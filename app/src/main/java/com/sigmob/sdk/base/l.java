package com.sigmob.sdk.base;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestQueue;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.VolleyError;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.models.config.SigmobAndroid;
import com.sigmob.sdk.base.models.config.SigmobCommon;
import com.sigmob.sdk.base.models.config.SigmobCommonEndpointsConfig;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.config.SigmobNativeConfig;
import com.sigmob.sdk.base.models.config.SigmobRvConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfig;
import com.sigmob.sdk.base.models.config.SigmobSdkConfigResponse;
import com.sigmob.sdk.base.models.config.SigmobSplashConfig;
import com.sigmob.sdk.base.network.e;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public class l {

    /* renamed from: i */
    public static final String f18195i = "sdkConfigVer";

    /* renamed from: j */
    public static l f18196j = null;

    /* renamed from: k */
    public static boolean f18197k = false;

    /* renamed from: l */
    public static String f18198l = null;

    /* renamed from: m */
    public static boolean f18199m = false;

    /* renamed from: h */
    public c f18207h;

    /* renamed from: c */
    public final String f18202c = k.f18179k;

    /* renamed from: e */
    public long f18204e = 0;

    /* renamed from: f */
    public SigmobSdkConfig f18205f = null;

    /* renamed from: g */
    public SigmobSdkConfig f18206g = null;

    /* renamed from: a */
    public final Handler f18200a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    public final Runnable f18201b = new a();

    /* renamed from: d */
    public boolean f18203d = true;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.i0();
        }
    }

    public class b implements e.a {

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ SigmobSdkConfig f18210a;

            public a(SigmobSdkConfig sigmobSdkConfig) {
                this.f18210a = sigmobSdkConfig;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.a(this.f18210a, true);
            }
        }

        public b() {
        }

        @Override // com.sigmob.sdk.base.network.e.a
        public void a(SigmobSdkConfigResponse sigmobSdkConfigResponse) {
            boolean unused = l.f18199m = false;
            SigmobLog.d(sigmobSdkConfigResponse.toString());
            SigmobSdkConfig sigmobSdkConfig = sigmobSdkConfigResponse.config;
            if (sigmobSdkConfig != null) {
                WindAds.sharedAds().getHandler().post(new a(sigmobSdkConfig));
                l.this.a(sigmobSdkConfig);
            } else {
                SigmobLog.e(sigmobSdkConfigResponse.error_message);
            }
            l.this.j0();
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            String unused = l.f18198l = l.this.m();
            if (l.f18199m) {
                l.this.j0();
            } else {
                boolean unused2 = l.f18199m = true;
                l.this.f18200a.post(l.this.f18201b);
            }
            SigmobLog.e(volleyError.toString());
        }
    }

    public interface c {
        void a(boolean z10);
    }

    public l() {
        Q();
    }

    public static boolean b0() {
        return f18197k;
    }

    public static String k0() {
        return "appId=" + WindAds.sharedAds().getAppId() + "&sdkVersion=4.19.1";
    }

    public static String r() {
        String str;
        if (!TextUtils.isEmpty(f18198l)) {
            if (f18198l.indexOf(63) == -1) {
                return f18198l + "?" + k0();
            }
            return f18198l + "&" + k0();
        }
        WindAdOptions options = WindAds.sharedAds().getOptions();
        if (options != null && options.getExtData() != null && (str = options.getExtData().get(k.f18172d)) != null && !TextUtils.isEmpty(str)) {
            if (str.indexOf(63) == -1) {
                return str + "?" + k0();
            }
            return str + "&" + k0();
        }
        String str2 = "https://" + k.f18175g;
        if (TextUtils.isEmpty(str2)) {
            return "https://" + k.f18175g + "?" + k0();
        }
        if (str2.indexOf(63) == -1) {
            return str2 + "?" + k0();
        }
        return str2 + "&" + k0();
    }

    public static String u() {
        return "https://" + k.T + "?" + k0();
    }

    public static synchronized l w() {
        l lVar;
        synchronized (l.class) {
            try {
                if (f18196j == null) {
                    f18196j = new l();
                }
                lVar = f18196j;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return lVar;
    }

    public int A() {
        Integer num = SigmobCommon.DEFAULT_MAX_SEND_LOG_RECORDS;
        int intValue = num.intValue();
        if (q() != null) {
            intValue = ((Integer) Wire.get(q().max_send_log_records, num)).intValue();
        }
        return intValue < 10 ? num.intValue() : intValue;
    }

    public int B() {
        if (!d() || q().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return ((Integer) Wire.get(q().anti_fraud_log.motion_config.count, 0)).intValue();
    }

    public int C() {
        if (!d() || q().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return ((Integer) Wire.get(q().anti_fraud_log.motion_config.interval, 0)).intValue();
    }

    public int D() {
        if (!d() || q().anti_fraud_log.motion_config == null) {
            return 0;
        }
        return q().anti_fraud_log.motion_config.queue_max.intValue() + (-50) < q().anti_fraud_log.motion_config.count.intValue() * 2 ? (((Integer) Wire.get(q().anti_fraud_log.motion_config.count, 0)).intValue() * 2) + 50 : ((Integer) Wire.get(q().anti_fraud_log.motion_config.queue_max, 0)).intValue();
    }

    public int E() {
        if (F() != null) {
            return ((Integer) Wire.get(F().cacheTop, 50)).intValue();
        }
        return 50;
    }

    public final SigmobNativeConfig F() {
        if (q() != null) {
            return q().native_config;
        }
        return null;
    }

    public final int G() {
        SigmobCommon q10 = q();
        if (q10 != null) {
            return ((Integer) Wire.get(q10.network_timeout, 0)).intValue();
        }
        return 0;
    }

    public boolean H() {
        if (k() != null) {
            return ((Boolean) Wire.get(k().oaid_api_is_disable, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public SigmobRvConfig I() {
        if (q() != null) {
            return q().rv_config;
        }
        return null;
    }

    public SigmobSdkConfig J() {
        SigmobSdkConfig sigmobSdkConfig = this.f18206g;
        return sigmobSdkConfig == null ? this.f18205f : sigmobSdkConfig;
    }

    public int K() {
        int intValue;
        if (q() == null || (intValue = ((Integer) Wire.get(q().send_log_interval, 3)).intValue()) < 3) {
            return 3;
        }
        return intValue;
    }

    public int L() {
        if (M() == null) {
            return 50;
        }
        return ((Integer) Wire.get(M().cacheTop, 50)).intValue();
    }

    public final SigmobSplashConfig M() {
        if (q() != null) {
            return q().splash_config;
        }
        return null;
    }

    public long N() {
        int intValue = M() != null ? ((Integer) Wire.get(M().material_expired_time, 2)).intValue() : 2;
        return intValue < 0 ? intValue : intValue * 86400000;
    }

    public int O() {
        SigmobAndroid k10 = k();
        if (k10 != null) {
            return ((Integer) Wire.get(k10.web_source_cache_expiration_time, 0)).intValue();
        }
        return 0;
    }

    public final boolean P() {
        SigmobCommon q10 = q();
        if (q10 != null) {
            return ((Boolean) Wire.get(q10.log_enc, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public final void Q() {
        if (this.f18205f == null) {
            SigmobSdkConfig.Builder builder = new SigmobSdkConfig.Builder();
            SigmobCommon.Builder builder2 = new SigmobCommon.Builder();
            SigmobAndroid.Builder builder3 = new SigmobAndroid.Builder();
            builder2.endpoints(new SigmobCommonEndpointsConfig.Builder().build());
            SigmobRvConfig.Builder builder4 = new SigmobRvConfig.Builder();
            builder4.cacheTop(4);
            builder2.rv_config(builder4.build());
            builder2.configRefresh(1000);
            Boolean bool = Boolean.TRUE;
            builder2.disable_up_location(bool);
            Boolean bool2 = Boolean.FALSE;
            builder2.is_gdpr_region(bool2);
            builder2.enable_debug_level(bool2);
            builder3.disable_boot_mark(bool);
            builder3.disableUpAppInfo(bool);
            builder3.oaid_api_is_disable(bool);
            builder3.enable_permission(bool2);
            builder3.enable_report_crash(bool2);
            builder.common_config(builder2.build());
            builder.android_config(builder3.build());
            this.f18205f = builder.build();
        }
        SigmobLog.d("Default config: " + this.f18205f.toString());
    }

    public boolean R() {
        if (k() != null) {
            return ((Boolean) Wire.get(k().disable_boot_mark, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean S() {
        if (k() != null) {
            return ((Boolean) Wire.get(k().disable_install_monitor, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean T() {
        if (k() != null) {
            return ((Boolean) Wire.get(k().disableUpAppInfo, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean U() {
        if (q() != null) {
            return ((Boolean) Wire.get(q().disable_up_location, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public boolean V() {
        return false;
    }

    public boolean W() {
        SigmobAndroid k10 = k();
        return k10 != null && ((Integer) Wire.get(k10.up_wifi_list_interval, 0)).intValue() >= 60;
    }

    public boolean X() {
        if (q() != null) {
            return ((Boolean) Wire.get(q().enable_debug_level, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean Y() {
        if (k() != null) {
            return ((Boolean) Wire.get(k().enable_permission, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean Z() {
        if (k() != null) {
            return ((Boolean) Wire.get(k().enable_report_crash, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public int a() {
        if (k() != null) {
            return ((Integer) Wire.get(k().enable_app_list, 0)).intValue();
        }
        return 0;
    }

    public boolean a0() {
        SigmobCommon q10 = q();
        if (q10 != null) {
            return ((Boolean) Wire.get(q10.feedback_debug, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean c0() {
        SigmobAndroid k10 = k();
        if (k10 != null) {
            return ((Boolean) Wire.get(k10.lock_play, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean d0() {
        SigmobAndroid k10 = k();
        if (k10 != null) {
            return ((Boolean) Wire.get(k10.screen_keep, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public final void e0() {
        SigmobRequestQueue sigRequestQueue = Networking.getSigRequestQueue();
        com.sigmob.sdk.base.network.e eVar = new com.sigmob.sdk.base.network.e(r(), new b());
        if (sigRequestQueue == null) {
            SigmobLog.e("queue is null");
            j0();
        } else {
            sigRequestQueue.add(eVar);
            SigmobLog.i("update sdk config");
        }
    }

    public int f() {
        SigmobAndroid k10 = k();
        if (k10 != null) {
            return ((Integer) Wire.get(k10.report_log, 0)).intValue();
        }
        return 0;
    }

    public void f0() {
        Throwable th2;
        ObjectInputStream objectInputStream = null;
        String string = com.sigmob.sdk.base.utils.f.a().getString(f18195i, null);
        File file = new File(com.sigmob.sdk.base.utils.d.d() + "/config");
        if (k.f18179k.equals(string)) {
            try {
                if (file.exists()) {
                    try {
                        ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(file));
                        try {
                            a(SigmobSdkConfig.ADAPTER.decode(objectInputStream2), false);
                            objectInputStream2.close();
                        } catch (Throwable th3) {
                            th2 = th3;
                            objectInputStream = objectInputStream2;
                            try {
                                a(this.f18205f, false);
                                SigmobLog.e(th2.getMessage());
                                if (objectInputStream != null) {
                                    objectInputStream.close();
                                    return;
                                }
                                return;
                            } catch (Throwable th4) {
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Throwable th5) {
                                        SigmobLog.e(th5.getMessage());
                                    }
                                }
                                throw th4;
                            }
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                    }
                    return;
                }
            } catch (Throwable th7) {
                SigmobLog.e(th7.getMessage());
                return;
            }
        }
        a(this.f18205f, false);
    }

    public boolean g() {
        SigmobAndroid k10 = k();
        if (k10 != null) {
            return ((Boolean) Wire.get(k10.use_web_source_cache, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public long g0() {
        SigmobNativeConfig F = F();
        if (F == null) {
            return 45000L;
        }
        int intValue = ((Integer) Wire.get(F.ad_load_timeout, 45)).intValue();
        if (intValue < 10) {
            intValue = 10;
        }
        return intValue * 1000;
    }

    public long h() {
        long intValue = q() != null ? ((Integer) Wire.get(q().tracking_expiration_time, 86400)).intValue() : 86400L;
        if (intValue < 180) {
            return 180L;
        }
        return intValue;
    }

    public long h0() {
        if (I() == null) {
            return 45000L;
        }
        int intValue = ((Integer) Wire.get(I().ad_load_timeout, 45)).intValue();
        if (intValue < 10) {
            intValue = 10;
        }
        return intValue * 1000;
    }

    public int i() {
        SigmobCommon q10 = q();
        int i10 = TinkerReport.KEY_APPLIED_VERSION_CHECK;
        if (q10 != null) {
            i10 = ((Integer) Wire.get(q().tracking_retry_interval, Integer.valueOf(TinkerReport.KEY_APPLIED_VERSION_CHECK))).intValue();
        }
        if (i10 < 10) {
            return 10;
        }
        return i10;
    }

    public final void i0() {
        if (com.sigmob.sdk.a.d() == null) {
            return;
        }
        if (ClientMetadata.getInstance().isNetworkConnected(r()) && f.f().b()) {
            e0();
        } else {
            SigmobLog.d("Can't load an ad because there is no network connectivity.");
            j0();
        }
    }

    public String j() {
        StringBuilder sb2;
        String str;
        String str2 = q().endpoints.ads;
        if (TextUtils.isEmpty(str2)) {
            str2 = "https://" + k.R;
        }
        if (str2.indexOf(63) == -1) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "?";
        } else {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "&";
        }
        sb2.append(str);
        sb2.append(k0());
        return sb2.toString();
    }

    public final void j0() {
        c();
        if (this.f18203d) {
            this.f18200a.postDelayed(this.f18201b, Math.max(30000L, this.f18204e));
        }
    }

    public SigmobAndroid k() {
        if (J() == null) {
            return null;
        }
        return J().sigmobAndroid_config;
    }

    public int l() {
        if (k() != null) {
            return ((Integer) Wire.get(k().apk_expired_time, 0)).intValue();
        }
        return 0;
    }

    public void l0() {
        c();
        this.f18200a.post(this.f18201b);
    }

    public final String m() {
        SigmobCommon q10 = q();
        if (q10 == null || q10.endpoints == null) {
            return "";
        }
        return (String) Wire.get(q10.endpoints.config, "https://" + k.O);
    }

    public int n() {
        if (I() != null) {
            return ((Integer) Wire.get(I().cacheTop, 5)).intValue();
        }
        return 5;
    }

    public List<String> o() {
        SigmobAndroid k10 = k();
        return k10 != null ? k10.open_pkg_list : Collections.emptyList();
    }

    public SigmobDialogSetting p() {
        if (I() != null) {
            return I().close_dialog_setting;
        }
        return null;
    }

    public SigmobCommon q() {
        if (J() == null) {
            return null;
        }
        return J().sigmobCommon_config;
    }

    public int s() {
        if (k() != null) {
            return ((Integer) Wire.get(k().disable_up_oaid, 0)).intValue();
        }
        return 0;
    }

    public String t() {
        StringBuilder sb2;
        String str;
        String str2 = (String) Wire.get(q().endpoints.feedback, "https://" + k.Q);
        if (TextUtils.isEmpty(str2)) {
            return str2;
        }
        if (str2.indexOf(63) == -1) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "?";
        } else {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "&";
        }
        sb2.append(str);
        sb2.append(k0());
        return sb2.toString();
    }

    public String v() {
        StringBuilder sb2;
        String str;
        String str2 = q().endpoints.hb_ads;
        if (TextUtils.isEmpty(str2)) {
            str2 = "https://" + k.S;
        }
        if (str2.indexOf(63) == -1) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "?";
        } else {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "&";
        }
        sb2.append(str);
        sb2.append(k0());
        return sb2.toString();
    }

    public long x() {
        if (q() == null) {
            return 0L;
        }
        long intValue = ((Integer) Wire.get(q().load_interval, 0)).intValue();
        if (intValue < 1) {
            return 0L;
        }
        return intValue * 1000;
    }

    public List<Integer> y() {
        if (q() != null) {
            return q().dclog_blacklist;
        }
        return null;
    }

    public String z() {
        StringBuilder sb2;
        String str;
        String str2 = q().endpoints.log;
        if (TextUtils.isEmpty(str2)) {
            str2 = "https://dc.sigmob.cn/log";
        }
        if (str2.indexOf(63) == -1) {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "?";
        } else {
            sb2 = new StringBuilder();
            sb2.append(str2);
            str = "&";
        }
        sb2.append(str);
        sb2.append(k0());
        return sb2.toString();
    }

    public final void c() {
        this.f18200a.removeCallbacks(this.f18201b);
    }

    public boolean d() {
        return (q() == null || q().anti_fraud_log == null || q().anti_fraud_log.events == null) ? false : true;
    }

    public boolean e() {
        SigmobCommon q10 = q();
        if (q10 != null) {
            return ((Boolean) Wire.get(q10.enable_extra_dclog, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean b(String str) {
        if (!d() || q().anti_fraud_log.events == null) {
            return false;
        }
        return q().anti_fraud_log.events.contains(str);
    }

    public final void a(SigmobSdkConfig sigmobSdkConfig, boolean z10) {
        SigmobCommon sigmobCommon;
        if (sigmobSdkConfig == null || (sigmobCommon = sigmobSdkConfig.sigmobCommon_config) == null) {
            return;
        }
        this.f18206g = sigmobSdkConfig;
        this.f18204e = ((Integer) Wire.get(sigmobCommon.configRefresh, 1800)).intValue() * 1000;
        SigmobLog.d("config: " + sigmobSdkConfig.toString());
        c cVar = this.f18207h;
        if (cVar != null) {
            cVar.a(z10);
        }
        Config.sharedInstance().setEnable_okhttp3(V());
        Config.sharedInstance().setNetworkTimeout(G());
        Config.sharedInstance().update(f18197k, R(), H(), s(), z(), K(), A(), P());
        TrackManager.getInstance().setRetryInterval(i());
        TrackManager.getInstance().setRetryExpiredTime(h());
    }

    public final void a(SigmobSdkConfig sigmobSdkConfig) {
        ObjectOutputStream objectOutputStream;
        if (sigmobSdkConfig != null) {
            File file = new File(com.sigmob.sdk.base.utils.d.d() + "/config");
            if (file.exists()) {
                file.delete();
            }
            file.getParentFile().mkdirs();
            ObjectOutputStream objectOutputStream2 = null;
            try {
                try {
                    try {
                        objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                        try {
                            sigmobSdkConfig.encode(objectOutputStream);
                            com.sigmob.sdk.base.utils.f.a().edit().putString(f18195i, k.f18179k).apply();
                            objectOutputStream.close();
                        } catch (IOException e10) {
                            e = e10;
                            objectOutputStream2 = objectOutputStream;
                            SigmobLog.e(e.getMessage());
                            if (objectOutputStream2 != null) {
                                objectOutputStream2.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e11) {
                                    SigmobLog.e(e11.getMessage());
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream = objectOutputStream2;
                    }
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (IOException e13) {
                SigmobLog.e(e13.getMessage());
            }
        }
    }

    public l a(c cVar) {
        this.f18207h = cVar;
        return f18196j;
    }
}
