package dressrooms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dressrooms.model.Transmog;
import dressrooms.repository.TransmogRepository;

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
        for (Transmog t : transmogs) {
            System.out.println(t);
        }
        return transmogs;
    }

}
