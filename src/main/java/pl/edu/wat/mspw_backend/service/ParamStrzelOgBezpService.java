package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.ParamStrzelOgBezpEntity;
import pl.edu.wat.mspw_frontend.model.ParamStrzelOgBezpDto;

public class ParamStrzelOgBezpService extends GenericService<ParamStrzelOgBezpEntity, ParamStrzelOgBezpDto> {
    public ParamStrzelOgBezpService() {
        super(ParamStrzelOgBezpEntity.class,
                e -> new ParamStrzelOgBezpDto(e.getId(), e.getAmoFk(), e.getSystemOgnFk(), e.getOdleg(),
                        e.getPredkPocisku(), e.getUchylSzer(), e.getUchylWys(), e.getWysok()),
                d -> new ParamStrzelOgBezpEntity(d.getId(), d.getAmoFk(), d.getSystemOgnFk(), d.getOdleg(),
                        d.getPredkPocisku(), d.getUchylSzer(), d.getUchylWys(), d.getWysok())
        );
    }
}
