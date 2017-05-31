package org.doggy.tracker;

import javax.sql.DataSource;

public interface DeviceDAO {

	   public void setDataSource(DataSource dataSource);
	   
	   public void update(String name, Integer userId, int id);

	   public Device getDevice(String imei);

}