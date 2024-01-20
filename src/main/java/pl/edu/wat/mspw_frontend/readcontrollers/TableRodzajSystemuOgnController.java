package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.RodzajSystemuOgnService;
import pl.edu.wat.mspw_frontend.model.RodzajSystemuOgnDto;

import java.util.List;

public class TableRodzajSystemuOgnController extends AbstractTableController<RodzajSystemuOgnDto, RodzajSystemuOgnService> {

    @Override
    protected void initializeService() {
        this.service = new RodzajSystemuOgnService();
    }

    @Override
    protected List<RodzajSystemuOgnDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<RodzajSystemuOgnDto> getGenericTypeClass() {
        return RodzajSystemuOgnDto.class;
    }
}

