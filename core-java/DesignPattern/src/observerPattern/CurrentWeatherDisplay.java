package observerPattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentWeatherDisplay implements Observer, Display {

	private Observable observable;
	private float temperature;
	private float humidity;

	public CurrentWeatherDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	@Override
	public void displayReport() {
		System.out.println("Current conditions:" + temperature 
				+ "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(Observable obs, Object args) {
		if (obs instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)obs;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			displayReport();
		}
	}

}
