package com.astra.anblicks.pdca.services.sql;

import java.sql.Connection;
import java.sql.DriverManager;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class PdcaMySqlConnection {
	
	private static Log _log = LogFactoryUtil.getLog(PdcaMySqlConnection.class.getName());
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(PdcaSqlConstants._driver).newInstance();
			connection = DriverManager.getConnection(PdcaSqlConstants._url, PdcaSqlConstants._username, PdcaSqlConstants._password);
		} catch (Exception ex) {
			_log.error("Error Occured While Getting the Connection: - "+ ex);
		}
		return connection;
	}
}
