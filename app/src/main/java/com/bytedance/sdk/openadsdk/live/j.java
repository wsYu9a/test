package com.bytedance.sdk.openadsdk.live;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.base.api.ILiveHostContextParam;
import com.bytedance.android.live.base.api.ILiveInitCallback;
import com.bytedance.android.live.base.api.IOuterLiveService;
import com.bytedance.android.openliveplugin.LivePluginHelper;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.api.plugin.gv;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j {

    /* renamed from: j */
    private static SharedPreferences f6482j;

    /* renamed from: com.bytedance.sdk.openadsdk.live.j$1 */
    static class AnonymousClass1 implements TTPluginListener {
        final /* synthetic */ Bundle zx;

        AnonymousClass1(Bundle bundle) {
            bundle = bundle;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public Bundle config() {
            return bundle;
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle) {
            TTPluginListener tTPluginListener = TTPluginListener.this;
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(i2, classLoader, resources, bundle);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTPluginListener
        public String packageName() {
            return "com.byted.live.lite";
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.j$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: g */
        final /* synthetic */ ILiveInitCallback f6484g;

        /* renamed from: i */
        final /* synthetic */ ILiveHostContextParam.Builder f6485i;

        /* renamed from: j */
        final /* synthetic */ Context f6486j;
        final /* synthetic */ String zx;

        AnonymousClass2(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback) {
            context = context;
            str = str;
            builder = builder;
            iLiveInitCallback = iLiveInitCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.live.j$3 */
    static class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LivePluginHelper.initLiveCommerce();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void g(long j2) {
        try {
            Zeus.unInstallPlugin("com.byted.live.lite");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        zx(j2);
    }

    public static boolean i(long j2) {
        int i2;
        if (f6482j == null) {
            f6482j = TTAppContextHolder.getContext().getSharedPreferences("csj_live", 0);
        }
        SharedPreferences sharedPreferences = f6482j;
        if (sharedPreferences != null) {
            i2 = sharedPreferences.getInt("live_init_" + j2, 0);
        } else {
            i2 = 0;
        }
        return i2 < 5;
    }

    public static Bundle j(gv gvVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("app_id", str);
        String j2 = gv.j("com.byted.live.lite");
        if (TextUtils.isEmpty(j2)) {
            j2 = "0.0.0.0";
        }
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, j2);
        bundle.putString("sdk_version", j(TTAppContextHolder.getContext()));
        return bundle;
    }

    public static void zx(long j2) {
        if (f6482j == null) {
            f6482j = TTAppContextHolder.getContext().getSharedPreferences("csj_live", 0);
        }
        try {
            SharedPreferences sharedPreferences = f6482j;
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt("live_init_" + j2, 0);
                edit.commit();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void j(gv gvVar, Bundle bundle, TTPluginListener tTPluginListener) {
        gvVar.zx(new TTPluginListener() { // from class: com.bytedance.sdk.openadsdk.live.j.1
            final /* synthetic */ Bundle zx;

            AnonymousClass1(Bundle bundle2) {
                bundle = bundle2;
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public Bundle config() {
                return bundle;
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public void onPluginListener(int i2, ClassLoader classLoader, Resources resources, Bundle bundle2) {
                TTPluginListener tTPluginListener2 = TTPluginListener.this;
                if (tTPluginListener2 != null) {
                    tTPluginListener2.onPluginListener(i2, classLoader, resources, bundle2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTPluginListener
            public String packageName() {
                return "com.byted.live.lite";
            }
        });
    }

    public static String j(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            String string = applicationInfo.metaData.getString(TTLiveConstants.LIVE_META_KEY);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return gv.j(new JSONObject(string).optInt(TTLiveConstants.LIVE_API_VERSION_KEY));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean j(Context context, String str, ILiveHostContextParam.Builder builder, ILiveInitCallback iLiveInitCallback) {
        try {
            com.bytedance.sdk.openadsdk.zx.j.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.live.j.2

                /* renamed from: g */
                final /* synthetic */ ILiveInitCallback f6484g;

                /* renamed from: i */
                final /* synthetic */ ILiveHostContextParam.Builder f6485i;

                /* renamed from: j */
                final /* synthetic */ Context f6486j;
                final /* synthetic */ String zx;

                AnonymousClass2(Context context2, String str2, ILiveHostContextParam.Builder builder2, ILiveInitCallback iLiveInitCallback2) {
                    context = context2;
                    str = str2;
                    builder = builder2;
                    iLiveInitCallback = iLiveInitCallback2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LivePluginHelper.initLive((Application) context, str, builder, iLiveInitCallback);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static boolean j() {
        try {
            com.bytedance.sdk.openadsdk.zx.j.j().j(new Runnable() { // from class: com.bytedance.sdk.openadsdk.live.j.3
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LivePluginHelper.initLiveCommerce();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean j(Context context, Bundle bundle) {
        if (context != null && bundle != null && bundle.containsKey(TTLiveConstants.ROOMID_KEY)) {
            long j2 = bundle.getLong(TTLiveConstants.ROOMID_KEY);
            try {
                IOuterLiveService iOuterLiveService = (IOuterLiveService) LivePluginHelper.getLiveRoomService();
                if (iOuterLiveService == null) {
                    return false;
                }
                iOuterLiveService.enterLiveRoom(context, j2, bundle);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean j(Context context, Uri uri) {
        if (context != null && uri != null) {
            try {
                IOuterLiveService iOuterLiveService = (IOuterLiveService) LivePluginHelper.getLiveRoomService();
                if (iOuterLiveService != null) {
                    return iOuterLiveService.handleSchema(context, uri);
                }
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void j(long j2) {
        if (f6482j == null) {
            f6482j = TTAppContextHolder.getContext().getSharedPreferences("csj_live", 0);
        }
        try {
            SharedPreferences sharedPreferences = f6482j;
            if (sharedPreferences != null) {
                int i2 = sharedPreferences.getInt("live_init_" + j2, 0);
                SharedPreferences.Editor edit = f6482j.edit();
                edit.putInt("live_init_" + j2, i2 + 1);
                edit.commit();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
