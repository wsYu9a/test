package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class H {

    /* renamed from: a */
    private static H f22597a;

    /* renamed from: b */
    public static final long f22598b = System.currentTimeMillis();

    /* renamed from: c */
    private Context f22599c;

    /* renamed from: f */
    private SharedPreferences f22602f;

    /* renamed from: e */
    private Map<Integer, Map<String, E>> f22601e = new HashMap();

    /* renamed from: d */
    private String f22600d = com.tencent.bugly.crashreport.common.info.a.m().f22296h;

    public H(Context context) {
        this.f22599c = context;
        this.f22602f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (r6 == null) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        if (r6 == null) goto L137;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            android.content.Context r3 = r5.f22599c     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            r4.append(r6)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            java.lang.String r6 = ""
            r4.append(r6)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            if (r6 != 0) goto L29
            monitor-exit(r5)
            return r0
        L29:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L42 java.lang.ClassNotFoundException -> L46 java.io.IOException -> L51
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L42 java.lang.ClassNotFoundException -> L46 java.io.IOException -> L51
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L42 java.lang.ClassNotFoundException -> L46 java.io.IOException -> L51
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.lang.ClassNotFoundException -> L46 java.io.IOException -> L51
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.Throwable -> L40 java.lang.ClassNotFoundException -> L47 java.io.IOException -> L52
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L40 java.lang.ClassNotFoundException -> L47 java.io.IOException -> L52
            r6.close()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            monitor-exit(r5)
            return r2
        L3e:
            r6 = move-exception
            goto L6e
        L40:
            r2 = move-exception
            goto L5f
        L42:
            r6 = move-exception
            r2 = r6
            r6 = r0
            goto L5f
        L46:
            r6 = r0
        L47:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L40
            com.tencent.bugly.proguard.X.c(r2, r3)     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L6c
            goto L5b
        L51:
            r6 = r0
        L52:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L40
            com.tencent.bugly.proguard.X.c(r2, r3)     // Catch: java.lang.Throwable -> L40
            if (r6 == 0) goto L6c
        L5b:
            r6.close()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
            goto L6c
        L5f:
            if (r6 == 0) goto L64
            r6.close()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
        L64:
            throw r2     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L65
        L65:
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = "readCrashRecord error"
            com.tencent.bugly.proguard.X.b(r1, r6)     // Catch: java.lang.Throwable -> L3e
        L6c:
            monitor-exit(r5)
            return r0
        L6e:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L3e
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.H.c(int):java.util.List");
    }

    public synchronized boolean b(int i10) {
        try {
            try {
                List<E> c10 = c(i10);
                if (c10 == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (E e10 : c10) {
                    String str = e10.f22586b;
                    if (str != null && str.equalsIgnoreCase(this.f22600d) && e10.f22588d > 0) {
                        arrayList.add(e10);
                    }
                    if (e10.f22587c + 86400000 < currentTimeMillis) {
                        arrayList2.add(e10);
                    }
                }
                Collections.sort(arrayList);
                if (arrayList.size() >= 2) {
                    if (arrayList.size() <= 0 || ((E) arrayList.get(arrayList.size() - 1)).f22587c + 86400000 >= currentTimeMillis) {
                        return true;
                    }
                    c10.clear();
                    a(i10, (int) c10);
                    return false;
                }
                c10.removeAll(arrayList2);
                a(i10, (int) c10);
                return false;
            } catch (Exception unused) {
                X.b("isFrequentCrash failed", new Object[0]);
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized H a(Context context) {
        H h10;
        synchronized (H.class) {
            try {
                if (f22597a == null) {
                    f22597a = new H(context);
                }
                h10 = f22597a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return h10;
    }

    public static synchronized H a() {
        H h10;
        synchronized (H.class) {
            h10 = f22597a;
        }
        return h10;
    }

    public void a(int i10, int i11) {
        W.c().a(new F(this, i10, i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0055 A[Catch: all -> 0x0036, Exception -> 0x0059, TryCatch #2 {Exception -> 0x0059, blocks: (B:8:0x0006, B:10:0x000c, B:12:0x001a, B:18:0x0032, B:32:0x0055, B:33:0x0058, B:27:0x004d), top: B:7:0x0006, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            android.content.Context r2 = r4.f22599c     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            r3.<init>()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            r3.append(r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            java.lang.String r5 = ""
            r3.append(r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L3e
            r2.writeObject(r6)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r2.close()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            goto L60
        L36:
            r5 = move-exception
            goto L62
        L38:
            r5 = move-exception
            goto L51
        L3a:
            r5 = move-exception
            goto L41
        L3c:
            r6 = move-exception
            goto L53
        L3e:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L41:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L38
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L38
            com.tencent.bugly.proguard.X.c(r5, r6)     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L60
            r2.close()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
            goto L60
        L51:
            r6 = r5
            r5 = r2
        L53:
            if (r5 == 0) goto L58
            r5.close()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
        L58:
            throw r6     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L59
        L59:
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L36
            java.lang.String r6 = "writeCrashRecord error"
            com.tencent.bugly.proguard.X.b(r6, r5)     // Catch: java.lang.Throwable -> L36
        L60:
            monitor-exit(r4)
            return
        L62:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L36
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.H.a(int, java.util.List):void");
    }

    public synchronized boolean a(int i10) {
        boolean z10;
        z10 = true;
        try {
            SharedPreferences sharedPreferences = this.f22602f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append(hf.e.f26694a);
            sb2.append(this.f22600d);
            z10 = sharedPreferences.getBoolean(sb2.toString(), true);
            W.c().a(new G(this, i10));
        } catch (Exception unused) {
            X.b("canInit error", new Object[0]);
            return z10;
        }
        return z10;
    }
}
