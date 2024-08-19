package br.com.luizfilie.apilist.todolistapi.model;

public record UserResponseDTO(
        Long id,
        String name,
        String password
) {
    public UserResponseDTO(User user){
        this(
                user.getId(),
                user.getName(),
                user.getPassword()
        );
    }
}
