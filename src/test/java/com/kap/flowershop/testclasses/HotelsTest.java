package com.kap.flowershop.testclasses;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class HotelsTest {

    @Test
    public void checkGuests() {
        assertEquals(0, maxGuests(new ArrayList<>()));
        assertEquals(1, maxGuests(Collections.singletonList(new MutablePair(1, 2))));
        assertEquals(1, maxGuests(Arrays.asList(new MutablePair(1, 2),
                new MutablePair(2, 3))));
        assertEquals(2, maxGuests(Arrays.asList(new MutablePair(1, 5), new MutablePair(0, 1), new MutablePair(4, 5))));
        assertEquals(2, maxGuests(Arrays.asList(new MutablePair(1, 10), new MutablePair(2, 3), new MutablePair(5, 7))));
    }

/*    int maxGuests(List<Pair<Integer, Integer>> segments) {
        if (CollectionUtils.isEmpty(segments)) {
            return 0;
        }

        Integer size = segments.stream()
                .map(Pair::getValue)
                .max(Comparator.naturalOrder())
                .get();

        int[] arr = new int[size+1];

        for(Pair<Integer, Integer> cur : segments) {
            arr[cur.getKey()]++;
        }

        for(Pair<Integer, Integer> cur : segments) {
            if(arr[cur.getValue()]-1 <= 0) {
                arr[cur.getValue()] = 0;
                continue;
            }
            arr[cur.getValue()]--;
        }

        return Arrays.stream(arr).max().getAsInt();
    }*/

    int maxGuests(List<Pair<Integer, Integer>> segments) {
        if (CollectionUtils.isEmpty(segments)) {
            return 0;
        }

        int result = 0;

        List<Pair<Integer, Integer>> structure = new ArrayList<>();

        segments.forEach(e -> {
            structure.add(Pair.of(e.getKey(), 1));
            structure.add(Pair.of(e.getValue(), -1));
        });

        structure.sort(Pair::compareTo);

        int cur = 0;
        for (Pair<Integer, Integer> pair : structure) {
            cur += pair.getValue();
            result = Math.max(result, cur);
        }

        return result;
    }
}
