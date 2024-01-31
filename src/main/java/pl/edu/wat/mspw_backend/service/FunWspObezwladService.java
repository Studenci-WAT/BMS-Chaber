package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunWspObezwladEntity;
import pl.edu.wat.mspw_frontend.model.FunWspObezwladDto;

public class FunWspObezwladService extends GenericService<FunWspObezwladEntity, FunWspObezwladDto> {
    public FunWspObezwladService() {
        super(FunWspObezwladEntity.class,
                e -> new FunWspObezwladDto(e.getId(), e.getPoziomOddzialOgnFk(), e.getWsp(),
                        e.getStrzelOpanc(), e.getPoziomWyszk()),
                d -> new FunWspObezwladEntity(d.getId(), d.getPoziomOddzialOgnFk(), d.getWsp(),
                        d.getStrzelOpanc(), d.getPoziomWyszk())
        );
    }
}
