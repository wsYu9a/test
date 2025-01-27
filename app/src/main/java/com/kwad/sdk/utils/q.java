package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public final class q {
    public static final BigInteger azA;
    public static final BigInteger azB;
    public static final BigInteger azC;
    public static final char azD;
    public static final BigInteger azE;
    public static final BigInteger azF;
    public static final File[] azG;
    public static final String azH;
    private static final char azI;
    public static final BigInteger azx;
    public static final BigInteger azy;
    public static final BigInteger azz;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        azx = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        azy = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        azz = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        azA = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        azB = multiply4;
        azC = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
        azE = multiply5;
        azF = valueOf.multiply(multiply5);
        azG = new File[0];
        azH = Character.toString('.');
        azI = File.separatorChar;
        azD = Dc() ? '/' : '\\';
    }

    private static boolean Dc() {
        return azI == '\\';
    }

    public static String G(@NonNull Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }

    public static boolean G(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean H(File file) {
        return file.exists();
    }

    private static FileInputStream I(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        }
        if (file.canRead()) {
            return new FileInputStream(file);
        }
        throw new IOException("File '" + file + "' cannot be read");
    }

    private static FileOutputStream J(File file) {
        return a(file, false);
    }

    public static void K(File file) {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IOException("Could not find parent directory");
        }
        if (parentFile.mkdirs() || parentFile.isDirectory()) {
            file.createNewFile();
            return;
        }
        throw new IOException("Directory '" + parentFile + "' could not be created");
    }

    private static void L(File file) {
        if (file.exists()) {
            if (!U(file)) {
                O(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean M(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                O(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean N(File file) {
        return M(file);
    }

    public static void O(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e2 = null;
        for (File file2 : listFiles) {
            try {
                R(file2);
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 != null) {
            throw e2;
        }
    }

    public static byte[] P(File file) {
        return Q(file).getBytes();
    }

    public static String Q(File file) {
        return a(file, Charset.defaultCharset());
    }

    private static void R(File file) {
        if (file.isDirectory()) {
            L(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (exists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static void S(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else {
            if (file.isDirectory()) {
                return;
            }
            if (!M(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static void T(File file) {
        M(file);
        n(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    private static boolean U(File file) {
        ao.checkNotNull(file);
        if (Dc()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean V(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        c(file, file2);
        return M(file2);
    }

    public static FileOutputStream a(File file, boolean z) {
        K(file);
        return new FileOutputStream(file, z);
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = I(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            String a2 = com.kwad.sdk.crash.utils.h.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return a2;
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void a(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Asset path is empty.");
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            b(inputStream, file);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z) {
        ArrayList arrayList;
        File[] listFiles;
        ao.f(file, "Source");
        ao.f(file2, HttpHeaders.DESTINATION);
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(listFiles.length);
            for (File file3 : listFiles) {
                arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
            }
        }
        a(file, file2, null, z, arrayList);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : listFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    a(file3, file4, fileFilter, z, list);
                } else {
                    c(file3, file4, z);
                }
            }
        }
        if (z) {
            file2.setLastModified(file.lastModified());
        }
    }

    public static void a(File file, String str, Charset charset, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.a(str, fileOutputStream, charset);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private static void b(File file, File file2, boolean z) {
        ao.f(file, "Source");
        ao.f(file2, HttpHeaders.DESTINATION);
        if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
        }
        if (!file2.exists() || file2.canWrite()) {
            c(file, file2, true);
            return;
        }
        throw new IOException("Destination '" + file2 + "' exists but is read-only");
    }

    private static void b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = J(file);
            try {
                com.kwad.sdk.crash.utils.h.g(inputStream, fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th) {
                th = th;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable, java.io.FileOutputStream] */
    private static void c(File file, File file2, boolean z) {
        FileInputStream fileInputStream;
        ?? r4;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            r4 = 0;
        }
        try {
            r4 = new FileOutputStream(file2);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (Throwable th3) {
            th = th3;
            r4 = 0;
            fileChannel = r4;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
        try {
            fileChannel2 = r4.getChannel();
            long size = fileChannel.size();
            long j2 = 0;
            while (j2 < size) {
                long j3 = size - j2;
                j2 += fileChannel2.transferFrom(fileChannel, j2, j3 > 31457280 ? 31457280L : j3);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            if (file.length() == file2.length()) {
                if (z) {
                    file2.setLastModified(file.lastModified());
                }
            } else {
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            }
        } catch (Throwable th4) {
            th = th4;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    private static boolean c(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            d(file, file2);
            try {
                file.delete();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
            return true;
        } catch (Exception e3) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
            return false;
        }
    }

    public static void d(File file, File file2) {
        b(file, file2, true);
    }

    private static void d(File file, File file2, boolean z) {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean delete(String str) {
        return M(new File(str));
    }

    public static void deleteContents(@NonNull File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                file2.delete();
            }
        }
    }

    public static void e(File file, File file2) {
        d(file, file2, true);
    }

    public static BufferedInputStream eu(String str) {
        FileInputStream fileInputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        return new BufferedInputStream(fileInputStream);
    }

    public static boolean ev(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean ew(String str) {
        return !TextUtils.isEmpty(str) && G(new File(str));
    }

    private static int ex(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int ey(String str) {
        int lastIndexOf;
        if (str != null && ex(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int ey = ey(str);
        return ey == -1 ? "" : str.substring(ey + 1);
    }

    private static void n(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(J(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }
}
