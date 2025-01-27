package cn.vlion.ad.inland.core;

import android.app.Activity;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class s0 implements VlionMediaInitCallback {

    /* renamed from: a */
    public final /* synthetic */ BaseAdAdapter f3762a;

    /* renamed from: b */
    public final /* synthetic */ b f3763b;

    /* renamed from: c */
    public final /* synthetic */ VlionAdapterADConfig f3764c;

    /* renamed from: d */
    public final /* synthetic */ String f3765d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3766e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar;
            VlionAdapterADConfig vlionAdapterADConfig;
            try {
                s0 s0Var = s0.this;
                BaseAdAdapter baseAdAdapter = s0Var.f3762a;
                if (baseAdAdapter == null || (bVar = s0Var.f3763b) == null || (vlionAdapterADConfig = s0Var.f3764c) == null) {
                    return;
                }
                p0 p0Var = s0Var.f3766e;
                Activity activity = p0Var.f3591b;
                p0Var.e(baseAdAdapter, s0Var.f3765d, bVar, vlionAdapterADConfig);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public s0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3766e = p0Var;
        this.f3762a = baseAdAdapter;
        this.f3763b = bVar;
        this.f3764c = vlionAdapterADConfig;
        this.f3765d = str;
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onFail(String str) {
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onSuccess() {
        VlionHandlerUtils.instant().post(new a());
    }
}
