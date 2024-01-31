package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.AmoEntity;
import pl.edu.wat.mspw_frontend.model.AmoDto;

public class AmoService extends GenericService<AmoEntity, AmoDto> {
    public AmoService() {
        super(AmoEntity.class,
                e -> new AmoDto(e.getId(), e.getNazwa(), e.getSkrot(), e.getKod(),
                        e.getKaliber(), e.getSztukWPaczce(), e.getMasaSztuki(),
                        e.getWymPaczkiX(), e.getWymPaczkiY(), e.getWymPaczkiZ(),
                        e.getKategFk(), e.getRodzajGlowicyBojFk(),
                        e.getRodzajGlowicyNaprowFk(), e.getRodzajNaprowFk()),
                d -> new AmoEntity(d.getId(), d.getNazwa(), d.getSkrot(), d.getKod(),
                        d.getKaliber(), d.getSztukWPaczce(), d.getMasaSztuki(),
                        d.getWymPaczkiX(), d.getWymPaczkiY(), d.getWymPaczkiZ(),
                        d.getKategFk(), d.getRodzajGlowicyBojFk(),
                        d.getRodzajGlowicyNaprowFk(), d.getRodzajNaprowFk())
        );
    }
}


