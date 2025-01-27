package m9;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a */
    public final List<MagicIndicator> f28533a;

    /* renamed from: b */
    public ValueAnimator f28534b;

    /* renamed from: c */
    public int f28535c;

    /* renamed from: d */
    public int f28536d;

    /* renamed from: e */
    public Interpolator f28537e;

    /* renamed from: f */
    public final Animator.AnimatorListener f28538f;

    /* renamed from: g */
    public final ValueAnimator.AnimatorUpdateListener f28539g;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.e(0);
            d.this.f28534b = null;
        }
    }

    public d() {
        this.f28533a = new ArrayList();
        this.f28536d = 150;
        this.f28537e = new AccelerateDecelerateInterpolator();
        this.f28538f = new a();
        this.f28539g = new ValueAnimator.AnimatorUpdateListener() { // from class: m9.c
            public /* synthetic */ c() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.k(valueAnimator);
            }
        };
    }

    public static i h(List<i> list, int i10) {
        i iVar;
        if (i10 >= 0 && i10 <= list.size() - 1) {
            return list.get(i10);
        }
        i iVar2 = new i();
        if (i10 < 0) {
            iVar = list.get(0);
        } else {
            i10 = (i10 - list.size()) + 1;
            iVar = list.get(list.size() - 1);
        }
        iVar2.f28543a = iVar.f28543a + (iVar.f() * i10);
        iVar2.f28544b = iVar.f28544b;
        iVar2.f28545c = iVar.f28545c + (iVar.f() * i10);
        iVar2.f28546d = iVar.f28546d;
        iVar2.f28547e = iVar.f28547e + (iVar.f() * i10);
        iVar2.f28548f = iVar.f28548f;
        iVar2.f28549g = iVar.f28549g + (i10 * iVar.f());
        iVar2.f28550h = iVar.f28550h;
        return iVar2;
    }

    public void d(MagicIndicator magicIndicator) {
        this.f28533a.add(magicIndicator);
    }

    public final void e(int i10) {
        Iterator<MagicIndicator> it = this.f28533a.iterator();
        while (it.hasNext()) {
            it.next().a(i10);
        }
    }

    public final void f(int i10, float f10) {
        Iterator<MagicIndicator> it = this.f28533a.iterator();
        while (it.hasNext()) {
            it.next().b(i10, f10, 0);
        }
    }

    public final void g(int i10) {
        Iterator<MagicIndicator> it = this.f28533a.iterator();
        while (it.hasNext()) {
            it.next().c(i10);
        }
    }

    public void i(int i10) {
        j(i10, true);
    }

    public void j(int i10, boolean z10) {
        if (this.f28535c == i10) {
            return;
        }
        if (z10) {
            ValueAnimator valueAnimator = this.f28534b;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e(2);
            }
            g(i10);
            float f10 = this.f28535c;
            ValueAnimator valueAnimator2 = this.f28534b;
            if (valueAnimator2 != null) {
                f10 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                this.f28534b.cancel();
                this.f28534b = null;
            }
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.f28534b = valueAnimator3;
            valueAnimator3.setFloatValues(f10, i10);
            this.f28534b.addUpdateListener(this.f28539g);
            this.f28534b.addListener(this.f28538f);
            this.f28534b.setInterpolator(this.f28537e);
            this.f28534b.setDuration(this.f28536d);
            this.f28534b.start();
        } else {
            g(i10);
            ValueAnimator valueAnimator4 = this.f28534b;
            if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                f(this.f28535c, 0.0f);
            }
            e(0);
            f(i10, 0.0f);
        }
        this.f28535c = i10;
    }

    public final /* synthetic */ void k(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int i10 = (int) floatValue;
        float f10 = floatValue - i10;
        if (floatValue < 0.0f) {
            i10--;
            f10 += 1.0f;
        }
        f(i10, f10);
    }

    public void l(int i10) {
        this.f28536d = i10;
    }

    public void m(Interpolator interpolator) {
        if (interpolator == null) {
            this.f28537e = new AccelerateDecelerateInterpolator();
        } else {
            this.f28537e = interpolator;
        }
    }

    public d(MagicIndicator magicIndicator) {
        ArrayList arrayList = new ArrayList();
        this.f28533a = arrayList;
        this.f28536d = 150;
        this.f28537e = new AccelerateDecelerateInterpolator();
        this.f28538f = new a();
        this.f28539g = new ValueAnimator.AnimatorUpdateListener() { // from class: m9.c
            public /* synthetic */ c() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.k(valueAnimator);
            }
        };
        arrayList.add(magicIndicator);
    }
}
