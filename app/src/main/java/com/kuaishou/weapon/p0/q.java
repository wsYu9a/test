package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a */
    public static final int f11156a = 3;

    /* renamed from: b */
    private static q f11157b = null;

    /* renamed from: g */
    private static final String f11158g = "1";

    /* renamed from: c */
    private volatile boolean f11159c = false;

    /* renamed from: d */
    private dp f11160d;

    /* renamed from: e */
    private Context f11161e;

    /* renamed from: f */
    private t f11162f;

    /* renamed from: com.kuaishou.weapon.p0.q$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f11163a;

        /* renamed from: com.kuaishou.weapon.p0.q$1$1 */
        public class C03611 extends TimerTask {

            /* renamed from: a */
            final /* synthetic */ r f11165a;

            /* renamed from: b */
            final /* synthetic */ s f11166b;

            public C03611(r rVar, s sVar) {
                a10 = rVar;
                d10 = sVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                a10.b(str);
                q.this.f11162f.a(str);
                File file = new File(d10.f11180e);
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            r a10;
            try {
                if (TextUtils.isEmpty(str) || (a10 = r.a(q.this.f11161e.getApplicationContext(), true)) == null) {
                    return;
                }
                s d10 = a10.d(str);
                if (d10 == null) {
                    s b10 = q.this.f11162f.b(str);
                    if (b10 != null) {
                        q.this.a(str, b10.f11180e);
                        return;
                    }
                    return;
                }
                new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1

                    /* renamed from: a */
                    final /* synthetic */ r f11165a;

                    /* renamed from: b */
                    final /* synthetic */ s f11166b;

                    public C03611(r a102, s d102) {
                        a10 = a102;
                        d10 = d102;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        a10.b(str);
                        q.this.f11162f.a(str);
                        File file = new File(d10.f11180e);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }, 600000L);
                a102.b(str);
                q.this.f11162f.a(str);
                File file = new File(d102.f11180e);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private q(Context context) {
        this.f11161e = context;
        this.f11160d = dp.a(context);
        this.f11162f = t.a(context);
    }

    private static void d() {
        try {
            dp a10 = dp.a();
            if (a10 != null) {
                a10.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public void c() {
        for (s sVar : this.f11162f.a()) {
            r a10 = r.a();
            if ((a10 != null ? a10.d(sVar.f11178c) : null) == null) {
                a(sVar.f11176a, sVar.f11179d, (PackageInfo) null);
            }
        }
    }

    public static synchronized q a(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (f11157b == null) {
                    f11157b = new q(context);
                }
                qVar = f11157b;
            } catch (Exception unused) {
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return qVar;
    }

    public synchronized void b() {
        String str;
        try {
            if (this.f11159c) {
                return;
            }
            this.f11159c = true;
            for (s sVar : this.f11162f.a()) {
                try {
                    str = this.f11161e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                    str = null;
                }
                if (str != null) {
                    sVar.f11188m = str + bi.f10814j + sVar.f11176a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(sVar.f11188m);
                    sb2.append("/lib");
                    dn.c(sb2.toString());
                    dn.c(sVar.f11188m);
                }
            }
            this.f11162f.b();
            if (this.f11160d.b(dp.f11084d)) {
                this.f11162f.c();
            } else {
                this.f11160d.a(dp.f11084d, Boolean.TRUE, true);
            }
            n.a().a(new u(this.f11161e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void a() {
        d();
        if (WeaponHI.isLoad) {
            b();
        } else {
            WeaponHI.iD();
        }
    }

    public synchronized boolean a(int i10, String str, PackageInfo packageInfo) {
        return a(i10, str, null, false, packageInfo);
    }

    private synchronized boolean a(int i10, String str, String str2, boolean z10, PackageInfo packageInfo) {
        if (z10) {
            if (this.f11162f.c(i10) != 1) {
                return false;
            }
        }
        s a10 = this.f11162f.a(i10);
        if (a10 == null) {
            this.f11162f.b(i10, -1);
            return false;
        }
        if (!dn.a(new File(a10.f11180e))) {
            this.f11162f.b(i10, -1);
            return false;
        }
        if (packageInfo != null) {
            a10.f11193r = packageInfo;
        }
        r a11 = r.a(this.f11161e.getApplicationContext(), true);
        if (!a11.a(a10, false)) {
            this.f11162f.b(i10, -1);
            a11.a(a10.f11180e);
            return false;
        }
        s c10 = a11.c(a10.f11180e);
        c10.f11177b = 1;
        c10.f11191p = 1;
        this.f11162f.a(c10);
        return true;
    }

    public void b(String str) {
        r a10;
        try {
            if (TextUtils.isEmpty(str) || (a10 = r.a()) == null) {
                return;
            }
            a10.b(str);
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        this.f11162f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1

                /* renamed from: a */
                final /* synthetic */ String f11163a;

                /* renamed from: com.kuaishou.weapon.p0.q$1$1 */
                public class C03611 extends TimerTask {

                    /* renamed from: a */
                    final /* synthetic */ r f11165a;

                    /* renamed from: b */
                    final /* synthetic */ s f11166b;

                    public C03611(r a102, s d102) {
                        a10 = a102;
                        d10 = d102;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        a10.b(str);
                        q.this.f11162f.a(str);
                        File file = new File(d10.f11180e);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }

                public AnonymousClass1(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    r a102;
                    try {
                        if (TextUtils.isEmpty(str) || (a102 = r.a(q.this.f11161e.getApplicationContext(), true)) == null) {
                            return;
                        }
                        s d102 = a102.d(str);
                        if (d102 == null) {
                            s b10 = q.this.f11162f.b(str);
                            if (b10 != null) {
                                q.this.a(str, b10.f11180e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1

                            /* renamed from: a */
                            final /* synthetic */ r f11165a;

                            /* renamed from: b */
                            final /* synthetic */ s f11166b;

                            public C03611(r a1022, s d1022) {
                                a10 = a1022;
                                d10 = d1022;
                            }

                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                a10.b(str);
                                q.this.f11162f.a(str);
                                File file = new File(d10.f11180e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, 600000L);
                        a1022.b(str);
                        q.this.f11162f.a(str);
                        File file = new File(d1022.f11180e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean a(s sVar, String str, String str2) {
        r a10;
        if (sVar == null) {
            return false;
        }
        File file = new File(sVar.f11180e);
        if (!dn.a(file)) {
            return false;
        }
        try {
            if (!this.f11162f.b(sVar.f11176a)) {
                this.f11162f.a(sVar);
            }
            a10 = r.a(this.f11161e.getApplicationContext(), true);
            this.f11162f.a(sVar.f11176a, 1);
            b(sVar.f11178c);
        } catch (Throwable unused) {
        }
        if (!a10.a(sVar, true)) {
            file.delete();
            a(sVar.f11176a, sVar.f11179d, null, true, null);
            this.f11162f.a(sVar.f11176a, 0);
            return false;
        }
        sVar = a10.c(sVar.f11180e);
        if (sVar == null) {
            this.f11162f.a(sVar.f11176a, 0);
            return false;
        }
        try {
            s a11 = this.f11162f.a(sVar.f11176a);
            File file2 = (a11 == null || a11.f11179d.equals(sVar.f11179d)) ? null : new File(a11.f11180e);
            sVar.f11177b = 1;
            sVar.f11191p = 1;
            if (this.f11162f.a(sVar) > 0 && file2 != null && file2.exists()) {
                file2.delete();
            }
            this.f11162f.a(sVar.f11176a, 0);
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }
}
