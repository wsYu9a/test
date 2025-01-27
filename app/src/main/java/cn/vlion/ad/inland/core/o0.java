package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class o0 implements VlionMediaInitCallback {

    /* renamed from: a */
    public final /* synthetic */ BaseAdAdapter f3715a;

    /* renamed from: b */
    public final /* synthetic */ b f3716b;

    /* renamed from: c */
    public final /* synthetic */ VlionAdapterADConfig f3717c;

    /* renamed from: d */
    public final /* synthetic */ String f3718d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3719e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar;
            VlionAdapterADConfig vlionAdapterADConfig;
            try {
                o0 o0Var = o0.this;
                BaseAdAdapter baseAdAdapter = o0Var.f3715a;
                if (baseAdAdapter == null || (bVar = o0Var.f3716b) == null || (vlionAdapterADConfig = o0Var.f3717c) == null) {
                    return;
                }
                o0Var.f3719e.d(baseAdAdapter, o0Var.f3718d, bVar, vlionAdapterADConfig);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public o0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3719e = p0Var;
        this.f3715a = baseAdAdapter;
        this.f3716b = bVar;
        this.f3717c = vlionAdapterADConfig;
        this.f3718d = str;
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onFail(String str) {
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onSuccess() {
        VlionHandlerUtils.instant().post(new a());
    }
}
