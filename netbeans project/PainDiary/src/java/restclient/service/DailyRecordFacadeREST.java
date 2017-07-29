/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import restclient.DailyRecord;

/**
 *
 * @author YLY
 */
@Stateless
@Path("restclient.dailyrecord")
public class DailyRecordFacadeREST extends AbstractFacade<DailyRecord> {

    @PersistenceContext(unitName = "PainDiaryPU")
    private EntityManager em;

    public DailyRecordFacadeREST() {
        super(DailyRecord.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DailyRecord entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, DailyRecord entity) {
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
    public DailyRecord find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DailyRecord> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DailyRecord> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
@Path("DailyRecord.findByRegId/{recId}")
@Produces({"application/json"})
public List<DailyRecord> findByRecId(@PathParam("recId") int recId) {
Query query = em.createNamedQuery("DailyRecord.findByRecId");
query.setParameter("recId", recId);
return query.getResultList();
}

 @GET
@Path("DailyRecord.findByRecDate/{recDate}")
@Produces({"application/json"})
public List<DailyRecord> findByRecDate(@PathParam("recDate") String recDate) {
Query query = em.createNamedQuery("DailyRecord.findByRecDate");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try{
java.util.Date datetemp = sdf.parse(recDate);
query.setParameter("recDate", datetemp,TemporalType.DATE);
}catch(Exception e){
System.out.println(e);
}
return query.getResultList();
}

@GET
@Path("DailyRecord.findByRecTime/{recTime}")
@Produces({"application/json"})
public List<DailyRecord> findByRecTime(@PathParam("recTime") String recTime) {
Query query = em.createNamedQuery("DailyRecord.findByRecTime");
SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
try{
java.util.Date datetemp = sdf.parse(recTime);
query.setParameter("recTime", datetemp,TemporalType.TIME);
}catch(Exception e){
System.out.println(e);
}
return query.getResultList();
}

@GET
@Path("DailyRecord.findByPainLvl/{painLvl}")
@Produces({"application/json"})
public List<DailyRecord> findByPainLvl(@PathParam("painLvl") int painLvl) {
Query query = em.createNamedQuery("DailyRecord.findByPainLvl");
query.setParameter("painLvl", painLvl);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByPainLoc/{painLoc}")
@Produces({"application/json"})
public List<DailyRecord> findByPainLoc(@PathParam("painLoc") String painLoc) {
Query query = em.createNamedQuery("DailyRecord.findByPainLoc");
query.setParameter("painLoc", painLoc);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByMoodLvl/{moodLvl}")
@Produces({"application/json"})
public List<DailyRecord> findByMoodLvl(@PathParam("moodLvl") String moodLvl) {
Query query = em.createNamedQuery("DailyRecord.findByMoodLvl");
query.setParameter("moodLvl", moodLvl);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByPainTrigger/{painTrigger}")
@Produces({"application/json"})
public List<DailyRecord> findByPainTrigger(@PathParam("painTrigger") String painTrigger) {
Query query = em.createNamedQuery("DailyRecord.findByPainTrigger");
query.setParameter("painTrigger", painTrigger);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByLatitude/{latitude}")
@Produces({"application/json"})
public List<DailyRecord> findByLatitude(@PathParam("latitude") String latitude) {
Query query = em.createNamedQuery("DailyRecord.findByLatitude");
query.setParameter("latitude", latitude);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByLongitude/{longitude}")
@Produces({"application/json"})
public List<DailyRecord> findByLongitude(@PathParam("longitude") String longitude) {
Query query = em.createNamedQuery("DailyRecord.findByLongitude");
query.setParameter("longitude", longitude);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByClimaticTemp/{climaticTemp}")
@Produces({"application/json"})
public List<DailyRecord> findByClimaticTemp(@PathParam("climaticTemp") String climaticTemp) {
Query query = em.createNamedQuery("DailyRecord.findByClimaticTemp");
query.setParameter("climaticTemp", climaticTemp);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByClimaticHumidity/{climaticHumidity}")
@Produces({"application/json"})
public List<DailyRecord> findByClimaticHumidity(@PathParam("climaticHumidity") String climaticHumidity) {
Query query = em.createNamedQuery("DailyRecord.findByClimaticHumidity");
query.setParameter("climaticHumidity", climaticHumidity);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByClimaticWindsp/{climaticWindsp}")
@Produces({"application/json"})
public List<DailyRecord> findByClimaticWindsp(@PathParam("climaticWindsp") String climaticWindsp) {
Query query = em.createNamedQuery("DailyRecord.findByClimaticWindsp");
query.setParameter("climaticWindsp", climaticWindsp);
return query.getResultList();
}

@GET
@Path("DailyRecord.findByClimaticPress/{climaticPress}")
@Produces({"application/json"})
public List<DailyRecord> findByClimaticPress(@PathParam("climaticPress") String climaticPress) {
Query query = em.createNamedQuery("DailyRecord.findByClimaticPress");
query.setParameter("climaticPress", climaticPress);
return query.getResultList();
}

// 3a
@GET
@Path("DailyRecord.DateAndWeather/{StartingDate}/{EndingDate}/{WeatherVariable}")
@Produces({"application/json"})
public List<WeatherV> findByDateANDWeather(@PathParam("StartingDate") String StartingDate,@PathParam("EndingDate") String EndingDate,@PathParam("WeatherVariable") String WeatherVariable) {
 TypedQuery<DailyRecord> q = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try{
java.util.Date datetemp1 = sdf.parse(StartingDate);
java.util.Date datetemp2 = sdf.parse(EndingDate);

    q = em.createQuery("SELECT d FROM DailyRecord d WHERE d.recDate <= :EndingDate AND d.recDate >= :StartingDate",DailyRecord.class);

q.setParameter("StartingDate", datetemp1);
q.setParameter("EndingDate", datetemp2);
//return q.getResultList();
}catch(Exception e){
System.out.println(e);

}
List<DailyRecord> SearchList = q.getResultList();
List<WeatherV> wList = new ArrayList<>();
if(WeatherVariable.equals("Temperature")){
for(int i = 0; i < SearchList.size();i++)
{
    WeatherV temp = new WeatherV(SearchList.get(i).getRecDate(),SearchList.get(i).getClimaticTemp(),SearchList.get(i).getPainLvl());
    wList.add(temp);
}
}
else if(WeatherVariable.equals("Humidity")){
for(int i = 0; i < SearchList.size();i++)
{
    WeatherV temp = new WeatherV(SearchList.get(i).getRecDate(),SearchList.get(i).getClimaticHumidity(),SearchList.get(i).getPainLvl());
    wList.add(temp);
}
}
else if(WeatherVariable.equals("Wind Speed")){
for(int i = 0; i < SearchList.size();i++)
{
    WeatherV temp = new WeatherV(SearchList.get(i).getRecDate(),SearchList.get(i).getClimaticWindsp(),SearchList.get(i).getPainLvl());
    wList.add(temp);
}
}
else if(WeatherVariable.equals("Pressure")){
for(int i = 0; i < SearchList.size();i++)
{
    WeatherV temp = new WeatherV(SearchList.get(i).getRecDate(),SearchList.get(i).getClimaticPress(),SearchList.get(i).getPainLvl());
    wList.add(temp);
}
}
return wList;
}
//3b
@GET
@Path("DailyRecord.CorrelationPainLvlAndWeather/{StartingDate}/{EndingDate}/{WeatherVariable}")
@Produces({"application/json"})
public CorrelP CorrelationPainLvlANDWeather(@PathParam("StartingDate") String StartingDate,@PathParam("EndingDate") String EndingDate,@PathParam("WeatherVariable") String WeatherVariable) {
 List<WeatherV> holdValues = findByDateANDWeather(StartingDate,EndingDate,WeatherVariable);
 try{
     double[][] data = new double[holdValues.size()][2];
            for (int i = 0; i < holdValues.size(); i++) {
                double temp =Double.parseDouble(holdValues.get(i).getWeatherVariable());
                data[i][0] = temp;
                data[i][1] = holdValues.get(i).getPainLvl();
            }
            RealMatrix m = MatrixUtils.createRealMatrix(data);
            PearsonsCorrelation pc = new PearsonsCorrelation(m);
            RealMatrix corM = pc.getCorrelationMatrix();
            RealMatrix pM = pc.getCorrelationPValues();
            return new CorrelP(corM.getEntry(0, 1), pM.getEntry(0, 1));
        } catch (Exception ex) {
            return new CorrelP(Double.NaN, Double.NaN);
        }
 }
//3c
@GET
@Path("DailyRecord.CountPainLoc/{StartingDate}/{EndingDate}")
@Produces({"application/json"})
public List<CountPainLoc> CountPainLoc(@PathParam("StartingDate") String StartingDate,@PathParam("EndingDate") String EndingDate) {
 TypedQuery<Object[]> q = null;
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try{
java.util.Date datetemp1 = sdf.parse(StartingDate);
java.util.Date datetemp2 = sdf.parse(EndingDate);

    q = em.createQuery("SELECT d.painLoc, COUNT(d) FROM DailyRecord d WHERE d.recDate <= :EndingDate AND d.recDate >= :StartingDate GROUP BY d.painLoc",Object[].class);

q.setParameter("StartingDate", datetemp1);
q.setParameter("EndingDate", datetemp2);

}catch(Exception e){
System.out.println(e);
}
    List<Object[]> SearchResult = q.getResultList();
    ArrayList<CountPainLoc> CountResult = new ArrayList<>();
    for(int i=0;i<SearchResult.size();i++)
    {
        String temp1 = SearchResult.get(i)[0].toString();
        CountPainLoc temp = new CountPainLoc((String) SearchResult.get(i)[0],((Number) SearchResult.get(i)[1]).intValue());
        CountResult.add(temp);
    }
    return CountResult;
}
}



