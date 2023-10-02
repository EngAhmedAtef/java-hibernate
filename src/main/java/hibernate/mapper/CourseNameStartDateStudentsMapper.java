package hibernate.mapper;

import hibernate.dtos.CourseNameStartDateStudentsDTO;
import hibernate.entities.Course;

public class CourseNameStartDateStudentsMapper implements Mapper<Course, CourseNameStartDateStudentsDTO> {
    @Override
    public CourseNameStartDateStudentsDTO mapToDTO(Course entity) {
        return new CourseNameStartDateStudentsDTO(entity);
    }

    @Override
    public Course mapToEntity(CourseNameStartDateStudentsDTO dto) {
        return null;
    }
}
