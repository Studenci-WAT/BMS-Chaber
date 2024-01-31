package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunWspWidoczDlaStrzelEntity;
import pl.edu.wat.mspw_frontend.model.FunWspWidoczDlaStrzelDto;

public class FunWspWidoczDlaStrzelService extends GenericService<FunWspWidoczDlaStrzelEntity, FunWspWidoczDlaStrzelDto> {
    public FunWspWidoczDlaStrzelService() {
        super(FunWspWidoczDlaStrzelEntity.class,
                e -> new FunWspWidoczDlaStrzelDto(e.getId(), e.getTypPrzyrzadowOcFk(), e.getWsp(),
                        e.getPoziomZadymIstotny(), e.getPoziomZamglIstotny(), e.getPoziomOpadIstotny(),
                        e.getPoziomMaskIstotny(), e.getDzien(), e.getPoziomWyszk(), e.getPoziomFort()),
                d -> new FunWspWidoczDlaStrzelEntity(d.getId(), d.getTypPrzyrzadowOcFk(), d.getWsp(),
                        d.getPoziomZadymIstotny(), d.getPoziomZamglIstotny(), d.getPoziomOpadIstotny(),
                        d.getPoziomMaskIstotny(), d.getDzien(), d.getPoziomWyszk(), d.getPoziomFort())
        );
    }
}
