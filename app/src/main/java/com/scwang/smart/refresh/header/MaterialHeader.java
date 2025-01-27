package com.scwang.smart.refresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import com.scwang.smart.refresh.header.material.R;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import nf.c;
import pf.d;
import pf.e;
import pf.f;

/* loaded from: classes3.dex */
public class MaterialHeader extends tf.b implements d {

    /* renamed from: r */
    public static final int f16665r = 0;

    /* renamed from: s */
    public static final int f16666s = 1;

    /* renamed from: t */
    public static final int f16667t = -328966;

    /* renamed from: u */
    public static final float f16668u = 0.8f;

    /* renamed from: v */
    @VisibleForTesting
    public static final int f16669v = 40;

    /* renamed from: w */
    @VisibleForTesting
    public static final int f16670w = 56;

    /* renamed from: e */
    public boolean f16671e;

    /* renamed from: f */
    public int f16672f;

    /* renamed from: g */
    public ImageView f16673g;

    /* renamed from: h */
    public e f16674h;

    /* renamed from: i */
    public c f16675i;

    /* renamed from: j */
    public int f16676j;

    /* renamed from: k */
    public int f16677k;

    /* renamed from: l */
    public int f16678l;

    /* renamed from: m */
    public Path f16679m;

    /* renamed from: n */
    public Paint f16680n;

    /* renamed from: o */
    public RefreshState f16681o;

    /* renamed from: p */
    public boolean f16682p;

    /* renamed from: q */
    public boolean f16683q;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: b */
        public final /* synthetic */ View f16684b;

        /* renamed from: c */
        public final /* synthetic */ boolean f16685c;

        public a(View view, boolean z10) {
            this.f16684b = view;
            this.f16685c = z10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f16684b.animate().setListener(null);
            MaterialHeader.this.f16675i.start();
            MaterialHeader.this.f16674h.f(animator, this.f16685c);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16687a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f16687a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16687a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16687a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16687a[RefreshState.PullDownToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public MaterialHeader(Context context) {
        this(context, null);
    }

    public MaterialHeader b(@ColorInt int... iArr) {
        this.f16675i.e(iArr);
        return this;
    }

    @Override // tf.b, sf.i
    public void c(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ImageView imageView = this.f16673g;
        this.f16681o = refreshState2;
        if (b.f16687a[refreshState2.ordinal()] != 4) {
            return;
        }
        this.f16671e = false;
        imageView.setVisibility(0);
        imageView.setTranslationY(0.0f);
        imageView.setScaleX(1.0f);
        imageView.setScaleY(1.0f);
    }

    @Override // tf.b, pf.a
    public void d(@NonNull e eVar, int i10, int i11) {
        if (!this.f16682p) {
            eVar.b(this, false);
        }
        if (isInEditMode()) {
            int i12 = i10 / 2;
            this.f16677k = i12;
            this.f16676j = i12;
        }
        this.f16674h = eVar;
        this.f16678l = i10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.f16682p) {
            this.f16679m.reset();
            this.f16679m.lineTo(0.0f, this.f16677k);
            this.f16679m.quadTo(getMeasuredWidth() / 2.0f, this.f16677k + (this.f16676j * 1.9f), getMeasuredWidth(), this.f16677k);
            this.f16679m.lineTo(getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.f16679m, this.f16680n);
        }
        super.dispatchDraw(canvas);
    }

    @Override // tf.b, pf.a
    public boolean m(int i10, float f10, boolean z10) {
        if (this.f16682p) {
            return false;
        }
        ImageView imageView = this.f16673g;
        imageView.setAlpha(1.0f);
        imageView.setScaleX(0.0f);
        imageView.setScaleY(0.0f);
        imageView.setTranslationY((this.f16678l / 2.0f) + (this.f16672f / 2.0f));
        imageView.animate().scaleX(1.0f).scaleY(1.0f).setDuration(i10).setListener(new a(imageView, z10));
        return true;
    }

    @Override // tf.b, pf.a
    public int o(@NonNull f fVar, boolean z10) {
        ImageView imageView = this.f16673g;
        this.f16675i.stop();
        imageView.animate().scaleX(0.0f).scaleY(0.0f);
        this.f16671e = true;
        return 0;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        if (getChildCount() == 0) {
            return;
        }
        ImageView imageView = this.f16673g;
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = imageView.getMeasuredWidth();
        int measuredHeight = imageView.getMeasuredHeight();
        if (!isInEditMode() || (i14 = this.f16677k) <= 0) {
            int i15 = measuredWidth / 2;
            int i16 = measuredWidth2 / 2;
            imageView.layout(i15 - i16, -measuredHeight, i15 + i16, 0);
            return;
        }
        int i17 = i14 - (measuredHeight / 2);
        int i18 = measuredWidth / 2;
        int i19 = measuredWidth2 / 2;
        imageView.layout(i18 - i19, i17, i18 + i19, measuredHeight + i17);
        this.f16675i.k(true);
        this.f16675i.i(0.0f, 0.8f);
        this.f16675i.d(1.0f);
        imageView.setAlpha(1.0f);
        imageView.setVisibility(0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        this.f16673g.measure(View.MeasureSpec.makeMeasureSpec(this.f16672f, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f16672f, 1073741824));
    }

    @Override // tf.b, pf.a
    public void r(boolean z10, float f10, int i10, int i11, int i12) {
        RefreshState refreshState = this.f16681o;
        RefreshState refreshState2 = RefreshState.Refreshing;
        if (refreshState == refreshState2) {
            return;
        }
        if (this.f16682p) {
            this.f16677k = Math.min(i10, i11);
            this.f16676j = Math.max(0, i10 - i11);
            postInvalidate();
        }
        if (z10 || !(this.f16675i.isRunning() || this.f16671e)) {
            if (this.f16681o != refreshState2) {
                float f11 = i11;
                float max = (((float) Math.max(Math.min(1.0f, Math.abs((i10 * 1.0f) / f11)) - 0.4d, l5.c.f27899e)) * 5.0f) / 3.0f;
                double max2 = Math.max(0.0f, Math.min(Math.abs(i10) - i11, f11 * 2.0f) / f11) / 4.0f;
                float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
                this.f16675i.k(true);
                this.f16675i.i(0.0f, Math.min(0.8f, max * 0.8f));
                this.f16675i.d(Math.min(1.0f, max));
                this.f16675i.f((((max * 0.4f) - 0.25f) + (pow * 2.0f)) * 0.5f);
            }
            ImageView imageView = this.f16673g;
            float f12 = i10;
            imageView.setTranslationY(Math.min(f12, (f12 / 2.0f) + (this.f16672f / 2.0f)));
            imageView.setAlpha(Math.min(1.0f, (f12 * 4.0f) / this.f16672f));
        }
    }

    @Override // tf.b, pf.a
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f16680n.setColor(iArr[0]);
        }
    }

    @Override // tf.b, pf.a
    public void t(@NonNull f fVar, int i10, int i11) {
        this.f16675i.start();
    }

    public MaterialHeader u(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iArr2[i10] = ContextCompat.getColor(context, iArr[i10]);
        }
        return b(iArr2);
    }

    public MaterialHeader v(@ColorInt int i10) {
        this.f16673g.setBackgroundColor(i10);
        return this;
    }

    public MaterialHeader w(@ColorRes int i10) {
        v(ContextCompat.getColor(getContext(), i10));
        return this;
    }

    public MaterialHeader x(boolean z10) {
        this.f16683q = z10;
        return this;
    }

    public MaterialHeader y(boolean z10) {
        this.f16682p = z10;
        return this;
    }

    public MaterialHeader z(int i10) {
        if (i10 != 0 && i10 != 1) {
            return this;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i10 == 0) {
            this.f16672f = (int) (displayMetrics.density * 56.0f);
        } else {
            this.f16672f = (int) (displayMetrics.density * 40.0f);
        }
        this.f16673g.setImageDrawable(null);
        this.f16675i.m(i10);
        this.f16673g.setImageDrawable(this.f16675i);
        return this;
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16682p = false;
        this.f16683q = true;
        this.f30866c = qf.b.f30070h;
        setMinimumHeight(uf.c.c(100.0f));
        c cVar = new c(this);
        this.f16675i = cVar;
        cVar.e(-16737844, -48060, -10053376, -5609780, -30720);
        nf.b bVar = new nf.b(context, f16667t);
        this.f16673g = bVar;
        bVar.setImageDrawable(this.f16675i);
        this.f16673g.setAlpha(0.0f);
        addView(this.f16673g);
        this.f16672f = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.f16679m = new Path();
        Paint paint = new Paint();
        this.f16680n = paint;
        paint.setAntiAlias(true);
        this.f16680n.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialHeader);
        this.f16682p = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_srlShowBezierWave, this.f16682p);
        this.f16683q = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_srlScrollableWhenRefreshing, this.f16683q);
        this.f16680n.setColor(obtainStyledAttributes.getColor(R.styleable.MaterialHeader_srlPrimaryColor, -15614977));
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialHeader_srlShadowRadius)) {
            this.f16680n.setShadowLayer(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialHeader_srlShadowRadius, 0), 0.0f, 0.0f, obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, -16777216));
            setLayerType(1, null);
        }
        this.f16682p = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhShowBezierWave, this.f16682p);
        this.f16683q = obtainStyledAttributes.getBoolean(R.styleable.MaterialHeader_mhScrollableWhenRefreshing, this.f16683q);
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialHeader_mhPrimaryColor)) {
            this.f16680n.setColor(obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhPrimaryColor, -15614977));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialHeader_mhShadowRadius)) {
            this.f16680n.setShadowLayer(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialHeader_mhShadowRadius, 0), 0.0f, 0.0f, obtainStyledAttributes.getColor(R.styleable.MaterialHeader_mhShadowColor, -16777216));
            setLayerType(1, null);
        }
        obtainStyledAttributes.recycle();
    }
}
