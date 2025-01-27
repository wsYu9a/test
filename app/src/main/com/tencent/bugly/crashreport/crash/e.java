package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointType;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.AbstractC0868m;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.L;
import com.tencent.bugly.proguard.M;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.tencent.bugly.proguard.ka;
import com.tencent.bugly.proguard.ma;
import com.tencent.bugly.proguard.na;
import com.tencent.bugly.proguard.oa;
import com.tencent.bugly.proguard.pa;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    public static int f22447a;

    /* renamed from: b */
    protected final Context f22448b;

    /* renamed from: c */
    protected final T f22449c;

    /* renamed from: d */
    protected final J f22450d;

    /* renamed from: e */
    protected final com.tencent.bugly.crashreport.common.strategy.c f22451e;

    /* renamed from: f */
    protected m f22452f;

    /* renamed from: g */
    protected BuglyStrategy.a f22453g;

    public e(int i10, Context context, T t10, J j10, com.tencent.bugly.crashreport.common.strategy.c cVar, BuglyStrategy.a aVar, m mVar) {
        f22447a = i10;
        this.f22448b = context;
        this.f22449c = t10;
        this.f22450d = j10;
        this.f22451e = cVar;
        this.f22453g = aVar;
        this.f22452f = mVar;
    }

    private boolean g(CrashDetailBean crashDetailBean) {
        String absolutePath;
        try {
            X.a("save eup logs", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
            String e10 = m10.e();
            String str = m10.E;
            String str2 = crashDetailBean.A;
            String format = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", e10, str, m10.f22304l, str2, ca.a(new Date(crashDetailBean.f22391r)), crashDetailBean.f22387n, crashDetailBean.f22388o, crashDetailBean.f22390q, crashDetailBean.f22376c);
            if (h.f22471j != null) {
                File file = new File(h.f22471j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                absolutePath = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(absolutePath2);
                sb2.append("/Tencent/");
                sb2.append(this.f22448b.getPackageName());
                absolutePath = sb2.toString();
            } else {
                absolutePath = null;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(absolutePath);
            sb3.append("/euplog.txt");
            ca.a(this.f22448b, sb3.toString(), format, h.f22472k);
            return true;
        } catch (Throwable th2) {
            X.e("rqdp{  save error} %s", th2.toString());
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return false;
        }
    }

    public CrashDetailBean a(List<b> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> a10;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        ArrayList arrayList = new ArrayList(10);
        for (b bVar : list) {
            if (bVar.f22443e) {
                arrayList.add(bVar);
            }
        }
        CrashDetailBean crashDetailBean2 = null;
        if (arrayList.size() > 0 && (a10 = a(arrayList)) != null && a10.size() > 0) {
            Collections.sort(a10);
            for (int i10 = 0; i10 < a10.size(); i10++) {
                CrashDetailBean crashDetailBean3 = a10.get(i10);
                if (i10 == 0) {
                    crashDetailBean2 = crashDetailBean3;
                } else {
                    String str = crashDetailBean3.f22392s;
                    if (str != null && (split = str.split("\n")) != null) {
                        for (String str2 : split) {
                            if (!crashDetailBean2.f22392s.contains("" + str2)) {
                                crashDetailBean2.f22393t++;
                                crashDetailBean2.f22392s += str2 + "\n";
                            }
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f22383j = true;
            crashDetailBean.f22393t = 0;
            crashDetailBean.f22392s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (b bVar2 : list) {
            if (!bVar2.f22443e && !bVar2.f22442d) {
                if (!crashDetailBean2.f22392s.contains("" + bVar2.f22440b)) {
                    crashDetailBean2.f22393t++;
                    crashDetailBean2.f22392s += bVar2.f22440b + "\n";
                }
            }
        }
        if (crashDetailBean2.f22391r != crashDetailBean.f22391r) {
            if (!crashDetailBean2.f22392s.contains("" + crashDetailBean.f22391r)) {
                crashDetailBean2.f22393t++;
                crashDetailBean2.f22392s += crashDetailBean.f22391r + "\n";
            }
        }
        return crashDetailBean2;
    }

    public List<b> b(List<b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar.f22442d && bVar.f22440b <= currentTimeMillis - 86400000) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public boolean c(CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00de A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:11:0x0013, B:12:0x0015, B:15:0x006d, B:18:0x0074, B:22:0x0084, B:24:0x0090, B:26:0x00ae, B:28:0x00b5, B:31:0x00de, B:33:0x00e4, B:34:0x00f7, B:36:0x00fd, B:39:0x0110, B:41:0x011e, B:43:0x0124, B:44:0x0131, B:46:0x013d, B:48:0x0149, B:50:0x0160, B:51:0x0185, B:53:0x018c, B:56:0x016e, B:58:0x0175, B:64:0x01a1, B:67:0x01ac, B:68:0x01e7, B:70:0x01eb, B:73:0x01f0, B:75:0x020a, B:76:0x0216, B:79:0x021c, B:82:0x0251, B:87:0x01cb, B:90:0x01d4, B:93:0x00b9, B:96:0x00c5, B:98:0x001b, B:102:0x002b, B:106:0x0038, B:110:0x0045, B:115:0x0054, B:119:0x0061), top: B:10:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fd A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:11:0x0013, B:12:0x0015, B:15:0x006d, B:18:0x0074, B:22:0x0084, B:24:0x0090, B:26:0x00ae, B:28:0x00b5, B:31:0x00de, B:33:0x00e4, B:34:0x00f7, B:36:0x00fd, B:39:0x0110, B:41:0x011e, B:43:0x0124, B:44:0x0131, B:46:0x013d, B:48:0x0149, B:50:0x0160, B:51:0x0185, B:53:0x018c, B:56:0x016e, B:58:0x0175, B:64:0x01a1, B:67:0x01ac, B:68:0x01e7, B:70:0x01eb, B:73:0x01f0, B:75:0x020a, B:76:0x0216, B:79:0x021c, B:82:0x0251, B:87:0x01cb, B:90:0x01d4, B:93:0x00b9, B:96:0x00c5, B:98:0x001b, B:102:0x002b, B:106:0x0038, B:110:0x0045, B:115:0x0054, B:119:0x0061), top: B:10:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01eb A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #0 {all -> 0x0028, blocks: (B:11:0x0013, B:12:0x0015, B:15:0x006d, B:18:0x0074, B:22:0x0084, B:24:0x0090, B:26:0x00ae, B:28:0x00b5, B:31:0x00de, B:33:0x00e4, B:34:0x00f7, B:36:0x00fd, B:39:0x0110, B:41:0x011e, B:43:0x0124, B:44:0x0131, B:46:0x013d, B:48:0x0149, B:50:0x0160, B:51:0x0185, B:53:0x018c, B:56:0x016e, B:58:0x0175, B:64:0x01a1, B:67:0x01ac, B:68:0x01e7, B:70:0x01eb, B:73:0x01f0, B:75:0x020a, B:76:0x0216, B:79:0x021c, B:82:0x0251, B:87:0x01cb, B:90:0x01d4, B:93:0x00b9, B:96:0x00c5, B:98:0x001b, B:102:0x002b, B:106:0x0038, B:110:0x0045, B:115:0x0054, B:119:0x0061), top: B:10:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01cb A[Catch: all -> 0x0028, TRY_LEAVE, TryCatch #0 {all -> 0x0028, blocks: (B:11:0x0013, B:12:0x0015, B:15:0x006d, B:18:0x0074, B:22:0x0084, B:24:0x0090, B:26:0x00ae, B:28:0x00b5, B:31:0x00de, B:33:0x00e4, B:34:0x00f7, B:36:0x00fd, B:39:0x0110, B:41:0x011e, B:43:0x0124, B:44:0x0131, B:46:0x013d, B:48:0x0149, B:50:0x0160, B:51:0x0185, B:53:0x018c, B:56:0x016e, B:58:0x0175, B:64:0x01a1, B:67:0x01ac, B:68:0x01e7, B:70:0x01eb, B:73:0x01f0, B:75:0x020a, B:76:0x0216, B:79:0x021c, B:82:0x0251, B:87:0x01cb, B:90:0x01d4, B:93:0x00b9, B:96:0x00c5, B:98:0x001b, B:102:0x002b, B:106:0x0038, B:110:0x0045, B:115:0x0054, B:119:0x0061), top: B:10:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.tencent.bugly.crashreport.crash.CrashDetailBean r22) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.e.d(com.tencent.bugly.crashreport.crash.CrashDetailBean):void");
    }

    public void e(CrashDetailBean crashDetailBean) {
        int i10 = crashDetailBean.f22375b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 3 && !h.g().j()) {
                    return;
                }
            } else if (!h.g().k()) {
                return;
            }
        } else if (!h.g().k()) {
            return;
        }
        if (this.f22452f != null) {
            X.a("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f22452f.a(crashDetailBean.f22375b == 1);
        }
    }

    public void f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues b10 = b(crashDetailBean);
        if (b10 != null) {
            long a10 = J.a().a("t_cr", b10, (I) null, true);
            if (a10 >= 0) {
                X.a("insert %s success!", "t_cr");
                crashDetailBean.f22374a = a10;
            }
        }
        if (h.f22470i) {
            g(crashDetailBean);
        }
    }

    public void c(List<b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id");
        sb2.append(" in ");
        sb2.append("(");
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().f22439a);
            sb2.append(",");
        }
        StringBuilder sb3 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        sb3.append(")");
        String sb4 = sb3.toString();
        sb3.setLength(0);
        try {
            X.a("deleted %s data %d", "t_cr", Integer.valueOf(J.a().a("t_cr", sb4, (String[]) null, (I) null, true)));
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public List<CrashDetailBean> b() {
        StrategyBean c10 = com.tencent.bugly.crashreport.common.strategy.c.b().c();
        if (c10 == null) {
            X.e("have not synced remote!", new Object[0]);
            return null;
        }
        if (!c10.f22342f) {
            X.e("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            X.d("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b10 = ca.b();
        List<b> a10 = a();
        X.a("Size of crash list loaded from DB: %s", Integer.valueOf(a10.size()));
        if (a10.size() <= 0) {
            return null;
        }
        List<b> arrayList = new ArrayList<>();
        arrayList.addAll(b(a10));
        a10.removeAll(arrayList);
        Iterator<b> it = a10.iterator();
        while (it.hasNext()) {
            b next = it.next();
            long j10 = next.f22440b;
            if (j10 < b10 - h.f22468g) {
                it.remove();
                arrayList.add(next);
            } else if (next.f22442d) {
                if (j10 >= currentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f22443e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f22444f >= 3 && j10 < currentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        List<CrashDetailBean> arrayList2 = new ArrayList<>();
        List<CrashDetailBean> a11 = a(a10);
        if (a11 != null && a11.size() > 0) {
            String str = com.tencent.bugly.crashreport.common.info.a.m().E;
            Iterator<CrashDetailBean> it2 = a11.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f22379f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return a11;
    }

    public boolean a(CrashDetailBean crashDetailBean, int i10) {
        ArrayList arrayList;
        if (crashDetailBean == null) {
            return true;
        }
        String str = h.f22475n;
        if (str != null && !str.isEmpty()) {
            X.a("Crash filter for crash stack is: %s", h.f22475n);
            if (crashDetailBean.f22390q.contains(h.f22475n)) {
                X.e("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = h.f22476o;
        if (str2 != null && !str2.isEmpty()) {
            X.a("Crash regular filter for crash stack is: %s", h.f22476o);
            if (Pattern.compile(h.f22476o).matcher(crashDetailBean.f22390q).find()) {
                X.e("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f22375b != 2) {
            L l10 = new L();
            l10.f22629b = 1;
            l10.f22630c = crashDetailBean.A;
            l10.f22631d = crashDetailBean.B;
            l10.f22632e = crashDetailBean.f22391r;
            this.f22450d.b(1);
            this.f22450d.c(l10);
            X.d("[crash] a crash occur, handling...", new Object[0]);
        } else {
            X.d("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<b> a10 = a();
        if (a10 == null || a10.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(b(a10));
            a10.removeAll(arrayList);
            if (a10.size() > 20) {
                a(5);
            }
            if (a(crashDetailBean)) {
                boolean z10 = false;
                for (b bVar : a10) {
                    if (crashDetailBean.f22394u.equals(bVar.f22441c)) {
                        if (bVar.f22443e) {
                            z10 = true;
                        }
                        arrayList2.add(bVar);
                    }
                }
                if (z10 || arrayList2.size() >= h.f22464c) {
                    X.c("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a11 = a(arrayList2, crashDetailBean);
                    for (b bVar2 : arrayList2) {
                        if (bVar2.f22439a != a11.f22374a) {
                            arrayList.add(bVar2);
                        }
                    }
                    f(a11);
                    c(arrayList);
                    X.d("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        f(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        X.d("[crash] save crash success", new Object[0]);
        return false;
    }

    public ContentValues b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = crashDetailBean.f22374a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f22391r));
            contentValues.put("_s1", crashDetailBean.f22394u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f22377d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f22383j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f22385l));
            contentValues.put("_dt", ca.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public CrashDetailBean b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ca.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f22374a = j10;
            }
            return crashDetailBean;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb2.append(" or ");
                    sb2.append("_id");
                    sb2.append(" = ");
                    sb2.append(crashDetailBean.f22374a);
                }
                String sb3 = sb2.toString();
                if (sb3.length() > 0) {
                    sb3 = sb3.substring(4);
                }
                String str = sb3;
                sb2.setLength(0);
                X.a("deleted %s data %d", "t_cr", Integer.valueOf(J.a().a("t_cr", str, (String[]) null, (I) null, true)));
            } catch (Throwable th2) {
                if (X.b(th2)) {
                    return;
                }
                th2.printStackTrace();
            }
        }
    }

    public boolean a(CrashDetailBean crashDetailBean) {
        int i10 = crashDetailBean.f22375b;
        return !com.tencent.bugly.b.f22066c && (!((i10 == 3) || (i10 == 0 || i10 == 1)) || h.f22465d);
    }

    public void a(CrashDetailBean crashDetailBean, long j10, boolean z10) {
        if (h.f22473l) {
            X.c("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, j10, z10, crashDetailBean.f22375b == 7, z10);
            return;
        }
        X.c("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public void a(List<CrashDetailBean> list, long j10, boolean z10, boolean z11, boolean z12) {
        if (!com.tencent.bugly.crashreport.common.info.a.a(this.f22448b).f22300j) {
            X.e("warn: not upload process", new Object[0]);
            return;
        }
        T t10 = this.f22449c;
        if (t10 == null) {
            X.e("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z12 && !t10.a(h.f22462a)) {
            X.e("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean c10 = this.f22451e.c();
        if (!c10.f22342f) {
            X.e("remote report is disable!", new Object[0]);
            X.d("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            try {
                String str = c10.f22354r;
                String str2 = StrategyBean.f22338b;
                oa a10 = a(this.f22448b, list, com.tencent.bugly.crashreport.common.info.a.m());
                if (a10 == null) {
                    X.e("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] a11 = M.a((AbstractC0868m) a10);
                if (a11 == null) {
                    X.e("send encode fail!", new Object[0]);
                    return;
                }
                pa a12 = M.a(this.f22448b, 830, a11);
                if (a12 == null) {
                    X.e("request package is null.", new Object[0]);
                    return;
                }
                d dVar = new d(this, list);
                if (z10) {
                    this.f22449c.a(f22447a, a12, str, str2, dVar, j10, z11);
                    return;
                } else {
                    this.f22449c.a(f22447a, a12, str, str2, dVar, false);
                    return;
                }
            } catch (Throwable th2) {
                X.b("req cr error %s", th2.toString());
                if (X.a(th2)) {
                    return;
                }
                th2.printStackTrace();
                return;
            }
        }
        X.e("warn: crashList is null or crashList num is 0", new Object[0]);
    }

    public void a(boolean z10, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            X.a("up finish update state %b", Boolean.valueOf(z10));
            for (CrashDetailBean crashDetailBean : list) {
                X.a("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f22376c, Integer.valueOf(crashDetailBean.f22385l), Boolean.valueOf(crashDetailBean.f22377d), Boolean.valueOf(crashDetailBean.f22383j));
                int i10 = crashDetailBean.f22385l + 1;
                crashDetailBean.f22385l = i10;
                crashDetailBean.f22377d = z10;
                X.a("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f22376c, Integer.valueOf(i10), Boolean.valueOf(crashDetailBean.f22377d), Boolean.valueOf(crashDetailBean.f22383j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                h.g().a(it.next());
            }
            X.a("update state size %d", Integer.valueOf(list.size()));
        }
        if (z10) {
            return;
        }
        X.d("[crash] upload fail.", new Object[0]);
    }

    public List<CrashDetailBean> a(List<b> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id");
        sb2.append(" in ");
        sb2.append("(");
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().f22439a);
            sb2.append(",");
        }
        if (sb2.toString().contains(",")) {
            sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        }
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            cursor = J.a().a("t_cr", null, sb3, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb2.append("_id");
                sb2.append(" in ");
                sb2.append("(");
                int i10 = 0;
                while (cursor.moveToNext()) {
                    try {
                        CrashDetailBean b10 = b(cursor);
                        if (b10 != null) {
                            arrayList.add(b10);
                        } else {
                            try {
                                sb2.append(cursor.getLong(cursor.getColumnIndex("_id")));
                                sb2.append(",");
                                i10++;
                            } catch (Throwable unused) {
                                X.e("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            if (!X.b(th)) {
                                th.printStackTrace();
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                String sb4 = sb2.toString();
                if (i10 > 0) {
                    X.e("deleted %s illegal data %d", "t_cr", Integer.valueOf(J.a().a("t_cr", sb4, (String[]) null, (I) null, true)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public b a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.f22439a = cursor.getLong(cursor.getColumnIndex("_id"));
            bVar.f22440b = cursor.getLong(cursor.getColumnIndex("_tm"));
            bVar.f22441c = cursor.getString(cursor.getColumnIndex("_s1"));
            bVar.f22442d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            bVar.f22443e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            bVar.f22444f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return bVar;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public List<b> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a10 = J.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (a10 == null) {
                if (a10 != null) {
                    a10.close();
                }
                return null;
            }
            try {
                if (a10.getCount() < 1) {
                    a10.close();
                    return arrayList;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id");
                sb2.append(" in ");
                sb2.append("(");
                int i10 = 0;
                while (a10.moveToNext()) {
                    try {
                        b a11 = a(a10);
                        if (a11 != null) {
                            arrayList.add(a11);
                        } else {
                            try {
                                sb2.append(a10.getLong(a10.getColumnIndex("_id")));
                                sb2.append(",");
                                i10++;
                            } catch (Throwable unused) {
                                X.e("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = a10;
                        try {
                            if (!X.b(th)) {
                                th.printStackTrace();
                            }
                            return arrayList;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                String sb3 = sb2.toString();
                sb2.setLength(0);
                if (i10 > 0) {
                    X.e("deleted %s illegal data %d", "t_cr", Integer.valueOf(J.a().a("t_cr", sb3, (String[]) null, (I) null, true)));
                }
                a10.close();
                return arrayList;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public void a(int i10) {
        if (i10 <= 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id");
        sb2.append(" in ");
        sb2.append("(");
        sb2.append("SELECT ");
        sb2.append("_id");
        sb2.append(" FROM ");
        sb2.append("t_cr");
        sb2.append(" order by ");
        sb2.append("_id");
        sb2.append(" limit ");
        sb2.append(i10);
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            X.a("deleted first record %s data %d", "t_cr", Integer.valueOf(J.a().a("t_cr", sb3, (String[]) null, (I) null, true)));
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public static na a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        ma a10;
        ma a11;
        ma maVar;
        if (context != null && crashDetailBean != null && aVar != null) {
            na naVar = new na();
            int i10 = crashDetailBean.f22375b;
            switch (i10) {
                case 0:
                    naVar.f22779i = crashDetailBean.f22383j ? "200" : "100";
                    break;
                case 1:
                    naVar.f22779i = crashDetailBean.f22383j ? "201" : PointType.ANTI_SPAM;
                    break;
                case 2:
                    naVar.f22779i = crashDetailBean.f22383j ? "202" : PointType.ANTI_SPAM_TOUCH;
                    break;
                case 3:
                    naVar.f22779i = crashDetailBean.f22383j ? "203" : "103";
                    break;
                case 4:
                    naVar.f22779i = crashDetailBean.f22383j ? "204" : "104";
                    break;
                case 5:
                    naVar.f22779i = crashDetailBean.f22383j ? "207" : PointType.WIND_ACTIVE;
                    break;
                case 6:
                    naVar.f22779i = crashDetailBean.f22383j ? "206" : "106";
                    break;
                case 7:
                    naVar.f22779i = crashDetailBean.f22383j ? "208" : "108";
                    break;
                default:
                    X.b("crash type error! %d", Integer.valueOf(i10));
                    break;
            }
            naVar.f22780j = crashDetailBean.f22391r;
            naVar.f22781k = crashDetailBean.f22387n;
            naVar.f22782l = crashDetailBean.f22388o;
            naVar.f22783m = crashDetailBean.f22389p;
            naVar.f22785o = crashDetailBean.f22390q;
            naVar.f22786p = crashDetailBean.f22399z;
            naVar.f22787q = crashDetailBean.f22376c;
            naVar.f22788r = null;
            naVar.f22790t = crashDetailBean.f22386m;
            naVar.f22791u = crashDetailBean.f22378e;
            naVar.f22784n = crashDetailBean.B;
            naVar.f22792v = null;
            X.a("libInfo %s", naVar.f22793w);
            Map<String, PlugInBean> map = crashDetailBean.f22381h;
            if (map != null && map.size() > 0) {
                naVar.f22794x = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f22381h.entrySet()) {
                    ka kaVar = new ka();
                    kaVar.f22755a = entry.getValue().f22279a;
                    kaVar.f22757c = entry.getValue().f22281c;
                    kaVar.f22759e = entry.getValue().f22280b;
                    naVar.f22794x.add(kaVar);
                }
            }
            if (crashDetailBean.f22383j) {
                naVar.f22789s = crashDetailBean.f22393t;
                String str = crashDetailBean.f22392s;
                if (str != null && str.length() > 0) {
                    if (naVar.f22795y == null) {
                        naVar.f22795y = new ArrayList<>();
                    }
                    try {
                        naVar.f22795y.add(new ma((byte) 1, "alltimes.txt", crashDetailBean.f22392s.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e10) {
                        e10.printStackTrace();
                        naVar.f22795y = null;
                    }
                }
                Integer valueOf = Integer.valueOf(naVar.f22789s);
                ArrayList<ma> arrayList = naVar.f22795y;
                X.a("crashcount:%d sz:%d", valueOf, Integer.valueOf(arrayList != null ? arrayList.size() : 0));
            }
            if (crashDetailBean.f22396w != null) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                try {
                    naVar.f22795y.add(new ma((byte) 1, "log.txt", crashDetailBean.f22396w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e11) {
                    e11.printStackTrace();
                    naVar.f22795y = null;
                }
            }
            if (crashDetailBean.f22397x != null) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                try {
                    naVar.f22795y.add(new ma((byte) 1, "jniLog.txt", crashDetailBean.f22397x.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e12) {
                    e12.printStackTrace();
                    naVar.f22795y = null;
                }
            }
            if (!ca.b(crashDetailBean.W)) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                try {
                    maVar = new ma((byte) 1, "crashInfos.txt", crashDetailBean.W.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e13) {
                    e13.printStackTrace();
                    maVar = null;
                }
                if (maVar != null) {
                    X.a("attach crash infos", new Object[0]);
                    naVar.f22795y.add(maVar);
                }
            }
            if (crashDetailBean.X != null) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                ma a12 = a("backupRecord.zip", context, crashDetailBean.X);
                if (a12 != null) {
                    X.a("attach backup record", new Object[0]);
                    naVar.f22795y.add(a12);
                }
            }
            byte[] bArr = crashDetailBean.f22398y;
            if (bArr != null && bArr.length > 0) {
                ma maVar2 = new ma((byte) 2, "buglylog.zip", bArr);
                X.a("attach user log", new Object[0]);
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                naVar.f22795y.add(maVar2);
            }
            if (crashDetailBean.f22375b == 3) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                X.a("crashBean.anrMessages:%s", crashDetailBean.Q);
                Map<String, String> map2 = crashDetailBean.Q;
                if (map2 != null && map2.containsKey("BUGLY_CR_01")) {
                    try {
                        if (!TextUtils.isEmpty(crashDetailBean.Q.get("BUGLY_CR_01"))) {
                            naVar.f22795y.add(new ma((byte) 1, "anrMessage.txt", crashDetailBean.Q.get("BUGLY_CR_01").getBytes("utf-8")));
                            X.a("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e14) {
                        e14.printStackTrace();
                        naVar.f22795y = null;
                    }
                    crashDetailBean.Q.remove("BUGLY_CR_01");
                }
                if (crashDetailBean.f22395v != null && NativeCrashHandler.getInstance().isEnableCatchAnrTrace() && (a11 = a("trace.zip", context, crashDetailBean.f22395v)) != null) {
                    X.a("attach traces", new Object[0]);
                    naVar.f22795y.add(a11);
                }
            }
            if (crashDetailBean.f22375b == 1) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                String str2 = crashDetailBean.f22395v;
                if (str2 != null && (a10 = a("tomb.zip", context, str2)) != null) {
                    X.a("attach tombs", new Object[0]);
                    naVar.f22795y.add(a10);
                }
            }
            List<String> list = aVar.f22309na;
            if (list != null && !list.isEmpty()) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> it = aVar.f22309na.iterator();
                while (it.hasNext()) {
                    sb2.append(it.next());
                }
                try {
                    naVar.f22795y.add(new ma((byte) 1, "martianlog.txt", sb2.toString().getBytes("utf-8")));
                    X.a("attach pageTracingList", new Object[0]);
                } catch (UnsupportedEncodingException e15) {
                    e15.printStackTrace();
                }
            }
            byte[] bArr2 = crashDetailBean.V;
            if (bArr2 != null && bArr2.length > 0) {
                if (naVar.f22795y == null) {
                    naVar.f22795y = new ArrayList<>();
                }
                naVar.f22795y.add(new ma((byte) 1, "userExtraByteData", crashDetailBean.V));
                X.a("attach extraData", new Object[0]);
            }
            HashMap hashMap = new HashMap();
            naVar.f22796z = hashMap;
            hashMap.put("A9", "" + crashDetailBean.C);
            naVar.f22796z.put("A11", "" + crashDetailBean.D);
            naVar.f22796z.put("A10", "" + crashDetailBean.E);
            naVar.f22796z.put("A23", "" + crashDetailBean.f22379f);
            naVar.f22796z.put("A7", "" + aVar.f22308n);
            naVar.f22796z.put("A6", "" + aVar.j());
            naVar.f22796z.put("A5", "" + aVar.k());
            naVar.f22796z.put("A22", "" + aVar.l());
            naVar.f22796z.put("A2", "" + crashDetailBean.G);
            naVar.f22796z.put("A1", "" + crashDetailBean.F);
            naVar.f22796z.put("A24", "" + aVar.f22312p);
            naVar.f22796z.put("A17", "" + crashDetailBean.H);
            naVar.f22796z.put("A25", "" + aVar.l());
            naVar.f22796z.put("A15", "" + aVar.i());
            naVar.f22796z.put("A13", "" + aVar.n());
            naVar.f22796z.put("A34", "" + crashDetailBean.A);
            if (aVar.f22291ea != null) {
                naVar.f22796z.put("productIdentify", "" + aVar.f22291ea);
            }
            try {
                naVar.f22796z.put("A26", "" + URLEncoder.encode(crashDetailBean.I, "utf-8"));
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            if (crashDetailBean.f22375b == 1) {
                naVar.f22796z.put("A27", "" + crashDetailBean.L);
                naVar.f22796z.put("A28", "" + crashDetailBean.K);
                naVar.f22796z.put("A29", "" + crashDetailBean.f22384k);
            }
            naVar.f22796z.put("A30", "" + crashDetailBean.M);
            naVar.f22796z.put("A18", "" + crashDetailBean.N);
            Map<String, String> map3 = naVar.f22796z;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(!crashDetailBean.O);
            map3.put("A36", sb3.toString());
            naVar.f22796z.put("F02", "" + aVar.X);
            naVar.f22796z.put("F03", "" + aVar.Y);
            naVar.f22796z.put("F04", "" + aVar.u());
            naVar.f22796z.put("F05", "" + aVar.Z);
            naVar.f22796z.put("F06", "" + aVar.W);
            naVar.f22796z.put("F08", "" + aVar.f22287ca);
            naVar.f22796z.put("F09", "" + aVar.f22289da);
            naVar.f22796z.put("F10", "" + aVar.f22283aa);
            if (crashDetailBean.R >= 0) {
                naVar.f22796z.put("C01", "" + crashDetailBean.R);
            }
            if (crashDetailBean.S >= 0) {
                naVar.f22796z.put("C02", "" + crashDetailBean.S);
            }
            Map<String, String> map4 = crashDetailBean.T;
            if (map4 != null && map4.size() > 0) {
                for (Map.Entry<String, String> entry2 : crashDetailBean.T.entrySet()) {
                    naVar.f22796z.put("C03_" + entry2.getKey(), entry2.getValue());
                }
            }
            Map<String, String> map5 = crashDetailBean.U;
            if (map5 != null && map5.size() > 0) {
                for (Map.Entry<String, String> entry3 : crashDetailBean.U.entrySet()) {
                    naVar.f22796z.put("C04_" + entry3.getKey(), entry3.getValue());
                }
            }
            naVar.A = null;
            Map<String, String> map6 = crashDetailBean.P;
            if (map6 != null && map6.size() > 0) {
                Map<String, String> map7 = crashDetailBean.P;
                naVar.A = map7;
                X.c("setted message size %d", Integer.valueOf(map7.size()));
            }
            X.a("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", crashDetailBean.f22387n, crashDetailBean.f22376c, aVar.u(), Long.valueOf((crashDetailBean.f22391r - crashDetailBean.N) / 1000), Boolean.valueOf(crashDetailBean.f22384k), Boolean.valueOf(crashDetailBean.O), Boolean.valueOf(crashDetailBean.f22383j), Boolean.valueOf(crashDetailBean.f22375b == 1), Integer.valueOf(crashDetailBean.f22393t), crashDetailBean.f22392s, Boolean.valueOf(crashDetailBean.f22377d), Integer.valueOf(naVar.f22796z.size()));
            return naVar;
        }
        X.e("enExp args == null", new Object[0]);
        return null;
    }

    public static oa a(Context context, List<CrashDetailBean> list, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (context != null && list != null && list.size() != 0 && aVar != null) {
            oa oaVar = new oa();
            oaVar.f22798b = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                oaVar.f22798b.add(a(context, it.next(), aVar));
            }
            return oaVar;
        }
        X.e("enEXPPkg args == null!", new Object[0]);
        return null;
    }

    public static ma a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            X.a("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!ca.a(file, file2, 5000)) {
                X.e("zip fail!", new Object[0]);
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                X.a("read bytes :%d", Integer.valueOf(byteArray.length));
                ma maVar = new ma((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e10) {
                    if (!X.b(e10)) {
                        e10.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    X.a("del tmp", new Object[0]);
                    file2.delete();
                }
                return maVar;
            } catch (Throwable th3) {
                th = th3;
                try {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            if (!X.b(e11)) {
                                e11.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        X.a("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th4) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e12) {
                            if (!X.b(e12)) {
                                e12.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        X.a("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th4;
                }
            }
        }
        X.e("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        if (m10 == null) {
            return;
        }
        X.b("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        X.b("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        X.b("# PKG NAME: %s", m10.f22294g);
        X.b("# APP VER: %s", m10.E);
        X.b("# SDK VER: %s", m10.f22304l);
        X.b("# LAUNCH TIME: %s", ca.a(new Date(com.tencent.bugly.crashreport.common.info.a.m().f22288d)));
        X.b("# CRASH TYPE: %s", str);
        X.b("# CRASH TIME: %s", str2);
        X.b("# CRASH PROCESS: %s", str3);
        X.b("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            X.b("# REPORT ID: %s", crashDetailBean.f22376c);
            X.b("# CRASH DEVICE: %s %s", m10.f22310o, m10.n().booleanValue() ? "ROOTED" : "UNROOT");
            X.b("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            X.b("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ca.b(crashDetailBean.L)) {
                X.b("# EXCEPTION FIRED BY %s %s", crashDetailBean.L, crashDetailBean.K);
            } else if (crashDetailBean.f22375b == 3) {
                if (crashDetailBean.Q == null) {
                    str6 = "null";
                } else {
                    str6 = "" + crashDetailBean.Q.get("BUGLY_CR_01");
                }
                X.b("# EXCEPTION ANR MESSAGE:\n %s", str6);
            }
        }
        if (!ca.b(str5)) {
            X.b("# CRASH STACK: ", new Object[0]);
            X.b(str5, new Object[0]);
        }
        X.b("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
