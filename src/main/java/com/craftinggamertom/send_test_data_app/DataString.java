package com.craftinggamertom.send_test_data_app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class DataString {
	
	private String xml = "";

	private final int minimumTemp = 50;
	private final int maximumTemp = 85;

	private final int minimumHumidity = 35;
	private final int maximumHumidity = 65;

	private final int minimumCarbon = 2;
	private final int maximumCarbon = 4;

	private final int minimumPh = 6;
	private final int maximumPh = 8;

	private final int minimumWater = 87;
	private final int maximumWater = 99;

	private final int minimumHeat = 52;
	private final int maximumHeat = 80;

	public DataString(HashMap<String, String> allSensors, ArrayList<String> sensorIds) {
		
		System.out.println("DELETE: entered DataString");

		
		setJSON("{\r\n" + 
				"	\"date\": \"");
		setJSON(getJSON() + getCurrentTime());
		setJSON(getJSON() + "\",\r\n" + 
				"	\"sensors\": [");
		
		for (int i = 0; i < allSensors.size(); i++) {
			System.out.println("DELETE: entered for loop");

			
			String identification = sensorIds.get(i);
			String sensorType = allSensors.get(identification);
			int randomData;
			
			if (sensorType.equals("temperature")) {
				randomData = minimumTemp + (int) (Math.random() * maximumTemp);
			} else if (sensorType.equals("humidity")) {
				randomData = minimumHumidity + (int) (Math.random() * maximumHumidity);
			} else if (sensorType.equals("carbon-dioxide")) {
				randomData = minimumCarbon + (int) (Math.random() * maximumCarbon);
			} else if (sensorType.equals("ph-level")) {
				randomData = minimumPh + (int) (Math.random() * maximumPh);
			} else if (sensorType.equals("water")) {
				randomData = minimumWater + (int) (Math.random() * maximumWater);
			} else if (sensorType.equals("heat-index")) {
				randomData = minimumHeat + (int) (Math.random() * maximumHeat);
			} else {
				randomData = 0;
			}
			
			setJSON(getJSON() + "{\r\n" + 
					"		\"id\": \"");
			setJSON(getJSON() + identification);
			setJSON(getJSON() + "\",\r\n" + 
					"		\"type\": \"");
			setJSON(getJSON() + sensorType);
			setJSON(getJSON() + "\",\r\n" + 
					"		\"value\": ");
			setJSON(getJSON() + randomData);
			setJSON(getJSON() + "\r\n" + 
					"	}, ");

		}
		setJSON(getJSON().substring(0, getJSON().length()-2)); // removes ", " from last sensor to make the array proper
		
		setJSON(getJSON() + "]\r\n" + 
				"}");
		
		System.out.println("DELETE: " + getJSON());

	}

	private String getCurrentTime() {
		String currentTime;
		// Collects and sets the current Time
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss-04:00");
		LocalDateTime now = LocalDateTime.now();
		currentTime = dtf.format(now); // 2016/11/16 12:08:43
		return currentTime;
	}

	private String getJSON() {
		return xml;
	}

	private void setJSON(String xml) {
		this.xml = xml;
	}
	
	/**
	 * getting the xml string
	 * @return
	 */
	public String getJSONAsString() {
		return xml;
	}
}
