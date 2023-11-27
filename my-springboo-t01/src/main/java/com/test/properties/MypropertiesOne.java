package com.test.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ConfigurationProperties(prefix = "mytest.pinfo")
@Data
@ToString
public class MypropertiesOne {

    private String myStr;

    private Integer myInt;

    private Double myDouble;

    private Boolean myBoolean;

    public Integer[] myIntArray;

    public  String[] myStrArray;

    private List<Integer> myIntList;

    private List<String> myStrList;

    private Set<Integer> myIntSet;

    private Set<String> myStrSet;

    private Map<Integer,Integer> myIntIntMap;

    private Map<String,String> myStrStrMap;

    private Map<Integer,String> myIntStrMap;

    private Map<String ,Integer> myStrIntMap;


    @Override
    public String toString() {
        return "MypropertiesOne{" +
                "myStr='" + myStr + '\'' +
                ", myInt=" + myInt +
                ", myDouble=" + myDouble +
                ", myBoolean=" + myBoolean +
                ", myIntArray=" + Arrays.toString(myIntArray) +
                ", myStrArray=" + Arrays.toString(myStrArray) +
                ", myIntList=" + myIntList.toString() +
                ", myStrList=" + myStrList.toString() +
                ", myIntSet=" + myIntSet.toString() +
                ", myStrSet=" + myStrSet.toString() +
                ", myIntIntMap=" + myIntIntMap.toString() +
                ", myStrStrMap=" + myStrStrMap.toString() +
                ", myIntStrMap=" + myIntStrMap.toString() +
                ", myStrIntMap=" + myStrIntMap.toString() +
                '}';
    }
}
