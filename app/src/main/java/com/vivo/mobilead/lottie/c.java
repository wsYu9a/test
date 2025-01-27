package com.vivo.mobilead.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.vivo.mobilead.lottie.e.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class c extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: c */
    private static final String f29129c = c.class.getSimpleName();

    /* renamed from: a */
    FontAssetDelegate f29130a;

    /* renamed from: b */
    TextDelegate f29131b;

    /* renamed from: d */
    private final Matrix f29132d = new Matrix();

    /* renamed from: e */
    private LottieComposition f29133e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.f.e f29134f;

    /* renamed from: g */
    private float f29135g;

    /* renamed from: h */
    private boolean f29136h;

    /* renamed from: i */
    private final Set<Object> f29137i;

    /* renamed from: j */
    private final ArrayList<a> f29138j;
    private com.vivo.mobilead.lottie.b.b k;
    private String l;
    private com.vivo.mobilead.lottie.a m;
    private com.vivo.mobilead.lottie.b.a n;
    private boolean o;
    private com.vivo.mobilead.lottie.c.c.b p;
    private int q;
    private boolean r;
    private boolean s;

    /* renamed from: com.vivo.mobilead.lottie.c$1 */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (c.this.p != null) {
                c.this.p.a(c.this.f29134f.d());
            }
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$10 */
    class AnonymousClass10 implements a {

        /* renamed from: a */
        final /* synthetic */ int f29140a;

        AnonymousClass10(int i2) {
            i2 = i2;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.a(i2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$11 */
    class AnonymousClass11 implements a {

        /* renamed from: a */
        final /* synthetic */ float f29142a;

        AnonymousClass11(float f2) {
            f2 = f2;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.a(f2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$12 */
    class AnonymousClass12 implements a {

        /* renamed from: a */
        final /* synthetic */ int f29144a;

        AnonymousClass12(int i2) {
            i2 = i2;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.b(i2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$13 */
    class AnonymousClass13 implements a {

        /* renamed from: a */
        final /* synthetic */ float f29146a;

        AnonymousClass13(float f2) {
            f2 = f2;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.b(f2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$14 */
    class AnonymousClass14 implements a {

        /* renamed from: a */
        final /* synthetic */ String f29148a;

        AnonymousClass14(String str) {
            str = str;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.b(str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$15 */
    class AnonymousClass15 implements a {

        /* renamed from: a */
        final /* synthetic */ String f29150a;

        AnonymousClass15(String str) {
            str = str;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.c(str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$2 */
    class AnonymousClass2 implements a {

        /* renamed from: a */
        final /* synthetic */ String f29152a;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.d(str);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$3 */
    class AnonymousClass3 implements a {

        /* renamed from: a */
        final /* synthetic */ int f29154a;

        /* renamed from: b */
        final /* synthetic */ int f29155b;

        AnonymousClass3(int i2, int i3) {
            i2 = i2;
            i3 = i3;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.a(i2, i3);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$4 */
    class AnonymousClass4 implements a {

        /* renamed from: a */
        final /* synthetic */ float f29157a;

        /* renamed from: b */
        final /* synthetic */ float f29158b;

        AnonymousClass4(float f2, float f3) {
            f2 = f2;
            f3 = f3;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.a(f2, f3);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$5 */
    class AnonymousClass5 implements a {

        /* renamed from: a */
        final /* synthetic */ int f29160a;

        AnonymousClass5(int i2) {
            i2 = i2;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.c(i2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$6 */
    class AnonymousClass6 implements a {

        /* renamed from: a */
        final /* synthetic */ float f29162a;

        AnonymousClass6(float f2) {
            f2 = f2;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.d(f2);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$7 */
    class AnonymousClass7 implements a {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.lottie.c.e f29164a;

        /* renamed from: b */
        final /* synthetic */ Object f29165b;

        /* renamed from: c */
        final /* synthetic */ com.vivo.mobilead.lottie.g.c f29166c;

        AnonymousClass7(com.vivo.mobilead.lottie.c.e eVar, Object obj, com.vivo.mobilead.lottie.g.c cVar) {
            eVar = eVar;
            t = obj;
            cVar = cVar;
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.a(eVar, t, cVar);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$8 */
    class AnonymousClass8 implements a {
        AnonymousClass8() {
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.h();
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.c$9 */
    class AnonymousClass9 implements a {
        AnonymousClass9() {
        }

        @Override // com.vivo.mobilead.lottie.c.a
        public void a(LottieComposition lottieComposition) {
            c.this.j();
        }
    }

    private interface a {
        void a(LottieComposition lottieComposition);
    }

    public c() {
        com.vivo.mobilead.lottie.f.e eVar = new com.vivo.mobilead.lottie.f.e();
        this.f29134f = eVar;
        this.f29135g = 1.0f;
        this.f29136h = true;
        this.f29137i = new HashSet();
        this.f29138j = new ArrayList<>();
        this.q = 255;
        this.s = false;
        eVar.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.vivo.mobilead.lottie.c.1
            AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.p != null) {
                    c.this.p.a(c.this.f29134f.d());
                }
            }
        });
    }

    private void B() {
        this.p = new com.vivo.mobilead.lottie.c.c.b(this, s.a(this.f29133e), this.f29133e.getLayers(), this.f29133e);
    }

    private void C() {
        if (this.f29133e == null) {
            return;
        }
        float w = w();
        setBounds(0, 0, (int) (this.f29133e.getBounds().width() * w), (int) (this.f29133e.getBounds().height() * w));
    }

    private com.vivo.mobilead.lottie.b.b D() {
        if (getCallback() == null) {
            return null;
        }
        com.vivo.mobilead.lottie.b.b bVar = this.k;
        if (bVar != null && !bVar.a(F())) {
            this.k = null;
        }
        if (this.k == null) {
            this.k = new com.vivo.mobilead.lottie.b.b(getCallback(), this.l, this.m, this.f29133e.getImages());
        }
        return this.k;
    }

    private com.vivo.mobilead.lottie.b.a E() {
        if (getCallback() == null) {
            return null;
        }
        if (this.n == null) {
            this.n = new com.vivo.mobilead.lottie.b.a(getCallback(), this.f29130a);
        }
        return this.n;
    }

    private Context F() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private float a(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f29133e.getBounds().width(), canvas.getHeight() / this.f29133e.getBounds().height());
    }

    public float A() {
        return this.f29134f.d();
    }

    public Bitmap a(String str, Bitmap bitmap) {
        com.vivo.mobilead.lottie.b.b D = D();
        if (D == null) {
            com.vivo.mobilead.lottie.f.d.b("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap a2 = D.a(str, bitmap);
        invalidateSelf();
        return a2;
    }

    public Typeface a(String str, String str2) {
        com.vivo.mobilead.lottie.b.a E = E();
        if (E != null) {
            return E.a(str, str2);
        }
        return null;
    }

    public List<com.vivo.mobilead.lottie.c.e> a(com.vivo.mobilead.lottie.c.e eVar) {
        if (this.p == null) {
            com.vivo.mobilead.lottie.f.d.b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.p.a(eVar, 0, arrayList, new com.vivo.mobilead.lottie.c.e(new String[0]));
        return arrayList;
    }

    public void a(float f2) {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.11

                /* renamed from: a */
                final /* synthetic */ float f29142a;

                AnonymousClass11(float f22) {
                    f2 = f22;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition2) {
                    c.this.a(f2);
                }
            });
        } else {
            a((int) com.vivo.mobilead.lottie.f.g.a(lottieComposition.getStartFrame(), this.f29133e.getEndFrame(), f22));
        }
    }

    public void a(float f2, float f3) {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.4

                /* renamed from: a */
                final /* synthetic */ float f29157a;

                /* renamed from: b */
                final /* synthetic */ float f29158b;

                AnonymousClass4(float f22, float f32) {
                    f2 = f22;
                    f3 = f32;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition2) {
                    c.this.a(f2, f3);
                }
            });
        } else {
            a((int) com.vivo.mobilead.lottie.f.g.a(lottieComposition.getStartFrame(), this.f29133e.getEndFrame(), f22), (int) com.vivo.mobilead.lottie.f.g.a(this.f29133e.getStartFrame(), this.f29133e.getEndFrame(), f32));
        }
    }

    public void a(int i2) {
        if (this.f29133e == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.10

                /* renamed from: a */
                final /* synthetic */ int f29140a;

                AnonymousClass10(int i22) {
                    i2 = i22;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition) {
                    c.this.a(i2);
                }
            });
        } else {
            this.f29134f.b(i22);
        }
    }

    public void a(int i2, int i3) {
        if (this.f29133e == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.3

                /* renamed from: a */
                final /* synthetic */ int f29154a;

                /* renamed from: b */
                final /* synthetic */ int f29155b;

                AnonymousClass3(int i22, int i32) {
                    i2 = i22;
                    i3 = i32;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition) {
                    c.this.a(i2, i3);
                }
            });
        } else {
            this.f29134f.a(i22, i32 + 0.99f);
        }
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.f29134f.addListener(animatorListener);
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f29134f.addUpdateListener(animatorUpdateListener);
    }

    public void a(FontAssetDelegate fontAssetDelegate) {
        this.f29130a = fontAssetDelegate;
        com.vivo.mobilead.lottie.b.a aVar = this.n;
        if (aVar != null) {
            aVar.a(fontAssetDelegate);
        }
    }

    public void a(TextDelegate textDelegate) {
        this.f29131b = textDelegate;
    }

    public void a(com.vivo.mobilead.lottie.a aVar) {
        this.m = aVar;
        com.vivo.mobilead.lottie.b.b bVar = this.k;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    public <T> void a(com.vivo.mobilead.lottie.c.e eVar, T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        if (this.p == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.7

                /* renamed from: a */
                final /* synthetic */ com.vivo.mobilead.lottie.c.e f29164a;

                /* renamed from: b */
                final /* synthetic */ Object f29165b;

                /* renamed from: c */
                final /* synthetic */ com.vivo.mobilead.lottie.g.c f29166c;

                AnonymousClass7(com.vivo.mobilead.lottie.c.e eVar2, Object t2, com.vivo.mobilead.lottie.g.c cVar2) {
                    eVar = eVar2;
                    t = t2;
                    cVar = cVar2;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition) {
                    c.this.a(eVar, t, cVar);
                }
            });
            return;
        }
        boolean z = true;
        if (eVar2.a() != null) {
            eVar2.a().a(t2, cVar2);
        } else {
            List<com.vivo.mobilead.lottie.c.e> a2 = a(eVar2);
            for (int i2 = 0; i2 < a2.size(); i2++) {
                a2.get(i2).a().a(t2, cVar2);
            }
            z = true ^ a2.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t2 == g.A) {
                d(A());
            }
        }
    }

    void a(Boolean bool) {
        this.f29136h = bool.booleanValue();
    }

    public void a(String str) {
        this.l = str;
    }

    public void a(boolean z) {
        if (this.o == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.vivo.mobilead.lottie.f.d.b("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.o = z;
        if (this.f29133e != null) {
            B();
        }
    }

    public boolean a() {
        com.vivo.mobilead.lottie.c.c.b bVar = this.p;
        return bVar != null && bVar.f();
    }

    public boolean a(LottieComposition lottieComposition) {
        if (this.f29133e == lottieComposition) {
            return false;
        }
        this.s = false;
        g();
        this.f29133e = lottieComposition;
        B();
        this.f29134f.a(lottieComposition);
        d(this.f29134f.getAnimatedFraction());
        e(this.f29135g);
        C();
        Iterator it = new ArrayList(this.f29138j).iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(lottieComposition);
            it.remove();
        }
        this.f29138j.clear();
        lottieComposition.setPerformanceTrackingEnabled(this.r);
        return true;
    }

    public void b(float f2) {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.13

                /* renamed from: a */
                final /* synthetic */ float f29146a;

                AnonymousClass13(float f22) {
                    f2 = f22;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition2) {
                    c.this.b(f2);
                }
            });
        } else {
            b((int) com.vivo.mobilead.lottie.f.g.a(lottieComposition.getStartFrame(), this.f29133e.getEndFrame(), f22));
        }
    }

    public void b(int i2) {
        if (this.f29133e == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.12

                /* renamed from: a */
                final /* synthetic */ int f29144a;

                AnonymousClass12(int i22) {
                    i2 = i22;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition) {
                    c.this.b(i2);
                }
            });
        } else {
            this.f29134f.a(i22 + 0.99f);
        }
    }

    public void b(Animator.AnimatorListener animatorListener) {
        this.f29134f.removeListener(animatorListener);
    }

    public void b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f29134f.removeUpdateListener(animatorUpdateListener);
    }

    public void b(String str) {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.14

                /* renamed from: a */
                final /* synthetic */ String f29148a;

                AnonymousClass14(String str2) {
                    str = str2;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition2) {
                    c.this.b(str);
                }
            });
            return;
        }
        com.vivo.mobilead.lottie.c.h marker = lottieComposition.getMarker(str2);
        if (marker != null) {
            a((int) marker.f29399a);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    public void b(boolean z) {
        this.r = z;
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(z);
        }
    }

    public boolean b() {
        com.vivo.mobilead.lottie.c.c.b bVar = this.p;
        return bVar != null && bVar.g();
    }

    public void c(float f2) {
        this.f29134f.b(f2);
    }

    public void c(int i2) {
        if (this.f29133e == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.5

                /* renamed from: a */
                final /* synthetic */ int f29160a;

                AnonymousClass5(int i22) {
                    i2 = i22;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition) {
                    c.this.c(i2);
                }
            });
        } else {
            this.f29134f.a(i22);
        }
    }

    public void c(String str) {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.15

                /* renamed from: a */
                final /* synthetic */ String f29150a;

                AnonymousClass15(String str2) {
                    str = str2;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition2) {
                    c.this.c(str);
                }
            });
            return;
        }
        com.vivo.mobilead.lottie.c.h marker = lottieComposition.getMarker(str2);
        if (marker != null) {
            b((int) (marker.f29399a + marker.f29400b));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
    }

    public boolean c() {
        return this.o;
    }

    public void d(float f2) {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.6

                /* renamed from: a */
                final /* synthetic */ float f29162a;

                AnonymousClass6(float f22) {
                    f2 = f22;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition2) {
                    c.this.d(f2);
                }
            });
        } else {
            c((int) com.vivo.mobilead.lottie.f.g.a(lottieComposition.getStartFrame(), this.f29133e.getEndFrame(), f22));
        }
    }

    public void d(int i2) {
        this.f29134f.setRepeatMode(i2);
    }

    public void d(String str) {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.2

                /* renamed from: a */
                final /* synthetic */ String f29152a;

                AnonymousClass2(String str2) {
                    str = str2;
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition2) {
                    c.this.d(str);
                }
            });
            return;
        }
        com.vivo.mobilead.lottie.c.h marker = lottieComposition.getMarker(str2);
        if (marker != null) {
            int i2 = (int) marker.f29399a;
            a(i2, ((int) marker.f29400b) + i2);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str2 + ".");
        }
    }

    public boolean d() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f2;
        this.s = false;
        b.a("Drawable#draw");
        if (this.p == null) {
            return;
        }
        float f3 = this.f29135g;
        float a2 = a(canvas);
        if (f3 > a2) {
            f2 = this.f29135g / a2;
        } else {
            a2 = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = this.f29133e.getBounds().width() / 2.0f;
            float height = this.f29133e.getBounds().height() / 2.0f;
            float f4 = width * a2;
            float f5 = height * a2;
            canvas.translate((w() * width) - f4, (w() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.f29132d.reset();
        this.f29132d.preScale(a2, a2);
        this.p.a(canvas, this.f29132d, this.q);
        b.b("Drawable#draw");
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    public Bitmap e(String str) {
        com.vivo.mobilead.lottie.b.b D = D();
        if (D != null) {
            return D.a(str);
        }
        return null;
    }

    public String e() {
        return this.l;
    }

    public void e(float f2) {
        this.f29135g = f2;
        C();
    }

    public void e(int i2) {
        this.f29134f.setRepeatCount(i2);
    }

    public i f() {
        LottieComposition lottieComposition = this.f29133e;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    public void g() {
        if (this.f29134f.isRunning()) {
            this.f29134f.cancel();
        }
        this.f29133e = null;
        this.p = null;
        this.k = null;
        this.f29134f.f();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f29133e == null) {
            return -1;
        }
        return (int) (r0.getBounds().height() * w());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f29133e == null) {
            return -1;
        }
        return (int) (r0.getBounds().width() * w());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h() {
        if (this.p == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.8
                AnonymousClass8() {
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition) {
                    c.this.h();
                }
            });
            return;
        }
        if (this.f29136h || s() == 0) {
            this.f29134f.i();
        }
        if (this.f29136h) {
            return;
        }
        c((int) (n() < 0.0f ? k() : l()));
    }

    public void i() {
        this.f29138j.clear();
        this.f29134f.j();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.s) {
            return;
        }
        this.s = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return t();
    }

    public void j() {
        if (this.p == null) {
            this.f29138j.add(new a() { // from class: com.vivo.mobilead.lottie.c.9
                AnonymousClass9() {
                }

                @Override // com.vivo.mobilead.lottie.c.a
                public void a(LottieComposition lottieComposition) {
                    c.this.j();
                }
            });
        } else {
            this.f29134f.l();
        }
    }

    public float k() {
        return this.f29134f.m();
    }

    public float l() {
        return this.f29134f.n();
    }

    public void m() {
        this.f29134f.g();
    }

    public float n() {
        return this.f29134f.h();
    }

    public void o() {
        this.f29134f.removeAllUpdateListeners();
    }

    public void p() {
        this.f29134f.removeAllListeners();
    }

    public int q() {
        return (int) this.f29134f.e();
    }

    public int r() {
        return this.f29134f.getRepeatMode();
    }

    public int s() {
        return this.f29134f.getRepeatCount();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.q = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.vivo.mobilead.lottie.f.d.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        h();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        i();
    }

    public boolean t() {
        return this.f29134f.isRunning();
    }

    public TextDelegate u() {
        return this.f29131b;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public boolean v() {
        return this.f29131b == null && this.f29133e.getCharacters().size() > 0;
    }

    public float w() {
        return this.f29135g;
    }

    public LottieComposition x() {
        return this.f29133e;
    }

    public void y() {
        this.f29138j.clear();
        this.f29134f.cancel();
    }

    public void z() {
        this.f29138j.clear();
        this.f29134f.k();
    }
}
