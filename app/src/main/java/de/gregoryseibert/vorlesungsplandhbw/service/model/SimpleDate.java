package de.gregoryseibert.vorlesungsplandhbw.service.model;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Gregory Seibert on 10.01.2018.
 */

public class SimpleDate {
    private Calendar c;
    private SimpleDateFormat sdfDateTime, sdfDate, sdfTime;

    public SimpleDate(int day, int month, int year, int hour, int minute) {
        c = Calendar.getInstance();
        c.set(year, month, day, hour, minute);
        initSimpleDateFormat();
    }

    public SimpleDate(SimpleDate date) {
        c = Calendar.getInstance();
        c.setTimeInMillis(date.getMillis());
        initSimpleDateFormat();
    }

    public SimpleDate() {
        c = Calendar.getInstance();
        initSimpleDateFormat();
    }

    private void initSimpleDateFormat() {
        sdfDateTime = new SimpleDateFormat("HH:mm 'Uhr, am' dd.MM.yyyy", Locale.GERMAN);
        sdfDate = new SimpleDateFormat("EEEE, dd.MM.yyyy", Locale.GERMAN);
        sdfTime = new SimpleDateFormat("HH:mm", Locale.GERMAN);
    }

    public boolean isSameDay(SimpleDate date) {
        return this.getFormatDate().equals(date.getFormatDate());
    }

    public boolean isSameWeek(SimpleDate date) {
        return this.getYear() == date.getYear() && this.getWeek() == date.getWeek();
    }

    public void addDays(int amount) {
        c.add(Calendar.DAY_OF_MONTH, amount);
    }

    public void setDay(int day) {
        c.set(Calendar.DAY_OF_MONTH, day);
    }

    public int getDay() {
        return c.get(Calendar.DAY_OF_MONTH);
    }

    public int getWeek() { return c.get(Calendar.WEEK_OF_YEAR); }

    public int getMonth() {
        return c.get(Calendar.MONTH);
    }

    public int getYear() {
        return c.get(Calendar.YEAR);
    }

    public long getMillis(){
        return c.getTimeInMillis();
    }

    public String getFormatDateTime() {
        return sdfDateTime.format(c.getTime());
    }

    public String getFormatDate() {
        return sdfDate.format(c.getTime());
    }

    public String getFormatTime() {
        return sdfTime.format(c.getTime());
    }
}