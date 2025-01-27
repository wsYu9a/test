package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;

/* loaded from: classes.dex */
public interface c extends b.a {

    public static class b implements TypeEvaluator<e> {

        /* renamed from: a */
        public static final TypeEvaluator<e> f6964a = new b();

        /* renamed from: b */
        private final e f6965b = new e();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* renamed from: a */
        public e evaluate(float f2, @NonNull e eVar, @NonNull e eVar2) {
            this.f6965b.b(com.google.android.material.f.a.f(eVar.f6969b, eVar2.f6969b, f2), com.google.android.material.f.a.f(eVar.f6970c, eVar2.f6970c, f2), com.google.android.material.f.a.f(eVar.f6971d, eVar2.f6971d, f2));
            return this.f6965b;
        }
    }

    /* renamed from: com.google.android.material.circularreveal.c$c */
    public static class C0088c extends Property<c, e> {

        /* renamed from: a */
        public static final Property<c, e> f6966a = new C0088c("circularReveal");

        private C0088c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        /* renamed from: a */
        public e get(@NonNull c cVar) {
            return cVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull c cVar, @Nullable e eVar) {
            cVar.setRevealInfo(eVar);
        }
    }

    public static class d extends Property<c, Integer> {

        /* renamed from: a */
        public static final Property<c, Integer> f6967a = new d("circularRevealScrimColor");

        private d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a */
        public Integer get(@NonNull c cVar) {
            return Integer.valueOf(cVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(@NonNull c cVar, @NonNull Integer num) {
            cVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    public static class e {

        /* renamed from: a */
        public static final float f6968a = Float.MAX_VALUE;

        /* renamed from: b */
        public float f6969b;

        /* renamed from: c */
        public float f6970c;

        /* renamed from: d */
        public float f6971d;

        /* synthetic */ e(a aVar) {
            this();
        }

        public boolean a() {
            return this.f6971d == Float.MAX_VALUE;
        }

        public void b(float f2, float f3, float f4) {
            this.f6969b = f2;
            this.f6970c = f3;
            this.f6971d = f4;
        }

        public void c(@NonNull e eVar) {
            b(eVar.f6969b, eVar.f6970c, eVar.f6971d);
        }

        private e() {
        }

        public e(float f2, float f3, float f4) {
            this.f6969b = f2;
            this.f6970c = f3;
            this.f6971d = f4;
        }

        public e(@NonNull e eVar) {
            this(eVar.f6969b, eVar.f6970c, eVar.f6971d);
        }
    }

    void a();

    void b();

    void draw(Canvas canvas);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    e getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i2);

    void setRevealInfo(@Nullable e eVar);
}
