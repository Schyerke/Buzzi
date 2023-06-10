package org.me.blockdash.utility;

import java.util.List;

public class ListUtility {
    private ListUtility(){

    }

    public static<T> int elementSize(List<T> list) {
        int size = 0;
        for(T t : list) {
            size++;
        }
        return size;
    }
}
