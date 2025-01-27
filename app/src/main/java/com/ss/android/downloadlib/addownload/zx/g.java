package com.ss.android.downloadlib.addownload.zx;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.ss.android.downloadlib.addownload.pa;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: j */
    private static volatile g f24218j;
    private final LinkedList<j> zx = new LinkedList<>();

    /* renamed from: i */
    private static final String[] f24217i = {"com", BaseWrapper.BASE_PKG_SYSTEM, "ss"};

    /* renamed from: g */
    private static final int[] f24216g = {3101, 3102, 3103, 3201, 3202, 3203};

    public static class j {

        /* renamed from: g */
        public final String f24219g;

        /* renamed from: i */
        public final String f24220i;

        /* renamed from: j */
        public final String f24221j;
        public final long q;
        public final int zx;

        /* synthetic */ j(String str, int i2, String str2, String str3, long j2, AnonymousClass1 anonymousClass1) {
            this(str, i2, str2, str3, j2);
        }

        private j(String str, int i2, String str2, String str3, long j2) {
            this.f24221j = str;
            this.zx = i2;
            this.f24220i = str2 != null ? str2.toLowerCase() : null;
            this.f24219g = str3 != null ? str3.toLowerCase() : null;
            this.q = j2;
        }
    }

    private g() {
    }

    private j i(String str) {
        try {
            PackageManager packageManager = pa.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new j(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static g j() {
        if (f24218j == null) {
            synchronized (g.class) {
                if (f24218j == null) {
                    f24218j = new g();
                }
            }
        }
        return f24218j;
    }

    public void zx(String str) {
        zx();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.zx) {
            Iterator<j> it = this.zx.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().f24221j)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void j(String str) {
        j i2;
        zx();
        if (TextUtils.isEmpty(str) || (i2 = i(str)) == null) {
            return;
        }
        synchronized (this.zx) {
            this.zx.add(i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0096, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.zx.g.j, java.lang.Integer> zx(com.ss.android.downloadad.api.j.zx r19) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.zx.g.zx(com.ss.android.downloadad.api.j.zx):android.util.Pair");
    }

    public j j(com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return null;
        }
        zx();
        synchronized (this.zx) {
            Iterator<j> it = this.zx.iterator();
            while (it.hasNext()) {
                j next = it.next();
                if (next.q > zxVar.qo()) {
                    return next;
                }
            }
            return null;
        }
    }

    private static boolean j(String str, String str2) {
        String[] split;
        String[] split2;
        boolean z;
        try {
            split = str.split("\\.");
            split2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (split.length != 0 && split2.length != 0) {
            int i2 = 0;
            int i3 = 0;
            for (String str3 : split) {
                String[] strArr = f24217i;
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        z = false;
                        break;
                    }
                    String str4 = strArr[i4];
                    if (str4.equals(str3)) {
                        if (i2 < split2.length && str4.equals(split2[i2])) {
                            i2++;
                        }
                        z = true;
                    } else {
                        i4++;
                    }
                }
                if (!z) {
                    int i5 = i3;
                    int i6 = i2;
                    while (i2 < split2.length) {
                        if (str3.equals(split2[i2])) {
                            if (i2 == i6) {
                                i6++;
                            }
                            i5++;
                            if (i5 >= 2) {
                                return true;
                            }
                        }
                        i2++;
                    }
                    i2 = i6;
                    i3 = i5;
                }
            }
            return false;
        }
        return false;
    }

    private void zx() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.zx) {
            Iterator<j> it = this.zx.iterator();
            while (it.hasNext() && currentTimeMillis - it.next().q > 1800000) {
                it.remove();
            }
        }
    }
}
