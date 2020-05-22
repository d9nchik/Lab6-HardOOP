package com.d9nich.exercise2;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.*;

public class JoyEvent implements Serializable {//immutable class
    private final GregorianCalendar date;
    private final String type;
    private final String eventCondition;
    private double price;
    private double beforeAmountCoefficient;

    public JoyEvent(GregorianCalendar date, String type, double price, String eventCondition, double beforeAmountCoefficient) {
        this.date = date;
        this.type = type;
        setPrice(price);
        this.eventCondition = eventCondition;
        setBeforeAmountCoefficient(beforeAmountCoefficient);
    }

    public JoyEvent(GregorianCalendar date, String type, double price) {
        this(date, type, price, "", 1);
    }

    public static JoyEvent generateEvent(GregorianCalendar month) {
        String[] type = {"circus", "zoo", "aqua park", "trip to Hoverla", "camp in nearest forest", "roller skates",
                "cinema", "McDonald", "park picnic", "Ice cream cafe"};
        int daysInMonth = month.getActualMaximum(Calendar.DAY_OF_MONTH);
        final Random random = new Random();
        return new JoyEvent(new GregorianCalendar(month.get(Calendar.YEAR),
                month.get(Calendar.MONTH), random.nextInt(daysInMonth) + 1), type[random.nextInt(type.length)],
                random.nextInt(2000));
    }

    public static JoyEvent[] generateEventsForCurrentMonth(int number) {
        JoyEvent[] events = new JoyEvent[number];
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        for (int i = 0; i < number; i++)
            events[i] = generateEvent(gregorianCalendar);
        Arrays.sort(events, Comparator.comparingLong(e -> e.date.getTime().getTime()));
        return events;
    }

    public GregorianCalendar getGregorianCalendar() {
        return (GregorianCalendar) date.clone();
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        if (price >= 0)
            this.price = price;
        else
            throw new InputMismatchException("Price can`t be negative number");
    }

    public String getEventCondition() {
        return eventCondition;
    }

    public double getBeforeAmountCoefficient() {
        return beforeAmountCoefficient;
    }

    private void setBeforeAmountCoefficient(double beforeAmountCoefficient) {
        if (beforeAmountCoefficient >= 0 && beforeAmountCoefficient <= 1)
            this.beforeAmountCoefficient = beforeAmountCoefficient;
        else
            throw new InputMismatchException("BeforeAmountCoefficient should be a float number between 0 and 1");
    }

    @Override
    public String toString() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return "JoyEvent{" +
                "date=" + dateFormat.format(date.getTime()) +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", eventCondition='" + eventCondition + '\'' +
                ", beforeAmountCoefficient=" + beforeAmountCoefficient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JoyEvent joyEvent = (JoyEvent) o;

        if (!date.equals(joyEvent.date)) return false;
        return type.equals(joyEvent.type);
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
