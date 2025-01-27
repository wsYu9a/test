package ug;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.MediaDrm;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tanx.onlyid.api.IdStorageManager;
import com.tanx.onlyid.api.OAIDException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class a implements c {

    /* renamed from: a */
    public Application f31062a;

    /* renamed from: b */
    public String f31063b;

    /* renamed from: c */
    public String f31064c;

    public static class b {

        /* renamed from: a */
        public static final a f31065a = new a();
    }

    public /* synthetic */ a(C0791a c0791a) {
        this();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(str2).digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                sb2.append(String.format("%02x", Byte.valueOf(b10)));
            }
            return sb2.toString();
        } catch (Exception e10) {
            e.b(e10);
            return "";
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String b(Context context) {
        String string;
        return (context == null || (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) == null || "9774d56d682e549c".equals(string)) ? "" : string;
    }

    public static String c() {
        String str = b.f31065a.f31063b;
        return str == null ? "" : str;
    }

    public static String d() {
        return a(c(), "MD5");
    }

    public static String e() {
        return a(c(), "SHA-1");
    }

    public static String f(Context context) {
        String p10 = p(context);
        if (TextUtils.isEmpty(p10)) {
            p10 = n(context);
        }
        if (TextUtils.isEmpty(p10)) {
            p10 = o(context);
        }
        if (!TextUtils.isEmpty(p10)) {
            return p10;
        }
        String uuid = UUID.randomUUID().toString();
        e.b("Generate uuid by random: " + uuid);
        t(context, uuid);
        u(context, uuid);
        s(context, uuid);
        return uuid;
    }

    public static File g(Context context) {
        int checkSelfPermission;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23) {
            if (i10 >= 30 || context == null) {
                return null;
            }
            checkSelfPermission = context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            if (checkSelfPermission != 0) {
                return null;
            }
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            return new File(Environment.getExternalStorageDirectory(), "Android/.GUID_uuid");
        }
        return null;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String h(Context context) {
        String imei;
        e.c("OnlyId", "getIMEI");
        if (context == null) {
            return "";
        }
        try {
            imei = ((TelephonyManager) context.getSystemService("phone")).getImei();
            return TextUtils.isEmpty(imei) ? i(context, 0) : imei;
        } catch (Error e10) {
            e.b(e10);
            return "";
        } catch (Exception e11) {
            e.b(e11);
            return "";
        }
    }

    public static String i(Context context, int i10) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (String) telephonyManager.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager, Integer.valueOf(i10));
        } catch (Exception e10) {
            e.b(e10);
            return "";
        }
    }

    public static String j() {
        String str = b.f31065a.f31064c;
        return str == null ? "" : str;
    }

    public static void k(Context context, c cVar) {
        com.tanx.onlyid.api.impl.a.a(context).a(cVar);
    }

    public static String l() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Build.BOARD.length() % 10);
        sb2.append(Arrays.deepToString(Build.SUPPORTED_ABIS).length() % 10);
        sb2.append(Build.DEVICE.length() % 10);
        sb2.append(Build.DISPLAY.length() % 10);
        sb2.append(Build.HOST.length() % 10);
        sb2.append(Build.ID.length() % 10);
        sb2.append(Build.MANUFACTURER.length() % 10);
        sb2.append(Build.BRAND.length() % 10);
        sb2.append(Build.MODEL.length() % 10);
        sb2.append(Build.PRODUCT.length() % 10);
        sb2.append(Build.BOOTLOADER.length() % 10);
        sb2.append(Build.HARDWARE.length() % 10);
        sb2.append(Build.TAGS.length() % 10);
        sb2.append(Build.TYPE.length() % 10);
        sb2.append(Build.USER.length() % 10);
        return sb2.toString();
    }

    public static String m(Context context) {
        int checkSelfPermission;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            e.b("IMEI/MEID not allowed on Android 10+");
            return "";
        }
        if (context == null) {
            return "";
        }
        if (i10 >= 23) {
            checkSelfPermission = context.checkSelfPermission(com.kuaishou.weapon.p0.g.f11102c);
            if (checkSelfPermission != 0) {
                e.b("android.permission.READ_PHONE_STATE not granted");
                return "";
            }
        }
        return h(context);
    }

    public static String n(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        File g10 = g(context);
        if (g10 != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(g10));
                try {
                    str = bufferedReader.readLine();
                    bufferedReader.close();
                } finally {
                }
            } catch (Exception e10) {
                e.b(e10);
            }
        }
        e.b("Get uuid from external storage: " + str);
        return str;
    }

    public static String o(Context context) {
        if (context == null) {
            return "";
        }
        String string = context.getSharedPreferences("GUID", 0).getString("uuid", "");
        e.b("Get uuid from shared preferences: " + string);
        return string;
    }

    public static String p(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.System.getString(context.getContentResolver(), "GUID_uuid");
        e.b("Get uuid from system settings: " + string);
        return string;
    }

    public static String q() {
        try {
            byte[] propertyByteArray = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId");
            if (propertyByteArray == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : propertyByteArray) {
                sb2.append(String.format("%02x", Byte.valueOf(b10)));
            }
            return sb2.toString();
        } catch (Error e10) {
            e.b(e10);
            return "";
        } catch (Exception e11) {
            e.b(e11);
            return "";
        }
    }

    public static void r(Application application) {
        if (application == null) {
            return;
        }
        b.f31065a.f31062a = application;
    }

    public static void s(Context context, String str) {
        if (context == null) {
            return;
        }
        File g10 = g(context);
        if (g10 == null) {
            e.b("UUID file in external storage is null");
            return;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(g10));
            try {
                if (!g10.exists()) {
                    g10.createNewFile();
                }
                bufferedWriter.write(str);
                bufferedWriter.flush();
                e.b("Save uuid to external storage: " + str);
                bufferedWriter.close();
            } finally {
            }
        } catch (Exception e10) {
            e.b(e10);
        }
    }

    public static void t(Context context, String str) {
        if (context == null) {
            return;
        }
        context.getSharedPreferences("GUID", 0).edit().putString("uuid", str).apply();
        e.b("Save uuid to shared preferences: " + str);
    }

    public static void u(Context context, String str) {
        boolean canWrite;
        if (context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            canWrite = Settings.System.canWrite(context);
            if (!canWrite) {
                e.b("android.permission.WRITE_SETTINGS not granted");
                return;
            }
        }
        try {
            Settings.System.putString(context.getContentResolver(), "GUID_uuid", str);
            e.b("Save uuid to system settings: " + str);
        } catch (Exception e10) {
            e.b(e10);
        }
    }

    public static boolean v(Context context) {
        return com.tanx.onlyid.api.impl.a.a(context).b();
    }

    @Override // ug.c
    public void oaidError(Exception exc) {
        String q10 = q();
        if (!TextUtils.isEmpty(q10)) {
            this.f31063b = q10;
            e.b("Client id is WidevineID: " + this.f31063b);
            return;
        }
        String b10 = b(this.f31062a);
        if (TextUtils.isEmpty(b10)) {
            this.f31063b = f(this.f31062a);
            e.b("Client id is GUID: " + this.f31063b);
            return;
        }
        this.f31063b = b10;
        e.b("Client id is AndroidID: " + this.f31063b);
    }

    @Override // ug.c
    public void oaidSucc(String str) {
        if (TextUtils.isEmpty(str)) {
            oaidError(new OAIDException("OAID is empty"));
            return;
        }
        this.f31063b = str;
        this.f31064c = str;
        e.b("Client id is OAID/AAID: " + this.f31063b);
        IdStorageManager.c(this.f31062a).e(IdStorageManager.f21978d, this.f31064c);
    }

    public a() {
    }
}
