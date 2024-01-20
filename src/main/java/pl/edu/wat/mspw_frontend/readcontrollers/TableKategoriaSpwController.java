package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.KategoriaSpwService;
import pl.edu.wat.mspw_frontend.model.KategoriaSpwDto;

import java.util.List;

public class TableKategoriaSpwController extends AbstractTableController<KategoriaSpwDto, KategoriaSpwService> {

    @Override
    protected void initializeService() {
        this.service = new KategoriaSpwService();
    }

    @Override
    protected List<KategoriaSpwDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<KategoriaSpwDto> getGenericTypeClass() {
        return KategoriaSpwDto.class;
    }
}

