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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* loaded from: classes3.dex */
public final class u {
    public static final BigInteger aTc;
    public static final BigInteger aTd;
    public static final BigInteger aTe;
    public static final BigInteger aTf;
    public static final BigInteger aTg;
    public static final BigInteger aTh;
    public static final char aTi;
    public static final BigInteger aTj;
    public static final BigInteger aTk;
    public static final File[] aTl;
    public static final String aTm;
    private static final char aTn;

    static {
        BigInteger valueOf = BigInteger.valueOf(1024L);
        aTc = valueOf;
        BigInteger multiply = valueOf.multiply(valueOf);
        aTd = multiply;
        BigInteger multiply2 = valueOf.multiply(multiply);
        aTe = multiply2;
        BigInteger multiply3 = valueOf.multiply(multiply2);
        aTf = multiply3;
        BigInteger multiply4 = valueOf.multiply(multiply3);
        aTg = multiply4;
        aTh = valueOf.multiply(multiply4);
        BigInteger multiply5 = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(LockFreeTaskQueueCore.FROZEN_MASK));
        aTj = multiply5;
        aTk = valueOf.multiply(multiply5);
        aTl = new File[0];
        aTm = Character.toString('.');
        aTn = File.separatorChar;
        if (Ne()) {
            aTi = '/';
        } else {
            aTi = '\\';
        }
    }

    public static boolean M(File file) {
        return file != null && file.exists() && file.length() > 0;
    }

    public static boolean N(File file) {
        return file.exists();
    }

    private static boolean Ne() {
        return aTn == '\\';
    }

    private static FileInputStream O(File file) {
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

    private static FileOutputStream P(File file) {
        return a(file, false);
    }

    public static void Q(File file) {
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

    private static void R(File file) {
        if (file.exists()) {
            if (!aa(file)) {
                U(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + p1.b.f29697h);
        }
    }

    public static boolean S(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                U(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static boolean T(File file) {
        return S(file);
    }

    public static void U(File file) {
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
        IOException e10 = null;
        for (File file2 : listFiles) {
            try {
                X(file2);
            } catch (IOException e11) {
                e10 = e11;
            }
        }
        if (e10 != null) {
            throw e10;
        }
    }

    public static byte[] V(File file) {
        return W(file).getBytes();
    }

    public static String W(File file) {
        return a(file, Charset.defaultCharset());
    }

    private static void X(File file) {
        if (file.isDirectory()) {
            R(file);
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

    public static void Y(File file) {
        if (file == null) {
            throw new IOException("Dir is null.");
        }
        if (!file.exists()) {
            file.mkdirs();
        } else {
            if (file.isDirectory()) {
                return;
            }
            if (!S(file)) {
                throw new IOException("Fail to delete existing file, file = " + file.getAbsolutePath());
            }
            file.mkdir();
        }
        if (file.exists() && file.isDirectory()) {
            return;
        }
        throw new IOException("Fail to create dir, dir = " + file.getAbsolutePath());
    }

    public static void Z(File file) {
        S(file);
        s(file);
        if (!file.exists()) {
            throw new IOException("Create file fail");
        }
    }

    public static FileOutputStream a(File file, boolean z10) {
        Q(file);
        return new FileOutputStream(file, z10);
    }

    private static boolean aa(File file) {
        au.checkNotNull(file);
        if (Ne()) {
            return false;
        }
        if (file.getParent() != null) {
            file = new File(file.getParentFile().getCanonicalFile(), file.getName());
        }
        return !file.getCanonicalFile().equals(file.getAbsoluteFile());
    }

    public static boolean ab(File file) {
        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
        e(file, file2);
        return S(file2);
    }

    private static void b(File file, File file2, boolean z10) {
        au.g(file, "Source");
        au.g(file2, "Destination");
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.Closeable, java.io.FileOutputStream] */
    private static void c(File file, File file2, boolean z10) {
        FileInputStream fileInputStream;
        ?? r42;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            r42 = 0;
        }
        try {
            r42 = new FileOutputStream(file2);
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    fileChannel2 = r42.getChannel();
                    long size = fileChannel.size();
                    long j10 = 0;
                    while (j10 < size) {
                        long j11 = size - j10;
                        j10 += fileChannel2.transferFrom(fileChannel, j10, j11 > ba.g.f1469c ? 31457280L : j11);
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    if (file.length() == file2.length()) {
                        if (z10) {
                            file2.setLastModified(file.lastModified());
                        }
                    } else {
                        throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
                    com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
            }
        } catch (Throwable th5) {
            th = th5;
            r42 = 0;
            fileChannel = r42;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel2);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileChannel);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    private static void d(File file, File file2, boolean z10) {
        a(file, file2, (FileFilter) null, true);
    }

    public static boolean delete(String str) {
        return S(new File(str));
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

    private static boolean e(File file, File file2) {
        if (file.renameTo(file2)) {
            return true;
        }
        try {
            f(file, file2);
            try {
                file.delete();
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
            return true;
        } catch (Exception e11) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e11);
            return false;
        }
    }

    public static void f(File file, File file2) {
        b(file, file2, true);
    }

    public static void g(File file, File file2) {
        d(file, file2, true);
    }

    public static BufferedInputStream gE(String str) {
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

    public static boolean gF(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean gG(String str) {
        return !TextUtils.isEmpty(str) && M(new File(str));
    }

    private static int gH(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    private static int gI(String str) {
        int lastIndexOf;
        if (str != null && gH(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int gI = gI(str);
        return gI == -1 ? "" : str.substring(gI + 1);
    }

    private static void s(File file) {
        if (!file.exists()) {
            com.kwad.sdk.crash.utils.b.closeQuietly(P(file));
        }
        if (file.setLastModified(System.currentTimeMillis())) {
            return;
        }
        throw new IOException("Unable to set the last modification time for " + file);
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z10) {
        ArrayList arrayList;
        File[] listFiles;
        au.g(file, "Source");
        au.g(file2, "Destination");
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                    if (!file2.getCanonicalPath().startsWith(file.getCanonicalPath()) || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(listFiles.length);
                        for (File file3 : listFiles) {
                            arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                        }
                    }
                    a(file, file2, null, z10, arrayList);
                    return;
                }
                throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
            }
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static String O(@NonNull Context context, String str) {
        return "/data/data/" + context.getPackageName() + "/" + str + "/";
    }

    private static void b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = P(file);
            try {
                com.kwad.sdk.crash.utils.h.g(inputStream, fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static void a(File file, File file2, FileFilter fileFilter, boolean z10, List<String> list) {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            a(file3, file4, fileFilter, z10, list);
                        } else {
                            c(file3, file4, z10);
                        }
                    }
                }
                if (z10) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static void a(Context context, String str, File file) {
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                b(inputStream, file);
                return;
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
        throw new IllegalArgumentException("Asset path is empty.");
    }

    public static String a(File file, Charset charset) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = O(file);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            String a10 = com.kwad.sdk.crash.utils.h.a(fileInputStream, com.kwad.sdk.crash.utils.a.a(charset));
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            return a10;
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileInputStream);
            throw th;
        }
    }

    public static void a(File file, String str, Charset charset, boolean z10) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = a(file, false);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            com.kwad.sdk.crash.utils.h.a(str, fileOutputStream, charset);
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            throw th;
        }
    }
}
