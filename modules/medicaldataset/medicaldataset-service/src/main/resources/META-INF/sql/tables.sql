create table FOO_ImportMedicalDataSet (
	uuid_ VARCHAR(75) null,
	importMedicalDataSetId LONG not null primary key,
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
	importName VARCHAR(75) null,
	importType VARCHAR(75) null,
	imiJobId LONG,
	description STRING null,
	fileName VARCHAR(75) null,
	filePath VARCHAR(1000) null,
	fileId LONG,
	importCount INTEGER,
	importStatus INTEGER
);

create table FOO_ImportMedicalDataSetFieldMap (
	uuid_ VARCHAR(75) null,
	importMedicalDataSetFieldMapId LONG not null primary key,
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
	importMedicalDataSetId LONG,
	importField VARCHAR(1000) null,
	importFieldPath VARCHAR(1000) null,
	sampleValue VARCHAR(1000) null,
	TableName VARCHAR(1000) null,
	TableField VARCHAR(1000) null
);

create table FOO_ImportMedicalDataSetLog (
	uuid_ VARCHAR(75) null,
	importMedicalDataSetLogId LONG not null primary key,
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
	importMedicalDataSetId LONG,
	importStatus INTEGER,
	importStatusLog STRING null
);

create table FOO_KloetzelBuch (
	uuid_ VARCHAR(75) null,
	kloetzelBuchId LONG not null primary key,
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
	medicalRecordId LONG,
	histonumberStart LONG,
	histonumberEnd LONG,
	histonumberRunning INTEGER,
	histonumber LONG,
	kloetzelBuchRunning INTEGER,
	oid VARCHAR(75) null,
	bid VARCHAR(75) null,
	area VARCHAR(75) null,
	type_ VARCHAR(75) null,
	acronym VARCHAR(75) null,
	text_ STRING null,
	info STRING null,
	count INTEGER,
	numberOfPieces INTEGER,
	kbStatus INTEGER,
	sort INTEGER,
	color VARCHAR(75) null,
	kbDate DATE null,
	day VARCHAR(75) null,
	pocessinguser VARCHAR(75) null,
	organizationUnit VARCHAR(75) null
);

create table FOO_MedicalRecord (
	uuid_ VARCHAR(75) null,
	medicalRecordId LONG not null primary key,
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
	importMedicalDataSetId LONG,
	histonumberStart LONG,
	histonumberEnd LONG,
	histonumberRunning INTEGER,
	iNumber LONG,
	vPatientId LONG,
	vHistonNumber LONG,
	area VARCHAR(75) null,
	imiJobId LONG,
	importFile VARCHAR(75) null
);

create table FOO_PathologieData (
	uuid_ VARCHAR(75) null,
	pathologieDataId LONG not null primary key,
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
	medicalRecordId LONG,
	receivedDate DATE null,
	validationDate DATE null,
	patientAge INTEGER,
	sender VARCHAR(75) null,
	extractionMethode VARCHAR(75) null,
	reportingPhysician1 VARCHAR(75) null,
	reportingPhysician2 VARCHAR(75) null,
	gynPhysician VARCHAR(75) null,
	validationPhysician1 VARCHAR(75) null,
	validationPhysician2 VARCHAR(75) null,
	reportStatus VARCHAR(75) null,
	numberOfBlockes INTEGER,
	numberOfSlides INTEGER,
	basicDisease VARCHAR(75) null,
	causeOfDeath VARCHAR(75) null,
	material VARCHAR(75) null,
	materialExtended VARCHAR(75) null,
	macroscopicDescription STRING null,
	microscopicDescription STRING null,
	histologicDescription STRING null,
	molecularPathologicDescription STRING null,
	zytologieDescription STRING null,
	pathologicDiagnosis STRING null,
	frozenSectionDiagnosis STRING null,
	molecularPathologicDiagnosis STRING null,
	zytologieDiagnosis STRING null,
	neuroPathologicDiagnosis STRING null,
	comment_ STRING null,
	zytologiecomment STRING null,
	grad VARCHAR(75) null,
	tnmp VARCHAR(75) null,
	tnmt VARCHAR(75) null,
	tnmn VARCHAR(75) null,
	tnmm VARCHAR(75) null,
	tnmr VARCHAR(75) null,
	tnml VARCHAR(75) null,
	tnmv VARCHAR(75) null,
	tnmpn VARCHAR(75) null,
	dgcode1 VARCHAR(75) null,
	dgcode2 VARCHAR(75) null,
	pap VARCHAR(75) null,
	smearQuality VARCHAR(75) null
);