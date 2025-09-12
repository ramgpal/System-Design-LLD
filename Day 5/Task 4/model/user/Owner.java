package model.user;

public class Owner extends User {
    private String countryName;
    private String cityName;
    
    // constructor
    public Owner(String name, int userId, String countryName, String cityName) {
        super(name, userId);
        this.cityName = cityName;
        this.countryName = countryName;
    }
}
