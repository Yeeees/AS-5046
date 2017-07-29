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
import restclient.Users;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
/**
 *
 * @author YLY
 */
@Stateless
@Path("restclient.users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "PainDiaryPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Users entity) {
         System.out.print("%%#$%#$%@$%@#$%@#$%@#"+entity.toString());
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Users entity) {
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
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
@Path("Users.findByUserId/{userId}")
@Produces({"application/json"})
public List<Users> findByUserId(@PathParam("userId") int userId) {
Query query = em.createNamedQuery("Users.findByUserId");
query.setParameter("userId", userId);
return query.getResultList();    
}

@GET
@Path("Users.findByUserFname/{userFname}")
@Produces({"application/json"})
public List<Users> findByUserFname(@PathParam("userFname") String userFname) {
Query query = em.createNamedQuery("Users.findByUserFname");
query.setParameter("userFname", userFname);
return query.getResultList();    
}

@GET
@Path("Users.findByUserLname/{userLname}")
@Produces({"application/json"})
public List<Users> findByUserLname(@PathParam("userLname") String userLname) {
Query query = em.createNamedQuery("Users.findByUserLname");
query.setParameter("userLname", userLname);
return query.getResultList();    
}

@GET
@Path("Users.findByUserDob/{userDob}")
@Produces({"application/json"})
public List<Users> findByUserDob(@PathParam("userDob") String userDob) {
Query query = em.createNamedQuery("Users.findByUserDob"); 
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try{
java.util.Date datetemp = sdf.parse(userDob);
query.setParameter("userDob", datetemp,TemporalType.DATE);
}catch(Exception e){
System.out.println(e);
}
return query.getResultList();
}

@GET
@Path("Users.findByUserHeight/{userHeight}")
@Produces({"application/json"})
public List<Users> findByUserHeight(@PathParam("userHeight") int userHeight) {
Query query = em.createNamedQuery("Users.findByUserHeight");
query.setParameter("userHeight", userHeight);
return query.getResultList();    
}

@GET
@Path("Users.findByUserWeight/{userWeight}")
@Produces({"application/json"})
public List<Users> findByUserWeight(@PathParam("userWeight") int userWeight) {
Query query = em.createNamedQuery("Users.findByUserWeight");
query.setParameter("userWeight", userWeight);
return query.getResultList();    
}

@GET
@Path("Users.findByUserGender/{userGender}")
@Produces({"application/json"})
public List<Users> findByUserGender(@PathParam("userGender") String userGender) {
Query query = em.createNamedQuery("Users.findByUserGender");
query.setParameter("userGender", userGender);
return query.getResultList();    
}

@GET
@Path("Users.findByUserOccup/{userOccup}")
@Produces({"application/json"})
public List<Users> findByUserOccup(@PathParam("userOccup") String userOccup) {
Query query = em.createNamedQuery("Users.findByUserOccup");
query.setParameter("userOccup", userOccup);
return query.getResultList(); 
}
@GET
@Path("Users.findByUserAddress/{userAddress}")
@Produces({"application/json"})
public List<Users> findByUserAddress(@PathParam("userAddress") String userAddress) {
Query query = em.createNamedQuery("Users.findByUserAddress");
query.setParameter("userAddress", userAddress);
return query.getResultList(); 
}



@GET
@Path("Users.findByDocId/{docId}")
@Produces({"application/json"})
public List<Users> findByDocId(@PathParam("docId") int docId) {
Query query = em.createNamedQuery("Users.findByDocId");
query.setParameter("docId", docId);
return query.getResultList(); 
}

@GET
@Path("User.findByRegId/{regId}")
@Produces({"application/json"})
public List<Users> findByRegId(@PathParam("regId") int regId) {
TypedQuery<Users> q = em.createQuery("SELECT u FROM Users u WHERE u.regId.regId = :regId", Users.class);
q.setParameter("regId", regId);
return q.getResultList();
}

@GET
@Path("User.findByDocLnameUsername/{docLname}/{userLname}")
@Produces({"application/json"})
public List<Users> findByDocLName(@PathParam("docLname") String docLname,@PathParam("userLname")String userLname) {
TypedQuery<Users> q = em.createQuery("SELECT u FROM Users u WHERE u.docId.docLname = :docLname AND u.userLname = :userLname", Users.class);
q.setParameter("docLname", docLname);
q.setParameter("userLname", userLname);
return q.getResultList();
}

@GET
@Path("Users.findByUserLnameANDDocLname/{userLname}/{docLname}")
@Produces({"application/json"})
public List<Users> findByUserLnameANDDocLname(@PathParam("userLname")String userLname, @PathParam("docLname") String docLname) {
Query query = em.createNamedQuery("Users.findByUserLnameANDDocLname");
query.setParameter("userLname", userLname);
query.setParameter("docLname", docLname);
return query.getResultList();
}
}

