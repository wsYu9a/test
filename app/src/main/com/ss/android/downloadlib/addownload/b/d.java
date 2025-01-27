package com.ss.android.downloadlib.addownload.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static volatile d f21207a;

    /* renamed from: c */
    private static final String[] f21208c = {"com", "android", "ss"};

    /* renamed from: d */
    private static final int[] f21209d = {3101, 3102, 3103, 3201, 3202, 3203};

    /* renamed from: b */
    private final LinkedList<a> f21210b = new LinkedList<>();

    public static class a {

        /* renamed from: a */
        public final String f21211a;

        /* renamed from: b */
        public final int f21212b;

        /* renamed from: c */
        public final String f21213c;

        /* renamed from: d */
        public final String f21214d;

        /* renamed from: e */
        public final long f21215e;

        public /* synthetic */ a(String str, int i10, String str2, String str3, long j10, AnonymousClass1 anonymousClass1) {
            this(str, i10, str2, str3, j10);
        }

        private a(String str, int i10, String str2, String str3, long j10) {
            this.f21211a = str;
            this.f21212b = i10;
            this.f21213c = str2 != null ? str2.toLowerCase() : null;
            this.f21214d = str3 != null ? str3.toLowerCase() : null;
            this.f21215e = j10;
        }
    }

    private d() {
    }

    public static d a() {
        if (f21207a == null) {
            synchronized (d.class) {
                try {
                    if (f21207a == null) {
                        f21207a = new d();
                    }
                } finally {
                }
            }
        }
        return f21207a;
    }

    private a c(String str) {
        try {
            PackageManager packageManager = k.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new a(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public void b(String str) {
        b();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f21210b) {
            try {
                Iterator<a> it = this.f21210b.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().f21211a)) {
                        it.remove();
                        return;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(String str) {
        a c10;
        b();
        if (TextUtils.isEmpty(str) || (c10 = c(str)) == null) {
            return;
        }
        synchronized (this.f21210b) {
            this.f21210b.add(c10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009a, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.b.d.a, java.lang.Integer> b(com.ss.android.downloadad.api.a.b r19) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.b.d.b(com.ss.android.downloadad.api.a.b):android.util.Pair");
    }

    public a a(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        b();
        synchronized (this.f21210b) {
            try {
                Iterator<a> it = this.f21210b.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f21215e > bVar.C()) {
                        return next;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean a(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z10;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (split.length != 0 && split2.length != 0) {
            int i10 = 0;
            int i11 = 0;
            for (String str3 : split) {
                String[] strArr = f21208c;
                int length = strArr.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        z10 = false;
                        break;
                    }
                    String str4 = strArr[i12];
                    if (str4.equals(str3)) {
                        if (i10 < split2.length && str4.equals(split2[i10])) {
                            i10++;
                        }
                        z10 = true;
                    } else {
                        i12++;
                    }
                }
                if (!z10) {
                    int i13 = i11;
                    int i14 = i10;
                    while (i10 < split2.length) {
                        if (str3.equals(split2[i10])) {
                            if (i10 == i14) {
                                i14++;
                            }
                            i13++;
                            if (i13 >= 2) {
                                return true;
                            }
                        }
                        i10++;
                    }
                    i10 = i14;
                    i11 = i13;
                }
            }
            return false;
        }
        return false;
    }

    private void b() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f21210b) {
            try {
                Iterator<a> it = this.f21210b.iterator();
                while (it.hasNext() && currentTimeMillis - it.next().f21215e > 1800000) {
                    it.remove();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
