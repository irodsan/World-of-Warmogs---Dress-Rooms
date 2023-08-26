package dressrooms.service;

import java.util.List;

import dressrooms.model.User;

public interface IUserService {

    public void guardar(User usuario);

    public void eliminar(Integer idUsuario);

    public List<User> buscarTodos();

    public String obtenerUsuarioPorId(Integer id);

    public User buscarPorAlias(String username);

}
