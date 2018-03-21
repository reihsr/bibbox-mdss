create table DP_wsi (
	uuid_ VARCHAR(75) null,
	wsiId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	filename VARCHAR(75) null,
	hashmrxs VARCHAR(75) null,
	scanstart DATE null,
	scanduration LONG
);

create table DP_wsihash (
	uuid_ VARCHAR(75) null,
	wsihashId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	wsiId LONG,
	filename VARCHAR(75) null,
	hash VARCHAR(75) null
);