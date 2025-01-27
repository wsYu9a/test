package com.martian.libmars.utils.tablayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(11)
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a */
    private final List<MagicIndicator> f10238a;

    /* renamed from: b */
    private ValueAnimator f10239b;

    /* renamed from: c */
    private int f10240c;

    /* renamed from: d */
    private int f10241d;

    /* renamed from: e */
    private Interpolator f10242e;

    /* renamed from: f */
    private final Animator.AnimatorListener f10243f;

    /* renamed from: g */
    private final ValueAnimator.AnimatorUpdateListener f10244g;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            g.this.d(0);
            g.this.f10239b = null;
        }
    }

    public g() {
        this.f10238a = new ArrayList();
        this.f10241d = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE;
        this.f10242e = new AccelerateDecelerateInterpolator();
        this.f10243f = new a();
        this.f10244g = new ValueAnimator.AnimatorUpdateListener() { // from class: com.martian.libmars.utils.tablayout.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.k(valueAnimator);
            }
        };
    }

    public void d(int state) {
        Iterator<MagicIndicator> it = this.f10238a.iterator();
        while (it.hasNext()) {
            it.next().b(state);
        }
    }

    private void e(int position, float positionOffset) {
        Iterator<MagicIndicator> it = this.f10238a.iterator();
        while (it.hasNext()) {
            it.next().c(position, positionOffset, 0);
        }
    }

    private void f(int pageIndex) {
        Iterator<MagicIndicator> it = this.f10238a.iterator();
        while (it.hasNext()) {
            it.next().d(pageIndex);
        }
    }

    public static l g(List<l> positionDataList, int index) {
        l lVar;
        if (index >= 0 && index <= positionDataList.size() - 1) {
            return positionDataList.get(index);
        }
        l lVar2 = new l();
        if (index < 0) {
            lVar = positionDataList.get(0);
        } else {
            index = (index - positionDataList.size()) + 1;
            lVar = positionDataList.get(positionDataList.size() - 1);
        }
        lVar2.f10255a = lVar.f10255a + (lVar.f() * index);
        lVar2.f10256b = lVar.f10256b;
        lVar2.f10257c = lVar.f10257c + (lVar.f() * index);
        lVar2.f10258d = lVar.f10258d;
        lVar2.f10259e = lVar.f10259e + (lVar.f() * index);
        lVar2.f10260f = lVar.f10260f;
        lVar2.f10261g = lVar.f10261g + (index * lVar.f());
        lVar2.f10262h = lVar.f10262h;
        return lVar2;
    }

    /* renamed from: j */
    public /* synthetic */ void k(ValueAnimator animation) {
        float floatValue = ((Float) animation.getAnimatedValue()).floatValue();
        int i2 = (int) floatValue;
        float f2 = floatValue - i2;
        if (floatValue < 0.0f) {
            i2--;
            f2 += 1.0f;
        }
        e(i2, f2);
    }

    public void c(MagicIndicator magicIndicator) {
        this.f10238a.add(magicIndicator);
    }

    public void h(int selectedIndex) {
        i(selectedIndex, true);
    }

    public void i(int selectedIndex, boolean smooth) {
        if (this.f10240c == selectedIndex) {
            return;
        }
        if (smooth) {
            ValueAnimator valueAnimator = this.f10239b;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                d(2);
            }
            f(selectedIndex);
            float f2 = this.f10240c;
            ValueAnimator valueAnimator2 = this.f10239b;
            if (valueAnimator2 != null) {
                f2 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                this.f10239b.cancel();
                this.f10239b = null;
            }
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.f10239b = valueAnimator3;
            valueAnimator3.setFloatValues(f2, selectedIndex);
            this.f10239b.addUpdateListener(this.f10244g);
            this.f10239b.addListener(this.f10243f);
            this.f10239b.setInterpolator(this.f10242e);
            this.f10239b.setDuration(this.f10241d);
            this.f10239b.start();
        } else {
            f(selectedIndex);
            ValueAnimator valueAnimator4 = this.f10239b;
            if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                e(this.f10240c, 0.0f);
            }
            d(0);
            e(selectedIndex, 0.0f);
        }
        this.f10240c = selectedIndex;
    }

    public void l(int duration) {
        this.f10241d = duration;
    }

    public void m(Interpolator interpolator) {
        if (interpolator == null) {
            this.f10242e = new AccelerateDecelerateInterpolator();
        } else {
            this.f10242e = interpolator;
        }
    }

    public g(MagicIndicator magicIndicator) {
        ArrayList arrayList = new ArrayList();
        this.f10238a = arrayList;
        this.f10241d = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE;
        this.f10242e = new AccelerateDecelerateInterpolator();
        this.f10243f = new a();
        this.f10244g = new ValueAnimator.AnimatorUpdateListener() { // from class: com.martian.libmars.utils.tablayout.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.k(valueAnimator);
            }
        };
        arrayList.add(magicIndicator);
    }
}
