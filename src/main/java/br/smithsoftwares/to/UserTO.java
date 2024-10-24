package br.smithsoftwares.to;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer couser;
	private String dcname;
	private String dcmail;
	private String dcpass;
	private String dtcreated;
	
}
