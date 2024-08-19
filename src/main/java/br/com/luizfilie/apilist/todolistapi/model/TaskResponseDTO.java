package br.com.luizfilie.apilist.todolistapi.model;

public record TaskResponseDTO(
        Long id,
        String name,
        Integer amount,
        Double value
) {
    public TaskResponseDTO(Task task){
        this(
                task.getId(),
                task.getName(),
                task.getAmount(),
                task.getValue()
       );
    }
}
