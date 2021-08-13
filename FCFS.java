import java.util.*;
public class FCFS
{
	public static void main(String args[])
	{
		int [][] arr = new int[6][6];
		int flag = 0 ;
		int data = 0 ;
		float avgWaitingTime = 0 ;
		Scanner in = new Scanner(System.in);
		for(int i = 0 ; i < 5; i++)  // for instering data about process
		{
			arr[i][0] = i ;
			for(int j = 1; j < 3 ; j++)
			{
					if(flag == 0)
					{
							System.out.print("Enter Arival Time FOR PID "+ i + " => ");
							arr[i][j] =in.nextInt();
							flag++;
					}else
					{
							System.out.print("Enter Burst Time FOR PID "+ i +" => ");
							arr[i][j] =in.nextInt();						
							flag--;
					}
					
			}
		}
		//	for calucating Compition Time
		for(int i = 0; i < 5; i++)	
		{
			for(int arTC = 1,brTC = 2, cmTC = 3 ; brTC < 3; brTC++,cmTC++,arTC++)
			{	
				 // Arival Time Should <=  Brust Time
			if(i != 0)
			{
					if( arr[i][arTC] > arr[i-1][cmTC]  ){
						//System.out.println("G = "+arr[i][brTC]);
							data = arr[i][arTC] - arr[i-1][cmTC] + arr[i][brTC]+arr[i-1][cmTC];
							arr[i][cmTC] = data ;
							//System.out.print("data" +data);

						}
						else{
							
							data = arr[i][brTC] + data ;  // arr[i][brTC] is brust Time
							arr[i][cmTC] = data ;			// arr[i][cmTC] is complition Time
						} 
			}else{
						
					
							data = arr[i][brTC] + arr[i][arTC] ;  // arr[i][brTC] is brust Time
							arr[i][cmTC] = data ;			// arr[i][cmTC] is complition Time
			}


			}
		}
		
		// for calucating Turn Aroundtime
		for(int i = 0; i < 5; i++)
		{
			for(int j = 4,cmTC = 3,arTC = 1; j < 5;j++)
			{
				arr[i][j] = arr[i][cmTC] - arr[i][arTC];
			}
		}
		// for calucating waiting Time
		for(int i = 0; i < 5; i++)
		{
			for(int j = 4,wtTC =5, brTC = 2; j < 5;j++)
			{
				arr[i][wtTC] = arr[i][j] - arr[i][brTC];
				avgWaitingTime = arr[i][wtTC] + avgWaitingTime;
			
			}
		}
		//for Display Result
		System.out.println("\n------------------------------------------------------------\n");
			System.out.println("\tPID \tAT \tBT \tCT \tTAT \tWT") ; 
	 	   for(int i = 0 ; i < 5; i++)
		   {
			for(int j = 0; j < 6 ; j++)   
				{
					System.out.print("\t"+arr[i][j]) ; 
					
				}
					System.out.println();
		   }
		System.out.println("\n------------------------------------------------------------\n");   
		System.out.printf("Average Waiting Time = %.2f",(avgWaitingTime/5));
		//System.out.println(df.s)
	}
}
