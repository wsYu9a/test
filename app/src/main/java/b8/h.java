package b8;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import cn.vlion.ad.inland.ad.interstitial.VlionCustomInterstitialActivity;
import com.baidu.mobads.sdk.api.MobRewardVideoActivity;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.stub.activity.Stub_Standard_Portrait_Activity;
import com.maritan.libads.R;
import com.martian.ads.ad.GroMoreAd;
import com.martian.apptask.data.AppTask;
import java.lang.reflect.InvocationTargetException;
import l9.m0;
import l9.p0;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a */
    public static final String f1434a = "icon_ad_float_close";

    public static void A(int i10, AppTask appTask, int i11) {
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            Class<?> cls2 = Integer.TYPE;
            cls.getDeclaredMethod("sendLossNotification", cls2, AppTask.class, cls2).invoke(cls, Integer.valueOf(i10), appTask, Integer.valueOf(i11));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void B(int i10, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            cls.getDeclaredMethod("sendSplashLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(i10), appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void C(AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            cls.getDeclaredMethod("sendWinNotification", AppTask.class).invoke(cls, appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static boolean D(Activity activity) {
        if (!(activity instanceof Stub_Standard_Portrait_Activity) && !(activity instanceof MobRewardVideoActivity) && !(activity instanceof VlionCustomInterstitialActivity)) {
            return false;
        }
        if (activity.findViewById(-513798977) != null) {
            return true;
        }
        new Handler().postDelayed(new Runnable() { // from class: b8.f

            /* renamed from: b */
            public final /* synthetic */ Activity f1432b;

            public /* synthetic */ f(Activity activity2) {
                activity = activity2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h.t(activity);
            }
        }, 8000L);
        return true;
    }

    public static void E(Activity activity, AppTask appTask, d8.a aVar) {
        try {
            Class<?> cls = Class.forName("ad.HwAd");
            cls.getDeclaredMethod("showInterstitialAd", Activity.class, AppTask.class, d8.a.class).invoke(cls, activity, appTask, aVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void F(Activity activity, AppTask appTask, d8.a aVar) {
        try {
            Class<?> cls = Class.forName("ad.HwAd");
            cls.getDeclaredMethod("showRewardVideoAd", Activity.class, AppTask.class, d8.a.class).invoke(cls, activity, appTask, aVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void G(AppTask appTask, ViewGroup viewGroup, d8.a aVar) {
        try {
            Class<?> cls = Class.forName("ad.HwAd");
            cls.getDeclaredMethod("showSplashAd", AppTask.class, ViewGroup.class, d8.a.class).invoke(cls, appTask, viewGroup, aVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void H(AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("showInterstitialAd", AppTask.class).invoke(cls, appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void I(Activity activity, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("showSplashAd", Activity.class, AppTask.class).invoke(cls, activity, appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void J(AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("showVideoAd", AppTask.class).invoke(cls, appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void K(Activity activity, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            cls.getDeclaredMethod("showInterstitialAd", Activity.class, AppTask.class, Boolean.TYPE).invoke(cls, activity, appTask, Boolean.valueOf(appTask.isBidding()));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void L(AppTask appTask, ViewGroup viewGroup) {
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            cls.getDeclaredMethod("showSplashAd", AppTask.class, ViewGroup.class).invoke(cls, appTask, viewGroup);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void c(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder) {
        try {
            Class<?> cls = Class.forName("ad.HwAd");
            cls.getDeclaredMethod("bindFlowAd", Activity.class, AppTask.class, ViewGroup.class, View.class, GroMoreAd.AdViewHolder.class).invoke(cls, activity, appTask, viewGroup, view, adViewHolder);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void d(ViewGroup viewGroup, AppTask appTask, d8.a aVar) {
        try {
            Class<?> cls = Class.forName("ad.MiAd");
            cls.getDeclaredMethod("bindFlowAd", ViewGroup.class, AppTask.class, d8.a.class).invoke(cls, viewGroup, appTask, aVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void e(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, GroMoreAd.AdViewHolder adViewHolder, d8.a aVar) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("bindFlowAd", Activity.class, AppTask.class, ViewGroup.class, View.class, GroMoreAd.AdViewHolder.class, d8.a.class).invoke(cls, activity, appTask, viewGroup, view, adViewHolder, aVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void f(Activity activity, AppTask appTask, ViewGroup viewGroup, View view, ViewGroup viewGroup2, View view2) {
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            cls.getDeclaredMethod("bindFlowAd", Activity.class, AppTask.class, ViewGroup.class, View.class, ViewGroup.class, View.class).invoke(cls, activity, appTask, viewGroup, view, viewGroup2, view2);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static boolean g(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.huawei.hms.ads.nativead.NativeAd");
    }

    public static boolean h(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.huawei.hms.ads.InterstitialAd");
    }

    public static boolean i(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.huawei.hms.ads.reward.RewardAd");
    }

    public static boolean j(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.huawei.hms.ads.splash.SplashAd");
    }

    public static boolean k(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.miui.zeus.mimo.sdk.NativeAd");
    }

    public static boolean l(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.heytap.msp.mobad.api.params.INativeAdvanceData");
    }

    public static boolean m(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.heytap.msp.mobad.api.ad.InterstitialAd");
    }

    public static boolean n(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.heytap.msp.mobad.api.ad.HotSplashAd");
    }

    public static boolean o(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.heytap.msp.mobad.api.ad.RewardVideoAd");
    }

    public static boolean p(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.vivo.ad.nativead.NativeResponse");
    }

    public static boolean q(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAd");
    }

    public static boolean r(@NonNull AppTask appTask) {
        return ba.m.E(appTask.origin, "com.vivo.mobilead.unified.splash.UnifiedVivoSplashAd");
    }

    public static /* synthetic */ void t(Activity activity) {
        if (m0.C(activity)) {
            ImageView imageView = new ImageView(activity);
            imageView.setId(-513798977);
            imageView.setImageResource(R.drawable.icon_ad_float_close);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS, 84));
            activity.getWindow().addContentView(imageView, new ViewGroup.LayoutParams(-2, -2));
            imageView.setOnClickListener(new View.OnClickListener() { // from class: b8.g

                /* renamed from: b */
                public final /* synthetic */ Activity f1433b;

                public /* synthetic */ g(Activity activity2) {
                    activity = activity2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    activity.finish();
                }
            });
        }
    }

    public static void u(int i10, String str, String str2, String str3, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.HwAd");
            cls.getDeclaredMethod("sendLossNotification", Integer.TYPE, String.class, String.class, String.class, AppTask.class).invoke(cls, Integer.valueOf(i10), str, str2, str3, appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void v(int i10, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("sendInterstitialLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(i10), appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void w(int i10, AppTask appTask, int i11) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            Class<?> cls2 = Integer.TYPE;
            cls.getDeclaredMethod("sendLossNotification", cls2, AppTask.class, cls2).invoke(cls, Integer.valueOf(i10), appTask, Integer.valueOf(i11));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void x(int i10, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("sendSplashLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(i10), appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void y(int i10, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.OppoAd");
            cls.getDeclaredMethod("sendVideoLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(i10), appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }

    public static void z(int i10, AppTask appTask) {
        try {
            Class<?> cls = Class.forName("ad.VivoAd");
            cls.getDeclaredMethod("sendInterstitialLossNotification", Integer.TYPE, AppTask.class).invoke(cls, Integer.valueOf(i10), appTask);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            p0.b(e10.getMessage());
        }
    }
}
