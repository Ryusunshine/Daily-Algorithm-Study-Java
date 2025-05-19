package org.example.해시;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class 프로그래머스_해시_신고결과받기 {
    static String[] id_list;
    static String[] report;
    static int k;
    public static void main(String[] args) {
        int[] answer = new int[id_list.length];
        //  notifyList
        // key = 신고당한 사람, value = 신고한 사람

        //reporterList
        // key = 신고한사람, value = 몇번 신고했는지

        // 중복은 문제 초반에 제거하자!!!

        //1. 중복제거
        // HashSet를 사용하여 report의 중복된 정보를 제거한다.
        HashSet<String> reporterSet = new HashSet<>();
        for (String rep : reporterSet) reporterSet.add(rep);

        //2. 신고자목록
        // key = 신고한 사람, value = 신고를 당한 사람 리스트
        // hash로 각 사용자를 신고한 사람들의 목록을 관리한다.
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for (String rep : reporterSet){
            String[] arr = rep.split(" ");
            String reportee = arr[0]; // 신고 당한 사람
            String reporter = arr[1]; // 신고한 사람
            // 신고당한 사람이 Key, 신고한 사람을 arrayList<> 타입의 value
            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
            // Null값이 가져오는것은 신고당한적이 없다는것을 의미
            if (reporterList == null) reporterList = new ArrayList<>();

            reporterList.add(reporter);
            notifyListHash.put(reportee, reporterList); // notifyListHash 수정
        }

        // notifyList 기반으로 ReporterHash 만들기
        // 신고당한 사람(key)의 신고한 사람의 리스트(value)가 k 이상이면
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for (ArrayList<String> notifier : notifyListHash.values()){
            if (notifier.size() >= k){
                for (String reporter : notifier){
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0)+1);
                }
            }
        }

        // reporterHash를 기반으로 answer 배열을 채운다.
        for (int i = 0; i < id_list.length; i++){
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
        }
//        return answer;
    }
}
