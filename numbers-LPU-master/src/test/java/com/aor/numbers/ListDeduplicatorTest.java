package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {

    public List<Integer> helper(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
        return list;
    }

    @Test
    public void deduplicate() {
        List<Integer> list = helper();

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        IListSorter sorter = new ListSorter(list);
        List<Integer> distinct = deduplicator.deduplicate(sorter);

        assertEquals(expected, distinct);
    }
}