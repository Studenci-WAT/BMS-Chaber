package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.StrefaRazeniaSpwService;
import pl.edu.wat.mspw_frontend.model.StrefaRazeniaSpwDto;

import java.util.List;

public class TableStrefaRazeniaSpwController extends AbstractTableController<StrefaRazeniaSpwDto, StrefaRazeniaSpwService> {

    @Override
    protected void initializeService() {
        this.service = new StrefaRazeniaSpwService();
    }

    @Override
    protected List<StrefaRazeniaSpwDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<StrefaRazeniaSpwDto> getGenericTypeClass() {
        return StrefaRazeniaSpwDto.class;
    }
}

