package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.PrzebijalPancRhaEntity;
import pl.edu.wat.mspw_frontend.model.PrzebijalPancRhaDto;

public class PrzebijalPancRhaService extends GenericService<PrzebijalPancRhaEntity, PrzebijalPancRhaDto> {
    public PrzebijalPancRhaService() {
        super(PrzebijalPancRhaEntity.class,
                e -> new PrzebijalPancRhaDto(e.getId(), e.getAmoFk(), e.getPredkPocisku(), e.getPrzebijalPocisku()),
                d -> new PrzebijalPancRhaEntity(d.getId(), d.getAmoFk(), d.getPredkPocisku(), d.getPrzebijalPocisku())
        );
    }
}
