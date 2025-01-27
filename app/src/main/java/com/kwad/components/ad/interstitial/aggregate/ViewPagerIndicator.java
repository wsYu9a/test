package com.kwad.components.ad.interstitial.aggregate;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;

/* loaded from: classes2.dex */
public class ViewPagerIndicator extends View {

    /* renamed from: ke */
    private int f11578ke;

    /* renamed from: kk */
    private int f11579kk;
    private int kl;
    private int km;
    private float kn;
    private float ko;
    private Paint kp;
    private float kq;
    private float kr;
    private float ks;
    private int kt;
    private Paint ku;
    private float kv;
    private boolean kw;
    private a kx;
    private ValueAnimator ky;
    private final Context mContext;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator$1 */
    public class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewPagerIndicator.this.kv = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewPagerIndicator.this.invalidate();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ViewPagerIndicator.a(ViewPagerIndicator.this, true);
            if (ViewPagerIndicator.this.kx != null) {
                ViewPagerIndicator.this.kx.cS();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator$3 */
    public class AnonymousClass3 implements ViewPager.OnPageChangeListener {
        public AnonymousClass3() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i10, float f10, int i11) {
            ViewPagerIndicator.this.f11578ke = i10;
            ViewPagerIndicator.this.kn = f10;
            ViewPagerIndicator.this.invalidate();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i10) {
            ViewPagerIndicator.this.f11578ke = i10;
            ViewPagerIndicator.this.kn = 0.0f;
            ViewPagerIndicator.this.invalidate();
        }
    }

    public interface a {
        void cS();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    private void cW() {
        Paint paint = new Paint(1);
        this.kp = paint;
        Paint.Style style = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style);
        this.kp.setStrokeWidth(1.0f);
        this.kp.setColor(this.kl);
        Paint paint2 = new Paint(1);
        this.ku = paint2;
        paint2.setStyle(style);
        this.ku.setStrokeWidth(1.0f);
        this.ku.setColor(this.f11579kk);
    }

    private void cX() {
        if (this.kt <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.ks, this.kr);
        this.ky = ofFloat;
        ofFloat.setDuration(this.kt * 1000);
        this.ky.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            public AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.kv = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.ky.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            public AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.kx != null) {
                    ViewPagerIndicator.this.kx.cS();
                }
            }
        });
        this.ky.start();
    }

    @RequiresApi(api = 19)
    public final void cY() {
        ValueAnimator valueAnimator = this.ky;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void cZ() {
        ValueAnimator valueAnimator = this.ky;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.kq : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = this.km > 1 ? (int) (this.kr + ((r6 - 1) * (this.ko + this.ks))) : (int) this.kr;
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setFirstAdShowTime(int i10) {
        this.kt = i10;
    }

    public void setPlayProgressListener(a aVar) {
        this.kx = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.km = count;
        if (count <= 1) {
            return;
        }
        this.kw = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            public AnonymousClass3() {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i10) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i10, float f10, int i11) {
                ViewPagerIndicator.this.f11578ke = i10;
                ViewPagerIndicator.this.kn = f10;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i10) {
                ViewPagerIndicator.this.f11578ke = i10;
                ViewPagerIndicator.this.kn = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        cX();
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Canvas canvas) {
        if (this.kw || this.f11578ke != 0) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.kv, this.kq);
        float f10 = this.kq;
        canvas.drawRoundRect(rectF, f10 / 2.0f, f10 / 2.0f, this.ku);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mContext = context;
        setWillNotDraw(false);
        a(context, attributeSet, i10);
        cW();
    }

    public static /* synthetic */ boolean a(ViewPagerIndicator viewPagerIndicator, boolean z10) {
        viewPagerIndicator.kw = true;
        return true;
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i10, 0);
        this.ko = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.c.a.a.a(this.mContext, 5.0f));
        this.kq = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.kr = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.c.a.a.a(this.mContext, 50.0f));
        this.ks = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.c.a.a.a(this.mContext, 6.0f));
        this.kl = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.f11579kk = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        obtainStyledAttributes.recycle();
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        for (int i10 = 0; i10 < this.km; i10++) {
            int i11 = this.f11578ke;
            if (i10 < i11) {
                float f10 = this.ko;
                float f11 = this.ks;
                float f12 = i10 * (f10 + f11);
                rectF.left = f12;
                rectF.right = f12 + f11;
                this.kp.setColor(this.kl);
            } else if (i10 == i11) {
                float f13 = this.ko;
                float f14 = this.ks;
                float f15 = i10 * (f13 + f14);
                rectF.left = f15;
                rectF.right = f15 + f14 + ((this.kr - f14) * (1.0f - this.kn));
                if (this.kw) {
                    this.kp.setColor(this.f11579kk);
                    this.kp.setAlpha((int) (((1.0f - this.kn) * 127.0f) + 127.0f));
                } else {
                    this.kp.setColor(this.kl);
                }
            } else if (i10 == i11 + 1) {
                float f16 = this.ko;
                float f17 = this.ks;
                float f18 = this.kr;
                float f19 = this.kn;
                float f20 = ((i10 - 1) * (f16 + f17)) + f17 + ((f18 - f17) * (1.0f - f19)) + f16;
                rectF.left = f20;
                rectF.right = f20 + (f19 * (f18 - f17)) + f17;
                if (this.kw) {
                    this.kp.setColor(this.f11579kk);
                    this.kp.setAlpha((int) (255.0f - ((1.0f - this.kn) * 127.0f)));
                } else {
                    this.kp.setColor(this.kl);
                }
            } else {
                float f21 = this.ko;
                float f22 = this.ks;
                float f23 = ((i10 - 1) * (f21 + f22)) + f21 + this.kr;
                rectF.left = f23;
                rectF.right = f23 + f22;
                this.kp.setColor(this.kl);
            }
            rectF.top = 0.0f;
            float f24 = this.kq;
            rectF.bottom = 0.0f + f24;
            canvas.drawRoundRect(rectF, f24 / 2.0f, f24 / 2.0f, this.kp);
        }
    }
}
