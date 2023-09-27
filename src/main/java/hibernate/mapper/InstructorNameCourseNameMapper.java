package hibernate.mapper;

import hibernate.dtos.InstructorNameCoursesNamesDTO;
import hibernate.entities.Instructor;

public class InstructorNameCourseNameMapper implements Mapper<Instructor, InstructorNameCoursesNamesDTO> {
    @Override
    public InstructorNameCoursesNamesDTO mapToDTO(Instructor entity) {
        return new InstructorNameCoursesNamesDTO(entity);
    }

    @Override
    public Instructor mapToEntity(InstructorNameCoursesNamesDTO dto) {
        return null;
    }
}
