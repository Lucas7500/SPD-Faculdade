package DAO;

import entities.Usuario;

import java.util.List;

public class UsuarioDAO extends BaseDAO {

    public List<Usuario> obterTodos() {
        return super.obterTodos(Usuario.class, Usuario.class.getName());
    }

    public Usuario obterPorId(Long id) {
        return super.obterPorId(Usuario.class, id);
    }

    public void criar(Usuario usuario) {
        super.criar(usuario);
    }

    public void deletar(Long id) {
        super.deletar(Usuario.class, id);
    }
}
