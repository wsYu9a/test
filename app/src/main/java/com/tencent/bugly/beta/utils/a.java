package com.tencent.bugly.beta.utils;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static long f24658a = -1;

    /* renamed from: b */
    public static long f24659b = 0;

    /* renamed from: c */
    public static long f24660c = 1;

    /* renamed from: d */
    private byte[] f24661d;

    /* renamed from: e */
    private byte[] f24662e;

    /* renamed from: f */
    private byte[] f24663f;

    /* renamed from: g */
    private long f24664g;

    /* renamed from: h */
    private String f24665h;

    /* renamed from: i */
    private BufferedInputStream f24666i;

    /* renamed from: j */
    private long f24667j;
    private long k;

    public a(String str) throws Exception {
        this.f24661d = new byte[2];
        this.f24662e = new byte[4];
        this.f24663f = new byte[8];
        this.f24664g = f24660c;
        this.f24665h = null;
        this.f24666i = null;
        this.f24667j = 0L;
        this.k = 0L;
        this.f24665h = str;
        this.f24666i = new BufferedInputStream(new FileInputStream(this.f24665h));
        this.f24667j = 0L;
        this.k = 0L;
    }

    public synchronized void a(long j2) {
        this.f24664g = j2;
    }

    public synchronized boolean b(long j2) {
        if (this.f24666i == null) {
            Log.e("BinaryFileReader", "Please open file first！");
            return false;
        }
        if (j2 == 0) {
            return true;
        }
        long j3 = j2;
        while (j3 > 0) {
            try {
                j3 -= this.f24666i.skip(j3);
            } catch (IOException unused) {
                Log.e("BinaryFileReader", "Failed to skip file pointer！");
                return false;
            }
        }
        this.f24667j += j2;
        return true;
    }

    public synchronized int c() throws IOException {
        BufferedInputStream bufferedInputStream = this.f24666i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0;
        }
        bufferedInputStream.read(this.f24662e);
        int a2 = a(this.f24662e, this.f24664g);
        this.f24667j += 4;
        this.k += 4;
        return a2;
    }

    public synchronized long d() throws IOException {
        BufferedInputStream bufferedInputStream = this.f24666i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0L;
        }
        bufferedInputStream.read(this.f24663f);
        long b2 = b(this.f24663f, this.f24664g);
        this.f24667j += 8;
        this.k += 8;
        return b2;
    }

    public synchronized short e() throws IOException {
        BufferedInputStream bufferedInputStream = this.f24666i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return (short) 0;
        }
        bufferedInputStream.read(this.f24661d);
        short c2 = c(this.f24661d, this.f24664g);
        this.f24667j += 2;
        this.k += 2;
        return c2;
    }

    public synchronized long f() throws IOException {
        return b() & 255;
    }

    public synchronized long g() throws IOException {
        return c() & 4294967295L;
    }

    public synchronized long h() throws IOException {
        return d();
    }

    public synchronized long i() throws IOException {
        return e() & 65535;
    }

    private static short f(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) b(bArr);
    }

    private static short g(byte[] bArr) {
        if (bArr == null || bArr.length > 2) {
            return (short) -1;
        }
        return (short) c(bArr);
    }

    public synchronized boolean a() {
        try {
            BufferedInputStream bufferedInputStream = this.f24666i;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            this.f24666i = null;
            this.f24665h = null;
            this.f24667j = 0L;
            this.k = 0L;
        } catch (IOException e2) {
            Log.e("BinaryFileReader", e2.getMessage());
            return false;
        }
        return true;
    }

    public synchronized byte b() throws IOException {
        BufferedInputStream bufferedInputStream = this.f24666i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return (byte) 0;
        }
        byte read = (byte) bufferedInputStream.read();
        this.f24667j++;
        this.k++;
        return read;
    }

    private static int c(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) e(bArr);
    }

    private static long d(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 = (j2 << 8) | (b2 & 255);
        }
        return j2;
    }

    private static long e(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j2 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j2 = (j2 << 8) | (bArr[length] & 255);
        }
        return j2;
    }

    public static short c(byte[] bArr, long j2) {
        if (j2 == f24660c) {
            return g(bArr);
        }
        return f(bArr);
    }

    public synchronized boolean a(byte[] bArr) {
        try {
            this.f24666i.read(bArr);
            this.f24667j += bArr.length;
            this.k += bArr.length;
        } catch (IOException e2) {
            Log.e("BinaryFileReader", e2.getMessage());
            return false;
        }
        return true;
    }

    private static int b(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return -1;
        }
        return (int) d(bArr);
    }

    public static int a(byte[] bArr, long j2) {
        if (j2 == f24660c) {
            return c(bArr);
        }
        return b(bArr);
    }

    public static long b(byte[] bArr, long j2) {
        if (j2 == f24660c) {
            return e(bArr);
        }
        return d(bArr);
    }

    public a(String str, long j2) throws Exception {
        this.f24661d = new byte[2];
        this.f24662e = new byte[4];
        this.f24663f = new byte[8];
        this.f24664g = f24660c;
        this.f24665h = null;
        this.f24666i = null;
        this.f24667j = 0L;
        this.k = 0L;
        this.f24665h = str;
        this.f24664g = j2;
        this.f24666i = new BufferedInputStream(new FileInputStream(this.f24665h));
        this.f24667j = 0L;
        this.k = 0L;
    }
}
