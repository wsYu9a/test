package com.kwad.framework.filedownloader.f;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.sdk.utils.av;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class f {
    private static int alC = 65536;
    private static long alD = 2000;
    private static String alE;
    private static Boolean alF;
    private static Boolean alG;
    private static final Pattern alH = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    public static int A(String str, String str2) {
        return com.kwad.framework.filedownloader.download.b.ww().wx().g(str, str2, false);
    }

    public static void B(String str, String str2) {
        bF(str2);
        bG(str);
    }

    public static void W(long j10) {
        if (!aC(c.xT())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        alD = j10;
    }

    public static String a(String str, boolean z10, String str2) {
        if (str == null) {
            return null;
        }
        if (!z10) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return z(str, str2);
    }

    public static boolean aC(Context context) {
        boolean endsWith;
        Boolean bool = alF;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (e.xV().alx) {
            endsWith = true;
        } else {
            if (((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
                d.d(f.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
            endsWith = av.getProcessName(context).endsWith(":filedownloader");
        }
        alF = Boolean.valueOf(endsWith);
        return endsWith;
    }

    public static void aD(Context context) {
        File aE = aE(context);
        try {
            aE.getParentFile().mkdirs();
            aE.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    private static File aE(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String b(String str, Object... objArr) {
        try {
            return String.format(Locale.ENGLISH, str, objArr);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String bA(String str) {
        int length = str.length();
        char c10 = File.separatorChar;
        int i10 = (c10 == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(c10);
        int i11 = (lastIndexOf != -1 || i10 <= 0) ? lastIndexOf : 2;
        if (i11 == -1 || str.charAt(length - 1) == c10) {
            return null;
        }
        return (str.indexOf(c10) == i11 && str.charAt(i10) == c10) ? str.substring(0, i11 + 1) : str.substring(0, i11);
    }

    public static String bB(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean bC(String str) {
        return c.xT().checkCallingOrSelfPermission(str) == 0;
    }

    private static long bD(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static com.kwad.framework.filedownloader.e.a bE(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            file.delete();
            if (!file.createNewFile()) {
                throw new RuntimeException(b("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            }
        }
        if (file.exists() || file.createNewFile()) {
            return com.kwad.framework.filedownloader.download.b.ww().b(file);
        }
        throw new IOException(b("create new file error  %s", file.getAbsolutePath()));
    }

    private static void bF(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bG(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void bN(int i10) {
        if (!aC(c.xT())) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        alC = i10;
    }

    public static String bv(String str) {
        return z(xZ(), bw(str));
    }

    private static String bw(String str) {
        return by(str);
    }

    public static String bx(String str) {
        return b("%s.temp", str);
    }

    public static String by(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b10 : digest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException("Huh, MD5 should be supported?", e11);
        }
    }

    public static String bz(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = alH.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        } catch (IllegalStateException unused) {
        }
        return null;
    }

    public static int g(String str, String str2, boolean z10) {
        return com.kwad.framework.filedownloader.download.b.ww().wx().g(str, str2, z10);
    }

    public static boolean i(long j10, long j11) {
        return j10 > ((long) xX()) && j11 > xY();
    }

    private static int xX() {
        return alC;
    }

    private static long xY() {
        return alD;
    }

    private static String xZ() {
        return !TextUtils.isEmpty(alE) ? alE : c.xT().getExternalCacheDir() == null ? Environment.getDownloadCacheDirectory().getAbsolutePath() : c.xT().getExternalCacheDir().getAbsolutePath();
    }

    public static boolean ya() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.xT().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static String yb() {
        return b("FileDownloader/%s", BuildConfig.VERSION_NAME);
    }

    private static String z(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        }
        if (str != null) {
            return b("%s%s%s", str, File.separator, str2);
        }
        throw new IllegalStateException("can't generate real path, the directory is null");
    }

    public static String a(int i10, com.kwad.framework.filedownloader.a.b bVar) {
        if (bVar == null) {
            throw new RuntimeException("connection is null when findEtag");
        }
        String bh2 = bVar.bh("Etag");
        if (d.alt) {
            d.c(f.class, "etag find %s for task(%d)", bh2, Integer.valueOf(i10));
        }
        return bh2;
    }

    public static long b(int i10, com.kwad.framework.filedownloader.a.b bVar) {
        long bD = bD(bVar.bh("Content-Length"));
        String bh2 = bVar.bh("Transfer-Encoding");
        if (bD < 0) {
            bD = -1;
            if (bh2 == null || !bh2.equals("chunked")) {
                if (!e.xV().alw) {
                    throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
                }
                if (d.alt) {
                    d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i10));
                }
            }
        }
        return bD;
    }

    public static String a(com.kwad.framework.filedownloader.a.b bVar, String str) {
        String bz = bz(bVar.bh("Content-Disposition"));
        if (TextUtils.isEmpty(bz)) {
            bz = bw(str);
        }
        return bz.replaceAll("\\/", hf.e.f26694a);
    }

    private static boolean a(int i10, com.kwad.framework.filedownloader.d.c cVar, Boolean bool) {
        if (cVar == null) {
            if (d.alt) {
                d.c(f.class, "can't continue %d model == null", Integer.valueOf(i10));
            }
            return false;
        }
        if (cVar.wL() == null) {
            if (d.alt) {
                d.c(f.class, "can't continue %d temp path == null", Integer.valueOf(i10));
            }
            return false;
        }
        return a(i10, cVar, cVar.wL(), null);
    }

    public static boolean b(int i10, com.kwad.framework.filedownloader.d.c cVar) {
        return a(i10, cVar, (Boolean) null);
    }

    public static boolean a(int i10, com.kwad.framework.filedownloader.d.c cVar, String str, Boolean bool) {
        if (str == null) {
            if (!d.alt) {
                return false;
            }
            d.c(f.class, "can't continue %d path = null", Integer.valueOf(i10));
            return false;
        }
        File file = new File(str);
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (exists && !isDirectory) {
            long length = file.length();
            long xt = cVar.xt();
            if (cVar.xw() <= 1 && xt == 0) {
                if (!d.alt) {
                    return false;
                }
                d.c(f.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i10));
                return false;
            }
            long total = cVar.getTotal();
            if (length >= xt && (total == -1 || (length <= total && xt < total))) {
                if (bool == null || bool.booleanValue() || total != length) {
                    return true;
                }
                if (!d.alt) {
                    return false;
                }
                d.c(f.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i10));
                return false;
            }
            if (!d.alt) {
                return false;
            }
            d.c(f.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i10), Long.valueOf(length), Long.valueOf(xt), Long.valueOf(total));
            return false;
        }
        if (!d.alt) {
            return false;
        }
        d.c(f.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i10), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
        return false;
    }
}
