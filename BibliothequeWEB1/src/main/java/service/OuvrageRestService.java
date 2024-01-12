package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import metier.AbonneLocal;
import metier.OuvrageLocal;
import metier.entities.Abonne;
import metier.entities.Ouvrage;

@Stateless
@Path("/")
public class OuvrageRestService {
	@EJB
	private OuvrageLocal ouvragedao;
	@EJB
	private AbonneLocal abonneDao;
    @POST
    @Path("/addOuvrage")
    @Consumes("application/json")
    public Response addOuvrage(Ouvrage ouvrage) {
        ouvragedao.ajoutOuvrage(ouvrage);
        return Response.status(Response.Status.CREATED).entity("Ouvrage added successfully").build();
    }
    @POST
    @Path("/{titre}/{date}")
    @Consumes("application/json")
    public Response addOuvrage(@PathParam("titre") String titre, @PathParam("date") String date) {
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
	 ////////////////////*********ABONNE**********\\\\\\\\\\\\\\\\\\\\\\\
	    @POST
	    @Path("/addAbonne")
	    @Consumes("application/json")
	    public Response addAbonne(Abonne abonne) {
	        abonneDao.ajoutAbonne(abonne);
	        return Response.status(Response.Status.CREATED).entity("Abonne added successfully").build();
	    }

	    @GET
	    @Path("/abonnes")
	    @Produces("application/json")
	    public List<Abonne> getAllAbonnes() {
	        return abonneDao.getAllAbonnes();
	    }

	    @GET
	    @Path("/abonne/{cin}")
	    @Produces("application/json")
	    public Response getAbonne(@PathParam("cin") int cin) {
	        Abonne abonne = abonneDao.rechercheAbonne(cin);

	        if (abonne != null) {
	            return Response.ok(abonne).build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND).entity("Abonne not found").build();
	        }
	    }

	    @PUT
	    @Path("/updateAbonne/{cin}")
	    @Consumes("application/json")
	    public Response updateAbonne(@PathParam("cin") int cin, Abonne updatedAbonne) {
	        Abonne existingAbonne = abonneDao.rechercheAbonne(cin);

	        if (existingAbonne != null) {
	            existingAbonne.setNom(updatedAbonne.getNom());
	            existingAbonne.setNumAbonnement(updatedAbonne.getNumAbonnement());
	            existingAbonne.setOuvrage(updatedAbonne.getOuvrage());

	            abonneDao.updateAbonne(existingAbonne);
	            return Response.ok("Abonne updated successfully").build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND).entity("Abonne not found").build();
	        }
	    }

	    @DELETE
	    @Path("/deleteAbonne/{cin}")
	    public Response deleteAbonne(@PathParam("cin") int cin) {
	        Abonne abonne = abonneDao.rechercheAbonne(cin);

	        if (abonne != null) {
	            abonneDao.suppAbonne(abonne);
	            return Response.ok("Abonne deleted successfully").build();
	        } else {
	            return Response.status(Response.Status.NOT_FOUND).entity("Abonne not found").build();
	        }
	    }
	    @POST
	    @Path("/emprunter/{titre}/{cin}")
	    @Produces("application/json")
	    public Response emprunter(@PathParam("titre") String titre, @PathParam("cin") int cin) {
	        try {
	            abonneDao.emprunter(titre, cin);
	            return Response.ok("Emprunt successful").build();
	        } catch (Exception e) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error during emprunt: " + e.getMessage()).build();
	        }
	    }

	    @PUT
	    @Path("/rendre/{cin}")
	    @Produces("application/json")
	    public Response rendre(@PathParam("cin") int cin) {
	        try {
	            abonneDao.rendre(cin);
	            return Response.ok("Rendre successful").build();
	        } catch (Exception e) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error during rendre: " + e.getMessage()).build();
	        }
	    }


	
}


