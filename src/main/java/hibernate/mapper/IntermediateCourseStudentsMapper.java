package hibernate.mapper;

import hibernate.dtos.IntermediateCourseStudentsDTO;
import hibernate.entities.Course;

public class IntermediateCourseStudentsMapper implements Mapper<Course, IntermediateCourseStudentsDTO> {
    @Override
    public IntermediateCourseStudentsDTO mapToDTO(Course entity) {
        return new IntermediateCourseStudentsDTO(entity);
    }

    @Override
    public Course mapToEntity(IntermediateCourseStudentsDTO dto) {
        return null;
    }
}
