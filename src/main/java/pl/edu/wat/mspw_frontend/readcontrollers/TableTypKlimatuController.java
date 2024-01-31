package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.TypKlimatuService;
import pl.edu.wat.mspw_frontend.model.TypKlimatuDto;

import java.util.List;

public class TableTypKlimatuController extends AbstractTableController<TypKlimatuDto, TypKlimatuService> {

    @Override
    protected void initializeService() {
        this.service = new TypKlimatuService();
    }

    @Override
    protected List<TypKlimatuDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<TypKlimatuDto> getGenericTypeClass() {
        return TypKlimatuDto.class;
    }
}

