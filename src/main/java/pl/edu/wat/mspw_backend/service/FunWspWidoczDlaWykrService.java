package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunWspWidoczDlaWykrEntity;
import pl.edu.wat.mspw_frontend.model.FunWspWidoczDlaWykrDto;

public class FunWspWidoczDlaWykrService extends GenericService<FunWspWidoczDlaWykrEntity, FunWspWidoczDlaWykrDto> {
    public FunWspWidoczDlaWykrService() {
        super(FunWspWidoczDlaWykrEntity.class,
                e -> new FunWspWidoczDlaWykrDto(e.getId(), e.getWsp(), e.getTypTerenuWidoczFk(),
                        e.getPoziomZadymIstotny(), e.getPoziomZamglIstotny(), e.getPoziomOpadIstotny(),
                        e.getPoziomMaskIstotny(), e.getDzien(), e.getPoziomWyszk(), e.getPoziomFort(),
                        e.getTypPrzyrzadowOcFk()),
                d -> new FunWspWidoczDlaWykrEntity(d.getId(), d.getWsp(), d.getTypTerenuWidoczFk(),
                        d.getPoziomZadymIstotny(), d.getPoziomZamglIstotny(), d.getPoziomOpadIstotny(),
                        d.getPoziomMaskIstotny(), d.getDzien(), d.getPoziomWyszk(), d.getPoziomFort(),
                        d.getTypPrzyrzadowOcFk())
        );
    }
}
