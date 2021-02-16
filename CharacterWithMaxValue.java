package yashpc.commonCodingChallenges;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
For string = "AbcBaaDbb", return uppercase character with maximum Hashcode value,
 which contains lowerCase as well as upperCase of the same character
  result: B
 */
public class CharacterWithMaxValue {

    public static void main(String[] args){
        //sample string
        String str = "AbcBaaDbb";
        System.out.println(characterWithMaxValue(str));

    }

    public static String characterWithMaxValue(String str){

        List<Character> characterList =  str.chars()
                .mapToObj( c -> (char)c)
                .collect(Collectors.toList());
        //characterList.forEach(System.out::println);

        //Function to compute HashCode of a Character
        Function<Character, Integer> hashCodeFun =
                ch -> ch.hashCode();

        List<Character> finalCharacterList = characterList.stream()
                .distinct() // ABDabc
                //.map(c -> c.hashCode()) // A=65, B=66, D=68, a=97, b=98, c=99
                .sorted(Comparator.comparing(hashCodeFun).reversed()) //sorting in descending order
                .filter( c -> characterList.contains(Character.toUpperCase(c)) && characterList.contains(Character.toLowerCase(c)))
                .collect(Collectors.toList());

        //System.out.println("Maximum value character: "+Character.toUpperCase(finalCharacterList.get(0)));
        return Character.toString(Character.toUpperCase(finalCharacterList.get(0)));
    }
}
