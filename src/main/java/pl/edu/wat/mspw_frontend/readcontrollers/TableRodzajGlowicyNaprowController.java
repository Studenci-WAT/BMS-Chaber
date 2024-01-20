package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.RodzajGlowicyNaprowService;
import pl.edu.wat.mspw_frontend.model.RodzajGlowicyNaprowDto;

import java.util.List;

public class TableRodzajGlowicyNaprowController extends AbstractTableController<RodzajGlowicyNaprowDto, RodzajGlowicyNaprowService> {

    @Override
    protected void initializeService() {
        this.service = new RodzajGlowicyNaprowService();
    }

    @Override
    protected List<RodzajGlowicyNaprowDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<RodzajGlowicyNaprowDto> getGenericTypeClass() {
        return RodzajGlowicyNaprowDto.class;
    }
}

