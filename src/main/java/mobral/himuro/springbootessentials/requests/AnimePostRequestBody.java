package mobral.himuro.springbootessentials.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "The anime cannot be empty")
    private String name;
}
