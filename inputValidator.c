#include<stdio.h>
#include<stdlib.h>

int main(int argc, char* argv[]){

	if(argc!=3){
		printf("\nUSAGE: ./executable <no_of_dimensions> <INSERT/OTHER>  <  <file_to_be_tested>\n");
		printf("\nEXPECTATION : \nINSERT QUERIES HAVE 3 LINES EACH\n0\nVALUES AS PER NUMBER OF DIMENSIONS\nVALUES AS PER NUMBER OF DIMENSIONS");
		printf("\n\nRANGE/KNN QUERIES HAVE 3 LINES EACH\n2/3\nRANGE_RADIUS/NO_OF_NEIGHBOURS\nVALUES AS PER NUMBER OF DIMENSIONS\n\n");
		exit(1);
	}

	int ch=0,ic,dim,cnt=0;
	double val;
	sscanf(argv[1],"%d",&dim);
	do{

		cnt++;
		scanf("%d",&ch);
		if(ch!=0 && ch!=2 && ch!=3){
			if(ch==-1)
				break;
			printf("ERROR :\nQUERY NUMBER %d\n",cnt);
			printf("LINE NUMBER %d\n",(cnt-1)*3);
			printf("VALUE OF READ CHARACTER %d\n",ch);
			printf("ERROR: INVALID FILE\n");
			exit(1);
		}
		if(strcmp("INSERT",argv[2])==0)
		{
			for(ic=0;ic<dim;ic++)
				scanf("%lf",&val);
			for(ic=0;ic<dim;ic++)
				scanf("%lf",&val);
		}
		else
		{
			scanf("%lf",&val);
			for(ic=0;ic<dim;ic++)
				scanf("%lf",&val);
		}
	}while(1);

	printf("SUCCESS: VALID FILE\n");
	return 0;
}

	
