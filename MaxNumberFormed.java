package yashpc.commonCodingChallenges;

public class MaxNumberFormed {
    public static void main(String[] args){
        int num = 256;
        //need to get how many times a digit is present in an array
        int[] digitCount = new int[10];
        //converting Number to String so we can add that to array
        String numString = Integer.toString(num);
        //count number of occurence of each digit in the String
        for(int i=0; i<numString.length(); i++){
            //numString.charAt(i) refers to each digit present in the string
            // numString.charAt(i) - '0' refers to the index of the array, e.g:
            // if numString.charAt(i) = 2, then numString.charAt(i) - '0' = 2nd index of the array

            //digitCount[numString.charAt(i) - '0'] + 1 refers to Number of times that index is read,
            //so it will just add 1 each time to count the occurence of each index
            digitCount[numString.charAt(i) - '0'] = digitCount[numString.charAt(i) - '0'] + 1;
        }

        int result = 0;
        int multiplyFactor = 1;
        // example: for num=256, max possible number is 652 with this combination
        // 652 = 2*10^0 + 5*10^1 + 6*10^2
        //     = 2*1    + 5*10  +  6*100
        for(int i =0; i<digitCount.length; i++){
            while(digitCount[i] > 0){
                result = result + ( i * multiplyFactor);
                digitCount[i]--;
                multiplyFactor = multiplyFactor * 10;
            }
        }

        System.out.println("Maximum Number using this combination: "+ result);
    }
}
