package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.KategoriaCeluRazeniaService;
import pl.edu.wat.mspw_frontend.model.KategoriaCeluRazeniaDto;

import java.util.List;

public class TableKategoriaCeluRazeniaController extends AbstractTableController<KategoriaCeluRazeniaDto, KategoriaCeluRazeniaService> {

    @Override
    protected void initializeService() {
        this.service = new KategoriaCeluRazeniaService();
    }

    @Override
    protected List<KategoriaCeluRazeniaDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<KategoriaCeluRazeniaDto> getGenericTypeClass() {
        return KategoriaCeluRazeniaDto.class;
    }
}

