package yashpc.commonCodingChallenges;

import java.util.*;
import java.util.function.Function;

public class SumOfListElementsAfterOperation {
    public static void main(String[] args){

        List<Integer> num = Arrays.asList(10,10,10,10);
        int sizeOfInitialArray = num.size();
        int k = 15; // means 4 times we need to do the operation

        //List to hold the sum of all elements
        List<Integer> listToHoldSum = new ArrayList<>();

        Function<List<Integer>, Integer> calculateSumOfArray =
                list -> list.stream()
                        .mapToInt(s -> s)
                        .sum();

        listToHoldSum.add(calculateSumOfArray.apply(num)); // inserting max sum to the list
        List<Integer> tempList1 = new ArrayList<>(num);

        int ul1 = 0;
        int ul2 = 0;
        //Check if Number of operations is more than initial size of array
        if(k > sizeOfInitialArray) {
            //setting upper limit for both the iterations
            ul1 = sizeOfInitialArray;
            ul2 = k - sizeOfInitialArray;
        }else{
            ul1 = k;
        }
        int count = 0;
        for(int i = 0; i<ul1 ; i++){
            double ceiling = num.get(i).doubleValue() / 2;
            tempList1.remove(i);
            tempList1.add(i, (int)Math.round(ceiling));
            listToHoldSum.add(calculateSumOfArray.apply(tempList1));
            count++;
        }
        int maxLimit = 0;
        if(ul2 > sizeOfInitialArray){
            maxLimit = sizeOfInitialArray;
        }else{
            maxLimit = ul2;
        }
        while(ul2 >0) {
          //check if all elements of num is equal to 1 then break;
            boolean numListCompletelyIterated =
                    tempList1.stream()
                    .mapToInt(s->s)
                    .allMatch(e -> e ==1);

//            for(int m = 0; m < num.size(); m++){
//                if(num.get(0) == 1){
//                    numListCompletelyIterated = true;
//                }
//            }
          if(numListCompletelyIterated || count == k){
              break;
          }else{
              // swapping value of tempList1 to num, for iteration over remaining number of operations
              num = tempList1;
          }
//            int maxLimit = 0;
//            if(ul2 > sizeOfInitialArray){
//                maxLimit = sizeOfInitialArray;
//            }else{
//                maxLimit = ul2;
//            }
            for (int j = 0; j < maxLimit; j++) {
                if(count != k) {
                    double ceiling = num.get(j).doubleValue() / 2;
                    tempList1.remove(j);
                    tempList1.add(j, (int) Math.round(ceiling));
                    //num.add(i, (int)Math.round(ceiling));
                    listToHoldSum.add(calculateSumOfArray.apply(tempList1));
                    count++;
                }
            }

            ul2--;
            //}
        }
        //Sorting list holding sum in ascending order, thus minimum sum will be at index 0
        Collections.sort(listToHoldSum);
        listToHoldSum.forEach(s -> System.out.println("TempList: "+s));
        //return listToHoldSum.get(0);

    }
}
