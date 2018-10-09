create index IX_B3E54EA5 on pdca_achivementFormula (uuid_[$COLUMN_LENGTH:75$]);

create index IX_78FAA71E on pdca_cla_kpi (uuid_[$COLUMN_LENGTH:75$]);

create index IX_787056CA on pdca_company (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_452B80B2 on pdca_itemDescription (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2A6AE1F1 on pdca_kpi (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_7C66CDA0 on pdca_period (uuid_[$COLUMN_LENGTH:75$]);

create index IX_6C94FED2 on pdca_tradingProfit (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_94F8F507 on pdca_type (uuid_[$COLUMN_LENGTH:75$]);