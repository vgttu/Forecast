import com.weather.FileHandler;
import com.weather.WeatherRequest;
import com.weather.reports.CurrentWeatherReport;
import com.weather.repositories.CurrentWeatherRepository;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
class CurrentWeatherRepositoryTest {
    @Test
    void checkCurrentWeatherResponse() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", "EE", "metric");

            CurrentWeatherRepository.mock();
            CurrentWeatherRepository repository = new CurrentWeatherRepository();

            CurrentWeatherReport report = repository.getCurrentWeather(request);

            assertEquals(request.getCity(), report.getCity());
            assertEquals(request.getCode(), report.getCode());
            assertNotNull(report.getCurrentTemperature());
            assertNotNull(report.getMaximumTemperature());
            assertNotNull(report.getMinimalTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}