package com.vivo.ic.dm;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.vivo.ic.VLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
class m {

    /* renamed from: d */
    private static final String f28496d = ".";

    /* renamed from: e */
    private static final String f28497e = "..";

    /* renamed from: a */
    private static final String f28493a = Constants.PRE_TAG + "Helpers";

    /* renamed from: b */
    private static final Pattern f28494b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: c */
    public static final Object f28495c = new Object();

    /* renamed from: f */
    public static Random f28498f = new Random(SystemClock.uptimeMillis());

    m() {
    }

    static String a(Context context, String str, String str2, String str3, String str4, String str5) throws IOException {
        String substring;
        String absolutePath;
        File b2 = b(str2);
        String a2 = a(str, str2, str3, str4);
        int lastIndexOf = a2.lastIndexOf(46);
        if (lastIndexOf < 0) {
            substring = a(str5, true);
        } else {
            String substring2 = a2.substring(0, lastIndexOf);
            substring = a2.substring(lastIndexOf);
            a2 = substring2;
        }
        synchronized (f28495c) {
            File file = new File(b2, a(b2, a2, substring));
            file.createNewFile();
            absolutePath = file.getAbsolutePath();
        }
        return absolutePath;
    }

    private static boolean a(char c2) {
        return ((c2 >= 0 && c2 <= 31) || c2 == '\"' || c2 == '*' || c2 == '/' || c2 == ':' || c2 == '<' || c2 == '\\' || c2 == '|' || c2 == 127 || c2 == '>' || c2 == '?') ? false : true;
    }

    private static File b(String str) throws IOException {
        File file;
        if (TextUtils.isEmpty(str)) {
            file = null;
        } else {
            String str2 = f28493a;
            VLog.d(str2, "chooseParent() hint:" + str);
            String path = Uri.parse(str).getPath();
            VLog.d(str2, "chooseParent() getPath:" + path);
            if (TextUtils.isEmpty(path)) {
                path = Constants.DEFAULT_SD_PARENT + "/" + Constants.DEFAULT_DL_FILENAME;
            }
            file = new File(path).getParentFile();
            if (file != null) {
                file = file.getAbsoluteFile();
            }
        }
        if (file == null) {
            String g2 = l.j().g();
            if (TextUtils.isEmpty(g2)) {
                g2 = Constants.DEFAULT_DL_PARENT;
            }
            file = new File(Uri.parse(g2).getPath());
        }
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Failed to create parent for " + file);
    }

    public static String c(String str) throws IOException {
        File file;
        File file2 = new File(str);
        File parentFile = file2.getParentFile();
        String name = file2.getName();
        synchronized (f28495c) {
            file = new File(parentFile, a(parentFile, name, ".temp"));
            file.createNewFile();
        }
        return file.getAbsolutePath();
    }

    static String d(String str) {
        try {
            return new File(str).getName();
        } catch (Exception unused) {
            return str;
        }
    }

    private static String e(String str) {
        try {
            Matcher matcher = f28494b.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    private static String a(String str, String str2, String str3, String str4) {
        String decode;
        int lastIndexOf;
        String decode2;
        if (str2 == null || str2.endsWith("/")) {
            str2 = null;
        } else {
            VLog.v(f28493a, "getting filename from hint");
            int lastIndexOf2 = str2.lastIndexOf(47) + 1;
            if (lastIndexOf2 > 0) {
                str2 = str2.substring(lastIndexOf2);
            }
        }
        if (TextUtils.isEmpty(str2) && str3 != null && (str2 = e(str3)) != null) {
            VLog.v(f28493a, "getting filename from content-disposition");
            int lastIndexOf3 = str2.lastIndexOf(47) + 1;
            if (lastIndexOf3 > 0) {
                str2 = str2.substring(lastIndexOf3);
            }
        }
        if (TextUtils.isEmpty(str2) && str4 != null && (decode2 = Uri.decode(str4)) != null && !decode2.endsWith("/") && decode2.indexOf(63) < 0) {
            VLog.v(f28493a, "getting filename from content-location");
            int lastIndexOf4 = decode2.lastIndexOf(47) + 1;
            str2 = lastIndexOf4 > 0 ? decode2.substring(lastIndexOf4) : decode2;
        }
        if (TextUtils.isEmpty(str2) && (decode = Uri.decode(str)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
            VLog.v(f28493a, "getting filename from uri");
            str2 = decode.substring(lastIndexOf);
        }
        if (TextUtils.isEmpty(str2)) {
            VLog.v(f28493a, "using default filename");
            str2 = Constants.DEFAULT_DL_FILENAME;
        }
        return a(str2);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || f28496d.equals(str) || f28497e.equals(str)) {
            return "(invalid)";
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (a(charAt)) {
                sb.append(charAt);
            } else {
                sb.append('_');
            }
        }
        return sb.toString();
    }

    private static String a(String str, boolean z) {
        String str2 = null;
        if (str != null) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            if (extensionFromMimeType != null && !"bin".equals(extensionFromMimeType)) {
                VLog.v(f28493a, "adding extension from type");
                str2 = f28496d + extensionFromMimeType;
            } else {
                VLog.v(f28493a, "couldn't find extension for " + str);
            }
        }
        if (str2 != null) {
            return str2;
        }
        if (str == null || !str.toLowerCase().startsWith("text/")) {
            if (!z) {
                return str2;
            }
            VLog.v(f28493a, "adding default binary extension");
            return ".bin";
        }
        if (str.equalsIgnoreCase("text/html")) {
            VLog.v(f28493a, "adding default html extension");
            return ".html";
        }
        if (!z) {
            return str2;
        }
        VLog.v(f28493a, "adding default text extension");
        return com.martian.mibook.lib.local.c.b.b.f13935b;
    }

    private static String a(String str, String str2, int i2) {
        String str3;
        String mimeTypeFromExtension;
        if (str == null || ((mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2.substring(i2 + 1))) != null && mimeTypeFromExtension.equalsIgnoreCase(str))) {
            str3 = null;
        } else {
            str3 = a(str, false);
            if (str3 != null) {
                VLog.v(f28493a, "substituting extension from type");
            } else {
                VLog.v(f28493a, "couldn't find extension for " + str);
            }
        }
        if (str3 != null) {
            return str3;
        }
        VLog.v(f28493a, "keeping extension");
        return str2.substring(i2);
    }

    private static String a(File file, String str, String str2) throws IOException {
        String str3 = str + str2;
        if (!new File(file, str3).exists()) {
            return str3;
        }
        int i2 = 1;
        for (int i3 = 1; i3 < 1000000000; i3 *= 10) {
            for (int i4 = 0; i4 < 9; i4++) {
                String str4 = str + "-" + i2 + str2;
                if (!new File(file, str4).exists()) {
                    return str4;
                }
                i2 += f28498f.nextInt(i3) + 1;
            }
        }
        throw new IOException("Failed to generate an available filename");
    }

    public static void a(String str, ContentValues contentValues, ContentValues contentValues2) {
        Integer asInteger;
        if (TextUtils.isEmpty(str) || contentValues == null || contentValues2 == null || (asInteger = contentValues.getAsInteger(str)) == null) {
            return;
        }
        contentValues2.put(str, asInteger);
    }

    public static Long[] a(ArrayList<Long> arrayList) {
        Long[] lArr = new Long[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            lArr[i2] = arrayList.get(i2);
        }
        return lArr;
    }

    public static String a(String str, int i2) {
        return str + "_" + i2;
    }
}
