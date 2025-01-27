package com.jd.ad.sdk.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_s_an.jad_s_fs;
import com.jd.ad.sdk.jad_s_an.jad_s_hu;
import com.jd.ad.sdk.jad_s_an.jad_s_iv;
import com.jd.ad.sdk.jad_s_an.jad_s_jt;
import com.jd.ad.sdk.jad_s_an.jad_s_jw;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.JADSplash;
import f7.a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_s_an implements DynamicRenderView.IDynamicRenderCallback {
    public WeakReference<Context> jad_s_an;
    public final JADSlot jad_s_bo;
    public String jad_s_cp;
    public String jad_s_dq;
    public String jad_s_er;
    public int jad_s_fs;
    public jad_s_cp jad_s_hu;
    public View jad_s_iv;
    public View jad_s_jt;
    public int jad_s_jw;
    public JADSplashSkipView jad_s_kx;
    public JADSplashCountDownListener jad_s_ly;
    public JADSplashVideoListener jad_s_mz;
    public boolean jad_s_na;
    public boolean jad_s_ob;
    public jad_s_jw jad_s_pc;
    public long jad_s_qd = 0;
    public OnVideoRenderListener jad_s_re = null;
    public VideoLoadListener jad_s_sf = null;

    /* renamed from: com.jd.ad.sdk.splash.jad_s_an$jad_s_an */
    public class C0359jad_s_an implements OnImageLoadListener {
        public final /* synthetic */ ImageView jad_s_an;
        public final /* synthetic */ View jad_s_bo;

        public C0359jad_s_an(ImageView imageView, View view) {
            this.jad_s_an = imageView;
            this.jad_s_bo = view;
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i10, String str, @Nullable Drawable drawable) {
            jad_s_an jad_s_anVar = jad_s_an.this;
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_an.this.jad_s_er, jADError.getCode(), jad_s_anVar.jad_s_an(jADError.getMessage(new String[0])), jad_s_an.this.jad_s_fs);
            jad_s_an.jad_s_an(jad_s_an.this, jADError.getCode(), jADError.getMessage(new String[0]));
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(@NonNull Drawable drawable) {
            ImageView imageView = this.jad_s_an;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            jad_s_an.this.jad_s_an(this.jad_s_bo, 1);
        }
    }

    public class jad_s_bo implements View.OnTouchListener {
        public jad_s_bo(jad_s_an jad_s_anVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public interface jad_s_cp {
    }

    public jad_s_an(Context context, JADSlot jADSlot, String str, String str2) {
        this.jad_s_cp = "";
        this.jad_s_dq = "";
        this.jad_s_er = "";
        this.jad_s_fs = 0;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.jad_s_an = new WeakReference<>(context);
        }
        this.jad_s_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_s_er = jADSlot.getRequestId();
            this.jad_s_fs = jADSlot.getSen();
        }
        this.jad_s_dq = str;
        this.jad_s_cp = str2;
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, View view) {
        jad_s_anVar.getClass();
        JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_anVar.jad_s_dq);
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.reportCloseEvent(CommonConstants.ClickFrom.CLOSE.ordinal());
            if (view != null) {
                JADSplash.this.callbackAdCloseOnUiThread();
            }
        }
    }

    public void jad_s_bo(int i10, String str) {
        try {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, i10, jad_s_an(str), this.jad_s_fs);
            jad_s_cp jad_s_cpVar = this.jad_s_hu;
            if (jad_s_cpVar != null) {
                JADSplash.this.callbackAdRenderFailedOnUiThread(i10, str);
            }
        } catch (Exception e10) {
            Logger.d(Log.getStackTraceString(e10));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onAnimationEnd() {
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.callbackAdCloseOnUiThread();
            JADSplash.this.destroy();
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderFailed(int i10, String str) {
        if (jad_s_an() == null) {
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, jADError.getCode(), jad_s_an(jADError.getMessage(new String[0])), this.jad_s_fs);
            jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        Context jad_s_an = jad_s_an();
        JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        int code = jADError2.getCode();
        String message = jADError2.getMessage(new String[0]);
        if (jad_s_an == null || this.jad_s_bo == null) {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
        }
        this.jad_s_bo.setRem(1);
        int templateId = this.jad_s_bo.getTemplateId();
        View view = null;
        if (templateId == CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_4.getTemplateId() || templateId == CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_8.getTemplateId()) {
            try {
                view = LayoutInflater.from(jad_s_an).inflate(ResourceUtils.getResourceId(jad_s_an, "jad_splash_layout", "layout"), (ViewGroup) null);
            } catch (Exception e10) {
                Logger.w("Exception while render: " + e10, new Object[0]);
            }
        } else {
            JADError jADError3 = JADError.RENDER_SPLASH_RESPONSE_TEMPLATE_ID_ERROR;
            code = jADError3.getCode();
            message = jADError3.getMessage(new String[0]);
        }
        if (view == null) {
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int dip2px = (int) ScreenUtils.dip2px(jad_s_an, this.jad_s_bo.getWidth());
        int dip2px2 = (int) ScreenUtils.dip2px(jad_s_an, this.jad_s_bo.getHeight());
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(dip2px, dip2px2);
        } else {
            layoutParams.height = dip2px2;
            layoutParams.width = dip2px;
        }
        view.setLayoutParams(layoutParams);
        try {
            this.jad_s_kx = (JADSplashSkipView) view.findViewById(ResourceUtils.getResourceId(jad_s_an, "jad_splash_skip_btn", "id"));
        } catch (Exception e11) {
            Logger.d("Exception while render: " + e11);
        }
        if (this.jad_s_kx != null) {
            if (this.jad_s_bo.isHideSkip()) {
                this.jad_s_kx.setVisibility(8);
            } else {
                this.jad_s_kx.setVisibility(0);
            }
            JADSplashSkipView jADSplashSkipView = this.jad_s_kx;
            int skipTime = this.jad_s_bo.getSkipTime();
            com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar = new com.jd.ad.sdk.splash.jad_s_bo(this);
            jADSplashSkipView.jad_s_an = skipTime;
            jADSplashSkipView.jad_s_bo = jad_s_boVar;
            jADSplashSkipView.setOnClickListener(new jad_s_dq(jADSplashSkipView));
        }
        try {
            ImageView imageView = (ImageView) view.findViewById(ResourceUtils.getResourceId(jad_s_an(), "jad_splash_image", "id"));
            jad_s_an(imageView, view);
            jad_s_an(jad_s_an(), view, imageView);
        } catch (Exception e12) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str2 = this.jad_s_er;
            JADError jADError4 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str2, jADError4.getCode(), jADError4.getMessage(e12.toString()), this.jad_s_fs);
            jad_s_an(jADError4.getCode(), jADError4.getMessage(e12.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderSuccess(View view) {
        try {
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            String message = jADError.getMessage(new String[0]);
            if (view != null && this.jad_s_bo != null) {
                this.jad_s_iv = view;
                jad_s_an(view, 3);
                return;
            }
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
        } catch (Exception e10) {
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            jad_s_an(jADError2.getCode(), jADError2.getMessage(e10.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public /* synthetic */ void onFullLottieViewClick(Context context) {
        a.b(this, context);
    }

    public static float jad_s_an(jad_s_an jad_s_anVar, float f10) {
        jad_s_anVar.getClass();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("xlog--transferDuration:");
        sb2.append(f10);
        sb2.append(",result: ");
        float f11 = f10 / 1000.0f;
        sb2.append(f11);
        Logger.d(sb2.toString());
        return f11;
    }

    public final FrameLayout.LayoutParams jad_s_bo() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    @Nullable
    public final Context jad_s_an() {
        WeakReference<Context> weakReference = this.jad_s_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public JSONObject jad_s_an(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        String message = exc.getMessage();
        int code = JADError.RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR.getCode();
        try {
            try {
                for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                    String message2 = cause.getMessage();
                    if (!TextUtils.isEmpty(message2) && message2.startsWith("40")) {
                        String[] split = message2.split("-");
                        code = Integer.parseInt(split[0]);
                        message = message + "|" + split[1];
                    } else {
                        message = message + "|" + message2;
                    }
                }
                jSONObject.put("code", code);
                jSONObject.put("msg", message);
            } catch (Exception unused) {
                Logger.d("错误信息拼接异常");
                jSONObject.put("code", code);
                jSONObject.put("msg", message);
            }
            return jSONObject;
        } catch (Throwable th2) {
            jSONObject.put("code", code);
            jSONObject.put("msg", message);
            throw th2;
        }
    }

    public String jad_s_an(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.jad_s_bo;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
        } else {
            str2 = "";
        }
        JsonUtils.put(jSONObject, ExposeManager.UtArgsNames.pid, str2);
        JsonUtils.put(jSONObject, "adt", 1);
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    @SuppressLint({"InflateParams"})
    public final void jad_s_an(Context context, View view, ImageView imageView) {
        if (context == null || this.jad_s_bo == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(ResourceUtils.getResourceId(jad_s_an(), "jad_splash_click_area_container", "id"));
        LayoutInflater from = LayoutInflater.from(context);
        int modelClickAreaType = this.jad_s_bo.getModelClickAreaType();
        int jad_s_an = jad_s_iv.jad_s_an(modelClickAreaType == 1 ? 2 : modelClickAreaType == 2 ? 3 : modelClickAreaType == 3 ? 4 : modelClickAreaType == 4 ? 5 : 1);
        if (jad_s_an == 1) {
            frameLayout.addView(from.inflate(ResourceUtils.getResourceId(context, "jad_splash_click_area_type1", "layout"), (ViewGroup) null), jad_s_bo());
            frameLayout.setVisibility(0);
            this.jad_s_iv = view;
            this.jad_s_jw = 1;
            return;
        }
        if (jad_s_an == 3) {
            frameLayout.setVisibility(8);
            this.jad_s_iv = view;
            this.jad_s_jw = 3;
        } else {
            if (jad_s_an != 4) {
                View inflate = from.inflate(ResourceUtils.getResourceId(context, "jad_splash_click_area_type2", "layout"), (ViewGroup) null);
                imageView.setOnTouchListener(new jad_s_bo(this));
                frameLayout.addView(inflate, jad_s_bo());
                frameLayout.setVisibility(0);
                this.jad_s_iv = inflate;
                this.jad_s_jw = 2;
                return;
            }
            frameLayout.addView(from.inflate(ResourceUtils.getResourceId(context, "jad_splash_click_area_type2", "layout"), (ViewGroup) null), jad_s_bo());
            frameLayout.setVisibility(0);
            this.jad_s_iv = view;
            this.jad_s_jw = 4;
        }
    }

    public final void jad_s_an(ImageView imageView, View view) {
        if (jad_s_an() != null) {
            if (TextUtils.isEmpty(this.jad_s_cp)) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String str = this.jad_s_er;
                JADError jADError = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
                eventService.reportRenderFailedEvent(str, jADError.getCode(), jad_s_an(jADError.getMessage(new String[0])), this.jad_s_fs);
                jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
                return;
            }
            JADMediator.getInstance().getFoundationService().loadImage(jad_s_an(), this.jad_s_cp, new C0359jad_s_an(imageView, view));
            return;
        }
        JADEventService eventService2 = JADMediator.getInstance().getEventService();
        String str2 = this.jad_s_er;
        JADError jADError2 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
        eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jad_s_an(jADError2.getMessage(new String[0])), this.jad_s_fs);
        jad_s_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, Context context, View view, int i10, int i11, int i12) {
        if (jad_s_anVar.jad_s_jt != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_anVar.jad_s_dq);
        }
        int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(context, view, jad_s_anVar.jad_s_dq);
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.reportClickEvent(onViewClicked, i10, i11, i12);
            JADSplash.this.callbackAdClickOnUiThread();
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, View view, boolean z10, String str, int i10, int i11) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.calculateClickArea();
            if (z10) {
                JADSplash.this.reportDelayExposureEvent(str, i10, i11);
                JADSplash.this.callbackAdShowedOnUiThread();
            } else {
                JADSplash.this.reportExposureEvent(str, i10, i11);
            }
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.jad_s_er jad_s_erVar = (JADSplash.jad_s_er) jad_s_cpVar;
            JADSplash.this.callbackAdCloseOnUiThread();
            JADSplash.this.destroy();
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, int i10, String str) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdRenderFailedOnUiThread(i10, str);
        }
    }

    public final void jad_s_an(int i10, String str) {
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdRenderFailedOnUiThread(i10, str);
        }
    }

    public final void jad_s_an(@NonNull View view, int i10) {
        this.jad_s_jt = view;
        if (view != null) {
            JADMediator.getInstance().getExposureService().registerExposureView(this.jad_s_dq);
            View view2 = this.jad_s_jt;
            JADMediator.getInstance().getExposureService().setViewExposureCallback(this.jad_s_dq, 1, view2, new com.jd.ad.sdk.jad_s_an.jad_s_er(this, i10, view2));
        }
        if (this.jad_s_iv != null) {
            JADMediator.getInstance().getTouchService().registerTouchView(this.jad_s_dq);
            if (i10 == 3) {
                try {
                    if (jad_s_an() != null) {
                        JADMediator.getInstance().getDynamicRenderService().registerAdViewClick(jad_s_an(), (DynamicRenderView) this.jad_s_jt, new jad_s_fs(this));
                    }
                } catch (Exception e10) {
                    Logger.d(Log.getStackTraceString(e10));
                }
            } else if (this.jad_s_ob) {
                try {
                    if (jad_s_an() != null) {
                        JADMediator.getInstance().getVideoRenderService().registerAdViewClick(jad_s_an(), (VideoRenderView) this.jad_s_jt, new jad_s_jt(this));
                    }
                } catch (Exception e11) {
                    Logger.d(Log.getStackTraceString(e11));
                }
            } else {
                View view3 = this.jad_s_iv;
                if (view3 != null) {
                    view3.setClickable(true);
                    this.jad_s_iv.setOnTouchListener(new jad_s_hu(this));
                    this.jad_s_iv.setOnClickListener(new com.jd.ad.sdk.jad_s_an.jad_s_an(this));
                }
            }
        }
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdReadyOnUiThread(view);
        }
    }

    public static void jad_s_an(jad_s_an jad_s_anVar, int i10) {
        jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.callbackAdCountDownOnUiThread(i10);
        }
    }
}
