//Tierra Doughty - September 2023 and ongoing rippp - Simple? Web Server Management System
//Allows user to choose up to six different options including adding a server, starting a server, stopping a server, deleting a server, looking
//Allows the user to input any number of web servers they have and basic information for each including the status and anything else
//This program will try to utilize an Array List for more flexible arrays
//Eventually I want to connect this with some type of API so the information can automatically be retrieved and connected to this program


//Everything I imported for this program:

import java.util.ArrayList; //Using an array list to make the array more flexible 
import java.util.*; //Used for general Java Library
import java.util.List; //For list of servers option to list servers and its information
import javax.swing.*; //Eventually will use to have Java GUI for this program
import java.lang.*; //Used for Java Lang library for the System.exit stuff

//class webserver that was in the og program 
class WebServer {
    private String name;
    private boolean status;

//trying out the this statement UwU
    public WebServer(String name) {
        this.name = name;
        this.status = false; // Initially the server is offline
    }

    //getter for name
    public String getName() {
        return name;
    }

    //getter for status
    public boolean getStatus() {
        return status;
    }

    //setter when starting a server
    public void start() {
        status = true;
        System.out.println(name + " has started.");
        System.out.println(name + " is now running.");
    }

    //setter for when stopping a server
    public void stop() {
        status = false;
        System.out.println(name + " has been stopped.");
        System.out.println(name + " is not running.");
    }
}

//Array List thingy...idk what im doing + using my references ;-;
public class WebServerManagementSystem {
    private List<WebServer> servers;

    public WebServerManagementSystem() {
        servers = new ArrayList<>(); //initializes new ArrayList stored in servers variable
    }
    
//Method to add a server using String serverName and has error message if server is not found
    public void addServer(String serverName) {
        WebServer server = new WebServer(serverName);
        servers.add(server);
    }

//Method to start a server using String serverName and has error message if server is not found
    public void startServer(String serverName) {
        WebServer server = findServer(serverName);
        if (server != null) {
            server.start();
        } else {
            System.out.println("Server not found: " + serverName);
        }
    }

    //method to stop a server by taking the string serverName and has an error message if the server is not found
    public void stopServer(String serverName) {
        WebServer server = findServer(serverName);
        if (server != null) {
            server.stop();
        } else {
            System.out.println("Server not found: " + serverName);
        }
    }

    //private method that finds a server using String serverName
    private WebServer findServer(String serverName) {
        for (WebServer server : servers) {
            if (server.getName().equals(serverName)) {
                return server;
            }
        }
        return null;
    }

    //main function for the whole program
    public static void main(String[] args) {
    	boolean programOn = true;
    	int systemChoice;
    	int numOfServers;
    	int EXIT = -1; //exit code so the user can type this to end the program
    	
    //while loop that keeps the program running and remains true until the program exits
    	while(programOn==true) {
    	
    	Scanner input = new Scanner(System.in); //initialize new scanner called input to get user input
    	
    	//Print lines for a welcome message and all command options
    	System.out.println("Hello, welcome to the Web Server Management System!");
    	System.out.println("Programmed by: Tierra Doughty");

		System.out.println("====================================================\n");
    	System.out.println("What are you here for?\n");
    	
    	System.out.println("1.) Add a server\n"); 
    	System.out.println("2.) Start a server\n");
    	System.out.println("3.) Stop a server\n");
    	System.out.println("4.) Delete a server\n");
    	System.out.println("5.) Find a server\n");
    	System.out.println("6.) List all servers\n");
    	System.out.println("Type " + EXIT + " to exit the program."); //utilizes exit code to stop the entire program
    	System.out.println("====================================================\n");
    	System.out.println("Enter your choice here: ");
    	systemChoice = input.nextInt(); //Scanner looking for an integer that relates to command options
    	
    	
//Eventually, these if-else statements will be replaced with a switch?
if(systemChoice == -1) { //if statement so program will exit if passed the exact exit code 
	System.out.println("<--You have exited the program-->");
	programOn=false;
	System.exit(EXIT); //terminates the program
	
	switch (systemChoice) {
    case 1:
        System.out.println("You have chosen to add a server\n");
        System.out.println("How many servers do you wish to add:\n");
        numOfServers = input.nextInt();
        System.out.println("You have chosen to add " + numOfServers + " servers\n");

        WebServerManagementSystem managementSystem = new WebServerManagementSystem();

        for (int i = 0; i < numOfServers; i++) {
            System.out.println("Enter the name of server " + (i + 1) + ":\n");
            String serverName = input.next();
            managementSystem.addServer(serverName);
        }
        System.out.println("You have added the following servers:");
        // Print the added servers here based on your system.
        break;

    case 2:
        System.out.println("You have chosen to start a server\n");
        System.out.println("How many servers do you wish to start:\n");
        numOfServers = input.nextInt();
        input.nextLine();

        String[] serverNames = new String[numOfServers];
        boolean[] serverStatus = new boolean[numOfServers];

        for (int i = 0; i < numOfServers; i++) {
            System.out.println("Enter each server name: " + (i + 1) + ": ");
            serverNames[i] = input.nextLine();
            System.out.println("Enter the current status of the server " + (i + 1) + ":");
            serverStatus[i] = input.nextBoolean();
            input.nextLine();
        }
        break;

    case 3:
        System.out.println("You have chosen to stop a server\n");
        // Implement the logic for stopping a server here.
        break;

    case 4:
        System.out.println("You have chosen to delete a server\n");
        // Implement the logic for deleting a server here.
        break;

    case 5:
        System.out.println("You have chosen to find a server\n");
        // Implement the logic for finding a server here.
        break;

    case 6:
        System.out.println("You have chosen to list all servers\n");
        // Implement the logic for listing all servers here.
        break;

    default:
        System.out.println("Error: Please try typing the number corresponding to the options above or type -1 to exit the Web Server Management System.\n");
}

}
	
	
	
	
	//Everything for choice 1:
		/*} else if (systemChoice == 1) {
		    System.out.println("You have chosen to add a server\n");
		    System.out.println("How many servers do you wish to add:\n");
		    numOfServers = input.nextInt();
		    System.out.println("You have chosen to add " + numOfServers + " servers\n");

		    WebServerManagementSystem managementSystem = new WebServerManagementSystem();

		    for (int i = 0; i < numOfServers; i++) {
		        System.out.println("Enter the name of server " + (i + 1) + ":\n");
		        String serverName = input.next();
		        managementSystem.addServer(serverName);
		    }
		    System.out.println("You have added the following servers:");
		    // You should print the added servers here, but you haven't provided the code for that. 
		    // You should implement a way to retrieve the added servers from the management system and print them.
		} else if (systemChoice == 2) {
		    System.out.println("You have chosen to start a server\n");
		    System.out.println("How many servers do you wish to start:\n");
		    numOfServers = input.nextInt();
		    input.nextLine();

		    String[] serverNames = new String[numOfServers];
		    boolean[] serverStatus = new boolean[numOfServers];

		    for (int i = 0; i < numOfServers; i++) {
		        System.out.println("Enter each server name: " + (i + 1) + ": ");
		        serverNames[i] = input.nextLine();
		        System.out.println("Enter the current status of the server " + (i + 1) + ":");
		        serverStatus[i] = input.nextBoolean();
		        input.nextLine();
		    }
		} else if (systemChoice == 3) {
			 System.out.println("You have chosen to stop a server\n");
			
		} else if(systemChoice == 4) {
			 System.out.println("You have chosen to delete a server\n");
		} else if(systemChoice == 5) {
			 System.out.println("You have chosen to find a server\n");
			
		} else if(systemChoice == 6) {
			 System.out.println("You have chosen to list all servers\n");
			
		}else if(systemChoice != 1 || systemChoice != 2 || systemChoice != 3 || systemChoice != 4 || systemChoice != 5 || systemChoice != 6) {
			System.out.println("");
			
		} else {
			 System.out.println("Error: Please try typing the number corresponding to the options above or type -1 to exit the Web Server Management System.\n");
		}
    	}*/
			
		
   
    	//This was the original program in the main method that worked to use the addServer, startServer, and stopServer command
        WebServerManagementSystem managementSystem = new WebServerManagementSystem();

        managementSystem.addServer("Server1");
        managementSystem.addServer("Server2");

        managementSystem.startServer("Server1");
        managementSystem.startServer("Server2");

        managementSystem.stopServer("Server1");
        managementSystem.stopServer("Server3"); // Server3 doesn't exist
        
    	}//end while loop 
    }// end main
}//end WebServerManagementSystem
