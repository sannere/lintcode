package solution;

import basicStructure.Record;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution613 {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        if (results == null || results.length == 0) {
            return new HashMap<>();
        }

        Map<Integer, PriorityQueue> map = new HashMap<>();
        Map<Integer, Double> recordMap = new HashMap<>();
        HashSet<Integer> idSet = new HashSet<>();

        for (Record r : results) {
            if (!idSet.contains(r.id)) {
                idSet.add(r.id);
                map.put(r.id, new PriorityQueue());
            }
            map.get(r.id).offer(r.score);
            if (map.get(r.id).size() > 5) {
                map.get(r.id).poll();
            }
        }

        for (int id : idSet) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += (int)map.get(id).poll();
            }
            recordMap.put(id, (double)sum / 5);
        }

        return recordMap;
    }
}
