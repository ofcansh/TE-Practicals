import java.util.Scanner;

public class FirstFit {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int blockSize[] = {100, 500, 200, 300, 600}; 
        int job[] = {212, 417, 112, 426}; 
        int m = blockSize.length; 
        int n = job.length; 
        int busy[]= new int[m];
		int mu=0;
        int allocation[] = new int[n];
        
        for (int i = 0; i < allocation.length; i++) 
        {
        	allocation[i] = -1; 
        }
        
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<m;j++)
        	{
        		if(job[i]<= blockSize[j] && busy[j]==0)
        		{
        			allocation[i]=j;
                    System.out.println("Job " + i + " (size " + job[i] + ") allocated to block " + j + " (size " + blockSize[j] + ")");
        			busy[j]=1;
        			mu=mu + job[i];
        			break;
        			
        		}
        	}
        }
        for (int i = 0; i < n; i++) {
            if (allocation[i] != -1) {
                System.out.println("Job " + i + " allocated to block " + allocation[i]);
            } else {
                System.out.println("Job " + i + " not allocated");
            }
        }
	}
}