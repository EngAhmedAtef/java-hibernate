package hibernate.mapper;

import hibernate.dtos.InstructorDetailsDTO;
import hibernate.entities.InstructorDetails;

public class InstructorDetailsMapper implements Mapper<InstructorDetails, InstructorDetailsDTO> {
    @Override
    public InstructorDetailsDTO mapToDTO(InstructorDetails entity) {
        return new InstructorDetailsDTO(entity);
    }

    @Override
    public InstructorDetails mapToEntity(InstructorDetailsDTO dto) {
        return new InstructorDetails(dto);
    }
}
