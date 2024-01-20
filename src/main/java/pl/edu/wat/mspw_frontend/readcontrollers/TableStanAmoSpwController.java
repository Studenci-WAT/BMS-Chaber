package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.StanAmoSpwService;
import pl.edu.wat.mspw_frontend.model.StanAmoSpwDto;

import java.util.List;

public class TableStanAmoSpwController extends AbstractTableController<StanAmoSpwDto, StanAmoSpwService> {

    @Override
    protected void initializeService() {
        this.service = new StanAmoSpwService();
    }

    @Override
    protected List<StanAmoSpwDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<StanAmoSpwDto> getGenericTypeClass() {
        return StanAmoSpwDto.class;
    }
}

