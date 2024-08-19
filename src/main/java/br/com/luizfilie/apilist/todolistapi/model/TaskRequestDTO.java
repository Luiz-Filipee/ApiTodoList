package br.com.luizfilie.apilist.todolistapi.model;

public record TaskRequestDTO(
        String name,
        Integer amount,
        Double value
) {
}
