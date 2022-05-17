package br.com.connemat.rest.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.keycloak.models.jpa.entities.GroupEntity;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.keycloak.representations.idm.authorization.GroupPolicyRepresentation;
import org.keycloak.representations.idm.authorization.PolicyRepresentation;
import org.keycloak.representations.idm.authorization.ResourcePermissionRepresentation;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.keycloak.representations.idm.authorization.RolePolicyRepresentation;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.connemat.model.api.ConnematResourcePermission;
import br.com.connemat.model.api.Group;
import br.com.connemat.model.api.PasswordDefinition;
import br.com.connemat.model.api.User;
import br.com.connemat.model.api.UserGroupRealm;
import br.com.connemat.model.api.UserLogoutRepresentation;
import br.com.connemat.rest.client.model.AuthToken;
import br.com.connemat.rest.client.model.KeyCloakConfiguration;
import br.com.connemat.rest.client.model.KeyCloakConfiguration.KeyCloakEndpoints;

public class AdminRestClient {

	private static final String USERNAME = "username";

	private static final String PASSWORD = "password";

	private static final String GRANTTYPE =  "grant_type";

	private static final String SCOPE =   "scope";

	private static final String CLIENTID = "client_id";

	private static final String IDTOKENHINT = "id_token_hint"; 

	private static final String LOGOUTREDIRECTURL = "post_logout_redirect_uri";

	private static final String USERID = "user_id";

	private static final String STATE = "state";

	private static final String REFRESHTOKEN = "refresh_token";

	private static final String CLIENTSECRET = "client_secret";

	private static final String WEBORIGINS = "web-origins";

	private String userName; 

	private String password; 

	private String clientId; 

	private String clientSecret; 

	private String redirectUrl;

	@Autowired 
	private KeyCloakConfiguration keyCloakConfiguration;

	@Autowired 
	private KeyCloakEndpoints keyCloakEndpoints;

	@Autowired
	@Qualifier("adminRestTemplate")
	private RestTemplate adminRestTemplate;

	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;

	private AuthToken adminAuthToken; 

	public AdminRestClient() {
	}

	public AdminRestClient(String userName, String password, String clientId) {
		super();
		this.userName = userName;
		this.password = password;
		this.clientId = clientId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public GroupRepresentation[] getGroups() { 
		return adminRestTemplate
				.exchange(keyCloakConfiguration.getGroupUrl(false), HttpMethod.GET, null, GroupRepresentation[].class)
				.getBody();
	}

	public GroupRepresentation[] getGroups( Integer start ,  Integer max) { 
		return adminRestTemplate
				.exchange(keyCloakConfiguration.getGroupUrl(false , start , max), HttpMethod.GET, null, GroupRepresentation[].class)
				.getBody();
	}

	public GroupRepresentation[] getGroups( Integer start ,  Integer max,String searchString) { 
		return adminRestTemplate
				.exchange(keyCloakConfiguration.getGroupUrl(false , start , max , searchString), HttpMethod.GET, null, GroupRepresentation[].class)
				.getBody();
	}


	public List<ClientRepresentation> getClients() {
		String clientUrl = getClientUrl();
		return Optional.ofNullable(adminRestTemplate
				.exchange(clientUrl, HttpMethod.GET, null, ClientRepresentation[].class)
				.getBody())
				.map(ar -> Arrays.asList(ar)).get();
	}

	public List<ClientRepresentation> getClientsViewable() {
		String clientUrl = getClientUrlViewable();
		return Optional.ofNullable(adminRestTemplate
				.exchange(clientUrl, HttpMethod.GET, null, ClientRepresentation[].class)
				.getBody())
				.map(ar -> Arrays.asList(ar)).get();
	}

	
	private String getClientUrlViewable() {
		StringBuffer sb = new StringBuffer(getClientUrl());
		sb.append("?viewableOnly=true");
		return sb.toString();
	}
	
	private String getClientUrl() { 
		return new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getRealmClientUrl())
				.toString();
	}

	public List<ResourceRepresentation> getResources(List<String> clientsId) {
		List<ResourceRepresentation> listaResources = new ArrayList<>();	
		clientsId
		.stream()
		.forEach(id -> 
		{listaResources.addAll(Arrays.asList(getResources (id)));
		});
		return listaResources;
	}

	public ResourceRepresentation [] getResources(String clientId) {
		return adminRestTemplate
				.exchange(getClientResourceUrl(clientId), HttpMethod.GET, null, ResourceRepresentation[].class)
				.getBody();
	}

	private String getClientResourceUrl(String clientId) { 
		return new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getRealmClientUrl())
				.append(clientId) 
				.append(keyCloakEndpoints.getResourceUrl())
				.toString();
	}

	public List<ConnematResourcePermission> getClientResourcePermissions(String clientId , String resourceId) {
		return Arrays
				.asList(adminRestTemplate
						.exchange(getPermissionsUrl(clientId , resourceId), HttpMethod.GET, null, ConnematResourcePermission[].class)
						.getBody());
	}

	private String getPermissionsUrl(String clientId2, String resourceId) {
		String resourceUrl = getClientResourceUrl(clientId2);
		return new StringBuilder(resourceUrl)
				.append("/")
				.append(resourceId)
				.append(keyCloakEndpoints.getPermissionsUrl()).toString();
	}

	public List<PolicyRepresentation> getAssociatedPolicies(String clientId , String permissionId){
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getRealmClientUrl())
				.append(clientId)
				.append("/authz/resource-server/policy/")
				.append(permissionId)
				.append("/associatedPolicies")
				.toString();
		return Arrays
				.asList(adminRestTemplate
						.exchange(url, HttpMethod.GET, null, PolicyRepresentation[].class)
						.getBody());
	}

	public RolePolicyRepresentation getPolicyRoles(String clientId , String policyId){
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getRealmClientUrl())
				.append(clientId)
				.append("/authz/resource-server/policy/role/")
				.append(policyId)
				.toString();

		return adminRestTemplate
				.exchange(url, HttpMethod.GET, null, RolePolicyRepresentation.class)
				.getBody();
	}

	public GroupPolicyRepresentation getPolicyGroups(String clientId , String policyId) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getRealmClientUrl())
				.append(clientId)
				.append("/authz/resource-server/policy/group/")
				.append(policyId).toString();
		return adminRestTemplate
				.exchange(url, HttpMethod.GET, null, GroupPolicyRepresentation.class)
				.getBody();
	}

	public GroupRepresentation getGroup(String groupId) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.append('/')
				.append(groupId).toString();
		return adminRestTemplate
				.exchange(url, HttpMethod.GET, null, GroupRepresentation.class)
				.getBody();
	}

	public RoleRepresentation getRoleRepresentationById(String roleId) { 
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append("/admin/realms/connemat/roles-by-id/")
				.append(roleId)
				.toString();
		return adminRestTemplate
				.exchange(url, HttpMethod.GET, null, RoleRepresentation.class)
				.getBody(); 
	}

	public List<?> getClientResourceAssociatedPolicies(String clientId , String policyId) { 
		return null;
	}

	//TODO: verificar alternativa para exceção do refresh token linha 277.
	public AuthToken exchangeAdminToken() { 
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add(USERNAME,this.userName);
		map.add(PASSWORD,this.password);
		map.add(GRANTTYPE,PASSWORD);
		map.add(SCOPE,WEBORIGINS);
		map.add(CLIENTID,this.clientId);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		this.adminAuthToken =  restTemplate.exchange(keyCloakConfiguration.getTokenUrl(), HttpMethod.POST, entity, AuthToken.class).getBody();
		this.adminAuthToken.setExpirationTime(((Optional.ofNullable(adminAuthToken.getExpiresIn()).orElse(0) * 1000L) + (System.currentTimeMillis()-1000L)));
		return adminAuthToken;
	}

	@Deprecated
	public List<GroupRepresentation> getWorkSpaceGroups() {
		return Arrays
				.asList(getGroups())
				.stream()
				.filter(gr -> gr.getAttributes().get("workspace") !=null)
				.collect(Collectors.toList());
	}


	public ResponseEntity<String> logoutUserSessions(UserLogoutRepresentation userLogoutRepresentation , Authentication authentication) {

		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication; 

		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getLogoutUrl())
				.toString();

		HttpHeaders headers = new HttpHeaders();	
		Jwt jwt = jwtAuthenticationToken.getToken();
		headers.setBearerAuth(jwt.getTokenValue());

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add(IDTOKENHINT,userLogoutRepresentation.getIdToken());
		map.add(LOGOUTREDIRECTURL,this.redirectUrl);
		map.add(USERID,authentication.getName());
		map.add(CLIENTID, userLogoutRepresentation.getClientId());
		map.add(STATE,userLogoutRepresentation.getSessionState());
		map.add(REFRESHTOKEN,userLogoutRepresentation.getIdToken());
		map.add(CLIENTSECRET , userLogoutRepresentation.getClientSecret());

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		return  restTemplate.exchange(
				builder.toUriString(), 
				HttpMethod.POST, 
				entity, 
				String.class);
	}

	public void verifyTokenExpiration() {
		Optional.ofNullable(this.adminAuthToken).ifPresent(	adminAuthToken->
		{if (adminAuthToken.getExpirationTime()  < System.currentTimeMillis() - 1000) {
			exchangeAdminToken();
		}else if (adminAuthToken.getExpirationTime()  > System.currentTimeMillis() ) {
			adminAuthToken = null;
		}}
				);
	}

	public String getAccessToken() {
		return Optional.ofNullable(this.adminAuthToken).map(a -> a.getAccessToken()).orElse(null);
	}

	public ResponseEntity<?> addGroup(GroupRepresentation groupRepresentation) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.toString();
		return adminRestTemplate
				.exchange(url, HttpMethod.POST, new HttpEntity<GroupRepresentation>(groupRepresentation), Object.class);
	}

	public void deleteGroupEntity(GroupEntity g) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.append('/')
				.append(g.getId())
				.toString();
		adminRestTemplate.delete(url);
	}
	
	public ResponseEntity<?> addUser(UserRepresentation ur) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.toString();
		return adminRestTemplate
				.exchange(url,  
						HttpMethod.POST ,
						new HttpEntity<UserRepresentation>(ur) 
						, Object.class );
	}

	//Request URL: http://192.168.0.81:8180/auth/admin/realms/connemat/users/af73233c-97ba-42dd-9e40-6b2d1d4acacd/reset-password
	public ResponseEntity<?> resetPassword(User user, PasswordDefinition pwd) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(user.getId())
				.append("/reset-password")
				.toString();
		return adminRestTemplate
				.exchange(url,  
						HttpMethod.PUT ,
						new HttpEntity<PasswordDefinition>(pwd) 
						, Object.class );
	}

	public ResponseEntity<?> deleteUser(@Valid User user) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(user.getId())
				.toString();
		return adminRestTemplate.
				exchange(url  , HttpMethod.DELETE , new HttpEntity<>(null), Object.class);
	}

	public GroupRepresentation[] getGroups(int i, int j, String searchString) {
		return adminRestTemplate
				.exchange(keyCloakConfiguration.getGroupUrl(false , i , j , searchString), HttpMethod.GET, null, GroupRepresentation[].class)
				.getBody();
	}

	public ResponseEntity<?> deleteGroup(String id) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.append("/")
				.append(id)
				.toString();
		return adminRestTemplate.
				exchange(url  , HttpMethod.DELETE , new HttpEntity<>(null), Object.class);
	}

	public ResponseEntity<?> updateGroup( String id, GroupRepresentation gr) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.append("/")
				.append(id)
				.toString();
		return adminRestTemplate.
				exchange(url  , HttpMethod.PUT , new HttpEntity<>(gr), Object.class);
	}

	public  ResponseEntity<?> createGroup(GroupRepresentation gr) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.toString();
		return adminRestTemplate.
						exchange(url  , HttpMethod.POST , new HttpEntity<>(gr), Object.class);
	}

	public  ResponseEntity<?>  createUpdateSubGroup(String id, GroupRepresentation group) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.append("/")
				.append(id)
				.append("/children")
				.toString();
		return adminRestTemplate.
				exchange(url  , HttpMethod.POST , new HttpEntity<>(group), Object.class);
	}

	public ResponseEntity<?> updateUser(UserRepresentation user) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(user.getId())
				.toString();
		return adminRestTemplate.
				exchange(url  , HttpMethod.PUT , new HttpEntity<>(user), Object.class);
	}
	
	public ResponseEntity<?> inactivateUser(UserRepresentation user) {
		user.setEnabled(false);
		return updateUser(user);
	}

	public ResponseEntity<UserRepresentation> getUser(String userId2) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(userId2)
				.toString();
		ResponseEntity<UserRepresentation> rur =  adminRestTemplate.
			exchange(url  , HttpMethod.GET , new HttpEntity<>(null), UserRepresentation.class);
		return rur;
	}

	public ResponseEntity<?> requiredActionsEmail( String userId2,  List<String> requiredActions) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(userId2)
				.append("/execute-actions-email")
				.toString();
		return  adminRestTemplate.
				exchange(url  , HttpMethod.PUT , new HttpEntity<>(requiredActions), Object.class);
	}

	@Deprecated
	public ResponseEntity<?> addGroupMember( String groupId,  String userId2) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(userId2)
				.append("/groups/")
				.append(groupId)
				.toString();
		return  adminRestTemplate.
				exchange(url  , HttpMethod.PUT , new HttpEntity<>(null), Object.class);
	}

	@Deprecated
	public ResponseEntity<?> deleteGroupMember( String groupId,  String userId2) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(userId2)
				.append("/groups/")
				.append(groupId)
				.toString();
		return  adminRestTemplate.
				exchange(url  , HttpMethod.DELETE , new HttpEntity<>(null), Object.class);
	}
	
	public ResponseEntity<?> joinGroup(UserGroupRealm ugr) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(ugr.getUserId())
				.append("/groups/")
				.append(ugr.getGroupId())
				.toString();
		return  adminRestTemplate.
				exchange(url  , HttpMethod.PUT , new HttpEntity<>(ugr), Object.class);
	}
	
	public ResponseEntity<?> leaveGroup(  String userId2 ,  String groupId) {
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(userId2)
				.append("/groups/")
				.append(groupId)
				.toString();
		return  adminRestTemplate.
				exchange(url  , HttpMethod.DELETE , new HttpEntity<>(null), Object.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getGroupMembers( String groupId) {
		List<UserRepresentation> members = new ArrayList<>();
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getGroupUrl())
				.append("/")
				.append(groupId)
				.append("/members")
				.append("?briefRepresentation=true")
				.append("&first=0")
				.append("&max="+Integer.MAX_VALUE)
				.toString();
		List<Map<String,?>> what = adminRestTemplate.
				exchange(url  , HttpMethod.GET , new HttpEntity<>(null), members.getClass())
				.getBody();
		return what.stream().map(e -> convert(e , User.class)).collect(Collectors.toList());
	}

	@SuppressWarnings("unchecked")
	public List<Group> getUserGroups(String userId2) {
		List<GroupRepresentation> members = new ArrayList<>();
		String url = new StringBuilder()
				.append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakEndpoints.getUserUrl())
				.append("/")
				.append(userId2)
				.append("/groups")
				.append("?briefRepresentation=true")
				.append("&first=0")
				.append("&max="+Integer.MAX_VALUE)
				.toString();
		List<Map<String,?>> what = adminRestTemplate.
				exchange(url  , HttpMethod.GET , new HttpEntity<>(null), members.getClass())
				.getBody();
		return what.stream().map(e -> convert(e , Group.class)).collect(Collectors.toList());
	}

	private <U> U convert(Map<String,?> e , Class<U> clazz) {
		BeanWrapper bw = new BeanWrapperImpl(clazz);
		e
		.keySet()
		.stream()
		.forEach(k ->{
			if (bw.isWritableProperty(k)) {
				PropertyValue pv = new PropertyValue(k , e.get(k));
				bw.setPropertyValue(pv);
			}
		});
		return clazz.cast(bw.getWrappedInstance());
	}

	@SuppressWarnings("unchecked")
	public List<User> search(MultiValueMap<String, String> params) {
		List<UserRepresentation> members = new ArrayList<>();
		StringBuilder sb = new StringBuilder()
					.append(keyCloakEndpoints.getUserUrl());
		UriBuilderFactory factory = new DefaultUriBuilderFactory();
		String url = factory.builder().path(sb.toString()).queryParams(params).build().toString();
		url = keyCloakConfiguration.getAuthServerUrl() + url;
		url = url + "&briefRepresentation=true";
		List<Map<String,?>> what = adminRestTemplate.
				exchange(url  , HttpMethod.GET , new HttpEntity<>(null), members.getClass())
				.getBody();
		return what.stream().map(e -> convert(e , User.class)).collect(Collectors.toList());
	}

	public List<RoleRepresentation> getClientRoles(String clientId2) {
		StringBuilder sb = new StringBuilder().append(keyCloakConfiguration.getAuthServerUrl())
		.append(keyCloakConfiguration.getKeyCloakEndpoints().getRealmClientUrl())
		.append('/')
		.append(clientId2)
		.append("/roles");
		String url  = sb.toString();
		return  adminRestTemplate.
				exchange(url  , HttpMethod.GET , new HttpEntity<>(null), new ParameterizedTypeReference<List<RoleRepresentation>>() {})
				.getBody();
	}

	public Optional<RoleRepresentation> getClientRoleByName(String clientId2,  String roleName) {
		StringBuilder sb = new StringBuilder().append(keyCloakConfiguration.getAuthServerUrl())
		.append(keyCloakConfiguration.getKeyCloakEndpoints().getRealmClientUrl())
		.append('/')
		.append(clientId2)
		.append("/roles")
		.append("/")
		.append(roleName);
		String url  = sb.toString();
		return Optional.of( adminRestTemplate.
				exchange(url  , HttpMethod.GET , new HttpEntity<>(null), RoleRepresentation.class)
				.getBody());
	}

	public ResponseEntity<?> createRole(String clientId , RoleRepresentation roleRepresentation) {
		StringBuilder sb = new StringBuilder().append(keyCloakConfiguration.getAuthServerUrl())
				.append(keyCloakConfiguration.getKeyCloakEndpoints().getRealmClientUrl())
				.append('/')
				.append(clientId)
				.append("/roles");
				String url  = sb.toString();
		return adminRestTemplate.
				exchange(url  , HttpMethod.POST , new HttpEntity<>(roleRepresentation), Object.class);
	}
	
}