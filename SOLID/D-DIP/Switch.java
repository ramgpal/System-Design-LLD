public class Switch {
    private Device device;

    public Switch(Device device) {
        this.device = device;
    }

    public void operate(String command) {
        if (command.equals("ON")) {
            device.TurnOn();
        } else if (command.equals("OFF")) {
            device.TurnOff();
        }

    }
}
