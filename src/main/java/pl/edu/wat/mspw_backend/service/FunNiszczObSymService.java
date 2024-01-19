package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunNiszczObSymEntity;
import pl.edu.wat.mspw_frontend.model.FunNiszczObSymDto;

public class FunNiszczObSymService extends GenericService<FunNiszczObSymEntity, FunNiszczObSymDto> {
    public FunNiszczObSymService() {
        super(FunNiszczObSymEntity.class,
                e -> new FunNiszczObSymDto(e.getId(), e.getSpwStrzelFk(), e.getSysOgnFk(), e.getAmoFk(),
                        e.getSpwCelFk(), e.getMobilStrzel(), e.getMobilCelu(), e.getTypTerenuWidoczFk(),
                        e.getTypKlimatuFk(), e.getPoziomOddzialOgnPkaFk(), e.getPoziomFortCelu(),
                        e.getPoziomWyszkStrzel(), e.getOdleg(), e.getIntensNiszcz(), e.getPstwoZniszcz()),
                d -> new FunNiszczObSymEntity(d.getId(), d.getSpwStrzelFk(), d.getSysOgnFk(), d.getAmoFk(),
                        d.getSpwCelFk(), d.getMobilStrzel(), d.getMobilCelu(), d.getTypTerenuWidoczFk(),
                        d.getTypKlimatuFk(), d.getPoziomOddzialOgnPkaFk(), d.getPoziomFortCelu(),
                        d.getPoziomWyszkStrzel(), d.getOdleg(), d.getIntensNiszcz(), d.getPstwoZniszcz())
        );
    }
}
