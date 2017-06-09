package service;

import model.Koffieautomaat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class CityService {
	private List<Koffieautomaat> alleKoffieautomaten = new ArrayList<Koffieautomaat>();
	
	public CityService() {
		alleKoffieautomaten.add(new Koffieautomaat("A1", "Siemens", "04BE ZE", 633.5));
		alleKoffieautomaten.add(new Koffieautomaat("B2", "Bosch", "0DE 5E", 733.5));
		alleKoffieautomaten.add(new Koffieautomaat("C3A", "Nivona", "DE ZE", 333.5));
		alleKoffieautomaten.add(new Koffieautomaat("D4", "Jura", "04BE ZE", 433.5));
		alleKoffieautomaten.add(new Koffieautomaat("E5", "Krups", "04BE ZE", 433.5));
		alleKoffieautomaten.add(new Koffieautomaat("F6", "Siemens", "04BE ZE", 433.5));
		alleKoffieautomaten.add(new Koffieautomaat("G7", "Siemens", "04BE ZE", 433.5));
		alleKoffieautomaten.add(new Koffieautomaat("H8", "Philips", "04BE ZE", 833.5));
		alleKoffieautomaten.add(new Koffieautomaat("I9", "Siemens", "04BE ZE", 433.5));
		alleKoffieautomaten.add(new Koffieautomaat("A2", "Siemens", "04BE ZE", 433.5));
	}
	
	public List<Koffieautomaat> getAlleKoffieautomaten() {
		return alleKoffieautomaten;
	}
	
	public Koffieautomaat getKoffieByCode(String code) {
		Koffieautomaat result = null;
		
		for (Koffieautomaat c : alleKoffieautomaten) {
			if (c.getCode().equals(code)) {
				result = c;
				break;
			}
		}
		
		return result;
	}
}
