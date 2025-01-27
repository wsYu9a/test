package com.google.zxing.client.result;

import com.baidu.mobads.sdk.internal.bj;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class g extends q {

    /* renamed from: b */
    private static final Pattern f8225b = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* renamed from: c */
    private static final long[] f8226c = {bj.f5599d, 86400000, 3600000, 60000, 1000};

    /* renamed from: d */
    private static final Pattern f8227d = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* renamed from: e */
    private final String f8228e;

    /* renamed from: f */
    private final Date f8229f;

    /* renamed from: g */
    private final boolean f8230g;

    /* renamed from: h */
    private final Date f8231h;

    /* renamed from: i */
    private final boolean f8232i;

    /* renamed from: j */
    private final String f8233j;
    private final String k;
    private final String[] l;
    private final String m;
    private final double n;
    private final double o;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(ParsedResultType.CALENDAR);
        this.f8228e = str;
        try {
            Date r = r(str2);
            this.f8229f = r;
            if (str3 == null) {
                long s = s(str4);
                this.f8231h = s < 0 ? null : new Date(r.getTime() + s);
            } else {
                try {
                    this.f8231h = r(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            this.f8230g = str2.length() == 8;
            this.f8232i = str3 != null && str3.length() == 8;
            this.f8233j = str5;
            this.k = str6;
            this.l = strArr;
            this.m = str7;
            this.n = d2;
            this.o = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    private static DateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b.d.b.f.f4409c, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static DateFormat e() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    private static String f(boolean z, Date date) {
        if (date == null) {
            return null;
        }
        return (z ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(date);
    }

    private static Date r(String str) throws ParseException {
        if (!f8227d.matcher(str).matches()) {
            throw new ParseException(str, 0);
        }
        if (str.length() == 8) {
            return d().parse(str);
        }
        if (str.length() != 16 || str.charAt(15) != 'Z') {
            return e().parse(str);
        }
        Date parse = e().parse(str.substring(0, 15));
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long time = parse.getTime() + gregorianCalendar.get(15);
        gregorianCalendar.setTime(new Date(time));
        return new Date(time + gregorianCalendar.get(16));
    }

    private static long s(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f8225b.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j2 = 0;
        int i2 = 0;
        while (true) {
            long[] jArr = f8226c;
            if (i2 >= jArr.length) {
                return j2;
            }
            int i3 = i2 + 1;
            if (matcher.group(i3) != null) {
                j2 += jArr[i2] * Integer.parseInt(r5);
            }
            i2 = i3;
        }
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.b(this.f8228e, sb);
        q.b(f(this.f8230g, this.f8229f), sb);
        q.b(f(this.f8232i, this.f8231h), sb);
        q.b(this.f8233j, sb);
        q.b(this.k, sb);
        q.c(this.l, sb);
        q.b(this.m, sb);
        return sb.toString();
    }

    public String[] g() {
        return this.l;
    }

    public String h() {
        return this.m;
    }

    public Date i() {
        return this.f8231h;
    }

    public double j() {
        return this.n;
    }

    public String k() {
        return this.f8233j;
    }

    public double l() {
        return this.o;
    }

    public String m() {
        return this.k;
    }

    public Date n() {
        return this.f8229f;
    }

    public String o() {
        return this.f8228e;
    }

    public boolean p() {
        return this.f8232i;
    }

    public boolean q() {
        return this.f8230g;
    }
}
