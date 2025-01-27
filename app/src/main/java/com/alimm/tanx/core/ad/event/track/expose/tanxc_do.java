package com.alimm.tanx.core.ad.event.track.expose;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class tanxc_do implements IExposer {

    /* renamed from: com.alimm.tanx.core.ad.event.track.expose.tanxc_do$1 */
    public class AnonymousClass1 implements NetWorkCallBack {
        final /* synthetic */ String tanxc_do;
        final /* synthetic */ ExposeCallback tanxc_if;

        public AnonymousClass1(String str, ExposeCallback exposeCallback) {
            str2 = str;
            exposeCallback = exposeCallback;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            LogUtils.d("DefaultExposer", str2);
            LogUtils.d("DefaultExposer", str2);
            ExposeCallback exposeCallback = exposeCallback;
            if (exposeCallback != null) {
                exposeCallback.onFail(i10, str2, str2);
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void succ(Object obj) {
            LogUtils.d("DefaultExposer", JSON.toJSONString(obj));
            ExposeCallback exposeCallback = exposeCallback;
            if (exposeCallback != null) {
                exposeCallback.onSucceed(200, str2);
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.event.track.expose.IExposer
    public void onExpose(String str, String str2, ExposeCallback exposeCallback) {
        try {
            RequestBean build = new RequestBean().setUrl(str2).build();
            build.setOverrideError(true);
            exposeCallback.send(str2);
            NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.expose.tanxc_do.1
                final /* synthetic */ String tanxc_do;
                final /* synthetic */ ExposeCallback tanxc_if;

                public AnonymousClass1(String str22, ExposeCallback exposeCallback2) {
                    str2 = str22;
                    exposeCallback = exposeCallback2;
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void error(int i10, String str3, String str22) {
                    LogUtils.d("DefaultExposer", str2);
                    LogUtils.d("DefaultExposer", str22);
                    ExposeCallback exposeCallback2 = exposeCallback;
                    if (exposeCallback2 != null) {
                        exposeCallback2.onFail(i10, str22, str2);
                    }
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void succ(Object obj) {
                    LogUtils.d("DefaultExposer", JSON.toJSONString(obj));
                    ExposeCallback exposeCallback2 = exposeCallback;
                    if (exposeCallback2 != null) {
                        exposeCallback2.onSucceed(200, str2);
                    }
                }
            });
        } catch (Exception e10) {
            e10.printStackTrace();
            LogUtils.d("DefaultExposer", str22);
            if (exposeCallback2 != null) {
                exposeCallback2.onFail(UtErrorCode.CRASH_ERROR.getIntCode(), LogUtils.getStackTraceMessage(e10), str22);
            }
        }
    }
}
