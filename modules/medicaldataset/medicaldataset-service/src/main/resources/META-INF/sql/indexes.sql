create index IX_F089762F on FOO_KloetzelBuch (groupId);
create index IX_B23B3572 on FOO_KloetzelBuch (medicalRecordId);
create index IX_6A8F660F on FOO_KloetzelBuch (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_E5882451 on FOO_KloetzelBuch (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8C3ABDBB on FOO_MedicalRecord (groupId);
create index IX_481F90D3 on FOO_MedicalRecord (iNumber);
create index IX_5C87DC03 on FOO_MedicalRecord (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_334D8745 on FOO_MedicalRecord (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_738A9BAB on FOO_PathologieData (groupId);
create index IX_9D248B7A on FOO_PathologieData (material[$COLUMN_LENGTH:75$]);
create index IX_596D1EEE on FOO_PathologieData (medicalRecordId);
create index IX_A99AAC13 on FOO_PathologieData (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BF51B55 on FOO_PathologieData (uuid_[$COLUMN_LENGTH:75$], groupId);