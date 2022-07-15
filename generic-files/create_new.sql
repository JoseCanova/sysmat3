create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
create sequence hibernate_sequence start 1 increment 1
create sequence sequence_id_seq start 1 increment 1
create table ApprovedValues (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, theValue varchar(255) not null, comment varchar(255), formadorLC boolean, theValueAbvEnglish varchar(255), theValueAbvSpanish varchar(255), theValueC40 varchar(255), theValueC60 varchar(255), theValueEnglish varchar(255), theValueSpanish varchar(255), primary key (characteristic, modifier, noun, theValue))
create table ASSOCIATED_POLICY (POLICY_ID varchar(36) not null, ASSOCIATED_POLICY_ID varchar(36) not null, primary key (POLICY_ID, ASSOCIATED_POLICY_ID))
create table AUTHENTICATION_EXECUTION (ID varchar(36) not null, AUTHENTICATOR varchar(255), AUTH_CONFIG varchar(255), AUTHENTICATOR_FLOW boolean, AUTH_FLOW_ID varchar(255), PRIORITY int4, REQUIREMENT int4, FLOW_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATION_FLOW (ID varchar(36) not null, ALIAS varchar(255), BUILT_IN boolean, DESCRIPTION varchar(255), PROVIDER_ID varchar(255), TOP_LEVEL boolean, REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG (ID varchar(36) not null, ALIAS varchar(255), REALM_ID varchar(36), primary key (ID))
create table AUTHENTICATOR_CONFIG_ENTRY (AUTHENTICATOR_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (AUTHENTICATOR_ID, NAME))
create table AuthServerConfig (id int8 not null, baseLogonUrl varchar(255), clientId varchar(255), clientSecret varchar(255), introspectUrl varchar(255), tokenUrl varchar(255), primary key (id))
create table Category (codeCat int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), primary key (codeCat))
create table CLIENT (ID varchar(36) not null, ALWAYS_DISPLAY_IN_CONSOLE boolean, BASE_URL varchar(255), BEARER_ONLY boolean, CLIENT_AUTHENTICATOR_TYPE varchar(255), CLIENT_ID varchar(255), CONSENT_REQUIRED boolean, DESCRIPTION varchar(255), DIRECT_ACCESS_GRANTS_ENABLED boolean, ENABLED boolean, FRONTCHANNEL_LOGOUT boolean, FULL_SCOPE_ALLOWED boolean, IMPLICIT_FLOW_ENABLED boolean, MANAGEMENT_URL varchar(255), NAME varchar(255), NODE_REREG_TIMEOUT int4, NOT_BEFORE int4, PROTOCOL varchar(255), PUBLIC_CLIENT boolean, REGISTRATION_TOKEN varchar(255), ROOT_URL varchar(255), SECRET varchar(255), SERVICE_ACCOUNTS_ENABLED boolean, STANDARD_FLOW_ENABLED boolean, SURROGATE_AUTH_REQUIRED boolean, REALM_ID varchar(36), primary key (ID))
create table CLIENT_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(4000), CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_AUTH_FLOW_BINDINGS (CLIENT_ID varchar(36) not null, FLOW_ID varchar(4000), BINDING_NAME varchar(255) not null, primary key (CLIENT_ID, BINDING_NAME))
create table CLIENT_DEFAULT_ROLES (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table CLIENT_INITIAL_ACCESS (ID varchar(36) not null, COUNT int4, EXPIRATION int4, REMAINING_COUNT int4, TIMESTAMP int4, REALM_ID varchar(36), primary key (ID))
create table CLIENT_NODE_REGISTRATIONS (CLIENT_ID varchar(36) not null, VALUE int4, NAME varchar(255) not null, primary key (CLIENT_ID, NAME))
create table CLIENT_SCOPE (ID varchar(36) not null, DESCRIPTION varchar(255), NAME varchar(255), PROTOCOL varchar(255), REALM_ID varchar(36), primary key (ID))
create table CLIENT_SCOPE_ATTRIBUTES (NAME varchar(255) not null, VALUE varchar(2048), SCOPE_ID varchar(36) not null, primary key (SCOPE_ID, NAME))
create table CLIENT_SCOPE_CLIENT (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, CLIENT_ID varchar(36) not null, primary key (CLIENT_ID, SCOPE_ID))
create table CLIENT_SCOPE_ROLE_MAPPING (SCOPE_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (SCOPE_ID, ROLE_ID))
create table COMPONENT (ID varchar(36) not null, NAME varchar(255), PARENT_ID varchar(255), PROVIDER_ID varchar(255), PROVIDER_TYPE varchar(255), SUB_TYPE varchar(255), REALM_ID varchar(36), primary key (ID))
create table COMPONENT_CONFIG (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), COMPONENT_ID varchar(36), primary key (ID))
create table COMPOSITE_ROLE (COMPOSITE varchar(36) not null, CHILD_ROLE varchar(36) not null, primary key (COMPOSITE, CHILD_ROLE))
create table CREDENTIAL (ID varchar(36) not null, CREATED_DATE int8, CREDENTIAL_DATA varchar(255), PRIORITY int4, SALT bytea, SECRET_DATA varchar(255), TYPE varchar(255), USER_LABEL varchar(255), USER_ID varchar(36), primary key (ID))
create table DataSourceConfig (id int8 not null, driverClassName varchar(255), name varchar(50), password varchar(50), url varchar(500), userName varchar(50), primary key (id))
create table DEFAULT_CLIENT_SCOPE (DEFAULT_SCOPE boolean, SCOPE_ID varchar(36) not null, REALM_ID varchar(36) not null, primary key (SCOPE_ID, REALM_ID))
create table FEDERATED_IDENTITY (IDENTITY_PROVIDER varchar(255) not null, REALM_ID varchar(255), TOKEN varchar(255), FEDERATED_USER_ID varchar(255), FEDERATED_USERNAME varchar(255), USER_ID varchar(36) not null, primary key (IDENTITY_PROVIDER, USER_ID))
create table GROUP_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), GROUP_ID varchar(36), primary key (ID))
create table GROUP_ROLE_MAPPING (ROLE_ID varchar(255) not null, GROUP_ID varchar(36) not null, primary key (GROUP_ID, ROLE_ID))
create table IDENTITY_PROVIDER (INTERNAL_ID varchar(36) not null, ADD_TOKEN_ROLE boolean, PROVIDER_ALIAS varchar(255), AUTHENTICATE_BY_DEFAULT boolean, PROVIDER_DISPLAY_NAME varchar(255), ENABLED boolean, FIRST_BROKER_LOGIN_FLOW_ID varchar(255), LINK_ONLY boolean, POST_BROKER_LOGIN_FLOW_ID varchar(255), PROVIDER_ID varchar(255), STORE_TOKEN boolean, TRUST_EMAIL boolean, REALM_ID varchar(36), primary key (INTERNAL_ID))
create table IDENTITY_PROVIDER_CONFIG (IDENTITY_PROVIDER_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (IDENTITY_PROVIDER_ID, NAME))
create table IDENTITY_PROVIDER_MAPPER (ID varchar(36) not null, IDP_ALIAS varchar(255), IDP_MAPPER_NAME varchar(255), NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table IDP_MAPPER_CONFIG (IDP_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (IDP_MAPPER_ID, NAME))
create table instance (instance_id int8 not null, code varchar(10) not null, description varchar(50) not null, logo text, logo_small text, manual text, primary key (instance_id))
create table instance_config_datasource (instance_config_datasource_id int8 not null, db_dialect varchar(50) not null, db_instance varchar(50) not null, db_name varchar(20) not null, db_password varchar(30) not null, db_user varchar(30) not null, instance_instance_id int8, primary key (instance_config_datasource_id))
create table Item_Center (error boolean not null, message varchar(255), status varchar(255), cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, cdItem))
create table Item_Custom (description varchar(255) not null, type varchar(255) not null, cdItem varchar(255) not null, primary key (description, cdItem, type))
create table Item_Description (description varchar(255), cdItem varchar(255) not null, type varchar(255) not null, primary key (cdItem, type))
create table Item_Erp (theValue varchar(255), FieldID varchar(255) not null, cdItem varchar(255) not null, CenterID varchar(255) not null, primary key (CenterID, FieldID, cdItem))
create table Item_Files (IdItemFile  serial not null, fileData bytea, fileName varchar(255), uploadDate timestamp, CdItem varchar(255), userId varchar(255), primary key (IdItemFile))
create table Item_Fiscal (cdItem varchar(255) not null, type varchar(255) not null, theValue varchar(255), primary key (cdItem, type))
create table Item_History (id  bigserial not null, comment varchar(255), data timestamp, ipv4 varchar(255), status varchar(255), theValue varchar(255), theValueRi varchar(255), tipo varchar(255), userID varchar(255), cdItem varchar(255), primary key (id))
create table Item_Master (cdItem varchar(255) not null, comment varchar(255), completed boolean, completedBy varchar(255), completedDate varchar(255), createdBy varchar(255), createdDate varchar(255), erpId varchar(255), erpId2 varchar(255), erpId3 varchar(255), erpId4 varchar(255), erpId5 varchar(255), image varchar(255), lastUpdatedBy varchar(255), lastUpdatedDate varchar(255), lockedBy varchar(255), lockedDate timestamp, masterId varchar(255), modifier varchar(255), notes varchar(255), noun varchar(255), oldErpId varchar(255), oldItemId varchar(255), requestedBy varchar(255), requestedDate varchar(255), shortNotes varchar(255), Status varchar(255), UnitIssue varchar(255), UnitPurchase varchar(255), primary key (cdItem))
create table Item_Reference (refNumber varchar(255) not null, refClean varchar(255), refFlag varchar(255), seq int4, vendorFlag varchar(255), cdItem varchar(255) not null, VendorCode varchar(255) not null, primary key (cdItem, refNumber, VendorCode))
create table Item_Values (Characteristic varchar(255) not null, theValue varchar(255), theValueRI varchar(255), cdItem varchar(255) not null, primary key (Characteristic, cdItem))
create table Item_Working (usuario varchar(255) not null, cdItem varchar(255) not null, primary key (usuario, cdItem))
create table KEYCLOAK_GROUP (ID varchar(36) not null, NAME varchar(255), PARENT_GROUP varchar(255), REALM_ID varchar(255), primary key (ID))
create table KEYCLOAK_ROLE (ID varchar(36) not null, CLIENT varchar(255), CLIENT_REALM_CONSTRAINT varchar(36), CLIENT_ROLE boolean, DESCRIPTION varchar(255), NAME varchar(255), REALM_ID varchar(255), REALM varchar(36), primary key (ID))
create table MIGRATION_MODEL (ID varchar(36) not null, UPDATE_TIME int8, VERSION varchar(36), primary key (ID))
create table Noun (noun varchar(255) not null, comment varchar(255), nounC40 varchar(255), nounC60 varchar(255), primary key (noun))
create table Noun_Modifier (modifier varchar(255) not null, noun varchar(255) not null, blocked boolean not null, cest varchar(255), codePDM int4, comment varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), mcpse varchar(255), modifierAbvEnglish varchar(255), modifierAbvSpanish varchar(255), modifierC40 varchar(255), modifierC60 varchar(255), modifierEnglish varchar(255), modifierSpanish varchar(255), nbs varchar(255), ncm varchar(255), nounAbvEnglish varchar(255), nounAbvSpanish varchar(255), nounEnglish varchar(255), nounSpanish varchar(255), unspsc varchar(255), CodeCat int4, codeSub int4, primary key (modifier, noun))
create table Noun_Modifier_Characteristic (characteristic varchar(255) not null, modifier varchar(255) not null, noun varchar(255) not null, characteristicAbvEnglish varchar(255), characteristicAbvSpanish varchar(255), characteristicC40 varchar(255), characteristicC60 varchar(255), characteristicEnglish varchar(255), characteristicSpanish varchar(255), comment varchar(255), formadorLC boolean, required boolean, seq int4, primary key (characteristic, modifier, noun))
create table POLICY_CONFIG (POLICY_ID varchar(36) not null, VALUE TEXT, NAME varchar(255) not null, primary key (POLICY_ID, NAME))
create table PROTOCOL_MAPPER (ID varchar(36) not null, NAME varchar(255), PROTOCOL varchar(255), PROTOCOL_MAPPER_NAME varchar(255), CLIENT_ID varchar(36), CLIENT_SCOPE_ID varchar(36), primary key (ID))
create table PROTOCOL_MAPPER_CONFIG (PROTOCOL_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (PROTOCOL_MAPPER_ID, NAME))
create table REALM (ID varchar(36) not null, ACCESS_CODE_LIFESPAN int4, LOGIN_LIFESPAN int4, USER_ACTION_LIFESPAN int4, ACCESS_TOKEN_LIFESPAN int4, ACCESS_TOKEN_LIFE_IMPLICIT int4, ACCOUNT_THEME varchar(255), ADMIN_EVENTS_DETAILS_ENABLED boolean, ADMIN_EVENTS_ENABLED boolean, ADMIN_THEME varchar(255), ALLOW_USER_MANAGED_ACCESS boolean, BROWSER_FLOW varchar(255), CLIENT_AUTH_FLOW varchar(255), DEFAULT_LOCALE varchar(255), DIRECT_GRANT_FLOW varchar(255), DOCKER_AUTH_FLOW varchar(255), DUPLICATE_EMAILS_ALLOWED boolean, EDIT_USERNAME_ALLOWED boolean, EMAIL_THEME varchar(255), ENABLED boolean, EVENTS_ENABLED boolean, EVENTS_EXPIRATION int8, INTERNATIONALIZATION_ENABLED boolean, LOGIN_THEME varchar(255), LOGIN_WITH_EMAIL_ALLOWED boolean, MASTER_ADMIN_CLIENT varchar(255), NAME varchar(255), NOT_BEFORE int4, OFFLINE_SESSION_IDLE_TIMEOUT int4, OTP_POLICY_ALG varchar(255), OTP_POLICY_DIGITS int4, OTP_POLICY_COUNTER int4, OTP_POLICY_WINDOW int4, OTP_POLICY_PERIOD int4, OTP_POLICY_TYPE varchar(255), PASSWORD_POLICY varchar(255), REFRESH_TOKEN_MAX_REUSE int4, REGISTRATION_ALLOWED boolean, REG_EMAIL_AS_USERNAME boolean, REGISTRATION_FLOW varchar(255), REMEMBER_ME boolean, RESET_CREDENTIALS_FLOW varchar(255), RESET_PASSWORD_ALLOWED boolean, REVOKE_REFRESH_TOKEN boolean, SSL_REQUIRED varchar(255), SSO_IDLE_TIMEOUT int4, SSO_IDLE_TIMEOUT_REMEMBER_ME int4, SSO_MAX_LIFESPAN int4, SSO_MAX_LIFESPAN_REMEMBER_ME int4, VERIFY_EMAIL boolean, primary key (ID))
create table REALM_ATTRIBUTE (NAME varchar(255) not null, VALUE varchar(255), REALM_ID varchar(36) not null, primary key (NAME, REALM_ID))
create table REALM_DEFAULT_GROUPS (REALM_ID varchar(36) not null, GROUP_ID varchar(255))
create table REALM_DEFAULT_ROLES (REALM_ID varchar(36) not null, ROLE_ID varchar(36) not null)
create table REALM_ENABLED_EVENT_TYPES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_EVENTS_LISTENERS (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REALM_REQUIRED_CREDENTIAL (TYPE varchar(255) not null, FORM_LABEL varchar(255), INPUT boolean, SECRET boolean, REALM_ID varchar(36) not null, primary key (REALM_ID, TYPE))
create table REALM_SMTP_CONFIG (REALM_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REALM_ID, NAME))
create table REALM_SUPPORTED_LOCALES (REALM_ID varchar(36) not null, VALUE varchar(255))
create table REDIRECT_URIS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
create table ReferenceFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table RepairValues ("Of" varchar(255) not null, "To" varchar(255), primary key ("Of"))
create table REQUIRED_ACTION_CONFIG (REQUIRED_ACTION_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (REQUIRED_ACTION_ID, NAME))
create table REQUIRED_ACTION_PROVIDER (ID varchar(36) not null, ALIAS varchar(255), DEFAULT_ACTION boolean, ENABLED boolean, NAME varchar(255), PRIORITY int4, PROVIDER_ID varchar(255), REALM_ID varchar(36), primary key (ID))
create table RESOURCE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), RESOURCE_ID varchar(36), primary key (ID))
create table RESOURCE_POLICY (RESOURCE_ID varchar(36) not null, POLICY_ID varchar(36) not null, primary key (POLICY_ID, RESOURCE_ID))
create table RESOURCE_SCOPE (RESOURCE_ID varchar(36) not null, SCOPE_ID varchar(36) not null)
create table RESOURCE_SERVER (ID varchar(36) not null, ALLOW_RS_REMOTE_MGMT boolean, DECISION_STRATEGY int4, POLICY_ENFORCE_MODE int4, primary key (ID))
create table RESOURCE_SERVER_PERM_TICKET (ID varchar(36) not null, CREATED_TIMESTAMP int8, GRANTED_TIMESTAMP int8, OWNER varchar(255), REQUESTER varchar(255), POLICY_ID varchar(36), RESOURCE_ID varchar(36) not null, RESOURCE_SERVER_ID varchar(36) not null, SCOPE_ID varchar(36), primary key (ID))
create table RESOURCE_SERVER_POLICY (ID varchar(36) not null, DECISION_STRATEGY int4, DESCRIPTION varchar(255), LOGIC int4, NAME varchar(255), OWNER varchar(255), TYPE varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_SERVER_RESOURCE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), OWNER varchar(255), OWNER_MANAGED_ACCESS boolean, RESOURCE_SERVER_ID varchar(255), TYPE varchar(255), primary key (ID))
create table RESOURCE_SERVER_SCOPE (ID varchar(36) not null, DISPLAY_NAME varchar(255), ICON_URI varchar(255), NAME varchar(255), RESOURCE_SERVER_ID varchar(36) not null, primary key (ID))
create table RESOURCE_URIS (RESOURCE_ID varchar(36) not null, VALUE varchar(255))
create table ROLE_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), ROLE_ID varchar(36), primary key (ID))
create table SCOPE_MAPPING (CLIENT_ID varchar(36) not null, ROLE_ID varchar(36) not null, primary key (CLIENT_ID, ROLE_ID))
create table SCOPE_POLICY (POLICY_ID varchar(36) not null, SCOPE_ID varchar(36) not null, primary key (POLICY_ID, SCOPE_ID))
create table sector (sector_id int8 not null, description varchar(50) not null, primary key (sector_id))
create table sector_instance (Sector_sector_id int8 not null, instances_instance_id int8 not null, primary key (Sector_sector_id, instances_instance_id))
create table Status (Code varchar(255) not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), primary key (Code))
create table Subcategory (codeSub int4 not null, description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), erp1 varchar(255), erp2 varchar(255), erp3 varchar(255), codeCat int4 not null, primary key (codeCat, codeSub))
create table system_config (system_config_id int8 not null, key_config varchar(20) not null, key_description varchar(50) not null, key_value text not null, primary key (system_config_id))
create table tbCenters (id varchar(255) not null, description varchar(255), primary key (id))
create table tbConfig (id int8 not null, "Key" varchar(255), value varchar(255), primary key (id))
create table tbErpFields (id varchar(255) not null, description varchar(255), primary key (id))
create table tblErpValues (erp1 varchar(255) not null, type varchar(255) not null, description varchar(255), primary key (erp1, type))
create table tbLog_Item_Center (id  bigserial not null, logDate timestamp, message varchar(255), operationType varchar(255), status varchar(255), userId varchar(255), CenterID varchar(255), cdItem varchar(255), primary key (id))
create table tblPermissions (id varchar(255) not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (id, item))
create table tblTypeCustom (type varchar(255) not null, description varchar(255), multiValue boolean, required boolean, seq int4 not null, status int4 not null, visible boolean, webCombo boolean, primary key (type))
create table tblTypeDescription (type varchar(255) not null, description varchar(255), primary key (type))
create table tblTypeFiscal (type varchar(255) not null, Description varchar(255), primary key (type))
create table tblTypeNewItemId (id int4 not null, description varchar(255), fieldIc varchar(255), primary key (id))
create table tblUsers (id varchar(255) not null, approver boolean not null, blocked boolean not null, businessPhone varchar(255), center varchar(255), city varchar(255), Comment varchar(255), country varchar(255), department varchar(255), disabled boolean not null, email varchar(255), enterprise varchar(255), identityNumber varchar(255), lastAccessDate timestamp, name varchar(255), Password bytea, profileId int4 not null, specialAccess varchar(255), state varchar(255), primary key (id))
create table tblUsersHistory (Id  bigserial not null, comment varchar(255), historyDate timestamp, historyType varchar(255), ipv4 varchar(255), profileId int4 not null, historyUserID varchar(255), UserID varchar(255), primary key (Id))
create table tbMatType (matType varchar(255) not null, currentId int8, idBegin int8, idEnd int8, primary key (matType))
create table tbNewItemId (description varchar(255) not null, currentId int8, idBegin int8, idEnd int8, id int4 not null, primary key (description, id))
create table tbProfileItems (profileId int4 not null, item varchar(255) not null, "Add" boolean, "Delete" boolean, "Edit" boolean, "View" boolean, primary key (profileId, item))
create table tbProfiles (profileId int4 not null, description varchar(255), systemProfile boolean not null, primary key (profileId))
create table tbProfitCenters (profitCenterID varchar(255), CenterID varchar(255) not null, primary key (CenterID))
create table tbUser_Passwords (ID  bigserial not null, ExchangeDate timestamp, Password bytea, UserId varchar(255), primary key (ID))
create table tbValuationClasses (valuationClassId varchar(255) not null, accountCode varchar(255), accountDescription varchar(255), blocked boolean not null, valuationClassDescription varchar(255), primary key (valuationClassId))
create table Units (code varchar(255) not null, blocked boolean not null, codeEnglish varchar(255), codeSpanish varchar(255), description varchar(255), descriptionEnglish varchar(255), descriptionSpanish varchar(255), primary key (code))
create table USER_ATTRIBUTE (ID varchar(36) not null, NAME varchar(255), VALUE varchar(255), USER_ID varchar(36), primary key (ID))
create table USER_CONSENT (ID varchar(36) not null, CLIENT_ID varchar(255), CLIENT_STORAGE_PROVIDER varchar(255), CREATED_DATE int8, EXTERNAL_CLIENT_ID varchar(255), LAST_UPDATED_DATE int8, USER_ID varchar(36), primary key (ID))
create table USER_CONSENT_CLIENT_SCOPE (SCOPE_ID varchar(255) not null, USER_CONSENT_ID varchar(36) not null, primary key (SCOPE_ID, USER_CONSENT_ID))
create table USER_ENTITY (ID varchar(36) not null, CREATED_TIMESTAMP int8, EMAIL varchar(255), EMAIL_CONSTRAINT varchar(255), EMAIL_VERIFIED boolean, ENABLED boolean, FEDERATION_LINK varchar(255), FIRST_NAME varchar(255), LAST_NAME varchar(255), NOT_BEFORE int4, REALM_ID varchar(255), SERVICE_ACCOUNT_CLIENT_LINK varchar(255), USERNAME varchar(255), primary key (ID))
create table USER_FEDERATION_CONFIG (USER_FEDERATION_PROVIDER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_PROVIDER_ID, NAME))
create table USER_FEDERATION_MAPPER (ID varchar(36) not null, FEDERATION_MAPPER_TYPE varchar(255), NAME varchar(255), FEDERATION_PROVIDER_ID varchar(36), REALM_ID varchar(36), primary key (ID))
create table USER_FEDERATION_MAPPER_CONFIG (USER_FEDERATION_MAPPER_ID varchar(36) not null, VALUE varchar(255), NAME varchar(255) not null, primary key (USER_FEDERATION_MAPPER_ID, NAME))
create table USER_FEDERATION_PROVIDER (ID varchar(36) not null, CHANGED_SYNC_PERIOD int4, DISPLAY_NAME varchar(255), FULL_SYNC_PERIOD int4, LAST_SYNC int4, PRIORITY int4, PROVIDER_NAME varchar(255), REALM_ID varchar(36), primary key (ID))
create table USER_GROUP_MEMBERSHIP (GROUP_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (GROUP_ID, USER_ID))
create table USER_REQUIRED_ACTION (REQUIRED_ACTION varchar(255) not null, USER_ID varchar(36) not null, primary key (REQUIRED_ACTION, USER_ID))
create table USER_ROLE_MAPPING (ROLE_ID varchar(255) not null, USER_ID varchar(36) not null, primary key (ROLE_ID, USER_ID))
create table Vendor (code varchar(255) not null, address varchar(255), cep varchar(255), city varchar(255), complement varchar(255), country varchar(255), erp1 varchar(255), longName varchar(255), shortName varchar(255), state varchar(255), primary key (code))
create table VendorFlag (code varchar(255) not null, description varchar(255), primary key (code))
create table WEB_ORIGINS (CLIENT_ID varchar(36) not null, VALUE varchar(255))
alter table ASSOCIATED_POLICY add constraint UK_88revuww99qbbjd1g7tpwgokf unique (ASSOCIATED_POLICY_ID)
alter table CLIENT add constraint UKp1tsw44ft0683dv9wb42mysyr unique (REALM_ID, CLIENT_ID)
alter table CLIENT_DEFAULT_ROLES add constraint UK_57wf169ptm436p6l9kjx4ublj unique (ROLE_ID)
alter table CLIENT_SCOPE add constraint UKfqe49gvskmpi37y793ke52fpb unique (REALM_ID, NAME)
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint UK_qme7nux07unfg72l46t27dxn7 unique (ROLE_ID)
alter table instance add constraint UKejk2j01kij1jl5rirm2n7paq2 unique (code)
alter table Item_Center add constraint UK_rj45wkfrxqs4fiqcuy4h1fy3v unique (CenterID)
alter table Item_Erp add constraint UK_j7789nq0m2mtu00tboe6n00ah unique (FieldID)
alter table Item_Erp add constraint UK_p1llrnvasb6i7uee92tgtfley unique (CenterID)
alter table Item_Reference add constraint UK_885rsk1783940co7eo25kcsw6 unique (VendorCode)
alter table KEYCLOAK_GROUP add constraint UK7bmwklwq49gc8wa2y2ejjb6pb unique (REALM_ID, PARENT_GROUP, NAME)
alter table KEYCLOAK_ROLE add constraint UKmcqiwngcws9qiobg6lc3v2o85 unique (NAME, CLIENT_REALM_CONSTRAINT)
alter table REALM add constraint UK_orvsdmla56612eaefiq6wl5oi unique (NAME)
alter table REALM_DEFAULT_ROLES add constraint UK_h4wpd7w4hsoolni3h0sw7btje unique (ROLE_ID)
alter table RESOURCE_POLICY add constraint UK_yc4xhh7ud059r0jayb0eoad2 unique (RESOURCE_ID)
alter table RESOURCE_SCOPE add constraint UK_3s6y2h9hsu8q77uxck6d2u3os unique (SCOPE_ID)
alter table RESOURCE_SERVER_PERM_TICKET add constraint UK6s040l27nee5qjh978rjl3kev unique (OWNER, RESOURCE_SERVER_ID, RESOURCE_ID, SCOPE_ID)
alter table RESOURCE_SERVER_POLICY add constraint UKegpbxdqel6yayumusdgb76im6 unique (NAME, RESOURCE_SERVER_ID)
alter table RESOURCE_SERVER_RESOURCE add constraint UK50lg8ld2h8tx0889f7v7hwsun unique (NAME, RESOURCE_SERVER_ID, OWNER)
alter table RESOURCE_SERVER_SCOPE add constraint UKok2c1v0pwuwaqdmkbrmoahvp0 unique (NAME, RESOURCE_SERVER_ID)
alter table SCOPE_MAPPING add constraint UK_p3rh9grku11kqfrs4fltt7rnq unique (ROLE_ID)
alter table SCOPE_POLICY add constraint UK_skbm79l9nq8ev7oupq1oiundg unique (SCOPE_ID)
alter table sector add constraint UKt5bsl94uqvea0vppy6tvpb2ob unique (description)
alter table sector_instance add constraint UK_2cd9my3uucx7nxwlcauf1wli2 unique (instances_instance_id)
alter table system_config add constraint UK35vx7p1il1691oofum7rmco0j unique (key_config)
alter table USER_CONSENT add constraint UK65k09aldnynqjmu4w34g74b0q unique (USER_ID, CLIENT_ID)
alter table USER_ENTITY add constraint UKru8tt6t700s9v50bu18ws5ha6 unique (REALM_ID, USERNAME)
alter table USER_ENTITY add constraint UKdykn684sl8up1crfei6eckhd7 unique (REALM_ID, EMAIL_CONSTRAINT)
alter table ASSOCIATED_POLICY add constraint FKna0pudjd7mt1j3ekj713cma1v foreign key (ASSOCIATED_POLICY_ID) references RESOURCE_SERVER_POLICY
alter table ASSOCIATED_POLICY add constraint FKewk6h2a6sg2gf0jjglq1vugen foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table AUTHENTICATION_EXECUTION add constraint FKlbv3v7bilk7shc6neppg99hsr foreign key (FLOW_ID) references AUTHENTICATION_FLOW
alter table AUTHENTICATION_EXECUTION add constraint FKcpnc0m0jwd9gylap0byjei064 foreign key (REALM_ID) references REALM
alter table AUTHENTICATION_FLOW add constraint FKfvi3bbft78le520gggevu193o foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG add constraint FKdv79ce1hldtk9asubnk504qko foreign key (REALM_ID) references REALM
alter table AUTHENTICATOR_CONFIG_ENTRY add constraint FKlgtjx8ivfl990t1k8b3bq08e0 foreign key (AUTHENTICATOR_ID) references AUTHENTICATOR_CONFIG
alter table CLIENT add constraint FKt573sd26btxntsqt2qumw6e6b foreign key (REALM_ID) references REALM
alter table CLIENT_ATTRIBUTES add constraint FK8915l45j3dbfeib5jkby4fyq4 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_AUTH_FLOW_BINDINGS add constraint FKa8ud4iv2eymntsdxgh3qcbr17 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_DEFAULT_ROLES add constraint FKiii4mkgj62jo06ko61r82yiso foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table CLIENT_DEFAULT_ROLES add constraint FK83gatu3bnc90m837apqfrwtfa foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_INITIAL_ACCESS add constraint FK8jmod59dcp76wpre5aqcu0d7c foreign key (REALM_ID) references REALM
alter table CLIENT_NODE_REGISTRATIONS add constraint FKppco4w5ywyka4s33xr84v4kq7 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE add constraint FK67tqjk1l45ft4jwkpqsy8qsd6 foreign key (REALM_ID) references REALM
alter table CLIENT_SCOPE_ATTRIBUTES add constraint FK1w6bpmqf8teo04mx026cfl8el foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKaf9d7o3d2n78uh9ortyeuvyta foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_CLIENT add constraint FKjhnpsl9s2kjjdv3wufxllbk00 foreign key (CLIENT_ID) references CLIENT
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKoscu3p2w47i99cly8in33lrhe foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table CLIENT_SCOPE_ROLE_MAPPING add constraint FKdaa9l1mw9axfux1bkatcmjfao foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table COMPONENT add constraint FKiu24c9rccwe81okq6cawhvbxe foreign key (REALM_ID) references REALM
alter table COMPONENT_CONFIG add constraint FKkwy262tty5mdbhbwtlcwe1k0s foreign key (COMPONENT_ID) references COMPONENT
alter table COMPOSITE_ROLE add constraint FKgqhn9ogsk14lxm7ilmj4u5k6n foreign key (CHILD_ROLE) references KEYCLOAK_ROLE
alter table COMPOSITE_ROLE add constraint FK3gpod7occqerk1ykkg9fnl1c5 foreign key (COMPOSITE) references KEYCLOAK_ROLE
alter table CREDENTIAL add constraint FKa6xvv957nfgg14bo1dmhpns5 foreign key (USER_ID) references USER_ENTITY
alter table DEFAULT_CLIENT_SCOPE add constraint FK2aba1746j4jee8nfr80ulhu8x foreign key (SCOPE_ID) references CLIENT_SCOPE
alter table DEFAULT_CLIENT_SCOPE add constraint FKdv2qwdi905o9yt0ttk4mi8qn8 foreign key (REALM_ID) references REALM
alter table FEDERATED_IDENTITY add constraint FK3lmqdxk3jm4bub40skn2vera5 foreign key (USER_ID) references USER_ENTITY
alter table GROUP_ATTRIBUTE add constraint FKltk4r5uyl8i83h3o5w2j9ayph foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table GROUP_ROLE_MAPPING add constraint FKhmvlv6sqau6ru3xvuhjmugmns foreign key (GROUP_ID) references KEYCLOAK_GROUP
alter table IDENTITY_PROVIDER add constraint FKqb4vl7w58hkfem5pqlbu5lxwg foreign key (REALM_ID) references REALM
alter table IDENTITY_PROVIDER_CONFIG add constraint FK7d1dsnmo6gapu042b9udy74x1 foreign key (IDENTITY_PROVIDER_ID) references IDENTITY_PROVIDER
alter table IDENTITY_PROVIDER_MAPPER add constraint FKblt5ap5dj14or0mt2g99edvbe foreign key (REALM_ID) references REALM
alter table IDP_MAPPER_CONFIG add constraint FKraojnvuep0dr5584vbgeaunx8 foreign key (IDP_MAPPER_ID) references IDENTITY_PROVIDER_MAPPER
alter table instance_config_datasource add constraint FK5ygvr5vfcjf2shoxhqts5smmm foreign key (instance_instance_id) references instance
alter table Item_Center add constraint FKf3xfbfxhkdedb84x81cxbu680 foreign key (cdItem) references Item_Master
alter table Item_Center add constraint FK89pixei0bcenw1au1ixqmw9xk foreign key (CenterID) references tbCenters
alter table Item_Custom add constraint FKowrrdy3mi4s8pv9tewh4ro89h foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKglm30qiaevoemgiequwykgtow foreign key (cdItem) references Item_Master
alter table Item_Description add constraint FKa8rb1v09kar7hcnhwo3ignjs2 foreign key (type) references tblTypeDescription
alter table Item_Erp add constraint FKgfmt5xhmyc236qctub6m1x50d foreign key (FieldID) references tbErpFields
alter table Item_Erp add constraint FK77uxinua73m0m1ermwii3h8bj foreign key (cdItem) references Item_Master
alter table Item_Erp add constraint FKrh4i9mviikr4811bxugari2sk foreign key (CenterID) references tbCenters
alter table Item_Files add constraint FKaaxw57fu1ewittyw9oxuiykpx foreign key (CdItem) references Item_Master
alter table Item_Files add constraint FKl4uitr2020so5smta6lj1xtlk foreign key (userId) references tblUsers
alter table Item_History add constraint FKr0k3dp25xm513bjhnr41ftwns foreign key (cdItem) references Item_Master
alter table Item_History add constraint FKit17qna9d9bkbo6syckmugjxx foreign key (userID) references tblUsers
alter table Item_Master add constraint FK3wlt2nvqv9unva8ljlbp2bxa1 foreign key (Status) references Status
alter table Item_Master add constraint FK2shlqx5sce93mipra9aawh23o foreign key (UnitIssue) references Units
alter table Item_Master add constraint FKe1e3rooyf758lfb52ept6gg6v foreign key (UnitPurchase) references Units
alter table Item_Reference add constraint FKfoe8t7886573q416hwojv7h87 foreign key (cdItem) references Item_Master
alter table Item_Reference add constraint FKdmsich6reh1m2jlk7git5rs5c foreign key (VendorCode) references Vendor
alter table Item_Values add constraint FKkwc9sx9fg1uamnbbgpaqdwbja foreign key (cdItem) references Item_Master
alter table Item_Working add constraint FKr0mhbymeggs4hei1ki5n3jajx foreign key (cdItem) references Item_Master
alter table KEYCLOAK_ROLE add constraint FKp78lfj966vm1igx5hs09lpiu9 foreign key (REALM) references REALM
alter table Noun_Modifier add constraint FKfkrae2meeicuffv789g7mic03 foreign key (CodeCat) references Category
alter table Noun_Modifier add constraint FKavnttn33qfqcgln3yj4d63w9v foreign key (codeCat, codeSub) references Subcategory
alter table POLICY_CONFIG add constraint FK4akhjcuxsqpyqn2cx3ksvj0gb foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table PROTOCOL_MAPPER add constraint FK88ja7rd0tp1m01f9r4boo34u3 foreign key (CLIENT_ID) references CLIENT
alter table PROTOCOL_MAPPER add constraint FKsr1vpars8s25uachbqgpaysyr foreign key (CLIENT_SCOPE_ID) references CLIENT_SCOPE
alter table PROTOCOL_MAPPER_CONFIG add constraint FKi7xitc6y6752xcnhlnycnd5yy foreign key (PROTOCOL_MAPPER_ID) references PROTOCOL_MAPPER
alter table REALM_ATTRIBUTE add constraint FKgl14xyknbw7hki6p7tcdcqubu foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_GROUPS add constraint FKd3h642jtj1pm7h9t112oded7c foreign key (REALM_ID) references REALM
alter table REALM_DEFAULT_ROLES add constraint FKef21kccsqqmq12w7x466gwd3n foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table REALM_DEFAULT_ROLES add constraint FK4jxv0yadn30q1bs1qeivvk6lg foreign key (REALM_ID) references REALM
alter table REALM_ENABLED_EVENT_TYPES add constraint FKir68aqdvxur96ba2c27yhug1e foreign key (REALM_ID) references REALM
alter table REALM_EVENTS_LISTENERS add constraint FKmykanyp4b0yni05pi0y78j503 foreign key (REALM_ID) references REALM
alter table REALM_REQUIRED_CREDENTIAL add constraint FKtgv64jkog8lshdwwtlbsy4y7u foreign key (REALM_ID) references REALM
alter table REALM_SMTP_CONFIG add constraint FKdsnw2vy1thovgtbjl7ackdffu foreign key (REALM_ID) references REALM
alter table REALM_SUPPORTED_LOCALES add constraint FK1wm14sgma2jwa6jvh0yub0xe2 foreign key (REALM_ID) references REALM
alter table REDIRECT_URIS add constraint FKmnuhq24u1faxaew1guhg52gj1 foreign key (CLIENT_ID) references CLIENT
alter table REQUIRED_ACTION_CONFIG add constraint FK5nslo2kos3fpda7kasp0rlg9v foreign key (REQUIRED_ACTION_ID) references REQUIRED_ACTION_PROVIDER
alter table REQUIRED_ACTION_PROVIDER add constraint FKb1t3dt4ofrmk9mr5cbluglohg foreign key (REALM_ID) references REALM
alter table RESOURCE_ATTRIBUTE add constraint FKfc8ia2lkiq7gs3mbru6o7h0qs foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_POLICY add constraint FKem0mp9iv843gde0nwgc1uy1jh foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_POLICY add constraint FKh9d4k6jywvgutuo1k7kla9wcm foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SCOPE add constraint FK1xj82005v338501q6sa1irm9c foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SCOPE add constraint FKe0q6yq7c3g5gxq2q66i1gswn7 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKpk44id51oklqdaguwx0ni7qt9 foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKbdatn20yvhvduxck45spwo9g5 foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKeyiugm6dq3sdmm5d4cydrhfv9 foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_PERM_TICKET add constraint FKj30hog3n7yskwqqf4lchfdpc9 foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table RESOURCE_SERVER_POLICY add constraint FKoqy0feddatjog6aw97h4qg3in foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_SERVER_SCOPE add constraint FK771wshl5yn7170s48ogu3cmmy foreign key (RESOURCE_SERVER_ID) references RESOURCE_SERVER
alter table RESOURCE_URIS add constraint FKsrtmmrs5mp7s8boackjcy9css foreign key (RESOURCE_ID) references RESOURCE_SERVER_RESOURCE
alter table ROLE_ATTRIBUTE add constraint FK6konni3btn5a3kpyo0c2a4fio foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK3wvsvshm8cyv7s0da4qw116h1 foreign key (ROLE_ID) references KEYCLOAK_ROLE
alter table SCOPE_MAPPING add constraint FK7drd1hft32ib7nteorag9q4ud foreign key (CLIENT_ID) references CLIENT
alter table SCOPE_POLICY add constraint FKq7l90v0vrd3uyy9k4mfjoyhcc foreign key (SCOPE_ID) references RESOURCE_SERVER_SCOPE
alter table SCOPE_POLICY add constraint FK2sqtfixfhbc1deki59lssygdc foreign key (POLICY_ID) references RESOURCE_SERVER_POLICY
alter table sector_instance add constraint FKi5lq8v20dbsh1dektrflmkt4a foreign key (instances_instance_id) references instance
alter table sector_instance add constraint FKrcy1jee6ornj0jp1undnx72qt foreign key (Sector_sector_id) references sector
alter table Subcategory add constraint FK43tc06kgjdorl3ipseoam4lw9 foreign key (codeCat) references Category
alter table tbLog_Item_Center add constraint FK3lk6nhr6eax43abipy1j5qiuy foreign key (CenterID) references tbCenters
alter table tbLog_Item_Center add constraint FK3k9hynoo8rr2k0upe9e252pvj foreign key (cdItem) references Item_Master
alter table tblUsersHistory add constraint FK6k0dstgo7eefwa2970rccp5is foreign key (historyUserID) references tblUsers
alter table tblUsersHistory add constraint FKfmfwaq94h8kflicmsax2oicqa foreign key (UserID) references tblUsers
alter table tbNewItemId add constraint FKnppj9a10jrnc9t7s7tvbeid63 foreign key (id) references tblTypeNewItemId
alter table tbProfitCenters add constraint FK8muq3yxwwbmwn6d4201xknf4r foreign key (CenterID) references tbCenters
alter table USER_ATTRIBUTE add constraint FKmri9y4ho2nnq0sabhcdi3g0am foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT add constraint FKicmojso97tmtxc210y5996118 foreign key (USER_ID) references USER_ENTITY
alter table USER_CONSENT_CLIENT_SCOPE add constraint FK2iwrnt95i599i7qmki85wqyp4 foreign key (USER_CONSENT_ID) references USER_CONSENT
alter table USER_FEDERATION_CONFIG add constraint FK6rrp2pt8urfy3u94ljvk0wmsc foreign key (USER_FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKso3vkvgi634r12hpyed97l46s foreign key (FEDERATION_PROVIDER_ID) references USER_FEDERATION_PROVIDER
alter table USER_FEDERATION_MAPPER add constraint FKnhb66nsf48lxffpo1hs7g9b2i foreign key (REALM_ID) references REALM
alter table USER_FEDERATION_MAPPER_CONFIG add constraint FKsu4g543wns06j1ibun7438my6 foreign key (USER_FEDERATION_MAPPER_ID) references USER_FEDERATION_MAPPER
alter table USER_FEDERATION_PROVIDER add constraint FKdt1xhnenabh7dtmixk6nfde6a foreign key (REALM_ID) references REALM
alter table USER_GROUP_MEMBERSHIP add constraint FKhd54egqa5g0jcwichyc7rspm5 foreign key (USER_ID) references USER_ENTITY
alter table USER_REQUIRED_ACTION add constraint FKs533b28rr3drddwsx0t06lkp7 foreign key (USER_ID) references USER_ENTITY
alter table USER_ROLE_MAPPING add constraint FKnco6kxmsv20rs8a0ywrw4xi9f foreign key (USER_ID) references USER_ENTITY
alter table WEB_ORIGINS add constraint FK1c0co420xe84nrvwpdg1p6de2 foreign key (CLIENT_ID) references CLIENT
