package h3;

import java.io.ByteArrayInputStream;
import java.util.Locale;
import p3.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a */
    public boolean f26394a;

    /* renamed from: b */
    public String f26395b = k.g(24);

    public c(boolean z10) {
        this.f26394a = z10;
    }

    public static int a(String str) {
        return Integer.parseInt(str);
    }

    public static String d(int i10) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i10));
    }

    public static byte[] e(String str, String str2) {
        return d3.d.a(str, str2);
    }

    public static byte[] f(String str, byte[] bArr, String str2) {
        return d3.e.b(str, bArr, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        if (r2 == null) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] g(byte[]... r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L67
            int r1 = r7.length
            if (r1 != 0) goto L8
            goto L67
        L8:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r1.<init>()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3b
            int r3 = r7.length     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r4 = 0
        L14:
            if (r4 >= r3) goto L2e
            r5 = r7[r4]     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            int r6 = r5.length     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            java.lang.String r6 = d(r6)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            byte[] r6 = r6.getBytes()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r2.write(r6)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r2.write(r5)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            int r4 = r4 + 1
            goto L14
        L2a:
            r7 = move-exception
            goto L3e
        L2c:
            r7 = move-exception
            goto L4a
        L2e:
            r2.flush()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            r1.close()     // Catch: java.lang.Exception -> L56
            goto L56
        L39:
            r7 = move-exception
            goto L3d
        L3b:
            r7 = move-exception
            goto L40
        L3d:
            r2 = r0
        L3e:
            r0 = r1
            goto L5a
        L40:
            r2 = r0
            goto L4a
        L42:
            r7 = move-exception
            goto L46
        L44:
            r7 = move-exception
            goto L48
        L46:
            r2 = r0
            goto L5a
        L48:
            r1 = r0
            r2 = r1
        L4a:
            p3.d.e(r7)     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L54
            r1.close()     // Catch: java.lang.Exception -> L53
            goto L54
        L53:
        L54:
            if (r2 == 0) goto L59
        L56:
            r2.close()     // Catch: java.lang.Exception -> L59
        L59:
            return r0
        L5a:
            if (r0 == 0) goto L61
            r0.close()     // Catch: java.lang.Exception -> L60
            goto L61
        L60:
        L61:
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.lang.Exception -> L66
        L66:
            throw r7
        L67:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.c.g(byte[][]):byte[]");
    }

    public static byte[] h(String str, byte[] bArr, String str2) {
        return d3.e.d(str, bArr, str2);
    }

    public b b(d dVar, String str) {
        ByteArrayInputStream byteArrayInputStream;
        String str2;
        String str3;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(dVar.a());
            try {
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str2 = new String(bArr2);
                    try {
                        byte[] bArr3 = new byte[5];
                        byteArrayInputStream.read(bArr3);
                        int a10 = a(new String(bArr3));
                        if (a10 > 0) {
                            byte[] bArr4 = new byte[a10];
                            byteArrayInputStream.read(bArr4);
                            if (this.f26394a) {
                                bArr4 = f(this.f26395b, bArr4, str);
                            }
                            if (dVar.b()) {
                                bArr4 = d3.b.b(bArr4);
                            }
                            str3 = new String(bArr4);
                        } else {
                            str3 = null;
                        }
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e10) {
                        e = e10;
                        p3.d.e(e);
                        if (byteArrayInputStream != null) {
                            try {
                                byteArrayInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        str3 = null;
                        if (str2 == null) {
                        }
                        return new b(str2, str3);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (byteArrayInputStream2 != null) {
                        try {
                            byteArrayInputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                str2 = null;
            }
        } catch (Exception e12) {
            e = e12;
            byteArrayInputStream = null;
            str2 = null;
        } catch (Throwable th3) {
            th = th3;
        }
        if (str2 == null || str3 != null) {
            return new b(str2, str3);
        }
        return null;
    }

    public d c(b bVar, boolean z10, String str) {
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.b().getBytes();
        byte[] bytes2 = bVar.a().getBytes();
        if (z10) {
            try {
                bytes2 = d3.b.a(bytes2);
            } catch (Exception unused) {
                z10 = false;
            }
        }
        return new d(z10, this.f26394a ? g(bytes, e(this.f26395b, z2.a.f33595f), h(this.f26395b, bytes2, str)) : g(bytes, bytes2));
    }
}
