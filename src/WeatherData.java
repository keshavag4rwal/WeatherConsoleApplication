// WeatherData.java
public class WeatherData {
    private String name;
    private Main main;
    private Weather[] weather;  // Change here

    // Constructors, getters, and setters

    public static class Main {
        private double temp;
        private int humidity;

        // Constructors, getters, and setters

        // Getter for the 'temp' field
        public double getTemp() {
            return temp;
        }

        // Getter for the 'humidity' field
        public int getHumidity() {
            return humidity;
        }
    }

    public static class Weather {
        private String description;

        // Constructors, getters, and setters

        // Getter for the 'description' field
        public String getDescription() {
            return description;
        }
    }

    // Getter for the 'name' field
    public String getName() {
        return name;
    }

    // Getter for the 'main' field
    public Main getMain() {
        return main;
    }

    // Getter for the 'weather' field
    public Weather[] getWeather() {
        return weather;
    }

    // Additional getters and setters
}

