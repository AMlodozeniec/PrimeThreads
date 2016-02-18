package primeThreads.driver;

import java.io.FileReader;
import java.io.FileNotFoundException;
import primeThreads.util.FileProcessor;			//FileProcessor 
import primeThreads.store.Results;				//Results
import primeThreads.util.IsPrime;				//IsPrime 
import primeThreads.threadMgmt.CreateWorkers;	//CreateWorkers

public class Driver{

	public static void main(String args[]) {

		FileReader file;
		FileProcessor fp;
		CreateWorkers cw;
		Results res;
		IsPrime ip;
        int NUM_THREADS;
        int DEBUG_VALUE;

        if (args.length != 3) {	
            System.out.println("Incorrect number of args. Exiting. " + args.length);
			System.exit(0);
        } else {
        	NUM_THREADS = Integer.parseInt(args[1]);
        	DEBUG_VALUE = Integer.parseInt(args[2]);
			//Validate that the value of NUM_THREADS is between 1 and 5.
            if (NUM_THREADS > 5 || NUM_THREADS < 1) {
                System.out.println("NUM_THREADS value must be between 1 and 5.");
				System.exit(0);
            } 
            //Validate that the DEBUG_VALUE is between 0 and 4.
            else if (DEBUG_VALUE > 4 || DEBUG_VALUE < 0) {
                System.out.println("DEBUG_VALUE value must be between 0 and 4.");
				System.exit(0);
            } else {
                try { 
                    file = new FileReader(args[0]);
                    fp   = new FileProcessor(file);
                    res  = new Results();
                    ip   = new IsPrime();
                    cw   = new CreateWorkers(fp, res, ip);
                    cw.startWorkers(NUM_THREADS);
					res.writeSumToScreen();
                //File stream failed.
                } catch (FileNotFoundException e) {
                    System.err.println("File stream could not be created.");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
	}

    /**
     * Override toString() method for debugging
     *
     * @return String   class description for debugging
     */
    public String toString() {
        return "primeTheads.driver.Driver.";
    }

} 
