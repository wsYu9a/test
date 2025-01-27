package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes.dex */
class v {

    /* renamed from: a, reason: collision with root package name */
    private static final v f7111a = new v(null, null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Long f7112b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final TimeZone f7113c;

    private v(@Nullable Long l, @Nullable TimeZone timeZone) {
        this.f7112b = l;
        this.f7113c = timeZone;
    }

    static v a(long j2) {
        return new v(Long.valueOf(j2), null);
    }

    static v b(long j2, @Nullable TimeZone timeZone) {
        return new v(Long.valueOf(j2), timeZone);
    }

    static v e() {
        return f7111a;
    }

    Calendar c() {
        return d(this.f7113c);
    }

    Calendar d(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f7112b;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
