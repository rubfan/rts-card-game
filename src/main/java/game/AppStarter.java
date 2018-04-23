package game;

import config.AppContextConfig;
import config.DeployDbConfig;
import org.eclipse.jetty.server.Server;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ruslangramatic on 4/19/18.
 */
public class AppStarter {

    public static void main(String[] args) throws Exception {
        if(args != null && args.length > 0) {
            switch (args[0]) {
                case "deploy":
                    new DeployDbConfig().runWithoutDb();
                    break;
                default:
                    Boolean debug = args.length > 1 && args[0].equals("debug");
                    Integer port = args.length > 2 ? Integer.parseInt(args[1]) : 8080;
                    new AppStarter().startServer(debug, port);
                    break;
            }
        } else {
            throw new Exception("You need to use App arguments: start or deploy!");
        }
    }

    private void startServer(Boolean debug, Integer port) {
        Server jettyServer = new Server(port);
        AppContextConfig appContext = new AppContextConfig();
        jettyServer.setHandler(appContext.getHandlersConfig());

        try {
            jettyServer.start();
            if(debug) jettyServer.dumpStdErr();
            jettyServer.join();
        } catch (Exception e) {
            Logger.getLogger(AppStarter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            jettyServer.destroy();
        }
    }
}
