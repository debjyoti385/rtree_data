import java.io.*;
import java.util.Random;

public class knn {

	public static void main(String[] argv) {
		
		// The size of the simulation population
		
		if (argv.length !=7){
			System.out.println("USAGE: executable <input_filename> <num_points_in_file> <dimension> <distribution[1..100]> <num_unique_query> <num_query> <slot>\n");
			return;
		}

int type,num_mbr, extra,dim,DIMENSION,distribution,num_unique_query,POINTS, r_number;
String filenm;

int q,r,times,slot;

filenm = argv[0];


POINTS = Integer.parseInt(argv[1]);
DIMENSION = Integer.parseInt(argv[2]);

distribution = Integer.parseInt(argv[3]);

num_unique_query = Integer.parseInt(argv[4]);
q= Integer.parseInt(argv[5]);
slot= Integer.parseInt(argv[6]);


mapping[] arr = new mapping[num_unique_query];

//create_map(arr,POINTS, slot, num_unique_query);

double[][][] pt =new double[POINTS+10][2][10];

			   try {
				    BufferedReader in = new BufferedReader(new FileReader(filenm));
				    String str;
//				    str = in.readLine();
				    int i=0;
				    while ((str = in.readLine()) != null && i != POINTS) {
				        //System.out.println(str);
				        str = in.readLine();
				        String[] s_arr = str.split("\t");				        
						for(int j=0;j<2;j++){
							pt[i][0][j] = Double.parseDouble(s_arr[j]);		
						}	
						
				        str = in.readLine();
				        s_arr = str.split("\t");				        
				        
						for(int j=0;j<2;j++){
							pt[i][1][j] = Double.parseDouble(s_arr[j]);		
						}	
										        
				        i++;
				    }
				    in.close();
				} catch (IOException e) {
				    System.out.println("File Read Error Resource.in");
				}
			
			
				
			Random rand = new Random();
			for(int i2=0;i2 < slot; i2++){
			
				create_map(arr,POINTS, q,num_unique_query);
				//int rr= rand.nextInt(17);
				int pop_query_count=0, nonpop_query_count=0;
								
				for(int i1=0;i1 < q;){
				

			//while(q>0){
				if(rand.nextInt(100) < distribution  && pop_query_count < (q*distribution)/100){
					  // Initialize random number generator.
	
					// select a random index from the array 
					int count =0;
					do{
					r_number = rand.nextInt(arr.length);
					r= arr[r_number].index;
					count++;
					}while(arr[r_number].occurances==0 && count < 100);
	
					int temp = arr[r_number].occurances;
					
					// for single query without chunk
					times=1;
					arr[r_number].occurances = arr[r_number].occurances - 1;

					// select a random times 
					
					
/*					if(temp > 29){
						times = rand.nextInt(29);
						arr[r_number].occurances = arr[r_number].occurances - times;
					}
					else {
						times = rand.nextInt(temp);
						arr[r_number].occurances = arr[r_number].occurances - times;
					}
*/	
					/*
	

										r = rand.nextInt(num_unique_query)* (int)((POINTS-10000)/(num_unique_query + rr));
									//cout <<"random value "<< r<< endl;
									//   srand(pow(q,r));
									//   srand(pow(q,r));
									//	times=1;
										times =rand.nextInt(29) + 5 ;

									//		file>>dim;	
									//		file>>num_mbr;	
				*/


						for(int k =0; k<times; k++){
						System.out.println("3");
						i1++;
						pop_query_count++;
//						double r_1= 0.005 + (double)rand.nextInt(500)/10000.0;
						System.out.println("10");

						for(int j=0;j<DIMENSION;j++){
					//			cout<< pt[0][j];
							System.out.print(pt[r][0][j] + "\t");

							}

						System.out.println("");
						}


					}
					else if (nonpop_query_count < (q*(100-distribution)/100)){							// nonpopular data 
	
						for(int idx =0 ; idx < 20 ; idx++){
	
								r = rand.nextInt(POINTS);



							System.out.println("3");
							i1++;
							nonpop_query_count++;
							
							//double r_1= 0.005 + (double)rand.nextInt(500)/10000.0;
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
	
	
	public static void create_map(mapping[] arr, int POINTS, int SLOT_QUERY, int FREQ_POINTS){
	
			Random rand = new Random();
        
        	//frequency function
//        	int FREQ_POINTS=25;
//        	int SLOT_QUERY=10000;
        	int[] frequency = new int[FREQ_POINTS];
        	double[] x = new double[FREQ_POINTS];
        	double[] y = new double[FREQ_POINTS];
        	double sum=0.0;
        	double[] result = new double[FREQ_POINTS];
        
        	int j=0;
        	//x-values are set
        	for(float i=0;i<15;i+=0.6)
                x[j++]=i;
        
        	//y-values and sum are being set
            for(j=0;j<FREQ_POINTS;j++){
                    y[j]=Math.pow(1.5,x[j]);
                    sum+=y[j];
            }
            
            for(j=0;j<FREQ_POINTS;j++){
                result[j] = (y[j]/sum) * SLOT_QUERY;
                frequency[j] = (int)(result[j]+1);
            }
                
			for(int i=0; i< arr.length; i++){
				arr[i] = new mapping();
				arr[i].index = rand.nextInt(POINTS);
				arr[i].occurances = frequency[i];
				
//				System.out.println(arr[i].index + " " + arr[i].occurances );
			}
	}
}
