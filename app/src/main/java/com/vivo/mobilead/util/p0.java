package com.vivo.mobilead.util;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.core.content.ContextCompat;
import com.vivo.ic.SystemUtils;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class p0 {

    /* renamed from: a */
    private com.vivo.mobilead.model.d f30762a;

    /* renamed from: b */
    private Context f30763b;

    /* renamed from: c */
    private Handler f30764c;

    /* renamed from: d */
    private final AtomicInteger f30765d;

    /* renamed from: e */
    private final AtomicInteger f30766e;

    /* renamed from: f */
    private final AtomicInteger f30767f;

    /* renamed from: g */
    private final AtomicInteger f30768g;

    /* renamed from: h */
    private final AtomicInteger f30769h;

    /* renamed from: i */
    private final AtomicInteger f30770i;

    /* renamed from: j */
    private final AtomicInteger f30771j;
    private final AtomicInteger k;
    private final AtomicInteger l;
    private final byte[] m;
    private final byte[] n;
    private final byte[] o;
    private final byte[] p;
    private final byte[] q;
    private final byte[] r;
    private final byte[] s;
    private final byte[] t;
    private final byte[] u;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 3) {
                    p0.this.p();
                    return false;
                }
                if (i2 != 7) {
                    return false;
                }
                p0.this.v();
                return false;
            }
            p0.this.q();
            p0.this.t();
            p0.this.r();
            p0.this.o();
            p0.this.u();
            p0.this.s();
            p0.this.n();
            p0.this.p();
            p0.this.v();
            return false;
        }
    }

    private static class b {

        /* renamed from: a */
        private static final p0 f30773a = new p0(null);
    }

    /* synthetic */ p0(a aVar) {
        this();
    }

    public static p0 m() {
        return b.f30773a;
    }

    public void n() {
        if (this.f30763b == null || this.f30767f.get() >= 3) {
            return;
        }
        synchronized (this.o) {
            if (this.f30767f.incrementAndGet() <= 3) {
                this.f30762a.a(Settings.System.getString(this.f30763b.getContentResolver(), "android_id"));
            }
        }
    }

    public void o() {
        Context context;
        if (Build.VERSION.SDK_INT < 29 && this.l.get() < 3 && (context = this.f30763b) != null && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9318c) != -1) {
            synchronized (this.u) {
                if (this.l.incrementAndGet() <= 3) {
                    String str = "";
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) this.f30763b.getSystemService("phone");
                        String subscriberId = telephonyManager != null ? telephonyManager.getSubscriberId() : null;
                        if (TextUtils.isEmpty(subscriberId)) {
                            str = "0";
                        } else {
                            if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002")) {
                                if (subscriberId.startsWith("46001")) {
                                    str = "2";
                                } else if (subscriberId.startsWith("46003")) {
                                    str = "3";
                                }
                            }
                            str = "1";
                        }
                        this.f30762a.b(str);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void p() {
        if (this.f30763b == null || this.f30769h.get() >= 3) {
            return;
        }
        synchronized (this.q) {
            if (this.f30769h.incrementAndGet() <= 3) {
                this.f30762a.h(com.vivo.mobilead.e.b.a.d().a());
                this.f30762a.j(com.vivo.mobilead.e.b.a.d().c());
                this.f30762a.a(com.vivo.mobilead.e.b.a.d().b());
                if (TextUtils.isEmpty(this.f30762a.h())) {
                    com.vivo.mobilead.e.b.a.d().b(this.f30763b);
                }
            }
        }
    }

    public void q() {
        Context context;
        if (Build.VERSION.SDK_INT < 29 && this.f30771j.get() < 3 && (context = this.f30763b) != null && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9318c) != -1) {
            synchronized (this.s) {
                if (this.f30771j.incrementAndGet() <= 3) {
                    this.f30762a.c(SystemUtils.getImei(this.f30763b));
                }
            }
        }
    }

    public void r() {
        if (this.f30766e.get() < 1) {
            synchronized (this.n) {
                if (this.f30766e.incrementAndGet() <= 1) {
                    try {
                        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                        while (networkInterfaces.hasMoreElements()) {
                            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                            while (true) {
                                if (inetAddresses.hasMoreElements()) {
                                    InetAddress nextElement = inetAddresses.nextElement();
                                    if (!(nextElement instanceof Inet6Address) && nextElement != null && !"127.0.0.1".equals(nextElement.getHostAddress())) {
                                        this.f30762a.d(nextElement.getHostAddress());
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void s() {
        Context context;
        if (this.f30768g.get() >= 1 || (context = this.f30763b) == null || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) == -1) {
            return;
        }
        synchronized (this.p) {
            if (this.f30768g.incrementAndGet() <= 1) {
                com.vivo.mobilead.util.b.b().a(this.f30763b);
                this.f30762a.e(com.vivo.mobilead.util.b.b().a());
            }
        }
    }

    public void t() {
        if (this.f30765d.get() >= 3 || this.f30763b == null) {
            return;
        }
        synchronized (this.m) {
            if (this.f30765d.incrementAndGet() <= 3) {
                this.f30762a.f(y.b(this.f30763b));
            }
        }
    }

    public void u() {
        Context context;
        if (Build.VERSION.SDK_INT < 29 && this.k.get() < 3 && (context = this.f30763b) != null && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9318c) != -1) {
            synchronized (this.t) {
                if (this.k.incrementAndGet() <= 3) {
                    try {
                        String subscriberId = ((TelephonyManager) this.f30763b.getSystemService("phone")).getSubscriberId();
                        if (!TextUtils.isEmpty(subscriberId) && subscriberId.length() >= 5) {
                            this.f30762a.g(subscriberId.substring(0, 3) + "-" + subscriberId.substring(3, 5));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void v() {
        if (this.f30770i.get() >= 3 || this.f30763b == null) {
            return;
        }
        synchronized (this.r) {
            if (this.f30770i.incrementAndGet() <= 3) {
                this.f30762a.i(WebSettings.getDefaultUserAgent(this.f30763b));
            }
        }
    }

    public int j() {
        return this.f30762a.i();
    }

    public String k() {
        String j2 = this.f30762a.j();
        if (TextUtils.isEmpty(j2)) {
            this.f30764c.sendEmptyMessage(7);
        } else {
            this.f30762a.i(j2);
        }
        return this.f30762a.j() == null ? "" : this.f30762a.j();
    }

    public String l() {
        return this.f30762a.k() == null ? "" : this.f30762a.k();
    }

    private p0() {
        this.f30765d = new AtomicInteger(0);
        this.f30766e = new AtomicInteger(0);
        this.f30767f = new AtomicInteger(0);
        this.f30768g = new AtomicInteger(0);
        this.f30769h = new AtomicInteger(0);
        this.f30770i = new AtomicInteger(0);
        this.f30771j = new AtomicInteger(0);
        this.k = new AtomicInteger(0);
        this.l = new AtomicInteger(0);
        this.m = new byte[0];
        this.n = new byte[0];
        this.o = new byte[0];
        this.p = new byte[0];
        this.q = new byte[0];
        this.r = new byte[0];
        this.s = new byte[0];
        this.t = new byte[0];
        this.u = new byte[0];
        this.f30762a = new com.vivo.mobilead.model.d();
        this.f30763b = com.vivo.mobilead.manager.f.j().c();
        try {
            HandlerThread handlerThread = new HandlerThread("VivoAdSensitive");
            handlerThread.start();
            this.f30764c = new Handler(handlerThread.getLooper(), new a());
        } catch (Exception unused) {
        }
    }

    public void a(Context context) {
        if (context != null) {
            this.f30763b = context;
        }
        com.vivo.mobilead.e.b.a.d().a(context);
    }

    public String b() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String b2 = this.f30762a.b();
        if (TextUtils.isEmpty(b2)) {
            o();
        } else {
            this.f30762a.b(b2);
        }
        return this.f30762a.b() == null ? "" : this.f30762a.b();
    }

    public int c() {
        Context context = this.f30763b;
        if (context != null) {
            return c0.a(context);
        }
        return 0;
    }

    public String d() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String c2 = this.f30762a.c();
        if (a(c2)) {
            q();
        } else {
            this.f30762a.c(c2);
        }
        return this.f30762a.c() == null ? "" : this.f30762a.c();
    }

    public String e() {
        if (TextUtils.isEmpty(this.f30762a.d())) {
            r();
        }
        return this.f30762a.d() == null ? "" : this.f30762a.d();
    }

    public String f() {
        if (TextUtils.isEmpty(this.f30762a.e())) {
            s();
        }
        return this.f30762a.e() == null ? "" : this.f30762a.e();
    }

    public String g() {
        String f2 = this.f30762a.f();
        if (TextUtils.isEmpty(f2)) {
            t();
        } else {
            this.f30762a.f(f2);
        }
        return this.f30762a.f() == null ? "" : this.f30762a.f();
    }

    public String h() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        String g2 = this.f30762a.g();
        if (TextUtils.isEmpty(g2)) {
            u();
        } else {
            this.f30762a.g(g2);
        }
        return this.f30762a.g() == null ? "" : this.f30762a.g();
    }

    public String i() {
        String h2 = this.f30762a.h();
        if (TextUtils.isEmpty(h2)) {
            this.f30762a.h(com.vivo.mobilead.e.b.a.d().a());
            this.f30762a.j(com.vivo.mobilead.e.b.a.d().c());
            this.f30762a.a(com.vivo.mobilead.e.b.a.d().b());
            if (TextUtils.isEmpty(this.f30762a.h())) {
                this.f30764c.sendEmptyMessage(3);
            }
        } else {
            this.f30762a.h(h2);
        }
        return this.f30762a.h() == null ? "" : this.f30762a.h();
    }

    public String a() {
        String a2 = this.f30762a.a();
        if (TextUtils.isEmpty(a2)) {
            n();
        } else {
            this.f30762a.a(a2);
        }
        return this.f30762a.a() == null ? "" : this.f30762a.a();
    }

    private boolean a(String str) {
        return TextUtils.isEmpty(str) || "123456789012345".equals(str);
    }
}
