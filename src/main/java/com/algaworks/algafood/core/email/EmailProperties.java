package com.algaworks.algafood.core.email;

import jakarta.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
@Component
@ConfigurationProperties("algafood.email")
public class EmailProperties {
	
	@NotNull
	private String remetente;
	
	//Isso evita o problema de enviar e-mails de verdade caso você esqueça
	private Implementacao impl = Implementacao.FAKE;
	
	private Sandbox sandbox = new Sandbox();

	public enum Implementacao {
	    SMTP, FAKE, SANDBOX
	}
	
	@Getter
	@Setter
	public class Sandbox {
	    
	    private String destinatario;
	    
	}  
}





