package fit.iuh.se.bai5.Rest_API;
import iuh.fit.se.entities.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/users")
public class UserResource {
    private static List<User> users = new ArrayList<>();
    private static AtomicInteger counter = new AtomicInteger(1);

    // GET /api/users -> list all
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return users;
    }

    // GET /api/users/{id} -> get by id
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .map(u -> Response.ok(u).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    // POST /api/users -> create new
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        user.setId(counter.getAndIncrement());
        if (user.getDob() == null) {
            user.setDob(Date.valueOf("2003-04-03")); // demo
        }
        users.add(user);
        return user;
    }

    // PUT /api/users/{id} -> update
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") int id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                user.setId(id);
                users.set(i, user);
                return Response.ok(user).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    // DELETE /api/users/{id} -> delete
    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        boolean removed = users.removeIf(u -> u.getId() == id);
        if (removed) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}