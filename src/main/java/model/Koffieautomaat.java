package model;

import java.util.Comparator;

public class Koffieautomaat implements Comparable<Koffieautomaat> {
	private String code;
	private String brand;
	private String model;
	private double price;

	public Koffieautomaat(String code, String brand, String model, double price) {
		this.code = code;
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public static final Comparator<Koffieautomaat> ASCENDING_PRICE = new Comparator<Koffieautomaat>() {
		public int compare(Koffieautomaat k, Koffieautomaat k1) {
			return (int) (k1.getPrice() - k.getPrice());
		}
	};

	public int compareTo(Koffieautomaat p) {
		return (this.brand).compareTo(p.brand);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
