package ba;

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
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1508a = 8192;

    public p() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean b(File file) {
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
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static List<String> c(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            arrayList.add(entries.nextElement().getComment());
        }
        zipFile.close();
        return arrayList;
    }

    public static List<String> d(String str) throws IOException {
        return c(e(str));
    }

    public static File e(String str) {
        if (h(str)) {
            return null;
        }
        return new File(str);
    }

    public static List<String> f(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            arrayList.add(entries.nextElement().getName().replace("\\", "/"));
        }
        zipFile.close();
        return arrayList;
    }

    public static List<String> g(String str) throws IOException {
        return f(e(str));
    }

    public static boolean h(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static boolean i(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return a(file2);
        }
        if (!b(file2)) {
            return false;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
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
        } catch (Throwable th2) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static List<File> j(File file, File file2) throws IOException {
        return l(file, file2, null);
    }

    public static List<File> k(String str, String str2) throws IOException {
        return m(str, str2, null);
    }

    public static List<File> l(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        try {
            if (h(str)) {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String replace = nextElement.getName().replace("\\", "/");
                    if (replace.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace + " is dangerous!");
                    } else if (!i(file2, arrayList, zipFile, nextElement, replace)) {
                        zipFile.close();
                        return arrayList;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement2 = entries.nextElement();
                    String replace2 = nextElement2.getName().replace("\\", "/");
                    if (replace2.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace2 + " is dangerous!");
                    } else if (replace2.contains(str) && !i(file2, arrayList, zipFile, nextElement2, replace2)) {
                        zipFile.close();
                        return arrayList;
                    }
                }
            }
            zipFile.close();
            return arrayList;
        } catch (Throwable th2) {
            zipFile.close();
            throw th2;
        }
    }

    public static List<File> m(String str, String str2, String str3) throws IOException {
        return l(e(str), e(str2), str3);
    }

    public static boolean n(File file, File file2) throws IOException {
        return o(file, file2, null);
    }

    public static boolean o(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        try {
            boolean p10 = p(file, "", zipOutputStream, str);
            zipOutputStream.close();
            return p10;
        } catch (Throwable th2) {
            try {
                zipOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static boolean p(File file, String str, ZipOutputStream zipOutputStream, String str2) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(h(str) ? "" : File.separator);
        sb2.append(file.getName());
        String sb3 = sb2.toString();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    if (!p(file2, sb3, zipOutputStream, str2)) {
                        return false;
                    }
                }
                return true;
            }
            ZipEntry zipEntry = new ZipEntry(sb3 + '/');
            zipEntry.setComment(str2);
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.closeEntry();
            return true;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            ZipEntry zipEntry2 = new ZipEntry(sb3);
            zipEntry2.setComment(str2);
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    zipOutputStream.closeEntry();
                    bufferedInputStream.close();
                    return true;
                }
                zipOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static boolean q(String str, String str2) throws IOException {
        return o(e(str), e(str2), null);
    }

    public static boolean r(String str, String str2, String str3) throws IOException {
        return o(e(str), e(str2), str3);
    }

    public static boolean s(Collection<File> collection, File file) throws IOException {
        return t(collection, file, null);
    }

    public static boolean t(Collection<File> collection, File file, String str) throws IOException {
        ZipOutputStream zipOutputStream;
        if (collection == null || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Iterator<File> it = collection.iterator();
            while (it.hasNext()) {
                if (!p(it.next(), "", zipOutputStream, str)) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    return false;
                }
            }
            zipOutputStream.finish();
            zipOutputStream.close();
            return true;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.finish();
                zipOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean u(Collection<String> collection, String str) throws IOException {
        return v(collection, str, null);
    }

    public static boolean v(Collection<String> collection, String str, String str2) throws IOException {
        if (collection == null || str == null) {
            return false;
        }
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                Iterator<String> it = collection.iterator();
                while (it.hasNext()) {
                    File e10 = e(it.next());
                    if (e10 != null && !p(e10, "", zipOutputStream2, str2)) {
                        zipOutputStream2.finish();
                        zipOutputStream2.close();
                        return false;
                    }
                }
                zipOutputStream2.finish();
                zipOutputStream2.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream = zipOutputStream2;
                if (zipOutputStream != null) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
