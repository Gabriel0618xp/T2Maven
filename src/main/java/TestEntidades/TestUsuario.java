package TestEntidades;

import java.util.List;

import DaoImp.UsuarioImp;
import model.Tblusuario;

public class TestUsuario {

	public static void main(String[] args) {
		UsuarioImp usuimp = new UsuarioImp();
		Tblusuario tblusu = new Tblusuario();
		/*-------------Registrar-----------*/
		/*tblusu.setUsuariocl2("Lucho");
		tblusu.setPasswordcl2("324");
		usuimp.RegistrarUsuario(tblusu);
		System.out.println("dato registrado en BD...");
        */
		
		/*-------------Actualizar-----------*/
		/*tblusu.setIdusuariocl2(1);
		tblusu.setUsuariocl2("gabriel");
		tblusu.setPasswordcl2("123");
		usuimp.ActualizarUsuario(tblusu);
		System.out.println("dato actualizado en BD...");
		*/
		
		/*-------------Eliminar-----------*/
		
		/*tblusu.setIdusuariocl2(1);
		usuimp.EliminarUsuario(tblusu);
		System.out.println("dato Eliminado en BD...");
		*/
		
		/*-------------Listar-----------*/
		
		/*List<Tblusuario>listado =usuimp.ListarUsuario();
		//aplicamos un bucle
		for(Tblusuario lis:listado){
			//imprimir por pantalla
			System.out.println(" Usuario: " +lis.getUsuariocl2() + " Password: "+lis.getPasswordcl2()
								);
		}//fin for
		*/
		
		/*--------------------BUSCAR CLIENTE--------------*/
	
		tblusu.setIdusuariocl2(2);
		Tblusuario buscar = usuimp.BuscarUsuario(tblusu);
		//imprimir por pantalla
		System.out.println(" Usuario: " +buscar.getUsuariocl2() + " Password: "+buscar.getPasswordcl2());
		
		
		
	}

}
