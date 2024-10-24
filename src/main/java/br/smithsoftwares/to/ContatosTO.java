package br.smithsoftwares.to;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatosTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer cocontatos;
	private String  dcnomes;
	private String  dcemail;
	private String  dcendereco;
	private String  nutelefone;
	private String  dtnascimento;
	
}
