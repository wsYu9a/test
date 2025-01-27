package cn.vlion.ad.inland.core;

import android.app.Activity;
import cn.vlion.ad.inland.base.adapter.BaseAdAdapter;
import cn.vlion.ad.inland.base.init.VlionMediaInitCallback;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;

/* loaded from: classes.dex */
public final class w0 implements VlionMediaInitCallback {

    /* renamed from: a */
    public final /* synthetic */ BaseAdAdapter f3796a;

    /* renamed from: b */
    public final /* synthetic */ b f3797b;

    /* renamed from: c */
    public final /* synthetic */ VlionAdapterADConfig f3798c;

    /* renamed from: d */
    public final /* synthetic */ String f3799d;

    /* renamed from: e */
    public final /* synthetic */ p0 f3800e;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            b bVar;
            VlionAdapterADConfig vlionAdapterADConfig;
            try {
                w0 w0Var = w0.this;
                BaseAdAdapter baseAdAdapter = w0Var.f3796a;
                if (baseAdAdapter == null || (bVar = w0Var.f3797b) == null || (vlionAdapterADConfig = w0Var.f3798c) == null) {
                    return;
                }
                p0 p0Var = w0Var.f3800e;
                Activity activity = p0Var.f3591b;
                p0Var.c(baseAdAdapter, w0Var.f3799d, bVar, vlionAdapterADConfig);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public w0(BaseAdAdapter baseAdAdapter, VlionAdapterADConfig vlionAdapterADConfig, p0 p0Var, b bVar, String str) {
        this.f3800e = p0Var;
        this.f3796a = baseAdAdapter;
        this.f3797b = bVar;
        this.f3798c = vlionAdapterADConfig;
        this.f3799d = str;
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onFail(String str) {
    }

    @Override // cn.vlion.ad.inland.base.init.VlionMediaInitCallback
    public final void onSuccess() {
        VlionHandlerUtils.instant().post(new a());
    }
}
