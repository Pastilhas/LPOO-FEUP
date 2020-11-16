package com.aor.numbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListAggregatorTest {

    public List<Integer> helper(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        return list;
    }

    @Test
    public void sum() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int sum = aggregator.sum();

        assertEquals(9, sum);
    }

    @Test
    public void max() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int max = aggregator.max();

        assertEquals(4, max);
    }

    @Test
    public void min() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int min = aggregator.min();

        assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new ListDeduplicator(list));

        assertEquals(4, distinct);
    }

    @Test
    public void distinct2() {

        class ListDeduplicatorStub implements IListDeduplicator{
            private List<Integer> list;

            public ListDeduplicatorStub(ArrayList<Integer> list) {
                this.list = list;
            }

            @Override
            public List<Integer> deduplicate(IListSorter sort) {
                list.add(1);
                list.add(2);
                list.add(4);

                return list;
            }
        }



        List<Integer> list = helper();

        ListAggregator aggregator = new ListAggregator(list);

        int distinct = aggregator.distinct(new ListDeduplicatorStub(new ArrayList<Integer>()));

        assertEquals(3, distinct);
    }
}