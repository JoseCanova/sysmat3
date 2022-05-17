package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "datasourceconfig")
public class DataSourceConfig extends BaseConfig{

	private static final long serialVersionUID = -2640754867834472157L;

    @Column(name = "name",length = 50)
	private String name;
    
    @Column(name = "url",length = 500)
    private String url;
    
    @Column(name = "username",length = 50)
    private String username;
    
    @Column(name = "password",length = 50)
    private String password;
    
    @Column(name = "driverclassname",length = 255)
    private String driverClassName;

    @Transient
    private boolean initialize;
    
    
	public DataSourceConfig() {
		super();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDriverClassName() {
		return driverClassName;
	}


	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}


	public boolean isInitialize() {
		return initialize;
	}


	public void setInitialize(boolean initialize) {
		this.initialize = initialize;
	}
    
}
