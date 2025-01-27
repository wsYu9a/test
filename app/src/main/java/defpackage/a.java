package defpackage;

import com.czhj.volley.toolbox.HttpHeaderParser;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import xi.k;
import xi.l;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final long f40a = 253402300799999L;

    /* renamed from: b */
    @k
    public static final C0000a f41b = new C0000a();

    /* renamed from: c */
    @k
    public static final String[] f42c;

    /* renamed from: d */
    @k
    public static final DateFormat[] f43d;

    /* renamed from: a$a */
    public static final class C0000a extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        @k
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(Util.UTC);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {HttpHeaderParser.f8779c, "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", t8.a.f30753h, "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f42c = strArr;
        f43d = new DateFormat[strArr.length];
    }

    @l
    public static final Date a(@k String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f41b.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return parse;
        }
        String[] strArr = f42c;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    DateFormat[] dateFormatArr = f43d;
                    DateFormat dateFormat = dateFormatArr[i10];
                    if (dateFormat == null) {
                        dateFormat = new SimpleDateFormat(f42c[i10], Locale.US);
                        dateFormat.setTimeZone(Util.UTC);
                        dateFormatArr[i10] = dateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date parse2 = dateFormat.parse(str, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return parse2;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @k
    public static final String b(@k Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String format = f41b.get().format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}
