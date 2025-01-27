package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import hf.d;
import hf.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class ImageLoaderConfiguration {

    /* renamed from: a */
    public final Resources f16209a;

    /* renamed from: b */
    public final int f16210b;

    /* renamed from: c */
    public final int f16211c;

    /* renamed from: d */
    public final int f16212d;

    /* renamed from: e */
    public final int f16213e;

    /* renamed from: f */
    public final gf.a f16214f;

    /* renamed from: g */
    public final Executor f16215g;

    /* renamed from: h */
    public final Executor f16216h;

    /* renamed from: i */
    public final boolean f16217i;

    /* renamed from: j */
    public final boolean f16218j;

    /* renamed from: k */
    public final int f16219k;

    /* renamed from: l */
    public final int f16220l;

    /* renamed from: m */
    public final QueueProcessingType f16221m;

    /* renamed from: n */
    public final xe.c f16222n;

    /* renamed from: o */
    public final te.b f16223o;

    /* renamed from: p */
    public final ImageDownloader f16224p;

    /* renamed from: q */
    public final cf.b f16225q;

    /* renamed from: r */
    public final com.nostra13.universalimageloader.core.a f16226r;

    /* renamed from: s */
    public final ImageDownloader f16227s;

    /* renamed from: t */
    public final ImageDownloader f16228t;

    public static class Builder {
        public static final String A = "memoryCache() and memoryCacheSize() calls overlap each other";
        public static final String B = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";
        public static final int C = 3;
        public static final int D = 4;
        public static final QueueProcessingType E = QueueProcessingType.FIFO;

        /* renamed from: y */
        public static final String f16229y = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";

        /* renamed from: z */
        public static final String f16230z = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";

        /* renamed from: a */
        public Context f16231a;

        /* renamed from: v */
        public cf.b f16252v;

        /* renamed from: b */
        public int f16232b = 0;

        /* renamed from: c */
        public int f16233c = 0;

        /* renamed from: d */
        public int f16234d = 0;

        /* renamed from: e */
        public int f16235e = 0;

        /* renamed from: f */
        public gf.a f16236f = null;

        /* renamed from: g */
        public Executor f16237g = null;

        /* renamed from: h */
        public Executor f16238h = null;

        /* renamed from: i */
        public boolean f16239i = false;

        /* renamed from: j */
        public boolean f16240j = false;

        /* renamed from: k */
        public int f16241k = 3;

        /* renamed from: l */
        public int f16242l = 4;

        /* renamed from: m */
        public boolean f16243m = false;

        /* renamed from: n */
        public QueueProcessingType f16244n = E;

        /* renamed from: o */
        public int f16245o = 0;

        /* renamed from: p */
        public long f16246p = 0;

        /* renamed from: q */
        public int f16247q = 0;

        /* renamed from: r */
        public xe.c f16248r = null;

        /* renamed from: s */
        public te.b f16249s = null;

        /* renamed from: t */
        public we.a f16250t = null;

        /* renamed from: u */
        public ImageDownloader f16251u = null;

        /* renamed from: w */
        public com.nostra13.universalimageloader.core.a f16253w = null;

        /* renamed from: x */
        public boolean f16254x = false;

        public Builder(Context context) {
            this.f16231a = context.getApplicationContext();
        }

        @Deprecated
        public Builder A(int i10) {
            return F(i10);
        }

        public Builder B(te.b bVar) {
            if (this.f16246p > 0 || this.f16247q > 0) {
                d.i(f16229y, new Object[0]);
            }
            if (this.f16250t != null) {
                d.i(f16230z, new Object[0]);
            }
            this.f16249s = bVar;
            return this;
        }

        public Builder C(int i10, int i11, gf.a aVar) {
            this.f16234d = i10;
            this.f16235e = i11;
            this.f16236f = aVar;
            return this;
        }

        public Builder D(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.f16249s != null) {
                d.i(f16229y, new Object[0]);
            }
            this.f16247q = i10;
            return this;
        }

        public Builder E(we.a aVar) {
            if (this.f16249s != null) {
                d.i(f16230z, new Object[0]);
            }
            this.f16250t = aVar;
            return this;
        }

        public Builder F(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.f16249s != null) {
                d.i(f16229y, new Object[0]);
            }
            this.f16246p = i10;
            return this;
        }

        public Builder G(cf.b bVar) {
            this.f16252v = bVar;
            return this;
        }

        public Builder H(ImageDownloader imageDownloader) {
            this.f16251u = imageDownloader;
            return this;
        }

        public final void I() {
            if (this.f16237g == null) {
                this.f16237g = ze.a.c(this.f16241k, this.f16242l, this.f16244n);
            } else {
                this.f16239i = true;
            }
            if (this.f16238h == null) {
                this.f16238h = ze.a.c(this.f16241k, this.f16242l, this.f16244n);
            } else {
                this.f16240j = true;
            }
            if (this.f16249s == null) {
                if (this.f16250t == null) {
                    this.f16250t = ze.a.d();
                }
                this.f16249s = ze.a.b(this.f16231a, this.f16250t, this.f16246p, this.f16247q);
            }
            if (this.f16248r == null) {
                this.f16248r = ze.a.g(this.f16245o);
            }
            if (this.f16243m) {
                this.f16248r = new ye.b(this.f16248r, e.a());
            }
            if (this.f16251u == null) {
                this.f16251u = ze.a.f(this.f16231a);
            }
            if (this.f16252v == null) {
                this.f16252v = ze.a.e(this.f16254x);
            }
            if (this.f16253w == null) {
                this.f16253w = com.nostra13.universalimageloader.core.a.t();
            }
        }

        public Builder J(xe.c cVar) {
            if (this.f16245o != 0) {
                d.i(A, new Object[0]);
            }
            this.f16248r = cVar;
            return this;
        }

        public Builder K(int i10, int i11) {
            this.f16232b = i10;
            this.f16233c = i11;
            return this;
        }

        public Builder L(int i10) {
            if (i10 <= 0) {
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.f16248r != null) {
                d.i(A, new Object[0]);
            }
            this.f16245o = i10;
            return this;
        }

        public Builder M(int i10) {
            if (i10 <= 0 || i10 >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.f16248r != null) {
                d.i(A, new Object[0]);
            }
            this.f16245o = (int) (Runtime.getRuntime().maxMemory() * (i10 / 100.0f));
            return this;
        }

        public Builder N(Executor executor) {
            if (this.f16241k != 3 || this.f16242l != 4 || this.f16244n != E) {
                d.i(B, new Object[0]);
            }
            this.f16237g = executor;
            return this;
        }

        public Builder O(Executor executor) {
            if (this.f16241k != 3 || this.f16242l != 4 || this.f16244n != E) {
                d.i(B, new Object[0]);
            }
            this.f16238h = executor;
            return this;
        }

        public Builder P(QueueProcessingType queueProcessingType) {
            if (this.f16237g != null || this.f16238h != null) {
                d.i(B, new Object[0]);
            }
            this.f16244n = queueProcessingType;
            return this;
        }

        public Builder Q(int i10) {
            if (this.f16237g != null || this.f16238h != null) {
                d.i(B, new Object[0]);
            }
            this.f16241k = i10;
            return this;
        }

        public Builder R(int i10) {
            if (this.f16237g != null || this.f16238h != null) {
                d.i(B, new Object[0]);
            }
            if (i10 < 1) {
                this.f16242l = 1;
            } else if (i10 > 10) {
                this.f16242l = 10;
            } else {
                this.f16242l = i10;
            }
            return this;
        }

        public Builder S() {
            this.f16254x = true;
            return this;
        }

        public ImageLoaderConfiguration t() {
            I();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder u(com.nostra13.universalimageloader.core.a aVar) {
            this.f16253w = aVar;
            return this;
        }

        public Builder v() {
            this.f16243m = true;
            return this;
        }

        @Deprecated
        public Builder w(te.b bVar) {
            return B(bVar);
        }

        @Deprecated
        public Builder x(int i10, int i11, gf.a aVar) {
            return C(i10, i11, aVar);
        }

        @Deprecated
        public Builder y(int i10) {
            return D(i10);
        }

        @Deprecated
        public Builder z(we.a aVar) {
            return E(aVar);
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16255a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            f16255a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16255a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b implements ImageDownloader {

        /* renamed from: a */
        public final ImageDownloader f16256a;

        public b(ImageDownloader imageDownloader) {
            this.f16256a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            int i10 = a.f16255a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i10 == 1 || i10 == 2) {
                throw new IllegalStateException();
            }
            return this.f16256a.getStream(str, obj);
        }
    }

    public static class c implements ImageDownloader {

        /* renamed from: a */
        public final ImageDownloader f16257a;

        public c(ImageDownloader imageDownloader) {
            this.f16257a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            InputStream stream = this.f16257a.getStream(str, obj);
            int i10 = a.f16255a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            return (i10 == 1 || i10 == 2) ? new af.b(stream) : stream;
        }
    }

    public /* synthetic */ ImageLoaderConfiguration(Builder builder, a aVar) {
        this(builder);
    }

    public static ImageLoaderConfiguration a(Context context) {
        return new Builder(context).t();
    }

    public af.c b() {
        DisplayMetrics displayMetrics = this.f16209a.getDisplayMetrics();
        int i10 = this.f16210b;
        if (i10 <= 0) {
            i10 = displayMetrics.widthPixels;
        }
        int i11 = this.f16211c;
        if (i11 <= 0) {
            i11 = displayMetrics.heightPixels;
        }
        return new af.c(i10, i11);
    }

    public ImageLoaderConfiguration(Builder builder) {
        this.f16209a = builder.f16231a.getResources();
        this.f16210b = builder.f16232b;
        this.f16211c = builder.f16233c;
        this.f16212d = builder.f16234d;
        this.f16213e = builder.f16235e;
        this.f16214f = builder.f16236f;
        this.f16215g = builder.f16237g;
        this.f16216h = builder.f16238h;
        this.f16219k = builder.f16241k;
        this.f16220l = builder.f16242l;
        this.f16221m = builder.f16244n;
        this.f16223o = builder.f16249s;
        this.f16222n = builder.f16248r;
        this.f16226r = builder.f16253w;
        ImageDownloader imageDownloader = builder.f16251u;
        this.f16224p = imageDownloader;
        this.f16225q = builder.f16252v;
        this.f16217i = builder.f16239i;
        this.f16218j = builder.f16240j;
        this.f16227s = new b(imageDownloader);
        this.f16228t = new c(imageDownloader);
        d.j(builder.f16254x);
    }
}
