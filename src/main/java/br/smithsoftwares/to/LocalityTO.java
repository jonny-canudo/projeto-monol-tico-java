package br.smithsoftwares.to;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalityTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer colocality;
	private String dclocality;
	
}
