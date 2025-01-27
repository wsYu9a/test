package b.d.b;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4407a = "yyyyMMddHHmmss";

    /* renamed from: b, reason: collision with root package name */
    public static final String f4408b = "yyyy-MM-dd HH:mm:ss";

    /* renamed from: c, reason: collision with root package name */
    public static final String f4409c = "yyyyMMdd";

    public static String a() {
        return new SimpleDateFormat(f4409c).format(new Date());
    }

    public static String b() {
        return new SimpleDateFormat(f4408b).format(new Date());
    }

    public static String c() {
        Date date = new Date();
        return new SimpleDateFormat(f4407a).format(date) + "_" + new Random().nextInt(100);
    }

    public static String d() {
        return new Random().nextInt(1000) + "";
    }
}
