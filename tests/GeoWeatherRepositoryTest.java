import com.weather.WeatherRequest;
import com.weather.reports.GeoWeatherReport;
import com.weather.repositories.GeoWeatherRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Vladimir Gaidushin on 01.10.2017.
 * Junity Development, LLC.
 */
class GeoWeatherRepositoryTest {
    @Test
    void checkGeoWeatherResponse() {
        try {
            WeatherRequest request = new WeatherRequest(50.0, 100.0, "metric");

            GeoWeatherRepository.mock();
            GeoWeatherRepository repository = new GeoWeatherRepository();

            GeoWeatherReport report = repository.getGeoWeather(request);

            assertEquals(request.getLatitude(), report.getLatitude());
            assertEquals(request.getLongtitude(), report.getLongtitude());
            assertNotNull(report.getCurrentTemperature());
            assertNotNull(report.getMaximumTemperature());
            assertNotNull(report.getMinimalTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}