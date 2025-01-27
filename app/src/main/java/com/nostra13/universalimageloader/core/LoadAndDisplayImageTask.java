package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import b.g.a.b.c;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.c;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
final class LoadAndDisplayImageTask implements Runnable, c.a {

    /* renamed from: a */
    private static final String f15890a = "ImageLoader is paused. Waiting...  [%s]";

    /* renamed from: b */
    private static final String f15891b = ".. Resume loading [%s]";

    /* renamed from: c */
    private static final String f15892c = "Delay %d ms before loading...  [%s]";

    /* renamed from: d */
    private static final String f15893d = "Start display image task [%s]";

    /* renamed from: e */
    private static final String f15894e = "Image already is loading. Waiting... [%s]";

    /* renamed from: f */
    private static final String f15895f = "...Get cached bitmap from memory after waiting. [%s]";

    /* renamed from: g */
    private static final String f15896g = "Load image from network [%s]";

    /* renamed from: h */
    private static final String f15897h = "Load image from disk cache [%s]";

    /* renamed from: i */
    private static final String f15898i = "Resize image in disk cache [%s]";

    /* renamed from: j */
    private static final String f15899j = "PreProcess image before caching in memory [%s]";
    private static final String k = "PostProcess image before displaying [%s]";
    private static final String l = "Cache image in memory [%s]";
    private static final String m = "Cache image on disk [%s]";
    private static final String n = "Process image before cache on disk [%s]";
    private static final String o = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String p = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String q = "Task was interrupted [%s]";
    private static final String r = "Pre-processor returned null [%s]";
    private static final String s = "Post-processor returned null [%s]";
    private static final String t = "Bitmap processor for disk cache returned null [%s]";
    private final ImageDownloader A;
    private final com.nostra13.universalimageloader.core.h.b B;
    final String C;
    private final String D;
    final com.nostra13.universalimageloader.core.j.a E;
    private final com.nostra13.universalimageloader.core.assist.c F;
    final com.nostra13.universalimageloader.core.c G;
    final com.nostra13.universalimageloader.core.k.a H;
    final com.nostra13.universalimageloader.core.k.b I;
    private final boolean J;
    private LoadedFrom K = LoadedFrom.NETWORK;
    private final e u;
    private final f v;
    private final Handler w;
    private final ImageLoaderConfiguration x;
    private final ImageDownloader y;
    private final ImageDownloader z;

    class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f15900a;

        /* renamed from: b */
        final /* synthetic */ int f15901b;

        a(int i2, int i3) {
            this.f15900a = i2;
            this.f15901b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.I.onProgressUpdate(loadAndDisplayImageTask.C, loadAndDisplayImageTask.E.getWrappedView(), this.f15900a, this.f15901b);
        }
    }

    class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ FailReason.FailType f15903a;

        /* renamed from: b */
        final /* synthetic */ Throwable f15904b;

        b(FailReason.FailType failType, Throwable th) {
            this.f15903a = failType;
            this.f15904b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LoadAndDisplayImageTask.this.G.O()) {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.E.setImageDrawable(loadAndDisplayImageTask.G.A(loadAndDisplayImageTask.x.f15867a));
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask2 = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask2.H.a(loadAndDisplayImageTask2.C, loadAndDisplayImageTask2.E.getWrappedView(), new FailReason(this.f15903a, this.f15904b));
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.H.onLoadingCancelled(loadAndDisplayImageTask.C, loadAndDisplayImageTask.E.getWrappedView());
        }
    }

    public LoadAndDisplayImageTask(e eVar, f fVar, Handler handler) {
        this.u = eVar;
        this.v = fVar;
        this.w = handler;
        ImageLoaderConfiguration imageLoaderConfiguration = eVar.f15982a;
        this.x = imageLoaderConfiguration;
        this.y = imageLoaderConfiguration.p;
        this.z = imageLoaderConfiguration.s;
        this.A = imageLoaderConfiguration.t;
        this.B = imageLoaderConfiguration.q;
        this.C = fVar.f15994a;
        this.D = fVar.f15995b;
        this.E = fVar.f15996c;
        this.F = fVar.f15997d;
        com.nostra13.universalimageloader.core.c cVar = fVar.f15998e;
        this.G = cVar;
        this.H = fVar.f15999f;
        this.I = fVar.f16000g;
        this.J = cVar.J();
    }

    private void c() throws TaskCancelledException {
        if (o()) {
            throw new TaskCancelledException();
        }
    }

    private void d() throws TaskCancelledException {
        e();
        f();
    }

    private void e() throws TaskCancelledException {
        if (q()) {
            throw new TaskCancelledException();
        }
    }

    private void f() throws TaskCancelledException {
        if (r()) {
            throw new TaskCancelledException();
        }
    }

    private Bitmap g(String str) throws IOException {
        return this.B.a(new com.nostra13.universalimageloader.core.h.c(this.D, str, this.C, this.F, this.E.getScaleType(), m(), this.G));
    }

    private boolean h() {
        if (!this.G.K()) {
            return false;
        }
        b.g.a.b.d.a(f15892c, Integer.valueOf(this.G.v()), this.D);
        try {
            Thread.sleep(this.G.v());
            return p();
        } catch (InterruptedException unused) {
            b.g.a.b.d.c(q, this.D);
            return true;
        }
    }

    private boolean i() throws IOException {
        return this.x.o.a(this.C, m().getStream(this.C, this.G.x()), this);
    }

    private void j() {
        if (this.J || o()) {
            return;
        }
        t(new c(), false, this.w, this.u);
    }

    private void k(FailReason.FailType failType, Throwable th) {
        if (this.J || o() || p()) {
            return;
        }
        t(new b(failType, th), false, this.w, this.u);
    }

    private boolean l(int i2, int i3) {
        if (o() || p()) {
            return false;
        }
        if (this.I == null) {
            return true;
        }
        t(new a(i2, i3), false, this.w, this.u);
        return true;
    }

    private ImageDownloader m() {
        return this.u.n() ? this.z : this.u.o() ? this.A : this.y;
    }

    private boolean o() {
        if (!Thread.interrupted()) {
            return false;
        }
        b.g.a.b.d.a(q, this.D);
        return true;
    }

    private boolean p() {
        return q() || r();
    }

    private boolean q() {
        if (!this.E.isCollected()) {
            return false;
        }
        b.g.a.b.d.a(p, this.D);
        return true;
    }

    private boolean r() {
        if (!(!this.D.equals(this.u.h(this.E)))) {
            return false;
        }
        b.g.a.b.d.a(o, this.D);
        return true;
    }

    private boolean s(int i2, int i3) throws IOException {
        File file = this.x.o.get(this.C);
        if (file == null || !file.exists()) {
            return false;
        }
        Bitmap a2 = this.B.a(new com.nostra13.universalimageloader.core.h.c(this.D, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.C, new com.nostra13.universalimageloader.core.assist.c(i2, i3), ViewScaleType.FIT_INSIDE, m(), new c.b().A(this.G).H(ImageScaleType.IN_SAMPLE_INT).u()));
        if (a2 != null && this.x.f15872f != null) {
            b.g.a.b.d.a(n, this.D);
            a2 = this.x.f15872f.process(a2);
            if (a2 == null) {
                b.g.a.b.d.c(t, this.D);
            }
        }
        if (a2 == null) {
            return false;
        }
        boolean save = this.x.o.save(this.C, a2);
        a2.recycle();
        return save;
    }

    static void t(Runnable runnable, boolean z, Handler handler, e eVar) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            eVar.g(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean u() throws TaskCancelledException {
        b.g.a.b.d.a(m, this.D);
        try {
            boolean i2 = i();
            if (i2) {
                ImageLoaderConfiguration imageLoaderConfiguration = this.x;
                int i3 = imageLoaderConfiguration.f15870d;
                int i4 = imageLoaderConfiguration.f15871e;
                if (i3 > 0 || i4 > 0) {
                    b.g.a.b.d.a(f15898i, this.D);
                    s(i3, i4);
                }
            }
            return i2;
        } catch (IOException e2) {
            b.g.a.b.d.d(e2);
            return false;
        }
    }

    private Bitmap v() throws TaskCancelledException {
        Bitmap bitmap;
        File file;
        Bitmap bitmap2 = null;
        try {
            try {
                File file2 = this.x.o.get(this.C);
                if (file2 == null || !file2.exists()) {
                    bitmap = null;
                } else {
                    b.g.a.b.d.a(f15897h, this.D);
                    this.K = LoadedFrom.DISC_CACHE;
                    d();
                    bitmap = g(ImageDownloader.Scheme.FILE.wrap(file2.getAbsolutePath()));
                }
                if (bitmap != null) {
                    try {
                        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                            return bitmap;
                        }
                    } catch (IOException e2) {
                        Bitmap bitmap3 = bitmap;
                        e = e2;
                        bitmap2 = bitmap3;
                        b.g.a.b.d.d(e);
                        k(FailReason.FailType.IO_ERROR, e);
                        return bitmap2;
                    } catch (IllegalStateException unused) {
                        k(FailReason.FailType.NETWORK_DENIED, null);
                        return bitmap;
                    } catch (OutOfMemoryError e3) {
                        Bitmap bitmap4 = bitmap;
                        e = e3;
                        bitmap2 = bitmap4;
                        b.g.a.b.d.d(e);
                        k(FailReason.FailType.OUT_OF_MEMORY, e);
                        return bitmap2;
                    } catch (Throwable th) {
                        Bitmap bitmap5 = bitmap;
                        th = th;
                        bitmap2 = bitmap5;
                        b.g.a.b.d.d(th);
                        k(FailReason.FailType.UNKNOWN, th);
                        return bitmap2;
                    }
                }
                b.g.a.b.d.a(f15896g, this.D);
                this.K = LoadedFrom.NETWORK;
                String str = this.C;
                if (this.G.G() && u() && (file = this.x.o.get(this.C)) != null) {
                    str = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                }
                d();
                bitmap = g(str);
                if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    return bitmap;
                }
                k(FailReason.FailType.DECODING_ERROR, null);
                return bitmap;
            } catch (IOException e4) {
                e = e4;
            } catch (IllegalStateException unused2) {
                bitmap = null;
            } catch (OutOfMemoryError e5) {
                e = e5;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (TaskCancelledException e6) {
            throw e6;
        }
    }

    private boolean w() {
        AtomicBoolean j2 = this.u.j();
        if (j2.get()) {
            synchronized (this.u.k()) {
                if (j2.get()) {
                    b.g.a.b.d.a(f15890a, this.D);
                    try {
                        this.u.k().wait();
                        b.g.a.b.d.a(f15891b, this.D);
                    } catch (InterruptedException unused) {
                        b.g.a.b.d.c(q, this.D);
                        return true;
                    }
                }
            }
        }
        return p();
    }

    String n() {
        return this.C;
    }

    @Override // b.g.a.b.c.a
    public boolean onBytesCopied(int i2, int i3) {
        return this.J || l(i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d4 A[Catch: all -> 0x00fd, TaskCancelledException -> 0x00ff, Merged into TryCatch #1 {all -> 0x00fd, TaskCancelledException -> 0x00ff, blocks: (B:13:0x0033, B:15:0x0044, B:18:0x004b, B:20:0x00b5, B:22:0x00bd, B:24:0x00d4, B:25:0x00df, B:29:0x005b, B:33:0x0065, B:35:0x0073, B:37:0x008a, B:39:0x0097, B:41:0x009f, B:42:0x00ff), top: B:12:0x0033 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.run():void");
    }
}
