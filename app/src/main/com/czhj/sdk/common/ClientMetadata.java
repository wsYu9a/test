package com.czhj.sdk.common;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.czhj.devicehelper.DeviceHelper;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.Database.SQLiteTrackHelper;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.mta.BuriedPointManager;
import com.czhj.sdk.common.network.SigmobRequestUtil;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.AdvertisingId;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.common.utils.IdentifierManager;
import com.czhj.sdk.common.utils.RomUtils;
import com.czhj.sdk.common.utils.SharedPreferencesUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.shu.priory.config.AdKeys;
import com.tan.mark.TanId;
import h3.e;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class ClientMetadata implements IdentifierManager.AdvertisingIdChangeListener {

    /* renamed from: v */
    public static final AtomicInteger f8366v = new AtomicInteger(1);

    /* renamed from: w */
    public static String f8367w = "-1";

    /* renamed from: x */
    public static String f8368x;

    /* renamed from: y */
    public static volatile ClientMetadata f8369y;

    /* renamed from: z */
    public static String f8370z;

    /* renamed from: a */
    public Location f8371a;

    /* renamed from: b */
    public IdentifierManager f8372b;

    /* renamed from: c */
    public int f8373c;

    /* renamed from: d */
    public boolean f8374d = true;

    /* renamed from: e */
    public String f8375e;

    /* renamed from: f */
    public String f8376f;

    /* renamed from: g */
    public String f8377g;

    /* renamed from: h */
    public String f8378h;

    /* renamed from: i */
    public Context f8379i;

    /* renamed from: j */
    public boolean f8380j;

    /* renamed from: k */
    public String f8381k;

    /* renamed from: l */
    public String f8382l;

    /* renamed from: m */
    public String f8383m;

    /* renamed from: n */
    public String f8384n;

    /* renamed from: o */
    public String f8385o;

    /* renamed from: p */
    public long f8386p;

    /* renamed from: q */
    public int f8387q;

    /* renamed from: r */
    public int f8388r;

    /* renamed from: s */
    public Display f8389s;

    /* renamed from: t */
    public RepeatingHandlerRunnable f8390t;

    /* renamed from: u */
    public boolean f8391u;

    public class a implements DevicesIDsHelper.AppIdsUpdater {
        public a() {
        }

        @Override // com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.AppIdsUpdater
        public void OnIdsAvalid(String str) {
            if (!TextUtils.isEmpty(str)) {
                ClientMetadata.this.f8382l = str;
                if (!str.equalsIgnoreCase(ClientMetadata.this.f8381k)) {
                    SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(ClientMetadata.this.f8379i).edit();
                    edit.putString("oaid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
                    edit.apply();
                }
            }
            ClientMetadata.this.f8391u = true;
        }
    }

    public class b implements DevicesIDsHelper.AppIdsUpdater {
        public b() {
        }

        @Override // com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.AppIdsUpdater
        public void OnIdsAvalid(String str) {
            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(ClientMetadata.this.f8384n)) {
                return;
            }
            ClientMetadata.this.f8384n = str;
            if (str.equalsIgnoreCase(ClientMetadata.this.f8381k)) {
                return;
            }
            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(ClientMetadata.this.f8379i).edit();
            edit.putString("oaid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
            edit.apply();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RomUtils.getRomInfo();
        }
    }

    public enum d {
        FORCE_PORTRAIT("portrait"),
        FORCE_LANDSCAPE("landscape"),
        DEVICE_ORIENTATION(e.f26411p),
        UNDEFINED("");

        private final String mKey;

        d(String str) {
            this.mKey = str;
        }
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i10;
        int i11;
        do {
            atomicInteger = f8366v;
            i10 = atomicInteger.get();
            i11 = i10 + 1;
            if (i11 > 16777215) {
                i11 = 1;
            }
        } while (!atomicInteger.compareAndSet(i10, i11));
        return i10;
    }

    public static Long getBootSystemTime() {
        return Long.valueOf(DeviceUtils.getBootSystemTime());
    }

    public static String getCPUInfo() {
        try {
            return DeviceUtils.getCPUInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getCPUModel() {
        return Build.BOARD;
    }

    public static String getCell_ip() {
        return DeviceUtils.getCell_ip();
    }

    public static String getDeviceBrand() {
        return DeviceUtils.getDeviceBrand();
    }

    public static String getDeviceManufacturer() {
        return DeviceUtils.getDeviceManufacturer();
    }

    public static String getDeviceModel() {
        return DeviceUtils.getDeviceModel();
    }

    public static Integer getDeviceOSLevel() {
        return Integer.valueOf(DeviceUtils.getDeviceOSLevel());
    }

    public static String getDeviceOsVersion() {
        return DeviceUtils.getDeviceOsVersion();
    }

    public static ClientMetadata getInstance() {
        if (f8369y == null) {
            synchronized (ClientMetadata.class) {
                try {
                    if (f8369y == null) {
                        f8369y = new ClientMetadata();
                    }
                } finally {
                }
            }
        }
        return f8369y;
    }

    public static String getMacAddress() {
        try {
            return DeviceHelper.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static PackageInfo getPackageInfoWithUri(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, String> getQueryParamMap(Uri uri) {
        HashMap hashMap = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            hashMap.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
        }
        return hashMap;
    }

    public static String getUid() {
        return f8370z;
    }

    public static String getUserId() {
        return TextUtils.isEmpty(f8367w) ? "-1" : f8367w;
    }

    public static String getVAID() {
        try {
            return DeviceHelper.getVAID();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isEmulator() {
        try {
            return DeviceUtils.isEmulator();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (context == null) {
            return false;
        }
        checkSelfPermission = context.checkSelfPermission(str);
        return checkSelfPermission == 0;
    }

    public static boolean isRoot() {
        try {
            return DeviceUtils.isRoot();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setOAIDCertPem(String str) {
        try {
            DevicesIDsHelper.c(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setOaidCertFileName(String str) {
        try {
            DevicesIDsHelper.d(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f8367w = str;
    }

    public int getActiveNetworkType() {
        try {
            return DeviceUtils.getActiveNetworkType().getId();
        } catch (Throwable unused) {
            return DeviceUtils.NetworkType.UNKNOWN.getId();
        }
    }

    public String getAdvertisingId() {
        return null;
    }

    public String getAndroidId() {
        try {
            return DeviceUtils.getAndroidId(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApkMd5() {
        try {
            return DeviceUtils.getApkSha1OrMd5(this.f8379i, "MD5");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApkSha1() {
        try {
            return DeviceUtils.getApkSha1OrMd5(this.f8379i, "SHA1");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getAppName() {
        return AppPackageUtil.getAppName(this.f8379i);
    }

    public String getAppPackageName() {
        try {
            return AppPackageUtil.getAppPackageName(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getAppVersion() {
        try {
            return AppPackageUtil.getAppVersionFromContext(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Float getBatteryLevel() {
        try {
            return Float.valueOf(DeviceUtils.getBatteryLevel(this.f8379i));
        } catch (Throwable unused) {
            return Float.valueOf(0.0f);
        }
    }

    public Boolean getBatterySaveEnable() {
        try {
            return Boolean.valueOf(DeviceUtils.getBatterySaveEnable(this.f8379i));
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    public Integer getBatteryState() {
        try {
            return Integer.valueOf(DeviceUtils.getBatteryState(this.f8379i));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getBlueToothName() {
        try {
            return DeviceUtils.getBlueToothName(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getBootId() {
        try {
        } catch (Throwable th2) {
            SigmobLog.i("getBootId:" + th2.getMessage());
        }
        if (Config.sharedInstance().isDisableBootMark()) {
            return "";
        }
        if (TextUtils.isEmpty(f8368x)) {
            byte[] bootFromJNI = TanId.getBootFromJNI();
            if (bootFromJNI != null && bootFromJNI.length > 0) {
                f8368x = new String(bootFromJNI);
            }
            SigmobLog.i("origin bootId:" + f8368x);
            if (!TextUtils.isEmpty(f8368x)) {
                String replaceAll = f8368x.replaceAll("\\s*|\t|\r|\n", "");
                f8368x = replaceAll;
                if (replaceAll.length() > 36) {
                    f8368x = f8368x.substring(0, 36);
                }
            }
            SigmobLog.i("bootId:" + f8368x);
        }
        return f8368x;
    }

    public Context getContext() {
        return this.f8379i;
    }

    public int getDensityDpi() {
        try {
            return (int) DeviceUtils.getDensityDpi(this.f8379i);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getDeviceId() {
        try {
            return getDeviceId(-1);
        } catch (Throwable th2) {
            SigmobLog.e("getDeviceId:" + th2.getMessage());
            return null;
        }
    }

    public Locale getDeviceLocale() {
        try {
            return DeviceUtils.getDeviceLocale(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getDeviceName() {
        try {
            return DeviceUtils.getDeviceName(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenHeightDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenHeightDip(this.f8379i));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public Integer getDeviceScreenRealHeightDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenRealHeightDip(this.f8379i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenRealWidthDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenRealWidthDip(this.f8379i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenWidthDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenWidthDip(this.f8379i));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getDeviceSerial() {
        try {
            return DeviceUtils.getDeviceSerial();
        } catch (Throwable unused) {
            return null;
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        try {
            return DeviceUtils.getDisplayMetrics(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getIMSI() {
        try {
            return DeviceHelper.getIMSI(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getInsetBottom() {
        return this.f8373c;
    }

    public long getInstallTime() {
        return this.f8386p;
    }

    public boolean getLimitAdTrackingEnabled() {
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public Location getLocation() {
        if (!this.f8380j) {
            return null;
        }
        Location location = this.f8371a;
        if (location != null) {
            return location;
        }
        LocationManager locationManager = getLocationManager();
        if (locationManager != null && DeviceUtils.isCanRetryLocation()) {
            SigmobLog.d("private :use_location ");
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation != null) {
                this.f8371a = lastKnownLocation;
            }
        }
        return this.f8371a;
    }

    public LocationManager getLocationManager() {
        try {
            if (DeviceUtils.isCanUseLocation(this.f8379i)) {
                return (LocationManager) this.f8379i.getSystemService("location");
            }
            return null;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return null;
        }
    }

    public String getNetworkOperatorForUrl() {
        try {
            return DeviceUtils.getNetworkOperatorForUrl(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getNetworkOperatorName() {
        try {
            return DeviceUtils.getNetworkOperatorName(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getOAID() {
        int disable_up_OAid = Config.sharedInstance().getDisable_up_OAid();
        boolean oaidApiDisable = Config.sharedInstance().getOaidApiDisable();
        if ((disable_up_OAid < 0 || disable_up_OAid > 1) && oaidApiDisable) {
            return null;
        }
        String oaid_sdk = getOAID_SDK();
        if (TextUtils.isEmpty(oaid_sdk) && this.f8391u) {
            oaid_sdk = getOAID_API();
        }
        if (TextUtils.isEmpty(oaid_sdk) || oaid_sdk.equalsIgnoreCase(this.f8381k)) {
            return this.f8381k;
        }
        this.f8381k = oaid_sdk;
        return oaid_sdk;
    }

    public String getOAID_API() {
        try {
            if (Build.VERSION.SDK_INT <= 28 || Config.sharedInstance().getOaidApiDisable()) {
                return null;
            }
            if (!TextUtils.isEmpty(this.f8384n)) {
                return this.f8384n;
            }
            DeviceHelper.getOAID_API(this.f8379i, new b());
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getOAID_SDK() {
        try {
            int disable_up_OAid = Config.sharedInstance().getDisable_up_OAid();
            if (disable_up_OAid == 0) {
                if (Build.VERSION.SDK_INT > 28) {
                    return b();
                }
                return null;
            }
            if (disable_up_OAid == 1 && Build.VERSION.SDK_INT >= 23) {
                return b();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getOrientationInt() {
        try {
            return Integer.valueOf(DeviceUtils.getOrientationInt(this.f8379i));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getPermission(Context context) {
        StringBuilder sb2;
        String str;
        String str2 = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (packageManager.checkPermission(strArr[i10], packageName) == 0) {
                    if (i10 == strArr.length - 1) {
                        sb2 = new StringBuilder();
                        sb2.append(str2);
                        str = strArr[i10];
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(strArr[i10]);
                        str = ",";
                    }
                    sb2.append(str);
                    str2 = sb2.toString();
                }
            }
            SigmobLog.d("permissionReq:" + str2);
            if (!TextUtils.isEmpty(str2)) {
                return Base64.encodeToString(str2.getBytes(), 2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return str2;
    }

    public DisplayMetrics getRealMetrics() {
        try {
            return DeviceUtils.getRealMetrics(this.f8379i);
        } catch (Throwable unused) {
            return DeviceUtils.getDisplayMetrics(this.f8379i);
        }
    }

    public String getRotation() {
        try {
            return DeviceUtils.getRotation(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getSDCardPath() {
        try {
            return DeviceUtils.getSDCardPath(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getScreenOrientation(Context context) {
        Display display = DeviceUtils.getDisplay(context);
        if (display == null) {
            return 0;
        }
        return display.getRotation();
    }

    public String getStringResources(String str, String str2) {
        Resources resources;
        int identifier;
        Context context = this.f8379i;
        return (context == null || (resources = context.getResources()) == null || (identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, this.f8379i.getPackageName())) == 0) ? str2 : resources.getString(identifier);
    }

    public int getStyleResources(String str) {
        Resources resources;
        Context context = this.f8379i;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return resources.getIdentifier(str, "style", this.f8379i.getPackageName());
    }

    public Long getSystemTotalMemorySize() {
        try {
            return Long.valueOf(DeviceUtils.getSysteTotalMemorySize(this.f8379i));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getTargetSdkVersion() {
        try {
            if (!TextUtils.isEmpty(this.f8385o)) {
                return this.f8385o;
            }
            String valueOf = String.valueOf(this.f8379i.getApplicationInfo().targetSdkVersion);
            this.f8385o = valueOf;
            return valueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUDID() {
        String str = this.f8383m;
        if (str != null) {
            return str;
        }
        this.f8383m = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.f8379i).edit();
        edit.putString("sig_UDID", this.f8383m);
        edit.apply();
        return this.f8383m;
    }

    public String getUpdateId() {
        try {
        } catch (Throwable th2) {
            SigmobLog.i("getUpdateId:" + th2.getMessage());
        }
        if (Config.sharedInstance().isDisableBootMark()) {
            return "";
        }
        if (TextUtils.isEmpty(this.f8378h)) {
            this.f8378h = TanId.getUpdateFromJNI();
            SigmobLog.i("updateId:" + this.f8378h);
        }
        return this.f8378h;
    }

    public String getWifiName() {
        try {
            return DeviceHelper.getWifiName(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getWifimac() {
        try {
            return DeviceHelper.getWifimac(this.f8379i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void initialize(Context context) {
        try {
            if (this.f8379i == null) {
                Context applicationContext = context.getApplicationContext();
                this.f8379i = applicationContext;
                long j10 = SharedPreferencesUtil.getSharedPreferences(applicationContext).getLong("install_time", 0L);
                this.f8386p = j10;
                if (j10 == 0) {
                    PackageInfo packageInfo = AppPackageUtil.getPackageInfo(context);
                    this.f8386p = packageInfo == null ? System.currentTimeMillis() / 1000 : packageInfo.firstInstallTime / 1000;
                    SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.f8379i).edit();
                    edit.putLong("install_time", this.f8386p);
                    edit.apply();
                }
                this.f8383m = SharedPreferencesUtil.getSharedPreferences(this.f8379i).getString("sig_UDID", null);
                String string = SharedPreferencesUtil.getSharedPreferences(this.f8379i).getString("uid_aes_gcm", null);
                if (string != null) {
                    f8370z = AESUtil.DecryptString(string, Constants.AESKEY);
                } else {
                    String string2 = SharedPreferencesUtil.getSharedPreferences(this.f8379i).getString("uid", null);
                    f8370z = string2;
                    if (string2 != null) {
                        SharedPreferences.Editor edit2 = SharedPreferencesUtil.getSharedPreferences(this.f8379i).edit();
                        edit2.remove("uid");
                        edit2.putString("uid_aes_gcm", AESUtil.EncryptString(f8370z, Constants.AESKEY));
                        edit2.apply();
                    }
                }
                String string3 = SharedPreferencesUtil.getSharedPreferences(this.f8379i).getString("oaid_aes_gcm", null);
                if (string3 != null) {
                    this.f8381k = AESUtil.DecryptString(string3, Constants.AESKEY);
                } else {
                    String string4 = SharedPreferencesUtil.getSharedPreferences(this.f8379i).getString(AdKeys.OAID, null);
                    this.f8381k = string4;
                    if (string4 != null) {
                        SharedPreferences.Editor edit3 = SharedPreferencesUtil.getSharedPreferences(this.f8379i).edit();
                        edit3.remove(AdKeys.OAID);
                        edit3.putString("oaid_aes_gcm", AESUtil.EncryptString(this.f8381k, Constants.AESKEY));
                        edit3.apply();
                    }
                }
                this.f8372b = new IdentifierManager(this.f8379i, this);
                SQLiteMTAHelper.initialize(this.f8379i);
                SQLiteTrackHelper.initialize(this.f8379i);
                BuriedPointManager.getInstance().start();
                DeviceUtils.registerNetworkChange(this.f8379i);
                TrackManager.getInstance().startRetryTracking();
                ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new c());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public boolean isNetworkConnected(String str) {
        try {
            return SigmobRequestUtil.isConnection(new URL(str).getHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isRetryAble() {
        return this.f8374d;
    }

    public boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public boolean isTablet() {
        try {
            return DeviceUtils.isTablet(this.f8379i);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.czhj.sdk.common.utils.IdentifierManager.AdvertisingIdChangeListener
    public void onIdChanged(AdvertisingId advertisingId, AdvertisingId advertisingId2) {
    }

    public void setEnableLocation(boolean z10) {
        this.f8380j = z10;
    }

    public void setLocation(Location location) {
        this.f8371a = location;
    }

    public void setRetryAble(boolean z10) {
        this.f8374d = z10;
    }

    public void setUid(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(f8370z) && str.equalsIgnoreCase(f8370z)) {
                return;
            }
            f8370z = str;
            SharedPreferences.Editor edit = SharedPreferencesUtil.getSharedPreferences(this.f8379i).edit();
            edit.putString("uid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
            edit.apply();
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public void setWindInsets(WindowInsets windowInsets) {
        if (windowInsets == null || !windowInsets.isRound()) {
            return;
        }
        this.f8373c = windowInsets.getSystemWindowInsetBottom();
    }

    public final boolean c() {
        return this.f8379i.getPackageManager().queryIntentActivities(new Intent("android.settings.USAGE_ACCESS_SETTINGS"), 65536).size() > 0;
    }

    public synchronized String getDeviceId(int i10) {
        try {
            if (TextUtils.isEmpty(this.f8375e) && Build.VERSION.SDK_INT < 29) {
                if (DeviceUtils.isCanUsePhoneState(this.f8379i) && DeviceUtils.isCanRetryIMEI()) {
                    this.f8375e = DeviceHelper.getIMEI(this.f8379i);
                    this.f8376f = DeviceHelper.getIMEI(this.f8379i, 0);
                    this.f8377g = DeviceHelper.getIMEI(this.f8379i, 1);
                }
                return null;
            }
            if (i10 == -1) {
                return this.f8375e;
            }
            if (i10 == 0) {
                return this.f8376f;
            }
            return this.f8377g;
        } catch (Throwable th2) {
            SigmobLog.e("getDeviceId:" + th2.getMessage());
            return null;
        }
    }

    public String getStringResources(String str, String str2, Object... objArr) {
        Resources resources;
        Context context = this.f8379i;
        if (context == null || (resources = context.getResources()) == null) {
            return str2;
        }
        int identifier = resources.getIdentifier(str, TypedValues.Custom.S_STRING, this.f8379i.getPackageName());
        if (identifier == 0) {
            return String.format(str2, objArr);
        }
        SigmobLog.d("getStringResources resid" + identifier);
        return resources.getString(identifier, objArr);
    }

    public final String b() {
        if (!TextUtils.isEmpty(this.f8382l)) {
            return this.f8382l;
        }
        try {
            DeviceHelper.getOAID(this.f8379i, new a());
        } catch (Throwable unused) {
        }
        return this.f8382l;
    }

    public DownloadManager a() {
        return (DownloadManager) this.f8379i.getSystemService("download");
    }
}
