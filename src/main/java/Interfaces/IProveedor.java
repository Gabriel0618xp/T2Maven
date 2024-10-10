package Interfaces;

import java.util.List;

import model.Tblproveedor;;

public interface IProveedor {
	void RegistrarProo(Tblproveedor pro);
	void ActualizarProo(Tblproveedor pro);
	void EliminarProo(Tblproveedor pro);
	List<Tblproveedor> ListarProo();
	Tblproveedor BuscarProo(Tblproveedor pro);
	
}
