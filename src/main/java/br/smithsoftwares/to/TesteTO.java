package br.smithsoftwares.to;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TesteTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer coteste;
	private String dcemail;
	private String dcsenha;
	
}
