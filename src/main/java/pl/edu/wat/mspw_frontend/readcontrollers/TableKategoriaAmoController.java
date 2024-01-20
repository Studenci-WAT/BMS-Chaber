package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.KategoriaAmoService;
import pl.edu.wat.mspw_frontend.model.KategoriaAmoDto;

import java.util.List;

public class TableKategoriaAmoController extends AbstractTableController<KategoriaAmoDto, KategoriaAmoService> {

    @Override
    protected void initializeService() {
        this.service = new KategoriaAmoService();
    }

    @Override
    protected List<KategoriaAmoDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<KategoriaAmoDto> getGenericTypeClass() {
        return KategoriaAmoDto.class;
    }
}

