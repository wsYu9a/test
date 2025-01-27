package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.a;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import hf.c;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import ze.d;

/* loaded from: classes3.dex */
public final class LoadAndDisplayImageTask implements Runnable, c.a {
    public static final String A = "Resize image in disk cache [%s]";
    public static final String B = "PreProcess image before caching in memory [%s]";
    public static final String C = "PostProcess image before displaying [%s]";
    public static final String D = "Cache image in memory [%s]";
    public static final String E = "Cache image on disk [%s]";
    public static final String F = "Process image before cache on disk [%s]";
    public static final String G = "ImageAware is reused for another image. Task is cancelled. [%s]";
    public static final String H = "ImageAware was collected by GC. Task is cancelled. [%s]";
    public static final String I = "Task was interrupted [%s]";
    public static final String J = "Pre-processor returned null [%s]";
    public static final String K = "Post-processor returned null [%s]";
    public static final String L = "Bitmap processor for disk cache returned null [%s]";

    /* renamed from: s */
    public static final String f16258s = "ImageLoader is paused. Waiting...  [%s]";

    /* renamed from: t */
    public static final String f16259t = ".. Resume loading [%s]";

    /* renamed from: u */
    public static final String f16260u = "Delay %d ms before loading...  [%s]";

    /* renamed from: v */
    public static final String f16261v = "Start display image task [%s]";

    /* renamed from: w */
    public static final String f16262w = "Image already is loading. Waiting... [%s]";

    /* renamed from: x */
    public static final String f16263x = "...Get cached bitmap from memory after waiting. [%s]";

    /* renamed from: y */
    public static final String f16264y = "Load image from network [%s]";

    /* renamed from: z */
    public static final String f16265z = "Load image from disk cache [%s]";

    /* renamed from: b */
    public final ze.c f16266b;

    /* renamed from: c */
    public final d f16267c;

    /* renamed from: d */
    public final Handler f16268d;

    /* renamed from: e */
    public final ImageLoaderConfiguration f16269e;

    /* renamed from: f */
    public final ImageDownloader f16270f;

    /* renamed from: g */
    public final ImageDownloader f16271g;

    /* renamed from: h */
    public final ImageDownloader f16272h;

    /* renamed from: i */
    public final cf.b f16273i;

    /* renamed from: j */
    public final String f16274j;

    /* renamed from: k */
    public final String f16275k;

    /* renamed from: l */
    public final ef.a f16276l;

    /* renamed from: m */
    public final af.c f16277m;

    /* renamed from: n */
    public final com.nostra13.universalimageloader.core.a f16278n;

    /* renamed from: o */
    public final ff.a f16279o;

    /* renamed from: p */
    public final ff.b f16280p;

    /* renamed from: q */
    public final boolean f16281q;

    /* renamed from: r */
    public LoadedFrom f16282r = LoadedFrom.NETWORK;

    public class TaskCancelledException extends Exception {
        public TaskCancelledException() {
        }
    }

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ int f16283b;

        /* renamed from: c */
        public final /* synthetic */ int f16284c;

        public a(int i10, int i11) {
            this.f16283b = i10;
            this.f16284c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.f16280p.onProgressUpdate(loadAndDisplayImageTask.f16274j, loadAndDisplayImageTask.f16276l.getWrappedView(), this.f16283b, this.f16284c);
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ FailReason.FailType f16286b;

        /* renamed from: c */
        public final /* synthetic */ Throwable f16287c;

        public b(FailReason.FailType failType, Throwable th2) {
            this.f16286b = failType;
            this.f16287c = th2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LoadAndDisplayImageTask.this.f16278n.O()) {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.f16276l.setImageDrawable(loadAndDisplayImageTask.f16278n.A(loadAndDisplayImageTask.f16269e.f16209a));
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask2 = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask2.f16279o.a(loadAndDisplayImageTask2.f16274j, loadAndDisplayImageTask2.f16276l.getWrappedView(), new FailReason(this.f16286b, this.f16287c));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.f16279o.onLoadingCancelled(loadAndDisplayImageTask.f16274j, loadAndDisplayImageTask.f16276l.getWrappedView());
        }
    }

    public LoadAndDisplayImageTask(ze.c cVar, d dVar, Handler handler) {
        this.f16266b = cVar;
        this.f16267c = dVar;
        this.f16268d = handler;
        ImageLoaderConfiguration imageLoaderConfiguration = cVar.f33788a;
        this.f16269e = imageLoaderConfiguration;
        this.f16270f = imageLoaderConfiguration.f16224p;
        this.f16271g = imageLoaderConfiguration.f16227s;
        this.f16272h = imageLoaderConfiguration.f16228t;
        this.f16273i = imageLoaderConfiguration.f16225q;
        this.f16274j = dVar.f33800a;
        this.f16275k = dVar.f33801b;
        this.f16276l = dVar.f33802c;
        this.f16277m = dVar.f33803d;
        com.nostra13.universalimageloader.core.a aVar = dVar.f33804e;
        this.f16278n = aVar;
        this.f16279o = dVar.f33805f;
        this.f16280p = dVar.f33806g;
        this.f16281q = aVar.J();
    }

    public static void s(Runnable runnable, boolean z10, Handler handler, ze.c cVar) {
        if (z10) {
            runnable.run();
        } else if (handler == null) {
            cVar.g(runnable);
        } else {
            handler.post(runnable);
        }
    }

    public final void b() throws TaskCancelledException {
        if (n()) {
            throw new TaskCancelledException();
        }
    }

    public final void c() throws TaskCancelledException {
        d();
        e();
    }

    public final void d() throws TaskCancelledException {
        if (p()) {
            throw new TaskCancelledException();
        }
    }

    public final void e() throws TaskCancelledException {
        if (q()) {
            throw new TaskCancelledException();
        }
    }

    public final Bitmap f(String str) throws IOException {
        return this.f16273i.a(new cf.c(this.f16275k, str, this.f16274j, this.f16277m, this.f16276l.getScaleType(), l(), this.f16278n));
    }

    public final boolean g() {
        if (!this.f16278n.K()) {
            return false;
        }
        hf.d.a(f16260u, Integer.valueOf(this.f16278n.v()), this.f16275k);
        try {
            Thread.sleep(this.f16278n.v());
            return o();
        } catch (InterruptedException unused) {
            hf.d.c(I, this.f16275k);
            return true;
        }
    }

    public final boolean h() throws IOException {
        return this.f16269e.f16223o.a(this.f16274j, l().getStream(this.f16274j, this.f16278n.x()), this);
    }

    public final void i() {
        if (this.f16281q || n()) {
            return;
        }
        s(new c(), false, this.f16268d, this.f16266b);
    }

    public final void j(FailReason.FailType failType, Throwable th2) {
        if (this.f16281q || n() || o()) {
            return;
        }
        s(new b(failType, th2), false, this.f16268d, this.f16266b);
    }

    public final boolean k(int i10, int i11) {
        if (n() || o()) {
            return false;
        }
        if (this.f16280p == null) {
            return true;
        }
        s(new a(i10, i11), false, this.f16268d, this.f16266b);
        return true;
    }

    public final ImageDownloader l() {
        return this.f16266b.n() ? this.f16271g : this.f16266b.o() ? this.f16272h : this.f16270f;
    }

    public String m() {
        return this.f16274j;
    }

    public final boolean n() {
        if (!Thread.interrupted()) {
            return false;
        }
        hf.d.a(I, this.f16275k);
        return true;
    }

    public final boolean o() {
        return p() || q();
    }

    @Override // hf.c.a
    public boolean onBytesCopied(int i10, int i11) {
        return this.f16281q || k(i10, i11);
    }

    public final boolean p() {
        if (!this.f16276l.isCollected()) {
            return false;
        }
        hf.d.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f16275k);
        return true;
    }

    public final boolean q() {
        if (!(!this.f16275k.equals(this.f16266b.h(this.f16276l)))) {
            return false;
        }
        hf.d.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f16275k);
        return true;
    }

    public final boolean r(int i10, int i11) throws IOException {
        File file = this.f16269e.f16223o.get(this.f16274j);
        if (file == null || !file.exists()) {
            return false;
        }
        Bitmap a10 = this.f16273i.a(new cf.c(this.f16275k, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.f16274j, new af.c(i10, i11), ViewScaleType.FIT_INSIDE, l(), new a.b().A(this.f16278n).H(ImageScaleType.IN_SAMPLE_INT).u()));
        if (a10 != null && this.f16269e.f16214f != null) {
            hf.d.a(F, this.f16275k);
            a10 = this.f16269e.f16214f.process(a10);
            if (a10 == null) {
                hf.d.c(L, this.f16275k);
            }
        }
        if (a10 == null) {
            return false;
        }
        boolean save = this.f16269e.f16223o.save(this.f16274j, a10);
        a10.recycle();
        return save;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d7 A[Catch: all -> 0x005b, TaskCancelledException -> 0x0100, TryCatch #0 {TaskCancelledException -> 0x0100, blocks: (B:13:0x0033, B:15:0x0044, B:18:0x004b, B:20:0x00b8, B:22:0x00c0, B:24:0x00d7, B:25:0x00e2, B:29:0x005e, B:33:0x0068, B:35:0x0076, B:37:0x008d, B:39:0x009a, B:41:0x00a2), top: B:12:0x0033, outer: #1 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 267
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.run():void");
    }

    public final boolean t() throws TaskCancelledException {
        hf.d.a(E, this.f16275k);
        try {
            boolean h10 = h();
            if (h10) {
                ImageLoaderConfiguration imageLoaderConfiguration = this.f16269e;
                int i10 = imageLoaderConfiguration.f16212d;
                int i11 = imageLoaderConfiguration.f16213e;
                if (i10 > 0 || i11 > 0) {
                    hf.d.a(A, this.f16275k);
                    r(i10, i11);
                }
            }
            return h10;
        } catch (IOException e10) {
            hf.d.d(e10);
            return false;
        }
    }

    public final Bitmap u() throws TaskCancelledException {
        Bitmap bitmap;
        File file;
        Bitmap bitmap2 = null;
        try {
            try {
                File file2 = this.f16269e.f16223o.get(this.f16274j);
                if (file2 == null || !file2.exists()) {
                    bitmap = null;
                } else {
                    hf.d.a(f16265z, this.f16275k);
                    this.f16282r = LoadedFrom.DISC_CACHE;
                    c();
                    bitmap = f(ImageDownloader.Scheme.FILE.wrap(file2.getAbsolutePath()));
                }
                if (bitmap != null) {
                    try {
                        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                            return bitmap;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        bitmap2 = bitmap;
                        hf.d.d(e);
                        j(FailReason.FailType.IO_ERROR, e);
                        return bitmap2;
                    } catch (IllegalStateException unused) {
                        j(FailReason.FailType.NETWORK_DENIED, null);
                        return bitmap;
                    } catch (OutOfMemoryError e11) {
                        e = e11;
                        bitmap2 = bitmap;
                        hf.d.d(e);
                        j(FailReason.FailType.OUT_OF_MEMORY, e);
                        return bitmap2;
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap2 = bitmap;
                        hf.d.d(th);
                        j(FailReason.FailType.UNKNOWN, th);
                        return bitmap2;
                    }
                }
                hf.d.a(f16264y, this.f16275k);
                this.f16282r = LoadedFrom.NETWORK;
                String str = this.f16274j;
                if (this.f16278n.G() && t() && (file = this.f16269e.f16223o.get(this.f16274j)) != null) {
                    str = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                }
                c();
                bitmap = f(str);
                if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    return bitmap;
                }
                j(FailReason.FailType.DECODING_ERROR, null);
                return bitmap;
            } catch (IOException e12) {
                e = e12;
            } catch (IllegalStateException unused2) {
                bitmap = null;
            } catch (OutOfMemoryError e13) {
                e = e13;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (TaskCancelledException e14) {
            throw e14;
        }
    }

    public final boolean v() {
        AtomicBoolean j10 = this.f16266b.j();
        if (j10.get()) {
            synchronized (this.f16266b.k()) {
                try {
                    if (j10.get()) {
                        hf.d.a(f16258s, this.f16275k);
                        try {
                            this.f16266b.k().wait();
                            hf.d.a(f16259t, this.f16275k);
                        } catch (InterruptedException unused) {
                            hf.d.c(I, this.f16275k);
                            return true;
                        }
                    }
                } finally {
                }
            }
        }
        return o();
    }
}
