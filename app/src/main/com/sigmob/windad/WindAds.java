package com.sigmob.windad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.a;
import com.sigmob.sdk.base.f;
import com.sigmob.sdk.base.k;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.windad.consent.ConsentStatus;
import com.sigmob.windad.consent.WindAdConsentInformation;
import java.util.logging.Level;

/* loaded from: classes4.dex */
public class WindAds {
    public static final String ADN_ID = "ADN_ID";
    public static final String ADX_ID = "_adx_id";
    public static final String AD_SCENE_DESC = "scene_desc";
    public static final String AD_SCENE_ID = "scene_id";
    public static final String AUCTION_PRICE = "AUCTION_PRICE";
    public static final String CNY = "CNY";
    public static final String CURRENCY = "CURRENCY";
    public static final String HIGHEST_LOSS_PRICE = "HIGHEST_LOSS_PRICE";
    public static final String LOSS_REASON = "LOSS_REASON";
    public static final String REWARD_TYPE = "reward_type";
    public static final String SERVER_ARRIVED = "server_arrived";
    public static final String TRANS_ID = "trans_id";
    public static final String USD = "USD";

    /* renamed from: k */
    public static volatile WindAds f20878k;

    /* renamed from: c */
    public boolean f20881c;

    /* renamed from: e */
    public OnInitializationListener f20883e;

    /* renamed from: g */
    public int f20885g;

    /* renamed from: i */
    public int f20887i;

    /* renamed from: j */
    public int f20888j;

    /* renamed from: a */
    public volatile boolean f20879a = false;

    /* renamed from: f */
    public boolean f20884f = true;

    /* renamed from: h */
    public boolean f20886h = true;

    /* renamed from: b */
    public WindAdOptions f20880b = null;

    /* renamed from: d */
    public Handler f20882d = new Handler(Looper.getMainLooper());

    /* renamed from: com.sigmob.windad.WindAds$1 */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        public static final /* synthetic */ int[] f20889a;

        static {
            int[] iArr = new int[ConsentStatus.values().length];
            f20889a = iArr;
            try {
                iArr[ConsentStatus.ACCEPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20889a[ConsentStatus.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20889a[ConsentStatus.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String getUserId() {
        return ClientMetadata.getUserId();
    }

    public static String getVersion() {
        return k.f18179k;
    }

    public static void requestPermission(Activity activity) {
        if (activity == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        boolean isPermissionGranted = ClientMetadata.isPermissionGranted(activity, g.f11102c);
        boolean isPermissionGranted2 = ClientMetadata.isPermissionGranted(activity, g.f11106g);
        if (isPermissionGranted && isPermissionGranted2) {
            return;
        }
        activity.requestPermissions(new String[]{g.f11102c, g.f11106g}, 0);
    }

    public static void setOAIDCertPem(String str) {
        try {
            ClientMetadata.setOAIDCertPem(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setUserId(String str) {
        ClientMetadata.setUserId(str);
    }

    public static WindAds sharedAds() {
        if (f20878k == null) {
            synchronized (WindAds.class) {
                try {
                    if (f20878k == null) {
                        WindAds windAds = new WindAds();
                        windAds.setDebugEnable(true);
                        f20878k = windAds;
                    }
                } finally {
                }
            }
        }
        return f20878k;
    }

    public int a() {
        return 159;
    }

    public final void b() {
        try {
            if (this.f20887i == 0) {
                this.f20887i = f.f().d();
            } else {
                f.f().a(this.f20887i, false);
            }
            if (this.f20888j == 0) {
                this.f20888j = f.f().h();
            } else {
                f.f().c(this.f20888j, false);
            }
        } catch (Throwable unused) {
        }
    }

    public final void c() {
        try {
            b();
            d();
            f.f().b(this.f20886h, false);
            f.f().a(this.f20884f, false);
        } catch (Throwable th2) {
            SigmobLog.e("loadPrivacyInfo", th2);
        }
    }

    public final void d() {
        if (this.f20885g == 0) {
            try {
                this.f20885g = f.f().e();
            } catch (Throwable unused) {
            }
            if (this.f20885g == 0) {
                try {
                    int i10 = AnonymousClass1.f20889a[WindAdConsentInformation.getInstance(a.d()).getConsentStatus().ordinal()];
                    int i11 = 1;
                    if (i10 != 1) {
                        i11 = 2;
                        if (i10 != 2) {
                        }
                    }
                    this.f20885g = i11;
                } catch (Throwable unused2) {
                }
            }
        }
        f.f().b(this.f20885g, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void debugDeviceID() {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            com.czhj.sdk.common.ClientMetadata r2 = com.czhj.sdk.common.ClientMetadata.getInstance()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = r2.getDeviceId()     // Catch: java.lang.Throwable -> L1f
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L1f
            if (r3 != 0) goto L21
            java.lang.String r3 = "debug device Type: IMEI,  ID => %s"
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L1f
            r4[r1] = r2     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L1f
            com.czhj.sdk.logger.SigmobLog.i(r2)     // Catch: java.lang.Throwable -> L1f
            r2 = 1
            goto L22
        L1f:
            goto L5d
        L21:
            r2 = 0
        L22:
            com.czhj.sdk.common.ClientMetadata r3 = com.czhj.sdk.common.ClientMetadata.getInstance()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = r3.getAdvertisingId()     // Catch: java.lang.Throwable -> L5a
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L5a
            if (r4 != 0) goto L3e
            java.lang.String r4 = "debug device Type: gaid, ID => %s"
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L5a
            r5[r1] = r3     // Catch: java.lang.Throwable -> L5a
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L5a
            com.czhj.sdk.logger.SigmobLog.i(r4)     // Catch: java.lang.Throwable -> L5a
            r2 = 1
        L3e:
            com.czhj.sdk.common.ClientMetadata r4 = com.czhj.sdk.common.ClientMetadata.getInstance()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r4 = r4.getOAID()     // Catch: java.lang.Throwable -> L5a
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L5a
            if (r4 != 0) goto L5b
            java.lang.String r4 = "debug device Type oaid, ID => %s"
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L5a
            r5[r1] = r3     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L5a
            com.czhj.sdk.logger.SigmobLog.i(r3)     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
        L5b:
            r0 = r2
            goto L5e
        L5d:
            r0 = 0
        L5e:
            if (r0 != 0) goto L6b
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "can't find any can be used debug valid Device Type"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            com.czhj.sdk.logger.SigmobLog.e(r0)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.windad.WindAds.debugDeviceID():void");
    }

    public final void e() {
        OnInitializationListener onInitializationListener = this.f20883e;
        if (onInitializationListener != null) {
            onInitializationListener.OnInitializationSuccess();
        }
    }

    public int getAgeRestrictedStatus() {
        return this.f20887i;
    }

    public String getAppId() {
        WindAdOptions windAdOptions = this.f20880b;
        if (windAdOptions != null) {
            return windAdOptions.getAppId();
        }
        return null;
    }

    public String getAppKey() {
        WindAdOptions windAdOptions = this.f20880b;
        if (windAdOptions != null) {
            return windAdOptions.getAppKey();
        }
        return null;
    }

    public int getCommonVersion() {
        try {
            return Constants.getVersion();
        } catch (Throwable unused) {
            return 170;
        }
    }

    public Handler getHandler() {
        if (this.f20882d == null) {
            this.f20882d = new Handler(Looper.getMainLooper());
        }
        return this.f20882d;
    }

    public WindAdOptions getOptions() {
        return this.f20880b;
    }

    public String getSDKToken() {
        if (this.f20879a) {
            return Sigmob.getInstance().getSDKToken();
        }
        return null;
    }

    public int getUserAge() {
        return this.f20888j;
    }

    public int getUserGDPRConsentStatus() {
        return this.f20885g;
    }

    public String getWindUid() {
        try {
            return ClientMetadata.getUid();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "Please initialize the SDK properly first";
        }
    }

    public boolean isAdult() {
        return this.f20884f;
    }

    public boolean isDebugEnable() {
        return this.f20881c;
    }

    public boolean isInit() {
        return this.f20879a;
    }

    public boolean isPersonalizedAdvertisingOn() {
        return this.f20886h;
    }

    public void setAdult(boolean z10) {
        this.f20884f = z10;
        SigmobLog.i("Windads -> setAdult " + z10);
        if (this.f20879a) {
            f.f().a(z10, true);
        }
    }

    public void setDebugEnable(boolean z10) {
        Level level;
        this.f20881c = z10;
        if (k.f18174f.booleanValue()) {
            if (z10) {
                level = Level.FINE;
            }
            level = Level.SEVERE;
        } else {
            if (z10) {
                level = Level.INFO;
            }
            level = Level.SEVERE;
        }
        SigmobLog.setSdkHandlerLevel(level);
    }

    public void setIsAgeRestrictedUser(int i10) {
        this.f20887i = i10;
        if (this.f20879a) {
            f.f().a(i10, true);
        }
    }

    public void setOAIDCertFileName(String str) {
        ClientMetadata.setOaidCertFileName(str);
    }

    public void setPersonalizedAdvertisingOn(boolean z10) {
        this.f20886h = z10;
        SigmobLog.i("Windads -> setPersonalized " + z10);
        if (this.f20879a) {
            f.f().b(z10, true);
        }
    }

    public void setUserAge(int i10) {
        this.f20888j = i10;
        if (this.f20879a) {
            f.f().c(i10, true);
        }
    }

    public void setUserGDPRConsentStatus(int i10) {
        this.f20885g = i10;
        if (this.f20879a) {
            f.f().b(i10, true);
        }
    }

    public boolean startWithOptions(Context context, WindAdOptions windAdOptions) {
        return startWithOptions(context, windAdOptions, null);
    }

    public final void a(String str) {
        SigmobLog.e("startWithOptions " + str);
        OnInitializationListener onInitializationListener = this.f20883e;
        if (onInitializationListener != null) {
            onInitializationListener.OnInitializationFail(str);
        }
        throw new RuntimeException(str);
    }

    public synchronized boolean startWithOptions(Context context, WindAdOptions windAdOptions, OnInitializationListener onInitializationListener) {
        try {
            this.f20883e = onInitializationListener;
            if (this.f20879a) {
                SigmobLog.i("already init appId: " + windAdOptions.getAppId());
            } else {
                try {
                    if (context == null) {
                        a("context is null ");
                        return false;
                    }
                    if (windAdOptions == null) {
                        a("WindAdOptions is null ");
                        return false;
                    }
                    if (TextUtils.isEmpty(windAdOptions.getAppId())) {
                        a("appId is empty ");
                        return false;
                    }
                    if (getCommonVersion() < 170) {
                        a("Your COMMON Lib version must be equal or higher than 170 ,current Version :[ " + getCommonVersion() + " ]");
                        return false;
                    }
                    this.f20880b = windAdOptions;
                    a.a(context.getApplicationContext());
                    c();
                    Sigmob.getInstance().init();
                    this.f20879a = true;
                    SigmobLog.i("init appId: " + windAdOptions.getAppId());
                } catch (Throwable th2) {
                    SigmobLog.e("startWithOptions fail", th2);
                    try {
                        PointEntitySigmobError.SigmobError(PointCategory.INIT, WindAdError.ERROR_SIGMOB_INIT_FAIL.getErrorCode(), th2.getMessage());
                    } catch (Throwable th3) {
                        SigmobLog.e("startWithOptions", th3);
                    }
                }
            }
            e();
            return true;
        } catch (Throwable th4) {
            throw th4;
        }
    }
}
