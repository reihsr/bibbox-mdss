create index IX_7E6CA4DF on FOO_ImportMedicalDataSet (groupId);
create index IX_F0DDBD5F on FOO_ImportMedicalDataSet (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_63240FA1 on FOO_ImportMedicalDataSet (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_DCD0DA7D on FOO_ImportMedicalDataSetFieldMap (groupId);
create index IX_120E1948 on FOO_ImportMedicalDataSetFieldMap (importMedicalDataSetId);
create index IX_7CB8F981 on FOO_ImportMedicalDataSetFieldMap (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_8783EC43 on FOO_ImportMedicalDataSetFieldMap (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5AFFE2E5 on FOO_ImportMedicalDataSetLog (groupId);
create index IX_17B7540B on FOO_ImportMedicalDataSetLog (importMedicalDataSetId, importStatus);
create index IX_CC8E619 on FOO_ImportMedicalDataSetLog (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C3561EDB on FOO_ImportMedicalDataSetLog (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F089762F on FOO_KloetzelBuch (groupId);
create index IX_B23B3572 on FOO_KloetzelBuch (medicalRecordId);
create index IX_6A8F660F on FOO_KloetzelBuch (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E5882451 on FOO_KloetzelBuch (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8C3ABDBB on FOO_MedicalRecord (groupId);
create index IX_481F90D3 on FOO_MedicalRecord (iNumber);
create index IX_7C95924A on FOO_MedicalRecord (importMedicalDataSetId);
create index IX_5C87DC03 on FOO_MedicalRecord (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_334D8745 on FOO_MedicalRecord (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_738A9BAB on FOO_PathologieData (groupId);
create index IX_9D248B7A on FOO_PathologieData (material[$COLUMN_LENGTH:75$]);
create index IX_596D1EEE on FOO_PathologieData (medicalRecordId);
create index IX_A99AAC13 on FOO_PathologieData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BF51B55 on FOO_PathologieData (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_7A6C63B4 on FOO_PathologyData (groupId);
create index IX_727BC491 on FOO_PathologyData (material[$COLUMN_LENGTH:75$]);
create index IX_9C6ECDF7 on FOO_PathologyData (medicalRecordId);
create index IX_C6CEDE2A on FOO_PathologyData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_47ECE72C on FOO_PathologyData (uuid_[$COLUMN_LENGTH:75$], groupId);