package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class m0 implements VlionMediaInitCallback {

    /* renamed from: a */
    public final /* synthetic */ BaseAdAdapter f3696a;

    /* renamed from: b */
    public final /* synthetic */ b f3697b;

    /* renamed from: c */
    public final /* synthetic */ VlionAdapterADConfig f3698c;

    /* renamed from: d */
    public final /* synthetic */ String f3699d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3700e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar;
            VlionAdapterADConfig vlionAdapterADConfig;
            try {
                m0 m0Var = m0.this;
                BaseAdAdapter baseAdAdapter = m0Var.f3696a;
                if (baseAdAdapter == null || (bVar = m0Var.f3697b) == null || (vlionAdapterADConfig = m0Var.f3698c) == null) {
                    return;
                }
                p0 p0Var = m0Var.f3700e;
                p0Var.a(p0Var.f3591b, baseAdAdapter, m0Var.f3699d, bVar, vlionAdapterADConfig);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public m0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3700e = p0Var;
        this.f3696a = baseAdAdapter;
        this.f3697b = bVar;
        this.f3698c = vlionAdapterADConfig;
        this.f3699d = str;
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onFail(String str) {
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onSuccess() {
        VlionHandlerUtils.instant().post(new a());
    }
}
