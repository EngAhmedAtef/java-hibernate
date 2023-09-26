package hibernate.mapper;

public interface Mapper<E, D> {
    D mapToDTO(E entity);
    E mapToEntity(D dto);
}
