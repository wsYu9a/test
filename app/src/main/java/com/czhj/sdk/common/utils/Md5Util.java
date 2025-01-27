package com.czhj.sdk.common.utils;

import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public final class Md5Util {

    /* renamed from: a */
    public static final String f8648a = "Md5Util";

    /* renamed from: b */
    public static final int f8649b = 1024;

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static String fileMd5(File file) {
        MessageDigest messageDigest;
        FileInputStream fileInputStream;
        if (file == null || !file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[2048];
        try {
            messageDigest = MessageDigest.getInstance("md5");
            try {
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            SigmobLog.e(th.getMessage());
                            if (messageDigest != null) {
                                try {
                                    messageDigest.clone();
                                } catch (Throwable th3) {
                                    SigmobLog.e(th3.getMessage());
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable th4) {
                                    SigmobLog.e(th4.getMessage());
                                }
                            }
                            return null;
                        } finally {
                        }
                    }
                }
                if (messageDigest != null) {
                    try {
                        messageDigest.clone();
                    } catch (Throwable th5) {
                        SigmobLog.e(th5.getMessage());
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th6) {
                    SigmobLog.e(th6.getMessage());
                }
                return a(messageDigest.digest());
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
            }
        } catch (Throwable th8) {
            th = th8;
            messageDigest = null;
            fileInputStream = null;
        }
    }

    public static String md5(String str) {
        if (str == null) {
            return null;
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i10 = 0;
            for (byte b10 : digest) {
                int i11 = i10 + 1;
                cArr2[i10] = cArr[(b10 >>> 4) & 15];
                i10 += 2;
                cArr2[i11] = cArr[b10 & 15];
            }
            return new String(cArr2);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            return null;
        }
    }

    public static String fileMd5(String str) {
        FileInputStream fileInputStream;
        DigestInputStream digestInputStream;
        if (str == null || !new File(str).exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(str);
            try {
                digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("md5"));
            } catch (Throwable th2) {
                th = th2;
                digestInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            digestInputStream = null;
        }
        try {
            while (digestInputStream.read(new byte[1024]) > 0) {
            }
            String a10 = a(digestInputStream.getMessageDigest().digest());
            try {
                fileInputStream.close();
            } catch (Throwable th4) {
                SigmobLog.e(th4.getMessage());
            }
            try {
                digestInputStream.close();
            } catch (Throwable th5) {
                SigmobLog.e(th5.getMessage());
            }
            return a10;
        } catch (Throwable th6) {
            th = th6;
            try {
                SigmobLog.e(th.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th7) {
                        SigmobLog.e(th7.getMessage());
                    }
                }
                if (digestInputStream != null) {
                    try {
                        digestInputStream.close();
                    } catch (Throwable th8) {
                        SigmobLog.e(th8.getMessage());
                    }
                }
                return null;
            } finally {
            }
        }
    }
}
