package com.sigmob.sdk.base.common;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.sigmob.sdk.base.models.BaseAdUnit;

/* loaded from: classes4.dex */
public class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: k */
    public static final int f17677k = 4;

    /* renamed from: l */
    public static final float f17678l = 100.0f;

    /* renamed from: m */
    public static final float f17679m = 100.0f;

    /* renamed from: a */
    public final BaseAdUnit f17680a;

    /* renamed from: b */
    public float f17681b;

    /* renamed from: c */
    public float f17682c;

    /* renamed from: d */
    public boolean f17683d;

    /* renamed from: e */
    public boolean f17684e;

    /* renamed from: f */
    public int f17685f;

    /* renamed from: g */
    public float f17686g;

    /* renamed from: h */
    public EnumC0562b f17687h = EnumC0562b.UNSET;

    /* renamed from: i */
    public View f17688i;

    /* renamed from: j */
    public boolean f17689j;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f17690a;

        static {
            int[] iArr = new int[EnumC0562b.values().length];
            f17690a = iArr;
            try {
                iArr[EnumC0562b.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17690a[EnumC0562b.GOING_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17690a[EnumC0562b.GOING_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17690a[EnumC0562b.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.common.b$b */
    public enum EnumC0562b {
        UNSET,
        GOING_RIGHT,
        GOING_LEFT,
        FINISHED,
        FAILED
    }

    public b(View view, BaseAdUnit baseAdUnit) {
        this.f17681b = 100.0f;
        if (view != null && view.getWidth() > 0) {
            this.f17681b = Math.min(100.0f, view.getWidth() / 3.0f);
        }
        this.f17689j = false;
        this.f17688i = view;
        this.f17680a = baseAdUnit;
    }

    public void a() {
        EnumC0562b enumC0562b = EnumC0562b.FINISHED;
        e();
    }

    public final void b() {
        int i10 = this.f17685f + 1;
        this.f17685f = i10;
        if (i10 >= 4) {
            this.f17687h = EnumC0562b.FINISHED;
        }
    }

    public boolean c() {
        return this.f17689j;
    }

    public void d() {
        this.f17689j = false;
    }

    public void e() {
        this.f17685f = 0;
        this.f17687h = EnumC0562b.UNSET;
    }

    public final void f(float f10) {
        if (c(f10) && b(f10)) {
            this.f17687h = EnumC0562b.GOING_RIGHT;
            this.f17686g = f10;
        }
    }

    public final void g(float f10) {
        if (d(f10) && a(f10)) {
            this.f17687h = EnumC0562b.GOING_LEFT;
            this.f17686g = f10;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (this.f17687h == EnumC0562b.FINISHED) {
            return super.onScroll(motionEvent, motionEvent2, f10, f11);
        }
        if (a(motionEvent, motionEvent2)) {
            this.f17687h = EnumC0562b.FAILED;
        } else {
            int i10 = a.f17690a[this.f17687h.ordinal()];
            if (i10 == 1) {
                this.f17686g = motionEvent.getX();
                e(motionEvent2.getX());
            } else if (i10 == 2) {
                g(motionEvent2.getX());
            } else if (i10 == 3) {
                f(motionEvent2.getX());
            }
            this.f17682c = motionEvent2.getX();
        }
        return super.onScroll(motionEvent, motionEvent2, f10, f11);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f17689j = true;
        return super.onSingleTapUp(motionEvent);
    }

    public final boolean a(float f10) {
        return f10 < this.f17682c;
    }

    public final boolean b(float f10) {
        return f10 > this.f17682c;
    }

    public final boolean c(float f10) {
        if (this.f17683d) {
            return true;
        }
        if (f10 > this.f17686g - this.f17681b) {
            return false;
        }
        this.f17684e = false;
        this.f17683d = true;
        b();
        return true;
    }

    public final boolean d(float f10) {
        if (this.f17684e) {
            return true;
        }
        if (f10 < this.f17686g + this.f17681b) {
            return false;
        }
        this.f17683d = false;
        this.f17684e = true;
        return true;
    }

    public final void e(float f10) {
        if (f10 > this.f17686g) {
            this.f17687h = EnumC0562b.GOING_RIGHT;
        }
    }

    public final boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        return Math.abs(motionEvent2.getY() - motionEvent.getY()) > 100.0f;
    }
}
