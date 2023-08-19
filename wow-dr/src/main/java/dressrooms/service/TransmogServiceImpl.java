package dressrooms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dressrooms.model.Classe;
import dressrooms.model.Transmog;
import dressrooms.repository.TransmogRepository;

@Service
public class TransmogServiceImpl implements ITransmogService {

    @Autowired
    private TransmogRepository repoTransmogs;

    public Transmog mostrarConjunto(int id) {
        Transmog t = null;
        Optional<Transmog> transmog = repoTransmogs.findById(id);
        if (transmog.isPresent()) {
            t = transmog.get();
        }
        return t;
    }

    public List<Transmog> buscarPorNombre(String nombre) {
        List<Transmog> transmogs = repoTransmogs.findByNombreContainingIgnoreCase(nombre);
        return transmogs;
    }

    public Integer obtenerImagenPersonajePorClase(Classe c) {
        return c.getId();
    }

    public List<Transmog> buscarNuevos() {
        List<Transmog> transmogs = repoTransmogs.findAll(Sort.by("fecha"));
        return transmogs;
    }

}
