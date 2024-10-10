package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IUsuario;
import model.Tblusuario;

public class UsuarioImp implements IUsuario{

	public void RegistrarUsuario(Tblusuario usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		try{
		em.getTransaction().begin();
		em.persist(usu);
		em.getTransaction().commit();
		}catch(RuntimeException e){
			e.getMessage();
		}finally{
		em.close();
		}
		
	}

	public void ActualizarUsuario(Tblusuario usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		try{
	
		em.getTransaction().begin();
		em.merge(usu);
		em.getTransaction().commit();
		}catch(RuntimeException e){
			e.getMessage();
		}finally{
		em.close();
		}
		
	}

	public void EliminarUsuario(Tblusuario usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		try{
		em.getTransaction().begin();
		Tblusuario tbusu=em.find(Tblusuario.class,usu.getIdusuariocl2());
		if(tbusu!=null){
			em.remove(tbusu);
			em.getTransaction().commit();		
		}//fin de la condicion...
		}catch(RuntimeException e){
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			e.getMessage();
		}finally {
			em.close();
		}
		
	}

	public List<Tblusuario> ListarUsuario() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		List<Tblusuario>listado = null;
		
		try {
			em.getTransaction().begin();
			listado=em.createQuery("select u from Tblusuario u",Tblusuario.class).getResultList();
			em.getTransaction().commit();
			
		} catch (RuntimeException e) {
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			e.getMessage();
		}
		finally {
			//cerramos
			em.close();
		}
		//retornamos el listado de cliente de la base de datos
		return listado;
	}

	public Tblusuario BuscarUsuario(Tblusuario usu) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		Tblusuario buscusu=null;
		
		try {
			//inciamos la transaccion
			em.getTransaction().begin();
			//buscamos por codigo 
			buscusu = em.find(Tblusuario.class,usu.getIdusuariocl2());
			//Confirmamos
			em.getTransaction().commit();
			
		} catch (RuntimeException e) {
			//aplicamos una condicion
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			
			//emitimos mensaje
			e.getMessage();
		}
		finally {
			//cerramos
			em.close();
		}
		
		
		return buscusu;
	}

}
