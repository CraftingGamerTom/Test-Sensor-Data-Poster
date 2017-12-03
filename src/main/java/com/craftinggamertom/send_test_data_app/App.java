package com.craftinggamertom.send_test_data_app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * @author Thomas Rokicki
 *
 */
public class App {

	/**
	 * Starts the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Started app");
		// Timer
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(App::myTask, 0, 600, TimeUnit.SECONDS); // First int is the intial delay,
																					// second int is the timer(sec)
	}

	private static void myTask() {
		System.out.println("DELETE: myTask");

		sendData(createData());
	}

	private static void sendData(String jsonString) {
		System.out.println("DELETE: Running");
		System.out.println(jsonString.toString());

		HttpClient httpClient = HttpClientBuilder.create().build(); // Use this instead

		try {

			HttpPost request = new HttpPost("http://192.168.1.2:8090/sensorData");
			StringEntity params = new StringEntity(jsonString);
			request.addHeader("test-data", "application/x-www-form-urlencoded");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);

			// handle response here...

		} catch (Exception ex) {

			// handle exception here
			ex.printStackTrace();

		} finally {
			// do nothing
		}

	}

	/**
	 * Creates the data and returns json
	 * 
	 * @return
	 */
	private static String createData() {

		System.out.println("DELETE: entered createData");
		DataString ds = new DataString(createMapOfSensors(), createSensorNamesList());

		String jsonString = ds.getJSONAsString();

		System.out.println("DELETE(app): print json String" + jsonString);

		return jsonString;

	}

	/**
	 * Needed a list of names to go with the list of sensors
	 * 
	 * @return ArrayList with all ids
	 */
	private static ArrayList<String> createSensorNamesList() {
		ArrayList<String> sensorIds = new ArrayList<String>();
		sensorIds.add("rp01-01");
		sensorIds.add("rp01-02");
		sensorIds.add("rp01-03");
		sensorIds.add("rp01-04");
		sensorIds.add("rp01-05");
		sensorIds.add("rp01-06");
		sensorIds.add("rp01-07");
		sensorIds.add("rp01-08");
		sensorIds.add("rp01-09");
		sensorIds.add("rp01-10");
		sensorIds.add("rp01-11");
		sensorIds.add("rp01-12");

		sensorIds.add("rp02-01");
		sensorIds.add("rp02-02");
		sensorIds.add("rp02-03");
		sensorIds.add("rp02-04");
		sensorIds.add("rp02-05");
		sensorIds.add("rp02-06");
		sensorIds.add("rp02-07");
		sensorIds.add("rp02-08");
		sensorIds.add("rp02-09");
		sensorIds.add("rp02-10");
		sensorIds.add("rp02-11");
		sensorIds.add("rp02-12");

		sensorIds.add("a01-01");
		sensorIds.add("a01-02");
		sensorIds.add("a01-03");
		sensorIds.add("a01-04");
		sensorIds.add("a01-05");
		sensorIds.add("a01-06");
		sensorIds.add("a01-07");
		sensorIds.add("a01-08");
		sensorIds.add("a01-09");
		sensorIds.add("a01-10");
		sensorIds.add("a01-11");
		sensorIds.add("a01-12");

		return sensorIds;
	}

	/**
	 * Organized way to cluster a bunch of sensors together based on their id and
	 * type May not be the best solution for the real application in the greenhouse.
	 * 
	 * @return Map with all the sensor ids and types
	 */
	private static HashMap<String, String> createMapOfSensors() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("rp01-01", "temperature");
		map.put("rp01-02", "temperature");
		map.put("rp01-03", "humidity");
		map.put("rp01-04", "humidity");
		map.put("rp01-05", "carbon-dioxide");
		map.put("rp01-06", "carbon-dioxide");
		map.put("rp01-07", "ph-level");
		map.put("rp01-08", "ph-level");
		map.put("rp01-09", "water");
		map.put("rp01-10", "water");
		map.put("rp01-11", "heat-index");
		map.put("rp01-12", "heat-index");

		map.put("rp02-01", "temperature");
		map.put("rp02-02", "temperature");
		map.put("rp02-03", "humidity");
		map.put("rp02-04", "humidity");
		map.put("rp02-05", "carbon-dioxide");
		map.put("rp02-06", "carbon-dioxide");
		map.put("rp02-07", "ph-level");
		map.put("rp02-08", "ph-level");
		map.put("rp02-09", "water");
		map.put("rp02-10", "water");
		map.put("rp02-11", "heat-index");
		map.put("rp02-12", "heat-index");

		map.put("a01-01", "temperature");
		map.put("a01-02", "temperature");
		map.put("a01-03", "humidity");
		map.put("a01-04", "humidity");
		map.put("a01-05", "carbon-dioxide");
		map.put("a01-06", "carbon-dioxide");
		map.put("a01-07", "ph-level");
		map.put("a01-08", "ph-level");
		map.put("a01-09", "water");
		map.put("a01-10", "water");
		map.put("a01-11", "heat-index");
		map.put("a01-12", "heat-index");

		return map;
	}

}
