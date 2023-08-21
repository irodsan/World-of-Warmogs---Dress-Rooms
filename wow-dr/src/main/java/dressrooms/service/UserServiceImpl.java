package dressrooms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dressrooms.model.User;
import dressrooms.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repoUsers;

    public String obtenerUsuarioPorId(Integer id) {
        String userName = "";
        Optional<User> user = repoUsers.findById(id);
        if (user.isPresent()) {
            userName = user.get().getAlias();
        }
        return userName;
    }

    @Override
    public User buscarPorAlias(String alias) {
        return repoUsers.findByAlias(alias);
    }

}
