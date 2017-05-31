package org.doggy.tracker;

import java.util.List;

import javax.sql.DataSource;

public interface DeviceReportDAO {
	
	   public void setDataSource(DataSource dataSource);

	   public void create(Integer deviceId, float latitude, float longitude, String deviceBattery);

	   public DeviceReport getDeviceReport(Integer id);

	   public List<DeviceReport> listDeviceReports();

	   public void update(Integer deviceId, float latitude, float longitude, String deviceBattery);
}
