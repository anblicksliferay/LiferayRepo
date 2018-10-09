create index IX_360F866 on astra_achivementFormula (uuid_[$COLUMN_LENGTH:75$]);

create index IX_BCE6CD6A on astra_cla_kpi (kpiId, periodId);
create index IX_1E8A5E1F on astra_cla_kpi (uuid_[$COLUMN_LENGTH:75$]);

create index IX_1869E529 on astra_company (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_6B58A6B3 on astra_itemDescription (uuid_[$COLUMN_LENGTH:75$]);

create index IX_54F077D0 on astra_kpi (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_5873B27F on astra_period (uuid_[$COLUMN_LENGTH:75$]);

create index IX_C41C09F1 on astra_tradingProfit (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_126785A6 on astra_type (uuid_[$COLUMN_LENGTH:75$]);

create index IX_B3E54EA5 on pdca_achivementFormula (uuid_[$COLUMN_LENGTH:75$]);

create index IX_78FAA71E on pdca_cla_kpi (uuid_[$COLUMN_LENGTH:75$]);

create index IX_787056CA on pdca_company (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_452B80B2 on pdca_itemDescription (uuid_[$COLUMN_LENGTH:75$]);

create index IX_2A6AE1F1 on pdca_kpi (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_7C66CDA0 on pdca_period (uuid_[$COLUMN_LENGTH:75$]);

create index IX_4CB70B96 on pdca_tradingProfit (uuid_[$COLUMN_LENGTH:75$]);

create index IX_94F8F507 on pdca_type (uuid_[$COLUMN_LENGTH:75$]);