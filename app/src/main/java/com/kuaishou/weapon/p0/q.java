package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cdo.oaps.ad.OapsKey;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class q {

    /* renamed from: a */
    public static final int f9368a = 3;

    /* renamed from: b */
    private static q f9369b = null;

    /* renamed from: g */
    private static final String f9370g = "1";

    /* renamed from: c */
    private volatile boolean f9371c = false;

    /* renamed from: d */
    private Cdo f9372d;

    /* renamed from: e */
    private Context f9373e;

    /* renamed from: f */
    private t f9374f;

    /* renamed from: com.kuaishou.weapon.p0.q$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f9375a;

        /* renamed from: com.kuaishou.weapon.p0.q$1$1 */
        class C01181 extends TimerTask {

            /* renamed from: a */
            final /* synthetic */ r f9377a;

            /* renamed from: b */
            final /* synthetic */ s f9378b;

            C01181(r rVar, s sVar) {
                a2 = rVar;
                d2 = sVar;
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                a2.b(str);
                q.this.f9374f.a(str);
                File file = new File(d2.f9395e);
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            r a2;
            try {
                if (TextUtils.isEmpty(str) || (a2 = r.a(q.this.f9373e.getApplicationContext(), true)) == null) {
                    return;
                }
                s d2 = a2.d(str);
                if (d2 == null) {
                    s b2 = q.this.f9374f.b(str);
                    if (b2 != null) {
                        q.this.a(str, b2.f9395e);
                        return;
                    }
                    return;
                }
                new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1

                    /* renamed from: a */
                    final /* synthetic */ r f9377a;

                    /* renamed from: b */
                    final /* synthetic */ s f9378b;

                    C01181(r a22, s d22) {
                        a2 = a22;
                        d2 = d22;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        a2.b(str);
                        q.this.f9374f.a(str);
                        File file = new File(d2.f9395e);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }, TTAdConstant.AD_MAX_EVENT_TIME);
                a22.b(str);
                q.this.f9374f.a(str);
                File file = new File(d22.f9395e);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private q(Context context) {
        this.f9373e = context;
        this.f9372d = Cdo.a(context);
        this.f9374f = t.a(context);
    }

    public static synchronized q a(Context context) {
        q qVar;
        synchronized (q.class) {
            try {
                if (f9369b == null) {
                    f9369b = new q(context);
                }
                qVar = f9369b;
            } catch (Exception unused) {
                return null;
            }
        }
        return qVar;
    }

    private synchronized boolean a(int i2, String str, String str2, boolean z, PackageInfo packageInfo) {
        if (z) {
            if (this.f9374f.c(i2) != 1) {
                return false;
            }
        }
        s a2 = this.f9374f.a(i2);
        if (a2 == null) {
            this.f9374f.b(i2, -1);
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            hashMap.put(OapsKey.KEY_PAGEKEY, sb.toString());
            hashMap.put("pv", str);
            hashMap.put(com.kwad.sdk.ranger.e.TAG, cj.m);
            bg.a(this.f9373e, "1002001", hashMap);
            return false;
        }
        if (!dm.a(new File(a2.f9395e))) {
            this.f9374f.b(i2, -1);
            HashMap hashMap2 = new HashMap();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i2);
            hashMap2.put(OapsKey.KEY_PAGEKEY, sb2.toString());
            hashMap2.put("pv", str);
            hashMap2.put(com.kwad.sdk.ranger.e.TAG, cj.n);
            hashMap2.put(t.f9404d, "CBH");
            bg.a(this.f9373e, "1002001", hashMap2);
            return false;
        }
        if (packageInfo != null) {
            a2.r = packageInfo;
        }
        r a3 = r.a(this.f9373e.getApplicationContext(), true);
        if (a3.a(a2, false)) {
            s c2 = a3.c(a2.f9395e);
            c2.f9392b = 1;
            c2.p = 1;
            this.f9374f.a(c2);
            return true;
        }
        this.f9374f.b(i2, -1);
        a3.a(a2.f9395e);
        HashMap hashMap3 = new HashMap();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i2);
        hashMap3.put(OapsKey.KEY_PAGEKEY, sb3.toString());
        hashMap3.put("pv", str);
        hashMap3.put(com.kwad.sdk.ranger.e.TAG, cj.o);
        hashMap3.put(t.f9404d, "CBH");
        bg.a(this.f9373e, "1002001", hashMap3);
        return false;
    }

    private static void d() {
        try {
            Cdo a2 = Cdo.a();
            if (a2 != null) {
                a2.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        d();
        b();
    }

    public void a(String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1

                /* renamed from: a */
                final /* synthetic */ String f9375a;

                /* renamed from: com.kuaishou.weapon.p0.q$1$1 */
                class C01181 extends TimerTask {

                    /* renamed from: a */
                    final /* synthetic */ r f9377a;

                    /* renamed from: b */
                    final /* synthetic */ s f9378b;

                    C01181(r a22, s d22) {
                        a2 = a22;
                        d2 = d22;
                    }

                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        a2.b(str);
                        q.this.f9374f.a(str);
                        File file = new File(d2.f9395e);
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }

                AnonymousClass1(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    r a22;
                    try {
                        if (TextUtils.isEmpty(str) || (a22 = r.a(q.this.f9373e.getApplicationContext(), true)) == null) {
                            return;
                        }
                        s d22 = a22.d(str);
                        if (d22 == null) {
                            s b2 = q.this.f9374f.b(str);
                            if (b2 != null) {
                                q.this.a(str, b2.f9395e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1

                            /* renamed from: a */
                            final /* synthetic */ r f9377a;

                            /* renamed from: b */
                            final /* synthetic */ s f9378b;

                            C01181(r a222, s d222) {
                                a2 = a222;
                                d2 = d222;
                            }

                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                a2.b(str);
                                q.this.f9374f.a(str);
                                File file = new File(d2.f9395e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, TTAdConstant.AD_MAX_EVENT_TIME);
                        a222.b(str);
                        q.this.f9374f.a(str);
                        File file = new File(d222.f9395e);
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

    public void a(String str, String str2) {
        this.f9374f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public synchronized boolean a(int i2, String str, PackageInfo packageInfo) {
        return a(i2, str, null, false, packageInfo);
    }

    public boolean a(s sVar, String str, String str2) {
        s sVar2;
        r a2;
        HashMap hashMap;
        String str3;
        if (sVar == null) {
            hashMap = new HashMap();
            str3 = cj.r;
        } else {
            File file = new File(sVar.f9395e);
            if (dm.a(file)) {
                try {
                    if (!this.f9374f.b(sVar.f9391a)) {
                        this.f9374f.a(sVar);
                    }
                    a2 = r.a(this.f9373e.getApplicationContext(), true);
                    this.f9374f.a(sVar.f9391a, 1);
                    b(sVar.f9393c);
                } catch (Throwable unused) {
                    sVar2 = sVar;
                }
                if (!a2.a(sVar, true)) {
                    file.delete();
                    a(sVar.f9391a, sVar.f9394d, null, true, null);
                    this.f9374f.a(sVar.f9391a, 0);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(com.kwad.sdk.ranger.e.TAG, cj.u);
                    hashMap2.put(t.f9404d, "CBH");
                    hashMap2.put("apk", sVar.toString());
                    bg.a(this.f9373e, "1002001", hashMap2);
                    return false;
                }
                sVar2 = a2.c(sVar.f9395e);
                if (sVar2 == null) {
                    try {
                        this.f9374f.a(sVar2.f9391a, 0);
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put(com.kwad.sdk.ranger.e.TAG, cj.s);
                        hashMap3.put(t.f9404d, "CBH");
                        bg.a(this.f9373e, "1002001", hashMap3);
                        return false;
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    s a3 = this.f9374f.a(sVar2.f9391a);
                    File file2 = null;
                    if (a3 != null && !a3.f9394d.equals(sVar2.f9394d)) {
                        file2 = new File(a3.f9395e);
                    }
                    sVar2.f9392b = 1;
                    sVar2.p = 1;
                    if (this.f9374f.a(sVar2) > 0 && file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    this.f9374f.a(sVar2.f9391a, 0);
                    return true;
                } catch (Throwable unused3) {
                    return false;
                }
            }
            hashMap = new HashMap();
            str3 = cj.t;
        }
        hashMap.put(com.kwad.sdk.ranger.e.TAG, str3);
        hashMap.put(t.f9404d, "CBH");
        bg.a(this.f9373e, "1002001", hashMap);
        return false;
    }

    public synchronized void b() {
        try {
            if (this.f9371c) {
                return;
            }
            this.f9371c = true;
            for (s sVar : this.f9374f.a()) {
                String str = null;
                try {
                    str = this.f9373e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                }
                if (str != null) {
                    sVar.m = str + bh.f9116j + sVar.f9391a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(sVar.m);
                    sb.append("/lib");
                    dm.c(sb.toString());
                    dm.b(sVar.m);
                }
            }
            this.f9374f.b();
            if (this.f9372d.b(Cdo.f9300d)) {
                this.f9374f.c();
            } else {
                this.f9372d.a(Cdo.f9300d, Boolean.TRUE, true);
            }
            n.a().a(new u(this.f9373e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void b(String str) {
        r a2;
        try {
            if (TextUtils.isEmpty(str) || (a2 = r.a()) == null) {
                return;
            }
            a2.b(str);
        } catch (Throwable unused) {
        }
    }

    public void c() {
        for (s sVar : this.f9374f.a()) {
            r a2 = r.a();
            if ((a2 != null ? a2.d(sVar.f9393c) : null) == null) {
                a(sVar.f9391a, sVar.f9394d, (PackageInfo) null);
            }
        }
    }
}
