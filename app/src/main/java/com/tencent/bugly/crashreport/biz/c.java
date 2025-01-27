package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.umeng.analytics.pro.aq;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private Context f24720a;

    /* renamed from: b */
    private long f24721b;

    /* renamed from: c */
    private int f24722c;

    /* renamed from: d */
    private boolean f24723d;

    class a implements Runnable {

        /* renamed from: a */
        private boolean f24724a;

        /* renamed from: b */
        private UserInfoBean f24725b;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.f24725b = userInfoBean;
            this.f24724a = z;
        }

        private void a(UserInfoBean userInfoBean) {
            com.tencent.bugly.crashreport.common.info.a m;
            if (userInfoBean == null || (m = com.tencent.bugly.crashreport.common.info.a.m()) == null) {
                return;
            }
            userInfoBean.f24716j = m.u();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                UserInfoBean userInfoBean = this.f24725b;
                if (userInfoBean != null) {
                    a(userInfoBean);
                    X.a("[UserInfo] Record user info.", new Object[0]);
                    c.this.a(this.f24725b, false);
                }
                if (this.f24724a) {
                    c.this.b();
                }
            } catch (Throwable th) {
                if (X.b(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < c.this.f24721b) {
                W.c().a(c.this.new b(), (c.this.f24721b - currentTimeMillis) + 5000);
            } else {
                c.this.a(3, false, 0L);
                c.this.a();
            }
        }
    }

    /* renamed from: com.tencent.bugly.crashreport.biz.c$c */
    class RunnableC0524c implements Runnable {

        /* renamed from: a */
        private long f24728a;

        public RunnableC0524c(long j2) {
            this.f24728a = 21600000L;
            this.f24728a = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
            c.this.b(this.f24728a);
        }
    }

    public c(Context context, boolean z) {
        this.f24723d = true;
        this.f24720a = context;
        this.f24723d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ee A[Catch: all -> 0x016f, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0118 A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0121 A[Catch: all -> 0x016f, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:63:0x00cc, B:73:0x00d3, B:74:0x00e8, B:76:0x00ee, B:78:0x00f3, B:81:0x00fa, B:84:0x0112, B:86:0x0118, B:89:0x0121, B:91:0x0127, B:94:0x0130, B:96:0x013a, B:99:0x0143, B:102:0x0161, B:107:0x0166, B:111:0x00e2), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.c.c():void");
    }

    public void b(long j2) {
        W.c().a(new RunnableC0524c(j2), j2);
    }

    private static UserInfoBean a(Context context, int i2) {
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f24708b = i2;
        userInfoBean.f24709c = a2.f24755h;
        userInfoBean.f24710d = a2.y();
        userInfoBean.f24711e = System.currentTimeMillis();
        userInfoBean.f24712f = -1L;
        userInfoBean.n = a2.E;
        userInfoBean.o = i2 != 1 ? 0 : 1;
        userInfoBean.l = a2.C();
        userInfoBean.m = a2.W;
        userInfoBean.f24713g = a2.X;
        userInfoBean.f24714h = a2.Y;
        userInfoBean.f24715i = a2.Z;
        userInfoBean.k = a2.aa;
        userInfoBean.r = a2.h();
        userInfoBean.s = a2.g();
        userInfoBean.p = a2.A();
        userInfoBean.q = a2.t();
        return userInfoBean;
    }

    public void b() {
        W c2 = W.c();
        if (c2 != null) {
            c2.a(new com.tencent.bugly.crashreport.biz.b(this));
        }
    }

    public void a(int i2, boolean z, long j2) {
        com.tencent.bugly.crashreport.common.strategy.c b2 = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (b2 != null && !b2.c().f24769g && i2 != 1 && i2 != 3) {
            X.b("UserInfo is disable", new Object[0]);
            return;
        }
        if (i2 == 1 || i2 == 3) {
            this.f24722c++;
        }
        W.c().a(new a(a(this.f24720a, i2), z), j2);
    }

    public void a(long j2) {
        W.c().a(new a(null, true), j2);
    }

    public void a() {
        this.f24721b = ca.b() + 86400000;
        W.c().a(new b(), (this.f24721b - System.currentTimeMillis()) + 5000);
    }

    public void a(UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean == null) {
            return;
        }
        if (!z && userInfoBean.f24708b != 1 && (a2 = a(com.tencent.bugly.crashreport.common.info.a.a(this.f24720a).f24755h)) != null && a2.size() >= 20) {
            X.c("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
            return;
        }
        long a3 = J.a().a("t_ui", a(userInfoBean), (I) null, true);
        if (a3 >= 0) {
            X.a("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
            userInfoBean.f24707a = a3;
        }
    }

    public List<UserInfoBean> a(String str) {
        Throwable th;
        Cursor cursor;
        String sb;
        try {
            if (ca.b(str)) {
                sb = null;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_pc = '");
                sb2.append(str);
                sb2.append("'");
                sb = sb2.toString();
            }
            cursor = J.a().a("t_ui", null, sb, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb3 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        try {
                            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb3.append(" or ");
                            sb3.append("_id");
                            sb3.append(" = ");
                            sb3.append(j2);
                        } catch (Throwable unused) {
                            X.e("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb4 = sb3.toString();
                if (sb4.length() > 0) {
                    int a3 = J.a().a("t_ui", sb4.substring(4), (String[]) null, (I) null, true);
                    Object[] objArr = new Object[2];
                    objArr[0] = "t_ui";
                    objArr[1] = Integer.valueOf(a3);
                    X.e("[Database] deleted %s error data %d", objArr);
                }
                cursor.close();
                return arrayList;
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
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size() && i2 < 50; i2++) {
            UserInfoBean userInfoBean = list.get(i2);
            sb.append(" or ");
            sb.append("_id");
            sb.append(" = ");
            sb.append(userInfoBean.f24707a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            int a2 = J.a().a("t_ui", str, (String[]) null, (I) null, true);
            Object[] objArr = new Object[2];
            objArr[0] = "t_ui";
            objArr[1] = Integer.valueOf(a2);
            X.a("[Database] deleted %s data %d", objArr);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    protected ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j2 = userInfoBean.f24707a;
            if (j2 > 0) {
                contentValues.put("_id", Long.valueOf(j2));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f24711e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f24712f));
            contentValues.put(aq.f25697e, Integer.valueOf(userInfoBean.f24708b));
            contentValues.put("_pc", userInfoBean.f24709c);
            contentValues.put("_dt", ca.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    protected UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j2 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ca.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f24707a = j2;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!X.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
