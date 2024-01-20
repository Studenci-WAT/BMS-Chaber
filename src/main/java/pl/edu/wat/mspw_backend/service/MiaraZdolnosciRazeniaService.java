package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.MiaraZdolnosciRazeniaEntity;
import pl.edu.wat.mspw_frontend.model.MiaraZdolnosciRazeniaDto;

public class MiaraZdolnosciRazeniaService extends GenericService<MiaraZdolnosciRazeniaEntity, MiaraZdolnosciRazeniaDto> {
    public MiaraZdolnosciRazeniaService() {
        super(MiaraZdolnosciRazeniaEntity.class,
                e -> new MiaraZdolnosciRazeniaDto(e.getId(), e.getNosicielZdolnFk(),
                        e.getZdolnRazPancOpancZasiegBliski(), e.getZdolnRazSrodkOgnZasiegBliski(),
                        e.getZdolnRazSilyZywejZasiegBliski(), e.getZdolnRazPancOpancZasiegSredni(),
                        e.getZdolnRazSrodkOgnZasiegSredni(), e.getZdolnRazSilyZywejZasiegSredni()),
                d -> new MiaraZdolnosciRazeniaEntity(d.getId(), d.getNosicielZdolnFk(),
                        d.getZdolnRazPancOpancZasiegBliski(), d.getZdolnRazSrodkOgnZasiegBliski(),
                        d.getZdolnRazSilyZywejZasiegBliski(), d.getZdolnRazPancOpancZasiegSredni(),
                        d.getZdolnRazSrodkOgnZasiegSredni(), d.getZdolnRazSilyZywejZasiegSredni())
        );
    }
}
