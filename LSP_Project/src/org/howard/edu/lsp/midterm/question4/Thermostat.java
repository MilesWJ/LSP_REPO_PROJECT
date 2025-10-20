package org.howard.edu.lsp.midterm.question4;

public class Thermostat extends Device implements Networked {
  private double temperature_c;

  public Thermostat(String id, String location, double initialTempC) {
    super(id, location);
    this.temperature_c = initialTempC;
  }

  public double getTemperatureC() { return temperature_c; }

  public void setTemperatureC(double temperatureC) { this.temperature_c = temperatureC; }

  @Override
  public void connect() { setConnected(true); }

  @Override
  public void disconnect() { setConnected(false); }

  @Override
  public boolean isConnected() { return super.isConnected(); }

  @Override
  public String getStatus() {
    String conn_status = isConnected() ? "up" : "down";
    return "Thermostat[id=" + getId() + ", loc=" + getLocation() +
           ", conn=" + conn_status + ", tempC=" + temperature_c + "]";
  }
}
