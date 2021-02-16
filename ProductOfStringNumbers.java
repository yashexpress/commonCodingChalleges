package yashpc.commonCodingChallenges;

import java.util.HashMap;
import java.util.Map;

public class ProductOfStringNumbers {
    public static void main(String args[]){
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("One", 1);
        map1.put("two", 2);
        map1.put("three", 3);
        map1.put("four", 4);
        map1.put("five", 5);

        int product = 0;
        int n = 4;
        product = n * map1.get("two");
        System.out.println(product);
    }
}
