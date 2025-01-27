package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends h {

    public class a implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ BaseAdAdapter f3637a;

        /* renamed from: b */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3638b;

        /* renamed from: c */
        public final /* synthetic */ VlionAdapterADConfig f3639c;

        /* renamed from: d */
        public final /* synthetic */ j f3640d;

        /* renamed from: cn.vlion.ad.inland.core.j$a$a */
        public class RunnableC0030a implements Runnable {
            public RunnableC0030a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cn.vlion.ad.inland.core.b bVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    a aVar = a.this;
                    BaseAdAdapter baseAdAdapter = aVar.f3637a;
                    if (baseAdAdapter == null || (bVar = aVar.f3638b) == null || (vlionAdapterADConfig = aVar.f3639c) == null) {
                        return;
                    }
                    j.a(baseAdAdapter, vlionAdapterADConfig, aVar.f3640d, bVar, "loadBanner");
                    a aVar2 = a.this;
                    aVar2.f3637a.loadBannerAD(aVar2.f3640d.f3591b, aVar2.f3639c);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public a(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar) {
            this.f3640d = jVar;
            this.f3637a = baseAdAdapter;
            this.f3638b = bVar;
            this.f3639c = vlionAdapterADConfig;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionHandlerUtils.instant().post(new RunnableC0030a());
        }
    }

    public class b implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ BaseAdAdapter f3642a;

        /* renamed from: b */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3643b;

        /* renamed from: c */
        public final /* synthetic */ VlionAdapterADConfig f3644c;

        /* renamed from: d */
        public final /* synthetic */ j f3645d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cn.vlion.ad.inland.core.b bVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    b bVar2 = b.this;
                    BaseAdAdapter baseAdAdapter = bVar2.f3642a;
                    if (baseAdAdapter == null || (bVar = bVar2.f3643b) == null || (vlionAdapterADConfig = bVar2.f3644c) == null) {
                        return;
                    }
                    j.a(baseAdAdapter, vlionAdapterADConfig, bVar2.f3645d, bVar, "getInterstitialAdData");
                    b bVar3 = b.this;
                    bVar3.f3642a.loadInterstitialAD(bVar3.f3645d.f3591b, bVar3.f3644c);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public b(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar) {
            this.f3645d = jVar;
            this.f3642a = baseAdAdapter;
            this.f3643b = bVar;
            this.f3644c = vlionAdapterADConfig;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionHandlerUtils.instant().post(new a());
        }
    }

    public class c implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ BaseAdAdapter f3647a;

        /* renamed from: b */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3648b;

        /* renamed from: c */
        public final /* synthetic */ VlionAdapterADConfig f3649c;

        /* renamed from: d */
        public final /* synthetic */ j f3650d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cn.vlion.ad.inland.core.b bVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    c cVar = c.this;
                    BaseAdAdapter baseAdAdapter = cVar.f3647a;
                    if (baseAdAdapter == null || (bVar = cVar.f3648b) == null || (vlionAdapterADConfig = cVar.f3649c) == null) {
                        return;
                    }
                    j.a(baseAdAdapter, vlionAdapterADConfig, cVar.f3650d, bVar, "loadSplash");
                    c cVar2 = c.this;
                    cVar2.f3647a.loadSplashAD(cVar2.f3650d.f3590a, cVar2.f3649c);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public c(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar) {
            this.f3650d = jVar;
            this.f3647a = baseAdAdapter;
            this.f3648b = bVar;
            this.f3649c = vlionAdapterADConfig;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionHandlerUtils.instant().post(new a());
        }
    }

    public class d implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ BaseAdAdapter f3652a;

        /* renamed from: b */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3653b;

        /* renamed from: c */
        public final /* synthetic */ VlionAdapterADConfig f3654c;

        /* renamed from: d */
        public final /* synthetic */ j f3655d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cn.vlion.ad.inland.core.b bVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    d dVar = d.this;
                    BaseAdAdapter baseAdAdapter = dVar.f3652a;
                    if (baseAdAdapter == null || (bVar = dVar.f3653b) == null || (vlionAdapterADConfig = dVar.f3654c) == null) {
                        return;
                    }
                    j.a(baseAdAdapter, vlionAdapterADConfig, dVar.f3655d, bVar, "loadFeed");
                    d dVar2 = d.this;
                    dVar2.f3652a.loadFeedAD(dVar2.f3655d.f3590a, dVar2.f3654c);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public d(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar) {
            this.f3655d = jVar;
            this.f3652a = baseAdAdapter;
            this.f3653b = bVar;
            this.f3654c = vlionAdapterADConfig;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionHandlerUtils.instant().post(new a());
        }
    }

    public class e implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ BaseAdAdapter f3657a;

        /* renamed from: b */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3658b;

        /* renamed from: c */
        public final /* synthetic */ VlionAdapterADConfig f3659c;

        /* renamed from: d */
        public final /* synthetic */ j f3660d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cn.vlion.ad.inland.core.b bVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    e eVar = e.this;
                    BaseAdAdapter baseAdAdapter = eVar.f3657a;
                    if (baseAdAdapter == null || (bVar = eVar.f3658b) == null || (vlionAdapterADConfig = eVar.f3659c) == null) {
                        return;
                    }
                    j.a(baseAdAdapter, vlionAdapterADConfig, eVar.f3660d, bVar, "loadNative");
                    e eVar2 = e.this;
                    eVar2.f3657a.loadNativeAD(eVar2.f3660d.f3590a, eVar2.f3659c);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public e(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar) {
            this.f3660d = jVar;
            this.f3657a = baseAdAdapter;
            this.f3658b = bVar;
            this.f3659c = vlionAdapterADConfig;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionHandlerUtils.instant().post(new a());
        }
    }

    public class f implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ BaseAdAdapter f3662a;

        /* renamed from: b */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3663b;

        /* renamed from: c */
        public final /* synthetic */ VlionAdapterADConfig f3664c;

        /* renamed from: d */
        public final /* synthetic */ j f3665d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cn.vlion.ad.inland.core.b bVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    f fVar = f.this;
                    BaseAdAdapter baseAdAdapter = fVar.f3662a;
                    if (baseAdAdapter == null || (bVar = fVar.f3663b) == null || (vlionAdapterADConfig = fVar.f3664c) == null) {
                        return;
                    }
                    j.a(baseAdAdapter, vlionAdapterADConfig, fVar.f3665d, bVar, "loadRewardVideo");
                    f fVar2 = f.this;
                    fVar2.f3662a.loadRewardVideoAD(fVar2.f3665d.f3590a, fVar2.f3664c);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public f(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar) {
            this.f3665d = jVar;
            this.f3662a = baseAdAdapter;
            this.f3663b = bVar;
            this.f3664c = vlionAdapterADConfig;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionHandlerUtils.instant().post(new a());
        }
    }

    public class g implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ BaseAdAdapter f3667a;

        /* renamed from: b */
        public final /* synthetic */ cn.vlion.ad.inland.core.b f3668b;

        /* renamed from: c */
        public final /* synthetic */ VlionAdapterADConfig f3669c;

        /* renamed from: d */
        public final /* synthetic */ j f3670d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                cn.vlion.ad.inland.core.b bVar;
                VlionAdapterADConfig vlionAdapterADConfig;
                try {
                    g gVar = g.this;
                    BaseAdAdapter baseAdAdapter = gVar.f3667a;
                    if (baseAdAdapter == null || (bVar = gVar.f3668b) == null || (vlionAdapterADConfig = gVar.f3669c) == null) {
                        return;
                    }
                    j.a(baseAdAdapter, vlionAdapterADConfig, gVar.f3670d, bVar, "loaDraw");
                    g gVar2 = g.this;
                    gVar2.f3667a.loadDrawAD(gVar2.f3670d.f3590a, gVar2.f3669c);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
            }
        }

        public g(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar) {
            this.f3670d = jVar;
            this.f3667a = baseAdAdapter;
            this.f3668b = bVar;
            this.f3669c = vlionAdapterADConfig;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionHandlerUtils.instant().post(new a());
        }
    }

    public j(Context context, Activity activity, ArrayList<cn.vlion.ad.inland.core.b> arrayList, boolean z10) {
        super(context, activity, arrayList, z10);
        this.f3592c = j.class.getName();
    }

    @Override // cn.vlion.ad.inland.core.h
    public final void a() {
        try {
            super.a();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void b(cn.vlion.ad.inland.core.b bVar) {
        try {
            a(bVar);
            if (f()) {
                LogVlion.e(this.f3592c + " checkAdapterIsFinished  currentProxy loadFinishedAdapter=false");
            } else {
                LogVlion.e(this.f3592c + " checkAdapterIsFinished  currentProxy loadFinishedAdapter=true ");
                a(false);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void c(c0 c0Var) {
        cn.vlion.ad.inland.core.b bVar;
        BaseAdAdapter c10;
        try {
            this.f3598i = c0Var;
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                try {
                    bVar = this.f3595f.get(i10);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (bVar == null || (c10 = bVar.c()) == null || bVar.m() == null) {
                    return;
                }
                a(c10, "loadFeed", bVar.o(), bVar, new d(c10, bVar.n(), this, bVar));
            }
            e();
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void d(c0 c0Var) {
        cn.vlion.ad.inland.core.b bVar;
        BaseAdAdapter c10;
        try {
            this.f3598i = c0Var;
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                try {
                    bVar = this.f3595f.get(i10);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (bVar == null || (c10 = bVar.c()) == null || bVar.m() == null) {
                    return;
                }
                a(c10, "getInterstitialAdData", bVar.o(), bVar, new b(c10, bVar.n(), this, bVar));
            }
            e();
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void e(c0 c0Var) {
        cn.vlion.ad.inland.core.b bVar;
        BaseAdAdapter c10;
        try {
            this.f3598i = c0Var;
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                try {
                    bVar = this.f3595f.get(i10);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (bVar == null || (c10 = bVar.c()) == null || bVar.m() == null) {
                    return;
                }
                a(c10, "loadNative", bVar.o(), bVar, new e(c10, bVar.n(), this, bVar));
            }
            e();
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void f(c0 c0Var) {
        cn.vlion.ad.inland.core.b bVar;
        BaseAdAdapter c10;
        try {
            this.f3598i = c0Var;
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                try {
                    bVar = this.f3595f.get(i10);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (bVar == null || (c10 = bVar.c()) == null || bVar.m() == null) {
                    return;
                }
                a(c10, "loadRewardVideo", bVar.o(), bVar, new f(c10, bVar.n(), this, bVar));
            }
            e();
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void g(c0 c0Var) {
        cn.vlion.ad.inland.core.b bVar;
        BaseAdAdapter c10;
        try {
            this.f3598i = c0Var;
            LogVlion.e(this.f3592c + " loadSplashload = loadSplash =");
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                try {
                    bVar = this.f3595f.get(i10);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (bVar == null || (c10 = bVar.c()) == null || bVar.m() == null) {
                    return;
                }
                a(c10, "loadSplash", bVar.o(), bVar, new c(c10, bVar.n(), this, bVar));
            }
            LogVlion.e(this.f3592c + " triggerAdapterIsLimit---=" + this.f3595f.size());
            e();
            LogVlion.e(this.f3592c + " loadSplashload = end  end end=");
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void a(c0 c0Var) {
        cn.vlion.ad.inland.core.b bVar;
        BaseAdAdapter c10;
        try {
            this.f3598i = c0Var;
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                try {
                    bVar = this.f3595f.get(i10);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (bVar == null || (c10 = bVar.c()) == null || bVar.m() == null) {
                    return;
                }
                a(c10, "loadBanner", bVar.o(), bVar, new a(c10, bVar.n(), this, bVar));
            }
            e();
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final void b(c0 c0Var) {
        cn.vlion.ad.inland.core.b bVar;
        BaseAdAdapter c10;
        try {
            this.f3598i = c0Var;
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                try {
                    bVar = this.f3595f.get(i10);
                } catch (Throwable th2) {
                    VlionSDkManager.getInstance().upLoadCatchException(th2);
                }
                if (bVar == null || (c10 = bVar.c()) == null || bVar.m() == null) {
                    return;
                }
                a(c10, "loaDraw", bVar.o(), bVar, new g(c10, bVar.n(), this, bVar));
            }
            e();
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
    }

    public final synchronized boolean f() {
        LogVlion.e(this.f3592c + " isNotFinishedAdapter  currentProxy");
        try {
            if (this.f3595f != null) {
                LogVlion.e(this.f3592c + " isNotFinishedAdapter  baseAdSourceDataList.size()=" + this.f3595f.size());
                if (this.f3595f.size() > 0) {
                    for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                        cn.vlion.ad.inland.core.b bVar = this.f3595f.get(i10);
                        if (bVar != null) {
                            LogVlion.e(this.f3592c + " isNotFinishedAdapter  baseAdSourceData=" + bVar.h() + " getLoadSuccessState()=" + bVar.e());
                            if (bVar.e() == 0) {
                                return true;
                            }
                        }
                    }
                }
            }
            LogVlion.e(this.f3592c + " isNotFinishedAdapter  setLoadAllFinished true");
            d();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return false;
    }

    public static void a(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, j jVar, cn.vlion.ad.inland.core.b bVar, String str) {
        jVar.getClass();
        try {
            VlionADEventManager.submitReq(vlionAdapterADConfig);
            baseAdAdapter.setVlionBiddingListener(new k(baseAdAdapter, vlionAdapterADConfig, jVar, bVar, str));
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(j jVar) {
        jVar.getClass();
        try {
            if (jVar.f()) {
                LogVlion.e(jVar.f3592c + " checkAdapterIsFinished !isNotFinishedAdapter=false");
            } else {
                LogVlion.e(jVar.f3592c + " checkAdapterIsFinished !isNotFinishedAdapter=true");
                jVar.a(true);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
