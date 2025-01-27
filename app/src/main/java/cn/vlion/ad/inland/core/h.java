package cn.vlion.ad.inland.core;

import android.app.Activity;
import android.content.Context;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterInitConfig;
import cn.vlion.ad.inland.base.util.VlionAdLimitStrategyUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.config.VlionAdError;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a */
    public Context f3590a;

    /* renamed from: b */
    public Activity f3591b;

    /* renamed from: d */
    public cn.vlion.ad.inland.core.a f3593d;

    /* renamed from: f */
    public volatile ArrayList<b> f3595f;

    /* renamed from: i */
    public c0 f3598i;

    /* renamed from: j */
    public final boolean f3599j;

    /* renamed from: c */
    public String f3592c = "";

    /* renamed from: e */
    public b f3594e = null;

    /* renamed from: g */
    public volatile boolean f3596g = false;

    /* renamed from: h */
    public volatile boolean f3597h = false;

    public class a implements VlionMediaInitCallback {

        /* renamed from: a */
        public final /* synthetic */ VlionMediaInitCallback f3600a;

        /* renamed from: b */
        public final /* synthetic */ b f3601b;

        /* renamed from: c */
        public final /* synthetic */ String f3602c;

        /* renamed from: d */
        public final /* synthetic */ BaseAdAdapter f3603d;

        public a(VlionMediaInitCallback vlionMediaInitCallback, b bVar, String str, BaseAdAdapter baseAdAdapter) {
            this.f3600a = vlionMediaInitCallback;
            this.f3601b = bVar;
            this.f3602c = str;
            this.f3603d = baseAdAdapter;
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onFail(String str) {
            try {
                VlionMediaInitCallback vlionMediaInitCallback = this.f3600a;
                if (vlionMediaInitCallback != null) {
                    vlionMediaInitCallback.onFail(str);
                }
                if (this.f3601b != null) {
                    LogVlion.e(h.this.f3592c + " " + this.f3602c + " init adapter " + this.f3603d.getNetworkName() + " fail:" + this.f3603d.getNetworkName());
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }

        @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
        public final void onSuccess() {
            VlionMediaInitCallback vlionMediaInitCallback = this.f3600a;
            if (vlionMediaInitCallback != null) {
                vlionMediaInitCallback.onSuccess();
            }
        }
    }

    public h(Context context, Activity activity, ArrayList<b> arrayList, boolean z10) {
        this.f3590a = context;
        this.f3591b = activity;
        this.f3595f = arrayList;
        this.f3599j = z10;
    }

    public void a() {
        try {
            this.f3597h = true;
            b bVar = this.f3594e;
            if (bVar != null) {
                bVar.a();
                this.f3594e = null;
            }
            if (this.f3599j || this.f3595f == null || this.f3595f.size() <= 0) {
                return;
            }
            for (int i10 = 0; i10 < this.f3595f.size(); i10++) {
                b bVar2 = this.f3595f.get(i10);
                if (bVar2 != null) {
                    bVar2.a();
                }
            }
            this.f3595f.clear();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final cn.vlion.ad.inland.core.a b() {
        return this.f3593d;
    }

    public final b c() {
        return this.f3594e;
    }

    public final void d() {
        LogVlion.e("VlionBaseAdSource setLoadAllFinished=true");
        this.f3596g = true;
    }

    public final synchronized void e() {
        try {
            if (this.f3595f != null && this.f3595f.size() > 0) {
                LogVlion.e("VlionBaseAdSource triggerAdapterIsLimit getShowId  ==" + this.f3595f.get(0).k());
                VlionAdLimitStrategyUtils.getInstance().setLimitStrategyBean(this.f3595f.get(0).k(), null);
            }
        } finally {
        }
    }

    public final void a(BaseAdAdapter baseAdAdapter, String str, VlionAdapterInitConfig vlionAdapterInitConfig, b bVar, VlionMediaInitCallback vlionMediaInitCallback) {
        try {
            LogVlion.e(this.f3592c + " " + str + " load  plat=" + bVar.h() + " " + bVar);
            if (baseAdAdapter != null) {
                baseAdAdapter.initialize(VlionSDkManager.getInstance().getApplication(), vlionAdapterInitConfig, new a(vlionMediaInitCallback, bVar, str, baseAdAdapter));
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void a(b bVar) {
        this.f3594e = bVar;
    }

    public final synchronized void a(b bVar, BaseAdAdapter baseAdAdapter) {
        cn.vlion.ad.inland.core.a aVar;
        if (bVar != null) {
            try {
                cn.vlion.ad.inland.core.a aVar2 = new cn.vlion.ad.inland.core.a(baseAdAdapter);
                aVar2.a(bVar.i());
                aVar2.a(bVar);
                aVar2.a(System.currentTimeMillis());
                if (this.f3599j) {
                    n.a(bVar, aVar2);
                }
                synchronized (this) {
                    try {
                        aVar = this.f3593d;
                    } finally {
                        VlionSDkManager.getInstance().upLoadCatchException(th);
                    }
                    if (aVar != null) {
                        if (aVar.c() < aVar2.c()) {
                        }
                    }
                    this.f3593d = aVar2;
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public final synchronized void a(String str) {
        try {
            if (this.f3595f != null && this.f3595f.size() > 0) {
                LogVlion.e("VlionBaseAdSource triggerAdapterIsLimit getShowId  ==" + this.f3595f.get(0).k());
                VlionAdLimitStrategyUtils.getInstance().setLimitStrategyBean(this.f3595f.get(0).k(), str);
            }
        } finally {
        }
    }

    public final synchronized void a(boolean z10) {
        c0 c0Var;
        VlionAdError vlionAdError;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("VlionBaseAdSource checkLoadResultCallback   isLoadAll=");
            sb2.append(this.f3596g);
            sb2.append("  isLoadSuccess=");
            sb2.append(z10);
            sb2.append(" baseAdAdapterCacheData=");
            sb2.append(this.f3593d == null);
            sb2.append(" failBaseAdSourceData=");
            sb2.append(this.f3594e);
            LogVlion.e(sb2.toString());
            cn.vlion.ad.inland.core.a aVar = this.f3593d;
            if (aVar != null) {
                c0 c0Var2 = this.f3598i;
                if (c0Var2 != null) {
                    c0Var2.a(aVar.c());
                }
            } else {
                if (this.f3594e != null) {
                    c0Var = this.f3598i;
                    if (c0Var != null) {
                        VlionAdBaseError vlionAdBaseError = VlionAdBaseError.AD_IS_NOT_FILL;
                        vlionAdError = new VlionAdError(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage(), String.valueOf(this.f3594e.f()), this.f3594e.g());
                    }
                } else {
                    c0Var = this.f3598i;
                    if (c0Var != null) {
                        VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.AD_IS_NOT_FILL;
                        vlionAdError = new VlionAdError(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage(), "", "");
                    }
                }
                c0Var.onAdLoadFailure(vlionAdError);
            }
        } finally {
        }
    }
}
