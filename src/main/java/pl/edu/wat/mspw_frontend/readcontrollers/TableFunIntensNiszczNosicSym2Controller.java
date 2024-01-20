package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.FunIntensNiszczNosicSym2Service;
import pl.edu.wat.mspw_frontend.model.FunIntensNiszczNosicSym2Dto;

import java.util.List;

public class TableFunIntensNiszczNosicSym2Controller extends AbstractTableController<FunIntensNiszczNosicSym2Dto, FunIntensNiszczNosicSym2Service> {

    @Override
    protected void initializeService() {
        this.service = new FunIntensNiszczNosicSym2Service();
    }

    @Override
    protected List<FunIntensNiszczNosicSym2Dto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunIntensNiszczNosicSym2Dto> getGenericTypeClass() {
        return FunIntensNiszczNosicSym2Dto.class;
    }
}

