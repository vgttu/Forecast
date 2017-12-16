import com.weather.FileHandler;
import com.weather.WeatherRequest;
import com.weather.reports.CurrentWeatherReport;
import com.weather.reports.ThreeDayWeatherReport;
import com.weather.repositories.CurrentWeatherRepository;
import com.weather.repositories.ThreeDayWeatherRepository;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherRequestTest {

    @Test
    void testRequestFromFile() {
        try {
            List<WeatherRequest> requests = WeatherRequest.requestsFromFile();

            requests.forEach(request -> {
                request.setUnits("metric");

                ThreeDayWeatherRepository.mock();
                ThreeDayWeatherRepository threeDayWeatherRepository = new ThreeDayWeatherRepository();

                try {
                    ThreeDayWeatherReport report = threeDayWeatherRepository.getThreeDayWeather(request);

                    report.writeToFile();
                } catch (Exception e) {
                    fail("Failure cause: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testRequestFromConsole() {
        String data = "Tallinn,EE";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        WeatherRequest request = WeatherRequest.requestFromConsole();

        assertEquals("Tallinn", request.getCity());
        assertEquals("EE", request.getCode());
    }
}