import java.io.*;
import java.util.Random;

public class make_san_data {

	public static void main(String[] argv) {
		
		// The size of the simulation population
		
		if (argv.length !=1){
			System.out.println("USAGE: executable <input_filename> \n");
			return;
		}

int type,num_mbr,extra,dim,DIMENSION,distribution,num_unique_query,POINTS, r_number;
String filenm;

int q,r,times,slot;

filenm = argv[0];


POINTS = 180000;
DIMENSION = 2;


//create_map(arr,POINTS, slot, num_unique_query);

double[][][] pt =new double[POINTS+10][2][10];

			   try {
				    BufferedReader in = new BufferedReader(new FileReader(filenm));
				    String str;
//				    str = in.readLine();
				    int i=0;
				    while ((str = in.readLine()) != null && i != POINTS) {
				        //System.out.println(str);
//				        str = in.readLine();
				        String[] s_arr = str.split(" ");				        
						System.out.println("0");										        
						for(int j=1;j<3;j++){
							pt[i][0][j] = Double.parseDouble(s_arr[j]);		
							System.out.print(pt[i][0][j] +"\t");
						}	
						System.out.println();
						for(int j=1;j<3;j++){
							System.out.print(pt[i][0][j] +"\t");
						}
						System.out.println();
				        i++;
				    }
				    in.close();
				} catch (IOException e) {
				    System.out.println("File Read Error Resource.in");
				}
			
			System.out.println("-1");
				
	}
	
}
	

