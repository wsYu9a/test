package com.martian.libsupport;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static final int f10616a = 8192;

    private m() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static boolean a(final File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    private static boolean b(final File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!a(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static List<String> c(final File zipFile) throws IOException {
        if (zipFile == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile2 = new ZipFile(zipFile);
        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
        while (entries.hasMoreElements()) {
            arrayList.add(entries.nextElement().getComment());
        }
        zipFile2.close();
        return arrayList;
    }

    public static List<String> d(final String zipFilePath) throws IOException {
        return c(e(zipFilePath));
    }

    private static File e(final String filePath) {
        if (h(filePath)) {
            return null;
        }
        return new File(filePath);
    }

    public static List<String> f(final File zipFile) throws IOException {
        if (zipFile == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile2 = new ZipFile(zipFile);
        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
        while (entries.hasMoreElements()) {
            arrayList.add(entries.nextElement().getName().replace("\\", "/"));
        }
        zipFile2.close();
        return arrayList;
    }

    public static List<String> g(final String zipFilePath) throws IOException {
        return f(e(zipFilePath));
    }

    private static boolean h(final String s) {
        if (s == null) {
            return true;
        }
        int length = s.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(s.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    private static boolean i(final File destDir, final List<File> files, final ZipFile zip, final ZipEntry entry, final String name) throws IOException {
        File file = new File(destDir, name);
        files.add(file);
        if (entry.isDirectory()) {
            return a(file);
        }
        if (!b(file)) {
            return false;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zip.getInputStream(entry));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        bufferedOutputStream.close();
                        bufferedInputStream.close();
                        return true;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable unused) {
                }
                throw th2;
            }
        }
    }

    public static List<File> j(final File zipFile, final File destDir) throws IOException {
        return l(zipFile, destDir, null);
    }

    public static List<File> k(final String zipFilePath, final String destDirPath) throws IOException {
        return m(zipFilePath, destDirPath, null);
    }

    public static List<File> l(final File zipFile, final File destDir, final String keyword) throws IOException {
        if (zipFile == null || destDir == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile2 = new ZipFile(zipFile);
        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
        try {
            if (h(keyword)) {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String replace = nextElement.getName().replace("\\", "/");
                    if (replace.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace + " is dangerous!");
                    } else if (!i(destDir, arrayList, zipFile2, nextElement, replace)) {
                        return arrayList;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement2 = entries.nextElement();
                    String replace2 = nextElement2.getName().replace("\\", "/");
                    if (replace2.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace2 + " is dangerous!");
                    } else if (replace2.contains(keyword) && !i(destDir, arrayList, zipFile2, nextElement2, replace2)) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        } finally {
            zipFile2.close();
        }
    }

    public static List<File> m(final String zipFilePath, final String destDirPath, final String keyword) throws IOException {
        return l(e(zipFilePath), e(destDirPath), keyword);
    }

    public static boolean n(final File srcFile, final File zipFile) throws IOException {
        return o(srcFile, zipFile, null);
    }

    public static boolean o(final File srcFile, final File zipFile, final String comment) throws IOException {
        if (srcFile == null || zipFile == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
        try {
            return p(srcFile, "", zipOutputStream, comment);
        } catch (Throwable th) {
            try {
                throw th;
            } finally {
                try {
                    zipOutputStream.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static boolean p(final File srcFile, String rootPath, final ZipOutputStream zos, final String comment) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(rootPath);
        sb.append(h(rootPath) ? "" : File.separator);
        sb.append(srcFile.getName());
        String sb2 = sb.toString();
        if (srcFile.isDirectory()) {
            File[] listFiles = srcFile.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (!p(file, sb2, zos, comment)) {
                        return false;
                    }
                }
                return true;
            }
            ZipEntry zipEntry = new ZipEntry(sb2 + '/');
            zipEntry.setComment(comment);
            zos.putNextEntry(zipEntry);
            zos.closeEntry();
            return true;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(srcFile));
        try {
            ZipEntry zipEntry2 = new ZipEntry(sb2);
            zipEntry2.setComment(comment);
            zos.putNextEntry(zipEntry2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    zos.closeEntry();
                    bufferedInputStream.close();
                    return true;
                }
                zos.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable unused) {
                }
                throw th2;
            }
        }
    }

    public static boolean q(final String srcFilePath, final String zipFilePath) throws IOException {
        return o(e(srcFilePath), e(zipFilePath), null);
    }

    public static boolean r(final String srcFilePath, final String zipFilePath, final String comment) throws IOException {
        return o(e(srcFilePath), e(zipFilePath), comment);
    }

    public static boolean s(final Collection<File> srcFiles, final File zipFile) throws IOException {
        return t(srcFiles, zipFile, null);
    }

    public static boolean t(final Collection<File> srcFiles, final File zipFile, final String comment) throws IOException {
        ZipOutputStream zipOutputStream;
        if (srcFiles == null || zipFile == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile));
        } catch (Throwable th) {
            th = th;
        }
        try {
            Iterator<File> it = srcFiles.iterator();
            while (it.hasNext()) {
                if (!p(it.next(), "", zipOutputStream, comment)) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    return false;
                }
            }
            zipOutputStream.finish();
            zipOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.finish();
                zipOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean u(final Collection<String> srcFiles, final String zipFilePath) throws IOException {
        return v(srcFiles, zipFilePath, null);
    }

    public static boolean v(final Collection<String> srcFilePaths, final String zipFilePath, final String comment) throws IOException {
        if (srcFilePaths == null || zipFilePath == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(zipFilePath));
            try {
                Iterator<String> it = srcFilePaths.iterator();
                while (it.hasNext()) {
                    File e2 = e(it.next());
                    if (e2 != null && !p(e2, "", zipOutputStream2, comment)) {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                        return false;
                    }
                }
                zipOutputStream2.finish();
                zipOutputStream2.close();
                return true;
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
