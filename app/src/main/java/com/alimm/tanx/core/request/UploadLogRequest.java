package com.alimm.tanx.core.request;

import android.app.Application;
import android.graphics.Point;
import android.os.SystemClock;
import android.text.TextUtils;
import b7.b;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.log.LogResultBean;
import com.alimm.tanx.core.log.UploadLogRequestBean;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.net.okhttp.callback.OnUploadListener;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.AndroidUtils;
import com.alimm.tanx.core.utils.DeviceIdGetUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.MD5Utils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SysUtils;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;

/* loaded from: classes.dex */
public class UploadLogRequest extends tanxc_do<UploadLogRequestBean, LogResultBean> implements NotConfused {
    private static final String TAG = "UploadLogRequest";

    /* renamed from: com.alimm.tanx.core.request.UploadLogRequest$1 */
    public class AnonymousClass1 implements OnUploadListener {
        final /* synthetic */ NetWorkCallBack tanxc_do;

        public AnonymousClass1(NetWorkCallBack netWorkCallBack) {
            netWorkCallBack = netWorkCallBack;
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnUploadListener
        public void error(int i10, String str) {
            netWorkCallBack.error(i10, "", str);
        }

        @Override // com.alimm.tanx.core.net.okhttp.callback.OnUploadListener
        public void succ(String str) {
            try {
                netWorkCallBack.succ(JSON.parseObject(str, LogResultBean.class));
            } catch (Exception e10) {
                LogResultBean logResultBean = new LogResultBean();
                logResultBean.errorMsg = "json解析异常" + LogUtils.getStackTraceMessage(e10);
                netWorkCallBack.succ(logResultBean);
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean useDeviceIdCache() {
        LogUtils.d(TAG, "useDeviceIdCache");
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public RequestBean buildRequestBean(UploadLogRequestBean uploadLogRequestBean, NetWorkCallBack<LogResultBean> netWorkCallBack) {
        LogUtils.d(TAG, "buildRequestBean");
        RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getUploadLogUrl());
        UploadLogRequestBean uploadLogRequestBean2 = (UploadLogRequestBean) super.buildBaseRequestBeanData(uploadLogRequestBean);
        Application appContext = TanxCoreManager.getInstance().getAppContext();
        uploadLogRequestBean2.md5_app_key = MD5Utils.getMD5String(TanxCoreSdk.getConfig().getAppKey());
        uploadLogRequestBean2.req_Id = uuid();
        if (uploadLogRequestBean2.device == null) {
            UploadLogRequestBean.AdDeviceBean adDeviceBean = new UploadLogRequestBean.AdDeviceBean();
            uploadLogRequestBean2.device = adDeviceBean;
            adDeviceBean.user_agent = AndroidUtils.getUserAgent();
            uploadLogRequestBean2.device.android_id = AndroidUtils.getAndroidId();
            UploadLogRequestBean.AdDeviceBean adDeviceBean2 = uploadLogRequestBean2.device;
            adDeviceBean2.device_type = 0;
            adDeviceBean2.brand = AndroidUtils.getBrand();
            uploadLogRequestBean2.device.model = AndroidUtils.getModel();
            uploadLogRequestBean2.device.os = 1;
            uploadLogRequestBean2.device.osv = AndroidUtils.getSystemVersion();
            uploadLogRequestBean2.device.network = NetWorkUtil.getNetworkType(appContext).getKey();
            uploadLogRequestBean2.device.operator = NetWorkUtil.getOperatorType(appContext);
            Point screenSize = AndroidUtils.getScreenSize(appContext);
            UploadLogRequestBean.AdDeviceBean adDeviceBean3 = uploadLogRequestBean2.device;
            adDeviceBean3.width = screenSize.x;
            adDeviceBean3.height = screenSize.y;
            adDeviceBean3.pixel_ratio = AndroidUtils.getDisplayDpi(appContext);
        }
        uploadLogRequestBean2.device.installed_app = SysUtils.getInstallStatus();
        uploadLogRequestBean2.device.imei = DeviceIdGetUtil.getInstance().getImei();
        uploadLogRequestBean2.device.oaid = DeviceIdGetUtil.getInstance().getOaid(true);
        uploadLogRequestBean2.device.clientId = TanxCoreSdk.getConfig().getClientId();
        uploadLogRequestBean2.device.widevineId = TanxCoreSdk.getConfig().getWidevineId();
        uploadLogRequestBean2.device.pseudoId = TanxCoreSdk.getConfig().getPseudoId();
        uploadLogRequestBean2.device.guid = TanxCoreSdk.getConfig().getGuid();
        uploadLogRequestBean2.device.orientation = AndroidUtils.getScreenOrientation(appContext);
        if (uploadLogRequestBean2.user == null) {
            UploadLogRequestBean.AdUserBean adUserBean = new UploadLogRequestBean.AdUserBean();
            uploadLogRequestBean2.user = adUserBean;
            adUserBean.app_key = TanxCoreSdk.getConfig().getAppKey();
        }
        String jSONString = JSON.toJSONString(uploadLogRequestBean2);
        LogUtils.d(TAG, jSONString);
        buildBaseRequestBeanUrl.setJson(jSONString);
        return buildBaseRequestBeanUrl;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkDeviceId(UploadLogRequestBean uploadLogRequestBean) {
        UploadLogRequestBean.AdDeviceBean adDeviceBean;
        LogUtils.d(TAG, "checkDeviceId");
        if (uploadLogRequestBean == null || (adDeviceBean = uploadLogRequestBean.device) == null) {
            return false;
        }
        return (TextUtils.isEmpty(adDeviceBean.imei) && TextUtils.isEmpty(uploadLogRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkInitData(UploadLogRequestBean uploadLogRequestBean, NetWorkCallBack<LogResultBean> netWorkCallBack) {
        LogUtils.d(TAG, "checkInitData");
        return uploadLogRequestBean != null;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkRequestBefore(UploadLogRequestBean uploadLogRequestBean, NetWorkCallBack<LogResultBean> netWorkCallBack) {
        UploadLogRequestBean.AdUserBean adUserBean;
        LogUtils.d(TAG, "checkRequestBefore");
        if (uploadLogRequestBean == null || (adUserBean = uploadLogRequestBean.user) == null || !TextUtils.isEmpty(adUserBean.app_key)) {
            return true;
        }
        UtErrorCode utErrorCode = UtErrorCode.APP_KEY_NULL;
        netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void request(UploadLogRequestBean uploadLogRequestBean, NetWorkCallBack<LogResultBean> netWorkCallBack) {
        LogUtils.d(TAG, "request");
        super.request((UploadLogRequest) uploadLogRequestBean, (NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void sendRequest(UploadLogRequestBean uploadLogRequestBean, RequestBean requestBean, NetWorkCallBack<LogResultBean> netWorkCallBack) {
        SystemClock.elapsedRealtime();
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId", uploadLogRequestBean.device.oaid);
        hashMap.put(b.Y, uploadLogRequestBean.md5_app_key);
        hashMap.put(bt.f23628x, "1");
        requestBean.setParams(hashMap);
        NetWorkManager.getInstance().uploadFile(requestBean, uploadLogRequestBean.logFile, new OnUploadListener() { // from class: com.alimm.tanx.core.request.UploadLogRequest.1
            final /* synthetic */ NetWorkCallBack tanxc_do;

            public AnonymousClass1(NetWorkCallBack netWorkCallBack2) {
                netWorkCallBack = netWorkCallBack2;
            }

            @Override // com.alimm.tanx.core.net.okhttp.callback.OnUploadListener
            public void error(int i10, String str) {
                netWorkCallBack.error(i10, "", str);
            }

            @Override // com.alimm.tanx.core.net.okhttp.callback.OnUploadListener
            public void succ(String str) {
                try {
                    netWorkCallBack.succ(JSON.parseObject(str, LogResultBean.class));
                } catch (Exception e10) {
                    LogResultBean logResultBean = new LogResultBean();
                    logResultBean.errorMsg = "json解析异常" + LogUtils.getStackTraceMessage(e10);
                    netWorkCallBack.succ(logResultBean);
                }
            }
        });
    }
}
