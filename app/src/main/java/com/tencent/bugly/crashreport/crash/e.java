package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.AbstractC0909m;
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
    public static int f24840a;

    /* renamed from: b */
    protected final Context f24841b;

    /* renamed from: c */
    protected final T f24842c;

    /* renamed from: d */
    protected final J f24843d;

    /* renamed from: e */
    protected final com.tencent.bugly.crashreport.common.strategy.c f24844e;

    /* renamed from: f */
    protected m f24845f;

    /* renamed from: g */
    protected BuglyStrategy.a f24846g;

    public e(int i2, Context context, T t, J j2, com.tencent.bugly.crashreport.common.strategy.c cVar, BuglyStrategy.a aVar, m mVar) {
        f24840a = i2;
        this.f24841b = context;
        this.f24842c = t;
        this.f24843d = j2;
        this.f24844e = cVar;
        this.f24846g = aVar;
        this.f24845f = mVar;
    }

    private boolean g(CrashDetailBean crashDetailBean) {
        try {
            X.a("save eup logs", new Object[0]);
            com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
            String e2 = m.e();
            String str = m.E;
            String str2 = crashDetailBean.A;
            String format = String.format(Locale.US, "#--------\npackage:%s\nversion:%s\nsdk:%s\nprocess:%s\ndate:%s\ntype:%s\nmessage:%s\nstack:\n%s\neupID:%s\n", e2, str, m.l, str2, ca.a(new Date(crashDetailBean.r)), crashDetailBean.n, crashDetailBean.o, crashDetailBean.q, crashDetailBean.f24789c);
            String str3 = null;
            if (h.f24864j != null) {
                File file = new File(h.f24864j);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str3 = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder sb = new StringBuilder();
                sb.append(absolutePath);
                sb.append("/Tencent/");
                sb.append(this.f24841b.getPackageName());
                str3 = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append("/euplog.txt");
            ca.a(this.f24841b, sb2.toString(), format, h.k);
            return true;
        } catch (Throwable th) {
            X.e("rqdp{  save error} %s", th.toString());
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    protected CrashDetailBean a(List<b> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> a2;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (b bVar : list) {
            if (bVar.f24836e) {
                arrayList.add(bVar);
            }
        }
        if (arrayList.size() > 0 && (a2 = a(arrayList)) != null && a2.size() > 0) {
            Collections.sort(a2);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                CrashDetailBean crashDetailBean3 = a2.get(i2);
                if (i2 == 0) {
                    crashDetailBean2 = crashDetailBean3;
                } else {
                    String str = crashDetailBean3.s;
                    if (str != null && (split = str.split("\n")) != null) {
                        for (String str2 : split) {
                            if (!crashDetailBean2.s.contains("" + str2)) {
                                crashDetailBean2.t++;
                                crashDetailBean2.s += str2 + "\n";
                            }
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f24796j = true;
            crashDetailBean.t = 0;
            crashDetailBean.s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (b bVar2 : list) {
            if (!bVar2.f24836e && !bVar2.f24835d) {
                if (!crashDetailBean2.s.contains("" + bVar2.f24833b)) {
                    crashDetailBean2.t++;
                    crashDetailBean2.s += bVar2.f24833b + "\n";
                }
            }
        }
        if (crashDetailBean2.r != crashDetailBean.r) {
            if (!crashDetailBean2.s.contains("" + crashDetailBean.r)) {
                crashDetailBean2.t++;
                crashDetailBean2.s += crashDetailBean.r + "\n";
            }
        }
        return crashDetailBean2;
    }

    protected List<b> b(List<b> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (b bVar : list) {
            if (bVar.f24835d && bVar.f24833b <= currentTimeMillis - 86400000) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public boolean c(CrashDetailBean crashDetailBean) {
        return a(crashDetailBean, -123456789);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00da A[Catch: all -> 0x024e, TryCatch #0 {all -> 0x024e, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00da, B:34:0x00e0, B:35:0x00f3, B:37:0x00f9, B:40:0x010c, B:42:0x011a, B:44:0x0120, B:45:0x012d, B:47:0x0139, B:49:0x0145, B:51:0x015c, B:52:0x0181, B:54:0x0188, B:57:0x016a, B:59:0x0171, B:65:0x019d, B:68:0x01a8, B:69:0x01e3, B:71:0x01e7, B:74:0x01ec, B:76:0x0206, B:77:0x0212, B:80:0x0218, B:83:0x0248, B:88:0x01c7, B:91:0x01d0, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f9 A[Catch: all -> 0x024e, TryCatch #0 {all -> 0x024e, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00da, B:34:0x00e0, B:35:0x00f3, B:37:0x00f9, B:40:0x010c, B:42:0x011a, B:44:0x0120, B:45:0x012d, B:47:0x0139, B:49:0x0145, B:51:0x015c, B:52:0x0181, B:54:0x0188, B:57:0x016a, B:59:0x0171, B:65:0x019d, B:68:0x01a8, B:69:0x01e3, B:71:0x01e7, B:74:0x01ec, B:76:0x0206, B:77:0x0212, B:80:0x0218, B:83:0x0248, B:88:0x01c7, B:91:0x01d0, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7 A[Catch: all -> 0x024e, TRY_LEAVE, TryCatch #0 {all -> 0x024e, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00da, B:34:0x00e0, B:35:0x00f3, B:37:0x00f9, B:40:0x010c, B:42:0x011a, B:44:0x0120, B:45:0x012d, B:47:0x0139, B:49:0x0145, B:51:0x015c, B:52:0x0181, B:54:0x0188, B:57:0x016a, B:59:0x0171, B:65:0x019d, B:68:0x01a8, B:69:0x01e3, B:71:0x01e7, B:74:0x01ec, B:76:0x0206, B:77:0x0212, B:80:0x0218, B:83:0x0248, B:88:0x01c7, B:91:0x01d0, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c7 A[Catch: all -> 0x024e, TRY_LEAVE, TryCatch #0 {all -> 0x024e, blocks: (B:12:0x0012, B:13:0x0015, B:16:0x0066, B:19:0x006d, B:23:0x0080, B:25:0x008c, B:27:0x00aa, B:29:0x00b1, B:32:0x00da, B:34:0x00e0, B:35:0x00f3, B:37:0x00f9, B:40:0x010c, B:42:0x011a, B:44:0x0120, B:45:0x012d, B:47:0x0139, B:49:0x0145, B:51:0x015c, B:52:0x0181, B:54:0x0188, B:57:0x016a, B:59:0x0171, B:65:0x019d, B:68:0x01a8, B:69:0x01e3, B:71:0x01e7, B:74:0x01ec, B:76:0x0206, B:77:0x0212, B:80:0x0218, B:83:0x0248, B:88:0x01c7, B:91:0x01d0, B:94:0x00b5, B:97:0x00c1, B:99:0x001b, B:102:0x0027, B:105:0x0033, B:108:0x003f, B:112:0x004d, B:116:0x005a), top: B:11:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(com.tencent.bugly.crashreport.crash.CrashDetailBean r23) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.e.d(com.tencent.bugly.crashreport.crash.CrashDetailBean):void");
    }

    public void e(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.f24788b;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 3 && !h.g().j()) {
                    return;
                }
            } else if (!h.g().k()) {
                return;
            }
        } else if (!h.g().k()) {
            return;
        }
        if (this.f24845f != null) {
            X.a("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            this.f24845f.a(crashDetailBean.f24788b == 1);
        }
    }

    public void f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues b2 = b(crashDetailBean);
        if (b2 != null) {
            long a2 = J.a().a("t_cr", b2, (I) null, true);
            if (a2 >= 0) {
                X.a("insert %s success!", "t_cr");
                crashDetailBean.f24787a = a2;
            }
        }
        if (h.f24863i) {
            g(crashDetailBean);
        }
    }

    public void c(List<b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id");
        sb.append(" in ");
        sb.append("(");
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f24832a);
            sb.append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            int a2 = J.a().a("t_cr", sb3, (String[]) null, (I) null, true);
            Object[] objArr = new Object[2];
            objArr[0] = "t_cr";
            objArr[1] = Integer.valueOf(a2);
            X.a("deleted %s data %d", objArr);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public List<CrashDetailBean> b() {
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.c.b().c();
        if (c2 == null) {
            X.e("have not synced remote!", new Object[0]);
            return null;
        }
        if (!c2.f24768f) {
            X.e("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            X.d("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b2 = ca.b();
        List<b> a2 = a();
        X.a("Size of crash list loaded from DB: %s", Integer.valueOf(a2.size()));
        if (a2.size() <= 0) {
            return null;
        }
        List<b> arrayList = new ArrayList<>();
        arrayList.addAll(b(a2));
        a2.removeAll(arrayList);
        Iterator<b> it = a2.iterator();
        while (it.hasNext()) {
            b next = it.next();
            long j2 = next.f24833b;
            if (j2 < b2 - h.f24861g) {
                it.remove();
                arrayList.add(next);
            } else if (next.f24835d) {
                if (j2 >= currentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f24836e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f24837f >= 3 && j2 < currentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        List<CrashDetailBean> arrayList2 = new ArrayList<>();
        List<CrashDetailBean> a3 = a(a2);
        if (a3 != null && a3.size() > 0) {
            String str = com.tencent.bugly.crashreport.common.info.a.m().E;
            Iterator<CrashDetailBean> it2 = a3.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f24792f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return a3;
    }

    public boolean a(CrashDetailBean crashDetailBean, int i2) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = h.n;
        if (str != null && !str.isEmpty()) {
            X.a("Crash filter for crash stack is: %s", h.n);
            if (crashDetailBean.q.contains(h.n)) {
                X.e("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = h.o;
        if (str2 != null && !str2.isEmpty()) {
            X.a("Crash regular filter for crash stack is: %s", h.o);
            if (Pattern.compile(h.o).matcher(crashDetailBean.q).find()) {
                X.e("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f24788b != 2) {
            L l = new L();
            l.f24980b = 1;
            l.f24981c = crashDetailBean.A;
            l.f24982d = crashDetailBean.B;
            l.f24983e = crashDetailBean.r;
            this.f24843d.b(1);
            this.f24843d.c(l);
            X.d("[crash] a crash occur, handling...", new Object[0]);
        } else {
            X.d("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<b> a2 = a();
        ArrayList arrayList = null;
        if (a2 != null && a2.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(b(a2));
            a2.removeAll(arrayList);
            if (a2.size() > 20) {
                a(5);
            }
            if (a(crashDetailBean)) {
                boolean z = false;
                for (b bVar : a2) {
                    if (crashDetailBean.u.equals(bVar.f24834c)) {
                        if (bVar.f24836e) {
                            z = true;
                        }
                        arrayList2.add(bVar);
                    }
                }
                if (z || arrayList2.size() >= h.f24857c) {
                    X.c("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a3 = a(arrayList2, crashDetailBean);
                    for (b bVar2 : arrayList2) {
                        if (bVar2.f24832a != a3.f24787a) {
                            arrayList.add(bVar2);
                        }
                    }
                    f(a3);
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

    protected ContentValues b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = crashDetailBean.f24787a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.r));
            contentValues.put("_s1", crashDetailBean.u);
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f24790d ? 1 : 0));
            contentValues.put("_me", Integer.valueOf(crashDetailBean.f24796j ? 1 : 0));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.l));
            contentValues.put("_dt", ca.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    protected CrashDetailBean b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ca.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f24787a = j2;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
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
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or ");
                    sb.append("_id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f24787a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                String str = sb2;
                sb.setLength(0);
                int a2 = J.a().a("t_cr", str, (String[]) null, (I) null, true);
                Object[] objArr = new Object[2];
                objArr[0] = "t_cr";
                objArr[1] = Integer.valueOf(a2);
                X.a("deleted %s data %d", objArr);
            } catch (Throwable th) {
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    public boolean a(CrashDetailBean crashDetailBean) {
        int i2 = crashDetailBean.f24788b;
        return !com.tencent.bugly.b.f24588c && (!((i2 == 3) || (i2 == 0 || i2 == 1)) || h.f24858d);
    }

    public void a(CrashDetailBean crashDetailBean, long j2, boolean z) {
        if (h.l) {
            X.c("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, j2, z, crashDetailBean.f24788b == 7, z);
            return;
        }
        X.c("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    public void a(List<CrashDetailBean> list, long j2, boolean z, boolean z2, boolean z3) {
        if (!com.tencent.bugly.crashreport.common.info.a.a(this.f24841b).f24757j) {
            X.e("warn: not upload process", new Object[0]);
            return;
        }
        T t = this.f24842c;
        if (t == null) {
            X.e("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z3 && !t.a(h.f24855a)) {
            X.e("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean c2 = this.f24844e.c();
        if (!c2.f24768f) {
            X.e("remote report is disable!", new Object[0]);
            X.d("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list != null && list.size() != 0) {
            try {
                String str = c2.r;
                String str2 = StrategyBean.f24764b;
                oa a2 = a(this.f24841b, list, com.tencent.bugly.crashreport.common.info.a.m());
                if (a2 == null) {
                    X.e("create eupPkg fail!", new Object[0]);
                    return;
                }
                byte[] a3 = M.a((AbstractC0909m) a2);
                if (a3 == null) {
                    X.e("send encode fail!", new Object[0]);
                    return;
                }
                pa a4 = M.a(this.f24841b, 830, a3);
                if (a4 == null) {
                    X.e("request package is null.", new Object[0]);
                    return;
                }
                d dVar = new d(this, list);
                if (z) {
                    this.f24842c.a(f24840a, a4, str, str2, dVar, j2, z2);
                    return;
                } else {
                    this.f24842c.a(f24840a, a4, str, str2, dVar, false);
                    return;
                }
            } catch (Throwable th) {
                X.b("req cr error %s", th.toString());
                if (X.a(th)) {
                    return;
                }
                th.printStackTrace();
                return;
            }
        }
        X.e("warn: crashList is null or crashList num is 0", new Object[0]);
    }

    public void a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            X.a("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                X.a("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f24789c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.f24790d), Boolean.valueOf(crashDetailBean.f24796j));
                int i2 = crashDetailBean.l + 1;
                crashDetailBean.l = i2;
                crashDetailBean.f24790d = z;
                X.a("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f24789c, Integer.valueOf(i2), Boolean.valueOf(crashDetailBean.f24790d), Boolean.valueOf(crashDetailBean.f24796j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                h.g().a(it.next());
            }
            X.a("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        X.d("[crash] upload fail.", new Object[0]);
    }

    public List<CrashDetailBean> a(List<b> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id");
        sb.append(" in ");
        sb.append("(");
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f24832a);
            sb.append(",");
        }
        if (sb.toString().contains(",")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = J.a().a("t_cr", null, sb2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append("_id");
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (cursor.moveToNext()) {
                    try {
                        CrashDetailBean b2 = b(cursor);
                        if (b2 != null) {
                            arrayList.add(b2);
                        } else {
                            try {
                                sb.append(cursor.getLong(cursor.getColumnIndex("_id")));
                                sb.append(",");
                                i2++;
                            } catch (Throwable unused) {
                                X.e("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
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
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb3 = sb.toString();
                if (i2 > 0) {
                    int a2 = J.a().a("t_cr", sb3, (String[]) null, (I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_cr";
                    objArr[1] = Integer.valueOf(a2);
                    X.e("deleted %s illegal data %d", objArr);
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    protected b a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            b bVar = new b();
            bVar.f24832a = cursor.getLong(cursor.getColumnIndex("_id"));
            bVar.f24833b = cursor.getLong(cursor.getColumnIndex("_tm"));
            bVar.f24834c = cursor.getString(cursor.getColumnIndex("_s1"));
            bVar.f24835d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            bVar.f24836e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            bVar.f24837f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return bVar;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public List<b> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            String[] strArr = new String[6];
            strArr[0] = "_id";
            strArr[1] = "_tm";
            strArr[2] = "_s1";
            strArr[3] = "_up";
            strArr[4] = "_me";
            strArr[5] = "_uc";
            Cursor a2 = J.a().a("t_cr", strArr, null, null, null, true);
            if (a2 == null) {
                if (a2 != null) {
                    a2.close();
                }
                return null;
            }
            try {
                if (a2.getCount() < 1) {
                    a2.close();
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id");
                sb.append(" in ");
                sb.append("(");
                int i2 = 0;
                while (a2.moveToNext()) {
                    try {
                        b a3 = a(a2);
                        if (a3 != null) {
                            arrayList.add(a3);
                        } else {
                            try {
                                sb.append(a2.getLong(a2.getColumnIndex("_id")));
                                sb.append(",");
                                i2++;
                            } catch (Throwable unused) {
                                X.e("unknown id!", new Object[0]);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = a2;
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
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i2 > 0) {
                    int a4 = J.a().a("t_cr", sb2, (String[]) null, (I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_cr";
                    objArr[1] = Integer.valueOf(a4);
                    X.e("deleted %s illegal data %d", objArr);
                }
                a2.close();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(int i2) {
        if (i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id");
        sb.append(" in ");
        sb.append("(");
        sb.append("SELECT ");
        sb.append("_id");
        sb.append(" FROM ");
        sb.append("t_cr");
        sb.append(" order by ");
        sb.append("_id");
        sb.append(" limit ");
        sb.append(i2);
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            X.a("deleted first record %s data %d", "t_cr", Integer.valueOf(J.a().a("t_cr", sb2, (String[]) null, (I) null, true)));
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static na a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        ma a2;
        ma a3;
        ma maVar;
        if (context != null && crashDetailBean != null && aVar != null) {
            na naVar = new na();
            int i2 = crashDetailBean.f24788b;
            switch (i2) {
                case 0:
                    naVar.f25107i = crashDetailBean.f24796j ? "200" : "100";
                    break;
                case 1:
                    naVar.f25107i = crashDetailBean.f24796j ? ErrorContants.REALTIME_LOADAD_ERROR : "101";
                    break;
                case 2:
                    naVar.f25107i = crashDetailBean.f24796j ? ErrorContants.INIT_LOADAD_ERROR : "102";
                    break;
                case 3:
                    naVar.f25107i = crashDetailBean.f24796j ? "203" : "103";
                    break;
                case 4:
                    naVar.f25107i = crashDetailBean.f24796j ? "204" : "104";
                    break;
                case 5:
                    naVar.f25107i = crashDetailBean.f24796j ? "207" : "107";
                    break;
                case 6:
                    naVar.f25107i = crashDetailBean.f24796j ? "206" : "106";
                    break;
                case 7:
                    naVar.f25107i = crashDetailBean.f24796j ? "208" : "108";
                    break;
                default:
                    X.b("crash type error! %d", Integer.valueOf(i2));
                    break;
            }
            naVar.f25108j = crashDetailBean.r;
            naVar.k = crashDetailBean.n;
            naVar.l = crashDetailBean.o;
            naVar.m = crashDetailBean.p;
            naVar.o = crashDetailBean.q;
            naVar.p = crashDetailBean.z;
            naVar.q = crashDetailBean.f24789c;
            naVar.r = null;
            naVar.t = crashDetailBean.m;
            naVar.u = crashDetailBean.f24791e;
            naVar.n = crashDetailBean.B;
            naVar.v = null;
            X.a("libInfo %s", naVar.w);
            Map<String, PlugInBean> map = crashDetailBean.f24794h;
            if (map != null && map.size() > 0) {
                naVar.x = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f24794h.entrySet()) {
                    ka kaVar = new ka();
                    kaVar.f25083a = entry.getValue().f24745a;
                    kaVar.f25085c = entry.getValue().f24747c;
                    kaVar.f25087e = entry.getValue().f24746b;
                    naVar.x.add(kaVar);
                }
            }
            if (crashDetailBean.f24796j) {
                naVar.s = crashDetailBean.t;
                String str = crashDetailBean.s;
                if (str != null && str.length() > 0) {
                    if (naVar.y == null) {
                        naVar.y = new ArrayList<>();
                    }
                    try {
                        naVar.y.add(new ma((byte) 1, "alltimes.txt", crashDetailBean.s.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        naVar.y = null;
                    }
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(naVar.s);
                ArrayList<ma> arrayList = naVar.y;
                objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
                X.a("crashcount:%d sz:%d", objArr);
            }
            if (crashDetailBean.w != null) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                try {
                    naVar.y.add(new ma((byte) 1, "log.txt", crashDetailBean.w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    naVar.y = null;
                }
            }
            if (crashDetailBean.x != null) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                try {
                    naVar.y.add(new ma((byte) 1, "jniLog.txt", crashDetailBean.x.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    naVar.y = null;
                }
            }
            if (!ca.b(crashDetailBean.W)) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                try {
                    maVar = new ma((byte) 1, "crashInfos.txt", crashDetailBean.W.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    maVar = null;
                }
                if (maVar != null) {
                    X.a("attach crash infos", new Object[0]);
                    naVar.y.add(maVar);
                }
            }
            if (crashDetailBean.X != null) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                ma a4 = a("backupRecord.zip", context, crashDetailBean.X);
                if (a4 != null) {
                    X.a("attach backup record", new Object[0]);
                    naVar.y.add(a4);
                }
            }
            byte[] bArr = crashDetailBean.y;
            if (bArr != null && bArr.length > 0) {
                ma maVar2 = new ma((byte) 2, "buglylog.zip", bArr);
                X.a("attach user log", new Object[0]);
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                naVar.y.add(maVar2);
            }
            if (crashDetailBean.f24788b == 3) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                X.a("crashBean.anrMessages:%s", crashDetailBean.Q);
                Map<String, String> map2 = crashDetailBean.Q;
                if (map2 != null && map2.containsKey("BUGLY_CR_01")) {
                    try {
                        if (!TextUtils.isEmpty(crashDetailBean.Q.get("BUGLY_CR_01"))) {
                            naVar.y.add(new ma((byte) 1, "anrMessage.txt", crashDetailBean.Q.get("BUGLY_CR_01").getBytes("utf-8")));
                            X.a("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e6) {
                        e6.printStackTrace();
                        naVar.y = null;
                    }
                    crashDetailBean.Q.remove("BUGLY_CR_01");
                }
                if (crashDetailBean.v != null && NativeCrashHandler.getInstance().isEnableCatchAnrTrace() && (a3 = a("trace.zip", context, crashDetailBean.v)) != null) {
                    X.a("attach traces", new Object[0]);
                    naVar.y.add(a3);
                }
            }
            if (crashDetailBean.f24788b == 1) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                String str2 = crashDetailBean.v;
                if (str2 != null && (a2 = a("tomb.zip", context, str2)) != null) {
                    X.a("attach tombs", new Object[0]);
                    naVar.y.add(a2);
                }
            }
            List<String> list = aVar.na;
            if (list != null && !list.isEmpty()) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = aVar.na.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                }
                try {
                    naVar.y.add(new ma((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                    X.a("attach pageTracingList", new Object[0]);
                } catch (UnsupportedEncodingException e7) {
                    e7.printStackTrace();
                }
            }
            byte[] bArr2 = crashDetailBean.V;
            if (bArr2 != null && bArr2.length > 0) {
                if (naVar.y == null) {
                    naVar.y = new ArrayList<>();
                }
                naVar.y.add(new ma((byte) 1, "userExtraByteData", crashDetailBean.V));
                X.a("attach extraData", new Object[0]);
            }
            HashMap hashMap = new HashMap();
            naVar.z = hashMap;
            hashMap.put("A9", "" + crashDetailBean.C);
            naVar.z.put("A11", "" + crashDetailBean.D);
            naVar.z.put("A10", "" + crashDetailBean.E);
            naVar.z.put("A23", "" + crashDetailBean.f24792f);
            naVar.z.put("A7", "" + aVar.n);
            naVar.z.put("A6", "" + aVar.j());
            naVar.z.put("A5", "" + aVar.k());
            naVar.z.put("A22", "" + aVar.l());
            naVar.z.put("A2", "" + crashDetailBean.G);
            naVar.z.put("A1", "" + crashDetailBean.F);
            naVar.z.put("A24", "" + aVar.p);
            naVar.z.put("A17", "" + crashDetailBean.H);
            naVar.z.put("A25", "" + aVar.l());
            naVar.z.put("A15", "" + aVar.i());
            naVar.z.put("A13", "" + aVar.n());
            naVar.z.put("A34", "" + crashDetailBean.A);
            if (aVar.ea != null) {
                naVar.z.put("productIdentify", "" + aVar.ea);
            }
            try {
                naVar.z.put("A26", "" + URLEncoder.encode(crashDetailBean.I, "utf-8"));
            } catch (UnsupportedEncodingException e8) {
                e8.printStackTrace();
            }
            if (crashDetailBean.f24788b == 1) {
                naVar.z.put("A27", "" + crashDetailBean.L);
                naVar.z.put("A28", "" + crashDetailBean.K);
                naVar.z.put("A29", "" + crashDetailBean.k);
            }
            naVar.z.put("A30", "" + crashDetailBean.M);
            naVar.z.put("A18", "" + crashDetailBean.N);
            Map<String, String> map3 = naVar.z;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(!crashDetailBean.O);
            map3.put("A36", sb2.toString());
            naVar.z.put("F02", "" + aVar.X);
            naVar.z.put("F03", "" + aVar.Y);
            naVar.z.put("F04", "" + aVar.u());
            naVar.z.put("F05", "" + aVar.Z);
            naVar.z.put("F06", "" + aVar.W);
            naVar.z.put("F08", "" + aVar.ca);
            naVar.z.put("F09", "" + aVar.da);
            naVar.z.put("F10", "" + aVar.aa);
            if (crashDetailBean.R >= 0) {
                naVar.z.put("C01", "" + crashDetailBean.R);
            }
            if (crashDetailBean.S >= 0) {
                naVar.z.put("C02", "" + crashDetailBean.S);
            }
            Map<String, String> map4 = crashDetailBean.T;
            if (map4 != null && map4.size() > 0) {
                for (Map.Entry<String, String> entry2 : crashDetailBean.T.entrySet()) {
                    naVar.z.put("C03_" + entry2.getKey(), entry2.getValue());
                }
            }
            Map<String, String> map5 = crashDetailBean.U;
            if (map5 != null && map5.size() > 0) {
                for (Map.Entry<String, String> entry3 : crashDetailBean.U.entrySet()) {
                    naVar.z.put("C04_" + entry3.getKey(), entry3.getValue());
                }
            }
            naVar.A = null;
            Map<String, String> map6 = crashDetailBean.P;
            if (map6 != null && map6.size() > 0) {
                Map<String, String> map7 = crashDetailBean.P;
                naVar.A = map7;
                X.c("setted message size %d", Integer.valueOf(map7.size()));
            }
            Object[] objArr2 = new Object[12];
            objArr2[0] = crashDetailBean.n;
            objArr2[1] = crashDetailBean.f24789c;
            objArr2[2] = aVar.u();
            objArr2[3] = Long.valueOf((crashDetailBean.r - crashDetailBean.N) / 1000);
            objArr2[4] = Boolean.valueOf(crashDetailBean.k);
            objArr2[5] = Boolean.valueOf(crashDetailBean.O);
            objArr2[6] = Boolean.valueOf(crashDetailBean.f24796j);
            objArr2[7] = Boolean.valueOf(crashDetailBean.f24788b == 1);
            objArr2[8] = Integer.valueOf(crashDetailBean.t);
            objArr2[9] = crashDetailBean.s;
            objArr2[10] = Boolean.valueOf(crashDetailBean.f24790d);
            objArr2[11] = Integer.valueOf(naVar.z.size());
            X.a("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
            return naVar;
        }
        X.e("enExp args == null", new Object[0]);
        return null;
    }

    public static oa a(Context context, List<CrashDetailBean> list, com.tencent.bugly.crashreport.common.info.a aVar) {
        if (context != null && list != null && list.size() != 0 && aVar != null) {
            oa oaVar = new oa();
            oaVar.f25110b = new ArrayList<>();
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                oaVar.f25110b.add(a(context, it.next(), aVar));
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
            } catch (Throwable th) {
                th = th;
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
                } catch (IOException e2) {
                    if (!X.b(e2)) {
                        e2.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    X.a("del tmp", new Object[0]);
                    file2.delete();
                }
                return maVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!X.b(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        X.a("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            if (!X.b(e4)) {
                                e4.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        X.a("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        X.e("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
        if (m == null) {
            return;
        }
        X.b("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        X.b("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        X.b("# PKG NAME: %s", m.f24754g);
        X.b("# APP VER: %s", m.E);
        X.b("# SDK VER: %s", m.l);
        X.b("# LAUNCH TIME: %s", ca.a(new Date(com.tencent.bugly.crashreport.common.info.a.m().f24751d)));
        X.b("# CRASH TYPE: %s", str);
        X.b("# CRASH TIME: %s", str2);
        X.b("# CRASH PROCESS: %s", str3);
        X.b("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            X.b("# REPORT ID: %s", crashDetailBean.f24789c);
            Object[] objArr = new Object[2];
            objArr[0] = m.o;
            objArr[1] = m.n().booleanValue() ? "ROOTED" : "UNROOT";
            X.b("# CRASH DEVICE: %s %s", objArr);
            X.b("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            X.b("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ca.b(crashDetailBean.L)) {
                X.b("# EXCEPTION FIRED BY %s %s", crashDetailBean.L, crashDetailBean.K);
            } else if (crashDetailBean.f24788b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.Q == null) {
                    str6 = "null";
                } else {
                    str6 = "" + crashDetailBean.Q.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                X.b("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!ca.b(str5)) {
            X.b("# CRASH STACK: ", new Object[0]);
            X.b(str5, new Object[0]);
        }
        X.b("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
