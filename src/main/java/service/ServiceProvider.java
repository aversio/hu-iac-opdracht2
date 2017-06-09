package service;

public class ServiceProvider {
	private static CityService cityService = new CityService();

	public static CityService getCityService() {
		return cityService;
	}
}