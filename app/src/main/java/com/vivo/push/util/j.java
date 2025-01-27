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
    private static Method f25130e;

    /* renamed from: a */
    public static final boolean f25126a = b("rom_1.0");

    /* renamed from: b */
    public static final boolean f25127b = b("rom_2.0");

    /* renamed from: c */
    public static final boolean f25128c = b("rom_2.5");

    /* renamed from: d */
    public static final boolean f25129d = b("rom_3.0");

    /* renamed from: f */
    private static String f25131f = null;

    /* renamed from: g */
    private static String f25132g = null;

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e10) {
            e10.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }

    private static boolean b(String str) {
        String b10 = z.b("ro.vivo.rom", "");
        String b11 = z.b("ro.vivo.rom.version", "");
        p.d("Device", "ro.vivo.rom = " + b10 + " ; ro.vivo.rom.version = " + b11);
        if (b10 == null || !b10.contains(str)) {
            return b11 != null && b11.contains(str);
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (j.class) {
            if (f25131f == null && f25132g == null) {
                try {
                    Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class);
                    f25130e = declaredMethod;
                    declaredMethod.setAccessible(true);
                    f25131f = (String) f25130e.invoke(null, "ro.vivo.rom", "@><@");
                    f25132g = (String) f25130e.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    p.b("Device", "getRomCode error");
                }
            }
            p.d("Device", "sRomProperty1 : " + f25131f + " ; sRomProperty2 : " + f25132g);
            String a10 = a(f25131f);
            if (!TextUtils.isEmpty(a10)) {
                return a10;
            }
            String a11 = a(f25132g);
            if (TextUtils.isEmpty(a11)) {
                return null;
            }
            return a11;
        }
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            p.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        p.d("Device", "Build.MANUFACTURER is " + str);
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith(ke.e.f27807e);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(matcher.group(1));
        sb2.append(TextUtils.isEmpty(matcher.group(2)) ? "0" : matcher.group(2).substring(0, 1));
        return sb2.toString();
    }
}
