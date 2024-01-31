package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.KadlubService;
import pl.edu.wat.mspw_frontend.model.KadlubDto;

import java.util.List;

public class TableKadlubController extends AbstractTableController<KadlubDto, KadlubService> {

    @Override
    protected void initializeService() {
        this.service = new KadlubService();
    }

    @Override
    protected List<KadlubDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<KadlubDto> getGenericTypeClass() {
        return KadlubDto.class;
    }
}

