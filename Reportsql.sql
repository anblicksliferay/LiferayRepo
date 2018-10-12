-- Query for Getting the Company Wise Period Wise Sum of KPis Data of cla_point

SELECT pdca_kpi.companyId,pdca_cla_kpi.periodId,sum(pdca_cla_kpi.claPoint) as sum_cla_point
FROM pdca.pdca_kpi,pdca.pdca_cla_kpi 
where pdca_kpi.kpiId = pdca_cla_kpi.kpiId and year = 2017 and periodId in (3,4,5)
group by pdca_kpi.companyId,pdca_cla_kpi.periodId order by pdca_kpi.companyId ASC;

-- Query for Getting the Company Period year Based KPis Data of cla_point of Trading Profit

SELECT pdca_kpi.companyId,pdca_cla_kpi.periodId,pdca_cla_kpi.claPoint FROM pdca.pdca_kpi,pdca.pdca_cla_kpi 
where pdca_kpi.kpiId = pdca_cla_kpi.kpiId and year = 2017 and periodId in (3,4,5) and pdca_kpi.itemDescriptionName = 1
group by pdca_kpi.companyId,pdca_cla_kpi.periodId order by pdca_kpi.companyId ASC;





