package com.taskly.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data 
public class UserCreationRequest {
    @Size (min = 3, message = "Username must be at least 3 characters long")
    private String username;
    private String firstName;
    private String lastName;
    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must contain uppercase, lowercase, number, and special character"
    )
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    @Min(value = 18, message = "Age must be at least 18")
    private int age;
    
    
}
