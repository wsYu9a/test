package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: e */
    private static Method f31094e;

    /* renamed from: a */
    public static final boolean f31090a = b("rom_1.0");

    /* renamed from: b */
    public static final boolean f31091b = b("rom_2.0");

    /* renamed from: c */
    public static final boolean f31092c = b("rom_2.5");

    /* renamed from: d */
    public static final boolean f31093d = b("rom_3.0");

    /* renamed from: f */
    private static String f31095f = null;

    /* renamed from: g */
    private static String f31096g = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String b2 = z.b("ro.vivo.rom", "");
        String b3 = z.b("ro.vivo.rom.version", "");
        p.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            return b3 != null && b3.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (j.class) {
            if (f31095f == null && f31096g == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
                    f31094e = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f31095f = (String) f31094e.invoke(null, "ro.vivo.rom", "@><@");
                    f31096g = (String) f31094e.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    p.b("Device", "getRomCode error");
                }
            }
            p.d("Device", "sRomProperty1 : " + f31095f + " ; sRomProperty2 : " + f31096g);
            String a2 = a(f31095f);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            String a3 = a(f31096g);
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            return a3;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        p.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matcher.group(1));
        sb.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb.toString();
    }
}
