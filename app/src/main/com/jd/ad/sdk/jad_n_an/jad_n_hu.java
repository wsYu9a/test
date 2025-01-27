package com.jd.ad.sdk.jad_n_an;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class jad_n_hu {
    public JADNative jad_n_an;
    public JADNativeInteractionListener jad_n_bo;
    public ViewGroup jad_n_fs;
    public List<View> jad_n_jt;
    public ShakeListener jad_n_kx;
    public Application jad_n_ly;
    public int jad_n_mz;
    public jad_n_cp jad_n_na;
    public boolean jad_n_cp = false;
    public int jad_n_dq = 0;
    public int jad_n_er = 100;
    public int jad_n_hu = 0;
    public int jad_n_iv = 0;
    public int jad_n_jw = CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    public final Application.ActivityLifecycleCallbacks jad_n_ob = new jad_n_bo();

    public class jad_n_an implements View.OnTouchListener {
        public jad_n_an() {
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (jad_n_hu.this.jad_n_an == null) {
                return false;
            }
            JADMediator.getInstance().getTouchService().onViewTouch(view, motionEvent, jad_n_hu.this.jad_n_an.getInstanceId());
            return false;
        }
    }

    public class jad_n_bo implements Application.ActivityLifecycleCallbacks {
        public jad_n_bo() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
            int hashCode = activity.hashCode();
            jad_n_hu jad_n_huVar = jad_n_hu.this;
            if (hashCode == jad_n_huVar.jad_n_mz) {
                jad_n_huVar.jad_n_an(true);
                jad_n_hu jad_n_huVar2 = jad_n_hu.this;
                Application application = jad_n_huVar2.jad_n_ly;
                if (application != null && (activityLifecycleCallbacks = jad_n_huVar2.jad_n_ob) != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                jad_n_hu.this.jad_n_an();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            int hashCode = activity.hashCode();
            jad_n_hu jad_n_huVar = jad_n_hu.this;
            if (hashCode == jad_n_huVar.jad_n_mz) {
                jad_n_huVar.jad_n_an(false);
                jad_n_hu.jad_n_an(jad_n_hu.this, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            int hashCode = activity.hashCode();
            jad_n_hu jad_n_huVar = jad_n_hu.this;
            if (hashCode != jad_n_huVar.jad_n_mz || jad_n_huVar.jad_n_cp) {
                return;
            }
            jad_n_huVar.jad_n_jt();
            jad_n_hu.jad_n_an(jad_n_hu.this, true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            int hashCode = activity.hashCode();
            jad_n_hu jad_n_huVar = jad_n_hu.this;
            if (hashCode == jad_n_huVar.jad_n_mz) {
                jad_n_huVar.jad_n_an(false);
                jad_n_hu.jad_n_an(jad_n_hu.this, false);
            }
        }
    }

    @RequiresApi(api = 18)
    public class jad_n_cp implements ViewTreeObserver.OnWindowFocusChangeListener {
        public jad_n_cp() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z10) {
            jad_n_hu jad_n_huVar = jad_n_hu.this;
            if (jad_n_huVar.jad_n_cp) {
                return;
            }
            if (!z10) {
                jad_n_huVar.jad_n_hu();
                return;
            }
            ShakeListener shakeListener = jad_n_huVar.jad_n_kx;
            if (shakeListener != null) {
                shakeListener.register();
            }
        }
    }

    public static boolean jad_n_an(jad_n_hu jad_n_huVar, View view) {
        jad_n_huVar.getClass();
        return view != null && view.getGlobalVisibleRect(new Rect()) && view.isShown();
    }

    public final void jad_n_cp(View view) {
        if (view == null || this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getTouchService().registerTouchView(this.jad_n_an.getInstanceId());
        view.setClickable(true);
        view.setOnTouchListener(new jad_n_an());
    }

    public final JADSlot jad_n_dq() {
        JADNative jADNative = this.jad_n_an;
        if (jADNative != null) {
            return jADNative.getSlot();
        }
        return null;
    }

    public final String jad_n_er() {
        JADNative jADNative = this.jad_n_an;
        return (jADNative == null || jADNative.getSlot() == null) ? "" : this.jad_n_an.getSlot().getRequestId();
    }

    public final String jad_n_fs() {
        return jad_n_dq() != null ? jad_n_dq().getSlotID() : "";
    }

    public final void jad_n_hu() {
        ShakeListener shakeListener = this.jad_n_kx;
        if (shakeListener != null) {
            shakeListener.unregister();
        }
    }

    public final void jad_n_jt() {
        ViewGroup viewGroup = this.jad_n_fs;
        if (viewGroup != null && this.jad_n_na == null) {
            this.jad_n_na = new jad_n_cp();
            viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(this.jad_n_na);
        }
    }

    public final void jad_n_bo(View view) {
        long j10;
        long j11;
        long j12;
        int i10;
        if (view == null || this.jad_n_fs == null || this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_n_an.getInstanceId());
        int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(view.getContext(), view, this.jad_n_an.getInstanceId());
        if (onViewClicked != -2) {
            String jad_n_er = jad_n_er();
            String jad_n_fs = jad_n_fs();
            int jad_n_bo2 = jad_n_bo();
            int jad_n_cp2 = jad_n_cp();
            if (jad_n_dq() != null) {
                int modelClickAreaType = jad_n_dq().getModelClickAreaType();
                jad_n_dq().setClickTime(System.currentTimeMillis());
                long clickTime = jad_n_dq().getClickTime() - jad_n_dq().getLoadTime();
                long clickTime2 = jad_n_dq().getClickTime() - jad_n_dq().getLoadSucTime();
                long clickTime3 = jad_n_dq().getClickTime() - jad_n_dq().getShowTime();
                jad_n_dq().setScdu(clickTime);
                jad_n_dq().setDcdu(clickTime2);
                jad_n_dq().setEcdu(clickTime3);
                jad_n_dq().setAtst(this.jad_n_jw);
                i10 = modelClickAreaType;
                j11 = clickTime2;
                j12 = clickTime3;
                j10 = clickTime;
            } else {
                j10 = 0;
                j11 = 0;
                j12 = 0;
                i10 = 0;
            }
            JADMediator.getInstance().getEventService().reportClickEvent(jad_n_er, jad_n_fs, jad_n_bo2, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs), 2, onViewClicked, j10, j11, j12, this.jad_n_dq, this.jad_n_er, jad_n_cp2, this.jad_n_jw, i10, this.jad_n_hu, this.jad_n_iv);
        }
        JADNativeInteractionListener jADNativeInteractionListener = this.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClick(view);
        }
    }

    public static int jad_n_an(jad_n_hu jad_n_huVar, float f10, float f11, float f12) {
        jad_n_huVar.getClass();
        CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
        int ordinal = adTriggerSourceType.ordinal();
        if (f12 > 0.0f) {
            if (f10 > 0.0f && f11 > 0.0f) {
                return CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
            }
            if (f10 > 0.0f) {
                return CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
            }
            return f11 > 0.0f ? CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal() : ordinal;
        }
        if (f10 > 0.0f && f11 > 0.0f) {
            return CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
        }
        if (f10 > 0.0f) {
            return adTriggerSourceType.ordinal();
        }
        return f11 > 0.0f ? CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal() : ordinal;
    }

    public final int jad_n_cp() {
        if (jad_n_dq() != null) {
            return jad_n_dq().getEventInteractionType();
        }
        return CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    }

    public static boolean jad_n_an(jad_n_hu jad_n_huVar, Context context, String str) {
        ConcurrentHashMap<String, WeakReference<View>> nativeExposureFeedShakeViewMap;
        WeakReference<View> weakReference;
        jad_n_huVar.getClass();
        if (context == null || TextUtils.isEmpty(str) || (nativeExposureFeedShakeViewMap = JADMediator.getInstance().getExposureService().getNativeExposureFeedShakeViewMap()) == null) {
            return false;
        }
        int screenWidth = JADScreenInfoUtils.getScreenWidth(context) / 2;
        int screenHeight = JADScreenInfoUtils.getScreenHeight(context) / 2;
        double d10 = Double.MAX_VALUE;
        String str2 = "";
        for (String str3 : nativeExposureFeedShakeViewMap.keySet()) {
            if (!TextUtils.isEmpty(str3) && (weakReference = nativeExposureFeedShakeViewMap.get(str3)) != null && weakReference.get() != null) {
                View view = weakReference.get();
                if (jad_n_huVar.jad_n_an(view)) {
                    int[] iArr = new int[2];
                    view.getLocationOnScreen(iArr);
                    int i10 = iArr[0];
                    int i11 = iArr[1];
                    int width = view.getWidth();
                    int height = (view.getHeight() / 2) + i11;
                    int abs = Math.abs(((width / 2) + i10) - screenWidth);
                    int abs2 = Math.abs(height - screenHeight);
                    double sqrt = Math.sqrt((abs2 * abs2) + (abs * abs));
                    if (sqrt < d10) {
                        str2 = str3;
                        d10 = sqrt;
                    }
                }
            }
        }
        JADNative jADNative = jad_n_huVar.jad_n_an;
        return jADNative != null && str2.equals(jADNative.getInstanceId());
    }

    public final int jad_n_bo() {
        if (jad_n_dq() != null) {
            return jad_n_dq().getAdType();
        }
        return 0;
    }

    public static void jad_n_an(jad_n_hu jad_n_huVar, boolean z10, String str, int i10) {
        long j10;
        long j11;
        int i11;
        long j12;
        long j13;
        int i12;
        List<View> list;
        View next;
        JADNative jADNative;
        jad_n_huVar.getClass();
        try {
            jad_n_huVar.jad_n_dq = 0;
            jad_n_huVar.jad_n_er = 0;
            if (jad_n_huVar.jad_n_fs != null && (list = jad_n_huVar.jad_n_jt) != null && list.size() != 0) {
                JADNative jADNative2 = jad_n_huVar.jad_n_an;
                if (jADNative2 != null && jADNative2.getSlot() != null && jad_n_huVar.jad_n_an.getSlot().getAdType() != 1) {
                    jad_n_huVar.jad_n_dq = 0;
                    jad_n_huVar.jad_n_er = 100;
                    jad_n_huVar.jad_n_an.getSlot().setSspt(jad_n_huVar.jad_n_dq);
                    jad_n_huVar.jad_n_an.getSlot().setScav(jad_n_huVar.jad_n_er);
                } else {
                    Iterator<View> it = jad_n_huVar.jad_n_jt.iterator();
                    int i13 = 0;
                    while (it.hasNext() && (next = it.next()) != null && (jADNative = jad_n_huVar.jad_n_an) != null && jADNative.getSlot() != null) {
                        int measuredWidth = (int) (jad_n_huVar.jad_n_fs.getMeasuredWidth() * jad_n_huVar.jad_n_fs.getMeasuredHeight());
                        i13 += next.getMeasuredWidth() * next.getMeasuredHeight();
                        if (measuredWidth > 0) {
                            jad_n_huVar.jad_n_er = (i13 * 100) / measuredWidth;
                            if (i13 < measuredWidth) {
                                jad_n_huVar.jad_n_dq = 5;
                            } else {
                                jad_n_huVar.jad_n_dq = 4;
                            }
                        } else {
                            jad_n_huVar.jad_n_dq = 0;
                            jad_n_huVar.jad_n_er = 0;
                        }
                        jad_n_huVar.jad_n_an.getSlot().setSspt(jad_n_huVar.jad_n_dq);
                        jad_n_huVar.jad_n_an.getSlot().setScav(jad_n_huVar.jad_n_er);
                    }
                }
            }
        } catch (Exception e10) {
            StringBuilder a10 = a.a("Exception while calculate area: ");
            a10.append(e10.getMessage());
            Logger.w(a10.toString(), new Object[0]);
        }
        if (z10) {
            String jad_n_er = jad_n_huVar.jad_n_er();
            String jad_n_fs = jad_n_huVar.jad_n_fs();
            int jad_n_bo2 = jad_n_huVar.jad_n_bo();
            if (jad_n_huVar.jad_n_dq() != null) {
                int modelClickAreaType = jad_n_huVar.jad_n_dq().getModelClickAreaType();
                jad_n_huVar.jad_n_dq().setDelayShowTime(System.currentTimeMillis());
                long delayShowTime = jad_n_huVar.jad_n_dq().getDelayShowTime() - jad_n_huVar.jad_n_dq().getLoadTime();
                long delayShowTime2 = jad_n_huVar.jad_n_dq().getDelayShowTime() - jad_n_huVar.jad_n_dq().getLoadSucTime();
                jad_n_huVar.jad_n_dq().setSedu(delayShowTime);
                jad_n_huVar.jad_n_dq().setDedu(delayShowTime2);
                jad_n_huVar.jad_n_dq().setExposureExtend(str);
                jad_n_huVar.jad_n_dq().setDstp(jad_n_huVar.jad_n_hu);
                jad_n_huVar.jad_n_dq().setSrtp(jad_n_huVar.jad_n_iv);
                i12 = modelClickAreaType;
                j12 = delayShowTime;
                j13 = delayShowTime2;
            } else {
                j12 = 0;
                j13 = 0;
                i12 = 0;
            }
            JADMediator.getInstance().getEventService().reportExposureEvent(jad_n_er, jad_n_fs, jad_n_bo2, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs), 2, i10, j12, j13, jad_n_huVar.jad_n_dq, jad_n_huVar.jad_n_er, jad_n_huVar.jad_n_cp(), i12, str, jad_n_huVar.jad_n_hu, jad_n_huVar.jad_n_iv);
            JADNativeInteractionListener jADNativeInteractionListener = jad_n_huVar.jad_n_bo;
            if (jADNativeInteractionListener != null) {
                jADNativeInteractionListener.onExposure();
                return;
            }
            return;
        }
        String jad_n_er2 = jad_n_huVar.jad_n_er();
        String jad_n_fs2 = jad_n_huVar.jad_n_fs();
        int jad_n_bo3 = jad_n_huVar.jad_n_bo();
        if (jad_n_huVar.jad_n_dq() != null) {
            int modelClickAreaType2 = jad_n_huVar.jad_n_dq().getModelClickAreaType();
            jad_n_huVar.jad_n_dq().setShowTime(System.currentTimeMillis());
            long showTime = jad_n_huVar.jad_n_dq().getShowTime() - jad_n_huVar.jad_n_dq().getLoadTime();
            long showTime2 = jad_n_huVar.jad_n_dq().getShowTime() - jad_n_huVar.jad_n_dq().getLoadSucTime();
            jad_n_huVar.jad_n_dq().setSedu(showTime);
            jad_n_huVar.jad_n_dq().setDedu(showTime2);
            jad_n_huVar.jad_n_dq().setExposureExtend(str);
            jad_n_huVar.jad_n_dq().setDstp(jad_n_huVar.jad_n_hu);
            jad_n_huVar.jad_n_dq().setSrtp(jad_n_huVar.jad_n_iv);
            i11 = modelClickAreaType2;
            j10 = showTime;
            j11 = showTime2;
        } else {
            j10 = 0;
            j11 = 0;
            i11 = 0;
        }
        JADMediator.getInstance().getEventService().reportExposureEvent(jad_n_er2, jad_n_fs2, jad_n_bo3, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs2), 2, i10, j10, j11, jad_n_huVar.jad_n_dq, jad_n_huVar.jad_n_er, jad_n_huVar.jad_n_cp(), i11, str, jad_n_huVar.jad_n_hu, jad_n_huVar.jad_n_iv);
    }

    public final boolean jad_n_an(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect) || !view.isShown() || rect.top <= 0) {
            return false;
        }
        int width = rect.width() * rect.height();
        int height = view.getHeight() * view.getWidth();
        return ((width == 0 || height == 0) ? 0 : (int) (new BigDecimal(String.valueOf(width)).divide(new BigDecimal(String.valueOf(height)), 2, RoundingMode.HALF_UP).floatValue() * 100.0f)) == 100;
    }

    public static void jad_n_an(jad_n_hu jad_n_huVar, View view, boolean z10) {
        long j10;
        long j11;
        long j12;
        if (jad_n_huVar.jad_n_cp) {
            return;
        }
        if (jad_n_huVar.jad_n_an != null) {
            try {
                JADMediator.getInstance().getExposureService().setViewForceExposure(jad_n_huVar.jad_n_an.getInstanceId());
                JADMediator.getInstance().getTouchService().unregisterTouchView(jad_n_huVar.jad_n_an.getInstanceId());
                if (jad_n_huVar.jad_n_an.getSlot() != null && jad_n_huVar.jad_n_an.getSlot().getAdType() == 2) {
                    JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(jad_n_huVar.jad_n_an.getInstanceId());
                }
                jad_n_huVar.jad_n_hu();
                jad_n_huVar.jad_n_an(true);
            } catch (Exception e10) {
                StringBuilder a10 = a.a("Exception while close: ");
                a10.append(e10.getMessage());
                Logger.w(a10.toString(), new Object[0]);
            }
        }
        jad_n_huVar.jad_n_cp = true;
        if (z10) {
            String jad_n_er = jad_n_huVar.jad_n_er();
            String jad_n_fs = jad_n_huVar.jad_n_fs();
            int jad_n_bo2 = jad_n_huVar.jad_n_bo();
            if (jad_n_huVar.jad_n_dq() != null) {
                jad_n_huVar.jad_n_dq().setClickTime(System.currentTimeMillis());
                long clickTime = jad_n_huVar.jad_n_dq().getClickTime() - jad_n_huVar.jad_n_dq().getLoadTime();
                long clickTime2 = jad_n_huVar.jad_n_dq().getClickTime() - jad_n_huVar.jad_n_dq().getLoadSucTime();
                long clickTime3 = jad_n_huVar.jad_n_dq().getClickTime() - jad_n_huVar.jad_n_dq().getShowTime();
                jad_n_huVar.jad_n_dq().setScdu(clickTime);
                jad_n_huVar.jad_n_dq().setDcdu(clickTime2);
                jad_n_huVar.jad_n_dq().setEcdu(clickTime3);
                j11 = clickTime2;
                j12 = clickTime3;
                j10 = clickTime;
            } else {
                j10 = 0;
                j11 = 0;
                j12 = 0;
            }
            JADMediator.getInstance().getEventService().reportCloseEvent(jad_n_er, jad_n_fs, jad_n_bo2, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs), 2, -1, j10, j11, j12, jad_n_huVar.jad_n_dq, jad_n_huVar.jad_n_er, CommonConstants.ClickFrom.CLOSE.ordinal(), jad_n_huVar.jad_n_hu, jad_n_huVar.jad_n_iv);
        }
        JADNativeInteractionListener jADNativeInteractionListener = jad_n_huVar.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClose(view);
        }
    }

    public void jad_n_an() {
        try {
            jad_n_hu();
            if (this.jad_n_kx != null) {
                this.jad_n_kx = null;
            }
            jad_n_an(true);
            if (this.jad_n_an != null) {
                JADMediator.getInstance().getExposureService().unregisterExposureView(this.jad_n_an.getInstanceId());
                JADMediator.getInstance().getTouchService().unregisterTouchView(this.jad_n_an.getInstanceId());
                if (this.jad_n_an.getSlot() != null && this.jad_n_an.getSlot().getAdType() == 2) {
                    JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(this.jad_n_an.getInstanceId());
                }
            }
            this.jad_n_bo = null;
            this.jad_n_an = null;
            this.jad_n_fs = null;
            this.jad_n_jt = null;
        } catch (Exception e10) {
            StringBuilder a10 = a.a("Exception while destroy: ");
            a10.append(e10.getMessage());
            Logger.w(a10.toString(), new Object[0]);
        }
    }

    public final void jad_n_an(boolean z10) {
        ViewGroup viewGroup = this.jad_n_fs;
        if (viewGroup == null || this.jad_n_na == null) {
            return;
        }
        viewGroup.getViewTreeObserver().removeOnWindowFocusChangeListener(this.jad_n_na);
        if (z10) {
            this.jad_n_na = null;
        }
    }

    public static void jad_n_an(jad_n_hu jad_n_huVar, boolean z10) {
        if (z10) {
            ShakeListener shakeListener = jad_n_huVar.jad_n_kx;
            if (shakeListener != null) {
                shakeListener.register();
                return;
            }
            return;
        }
        jad_n_huVar.jad_n_hu();
    }
}
