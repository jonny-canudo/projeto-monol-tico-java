package br.smithsoftwares.to;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MeusdadosTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer codados;
	private String dcmail;
	private String dcsenha;
}
