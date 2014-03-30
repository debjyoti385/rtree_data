
import javax.swing.JOptionPane;
import java.util.Random;

/** Generate random doubleegers in a certain range. */
public final class insert_gaussian{
  
  private static Random fRandom = new Random();
  
  public static final void main(String... aArgs){
//    log("Generating random doubleegers in the range 1..10.");
   
        String Start = JOptionPane.showInputDialog("Enter Start");

        String End =  JOptionPane.showInputDialog("Enter End");
        String Dim =  JOptionPane.showInputDialog("Enter Dimension");        
    	String Threshold=JOptionPane.showInputDialog("Enter threshold");        
        double low[]=new double[100];
        double high[]=new double[100];
    
    double START =Double.parseDouble(Start);
    double END = Double.parseDouble(End);
    int DIM = Integer.parseInt(Dim);     
    double THR = Double.parseDouble(Threshold);       
//    log("\n"+DIM+"\t");

    String queries =  JOptionPane.showInputDialog("Enter Total queries");                
    int QRY = Integer.parseInt(queries);        	    
    
	Random random = new Random();    
    
    int slot = QRY - (int) getRandomDouble(1000,5000,random);
    double mean[]=new double[DIM];
    double variance[]=new double[DIM];
	for (int idx = 0; idx < DIM; ++idx){
	  mean[idx]=getRandomDouble(START, END, random);
	  variance[idx]=getGaussian(START+(END-START)/2.0f,(END-START)/20.0f);
	}
	
/*	
    log ("mean & variance ");
	for (int idx = 0; idx < DIM; ++idx){
	  log(mean[idx] +"\t");
	}
	log("\n");
	for (int idx = 0; idx < DIM; ++idx){
	  log(variance[idx] +"\t");
	}	
	log("\n");	
*/



//    log(QRY+"\t");    
    while(QRY!=0){
		if(QRY == slot){							// create new set of mean and variance
				for (int idx = 0; idx < DIM; ++idx){
					slot = QRY - (int) getRandomDouble(1000,5000,random);				
					mean[idx]=getRandomDouble(START, END, random);
					variance[idx]=getGaussian(START+(END-START)/2.0f,(END-START)/20.0f);
				}
			
		}
			log("0\n");
//				Random random = new Random();
				for (int idx = 0; idx < DIM; ++idx){
						do{
							  low[idx]=getGaussian(mean[idx],variance[idx]);
						}while(low[idx] < START || low[idx] > END );
						log(low[idx]+"\t ");
				}
				log("\n");
				for (int idx = 0; idx < DIM; ++idx){
				        int count=0;
						do{
							  if(count<4){						
								high[idx]=getRandomDouble(low[idx], low[idx]+THR, random);
								count++;
							  }
							  else{
								high[idx]=low[idx];
								break;
							  }
						}while(high[idx] < START || high[idx] > END );				  
						log(high[idx]+"\t ");						
				}
			QRY--;	    
			log("\n");	
	}
			
    log("\n-1"+"\n");
  }
  
  private static double showRandomDouble(double aStart, double aEnd, Random aRandom){
    if ( aStart > aEnd ) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    //get the range, casting to double to avoid overflow problems
//    double range = (double)aEnd - (double)aStart + 1;
    double range = (double)aEnd - (double)aStart ;    
    // compute a fraction of the range, 0 <= frac < range
    double fraction = (double)(range * aRandom.nextDouble());
    double randomNumber =  (fraction + aStart);
    if(randomNumber>aEnd)    {
	randomNumber=showRandomDouble(aStart, aEnd, aRandom);
//	    log( aEnd+ "\t " );
	}	
	else    
    log( randomNumber+ "\t " );
    return randomNumber;
  }
  
  private static double getRandomDouble(double aStart, double aEnd, Random aRandom){
    if ( aStart > aEnd ) {
      throw new IllegalArgumentException("Start cannot exceed End.");
    }
    //get the range, casting to double to avoid overflow problems
//    double range = (double)aEnd - (double)aStart + 1;
    double range = (double)aEnd - (double)aStart ;    
    // compute a fraction of the range, 0 <= frac < range
    double fraction = (double)(range * aRandom.nextDouble());
    double randomNumber =  (fraction + aStart);
    if(randomNumber>aEnd)    {
	randomNumber=showRandomDouble(aStart, aEnd, aRandom);
//	    log( aEnd+ "\t " );
	}	
  	  return randomNumber;
  }  
  
	public static double getGaussian(double aMean, double aVariance){
      return aMean + fRandom.nextGaussian() * aVariance;
	}    
  
  
  
  private static void log(String aMessage){
    System.out.print(aMessage);
  }
}	

