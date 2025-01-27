package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class ImageLoaderConfiguration {

    /* renamed from: a */
    final Resources f15867a;

    /* renamed from: b */
    final int f15868b;

    /* renamed from: c */
    final int f15869c;

    /* renamed from: d */
    final int f15870d;

    /* renamed from: e */
    final int f15871e;

    /* renamed from: f */
    final com.nostra13.universalimageloader.core.l.a f15872f;

    /* renamed from: g */
    final Executor f15873g;

    /* renamed from: h */
    final Executor f15874h;

    /* renamed from: i */
    final boolean f15875i;

    /* renamed from: j */
    final boolean f15876j;
    final int k;
    final int l;
    final QueueProcessingType m;
    final b.g.a.a.b.c n;
    final b.g.a.a.a.b o;
    final ImageDownloader p;
    final com.nostra13.universalimageloader.core.h.b q;
    final com.nostra13.universalimageloader.core.c r;
    final ImageDownloader s;
    final ImageDownloader t;

    public static class Builder {

        /* renamed from: a */
        private static final String f15877a = "diskCache(), diskCacheSize() and diskCacheFileCount calls overlap each other";

        /* renamed from: b */
        private static final String f15878b = "diskCache() and diskCacheFileNameGenerator() calls overlap each other";

        /* renamed from: c */
        private static final String f15879c = "memoryCache() and memoryCacheSize() calls overlap each other";

        /* renamed from: d */
        private static final String f15880d = "threadPoolSize(), threadPriority() and tasksProcessingOrder() calls can overlap taskExecutor() and taskExecutorForCachedImages() calls.";

        /* renamed from: e */
        public static final int f15881e = 3;

        /* renamed from: f */
        public static final int f15882f = 4;

        /* renamed from: g */
        public static final QueueProcessingType f15883g = QueueProcessingType.FIFO;
        private com.nostra13.universalimageloader.core.h.b C;

        /* renamed from: h */
        private Context f15884h;

        /* renamed from: i */
        private int f15885i = 0;

        /* renamed from: j */
        private int f15886j = 0;
        private int k = 0;
        private int l = 0;
        private com.nostra13.universalimageloader.core.l.a m = null;
        private Executor n = null;
        private Executor o = null;
        private boolean p = false;
        private boolean q = false;
        private int r = 3;
        private int s = 4;
        private boolean t = false;
        private QueueProcessingType u = f15883g;
        private int v = 0;
        private long w = 0;
        private int x = 0;
        private b.g.a.a.b.c y = null;
        private b.g.a.a.a.b z = null;
        private b.g.a.a.a.d.a A = null;
        private ImageDownloader B = null;
        private com.nostra13.universalimageloader.core.c D = null;
        private boolean E = false;

        public Builder(Context context) {
            this.f15884h = context.getApplicationContext();
        }

        private void I() {
            if (this.n == null) {
                this.n = com.nostra13.universalimageloader.core.a.c(this.r, this.s, this.u);
            } else {
                this.p = true;
            }
            if (this.o == null) {
                this.o = com.nostra13.universalimageloader.core.a.c(this.r, this.s, this.u);
            } else {
                this.q = true;
            }
            if (this.z == null) {
                if (this.A == null) {
                    this.A = com.nostra13.universalimageloader.core.a.d();
                }
                this.z = com.nostra13.universalimageloader.core.a.b(this.f15884h, this.A, this.w, this.x);
            }
            if (this.y == null) {
                this.y = com.nostra13.universalimageloader.core.a.g(this.v);
            }
            if (this.t) {
                this.y = new b.g.a.a.b.e.b(this.y, b.g.a.b.e.a());
            }
            if (this.B == null) {
                this.B = com.nostra13.universalimageloader.core.a.f(this.f15884h);
            }
            if (this.C == null) {
                this.C = com.nostra13.universalimageloader.core.a.e(this.E);
            }
            if (this.D == null) {
                this.D = com.nostra13.universalimageloader.core.c.t();
            }
        }

        @Deprecated
        public Builder A(int i2) {
            return F(i2);
        }

        public Builder B(b.g.a.a.a.b bVar) {
            if (this.w > 0 || this.x > 0) {
                b.g.a.b.d.i(f15877a, new Object[0]);
            }
            if (this.A != null) {
                b.g.a.b.d.i(f15878b, new Object[0]);
            }
            this.z = bVar;
            return this;
        }

        public Builder C(int i2, int i3, com.nostra13.universalimageloader.core.l.a aVar) {
            this.k = i2;
            this.l = i3;
            this.m = aVar;
            return this;
        }

        public Builder D(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("maxFileCount must be a positive number");
            }
            if (this.z != null) {
                b.g.a.b.d.i(f15877a, new Object[0]);
            }
            this.x = i2;
            return this;
        }

        public Builder E(b.g.a.a.a.d.a aVar) {
            if (this.z != null) {
                b.g.a.b.d.i(f15878b, new Object[0]);
            }
            this.A = aVar;
            return this;
        }

        public Builder F(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("maxCacheSize must be a positive number");
            }
            if (this.z != null) {
                b.g.a.b.d.i(f15877a, new Object[0]);
            }
            this.w = i2;
            return this;
        }

        public Builder G(com.nostra13.universalimageloader.core.h.b bVar) {
            this.C = bVar;
            return this;
        }

        public Builder H(ImageDownloader imageDownloader) {
            this.B = imageDownloader;
            return this;
        }

        public Builder J(b.g.a.a.b.c cVar) {
            if (this.v != 0) {
                b.g.a.b.d.i(f15879c, new Object[0]);
            }
            this.y = cVar;
            return this;
        }

        public Builder K(int i2, int i3) {
            this.f15885i = i2;
            this.f15886j = i3;
            return this;
        }

        public Builder L(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("memoryCacheSize must be a positive number");
            }
            if (this.y != null) {
                b.g.a.b.d.i(f15879c, new Object[0]);
            }
            this.v = i2;
            return this;
        }

        public Builder M(int i2) {
            if (i2 <= 0 || i2 >= 100) {
                throw new IllegalArgumentException("availableMemoryPercent must be in range (0 < % < 100)");
            }
            if (this.y != null) {
                b.g.a.b.d.i(f15879c, new Object[0]);
            }
            this.v = (int) (Runtime.getRuntime().maxMemory() * (i2 / 100.0f));
            return this;
        }

        public Builder N(Executor executor) {
            if (this.r != 3 || this.s != 4 || this.u != f15883g) {
                b.g.a.b.d.i(f15880d, new Object[0]);
            }
            this.n = executor;
            return this;
        }

        public Builder O(Executor executor) {
            if (this.r != 3 || this.s != 4 || this.u != f15883g) {
                b.g.a.b.d.i(f15880d, new Object[0]);
            }
            this.o = executor;
            return this;
        }

        public Builder P(QueueProcessingType queueProcessingType) {
            if (this.n != null || this.o != null) {
                b.g.a.b.d.i(f15880d, new Object[0]);
            }
            this.u = queueProcessingType;
            return this;
        }

        public Builder Q(int i2) {
            if (this.n != null || this.o != null) {
                b.g.a.b.d.i(f15880d, new Object[0]);
            }
            this.r = i2;
            return this;
        }

        public Builder R(int i2) {
            if (this.n != null || this.o != null) {
                b.g.a.b.d.i(f15880d, new Object[0]);
            }
            if (i2 < 1) {
                this.s = 1;
            } else if (i2 > 10) {
                this.s = 10;
            } else {
                this.s = i2;
            }
            return this;
        }

        public Builder S() {
            this.E = true;
            return this;
        }

        public ImageLoaderConfiguration t() {
            I();
            return new ImageLoaderConfiguration(this, null);
        }

        public Builder u(com.nostra13.universalimageloader.core.c cVar) {
            this.D = cVar;
            return this;
        }

        public Builder v() {
            this.t = true;
            return this;
        }

        @Deprecated
        public Builder w(b.g.a.a.a.b bVar) {
            return B(bVar);
        }

        @Deprecated
        public Builder x(int i2, int i3, com.nostra13.universalimageloader.core.l.a aVar) {
            return C(i2, i3, aVar);
        }

        @Deprecated
        public Builder y(int i2) {
            return D(i2);
        }

        @Deprecated
        public Builder z(b.g.a.a.a.d.a aVar) {
            return E(aVar);
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f15887a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            f15887a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15887a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static class b implements ImageDownloader {

        /* renamed from: a */
        private final ImageDownloader f15888a;

        public b(ImageDownloader imageDownloader) {
            this.f15888a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            int i2 = a.f15887a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            if (i2 == 1 || i2 == 2) {
                throw new IllegalStateException();
            }
            return this.f15888a.getStream(str, obj);
        }
    }

    private static class c implements ImageDownloader {

        /* renamed from: a */
        private final ImageDownloader f15889a;

        public c(ImageDownloader imageDownloader) {
            this.f15889a = imageDownloader;
        }

        @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
        public InputStream getStream(String str, Object obj) throws IOException {
            InputStream stream = this.f15889a.getStream(str, obj);
            int i2 = a.f15887a[ImageDownloader.Scheme.ofUri(str).ordinal()];
            return (i2 == 1 || i2 == 2) ? new com.nostra13.universalimageloader.core.assist.b(stream) : stream;
        }
    }

    /* synthetic */ ImageLoaderConfiguration(Builder builder, a aVar) {
        this(builder);
    }

    public static ImageLoaderConfiguration a(Context context) {
        return new Builder(context).t();
    }

    com.nostra13.universalimageloader.core.assist.c b() {
        DisplayMetrics displayMetrics = this.f15867a.getDisplayMetrics();
        int i2 = this.f15868b;
        if (i2 <= 0) {
            i2 = displayMetrics.widthPixels;
        }
        int i3 = this.f15869c;
        if (i3 <= 0) {
            i3 = displayMetrics.heightPixels;
        }
        return new com.nostra13.universalimageloader.core.assist.c(i2, i3);
    }

    private ImageLoaderConfiguration(Builder builder) {
        this.f15867a = builder.f15884h.getResources();
        this.f15868b = builder.f15885i;
        this.f15869c = builder.f15886j;
        this.f15870d = builder.k;
        this.f15871e = builder.l;
        this.f15872f = builder.m;
        this.f15873g = builder.n;
        this.f15874h = builder.o;
        this.k = builder.r;
        this.l = builder.s;
        this.m = builder.u;
        this.o = builder.z;
        this.n = builder.y;
        this.r = builder.D;
        ImageDownloader imageDownloader = builder.B;
        this.p = imageDownloader;
        this.q = builder.C;
        this.f15875i = builder.p;
        this.f15876j = builder.q;
        this.s = new b(imageDownloader);
        this.t = new c(imageDownloader);
        b.g.a.b.d.j(builder.E);
    }
}
