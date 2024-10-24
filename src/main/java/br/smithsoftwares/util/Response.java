package br.smithsoftwares.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	private Object result;
	private Integer status;
	
	public Response() {
	}

	public static Response Ok(Object result) {
		Response r = new Response();
		r.setResult(result);
		r.setStatus(1);
		return r;
	}

	public static Response Error(Integer cod, Object result) {
		Response r = new Response();
		r.setResult(result);
		r.setStatus(cod);
		return r;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
