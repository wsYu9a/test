package com.jd.ad.sdk.bl.initsdk;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.bl.video.db.SplashRenderVideoHelper;
import com.jd.ad.sdk.dl.baseinfo.JADLocation;
import com.jd.ad.sdk.fdt.logger.JADLogAdapter;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_kx.jad_er;
import com.jd.ad.sdk.jad_ob.jad_dq;
import com.jd.ad.sdk.jad_ob.jad_er;
import com.jd.ad.sdk.jad_qd.jad_cp;
import com.jd.ad.sdk.jad_qd.jad_jt;
import com.jd.ad.sdk.jad_uh.jad_an;
import com.jd.ad.sdk.jad_xk.jad_bo;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.jad_xk.jad_hu;
import com.jd.ad.sdk.jad_xk.jad_iv;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.multi.BuildConfig;
import com.sigmob.sdk.base.mta.PointCategory;
import hf.e;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JADYunSdk {
    private static boolean isEnableLog = false;
    private static boolean isInitSuccess = false;
    private static JADInitCallback mInitCallback = null;
    public static jad_er mInnerInitCallBack = null;
    private static boolean mSupportMultiProcess = false;
    private static String sAppId = "";
    public static volatile JADLogAdapter sLogAdapter;
    public static volatile JADPrivateController sPrivateController;

    public class jad_an implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_jw.jad_an.jad_an)) {
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                    com.jd.ad.sdk.jad_jw.jad_an.jad_an = jad_anVar.jad_an("refo");
                    Object jad_an = jad_anVar.jad_an("refot", (Class<Object>) Long.TYPE);
                    if (System.currentTimeMillis() - ((jad_an == null || !(jad_an instanceof Long)) ? 0L : ((Long) jad_an).longValue()) > 86400000) {
                        com.jd.ad.sdk.jad_jw.jad_an.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
                    }
                }
            } catch (Exception e10) {
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("init oaid error: ");
                jad_an2.append(Log.getStackTraceString(e10));
                Logger.d(jad_an2.toString());
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.UTILS_OADI_REFLECT_ERROR;
                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e10.getMessage()));
            }
        }
    }

    public class jad_bo extends JADLogAdapter {
        @Override // com.jd.ad.sdk.fdt.logger.JADLogAdapter, com.jd.ad.sdk.jad_kt.jad_bo
        public boolean isLoggable(int i10, @Nullable String str) {
            if (JADYunSdk.isEnableLog) {
                return super.isLoggable(i10, str);
            }
            return false;
        }
    }

    public class jad_cp implements jad_er {
    }

    public class jad_dq implements Runnable {
        public final /* synthetic */ Context jad_an;
        public final /* synthetic */ JADYunSdkConfig jad_bo;

        public jad_dq(Context context, JADYunSdkConfig jADYunSdkConfig) {
            this.jad_an = context;
            this.jad_bo = jADYunSdkConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADYunSdk.init(this.jad_an, this.jad_bo);
        }
    }

    public interface jad_er {
    }

    public static void asyncInit(@NonNull Context context, @NonNull JADYunSdkConfig jADYunSdkConfig, JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        WorkExecutor.execute(new jad_dq(context, jADYunSdkConfig));
    }

    private static void crashInit() {
        if (jad_dq.jad_an.jad_an.jad_an(10, (String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_xk.jad_bo jad_boVar = jad_bo.C0358jad_bo.jad_an;
        try {
            String str = "jadcrash";
            if (!jad_jt.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                str = "jadcrash" + e.f26694a + jad_jt.jad_cp(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
            }
            jad_boVar.jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getSharedPreferences(str, 0);
            if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof com.jd.ad.sdk.jad_xk.jad_bo) && jad_boVar.jad_bo == null) {
                jad_boVar.jad_bo = Thread.getDefaultUncaughtExceptionHandler();
            }
            Thread.setDefaultUncaughtExceptionHandler(jad_boVar);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        WorkExecutor.execute(new com.jd.ad.sdk.jad_xk.jad_an(jad_bo.C0358jad_bo.jad_an));
    }

    public static String getAppId() {
        return !TextUtils.isEmpty(sAppId) ? sAppId : jad_an.jad_bo.jad_an.jad_an(h3.e.f26403h);
    }

    public static JADPrivateController getPrivateController() {
        return sPrivateController;
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void init(@NonNull Context context, @NonNull JADYunSdkConfig jADYunSdkConfig) {
        long currentTimeMillis = System.currentTimeMillis();
        initJADLog(jADYunSdkConfig);
        Application application = (Application) context.getApplicationContext();
        com.jd.ad.sdk.jad_fq.jad_cp.jad_an = application;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(new ActLifecycle());
        }
        sAppId = jADYunSdkConfig.getAppId();
        WorkExecutor.execute(new com.jd.ad.sdk.jad_re.jad_bo(jADYunSdkConfig));
        mSupportMultiProcess = jADYunSdkConfig.isSupportMultiProcess();
        Context jad_an2 = context instanceof Application ? context : com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        initAntiSDK(jad_an2);
        if (jADYunSdkConfig.getPrivateController() != null) {
            sPrivateController = jADYunSdkConfig.getPrivateController();
            com.jd.ad.sdk.jad_qd.jad_cp jad_cpVar = jad_cp.jad_an.jad_an;
            JADPrivateController jADPrivateController = sPrivateController;
            jad_cpVar.jad_jw = jADPrivateController;
            String oaid = jADPrivateController.getOaid();
            if (!TextUtils.isEmpty(oaid)) {
                jad_cpVar.jad_an = oaid;
                jad_an.jad_bo.jad_an.jad_an("oidCustom", oaid);
            }
            jADPrivateController.isCanUsePhoneState();
            jad_cpVar.jad_er = false;
            String imei = jADPrivateController.getImei();
            if (!TextUtils.isEmpty(imei)) {
                String jad_bo2 = com.jd.ad.sdk.jad_fq.jad_fs.jad_bo(imei.toUpperCase());
                jad_an.jad_bo.jad_an.jad_an("didCustom", (Object) jad_bo2);
                jad_cpVar.jad_bo = jad_bo2;
            }
            jad_cpVar.jad_fs = jADPrivateController.isCanUseLocation();
            JADLocation location = jADPrivateController.getLocation();
            if (location != null && location.isValid()) {
                jad_cpVar.jad_dq = location;
            }
            jad_cpVar.jad_jt = jADPrivateController.isCanUseIP();
            String ip = jADPrivateController.getIP();
            if (!TextUtils.isEmpty(ip) && !"0.0.0.0".equals(ip)) {
                jad_cpVar.jad_cp = ip;
            }
            if (jad_an2 != null) {
                jad_cpVar.jad_hu.clear();
                Iterator<String> it = com.jd.ad.sdk.jad_qd.jad_bo.jad_cp.iterator();
                while (it.hasNext()) {
                    jad_cpVar.jad_hu.add(com.jd.ad.sdk.jad_fq.jad_fs.jad_an(it.next()));
                }
            }
            try {
                jad_cpVar.jad_iv.clear();
                com.jd.ad.sdk.jad_pc.jad_an jad_an3 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
                if (jad_an3 != null) {
                    String str = jad_an3.jad_qd;
                    if (!TextUtils.isEmpty(str)) {
                        jad_cpVar.jad_iv.addAll(Arrays.asList(str.split(",")));
                    }
                }
            } catch (Exception unused) {
            }
        }
        crashInit();
        jad_iv jad_ivVar = jad_iv.jad_cp.jad_an;
        jad_ivVar.getClass();
        WorkExecutor.execute(new jad_hu(jad_ivVar, context));
        initInternalInitCallBack();
        String appId = jADYunSdkConfig.getAppId();
        Handler handler = com.jd.ad.sdk.jad_ob.jad_er.jad_an;
        com.jd.ad.sdk.jad_ob.jad_bo.jad_bo = true;
        com.jd.ad.sdk.jad_ob.jad_er.jad_an(appId);
        ActLifecycle.jad_an(new jad_er.jad_bo());
        com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
        String jad_dq2 = jad_anVar.jad_dq("isRegisterNetworkReceiver");
        if (TextUtils.isEmpty(jad_dq2) || !jad_dq2.equals("1")) {
            if (com.jd.ad.sdk.jad_ob.jad_er.jad_bo == null) {
                com.jd.ad.sdk.jad_ob.jad_er.jad_bo = new com.jd.ad.sdk.jad_ob.jad_hu();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            jad_an2.registerReceiver(com.jd.ad.sdk.jad_ob.jad_er.jad_bo, intentFilter, null, null);
            jad_anVar.jad_bo("isRegisterNetworkReceiver", "1");
        }
        initSOaid();
        WorkExecutor.execute(new com.jd.ad.sdk.jad_hu.jad_dq(context));
        WorkExecutor.execute(new com.jd.ad.sdk.jad_kx.jad_dq(jad_er.jad_an.jad_an, context));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        int i10 = com.jd.ad.sdk.jad_vi.jad_an.jad_an;
        if (i10 < 1) {
            com.jd.ad.sdk.jad_vi.jad_an.jad_an = i10 + 1;
            JSONObject jSONObject = new JSONObject();
            JsonUtils.put(jSONObject, "tp", 6);
            JsonUtils.put(jSONObject, "iid", UUIDUtils.uuid());
            JsonUtils.put(jSONObject, PointCategory.INIT, 1);
            JsonUtils.put(jSONObject, "idu", Long.valueOf(currentTimeMillis2));
            jad_ivVar.jad_bo(jSONObject);
        }
        SplashRenderVideoHelper.init(context);
    }

    private static void initAntiSDK(Context context) {
        if (jad_dq.jad_an.jad_an.jad_an(11, (String) null)) {
            return;
        }
        com.jd.ad.sdk.jad_il.jad_bo jad_boVar = new com.jd.ad.sdk.jad_il.jad_bo();
        jad_boVar.jad_an = context;
        jad_boVar.jad_bo = false;
        synchronized (com.jd.ad.sdk.jad_il.jad_an.class) {
            try {
                if (com.jd.ad.sdk.jad_il.jad_an.jad_bo) {
                    Log.i("AntiSDK", "AntiSDK has initialized.");
                } else {
                    Context context2 = jad_boVar.jad_an;
                    if (context2 == null) {
                        Log.w("AntiSDK", "context is null");
                    } else {
                        boolean z10 = jad_boVar.jad_bo;
                        com.jd.android.sdk.coreinfo.util.Logger.enableLogger(z10);
                        Log.i("AntiSDK", "init AntiSDK :context=" + jad_boVar.jad_an + ", debugFlag=" + z10);
                        com.jd.ad.sdk.jad_il.jad_an.jad_an = context2;
                        com.jd.ad.sdk.jad_il.jad_an.jad_bo = true;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static void initInternalInitCallBack() {
        mInnerInitCallBack = new jad_cp();
    }

    private static void initJADLog(JADYunSdkConfig jADYunSdkConfig) {
        isEnableLog = jADYunSdkConfig.isEnableLog();
        if (sLogAdapter == null) {
            sLogAdapter = new jad_bo();
            Logger.addLogAdapter(sLogAdapter);
        }
    }

    private static void initSOaid() {
        try {
            if (jad_dq.jad_an.jad_an.jad_an(12, (String) null)) {
                return;
            }
            if (JADMediator.getInstance().getInitService().getOpenReflectOaid() == 1) {
                WorkExecutor.execute(new jad_an());
            } else {
                com.jd.ad.sdk.jad_jw.jad_an.jad_an = "NA";
            }
        } catch (Exception unused) {
            com.jd.ad.sdk.jad_jw.jad_an.jad_an = "NA";
        }
    }

    public static boolean isEnableLog() {
        return isEnableLog;
    }

    public static boolean isInitSuccess() {
        return isInitSuccess;
    }

    public static boolean isSupportMultiProcess() {
        return mSupportMultiProcess;
    }

    public static void syncInit(@NonNull Context context, @NonNull JADYunSdkConfig jADYunSdkConfig, JADInitCallback jADInitCallback) {
        mInitCallback = jADInitCallback;
        init(context, jADYunSdkConfig);
    }
}
