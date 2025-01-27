package com.sigmob.sdk;

import android.text.TextUtils;
import android.util.Base64;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.exceptions.CrashHandler;
import com.czhj.sdk.common.models.BidRequest;
import com.czhj.sdk.common.mta.PointEntityCommon;
import com.czhj.sdk.common.network.BuriedPointRequest;
import com.czhj.sdk.common.network.JsonRequest;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageManager;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.czhj.volley.VolleyLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.l;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobCrash;
import com.sigmob.sdk.base.services.j;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Sigmob {

    /* renamed from: c */
    public static Sigmob f17467c;

    /* renamed from: d */
    public static boolean f17468d;
    public static SigMacroCommon macroCommon;

    /* renamed from: a */
    public WindAdError f17469a;

    /* renamed from: b */
    public RepeatingHandlerRunnable f17470b = null;

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ int f17471a;

        /* renamed from: b */
        public final /* synthetic */ boolean f17472b;

        /* renamed from: c */
        public final /* synthetic */ boolean f17473c;

        /* renamed from: d */
        public final /* synthetic */ int f17474d;

        /* renamed from: e */
        public final /* synthetic */ boolean f17475e;

        public a(int i10, boolean z10, boolean z11, int i11, boolean z12) {
            this.f17471a = i10;
            this.f17472b = z10;
            this.f17473c = z11;
            this.f17474d = i11;
            this.f17475e = z12;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntityCommon) {
                PointEntityCommon pointEntityCommon = (PointEntityCommon) obj;
                HashMap hashMap = new HashMap();
                hashMap.put("is_minor", com.sigmob.sdk.base.f.f().i() ? "0" : "1");
                hashMap.put("is_unpersonalized", com.sigmob.sdk.base.f.f().j() ? "0" : "1");
                hashMap.put("canUseAppList", String.valueOf(this.f17471a));
                hashMap.put("appListPermission", this.f17472b ? "1" : "0");
                hashMap.put("disableUpAppInfo", this.f17473c ? "1" : "0");
                hashMap.put("EnableAppList", String.valueOf(this.f17474d));
                hashMap.put("uploadAppList", this.f17475e ? "1" : "0");
                hashMap.put("common_version", String.valueOf(WindAds.sharedAds().getCommonVersion()));
                pointEntityCommon.setOptions(hashMap);
            }
        }
    }

    public class b implements b0.g {
        public b() {
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setPermission(ClientMetadata.getInstance().getPermission(com.sigmob.sdk.a.d()));
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.a(PointCategory.APP);
            Sigmob.this.f17469a = com.sigmob.sdk.base.common.f.b();
            Sigmob.this.h();
        }
    }

    public class d implements TrackManager.Listener {
        public d() {
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onErrorResponse(AdTracker adTracker, VolleyError volleyError) {
            b0.a(adTracker, adTracker.getUrl(), (BaseAdUnit) null, volleyError);
        }

        @Override // com.czhj.sdk.common.track.TrackManager.Listener
        public void onSuccess(AdTracker adTracker, NetworkResponse networkResponse) {
            b0.a(adTracker, adTracker.getUrl(), (BaseAdUnit) null, networkResponse, (b0.g) null);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Sigmob.this.d();
        }
    }

    public class f implements JsonRequest.Listener {
        public f() {
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            Sigmob.this.j();
            com.sigmob.sdk.base.f.f().a((Boolean) null);
        }

        @Override // com.czhj.sdk.common.network.JsonRequest.Listener
        public void onSuccess(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    com.sigmob.sdk.base.f.f().a(Boolean.valueOf(jSONObject.getBoolean(Constants.IS_REQUEST_IN_EEA_OR_UNKNOWN)));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            Sigmob.this.j();
        }
    }

    public class g implements BuriedPointRequest.RequestListener {

        /* renamed from: a */
        public final /* synthetic */ File f17482a;

        public g(File file) {
            this.f17482a = file;
        }

        @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
        public void onErrorResponse(VolleyError volleyError) {
        }

        @Override // com.czhj.sdk.common.network.BuriedPointRequest.RequestListener
        public void onSuccess() {
            File file = this.f17482a;
            if (file != null) {
                file.delete();
            }
        }
    }

    public class h implements l.c {
        public h() {
        }

        @Override // com.sigmob.sdk.base.l.c
        public void a(boolean z10) {
            Sigmob.k();
            Sigmob.l();
            if (z10) {
                com.sigmob.sdk.base.services.b.f();
                Sigmob.f();
                com.sigmob.sdk.base.services.b.g();
            }
        }
    }

    public class i implements CrashHandler.CrashHandlerListener {

        /* renamed from: a */
        public final /* synthetic */ String f17485a;

        public i(String str) {
            this.f17485a = str;
        }

        @Override // com.czhj.sdk.common.exceptions.CrashHandler.CrashHandlerListener
        public void reportCrash(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains(this.f17485a) || str.contains("com.czhj.")) {
                String format = String.format("crashTime %d, appId %s, sdkVersion %s, commonVersion %d crashLog: %s", Long.valueOf(System.currentTimeMillis()), WindAds.sharedAds().getAppId(), k.f18179k, Integer.valueOf(WindAds.sharedAds().getCommonVersion()), str);
                SigmobLog.e("crashLog " + format);
                File b10 = com.sigmob.sdk.base.utils.d.b();
                if (b10 != null) {
                    FileUtil.writeToBuffer(format.getBytes(), b10.getAbsolutePath());
                }
                Sigmob.this.a(b10, format);
            }
        }
    }

    public static BidRequest createRequest() {
        BidRequest.Builder builder = new BidRequest.Builder();
        try {
            builder = com.sigmob.sdk.base.network.a.a((LoadAdRequest) null);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        return builder.build();
    }

    public static void f() {
        try {
            j.a(j.f18385b, true);
        } catch (Throwable th2) {
            SigmobLog.e("initAppInstallService fail", th2);
        }
    }

    public static void g() {
        try {
            j.a(j.f18387d, true);
        } catch (Throwable th2) {
            SigmobLog.e("initDownloadService fail", th2);
        }
    }

    public static synchronized Sigmob getInstance() {
        Sigmob sigmob;
        synchronized (Sigmob.class) {
            try {
                if (f17467c == null) {
                    synchronized (Sigmob.class) {
                        f17467c = new Sigmob();
                    }
                }
                sigmob = f17467c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sigmob;
    }

    public static void k() {
        try {
            j.a(j.f18384a, com.sigmob.sdk.base.f.f().b() && !l.w().U());
        } catch (Throwable th2) {
            SigmobLog.e("updateLocationMonitor fail", th2);
        }
    }

    public static void l() {
        try {
            j.a(j.f18386c, com.sigmob.sdk.base.f.f().b() && l.w().W());
        } catch (Throwable th2) {
            SigmobLog.e("updateWifiScanService fail", th2);
        }
    }

    public final void d() {
        com.sigmob.sdk.base.common.h.f();
        com.sigmob.sdk.base.common.h.l();
        com.sigmob.sdk.base.common.h.i();
        com.sigmob.sdk.base.common.h.k();
        com.sigmob.sdk.base.common.h.j();
        com.sigmob.sdk.base.common.h.g();
        com.sigmob.sdk.base.common.h.e();
    }

    public final void e() {
        ImageManager.with(com.sigmob.sdk.a.d()).clearCache();
    }

    public SigMacroCommon getMacroCommon() {
        if (macroCommon == null) {
            macroCommon = new SigMacroCommon();
        }
        return macroCommon;
    }

    public String getSDKToken() {
        com.sigmob.sdk.a.a(true);
        String str = "2.01|" + a(createRequest().encode());
        b0.a("token_request", (String) null, (BaseAdUnit) null, (b0.g) null);
        SigmobLog.d("getSDKToken: " + str);
        return str;
    }

    public WindAdError getSigMobError() {
        return this.f17469a;
    }

    public final void h() {
        Networking.getSigRequestQueue().add(new JsonRequest(l.u(), new f(), 0));
    }

    public final void i() {
        try {
            File[] e10 = com.sigmob.sdk.base.utils.d.e();
            if (e10 != null) {
                for (File file : e10) {
                    String readFileToString = FileUtil.readFileToString(file);
                    if (!TextUtils.isEmpty(readFileToString)) {
                        a(file, readFileToString);
                    }
                }
            }
        } catch (Throwable th2) {
            SigmobLog.e("send crash Log fail", th2);
        }
    }

    public void init() {
        boolean z10;
        int i10;
        VolleyLog.DEBUG = k.f18174f.booleanValue();
        WindAdOptions options = WindAds.sharedAds().getOptions();
        WindCustomController customController = WindAds.sharedAds().getOptions().getCustomController();
        int a10 = l.w().a();
        boolean T = l.w().T();
        if (options == null || customController == null) {
            z10 = true;
            i10 = 0;
        } else {
            z10 = customController.isCanUseAppList();
            i10 = z10 ? 1 : 2;
        }
        b0.a(PointCategory.INIT, new a(i10, com.sigmob.sdk.base.common.f.d(), T, a10, a10 == 1 || !(a10 == 2 || !z10 || T)));
        if (l.w().Y()) {
            b0.a("permission", PointCategory.INIT, (BaseAdUnit) null, new b());
        }
        com.sigmob.sdk.base.common.h.r();
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new c());
        TrackManager.getInstance().setSigmobTrackListener(new d());
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new e());
        TrackManager.getInstance().startRetryTracking();
        f17468d = true;
    }

    public final void j() {
        g();
        com.sigmob.sdk.a.j();
        l.w().a(new h()).l0();
        if (l.w().Z()) {
            String[] split = WindAds.class.getName().split("\\.");
            if (split.length <= 2) {
                return;
            }
            CrashHandler.getInstance().add(new i(split[0] + p1.b.f29697h + split[1] + p1.b.f29697h));
            i();
        }
        e();
    }

    public final String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public final void a(File file, String str) {
        PointEntitySigmobCrash WindCrash = PointEntitySigmobCrash.WindCrash(str);
        if (file != null) {
            try {
                WindCrash.setCrashTime(Long.parseLong(file.getName().replace(".log", "")));
            } catch (Throwable th2) {
                SigmobLog.e("set crash time fail", th2);
            }
        }
        WindCrash.sendServe(new g(file));
    }
}
