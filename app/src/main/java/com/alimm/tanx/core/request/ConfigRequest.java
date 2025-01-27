package com.alimm.tanx.core.request;

import android.app.Application;
import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.ConfigRequestBean;
import com.alimm.tanx.core.ad.bean.ConfigResponseBean;
import com.alimm.tanx.core.ad.bean.LogSwitchBean;
import com.alimm.tanx.core.log.tanxc_int;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.orange.bean.TanxConfigTableV2;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.EncryptUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.MD5Utils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SysUtils;

/* loaded from: classes.dex */
public class ConfigRequest extends tanxc_do<ConfigRequestBean, TanxConfigTableV2> implements NotConfused {
    private static final String TAG = "ConfigRequest";

    /* renamed from: com.alimm.tanx.core.request.ConfigRequest$1 */
    public class AnonymousClass1 implements NetWorkCallBack<ConfigResponseBean> {
        final /* synthetic */ NetWorkCallBack tanxc_do;
        final /* synthetic */ RequestBean tanxc_for;
        final /* synthetic */ long tanxc_if;

        public AnonymousClass1(NetWorkCallBack netWorkCallBack, long j10, RequestBean requestBean) {
            netWorkCallBack = netWorkCallBack;
            elapsedRealtime = j10;
            requestBean = requestBean;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            NetWorkCallBack netWorkCallBack = netWorkCallBack;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i10, str, str2);
                TanxCommonUt.sendNewConfigFail(str, SystemClock.elapsedRealtime() - elapsedRealtime, i10, str2, ConfigRequest.this.getReqJson(requestBean));
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(ConfigResponseBean configResponseBean) {
            LogUtils.d(ConfigRequest.TAG, "配置请求成功:" + EncryptUtils.decrypt(configResponseBean.content));
            ConfigRequest.suc(configResponseBean, "", ConfigRequest.this.getReqJson(requestBean), elapsedRealtime, netWorkCallBack);
        }
    }

    public String getReqJson(RequestBean requestBean) {
        return (requestBean == null || requestBean.getJson() == null) ? "" : requestBean.getJson();
    }

    private static void setLogSwitch(LogSwitchBean logSwitchBean) {
        tanxc_int.tanxc_do().tanxc_do(logSwitchBean);
    }

    public static void suc(ConfigResponseBean configResponseBean, String str, String str2, long j10, NetWorkCallBack<TanxConfigTableV2> netWorkCallBack) {
        LogUtils.d(TAG, "suc 线程：" + Thread.currentThread());
        if (netWorkCallBack != null) {
            if (configResponseBean == null || TextUtils.isEmpty(configResponseBean.content)) {
                UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                TanxCommonUt.sendNewConfigFail(configResponseBean.reqId, SystemClock.elapsedRealtime() - j10, utErrorCode.getIntCode(), "ConfigResponseBean解析为空", str2);
                return;
            }
            if (TextUtils.isEmpty(configResponseBean.errorCode)) {
                String str3 = configResponseBean.reqId;
                long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
                UtErrorCode utErrorCode2 = UtErrorCode.CONFIG_SERVER_NOT_CODE;
                TanxCommonUt.sendNewConfigFail(str3, elapsedRealtime, utErrorCode2.getIntCode(), utErrorCode2.getMsg(), str2);
                netWorkCallBack.error(utErrorCode2.getIntCode(), configResponseBean.reqId, utErrorCode2.getMsg());
                return;
            }
            if (!configResponseBean.errorCode.equals("200")) {
                try {
                    int parseInt = Integer.parseInt(configResponseBean.errorCode);
                    TanxCommonUt.sendNewConfigFail(configResponseBean.reqId, SystemClock.elapsedRealtime() - j10, parseInt, configResponseBean.errorMsg, str2);
                    netWorkCallBack.error(parseInt, configResponseBean.reqId, configResponseBean.errorMsg);
                    return;
                } catch (Exception e10) {
                    LogUtils.e(TAG, e10);
                    String str4 = configResponseBean.reqId;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - j10;
                    UtErrorCode utErrorCode3 = UtErrorCode.CONFIG_SERVER_CODE_PARSE_INTEGER_ERROR;
                    TanxCommonUt.sendNewConfigFail(str4, elapsedRealtime2, utErrorCode3.getIntCode(), LogUtils.getStackTraceMessage(e10), str2);
                    netWorkCallBack.error(utErrorCode3.getIntCode(), configResponseBean.reqId, LogUtils.getStackTraceMessage(e10));
                    return;
                }
            }
            setLogSwitch(configResponseBean.logSwitchBean);
            String decrypt = EncryptUtils.decrypt(configResponseBean.content);
            if (TextUtils.isEmpty(decrypt)) {
                String str5 = configResponseBean.reqId;
                long elapsedRealtime3 = SystemClock.elapsedRealtime() - j10;
                UtErrorCode utErrorCode4 = UtErrorCode.DECRYPT_ERROR;
                TanxCommonUt.sendNewConfigFail(str5, elapsedRealtime3, utErrorCode4.getIntCode(), utErrorCode4.getMsg(), str2);
                netWorkCallBack.error(utErrorCode4.getIntCode(), "", utErrorCode4.getMsg());
                return;
            }
            try {
                TanxConfigTableV2 tanxConfigTableV2 = (TanxConfigTableV2) JSON.parseObject(decrypt, TanxConfigTableV2.class);
                if (tanxConfigTableV2 != null) {
                    netWorkCallBack.succ(tanxConfigTableV2);
                    TanxCommonUt.sendNewConfigSuc(configResponseBean.reqId, SystemClock.elapsedRealtime() - j10);
                } else {
                    String str6 = configResponseBean.reqId;
                    long elapsedRealtime4 = SystemClock.elapsedRealtime() - j10;
                    UtErrorCode utErrorCode5 = UtErrorCode.JSON_PARSE_ERROR;
                    TanxCommonUt.sendNewConfigFail(str6, elapsedRealtime4, utErrorCode5.getIntCode(), utErrorCode5.getMsg(), str2);
                    netWorkCallBack.error(utErrorCode5.getIntCode(), "", utErrorCode5.getMsg());
                }
            } catch (Exception e11) {
                LogUtils.e(TAG, e11);
                String str7 = configResponseBean.reqId;
                long elapsedRealtime5 = SystemClock.elapsedRealtime() - j10;
                UtErrorCode utErrorCode6 = UtErrorCode.JSON_PARSE_ERROR;
                TanxCommonUt.sendNewConfigFail(str7, elapsedRealtime5, utErrorCode6.getIntCode(), utErrorCode6.getMsg(), str2);
                netWorkCallBack.error(utErrorCode6.getIntCode(), "", "catch异常：" + utErrorCode6.getMsg());
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean useDeviceIdCache() {
        LogUtils.d(TAG, "useDeviceIdCache");
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public RequestBean buildRequestBean(ConfigRequestBean configRequestBean, NetWorkCallBack<TanxConfigTableV2> netWorkCallBack) {
        LogUtils.d(TAG, "buildRequestBean");
        RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getConfigUrl());
        ConfigRequestBean configRequestBean2 = (ConfigRequestBean) super.buildBaseRequestBeanData(configRequestBean);
        Application appContext = TanxCoreManager.getInstance().getAppContext();
        configRequestBean2.md5_app_key = MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
        configRequestBean2.req_Id = uuid();
        if (configRequestBean2.device == null) {
            ConfigRequestBean.AdDeviceBean adDeviceBean = new ConfigRequestBean.AdDeviceBean();
            configRequestBean2.device = adDeviceBean;
            adDeviceBean.user_agent = AndroidUtils.getUserAgent();
            configRequestBean2.device.android_id = AndroidUtils.getAndroidId();
            ConfigRequestBean.AdDeviceBean adDeviceBean2 = configRequestBean2.device;
            adDeviceBean2.device_type = 0;
            adDeviceBean2.brand = AndroidUtils.getBrand();
            configRequestBean2.device.model = AndroidUtils.getModel();
            configRequestBean2.device.os = 1;
            configRequestBean2.device.osv = AndroidUtils.getSystemVersion();
            configRequestBean2.device.network = NetWorkUtil.getNetworkType(appContext).getKey();
            configRequestBean2.device.operator = NetWorkUtil.getOperatorType(appContext);
            Point screenSize = AndroidUtils.getScreenSize(appContext);
            ConfigRequestBean.AdDeviceBean adDeviceBean3 = configRequestBean2.device;
            adDeviceBean3.width = screenSize.x;
            adDeviceBean3.height = screenSize.y;
            adDeviceBean3.pixel_ratio = AndroidUtils.getDisplayDpi(appContext);
        }
        configRequestBean2.device.installed_app = SysUtils.getInstallStatus();
        configRequestBean2.device.imei = DeviceIdGetUtil.getInstance().getImei();
        configRequestBean2.device.oaid = DeviceIdGetUtil.getInstance().getOaid();
        configRequestBean2.device.clientId = TanxCoreSdk.getConfig().getClientId();
        configRequestBean2.device.widevineId = TanxCoreSdk.getConfig().getWidevineId();
        configRequestBean2.device.pseudoId = TanxCoreSdk.getConfig().getPseudoId();
        configRequestBean2.device.guid = TanxCoreSdk.getConfig().getGuid();
        configRequestBean2.device.orientation = AndroidUtils.getScreenOrientation(appContext);
        if (configRequestBean2.user == null) {
            ConfigRequestBean.AdUserBean adUserBean = new ConfigRequestBean.AdUserBean();
            configRequestBean2.user = adUserBean;
            adUserBean.app_key = TanxCoreSdk.getConfig().getAppKey();
        }
        String jSONString = JSON.toJSONString(configRequestBean2);
        LogUtils.d(TAG, jSONString);
        buildBaseRequestBeanUrl.setJson(jSONString);
        return buildBaseRequestBeanUrl;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkDeviceId(ConfigRequestBean configRequestBean) {
        ConfigRequestBean.AdDeviceBean adDeviceBean;
        LogUtils.d(TAG, "checkDeviceId");
        if (configRequestBean == null || (adDeviceBean = configRequestBean.device) == null) {
            return false;
        }
        return (TextUtils.isEmpty(adDeviceBean.imei) && TextUtils.isEmpty(configRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkInitData(ConfigRequestBean configRequestBean, NetWorkCallBack<TanxConfigTableV2> netWorkCallBack) {
        LogUtils.d(TAG, "checkInitData");
        return configRequestBean != null;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkRequestBefore(ConfigRequestBean configRequestBean, NetWorkCallBack<TanxConfigTableV2> netWorkCallBack) {
        ConfigRequestBean.AdUserBean adUserBean;
        LogUtils.d(TAG, "checkRequestBefore");
        if (configRequestBean == null || (adUserBean = configRequestBean.user) == null || !TextUtils.isEmpty(adUserBean.app_key)) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.APP_KEY_NULL;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void request(ConfigRequestBean configRequestBean, NetWorkCallBack<TanxConfigTableV2> netWorkCallBack) {
        LogUtils.d(TAG, "request");
        super.request((ConfigRequest) configRequestBean, (NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void sendRequest(ConfigRequestBean configRequestBean, RequestBean requestBean, NetWorkCallBack<TanxConfigTableV2> netWorkCallBack) {
        NetWorkManager.getInstance().sendHttpPost(requestBean, ConfigResponseBean.class, false, new NetWorkCallBack<ConfigResponseBean>() { // from class: com.alimm.tanx.core.request.ConfigRequest.1
            final /* synthetic */ NetWorkCallBack tanxc_do;
            final /* synthetic */ RequestBean tanxc_for;
            final /* synthetic */ long tanxc_if;

            public AnonymousClass1(NetWorkCallBack netWorkCallBack2, long j10, RequestBean requestBean2) {
                netWorkCallBack = netWorkCallBack2;
                elapsedRealtime = j10;
                requestBean = requestBean2;
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                if (netWorkCallBack2 != null) {
                    netWorkCallBack2.error(i10, str, str2);
                    TanxCommonUt.sendNewConfigFail(str, SystemClock.elapsedRealtime() - elapsedRealtime, i10, str2, ConfigRequest.this.getReqJson(requestBean));
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(ConfigResponseBean configResponseBean) {
                LogUtils.d(ConfigRequest.TAG, "配置请求成功:" + EncryptUtils.decrypt(configResponseBean.content));
                ConfigRequest.suc(configResponseBean, "", ConfigRequest.this.getReqJson(requestBean), elapsedRealtime, netWorkCallBack);
            }
        });
    }
}
