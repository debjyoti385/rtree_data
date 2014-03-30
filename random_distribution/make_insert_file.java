import java.io.*;
import java.util.Random;

public class make_insert_file {

	public static void main(String[] argv) {
		
		// The size of the simulation population
		
		if (argv.length !=3){
			System.out.println("USAGE: executable <input_filename> <num_points_in_file> <dimension>\n");
			return ;
		}
		
int type,num_mbr, extra,dim,DIMENSION,distribution,num_unique_query,POINTS;
String filenm;

int q,r,times,slot;


filenm = argv[0];

POINTS = Integer.parseInt(argv[1]);
DIMENSION = Integer.parseInt(argv[2]);


double[][][] pt =new double[POINTS+10][2][10];		
		
					
			   try {
				    BufferedReader in = new BufferedReader(new FileReader(filenm));
				    String str;
//				    str = in.readLine();
				    int i=0;
				    while ((str = in.readLine()) != null && i != POINTS) {
				        //System.out.println(str);
				        str = in.readLine();
				        String[] arr = str.split("\t");				        
						for(int j=0;j<10;j++){
							pt[i][0][j] = Double.parseDouble(arr[j]);		
						}	
						
				        str = in.readLine();
				        arr = str.split("\t");				        
				        
						for(int j=0;j<10;j++){
							pt[i][1][j] = Double.parseDouble(arr[j]);		
						}	
										        
				        i++;
				    }
				    in.close();
				} catch (IOException e) {
				    System.out.println("File Read Error Resource.in");
				}
			
			
				

				for(int i=0;i<POINTS;i++){


						System.out.println("0");


						for(int j=0;j<DIMENSION;j++){
					//			cout<< pt[0][j];
							System.out.print(pt[i][0][j] + "\t");			

							}	

						System.out.println("");
						
						for(int j=0;j<DIMENSION;j++){
					//			cout<< pt[0][j];
							System.out.print(pt[i][1][j] + "\t");			

							}	

						System.out.println("");
												


				}
	

	


			
			System.out.println("-1");
				
				
				
	}				
}	
