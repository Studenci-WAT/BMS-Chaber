package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.FunIntensNiszczNosicSymService;
import pl.edu.wat.mspw_frontend.model.FunIntensNiszczNosicSymDto;

import java.util.List;

public class TableFunIntensNiszczNosicSymController extends AbstractTableController<FunIntensNiszczNosicSymDto, FunIntensNiszczNosicSymService> {

    @Override
    protected void initializeService() {
        this.service = new FunIntensNiszczNosicSymService();
    }

    @Override
    protected List<FunIntensNiszczNosicSymDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunIntensNiszczNosicSymDto> getGenericTypeClass() {
        return FunIntensNiszczNosicSymDto.class;
    }
}

