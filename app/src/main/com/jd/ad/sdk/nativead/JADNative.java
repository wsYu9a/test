package com.jd.ad.sdk.nativead;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.event.JADVideoReporter;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_n_an.jad_n_dq;
import com.jd.ad.sdk.jad_n_an.jad_n_er;
import com.jd.ad.sdk.jad_n_an.jad_n_fs;
import com.jd.ad.sdk.jad_n_an.jad_n_hu;
import com.jd.ad.sdk.jad_n_an.jad_n_iv;
import com.jd.ad.sdk.jad_n_an.jad_n_jt;
import com.jd.ad.sdk.jad_n_an.jad_n_jw;
import com.jd.ad.sdk.jad_n_an.jad_n_kx;
import com.jd.ad.sdk.jad_n_an.jad_n_ly;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JADNative implements IJADBase {
    private WeakReference<Activity> mActivityRef;
    private jad_n_hu mAdViewController;
    private String mInstanceId;
    private IJADExtra mJADExtra;
    private JADNativeLoadListener mLoadListener;
    private List<JADMaterialData> mMaterialDataList;
    private final JADSlot mSlot;
    private JADVideoReporter mVideoReporter;

    public class jad_n_an implements JADAdLoadListener {
        public jad_n_an() {
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadFailure(int i10, String str) {
            JADNative jADNative = JADNative.this;
            jADNative.callbackAdLoadFailedOnUiThread(jADNative.mLoadListener, i10, str);
        }

        @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
        public void onLoadSuccess() {
            JADNative jADNative = JADNative.this;
            jADNative.callbackAdLoadOnUiThread(jADNative.mLoadListener);
        }
    }

    public class jad_n_bo implements Runnable {
        public final /* synthetic */ JADNativeLoadListener jad_n_an;

        public jad_n_bo(JADNativeLoadListener jADNativeLoadListener) {
            this.jad_n_an = jADNativeLoadListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADNative.this.onAdLoadCallback(this.jad_n_an);
        }
    }

    public class jad_n_cp implements Runnable {
        public final /* synthetic */ JADNativeLoadListener jad_n_an;
        public final /* synthetic */ int jad_n_bo;
        public final /* synthetic */ String jad_n_cp;

        public jad_n_cp(JADNativeLoadListener jADNativeLoadListener, int i10, String str) {
            this.jad_n_an = jADNativeLoadListener;
            this.jad_n_bo = i10;
            this.jad_n_cp = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADNative.this.onAdLoadFailedCallback(this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
        }
    }

    public JADNative(@NonNull JADSlot jADSlot) {
        this.mInstanceId = "";
        this.mInstanceId = UUIDUtils.uuid();
        JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
        this.mSlot = jADSlot;
        this.mAdViewController = new jad_n_hu();
    }

    public void callbackAdLoadFailedOnUiThread(JADNativeLoadListener jADNativeLoadListener, int i10, String str) {
        HandlerUtils.runOnUiThread(new jad_n_cp(jADNativeLoadListener, i10, str));
    }

    public void callbackAdLoadOnUiThread(JADNativeLoadListener jADNativeLoadListener) {
        HandlerUtils.runOnUiThread(new jad_n_bo(jADNativeLoadListener));
    }

    private int getRenderMode() {
        return 2;
    }

    public void onAdLoadCallback(JADNativeLoadListener jADNativeLoadListener) {
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadSuccess();
        }
    }

    public void onAdLoadFailedCallback(JADNativeLoadListener jADNativeLoadListener, int i10, String str) {
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        if (jADNativeLoadListener != null) {
            jADNativeLoadListener.onLoadFailure(i10, str);
        }
    }

    public void destroy() {
        jad_n_hu jad_n_huVar = this.mAdViewController;
        if (jad_n_huVar != null) {
            jad_n_huVar.jad_n_an();
            this.mAdViewController = null;
        }
        List<JADMaterialData> list = this.mMaterialDataList;
        if (list != null && list.size() > 0) {
            this.mMaterialDataList.clear();
            this.mMaterialDataList = null;
        }
        if (this.mVideoReporter != null) {
            this.mVideoReporter = null;
        }
        JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    @Nullable
    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public List<JADMaterialData> getDataList() {
        List<JADMaterialData> list = this.mMaterialDataList;
        if (list == null || list.size() == 0) {
            this.mMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        }
        return this.mMaterialDataList;
    }

    public int getDisplayScene(int i10) {
        if (i10 == 1) {
            return 4;
        }
        if (i10 == 2) {
            return 64;
        }
        if (i10 != 4) {
            return i10 != 5 ? 0 : 1;
        }
        return 2;
    }

    public String getErin(@NonNull String str, int i10, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str);
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(i10));
        JsonUtils.put(jSONObject, "error", str2);
        return jSONObject.toString();
    }

    public String getInstanceId() {
        return this.mInstanceId;
    }

    @NonNull
    public IJADExtra getJADExtra() {
        if (this.mJADExtra == null) {
            this.mJADExtra = JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
        }
        return this.mJADExtra;
    }

    public JADVideoReporter getJADVideoReporter() {
        if (this.mVideoReporter == null) {
            this.mVideoReporter = new jad_n_dq(this.mSlot);
        }
        return this.mVideoReporter;
    }

    public int getMediaSpecSetType() {
        return this.mSlot.getMediaSpecSetType();
    }

    public JADSlot getSlot() {
        return this.mSlot;
    }

    public void loadAd(@NonNull JADNativeLoadListener jADNativeLoadListener) {
        this.mLoadListener = jADNativeLoadListener;
        String uuid = UUIDUtils.uuid();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin("", 0, jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        jADSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        if (this.mSlot.getAdType() == 0) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            JADError jADError2 = JADError.GW_REQUEST_AD_TYPE_IS_NOT_SET_ERROR;
            eventService2.reportRequestErrorEvent(uuid, jADError2.getCode(), getErin(this.mSlot.getSlotID(), 0, jADError2.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(this.mLoadListener, jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        JADSlot jADSlot2 = this.mSlot;
        jADSlot2.setDisplayScene(getDisplayScene(jADSlot2.getAdType()));
        this.mSlot.setFromNativeAd(true);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, new jad_n_an());
    }

    public void registerNativeView(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @NonNull JADNativeInteractionListener jADNativeInteractionListener) {
        JADNative jADNative;
        float feedShakeSensitivityValue;
        float feedShakeAngleValue;
        float feedShakeTimeValue;
        boolean z10;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        JADNative jADNative2;
        this.mActivityRef = new WeakReference<>(activity);
        if (this.mAdViewController == null) {
            this.mAdViewController = new jad_n_hu();
        }
        jad_n_hu jad_n_huVar = this.mAdViewController;
        jad_n_huVar.getClass();
        jad_n_huVar.jad_n_ly = JADMediator.getInstance().getFoundationService().getApplication();
        jad_n_huVar.jad_n_mz = getActivity() != null ? getActivity().hashCode() : -1;
        jad_n_huVar.jad_n_an = this;
        jad_n_huVar.jad_n_fs = viewGroup;
        jad_n_huVar.jad_n_jt = list;
        jad_n_huVar.jad_n_bo = jADNativeInteractionListener;
        if (jADNativeInteractionListener != null) {
            jad_n_huVar.jad_n_cp(viewGroup);
            if (viewGroup != null && (jADNative2 = jad_n_huVar.jad_n_an) != null && jADNative2.getSlot() != null) {
                JADMediator.getInstance().getExposureService().registerExposureView(jad_n_huVar.jad_n_an.getInstanceId());
                if (jad_n_huVar.jad_n_an.getSlot().getEventInteractionType() == 1) {
                    JADMediator.getInstance().getExposureService().registerNativeExposureFeedShakeView(jad_n_huVar.jad_n_an.getInstanceId(), viewGroup);
                }
                JADMediator.getInstance().getExposureService().setViewExposureCallback(jad_n_huVar.jad_n_an.getInstanceId(), jad_n_huVar.jad_n_an.getSlot().getAdType(), viewGroup, new jad_n_jt(jad_n_huVar, viewGroup));
            }
            JADNative jADNative3 = jad_n_huVar.jad_n_an;
            if (jADNative3 == null || jADNative3.getSlot() == null) {
                return;
            }
            boolean z11 = jad_n_huVar.jad_n_an.getSlot().getAdType() == 4;
            try {
                for (View view : list) {
                    if (view != null) {
                        view.setOnClickListener(new jad_n_iv(jad_n_huVar, view, z11));
                        jad_n_huVar.jad_n_cp(view);
                    }
                }
            } catch (Exception e10) {
                StringBuilder a10 = a.a("Exception while click:");
                a10.append(e10.getMessage());
                Logger.w(a10.toString(), new Object[0]);
            }
            if (jad_n_huVar.jad_n_an.getSlot().getAdType() == 1) {
                JADNative jADNative4 = jad_n_huVar.jad_n_an;
                if (jADNative4 != null) {
                    com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = new com.jd.ad.sdk.jad_n_an.jad_n_an(jADNative4);
                    if (jad_n_huVar.jad_n_an.getSlot() != null) {
                        jad_n_anVar.jad_n_an = jad_n_huVar.jad_n_an.getSlot().getSkipTime();
                    }
                    JADNativeInteractionListener jADNativeInteractionListener2 = jad_n_huVar.jad_n_bo;
                    if (jADNativeInteractionListener2 != null && (jADNativeInteractionListener2 instanceof JADNativeSplashInteractionListener)) {
                        jad_n_anVar.jad_n_cp = new WeakReference<>((JADNativeSplashInteractionListener) jADNativeInteractionListener2);
                        jad_n_anVar.jad_n_bo = new jad_n_jw(jad_n_huVar);
                    }
                    if (list2 != null && !list2.isEmpty()) {
                        for (View view2 : list2) {
                            if (view2 != null) {
                                jad_n_huVar.jad_n_cp(view2);
                                jad_n_anVar.jad_n_hu = view2;
                                view2.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_n_an.jad_n_bo(jad_n_anVar));
                                View view3 = jad_n_anVar.jad_n_hu;
                                if (view3 == null ? false : ViewCompat.isAttachedToWindow(view3)) {
                                    Logger.d("Native ad setSkipView startCount");
                                    jad_n_anVar.jad_n_an();
                                }
                                view2.setOnClickListener(new jad_n_kx(jad_n_huVar, jad_n_anVar));
                            }
                        }
                    }
                }
            } else if (list2 != null && !list2.isEmpty()) {
                for (View view4 : list2) {
                    if (view4 != null) {
                        try {
                            view4.setOnClickListener(new jad_n_ly(jad_n_huVar));
                        } catch (Exception e11) {
                            StringBuilder a11 = a.a("Exception while click:");
                            a11.append(e11.getMessage());
                            Logger.w(a11.toString(), new Object[0]);
                        }
                        jad_n_huVar.jad_n_cp(view4);
                    }
                }
            }
            if (getSlot().getEventInteractionType() == 1 && jad_n_huVar.jad_n_fs != null && (jADNative = jad_n_huVar.jad_n_an) != null && jADNative.getSlot() != null) {
                if (jad_n_huVar.jad_n_an.getSlot().getAdType() == 1) {
                    feedShakeSensitivityValue = JADMediator.getInstance().getInitService().getShakeSensitivityValue();
                    feedShakeAngleValue = JADMediator.getInstance().getInitService().getShakeAngleValue();
                    feedShakeTimeValue = JADMediator.getInstance().getInitService().getShakeTimeValue();
                    z10 = true;
                } else {
                    feedShakeSensitivityValue = JADMediator.getInstance().getInitService().getFeedShakeSensitivityValue();
                    feedShakeAngleValue = JADMediator.getInstance().getInitService().getFeedShakeAngleValue();
                    feedShakeTimeValue = JADMediator.getInstance().getInitService().getFeedShakeTimeValue();
                    z10 = false;
                }
                Application application = jad_n_huVar.jad_n_ly;
                if (application != null && -1 != jad_n_huVar.jad_n_mz && (activityLifecycleCallbacks = jad_n_huVar.jad_n_ob) != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    jad_n_huVar.jad_n_ly.registerActivityLifecycleCallbacks(jad_n_huVar.jad_n_ob);
                }
                jad_n_huVar.jad_n_jt();
                float f10 = (feedShakeSensitivityValue == 0.0f && feedShakeAngleValue == 0.0f) ? 15.0f : feedShakeSensitivityValue;
                jad_n_er jad_n_erVar = new jad_n_er(jad_n_huVar, jad_n_huVar.jad_n_fs.getContext(), f10, feedShakeAngleValue, feedShakeTimeValue, z10, f10, feedShakeAngleValue, feedShakeTimeValue);
                jad_n_huVar.jad_n_kx = jad_n_erVar;
                jad_n_erVar.register();
            }
            if (getSlot().getEventInteractionType() == 2 && jad_n_huVar.jad_n_fs != null) {
                float[] fArr = {0.0f, 0.0f};
                float[] fArr2 = {0.0f, 0.0f};
                float swipeLength = JADMediator.getInstance().getInitService().getSwipeLength();
                float swipeAngle = JADMediator.getInstance().getInitService().getSwipeAngle();
                jad_n_huVar.jad_n_fs.setOnTouchListener(new jad_n_fs(jad_n_huVar, fArr, fArr2, swipeLength <= 0.0f ? 1.0f : swipeLength, swipeAngle <= 0.0f ? 45.0f : swipeAngle));
            }
        }
        jad_n_huVar.jad_n_hu = JADMediator.getInstance().getInitService().getDs(jad_n_huVar.jad_n_fs());
        jad_n_huVar.jad_n_iv = JADMediator.getInstance().getInitService().getR(jad_n_huVar.jad_n_fs());
    }
}
