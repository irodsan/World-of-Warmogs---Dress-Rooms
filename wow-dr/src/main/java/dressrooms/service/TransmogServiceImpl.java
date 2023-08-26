package dressrooms.service;

import java.util.ArrayList;
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
    private TransmogRepository transmogRepository;

    public Transmog mostrarConjunto(int id) {
        Transmog t = null;
        Optional<Transmog> transmog = transmogRepository.findById(id);
        if (transmog.isPresent()) {
            t = transmog.get();
        }
        return t;
    }

    public List<Transmog> buscarPorNombre(String nombre) {
        List<Transmog> transmogs = transmogRepository.findByNombreContainingIgnoreCase(nombre);
        return transmogs;
    }

    public Integer obtenerImagenPersonajePorClase(Classe c) {
        return c.getId();
    }

    public List<Transmog> buscarNuevos() {
        List<Transmog> transmogs = transmogRepository.findAll(Sort.by("fecha"));
        return transmogs;
    }

    public void eliminarTransmogs(List<Transmog> transmogs) {
        transmogRepository.deleteAll(transmogs);
    }

    public List<Transmog> buscarTransmogsPorIdUsuario(Integer id) {
        List<Transmog> allTransmogs = transmogRepository.findAll();
        List<Transmog> userTransmogs = new ArrayList<>();
        for (var t : allTransmogs) {
            if (t.getId_usuario() == id) {
                userTransmogs.add(t);
            }
        }
        return userTransmogs;
    }

}
