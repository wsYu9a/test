package com.wbl.ad.yzz.download.i;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.io.Closeable;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class f implements Closeable {
    public static final Pattern o = Pattern.compile("[a-z0-9_-]{1,120}");
    public static final OutputStream p = new b();

    /* renamed from: a */
    public final File f32064a;

    /* renamed from: b */
    public final File f32065b;

    /* renamed from: c */
    public final File f32066c;

    /* renamed from: d */
    public final File f32067d;

    /* renamed from: e */
    public final int f32068e;

    /* renamed from: f */
    public long f32069f;

    /* renamed from: g */
    public final int f32070g;

    /* renamed from: i */
    public Writer f32072i;
    public int k;

    /* renamed from: h */
    public long f32071h = 0;

    /* renamed from: j */
    public final LinkedHashMap<String, d> f32073j = new LinkedHashMap<>(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final Callable<Void> n = new a();

    public class a implements Callable<Void> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.lang.Void] */
        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13854, this, null);
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call */
        public Void call2() throws Exception {
            return (Void) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13853, this, null);
        }
    }

    public static class b extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13856, this, Integer.valueOf(i2));
        }
    }

    public final class c {

        /* renamed from: a */
        public final d f32075a;

        /* renamed from: b */
        public final boolean[] f32076b;

        /* renamed from: c */
        public boolean f32077c;

        public class a extends FilterOutputStream {
            public /* synthetic */ a(c cVar, OutputStream outputStream, a aVar) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13855, this, null);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public void flush() {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13850, this, null);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(int i2) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13849, this, Integer.valueOf(i2));
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public void write(byte[] bArr, int i2, int i3) {
                Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13852, this, bArr, Integer.valueOf(i2), Integer.valueOf(i3));
            }

            public a(OutputStream outputStream) {
                super(outputStream);
            }
        }

        public /* synthetic */ c(f fVar, d dVar, a aVar) {
            this(dVar);
        }

        public static /* synthetic */ d a(c cVar) {
            return (d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13851, null, cVar);
        }

        public static /* synthetic */ boolean[] b(c cVar) {
            return (boolean[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13845, null, cVar);
        }

        public OutputStream a(int i2) throws IOException {
            return (OutputStream) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13848, this, Integer.valueOf(i2));
        }

        public void a() throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13847, this, null);
        }

        public void b() throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13842, this, null);
        }

        public c(d dVar) {
            this.f32075a = dVar;
            this.f32076b = d.d(dVar) ? null : new boolean[f.c(f.this)];
        }
    }

    public final class d {

        /* renamed from: a */
        public final String f32080a;

        /* renamed from: b */
        public final long[] f32081b;

        /* renamed from: c */
        public boolean f32082c;

        /* renamed from: d */
        public c f32083d;

        /* renamed from: e */
        public long f32084e;

        public /* synthetic */ d(f fVar, String str, a aVar) {
            this(str);
        }

        public static /* synthetic */ c a(d dVar, c cVar) {
            return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13844, null, dVar, cVar);
        }

        public static /* synthetic */ long[] a(d dVar) {
            return (long[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13933, null, dVar);
        }

        public static /* synthetic */ String b(d dVar) {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13936, null, dVar);
        }

        public static /* synthetic */ boolean d(d dVar) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13930, null, dVar);
        }

        public static /* synthetic */ c e(d dVar) {
            return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13929, null, dVar);
        }

        public File a(int i2) {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13932, this, Integer.valueOf(i2));
        }

        public final IOException a(String[] strArr) throws IOException {
            return (IOException) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13931, this, strArr);
        }

        public String a() throws IOException {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13926, this, null);
        }

        public File b(int i2) {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13925, this, Integer.valueOf(i2));
        }

        public final void b(String[] strArr) throws IOException {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13928, this, strArr);
        }

        public d(String str) {
            this.f32080a = str;
            this.f32081b = new long[f.c(f.this)];
        }
    }

    public final class e implements Closeable {

        /* renamed from: a */
        public final InputStream[] f32086a;

        /* renamed from: b */
        public final File[] f32087b;

        public /* synthetic */ e(f fVar, String str, long j2, InputStream[] inputStreamArr, File[] fileArr, long[] jArr, a aVar) {
            this(fVar, str, j2, inputStreamArr, fileArr, jArr);
        }

        public File a(int i2) {
            return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13927, this, Integer.valueOf(i2));
        }

        public InputStream b(int i2) {
            return (InputStream) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13922, this, Integer.valueOf(i2));
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13921, this, null);
        }

        public e(f fVar, String str, long j2, InputStream[] inputStreamArr, File[] fileArr, long[] jArr) {
            this.f32086a = inputStreamArr;
            this.f32087b = fileArr;
        }
    }

    public f(File file, int i2, int i3, long j2) {
        this.f32064a = file;
        this.f32068e = i2;
        this.f32065b = new File(file, "journal");
        this.f32066c = new File(file, "journal.tmp");
        this.f32067d = new File(file, "journal.bkp");
        this.f32070g = i3;
        this.f32069f = j2;
    }

    public static f a(File file, int i2, int i3, long j2) throws IOException {
        return (f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13923, null, file, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
    }

    public static /* synthetic */ OutputStream a() {
        return (OutputStream) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13950, null, null);
    }

    public static /* synthetic */ Writer a(f fVar) {
        return (Writer) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13949, null, fVar);
    }

    public static void a(File file) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13951, null, file);
    }

    public static void a(File file, File file2, boolean z) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13946, null, file, file2, Boolean.valueOf(z));
    }

    public static /* synthetic */ int c(f fVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13948, null, fVar);
    }

    public static /* synthetic */ File d(f fVar) {
        return (File) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13947, null, fVar);
    }

    public c a(String str) throws IOException {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13944, this, str);
    }

    public final synchronized c a(String str, long j2) throws IOException {
        return (c) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13943, this, str, Long.valueOf(j2));
    }

    public final synchronized void a(c cVar, boolean z) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13938, this, cVar, Boolean.valueOf(z));
    }

    public synchronized e b(String str) throws IOException {
        return (e) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13937, this, str);
    }

    public final void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13940, this, null);
    }

    public synchronized void c() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13939, this, null);
    }

    public final void c(String str) throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13902, this, str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13901, this, null);
    }

    public final boolean d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13904, this, null);
    }

    public synchronized boolean d(String str) throws IOException {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13903, this, str);
    }

    public void delete() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13898, this, null);
    }

    public final void e() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13897, this, null);
    }

    public final void e(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13900, this, str);
    }

    public final void f() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13899, this, null);
    }

    public final synchronized void g() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13894, this, null);
    }

    public final void h() throws IOException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13893, this, null);
    }
}
