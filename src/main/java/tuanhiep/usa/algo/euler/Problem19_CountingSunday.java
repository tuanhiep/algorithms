package tuanhiep.usa.algo.euler;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem19_CountingSunday {
    public static void main(String[] args) {
        System.out.println(findSumSunday(1901, 2000));
    }

    private static long findSumSunday(int startYear, int endYear) {
        long sum = 0;
        for (int i = startYear; i <= endYear; i++) {
            sum += findSumSunday(i);
        }
        return sum;
    }

    private static long findSumSunday(int year) {
        long sum = 0;
        long[] indexFirstDays = getIndexFirstDayOfMonth(year, isLeapYear(year));
        for (long index : indexFirstDays) {
            if (index % 7 == 0) {
                sum++;
            }
        }
        return sum;

    }

    private static long[] getIndexFirstDayOfMonth(int year, boolean leapYear) {
        long[] indexes = new long[12];
        if (year < 1900) return null;
        long index = getIndexOfFirstDayYear(year);
        int i = 0;
        indexes[i] = index;
        i++;
        indexes[i] = indexes[i - 1] + 31;// January
        i++;
        if (isLeapYear(year)) {
            indexes[i] = indexes[i - 1] + 29;// February
        } else {
            indexes[i] = indexes[i - 1] + 28;
        }
        i++;
        indexes[i] = indexes[i - 1] + 31;// Mars
        i++;
        indexes[i] = indexes[i - 1] + 30;// April
        i++;
        indexes[i] = indexes[i - 1] + 31;// May
        i++;
        indexes[i] = indexes[i - 1] + 30;// June
        i++;
        indexes[i] = indexes[i - 1] + 31;// July
        i++;
        indexes[i] = indexes[i - 1] + 31;// August
        i++;
        indexes[i] = indexes[i - 1] + 30;// September
        i++;
        indexes[i] = indexes[i - 1] + 31;// October
        i++;
        indexes[i] = indexes[i - 1] + 30;// November

        return indexes;
    }

    private static long getIndexOfFirstDayYear(int year) {
        if (year < 1900) return -1;
        int index = 1;
        for (int i = 1900; i < year; i++) {
            if (isLeapYear(i)) {
                index += 366;
            } else {
                index += 365;
            }
        }
        return index;

    }

    private static boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else {
            return year % 4 == 0;
        }
    }


}
