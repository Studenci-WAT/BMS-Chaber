package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunWspMobilDlaStrzelEntity;
import pl.edu.wat.mspw_frontend.model.FunWspMobilDlaStrzelDto;

public class FunWspMobilDlaStrzelService extends GenericService<FunWspMobilDlaStrzelEntity, FunWspMobilDlaStrzelDto> {
    public FunWspMobilDlaStrzelService() {
        super(FunWspMobilDlaStrzelEntity.class,
                e -> new FunWspMobilDlaStrzelDto(e.getId(), e.getWsp(), e.getMobilCeluIstotna(),
                        e.getMobilStrzelIstotna(), e.getPoziomWyszk(), e.getPoziomZdolnManewr()),
                d -> new FunWspMobilDlaStrzelEntity(d.getId(), d.getWsp(), d.getMobilCeluIstotna(),
                        d.getMobilStrzelIstotna(), d.getPoziomWyszk(), d.getPoziomZdolnManewr())
        );
    }
}
