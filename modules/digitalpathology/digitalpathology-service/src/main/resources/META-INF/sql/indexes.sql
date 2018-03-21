create index IX_2ACF35B on DP_wsi (filename[$COLUMN_LENGTH:75$]);
create index IX_78AB4E14 on DP_wsi (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_17184996 on DP_wsi (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_40907F22 on DP_wsihash (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_75126624 on DP_wsihash (uuid_[$COLUMN_LENGTH:75$], groupId);
create index IX_EF3F2F4A on DP_wsihash (wsiId);