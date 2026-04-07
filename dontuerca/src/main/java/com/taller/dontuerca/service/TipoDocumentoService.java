package com.taller.dontuerca.service;

import com.taller.dontuerca.entity.TipoDocumento;
import com.taller.dontuerca.repository.TipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TipoDocumentoService {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    public List<TipoDocumento> obtenerTodos() {
        return tipoDocumentoRepository.findAll();
    }

    public TipoDocumento crearTipoDocumento(TipoDocumento tipo) {
        return tipoDocumentoRepository.save(tipo);
    }

    public void eliminarTipoDocumento(Integer id) {
        if (!tipoDocumentoRepository.existsById(id))
            throw new RuntimeException("Tipo de documento no encontrado");
        tipoDocumentoRepository.deleteById(id);
    }
}