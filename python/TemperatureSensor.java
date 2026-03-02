package Technolog.python;

import java.util.ArrayList;

/**
 * Represente un capteur de temperature.
 */
public class TemperatureSensor 
{
	private String name;
	private float temperature;
	private ArrayList<WeatherStation> weatherStations;
	
	public TemperatureSensor(String name)
	{
		this.name = name;
		this.weatherStations = new ArrayList<WeatherStation>();
	}
	
	public float getTemperature()
	{
		return temperature;
	}
	
	public void setTemperature(float temperature)
	{
		this.temperature = temperature;
		for (WeatherStation ws : weatherStations) 
			ws.displayTemperature(name, temperature);
	}
	
	public void addWeatherStation(WeatherStation ws)
	{
		weatherStations.add(ws);
	}
}