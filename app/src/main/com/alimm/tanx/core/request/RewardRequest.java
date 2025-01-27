package com.alimm.tanx.core.request;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;
import com.alimm.tanx.core.ad.bean.RewardResponse;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

/* loaded from: classes.dex */
public class RewardRequest extends tanxc_do<RewardRequestBean, RewardResponse> implements NotConfused {
    private static final String TAG = "RewardRequest";

    /* renamed from: com.alimm.tanx.core.request.RewardRequest$1 */
    public class AnonymousClass1 implements NetWorkCallBack<RewardResponse> {
        final /* synthetic */ NetWorkCallBack tanxc_do;
        final /* synthetic */ RequestBean tanxc_for;
        final /* synthetic */ long tanxc_if;
        final /* synthetic */ RewardRequestBean tanxc_int;

        public AnonymousClass1(NetWorkCallBack netWorkCallBack, long j10, RequestBean requestBean, RewardRequestBean rewardRequestBean) {
            netWorkCallBack = netWorkCallBack;
            elapsedRealtime = j10;
            requestBean = requestBean;
            rewardRequestBean = rewardRequestBean;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            NetWorkCallBack netWorkCallBack = netWorkCallBack;
            if (netWorkCallBack != null) {
                netWorkCallBack.error(i10, str, str2);
                long elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                RequestBean requestBean = requestBean;
                TanxCommonUt.sendRewardRqFail(str, elapsedRealtime, i10, str2, requestBean == null ? "" : requestBean.getJson());
            }
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(RewardResponse rewardResponse) {
            Integer triggerEvent = RewardRequest.this.getTriggerEvent(rewardRequestBean);
            RequestBean requestBean = requestBean;
            RewardRequest.suc(rewardResponse, triggerEvent, requestBean == null ? "" : requestBean.getJson(), elapsedRealtime, netWorkCallBack);
        }
    }

    public Integer getTriggerEvent(RewardRequestBean rewardRequestBean) {
        if (rewardRequestBean != null) {
            return rewardRequestBean.trigger_event;
        }
        return null;
    }

    public static void suc(RewardResponse rewardResponse, Integer num, String str, long j10, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        if (netWorkCallBack != null) {
            if (rewardResponse == null) {
                UtErrorCode utErrorCode = UtErrorCode.DATA_PARSE_ERROR;
                netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
                TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j10, utErrorCode.getIntCode(), "RewardResponse解析为空", str);
                return;
            }
            if (rewardResponse.getStatus() != 1) {
                if (rewardResponse.getStatus() == 0) {
                    netWorkCallBack.succ(rewardResponse);
                    TanxCommonUt.sendRewardRqSuc(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j10, rewardResponse);
                    return;
                } else {
                    int status = rewardResponse.getStatus();
                    netWorkCallBack.error(status, rewardResponse.getRequestId(), "查询服务端错误码信息");
                    TanxCommonUt.sendRewardRqFail(rewardResponse.getRequestId(), SystemClock.elapsedRealtime() - j10, status, "查询服务端错误码信息", str);
                    return;
                }
            }
            LogUtils.d(TAG, "loopReward过程状态码为1");
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 3) {
                    UtErrorCode utErrorCode2 = UtErrorCode.REWARD_QUERY_NULL;
                    netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg() + ",server_code:1");
                }
            }
        }
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkRequestBefore(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean useDeviceIdCache() {
        return false;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public RequestBean buildRequestBean(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        RequestBean buildBaseRequestBeanUrl = super.buildBaseRequestBeanUrl(C.getRewardUrl());
        String jSONString = JSON.toJSONString(super.buildBaseRequestBeanData(rewardRequestBean));
        LogUtils.d(TAG, jSONString);
        buildBaseRequestBeanUrl.setJson(jSONString);
        return buildBaseRequestBeanUrl;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkDeviceId(RewardRequestBean rewardRequestBean) {
        RequestBaseBean.AdDeviceBean adDeviceBean;
        if (rewardRequestBean == null || (adDeviceBean = rewardRequestBean.device) == null) {
            return false;
        }
        return (TextUtils.isEmpty(adDeviceBean.imei) && TextUtils.isEmpty(rewardRequestBean.device.oaid)) ? false : true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public boolean checkInitData(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        RewardRequestBean.RewardUserBean rewardUserBean;
        if (rewardRequestBean == null || (rewardUserBean = rewardRequestBean.user) == null || checkStrNull(rewardUserBean.media_uid)) {
            UtErrorCode utErrorCode = UtErrorCode.MEDIA_UID_NULL;
            netWorkCallBack.error(utErrorCode.getIntCode(), "", utErrorCode.getMsg());
            return true;
        }
        List<RewardRequestBean.PidVerifications> list = rewardRequestBean.task_check;
        if (list == null || list.size() <= 0) {
            UtErrorCode utErrorCode2 = UtErrorCode.PID_NULL;
            netWorkCallBack.error(utErrorCode2.getIntCode(), "", utErrorCode2.getMsg());
            return false;
        }
        for (int i10 = 0; i10 < rewardRequestBean.task_check.size(); i10++) {
            if (rewardRequestBean.task_check.get(i10) == null || TextUtils.isEmpty(rewardRequestBean.task_check.get(i10).pid)) {
                UtErrorCode utErrorCode3 = UtErrorCode.PID_NULL;
                netWorkCallBack.error(utErrorCode3.getIntCode(), "", utErrorCode3.getMsg());
                return false;
            }
        }
        return true;
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void request(RewardRequestBean rewardRequestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        super.request((RewardRequest) rewardRequestBean, (NetWorkCallBack) netWorkCallBack);
    }

    @Override // com.alimm.tanx.core.request.tanxc_do
    public void sendRequest(RewardRequestBean rewardRequestBean, RequestBean requestBean, NetWorkCallBack<RewardResponse> netWorkCallBack) {
        NetWorkManager.getInstance().sendHttpPost(requestBean, RewardResponse.class, new NetWorkCallBack<RewardResponse>() { // from class: com.alimm.tanx.core.request.RewardRequest.1
            final /* synthetic */ NetWorkCallBack tanxc_do;
            final /* synthetic */ RequestBean tanxc_for;
            final /* synthetic */ long tanxc_if;
            final /* synthetic */ RewardRequestBean tanxc_int;

            public AnonymousClass1(NetWorkCallBack netWorkCallBack2, long j10, RequestBean requestBean2, RewardRequestBean rewardRequestBean2) {
                netWorkCallBack = netWorkCallBack2;
                elapsedRealtime = j10;
                requestBean = requestBean2;
                rewardRequestBean = rewardRequestBean2;
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                NetWorkCallBack netWorkCallBack2 = netWorkCallBack;
                if (netWorkCallBack2 != null) {
                    netWorkCallBack2.error(i10, str, str2);
                    long elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                    RequestBean requestBean2 = requestBean;
                    TanxCommonUt.sendRewardRqFail(str, elapsedRealtime, i10, str2, requestBean2 == null ? "" : requestBean2.getJson());
                }
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(RewardResponse rewardResponse) {
                Integer triggerEvent = RewardRequest.this.getTriggerEvent(rewardRequestBean);
                RequestBean requestBean2 = requestBean;
                RewardRequest.suc(rewardResponse, triggerEvent, requestBean2 == null ? "" : requestBean2.getJson(), elapsedRealtime, netWorkCallBack);
            }
        });
    }
}
