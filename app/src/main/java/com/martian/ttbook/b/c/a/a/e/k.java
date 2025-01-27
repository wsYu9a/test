package com.martian.ttbook.b.c.a.a.e;

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

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static Map<String, WeakReference<k>> f15848a = new HashMap();

    /* renamed from: b */
    private String f15849b;

    /* renamed from: c */
    private byte[] f15850c = new byte[0];

    /* renamed from: d */
    private int f15851d;

    /* renamed from: e */
    private long f15852e;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File j2;
            synchronized (k.this.f15849b) {
                try {
                    j2 = k.this.j();
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                if (j2.exists()) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    FileInputStream fileInputStream = new FileInputStream(j2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    }
                    k.this.f15850c = byteArrayOutputStream.toByteArray();
                    k kVar = k.this;
                    kVar.f15851d = kVar.f15850c.length / 8;
                    fileInputStream.close();
                    k.this.i();
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File j2;
            synchronized (k.this.f15849b) {
                try {
                    try {
                        j2 = k.this.j();
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                if (j2.exists() || j2.createNewFile()) {
                    new FileOutputStream(k.this.j()).write(k.this.f15850c);
                }
            }
        }
    }

    public static final class c extends Enum<c> {

        /* renamed from: d */
        public static final c f15855d = new c("REQUEST_DAILY", 0, 86400000, 0);

        /* renamed from: e */
        public static final c f15856e = new c("REQUEST_HOURLY", 1, 3600000, 1);

        /* renamed from: f */
        public static final c f15857f = new c("EXPOSURE_DAILY", 2, 86400000, 2);

        /* renamed from: g */
        public static final c f15858g = new c("EXPOSURE_HOURLY", 3, 3600000, 3);

        /* renamed from: h */
        public static final c f15859h = new c("CLICK_DAILY", 4, 86400000, 4);

        /* renamed from: i */
        public static final c f15860i = new c("CLICK_HOURLY", 5, 3600000, 5);

        /* renamed from: b */
        public long f15861b;

        /* renamed from: c */
        public int f15862c;

        private c(String str, int i2, long j2, int i3) {
            super(str, i2);
            this.f15861b = j2;
            this.f15862c = i3;
        }
    }

    protected k(String str, long j2) {
        new ArrayList();
        this.f15851d = 0;
        this.f15849b = str;
        this.f15852e = j2;
        f();
    }

    public static k b(String str, c cVar) {
        String format = String.format("%s_%d", str, Integer.valueOf(cVar.f15862c));
        WeakReference<k> weakReference = f15848a.get(format);
        k kVar = weakReference != null ? weakReference.get() : null;
        if (kVar == null) {
            synchronized (k.class) {
                WeakReference<k> weakReference2 = f15848a.get(format);
                if (weakReference2 != null) {
                    kVar = weakReference2.get();
                }
                if (kVar == null) {
                    kVar = new k(format, cVar.f15861b);
                    f15848a.put(format, new WeakReference<>(kVar));
                }
            }
        }
        return kVar;
    }

    public void d() {
        synchronized (this) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(this.f15850c);
                new DataOutputStream(byteArrayOutputStream).writeLong(System.currentTimeMillis());
                this.f15850c = byteArrayOutputStream.toByteArray();
                this.f15851d++;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        h();
    }

    public void f() {
        j.e(new a());
    }

    public void h() {
        j.e(new b());
    }

    public int i() {
        synchronized (this) {
            if (this.f15850c.length == 0) {
                return 0;
            }
            int i2 = 0;
            while (new DataInputStream(new ByteArrayInputStream(this.f15850c)).readLong() < System.currentTimeMillis() - this.f15852e) {
                try {
                    this.f15851d--;
                    i2++;
                } catch (IOException unused) {
                }
            }
            if (i2 > 0) {
                int i3 = i2 * 8;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = this.f15850c;
                byteArrayOutputStream.write(bArr, i3, bArr.length - i3);
                this.f15850c = byteArrayOutputStream.toByteArray();
            }
            if (i2 > 0) {
                h();
            }
            if (this.f15851d < 0) {
                this.f15851d = 0;
            }
            return this.f15851d;
        }
    }

    protected File j() {
        return new File(com.martian.ttbook.b.c.a.a.d.b.j.q.getApplicationInfo().dataDir, com.martian.ttbook.b.c.a.a.e.b.s() + this.f15849b);
    }

    public String toString() {
        return String.format("TimeSpan{name= %s,count= %s,timeSpan= %s}", this.f15849b, Integer.valueOf(this.f15851d), Long.valueOf(this.f15852e));
    }
}
