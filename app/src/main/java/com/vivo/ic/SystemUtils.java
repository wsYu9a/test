package com.vivo.ic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes4.dex */
public class SystemUtils {
    private static final int LOLLIPOP = 21;
    private static final String MODEL_1007 = "PD1007";
    private static final String MODEL_1007B = "PD1007B";
    private static final String MODEL_1007C = "PD1007C";
    private static final String MODEL_1110 = "PD1110";
    private static final String MODEL_1115 = "PD1115";
    private static final String MODEL_1121 = "PD1121";
    private static final String MODEL_1124 = "PD1124";
    private static final String MODEL_1124T = "PD1124T";
    private static final String MODEL_1203 = "PD1203";
    private static final String MODEL_1203T = "PD1203T";
    private static final String MODEL_1206 = "PD1206";
    private static final String MODEL_1207W = "PD1207W";
    private static final String MODEL_1208 = "PD1208";
    private static final String MODEL_1209 = "PD1209";
    private static final int P = 28;
    private static String PLATFORM_INFO = null;
    private static final String PROP_BRANCH_VERSION = "ro.hardware.bbk";
    private static final String PROP_CUSTOMIZE = "ro.product.customize.bbk";
    private static final String PROP_CUSTOMIZE_NEW = "ro.product.country.region";
    private static final String PROP_HARDWARE = "ro.boot.hardware";
    private static final String PROP_MODEL = "ro.product.model.bbk";
    private static final String PROP_QCOM = "qcom";
    private static final String PROP_SIM_ID = "gsm.sim.operator.numeric.2";
    private static final String PROP_SIM_ID_SINGLE = "gsm.sim.operator.numeric";
    private static final String PROP_VERSION = "ro.build.version.bbk";
    private static final String PROP_VIVO_IN_NAME = "ro.vivo.internet.name";
    private static final String PROP_VIVO_NAME = "ro.vivo.market.name";
    private static final int SOFT_VERSION_LIST_LENGTH_MAX = 3;
    private static final String TAG = "SystemUtils";
    private static boolean isMtk;
    private static boolean isMulSimCard;
    private static boolean isQcom;
    private static int sCount;
    private static final boolean IS_CDMA_DEVICE = getSystemProperties("ro.vivo.op.entry", "no").contains("CTCC");
    private static String PLATFORM_TAG = "ro.vivo.product.solution";
    private static String QCOM_PLATFORM = "QCOM";
    private static String MTK_PLATFORM = "MTK";
    private static String DEFAULT_IMEI = "123456789012345";
    private static int GET_IMEI_MAX_COUNT = 10;
    private static String mImei = "";
    private static String sUsfId = "";
    private static final byte[] LOCK = new byte[0];

    static {
        PLATFORM_INFO = null;
        isMtk = false;
        isQcom = false;
        isMulSimCard = false;
        String systemProperties = getSystemProperties("ro.vivo.product.solution", "");
        PLATFORM_INFO = systemProperties;
        isQcom = QCOM_PLATFORM.equals(systemProperties);
        isMtk = MTK_PLATFORM.equals(PLATFORM_INFO);
        if (Build.VERSION.SDK_INT >= 21) {
            isMulSimCard = isMultiSimEnabled();
            return;
        }
        try {
            if (isMtk) {
                Class<?> cls = Class.forName("com.mediatek.common.featureoption.FeatureOption");
                Field declaredField = cls.getDeclaredField("MTK_GEMINI_SUPPORT");
                declaredField.setAccessible(true);
                isMulSimCard = declaredField.getBoolean(cls.newInstance());
                cls.getDeclaredField("MTK_VT3G324M_SUPPORT").setAccessible(true);
            } else {
                if (!isQcom) {
                    return;
                }
                isMulSimCard = false;
                Class<?> cls2 = Class.forName("android.telephony.MSimTelephonyManager");
                Method method = cls2.getMethod("getDefault", new Class[0]);
                if (method != null) {
                    Object invoke = method.invoke(null, new Object[0]);
                    Method method2 = cls2.getMethod("isMultiSimEnabled", new Class[0]);
                    if (method2 != null) {
                        isMulSimCard = ((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static String format(String str) {
        char[] charArray = str.trim().toCharArray();
        int length = charArray.length;
        int i2 = 0;
        while (i2 < length && !isDigit(charArray[i2])) {
            i2++;
        }
        return str.substring(i2);
    }

    private static String funtouchSDKImei(Context context) {
        Object invoke;
        try {
            Method method = Class.forName("android.telephony.FtTelephonyAdapter").getMethod("getFtTelephony", Context.class);
            if (method != null && (invoke = method.invoke(null, context)) != null) {
                return (String) invoke.getClass().getMethod("getImei", Integer.TYPE).invoke(invoke, 0);
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String getCustomize() {
        String systemProperties = getSystemProperties(PROP_CUSTOMIZE_NEW, "N");
        return "N".equals(systemProperties) ? getSystemProperties(PROP_CUSTOMIZE, "N") : systemProperties;
    }

    private static String getDeviceIdOfMtk(int i2) {
        try {
            Class<?> cls = Class.forName("com.mediatek.telephony.TelephonyManagerEx");
            Method method = cls.getMethod("getDefault", new Class[0]);
            if (method != null) {
                Object invoke = method.invoke(null, new Object[0]);
                Method method2 = cls.getMethod("getDeviceId", Integer.TYPE);
                if (method2 != null) {
                    return (String) method2.invoke(invoke, Integer.valueOf(i2));
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String getDeviceIdOfQcom(int i2) {
        try {
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            Method method = cls.getMethod("getDefault", new Class[0]);
            if (method != null) {
                Object invoke = method.invoke(null, new Object[0]);
                Method method2 = cls.getMethod("getDeviceId", Integer.TYPE);
                if (method2 != null) {
                    return (String) method2.invoke(invoke, Integer.valueOf(i2));
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String getEmmcId() {
        String emmcIdForAndroidP = Build.VERSION.SDK_INT >= 28 ? getEmmcIdForAndroidP() : "";
        try {
            return TextUtils.isEmpty(emmcIdForAndroidP) ? readTextFile(new File("/sys/block/mmcblk0/device/cid"), 0, null).trim() : emmcIdForAndroidP;
        } catch (Exception e2) {
            e2.printStackTrace();
            return emmcIdForAndroidP;
        }
    }

    private static String getEmmcIdForAndroidP() {
        try {
            Class<?> cls = Class.forName("android.util.FtDeviceInfo");
            return (String) cls.getMethod("getEmmcId", new Class[0]).invoke(cls.newInstance(), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int getHardWare() {
        String systemProperties = getSystemProperties(PROP_HARDWARE, null);
        return (systemProperties == null || !systemProperties.equals(PROP_QCOM)) ? 1 : 0;
    }

    public static String getHardwareVersion() {
        return getSystemProperties(PROP_BRANCH_VERSION, "");
    }

    public static String getImei(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (TextUtils.isEmpty(mImei) || isDefaultIMEI()) {
            if (isDefaultIMEI()) {
                int i2 = sCount;
                if (i2 >= GET_IMEI_MAX_COUNT) {
                    return DEFAULT_IMEI;
                }
                sCount = i2 + 1;
            }
            if (Build.VERSION.SDK_INT >= 22) {
                mImei = funtouchSDKImei(context);
            }
            if (TextUtils.isEmpty(mImei)) {
                if (IS_CDMA_DEVICE) {
                    mImei = getImei1OfCdma();
                } else if (isMulSimCard) {
                    if (isMtk) {
                        mImei = getDeviceIdOfMtk(0);
                    } else {
                        mImei = getDeviceIdOfQcom(0);
                    }
                }
            }
            if (TextUtils.isEmpty(mImei)) {
                int i3 = -1;
                try {
                    Method method = telephonyManager.getClass().getMethod("getPhoneCount", new Class[0]);
                    boolean isAccessible = method.isAccessible();
                    method.setAccessible(true);
                    i3 = Integer.parseInt(String.valueOf(method.invoke(telephonyManager, new Object[0])));
                    method.setAccessible(isAccessible);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                } catch (IllegalArgumentException e4) {
                    e4.printStackTrace();
                } catch (NoSuchMethodException e5) {
                    e5.printStackTrace();
                } catch (InvocationTargetException e6) {
                    e6.printStackTrace();
                }
                try {
                    if (i3 <= 1) {
                        Method method2 = telephonyManager.getClass().getMethod("getImei", new Class[0]);
                        boolean isAccessible2 = method2.isAccessible();
                        method2.setAccessible(true);
                        mImei = String.valueOf(method2.invoke(telephonyManager, new Object[0]));
                        method2.setAccessible(isAccessible2);
                    } else {
                        Method method3 = telephonyManager.getClass().getMethod("getImei", Integer.TYPE);
                        boolean isAccessible3 = method3.isAccessible();
                        method3.setAccessible(true);
                        mImei = String.valueOf(method3.invoke(telephonyManager, new Object[0]));
                        method3.setAccessible(isAccessible3);
                    }
                } catch (IllegalAccessException e7) {
                    e7.printStackTrace();
                } catch (IllegalArgumentException e8) {
                    e8.printStackTrace();
                } catch (NoSuchMethodException e9) {
                    e9.printStackTrace();
                } catch (InvocationTargetException e10) {
                    e10.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(mImei)) {
                try {
                    mImei = telephonyManager.getDeviceId();
                } catch (SecurityException unused) {
                }
            }
            if (TextUtils.isEmpty(mImei)) {
                mImei = DEFAULT_IMEI;
            }
        }
        return mImei;
    }

    private static String getImei1OfCdma() {
        try {
            Object invoke = Class.forName("com.android.internal.telephony.ITelephony$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "phone"));
            return invoke != null ? (String) invoke.getClass().getMethod("getImei", new Class[0]).invoke(invoke, new Object[0]) : "";
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return "";
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return "";
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
            return "";
        } catch (NoSuchMethodException e5) {
            e5.printStackTrace();
            return "";
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return "";
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getProductName() {
        String systemProperties = getSystemProperties(PROP_VIVO_IN_NAME, EnvironmentCompat.MEDIA_UNKNOWN);
        if (!TextUtils.isEmpty(systemProperties) && !EnvironmentCompat.MEDIA_UNKNOWN.equals(systemProperties)) {
            if (systemProperties.toLowerCase().contains("vivo")) {
                return systemProperties;
            }
            return "vivo " + systemProperties;
        }
        String systemProperties2 = getSystemProperties(PROP_VIVO_NAME, EnvironmentCompat.MEDIA_UNKNOWN);
        if (EnvironmentCompat.MEDIA_UNKNOWN.equals(systemProperties2) || TextUtils.isEmpty(systemProperties2)) {
            return Build.MODEL;
        }
        if (systemProperties2.toLowerCase().contains("vivo")) {
            return systemProperties2;
        }
        return "vivo " + systemProperties2;
    }

    public static String getProjectVersion() {
        return getSystemProperties(PROP_VERSION, "");
    }

    public static int getSimCount() {
        String systemProperties = getSystemProperties(PROP_HARDWARE, null);
        if (systemProperties == null || !systemProperties.equals(PROP_QCOM)) {
            String systemProperties2 = getSystemProperties(PROP_SIM_ID_SINGLE, null);
            String systemProperties3 = getSystemProperties(PROP_SIM_ID, null);
            if (systemProperties2 == null && systemProperties3 == null) {
                return 0;
            }
            if (systemProperties2 != null && systemProperties3 != null) {
                return 2;
            }
        }
        return 1;
    }

    public static String getSimId1() {
        return getSystemProperties(PROP_SIM_ID_SINGLE, null);
    }

    public static String getSimId2() {
        return getSystemProperties(PROP_SIM_ID, null);
    }

    public static String getSoftVersion() {
        String[] split;
        String systemProperties = getSystemProperties(PROP_VERSION, "");
        return (TextUtils.isEmpty(systemProperties) || (split = systemProperties.split("_")) == null) ? "" : split.length <= 3 ? format(split[split.length - 1]) : format(split[2]);
    }

    public static String getSysVersion() {
        String systemModel = getSystemModel();
        String hardwareVersion = getHardwareVersion();
        String softVersion = getSoftVersion();
        if (TextUtils.isEmpty(systemModel) || TextUtils.isEmpty(hardwareVersion) || TextUtils.isEmpty(softVersion)) {
            return "";
        }
        return systemModel + "_" + hardwareVersion + "_" + softVersion;
    }

    public static String getSystemModel() {
        String systemProperties = getSystemProperties(PROP_MODEL, "");
        return (MODEL_1124.equals(systemProperties) || MODEL_1121.equals(systemProperties) || MODEL_1007C.equals(systemProperties) || MODEL_1007.equals(systemProperties) || MODEL_1115.equals(systemProperties) || MODEL_1110.equals(systemProperties) || MODEL_1203.equals(systemProperties) || MODEL_1206.equals(systemProperties) || MODEL_1207W.equals(systemProperties) || MODEL_1007B.equals(systemProperties) || MODEL_1208.equals(systemProperties) || MODEL_1209.equals(systemProperties) || MODEL_1203T.equals(systemProperties) || MODEL_1124T.equals(systemProperties)) ? Build.MODEL.replace(" ", "") : systemProperties;
    }

    public static String getSystemProperties(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static String getUFSIdForAndroidP() {
        try {
            Class<?> cls = Class.forName("android.util.FtDeviceInfo");
            return (String) cls.getMethod("getUFSId", new Class[0]).invoke(cls.newInstance(), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String getUfsId() {
        String uFSIdForAndroidP = Build.VERSION.SDK_INT >= 28 ? getUFSIdForAndroidP() : "";
        try {
            return TextUtils.isEmpty(uFSIdForAndroidP) ? readTextFile(new File("/sys/ufs/ufsid"), 0, null).trim() : uFSIdForAndroidP;
        } catch (Exception e2) {
            e2.printStackTrace();
            return uFSIdForAndroidP;
        }
    }

    public static String getUfsid() {
        if (!TextUtils.isEmpty(sUsfId)) {
            return sUsfId;
        }
        String ufsId = getUfsId();
        sUsfId = ufsId;
        if (TextUtils.isEmpty(ufsId)) {
            sUsfId = getEmmcId();
        }
        return sUsfId;
    }

    private static boolean isDefaultIMEI() {
        return DEFAULT_IMEI.equals(mImei);
    }

    private static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean isMultiSimEnabled() {
        try {
            Class<?> cls = Class.forName("android.telephony.TelephonyManager");
            Method method = cls.getMethod("getDefault", new Class[0]);
            if (method == null) {
                return false;
            }
            Object invoke = method.invoke(null, new Object[0]);
            Method method2 = cls.getMethod("isMultiSimEnabled", new Class[0]);
            if (method2 != null) {
                return ((Boolean) method2.invoke(invoke, new Object[0])).booleanValue();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSystemApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    public static boolean isSystemUpdateApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }

    public static boolean isUserApp(ApplicationInfo applicationInfo) {
        return (isSystemApp(applicationInfo) || isSystemUpdateApp(applicationInfo)) ? false : true;
    }

    public static boolean isVivoPhone() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    public static String readTextFile(File file, int i2, String str) throws IOException {
        int read;
        boolean z;
        int read2;
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        try {
            long length = file.length();
            if (i2 > 0 || (length > 0 && i2 == 0)) {
                if (length > 0 && (i2 == 0 || length < i2)) {
                    i2 = (int) length;
                }
                byte[] bArr = new byte[i2 + 1];
                int read3 = bufferedInputStream.read(bArr);
                if (read3 <= 0) {
                    return "";
                }
                if (read3 <= i2) {
                    return new String(bArr, 0, read3);
                }
                if (str == null) {
                    return new String(bArr, 0, i2);
                }
                return new String(bArr, 0, i2) + str;
            }
            if (i2 >= 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr2 = new byte[1024];
                do {
                    read = bufferedInputStream.read(bArr2);
                    if (read > 0) {
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                } while (read == 1024);
                return byteArrayOutputStream.toString();
            }
            byte[] bArr3 = null;
            byte[] bArr4 = null;
            boolean z2 = false;
            while (true) {
                z = true;
                if (bArr3 != null) {
                    z2 = true;
                }
                if (bArr3 == null) {
                    bArr3 = new byte[-i2];
                }
                read2 = bufferedInputStream.read(bArr3);
                if (read2 != bArr3.length) {
                    break;
                }
                byte[] bArr5 = bArr4;
                bArr4 = bArr3;
                bArr3 = bArr5;
            }
            if (bArr4 == null && read2 <= 0) {
                return "";
            }
            if (bArr4 == null) {
                return new String(bArr3, 0, read2);
            }
            if (read2 > 0) {
                System.arraycopy(bArr4, read2, bArr4, 0, bArr4.length - read2);
                System.arraycopy(bArr3, 0, bArr4, bArr4.length - read2, read2);
            } else {
                z = z2;
            }
            if (str != null && z) {
                return str + new String(bArr4);
            }
            return new String(bArr4);
        } finally {
            bufferedInputStream.close();
            fileInputStream.close();
        }
    }
}
