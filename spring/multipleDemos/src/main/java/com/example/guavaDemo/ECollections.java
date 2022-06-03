package com.example.guavaDemo;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ECollections {
    public static void main(String[] args) {
        //DownCasting
        List<Number> originalList = Lists.newArrayList();
        List<Integer> theList = (List<Integer>) (List<? extends Number>) originalList;

        //Adding an iterable to a collection
        Iterable<String> iter = Lists.newArrayList();
        Collection<String> collection = Lists.newArrayList();
        Iterables.addAll(collection, iter);

        //Check if collection contains elements according to custom matching rule
        Iterable<String> theCollection = Lists.newArrayList("a", "bc", "def");
        boolean contains = Iterables.any(theCollection, new Predicate<String>() {
            @Override
            public boolean apply(final String input) {
                return input.length()==1;
            }
        });
//        assertTrue(contains);


        Iterable<String> theCollection2 = Sets.newHashSet("abcd", "efgh", "ijkl");
        Predicate<String> inputOfLengthOne = new Predicate<String>() {
            @Override
            public boolean apply(String s) {
                return s.length()==1;
            }
        };
        String found = Iterables.find(theCollection2, inputOfLengthOne, null);
        System.out.println(found);



        List<String> values = Lists.newArrayList("a", null, "b", "c");
        Iterable<String> withoutNulls = Iterables.filter(values,
                Predicates.notNull());
        System.out.println(withoutNulls);


        List<String> muttableList = Lists.newArrayList();
        ImmutableList<String> immutableList = ImmutableList.copyOf(muttableList);



        immutableList = ImmutableList.<String> builder().addAll(muttableList).build();


    }



}
