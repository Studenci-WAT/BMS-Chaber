package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunIntensStrzelOpService;
import pl.edu.wat.mspw_frontend.model.FunIntensStrzelOpDto;

import java.util.List;

public class TableFunIntensStrzelOpController extends AbstractTableController<FunIntensStrzelOpDto, FunIntensStrzelOpService> {

    @Override
    protected void initializeService() {
        this.service = new FunIntensStrzelOpService();
    }

    @Override
    protected List<FunIntensStrzelOpDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunIntensStrzelOpDto> getGenericTypeClass() {
        return FunIntensStrzelOpDto.class;
    }
}

