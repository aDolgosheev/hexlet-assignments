package exercise.dto;

// BEGIN

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class GuestCreateDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Column(unique = true)
    @Pattern(regexp = "\\+[0-9]{11,13}")
    private String phoneNumber;

    @Pattern(regexp = "\\d{4}")
    private String clubCard;

    @Future
    private LocalDate cardValidUntil;
}

// END
