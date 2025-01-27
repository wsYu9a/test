package com.martian.ttbook.b.c.a.a.e;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static Map<String, WeakReference<a>> f15801a = new HashMap();

    /* renamed from: b */
    private static f f15802b = new f("cc_default");

    /* renamed from: c */
    private String f15803c;

    /* renamed from: d */
    private long f15804d;

    /* renamed from: e */
    private byte[] f15805e;

    /* renamed from: com.martian.ttbook.b.c.a.a.e.a$a */
    class RunnableC0360a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ byte[] f15806a;

        RunnableC0360a(byte[] bArr) {
            this.f15806a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this) {
                File file = new File(com.martian.ttbook.b.c.a.a.d.b.j.q.getApplicationInfo().dataDir, String.format("%s_%s_m", com.martian.ttbook.b.c.a.a.e.b.s(), a.this.f15803c));
                if (this.f15806a == null) {
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
                    fileOutputStream.write(this.f15806a);
                    fileOutputStream.close();
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ c f15808a;

        b(c cVar) {
            this.f15808a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.this) {
                File file = new File(com.martian.ttbook.b.c.a.a.d.b.j.q.getApplicationInfo().dataDir, String.format("%s_%s_m", com.martian.ttbook.b.c.a.a.e.b.s(), a.this.f15803c));
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
                        a.this.f15805e = byteArrayOutputStream.toByteArray();
                        a.this.f15804d = a.f15802b.b(a.this.f15803c, 0L);
                        fileInputStream.close();
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            this.f15808a.a(a.this);
        }
    }

    public interface c {
        void a(a aVar);
    }

    protected a(String str) {
        this.f15803c = str;
    }

    public static a b(String str) {
        WeakReference<a> weakReference = f15801a.get(str);
        a aVar = weakReference != null ? weakReference.get() : null;
        if (aVar == null) {
            synchronized (a.class) {
                WeakReference<a> weakReference2 = f15801a.get(str);
                if (weakReference2 != null) {
                    aVar = weakReference2.get();
                }
                if (aVar == null) {
                    aVar = new a(str);
                    f15801a.put(str, new WeakReference<>(aVar));
                }
            }
        }
        return aVar;
    }

    public void e(c cVar) {
        j.e(new b(cVar));
    }

    public void f(byte[] bArr) {
        this.f15805e = bArr;
        this.f15804d = System.currentTimeMillis();
        if (bArr == null) {
            this.f15804d = 0L;
        }
        f15802b.i(this.f15803c, this.f15804d);
        j.e(new RunnableC0360a(bArr));
    }

    public byte[] h() {
        return this.f15805e;
    }

    public long i() {
        return this.f15804d;
    }
}
