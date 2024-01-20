package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunPstwoZniszczOpService;
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczOpDto;

import java.util.List;

public class TableFunPstwoZniszczOpController extends AbstractTableController<FunPstwoZniszczOpDto, FunPstwoZniszczOpService> {

    @Override
    protected void initializeService() {
        this.service = new FunPstwoZniszczOpService();
    }

    @Override
    protected List<FunPstwoZniszczOpDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunPstwoZniszczOpDto> getGenericTypeClass() {
        return FunPstwoZniszczOpDto.class;
    }
}

