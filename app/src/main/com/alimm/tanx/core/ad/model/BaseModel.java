package com.alimm.tanx.core.ad.model;

import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.core.ad.bean.AdInfo;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.listener.model.IModel;
import com.alimm.tanx.core.ad.loader.ITanxRequestLoader;
import com.alimm.tanx.core.ad.loader.TanxRequestLoader;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.request.AdRequest;
import com.alimm.tanx.core.request.AdRequestBean;
import com.alimm.tanx.core.request.TanxAdSlot;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public abstract class BaseModel implements IModel, NotConfused, Runnable {
    protected TanxAdSlot adSlot;
    protected BidInfo bidInfo;
    protected boolean hasRequest;
    protected boolean hasTimeOut;
    protected boolean isCancel;
    protected ITanxRequestLoader.ITanxRequestListener requestListener;
    private final String TAG = "BaseModel";
    protected Handler handler = new Handler(Looper.getMainLooper());
    protected Handler mDelivery = new Handler(Looper.getMainLooper());

    /* renamed from: com.alimm.tanx.core.ad.model.BaseModel$1 */
    public class AnonymousClass1 implements NetWorkCallBack<AdInfo> {
        final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_do;

        public AnonymousClass1(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
            iTanxRequestListener = iTanxRequestListener;
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i10, String str, String str2) {
            LogUtils.e("BaseModel", "发起请求 error=" + str2);
            BaseModel baseModel = BaseModel.this;
            if (baseModel.isCancel || baseModel.hasTimeOut) {
                return;
            }
            baseModel.callBackError(iTanxRequestListener, new TanxError(str, i10, str2));
            BaseModel.this.cancel();
            BaseModel.this.timerCancelNotify(null, true, 0);
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        /* renamed from: tanxc_do */
        public void succ(AdInfo adInfo) {
            LogUtils.d("BaseModel", "发起请求 isCancel=" + BaseModel.this.isCancel + "--- hasTimeOut= " + BaseModel.this.hasTimeOut);
            BaseModel.this.requestSucc(adInfo);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.model.BaseModel$2 */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_do;
        final /* synthetic */ TanxError tanxc_if;

        public AnonymousClass2(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, TanxError tanxError) {
            iTanxRequestListener = iTanxRequestListener;
            tanxError = tanxError;
        }

        @Override // java.lang.Runnable
        public void run() {
            iTanxRequestListener.onError(tanxError);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.model.BaseModel$3 */
    public class AnonymousClass3 implements Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseModel.this.requestListener.onTimeOut();
        }
    }

    public void callBackError(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, TanxError tanxError) {
        if (iTanxRequestListener != null) {
            this.mDelivery.post(new Runnable() { // from class: com.alimm.tanx.core.ad.model.BaseModel.2
                final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_do;
                final /* synthetic */ TanxError tanxc_if;

                public AnonymousClass2(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2, TanxError tanxError2) {
                    iTanxRequestListener = iTanxRequestListener2;
                    tanxError = tanxError2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    iTanxRequestListener.onError(tanxError);
                }
            });
        }
    }

    public void callBackTimeOut() {
        if (this.requestListener != null) {
            this.mDelivery.post(new Runnable() { // from class: com.alimm.tanx.core.ad.model.BaseModel.3
                public AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    BaseModel.this.requestListener.onTimeOut();
                }
            });
        }
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void cancel() {
        this.isCancel = true;
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this);
        }
        LogUtils.d("BaseModel", "计时器取消");
    }

    public void checkSuccess(AdInfo adInfo) {
        if (adInfo == null) {
            callBackError(this.requestListener, new TanxError(TanxError.ERROR_ADINFO_NULL));
        } else {
            onSuccess(adInfo);
        }
    }

    public abstract String getScene();

    public abstract void onSuccess(AdInfo adInfo);

    public void requestSucc(AdInfo adInfo) {
        if (this.isCancel || this.hasTimeOut) {
            return;
        }
        checkSuccess(adInfo);
        cancel();
        timerCancelNotify(adInfo, true, 0);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.hasTimeOut = true;
        callBackTimeOut();
        LogUtils.d("BaseModel", "计时器达到超时");
        TanxAdSlot tanxAdSlot = this.adSlot;
        if (tanxAdSlot != null && tanxAdSlot.isBrandAd()) {
            new TanxRequestLoader().preRequest(this.adSlot, null);
        }
        timerCancelNotify(null, false, UtErrorCode.TIMER_OUT.getIntCode());
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(boolean z10, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
    }

    public void startTimer(long j10) {
        LogUtils.d("BaseModel", "启动计时器 timeOut=" + j10);
        if (j10 > 0) {
            this.handler.postDelayed(this, j10);
        }
    }

    public abstract void timerCancelNotify(AdInfo adInfo, boolean z10, int i10);

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(boolean z10, TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10) {
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener) {
        sendRequest(tanxAdSlot, iTanxRequestListener, 0L);
    }

    @Override // com.alimm.tanx.core.ad.listener.model.IModel
    public void sendRequest(TanxAdSlot tanxAdSlot, ITanxRequestLoader.ITanxRequestListener iTanxRequestListener, long j10) {
        this.adSlot = tanxAdSlot;
        this.requestListener = iTanxRequestListener;
        LogUtils.d("BaseModel", "发起请求 hasRequest=" + this.hasRequest);
        if (!this.hasRequest) {
            this.hasRequest = true;
            startTimer(j10);
            new AdRequest().request(new AdRequestBean().build(tanxAdSlot), (NetWorkCallBack<AdInfo>) new NetWorkCallBack<AdInfo>() { // from class: com.alimm.tanx.core.ad.model.BaseModel.1
                final /* synthetic */ ITanxRequestLoader.ITanxRequestListener tanxc_do;

                public AnonymousClass1(ITanxRequestLoader.ITanxRequestListener iTanxRequestListener2) {
                    iTanxRequestListener = iTanxRequestListener2;
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void error(int i10, String str, String str2) {
                    LogUtils.e("BaseModel", "发起请求 error=" + str2);
                    BaseModel baseModel = BaseModel.this;
                    if (baseModel.isCancel || baseModel.hasTimeOut) {
                        return;
                    }
                    baseModel.callBackError(iTanxRequestListener, new TanxError(str, i10, str2));
                    BaseModel.this.cancel();
                    BaseModel.this.timerCancelNotify(null, true, 0);
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                /* renamed from: tanxc_do */
                public void succ(AdInfo adInfo) {
                    LogUtils.d("BaseModel", "发起请求 isCancel=" + BaseModel.this.isCancel + "--- hasTimeOut= " + BaseModel.this.hasTimeOut);
                    BaseModel.this.requestSucc(adInfo);
                }
            });
            return;
        }
        throw new IllegalStateException("has request");
    }
}
