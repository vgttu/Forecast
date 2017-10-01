import com.weather.WeatherRequest;
import com.weather.reports.CurrentWeatherReport;
import com.weather.reports.ThreeDayWeatherReport;
import com.weather.repositories.ThreeDayWeatherRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 */
class ThreeDayWeatherRepositoryTest {
    @Test
    void checkThreeDayWeatherResponse() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", "EE", "metric");
            ThreeDayWeatherRepository repository = new ThreeDayWeatherRepository();

            ThreeDayWeatherReport report = repository.getThreeDayWeather(request);

            fail("Not implimented");
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}