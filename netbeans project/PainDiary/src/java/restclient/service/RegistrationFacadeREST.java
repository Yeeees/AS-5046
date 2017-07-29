/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
  import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restclient.Registration;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

/**
 *
 * @author YLY
 */
@Stateless
@Path("restclient.registration")
public class RegistrationFacadeREST extends AbstractFacade<Registration> {

    @PersistenceContext(unitName = "PainDiaryPU")
    private EntityManager em;

    public RegistrationFacadeREST() {
        super(Registration.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Registration entity) {
        
        //entity.setUsersCollection(usersCollection);
       //System.out.println(entity.);
//       Registration reg = new Registration();
//       reg.setRegId(entity.getRegId());
//       reg.setUsername(entity.getUsername());
//       reg.setPasswd(entity.getPasswd());
//       reg.setRegDate(entity.getRegDate());
//       reg.setRegTime(entity.getRegTime());
       
       try{ super.create(entity);}catch(Exception e){
       System.out.println(e);}
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Registration entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Registration find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Registration> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Registration> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
@Path("Registration.findByRegId/{regId}")
@Produces({"application/json"})
public List<Registration> findByRegId(@PathParam("regId") int regId) {
Query query = em.createNamedQuery("Registration.findByRegId");
query.setParameter("regId", regId);
return query.getResultList();
}

@GET
@Path("Registration.findByUsername/{username}")
@Produces({"application/json"})
public List<Registration> findByUserName(@PathParam("username") String username) {
Query query = em.createNamedQuery("Registration.findByUsername");
query.setParameter("username", username);
return query.getResultList();
}

@GET
@Path("Registration.findByPasswd/{passwd}")
@Produces({"application/json"})
public List<Registration> findByPasswd(@PathParam("passwd") String passwd) {
Query query = em.createNamedQuery("Registration.findByPasswd");
query.setParameter("passwd", passwd);
return query.getResultList();
    
}

@GET
@Path("Registration.findByRegDate/{regDate}")
@Produces({"application/json"})
public List<Registration> findByRegDate(@PathParam("regDate") String regDate) {
Query query = em.createNamedQuery("Registration.findByRegDate");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try{
java.util.Date datetemp = sdf.parse(regDate);
query.setParameter("regDate", datetemp,TemporalType.DATE);
}catch(Exception e){
System.out.println(e);
}
return query.getResultList();
    
}

@GET
@Path("Registration.findByRegTime/{regTime}")
@Produces({"application/json"})
public List<Registration> findByRegTime(@PathParam("regTime") String regTime) {
Query query = em.createNamedQuery("Registration.findByRegTime");
SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
try{
java.util.Date datetemp = sdf.parse(regTime);
query.setParameter("regTime", datetemp,TemporalType.TIME);
}catch(Exception e){
System.out.println(e);
}
return query.getResultList();
}
    
@GET
@Path("Registration.findNextId")
@Produces(MediaType.TEXT_PLAIN)
public String findNextId() {

  int num = em.createQuery("SELECT max(regId) FROM Registration",Integer.class).getSingleResult();
   String result= Integer.toString(num);
return result;
}


}
