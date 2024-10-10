package Interfaces;

import java.util.List;

import model.Tblusuario;

public interface IUsuario {

	void RegistrarUsuario(Tblusuario usu);
	void ActualizarUsuario(Tblusuario usu);
	void EliminarUsuario(Tblusuario usu);
	List<Tblusuario> ListarUsuario();
	Tblusuario BuscarUsuario(Tblusuario usu);
	
}
