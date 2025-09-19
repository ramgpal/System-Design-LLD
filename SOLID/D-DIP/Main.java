class Main {
    public static void main(String[] args) {
        Device TubeLight = new TubeLight();
        Switch sw = new Switch(TubeLight);
        
        sw.operate("ON");
        sw.operate("OFF");
    }
}