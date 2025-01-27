package com.google.gson.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes2.dex */
public class PreJava9DateFormatProvider {
    private static String getDateFormatPattern(int i10) {
        if (i10 == 0) {
            return "EEEE, MMMM d, y";
        }
        if (i10 == 1) {
            return "MMMM d, y";
        }
        if (i10 == 2) {
            return "MMM d, y";
        }
        if (i10 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i10);
    }

    private static String getDatePartOfDateTimePattern(int i10) {
        if (i10 == 0) {
            return "EEEE, MMMM d, yyyy";
        }
        if (i10 == 1) {
            return "MMMM d, yyyy";
        }
        if (i10 == 2) {
            return "MMM d, yyyy";
        }
        if (i10 == 3) {
            return "M/d/yy";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i10);
    }

    private static String getTimePartOfDateTimePattern(int i10) {
        if (i10 == 0 || i10 == 1) {
            return "h:mm:ss a z";
        }
        if (i10 == 2) {
            return "h:mm:ss a";
        }
        if (i10 == 3) {
            return "h:mm a";
        }
        throw new IllegalArgumentException("Unknown DateFormat style: " + i10);
    }

    public static DateFormat getUSDateFormat(int i10) {
        return new SimpleDateFormat(getDateFormatPattern(i10), Locale.US);
    }

    public static DateFormat getUSDateTimeFormat(int i10, int i11) {
        return new SimpleDateFormat(getDatePartOfDateTimePattern(i10) + " " + getTimePartOfDateTimePattern(i11), Locale.US);
    }
}
