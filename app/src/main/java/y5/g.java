package y5;

import com.baidu.mobads.sdk.internal.bm;
import com.google.zxing.client.result.ParsedResultType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class g extends q {

    /* renamed from: m */
    public static final Pattern f32990m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");

    /* renamed from: n */
    public static final long[] f32991n = {bm.f6899d, 86400000, 3600000, 60000, 1000};

    /* renamed from: o */
    public static final Pattern f32992o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");

    /* renamed from: b */
    public final String f32993b;

    /* renamed from: c */
    public final Date f32994c;

    /* renamed from: d */
    public final boolean f32995d;

    /* renamed from: e */
    public final Date f32996e;

    /* renamed from: f */
    public final boolean f32997f;

    /* renamed from: g */
    public final String f32998g;

    /* renamed from: h */
    public final String f32999h;

    /* renamed from: i */
    public final String[] f33000i;

    /* renamed from: j */
    public final String f33001j;

    /* renamed from: k */
    public final double f33002k;

    /* renamed from: l */
    public final double f33003l;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d10, double d11) {
        super(ParsedResultType.CALENDAR);
        this.f32993b = str;
        try {
            Date r10 = r(str2);
            this.f32994c = r10;
            if (str3 == null) {
                long s10 = s(str4);
                this.f32996e = s10 < 0 ? null : new Date(r10.getTime() + s10);
            } else {
                try {
                    this.f32996e = r(str3);
                } catch (ParseException e10) {
                    throw new IllegalArgumentException(e10.toString());
                }
            }
            boolean z10 = false;
            this.f32995d = str2.length() == 8;
            if (str3 != null && str3.length() == 8) {
                z10 = true;
            }
            this.f32997f = z10;
            this.f32998g = str5;
            this.f32999h = str6;
            this.f33000i = strArr;
            this.f33001j = str7;
            this.f33002k = d10;
            this.f33003l = d11;
        } catch (ParseException e11) {
            throw new IllegalArgumentException(e11.toString());
        }
    }

    public static DateFormat d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static DateFormat e() {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
    }

    public static String f(boolean z10, Date date) {
        if (date == null) {
            return null;
        }
        return (z10 ? DateFormat.getDateInstance(2) : DateFormat.getDateTimeInstance(2, 2)).format(date);
    }

    public static Date r(String str) throws ParseException {
        if (!f32992o.matcher(str).matches()) {
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

    public static long s(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f32990m.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j10 = 0;
        int i10 = 0;
        while (true) {
            long[] jArr = f32991n;
            if (i10 >= jArr.length) {
                return j10;
            }
            int i11 = i10 + 1;
            if (matcher.group(i11) != null) {
                j10 += jArr[i10] * Integer.parseInt(r5);
            }
            i10 = i11;
        }
    }

    @Override // y5.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(100);
        q.b(this.f32993b, sb2);
        q.b(f(this.f32995d, this.f32994c), sb2);
        q.b(f(this.f32997f, this.f32996e), sb2);
        q.b(this.f32998g, sb2);
        q.b(this.f32999h, sb2);
        q.c(this.f33000i, sb2);
        q.b(this.f33001j, sb2);
        return sb2.toString();
    }

    public String[] g() {
        return this.f33000i;
    }

    public String h() {
        return this.f33001j;
    }

    public Date i() {
        return this.f32996e;
    }

    public double j() {
        return this.f33002k;
    }

    public String k() {
        return this.f32998g;
    }

    public double l() {
        return this.f33003l;
    }

    public String m() {
        return this.f32999h;
    }

    public Date n() {
        return this.f32994c;
    }

    public String o() {
        return this.f32993b;
    }

    public boolean p() {
        return this.f32997f;
    }

    public boolean q() {
        return this.f32995d;
    }
}
