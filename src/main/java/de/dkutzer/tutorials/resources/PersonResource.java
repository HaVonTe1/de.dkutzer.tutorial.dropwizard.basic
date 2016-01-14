package de.dkutzer.tutorials.resources;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import de.dkutzer.tutorials.api.Person;
import de.dkutzer.tutorials.db.EntityManager;

@SuppressWarnings("static-method")
@Path("/person")
public class PersonResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(final Person person, @Context UriInfo info) {
        EntityManager.create(person);
        URI absoluteURI = info.getBaseUriBuilder().path("/" + person.getId()).build();
        return Response.created(absoluteURI).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") final int id) {
        final Person personById = EntityManager.getPersonById(id);
        return Response.ok().entity(personById).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        final Collection<Person> findAll = EntityManager.findAll();
        GenericEntity<Collection<Person>> entity = new GenericEntity<Collection<Person>>(findAll) {
        };
        return Response.ok().entity(entity).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(final Person p) {
        EntityManager.update(p);
        return Response.ok().build();
    }
}
