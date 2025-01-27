package com.vivo.mobilead.util;

import android.text.TextUtils;
import com.vivo.google.android.exoplayer3.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class o0 {
    private o0() {
    }

    private static File a() {
        try {
            String[] b2 = b();
            if (b2 == null) {
                return null;
            }
            for (String str : b2) {
                if (!TextUtils.isEmpty(str)) {
                    File file = new File(str.trim(), "libvsecbox.so");
                    if (file.exists()) {
                        return file;
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String[] b() {
        String obj;
        int indexOf;
        ClassLoader classLoader = o0.class.getClassLoader();
        if (classLoader == null || (indexOf = (obj = classLoader.toString()).indexOf("nativeLibraryDirectories")) == -1) {
            return null;
        }
        return obj.substring(indexOf).replace("nativeLibraryDirectories=[", "").replaceAll("]", "").split(",");
    }

    public static String c() {
        try {
            File a2 = a();
            return a2 != null ? a(a2) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long d() {
        try {
            File a2 = a();
            if (a2 != null) {
                return a2.length();
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static String a(File file) {
        if (file != null && file.isFile()) {
            FileInputStream fileInputStream = null;
            byte[] bArr = new byte[CacheDataSink.DEFAULT_BUFFER_SIZE];
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused4) {
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream2.close();
                return a(messageDigest.digest());
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString().toUpperCase();
    }
}
