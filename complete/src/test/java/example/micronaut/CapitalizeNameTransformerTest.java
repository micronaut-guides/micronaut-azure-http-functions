package example.micronaut;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CapitalizeNameTransformerTest {

    @Test
    public void testCapitalize() throws Exception {
        try (Function function = new Function()) {
            NameTransformer nameTransformer = function.getApplicationContext().getBean(CapitalizeNameTransformer.class);
            String result = nameTransformer.transform("sergio");
            assertEquals("Sergio", result);
        }
    }
}