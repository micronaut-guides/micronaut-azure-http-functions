package example.micronaut;

import edu.umd.cs.findbugs.annotations.NonNull;
import io.micronaut.core.util.StringUtils;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;

@Singleton
public class CapitalizeNameTransformer implements NameTransformer {
    @NonNull
    @Override
    public String transform(@NonNull @NotBlank String name) {
        return StringUtils.capitalize(name);
    }
}
