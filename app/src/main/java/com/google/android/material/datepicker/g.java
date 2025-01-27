package com.google.android.material.datepicker;

import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
class g {
    private g() {
    }

    static Pair<String, String> a(@Nullable Long l, @Nullable Long l2) {
        return b(l, l2, null);
    }

    static Pair<String, String> b(@Nullable Long l, @Nullable Long l2, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l == null && l2 == null) {
            return Pair.create(null, null);
        }
        if (l == null) {
            return Pair.create(null, d(l2.longValue(), simpleDateFormat));
        }
        if (l2 == null) {
            return Pair.create(d(l.longValue(), simpleDateFormat), null);
        }
        Calendar t = w.t();
        Calendar v = w.v();
        v.setTimeInMillis(l.longValue());
        Calendar v2 = w.v();
        v2.setTimeInMillis(l2.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l.longValue())), simpleDateFormat.format(new Date(l2.longValue())));
        }
        return v.get(1) == v2.get(1) ? v.get(1) == t.get(1) ? Pair.create(f(l.longValue(), Locale.getDefault()), f(l2.longValue(), Locale.getDefault())) : Pair.create(f(l.longValue(), Locale.getDefault()), j(l2.longValue(), Locale.getDefault())) : Pair.create(j(l.longValue(), Locale.getDefault()), j(l2.longValue(), Locale.getDefault()));
    }

    static String c(long j2) {
        return d(j2, null);
    }

    static String d(long j2, @Nullable SimpleDateFormat simpleDateFormat) {
        Calendar t = w.t();
        Calendar v = w.v();
        v.setTimeInMillis(j2);
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j2)) : t.get(1) == v.get(1) ? e(j2) : i(j2);
    }

    static String e(long j2) {
        return f(j2, Locale.getDefault());
    }

    static String f(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? w.c(locale).format(new Date(j2)) : w.m(locale).format(new Date(j2));
    }

    static String g(long j2) {
        return h(j2, Locale.getDefault());
    }

    static String h(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? w.d(locale).format(new Date(j2)) : w.i(locale).format(new Date(j2));
    }

    static String i(long j2) {
        return j(j2, Locale.getDefault());
    }

    static String j(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? w.x(locale).format(new Date(j2)) : w.k(locale).format(new Date(j2));
    }

    static String k(long j2) {
        return l(j2, Locale.getDefault());
    }

    static String l(long j2, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? w.y(locale).format(new Date(j2)) : w.i(locale).format(new Date(j2));
    }
}
