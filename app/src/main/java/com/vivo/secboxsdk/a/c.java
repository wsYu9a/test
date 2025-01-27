package com.vivo.secboxsdk.a;

import com.vivo.google.android.exoplayer3.upstream.cache.CacheDataSink;
import com.vivo.secboxsdk.jni.SecBoxNative;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

/* loaded from: classes4.dex */
public class c {
    public static String[] a() {
        String obj;
        int indexOf;
        ClassLoader classLoader = c.class.getClassLoader();
        if (classLoader == null || (indexOf = (obj = classLoader.toString()).indexOf("nativeLibraryDirectories")) == -1) {
            return null;
        }
        return obj.substring(indexOf).replace("nativeLibraryDirectories=[", "").replaceAll("]", "").split(",");
    }

    private static String b(byte[] bArr) {
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

    public static String a(File file) {
        if (!file.isFile()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        byte[] bArr = new byte[CacheDataSink.DEFAULT_BUFFER_SIZE];
        try {
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
                            } catch (IOException e2) {
                                b.a(SecBoxNative.TAG, "Error: " + e2.getMessage(), e2);
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        b.a(SecBoxNative.TAG, "Error: " + e.getMessage(), e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                b.a(SecBoxNative.TAG, "Error: " + e4.getMessage(), e4);
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                                b.a(SecBoxNative.TAG, "Error: " + e5.getMessage(), e5);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream2.close();
                return b(messageDigest.digest());
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }
}
