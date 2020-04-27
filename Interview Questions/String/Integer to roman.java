// https://www.interviewbit.com/problems/integer-to-roman/

public class Solution {
    int[] divStore = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,4,1}; 
    String [] romanStore = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V","IV","I"}; 
    public String intToRoman(int num) {
        return getConversion(num);
    }
    private String getConversion(int num){
        if(num==0){
            return "";
        }
        int idx = getDivisor(num);
        return romanStore[idx]+ getConversion(num-divStore[idx]);    
    }
    
    private int getDivisor(int num){
        for(int i=0; i<divStore.length; i++){
            if(num/divStore[i] != 0){
                return i;
            }
        }
        return -1;
    }
}
