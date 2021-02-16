package yashpc.commonCodingChallenges;

import java.util.ArrayList;
import java.util.List;

/*
For a String str = "Hello Yash how are you doing",
maximum length of a text message = 5
Thus split the above string so that it could be sent as text messages
Find how many maximum number of text messages will be required to send the complete string.
i.e. in this case the result will be 6
 */
public class StringBrokenAsTextMessage {

    public static void main(String[] args){

        String str = "Hello Yash how are you doing";
        int k = 5;

        //String noSpaceStr = str.replaceAll("\\s", "");
        //String str1 = "";
        int len = str.length();

        List<String> stringList = new ArrayList<>();
        //int k = 2;
        int startIndex = 0;
        int endIndex = k;
        for(int i=0; i<len; i++){
            while(endIndex <= len){
                String temp = str.substring(startIndex, endIndex);
                stringList.add(temp);
                startIndex=endIndex;
                endIndex=endIndex+k;
                if(endIndex > len){
                    String lastTempStr = str.substring(startIndex, len);
                    stringList.add(lastTempStr);
                }
            }
        }
        System.out.println("Total number of texts required: "+stringList.size());
        //stringList.forEach(System.out::println);
    }
}
