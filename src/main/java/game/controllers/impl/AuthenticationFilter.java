package game.controllers.impl;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 * @author ruslangramatic on 4/22/18.
 */
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequest) throws WebApplicationException {
        String path = containerRequest.getUriInfo().getPath();
        if (path.equals("/user/login") || path.equals("/user/logout") || path.equals("/user/new")) {
            return;
        }
        Cookie tokenCookie = containerRequest.getCookies().get("token");
        if (tokenCookie == null || tokenCookie.getValue() == null) {
            containerRequest.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("Cookie Not Found").build());
        }
    }
}
