package org.me.treasurehunter.utils;

public final class IterableUtility {
    public static boolean sameSize(Iterable<?> obj1, Iterable<?> obj2) {
        int obj1index = 0;
        int obj2index = 0;
        for(Object ignored : obj1) {
            obj2index++;
        }
        for(Object ignored : obj2) {
            obj1index++;
        }
        return obj1index == obj2index;
    }
}
