package br.com.connemat.service.datasource;

public class BaseDataSourceConfiguration {

	private String url; 
	
	private String userName; 
	
	private String password;
	
	public BaseDataSourceConfiguration() {}
	
	public BaseDataSourceConfiguration(String url, String userName, String password) {
		super();
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
}