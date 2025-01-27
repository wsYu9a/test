package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import com.umeng.analytics.pro.bx;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private Context f22251a;

    /* renamed from: b */
    private long f22252b;

    /* renamed from: c */
    private int f22253c;

    /* renamed from: d */
    private boolean f22254d;

    public class a implements Runnable {

        /* renamed from: a */
        private boolean f22255a;

        /* renamed from: b */
        private UserInfoBean f22256b;

        public a(UserInfoBean userInfoBean, boolean z10) {
            this.f22256b = userInfoBean;
            this.f22255a = z10;
        }

        private void a(UserInfoBean userInfoBean) {
            com.tencent.bugly.crashreport.common.info.a m10;
            if (userInfoBean == null || (m10 = com.tencent.bugly.crashreport.common.info.a.m()) == null) {
                return;
            }
            userInfoBean.f22238j = m10.u();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                UserInfoBean userInfoBean = this.f22256b;
                if (userInfoBean != null) {
                    a(userInfoBean);
                    X.a("[UserInfo] Record user info.", new Object[0]);
                    c.this.a(this.f22256b, false);
                }
                if (this.f22255a) {
                    c.this.b();
                }
            } catch (Throwable th2) {
                if (X.b(th2)) {
                    return;
                }
                th2.printStackTrace();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < c.this.f22252b) {
                W.c().a(c.this.new b(), (c.this.f22252b - currentTimeMillis) + 5000);
            } else {
                c.this.a(3, false, 0L);
                c.this.a();
            }
        }
    }

    /* renamed from: com.tencent.bugly.crashreport.biz.c$c */
    public class RunnableC0653c implements Runnable {

        /* renamed from: a */
        private long f22259a;

        public RunnableC0653c(long j10) {
            this.f22259a = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b();
            c.this.b(this.f22259a);
        }
    }

    public c(Context context, boolean z10) {
        this.f22251a = context;
        this.f22254d = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0 A[Catch: all -> 0x0029, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0009, B:13:0x0011, B:17:0x0019, B:19:0x001f, B:23:0x002c, B:25:0x003f, B:28:0x0048, B:30:0x004f, B:31:0x0052, B:33:0x0058, B:35:0x006c, B:37:0x007c, B:44:0x0083, B:46:0x008c, B:47:0x0091, B:49:0x0097, B:51:0x00a5, B:53:0x00b2, B:54:0x00b5, B:57:0x00c3, B:64:0x00cd, B:74:0x00d3, B:75:0x00ea, B:77:0x00f0, B:79:0x00f5, B:82:0x00fc, B:85:0x0114, B:87:0x011a, B:90:0x0123, B:92:0x0129, B:95:0x0132, B:97:0x013c, B:100:0x0145, B:103:0x0161, B:108:0x0168, B:112:0x00e4), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011a A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0009, B:13:0x0011, B:17:0x0019, B:19:0x001f, B:23:0x002c, B:25:0x003f, B:28:0x0048, B:30:0x004f, B:31:0x0052, B:33:0x0058, B:35:0x006c, B:37:0x007c, B:44:0x0083, B:46:0x008c, B:47:0x0091, B:49:0x0097, B:51:0x00a5, B:53:0x00b2, B:54:0x00b5, B:57:0x00c3, B:64:0x00cd, B:74:0x00d3, B:75:0x00ea, B:77:0x00f0, B:79:0x00f5, B:82:0x00fc, B:85:0x0114, B:87:0x011a, B:90:0x0123, B:92:0x0129, B:95:0x0132, B:97:0x013c, B:100:0x0145, B:103:0x0161, B:108:0x0168, B:112:0x00e4), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0123 A[Catch: all -> 0x0029, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:9:0x0009, B:13:0x0011, B:17:0x0019, B:19:0x001f, B:23:0x002c, B:25:0x003f, B:28:0x0048, B:30:0x004f, B:31:0x0052, B:33:0x0058, B:35:0x006c, B:37:0x007c, B:44:0x0083, B:46:0x008c, B:47:0x0091, B:49:0x0097, B:51:0x00a5, B:53:0x00b2, B:54:0x00b5, B:57:0x00c3, B:64:0x00cd, B:74:0x00d3, B:75:0x00ea, B:77:0x00f0, B:79:0x00f5, B:82:0x00fc, B:85:0x0114, B:87:0x011a, B:90:0x0123, B:92:0x0129, B:95:0x0132, B:97:0x013c, B:100:0x0145, B:103:0x0161, B:108:0x0168, B:112:0x00e4), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void c() {
        /*
            Method dump skipped, instructions count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.c.c():void");
    }

    public void b(long j10) {
        W.c().a(new RunnableC0653c(j10), j10);
    }

    private static UserInfoBean a(Context context, int i10) {
        com.tencent.bugly.crashreport.common.info.a a10 = com.tencent.bugly.crashreport.common.info.a.a(context);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f22230b = i10;
        userInfoBean.f22231c = a10.f22296h;
        userInfoBean.f22232d = a10.y();
        userInfoBean.f22233e = System.currentTimeMillis();
        userInfoBean.f22234f = -1L;
        userInfoBean.f22242n = a10.E;
        userInfoBean.f22243o = i10 != 1 ? 0 : 1;
        userInfoBean.f22240l = a10.C();
        userInfoBean.f22241m = a10.W;
        userInfoBean.f22235g = a10.X;
        userInfoBean.f22236h = a10.Y;
        userInfoBean.f22237i = a10.Z;
        userInfoBean.f22239k = a10.f22283aa;
        userInfoBean.f22246r = a10.h();
        userInfoBean.f22247s = a10.g();
        userInfoBean.f22244p = a10.A();
        userInfoBean.f22245q = a10.t();
        return userInfoBean;
    }

    public void b() {
        W c10 = W.c();
        if (c10 != null) {
            c10.a(new com.tencent.bugly.crashreport.biz.b(this));
        }
    }

    public void a(int i10, boolean z10, long j10) {
        com.tencent.bugly.crashreport.common.strategy.c b10 = com.tencent.bugly.crashreport.common.strategy.c.b();
        if (b10 != null && !b10.c().f22343g && i10 != 1 && i10 != 3) {
            X.b("UserInfo is disable", new Object[0]);
            return;
        }
        if (i10 == 1 || i10 == 3) {
            this.f22253c++;
        }
        W.c().a(new a(a(this.f22251a, i10), z10), j10);
    }

    public void a(long j10) {
        W.c().a(new a(null, true), j10);
    }

    public void a() {
        this.f22252b = ca.b() + 86400000;
        W.c().a(new b(), (this.f22252b - System.currentTimeMillis()) + 5000);
    }

    public void a(UserInfoBean userInfoBean, boolean z10) {
        List<UserInfoBean> a10;
        if (userInfoBean == null) {
            return;
        }
        if (!z10 && userInfoBean.f22230b != 1 && (a10 = a(com.tencent.bugly.crashreport.common.info.a.a(this.f22251a).f22296h)) != null && a10.size() >= 20) {
            X.c("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a10.size()));
            return;
        }
        long a11 = J.a().a("t_ui", a(userInfoBean), (I) null, true);
        if (a11 >= 0) {
            X.a("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a11));
            userInfoBean.f22229a = a11;
        }
    }

    public List<UserInfoBean> a(String str) {
        Throwable th2;
        Cursor cursor;
        String sb2;
        try {
            if (ca.b(str)) {
                sb2 = null;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("_pc = '");
                sb3.append(str);
                sb3.append("'");
                sb2 = sb3.toString();
            }
            cursor = J.a().a("t_ui", null, sb2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb4 = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a10 = a(cursor);
                    if (a10 != null) {
                        arrayList.add(a10);
                    } else {
                        try {
                            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb4.append(" or ");
                            sb4.append("_id");
                            sb4.append(" = ");
                            sb4.append(j10);
                        } catch (Throwable unused) {
                            X.e("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb5 = sb4.toString();
                if (sb5.length() > 0) {
                    X.e("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(J.a().a("t_ui", sb5.substring(4), (String[]) null, (I) null, true)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    if (!X.b(th2)) {
                        th2.printStackTrace();
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
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    public void a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < list.size() && i10 < 50; i10++) {
            UserInfoBean userInfoBean = list.get(i10);
            sb2.append(" or ");
            sb2.append("_id");
            sb2.append(" = ");
            sb2.append(userInfoBean.f22229a);
        }
        String sb3 = sb2.toString();
        if (sb3.length() > 0) {
            sb3 = sb3.substring(4);
        }
        String str = sb3;
        sb2.setLength(0);
        try {
            X.a("[Database] deleted %s data %d", "t_ui", Integer.valueOf(J.a().a("t_ui", str, (String[]) null, (I) null, true)));
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = userInfoBean.f22229a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f22233e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f22234f));
            contentValues.put(bx.f23687e, Integer.valueOf(userInfoBean.f22230b));
            contentValues.put("_pc", userInfoBean.f22231c);
            contentValues.put("_dt", ca.a(userInfoBean));
            return contentValues;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }

    public UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) ca.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f22229a = j10;
            }
            return userInfoBean;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            return null;
        }
    }
}
