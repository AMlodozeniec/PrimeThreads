package primeThreads.threadMgmt;

import primeThreads.util.IsPrime;
import primeThreads.store.Results;
import primeThreads.util.FileProcessor;
import java.lang.Thread;

public class CreateWorkers {
	FileProcessor fileProcessor;
	Results results;
	IsPrime prime;
	
	//
	public CreateWorkers(FileProcessor f, Results r, IsPrime p){
		this.fileProcessor = f;
		this.results = r;
		this.prime = p;
		
	}
	
    // this class has the method startWokers(...)
	public void startWorkers(int num_threads){
		
		for(int i = 1; i <= num_threads; i++){
			System.out.println("Creating thread #" + i);
			WorkerThread worker = new WorkerThread(fileProcessor,results,prime);
			Thread t = new Thread(worker);
			t.start();
			try{
				t.join();
			}
			catch(InterruptedException e){
				System.out.println("Failed join");	
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
}
