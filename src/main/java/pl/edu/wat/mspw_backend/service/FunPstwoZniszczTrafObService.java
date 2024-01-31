package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunPstwoZniszczTrafObEntity;
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczTrafObDto;

public class FunPstwoZniszczTrafObService extends GenericService<FunPstwoZniszczTrafObEntity, FunPstwoZniszczTrafObDto> {
    public FunPstwoZniszczTrafObService() {
        super(FunPstwoZniszczTrafObEntity.class,
                e -> new FunPstwoZniszczTrafObDto(e.getId(), e.getSysOgnFk(), e.getAmoFk(),
                        e.getSpwCelFk(), e.getOdleg(), e.getPstwo()),
                d -> new FunPstwoZniszczTrafObEntity(d.getId(), d.getSysOgnFk(), d.getAmoFk(),
                        d.getSpwCelFk(), d.getOdleg(), d.getPstwo())
        );
    }
}
