package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.TypTerenuWidoczService;
import pl.edu.wat.mspw_frontend.model.TypTerenuWidoczDto;

import java.util.List;

public class TableTypTerenuWidoczController extends AbstractTableController<TypTerenuWidoczDto, TypTerenuWidoczService> {

    @Override
    protected void initializeService() {
        this.service = new TypTerenuWidoczService();
    }

    @Override
    protected List<TypTerenuWidoczDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<TypTerenuWidoczDto> getGenericTypeClass() {
        return TypTerenuWidoczDto.class;
    }
}

