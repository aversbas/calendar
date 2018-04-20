package com.calendar;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


class JavaCalendar {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Date time = new Date();
        System.out.println(time);
        GregorianCalendar calendar = new GregorianCalendar();
        int today = calendar.get(Calendar.DAY_OF_MONTH);
        int currentMonth = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int firstDayOfWeek = calendar.getFirstDayOfWeek();

        int calendarMatrix = 0;
        while (dayOfWeek != firstDayOfWeek) {
            calendarMatrix++;
            calendar.add(Calendar.DAY_OF_MONTH, -1);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        }

        String[] weekDayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekDayNames[dayOfWeek]);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        } while (dayOfWeek != firstDayOfWeek);
        System.out.println();
        for (int i = 1; i <= calendarMatrix; i++) {
            System.out.print("    ");
        }

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        do {
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


            String coloredDay;
            if (dayOfMonth == today) {
                coloredDay = ANSI_YELLOW + Integer.toString(dayOfMonth) + ANSI_RESET;
            }
            else if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                    coloredDay = ANSI_RED + Integer.toString(dayOfMonth) + ANSI_RESET;
                }
                else
                    coloredDay = ANSI_PURPLE + Integer.toString(dayOfMonth) + ANSI_RESET;

            System.out.printf("%13s", coloredDay);


            calendar.add(Calendar.DAY_OF_MONTH, 1);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == firstDayOfWeek)
                System.out.println();
        }
        while (calendar.get(Calendar.MONTH) == currentMonth);
    }
}