package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    public final int f16290a;

    /* renamed from: b */
    public final int f16291b;

    /* renamed from: c */
    public final int f16292c;

    /* renamed from: d */
    public final Drawable f16293d;

    /* renamed from: e */
    public final Drawable f16294e;

    /* renamed from: f */
    public final Drawable f16295f;

    /* renamed from: g */
    public final boolean f16296g;

    /* renamed from: h */
    public final boolean f16297h;

    /* renamed from: i */
    public final boolean f16298i;

    /* renamed from: j */
    public final ImageScaleType f16299j;

    /* renamed from: k */
    public final BitmapFactory.Options f16300k;

    /* renamed from: l */
    public final int f16301l;

    /* renamed from: m */
    public final boolean f16302m;

    /* renamed from: n */
    public final Object f16303n;

    /* renamed from: o */
    public final gf.a f16304o;

    /* renamed from: p */
    public final gf.a f16305p;

    /* renamed from: q */
    public final df.a f16306q;

    /* renamed from: r */
    public final Handler f16307r;

    /* renamed from: s */
    public final boolean f16308s;

    public static class b {

        /* renamed from: a */
        public int f16309a = 0;

        /* renamed from: b */
        public int f16310b = 0;

        /* renamed from: c */
        public int f16311c = 0;

        /* renamed from: d */
        public Drawable f16312d = null;

        /* renamed from: e */
        public Drawable f16313e = null;

        /* renamed from: f */
        public Drawable f16314f = null;

        /* renamed from: g */
        public boolean f16315g = false;

        /* renamed from: h */
        public boolean f16316h = false;

        /* renamed from: i */
        public boolean f16317i = false;

        /* renamed from: j */
        public ImageScaleType f16318j = ImageScaleType.IN_SAMPLE_POWER_OF_2;

        /* renamed from: k */
        public BitmapFactory.Options f16319k = new BitmapFactory.Options();

        /* renamed from: l */
        public int f16320l = 0;

        /* renamed from: m */
        public boolean f16321m = false;

        /* renamed from: n */
        public Object f16322n = null;

        /* renamed from: o */
        public gf.a f16323o = null;

        /* renamed from: p */
        public gf.a f16324p = null;

        /* renamed from: q */
        public df.a f16325q = ze.a.a();

        /* renamed from: r */
        public Handler f16326r = null;

        /* renamed from: s */
        public boolean f16327s = false;

        public b() {
            BitmapFactory.Options options = this.f16319k;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }

        public b A(a aVar) {
            this.f16309a = aVar.f16290a;
            this.f16310b = aVar.f16291b;
            this.f16311c = aVar.f16292c;
            this.f16312d = aVar.f16293d;
            this.f16313e = aVar.f16294e;
            this.f16314f = aVar.f16295f;
            this.f16315g = aVar.f16296g;
            this.f16316h = aVar.f16297h;
            this.f16317i = aVar.f16298i;
            this.f16318j = aVar.f16299j;
            this.f16319k = aVar.f16300k;
            this.f16320l = aVar.f16301l;
            this.f16321m = aVar.f16302m;
            this.f16322n = aVar.f16303n;
            this.f16323o = aVar.f16304o;
            this.f16324p = aVar.f16305p;
            this.f16325q = aVar.f16306q;
            this.f16326r = aVar.f16307r;
            this.f16327s = aVar.f16308s;
            return this;
        }

        public b B(boolean z10) {
            this.f16321m = z10;
            return this;
        }

        public b C(BitmapFactory.Options options) {
            if (options == null) {
                throw new IllegalArgumentException("decodingOptions can't be null");
            }
            this.f16319k = options;
            return this;
        }

        public b D(int i10) {
            this.f16320l = i10;
            return this;
        }

        public b E(df.a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("displayer can't be null");
            }
            this.f16325q = aVar;
            return this;
        }

        public b F(Object obj) {
            this.f16322n = obj;
            return this;
        }

        public b G(Handler handler) {
            this.f16326r = handler;
            return this;
        }

        public b H(ImageScaleType imageScaleType) {
            this.f16318j = imageScaleType;
            return this;
        }

        public b I(gf.a aVar) {
            this.f16324p = aVar;
            return this;
        }

        public b J(gf.a aVar) {
            this.f16323o = aVar;
            return this;
        }

        public b K() {
            this.f16315g = true;
            return this;
        }

        public b L(boolean z10) {
            this.f16315g = z10;
            return this;
        }

        public b M(int i10) {
            this.f16310b = i10;
            return this;
        }

        public b N(Drawable drawable) {
            this.f16313e = drawable;
            return this;
        }

        public b O(int i10) {
            this.f16311c = i10;
            return this;
        }

        public b P(Drawable drawable) {
            this.f16314f = drawable;
            return this;
        }

        public b Q(int i10) {
            this.f16309a = i10;
            return this;
        }

        public b R(Drawable drawable) {
            this.f16312d = drawable;
            return this;
        }

        @Deprecated
        public b S(int i10) {
            this.f16309a = i10;
            return this;
        }

        public b T(boolean z10) {
            this.f16327s = z10;
            return this;
        }

        public b t(Bitmap.Config config) {
            if (config == null) {
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }
            this.f16319k.inPreferredConfig = config;
            return this;
        }

        public a u() {
            return new a(this);
        }

        @Deprecated
        public b v() {
            this.f16316h = true;
            return this;
        }

        public b w(boolean z10) {
            this.f16316h = z10;
            return this;
        }

        @Deprecated
        public b x() {
            return z(true);
        }

        @Deprecated
        public b y(boolean z10) {
            return z(z10);
        }

        public b z(boolean z10) {
            this.f16317i = z10;
            return this;
        }
    }

    public /* synthetic */ a(b bVar, C0544a c0544a) {
        this(bVar);
    }

    public static a t() {
        return new b().u();
    }

    public Drawable A(Resources resources) {
        int i10 = this.f16292c;
        return i10 != 0 ? resources.getDrawable(i10) : this.f16295f;
    }

    public Drawable B(Resources resources) {
        int i10 = this.f16290a;
        return i10 != 0 ? resources.getDrawable(i10) : this.f16293d;
    }

    public ImageScaleType C() {
        return this.f16299j;
    }

    public gf.a D() {
        return this.f16305p;
    }

    public gf.a E() {
        return this.f16304o;
    }

    public boolean F() {
        return this.f16297h;
    }

    public boolean G() {
        return this.f16298i;
    }

    public boolean H() {
        return this.f16302m;
    }

    public boolean I() {
        return this.f16296g;
    }

    public boolean J() {
        return this.f16308s;
    }

    public boolean K() {
        return this.f16301l > 0;
    }

    public boolean L() {
        return this.f16305p != null;
    }

    public boolean M() {
        return this.f16304o != null;
    }

    public boolean N() {
        return (this.f16294e == null && this.f16291b == 0) ? false : true;
    }

    public boolean O() {
        return (this.f16295f == null && this.f16292c == 0) ? false : true;
    }

    public boolean P() {
        return (this.f16293d == null && this.f16290a == 0) ? false : true;
    }

    public BitmapFactory.Options u() {
        return this.f16300k;
    }

    public int v() {
        return this.f16301l;
    }

    public df.a w() {
        return this.f16306q;
    }

    public Object x() {
        return this.f16303n;
    }

    public Handler y() {
        return this.f16307r;
    }

    public Drawable z(Resources resources) {
        int i10 = this.f16291b;
        return i10 != 0 ? resources.getDrawable(i10) : this.f16294e;
    }

    public a(b bVar) {
        this.f16290a = bVar.f16309a;
        this.f16291b = bVar.f16310b;
        this.f16292c = bVar.f16311c;
        this.f16293d = bVar.f16312d;
        this.f16294e = bVar.f16313e;
        this.f16295f = bVar.f16314f;
        this.f16296g = bVar.f16315g;
        this.f16297h = bVar.f16316h;
        this.f16298i = bVar.f16317i;
        this.f16299j = bVar.f16318j;
        this.f16300k = bVar.f16319k;
        this.f16301l = bVar.f16320l;
        this.f16302m = bVar.f16321m;
        this.f16303n = bVar.f16322n;
        this.f16304o = bVar.f16323o;
        this.f16305p = bVar.f16324p;
        this.f16306q = bVar.f16325q;
        this.f16307r = bVar.f16326r;
        this.f16308s = bVar.f16327s;
    }
}
