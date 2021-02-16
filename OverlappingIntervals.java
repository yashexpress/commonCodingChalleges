package yashpc.commonCodingChallenges;

import java.util.*;

/*
Example: you have three lists:
1) Start time of courses  e.g: [10,5,15,18,30]
2) Duration of courses   e.g: [30,12,20,25,35]
3) total credits of courses  e.g:[50,51,20,25,10]

Objective: calculate maximum of credits a student can take
 */
public class OverlappingIntervals {
    public static void main(String[] args){

        List<Integer> start = Arrays.asList(10,5,15,18,30);
        List<Integer> duration = Arrays.asList(30,12,20,25,35);
        List<Integer> credits = Arrays.asList(50,51,20,25,10);

        List<Course> courseList = new ArrayList<>();
        Course[] courseArray = new Course[start.size()];
        for(int i=0; i< start.size(); i++){
            Course cObj = new Course(start.get(i), duration.get(i), credits.get(i));
            courseList.add(cObj);
        }
//        for(int i =0; i<courseList.size(); i++){
//            System.out.println(courseList.get(i));
//        }

        courseList.sort(Comparator.comparing(Course::getEndTime));
        //courseList.forEach(System.out::println);

        List<Integer> maxCreditList = new ArrayList<>();
        for(int i=0; i<courseList.size();i++){
            for(int j=i+1; j<courseList.size();j++){
                if(courseList.get(i).getEndTime() < courseList.get(j).getStartTime()){
                    int maxCredit = courseList.get(i).getCredits() +
                            courseList.get(j).getCredits();
                    maxCreditList.add(maxCredit);
                }
            }
        }
        maxCreditList.forEach(System.out::println);
        OptionalInt optionalForMax = maxCreditList.stream()
                .mapToInt(s->s)
                .max();
        if(optionalForMax.isPresent()){
            System.out.println("Maximum credit: "+optionalForMax.getAsInt());
        }

    }
}


