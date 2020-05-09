package example.micronaut;
import com.microsoft.azure.functions.HttpStatus;
import io.micronaut.azure.function.http.HttpRequestMessageBuilder;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.uri.UriBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameControllerTest {

    @Test
    public void testNameSupplied() throws Exception {
        String url = UriBuilder.of("/").queryParam("name", "sergio").build().toString();

        try (Function function = new Function()) {
            HttpRequestMessageBuilder.AzureHttpResponseMessage response =
                function.request(HttpMethod.GET, url)
                        .invoke();
            assertEquals(HttpStatus.OK, response.getStatus());
            assertEquals("Sergio", response.getBodyAsString());
        }
    }

    @Test
    public void testNoNameParamSupplied() throws Exception {
        String url = UriBuilder.of("/").build().toString();

        try (Function function = new Function()) {
            HttpRequestMessageBuilder.AzureHttpResponseMessage response =
                    function.request(HttpMethod.GET, url)
                            .invoke();
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatus());
            assertEquals("The supplied name must be not blank", response.getBodyAsString());
        }
    }
}
