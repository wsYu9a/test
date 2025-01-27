package com.tencent.bugly.beta.utils;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static long f22167a = -1;

    /* renamed from: b */
    public static long f22168b = 0;

    /* renamed from: c */
    public static long f22169c = 1;

    /* renamed from: d */
    private byte[] f22170d;

    /* renamed from: e */
    private byte[] f22171e;

    /* renamed from: f */
    private byte[] f22172f;

    /* renamed from: g */
    private long f22173g;

    /* renamed from: h */
    private String f22174h;

    /* renamed from: i */
    private BufferedInputStream f22175i;

    /* renamed from: j */
    private long f22176j;

    /* renamed from: k */
    private long f22177k;

    public a(String str) throws Exception {
        this.f22170d = new byte[2];
        this.f22171e = new byte[4];
        this.f22172f = new byte[8];
        this.f22173g = f22169c;
        this.f22175i = null;
        this.f22176j = 0L;
        this.f22177k = 0L;
        this.f22174h = str;
        this.f22175i = new BufferedInputStream(new FileInputStream(this.f22174h));
        this.f22176j = 0L;
        this.f22177k = 0L;
    }

    public synchronized void a(long j10) {
        this.f22173g = j10;
    }

    public synchronized boolean b(long j10) {
        if (this.f22175i == null) {
            Log.e("BinaryFileReader", "Please open file first！");
            return false;
        }
        if (j10 == 0) {
            return true;
        }
        long j11 = j10;
        while (j11 > 0) {
            try {
                j11 -= this.f22175i.skip(j11);
            } catch (IOException unused) {
                Log.e("BinaryFileReader", "Failed to skip file pointer！");
                return false;
            }
        }
        this.f22176j += j10;
        return true;
    }

    public synchronized int c() throws IOException {
        BufferedInputStream bufferedInputStream = this.f22175i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0;
        }
        bufferedInputStream.read(this.f22171e);
        int a10 = a(this.f22171e, this.f22173g);
        this.f22176j += 4;
        this.f22177k += 4;
        return a10;
    }

    public synchronized long d() throws IOException {
        BufferedInputStream bufferedInputStream = this.f22175i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return 0L;
        }
        bufferedInputStream.read(this.f22172f);
        long b10 = b(this.f22172f, this.f22173g);
        this.f22176j += 8;
        this.f22177k += 8;
        return b10;
    }

    public synchronized short e() throws IOException {
        BufferedInputStream bufferedInputStream = this.f22175i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return (short) 0;
        }
        bufferedInputStream.read(this.f22170d);
        short c10 = c(this.f22170d, this.f22173g);
        this.f22176j += 2;
        this.f22177k += 2;
        return c10;
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
        return e() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
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
            try {
                BufferedInputStream bufferedInputStream = this.f22175i;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                this.f22175i = null;
                this.f22174h = null;
                this.f22176j = 0L;
                this.f22177k = 0L;
            } catch (IOException e10) {
                Log.e("BinaryFileReader", e10.getMessage());
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return true;
    }

    public synchronized byte b() throws IOException {
        BufferedInputStream bufferedInputStream = this.f22175i;
        if (bufferedInputStream == null) {
            Log.e("BinaryFileReader", "Failed to skip file pointer！");
            return (byte) 0;
        }
        byte read = (byte) bufferedInputStream.read();
        this.f22176j++;
        this.f22177k++;
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
        long j10 = 0;
        for (byte b10 : bArr) {
            j10 = (j10 << 8) | (b10 & 255);
        }
        return j10;
    }

    private static long e(byte[] bArr) {
        if (bArr == null || bArr.length > 8) {
            return -1L;
        }
        long j10 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            j10 = (j10 << 8) | (bArr[length] & 255);
        }
        return j10;
    }

    public static short c(byte[] bArr, long j10) {
        if (j10 == f22169c) {
            return g(bArr);
        }
        return f(bArr);
    }

    public synchronized boolean a(byte[] bArr) {
        try {
            this.f22175i.read(bArr);
            this.f22176j += bArr.length;
            this.f22177k += bArr.length;
        } catch (IOException e10) {
            Log.e("BinaryFileReader", e10.getMessage());
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

    public a(String str, long j10) throws Exception {
        this.f22170d = new byte[2];
        this.f22171e = new byte[4];
        this.f22172f = new byte[8];
        this.f22175i = null;
        this.f22176j = 0L;
        this.f22177k = 0L;
        this.f22174h = str;
        this.f22173g = j10;
        this.f22175i = new BufferedInputStream(new FileInputStream(this.f22174h));
        this.f22176j = 0L;
        this.f22177k = 0L;
    }

    public static int a(byte[] bArr, long j10) {
        if (j10 == f22169c) {
            return c(bArr);
        }
        return b(bArr);
    }

    public static long b(byte[] bArr, long j10) {
        if (j10 == f22169c) {
            return e(bArr);
        }
        return d(bArr);
    }
}
