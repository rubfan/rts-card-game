package config;

import game.controllers.*;

import game.controllers.impl.*;

import game.repositories.dao.*;
import game.repositories.dao.impl.*;
import game.services.*;
import game.services.impl.*;

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

                    bindAsContract(UpgradeDaoImpl.class).to(UpgradeDao.class);
                    bindAsContract(UpgradeServiceImpl.class).to(UpgradeService.class);
                    bindAsContract(UpgradeControllerImpl.class).to(UpgradeController.class);

                    bindAsContract(AccountBuildingDaoImpl.class).to(AccountBuildingDao.class);
                    bindAsContract(AccountBuildingServiceImpl.class).to(AccountBuildingService.class);
                    bindAsContract(AccountBuildingControllerImpl.class).to(AccountBuildingController.class);

                    bindAsContract(BuildingProductDaoImpl.class).to(BuildingProductDao.class);
                    bindAsContract(BuildingProductServiceImpl.class).to(BuildingProductService.class);
                    bindAsContract(BuildingProductControllerImpl.class).to(BuildingProductController.class);

                    bindAsContract(ResourceDaoImpl.class).to(ResourceDao.class);
                    bindAsContract(ResourceServiceImpl.class).to(ResourceService.class);
                    bindAsContract(ResourceControllerImpl.class).to(ResourceControllerImpl.class);

                    bindAsContract(UserDaoImpl.class).to(UserDao.class);
                    bindAsContract(UserServiceImpl.class).to(UserService.class);
                    bindAsContract(UserControllerImpl.class).to(UserController.class);

                    bindAsContract(AccountDaoImpl.class).to(AccountDao.class);
                    bindAsContract(AccountServiceImpl.class).to(AccountService.class);
                    bindAsContract(AccountControllerImpl.class).to(AccountController.class);

                    bindAsContract(MessageDaoImpl.class).to(MessageDao.class);
                    bindAsContract(MessageServiceImpl.class).to(MessageService.class);
                    bindAsContract(MessageControllerImpl.class).to(MessageController.class);

                }
            });
        }};
    }
}
