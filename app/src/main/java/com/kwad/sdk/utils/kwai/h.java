package com.kwad.sdk.utils.kwai;

import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;

/* loaded from: classes2.dex */
final class h {

    static class a {
        static final SecureRandom aCI = new SecureRandom();
        static final char[] aCJ = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    static String Fy() {
        byte[] bArr = new byte[16];
        a.aCI.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i2 = 0; i2 < 16; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 << 1;
            char[] cArr2 = a.aCJ;
            cArr[i3] = cArr2[(b2 >> 4) & 15];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    static int Fz() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), new Object[0])).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    static boolean Y(File file) {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
        }
        return false;
    }

    static byte[] Z(File file) {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) != 0) {
            throw new IllegalArgumentException("file too large, path:" + file.getPath());
        }
        int i2 = (int) length;
        byte[] bArr = new byte[i2];
        a(file, bArr, i2);
        return bArr;
    }

    static void a(File file, byte[] bArr, int i2) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i3 = 0;
        while (i3 < i2) {
            try {
                int read = randomAccessFile.read(bArr, i3, i2 - i3);
                if (read < 0) {
                    break;
                } else {
                    i3 += read;
                }
            } finally {
                closeQuietly(randomAccessFile);
            }
        }
    }

    static boolean a(File file, byte[] bArr) {
        File file2;
        try {
            file2 = new File(file.getParent(), file.getName() + ".tmp");
        } catch (Exception unused) {
        }
        if (!Y(file2)) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.setLength(bArr.length);
            randomAccessFile.write(bArr);
            closeQuietly(randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Throwable th) {
            closeQuietly(randomAccessFile);
            throw th;
        }
    }

    private static void aa(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                aa(file2);
            }
        }
        file.delete();
    }

    static int binarySearch(int[] iArr, int i2) {
        int length = (iArr.length >> 1) - 1;
        int i3 = 0;
        while (i3 <= length) {
            int i4 = (i3 + length) >>> 1;
            int i5 = iArr[i4 << 1];
            if (i5 < i2) {
                i3 = i4 + 1;
            } else {
                if (i5 <= i2) {
                    return i4;
                }
                length = i4 - 1;
            }
        }
        return length;
    }

    static void c(File file) {
        try {
            if (file.exists()) {
                aa(file);
            }
        } catch (Exception unused) {
        }
    }

    static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
