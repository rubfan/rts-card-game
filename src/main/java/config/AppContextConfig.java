package config;

import game.controllers.BuildingController;
import game.controllers.CardController;
import game.controllers.RoomController;
import game.controllers.UserController;
import game.controllers.impl.*;
import game.repositories.dao.BuildingDao;
import game.repositories.dao.CardDao;
import game.repositories.dao.RoomDao;
import game.repositories.dao.UserDao;
import game.repositories.dao.impl.BuildingDaoImpl;
import game.repositories.dao.impl.CardDaoImpl;
import game.repositories.dao.impl.RoomDaoImpl;
import game.repositories.dao.impl.UserDaoImpl;
import game.services.BuildingService;
import game.services.CardService;
import game.services.RoomService;
import game.services.UserService;
import game.services.impl.BuildingServiceImpl;
import game.services.impl.CardServiceImpl;
import game.services.impl.RoomServiceImpl;
import game.services.impl.UserServiceImpl;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor ruslangramatic on 4/20/18.
 */
public class AppContextConfig {
    public HandlerList getHandlersConfig() {
        ServletContextHandler servletsHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        servletsHandler.setContextPath("/");
        servletsHandler.addServlet(new ServletHolder(new ServletContainer(getResourceConfig())), "/rest/*");

        ResourceHandler resourceHandler = getResourceHandler();
        resourceHandler.setWelcomeFiles(new String[]{"login.html"});
        resourceHandler.setBaseResource(Resource.newClassPathResource("/webapp"));

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, servletsHandler/*,new DefaultHandler()*/});
        return handlers;
    }

    private ResourceHandler getResourceHandler(){
        return new ResourceHandler(){
            @Override
            public void handle(String target, Request baseRequest, HttpServletRequest request,
                               HttpServletResponse response) throws IOException, ServletException {
                if(target.equals("/rooms.html")
                        || target.equals("/achievements.html")
                        || target.equals("/gameplay.html")) {
                    Boolean flag = true;
                    for (Cookie cookie : request.getCookies()) {
                        if ("token".equals(cookie.getName())) {
                            flag = false;
                            if (cookie.getValue() == null || cookie.getValue().equals("")) {
                                flag = true;
                            }
                            break;
                        }
                    }
                    if (flag) {
                        response.sendRedirect("/login.html");
                    }
                }
                super.handle(target, baseRequest, request, response);
            }
        };
    }

    private ResourceConfig getResourceConfig() {
        return new ResourceConfig() {{
            packages("game");
            register(AuthenticationFilter.class);
            register(new AbstractBinder() {
                @Override
                protected void configure () {
                    bindAsContract(RoomDaoImpl.class).to(RoomDao.class);
                    bindAsContract(RoomServiceImpl.class).to(RoomService.class);
                    bindAsContract(RoomControllerImpl.class).to(RoomController.class);

                    bindAsContract(CardDaoImpl.class).to(CardDao.class);
                    bindAsContract(CardServiceImpl.class).to(CardService.class);
                    bindAsContract(CardControllerImpl.class).to(CardController.class);

                    bindAsContract(BuildingDaoImpl.class).to(BuildingDao.class);
                    bindAsContract(BuildingServiceImpl.class).to(BuildingService.class);
                    bindAsContract(BuildingControllerImpl.class).to(BuildingController.class);

                    bindAsContract(UserDaoImpl.class).to(UserDao.class);
                    bindAsContract(UserServiceImpl.class).to(UserService.class);
                    bindAsContract(UserControllerImpl.class).to(UserController.class);
                }
            });
        }};
    }
}
