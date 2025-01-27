package b.d.a;

import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final long f4362a = 1024;

    /* renamed from: b, reason: collision with root package name */
    private static final long f4363b = 1048576;

    /* renamed from: c, reason: collision with root package name */
    private static final long f4364c = 1073741824;

    /* renamed from: d, reason: collision with root package name */
    private static final long f4365d = 1099511627776L;

    /* renamed from: e, reason: collision with root package name */
    public static String f4366e = "TOUTIAO_VIDEO";

    public static String a(final long value) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (value < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j2 = jArr[i2];
            if (value >= j2) {
                return b(value, j2, strArr[i2]);
            }
        }
        return null;
    }

    private static String b(final long value, final long divider, final String unit) {
        double d2 = value;
        if (divider > 1) {
            double d3 = divider;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d2 /= d3;
        }
        return new DecimalFormat("#.##").format(d2) + " " + unit;
    }
}
