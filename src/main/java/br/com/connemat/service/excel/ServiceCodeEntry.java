package br.com.connemat.service.excel;

public class ServiceCodeEntry {

	private String code; 
	
	private String desciption;
	
	
	public ServiceCodeEntry() {
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDesciption() {
		return desciption;
	}


	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}


	@Override
	public String toString() {
		return "ServiceCodeEntry [code=" + code + ", desciption=" + desciption + "]";
	}

}
