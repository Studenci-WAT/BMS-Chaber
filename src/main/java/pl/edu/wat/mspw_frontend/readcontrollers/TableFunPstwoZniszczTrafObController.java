package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunPstwoZniszczTrafObService;
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczTrafObDto;

import java.util.List;

public class TableFunPstwoZniszczTrafObController extends AbstractTableController<FunPstwoZniszczTrafObDto, FunPstwoZniszczTrafObService> {

    @Override
    protected void initializeService() {
        this.service = new FunPstwoZniszczTrafObService();
    }

    @Override
    protected List<FunPstwoZniszczTrafObDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunPstwoZniszczTrafObDto> getGenericTypeClass() {
        return FunPstwoZniszczTrafObDto.class;
    }
}

