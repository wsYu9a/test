package cn.vlion.ad.inland.kd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener;
import cn.vlion.ad.inland.ad.natives.VlionNativeViewEventManager;
import cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorBean;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorManagerHelper;
import cn.vlion.ad.inland.ad.utils.sensor.VlionSensorPara;
import cn.vlion.ad.inland.ad.view.active.VlionDownloadProgressBar;
import cn.vlion.ad.inland.ad.view.button.VlionButtonSolidBgView;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.app.VlionAppInfo;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.kd.k;
import com.shu.priory.IFLYVideoAd;
import com.shu.priory.conn.NativeDataRef;
import com.shu.priory.conn.VideoDataRef;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class VlionKdRewardVideoActivity extends Activity {

    /* renamed from: l */
    public static WeakReference<IFLYVideoAd> f3845l;

    /* renamed from: m */
    public static WeakReference<VideoDataRef> f3846m;

    /* renamed from: n */
    public static WeakReference<View> f3847n;

    /* renamed from: o */
    public static WeakReference<NativeDataRef> f3848o;

    /* renamed from: p */
    public static WeakReference<VlionAdapterADConfig> f3849p;

    /* renamed from: q */
    public static f f3850q;

    /* renamed from: r */
    public static boolean f3851r;

    /* renamed from: s */
    public static boolean f3852s;

    /* renamed from: t */
    public static WeakReference<VlionKdRewardVideoActivity> f3853t;

    /* renamed from: a */
    public FrameLayout f3854a;

    /* renamed from: b */
    public FrameLayout f3855b;

    /* renamed from: c */
    public TextView f3856c;

    /* renamed from: d */
    public VlionDownloadProgressBar f3857d;

    /* renamed from: e */
    public VlionButtonSolidBgView f3858e;

    /* renamed from: f */
    public ImageView f3859f;

    /* renamed from: h */
    public FrameLayout f3861h;

    /* renamed from: i */
    public VlionSensorBean f3862i;

    /* renamed from: k */
    public VlionNativeViewEventManager f3864k;

    /* renamed from: g */
    public IFLYVideoAd f3860g = null;

    /* renamed from: j */
    public boolean f3863j = false;

    public class a implements VlionCustomsNativeEventListener {
        public a() {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void isResume(boolean z10) {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onAdEnter() {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onClick(VlionADClickType vlionADClickType) {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onClose() {
        }

        @Override // cn.vlion.ad.inland.ad.natives.VlionCustomsNativeEventListener
        public final void onExposure() {
            try {
                LogVlion.e("VlionKdRewardVideoActivity onAdExposure ");
                VlionKdRewardVideoActivity.a(VlionKdRewardVideoActivity.this);
                if (VlionKdRewardVideoActivity.this.f3864k != null) {
                    VlionKdRewardVideoActivity.this.f3864k.destroy();
                    VlionKdRewardVideoActivity.this.f3864k = null;
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VlionKdRewardVideoActivity.d(VlionKdRewardVideoActivity.this);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VlionKdRewardVideoActivity.d(VlionKdRewardVideoActivity.this);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VlionKdRewardVideoActivity.this.finish();
        }
    }

    public class e implements SensorManagerManager.OnShakeListener {
        public e() {
        }

        @Override // cn.vlion.ad.inland.ad.utils.sensor.SensorManagerManager.OnShakeListener
        public final void onShake(boolean z10, VlionSensorPara vlionSensorPara) {
            try {
                LogVlion.e("VlionKdRewardVideoActivity onShake =");
                if (VlionKdRewardVideoActivity.this.f3863j) {
                    return;
                }
                VlionKdRewardVideoActivity.this.f3863j = true;
                VlionSensorManagerHelper.getInstance().unregisterShakeListener(VlionKdRewardVideoActivity.this.f3862i);
                VlionKdRewardVideoActivity.this.f3862i = null;
                VlionKdRewardVideoActivity.f3852s = false;
                if (VlionKdRewardVideoActivity.this.f3858e != null) {
                    VlionKdRewardVideoActivity.this.f3858e.setShakeStyle(VlionKdRewardVideoActivity.this.getResources().getString(cn.vlion.ad.inland.base.R.string.vlion_custom_ad_click_look), VlionKdRewardVideoActivity.f3852s);
                }
                if (VlionKdRewardVideoActivity.this.f3857d != null) {
                    VlionKdRewardVideoActivity.this.f3857d.setShakeStyle(VlionKdRewardVideoActivity.this.getResources().getString(cn.vlion.ad.inland.base.R.string.vlion_custom_ad_click_look), VlionKdRewardVideoActivity.f3852s);
                }
                VlionKdRewardVideoActivity.d(VlionKdRewardVideoActivity.this);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public interface f {
        void onAdClose();

        void onClick();

        void onExposure();
    }

    public static void a(Context context, ImageView imageView, NativeDataRef nativeDataRef, boolean z10, VlionAdapterADConfig vlionAdapterADConfig, k.b bVar) {
        if (context == null) {
            return;
        }
        try {
            f3851r = true;
            f3852s = z10;
            f3847n = new WeakReference<>(imageView);
            f3848o = new WeakReference<>(nativeDataRef);
            f3849p = new WeakReference<>(vlionAdapterADConfig);
            f3850q = bVar;
            if (vlionAdapterADConfig != null && vlionAdapterADConfig.getAccelerate() == 0 && vlionAdapterADConfig.getAngle() == 0 && vlionAdapterADConfig.getShakeDuration() == 0) {
                f3852s = false;
            }
            Intent intent = new Intent(context, (Class<?>) VlionKdRewardVideoActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void c() {
        try {
            LogVlion.e("VlionKdRewardVideoActivity initImage------------");
            WeakReference<View> weakReference = f3847n;
            View view = weakReference != null ? weakReference.get() : null;
            WeakReference<NativeDataRef> weakReference2 = f3848o;
            NativeDataRef nativeDataRef = weakReference2 != null ? weakReference2.get() : null;
            if (view == null || nativeDataRef == null) {
                finish();
            }
            if (view != null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f3854a.addView(view);
            } else {
                finish();
            }
            if (nativeDataRef != null) {
                this.f3856c.setText(nativeDataRef.getTitle());
                VlionKDAdapter.a(this.f3859f, nativeDataRef.getIconUrl());
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void d() {
        WeakReference<VlionAdapterADConfig> weakReference;
        VlionAdapterADConfig vlionAdapterADConfig;
        try {
            if (!f3852s || this.f3863j || (weakReference = f3849p) == null || (vlionAdapterADConfig = weakReference.get()) == null) {
                return;
            }
            this.f3862i = new VlionSensorBean(vlionAdapterADConfig.getAccelerate(), vlionAdapterADConfig.getAngle(), vlionAdapterADConfig.getShakeDuration(), new e());
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public final void e() {
        try {
            LogVlion.e("VlionKdRewardVideoActivity initVideo------------");
            WeakReference<IFLYVideoAd> weakReference = f3845l;
            if (weakReference != null) {
                this.f3860g = weakReference.get();
            }
            WeakReference<VideoDataRef> weakReference2 = f3846m;
            VideoDataRef videoDataRef = weakReference2 != null ? weakReference2.get() : null;
            if (this.f3860g == null || videoDataRef == null) {
                finish();
            }
            IFLYVideoAd iFLYVideoAd = this.f3860g;
            if (iFLYVideoAd == null || iFLYVideoAd.getVideoView() == null) {
                finish();
            } else {
                ViewGroup videoView = this.f3860g.getVideoView();
                videoView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                this.f3854a.addView(videoView);
            }
            if (videoDataRef != null) {
                this.f3856c.setText(videoDataRef.getTitle());
                VlionKDAdapter.a(this.f3859f, videoDataRef.getIconUrl());
            }
            this.f3860g.showAd(1);
            IFLYVideoAd iFLYVideoAd2 = this.f3860g;
            if (iFLYVideoAd2 == null || iFLYVideoAd2.isPlaying()) {
                return;
            }
            this.f3860g.startPlay();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.vlion_cn_kd_reward_media);
            this.f3861h = (FrameLayout) findViewById(R.id.fl_reward_video_root);
            this.f3854a = (FrameLayout) findViewById(R.id.fl_reward_video);
            this.f3855b = (FrameLayout) findViewById(R.id.vilon_close_miss);
            this.f3856c = (TextView) findViewById(R.id.vlion_ad_app_title);
            this.f3857d = (VlionDownloadProgressBar) findViewById(R.id.vlion_ad_app_action);
            this.f3858e = (VlionButtonSolidBgView) findViewById(R.id.vlion_button_solidbg_download_view);
            this.f3859f = (ImageView) findViewById(R.id.vlion_ad_app_icon);
            f3853t = new WeakReference<>(this);
            this.f3864k = new VlionNativeViewEventManager(this, this.f3854a, null, null, "", null, new a());
            if (f3851r) {
                c();
            } else {
                e();
            }
            if (VlionServiceConfigParse.getInstance().isHotspot()) {
                findViewById(R.id.vlion_kd_fl_reward_video).setOnClickListener(new b());
            }
            this.f3857d.setOnClickListener(new c());
            this.f3855b.setOnClickListener(new d());
            this.f3857d.setShakeStyle(getResources().getString(cn.vlion.ad.inland.base.R.string.vlion_custom_ad_click_look), f3852s);
            d();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            LogVlion.e("VlionKdRewardVideoActivity onDestroy------------");
            IFLYVideoAd iFLYVideoAd = this.f3860g;
            if (iFLYVideoAd != null) {
                iFLYVideoAd.release();
                this.f3860g = null;
            }
            WeakReference<IFLYVideoAd> weakReference = f3845l;
            if (weakReference != null) {
                weakReference.clear();
                f3845l = null;
            }
            WeakReference<VideoDataRef> weakReference2 = f3846m;
            if (weakReference2 != null) {
                weakReference2.clear();
                f3846m = null;
            }
            WeakReference<View> weakReference3 = f3847n;
            if (weakReference3 != null) {
                weakReference3.clear();
                f3847n = null;
            }
            WeakReference<NativeDataRef> weakReference4 = f3848o;
            if (weakReference4 != null) {
                weakReference4.clear();
                f3848o = null;
            }
            f fVar = f3850q;
            if (fVar != null) {
                fVar.onAdClose();
                f3850q = null;
            }
            VlionNativeViewEventManager vlionNativeViewEventManager = this.f3864k;
            if (vlionNativeViewEventManager != null) {
                vlionNativeViewEventManager.destroy();
                this.f3864k = null;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        try {
            LogVlion.e("VlionKdRewardVideoActivity onKeyDown------------");
            if (i10 == 4) {
                return true;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        try {
            LogVlion.e("VlionKdRewardVideoActivity onPause------------");
            IFLYVideoAd iFLYVideoAd = this.f3860g;
            if (iFLYVideoAd != null && iFLYVideoAd.isPlaying()) {
                this.f3860g.onPause();
            }
            VlionSensorManagerHelper.getInstance().unregisterShakeListener(this.f3862i);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        try {
            VlionAppInfo.getInstance().hideNavigationBar(this);
            LogVlion.e("VlionKdRewardVideoActivity onResume------------");
            IFLYVideoAd iFLYVideoAd = this.f3860g;
            if (iFLYVideoAd != null) {
                iFLYVideoAd.onResume();
            }
            if (f3852s) {
                VlionSensorManagerHelper.getInstance().registerShakeListener(getApplicationContext(), this.f3862i);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(Context context, IFLYVideoAd iFLYVideoAd, VideoDataRef videoDataRef, boolean z10, VlionAdapterADConfig vlionAdapterADConfig, f fVar) {
        if (context == null) {
            return;
        }
        try {
            f3851r = false;
            f3852s = z10;
            f3845l = new WeakReference<>(iFLYVideoAd);
            f3846m = new WeakReference<>(videoDataRef);
            f3849p = new WeakReference<>(vlionAdapterADConfig);
            f3850q = fVar;
            if (vlionAdapterADConfig != null && vlionAdapterADConfig.getAccelerate() == 0 && vlionAdapterADConfig.getAngle() == 0 && vlionAdapterADConfig.getShakeDuration() == 0) {
                f3852s = false;
            }
            Intent intent = new Intent(context, (Class<?>) VlionKdRewardVideoActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void d(VlionKdRewardVideoActivity vlionKdRewardVideoActivity) {
        VideoDataRef videoDataRef;
        IFLYVideoAd iFLYVideoAd;
        NativeDataRef nativeDataRef;
        vlionKdRewardVideoActivity.getClass();
        try {
            LogVlion.e("VlionKdRewardVideoActivity adOnClick------------");
            WeakReference<NativeDataRef> weakReference = f3848o;
            if (weakReference != null && (nativeDataRef = weakReference.get()) != null) {
                LogVlion.e("VlionKdRewardVideoActivity adOnClick------------" + nativeDataRef.onClick(vlionKdRewardVideoActivity.f3861h, 2));
            }
            WeakReference<VideoDataRef> weakReference2 = f3846m;
            if (weakReference2 != null && (videoDataRef = weakReference2.get()) != null && (iFLYVideoAd = vlionKdRewardVideoActivity.f3860g) != null) {
                LogVlion.e("VlionKdRewardVideoActivity adOnClick Video------------" + videoDataRef.onClick(iFLYVideoAd.getVideoView(), 2));
            }
            f fVar = f3850q;
            if (fVar != null) {
                fVar.onClick();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(VlionKdRewardVideoActivity vlionKdRewardVideoActivity) {
        VideoDataRef videoDataRef;
        IFLYVideoAd iFLYVideoAd;
        NativeDataRef nativeDataRef;
        vlionKdRewardVideoActivity.getClass();
        try {
            LogVlion.e("VlionKdRewardVideoActivity adOnExposure------------");
            WeakReference<NativeDataRef> weakReference = f3848o;
            if (weakReference != null && (nativeDataRef = weakReference.get()) != null) {
                LogVlion.e("VlionKdRewardVideoActivity adOnExposure------------" + nativeDataRef.onExposure(vlionKdRewardVideoActivity.f3861h));
            }
            WeakReference<VideoDataRef> weakReference2 = f3846m;
            if (weakReference2 != null && (videoDataRef = weakReference2.get()) != null && (iFLYVideoAd = vlionKdRewardVideoActivity.f3860g) != null) {
                LogVlion.e("VlionKdRewardVideoActivity adOnExposure Video------------" + videoDataRef.onExposure(iFLYVideoAd.getVideoView()));
            }
            f fVar = f3850q;
            if (fVar != null) {
                fVar.onExposure();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
