package com.wbl.ad.yzz.util.f0.e;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public final class h implements Closeable {

    /* renamed from: a */
    public final File f34297a;

    /* renamed from: b */
    public final File f34298b;

    /* renamed from: c */
    public final File f34299c;

    /* renamed from: d */
    public final File f34300d;

    /* renamed from: e */
    public final int f34301e;

    /* renamed from: f */
    public long f34302f;

    /* renamed from: g */
    public final int f34303g;

    /* renamed from: i */
    public Writer f34305i;
    public int k;

    /* renamed from: h */
    public long f34304h = 0;

    /* renamed from: j */
    public final LinkedHashMap<String, c> f34306j = new LinkedHashMap<>(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> n = new a();

    public class a implements Callable<Void> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Void] */
        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8233, this, null);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call */
        public Void call2() throws Exception {
            return (Void) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8236, this, null);
        }
    }

    public final class b {

        /* renamed from: a */
        public final c f34308a;

        /* renamed from: b */
        public final boolean[] f34309b;

        /* renamed from: c */
        public boolean f34310c;

        public /* synthetic */ b(h hVar, c cVar, a aVar) {
            this(cVar);
        }

        public static /* synthetic */ c a(b bVar) {
            return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8235, null, bVar);
        }

        public static /* synthetic */ boolean[] b(b bVar) {
            return (boolean[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8230, null, bVar);
        }

        public File a(int i2) throws IOException {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8229, this, Integer.valueOf(i2));
        }

        public void a() throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8232, this, null);
        }

        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8231, this, null);
        }

        public void c() throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8226, this, null);
        }

        public b(c cVar) {
            this.f34308a = cVar;
            this.f34309b = c.d(cVar) ? null : new boolean[h.c(h.this)];
        }
    }

    public final class c {

        /* renamed from: a */
        public final String f34312a;

        /* renamed from: b */
        public final long[] f34313b;

        /* renamed from: c */
        public File[] f34314c;

        /* renamed from: d */
        public File[] f34315d;

        /* renamed from: e */
        public boolean f34316e;

        /* renamed from: f */
        public b f34317f;

        /* renamed from: g */
        public long f34318g;

        public /* synthetic */ c(h hVar, String str, a aVar) {
            this(str);
        }

        public static /* synthetic */ b a(c cVar, b bVar) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8228, null, cVar, bVar);
        }

        public static /* synthetic */ long[] a(c cVar) {
            return (long[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8253, null, cVar);
        }

        public static /* synthetic */ String b(c cVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8256, null, cVar);
        }

        public static /* synthetic */ boolean d(c cVar) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8250, null, cVar);
        }

        public static /* synthetic */ b e(c cVar) {
            return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8249, null, cVar);
        }

        public File a(int i2) {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8252, this, Integer.valueOf(i2));
        }

        public final IOException a(String[] strArr) throws IOException {
            return (IOException) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8251, this, strArr);
        }

        public String a() throws IOException {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8246, this, null);
        }

        public File b(int i2) {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8245, this, Integer.valueOf(i2));
        }

        public final void b(String[] strArr) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8248, this, strArr);
        }

        public c(String str) {
            this.f34312a = str;
            this.f34313b = new long[h.c(h.this)];
            this.f34314c = new File[h.c(h.this)];
            this.f34315d = new File[h.c(h.this)];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < h.c(h.this); i2++) {
                sb.append(i2);
                this.f34314c[i2] = new File(h.d(h.this), sb.toString());
                sb.append(".tmp");
                this.f34315d[i2] = new File(h.d(h.this), sb.toString());
                sb.setLength(length);
            }
        }
    }

    public final class d {

        /* renamed from: a */
        public final File[] f34320a;

        public /* synthetic */ d(h hVar, String str, long j2, File[] fileArr, long[] jArr, a aVar) {
            this(hVar, str, j2, fileArr, jArr);
        }

        public File a(int i2) {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8247, this, Integer.valueOf(i2));
        }

        public d(h hVar, String str, long j2, File[] fileArr, long[] jArr) {
            this.f34320a = fileArr;
        }
    }

    public h(File file, int i2, int i3, long j2) {
        this.f34297a = file;
        this.f34301e = i2;
        this.f34298b = new File(file, "journal");
        this.f34299c = new File(file, "journal.tmp");
        this.f34300d = new File(file, "journal.bkp");
        this.f34303g = i3;
        this.f34302f = j2;
    }

    public static h a(File file, int i2, int i3, long j2) throws IOException {
        return (h) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8241, null, file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
    }

    public static /* synthetic */ Writer a(h hVar) {
        return (Writer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8244, null, hVar);
    }

    public static void a(File file) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8206, null, file);
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8205, null, file, file2, Boolean.valueOf(z));
    }

    public static /* synthetic */ int c(h hVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8207, null, hVar);
    }

    public static /* synthetic */ File d(h hVar) {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8202, null, hVar);
    }

    public b a(String str) throws IOException {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8203, this, str);
    }

    public final synchronized b a(String str, long j2) throws IOException {
        return (b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8198, this, str, Long.valueOf(j2));
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8197, this, null);
    }

    public final synchronized void a(b bVar, boolean z) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8200, this, bVar, Boolean.valueOf(z));
    }

    public synchronized d b(String str) throws IOException {
        return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8199, this, str);
    }

    public final boolean b() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8194, this, null);
    }

    public final void c() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8193, this, null);
    }

    public final void c(String str) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8196, this, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8195, this, null);
    }

    public final void d() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8222, this, null);
    }

    public synchronized boolean d(String str) throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-8221, this, str);
    }

    public void delete() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8224, this, null);
    }

    public final synchronized void e() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8223, this, null);
    }

    public final void f() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8218, this, null);
    }
}
