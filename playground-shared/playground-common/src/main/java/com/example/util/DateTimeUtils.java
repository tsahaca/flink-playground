package com.flink.playground.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Utility class for working with DateTime conversion
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateTimeUtils {
    private static final ZoneId UTC = ZoneId.of("UTC");
    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");

    /**
     * Converts timestamp into String of "yyyy-MM-dd HH:mm:ss.SSSSSS" in UTC time zone
     */
    public static String format(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(UTC).format(DATE_TIME);
    }

    /**
     * Converts Joda LocalDate to Java LocalDate
     */
    public static LocalDate convert(org.joda.time.LocalDate jodaDate) {
        return jodaDate == null ? null : LocalDate.of(jodaDate.getYear(), jodaDate.getMonthOfYear(), jodaDate.getDayOfMonth());
    }

    /**
     * Converts Java LocalDate to Joda LocalDate
     */
    public static org.joda.time.LocalDate convert(LocalDate javaDate) {
        return javaDate == null ? null : new org.joda.time.LocalDate(javaDate.getYear(), javaDate.getMonthValue(), javaDate.getDayOfMonth());
    }

    public static LocalDate convert(Instant instant) {
        return instant == null ? null : LocalDate.ofInstant(instant, UTC);
    }
}
