package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class r0 implements VlionMediaInitCallback {

    /* renamed from: a */
    public final /* synthetic */ BaseAdAdapter f3753a;

    /* renamed from: b */
    public final /* synthetic */ b f3754b;

    /* renamed from: c */
    public final /* synthetic */ VlionAdapterADConfig f3755c;

    /* renamed from: d */
    public final /* synthetic */ String f3756d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3757e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar;
            VlionAdapterADConfig vlionAdapterADConfig;
            try {
                r0 r0Var = r0.this;
                BaseAdAdapter baseAdAdapter = r0Var.f3753a;
                if (baseAdAdapter == null || (bVar = r0Var.f3754b) == null || (vlionAdapterADConfig = r0Var.f3755c) == null) {
                    return;
                }
                p0 p0Var = r0Var.f3757e;
                p0Var.b(p0Var.f3591b, baseAdAdapter, r0Var.f3756d, bVar, vlionAdapterADConfig);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public r0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3757e = p0Var;
        this.f3753a = baseAdAdapter;
        this.f3754b = bVar;
        this.f3755c = vlionAdapterADConfig;
        this.f3756d = str;
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onFail(String str) {
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onSuccess() {
        VlionHandlerUtils.instant().post(new a());
    }
}
