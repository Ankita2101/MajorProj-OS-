import java.util.*;
class Bankers2
{
    int claim[][],alloc[][],av[],need[],p,r,alsum[],sum,temp[][];
    int a=0,b=0,c;
    boolean flag;
    Scanner src = new Scanner(System.in);
    Bankers2(int p,int r)
    {
          this.p=p;
          this.r=r;
          claim=new int[p][r];
          alloc=new int[p][r];
          av=new int [r];
          need=new int [r];
          alsum=new int[r];
          temp=new int[p][r];
          System.out.println("ENTER THE "+r+" VALUES IN AVAILABLE MATRIX");
          for(int i=0;i<r;i++)
          {
              av[i]=src.nextInt();
          }
          System.out.println("ENTER THE CLAIM MATRIX OF "+p+" X "+r+":");
          for(int i=0;i<p;i++)
                 for(int j=0;j<r;j++)
                         claim[i][j]=src.nextInt();
          System.out.println("ENTER THE ALLOCATION MATRIX OF "+p+" X "+r+":");
          for(int i=0;i<p;i++)
                   for(int j=0;j<r;j++)
          alloc[i][j]=src.nextInt();               
     }
     public void calNeed()
     {
         for(int i=0;i<r;i++)
         {
                 for(int j=0;j<p;j++)
                 {
                     sum=sum+alloc[j][i];                  
                 }
                 alsum[i]=sum;
                 sum=0;
          }
          for(int i=0;i<r;i++)
          {
              need[i]=av[i]-alsum[i];
              System.out.print("Initial Need Vector ");
              System.out.print(need[i]);
              System.out.println();
              System.out.println(); 
          }      }
      public void checkNeed()
      { 
          for( int i=0;i<p;i++)
                 for(int j=0;j<r;j++)
                 {
                          temp[i][j]=claim[i][j]-alloc[i][j];
                 }    }
      public void compareNeed()
      {
       while(b<p)
       {
         flag=false;
         for(int i=0;i<p;i++)
        {
           for(int j=0;j<r;j++)
           { 
              if(temp[i][0]==89)
                     break;
              if(temp[i][j]<=need[j])
                 a++ ;
              else break;
           }
           if(a==r)
           {
              System.out.println("Process P"+(i+1)+" is Completed");
              addtoNeed(i);
              temp[i][0]=89;
              a=0;
              c++;
              flag=true;
           }
          if(flag==true)
              break;
        }
        b++;
       }
      }
      public void addtoNeed(int k)
      {
            int n=k;
            for(int j=0;j<r;j++)
            {
               need[j]=need[j]+alloc[n][j];
            }  
             if(c==p)
                     System.out.println("SYSTEM IS IN SAFE STATE");           
            else
System.out.println("SYSTEM IS NOT IN SAFE STATE");           
      }
 }
class BankerExp1
{
       public static void main(String args[])
       {  
           Scanner src = new Scanner(System.in);
           System.out.println("ENTER THE NO. OF PROCESS");
           int p= src.nextInt();
           System.out.println("ENTER THE NO. OF RESOURCES");
           int r = src.nextInt();
           Bankers2 obj = new Bankers2(p,r);                                
           obj.calNeed();
           obj.checkNeed();
           obj.compareNeed(); 
        }
}      