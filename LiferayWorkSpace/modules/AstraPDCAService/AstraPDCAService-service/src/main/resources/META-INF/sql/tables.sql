create table astra_achivementFormula (
	uuid_ VARCHAR(75) null,
	achivementFormulaId LONG not null primary key,
	achivementFormula VARCHAR(75) null,
	itemDescriptionId LONG
);

create table astra_cla_kpi (
	uuid_ VARCHAR(75) null,
	claKpiId LONG not null primary key,
	kpiId LONG,
	periodId LONG,
	ytd LONG,
	ol LONG,
	claPoint LONG,
	achivement LONG
);

create table astra_company (
	uuid_ VARCHAR(75) null,
	companyId LONG not null primary key,
	companyName VARCHAR(75) null
);

create table astra_itemDescription (
	uuid_ VARCHAR(75) null,
	itemDescriptionId LONG not null primary key,
	itemDescriptionName VARCHAR(75) null
);

create table astra_kpi (
	uuid_ VARCHAR(75) null,
	kpiId LONG not null primary key,
	companyId LONG,
	typeId LONG,
	weight LONG,
	target LONG,
	year LONG,
	unit VARCHAR(75) null,
	achivementFormulaId LONG,
	itemDescriptionName VARCHAR(75) null,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table astra_period (
	uuid_ VARCHAR(75) null,
	periodId LONG not null primary key,
	periodName VARCHAR(75) null
);

create table astra_tradingProfit (
	uuid_ VARCHAR(75) null,
	tradingProfitId LONG not null primary key,
	periodId LONG,
	companyId LONG,
	npat DOUBLE,
	netForex DOUBLE,
	ppeDispos DOUBLE,
	revalutionOnPropertyInvestment DOUBLE,
	investment DOUBLE,
	taxExpense DOUBLE,
	impairmentOnAsset DOUBLE
);

create table astra_type (
	uuid_ VARCHAR(75) null,
	typeId LONG not null primary key,
	typeName VARCHAR(75) null
);

create table pdca_achivementFormula (
	uuid_ VARCHAR(75) null,
	achivementFormulaId LONG not null primary key,
	achivementFormula VARCHAR(75) null,
	itemDescriptionId LONG
);

create table pdca_cla_kpi (
	uuid_ VARCHAR(75) null,
	claKpiId LONG not null primary key,
	kpiId LONG,
	periodId LONG,
	ytd LONG,
	ol LONG,
	claPoint LONG,
	achivement LONG
);

create table pdca_company (
	uuid_ VARCHAR(75) null,
	companyId LONG not null primary key,
	companyName VARCHAR(75) null
);

create table pdca_itemDescription (
	uuid_ VARCHAR(75) null,
	itemDescriptionId LONG not null primary key,
	itemDescriptionName VARCHAR(75) null
);

create table pdca_kpi (
	uuid_ VARCHAR(75) null,
	kpiId LONG not null primary key,
	companyId LONG,
	typeId LONG,
	weight LONG,
	target LONG,
	year LONG,
	unit LONG,
	achivementFormulaId LONG,
	itemDescriptionName VARCHAR(75) null,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table pdca_period (
	uuid_ VARCHAR(75) null,
	periodId LONG not null primary key,
	periodName VARCHAR(75) null
);

create table pdca_tradingProfit (
	uuid_ VARCHAR(75) null,
	tradingProfitId LONG not null primary key,
	periodId LONG,
	npat LONG,
	netForex LONG,
	ppeDispos LONG,
	revalutionOnPropertyInvestment LONG,
	investment LONG,
	taxExpense LONG,
	impairmentOnAsset LONG
);

create table pdca_type (
	uuid_ VARCHAR(75) null,
	typeId LONG not null primary key,
	typeName VARCHAR(75) null
);