package primeThreads.threadMgmt;

import primeThreads.util.IsPrime;
import primeThreads.store.Results;
import primeThreads.util.FileProcessor;

public class WorkerThread implements Runnable  {
	FileProcessor fileProcessor;
	Results results;
	IsPrime prime;
	
	public WorkerThread(FileProcessor f, Results r, IsPrime p){
		this.fileProcessor = f;
		this.results  = r;
		this.prime = p;
		
	}

    public void run() {
		String s;
		boolean evenNum;
		synchronized(fileProcessor){
			while((s = fileProcessor.readLineFromFile()) != null){
				int num = Integer.parseInt(s);
				System.out.println(num);
				evenNum = prime.checkPrime(num);
				if(evenNum){
					//System.out.println("I'm even son");
					results.insert_num(num);
					
				}
			}
		}
    }
    

}
