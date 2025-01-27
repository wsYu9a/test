package com.zk_oaction.adengine.bitmap;

import java.util.HashMap;

/* loaded from: classes5.dex */
class a {

    /* renamed from: a */
    HashMap<String, C0804a> f34711a = new HashMap<>();

    /* renamed from: com.zk_oaction.adengine.bitmap.a$a */
    class C0804a {

        /* renamed from: a */
        String f34712a;

        /* renamed from: b */
        byte[] f34713b;

        C0804a(a aVar, String str) {
            this.f34712a = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
        
            if (r2 == null) goto L68;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public byte[] a() {
            /*
                r6 = this;
                monitor-enter(r6)
                byte[] r0 = r6.f34713b     // Catch: java.lang.Throwable -> L44
                if (r0 == 0) goto L6
                goto L39
            L6:
                r0 = 0
                java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                java.lang.String r2 = r6.f34712a     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                r1.<init>(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                r2.<init>(r1)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
                long r3 = r1.length()     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3b
                int r1 = (int) r3     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3b
                byte[] r3 = new byte[r1]     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3b
                r6.f34713b = r3     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3b
                r3 = 0
            L1d:
                if (r3 >= r1) goto L34
                byte[] r4 = r6.f34713b     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3b
                int r5 = r1 - r3
                int r4 = r2.read(r4, r3, r5)     // Catch: java.lang.Exception -> L30 java.lang.Throwable -> L3b
                r5 = -1
                if (r4 != r5) goto L2b
                goto L34
            L2b:
                int r3 = r3 + r4
                goto L1d
            L2d:
                r1 = move-exception
                goto L3e
            L2f:
                r2 = r0
            L30:
                r6.f34713b = r0     // Catch: java.lang.Throwable -> L3b
                if (r2 == 0) goto L37
            L34:
                r2.close()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L44
            L37:
                byte[] r0 = r6.f34713b     // Catch: java.lang.Throwable -> L44
            L39:
                monitor-exit(r6)
                return r0
            L3b:
                r0 = move-exception
                r1 = r0
                r0 = r2
            L3e:
                if (r0 == 0) goto L43
                r0.close()     // Catch: java.io.IOException -> L43 java.lang.Throwable -> L44
            L43:
                throw r1     // Catch: java.lang.Throwable -> L44
            L44:
                r0 = move-exception
                monitor-exit(r6)
                goto L48
            L47:
                throw r0
            L48:
                goto L47
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.bitmap.a.C0804a.a():byte[]");
        }
    }

    a() {
    }

    public void a() {
        synchronized (this) {
            this.f34711a.clear();
        }
    }

    public byte[] b(String str) {
        C0804a c0804a;
        synchronized (this) {
            c0804a = this.f34711a.get(str);
            if (c0804a == null) {
                c0804a = new C0804a(this, str);
                this.f34711a.put(str, c0804a);
            }
        }
        return c0804a.a();
    }
}
