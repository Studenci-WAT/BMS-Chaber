package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.SpwSysOgnEntity;
import pl.edu.wat.mspw_frontend.model.SpwSysOgnDto;

public class SpwSysOgnService extends GenericService<SpwSysOgnEntity, SpwSysOgnDto> {
    public SpwSysOgnService() {
        super(SpwSysOgnEntity.class,
                e -> new SpwSysOgnDto(e.getId(), e.getLiczba(), e.getSpwFk(), e.getSystemOgnFk()),
                d -> new SpwSysOgnEntity(d.getId(), d.getLiczba(), d.getSpwFk(), d.getSystemOgnFk())
        );
    }
}
