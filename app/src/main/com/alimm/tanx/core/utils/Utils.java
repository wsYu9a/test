package com.alimm.tanx.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: classes.dex */
public class Utils implements NotConfused {
    public static String formatTimeInMillis(long j10, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        return new SimpleDateFormat(str).format(calendar.getTime());
    }
}
