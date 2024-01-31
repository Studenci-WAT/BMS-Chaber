package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunWspUkryciaEntity;
import pl.edu.wat.mspw_frontend.model.FunWspUkryciaDto;

public class FunWspUkryciaService extends GenericService<FunWspUkryciaEntity, FunWspUkryciaDto> {
    public FunWspUkryciaService() {
        super(FunWspUkryciaEntity.class,
                e -> new FunWspUkryciaDto(e.getId(), e.getTypTerenuWidoczFk(), e.getWsp(), e.getPoziomFort()),
                d -> new FunWspUkryciaEntity(d.getId(), d.getTypTerenuWidoczFk(), d.getWsp(), d.getPoziomFort())
        );
    }
}
