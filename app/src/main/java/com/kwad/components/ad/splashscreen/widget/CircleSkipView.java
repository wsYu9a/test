package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public class CircleSkipView extends KSFrameLayout implements b {
    private float Hr;
    private float Hs;
    private int Ht;
    private ValueAnimator Hu;
    private boolean Hv;
    private SkipView.a Hw;
    private long Hx;
    private float Hy;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;

    /* renamed from: ue */
    private boolean f11908ue;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (CircleSkipView.this.Hw != null) {
                CircleSkipView.this.Hw.lr();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            CircleSkipView.this.mz();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView$3 */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (CircleSkipView.this.Hy != 1.0f || CircleSkipView.this.Hw == null) {
                return;
            }
            CircleSkipView.this.Hw.ls();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView$4 */
    public class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int HA;
        final /* synthetic */ boolean HB;

        public AnonymousClass4(int i10, boolean z10) {
            i10 = i10;
            z10 = z10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircleSkipView.this.Hy = floatValue;
            CircleSkipView circleSkipView = CircleSkipView.this;
            circleSkipView.Y((int) ((i10 / 1000) * circleSkipView.Hy));
            if (z10) {
                CircleSkipView.a(CircleSkipView.this, true);
                float f10 = floatValue * 360.0f;
                CircleSkipView.this.Hr = 270.0f - f10;
                CircleSkipView.this.Hs = 360.0f - f10;
                CircleSkipView.this.invalidate();
            }
        }
    }

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    public void Y(int i10) {
        SkipView.a aVar = this.Hw;
        if (aVar != null) {
            aVar.Z(i10);
        }
    }

    private void ad(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        ae(context);
        addView(af(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.Hw != null) {
                    CircleSkipView.this.Hw.lr();
                }
            }
        });
    }

    private void ae(Context context) {
        this.Ht = com.kwad.sdk.c.a.a.a(context, 2.0f);
        int a10 = com.kwad.sdk.c.a.a.a(context, 32.0f);
        int i10 = this.Ht;
        this.radius = a10 - i10;
        this.padding = i10 / 2;
        int i11 = this.padding;
        int i12 = this.radius;
        this.mRectF = new RectF(i11, i11, i12 + i11, i12 + i11);
    }

    private static TextView af(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    private void my() {
        this.Hv = true;
        ValueAnimator valueAnimator = this.Hu;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.Hx);
            this.Hu.start();
        }
    }

    public void mz() {
        this.Hv = false;
        ValueAnimator valueAnimator = this.Hu;
        if (valueAnimator != null) {
            this.Hx = valueAnimator.getCurrentPlayTime();
            this.Hu.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Ht);
        paint.setColor(-1);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#4D000000"));
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Ht);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void A(AdInfo adInfo) {
        bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                CircleSkipView.this.mz();
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void B(AdInfo adInfo) {
        my();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final int ab(int i10) {
        getLayoutParams().height = com.kwad.sdk.c.a.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void bH() {
        mz();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.Ht, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.Hv) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.Hr, -this.Hs, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public void setOnViewListener(SkipView.a aVar) {
        this.Hw = aVar;
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mPaint = new Paint();
        this.Hr = 270.0f;
        this.Hs = 360.0f;
        this.radius = 0;
        this.Ht = 0;
        this.Hv = false;
        this.Hx = 0L;
        this.Hy = 0.0f;
        this.padding = 0;
        this.f11908ue = true;
        ad(context);
    }

    private void c(int i10, boolean z10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Hu = ofFloat;
        ofFloat.setDuration(i10);
        this.Hu.setInterpolator(new LinearInterpolator());
        this.Hu.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            public AnonymousClass3() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.Hy != 1.0f || CircleSkipView.this.Hw == null) {
                    return;
                }
                CircleSkipView.this.Hw.ls();
            }
        });
        this.Hu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.4
            final /* synthetic */ int HA;
            final /* synthetic */ boolean HB;

            public AnonymousClass4(int i102, boolean z102) {
                i10 = i102;
                z10 = z102;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.Hy = floatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.Y((int) ((i10 / 1000) * circleSkipView.Hy));
                if (z10) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f10 = floatValue * 360.0f;
                    CircleSkipView.this.Hr = 270.0f - f10;
                    CircleSkipView.this.Hs = 360.0f - f10;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z10) {
        circleSkipView.Hv = true;
        return true;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.b
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.f11908ue = com.kwad.sdk.core.response.b.a.cE(adInfo);
        boolean cF = com.kwad.sdk.core.response.b.a.cF(adInfo);
        if (this.f11908ue) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, cF);
    }
}
