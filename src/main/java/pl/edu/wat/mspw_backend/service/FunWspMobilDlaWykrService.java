package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunWspMobilDlaWykrEntity;
import pl.edu.wat.mspw_frontend.model.FunWspMobilDlaWykrDto;

public class FunWspMobilDlaWykrService extends GenericService<FunWspMobilDlaWykrEntity, FunWspMobilDlaWykrDto> {
    public FunWspMobilDlaWykrService() {
        super(FunWspMobilDlaWykrEntity.class,
                e -> new FunWspMobilDlaWykrDto(e.getId(), e.getWsp(), e.getMobilCeluIstotna(),
                        e.getMobilStrzelIstotna(), e.getPoziomWyszk()),
                d -> new FunWspMobilDlaWykrEntity(d.getId(), d.getWsp(), d.getMobilCeluIstotna(),
                        d.getMobilStrzelIstotna(), d.getPoziomWyszk())
        );
    }
}
