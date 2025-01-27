package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: a */
    private static final int[] f1088a = {R.attr.colorBackground};

    /* renamed from: b */
    private static final CardViewImpl f1089b;

    /* renamed from: c */
    private boolean f1090c;

    /* renamed from: d */
    private boolean f1091d;

    /* renamed from: e */
    int f1092e;

    /* renamed from: f */
    int f1093f;

    /* renamed from: g */
    final Rect f1094g;

    /* renamed from: h */
    final Rect f1095h;

    /* renamed from: i */
    private final CardViewDelegate f1096i;

    /* renamed from: androidx.cardview.widget.CardView$1 */
    class AnonymousClass1 implements CardViewDelegate {

        /* renamed from: a */
        private Drawable f1097a;

        AnonymousClass1() {
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public Drawable getCardBackground() {
            return this.f1097a;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public View getCardView() {
            return CardView.this;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public boolean getPreventCornerOverlap() {
            return CardView.this.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public boolean getUseCompatPadding() {
            return CardView.this.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setCardBackground(Drawable drawable) {
            this.f1097a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setMinWidthHeightInternal(int i2, int i3) {
            CardView cardView = CardView.this;
            if (i2 > cardView.f1092e) {
                CardView.super.setMinimumWidth(i2);
            }
            CardView cardView2 = CardView.this;
            if (i3 > cardView2.f1093f) {
                CardView.super.setMinimumHeight(i3);
            }
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setShadowPadding(int i2, int i3, int i4, int i5) {
            CardView.this.f1095h.set(i2, i3, i4, i5);
            CardView cardView = CardView.this;
            Rect rect = cardView.f1094g;
            CardView.super.setPadding(i2 + rect.left, i3 + rect.top, i4 + rect.right, i5 + rect.bottom);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            f1089b = new CardViewApi21Impl();
        } else if (i2 >= 17) {
            f1089b = new CardViewApi17Impl();
        } else {
            f1089b = new CardViewBaseImpl();
        }
        f1089b.initStatic();
    }

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f1089b.getBackgroundColor(this.f1096i);
    }

    public float getCardElevation() {
        return f1089b.getElevation(this.f1096i);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.f1094g.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.f1094g.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.f1094g.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.f1094g.top;
    }

    public float getMaxCardElevation() {
        return f1089b.getMaxElevation(this.f1096i);
    }

    public boolean getPreventCornerOverlap() {
        return this.f1091d;
    }

    public float getRadius() {
        return f1089b.getRadius(this.f1096i);
    }

    public boolean getUseCompatPadding() {
        return this.f1090c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (f1089b instanceof CardViewApi21Impl) {
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinWidth(this.f1096i)), View.MeasureSpec.getSize(i2)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinHeight(this.f1096i)), View.MeasureSpec.getSize(i3)), mode2);
        }
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(@ColorInt int i2) {
        f1089b.setBackgroundColor(this.f1096i, ColorStateList.valueOf(i2));
    }

    public void setCardElevation(float f2) {
        f1089b.setElevation(this.f1096i, f2);
    }

    public void setContentPadding(@Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        this.f1094g.set(i2, i3, i4, i5);
        f1089b.updatePadding(this.f1096i);
    }

    public void setMaxCardElevation(float f2) {
        f1089b.setMaxElevation(this.f1096i, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.f1093f = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.f1092e = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f1091d) {
            this.f1091d = z;
            f1089b.onPreventCornerOverlapChanged(this.f1096i);
        }
    }

    public void setRadius(float f2) {
        f1089b.setRadius(this.f1096i, f2);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f1090c != z) {
            this.f1090c = z;
            f1089b.onCompatPaddingChanged(this.f1096i);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        f1089b.setBackgroundColor(this.f1096i, colorStateList);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f1094g = rect;
        this.f1095h = new Rect();
        AnonymousClass1 anonymousClass1 = new CardViewDelegate() { // from class: androidx.cardview.widget.CardView.1

            /* renamed from: a */
            private Drawable f1097a;

            AnonymousClass1() {
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public Drawable getCardBackground() {
                return this.f1097a;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public View getCardView() {
                return CardView.this;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.f1097a = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setMinWidthHeightInternal(int i22, int i3) {
                CardView cardView = CardView.this;
                if (i22 > cardView.f1092e) {
                    CardView.super.setMinimumWidth(i22);
                }
                CardView cardView2 = CardView.this;
                if (i3 > cardView2.f1093f) {
                    CardView.super.setMinimumHeight(i3);
                }
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setShadowPadding(int i22, int i3, int i4, int i5) {
                CardView.this.f1095h.set(i22, i3, i4, i5);
                CardView cardView = CardView.this;
                Rect rect2 = cardView.f1094g;
                CardView.super.setPadding(i22 + rect2.left, i3 + rect2.top, i4 + rect2.right, i5 + rect2.bottom);
            }
        };
        this.f1096i = anonymousClass1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i2, androidx.cardview.R.style.CardView);
        int i3 = androidx.cardview.R.styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i3)) {
            valueOf = obtainStyledAttributes.getColorStateList(i3);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f1088a);
            int color2 = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            if (fArr[2] > 0.5f) {
                color = getResources().getColor(androidx.cardview.R.color.cardview_light_background);
            } else {
                color = getResources().getColor(androidx.cardview.R.color.cardview_dark_background);
            }
            valueOf = ColorStateList.valueOf(color);
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.f1090c = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.f1091d = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f2 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f1092e = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.f1093f = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f1089b.initialize(anonymousClass1, context, colorStateList, dimension, dimension2, f2);
    }
}
