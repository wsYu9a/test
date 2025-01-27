package com.jd.ad.sdk.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.jad_s_an;
import com.jd.ad.sdk.splash.jad_s_er;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JADSplash implements IJADBase, JADAdLoadListener, jad_s_er.jad_s_an, PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private WeakReference<Context> mContextWf;
    private String mInstanceId;
    private jad_s_an.jad_s_cp mInteractionListener;
    private JADSplashCountDownListener mJADCountDownListener;
    private JADSplashListener mJADListener;
    private final com.jd.ad.sdk.splash.jad_s_er mJADSplashTolerateManager;
    private JADSplashVideoListener mJADSplashVideoListener;
    private ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private JADSlot mSlot;
    private com.jd.ad.sdk.splash.jad_s_an mSplashAdRender;
    private int srtp;
    private int mSplashStylePlanType = 0;
    private int mSplashClickAreaValue = 100;
    private long mRemainTolerateTime = 0;

    public class jad_s_an implements Runnable {
        public jad_s_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdCloseCallback();
        }
    }

    public class jad_s_bo implements Runnable {
        public final /* synthetic */ int jad_s_an;

        public jad_s_bo(int i10) {
            this.jad_s_an = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdCountDownCallback(this.jad_s_an);
        }
    }

    public class jad_s_cp implements ActLifecycle.OnLifecycleChangeListener {
        public jad_s_cp() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (activity.hashCode() == JADSplash.this.mAttachActivityHashCode) {
                JADSplash.this.destroy();
            }
        }
    }

    public class jad_s_dq implements Runnable {
        public jad_s_dq() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.startRender();
        }
    }

    public class jad_s_er implements jad_s_an.jad_s_cp {
        public jad_s_er() {
        }
    }

    public class jad_s_fs implements Runnable {
        public jad_s_fs() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdLoadCallback();
        }
    }

    public class jad_s_hu implements Runnable {
        public final /* synthetic */ View jad_s_an;

        public jad_s_hu(View view) {
            this.jad_s_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdRenderSucCallback(this.jad_s_an);
        }
    }

    public class jad_s_iv implements Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ String jad_s_bo;

        public jad_s_iv(int i10, String str) {
            this.jad_s_an = i10;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdRenderFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    public class jad_s_jt implements Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ String jad_s_bo;

        public jad_s_jt(int i10, String str) {
            this.jad_s_an = i10;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdLoadFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    public class jad_s_jw implements Runnable {
        public jad_s_jw() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdClickCallback();
        }
    }

    public class jad_s_kx implements Runnable {
        public jad_s_kx() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdShowedCallback();
        }
    }

    public JADSplash(@NonNull Context context, @NonNull JADSlot jADSlot) {
        this.dstp = 0;
        this.srtp = 0;
        this.mInstanceId = "";
        this.mAttachActivityHashCode = -1;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.mContextWf = new WeakReference<>(context);
            if (context instanceof Activity) {
                this.mAttachActivityHashCode = context.hashCode();
            }
        }
        this.mInstanceId = UUIDUtils.uuid();
        if (jADSlot == null) {
            Logger.w("JADSlot can not be null !!!", new Object[0]);
        } else {
            this.mSlot = jADSlot;
            JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
            this.dstp = JADMediator.getInstance().getInitService().getDs(this.mSlot.getSlotID());
            this.srtp = JADMediator.getInstance().getInitService().getR(this.mSlot.getSlotID());
        }
        JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        this.mJADSplashTolerateManager = getTolerateWidget(jADSlot.getTolerateTime());
        initActLifeListener();
    }

    public void calculateClickArea() {
        View view;
        try {
            JADSlot jADSlot = this.mSlot;
            if (jADSlot == null) {
                return;
            }
            if (jADSlot.getRem() == 3) {
                this.mSplashStylePlanType = 6;
                com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
                if (jad_s_anVar != null) {
                    View view2 = jad_s_anVar.jad_s_jt;
                    DynamicRenderView dynamicRenderView = null;
                    if (((view2 == null || !(view2 instanceof DynamicRenderView)) ? null : (DynamicRenderView) view2) != null) {
                        if (view2 != null && (view2 instanceof DynamicRenderView)) {
                            dynamicRenderView = (DynamicRenderView) view2;
                        }
                        this.mSplashClickAreaValue = dynamicRenderView.getAdClickAreaValue();
                    }
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
                return;
            }
            com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.mSplashAdRender;
            if (jad_s_anVar2 != null && jad_s_anVar2.jad_s_iv != null && (view = jad_s_anVar2.jad_s_jt) != null) {
                this.mSplashStylePlanType = jad_s_anVar2.jad_s_jw;
                int measuredWidth = (int) (view.getMeasuredWidth() * this.mSplashAdRender.jad_s_jt.getMeasuredHeight());
                int measuredWidth2 = this.mSplashAdRender.jad_s_iv.getMeasuredWidth() * this.mSplashAdRender.jad_s_iv.getMeasuredHeight();
                if (measuredWidth > 0) {
                    this.mSplashClickAreaValue = (measuredWidth2 * 100) / measuredWidth;
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
            }
        } catch (Exception e10) {
            StringBuilder a10 = a.a("Exception while calculate area: ");
            a10.append(e10.getMessage());
            Logger.w(a10.toString(), new Object[0]);
        }
    }

    public void callbackAdClickOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_jw());
    }

    public void callbackAdCloseOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_an());
    }

    public void callbackAdCountDownOnUiThread(int i10) {
        HandlerUtils.runOnUiThread(new jad_s_bo(i10));
    }

    private void callbackAdLoadFailedOnUiThread(int i10, String str) {
        HandlerUtils.runOnUiThread(new jad_s_jt(i10, str));
    }

    private void callbackAdLoadOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_fs());
    }

    public void callbackAdReadyOnUiThread(View view) {
        reportRenderSuccessEvent();
        HandlerUtils.runOnUiThread(new jad_s_hu(view));
    }

    public void callbackAdRenderFailedOnUiThread(int i10, String str) {
        HandlerUtils.runOnUiThread(new jad_s_iv(i10, str));
    }

    public void callbackAdShowedOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_kx());
    }

    private void doAfterPreloadFinished() {
        JADMediator.getInstance().getAdService().unregisterAdPreloader(this.mInstanceId, this.mSlot);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    private int getAdType() {
        return 1;
    }

    @Nullable
    private Context getAppContext() {
        WeakReference<Context> weakReference = this.mContextWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private int getDisplayScene() {
        return 4;
    }

    private String getImageUrl() {
        return (getJADMaterialData() == null || getJADMaterialData().getImageUrls() == null || getJADMaterialData().getImageUrls().isEmpty()) ? "" : getJADMaterialData().getImageUrls().get(0);
    }

    private String getTolerateTimeFinishErin(String str) {
        String str2;
        float f10;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
            f10 = this.mSlot.getTolerateTime();
        } else {
            str2 = "";
            f10 = 0.0f;
        }
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(getAdType()));
        JsonUtils.put(jSONObject, "toti", Float.valueOf(f10));
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    private com.jd.ad.sdk.splash.jad_s_er getTolerateWidget(float f10) {
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = new com.jd.ad.sdk.splash.jad_s_er(f10);
        jad_s_erVar.jad_s_dq = this;
        return jad_s_erVar;
    }

    private int getVideoDuration() {
        if (getJADMaterialData() != null) {
            return getJADMaterialData().getVideoDuration();
        }
        return 0;
    }

    private String getVideoUrl() {
        return (getJADMaterialData() == null || TextUtils.isEmpty(getJADMaterialData().getVideoUrl())) ? "" : getJADMaterialData().getVideoUrl();
    }

    private void initActLifeListener() {
        if (this.mAttachActivityHashCode != -1) {
            jad_s_cp jad_s_cpVar = new jad_s_cp();
            this.mLifeChangeListener = jad_s_cpVar;
            ActLifecycle.addLifecycleListener(jad_s_cpVar);
        }
    }

    private void initInteractionListener() {
        this.mInteractionListener = new jad_s_er();
    }

    private void notifyRender() {
        HandlerUtils.runOnUiThread(new jad_s_dq());
    }

    @UiThread
    public void onAdClickCallback() {
        StringBuilder a10 = a.a("seven_back=====onAdClickCallback====TYPE=");
        a10.append(getAdType());
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClick();
        }
    }

    @UiThread
    public void onAdCloseCallback() {
        StringBuilder a10 = a.a("seven_back=====onAdCloseCallback====TYPE=");
        a10.append(getAdType());
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an();
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClose();
        }
        this.mJADListener = null;
        destroy();
    }

    @UiThread
    public void onAdCountDownCallback(int i10) {
        StringBuilder a10 = a.a("seven_back=====onAdCountDownCallback====TYPE=");
        a10.append(getAdType());
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            jADSplashCountDownListener.onCountdown(i10);
        }
    }

    @UiThread
    public void onAdLoadCallback() {
        StringBuilder a10 = a.a("seven_back=====onAdLoadCallback====TYPE=");
        a10.append(getAdType());
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an = true;
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadSuccess();
        }
    }

    @UiThread
    public void onAdLoadFailedCallback(int i10, String str) {
        StringBuilder a10 = a.a("seven_back=====onAdLoadFailedCallback====TYPE=");
        a10.append(getAdType());
        a10.append(",code=");
        a10.append(i10);
        a10.append(",error=");
        a10.append(str);
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an();
        }
        if (this.mSlot != null) {
            JADMediator.getInstance().getAdService().printRequestData(this.mSlot);
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadFailure(i10, str);
        }
    }

    @UiThread
    public void onAdRenderFailedCallback(int i10, String str) {
        StringBuilder a10 = a.a("seven_back=====onAdRenderFailedCallback====TYPE=");
        a10.append(getAdType());
        a10.append(",code=");
        a10.append(i10);
        a10.append(",error=");
        a10.append(str);
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an();
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onRenderFailure(i10, str);
        }
    }

    @UiThread
    public void onAdRenderSucCallback(View view) {
        StringBuilder a10 = a.a("seven_back=====onAdRenderCallback====TYPE=");
        a10.append(getAdType());
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("seven_back===thread error!!", new Object[0]);
        }
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
            if (jad_s_erVar != null) {
                jad_s_erVar.jad_s_an();
            }
            JADSplashListener jADSplashListener = this.mJADListener;
            if (jADSplashListener != null) {
                jADSplashListener.onRenderSuccess(view);
                return;
            }
            return;
        }
        if (this.mSlot != null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String requestId = this.mSlot.getRequestId();
            JADError jADError = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
            eventService.reportRenderFailedEvent(requestId, jADError.getCode(), jADError.getMessage(new String[0]), this.mSlot.getSen());
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar2 = this.mJADSplashTolerateManager;
        if (jad_s_erVar2 != null) {
            jad_s_erVar2.jad_s_an();
        }
        JADSplashListener jADSplashListener2 = this.mJADListener;
        if (jADSplashListener2 != null) {
            JADError jADError2 = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
            jADSplashListener2.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new String[0]));
        }
    }

    @UiThread
    public void onAdShowedCallback() {
        StringBuilder a10 = a.a("seven_back=====onAdShowedCallback====TYPE=");
        a10.append(getAdType());
        Logger.d(a10.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onExposure();
        }
    }

    public void reportClickEvent(int i10, int i11, int i12, int i13) {
        JADSlot jADSlot;
        if (i10 == -2 || (jADSlot = this.mSlot) == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            JADMediator.getInstance().getEventService().reportPreloadClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i11, i10, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i13, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i11, i10, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i13, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        }
    }

    public void reportCloseEvent(int i10) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            JADMediator.getInstance().getEventService().reportPreloadCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i10, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i10, this.dstp, this.srtp);
        }
    }

    public void reportDelayExposureEvent(String str, int i10, int i11) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setDelayShowTime(System.currentTimeMillis());
        long delayShowTime = this.mSlot.getDelayShowTime() - this.mSlot.getLoadTime();
        long delayShowTime2 = this.mSlot.getDelayShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(delayShowTime);
        this.mSlot.setDedu(delayShowTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i11, i10, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i11, i10, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    public void reportExposureEvent(String str, int i10, int i11) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setShowTime(System.currentTimeMillis());
        long showTime = this.mSlot.getShowTime() - this.mSlot.getLoadTime();
        long showTime2 = this.mSlot.getShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(showTime);
        this.mSlot.setDedu(showTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i11, i10, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i11, i10, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    private void reportRenderSuccessEvent() {
        long j10;
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setRenderSucTime(System.currentTimeMillis());
        long renderSucTime = this.mSlot.getRenderSucTime() - this.mSlot.getLoadTime();
        long dynamicRenderViewInitSuccessTime = this.mSlot.getDynamicRenderViewInitSuccessTime();
        if (dynamicRenderViewInitSuccessTime > 0) {
            long loadTime = dynamicRenderViewInitSuccessTime - this.mSlot.getLoadTime();
            Logger.d("dynamic render view init time:" + loadTime);
            j10 = loadTime;
        } else {
            j10 = 0;
        }
        if (this.mSlot.getAdDataRequestSourceType() == 1 || this.mSlot.getAdDataRequestSourceType() == 2) {
            JADMediator.getInstance().getEventService().reportPreloadRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j10, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j10, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        }
    }

    private void startPreloadAdDataTimeCounter() {
        PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    public void startRender() {
        JADSlot jADSlot;
        int i10;
        Context appContext = getAppContext();
        JADSlot jADSlot2 = this.mSlot;
        String str = this.mInstanceId;
        String imageUrl = getImageUrl();
        getVideoUrl();
        getVideoDuration();
        this.mSplashAdRender = new com.jd.ad.sdk.splash.jad_s_an(appContext, jADSlot2, str, imageUrl);
        initInteractionListener();
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        jad_s_anVar.jad_s_hu = this.mInteractionListener;
        JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            jad_s_anVar.jad_s_ly = jADSplashCountDownListener;
        }
        JADSplashVideoListener jADSplashVideoListener = this.mJADSplashVideoListener;
        if (jADSplashVideoListener != null) {
            jad_s_anVar.jad_s_mz = jADSplashVideoListener;
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            this.mRemainTolerateTime = (long) ((jad_s_erVar.jad_s_bo * 1000.0f) - (System.currentTimeMillis() - jad_s_erVar.jad_s_er));
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar2 = this.mSplashAdRender;
        jad_s_anVar2.jad_s_qd = this.mRemainTolerateTime;
        if (jad_s_anVar2.jad_s_bo == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str2 = jad_s_anVar2.jad_s_er;
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str2, jADError.getCode(), jADError.getMessage(new String[0]), jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        if (jad_s_anVar2.jad_s_an() == null) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            String str3 = jad_s_anVar2.jad_s_er;
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService2.reportRenderFailedEvent(str3, jADError2.getCode(), jADError2.getMessage(new String[0]), jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        if (jad_s_anVar2.jad_s_bo.getMediaSpecSetType() != 10009) {
            Context jad_s_an2 = jad_s_anVar2.jad_s_an();
            JADError jADError3 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError3.getCode();
            String message = jADError3.getMessage(new String[0]);
            if (jad_s_an2 == null || (jADSlot = jad_s_anVar2.jad_s_bo) == null) {
                JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code, message, jad_s_anVar2.jad_s_fs);
                jad_s_anVar2.jad_s_an(code, message);
                return;
            }
            if (jADSlot.getDynamicRenderTemplateHelper() == null) {
                jad_s_anVar2.onDynamicRenderFailed(code, message);
                return;
            }
            try {
                if (JADMediator.getInstance().getDynamicRenderService().createDynamicView(jad_s_an2, jad_s_anVar2.jad_s_dq, jad_s_anVar2.jad_s_bo, jad_s_anVar2) == null) {
                    JADError jADError4 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    jad_s_anVar2.onDynamicRenderFailed(jADError4.getCode(), jADError4.getMessage(new String[0]));
                } else {
                    jad_s_anVar2.jad_s_bo.setDynamicRenderViewInitSuccessTime(System.currentTimeMillis());
                    jad_s_anVar2.jad_s_bo.setRem(3);
                }
                return;
            } catch (Throwable th2) {
                try {
                    Exception exc = new Exception("dynamic render view init error", th2);
                    JSONObject jad_s_an3 = jad_s_anVar2.jad_s_an(exc);
                    int optInt = jad_s_an3.optInt("code");
                    JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, optInt, jad_s_an3.optString("msg"), jad_s_anVar2.jad_s_fs);
                    Logger.d(optInt + ": " + Log.getStackTraceString(exc));
                } catch (Exception e10) {
                    Logger.d(Log.getStackTraceString(e10));
                }
                jad_s_anVar2.onDynamicRenderFailed(code, message);
                return;
            }
        }
        jad_s_anVar2.jad_s_ob = true;
        Context jad_s_an4 = jad_s_anVar2.jad_s_an();
        JADError jADError5 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        int code2 = jADError5.getCode();
        String message2 = jADError5.getMessage(new String[0]);
        if (jad_s_an4 == null || jad_s_anVar2.jad_s_bo == null) {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, code2, message2, jad_s_anVar2.jad_s_fs);
            jad_s_anVar2.jad_s_an(code2, message2);
            return;
        }
        try {
            if (jad_s_anVar2.jad_s_re == null) {
                jad_s_anVar2.jad_s_re = new com.jd.ad.sdk.jad_s_an.jad_s_cp(jad_s_anVar2);
            }
            if (jad_s_anVar2.jad_s_sf == null) {
                jad_s_anVar2.jad_s_sf = new com.jd.ad.sdk.jad_s_an.jad_s_dq(jad_s_anVar2);
            }
            i10 = code2;
            try {
                if (JADMediator.getInstance().getVideoRenderService().createVideoRendView(jad_s_an4, jad_s_anVar2.jad_s_dq, jad_s_anVar2.jad_s_bo, jad_s_anVar2.jad_s_qd, jad_s_anVar2.jad_s_re, jad_s_anVar2.jad_s_sf) == null) {
                    JADError jADError6 = JADError.RENDER_VIDEO_FAIL_ERROR;
                    jad_s_anVar2.jad_s_bo(jADError6.getCode(), jADError6.getMessage(new String[0]));
                } else {
                    jad_s_anVar2.jad_s_bo.setRem(1);
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    Exception exc2 = new Exception("video render view init error", th);
                    JSONObject jad_s_an5 = jad_s_anVar2.jad_s_an(exc2);
                    int optInt2 = jad_s_an5.optInt("code");
                    JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_anVar2.jad_s_er, optInt2, jad_s_an5.optString("msg"), jad_s_anVar2.jad_s_fs);
                    Logger.d(optInt2 + ": " + Log.getStackTraceString(exc2));
                } catch (Exception e11) {
                    Logger.d(Log.getStackTraceString(e11));
                }
                jad_s_anVar2.jad_s_bo(i10, message2);
            }
        } catch (Throwable th4) {
            th = th4;
            i10 = code2;
        }
    }

    public void destroy() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            try {
                JADMediator.getInstance().getTouchService().unregisterTouchView(jad_s_anVar.jad_s_dq);
                JADMediator.getInstance().getExposureService().unregisterExposureView(jad_s_anVar.jad_s_dq);
                View view = jad_s_anVar.jad_s_jt;
                if (((view == null || !(view instanceof VideoRenderView)) ? null : (VideoRenderView) view) != null) {
                    ((view == null || !(view instanceof VideoRenderView)) ? null : (VideoRenderView) view).destroy();
                }
                jad_s_anVar.jad_s_jt = null;
                jad_s_anVar.jad_s_iv = null;
                jad_s_anVar.jad_s_hu = null;
            } catch (Exception e10) {
                StringBuilder a10 = a.a("Exception while destroy: ");
                a10.append(e10.getMessage());
                Logger.w(a10.toString(), new Object[0]);
            }
            this.mSplashAdRender = null;
        }
        this.mJADListener = null;
        if (this.mInteractionListener != null) {
            this.mInteractionListener = null;
        }
        JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
        ActLifecycle.OnLifecycleChangeListener onLifecycleChangeListener = this.mLifeChangeListener;
        if (onLifecycleChangeListener != null) {
            ActLifecycle.removeLifecycleListener(onLifecycleChangeListener);
            this.mLifeChangeListener = null;
        }
    }

    public String getErin(String str) {
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.mSlot;
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, jADSlot != null ? jADSlot.getSlotID() : "");
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(getAdType()));
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public final IJADExtra getJADExtra() {
        return JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
    }

    @Nullable
    public JADMaterialData getJADMaterialData() {
        List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        if (jADMaterialDataList == null || jADMaterialDataList.isEmpty() || jADMaterialDataList.get(0) == null) {
            return null;
        }
        return jADMaterialDataList.get(0);
    }

    public boolean isMaterialMetaPreload() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            return jad_s_anVar.jad_s_na;
        }
        return false;
    }

    public boolean isMaterialMetaVideo() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            return jad_s_anVar.jad_s_ob;
        }
        return false;
    }

    public final void loadAd(JADSplashListener jADSplashListener) {
        Handler handler;
        this.mJADListener = jADSplashListener;
        String uuid = UUIDUtils.uuid();
        if (this.mSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null && (handler = jad_s_erVar.jad_s_cp) != null) {
            handler.sendEmptyMessageDelayed(1, (long) (jad_s_erVar.jad_s_bo * 1000.0f));
            jad_s_erVar.jad_s_er = System.currentTimeMillis();
        }
        startPreloadAdDataTimeCounter();
        this.mSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(0);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    @Override // com.jd.ad.sdk.splash.jad_s_er.jad_s_an
    public void onCounterFinish() {
        String str;
        int i10;
        if (this.mJADSplashTolerateManager != null) {
            JADSlot jADSlot = this.mSlot;
            if (jADSlot != null) {
                str = jADSlot.getRequestId();
                i10 = this.mSlot.getSen();
            } else {
                str = "";
                i10 = 0;
            }
            if (this.mJADSplashTolerateManager.jad_s_an) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                JADError jADError = JADError.RENDER_TOLERATE_TIME_ERROR;
                eventService.reportRenderFailedEvent(str, jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new String[0])), i10);
                onAdRenderFailedCallback(jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new String[0])));
            } else {
                JADEventService eventService2 = JADMediator.getInstance().getEventService();
                JADError jADError2 = JADError.GW_RESPONSE_TOLERATE_TIME_ERROR;
                eventService2.reportRequestErrorEvent(str, jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new String[0])));
                onAdLoadFailedCallback(jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new String[0])));
            }
            this.mJADListener = null;
        }
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadFailure(int i10, String str) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null || jADSlot.getAdDataRequestSourceType() != 1) {
            callbackAdLoadFailedOnUiThread(i10, str);
        } else {
            doAfterPreloadFinished();
        }
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadSuccess() {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null && jADSlot.getAdDataRequestSourceType() == 1) {
            doAfterPreloadFinished();
        } else {
            callbackAdLoadOnUiThread();
            notifyRender();
        }
    }

    @Override // com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback
    public void onUseCacheCounterFinish() {
        JADMediator.getInstance().getAdService().loadAdFromCache(this.mInstanceId, this.mSlot, this);
    }

    public void preloadAd() {
        String uuid = UUIDUtils.uuid();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            return;
        }
        jADSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(1);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    public final void removeSplashView() {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.mSplashAdRender;
        if (jad_s_anVar != null) {
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.jad_s_cp(jad_s_anVar));
        }
    }

    public void setCountDownListener(JADSplashCountDownListener jADSplashCountDownListener) {
        this.mJADCountDownListener = jADSplashCountDownListener;
    }

    public void setSplashVideoListener(JADSplashVideoListener jADSplashVideoListener) {
        this.mJADSplashVideoListener = jADSplashVideoListener;
    }
}
