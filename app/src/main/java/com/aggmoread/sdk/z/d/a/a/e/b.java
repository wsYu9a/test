package com.aggmoread.sdk.z.d.a.a.e;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {

    /* renamed from: e */
    private static Map<String, WeakReference<b>> f6066e = new HashMap();

    /* renamed from: f */
    private static h f6067f = new h("cc_default");

    /* renamed from: a */
    private String f6068a;

    /* renamed from: b */
    private long f6069b;

    /* renamed from: c */
    private byte[] f6070c;

    /* renamed from: d */
    private String f6071d;

    public class a implements Runnable {

        /* renamed from: b */
        final /* synthetic */ byte[] f6072b;

        public a(byte[] bArr) {
            this.f6072b = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                try {
                    File file = new File(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getApplicationInfo().dataDir, String.format("%s_%s_m", com.aggmoread.sdk.z.d.a.a.e.c.l(), b.this.f6068a));
                    if (this.f6072b == null) {
                        if (file.exists()) {
                            file.delete();
                        }
                        return;
                    }
                    try {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(this.f6072b);
                        fileOutputStream.close();
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        e.printStackTrace();
                    } catch (IOException e11) {
                        e = e11;
                        e.printStackTrace();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.e.b$b */
    public class RunnableC0189b implements Runnable {

        /* renamed from: b */
        final /* synthetic */ c f6074b;

        public RunnableC0189b(c cVar) {
            this.f6074b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                try {
                    File file = new File(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getApplicationInfo().dataDir, String.format("%s_%s_m", com.aggmoread.sdk.z.d.a.a.e.c.l(), b.this.f6068a));
                    if (file.exists()) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 1024);
                                if (read <= 0) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            }
                            b.this.f6070c = byteArrayOutputStream.toByteArray();
                            b.this.f6069b = b.f6067f.a(b.this.f6068a, 0L);
                            b.this.f6071d = b.f6067f.a(b.this.f6068a + "_v", (String) null);
                            fileInputStream.close();
                        } catch (FileNotFoundException e10) {
                            e = e10;
                            e.printStackTrace();
                            this.f6074b.a(b.this);
                        } catch (IOException e11) {
                            e = e11;
                            e.printStackTrace();
                            this.f6074b.a(b.this);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.f6074b.a(b.this);
        }
    }

    public interface c {
        void a(b bVar);
    }

    public b(String str) {
        this.f6068a = str;
    }

    public byte[] b() {
        return this.f6070c;
    }

    public long c() {
        return this.f6069b;
    }

    public String d() {
        return this.f6071d;
    }

    public static b a(String str) {
        WeakReference<b> weakReference = f6066e.get(str);
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar == null) {
            synchronized (b.class) {
                try {
                    WeakReference<b> weakReference2 = f6066e.get(str);
                    if (weakReference2 != null) {
                        bVar = weakReference2.get();
                    }
                    if (bVar == null) {
                        bVar = new b(str);
                        f6066e.put(str, new WeakReference<>(bVar));
                    }
                } finally {
                }
            }
        }
        return bVar;
    }

    public void a(c cVar) {
        n.b(new RunnableC0189b(cVar));
    }

    public void a(byte[] bArr) {
        this.f6070c = bArr;
        this.f6069b = System.currentTimeMillis();
        if (bArr == null) {
            this.f6069b = 0L;
        }
        f6067f.b(this.f6068a, this.f6069b);
        f6067f.b(this.f6068a + "_v", "8091910");
        n.b(new a(bArr));
    }
}
