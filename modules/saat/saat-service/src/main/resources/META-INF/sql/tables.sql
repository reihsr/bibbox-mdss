create table SAAT_Dictionary (
	uuid_ VARCHAR(75) null,
	dictionaryId LONG not null primary key,
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
	synonym VARCHAR(75) null,
	pattern VARCHAR(75) null,
	code_ BOOLEAN,
	code_type VARCHAR(75) null,
	code_value VARCHAR(75) null,
	root BOOLEAN,
	negation BOOLEAN,
	priority INTEGER,
	priority_mode BOOLEAN,
	before_synonym INTEGER,
	after_synonym INTEGER,
	foreword BOOLEAN,
	ending BOOLEAN,
	sentence BOOLEAN,
	occure BOOLEAN
);

create table SAAT_DictionaryDictionaryLink (
	uuid_ VARCHAR(75) null,
	dictionarydictionarylinkId LONG not null primary key,
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
	dictionaryId LONG,
	linkdictionaryId LONG
);