package com.alimm.tanx.core.request;

import android.app.Application;
import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.ConfigRequestBean;
import com.alimm.tanx.core.ad.bean.LogSwitchBean;
import com.alimm.tanx.core.ad.bean.LogSwitchResponseBean;
import com.alimm.tanx.core.ad.bean.RequestUploadLogSwitchBean;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.MD5Utils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SysUtils;

/* loaded from: classes.dex */
public class UploadLogSwitchRequest extends tanxc_do<RequestUploadLogSwitchBean, LogSwitchBean> implements NotConfused {
    private static final String TAG = "UploadLogSwitchRequest";

    /* renamed from: com.alimm.tanx.core.request.UploadLogSwitchRequest$1 */
    public class AnonymousClass1 implements NetWorkCallBack<LogSwitchResponseBean> {
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
                TanxCommonUt.sendNewConfigFail(str, SystemClock.elapsedRealtime() - elapsedRealtime, i10, str2, UploadLogSwitchRequest.this.getReqJson(requestBean));
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(LogSwitchResponseBean logSwitchResponseBean) {
            UploadLogSwitchRequest.suc(logSwitchResponseBean, "", UploadLogSwitchRequest.this.getReqJson(requestBean), elapsedRealtime, netWorkCallBack);
        }
    }

    public String getReqJson(RequestBean requestBean) {
        return (requestBean == null || requestBean.getJson() == null) ? "" : requestBean.getJson();
    }

    public static void suc(LogSwitchResponseBean logSwitchResponseBean, String str, String str2, long j10, NetWorkCallBack<LogSwitchBean> netWorkCallBack) {
        if (netWorkCallBack != null) {
            if (logSwitchResponseBean == null) {
                UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                return;
            }
            if (TextUtils.isEmpty(logSwitchResponseBean.errorCode)) {
                UtErrorCode utErrorCode2 = UtErrorCode.CONFIG_SERVER_NOT_CODE;
                netWorkCallBack.error(utErrorCode2.getIntCode(), logSwitchResponseBean.reqId, utErrorCode2.getMsg());
                return;
            }
            if (!logSwitchResponseBean.errorCode.equals("200")) {
                try {
                    netWorkCallBack.error(Integer.parseInt(logSwitchResponseBean.errorCode), logSwitchResponseBean.reqId, logSwitchResponseBean.errorMsg);
                    return;
                } catch (Exception e10) {
                    Log.e(TAG, LogUtils.getStackTraceMessage(e10));
                    netWorkCallBack.error(UtErrorCode.CONFIG_SERVER_CODE_PARSE_INTEGER_ERROR.getIntCode(), logSwitchResponseBean.reqId, LogUtils.getStackTraceMessage(e10));
                    return;
                }
            }
            try {
                LogSwitchBean logSwitchBean = logSwitchResponseBean.logSwitchBean;
                if (logSwitchBean != null) {
                    netWorkCallBack.succ(logSwitchBean);
                } else {
                    UtErrorCode utErrorCode3 = UtErrorCode.JSON_PARSE_ERROR;
                    netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
                }
            } catch (Exception e11) {
                Log.e(TAG, LogUtils.getStackTraceMessage(e11));
                UtErrorCode utErrorCode4 = UtErrorCode.JSON_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode4.getIntCode(), "", "catch异常：" + utErrorCode4.getMsg());
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkInitData(RequestUploadLogSwitchBean requestUploadLogSwitchBean, NetWorkCallBack<LogSwitchBean> netWorkCallBack) {
        return requestUploadLogSwitchBean != null;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean useDeviceIdCache() {
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public RequestBean buildRequestBean(RequestUploadLogSwitchBean requestUploadLogSwitchBean, NetWorkCallBack<LogSwitchBean> netWorkCallBack) {
        RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getUploadLogSwitchUrl());
        ConfigRequestBean configRequestBean = (ConfigRequestBean) super.buildBaseRequestBeanData(requestUploadLogSwitchBean);
        Application appContext = TanxCoreManager.getInstance().getAppContext();
        configRequestBean.md5_app_key = MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
        configRequestBean.req_Id = uuid();
        if (configRequestBean.device == null) {
            ConfigRequestBean.AdDeviceBean adDeviceBean = new ConfigRequestBean.AdDeviceBean();
            configRequestBean.device = adDeviceBean;
            adDeviceBean.user_agent = AndroidUtils.getUserAgent();
            configRequestBean.device.android_id = AndroidUtils.getAndroidId();
            ConfigRequestBean.AdDeviceBean adDeviceBean2 = configRequestBean.device;
            adDeviceBean2.device_type = 0;
            adDeviceBean2.brand = AndroidUtils.getBrand();
            configRequestBean.device.model = AndroidUtils.getModel();
            configRequestBean.device.os = 1;
            configRequestBean.device.osv = AndroidUtils.getSystemVersion();
            configRequestBean.device.network = NetWorkUtil.getNetworkType(appContext).getKey();
            configRequestBean.device.operator = NetWorkUtil.getOperatorType(appContext);
            Point screenSize = AndroidUtils.getScreenSize(appContext);
            ConfigRequestBean.AdDeviceBean adDeviceBean3 = configRequestBean.device;
            adDeviceBean3.width = screenSize.x;
            adDeviceBean3.height = screenSize.y;
            adDeviceBean3.pixel_ratio = AndroidUtils.getDisplayDpi(appContext);
        }
        configRequestBean.device.installed_app = SysUtils.getInstallStatus();
        configRequestBean.device.imei = DeviceIdGetUtil.getInstance().getImei();
        configRequestBean.device.oaid = DeviceIdGetUtil.getInstance().getOaid();
        configRequestBean.device.clientId = TanxCoreSdk.getConfig().getClientId();
        configRequestBean.device.widevineId = TanxCoreSdk.getConfig().getWidevineId();
        configRequestBean.device.pseudoId = TanxCoreSdk.getConfig().getPseudoId();
        configRequestBean.device.guid = TanxCoreSdk.getConfig().getGuid();
        configRequestBean.device.orientation = AndroidUtils.getScreenOrientation(appContext);
        if (configRequestBean.user == null) {
            ConfigRequestBean.AdUserBean adUserBean = new ConfigRequestBean.AdUserBean();
            configRequestBean.user = adUserBean;
            adUserBean.app_key = TanxCoreSdk.getConfig().getAppKey();
        }
        buildBaseRequestBeanUrl.setJson(JSON.toJSONString(configRequestBean));
        return buildBaseRequestBeanUrl;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkDeviceId(RequestUploadLogSwitchBean requestUploadLogSwitchBean) {
        ConfigRequestBean.AdDeviceBean adDeviceBean;
        if (requestUploadLogSwitchBean == null || (adDeviceBean = ((ConfigRequestBean) requestUploadLogSwitchBean).device) == null) {
            return false;
        }
        return (TextUtils.isEmpty(adDeviceBean.imei) && TextUtils.isEmpty(((ConfigRequestBean) requestUploadLogSwitchBean).device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkRequestBefore(RequestUploadLogSwitchBean requestUploadLogSwitchBean, NetWorkCallBack<LogSwitchBean> netWorkCallBack) {
        ConfigRequestBean.AdUserBean adUserBean;
        if (requestUploadLogSwitchBean == null || (adUserBean = requestUploadLogSwitchBean.user) == null || !TextUtils.isEmpty(adUserBean.app_key)) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.APP_KEY_NULL;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void request(RequestUploadLogSwitchBean requestUploadLogSwitchBean, NetWorkCallBack<LogSwitchBean> netWorkCallBack) {
        super.request((UploadLogSwitchRequest) requestUploadLogSwitchBean, (NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void sendRequest(RequestUploadLogSwitchBean requestUploadLogSwitchBean, RequestBean requestBean, NetWorkCallBack<LogSwitchBean> netWorkCallBack) {
        NetWorkManager.getInstance().sendHttpPost(requestBean, LogSwitchResponseBean.class, false, new NetWorkCallBack<LogSwitchResponseBean>() { // from class: com.alimm.tanx.core.request.UploadLogSwitchRequest.1
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
                    TanxCommonUt.sendNewConfigFail(str, SystemClock.elapsedRealtime() - elapsedRealtime, i10, str2, UploadLogSwitchRequest.this.getReqJson(requestBean));
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(LogSwitchResponseBean logSwitchResponseBean) {
                UploadLogSwitchRequest.suc(logSwitchResponseBean, "", UploadLogSwitchRequest.this.getReqJson(requestBean), elapsedRealtime, netWorkCallBack);
            }
        });
    }
}
