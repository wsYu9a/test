package com.aggmoread.sdk.z.d.a.a.e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class o {

    /* renamed from: e */
    private static Map<String, WeakReference<o>> f6116e = new HashMap();

    /* renamed from: a */
    private String f6117a;

    /* renamed from: b */
    private byte[] f6118b = new byte[0];

    /* renamed from: c */
    private int f6119c;

    /* renamed from: d */
    private long f6120d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File e10;
            synchronized (o.this.f6117a) {
                try {
                    e10 = o.this.e();
                } catch (FileNotFoundException e11) {
                    e = e11;
                    e.printStackTrace();
                    o.this.d();
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                    o.this.d();
                }
                if (e10.exists()) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    FileInputStream fileInputStream = new FileInputStream(e10);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    o.this.f6118b = byteArrayOutputStream.toByteArray();
                    o oVar = o.this;
                    oVar.f6119c = oVar.f6118b.length / 8;
                    fileInputStream.close();
                    o.this.d();
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File e10;
            synchronized (o.this.f6117a) {
                try {
                    e10 = o.this.e();
                } catch (FileNotFoundException | IOException e11) {
                    e11.printStackTrace();
                }
                if (e10.exists() || e10.createNewFile()) {
                    new FileOutputStream(o.this.e()).write(o.this.f6118b);
                }
            }
        }
    }

    public static final class c extends Enum<c> {

        /* renamed from: d */
        public static final c f6123d = new c("REQUEST_DAILY", 0, 86400000, 0);

        /* renamed from: e */
        public static final c f6124e = new c("REQUEST_HOURLY", 1, 3600000, 1);

        /* renamed from: f */
        public static final c f6125f = new c("EXPOSURE_DAILY", 2, 86400000, 2);

        /* renamed from: g */
        public static final c f6126g = new c("EXPOSURE_HOURLY", 3, 3600000, 3);

        /* renamed from: h */
        public static final c f6127h = new c("CLICK_DAILY", 4, 86400000, 4);

        /* renamed from: i */
        public static final c f6128i = new c("CLICK_HOURLY", 5, 3600000, 5);

        /* renamed from: b */
        public long f6129b;

        /* renamed from: c */
        public int f6130c;

        private c(String str, int i10, long j10, int i11) {
            super(str, i10);
            this.f6129b = j10;
            this.f6130c = i11;
        }
    }

    public o(String str, long j10) {
        new ArrayList();
        this.f6119c = 0;
        this.f6117a = str;
        this.f6120d = j10;
        b();
    }

    public void b() {
        n.b(new a());
    }

    public void c() {
        n.b(new b());
    }

    public int d() {
        synchronized (this) {
            try {
                if (this.f6118b.length == 0) {
                    return 0;
                }
                int i10 = 0;
                while (new DataInputStream(new ByteArrayInputStream(this.f6118b)).readLong() < System.currentTimeMillis() - this.f6120d) {
                    try {
                        this.f6119c--;
                        i10++;
                    } catch (IOException unused) {
                    }
                }
                if (i10 > 0) {
                    int i11 = i10 * 8;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr = this.f6118b;
                    byteArrayOutputStream.write(bArr, i11, bArr.length - i11);
                    this.f6118b = byteArrayOutputStream.toByteArray();
                }
                if (i10 > 0) {
                    c();
                }
                if (this.f6119c < 0) {
                    this.f6119c = 0;
                }
                return this.f6119c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public File e() {
        return new File(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getApplicationInfo().dataDir, com.aggmoread.sdk.z.d.a.a.e.c.l() + this.f6117a);
    }

    public String toString() {
        return String.format("{tsname= %s,tsc= %s,span= %s}", this.f6117a, Integer.valueOf(this.f6119c), Long.valueOf(this.f6120d));
    }

    public static o a(String str, c cVar) {
        String format = String.format("%s_%d", str, Integer.valueOf(cVar.f6130c));
        WeakReference<o> weakReference = f6116e.get(format);
        o oVar = weakReference != null ? weakReference.get() : null;
        if (oVar == null) {
            synchronized (o.class) {
                try {
                    WeakReference<o> weakReference2 = f6116e.get(format);
                    if (weakReference2 != null) {
                        oVar = weakReference2.get();
                    }
                    if (oVar == null) {
                        oVar = new o(format, cVar.f6129b);
                        f6116e.put(format, new WeakReference<>(oVar));
                    }
                } finally {
                }
            }
        }
        return oVar;
    }

    public void a() {
        synchronized (this) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(this.f6118b);
                new DataOutputStream(byteArrayOutputStream).writeLong(System.currentTimeMillis());
                this.f6118b = byteArrayOutputStream.toByteArray();
                this.f6119c++;
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            }
        }
        c();
    }
}
