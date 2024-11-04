package datadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import seleniumlearnings.HandlingDatePickerCalender;

public class HandlingPropertiesFile {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\testdata\\testdata.properties");
		Properties properties = new Properties();
		properties.load(file);
		
		String firstName = properties.getProperty("first_name");
		String lastName = properties.getProperty("last_name","default");
		boolean containsLastName =properties.contains(lastName);
		properties.containsKey("last_name");
		properties.containsValue(lastName);
		properties.get("first_name");
		properties.getOrDefault("first_name", "default");
		boolean isEmpty=properties.isEmpty();
		Set<Object> keys=properties.keySet();
		for(Object key:keys) {
			System.out.println(key.toString());
		}
		properties.put("actor_name", "Kanu reves");
		HashMap<String,String> months;
			months = new HashMap<String,String>();
			months.put("January", "1");
			months.put("February", "2");
			months.put("March", "3");
			months.put("April", "4");
		properties.putAll(months);
		properties.remove("December");
		properties.replace("actor_name", "Keanu reeves");
		
		FileOutputStream output= new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\testdata.properties");
		properties.store(output, "description of properties");
		System.out.println(firstName+" "+lastName+ " "+containsLastName+ " " +isEmpty);
		
	}

}
