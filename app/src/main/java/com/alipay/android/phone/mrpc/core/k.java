package com.alipay.android.phone.mrpc.core;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f6372a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f6373b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f6374a;

        /* renamed from: b, reason: collision with root package name */
        public int f6375b;

        /* renamed from: c, reason: collision with root package name */
        public int f6376c;

        public a(int i10, int i11, int i12) {
            this.f6374a = i10;
            this.f6375b = i11;
            this.f6376c = i12;
        }
    }

    public static long a(String str) {
        int c10;
        int d10;
        int i10;
        a aVar;
        int i11;
        int i12;
        int i13;
        Matcher matcher = f6372a.matcher(str);
        if (matcher.find()) {
            i10 = b(matcher.group(1));
            c10 = c(matcher.group(2));
            d10 = d(matcher.group(3));
            aVar = e(matcher.group(4));
        } else {
            Matcher matcher2 = f6373b.matcher(str);
            if (!matcher2.find()) {
                throw new IllegalArgumentException();
            }
            c10 = c(matcher2.group(1));
            int b10 = b(matcher2.group(2));
            a e10 = e(matcher2.group(3));
            d10 = d(matcher2.group(4));
            i10 = b10;
            aVar = e10;
        }
        if (d10 >= 2038) {
            i11 = 1;
            i12 = 0;
            i13 = 2038;
        } else {
            i11 = i10;
            i12 = c10;
            i13 = d10;
        }
        Time time = new Time("UTC");
        time.set(aVar.f6376c, aVar.f6375b, aVar.f6374a, i11, i12, i13);
        return time.toMillis(false);
    }

    public static int b(String str) {
        return str.length() == 2 ? ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0') : str.charAt(0) - '0';
    }

    public static int c(String str) {
        int lowerCase = ((Character.toLowerCase(str.charAt(0)) + Character.toLowerCase(str.charAt(1))) + Character.toLowerCase(str.charAt(2))) - 291;
        if (lowerCase == 9) {
            return 11;
        }
        if (lowerCase == 10) {
            return 1;
        }
        if (lowerCase == 22) {
            return 0;
        }
        if (lowerCase == 26) {
            return 7;
        }
        if (lowerCase == 29) {
            return 2;
        }
        if (lowerCase == 32) {
            return 3;
        }
        if (lowerCase == 40) {
            return 6;
        }
        if (lowerCase == 42) {
            return 5;
        }
        if (lowerCase == 48) {
            return 10;
        }
        switch (lowerCase) {
            case 35:
                return 9;
            case 36:
                return 4;
            case 37:
                return 8;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int d(String str) {
        if (str.length() == 2) {
            int charAt = ((str.charAt(0) - '0') * 10) + (str.charAt(1) - '0');
            return charAt >= 70 ? charAt + 1900 : charAt + 2000;
        }
        if (str.length() == 3) {
            return ((str.charAt(0) - '0') * 100) + ((str.charAt(1) - '0') * 10) + (str.charAt(2) - '0') + 1900;
        }
        if (str.length() == 4) {
            return ((str.charAt(0) - '0') * 1000) + ((str.charAt(1) - '0') * 100) + ((str.charAt(2) - '0') * 10) + (str.charAt(3) - '0');
        }
        return 1970;
    }

    public static a e(String str) {
        int charAt = str.charAt(0) - '0';
        int i10 = 1;
        if (str.charAt(1) != ':') {
            charAt = (charAt * 10) + (str.charAt(1) - '0');
            i10 = 2;
        }
        return new a(charAt, ((str.charAt(i10 + 1) - '0') * 10) + (str.charAt(i10 + 2) - '0'), ((str.charAt(i10 + 4) - '0') * 10) + (str.charAt(i10 + 5) - '0'));
    }
}
