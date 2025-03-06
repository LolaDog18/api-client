import com.woozy.AuthenticationRequestDto;
import com.woozy.car_rentals.clients.implementation.AuthRestAssuredClientImpl;
import com.woozy.car_rentals.clients.interfaces.AuthenticationClient;
import com.woozy.car_rentals.response.ClientResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RestAssuredTest {

    @BeforeEach
    void setup() {
        System.setProperty("baseUri", "http://localhost:8080");
        System.setProperty("basePath", "/api/v1");
    }

    @Test
    void testAuthEndpoint() {
        AuthenticationClient authenticationClient = new AuthRestAssuredClientImpl();
        ClientResponse response = authenticationClient.authenticateCustomer(new AuthenticationRequestDto("andrew73@gmail.com", "1qaz"));

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
}
