package com.astra.anblicks.pdca.services.sql;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.astra.anblicks.pdca.dto.Reportdto;

public class PdcaSqlQueries {
	
	public static void getkpis(Connection conn) {
        QueryRunner queryRunner = new QueryRunner();
        
        ResultSetHandler<List<Reportdto>> resultHandler = new BeanListHandler<Reportdto>(Reportdto.class);
        
        try {
        	
        	 if(conn!=null){
                 String sql = "SELECT k.companyId AS cid,ck.periodId AS pid,SUM(ck.claPoint) AS value, 'Sum_ClaPoint' As type FROM pdca_kpi k INNER JOIN pdca_cla_kpi ck ON k.kpiId = ck.kpiId WHERE k.year = ? AND ck.periodId IN (?,?) GROUP BY k.companyId,ck.periodId ORDER BY k.companyId ASC";
                 
                 List<Reportdto> listofitems = queryRunner.query(conn, sql, resultHandler,2017,1,2);
                 
                 
                 for(Reportdto r : listofitems) {
                	 System.out.println(r.toString());
                 }

             } 
        	
			
		} catch (Exception e) {
		}    
		
	}

}
