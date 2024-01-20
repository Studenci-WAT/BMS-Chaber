package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.RodzajPodwoziaService;
import pl.edu.wat.mspw_frontend.model.RodzajPodwoziaDto;

import java.util.List;

public class TableRodzajPodwoziaController extends AbstractTableController<RodzajPodwoziaDto, RodzajPodwoziaService> {

    @Override
    protected void initializeService() {
        this.service = new RodzajPodwoziaService();
    }

    @Override
    protected List<RodzajPodwoziaDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<RodzajPodwoziaDto> getGenericTypeClass() {
        return RodzajPodwoziaDto.class;
    }
}

