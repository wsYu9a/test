package com.tencent.bugly.beta.utils;

import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private String f24668a;

    /* renamed from: c */
    private long f24670c;

    /* renamed from: d */
    private long f24671d;

    /* renamed from: f */
    private final HashMap<Long, String> f24673f;

    /* renamed from: b */
    private a f24669b = null;

    /* renamed from: e */
    private String f24672e = null;

    public b(String str, long j2, long j3) {
        this.f24668a = null;
        this.f24670c = 0L;
        this.f24671d = 0L;
        HashMap<Long, String> hashMap = new HashMap<>();
        this.f24673f = hashMap;
        hashMap.put(1L, "armeabi-v4");
        hashMap.put(2L, "armeabi-v4t");
        hashMap.put(3L, "armeabi-v5t");
        hashMap.put(4L, "armeabi-v5te");
        hashMap.put(5L, "armeabi-v5tej");
        hashMap.put(6L, "armeabi-v6");
        hashMap.put(7L, "armeabi-v6kz");
        hashMap.put(8L, "armeabi-v6t2");
        hashMap.put(9L, "armeabi-v6k");
        hashMap.put(10L, "armeabi-v7a");
        hashMap.put(11L, "armeabi-v6-m");
        hashMap.put(12L, "armeabi-v6s-m");
        hashMap.put(13L, "armeabi-v7e-m");
        hashMap.put(14L, "armeabi-v8a");
        this.f24668a = str;
        this.f24670c = j2;
        this.f24671d = j3;
    }

    private boolean a() {
        return 0 != this.f24671d;
    }

    private synchronized void b() {
        a aVar = this.f24669b;
        if (aVar == null) {
            return;
        }
        if (aVar.a()) {
            this.f24669b = null;
        }
    }

    private synchronized boolean c() {
        if (!a()) {
            return false;
        }
        if (this.f24669b != null) {
            b();
        }
        try {
            a aVar = new a(this.f24668a, this.f24670c);
            this.f24669b = aVar;
            return aVar.b(this.f24671d);
        } catch (Exception e2) {
            Log.e("ElfArmAttrParser", e2.getMessage());
            return false;
        }
    }

    private boolean d() {
        if (!c()) {
            b();
            return false;
        }
        if (!e()) {
            Log.e("ElfArmAttrParser", "Failed to parse elf header");
        }
        b();
        return true;
    }

    private synchronized boolean e() {
        try {
            if (65 != this.f24669b.f()) {
                return false;
            }
            long g2 = this.f24669b.g();
            String g3 = g();
            if (g3 != null && g3.equals("aeabi")) {
                long length = g2 - g3.length();
                while (length > 0) {
                    long f2 = this.f24669b.f();
                    long g4 = this.f24669b.g() - 5;
                    if (1 == f2) {
                        return a(g4);
                    }
                    this.f24669b.b(g4);
                }
                return true;
            }
            return false;
        } catch (IOException e2) {
            Log.e("ElfArmAttrParser", e2.getMessage());
            return false;
        }
    }

    private synchronized String f() {
        StringBuilder sb;
        sb = new StringBuilder();
        while (true) {
            try {
                char b2 = (char) this.f24669b.b();
                if (b2 != 0) {
                    sb.append(b2);
                }
            } catch (IOException e2) {
                Log.e("ElfArmAttrParser", e2.getMessage());
                return null;
            }
        }
        return sb.toString();
    }

    private String g() {
        return f();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0001 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean a(long r5) {
        /*
            r4 = this;
            monitor-enter(r4)
        L1:
            r0 = 0
            r2 = 0
            int r3 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r3 <= 0) goto L71
            com.tencent.bugly.beta.utils.a r0 = r4.f24669b     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            long r0 = a(r0)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            int r1 = (int) r0
            r0 = 34
            if (r1 == r0) goto L5b
            r0 = 36
            if (r1 == r0) goto L5b
            r0 = 38
            if (r1 == r0) goto L5b
            r0 = 42
            if (r1 == r0) goto L5b
            r0 = 44
            if (r1 == r0) goto L5b
            r0 = 70
            if (r1 == r0) goto L5b
            switch(r1) {
                case 4: goto L47;
                case 5: goto L47;
                case 6: goto L30;
                case 7: goto L5b;
                case 8: goto L5b;
                case 9: goto L5b;
                case 10: goto L5b;
                case 11: goto L5b;
                case 12: goto L5b;
                case 13: goto L5b;
                case 14: goto L5b;
                case 15: goto L5b;
                case 16: goto L5b;
                case 17: goto L5b;
                case 18: goto L5b;
                case 19: goto L5b;
                case 20: goto L5b;
                case 21: goto L5b;
                case 22: goto L5b;
                case 23: goto L5b;
                case 24: goto L5b;
                case 25: goto L5b;
                case 26: goto L5b;
                case 27: goto L5b;
                case 28: goto L5b;
                case 29: goto L5b;
                case 30: goto L5b;
                case 31: goto L5b;
                case 32: goto L47;
                default: goto L2a;
            }
        L2a:
            switch(r1) {
                case 64: goto L5b;
                case 65: goto L47;
                case 66: goto L5b;
                case 67: goto L47;
                case 68: goto L5b;
                default: goto L2d;
            }
        L2d:
            java.lang.String r5 = "ElfArmAttrParser"
            goto L54
        L30:
            com.tencent.bugly.beta.utils.a r5 = r4.f24669b     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            long r5 = a(r5)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            java.util.HashMap<java.lang.Long, java.lang.String> r0 = r4.f24673f     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            r4.f24672e = r5     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            r5 = 1
            monitor-exit(r4)
            return r5
        L47:
            java.lang.String r0 = r4.f()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            if (r0 == 0) goto L1
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            long r0 = (long) r0
            long r5 = r5 - r0
            goto L1
        L54:
            java.lang.String r6 = "Unimplemented tag."
            android.util.Log.e(r5, r6)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            monitor-exit(r4)
            return r2
        L5b:
            com.tencent.bugly.beta.utils.a r0 = r4.f24669b     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            a(r0)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            goto L1
        L61:
            r5 = move-exception
            goto L6f
        L63:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L61
            java.lang.String r6 = "ElfArmAttrParser"
            android.util.Log.e(r6, r5)     // Catch: java.lang.Throwable -> L61
            monitor-exit(r4)
            return r2
        L6f:
            monitor-exit(r4)
            throw r5
        L71:
            monitor-exit(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.b.a(long):boolean");
    }

    public static String a(String str, long j2, long j3) {
        b bVar = new b(str, j2, j3);
        if (!bVar.d()) {
            Log.e("ElfArmAttrParser", "Failed to parse the arch.");
            return null;
        }
        return bVar.f24672e;
    }

    public static synchronized long a(a aVar) throws IOException {
        long j2;
        byte b2;
        synchronized (b.class) {
            long j3 = 0;
            j2 = 0;
            do {
                b2 = aVar.b();
                j2 |= (b2 & 127) << ((int) j3);
                j3 += 7;
            } while ((b2 & ByteCompanionObject.MIN_VALUE) != 0);
        }
        return j2;
    }
}
