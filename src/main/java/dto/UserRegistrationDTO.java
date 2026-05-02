package dto;

public record UserRegistrationDTO(String username, String password, String confirmPassword, String email) {
    public UserRegistrationDTO {
    }
}
