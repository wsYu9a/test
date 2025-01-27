package com.alimm.tanx.core.request;

import android.app.Application;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.core.SdkConstant;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.SysUtils;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class tanxc_do<Req extends RequestBaseBean, Rep extends BaseBean> {
    private static final String TAG = "BaseRequest";
    private static long localTime;
    private static long sTime;

    /* renamed from: com.alimm.tanx.core.request.tanxc_do$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ RequestBaseBean tanxc_do;
        final /* synthetic */ NetWorkCallBack tanxc_if;

        public AnonymousClass1(RequestBaseBean requestBaseBean, NetWorkCallBack netWorkCallBack) {
            req = requestBaseBean;
            netWorkCallBack = netWorkCallBack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            long unused = tanxc_do.sTime = System.currentTimeMillis();
            try {
                if (tanxc_do.this.checkInitData(req, netWorkCallBack)) {
                    RequestBean buildRequestBean = tanxc_do.this.buildRequestBean(req, netWorkCallBack);
                    if (buildRequestBean == null) {
                        NetWorkCallBack netWorkCallBack = netWorkCallBack;
                        UtErrorCode utErrorCode = UtErrorCode.REQUEST_BEAN_ERROR;
                        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                    } else if (!tanxc_do.this.checkDeviceId(req)) {
                        NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                        UtErrorCode utErrorCode2 = UtErrorCode.APP_DEVICE_NUMBER_NULL;
                        netWorkCallBack2.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
                    } else if (!tanxc_do.this.checkRequestBefore(req, netWorkCallBack)) {
                        Log.d(tanxc_do.TAG, "checkRequestBefore() : false");
                    } else {
                        long unused2 = tanxc_do.localTime = System.currentTimeMillis() - tanxc_do.sTime;
                        tanxc_do.this.sendRequest(req, buildRequestBean, netWorkCallBack);
                    }
                }
            } catch (Exception e10) {
                LogUtils.e(tanxc_do.TAG, e10);
            }
        }
    }

    public Req buildBaseRequestBeanData(Req req) {
        Application appContext = TanxCoreManager.getInstance().getAppContext();
        if (req.app == null) {
            RequestBaseBean.AdAppBean adAppBean = new RequestBaseBean.AdAppBean();
            req.app = adAppBean;
            adAppBean.package_name = AndroidUtils.getPackageName(appContext);
            req.app.app_name = AndroidUtils.getAppName(appContext);
            RequestBaseBean.AdAppBean adAppBean2 = req.app;
            adAppBean2.app_version = AndroidUtils.getAppVersion(appContext, adAppBean2.package_name);
            req.app.sdk_version = SdkConstant.getSdkVersion();
        }
        if (req.device == null) {
            RequestBaseBean.AdDeviceBean adDeviceBean = new RequestBaseBean.AdDeviceBean();
            req.device = adDeviceBean;
            adDeviceBean.user_agent = AndroidUtils.getUserAgent();
            adDeviceBean.android_id = AndroidUtils.getAndroidId();
            adDeviceBean.device_type = 0;
            adDeviceBean.brand = AndroidUtils.getBrand();
            adDeviceBean.model = AndroidUtils.getModel();
            adDeviceBean.os = "Android";
            adDeviceBean.osv = AndroidUtils.getSystemVersion();
            adDeviceBean.network = NetWorkUtil.getNetworkType(appContext).getKey();
            req.device.operator = NetWorkUtil.getOperatorType(appContext);
            Point screenSize = AndroidUtils.getScreenSize(appContext);
            adDeviceBean.width = screenSize.x;
            adDeviceBean.height = screenSize.y;
            adDeviceBean.pixel_ratio = AndroidUtils.getDisplayDpi(appContext);
        }
        req.device.installed_app = SysUtils.getInstallStatus();
        req.device.imei = DeviceIdGetUtil.getInstance().getImei();
        req.device.oaid = DeviceIdGetUtil.getInstance().getOaid();
        req.device.clientId = TanxCoreSdk.getConfig().getClientId();
        req.device.widevineId = TanxCoreSdk.getConfig().getWidevineId();
        req.device.pseudoId = TanxCoreSdk.getConfig().getPseudoId();
        req.device.guid = TanxCoreSdk.getConfig().getGuid();
        req.device.orientation = AndroidUtils.getScreenOrientation(appContext);
        req.f6313id = uuid();
        return req;
    }

    public RequestBean buildBaseRequestBeanUrl(String str) {
        DeviceIdGetUtil.getInstance().getImei(useDeviceIdCache());
        RequestBean build = new RequestBean().setUrl(str).build();
        build.setOverrideError(true);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json; charset=utf-8");
        build.setHeads(hashMap);
        return build;
    }

    public abstract RequestBean buildRequestBean(Req req, NetWorkCallBack<Rep> netWorkCallBack);

    public abstract boolean checkDeviceId(Req req);

    public abstract boolean checkInitData(Req req, NetWorkCallBack<Rep> netWorkCallBack);

    public abstract boolean checkRequestBefore(Req req, NetWorkCallBack<Rep> netWorkCallBack);

    public boolean checkStrNull(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public void request(Req req, NetWorkCallBack<Rep> netWorkCallBack) {
        com.alimm.tanx.core.common.tanxc_do.tanxc_do(new Runnable() { // from class: com.alimm.tanx.core.request.tanxc_do.1
            final /* synthetic */ RequestBaseBean tanxc_do;
            final /* synthetic */ NetWorkCallBack tanxc_if;

            public AnonymousClass1(RequestBaseBean req2, NetWorkCallBack netWorkCallBack2) {
                req = req2;
                netWorkCallBack = netWorkCallBack2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                long unused = tanxc_do.sTime = System.currentTimeMillis();
                try {
                    if (tanxc_do.this.checkInitData(req, netWorkCallBack)) {
                        RequestBean buildRequestBean = tanxc_do.this.buildRequestBean(req, netWorkCallBack);
                        if (buildRequestBean == null) {
                            NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                            UtErrorCode utErrorCode = UtErrorCode.REQUEST_BEAN_ERROR;
                            netWorkCallBack2.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                        } else if (!tanxc_do.this.checkDeviceId(req)) {
                            NetWorkCallBack netWorkCallBack22 = netWorkCallBack;
                            UtErrorCode utErrorCode2 = UtErrorCode.APP_DEVICE_NUMBER_NULL;
                            netWorkCallBack22.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
                        } else if (!tanxc_do.this.checkRequestBefore(req, netWorkCallBack)) {
                            Log.d(tanxc_do.TAG, "checkRequestBefore() : false");
                        } else {
                            long unused2 = tanxc_do.localTime = System.currentTimeMillis() - tanxc_do.sTime;
                            tanxc_do.this.sendRequest(req, buildRequestBean, netWorkCallBack);
                        }
                    }
                } catch (Exception e10) {
                    LogUtils.e(tanxc_do.TAG, e10);
                }
            }
        });
    }

    public abstract void sendRequest(Req req, RequestBean requestBean, NetWorkCallBack<Rep> netWorkCallBack);

    public abstract boolean useDeviceIdCache();

    public String uuid() {
        return UUID.randomUUID().toString().replace("-", "") + "-" + (System.currentTimeMillis() / 1000);
    }
}
