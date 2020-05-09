package example.micronaut;

import edu.umd.cs.findbugs.annotations.NonNull;
import javax.validation.constraints.NotBlank;

public interface NameTransformer {
    @NonNull
    String transform(@NonNull @NotBlank String name);
}
