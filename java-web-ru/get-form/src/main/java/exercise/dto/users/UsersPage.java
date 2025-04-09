package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@Getter
public class UsersPage {
    private List<User> users;
    private String term;

    public UsersPage(List<User> users, String term) {
        this.users = users;
        this.term = term;
    }
}
// END
