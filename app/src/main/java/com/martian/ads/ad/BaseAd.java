package com.martian.ads.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.MobRewardVideoActivity;
import com.bytedance.sdk.openadsdk.stub.activity.Stub_Standard_Portrait_Activity;
import com.maritan.libads.R;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.utils.n0;
import com.martian.libsupport.l;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class BaseAd {
    private static final String CLOSE_VIEW_ID = "icon_ad_float_close";
    protected AdConfig adConfig;
    private AppTaskList appTaskList;
    protected boolean exposed = false;

    @NonNull
    public b.d.a.k.a receiver;

    public BaseAd() {
    }

    public static void bindHwFlowAd(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, ViewGroup videoView) {
        try {
            Class<?> cls = Class.forName("ad.HwAd");
            cls.getDeclaredMethod("bindFlowAd", Activity.class, AppTask.class, ViewGroup.class, View.class, ViewGroup.class).invoke(cls, activity, appTask, adContainer, adView, videoView);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void bindMiFlowAd(final ViewGroup adContainer, final AppTask appTask, final b.d.a.k.a innerListener) {
        try {
            Class<?> cls = Class.forName("ad.MiAd");
            cls.getDeclaredMethod("bindFlowAd", ViewGroup.class, AppTask.class, b.d.a.k.a.class).invoke(cls, adContainer, appTask, innerListener);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void bindOppoFlowAd(Activity activity, final AppTask appTask, ViewGroup adContainer, View adView, ViewGroup videoView, View creativeView, final b.d.a.k.a innerListener) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("bindFlowAd", Activity.class, AppTask.class, ViewGroup.class, View.class, ViewGroup.class, View.class, b.d.a.k.a.class).invoke(cls, activity, appTask, adContainer, adView, videoView, creativeView, innerListener);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void exitOppoAd(Context context) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("exit", Context.class).invoke(cls, context);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static boolean isHwFlowAd(@NonNull AppTask appTask) {
        return l.J(appTask.origin, "com.huawei.hms.ads.nativead.NativeAd");
    }

    public static boolean isMiFlowAd(@NonNull AppTask appTask) {
        return l.J(appTask.origin, "com.miui.zeus.mimo.sdk.NativeAd");
    }

    public static boolean isOppoFlowAd(@NonNull AppTask appTask) {
        return l.J(appTask.origin, "com.heytap.msp.mobad.api.params.INativeAdvanceData");
    }

    public static boolean isOppoInterstitialAd(@NonNull AppTask appTask) {
        return l.J(appTask.origin, "com.heytap.msp.mobad.api.ad.InterstitialAd");
    }

    public static boolean isOppoSplashAd(@NonNull AppTask appTask) {
        return l.J(appTask.origin, "com.heytap.msp.mobad.api.ad.HotSplashAd");
    }

    public static boolean isOppoVideoAd(@NonNull AppTask appTask) {
        return l.J(appTask.origin, "com.heytap.msp.mobad.api.ad.RewardVideoAd");
    }

    static /* synthetic */ void lambda$showCloseAdIcon$1(final Activity activity) {
        if (n0.C(activity)) {
            ImageView imageView = new ImageView(activity);
            imageView.setId(-513798977);
            imageView.setImageResource(R.drawable.icon_ad_float_close);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(144, 84));
            activity.getWindow().addContentView(imageView, new ViewGroup.LayoutParams(-2, -2));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.ads.ad.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    activity.finish();
                }
            });
        }
    }

    public static void sendOppoInterstitialLossNotification(int winPrice, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("sendInterstitialLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(winPrice), appTask);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void sendOppoLossNotification(int winPrice, AppTask appTask, int reason) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            Class<?> cls2 = Integer.TYPE;
            cls.getDeclaredMethod("sendLossNotification", cls2, AppTask.class, cls2).invoke(cls, Integer.valueOf(winPrice), appTask, Integer.valueOf(reason));
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void sendOppoSplashLossNotification(int winPrice, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("sendSplashLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(winPrice), appTask);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void sendOppoVideoLossNotification(int winPrice, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("sendVideoLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(winPrice), appTask);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void sendOppoWinNotification(AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("sendWinNotification", AppTask.class).invoke(cls, appTask);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static boolean showCloseAdIcon(final Activity activity) {
        if (!(activity instanceof Stub_Standard_Portrait_Activity) && !(activity instanceof MobRewardVideoActivity)) {
            return false;
        }
        if (activity.findViewById(-513798977) != null) {
            return true;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.martian.ads.ad.f
            @Override // java.lang.Runnable
            public final void run() {
                BaseAd.lambda$showCloseAdIcon$1(activity);
            }
        }, 8000L);
        return true;
    }

    public static void showOppoInterstitialAd(final AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("showInterstitialAd", AppTask.class).invoke(cls, appTask);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void showOppoSplashAd(Activity activity, final AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("showSplashAd", Activity.class, AppTask.class).invoke(cls, activity, appTask);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static void showOppoVideoAd(final AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("showVideoAd", AppTask.class).invoke(cls, appTask);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    protected abstract boolean adCanceled();

    public abstract void cancelLoading();

    public AppTaskList getAppTaskList() {
        if (this.appTaskList == null) {
            this.appTaskList = new AppTaskList();
        }
        return this.appTaskList;
    }

    public BaseAd init(AdConfig config, @NonNull b.d.a.k.a receiver) {
        this.adConfig = config;
        this.receiver = receiver;
        return this;
    }

    public abstract void loadAds(Activity activity);

    /* JADX INFO: Access modifiers changed from: protected */
    public void onAdReceived() {
        if (adCanceled()) {
            return;
        }
        cancelLoading();
        this.receiver.d(this.adConfig, getAppTaskList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClick() {
        this.receiver.j(this.adConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClose() {
        this.receiver.b(this.adConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDismiss() {
        this.receiver.c(this.adConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError(b.d.c.b.c errorResult) {
        if (adCanceled()) {
            return;
        }
        cancelLoading();
        if (errorResult == null) {
            errorResult = new b.d.c.b.c(-1, AdConfig.ActionString.FAIL);
        }
        this.receiver.g(this.adConfig, errorResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onExpose() {
        if (this.exposed) {
            return;
        }
        this.exposed = true;
        this.receiver.a(this.adConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRewardVerify(boolean verify) {
        this.receiver.e(this.adConfig, verify);
    }

    public void setAppTaskList(AppTaskList list) {
        this.appTaskList = list;
    }

    public BaseAd(AdConfig config, @NonNull b.d.a.k.a receiver) {
        this.adConfig = config;
        this.receiver = receiver;
    }
}
