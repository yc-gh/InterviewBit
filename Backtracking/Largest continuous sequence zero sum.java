//https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/

public int[] lszero(int[] a) {
HashMap<Integer,Integer> h=new HashMap<>();
h.put(0,-1);
int n=a.length;
int s=0,x=0,len=0,in=0;
for(int i=0;i<n;i++){
s=s+a[i];

        if(h.containsKey(s)){
            x=i-h.get(s);
        }
        else
        h.put(s,i); 
        if(len<x){
            len=x;
            in=i;
        }
    }
    int r[]=new int[len];
    int j=0;
    for(int i=in-len+1;i<=in;i++){
        r[j]=a[i];
        j++;
    }
    return r;
}
