package cn.vlion.ad.inland.base.util.device;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import cn.vlion.ad.inland.base.a0;
import cn.vlion.ad.inland.base.d5;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.p;
import cn.vlion.ad.inland.base.s4;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionPrivateController;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil;
import cn.vlion.ad.inland.base.util.sp.VlionSharedPreferences;
import cn.vlion.ad.inland.base.v4;
import cn.vlion.ad.inland.base.y;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import l5.c;

/* loaded from: classes.dex */
public class VlionDeviceInfo {
    private long AvailableBytes;
    private String Lang;
    private String SSID;
    private String androidId;
    private String battery;
    private int batteryLevel;
    private int battery_status;
    private String bootmark;
    private int cpuCount;
    private float cpu_freq;
    private String density;
    private String device_name;
    private String device_name_md5;
    private int devicetype;
    private int dpi;
    private float fontSize;
    private long fontType;
    private String gaid;
    private int height;
    private String hms_ver_code;
    private String honor_storever;
    private String houiVersion;
    private String hourFormat;
    private String huuiVersion;
    private String hw_ag_ver_code;
    private String imei;
    private String imsi;
    private long internalStorageMemory;
    private String ip;
    private double[] locationList;
    private String mac;
    private String make;
    private long memory;
    private long memorybytes;
    private String mistorever;
    private String miui_version;
    private String model;
    private String mzuiVersion;
    private String oaid;
    private String oppo_storever;
    private String opuiVersion;
    private String os;
    private int osl;
    private String osv;
    private int ppi;
    private int pxratio;
    private String region;
    private String rom_version;
    private String screensize;
    private long sdStorageMemory;
    private String serialno;
    private String spOaid;
    private long systemInitTime;
    private String time_zone;
    private String timezone;
    private long totalBlocks;
    private String updateMark;
    private String userAgent;
    private String vaid;
    private String versionCode;
    private String viuiVersion;
    private String vivo_storever;
    private int width;

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f3403a;

        public a(Context context) {
            this.f3403a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                LogVlion.e("getUserAgent 子线userAgent=" + VlionDeviceInfo.this.userAgent);
                VlionDeviceInfo.this.userAgent = new WebView(this.f3403a).getSettings().getUserAgentString();
                VlionSharedPreferences.getInstance().setUa(VlionDeviceInfo.this.userAgent);
                LogVlion.e("getUserAgent 子线userAgent=" + VlionDeviceInfo.this.userAgent);
            } catch (Throwable th2) {
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        }
    }

    public static class b {

        /* renamed from: a */
        public static VlionDeviceInfo f3405a = new VlionDeviceInfo(null);
    }

    private VlionDeviceInfo() {
        this.userAgent = "";
        this.devicetype = -1;
        this.make = "";
        this.model = "";
        this.os = "";
        this.osv = "";
        this.imei = "";
        this.androidId = "";
        this.gaid = "";
        this.memorybytes = 0L;
        this.timezone = "";
        this.oaid = "";
        this.mac = "";
        this.width = -1;
        this.height = -1;
        this.cpuCount = 0;
        this.ppi = -1;
        this.pxratio = -1;
        this.osl = -1;
        this.imsi = "";
        this.density = "";
        this.dpi = 0;
        this.screensize = "";
        this.serialno = "";
        this.time_zone = "";
        this.locationList = new double[]{c.f27899e, c.f27899e};
        this.totalBlocks = 0L;
        this.AvailableBytes = 0L;
        this.SSID = "";
        this.hms_ver_code = "";
        this.hw_ag_ver_code = "";
        this.vaid = "";
        this.vivo_storever = "";
        this.oppo_storever = "";
        this.honor_storever = "";
        this.mistorever = "";
        this.versionCode = "";
        this.miui_version = "";
        this.region = "";
        this.batteryLevel = 25;
        this.Lang = "";
        this.ip = "";
        this.mzuiVersion = "";
        this.viuiVersion = "";
        this.opuiVersion = "";
        this.huuiVersion = "";
        this.houiVersion = "";
        this.device_name = "";
        this.device_name_md5 = "";
        this.rom_version = "";
        this.cpu_freq = -1.0f;
        this.battery_status = -1;
    }

    public static long getBuildTime() {
        return Build.TIME;
    }

    public static VlionDeviceInfo getInstance() {
        return b.f3405a;
    }

    public static long getStartupTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public void SetGaid(String str) {
        this.gaid = str;
    }

    public String getAndroidId(Context context) {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.androidId)) {
            this.androidId = v4.a(context);
        }
        return this.androidId;
    }

    public String getAppVersionCode(Context context, String str) {
        if (TextUtils.isEmpty(this.versionCode)) {
            this.versionCode = v4.a(context, str);
        }
        return this.versionCode;
    }

    public long getAvailableStorageSpace() {
        return v4.a();
    }

    public String getBattery(Context context) {
        if (TextUtils.isEmpty(this.battery)) {
            String str = "";
            if (context != null) {
                try {
                    Double valueOf = Double.valueOf(c.f27899e);
                    Object newInstance = Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context);
                    if (newInstance != null) {
                        valueOf = (Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", null).invoke(newInstance, null);
                    }
                    LogVlion.e("getSdStorageMemory batteryCapacity=" + valueOf);
                    str = String.valueOf(valueOf);
                } catch (Throwable th2) {
                    p.a(th2, "getSdStorageMemory Exception=", th2);
                }
            }
            this.battery = str;
        }
        return this.battery;
    }

    public int getBatteryLevel() {
        if (this.batteryLevel == 25) {
            this.batteryLevel = new Random().nextInt(75) + 25;
        }
        return this.batteryLevel;
    }

    public int getBatteryStatus(Context context) {
        try {
            if (this.battery_status < 0) {
                this.battery_status = v4.b(context);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this.battery_status;
    }

    public String getBootMark() {
        String str;
        File file;
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(this.bootmark)) {
            try {
                file = new File("/proc/sys/kernel/random/boot_id");
            } catch (Throwable th2) {
                p.a(th2, "getBootMark Throwable=", th2);
            }
            if (file.exists()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            str = new BufferedReader(new InputStreamReader(fileInputStream)).readLine().trim().substring(0, 36);
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        } catch (IOException e11) {
                            e = e11;
                            fileInputStream2 = fileInputStream;
                            LogVlion.e("getBootMark IOException =" + e);
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            str = "";
                            this.bootmark = str;
                            return this.bootmark;
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e14) {
                        e = e14;
                    }
                    this.bootmark = str;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                }
            }
            str = "";
            this.bootmark = str;
        }
        return this.bootmark;
    }

    public String getCarrier(Context context) {
        TelephonyManager telephonyManager;
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        String str = "";
        if (context != null && privateController != null) {
            LogVlion.e("getOperator carrier=");
            if (TextUtils.isEmpty("")) {
                try {
                    LogVlion.e("VlionDeviceUtils getOperator +=");
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                } catch (Throwable th2) {
                    p.a(th2, "VlionDeviceUtils getOperator e=", th2);
                }
                if (telephonyManager != null) {
                    LogVlion.e("VlionDeviceUtils getOperator tm.getSimState()=" + telephonyManager.getSimState());
                    if (telephonyManager.getSimState() == 5) {
                        String simOperator = telephonyManager.getSimOperator();
                        str = telephonyManager.getNetworkOperator();
                        LogVlion.e("VlionDeviceUtils getOperatorsimOperator=" + simOperator + " networkOperator=" + str);
                    }
                    y.a("VlionDeviceUtils getOperator operator：", str);
                }
            }
        }
        return str;
    }

    public int getConnectionType(Context context) {
        return NetWorkTypeUtil.getConnectionType();
    }

    public Float getCpuFreq() {
        try {
            float f10 = 0.0f;
            if (this.cpu_freq < 0.0f) {
                try {
                    String readLine = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq").getInputStream())).readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        f10 = Float.parseFloat(readLine);
                    }
                } catch (IOException | NumberFormatException e10) {
                    e10.printStackTrace();
                }
                this.cpu_freq = f10;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return Float.valueOf(this.cpu_freq);
    }

    public int getCpuNum() {
        if (this.cpuCount == 0) {
            this.cpuCount = Runtime.getRuntime().availableProcessors();
        }
        return this.cpuCount;
    }

    public String getDensity(Context context) {
        if (TextUtils.isEmpty(this.density)) {
            getScreenParameter(context);
        }
        return this.density;
    }

    public String getDeviceName(Context context) {
        try {
            if (TextUtils.isEmpty(this.device_name)) {
                this.device_name = v4.c(context);
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this.device_name;
    }

    public int getDevicetype(Context context) {
        if (this.devicetype == -1) {
            this.devicetype = v4.p(context) ? 5 : 4;
        }
        return this.devicetype;
    }

    public int getDpi(Context context) {
        if (this.dpi == 0) {
            getScreenParameter(context);
        }
        return this.dpi;
    }

    public float getFontSize(Context context) {
        Resources resources;
        float f10;
        if (this.fontSize <= 0.0f) {
            if (context != null) {
                try {
                    resources = context.getResources();
                } catch (Throwable th2) {
                    p.a(th2, "getFontSize Exception=", th2);
                }
                if (resources != null) {
                    Configuration configuration = resources.getConfiguration();
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (configuration != null && displayMetrics != null) {
                        f10 = configuration.fontScale * displayMetrics.scaledDensity;
                        LogVlion.e("getFontSize fontSize=" + f10);
                        this.fontSize = f10;
                    }
                }
            }
            f10 = -1.0f;
            this.fontSize = f10;
        }
        return this.fontSize;
    }

    public long getFontType(Context context) {
        if (this.fontType <= 0) {
            long j10 = -1;
            if (context != null) {
                try {
                    int style = Typeface.DEFAULT.getStyle();
                    LogVlion.e("getFontType fontType=" + style);
                    j10 = style;
                } catch (Throwable th2) {
                    p.a(th2, "getFontType Exception=", th2);
                }
            }
            this.fontType = j10;
        }
        return this.fontType;
    }

    public String getGaid(Context context) {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (context == null || privateController == null || !privateController.isCanUseGaid()) {
            return "";
        }
        if (TextUtils.isEmpty(this.gaid)) {
            Executors.newSingleThreadExecutor().execute(new d5(context));
        }
        return this.gaid;
    }

    public int getHeight(Context context) {
        if (context == null) {
            return this.height;
        }
        if (this.height <= 0) {
            int[] l10 = v4.l(context);
            if (l10.length > 1) {
                this.height = l10[1];
            }
        }
        return this.height;
    }

    public String getHourFormat(Context context) {
        if (TextUtils.isEmpty(this.hourFormat)) {
            this.hourFormat = v4.d(context);
        }
        return this.hourFormat;
    }

    public String getIPv4Address() {
        try {
            if (TextUtils.isEmpty(this.ip)) {
                this.ip = v4.b();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this.ip;
    }

    public String getImei(Context context) {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (context == null || privateController == null) {
            return "";
        }
        if (!privateController.isCanUsePhoneState()) {
            return privateController.getImei();
        }
        if (TextUtils.isEmpty(this.imei)) {
            this.imei = v4.e(context);
        }
        return this.imei;
    }

    public String getImsi(Context context) {
        String str;
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (context == null || privateController == null) {
            return this.imsi;
        }
        if (!privateController.isCanUsePhoneState()) {
            return this.imsi;
        }
        if (TextUtils.isEmpty(this.imsi)) {
            try {
            } catch (Throwable th2) {
                StringBuilder a10 = l1.a("getImsi");
                a10.append(th2.getMessage());
                LogVlion.e(a10.toString());
            }
            if (a0.c(context)) {
                LogVlion.e("getImsi checkReadPhonePermission true");
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    str = telephonyManager.getSubscriberId();
                    this.imsi = str;
                }
            }
            str = "";
            this.imsi = str;
        }
        return this.imsi;
    }

    public List<String> getInstalledPackages(Context context) {
        boolean z10;
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (context == null || privateController == null || !privateController.isCanReadAppList()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && a0.a(context)) {
                List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(128);
                if (installedApplications != null && !installedApplications.isEmpty()) {
                    for (ApplicationInfo applicationInfo : installedApplications) {
                        if (applicationInfo != null) {
                            String str = applicationInfo.packageName;
                            int i10 = applicationInfo.flags;
                            if ((i10 & 128) == 0 && (i10 & 1) != 0) {
                                z10 = false;
                                if (!TextUtils.isEmpty(str) && z10) {
                                    arrayList.add(str);
                                }
                            }
                            z10 = true;
                            if (!TextUtils.isEmpty(str)) {
                                arrayList.add(str);
                            }
                        }
                    }
                }
                LogVlion.e("getInstalledPackages:installedPackages=null");
            }
        } catch (Throwable th2) {
            p.a(th2, "getInstalledPackages Exception=", th2);
        }
        return arrayList;
    }

    public long getInternalStorageMemory(Context context) {
        if (this.internalStorageMemory <= 0) {
            this.internalStorageMemory = v4.f(context);
        }
        return this.internalStorageMemory;
    }

    public String getLang() {
        try {
            if (TextUtils.isEmpty(this.Lang)) {
                this.Lang = Locale.getDefault().getLanguage();
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this.Lang;
    }

    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00fe, code lost:
    
        if (r2.contains(com.sigmob.sdk.base.mta.PointCategory.NETWORK) != false) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double[] getLocation(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.util.device.VlionDeviceInfo.getLocation(android.content.Context):double[]");
    }

    public String getMac(Context context) {
        if (!TextUtils.isEmpty(this.mac)) {
            return this.mac;
        }
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (privateController != null) {
            if (!TextUtils.isEmpty(privateController.getMac())) {
                this.mac = privateController.getMac();
            } else if (privateController.isCanUseMacAddress()) {
                this.mac = v4.g(context);
                StringBuilder a10 = l1.a("VlionDeviceInfo mac: ----------- ");
                a10.append(this.mac);
                LogVlion.e(a10.toString());
            }
        }
        return this.mac;
    }

    public String getMake() {
        if (TextUtils.isEmpty(this.make)) {
            this.make = Build.BRAND;
        }
        return this.make;
    }

    public long getMemory(Context context) {
        if (this.memory <= 0) {
            this.memory = v4.h(context);
        }
        return this.memory;
    }

    public long getMemorybytes(Context context) {
        if (this.memorybytes <= 0) {
            this.memorybytes = v4.i(context);
        }
        return this.memorybytes;
    }

    public String getModel() {
        if (TextUtils.isEmpty(this.model)) {
            this.model = Build.MODEL;
        }
        return this.model;
    }

    public String getOS() {
        return "Android";
    }

    public String getOaid() {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        StringBuilder a10 = l1.a("VlionDeviceInfo getOaid:oaid=======");
        a10.append(this.oaid);
        LogVlion.e(a10.toString());
        if (privateController != null) {
            String oaid = privateController.getOaid();
            if (this.spOaid == null) {
                LogVlion.e("VlionDeviceInfo getOaid: getOaid sp");
                this.spOaid = VlionSharedPreferences.getInstance().getOaid();
            }
            LogVlion.e("VlionDeviceInfo getOaid:userOaid=" + oaid + " spOaid=" + this.spOaid);
            if (!TextUtils.isEmpty(oaid)) {
                if (!TextUtils.equals(oaid, this.spOaid)) {
                    this.spOaid = oaid;
                    LogVlion.e("VlionDeviceInfo getOaid:setOaid=userOaid");
                    VlionSharedPreferences.getInstance().setOaid(oaid);
                }
                LogVlion.e("VlionDeviceInfo getOaid: return userOaid;");
                return oaid;
            }
            if (!TextUtils.isEmpty(this.oaid)) {
                StringBuilder a11 = l1.a("VlionDeviceInfo getOaid: oaid: ");
                a11.append(this.oaid);
                LogVlion.e(a11.toString());
                if (!TextUtils.equals(this.oaid, this.spOaid)) {
                    this.spOaid = this.oaid;
                    LogVlion.e("VlionDeviceInfo getOaid:setOaid=oaid");
                    VlionSharedPreferences.getInstance().setOaid(this.oaid);
                }
                LogVlion.e("VlionDeviceInfo getOaid: return oaid;");
                return this.oaid;
            }
            StringBuilder a12 = l1.a("VlionDeviceInfo getOaid: spOaid: ");
            a12.append(this.spOaid);
            LogVlion.e(a12.toString());
            if (!TextUtils.isEmpty(this.spOaid)) {
                LogVlion.e("VlionDeviceInfo getOaid: return spOaid;");
                return this.spOaid;
            }
        }
        return this.oaid;
    }

    public int getOrientation(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getConfiguration().orientation != 1 ? 2 : 1;
        } catch (Throwable th2) {
            p.a(th2, "getOrientation +=", th2);
            return 0;
        }
    }

    public String getOs() {
        if (TextUtils.isEmpty(this.os)) {
            this.os = "android";
        }
        return this.os;
    }

    public int getOsl() {
        if (this.osl < 0) {
            this.osl = v4.c();
        }
        return this.osl;
    }

    public String getOstimezone() {
        String str = "";
        if (TextUtils.isEmpty(this.time_zone)) {
            try {
                str = (TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000) + "";
            } catch (Throwable th2) {
                p.a(th2, "getTimezone Exception=", th2);
            }
            this.time_zone = str;
        }
        return this.time_zone;
    }

    public String getOsv() {
        if (TextUtils.isEmpty(this.osv)) {
            this.osv = Build.VERSION.RELEASE;
        }
        return this.osv;
    }

    public int getPpi(Context context) {
        if (context == null) {
            return this.ppi;
        }
        if (this.ppi < 0) {
            this.ppi = v4.j(context);
        }
        return this.ppi;
    }

    public int getPxratio(Context context) {
        int i10;
        if (context == null) {
            return this.pxratio;
        }
        if (this.pxratio < 0) {
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                LogVlion.e("getPxratio dm.density=" + displayMetrics.density);
                i10 = (int) displayMetrics.density;
            } catch (Throwable th2) {
                p.a(th2, "getPxratio Exception=", th2);
                i10 = -1;
            }
            this.pxratio = i10;
        }
        return this.pxratio;
    }

    public String getRomversion() {
        try {
            if (TextUtils.isEmpty(this.rom_version)) {
                this.rom_version = Build.VERSION.RELEASE;
            }
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
        return this.rom_version;
    }

    public String getSSID(Context context) {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (context == null || privateController == null || !privateController.isCanUseMacAddress()) {
            return null;
        }
        if (TextUtils.isEmpty(this.SSID)) {
            this.SSID = v4.k(context);
        }
        return this.SSID;
    }

    public void getScreenParameter(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            this.density = String.valueOf(displayMetrics.density);
            this.dpi = displayMetrics.densityDpi;
            defaultDisplay.getRealSize(new Point());
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            float sqrt = (float) Math.sqrt(Math.pow(r1.x / displayMetrics2.xdpi, 2.0d) + Math.pow(r1.y / displayMetrics2.ydpi, 2.0d));
            this.screensize = new BigDecimal(sqrt).setScale(2, RoundingMode.HALF_UP).toString();
            LogVlion.e("VlionDeviceInfo ====number=" + sqrt + "   screensize=" + this.screensize);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    public String getScreensize(Context context) {
        if (TextUtils.isEmpty(this.screensize)) {
            getScreenParameter(context);
        }
        return this.screensize;
    }

    public long getSdStorageMemory(Context context) {
        if (this.internalStorageMemory <= 0) {
            this.internalStorageMemory = v4.m(context);
        }
        return this.sdStorageMemory;
    }

    public String getSerialno(Context context) {
        VlionPrivateController privateController = VlionSDkManager.getInstance().getPrivateController();
        if (context == null || privateController == null) {
            return this.serialno;
        }
        if (!privateController.isCanUsePhoneState()) {
            return this.serialno;
        }
        if (TextUtils.isEmpty(this.serialno)) {
            this.serialno = v4.n(context);
        }
        return this.serialno;
    }

    public long getStorageAvailableBytes() {
        if (this.AvailableBytes == 0) {
            getStorageMemory();
        }
        return this.AvailableBytes;
    }

    public void getStorageMemory() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            this.totalBlocks = statFs.getTotalBytes();
            this.AvailableBytes = statFs.getAvailableBytes();
        } catch (Throwable th2) {
            s4.a("getMemory Exception=", th2);
        }
    }

    public long getStoragetotal() {
        if (this.totalBlocks == 0) {
            getStorageMemory();
        }
        return this.totalBlocks;
    }

    public long getSystemInitTime() {
        long j10;
        if (this.systemInitTime <= 0) {
            try {
                j10 = SystemClock.elapsedRealtime();
                LogVlion.e("getTimezone timezone=" + j10);
            } catch (Throwable th2) {
                p.a(th2, "getTimezone Exception=", th2);
                j10 = -1;
            }
            this.systemInitTime = j10;
        }
        return this.systemInitTime;
    }

    public String getTimezone() {
        String str;
        if (TextUtils.isEmpty(this.timezone)) {
            try {
                str = TimeZone.getDefault().getDisplayName(false, 0);
                LogVlion.e("getTimezone timezone=" + str);
            } catch (Throwable th2) {
                p.a(th2, "getTimezone Exception=", th2);
                str = "";
            }
            this.timezone = str;
        }
        return this.timezone;
    }

    public String getUpdateMark() {
        if (TextUtils.isEmpty(this.updateMark)) {
            this.updateMark = v4.d();
        }
        return this.updateMark;
    }

    public String getUserAgent(Context context) {
        try {
            if (TextUtils.isEmpty(this.userAgent)) {
                if (context == null) {
                    return "";
                }
                LogVlion.e("getUserAgent Looper.getMainLooper()=" + Looper.getMainLooper() + " Looper.myLooper()=" + Looper.myLooper());
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    try {
                        LogVlion.e("getUserAgent userAgent MainLooper=" + this.userAgent);
                        this.userAgent = new WebView(context).getSettings().getUserAgentString();
                        VlionSharedPreferences.getInstance().setUa(this.userAgent);
                        LogVlion.e("getUserAgent userAgent MainLooper=" + this.userAgent);
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                } else {
                    VlionHandlerUtils.instant().post(new a(context));
                }
            }
            String ua2 = VlionSharedPreferences.getInstance().getUa();
            if (TextUtils.isEmpty(this.userAgent) && !TextUtils.isEmpty(ua2)) {
                LogVlion.e("getUserAgent 内存没有，本地有=" + ua2);
                return ua2;
            }
        } catch (Throwable th3) {
            VlionSDkManager.getInstance().upLoadCatchException(th3);
        }
        StringBuilder a10 = l1.a("getUserAgent userAgent return=");
        a10.append(this.userAgent);
        LogVlion.e(a10.toString());
        return this.userAgent;
    }

    public String getVaid(Context context) {
        if (TextUtils.isEmpty(this.vaid)) {
            this.vaid = v4.o(context);
        }
        return this.vaid;
    }

    public int getWidth(Context context) {
        if (context == null) {
            return this.width;
        }
        if (this.width <= 0) {
            int[] l10 = v4.l(context);
            if (l10.length > 0) {
                this.width = l10[0];
            }
        }
        return this.width;
    }

    public String gethms_ver_code(Context context) {
        if (TextUtils.isEmpty(this.hms_ver_code)) {
            this.hms_ver_code = v4.a(context, "com.huawei.hwid");
        }
        return this.hms_ver_code;
    }

    public String gethonor_storever(Context context) {
        if (TextUtils.isEmpty(this.honor_storever)) {
            this.honor_storever = v4.a(context, "com.hihonor.appmarket");
        }
        return this.honor_storever;
    }

    public String gethonui_version(Context context) {
        String str;
        if (TextUtils.isEmpty(this.houiVersion)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.emui");
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            this.houiVersion = str;
        }
        return this.houiVersion;
    }

    public String gethw_ag_ver_code(Context context) {
        if (TextUtils.isEmpty(this.hw_ag_ver_code)) {
            this.hw_ag_ver_code = v4.a(context, "com.huawei.appmarket");
        }
        return this.hw_ag_ver_code;
    }

    public String gethwui_version(Context context) {
        String str;
        if (TextUtils.isEmpty(this.huuiVersion)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "hw_sc.build.platform.version");
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            this.huuiVersion = str;
        }
        return this.huuiVersion;
    }

    public String getmistorever(Context context) {
        if (TextUtils.isEmpty(this.mistorever)) {
            this.mistorever = v4.a(context, "com.xiaomi.market");
        }
        return this.mistorever;
    }

    public String getmiui_version(Context context) {
        String str;
        if (TextUtils.isEmpty(this.miui_version)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.miui.version.name");
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            this.miui_version = str;
        }
        return this.miui_version;
    }

    public String getmzui_version(Context context) {
        String str;
        if (TextUtils.isEmpty(this.mzuiVersion)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.emui");
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            this.mzuiVersion = str;
        }
        return this.mzuiVersion;
    }

    public String getoppo_storever(Context context) {
        if (TextUtils.isEmpty(this.oppo_storever)) {
            this.oppo_storever = v4.a(context, Build.VERSION.SDK_INT >= 26 ? "com.heytap.market" : "com.oppo.market");
        }
        return this.oppo_storever;
    }

    public String getopui_version(Context context) {
        String str;
        if (TextUtils.isEmpty(this.opuiVersion)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.build.version.opporom");
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            this.opuiVersion = str;
        }
        return this.opuiVersion;
    }

    public String getregion(Context context) {
        String str;
        if (TextUtils.isEmpty(this.region)) {
            try {
                str = context.getResources().getConfiguration().locale.getCountry();
            } catch (Throwable th2) {
                th2.printStackTrace();
                str = "";
            }
            this.region = str;
        }
        return this.region;
    }

    public String getviui_version(Context context) {
        String str;
        if (TextUtils.isEmpty(this.viuiVersion)) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, "ro.vivo.os.version");
            } catch (Exception e10) {
                e10.printStackTrace();
                str = "";
            }
            this.viuiVersion = str;
        }
        return this.viuiVersion;
    }

    public String getvivo_storever(Context context) {
        if (TextUtils.isEmpty(this.vivo_storever)) {
            this.vivo_storever = v4.a(context, "com.bbk.appstore");
        }
        return this.vivo_storever;
    }

    public boolean isAppInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            LogVlion.e("拉活策略 : getInstalledPackages 已安装 packageName: " + str);
            return true;
        } catch (Throwable unused) {
            y.a("拉活策略 : getInstalledPackages App not found: ", str);
            return false;
        }
    }

    public boolean isConnectionWifi() {
        return 2 == NetWorkTypeUtil.getConnectionType();
    }

    public boolean isRunningTaskForeground(Context context, String str) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                    return false;
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null) {
                        LogVlion.e("VlionDeviceInfo ====packageName=" + str + " processInfo.processName=" + runningAppProcessInfo.processName + " processInfo.importance=" + runningAppProcessInfo.importance);
                        if (str.equals(runningAppProcessInfo.processName) && runningAppProcessInfo.importance == 100) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th2) {
                s4.a("isRunningTaskForeground +=", th2);
            }
        }
        return false;
    }

    public void setOaid(String str) {
        LogVlion.e("VlionDeviceInfo getOaid: setOaid: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.oaid = str;
        VlionSharedPreferences.getInstance().setOaid(str);
    }

    public /* synthetic */ VlionDeviceInfo(a aVar) {
        this();
    }
}
