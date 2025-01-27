package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.widget.ViewSwitcher;

/* loaded from: classes4.dex */
public class i extends ViewSwitcher {

    /* renamed from: a */
    private volatile a f20756a;

    /* renamed from: b */
    private final b f20757b;

    public interface a {
        void a(int i2, int i3);
    }

    public static class b {

        /* renamed from: a */
        public final int f20758a;

        /* renamed from: b */
        public final int f20759b;

        /* renamed from: c */
        public final int f20760c;

        /* renamed from: d */
        public final int f20761d;

        /* renamed from: e */
        public final float f20762e;

        public b(int i2, int i3, float f2) {
            f2 = f2 <= 0.0f ? 6.315f : f2;
            this.f20762e = f2;
            int i4 = i2 > 0 ? i2 : 171;
            this.f20759b = i4;
            this.f20758a = (int) (i4 / f2);
            if (i3 <= i4 && i3 > 0) {
                i2 = i3;
            }
            this.f20761d = i2;
            this.f20760c = (int) (i2 / f2);
        }

        public int a(int i2) {
            int i3 = this.f20761d;
            return (i2 > i3 && i2 < (i3 = this.f20759b)) ? i2 : i3;
        }

        public int b(int i2) {
            int i3 = this.f20760c;
            return (i2 > i3 && i2 < (i3 = this.f20758a)) ? i2 : i3;
        }

        public String toString() {
            return "maxH = " + this.f20758a + ",maxW = " + this.f20759b + ",minH = " + this.f20760c + ",minW = " + this.f20761d;
        }
    }

    public i(Context context, b bVar) {
        super(context);
        this.f20757b = bVar;
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (i2 == i4 && i3 == i5) {
            return;
        }
        if (this.f20756a != null) {
            this.f20756a.a(i2, i3);
        }
        com.opos.cmn.an.f.a.b("switcher", "w = " + i2 + ",h = " + i3 + ",oldw = " + i4 + ",oldh = " + i5);
    }

    public void a(a aVar) {
        this.f20756a = aVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int b2 = this.f20757b.b(size);
        int a2 = this.f20757b.a(size2);
        float f2 = this.f20757b.f20762e;
        int i4 = (int) (a2 / f2);
        int i5 = (int) (b2 * f2);
        if (mode2 != 1073741824 && mode == 1073741824) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(b2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a2, 1073741824);
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        com.opos.cmn.an.f.a.b("switcher", "onSizeChanged w = " + i2 + ",h = " + i3 + ",oldw = " + i4 + ",oldh = " + i5);
        a(i2, i3, i4, i5);
    }
}
