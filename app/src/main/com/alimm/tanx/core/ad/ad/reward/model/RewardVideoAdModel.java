package com.alimm.tanx.core.ad.ad.reward.model;

import android.text.TextUtils;
import com.alimm.tanx.core.ad.ad.reward.IRewardRequestListener;
import com.alimm.tanx.core.ad.ad.reward.tanxc_do;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.bean.RewardRequestBean;
import com.alimm.tanx.core.ad.bean.RewardResponse;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.model.BaseModel;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.RewardRequest;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxInterfaceUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RewardVideoAdModel extends BaseModel {

    /* renamed from: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel$1 */
    public class AnonymousClass1 implements ITanxRequestLoader.ITanxRequestListener {
        final /* synthetic */ TanxAdSlot tanxc_do;
        final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_for;
        final /* synthetic */ long tanxc_if;

        public AnonymousClass1(TanxAdSlot tanxAdSlot, long j10, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            tanxAdSlot = tanxAdSlot;
            currentTimeMillis = j10;
            iTanxRequestListener = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onError(TanxError tanxError) {
            TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, "error", System.currentTimeMillis() - currentTimeMillis);
            ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onError(tanxError);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onSuccess(List list) {
            TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, "success", System.currentTimeMillis() - currentTimeMillis);
            ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onSuccess(list);
            }
        }

        @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
        public void onTimeOut() {
            TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
            ITanxRequestLoader.ITanxRequestListener iTanxRequestListener = iTanxRequestListener;
            if (iTanxRequestListener != null) {
                iTanxRequestListener.onTimeOut();
            }
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel$2 */
    public class AnonymousClass2 implements NetWorkCallBack<RewardResponse> {
        final /* synthetic */ IRewardRequestListener tanxc_do;

        public AnonymousClass2(IRewardRequestListener iRewardRequestListener) {
            iRewardRequestListener = iRewardRequestListener;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            iRewardRequestListener.onError(new TanxError(str, i10, str2));
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(RewardResponse rewardResponse) {
            RewardVideoAdModel.this.loopReward(rewardResponse, iRewardRequestListener);
        }
    }

    public void loopReward(RewardResponse rewardResponse, IRewardRequestListener iRewardRequestListener) {
        if (iRewardRequestListener != null) {
            try {
                if (rewardResponse == null) {
                    String requestId = rewardResponse != null ? rewardResponse.getRequestId() : "";
                    UtErrorCode utErrorCode = UtErrorCode.ERROR_QUERY_REWARD;
                    iRewardRequestListener.onError(new TanxError(requestId, utErrorCode.getIntCode(), utErrorCode.getMsg()));
                    return;
                }
                if (rewardResponse.getPidRewards() == null || rewardResponse.getPidRewards().size() <= 0) {
                    String requestId2 = rewardResponse.getRequestId();
                    UtErrorCode utErrorCode2 = UtErrorCode.REWARD_QUERY_NULL;
                    iRewardRequestListener.onError(new TanxError(requestId2, utErrorCode2.getIntCode(), utErrorCode2.getMsg()));
                    return;
                }
                for (int i10 = 0; i10 < rewardResponse.getPidRewards().size(); i10++) {
                    RewardResponse.PidRewards pidRewards = rewardResponse.getPidRewards().get(i10);
                    int i11 = pidRewards.getTaskType() == 3 ? 1 : 0;
                    HashMap hashMap = new HashMap();
                    hashMap.put(ExposeManager.UtArgsNames.pid, pidRewards.getPid());
                    hashMap.put("taskType", Integer.valueOf(pidRewards.getTaskType()));
                    hashMap.put("sessionId", pidRewards.getSessionId());
                    hashMap.put("completeTime", pidRewards.getCompleteTime());
                    hashMap.put("rewardName", pidRewards.getRewardName());
                    hashMap.put("rewardCount", Integer.valueOf(pidRewards.getRewardCount()));
                    iRewardRequestListener.onRewardArrived(true, i11, hashMap);
                }
            } catch (Exception e10) {
                LogUtils.e("loopReward", e10);
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public String getScene() {
        return "rewardVideo";
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void onSuccess(AdInfo adInfo) {
        if (this.requestListener == null) {
            return;
        }
        if (adInfo != null && !TextUtils.isEmpty(adInfo.getRequestId()) && adInfo.getSeatList() != null && adInfo.getSeatList().size() > 0) {
            if (adInfo.getSeatList().get(0) != null && adInfo.getSeatList().get(0).getBidList() != null && adInfo.getSeatList().get(0).getBidList().size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < adInfo.getSeatList().size(); i10++) {
                    List<BidInfo> bidList = adInfo.getSeatList().get(i10).getBidList();
                    if (bidList != null && bidList.size() > 0) {
                        Iterator<BidInfo> it = bidList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new tanxc_do(this.adSlot, it.next(), adInfo.getRequestId(), getScene()));
                        }
                    }
                }
                this.requestListener.onSuccess(arrayList);
                return;
            }
        }
        this.requestListener.onError(new TanxError(adInfo != null ? adInfo.getRequestId() : "", TanxError.ERROR_ADINFO_ADCOUNT_NULL));
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    public void sendRewardRequest(RewardRequestBean rewardRequestBean, IRewardRequestListener iRewardRequestListener) {
        new RewardRequest().request(rewardRequestBean, (NetWorkCallBack<RewardResponse>) new NetWorkCallBack<RewardResponse>() { // from class: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel.2
            final /* synthetic */ IRewardRequestListener tanxc_do;

            public AnonymousClass2(IRewardRequestListener iRewardRequestListener2) {
                iRewardRequestListener = iRewardRequestListener2;
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            public void error(int i10, String str, String str2) {
                iRewardRequestListener.onError(new TanxError(str, i10, str2));
            }

            @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
            /* renamed from: tanxc_do */
            public void succ(RewardResponse rewardResponse) {
                RewardVideoAdModel.this.loopReward(rewardResponse, iRewardRequestListener);
            }
        });
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel
    public void timerCancelNotify(AdInfo adInfo, boolean z10, int i10) {
        tanxc_do tanxc_doVar = null;
        r0 = null;
        BidInfo bidInfo = null;
        if (adInfo != null) {
            if (adInfo.getBidInfoList() != null && adInfo.getBidInfoList().size() > 0) {
                bidInfo = adInfo.getBidInfoList().get(0);
            }
            tanxc_doVar = new tanxc_do(this.adSlot, bidInfo, adInfo.getRequestId(), getScene());
        }
        TanxCommonUt.utTimer(tanxc_doVar, z10, i10);
    }

    @Override // com.alimm.tanx.core.ad.model.BaseModel, com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        TanxInterfaceUt.sendMethodInvoke(tanxAdSlot.getPid(), TanxInterfaceUt.REQUEST_REWARD_VIDEO);
        super.sendRequest(tanxAdSlot, new ITanxRequestLoader.ITanxRequestListener() { // from class: com.alimm.tanx.core.ad.ad.reward.model.RewardVideoAdModel.1
            final /* synthetic */ TanxAdSlot tanxc_do;
            final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_for;
            final /* synthetic */ long tanxc_if;

            public AnonymousClass1(TanxAdSlot tanxAdSlot2, long currentTimeMillis2, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2) {
                tanxAdSlot = tanxAdSlot2;
                currentTimeMillis = currentTimeMillis2;
                iTanxRequestListener = iTanxRequestListener2;
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onError(TanxError tanxError) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, "error", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onError(tanxError);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onSuccess(List list) {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, "success", System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onSuccess(list);
                }
            }

            @Override // com.alimm.tanx.core.ad.loader.ITanxRequestLoader.ITanxRequestListener
            public void onTimeOut() {
                TanxInterfaceUt.sendMethodCallback(tanxAdSlot, TanxInterfaceUt.REQUEST_REWARD_VIDEO, TanxInterfaceUt.CALLBACK_TIMEOUT, System.currentTimeMillis() - currentTimeMillis);
                ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2 = iTanxRequestListener;
                if (iTanxRequestListener2 != null) {
                    iTanxRequestListener2.onTimeOut();
                }
            }
        }, j10);
    }
}
