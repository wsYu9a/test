package z5;

import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a */
    public static final String f33690a;

    /* renamed from: b */
    public static final String f33691b = "SJIS";

    /* renamed from: c */
    public static final String f33692c = "GB2312";

    /* renamed from: d */
    public static final String f33693d = "EUC_JP";

    /* renamed from: e */
    public static final String f33694e = "UTF8";

    /* renamed from: f */
    public static final String f33695f = "ISO8859_1";

    /* renamed from: g */
    public static final boolean f33696g;

    static {
        String name = Charset.defaultCharset().name();
        f33690a = name;
        f33696g = f33691b.equalsIgnoreCase(name) || f33693d.equalsIgnoreCase(name);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(byte[] r21, java.util.Map<com.google.zxing.DecodeHintType, ?> r22) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.k.a(byte[], java.util.Map):java.lang.String");
    }
}
