create index IX_C8CD838B on SAAT_Dictionary (dictionaryId, groupId);
create index IX_3EE8DE5A on SAAT_Dictionary (root, groupId);
create index IX_E2542EEE on SAAT_Dictionary (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_935798F0 on SAAT_Dictionary (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_DC1BBACF on SAAT_DictionaryDictionaryLink (dictionaryId);
create index IX_87D64749 on SAAT_DictionaryDictionaryLink (linkdictionaryId);
create index IX_90F781BE on SAAT_DictionaryDictionaryLink (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_D9515FC0 on SAAT_DictionaryDictionaryLink (uuid_[$COLUMN_LENGTH:75$], groupId);