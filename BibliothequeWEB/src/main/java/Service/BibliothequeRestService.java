package Service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.ws.rs.FormParam;
import javax.ws.rs.GET;

import com.BibliothequeEJB.dao.interfaces.OuvrageDao;
import com.BibliothequeEJB.entities.Ouvrage;

@Stateless
@Path("/bibliotheque/ouvrages")
public class BibliothequeRestService {
	@EJB
	private OuvrageDao ouvragedao;
    @POST
    @Consumes("application/json")
    public Response addOuvrage(Ouvrage ouvrage) {
        ouvragedao.ajoutOuvrage(ouvrage);
        return Response.status(Response.Status.CREATED).entity("Ouvrage added successfully").build();
    }
    @POST
    @Path("/{titre}/{date}")
    @Consumes("application/json")
    public Response adddOuvrage(@PathParam("titre") String titre, @PathParam("date") String date) {
    	Ouvrage ouvr = new Ouvrage();
    	ouvr.setDateCreation(date);
    	ouvr.setTitre(titre);
        ouvragedao.ajoutOuvrage(ouvr);
        return Response.status(Response.Status.CREATED).entity("Ouvrage added successfully").build();
    }
	
    @GET
    @Produces("application/json")
    public List<Ouvrage> getAllOuvrages() {
        return ouvragedao.getAllOuvrages();
    }
	
	@GET
    @Path("/{titre}")
    @Produces("application/json")
    public Response getOuvrage(@PathParam("titre") String titre) {
        Ouvrage ouvrage = ouvragedao.rechercheOuvrage(titre);

        if (ouvrage != null) {
            return Response.ok(ouvrage).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Ouvrage not found").build();
        }
    }
	
	 @PUT
	    @Path("/{titre}")
	    @Consumes("application/json")
	    public Response updateOuvrage(@PathParam("titre") String titre, Ouvrage updatedOuvrage) {
	        Ouvrage existingOuvrage = ouvragedao.rechercheOuvrage(titre);

	        if (existingOuvrage != null) {
	            
	            existingOuvrage.setTitre(updatedOuvrage.getTitre());
	            existingOuvrage.setDateCreation(updatedOuvrage.getDateCreation());
	            existingOuvrage.setExist(true);
	        
                                                            
	            ouvragedao.updateOuvrage(existingOuvrage);
	            return Response.ok("Ouvrage updated successfully").build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND).entity("Ouvrage not found").build();
	        }
	    }
	 @DELETE
	 @Path("/{titre}")
	 public Response deleteOuvrage(@PathParam("titre") String titre) {
	        Ouvrage ouvrage = ouvragedao.rechercheOuvrage(titre);

	        if (ouvrage != null) {
	            ouvragedao.suppOuvrage(ouvrage);
	            return Response.ok("Ouvrage deleted successfully").build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND).entity("Ouvrage not found").build();
	        }
	    }
	
}


