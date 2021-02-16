package yashpc.commonCodingChallenges;

public class ArrayElementsMultiplication {

    public static void main(String[] args){
        int[] a = {1,-2,-3,5};
        int product = 1;
        for(int i=0; i<a.length; i++){
            product = product * a[i];
        }
        if(product > 0){
            System.out.println(1);
        }else if( product < 0)
            System.out.println(-1);
        else
            System.out.println(0);
    }
}
