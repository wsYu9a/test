package com.google.android.material.j;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a */
    public static final d f7439a = new m(0.5f);

    /* renamed from: b */
    e f7440b;

    /* renamed from: c */
    e f7441c;

    /* renamed from: d */
    e f7442d;

    /* renamed from: e */
    e f7443e;

    /* renamed from: f */
    d f7444f;

    /* renamed from: g */
    d f7445g;

    /* renamed from: h */
    d f7446h;

    /* renamed from: i */
    d f7447i;

    /* renamed from: j */
    g f7448j;
    g k;
    g l;
    g m;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface c {
        @NonNull
        d a(@NonNull d dVar);
    }

    /* synthetic */ o(b bVar, a aVar) {
        this(bVar);
    }

    @NonNull
    public static b a() {
        return new b();
    }

    @NonNull
    public static b b(Context context, @StyleRes int i2, @StyleRes int i3) {
        return c(context, i2, i3, 0);
    }

    @NonNull
    private static b c(Context context, @StyleRes int i2, @StyleRes int i3, int i4) {
        return d(context, i2, i3, new com.google.android.material.j.a(i4));
    }

    @NonNull
    private static b d(Context context, @StyleRes int i2, @StyleRes int i3, @NonNull d dVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            d m = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, dVar);
            d m2 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, m);
            d m3 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, m);
            d m4 = m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, m);
            return new b().I(i5, m2).N(i6, m3).A(i7, m4).v(i8, m(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, m));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        return f(context, attributeSet, i2, i3, 0);
    }

    @NonNull
    public static b f(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, int i4) {
        return g(context, attributeSet, i2, i3, new com.google.android.material.j.a(i4));
    }

    @NonNull
    public static b g(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, @NonNull d dVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    @NonNull
    private static d m(TypedArray typedArray, int i2, @NonNull d dVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return dVar;
        }
        int i3 = peekValue.type;
        return i3 == 5 ? new com.google.android.material.j.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i3 == 6 ? new m(peekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    @NonNull
    public g h() {
        return this.l;
    }

    @NonNull
    public e i() {
        return this.f7443e;
    }

    @NonNull
    public d j() {
        return this.f7447i;
    }

    @NonNull
    public e k() {
        return this.f7442d;
    }

    @NonNull
    public d l() {
        return this.f7446h;
    }

    @NonNull
    public g n() {
        return this.m;
    }

    @NonNull
    public g o() {
        return this.k;
    }

    @NonNull
    public g p() {
        return this.f7448j;
    }

    @NonNull
    public e q() {
        return this.f7440b;
    }

    @NonNull
    public d r() {
        return this.f7444f;
    }

    @NonNull
    public e s() {
        return this.f7441c;
    }

    @NonNull
    public d t() {
        return this.f7445g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u(@NonNull RectF rectF) {
        boolean z = this.m.getClass().equals(g.class) && this.k.getClass().equals(g.class) && this.f7448j.getClass().equals(g.class) && this.l.getClass().equals(g.class);
        float a2 = this.f7444f.a(rectF);
        return z && ((this.f7445g.a(rectF) > a2 ? 1 : (this.f7445g.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f7447i.a(rectF) > a2 ? 1 : (this.f7447i.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f7446h.a(rectF) > a2 ? 1 : (this.f7446h.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f7441c instanceof n) && (this.f7440b instanceof n) && (this.f7442d instanceof n) && (this.f7443e instanceof n));
    }

    @NonNull
    public b v() {
        return new b(this);
    }

    @NonNull
    public o w(float f2) {
        return v().o(f2).m();
    }

    @NonNull
    public o x(@NonNull d dVar) {
        return v().p(dVar).m();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public o y(@NonNull c cVar) {
        return v().L(cVar.a(r())).Q(cVar.a(t())).y(cVar.a(j())).D(cVar.a(l())).m();
    }

    private o(@NonNull b bVar) {
        this.f7440b = bVar.f7449a;
        this.f7441c = bVar.f7450b;
        this.f7442d = bVar.f7451c;
        this.f7443e = bVar.f7452d;
        this.f7444f = bVar.f7453e;
        this.f7445g = bVar.f7454f;
        this.f7446h = bVar.f7455g;
        this.f7447i = bVar.f7456h;
        this.f7448j = bVar.f7457i;
        this.k = bVar.f7458j;
        this.l = bVar.k;
        this.m = bVar.l;
    }

    public static final class b {

        /* renamed from: a */
        @NonNull
        private e f7449a;

        /* renamed from: b */
        @NonNull
        private e f7450b;

        /* renamed from: c */
        @NonNull
        private e f7451c;

        /* renamed from: d */
        @NonNull
        private e f7452d;

        /* renamed from: e */
        @NonNull
        private d f7453e;

        /* renamed from: f */
        @NonNull
        private d f7454f;

        /* renamed from: g */
        @NonNull
        private d f7455g;

        /* renamed from: h */
        @NonNull
        private d f7456h;

        /* renamed from: i */
        @NonNull
        private g f7457i;

        /* renamed from: j */
        @NonNull
        private g f7458j;

        @NonNull
        private g k;

        @NonNull
        private g l;

        public b() {
            this.f7449a = k.b();
            this.f7450b = k.b();
            this.f7451c = k.b();
            this.f7452d = k.b();
            this.f7453e = new com.google.android.material.j.a(0.0f);
            this.f7454f = new com.google.android.material.j.a(0.0f);
            this.f7455g = new com.google.android.material.j.a(0.0f);
            this.f7456h = new com.google.android.material.j.a(0.0f);
            this.f7457i = k.c();
            this.f7458j = k.c();
            this.k = k.c();
            this.l = k.c();
        }

        private static float n(e eVar) {
            if (eVar instanceof n) {
                return ((n) eVar).f7438a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f7403a;
            }
            return -1.0f;
        }

        @NonNull
        public b A(int i2, @NonNull d dVar) {
            return B(k.a(i2)).D(dVar);
        }

        @NonNull
        public b B(@NonNull e eVar) {
            this.f7451c = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                C(n);
            }
            return this;
        }

        @NonNull
        public b C(@Dimension float f2) {
            this.f7455g = new com.google.android.material.j.a(f2);
            return this;
        }

        @NonNull
        public b D(@NonNull d dVar) {
            this.f7455g = dVar;
            return this;
        }

        @NonNull
        public b E(@NonNull g gVar) {
            this.l = gVar;
            return this;
        }

        @NonNull
        public b F(@NonNull g gVar) {
            this.f7458j = gVar;
            return this;
        }

        @NonNull
        public b G(@NonNull g gVar) {
            this.f7457i = gVar;
            return this;
        }

        @NonNull
        public b H(int i2, @Dimension float f2) {
            return J(k.a(i2)).K(f2);
        }

        @NonNull
        public b I(int i2, @NonNull d dVar) {
            return J(k.a(i2)).L(dVar);
        }

        @NonNull
        public b J(@NonNull e eVar) {
            this.f7449a = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                K(n);
            }
            return this;
        }

        @NonNull
        public b K(@Dimension float f2) {
            this.f7453e = new com.google.android.material.j.a(f2);
            return this;
        }

        @NonNull
        public b L(@NonNull d dVar) {
            this.f7453e = dVar;
            return this;
        }

        @NonNull
        public b M(int i2, @Dimension float f2) {
            return O(k.a(i2)).P(f2);
        }

        @NonNull
        public b N(int i2, @NonNull d dVar) {
            return O(k.a(i2)).Q(dVar);
        }

        @NonNull
        public b O(@NonNull e eVar) {
            this.f7450b = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                P(n);
            }
            return this;
        }

        @NonNull
        public b P(@Dimension float f2) {
            this.f7454f = new com.google.android.material.j.a(f2);
            return this;
        }

        @NonNull
        public b Q(@NonNull d dVar) {
            this.f7454f = dVar;
            return this;
        }

        @NonNull
        public o m() {
            return new o(this);
        }

        @NonNull
        public b o(@Dimension float f2) {
            return K(f2).P(f2).C(f2).x(f2);
        }

        @NonNull
        public b p(@NonNull d dVar) {
            return L(dVar).Q(dVar).D(dVar).y(dVar);
        }

        @NonNull
        public b q(int i2, @Dimension float f2) {
            return r(k.a(i2)).o(f2);
        }

        @NonNull
        public b r(@NonNull e eVar) {
            return J(eVar).O(eVar).B(eVar).w(eVar);
        }

        @NonNull
        public b s(@NonNull g gVar) {
            return E(gVar).G(gVar).F(gVar).t(gVar);
        }

        @NonNull
        public b t(@NonNull g gVar) {
            this.k = gVar;
            return this;
        }

        @NonNull
        public b u(int i2, @Dimension float f2) {
            return w(k.a(i2)).x(f2);
        }

        @NonNull
        public b v(int i2, @NonNull d dVar) {
            return w(k.a(i2)).y(dVar);
        }

        @NonNull
        public b w(@NonNull e eVar) {
            this.f7452d = eVar;
            float n = n(eVar);
            if (n != -1.0f) {
                x(n);
            }
            return this;
        }

        @NonNull
        public b x(@Dimension float f2) {
            this.f7456h = new com.google.android.material.j.a(f2);
            return this;
        }

        @NonNull
        public b y(@NonNull d dVar) {
            this.f7456h = dVar;
            return this;
        }

        @NonNull
        public b z(int i2, @Dimension float f2) {
            return B(k.a(i2)).C(f2);
        }

        public b(@NonNull o oVar) {
            this.f7449a = k.b();
            this.f7450b = k.b();
            this.f7451c = k.b();
            this.f7452d = k.b();
            this.f7453e = new com.google.android.material.j.a(0.0f);
            this.f7454f = new com.google.android.material.j.a(0.0f);
            this.f7455g = new com.google.android.material.j.a(0.0f);
            this.f7456h = new com.google.android.material.j.a(0.0f);
            this.f7457i = k.c();
            this.f7458j = k.c();
            this.k = k.c();
            this.l = k.c();
            this.f7449a = oVar.f7440b;
            this.f7450b = oVar.f7441c;
            this.f7451c = oVar.f7442d;
            this.f7452d = oVar.f7443e;
            this.f7453e = oVar.f7444f;
            this.f7454f = oVar.f7445g;
            this.f7455g = oVar.f7446h;
            this.f7456h = oVar.f7447i;
            this.f7457i = oVar.f7448j;
            this.f7458j = oVar.k;
            this.k = oVar.l;
            this.l = oVar.m;
        }
    }

    public o() {
        this.f7440b = k.b();
        this.f7441c = k.b();
        this.f7442d = k.b();
        this.f7443e = k.b();
        this.f7444f = new com.google.android.material.j.a(0.0f);
        this.f7445g = new com.google.android.material.j.a(0.0f);
        this.f7446h = new com.google.android.material.j.a(0.0f);
        this.f7447i = new com.google.android.material.j.a(0.0f);
        this.f7448j = k.c();
        this.k = k.c();
        this.l = k.c();
        this.m = k.c();
    }
}
