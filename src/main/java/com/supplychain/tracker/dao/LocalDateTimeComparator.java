package com.supplychain.tracker.dao;

import java.time.LocalDateTime;
import java.util.Comparator;

public class LocalDateTimeComparator implements Comparator<LocalDateTime> {

    // return positive integer if t1 is after t2: return 1
    // return negative integer if t1 is before t2: return -1
    // return zero if both the LocalDateTime objects are equal: return 0
    @Override
    public int compare(LocalDateTime t1, LocalDateTime t2) {
        if(t1.isAfter(t2)) {
            return 1;
        } else if (t2.isAfter(t1)) {
            return -1;
        } else {
            return 0;
        }
    }
}
