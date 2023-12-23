package com.homeworktests;

import java.util.List;

public class FindMatching{

public static void main(String[] args){
    List<Double> testList = List.of(10.0, 15.45, 5.811, 175.0);
    FindMatching findMatching=new FindMatching();
    Double actual=findMatching.findFirst(testList,4.0,9.3);
    Double expected = 5.811; 
    System.out.println("actual("+actual+") is equals expected : "+(actual.equals(expected)));
}

public Double findFirst(List<Double> list,Double lowerLimit,Double upperLimit){
    for(Double item:list){
        if(item>=lowerLimit&&item<=upperLimit){
            return item;
        }
    }
    return null;
}
}
