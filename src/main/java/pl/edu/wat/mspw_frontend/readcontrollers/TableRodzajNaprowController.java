package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.RodzajNaprowService;
import pl.edu.wat.mspw_frontend.model.RodzajNaprowDto;

import java.util.List;

public class TableRodzajNaprowController extends AbstractTableController<RodzajNaprowDto, RodzajNaprowService> {

    @Override
    protected void initializeService() {
        this.service = new RodzajNaprowService();
    }

    @Override
    protected List<RodzajNaprowDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<RodzajNaprowDto> getGenericTypeClass() {
        return RodzajNaprowDto.class;
    }
}

