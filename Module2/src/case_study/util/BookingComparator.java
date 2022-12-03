package case_study.util;

import case_study.model.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {
    public int compare(Booking o1, Booking o2) {
        if (o1.getStartDay().compareTo(o2.getEndDay())>0){
            return 1;
        }else if (o1.getStartDay().compareTo(o2.getEndDay())<0){
            return -1;
        }else {
            return Integer.compare(o1.getEndDay().compareTo(o2.getEndDay()), 0);
        }

    }
}
