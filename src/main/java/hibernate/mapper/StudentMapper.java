package hibernate.mapper;

import hibernate.dtos.StudentDTO;
import hibernate.entities.Student;

public class StudentMapper implements Mapper<Student, StudentDTO> {
    @Override
    public StudentDTO mapToDTO(Student entity) {
        return new StudentDTO(entity);
    }

    @Override
    public Student mapToEntity(StudentDTO dto) {
        return new Student(dto);
    }
}
