package com.bytedance.pangle.util;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    static String f7856a = null;

    /* renamed from: b, reason: collision with root package name */
    static String f7857b = null;

    /* renamed from: c, reason: collision with root package name */
    static int f7858c = 8192;

    public static void a(String str) {
        a(new File(str));
    }

    public static String b(Context context) {
        File parentFile;
        if (f7857b == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            try {
                f7857b = parentFile.getCanonicalPath();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        return f7857b;
    }

    public static void a(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        file.delete();
    }

    public static void b(String str, String str2) {
        ZipInputStream zipInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("..")) {
                            if (nextEntry.isDirectory()) {
                                new File(str2 + File.separator + name).mkdirs();
                            } else {
                                File file = new File(str2 + File.separator + name);
                                if (file.exists()) {
                                    file.delete();
                                } else {
                                    file.getParentFile().mkdirs();
                                }
                                file.createNewFile();
                                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                                try {
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            bufferedOutputStream2.write(bArr, 0, read);
                                        }
                                    }
                                    bufferedOutputStream2.flush();
                                    bufferedOutputStream2.close();
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Exception e10) {
                                    e = e10;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    a(bufferedOutputStream);
                                    a(zipInputStream);
                                    throw e;
                                }
                            }
                        }
                    } else {
                        zipInputStream.close();
                        return;
                    }
                } catch (Exception e11) {
                    e = e11;
                }
            }
        } catch (Exception e12) {
            e = e12;
            zipInputStream = null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static String a(Context context) {
        File parentFile;
        if (f7856a == null && (parentFile = context.getCacheDir().getParentFile()) != null) {
            f7856a = parentFile.getAbsolutePath();
        }
        return f7856a;
    }

    public static void a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists()) {
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file2.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        return;
                    }
                    for (File file3 : listFiles) {
                        String str3 = file2 + File.separator + file3.getName();
                        if (file3.isDirectory()) {
                            a(file3.getAbsolutePath(), str3);
                        } else if (!new File(str3).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file3));
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str3));
                            byte[] bArr = new byte[f7858c];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                } else {
                                    bufferedOutputStream.write(bArr, 0, read);
                                }
                            }
                            bufferedOutputStream.close();
                            bufferedInputStream.close();
                        }
                    }
                    return;
                }
                throw new Exception("目标文件夹不是目录");
            }
            throw new Exception("源文件夹不是目录");
        }
        throw new Exception("文件夹不存在");
    }

    public static boolean b(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            a((Closeable) null);
            return false;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
        }
        try {
            byte[] bArr = new byte[6];
            if (fileInputStream.read(bArr) != 6) {
                a(fileInputStream);
                return false;
            }
            byte[] bArr2 = {80, 75, 3, 4};
            for (int i10 = 0; i10 < 4; i10++) {
                if (bArr2[i10] != bArr[i10]) {
                    a(fileInputStream);
                    return false;
                }
            }
            byte b10 = bArr[4];
            if (b10 == 0 && bArr[5] == 0) {
                a(fileInputStream);
                return false;
            }
            if (b10 == 20) {
                if (bArr[5] == 3) {
                    a(fileInputStream);
                    return true;
                }
            }
            a(fileInputStream);
            return false;
        } catch (Throwable unused2) {
            fileInputStream2 = fileInputStream;
            a(fileInputStream2);
            return false;
        }
    }

    public static void a(RandomAccessFile randomAccessFile, RandomAccessFile randomAccessFile2, long j10, long j11, String str) {
        byte[] bArr;
        long j12 = 0;
        if (j10 < 0 || j11 < 0 || j10 > j11) {
            throw new IOException("invalid offsets  ".concat(String.valueOf(str)));
        }
        if (j10 == j11) {
            return;
        }
        randomAccessFile.seek(j10);
        long j13 = j11 - j10;
        int i10 = f7858c;
        if (j13 < i10) {
            bArr = new byte[(int) j13];
        } else {
            bArr = new byte[i10];
        }
        while (true) {
            int read = randomAccessFile.read(bArr);
            if (read == -1) {
                return;
            }
            randomAccessFile2.write(bArr, 0, read);
            j12 += read;
            if (j12 == j13) {
                return;
            }
            if (bArr.length + j12 > j13) {
                bArr = new byte[(int) (j13 - j12)];
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        try {
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedOutputStream.flush();
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th2) {
            bufferedInputStream.close();
            bufferedOutputStream.close();
            throw th2;
        }
    }
}
