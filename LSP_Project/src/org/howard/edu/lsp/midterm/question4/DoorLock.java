package org.howard.edu.lsp.midterm.question4;

public class DoorLock extends Device implements Networked, BatteryPowered {
  private int battery_percent;

  public DoorLock(String id, String location, int initialBattery) {
    super(id, location);
    setBatteryPercent(initialBattery);
  }

  @Override
  public void connect() { setConnected(true); }

  @Override
  public void disconnect() { setConnected(false); }

  @Override
  public boolean isConnected() { return super.isConnected(); }

  @Override
  public int getBatteryPercent() { return battery_percent; }

  @Override
  public void setBatteryPercent(int percent) {
    if (percent < 0 || percent > 100) {
      throw new IllegalArgumentException("battery 0..100");
    }
    this.battery_percent = percent;
  }

  @Override
  public String getStatus() {
    final String conn_status = isConnected() ? "up" : "down";
    return "DoorLock[id=" + getId() + ", loc=" + getLocation() +
           ", conn=" + conn_status + ", batt=" + battery_percent + "%]";
  }
}
