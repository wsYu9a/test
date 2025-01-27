package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class aa {

    /* renamed from: a */
    private static final String f6689a = "LoadRemoteDex";

    /* renamed from: i */
    private static aa f6690i;

    /* renamed from: b */
    private IXAdContainerFactory f6691b;

    /* renamed from: c */
    private bo f6692c;

    /* renamed from: f */
    private Runnable f6695f;

    /* renamed from: g */
    private Context f6696g;

    /* renamed from: k */
    private boolean f6699k;

    /* renamed from: d */
    private int f6693d = 5000;

    /* renamed from: e */
    private Handler f6694e = new Handler(Looper.getMainLooper());

    /* renamed from: h */
    private bt f6697h = bt.a();

    /* renamed from: j */
    private AtomicBoolean f6698j = new AtomicBoolean(false);

    public interface a {

        /* renamed from: a */
        public static final int f6700a = 1;

        /* renamed from: b */
        public static final int f6701b = 2;

        void onFailure();

        void onSuccess();
    }

    private aa() {
    }

    private void f() {
        this.f6698j.set(true);
        if (an.a()) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        synchronized (aa.class) {
            try {
                bo boVar = new bo(Class.forName(z.aN, true, getClass().getClassLoader()), this.f6696g);
                this.f6692c = boVar;
                this.f6691b = boVar.a();
                k();
            } catch (Exception unused) {
                a("反射调用remote失败");
            }
        }
    }

    private void h() {
        this.f6695f = new ab(this);
        j();
        if (h.f7186a == null) {
            synchronized (bz.class) {
                try {
                    if (h.f7186a == null) {
                        h.f7186a = new bz(this.f6696g);
                    }
                } finally {
                }
            }
        }
        if (this.f6691b != null) {
            k();
            return;
        }
        if (h.f7186a == null) {
            this.f6697h.a(f6689a, "BaiduXAdSDKContext.mApkLoader == null,not load apk");
            return;
        }
        this.f6697h.a(f6689a, "start load apk");
        try {
            h.f7186a.a(new ac(this));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void i() {
        Runnable runnable = this.f6695f;
        if (runnable != null) {
            this.f6694e.removeCallbacks(runnable);
        }
        this.f6695f = null;
    }

    private void j() {
        Runnable runnable = this.f6695f;
        if (runnable != null) {
            this.f6694e.postDelayed(runnable, this.f6693d);
        }
    }

    public void k() {
        this.f6698j.set(false);
        bm.a(this.f6696g);
        i();
        s.a().a(1);
        cn.a(this.f6696g).b();
        cn.a(this.f6696g).a();
    }

    public IXAdContainerFactory c() {
        if (this.f6696g == null) {
            return null;
        }
        if (this.f6691b == null && !this.f6698j.get()) {
            f();
        }
        return this.f6691b;
    }

    public String d() {
        if (this.f6691b == null) {
            return "";
        }
        return hf.e.f26694a + this.f6691b.getRemoteVersion();
    }

    public boolean e() {
        return this.f6699k;
    }

    public Context b() {
        return this.f6696g;
    }

    public static aa a() {
        if (f6690i == null) {
            synchronized (aa.class) {
                try {
                    if (f6690i == null) {
                        f6690i = new aa();
                    }
                } finally {
                }
            }
        }
        return f6690i;
    }

    public void a(Context context, a aVar) {
        if (context == null) {
            this.f6697h.c(f6689a, "init Context is null,error");
            return;
        }
        this.f6696g = context.getApplicationContext();
        s.a().a(aVar);
        if (this.f6691b != null) {
            k();
        } else {
            if (this.f6698j.get()) {
                return;
            }
            f();
        }
    }

    public void a(String str) {
        this.f6697h.a(f6689a, "加载dex失败原因=" + str);
        this.f6698j.set(false);
        i();
        s.a().a(2);
    }
}
