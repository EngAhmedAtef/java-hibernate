package hibernate.mapper;

import hibernate.dtos.InstructorCourseStudentsDTO;
import hibernate.entities.Instructor;

public class InstructorCourseStudentsMapper implements Mapper<Instructor, InstructorCourseStudentsDTO> {
    @Override
    public InstructorCourseStudentsDTO mapToDTO(Instructor entity) {
        return new InstructorCourseStudentsDTO(entity);
    }

    @Override
    public Instructor mapToEntity(InstructorCourseStudentsDTO dto) {
        return null;
    }
}
