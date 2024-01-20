package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.PrzebijalPancRhaService;
import pl.edu.wat.mspw_frontend.model.PrzebijalPancRhaDto;

import java.util.List;

public class TablePrzebijalPancRhaController extends AbstractTableController<PrzebijalPancRhaDto, PrzebijalPancRhaService> {

    @Override
    protected void initializeService() {
        this.service = new PrzebijalPancRhaService();
    }

    @Override
    protected List<PrzebijalPancRhaDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<PrzebijalPancRhaDto> getGenericTypeClass() {
        return PrzebijalPancRhaDto.class;
    }
}

