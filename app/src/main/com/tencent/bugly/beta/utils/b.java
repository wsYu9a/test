package com.tencent.bugly.beta.utils;

import android.util.Log;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private String f22178a;

    /* renamed from: c */
    private long f22180c;

    /* renamed from: d */
    private long f22181d;

    /* renamed from: f */
    private final HashMap<Long, String> f22183f;

    /* renamed from: b */
    private a f22179b = null;

    /* renamed from: e */
    private String f22182e = null;

    public b(String str, long j10, long j11) {
        this.f22178a = null;
        this.f22180c = 0L;
        this.f22181d = 0L;
        HashMap<Long, String> hashMap = new HashMap<>();
        this.f22183f = hashMap;
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
        this.f22178a = str;
        this.f22180c = j10;
        this.f22181d = j11;
    }

    private boolean a() {
        return 0 != this.f22181d;
    }

    private synchronized void b() {
        a aVar = this.f22179b;
        if (aVar == null) {
            return;
        }
        if (aVar.a()) {
            this.f22179b = null;
        }
    }

    private synchronized boolean c() {
        if (!a()) {
            return false;
        }
        if (this.f22179b != null) {
            b();
        }
        try {
            a aVar = new a(this.f22178a, this.f22180c);
            this.f22179b = aVar;
            return aVar.b(this.f22181d);
        } catch (Exception e10) {
            Log.e("ElfArmAttrParser", e10.getMessage());
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
            if (65 != this.f22179b.f()) {
                return false;
            }
            long g10 = this.f22179b.g();
            String g11 = g();
            if (g11 != null && g11.equals("aeabi")) {
                long length = g10 - g11.length();
                while (length > 0) {
                    long f10 = this.f22179b.f();
                    long g12 = this.f22179b.g() - 5;
                    if (1 == f10) {
                        return a(g12);
                    }
                    this.f22179b.b(g12);
                }
                return true;
            }
            return false;
        } catch (IOException e10) {
            Log.e("ElfArmAttrParser", e10.getMessage());
            return false;
        }
    }

    private synchronized String f() {
        StringBuilder sb2;
        try {
            sb2 = new StringBuilder();
            while (true) {
                try {
                    char b10 = (char) this.f22179b.b();
                    if (b10 != 0) {
                        sb2.append(b10);
                    }
                } catch (IOException e10) {
                    Log.e("ElfArmAttrParser", e10.getMessage());
                    return null;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return sb2.toString();
    }

    private String g() {
        return f();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0001 A[SYNTHETIC] */
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
            com.tencent.bugly.beta.utils.a r0 = r4.f22179b     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            long r0 = a(r0)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            int r1 = (int) r0
            r0 = 34
            if (r1 == r0) goto L5e
            r0 = 36
            if (r1 == r0) goto L5e
            r0 = 38
            if (r1 == r0) goto L5e
            r0 = 42
            if (r1 == r0) goto L5e
            r0 = 44
            if (r1 == r0) goto L5e
            r0 = 70
            if (r1 == r0) goto L5e
            switch(r1) {
                case 4: goto L51;
                case 5: goto L51;
                case 6: goto L3a;
                case 7: goto L5e;
                case 8: goto L5e;
                case 9: goto L5e;
                case 10: goto L5e;
                case 11: goto L5e;
                case 12: goto L5e;
                case 13: goto L5e;
                case 14: goto L5e;
                case 15: goto L5e;
                case 16: goto L5e;
                case 17: goto L5e;
                case 18: goto L5e;
                case 19: goto L5e;
                case 20: goto L5e;
                case 21: goto L5e;
                case 22: goto L5e;
                case 23: goto L5e;
                case 24: goto L5e;
                case 25: goto L5e;
                case 26: goto L5e;
                case 27: goto L5e;
                case 28: goto L5e;
                case 29: goto L5e;
                case 30: goto L5e;
                case 31: goto L5e;
                case 32: goto L51;
                default: goto L2a;
            }
        L2a:
            switch(r1) {
                case 64: goto L5e;
                case 65: goto L51;
                case 66: goto L5e;
                case 67: goto L51;
                case 68: goto L5e;
                default: goto L2d;
            }
        L2d:
            java.lang.String r5 = "ElfArmAttrParser"
            java.lang.String r6 = "Unimplemented tag."
            android.util.Log.e(r5, r6)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            monitor-exit(r4)
            return r2
        L36:
            r5 = move-exception
            goto L6f
        L38:
            r5 = move-exception
            goto L64
        L3a:
            com.tencent.bugly.beta.utils.a r5 = r4.f22179b     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            long r5 = a(r5)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            java.util.HashMap<java.lang.Long, java.lang.String> r0 = r4.f22183f     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            r4.f22182e = r5     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            monitor-exit(r4)
            r5 = 1
            return r5
        L51:
            java.lang.String r0 = r4.f()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            if (r0 == 0) goto L1
            int r0 = r0.length()     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            long r5 = r5 - r0
            goto L1
        L5e:
            com.tencent.bugly.beta.utils.a r0 = r4.f22179b     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            a(r0)     // Catch: java.lang.Throwable -> L36 java.io.IOException -> L38
            goto L1
        L64:
            java.lang.String r5 = r5.getMessage()     // Catch: java.lang.Throwable -> L36
            java.lang.String r6 = "ElfArmAttrParser"
            android.util.Log.e(r6, r5)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r4)
            return r2
        L6f:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L36
            throw r5
        L71:
            monitor-exit(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.b.a(long):boolean");
    }

    public static String a(String str, long j10, long j11) {
        b bVar = new b(str, j10, j11);
        if (!bVar.d()) {
            Log.e("ElfArmAttrParser", "Failed to parse the arch.");
            return null;
        }
        return bVar.f22182e;
    }

    public static synchronized long a(a aVar) throws IOException {
        long j10;
        byte b10;
        synchronized (b.class) {
            long j11 = 0;
            j10 = 0;
            do {
                b10 = aVar.b();
                j10 |= (b10 & 127) << ((int) j11);
                j11 += 7;
            } while ((b10 & 128) != 0);
        }
        return j10;
    }
}
