package com.vivo.mobilead.unified.base.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.StateListDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.vivo.ad.model.q;
import com.vivo.ic.SystemUtils;

/* loaded from: classes4.dex */
public class a extends TextView implements View.OnClickListener {

    /* renamed from: a */
    private ValueAnimator f29816a;

    /* renamed from: b */
    private LinearGradient f29817b;

    /* renamed from: c */
    private Matrix f29818c;

    /* renamed from: d */
    private Paint f29819d;

    /* renamed from: e */
    private int f29820e;

    /* renamed from: f */
    private int f29821f;

    /* renamed from: g */
    private boolean f29822g;

    /* renamed from: h */
    private int f29823h;

    /* renamed from: i */
    private boolean f29824i;

    /* renamed from: j */
    private int f29825j;
    private com.vivo.ad.view.k k;
    private int l;
    private int m;
    private int n;
    private int o;
    private float p;
    private com.vivo.ad.model.b q;
    private String r;
    private String s;
    private String t;

    /* renamed from: com.vivo.mobilead.unified.base.view.a$a */
    class C0618a extends AnimatorListenerAdapter {
        C0618a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            if (a.this.f29820e != 0) {
                a.this.f29821f += a.this.f29823h;
                a.this.f29821f %= a.this.f29820e * 2;
                a.this.invalidate();
            }
        }
    }

    public a(Context context) {
        this(context, null);
    }

    private void f() {
        int currentTextColor = getCurrentTextColor();
        this.f29825j = currentTextColor;
        int argb = Color.argb(120, Color.red(currentTextColor), Color.green(this.f29825j), Color.blue(this.f29825j));
        float f2 = -this.f29820e;
        int i2 = this.f29825j;
        this.f29817b = new LinearGradient(f2, 0.0f, 0.0f, 0.0f, new int[]{i2, argb, i2}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.f29818c = new Matrix();
    }

    private void g() {
        f();
        if (this.f29816a == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(1, 100);
            this.f29816a = ofInt;
            ofInt.setDuration(50L);
            this.f29816a.setInterpolator(new AccelerateDecelerateInterpolator());
            this.f29816a.setRepeatCount(-1);
            this.f29816a.setRepeatMode(1);
            this.f29816a.addListener(new C0618a());
        }
        if (this.f29816a.isRunning()) {
            return;
        }
        this.f29822g = true;
        this.f29816a.start();
    }

    private void h() {
        ValueAnimator valueAnimator = this.f29816a;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f29822g = false;
        clearAnimation();
        this.f29816a.cancel();
        Paint paint = this.f29819d;
        if (paint != null) {
            paint.setShader(null);
        }
    }

    public void d() {
        a(getContext(), 15.0f, 103.33f, 33.33f, 4, 16.67f);
    }

    public void e() {
        a(getContext(), 12.0f, 77.33f, 25.67f, 4, 13.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f29824i) {
            g();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.vivo.ad.view.k kVar = this.k;
        if (kVar != null) {
            if (kVar instanceof com.vivo.ad.view.m) {
                ((com.vivo.ad.view.m) kVar).a(view, this.l, this.m, this.n, this.o, -1.0d, -1.0d, true, 1);
            } else {
                kVar.a(view, this.l, this.m, this.n, this.o, true);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
        com.vivo.mobilead.c.b.e().a(this.s, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        TextPaint paint = getPaint();
        this.f29819d = paint;
        if (!this.f29824i || this.f29818c == null || !this.f29822g) {
            paint.setShader(null);
            return;
        }
        if (this.f29825j != getCurrentTextColor()) {
            f();
        }
        this.f29818c.setTranslate(this.f29821f, 0.0f);
        this.f29817b.setLocalMatrix(this.f29818c);
        this.f29819d.setShader(this.f29817b);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (getMeasuredWidth() <= 0 || getText().length() <= 0) {
            return;
        }
        this.f29820e = getMeasuredWidth();
        f();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.l = (int) motionEvent.getRawX();
            this.m = (int) motionEvent.getRawY();
            this.n = (int) motionEvent.getX();
            this.o = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z && this.f29824i) {
            g();
        } else {
            h();
        }
    }

    public void setDelta(int i2) {
        this.f29823h = i2;
    }

    public void setInstallText(String str) {
        StateListDrawable a2;
        this.t = str;
        Context context = getContext();
        String str2 = "#5C81FF";
        if ("立即打开".equals(str) || "查看详情".equals(str)) {
            a2 = com.vivo.ad.h.b.f.a(context, this.p, "#EFF2FE", "#DEE6FD");
        } else {
            a2 = com.vivo.ad.h.b.f.a(context, this.p, "#5C81FF", "#5374E6");
            str2 = "#ffffff";
        }
        setTextColor(Color.parseColor(str2));
        setBackground(a2);
        setText(str);
        if ("下载中".equals(str)) {
            a(true);
        } else {
            a(false);
        }
    }

    public void setOnAWClickListener(com.vivo.ad.view.k kVar) {
        this.k = kVar;
    }

    public void setText(com.vivo.ad.model.b bVar) {
        StateListDrawable a2;
        if (bVar == null) {
            return;
        }
        this.q = bVar;
        Context context = getContext();
        String a3 = com.vivo.mobilead.util.f.a(context, bVar);
        this.t = a3;
        String str = "#5C81FF";
        if ("立即打开".equals(a3) || "查看详情".equals(this.t)) {
            a2 = com.vivo.ad.h.b.f.a(context, this.p, "#EFF2FE", "#DEE6FD");
        } else {
            a2 = com.vivo.ad.h.b.f.a(context, this.p, "#5C81FF", "#5374E6");
            str = "#ffffff";
        }
        setTextColor(Color.parseColor(str));
        setBackground(a2);
        setText(this.t);
        a(this.q);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i2, float f2) {
        super.setTextSize(i2, f2);
        Paint paint = this.f29819d;
        if (paint != null) {
            paint.setTextSize(com.vivo.mobilead.util.m.a(getContext(), f2));
            invalidate();
        }
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void b() {
        a(getContext(), 17.0f, 133.33f, 33.33f, 4, 30.0f);
    }

    public void c() {
        a(getContext(), 18.0f, 206.67f, 41.33f, 8, 30.0f);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29820e = 0;
        this.f29821f = 0;
        this.f29822g = false;
        this.f29823h = 15;
        this.f29824i = false;
        setOnClickListener(this);
        setGravity(17);
    }

    private void a(Context context, float f2, float f3, float f4, int i2, float f5) {
        StateListDrawable a2;
        if (context == null) {
            return;
        }
        this.p = f5;
        if (!"立即打开".equals(this.t) && !"查看详情".equals(this.t)) {
            a2 = com.vivo.ad.h.b.f.a(context, this.p, "#5C81FF", "#5374E6");
        } else {
            a2 = com.vivo.ad.h.b.f.a(context, this.p, "#EFF2FE", "#DEE6FD");
        }
        setBackground(a2);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxEms(i2);
        setTextSize(1, f2);
        setWidth(com.vivo.mobilead.util.m.a(context, f3));
        setHeight(com.vivo.mobilead.util.m.a(context, f4));
    }

    @Override // android.widget.TextView
    public void setTextSize(float f2) {
        super.setTextSize(1, f2);
        Paint paint = this.f29819d;
        if (paint != null) {
            paint.setTextSize(f2);
            invalidate();
        }
    }

    public void a(boolean z) {
        this.f29824i = z;
        if (z) {
            g();
        } else {
            h();
        }
    }

    public void a() {
        com.vivo.mobilead.c.b.e().a(this.s, this);
        h();
    }

    private void a(com.vivo.ad.model.b bVar) {
        q y;
        if (SystemUtils.isVivoPhone() || bVar == null || (y = bVar.y()) == null) {
            return;
        }
        this.r = y.k();
        this.s = y.a();
        if (TextUtils.isEmpty(this.r) || TextUtils.isEmpty(this.s)) {
            return;
        }
        com.vivo.mobilead.c.b.e().a(this, bVar);
    }
}
