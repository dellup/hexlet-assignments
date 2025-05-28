package exercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
public class GuestCreateDTO {
    private long id;

    @NotNull
    private String name;
    @Email
    private String email;
    @Pattern(regexp = "^\\+\\d{11,13}$")
    private String phoneNumber;
    @Pattern(regexp = "^\\d{4}")
    private String clubCard;
    @FutureOrPresent
    private LocalDate cardValidUntil;
}
