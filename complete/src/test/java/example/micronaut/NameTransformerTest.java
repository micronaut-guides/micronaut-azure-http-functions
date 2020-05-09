package example.micronaut;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTransformerTest {

    @Test
    public void nameConstraints() throws Exception {
        try (Function function = new Function()) {
            NameTransformer nameTransformer = function.getApplicationContext().getBean(NameTransformer.class);
            Executable e = () -> nameTransformer.transform(null);
            ConstraintViolationException thrown = assertThrows(ConstraintViolationException.class, e);
            e = () -> nameTransformer.transform("");
            thrown = assertThrows(ConstraintViolationException.class, e);
        }
    }
}
