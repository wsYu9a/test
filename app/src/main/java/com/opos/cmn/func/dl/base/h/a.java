package com.opos.cmn.func.dl.base.h;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.kuaishou.weapon.p0.g;
import com.opos.cmn.an.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final String f17382a = "a";

    /* renamed from: b */
    private static final Pattern f17383b = Pattern.compile("attachment;\\s*filename\\s*=\\s*(\"?)([^\"]*)\\1\\s*$", 2);

    public static int a(String str, String str2) {
        return (str + File.separator + str2).hashCode();
    }

    public static String a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(bu.f5659a).digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("MD5 should be supported", e2);
        }
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        if (!com.opos.cmn.an.d.b.a.b(com.opos.cmn.an.d.b.a.d(file))) {
            com.opos.cmn.an.d.b.a.c(file);
        }
        com.opos.cmn.an.d.b.a.f(file);
    }

    public static void a(Closeable... closeableArr) {
        try {
            for (Closeable closeable : closeableArr) {
                if (closeable != null) {
                    closeable.close();
                }
            }
        } catch (IOException e2) {
            com.opos.cmn.an.f.a.c(f17382a, e2.getMessage());
        }
    }

    private static boolean a() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(int i2) {
        return i2 == 200 || i2 == 206;
    }

    public static boolean a(long j2) {
        if (a()) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            if (j2 <= statFs.getAvailableBlocks() * statFs.getBlockSize()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(long j2, File file) {
        boolean z = j2 <= 0 || j2 == file.length();
        com.opos.cmn.an.f.a.a(f17382a, "length check:".concat(String.valueOf(z)));
        return z;
    }

    public static boolean a(Context context) {
        return context.checkCallingOrSelfPermission(g.f9325j) == 0 && context.checkCallingOrSelfPermission(g.f9324i) == 0;
    }

    public static boolean a(String str, File file) {
        boolean equals = !TextUtils.isEmpty(str) ? str.equals(c.a(file)) : true;
        com.opos.cmn.an.f.a.a(f17382a, "md5 check:".concat(String.valueOf(equals)));
        return equals;
    }

    public static long b(String str) {
        if (str != null) {
            String[] split = str.split("/");
            if (split.length >= 2) {
                try {
                    return Long.parseLong(split[1]);
                } catch (NumberFormatException unused) {
                    com.opos.cmn.an.f.a.c(f17382a, "parse instance length failed with ".concat(str));
                }
            }
        }
        return -1L;
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Matcher matcher = f17383b.matcher(str);
                if (matcher.find()) {
                    return matcher.group(2);
                }
            } catch (IllegalStateException unused) {
            }
        }
        return null;
    }

    public static String d(String str) {
        String e2 = e(str);
        return TextUtils.isEmpty(e2) ? a(str) : e2;
    }

    private static String e(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                String path = new URL(str).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (!substring.isEmpty()) {
                    return substring;
                }
            } catch (MalformedURLException unused) {
            }
        }
        return null;
    }
}
