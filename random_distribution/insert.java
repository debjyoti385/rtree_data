
import javax.swing.JOptionPane;
import java.util.Random;

/** Generate random doubleegers in a certain range. */
public final class insert {
  
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
//    log(QRY+"\t");    
    while(QRY!=0){
    log("0\n");
	    Random random = new Random();
	    for (int idx = 0; idx < DIM; ++idx){
	      low[idx]=showRandomDouble(START, END, random);
	    }
	    log("\n");
	    for (int idx = 0; idx < DIM; ++idx){
	      high[idx]=showRandomDouble(low[idx], low[idx]+THR, random);
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
  
  private static void log(String aMessage){
    System.out.print(aMessage);
  }
}	

