package hanifi.siavash.id1212.rockPaperSizzor.lookupService.startup;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

import hanifi.siavash.id1212.rockPaperSizzor.common.LookupServiceInterface;
import hanifi.siavash.id1212.rockPaperSizzor.lookupService.controller.Controller;

public class Main {
	public static void main(String[] args) throws RemoteException, MalformedURLException, ClassNotFoundException, SQLException {
		LookupServiceInterface controller = new Controller(); 
		LocateRegistry.createRegistry(5008);
		Naming.rebind("rmi://localhost:5008"+ "/rmi",controller); 
	}
}
