package yashpc.commonCodingChallenges;

import java.util.Arrays;
import java.util.List;

public class RegexStringParsing {

    public static void main(String[] args){
        String str ="'a','b','c,d'";
        String delims = ",";
        String tempStr = str.replaceAll("'","");
        String[] tokens = tempStr.split(delims);

        List<String> listOfString = Arrays.asList(tokens);
        //String finalString="";
        StringBuilder stringBuilder = new StringBuilder();
        for(String s: listOfString){
            stringBuilder.append(s +" ");
            //finalString += s +" ";
        }
        stringBuilder.insert(0,"START ");
        stringBuilder.insert(stringBuilder.length()-1," END");

        //finalString = "START "+finalString+"END";
        System.out.println(stringBuilder.toString());
    }
}
