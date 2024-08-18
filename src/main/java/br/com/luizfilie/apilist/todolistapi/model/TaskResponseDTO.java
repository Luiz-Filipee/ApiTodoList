package br.com.luizfilie.apilist.todolistapi.model;

public record TaskResponseDTO(
        Long id,
        String name,
        Double value
) {
    public TaskResponseDTO(Task task){
        this(
                task.getId(),
                task.getName(),
                task.getValue()
       );
    }
}
