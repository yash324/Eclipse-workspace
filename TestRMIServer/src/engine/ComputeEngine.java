package engine;

import java.rmi.RemoteException;

import compute.Compute;
import compute.Task;

public class ComputeEngine implements Compute {
 
    public ComputeEngine() {
    }
 
 
    public <T> T executeTask(Task<T> arg0) throws RemoteException {
    	return arg0.execute();
    }
   
}