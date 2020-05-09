package example.micronaut;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

import javax.validation.ConstraintViolationException;

@Controller
public class NameController {

    private final NameTransformer transformer;

    public NameController(NameTransformer transformer) { // <1>
        this.transformer = transformer;
    }

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public HttpResponse<String> index(@QueryValue @Nullable String name) {
        try {
            return HttpResponse.ok(transformer.transform(name));
        } catch(ConstraintViolationException e){
            return HttpResponse.badRequest("The supplied name must be not blank");
        }
    }
}
