package com.kwai.filedownloader.e;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.utils.ap;
import com.kwai.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class f {
    private static long aJA = 2000;
    private static String aJB = null;
    private static Boolean aJC = null;
    private static Boolean aJD = null;
    private static final Pattern aJE = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static int aJz = 65536;

    private static int Jd() {
        return aJz;
    }

    private static long Je() {
        return aJA;
    }

    private static String Jf() {
        if (TextUtils.isEmpty(aJB)) {
            return (c.IZ().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory() : c.IZ().getExternalCacheDir()).getAbsolutePath();
        }
        return aJB;
    }

    public static boolean Jg() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.IZ().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.h(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static String Jh() {
        return j("FileDownloader/%s", "3.3.40");
    }

    public static String a(int i2, com.kwai.filedownloader.kwai.b bVar) {
        if (bVar == null) {
            throw new RuntimeException("connection is null when findEtag");
        }
        String o = bVar.o(DownloadUtils.ETAG);
        if (d.aJq) {
            d.g(f.class, "etag find %s for task(%d)", o, Integer.valueOf(i2));
        }
        return o;
    }

    public static String a(com.kwai.filedownloader.kwai.b bVar, String str) {
        String fC = fC(bVar.o("Content-Disposition"));
        if (TextUtils.isEmpty(fC)) {
            fC = fA(str);
        }
        return fC.replaceAll("\\/", "_");
    }

    public static String a(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (!z) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return ap(str, str2);
    }

    private static boolean a(int i2, com.kwai.filedownloader.c.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.aJq) {
                d.g(f.class, "can't continue %d model == null", Integer.valueOf(i2));
            }
            return false;
        }
        if (cVar.HT() != null) {
            return a(i2, cVar, cVar.HT(), null);
        }
        if (d.aJq) {
            d.g(f.class, "can't continue %d temp path == null", Integer.valueOf(i2));
        }
        return false;
    }

    public static boolean a(int i2, com.kwai.filedownloader.c.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (!d.aJq) {
                return false;
            }
            d.g(f.class, "can't continue %d path = null", Integer.valueOf(i2));
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (!exists || isDirectory) {
            if (!d.aJq) {
                return false;
            }
            d.g(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i2), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
            return false;
        }
        long length = file.length();
        long IB = cVar.IB();
        if (cVar.ID() <= 1 && IB == 0) {
            if (!d.aJq) {
                return false;
            }
            d.g(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i2));
            return false;
        }
        long total = cVar.getTotal();
        if (length < IB || (total != -1 && (length > total || IB >= total))) {
            if (!d.aJq) {
                return false;
            }
            d.g(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i2), Long.valueOf(length), Long.valueOf(IB), Long.valueOf(total));
            return false;
        }
        if (bool == null || bool.booleanValue() || total != length) {
            return true;
        }
        if (!d.aJq) {
            return false;
        }
        d.g(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i2));
        return false;
    }

    private static String ap(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return j("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static int aq(String str, String str2) {
        return com.kwai.filedownloader.download.b.HF().HG().k(str, str2, false);
    }

    public static void ar(long j2) {
        if (!du(c.IZ())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        aJA = j2;
    }

    public static void ar(String str, String str2) {
        fI(str2);
        fJ(str);
    }

    public static long b(int i2, com.kwai.filedownloader.kwai.b bVar) {
        long fG = fG(bVar.o("Content-Length"));
        String o = bVar.o("Transfer-Encoding");
        if (fG >= 0) {
            return fG;
        }
        if (!(o != null && o.equals("chunked"))) {
            if (!e.Jb().aJt) {
                throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            }
            if (d.aJq) {
                d.g(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i2));
            }
        }
        return -1L;
    }

    public static boolean b(int i2, com.kwai.filedownloader.c.c cVar) {
        return a(i2, cVar, (Boolean) null);
    }

    public static void dk(int i2) {
        if (!du(c.IZ())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        aJz = i2;
    }

    public static boolean du(Context context) {
        boolean endsWith;
        Boolean bool = aJC;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.Jb().aJu) {
            endsWith = true;
        } else {
            if (((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
                d.h(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            endsWith = ap.getProcessName(context).endsWith(":filedownloader");
        }
        Boolean valueOf = Boolean.valueOf(endsWith);
        aJC = valueOf;
        return valueOf.booleanValue();
    }

    public static void dv(Context context) {
        File dw = dw(context);
        try {
            dw.getParentFile().mkdirs();
            dw.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private static File dw(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String eC(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(bu.f5659a).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }

    private static String fA(String str) {
        return eC(str);
    }

    public static String fB(String str) {
        return j("%s.temp", str);
    }

    public static String fC(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = aJE.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static String fD(String str) {
        int length = str.length();
        int i2 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        int i3 = (lastIndexOf != -1 || i2 <= 0) ? lastIndexOf : 2;
        if (i3 == -1) {
            return null;
        }
        char charAt = str.charAt(length - 1);
        char c2 = File.separatorChar;
        if (charAt == c2) {
            return null;
        }
        return (str.indexOf(c2) == i3 && str.charAt(i2) == File.separatorChar) ? str.substring(0, i3 + 1) : str.substring(0, i3);
    }

    public static String fE(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean fF(String str) {
        return c.IZ().checkCallingOrSelfPermission(str) == 0;
    }

    private static long fG(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static com.kwai.filedownloader.d.a fH(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            file.delete();
            if (!file.createNewFile()) {
                throw new RuntimeException(j("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            }
        }
        if (file.exists() || file.createNewFile()) {
            return com.kwai.filedownloader.download.b.HF().ab(file);
        }
        throw new IOException(j("create new file error  %s", file.getAbsolutePath()));
    }

    private static void fI(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void fJ(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String fz(String str) {
        return ap(Jf(), fA(str));
    }

    public static boolean h(long j2, long j3) {
        return j2 > ((long) Jd()) && j3 > Je();
    }

    public static String j(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static int k(String str, String str2, boolean z) {
        return com.kwai.filedownloader.download.b.HF().HG().k(str, str2, z);
    }
}
