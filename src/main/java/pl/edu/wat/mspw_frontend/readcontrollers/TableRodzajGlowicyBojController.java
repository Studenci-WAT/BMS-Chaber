package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.RodzajGlowicyBojService;
import pl.edu.wat.mspw_frontend.model.RodzajGlowicyBojDto;

import java.util.List;

public class TableRodzajGlowicyBojController extends AbstractTableController<RodzajGlowicyBojDto, RodzajGlowicyBojService> {

    @Override
    protected void initializeService() {
        this.service = new RodzajGlowicyBojService();
    }

    @Override
    protected List<RodzajGlowicyBojDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<RodzajGlowicyBojDto> getGenericTypeClass() {
        return RodzajGlowicyBojDto.class;
    }
}

