package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class WeatherForcast implements Observer, Display{

	private Observable subject;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherForcast(Observable obs) {
		this.subject = obs;
		obs.addObserver(this);
	}
	@Override
	public void displayReport() {
		System.out.println("Current conditions:" + temperature 
				+ "F degrees and " + humidity + "% humidity"+" pressure: "+pressure);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData) {
			this.temperature = ((WeatherData) o).getTemperature();
			this.humidity = ((WeatherData) o).getHumidity();
			this.pressure = ((WeatherData) o).getPressure();
		}
	}

}
