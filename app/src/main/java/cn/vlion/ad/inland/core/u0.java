package cn.vlion.ad.inland.core;

import android.app.Activity;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class u0 implements VlionMediaInitCallback {

    /* renamed from: a */
    public final /* synthetic */ BaseAdAdapter f3783a;

    /* renamed from: b */
    public final /* synthetic */ b f3784b;

    /* renamed from: c */
    public final /* synthetic */ VlionAdapterADConfig f3785c;

    /* renamed from: d */
    public final /* synthetic */ String f3786d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3787e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar;
            VlionAdapterADConfig vlionAdapterADConfig;
            try {
                u0 u0Var = u0.this;
                BaseAdAdapter baseAdAdapter = u0Var.f3783a;
                if (baseAdAdapter == null || (bVar = u0Var.f3784b) == null || (vlionAdapterADConfig = u0Var.f3785c) == null) {
                    return;
                }
                p0 p0Var = u0Var.f3787e;
                Activity activity = p0Var.f3591b;
                p0Var.b(baseAdAdapter, u0Var.f3786d, bVar, vlionAdapterADConfig);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public u0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3787e = p0Var;
        this.f3783a = baseAdAdapter;
        this.f3784b = bVar;
        this.f3785c = vlionAdapterADConfig;
        this.f3786d = str;
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onFail(String str) {
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onSuccess() {
        VlionHandlerUtils.instant().post(new a());
    }
}
