import com.woozy.AuthenticationRequestDto;
import com.woozy.car_rentals.clients.AuthenticationClient;
import com.woozy.car_rentals.clients.AuthenticationClientImpl;
import com.woozy.car_rentals.response.ClientResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RestAssuredTest {
    @Test
    void testEndpoint() {
        AuthenticationClient authenticationClient = new AuthenticationClientImpl("http://localhost:8080", "/api/v1/auth/");

        ClientResponse response = authenticationClient.authenticateCustomer(new AuthenticationRequestDto("andrew73@gmail.com", "1qaz"));

        assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }
}
