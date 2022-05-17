package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.connemat.Base;
import br.com.connemat.CreateValidationGroup;
import br.com.connemat.UpdateValidationGroup;
import br.com.connemat.model.entity.validation.BaseConstraint;
import br.com.connemat.util.JsonBaseSerializer;

@Entity
@Table(name="instance_config_datasource")
@Valid
public class InstanceDataSourceConfig implements Base<Long> {

	private static final long serialVersionUID = -4418707585709886839L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="instance_config_datasource_id")
	@NotNull(groups= {UpdateValidationGroup.class})
	@Null(groups= {CreateValidationGroup.class})
	private Long id; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Size(max=50 , groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Column(name="host"  )
	private String host;
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Size(max=20,groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Column(name="db_name"   )
	private String dbName;
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Size(max=30 , groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Column(name="db_user"  )
	private String dbUser; 
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Size(max=30,groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Column(name="db_password"  )
	private String dbPassword;
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Size(max=50,groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Column(name="db_instance"  )
	private String dbInstance;
	
	@NotEmpty(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Size(max=50,groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@Column(name="db_dialect"  )
	private String dbDialect;
	
	@Column(name="db_port")
	private Integer dbPort;
	
	@Column(name="db_pool_size" )
	private Integer dbPoolSize;

	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@NotNull(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="instance_id")
	private Instance instance;
	
	@JsonSerialize(using=JsonBaseSerializer.class)
	@BaseConstraint(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@NotNull(groups= {UpdateValidationGroup.class,CreateValidationGroup.class })
	@JoinColumn(name="app_id")
	@ManyToOne(fetch=FetchType.EAGER)
	private App app;
	
	public InstanceDataSourceConfig() {
		super();
	}

	public InstanceDataSourceConfig(String host  ,  String dbName,String dbUser,
			String dbPassword,  String dbInstance,
			 String dbDialect) {
		super();
		this.host = host;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
		this.dbInstance = dbInstance;
		this.dbDialect = dbDialect;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbInstance() {
		return dbInstance;
	}

	public void setDbInstance(String dbInstance) {
		this.dbInstance = dbInstance;
	}

	public String getDbDialect() {
		return dbDialect;
	}

	public void setDbDialect(String dbDialect) {
		this.dbDialect = dbDialect;
	}
	
	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}
	
	public Integer getDbPort() {
		return dbPort;
	}

	public void setDbPort(Integer dbPort) {
		this.dbPort = dbPort;
	}

	public Integer getDbPoolSize() {
		return dbPoolSize;
	}

	public void setDbPoolSize(Integer dbPoolSize) {
		this.dbPoolSize = dbPoolSize;
	}

	public App getApp() {
		return app;
	}

	public void setApp(App app) {
		this.app = app;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dbDialect == null) ? 0 : dbDialect.hashCode());
		result = prime * result + ((dbInstance == null) ? 0 : dbInstance.hashCode());
		result = prime * result + ((dbName == null) ? 0 : dbName.hashCode());
		result = prime * result + ((dbPassword == null) ? 0 : dbPassword.hashCode());
		result = prime * result + ((dbUser == null) ? 0 : dbUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof InstanceDataSourceConfig))
			return false;
		InstanceDataSourceConfig other = (InstanceDataSourceConfig) obj;
		if (dbDialect == null) {
			if (other.dbDialect != null)
				return false;
		} else if (!dbDialect.equals(other.dbDialect))
			return false;
		if (dbInstance == null) {
			if (other.dbInstance != null)
				return false;
		} else if (!dbInstance.equals(other.dbInstance))
			return false;
		if (dbName == null) {
			if (other.dbName != null)
				return false;
		} else if (!dbName.equals(other.dbName))
			return false;
		if (dbPassword == null) {
			if (other.dbPassword != null)
				return false;
		} else if (!dbPassword.equals(other.dbPassword))
			return false;
		if (dbUser == null) {
			if (other.dbUser != null)
				return false;
		} else if (!dbUser.equals(other.dbUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InstanceDataSourceConfig [id=" + id + ", host=" + host + ", dbName=" + dbName + ", dbUser=" + dbUser
				+ ", dbPassword=" + dbPassword + ", dbInstance=" + dbInstance + ", dbDialect=" + dbDialect + ", dbPort="
				+ dbPort + ", dbPoolSize=" + dbPoolSize + "]";
	}
	
}
