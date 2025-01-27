package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: a */
    private static final int[] f4037a = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: b */
    private static final int[] f4038b = {R.attr.textAllCaps};

    /* renamed from: c */
    private static final float f4039c = 0.6f;

    /* renamed from: d */
    private static final int f4040d = 16;

    /* renamed from: e */
    ViewPager f4041e;

    /* renamed from: f */
    TextView f4042f;

    /* renamed from: g */
    TextView f4043g;

    /* renamed from: h */
    TextView f4044h;

    /* renamed from: i */
    private int f4045i;

    /* renamed from: j */
    float f4046j;
    private int k;
    private int l;
    private boolean m;
    private boolean n;
    private final PageListener o;
    private WeakReference<PagerAdapter> p;
    private int q;
    int r;

    private class PageListener extends DataSetObserver implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

        /* renamed from: a */
        private int f4047a;

        PageListener() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            PagerTitleStrip.this.a(pagerAdapter, pagerAdapter2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.b(pagerTitleStrip.f4041e.getCurrentItem(), PagerTitleStrip.this.f4041e.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f2 = pagerTitleStrip2.f4046j;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            pagerTitleStrip2.c(pagerTitleStrip2.f4041e.getCurrentItem(), f2, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f4047a = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.c(i2, f2, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (this.f4047a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.b(pagerTitleStrip.f4041e.getCurrentItem(), PagerTitleStrip.this.f4041e.getAdapter());
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f2 = pagerTitleStrip2.f4046j;
                if (f2 < 0.0f) {
                    f2 = 0.0f;
                }
                pagerTitleStrip2.c(pagerTitleStrip2.f4041e.getCurrentItem(), f2, true);
            }
        }
    }

    private static class SingleLineAllCapsTransform extends SingleLineTransformationMethod {

        /* renamed from: a */
        private Locale f4049a;

        SingleLineAllCapsTransform(Context context) {
            this.f4049a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f4049a);
            }
            return null;
        }
    }

    public PagerTitleStrip(@NonNull Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new SingleLineAllCapsTransform(textView.getContext()));
    }

    void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(this.o);
            this.p = null;
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(this.o);
            this.p = new WeakReference<>(pagerAdapter2);
        }
        ViewPager viewPager = this.f4041e;
        if (viewPager != null) {
            this.f4045i = -1;
            this.f4046j = -1.0f;
            b(viewPager.getCurrentItem(), pagerAdapter2);
            requestLayout();
        }
    }

    void b(int i2, PagerAdapter pagerAdapter) {
        int count = pagerAdapter != null ? pagerAdapter.getCount() : 0;
        this.m = true;
        CharSequence charSequence = null;
        this.f4042f.setText((i2 < 1 || pagerAdapter == null) ? null : pagerAdapter.getPageTitle(i2 - 1));
        this.f4043g.setText((pagerAdapter == null || i2 >= count) ? null : pagerAdapter.getPageTitle(i2));
        int i3 = i2 + 1;
        if (i3 < count && pagerAdapter != null) {
            charSequence = pagerAdapter.getPageTitle(i3);
        }
        this.f4044h.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f4042f.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4043g.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4044h.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4045i = i2;
        if (!this.n) {
            c(i2, this.f4046j, false);
        }
        this.m = false;
    }

    void c(int i2, float f2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 != this.f4045i) {
            b(i2, this.f4041e.getAdapter());
        } else if (!z && f2 == this.f4046j) {
            return;
        }
        this.n = true;
        int measuredWidth = this.f4042f.getMeasuredWidth();
        int measuredWidth2 = this.f4043g.getMeasuredWidth();
        int measuredWidth3 = this.f4044h.getMeasuredWidth();
        int i7 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i8 = paddingRight + i7;
        int i9 = (width - (paddingLeft + i7)) - i8;
        float f3 = 0.5f + f2;
        if (f3 > 1.0f) {
            f3 -= 1.0f;
        }
        int i10 = ((width - i8) - ((int) (i9 * f3))) - i7;
        int i11 = measuredWidth2 + i10;
        int baseline = this.f4042f.getBaseline();
        int baseline2 = this.f4043g.getBaseline();
        int baseline3 = this.f4044h.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i12 = max - baseline;
        int i13 = max - baseline2;
        int i14 = max - baseline3;
        int max2 = Math.max(Math.max(this.f4042f.getMeasuredHeight() + i12, this.f4043g.getMeasuredHeight() + i13), this.f4044h.getMeasuredHeight() + i14);
        int i15 = this.l & 112;
        if (i15 == 16) {
            i3 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else {
            if (i15 != 80) {
                i4 = i12 + paddingTop;
                i5 = i13 + paddingTop;
                i6 = paddingTop + i14;
                TextView textView = this.f4043g;
                textView.layout(i10, i5, i11, textView.getMeasuredHeight() + i5);
                int min = Math.min(paddingLeft, (i10 - this.k) - measuredWidth);
                TextView textView2 = this.f4042f;
                textView2.layout(min, i4, measuredWidth + min, textView2.getMeasuredHeight() + i4);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.k);
                TextView textView3 = this.f4044h;
                textView3.layout(max3, i6, max3 + measuredWidth3, textView3.getMeasuredHeight() + i6);
                this.f4046j = f2;
                this.n = false;
            }
            i3 = (height - paddingBottom) - max2;
        }
        i4 = i12 + i3;
        i5 = i13 + i3;
        i6 = i3 + i14;
        TextView textView4 = this.f4043g;
        textView4.layout(i10, i5, i11, textView4.getMeasuredHeight() + i5);
        int min2 = Math.min(paddingLeft, (i10 - this.k) - measuredWidth);
        TextView textView22 = this.f4042f;
        textView22.layout(min2, i4, measuredWidth + min2, textView22.getMeasuredHeight() + i4);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i11 + this.k);
        TextView textView32 = this.f4044h;
        textView32.layout(max32, i6, max32 + measuredWidth3, textView32.getMeasuredHeight() + i6);
        this.f4046j = f2;
        this.n = false;
    }

    int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        PagerAdapter adapter = viewPager.getAdapter();
        viewPager.setInternalPageChangeListener(this.o);
        viewPager.addOnAdapterChangeListener(this.o);
        this.f4041e = viewPager;
        WeakReference<PagerAdapter> weakReference = this.p;
        a(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f4041e;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            this.f4041e.setInternalPageChangeListener(null);
            this.f4041e.removeOnAdapterChangeListener(this.o);
            this.f4041e = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f4041e != null) {
            float f2 = this.f4046j;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            c(this.f4045i, f2, true);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int max;
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i2);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, (int) (size * 0.2f), -2);
        this.f4042f.measure(childMeasureSpec2, childMeasureSpec);
        this.f4043g.measure(childMeasureSpec2, childMeasureSpec);
        this.f4044h.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i3) == 1073741824) {
            max = View.MeasureSpec.getSize(i3);
        } else {
            max = Math.max(getMinHeight(), this.f4043g.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i3, this.f4043g.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.m) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i2) {
        this.l = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        int i2 = ((int) (f2 * 255.0f)) & 255;
        this.q = i2;
        int i3 = (i2 << 24) | (this.r & 16777215);
        this.f4042f.setTextColor(i3);
        this.f4044h.setTextColor(i3);
    }

    public void setTextColor(@ColorInt int i2) {
        this.r = i2;
        this.f4043g.setTextColor(i2);
        int i3 = (this.q << 24) | (this.r & 16777215);
        this.f4042f.setTextColor(i3);
        this.f4044h.setTextColor(i3);
    }

    public void setTextSize(int i2, float f2) {
        this.f4042f.setTextSize(i2, f2);
        this.f4043g.setTextSize(i2, f2);
        this.f4044h.setTextSize(i2, f2);
    }

    public void setTextSpacing(int i2) {
        this.k = i2;
        requestLayout();
    }

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4045i = -1;
        this.f4046j = -1.0f;
        this.o = new PageListener();
        TextView textView = new TextView(context);
        this.f4042f = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f4043g = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f4044h = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4037a);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.setTextAppearance(this.f4042f, resourceId);
            TextViewCompat.setTextAppearance(this.f4043g, resourceId);
            TextViewCompat.setTextAppearance(this.f4044h, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f4042f.setTextColor(color);
            this.f4043g.setTextColor(color);
            this.f4044h.setTextColor(color);
        }
        this.l = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.r = this.f4043g.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(f4039c);
        this.f4042f.setEllipsize(TextUtils.TruncateAt.END);
        this.f4043g.setEllipsize(TextUtils.TruncateAt.END);
        this.f4044h.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f4038b);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.f4042f);
            setSingleLineAllCaps(this.f4043g);
            setSingleLineAllCaps(this.f4044h);
        } else {
            this.f4042f.setSingleLine();
            this.f4043g.setSingleLine();
            this.f4044h.setSingleLine();
        }
        this.k = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
