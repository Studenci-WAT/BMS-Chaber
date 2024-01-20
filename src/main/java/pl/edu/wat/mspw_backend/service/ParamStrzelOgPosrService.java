package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.ParamStrzelOgPosrEntity;
import pl.edu.wat.mspw_frontend.model.ParamStrzelOgPosrDto;

public class ParamStrzelOgPosrService extends GenericService<ParamStrzelOgPosrEntity, ParamStrzelOgPosrDto> {
    public ParamStrzelOgPosrService() {
        super(ParamStrzelOgPosrEntity.class,
                e -> new ParamStrzelOgPosrDto(e.getId(), e.getAmoFk(), e.getSystemOgnFk(), e.getOdleg(),
                        e.getUchylSzer(), e.getUchylGleb()),
                d -> new ParamStrzelOgPosrEntity(d.getId(), d.getAmoFk(), d.getSystemOgnFk(), d.getOdleg(),
                        d.getUchylSzer(), d.getUchylGleb())
        );
    }
}
