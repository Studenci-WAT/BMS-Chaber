package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.SprzetWojService;
import pl.edu.wat.mspw_frontend.model.SprzetWojDto;

import java.util.List;

public class TableSprzetWojController extends AbstractTableController<SprzetWojDto, SprzetWojService> {

    @Override
    protected void initializeService() {
        this.service = new SprzetWojService();
    }

    @Override
    protected List<SprzetWojDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<SprzetWojDto> getGenericTypeClass() {
        return SprzetWojDto.class;
    }
}

