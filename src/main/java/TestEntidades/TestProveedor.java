package TestEntidades;

import java.util.Date;

import DaoImp.ProveedorImp;
import model.Tblproveedor;

public class TestProveedor {

	public static void main(String[] args) {
		
	
		Tblproveedor tblpro = new Tblproveedor();
		ProveedorImp proimp = new ProveedorImp();
		Date fecha= new Date();
		Date fechasql = new Date(fecha.getTime());
		/*-------------Registrar-----------*/
		tblpro.setNomproveecl2("carlos");
		tblpro.setRucproveecl2("2312");
		tblpro.setRsocialproveecl2("no se");
		tblpro.setEmailproveecl2("carlos@gmial");
		tblpro.setFeingproveecl2(fechasql);
		proimp.RegistrarProo(tblpro);
		System.out.println("dato registrado en BD...");

		/*-------------Actualizar-----------*/
		tblpro.setIdprooveedorcl2(1);
		tblpro.setNomproveecl2("carlos");
		tblpro.setRucproveecl2("2312");
		tblpro.setRsocialproveecl2("no se");
		tblpro.setEmailproveecl2("carlos@gmial");
		tblpro.setFeingproveecl2(fechasql);
		proimp.ActualizarProo(tblpro);
		System.out.println("dato actualizado en BD...");

		
		/*-------------Eliminar-----------*/
		
		
		
		/*-------------Listar-----------*/
		
		
		
		
		/*--------------------BUSCAR CLIENTE--------------*/
		
	}

}
