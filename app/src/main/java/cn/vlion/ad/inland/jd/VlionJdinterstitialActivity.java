package cn.vlion.ad.inland.jd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import cn.vlion.ad.inland.base.bid.VlionBiddingActionListener;
import cn.vlion.ad.inland.base.javabean.VlionAdapterADConfig;
import cn.vlion.ad.inland.base.util.config.VlionAdBaseError;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class VlionJdinterstitialActivity extends Activity {

    /* renamed from: b */
    public static VlionBiddingActionListener f3809b;

    /* renamed from: c */
    public static VlionAdapterADConfig f3810c;

    /* renamed from: d */
    public static WeakReference<View> f3811d;

    /* renamed from: e */
    public static WeakReference<Activity> f3812e;

    /* renamed from: a */
    public int f3813a = 0;

    public static void a() {
        try {
            WeakReference<Activity> weakReference = f3812e;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            f3812e.get().finish();
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_vlion_jdinterstitial_container);
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (attributes == null) {
                    attributes = new WindowManager.LayoutParams(-1, -1);
                }
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                if (window.getDecorView() != null) {
                    window.getDecorView().setBackgroundResource(android.R.color.transparent);
                }
                window.setBackgroundDrawableResource(android.R.color.transparent);
            }
            f3812e = new WeakReference<>(this);
            VlionAdapterADConfig vlionAdapterADConfig = f3810c;
            if (vlionAdapterADConfig != null) {
                this.f3813a = vlionAdapterADConfig.getScreenType();
            } else {
                VlionSDkManager.getInstance().upLoadCatchException(new Throwable("cn.vlion.ad.inland.jd.VlionJdinterstitialActivity  onCreate()  mvlionAdapterADConfig is  null "));
                this.f3813a = 0;
            }
            try {
                if (1 == this.f3813a) {
                    setRequestedOrientation(6);
                } else {
                    setRequestedOrientation(1);
                }
            } catch (Throwable th2) {
                VlionBiddingActionListener vlionBiddingActionListener = f3809b;
                if (vlionBiddingActionListener != null) {
                    VlionAdBaseError vlionAdBaseError = VlionAdBaseError.Exception_CODE_ERROR;
                    vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
                }
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.vlion_jd_container);
            WeakReference<View> weakReference = f3811d;
            if (weakReference == null) {
                VlionSDkManager.getInstance().upLoadCatchException(new Throwable("cn.vlion.ad.inland.jd.VlionJdinterstitialActivity  onCreate() weakReferencemJadnative is  null "));
                return;
            }
            View view = weakReference.get();
            if (view == null || frameLayout == null) {
                return;
            }
            try {
                frameLayout.removeAllViews();
                removeFromParent(view);
                frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            } catch (Throwable th3) {
                VlionBiddingActionListener vlionBiddingActionListener2 = f3809b;
                if (vlionBiddingActionListener2 != null) {
                    VlionAdBaseError vlionAdBaseError2 = VlionAdBaseError.Exception_CODE_ERROR;
                    vlionBiddingActionListener2.onAdShowFailure(vlionAdBaseError2.getErrorCode(), vlionAdBaseError2.getErrorMessage());
                }
                VlionSDkManager.getInstance().upLoadCatchException(th3);
            }
        } catch (Throwable th4) {
            VlionBiddingActionListener vlionBiddingActionListener3 = f3809b;
            if (vlionBiddingActionListener3 != null) {
                VlionAdBaseError vlionAdBaseError3 = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener3.onAdShowFailure(vlionAdBaseError3.getErrorCode(), vlionAdBaseError3.getErrorMessage());
            }
            VlionSDkManager.getInstance().upLoadCatchException(th4);
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        VlionBiddingActionListener vlionBiddingActionListener = f3809b;
        if (vlionBiddingActionListener != null) {
            vlionBiddingActionListener.onAdClose();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    public void removeFromParent(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    @Override // android.app.Activity
    public final void setRequestedOrientation(int i10) {
        try {
            if (Build.VERSION.SDK_INT == 26) {
                a(this, i10);
            } else {
                super.setRequestedOrientation(i10);
            }
        } catch (Throwable th2) {
            VlionBiddingActionListener vlionBiddingActionListener = f3809b;
            if (vlionBiddingActionListener != null) {
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            }
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(Activity activity, int i10) {
        if (activity == null) {
            return;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ActivityInfo activityInfo = (ActivityInfo) declaredField.get(activity);
            if (activityInfo == null) {
                return;
            }
            activityInfo.screenOrientation = i10;
            declaredField.setAccessible(false);
        } catch (Throwable th2) {
            VlionBiddingActionListener vlionBiddingActionListener = f3809b;
            if (vlionBiddingActionListener != null) {
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            }
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public static void a(Context context, ViewGroup viewGroup, VlionAdapterADConfig vlionAdapterADConfig, VlionBiddingActionListener vlionBiddingActionListener) {
        if (context == null) {
            return;
        }
        try {
            f3811d = new WeakReference<>(viewGroup);
            f3809b = vlionBiddingActionListener;
            f3810c = vlionAdapterADConfig;
            Intent intent = new Intent(context, (Class<?>) VlionJdinterstitialActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th2) {
            VlionBiddingActionListener vlionBiddingActionListener2 = f3809b;
            if (vlionBiddingActionListener2 != null) {
                VlionAdBaseError vlionAdBaseError = VlionAdBaseError.Exception_CODE_ERROR;
                vlionBiddingActionListener2.onAdShowFailure(vlionAdBaseError.getErrorCode(), vlionAdBaseError.getErrorMessage());
            }
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }
}
