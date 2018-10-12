package com.astra.anblicks.pdca.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PdcaSqlQueries {
	
	public static void getkpis(Connection conn) {
		

        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
        	
        	 if(conn!=null){
                 String sql = "SELECT pdca_kpi.companyId,pdca_cla_kpi.periodId,sum(pdca_cla_kpi.claPoint) as sum_cla_point "
                 		+ "FROM pdca.pdca_kpi,pdca.pdca_cla_kpi "
                 		+ "where pdca_kpi.kpiId = pdca_cla_kpi.kpiId and year = 2017 and periodId in (3,4,5)"
                 		+ "group by pdca_kpi.companyId,pdca_cla_kpi.periodId order by pdca_kpi.companyId ASC";
                 stmt = conn.prepareStatement(sql);       
                 rs = stmt.executeQuery();
                 while(rs.next()){
                	 System.out.println("data ---> "+rs.getLong(1)+"  "+rs.getLong(2)+" "+rs.getDouble(3));
                 }
              //   System.out.println("data ---> "+rs.toString());
             }
			
		} catch (Exception e) {
		}    
		
	}

}
