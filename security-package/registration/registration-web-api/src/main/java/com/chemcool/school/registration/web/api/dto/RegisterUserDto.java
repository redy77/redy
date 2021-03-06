package com.chemcool.school.registration.web.api.dto;

import com.chemcool.school.registration.annotations.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    private LocalDate birthday;

    @NotBlank
    private String gender;

    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @ValidPassword
    private String password;
}
