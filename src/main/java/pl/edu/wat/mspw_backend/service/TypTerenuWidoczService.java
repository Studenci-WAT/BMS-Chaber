package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.TypTerenuWidoczEntity;
import pl.edu.wat.mspw_frontend.model.TypTerenuWidoczDto;

public class TypTerenuWidoczService  extends GenericService<TypTerenuWidoczEntity, TypTerenuWidoczDto> {
    public TypTerenuWidoczService() {
        super(TypTerenuWidoczEntity.class,
                e -> new TypTerenuWidoczDto(
                        e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new TypTerenuWidoczEntity(
                        d.getId(), d.getNazwa(), d.getSkrot()
                )
        );
    }
}
