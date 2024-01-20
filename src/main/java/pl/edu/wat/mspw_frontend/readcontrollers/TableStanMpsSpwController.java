package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.StanMpsSpwService;
import pl.edu.wat.mspw_frontend.model.StanMpsSpwDto;

import java.util.List;

public class TableStanMpsSpwController extends AbstractTableController<StanMpsSpwDto, StanMpsSpwService> {

    @Override
    protected void initializeService() {
        this.service = new StanMpsSpwService();
    }

    @Override
    protected List<StanMpsSpwDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<StanMpsSpwDto> getGenericTypeClass() {
        return StanMpsSpwDto.class;
    }
}

