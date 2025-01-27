package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter;
import cn.vlion.ad.inland.base.network.HttpConfigCallBack;
import cn.vlion.ad.inland.base.network.VlionHttpNetCallBack;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;

/* loaded from: classes.dex */
public final class o implements VlionHttpNetCallBack {

    /* renamed from: a */
    public final /* synthetic */ HttpConfigCallBack f3713a;

    /* renamed from: b */
    public final /* synthetic */ String f3714b;

    public o(cn.vlion.ad.inland.core.init.a aVar, String str) {
        this.f3713a = aVar;
        this.f3714b = str;
    }

    @Override // cn.vlion.ad.inland.base.network.VlionHttpNetCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError, VlionADNetBodyParameter vlionADNetBodyParameter) {
        StringBuilder a10 = f.a("VlionCoreNetWorkProxy onFailure: ");
        a10.append(vlionAdBaseError.getErrorMessage());
        LogVlion.e(a10.toString());
        HttpConfigCallBack httpConfigCallBack = this.f3713a;
        if (httpConfigCallBack != null) {
            httpConfigCallBack.onFail(vlionAdBaseError);
        }
        if (vlionADNetBodyParameter != null) {
            VlionADEventManager.uploadNetEvent(vlionADNetBodyParameter);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x022f, code lost:
    
        if (r2 != null) goto L230;
     */
    @Override // cn.vlion.ad.inland.base.network.VlionHttpNetCallBack
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onSuccess(java.lang.String r9, cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter r10) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.core.o.onSuccess(java.lang.String, cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter):void");
    }
}
