package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a */
    private static final String f5934a = "LoadRemoteDex";

    /* renamed from: i */
    private static z f5935i;

    /* renamed from: b */
    private IXAdContainerFactory f5936b;

    /* renamed from: c */
    private bl f5937c;

    /* renamed from: f */
    private Runnable f5940f;

    /* renamed from: g */
    private Context f5941g;
    private boolean k;

    /* renamed from: d */
    private int f5938d = 5000;

    /* renamed from: e */
    private Handler f5939e = new Handler(Looper.getMainLooper());

    /* renamed from: h */
    private bq f5942h = bq.a();

    /* renamed from: j */
    private AtomicBoolean f5943j = new AtomicBoolean(false);

    public interface a {

        /* renamed from: a */
        public static final int f5944a = 1;

        /* renamed from: b */
        public static final int f5945b = 2;

        void onFailure();

        void onSuccess();
    }

    private z() {
    }

    private void f() {
        this.f5943j.set(true);
        if (an.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (z.class) {
            try {
                bl blVar = new bl(Class.forName(w.aC, true, getClass().getClassLoader()), this.f5941g);
                this.f5937c = blVar;
                this.f5936b = blVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f5940f = new aa(this);
        j();
        if (f.f5802a == null) {
            synchronized (bw.class) {
                if (f.f5802a == null) {
                    f.f5802a = new bw(this.f5941g);
                }
            }
        }
        if (this.f5936b != null) {
            k();
            return;
        }
        if (f.f5802a == null) {
            this.f5942h.a(f5934a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
            return;
        }
        this.f5942h.a(f5934a, "start load apk");
        try {
            f.f5802a.a(new ab(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void i() {
        Runnable runnable = this.f5940f;
        if (runnable != null) {
            this.f5939e.removeCallbacks(runnable);
        }
        this.f5940f = null;
    }

    private void j() {
        Runnable runnable = this.f5940f;
        if (runnable != null) {
            this.f5939e.postDelayed(runnable, this.f5938d);
        }
    }

    public void k() {
        this.f5943j.set(false);
        bj.a(this.f5941g);
        i();
        p.a().a(1);
        ck.a(this.f5941g).b();
        ck.a(this.f5941g).a();
    }

    public IXAdContainerFactory c() {
        if (this.f5941g == null) {
            return null;
        }
        if (this.f5936b == null && !this.f5943j.get()) {
            f();
        }
        return this.f5936b;
    }

    public String d() {
        if (this.f5936b == null) {
            return "";
        }
        return "_" + this.f5936b.getRemoteVersion();
    }

    public boolean e() {
        return this.k;
    }

    public Context b() {
        return this.f5941g;
    }

    public static z a() {
        if (f5935i == null) {
            synchronized (z.class) {
                if (f5935i == null) {
                    f5935i = new z();
                }
            }
        }
        return f5935i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.f5942h.c(f5934a, "init Context is null,error");
            return;
        }
        this.f5941g = context.getApplicationContext();
        p.a().a(aVar);
        if (this.f5936b != null) {
            k();
        } else {
            if (this.f5943j.get()) {
                return;
            }
            f();
        }
    }

    public void a(String str) {
        this.f5942h.a(f5934a, "加载dex失败原因=" + str);
        this.f5943j.set(false);
        i();
        p.a().a(2);
    }
}
