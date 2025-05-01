import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the city you want to search for location:");
        String city = scanner.nextLine();
        scanner.close();
        String apiKey = "your_api_key";

        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            // WeatherData.java

            Gson gson = new Gson();
            WeatherData weatherData = gson.fromJson(response.toString(), WeatherData.class);

            // Access the weather data
            System.out.println("City: " + weatherData.getName());
            System.out.println("Temperature: " + weatherData.getMain().getTemp() + " K");
            System.out.println("Humidity: " + weatherData.getMain().getHumidity() + "%");
            System.out.println("Weather Description: " + weatherData.getWeather()[0].getDescription());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}