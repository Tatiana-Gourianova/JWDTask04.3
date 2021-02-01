package com.gourianova.service;

import java.util.*;

public class SortByComparator {
    public static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(
                unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static Map<Double,String> sortByComparatorD(Map<Double,String> unsortMap) {

        List<Map.Entry<Double,String>> list = new LinkedList<Map.Entry<Double,String>>(
                unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Double,String>>() {
            public int compare(Map.Entry<Double,String> o1, Map.Entry<Double,String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        Map<Double,String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Double,String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static Map<String, String> sortByComparatorS(Map<String, String> unsortMap) {

        List<Map.Entry<String, String>> list = new LinkedList<Map.Entry<String, String>>(
                unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<String, String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }


}