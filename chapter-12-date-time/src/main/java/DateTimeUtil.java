import java.time.*;
import java.time.chrono.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class DateTimeUtil {
    public void localDateExample() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        LocalDate now = LocalDate.now();

        LocalDate parsedDate = LocalDate.parse("2014-03-18");
    }

    public void localDateAndChronoExample() {
        LocalDate now = LocalDate.now();
        int year = now.get(ChronoField.YEAR);
        int month = now.get(ChronoField.MONTH_OF_YEAR);
        int day = now.get(ChronoField.DAY_OF_MONTH);
    }

    public void localTimeExample() {
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalTime parsedTime = LocalTime.parse("13:45:20");
    }

    public void combiningDateTime() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }

    public void instantExample() {
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(3, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);
    }

    public void durationExample() {
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.now();

        Duration d1 = Duration.between(time1, time2);
    }

    public void periodExample() {
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
    }

    public void dateManipulationExample() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);
    }

    public void temporalAdjustersExample() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
    }

    public void formattingDates() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public void parsingDates() {
        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public void creatingDateTimeFormatterExample() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
    }

    public void creatingRegionalDateTimeFormatterExample() {
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(italianFormatter);
        LocalDate date2 = LocalDate.parse(formattedDate, italianFormatter);
    }

    public void creatingDateTimeFormatterFromBuilder() {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendText(ChronoField.DAY_OF_MONTH)
                                                                    .appendLiteral(". ")
                                                                    .appendText(ChronoField.MONTH_OF_YEAR)
                                                                    .appendLiteral(" ")
                                                                    .appendText(ChronoField.YEAR)
                                                                    .parseCaseInsensitive()
                                                                    .toFormatter(Locale.ITALIAN);
    }

    public void timezoneExample() {
        ZoneId romeZone = ZoneId.of("Europe/Rome");
        LocalDate date = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        Instant instant = Instant.now();
        ZonedDateTime ztd3 = instant.atZone(romeZone);

        LocalDateTime timeFomInstant = LocalDateTime.ofInstant(instant, romeZone);
    }

    public void timezoneOffsetExample() {
        ZoneOffset newYorkOffSet = ZoneOffset.of("-05:00/");

        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime, newYorkOffSet);
    }

    public void alternativeCalendarSystemsExample() {
        // Japanese
        LocalDate date = LocalDate.now();
        JapaneseDate japaneseDate = JapaneseDate.from(date);

        Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate chronoNow = japaneseChronology.dateNow();

        // Islamic
        HijrahDate ramadanDate = HijrahDate.now()
                                           .with(ChronoField.DAY_OF_MONTH, 1)
                                           .with(ChronoField.MONTH_OF_YEAR, 9);

        System.out.println("Ramadan stats on " + IsoChronology.INSTANCE.date(ramadanDate) + "and ends on " +
                IsoChronology.INSTANCE.date(ramadanDate.with(TemporalAdjusters.lastDayOfMonth())));
    }
}