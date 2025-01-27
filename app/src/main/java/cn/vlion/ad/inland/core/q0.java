package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class q0 implements VlionMediaInitCallback {

    /* renamed from: a */
    public final /* synthetic */ BaseAdAdapter f3747a;

    /* renamed from: b */
    public final /* synthetic */ b f3748b;

    /* renamed from: c */
    public final /* synthetic */ VlionAdapterADConfig f3749c;

    /* renamed from: d */
    public final /* synthetic */ String f3750d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3751e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar;
            VlionAdapterADConfig vlionAdapterADConfig;
            try {
                q0 q0Var = q0.this;
                BaseAdAdapter baseAdAdapter = q0Var.f3747a;
                if (baseAdAdapter == null || (bVar = q0Var.f3748b) == null || (vlionAdapterADConfig = q0Var.f3749c) == null) {
                    return;
                }
                q0Var.f3751e.a(baseAdAdapter, q0Var.f3750d, bVar, vlionAdapterADConfig);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public q0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3751e = p0Var;
        this.f3747a = baseAdAdapter;
        this.f3748b = bVar;
        this.f3749c = vlionAdapterADConfig;
        this.f3750d = str;
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onFail(String str) {
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onSuccess() {
        VlionHandlerUtils.instant().post(new a());
    }
}
