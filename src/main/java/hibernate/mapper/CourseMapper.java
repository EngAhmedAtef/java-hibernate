package hibernate.mapper;

import hibernate.dtos.CourseDTO;
import hibernate.entities.Course;

public class CourseMapper implements Mapper<Course, CourseDTO> {
    @Override
    public CourseDTO mapToDTO(Course entity) {
        return new CourseDTO(entity);
    }

    @Override
    public Course mapToEntity(CourseDTO dto) {
        return new Course(dto);
    }
}
