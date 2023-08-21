package dressrooms.service;

import dressrooms.model.User;

public interface IUserService {

    public String obtenerUsuarioPorId(Integer id);

    User buscarPorAlias(String username);

}
