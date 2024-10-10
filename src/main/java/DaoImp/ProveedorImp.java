package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProveedor;
import model.Tblproveedor;




public class ProveedorImp implements IProveedor{

	public void RegistrarProo(Tblproveedor pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		try{
		em.getTransaction().begin();
		em.persist(pro);
		em.getTransaction().commit();
		}catch(RuntimeException e){
			e.getMessage();
		}finally{
		em.close();
		}
		
	}

	public void ActualizarProo(Tblproveedor pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		try{
	
		em.getTransaction().begin();
		em.merge(pro);
		em.getTransaction().commit();
		}catch(RuntimeException e){
			e.getMessage();
		}finally{
		em.close();
		}
		
	}

	public void EliminarProo(Tblproveedor pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		try{
		em.getTransaction().begin();
		Tblproveedor tbpro=em.find(Tblproveedor.class,pro.getIdprooveedorcl2());
		if(tbpro!=null){
			em.remove(tbpro);
			em.getTransaction().commit();		
		}//fin de la condicion...
		}catch(RuntimeException e){
			if(em.getTransaction().isActive()) em.getTransaction().rollback();
			e.getMessage();
		}finally {
			em.close();
		}
		
	}

	public List<Tblproveedor> ListarProo() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		List<Tblproveedor>listado = null;
		
		try {
			em.getTransaction().begin();
			listado=em.createQuery("select p from Tblproveedor  p",Tblproveedor.class).getResultList();
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

	public Tblproveedor BuscarProo(Tblproveedor pro) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_CL2_SALINASCONQUICARLOS");
		EntityManager em=emf.createEntityManager();
		Tblproveedor busca=null;
		
		try {
			//inciamos la transaccion
			em.getTransaction().begin();
			//buscamos por codigo 
			busca = em.find(Tblproveedor.class,pro.getIdprooveedorcl2());
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
		
		
		return busca;
	}

}
