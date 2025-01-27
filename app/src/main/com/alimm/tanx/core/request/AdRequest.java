package com.alimm.tanx.core.request;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.constant.TanxAdType;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.AdNetWorkCallBack;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.AdRequestBean;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AdRequest extends tanxc_do<AdRequestBean, AdInfo> implements NotConfused {
    private static final String TAG = "AdRequest";

    /* renamed from: com.alimm.tanx.core.request.AdRequest$1 */
    public class AnonymousClass1 implements AdNetWorkCallBack<AdInfo> {
        final /* synthetic */ NetWorkCallBack tanxc_do;
        final /* synthetic */ long tanxc_for;
        final /* synthetic */ AdRequestBean tanxc_if;
        final /* synthetic */ RequestBean tanxc_int;

        public AnonymousClass1(NetWorkCallBack netWorkCallBack, AdRequestBean adRequestBean, long j10, RequestBean requestBean) {
            netWorkCallBack = netWorkCallBack;
            adRequestBean = adRequestBean;
            elapsedRealtime = j10;
            requestBean = requestBean;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            NetWorkCallBack netWorkCallBack = netWorkCallBack;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i10, str, str2);
                TanxCommonUt.sendAdRqFail(AdRequest.this.getScene(adRequestBean), AdRequest.this.getPid(adRequestBean), AdRequest.this.getReqId(adRequestBean), SystemClock.elapsedRealtime() - elapsedRealtime, i10, str2, AdRequest.this.getReqJson(requestBean));
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(AdInfo adInfo) {
            AdRequest adRequest = AdRequest.this;
            adRequest.suc(adInfo, "", adRequest.getReqJson(requestBean), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean), AdRequest.this.getScene(adRequestBean), AdRequest.this.getReqId(adRequestBean), netWorkCallBack);
        }

        @Override // com.alimm.tanx.core.net.callback.AdNetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(AdInfo adInfo, String str) {
            AdRequest adRequest = AdRequest.this;
            adRequest.suc(adInfo, str, adRequest.getReqJson(requestBean), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean), AdRequest.this.getScene(adRequestBean), AdRequest.this.getReqId(adRequestBean), netWorkCallBack);
        }
    }

    public TanxAdSlot getAdSlot(AdRequestBean adRequestBean) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) {
            return null;
        }
        return tanxAdSlot;
    }

    public String getPid(AdRequestBean adRequestBean) {
        return getAdSlot(adRequestBean) != null ? getAdSlot(adRequestBean).getPid() : "";
    }

    public String getReqId(AdRequestBean adRequestBean) {
        return adRequestBean != null ? adRequestBean.f6313id : "";
    }

    public String getReqJson(RequestBean requestBean) {
        return (requestBean == null || requestBean.getJson() == null) ? "" : requestBean.getJson();
    }

    public String getScene(AdRequestBean adRequestBean) {
        TanxAdSlot tanxAdSlot;
        return (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) ? "未知" : TanxAdType.getAdTypeStr(tanxAdSlot.getAdType());
    }

    public void suc(AdInfo adInfo, String str, String str2, long j10, TanxAdSlot tanxAdSlot, String str3, String str4, NetWorkCallBack<AdInfo> netWorkCallBack) {
        if (netWorkCallBack != null) {
            if (adInfo == null) {
                UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, SystemClock.elapsedRealtime() - j10, utErrorCode.getIntCode(), utErrorCode.getMsg(), str2);
            } else if (adInfo.getStatus() == 0) {
                adInfo.setDecrypt(str);
                netWorkCallBack.succ(AdParse.tanxc_do(adInfo));
                TanxCommonUt.sendAdRqSuc(str3, tanxAdSlot, adInfo.getRequestId(), SystemClock.elapsedRealtime() - j10, adInfo.getAdCount(), adInfo);
            } else {
                int status = adInfo.getStatus();
                String msg = status == 1 ? UtErrorCode.SERVER_RETURN_1.getMsg() : UtErrorCode.SERVER_RETURN_ERROR.getMsg();
                netWorkCallBack.error(status, adInfo.getRequestId(), msg);
                TanxCommonUt.sendAdRqFail(str3, tanxAdSlot.getPid(), str4, SystemClock.elapsedRealtime() - j10, status, msg, str2);
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkRequestBefore(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean useDeviceIdCache() {
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public RequestBean buildRequestBean(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        try {
            RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getAdUrl());
            AdRequestBean adRequestBean2 = (AdRequestBean) super.buildBaseRequestBeanData(adRequestBean);
            adRequestBean2.imp = new ArrayList();
            int i10 = 1;
            int max = Math.max(adRequestBean2.tanxAdSlot.getAdCount(), 1);
            if (adRequestBean2.tanxAdSlot.getAdCount() > 10) {
                max = 10;
            }
            for (int i11 = 0; i11 < max; i11++) {
                AdRequestBean.AdImpBean adImpBean = new AdRequestBean.AdImpBean();
                adImpBean.pid = adRequestBean2.tanxAdSlot.getPid();
                adImpBean.native_template_id = adRequestBean2.tanxAdSlot.getNativeTemplateId();
                adImpBean.slot_num = 1;
                adImpBean.f6319id = String.valueOf(i11);
                adImpBean.top_creatives = adRequestBean2.tanxAdSlot.getTopCreatives();
                adRequestBean2.imp.add(adImpBean);
            }
            if (adRequestBean2.user == null) {
                adRequestBean2.user = new AdRequestBean.AdUserBean();
            }
            adRequestBean2.user.user_tag = TanxCoreSdk.getConfig().getUserTag();
            adRequestBean2.user.media_uid = adRequestBean2.tanxAdSlot.getMediaUid();
            adRequestBean2.ext = adRequestBean2.tanxAdSlot.getExt();
            adRequestBean2.https_required = true;
            adRequestBean2.version = 1;
            if (!adRequestBean2.tanxAdSlot.isExpressRender()) {
                i10 = 2;
            }
            adRequestBean2.render_type = i10;
            adRequestBean2.is_realtime_request = adRequestBean2.tanxAdSlot.getRealtimeRequest();
            String jSONString = JSON.toJSONString(adRequestBean2);
            LogUtils.d(TAG, jSONString);
            buildBaseRequestBeanUrl.setJson(jSONString);
            return buildBaseRequestBeanUrl;
        } catch (Exception e10) {
            LogUtils.e(TAG, e10);
            return null;
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkDeviceId(AdRequestBean adRequestBean) {
        RequestBaseBean.AdDeviceBean adDeviceBean;
        if (adRequestBean == null || (adDeviceBean = adRequestBean.device) == null) {
            return false;
        }
        return (TextUtils.isEmpty(adDeviceBean.imei) && TextUtils.isEmpty(adRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkInitData(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        TanxAdSlot tanxAdSlot;
        if (adRequestBean == null || (tanxAdSlot = adRequestBean.tanxAdSlot) == null) {
            UtErrorCode utErrorCode = UtErrorCode.REQUEST_BEAN_ERROR;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg() + " :adRequestBean");
            return false;
        }
        if (TextUtils.isEmpty(tanxAdSlot.getPid())) {
            UtErrorCode utErrorCode2 = UtErrorCode.PID_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return false;
        }
        if (!TextUtils.isEmpty(adRequestBean.tanxAdSlot.getMediaUid())) {
            return true;
        }
        if (adRequestBean.tanxAdSlot.getAdType() != 4 && adRequestBean.tanxAdSlot.getAdType() != 3) {
            return true;
        }
        UtErrorCode utErrorCode3 = UtErrorCode.MEDIA_UID_NULL;
        netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void request(AdRequestBean adRequestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        super.request((AdRequest) adRequestBean, (NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void sendRequest(AdRequestBean adRequestBean, RequestBean requestBean, NetWorkCallBack<AdInfo> netWorkCallBack) {
        NetWorkManager.getInstance().sendHttpPost(requestBean, AdInfo.class, new AdNetWorkCallBack<AdInfo>() { // from class: com.alimm.tanx.core.request.AdRequest.1
            final /* synthetic */ NetWorkCallBack tanxc_do;
            final /* synthetic */ long tanxc_for;
            final /* synthetic */ AdRequestBean tanxc_if;
            final /* synthetic */ RequestBean tanxc_int;

            public AnonymousClass1(NetWorkCallBack netWorkCallBack2, AdRequestBean adRequestBean2, long j10, RequestBean requestBean2) {
                netWorkCallBack = netWorkCallBack2;
                adRequestBean = adRequestBean2;
                elapsedRealtime = j10;
                requestBean = requestBean2;
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                if (netWorkCallBack2 != null) {
                    netWorkCallBack2.error(i10, str, str2);
                    TanxCommonUt.sendAdRqFail(AdRequest.this.getScene(adRequestBean), AdRequest.this.getPid(adRequestBean), AdRequest.this.getReqId(adRequestBean), SystemClock.elapsedRealtime() - elapsedRealtime, i10, str2, AdRequest.this.getReqJson(requestBean));
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(AdInfo adInfo) {
                AdRequest adRequest = AdRequest.this;
                adRequest.suc(adInfo, "", adRequest.getReqJson(requestBean), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean), AdRequest.this.getScene(adRequestBean), AdRequest.this.getReqId(adRequestBean), netWorkCallBack);
            }

            @Override // com.alimm.tanx.core.net.callback.AdNetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(AdInfo adInfo, String str) {
                AdRequest adRequest = AdRequest.this;
                adRequest.suc(adInfo, str, adRequest.getReqJson(requestBean), elapsedRealtime, AdRequest.this.getAdSlot(adRequestBean), AdRequest.this.getScene(adRequestBean), AdRequest.this.getReqId(adRequestBean), netWorkCallBack);
            }
        });
    }
}
