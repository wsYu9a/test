package com.bytedance.hume.readapk.a;

import com.kuaishou.weapon.p0.t;
import java.io.DataInput;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final byte[] f5962a = {108, 116, 108, 111, 118, 101, 122, 104};

    public static String a(File file) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        long length;
        RandomAccessFile randomAccessFile2 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        r0 = null;
        String str = null;
        try {
            try {
                try {
                    randomAccessFile = new RandomAccessFile(file, t.k);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (UnsupportedEncodingException e3) {
                    e = e3;
                    randomAccessFile = null;
                } catch (IOException e4) {
                    e = e4;
                    randomAccessFile = null;
                } catch (Exception e5) {
                    e = e5;
                    randomAccessFile = null;
                } catch (Throwable th) {
                    th = th;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    long length2 = randomAccessFile.length();
                    bArr = new byte[f5962a.length];
                    length = length2 - r7.length;
                    randomAccessFile.seek(length);
                    randomAccessFile.readFully(bArr);
                } catch (FileNotFoundException e7) {
                    e = e7;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                } catch (UnsupportedEncodingException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                } catch (IOException e9) {
                    e = e9;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                } catch (Exception e10) {
                    e = e10;
                    e.printStackTrace();
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    return str;
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            if (!a(bArr)) {
                try {
                    randomAccessFile.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return "";
            }
            long j2 = length - 2;
            randomAccessFile.seek(j2);
            int a2 = a(randomAccessFile);
            if (a2 <= 0) {
                try {
                    randomAccessFile.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
                return "";
            }
            randomAccessFile.seek(j2 - a2);
            byte[] bArr2 = new byte[a2];
            randomAccessFile.readFully(bArr2);
            String str2 = new String(bArr2, "UTF-8");
            try {
                randomAccessFile.close();
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            str = str2;
            return str;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
        }
    }

    private static short a(DataInput dataInput) {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length != f5962a.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f5962a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }
}
