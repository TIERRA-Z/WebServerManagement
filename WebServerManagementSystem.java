import java.util.ArrayList;
import java.util.List;

class WebServer {
    private String name;
    private boolean status;

    public WebServer(String name) {
        this.name = name;
        this.status = false; // Initially, the server is offline
    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }

    public void start() {
        status = true;
        System.out.println(name + " is now running.");
    }

    public void stop() {
        status = false;
        System.out.println(name + " has been stopped.");
    }
}

public class WebServerManagementSystem {
    private List<WebServer> servers;

    public WebServerManagementSystem() {
        servers = new ArrayList<>();
    }

    public void addServer(String serverName) {
        WebServer server = new WebServer(serverName);
        servers.add(server);
    }

    public void startServer(String serverName) {
        WebServer server = findServer(serverName);
        if (server != null) {
            server.start();
        } else {
            System.out.println("Server not found: " + serverName);
        }
    }

    public void stopServer(String serverName) {
        WebServer server = findServer(serverName);
        if (server != null) {
            server.stop();
        } else {
            System.out.println("Server not found: " + serverName);
        }
    }

    private WebServer findServer(String serverName) {
        for (WebServer server : servers) {
            if (server.getName().equals(serverName)) {
                return server;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        WebServerManagementSystem managementSystem = new WebServerManagementSystem();

        managementSystem.addServer("Server1");
        managementSystem.addServer("Server2");

        managementSystem.startServer("Server1");
        managementSystem.startServer("Server2");

        managementSystem.stopServer("Server1");
        managementSystem.stopServer("Server3"); // Server3 doesn't exist
    }
}
