package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.MiaraZdolnosciRazeniaService;
import pl.edu.wat.mspw_frontend.model.MiaraZdolnosciRazeniaDto;

import java.util.List;

public class TableMiaraZdolnosciRazeniaController extends AbstractTableController<MiaraZdolnosciRazeniaDto, MiaraZdolnosciRazeniaService> {

    @Override
    protected void initializeService() {
        this.service = new MiaraZdolnosciRazeniaService();
    }

    @Override
    protected List<MiaraZdolnosciRazeniaDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<MiaraZdolnosciRazeniaDto> getGenericTypeClass() {
        return MiaraZdolnosciRazeniaDto.class;
    }
}

