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
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public class CircleSkipView extends KSFrameLayout implements a {
    private float Eo;
    private float Ep;
    private int Eq;
    private ValueAnimator Er;
    private boolean Es;
    private SkipView.a Et;
    private long Eu;
    private float Ev;
    private Paint mPaint;
    private RectF mRectF;
    private int padding;
    private int radius;
    private boolean sp;

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView$1 */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (CircleSkipView.this.Et != null) {
                CircleSkipView.this.Et.kI();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView$2 */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (CircleSkipView.this.Ev != 1.0f || CircleSkipView.this.Et == null) {
                return;
            }
            CircleSkipView.this.Et.kJ();
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.widget.CircleSkipView$3 */
    final class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int Ex;
        final /* synthetic */ boolean Ey;

        AnonymousClass3(int i2, boolean z) {
            i2 = i2;
            z = z;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircleSkipView.this.Ev = floatValue;
            CircleSkipView circleSkipView = CircleSkipView.this;
            circleSkipView.ab((int) ((i2 / 1000) * circleSkipView.Ev));
            if (z) {
                CircleSkipView.a(CircleSkipView.this, true);
                float f2 = floatValue * 360.0f;
                CircleSkipView.this.Eo = 270.0f - f2;
                CircleSkipView.this.Ep = 360.0f - f2;
                CircleSkipView.this.invalidate();
            }
        }
    }

    public CircleSkipView(@NonNull Context context) {
        this(context, null, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleSkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mPaint = new Paint();
        this.Eo = 270.0f;
        this.Ep = 360.0f;
        this.radius = 0;
        this.Eq = 0;
        this.Es = false;
        this.Eu = 0L;
        this.Ev = 0.0f;
        this.padding = 0;
        this.sp = true;
        U(context);
    }

    private void U(Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        V(context);
        addView(W(context), layoutParams);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (CircleSkipView.this.Et != null) {
                    CircleSkipView.this.Et.kI();
                }
            }
        });
    }

    private void V(Context context) {
        this.Eq = com.kwad.sdk.c.kwai.a.a(context, 2.0f);
        int a2 = com.kwad.sdk.c.kwai.a.a(context, 32.0f);
        int i2 = this.Eq;
        this.radius = a2 - i2;
        this.padding = i2 / 2;
        int i3 = this.padding;
        int i4 = this.radius;
        this.mRectF = new RectF(i3, i3, i4 + i3, i4 + i3);
    }

    private static TextView W(Context context) {
        TextView textView = new TextView(context);
        textView.setText(context.getString(R.string.ksad_skip_text));
        textView.setTextColor(-1);
        textView.setTextSize(12.0f);
        return textView;
    }

    static /* synthetic */ boolean a(CircleSkipView circleSkipView, boolean z) {
        circleSkipView.Es = true;
        return true;
    }

    public void ab(int i2) {
        SkipView.a aVar = this.Et;
        if (aVar != null) {
            aVar.ac(i2);
        }
    }

    private void c(int i2, boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Er = ofFloat;
        ofFloat.setDuration(i2);
        this.Er.setInterpolator(new LinearInterpolator());
        this.Er.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.2
            AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (CircleSkipView.this.Ev != 1.0f || CircleSkipView.this.Et == null) {
                    return;
                }
                CircleSkipView.this.Et.kJ();
            }
        });
        this.Er.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.splashscreen.widget.CircleSkipView.3
            final /* synthetic */ int Ex;
            final /* synthetic */ boolean Ey;

            AnonymousClass3(int i22, boolean z2) {
                i2 = i22;
                z = z2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircleSkipView.this.Ev = floatValue;
                CircleSkipView circleSkipView = CircleSkipView.this;
                circleSkipView.ab((int) ((i2 / 1000) * circleSkipView.Ev));
                if (z) {
                    CircleSkipView.a(CircleSkipView.this, true);
                    float f2 = floatValue * 360.0f;
                    CircleSkipView.this.Eo = 270.0f - f2;
                    CircleSkipView.this.Ep = 360.0f - f2;
                    CircleSkipView.this.invalidate();
                }
            }
        });
    }

    private void lr() {
        this.Es = true;
        ValueAnimator valueAnimator = this.Er;
        if (valueAnimator != null) {
            valueAnimator.setCurrentPlayTime(this.Eu);
            this.Er.start();
        }
    }

    private void ls() {
        this.Es = false;
        ValueAnimator valueAnimator = this.Er;
        if (valueAnimator != null) {
            this.Eu = valueAnimator.getCurrentPlayTime();
            this.Er.cancel();
        }
    }

    private void setAnimationPaint(Paint paint) {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Eq);
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
        paint.setStrokeWidth(this.Eq);
        paint.setColor(Color.parseColor("#33FFFFFF"));
        paint.setAntiAlias(true);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void a(SplashSkipViewModel splashSkipViewModel, AdInfo adInfo) {
        this.sp = com.kwad.sdk.core.response.a.a.ce(adInfo);
        boolean cf = com.kwad.sdk.core.response.a.a.cf(adInfo);
        if (this.sp) {
            setVisibility(0);
        }
        c(splashSkipViewModel.skipSecond * 1000, cf);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final int af(int i2) {
        getLayoutParams().height = com.kwad.sdk.c.kwai.a.a(getContext(), 35.0f);
        return getWidth();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void bn() {
        ls();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (Math.min(getWidth(), getHeight()) / 2.0f) - this.Eq, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawArc(this.mRectF, 0.0f, 360.0f, false, this.mPaint);
        if (this.Es) {
            setAnimationPaint(this.mPaint);
            canvas.drawArc(this.mRectF, this.Eo, -this.Ep, false, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public void setOnViewListener(SkipView.a aVar) {
        this.Et = aVar;
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void u(AdInfo adInfo) {
        ls();
    }

    @Override // com.kwad.components.ad.splashscreen.widget.a
    public final void v(AdInfo adInfo) {
        lr();
    }
}
