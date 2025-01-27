package cn.vlion.ad.inland.core.init;

import cn.vlion.ad.inland.base.javabean.VlionServiceConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.network.HttpConfigCallBack;
import cn.vlion.ad.inland.base.util.VlionAdLimitStrategyUtils;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.down.VlionAdDownStrategyUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.core.d0;
import cn.vlion.ad.inland.core.f;
import cn.vlion.ad.inland.core.i0;
import cn.vlion.ad.inland.core.init.b;

/* loaded from: classes.dex */
public final class a implements HttpConfigCallBack<VlionServiceConfig> {

    /* renamed from: a */
    public final /* synthetic */ b.InterfaceC0029b f3635a;

    public a(d0.a aVar) {
        this.f3635a = aVar;
    }

    @Override // cn.vlion.ad.inland.base.network.HttpConfigCallBack
    public final void onFail(VlionAdBaseError vlionAdBaseError) {
        StringBuilder a10 = f.a("VlionSDkConfig getAdData  onFail  (null == vlionServiceConfigParse)=");
        a10.append(this.f3635a == null);
        LogVlion.e(a10.toString());
        b.InterfaceC0029b interfaceC0029b = this.f3635a;
        if (interfaceC0029b != null) {
            ((d0.a) interfaceC0029b).a(vlionAdBaseError);
        }
    }

    @Override // cn.vlion.ad.inland.base.network.HttpConfigCallBack
    public final void onSuccess(String str, VlionServiceConfig vlionServiceConfig) {
        VlionServiceConfig vlionServiceConfig2 = vlionServiceConfig;
        if (vlionServiceConfig2 != null) {
            try {
                if (vlionServiceConfig2.getCode() == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("VlionSDkConfig getAdData  onSuccess (null == vlionServiceConfigParse)=");
                    sb2.append(this.f3635a == null);
                    LogVlion.e(sb2.toString());
                    VlionServiceConfigParse.getInstance().Parse(str, vlionServiceConfig2);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
                b.InterfaceC0029b interfaceC0029b = this.f3635a;
                if (interfaceC0029b != null) {
                    ((d0.a) interfaceC0029b).a(VlionAdBaseError.Exception_CODE_ERROR);
                    return;
                }
                return;
            }
        }
        VlionSDkManager.getInstance().createWXAPI(VlionServiceConfigParse.getInstance().getWxAppId());
        VlionSDkManager.getInstance().VlionCustomSDkAddReceiver(VlionServiceConfigParse.getInstance().isRegisterAddReceiver());
        VlionServiceConfigParse.getInstance().setLastConfigTime(System.currentTimeMillis());
        b.b();
        VlionAdLimitStrategyUtils.getInstance().regroupAdStrategysIdList(VlionSDkManager.getInstance().getApplication());
        b.InterfaceC0029b interfaceC0029b2 = this.f3635a;
        if (interfaceC0029b2 != null) {
            ((d0.a) interfaceC0029b2).a();
        }
        VlionAdDownStrategyUtils.getInstance().regroupAdDownStrategysIdList(VlionSDkManager.getInstance().getApplication(), new i0());
    }
}
