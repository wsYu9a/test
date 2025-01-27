package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private final int f15940a;

    /* renamed from: b */
    private final int f15941b;

    /* renamed from: c */
    private final int f15942c;

    /* renamed from: d */
    private final Drawable f15943d;

    /* renamed from: e */
    private final Drawable f15944e;

    /* renamed from: f */
    private final Drawable f15945f;

    /* renamed from: g */
    private final boolean f15946g;

    /* renamed from: h */
    private final boolean f15947h;

    /* renamed from: i */
    private final boolean f15948i;

    /* renamed from: j */
    private final ImageScaleType f15949j;
    private final BitmapFactory.Options k;
    private final int l;
    private final boolean m;
    private final Object n;
    private final com.nostra13.universalimageloader.core.l.a o;
    private final com.nostra13.universalimageloader.core.l.a p;
    private final com.nostra13.universalimageloader.core.i.a q;
    private final Handler r;
    private final boolean s;

    public static class b {

        /* renamed from: a */
        private int f15950a = 0;

        /* renamed from: b */
        private int f15951b = 0;

        /* renamed from: c */
        private int f15952c = 0;

        /* renamed from: d */
        private Drawable f15953d = null;

        /* renamed from: e */
        private Drawable f15954e = null;

        /* renamed from: f */
        private Drawable f15955f = null;

        /* renamed from: g */
        private boolean f15956g = false;

        /* renamed from: h */
        private boolean f15957h = false;

        /* renamed from: i */
        private boolean f15958i = false;

        /* renamed from: j */
        private ImageScaleType f15959j = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        private BitmapFactory.Options k = new BitmapFactory.Options();
        private int l = 0;
        private boolean m = false;
        private Object n = null;
        private com.nostra13.universalimageloader.core.l.a o = null;
        private com.nostra13.universalimageloader.core.l.a p = null;
        private com.nostra13.universalimageloader.core.i.a q = com.nostra13.universalimageloader.core.a.a();
        private Handler r = null;
        private boolean s = false;

        public b() {
            BitmapFactory.Options options = this.k;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }

        public b A(c cVar) {
            this.f15950a = cVar.f15940a;
            this.f15951b = cVar.f15941b;
            this.f15952c = cVar.f15942c;
            this.f15953d = cVar.f15943d;
            this.f15954e = cVar.f15944e;
            this.f15955f = cVar.f15945f;
            this.f15956g = cVar.f15946g;
            this.f15957h = cVar.f15947h;
            this.f15958i = cVar.f15948i;
            this.f15959j = cVar.f15949j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.q = cVar.q;
            this.r = cVar.r;
            this.s = cVar.s;
            return this;
        }

        public b B(boolean z) {
            this.m = z;
            return this;
        }

        public b C(BitmapFactory.Options options) {
            if (options == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.k = options;
            return this;
        }

        public b D(int i2) {
            this.l = i2;
            return this;
        }

        public b E(com.nostra13.universalimageloader.core.i.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.q = aVar;
            return this;
        }

        public b F(Object obj) {
            this.n = obj;
            return this;
        }

        public b G(Handler handler) {
            this.r = handler;
            return this;
        }

        public b H(ImageScaleType imageScaleType) {
            this.f15959j = imageScaleType;
            return this;
        }

        public b I(com.nostra13.universalimageloader.core.l.a aVar) {
            this.p = aVar;
            return this;
        }

        public b J(com.nostra13.universalimageloader.core.l.a aVar) {
            this.o = aVar;
            return this;
        }

        public b K() {
            this.f15956g = true;
            return this;
        }

        public b L(boolean z) {
            this.f15956g = z;
            return this;
        }

        public b M(int i2) {
            this.f15951b = i2;
            return this;
        }

        public b N(Drawable drawable) {
            this.f15954e = drawable;
            return this;
        }

        public b O(int i2) {
            this.f15952c = i2;
            return this;
        }

        public b P(Drawable drawable) {
            this.f15955f = drawable;
            return this;
        }

        public b Q(int i2) {
            this.f15950a = i2;
            return this;
        }

        public b R(Drawable drawable) {
            this.f15953d = drawable;
            return this;
        }

        @Deprecated
        public b S(int i2) {
            this.f15950a = i2;
            return this;
        }

        b T(boolean z) {
            this.s = z;
            return this;
        }

        public b t(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.k.inPreferredConfig = config;
            return this;
        }

        public c u() {
            return new c(this);
        }

        @Deprecated
        public b v() {
            this.f15957h = true;
            return this;
        }

        public b w(boolean z) {
            this.f15957h = z;
            return this;
        }

        @Deprecated
        public b x() {
            return z(true);
        }

        @Deprecated
        public b y(boolean z) {
            return z(z);
        }

        public b z(boolean z) {
            this.f15958i = z;
            return this;
        }
    }

    /* synthetic */ c(b bVar, a aVar) {
        this(bVar);
    }

    public static c t() {
        return new b().u();
    }

    public Drawable A(Resources resources) {
        int i2 = this.f15942c;
        return i2 != 0 ? resources.getDrawable(i2) : this.f15945f;
    }

    public Drawable B(Resources resources) {
        int i2 = this.f15940a;
        return i2 != 0 ? resources.getDrawable(i2) : this.f15943d;
    }

    public ImageScaleType C() {
        return this.f15949j;
    }

    public com.nostra13.universalimageloader.core.l.a D() {
        return this.p;
    }

    public com.nostra13.universalimageloader.core.l.a E() {
        return this.o;
    }

    public boolean F() {
        return this.f15947h;
    }

    public boolean G() {
        return this.f15948i;
    }

    public boolean H() {
        return this.m;
    }

    public boolean I() {
        return this.f15946g;
    }

    boolean J() {
        return this.s;
    }

    public boolean K() {
        return this.l > 0;
    }

    public boolean L() {
        return this.p != null;
    }

    public boolean M() {
        return this.o != null;
    }

    public boolean N() {
        return (this.f15944e == null && this.f15941b == 0) ? false : true;
    }

    public boolean O() {
        return (this.f15945f == null && this.f15942c == 0) ? false : true;
    }

    public boolean P() {
        return (this.f15943d == null && this.f15940a == 0) ? false : true;
    }

    public BitmapFactory.Options u() {
        return this.k;
    }

    public int v() {
        return this.l;
    }

    public com.nostra13.universalimageloader.core.i.a w() {
        return this.q;
    }

    public Object x() {
        return this.n;
    }

    public Handler y() {
        return this.r;
    }

    public Drawable z(Resources resources) {
        int i2 = this.f15941b;
        return i2 != 0 ? resources.getDrawable(i2) : this.f15944e;
    }

    private c(b bVar) {
        this.f15940a = bVar.f15950a;
        this.f15941b = bVar.f15951b;
        this.f15942c = bVar.f15952c;
        this.f15943d = bVar.f15953d;
        this.f15944e = bVar.f15954e;
        this.f15945f = bVar.f15955f;
        this.f15946g = bVar.f15956g;
        this.f15947h = bVar.f15957h;
        this.f15948i = bVar.f15958i;
        this.f15949j = bVar.f15959j;
        this.k = bVar.k;
        this.l = bVar.l;
        this.m = bVar.m;
        this.n = bVar.n;
        this.o = bVar.o;
        this.p = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
    }
}
