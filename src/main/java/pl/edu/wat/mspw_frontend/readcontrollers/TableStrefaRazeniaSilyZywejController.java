package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.StrefaRazeniaSilyZywejService;
import pl.edu.wat.mspw_frontend.model.StrefaRazeniaSilyZywejDto;

import java.util.List;

public class TableStrefaRazeniaSilyZywejController extends AbstractTableController<StrefaRazeniaSilyZywejDto, StrefaRazeniaSilyZywejService> {

    @Override
    protected void initializeService() {
        this.service = new StrefaRazeniaSilyZywejService();
    }

    @Override
    protected List<StrefaRazeniaSilyZywejDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<StrefaRazeniaSilyZywejDto> getGenericTypeClass() {
        return StrefaRazeniaSilyZywejDto.class;
    }
}

