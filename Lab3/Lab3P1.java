package com.company;

public class Main {

    public static void main(String[] args) {
	 int n=10000;
	 boolean[] isPrime = new boolean[n];
	 for(int i = 2 ; i < n ;i++)
	     isPrime[i] = true;

	 for(int j = 2 ; j*j < n ; j++){
	     if(isPrime[j]){
	         for(int k=j;k*j<n;k++)
	             isPrime[k*j]=false;
	     }
     }
	 int nrp = 0;
	 for (int i=2;i<n;++i)
	     if(isPrime[i]) nrp++;

    int[] lista=new int[nrp];
    int j = 0;
    for(int i = 0;i<n;i++)
        if (isPrime[i]) lista[j++] = i;

     int st=0, dr=j-1;
     while(st<dr){
         if (lista[st]+ lista[dr]== n) break;
         else if (lista[st] + lista[dr]< n) st++;
         else dr--;
     }
     if (lista[st] + lista [dr] == n)
         System.out.println(n + " = " + lista[st] + " " + lista[dr]);
     else
         System.out.println(n +"nu se poare rep ca suma de 2 nrprime");
    }
}
