package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.util.MainDao;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericService<E, D> {
    private MainDao mainDao;
    private Class<E> entityType;
    private Function<E, D> entityToDtoMapper;
    private Function<D, E> dtoToEntityMapper;

    public GenericService(Class<E> entityType,
                          Function<E, D> entityToDtoMapper,
                          Function<D, E> dtoToEntityMapper) {
        this.mainDao = MainDao.getInstance();
        this.entityType = entityType;
        this.entityToDtoMapper = entityToDtoMapper;
        this.dtoToEntityMapper = dtoToEntityMapper;
    }

    public void create(D dto) {
        E entity = dtoToEntityMapper.apply(dto);
        mainDao.createRecord(entity);
    }

    public void delete(Long id) {
        mainDao.deleteByID(entityType, Math.toIntExact(id));
    }

    public List<D> getAll() {
        return mainDao.readAllRecords(entityType).stream()
                .map(entityToDtoMapper)
                .collect(Collectors.toList());
    }

}

