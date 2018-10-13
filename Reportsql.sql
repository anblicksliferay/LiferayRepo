-- Query for Getting the Company Wise Period Wise Sum of KPis Data of Cla Point(Report For FY)

SELECT k.companyId AS cid,ck.periodId AS pid,SUM(ck.claPoint) AS sum_cla_point
FROM pdca_kpi k 
INNER JOIN pdca_cla_kpi ck
ON k.kpiId = ck.kpiId
WHERE k.year = 2017 AND ck.periodId IN (3,4,5)
GROUP BY k.companyId,ck.periodId 
ORDER BY k.companyId ASC;

-- Query for Getting the Company Period year Based KPis Data of Achivement of Trading Profit(Report For FY)

SELECT k.companyId AS cid,ck.periodId AS pid,ck.achivement 
FROM pdca_kpi k 
INNER JOIN pdca_cla_kpi ck
ON k.kpiId = ck.kpiId
WHERE k.year = 2017 AND ck.periodId IN (3,4,5) AND k.itemDescriptionName = 1
GROUP BY k.companyId,ck.periodId 
ORDER BY k.companyId ASC;

-- Query for Getting the Company Period year Based KPis Data of OL of Trading Profit(Report For CP)

SELECT k.companyId AS cid,ck.periodId AS pid,ck.ol
FROM pdca_kpi k 
INNER JOIN pdca_cla_kpi ck
ON k.kpiId = ck.kpiId
WHERE k.year = 2017 AND ck.periodId IN (3,4,5) AND k.itemDescriptionName = 1
GROUP BY k.companyId,ck.periodId 
ORDER BY k.companyId ASC;




