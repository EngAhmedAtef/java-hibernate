package hibernate.mapper;

import hibernate.dtos.InstructorDTO;
import hibernate.entities.Instructor;

public class InstructorMapper implements Mapper<Instructor, InstructorDTO> {
    @Override
    public InstructorDTO mapToDTO(Instructor entity) {
        return new InstructorDTO(entity);
    }

    @Override
    public Instructor mapToEntity(InstructorDTO dto) {
        return new Instructor(dto);
    }
}
