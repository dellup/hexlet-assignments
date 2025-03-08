package exercise.dto.posts;

import java.util.List;
import java.util.Map;

import exercise.dto.BasePage;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class BuildPostPage extends BasePage {
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;

    public BuildPostPage(String name, String body, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.body = body;
        this.errors = errors;
    }

    public BuildPostPage() {
    }
}
