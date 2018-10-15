package com.astra.anblicks.pdca.services.sql;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.astra.anblicks.pdca.dto.NamedObject;
import com.astra.anblicks.pdca.dto.Reportdto;

public class PdcaSqlQueries {
	
	public static List<NamedObject<Map<Long, List<Reportdto>>>> getReportForFullYearData(Connection conn,int reportId, long year) {
		
		List<NamedObject<Map<Long, List<Reportdto>>>> MappedObjects = new ArrayList<NamedObject<Map<Long, List<Reportdto>>>>();
		
		
        QueryRunner queryRunner = new QueryRunner();
        
        ResultSetHandler<List<Reportdto>> resultHandler = new BeanListHandler<Reportdto>(Reportdto.class);
        
        long previousYear = year-1l;
        
        try{
        	 if(conn!=null){
                 String sql1 = "SELECT k.companyId AS cid,ck.periodId AS pid,SUM(ck.claPoint) AS value, 'Sum_ClaPoint_CurrentYear' AS type, k.year AS year FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?,?,?) GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
                 
                 String sql2 = "SELECT k.companyId AS cid,ck.periodId AS pid,SUM(ck.claPoint) AS value, 'Sum_ClaPoint_PreviousYear' AS type, k.year AS year FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?) GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
                 
                 String sql3 = "SELECT k.companyId AS cid,ck.periodId AS pid,ck.achivement AS value, 'Trading_Profit' As type, k.year AS year FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?,?,?) AND k.itemDescriptionName = ? GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
                 List<Reportdto> sumOfKpislist_CurrentYear = queryRunner.query(conn, sql1, resultHandler, year,3,4,5);
                 List<Reportdto> sumOfKpislist_PreviousYear = queryRunner.query(conn, sql2, resultHandler, previousYear,4);
                 List<Reportdto> TradingProfitKpis_CurrentYear = queryRunner.query(conn, sql3, resultHandler,year,3,4,5,1);
                 
                 MappedObjects.add(new NamedObject<Map<Long,List<Reportdto>>>("list1", MergeListstoMap(sumOfKpislist_CurrentYear,sumOfKpislist_PreviousYear)));
                 MappedObjects.add(new NamedObject<Map<Long,List<Reportdto>>>("list2", ListtoMap(TradingProfitKpis_CurrentYear)));    

             } 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        return MappedObjects;
	}
	
	public static Map<Long, List<Reportdto>> getReportForCP(Connection conn,int reportId, long year) {
		
		    Map<Long, List<Reportdto>> map = new HashMap<Long, List<Reportdto>>();
		
		    QueryRunner queryRunner = new QueryRunner();
	        
	        ResultSetHandler<List<Reportdto>> resultHandler = new BeanListHandler<Reportdto>(Reportdto.class);
	        
	        long previousYear = year-1l;
	        
	        try {
				if(conn!=null) {
	                 String sql = "SELECT k.companyId AS cid,ck.periodId AS pid,ck.ol AS value, 'Trading_Profit' As type, k.year AS year FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?) AND k.itemDescriptionName = ? GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
				
	                 List<Reportdto> TradingProfitKpis_CurrentYear = queryRunner.query(conn, sql, resultHandler,previousYear,5,1);
	                 
	                 map = ListtoMap(TradingProfitKpis_CurrentYear);
				
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	        
	        return map;
		
	}
	
	public static List<NamedObject<Map<Long, List<Reportdto>>>> getReportForEM_OlAdj(Connection conn,int reportId, long year) {
		
        List<NamedObject<Map<Long, List<Reportdto>>>> MappedObjects = new ArrayList<NamedObject<Map<Long, List<Reportdto>>>>();
		
		
        QueryRunner queryRunner = new QueryRunner();
        
        ResultSetHandler<List<Reportdto>> resultHandler = new BeanListHandler<Reportdto>(Reportdto.class);
        
        long previousYear = year-1l;
        
        try{
        	 if(conn!=null){
                 String sql1 = "SELECT k.companyId AS cid,ck.periodId AS pid,SUM(ck.claPoint) AS value, 'Sum_ClaPoint_CurrentYear' AS type, k.year AS year FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?) GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
                 
                 String sql2 = "SELECT k.companyId AS cid,ck.periodId AS pid,SUM(ck.claPoint) AS value, 'Sum_ClaPoint_PreviousYear' AS type, k.year AS year FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?) GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
                 
                 String sql3 = "SELECT k.companyId AS cid,ck.periodId AS pid,ck.achivement AS value, 'Trading_Profit' As type, k.year AS year FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?) AND k.itemDescriptionName = ? GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
                 List<Reportdto> sumOfKpislist_CurrentYear = queryRunner.query(conn, sql1, resultHandler, year,3);
                 List<Reportdto> sumOfKpislist_PreviousYear = queryRunner.query(conn, sql2, resultHandler, previousYear,3);
                 List<Reportdto> TradingProfitKpis_CurrentYear = queryRunner.query(conn, sql3, resultHandler,year,3,1);
                 
                 MappedObjects.add(new NamedObject<Map<Long,List<Reportdto>>>("list1", MergeListstoMap(sumOfKpislist_CurrentYear,sumOfKpislist_PreviousYear)));
                 MappedObjects.add(new NamedObject<Map<Long,List<Reportdto>>>("list2", ListtoMap(TradingProfitKpis_CurrentYear)));    

             } 
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        return MappedObjects;
	
	}
	
	private static Map<Long, List<Reportdto>> MergeListstoMap(List<Reportdto> list1,
			List<Reportdto> list2) {
		
		Map<Long, List<Reportdto>> listtoMap1 = ListtoMap(list1);
		Map<Long, List<Reportdto>> listtoMap2 = ListtoMap(list2);
		
		return Stream.of(listtoMap1, listtoMap2)
        .flatMap(map -> map.entrySet().stream())
        .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> new ArrayList<>(e.getValue()),
                (left, right) -> {left.addAll(right); return left;}
        ));
		
		
		
	}

	private static Map<Long, List<Reportdto>> ListtoMap(List<Reportdto> list) {
		
	  return list
			.stream()
			.collect(Collectors.groupingBy(Reportdto::getCid));
	
	}

}
