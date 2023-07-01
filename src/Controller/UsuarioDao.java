package Controller;

import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private PreparedStatement preparedStatement;
    private ResultSet rs;

    private final String QUERY_INSERT = "INSERT INTO usuario (nome, login, senha, email, perfil) VALUES (?, ?, md5(?), ?, ?);";
    private final String QUERY_UPDATE = "UPDATE usuario SET nome = ?, login = ?, senha = ?, email = ?, perfil = ? WHERE id = ?";
    private final String QUERY_UPDATE_AND_ENCRIPT_PASSWORD = "UPDATE usuario SET nome = ?, login = ?, senha = md5(?), email = ?, perfil = ? WHERE id = ?";
    private final String QUERY_DELETE = "DELETE FROM usuario WHERE id = ?";
    private final String QUERY_SELECT_BY_NAME = "SELECT * FROM usuario WHERE nome LIKE ?";
    private final String QUERY_SELECT_ALL = "SELECT * FROM usuario";

    private final String QUERY_LOGIN = "SELECT * FROM usuario WHERE login = ? AND senha = md5(?)";

    public boolean insert(Usuario usuario) {
        try {
            Conexao.conectar();
            preparedStatement = Conexao.conectar().prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setString(5, usuario.getPerfil());

            preparedStatement.execute();

            Conexao.desconectar(Conexao.conectar());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Usuario usuario, Boolean passwordAlreadyChanged) {
        try {
            Conexao.conectar();

            if (passwordAlreadyChanged) {
                preparedStatement = Conexao.conectar().prepareStatement(QUERY_UPDATE_AND_ENCRIPT_PASSWORD);
            } else {
                preparedStatement = Conexao.conectar().prepareStatement(QUERY_UPDATE);

            }

            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getLogin());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setString(5, usuario.getPerfil());
            preparedStatement.setInt(6, usuario.getId());

            preparedStatement.executeUpdate();

            Conexao.desconectar(Conexao.conectar());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Usuario> select() {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Usuario usuario;

        try {
            Conexao.conectar();
            preparedStatement = Conexao.conectar().prepareStatement(QUERY_SELECT_ALL);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPerfil(rs.getString("perfil"));

                listaUsuarios.add(usuario);
            }
            Conexao.desconectar(Conexao.conectar());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public List<Usuario> selectByName(String name) {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        Usuario usuario;

        try {
            Conexao.conectar();
            preparedStatement = Conexao.conectar().prepareStatement(QUERY_SELECT_BY_NAME);
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPerfil(rs.getString("perfil"));

                listaUsuarios.add(usuario);
            }
            Conexao.desconectar(Conexao.conectar());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public boolean delete(Integer id) {
        try {
            preparedStatement = Conexao.conectar().prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            Conexao.desconectar(Conexao.conectar());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Usuario login(String login, String password) {
        Usuario usuario = new Usuario();
        try {
            preparedStatement = Conexao.conectar().prepareStatement(QUERY_LOGIN);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPerfil(rs.getString("perfil"));

            }
            Conexao.desconectar(Conexao.conectar());
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
