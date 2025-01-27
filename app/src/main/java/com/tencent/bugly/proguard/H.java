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
    private static H f24956a;

    /* renamed from: b */
    public static final long f24957b = System.currentTimeMillis();

    /* renamed from: c */
    private Context f24958c;

    /* renamed from: f */
    private SharedPreferences f24961f;

    /* renamed from: e */
    private Map<Integer, Map<String, E>> f24960e = new HashMap();

    /* renamed from: d */
    private String f24959d = com.tencent.bugly.crashreport.common.info.a.m().f24755h;

    public H(Context context) {
        this.f24958c = context;
        this.f24961f = context.getSharedPreferences("crashrecord", 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
    
        if (r6 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
    
        if (r6 == null) goto L86;
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
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            android.content.Context r3 = r5.f24958c     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r4.append(r6)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.String r6 = ""
            r4.append(r6)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            if (r6 != 0) goto L29
            monitor-exit(r5)
            return r0
        L29:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L40 java.lang.ClassNotFoundException -> L44 java.io.IOException -> L4f
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L40 java.lang.ClassNotFoundException -> L44 java.io.IOException -> L4f
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L40 java.lang.ClassNotFoundException -> L44 java.io.IOException -> L4f
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.lang.ClassNotFoundException -> L44 java.io.IOException -> L4f
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L45 java.io.IOException -> L50
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L3e java.lang.ClassNotFoundException -> L45 java.io.IOException -> L50
            r6.close()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            monitor-exit(r5)
            return r2
        L3e:
            r2 = move-exception
            goto L5d
        L40:
            r6 = move-exception
            r2 = r6
            r6 = r0
            goto L5d
        L44:
            r6 = r0
        L45:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L3e
            com.tencent.bugly.proguard.X.c(r2, r3)     // Catch: java.lang.Throwable -> L3e
            if (r6 == 0) goto L6c
            goto L59
        L4f:
            r6 = r0
        L50:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L3e
            com.tencent.bugly.proguard.X.c(r2, r3)     // Catch: java.lang.Throwable -> L3e
            if (r6 == 0) goto L6c
        L59:
            r6.close()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            goto L6c
        L5d:
            if (r6 == 0) goto L62
            r6.close()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
        L62:
            throw r2     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
        L63:
            r6 = move-exception
            goto L6e
        L65:
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L63
            java.lang.String r1 = "readCrashRecord error"
            com.tencent.bugly.proguard.X.b(r1, r6)     // Catch: java.lang.Throwable -> L63
        L6c:
            monitor-exit(r5)
            return r0
        L6e:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.H.c(int):java.util.List");
    }

    public synchronized boolean b(int i2) {
        try {
            List<E> c2 = c(i2);
            if (c2 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (E e2 : c2) {
                String str = e2.f24945b;
                if (str != null && str.equalsIgnoreCase(this.f24959d) && e2.f24947d > 0) {
                    arrayList.add(e2);
                }
                if (e2.f24946c + 86400000 < currentTimeMillis) {
                    arrayList2.add(e2);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((E) arrayList.get(arrayList.size() - 1)).f24946c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                c2.clear();
                a(i2, (int) c2);
                return false;
            }
            c2.removeAll(arrayList2);
            a(i2, (int) c2);
            return false;
        } catch (Exception unused) {
            X.b("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public static synchronized H a(Context context) {
        H h2;
        synchronized (H.class) {
            if (f24956a == null) {
                f24956a = new H(context);
            }
            h2 = f24956a;
        }
        return h2;
    }

    public static synchronized H a() {
        H h2;
        synchronized (H.class) {
            h2 = f24956a;
        }
        return h2;
    }

    public void a(int i2, int i3) {
        W.c().a(new F(this, i2, i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0052 A[Catch: all -> 0x0056, Exception -> 0x0058, TryCatch #4 {Exception -> 0x0058, blocks: (B:8:0x0006, B:10:0x000c, B:12:0x001a, B:18:0x0032, B:27:0x0049, B:32:0x0052, B:33:0x0055), top: B:7:0x0006, outer: #2 }] */
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
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.content.Context r2 = r4.f24958c     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r3.<init>()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r3.append(r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r5 = ""
            r3.append(r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3a
            r2.writeObject(r6)     // Catch: java.io.IOException -> L36 java.lang.Throwable -> L4d
            r2.close()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            goto L5f
        L36:
            r5 = move-exception
            goto L3d
        L38:
            r6 = move-exception
            goto L50
        L3a:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L3d:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.X.c(r5, r6)     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L5f
            r2.close()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            goto L5f
        L4d:
            r5 = move-exception
            r6 = r5
            r5 = r2
        L50:
            if (r5 == 0) goto L55
            r5.close()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
        L55:
            throw r6     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
        L56:
            r5 = move-exception
            goto L61
        L58:
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L56
            java.lang.String r6 = "writeCrashRecord error"
            com.tencent.bugly.proguard.X.b(r6, r5)     // Catch: java.lang.Throwable -> L56
        L5f:
            monitor-exit(r4)
            return
        L61:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.H.a(int, java.util.List):void");
    }

    public synchronized boolean a(int i2) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f24961f;
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append("_");
            sb.append(this.f24959d);
            z = sharedPreferences.getBoolean(sb.toString(), true);
            W.c().a(new G(this, i2));
        } catch (Exception unused) {
            X.b("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
