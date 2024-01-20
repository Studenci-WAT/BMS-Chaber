package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.FunNiszczObSymService;
import pl.edu.wat.mspw_frontend.model.FunNiszczObSymDto;

import java.util.List;

public class TableFunNiszczObSymController extends AbstractTableController<FunNiszczObSymDto, FunNiszczObSymService> {

    @Override
    protected void initializeService() {
        this.service = new FunNiszczObSymService();
    }

    @Override
    protected List<FunNiszczObSymDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunNiszczObSymDto> getGenericTypeClass() {
        return FunNiszczObSymDto.class;
    }
}

