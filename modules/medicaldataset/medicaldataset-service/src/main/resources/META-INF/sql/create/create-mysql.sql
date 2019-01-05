drop database if exists lportal;
create database lportal character set utf8;
use lportal;



create index IX_67169500 on medicaldataset_ImportMedicalDataSet (groupId);
create index IX_DD9625E on medicaldataset_ImportMedicalDataSet (uuid_, companyId);
create unique index IX_9872E860 on medicaldataset_ImportMedicalDataSet (uuid_, groupId);

create index IX_515D199E on medicaldataset_ImportMedicalDataSetFieldMap (groupId);
create index IX_6D699407 on medicaldataset_ImportMedicalDataSetFieldMap (importMedicalDataSetId);
create index IX_F5FB2F80 on medicaldataset_ImportMedicalDataSetFieldMap (uuid_, companyId);
create unique index IX_EB899602 on medicaldataset_ImportMedicalDataSetFieldMap (uuid_, groupId);

create index IX_B2DEF324 on medicaldataset_ImportMedicalDataSetLog (groupId);
create index IX_9570802C on medicaldataset_ImportMedicalDataSetLog (importMedicalDataSetId, importStatus);
create index IX_D4EEACBA on medicaldataset_ImportMedicalDataSetLog (uuid_, companyId);
create unique index IX_45CF19BC on medicaldataset_ImportMedicalDataSetLog (uuid_, groupId);

create index IX_3A921750 on medicaldataset_KloetzelBuch (groupId);
create index IX_9AE52593 on medicaldataset_KloetzelBuch (medicalRecordId);
create index IX_97237A0E on medicaldataset_KloetzelBuch (uuid_, companyId);
create unique index IX_C3BF2C10 on medicaldataset_KloetzelBuch (uuid_, groupId);

create index IX_834640BA on medicaldataset_MedicalRecord (groupId);
create index IX_3F2B13D2 on medicaldataset_MedicalRecord (iNumber);
create index IX_F121D16B on medicaldataset_MedicalRecord (importMedicalDataSetId);
create index IX_C27647E4 on medicaldataset_MedicalRecord (uuid_, companyId);
create unique index IX_1BF77766 on medicaldataset_MedicalRecord (uuid_, groupId);

create index IX_7177E6B3 on medicaldataset_PathologyData (groupId);
create index IX_5CE0A172 on medicaldataset_PathologyData (material(255));
create index IX_C902E1F6 on medicaldataset_PathologyData (medicalRecordId);
create index IX_2CBD4A0B on medicaldataset_PathologyData (uuid_, companyId);
create unique index IX_3096D74D on medicaldataset_PathologyData (uuid_, groupId);


