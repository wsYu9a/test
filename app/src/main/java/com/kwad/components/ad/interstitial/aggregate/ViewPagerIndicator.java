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

/* loaded from: classes.dex */
public class ViewPagerIndicator extends View {
    private int iC;
    private int iI;
    private int iJ;
    private int iK;
    private float iL;
    private float iM;
    private Paint iN;
    private float iO;
    private float iP;
    private float iQ;
    private int iR;
    private Paint iS;
    private float iT;
    private boolean iU;
    private a iV;
    private ValueAnimator iW;
    private final Context mContext;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator$1 */
    final class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass1() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewPagerIndicator.this.iT = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ViewPagerIndicator.this.invalidate();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator$2 */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ViewPagerIndicator.a(ViewPagerIndicator.this, true);
            if (ViewPagerIndicator.this.iV != null) {
                ViewPagerIndicator.this.iV.cz();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator$3 */
    final class AnonymousClass3 implements ViewPager.OnPageChangeListener {
        AnonymousClass3() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int i2, float f2, int i3) {
            ViewPagerIndicator.this.iC = i2;
            ViewPagerIndicator.this.iL = f2;
            ViewPagerIndicator.this.invalidate();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int i2) {
            ViewPagerIndicator.this.iC = i2;
            ViewPagerIndicator.this.iL = 0.0f;
            ViewPagerIndicator.this.invalidate();
        }
    }

    public interface a {
        void cz();
    }

    public ViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewPagerIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mContext = context;
        setWillNotDraw(false);
        init(context, attributeSet, i2);
        cD();
    }

    private void a(Canvas canvas) {
        float f2;
        float f3;
        Paint paint;
        int i2;
        RectF rectF = new RectF();
        for (int i3 = 0; i3 < this.iK; i3++) {
            int i4 = this.iC;
            if (i3 < i4) {
                float f4 = this.iM;
                f2 = this.iQ;
                f3 = i3 * (f4 + f2);
            } else {
                if (i3 == i4) {
                    float f5 = this.iM;
                    float f6 = this.iQ;
                    float f7 = i3 * (f5 + f6);
                    rectF.left = f7;
                    rectF.right = f7 + f6 + ((this.iP - f6) * (1.0f - this.iL));
                    if (this.iU) {
                        this.iN.setColor(this.iI);
                        paint = this.iN;
                        i2 = (int) (((1.0f - this.iL) * 127.0f) + 127.0f);
                        paint.setAlpha(i2);
                    }
                    this.iN.setColor(this.iJ);
                } else if (i3 == i4 + 1) {
                    float f8 = this.iM;
                    float f9 = this.iQ;
                    float f10 = this.iP;
                    float f11 = this.iL;
                    float f12 = ((i3 - 1) * (f8 + f9)) + f9 + ((f10 - f9) * (1.0f - f11)) + f8;
                    rectF.left = f12;
                    rectF.right = f12 + (f11 * (f10 - f9)) + f9;
                    if (this.iU) {
                        this.iN.setColor(this.iI);
                        paint = this.iN;
                        i2 = (int) (255.0f - ((1.0f - this.iL) * 127.0f));
                        paint.setAlpha(i2);
                    }
                    this.iN.setColor(this.iJ);
                } else {
                    float f13 = this.iM;
                    f2 = this.iQ;
                    f3 = ((i3 - 1) * (f13 + f2)) + f13 + this.iP;
                }
                rectF.top = 0.0f;
                float f14 = this.iO;
                rectF.bottom = 0.0f + f14;
                canvas.drawRoundRect(rectF, f14 / 2.0f, f14 / 2.0f, this.iN);
            }
            rectF.left = f3;
            rectF.right = f3 + f2;
            this.iN.setColor(this.iJ);
            rectF.top = 0.0f;
            float f142 = this.iO;
            rectF.bottom = 0.0f + f142;
            canvas.drawRoundRect(rectF, f142 / 2.0f, f142 / 2.0f, this.iN);
        }
    }

    static /* synthetic */ boolean a(ViewPagerIndicator viewPagerIndicator, boolean z) {
        viewPagerIndicator.iU = true;
        return true;
    }

    private void b(Canvas canvas) {
        if (this.iU || this.iC != 0) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, this.iT, this.iO);
        float f2 = this.iO;
        canvas.drawRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, this.iS);
    }

    private void cD() {
        Paint paint = new Paint(1);
        this.iN = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.iN.setStrokeWidth(1.0f);
        this.iN.setColor(this.iJ);
        Paint paint2 = new Paint(1);
        this.iS = paint2;
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        this.iS.setStrokeWidth(1.0f);
        this.iS.setColor(this.iI);
    }

    private void cE() {
        if (this.iR <= 0) {
            setVisibility(8);
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.iQ, this.iP);
        this.iW = ofFloat;
        ofFloat.setDuration(this.iR * 1000);
        this.iW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.1
            AnonymousClass1() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewPagerIndicator.this.iT = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ViewPagerIndicator.this.invalidate();
            }
        });
        this.iW.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.2
            AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewPagerIndicator.a(ViewPagerIndicator.this, true);
                if (ViewPagerIndicator.this.iV != null) {
                    ViewPagerIndicator.this.iV.cz();
                }
            }
        });
        this.iW.start();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ViewPagerIndicator, i2, 0);
        this.iM = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_distance, com.kwad.sdk.c.kwai.a.a(this.mContext, 5.0f));
        this.iO = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_height, com.kwad.sdk.c.kwai.a.a(this.mContext, 6.0f));
        this.iP = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_selected_width, com.kwad.sdk.c.kwai.a.a(this.mContext, 50.0f));
        this.iQ = obtainStyledAttributes.getDimension(R.styleable.ksad_ViewPagerIndicator_ksad_dot_unselected_width, com.kwad.sdk.c.kwai.a.a(this.mContext, 6.0f));
        this.iJ = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_default_color, getResources().getColor(R.color.ksad_88_white));
        this.iI = obtainStyledAttributes.getColor(R.styleable.ksad_ViewPagerIndicator_ksad_height_color, getResources().getColor(R.color.ksad_white));
        obtainStyledAttributes.recycle();
    }

    @RequiresApi(api = 19)
    public final void cF() {
        ValueAnimator valueAnimator = this.iW;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    @RequiresApi(api = 19)
    public final void cG() {
        ValueAnimator valueAnimator = this.iW;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 != 1073741824) {
            size2 = mode2 == Integer.MIN_VALUE ? (int) this.iO : 0;
        }
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = this.iK > 1 ? (int) (this.iP + ((r6 - 1) * (this.iM + this.iQ))) : (int) this.iP;
            } else {
                size = 0;
            }
        }
        setMeasuredDimension(size, size2);
    }

    public void setFirstAdShowTime(int i2) {
        this.iR = i2;
    }

    public void setPlayProgressListener(a aVar) {
        this.iV = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            return;
        }
        int count = adapter.getCount();
        this.iK = count;
        if (count <= 1) {
            return;
        }
        this.iU = false;
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.ViewPagerIndicator.3
            AnonymousClass3() {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int i2, float f2, int i3) {
                ViewPagerIndicator.this.iC = i2;
                ViewPagerIndicator.this.iL = f2;
                ViewPagerIndicator.this.invalidate();
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                ViewPagerIndicator.this.iC = i2;
                ViewPagerIndicator.this.iL = 0.0f;
                ViewPagerIndicator.this.invalidate();
            }
        });
        cE();
    }
}
