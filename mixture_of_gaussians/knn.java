import java.io.*;
import java.util.Random;

public class knn {

	public static void main(String[] argv) {
		
		// The size of the simulation population
		
		if (argv.length !=7){
			System.out.println("USAGE: executable <input_filename> <num_points_in_file> <dimension> <distribution[1..100]> <num_unique_query> <num_query> <slot>\n");
			return ;
		}
		
int type,num_mbr, extra,dim,DIMENSION,distribution,num_unique_query,POINTS;
String filenm;

int q,r,times,slot;


filenm = argv[0];

POINTS = Integer.parseInt(argv[1]);
DIMENSION = Integer.parseInt(argv[2]);

distribution = Integer.parseInt(argv[3]);

num_unique_query = Integer.parseInt(argv[4]);
q= Integer.parseInt(argv[5]);
slot= Integer.parseInt(argv[6]);

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
			
			
				
			Random rand = new Random();
			for(int i2=0;i2 < slot; i2++){
				int rr= rand.nextInt(17);
				for(int i1=0;i1 < q;){

			//while(q>0){
				if(rand.nextInt(100) < distribution){
					  // Initialize random number generator.
	
						r = rand.nextInt(num_unique_query)* (int)((POINTS-10000)/(num_unique_query + rr));
					//cout <<"random value "<< r<< endl;
					//   srand(pow(q,r));
					//   srand(pow(q,r));
					//	times=1;
						times =rand.nextInt(29) + 5 ;

					//		file>>dim;	
					//		file>>num_mbr;	



						for(int k =0; k<times; k++){
						System.out.println("3");
						i1++;
						System.out.println("10");


						for(int j=0;j<DIMENSION;j++){
					//			cout<< pt[0][j];
							System.out.print(pt[r][0][j] + "\t");			

							}	

						System.out.println("");
						}



				}
				else{							// nonpopular data 
	
					for(int idx =0 ; idx < 20 ; idx++){
	
							r = rand.nextInt(POINTS);



						System.out.println("3");
						i1++;
						System.out.println("10");
													//	cout<<r<<"\n";
								for(int j=0;j<DIMENSION;j++){
			
							
										System.out.print(pt[r][0][j] + "\t");			
			
									}	
						System.out.println("");



	
	
					}	
	
				}
			}
			}
			System.out.println("-1");
				
				
				
	}				
}	
