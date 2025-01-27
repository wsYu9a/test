package com.martian.libmars.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001<B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ-\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010!\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u00100\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/martian/libmars/widget/BookCoverImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/view/View$OnTouchListener;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "", "setBookCoverDrawable", "(Landroid/graphics/drawable/Drawable;)V", "setMaskDrawable", "", "topLeft", "topRight", "bottomLeft", "bottomRight", "a", "(FFFF)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "b", "Landroid/graphics/drawable/Drawable;", "bookCoverDrawable", "c", "maskDrawable", "d", "F", "cornerRadiusTopLeft", e.TAG, "cornerRadiusTopRight", "f", "cornerRadiusBottomLeft", "g", "cornerRadiusBottomRight", "h", "I", "selectableCoverType", "i", "pressedColor", "j", "transparentColor", "Lcom/martian/libmars/widget/BookCoverImageView$CoverStyle;", "k", "Lcom/martian/libmars/widget/BookCoverImageView$CoverStyle;", "currentStyle", "CoverStyle", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookCoverImageView extends AppCompatImageView implements View.OnTouchListener {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public Drawable bookCoverDrawable;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public Drawable maskDrawable;

    /* renamed from: d, reason: from kotlin metadata */
    public float cornerRadiusTopLeft;

    /* renamed from: e */
    public float cornerRadiusTopRight;

    /* renamed from: f, reason: from kotlin metadata */
    public float cornerRadiusBottomLeft;

    /* renamed from: g, reason: from kotlin metadata */
    public float cornerRadiusBottomRight;

    /* renamed from: h, reason: from kotlin metadata */
    public int selectableCoverType;

    /* renamed from: i, reason: from kotlin metadata */
    public int pressedColor;

    /* renamed from: j, reason: from kotlin metadata */
    public int transparentColor;

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public CoverStyle currentStyle;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/martian/libmars/widget/BookCoverImageView$CoverStyle;", "", "(Ljava/lang/String;I)V", "BOOK_STYLE", "NORMAL_STYLE", "libmars_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CoverStyle extends Enum<CoverStyle> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CoverStyle[] $VALUES;
        public static final CoverStyle BOOK_STYLE = new CoverStyle("BOOK_STYLE", 0);
        public static final CoverStyle NORMAL_STYLE = new CoverStyle("NORMAL_STYLE", 1);

        private static final /* synthetic */ CoverStyle[] $values() {
            return new CoverStyle[]{BOOK_STYLE, NORMAL_STYLE};
        }

        static {
            CoverStyle[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private CoverStyle(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<CoverStyle> getEntries() {
            return $ENTRIES;
        }

        public static CoverStyle valueOf(String str) {
            return (CoverStyle) Enum.valueOf(CoverStyle.class, str);
        }

        public static CoverStyle[] values() {
            return (CoverStyle[]) $VALUES.clone();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BookCoverImageView(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(float topLeft, float topRight, float bottomLeft, float bottomRight) {
        this.cornerRadiusTopLeft = topLeft;
        this.cornerRadiusTopRight = topRight;
        this.cornerRadiusBottomLeft = bottomLeft;
        this.cornerRadiusBottomRight = bottomRight;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@k Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Path path = new Path();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        CoverStyle coverStyle = this.currentStyle;
        CoverStyle coverStyle2 = CoverStyle.BOOK_STYLE;
        if (coverStyle == coverStyle2) {
            float f10 = this.cornerRadiusTopLeft;
            float f11 = this.cornerRadiusTopRight;
            float f12 = this.cornerRadiusBottomRight;
            float f13 = this.cornerRadiusBottomLeft;
            path.addRoundRect(rectF, new float[]{f10, f10, f11, f11, f12, f12, f13, f13}, Path.Direction.CW);
        } else {
            float f14 = this.cornerRadiusTopLeft;
            float f15 = this.cornerRadiusBottomLeft;
            path.addRoundRect(rectF, new float[]{f14, f14, f14, f14, f15, f15, f15, f15}, Path.Direction.CW);
        }
        canvas.clipPath(path);
        super.onDraw(canvas);
        if (this.currentStyle != coverStyle2 || (drawable = this.maskDrawable) == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@l View v10, @l MotionEvent r42) {
        if (this.selectableCoverType <= 0) {
            return false;
        }
        Integer valueOf = r42 != null ? Integer.valueOf(r42.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            if (this.selectableCoverType == 2) {
                setColorFilter(this.pressedColor);
                return false;
            }
            setAlpha(0.6f);
            return false;
        }
        if ((valueOf == null || valueOf.intValue() != 1) && (valueOf == null || valueOf.intValue() != 3)) {
            return false;
        }
        if (this.selectableCoverType == 2) {
            setColorFilter(this.transparentColor);
            return false;
        }
        setAlpha(1.0f);
        return false;
    }

    public final void setBookCoverDrawable(@l Drawable drawable) {
        this.bookCoverDrawable = drawable;
        invalidate();
    }

    public final void setMaskDrawable(@l Drawable drawable) {
        this.maskDrawable = drawable;
        invalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BookCoverImageView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BookCoverImageView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BookCoverImageView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentStyle = CoverStyle.BOOK_STYLE;
        if (Intrinsics.areEqual(context.getPackageName(), "com.martian.qmbook.qdbook")) {
            this.currentStyle = CoverStyle.NORMAL_STYLE;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BookCoverImageView, i10, 0);
        try {
            this.bookCoverDrawable = obtainStyledAttributes.getDrawable(R.styleable.BookCoverImageView_bookCoverDrawable);
            this.maskDrawable = obtainStyledAttributes.getDrawable(R.styleable.BookCoverImageView_maskDrawable);
            this.cornerRadiusTopLeft = obtainStyledAttributes.getDimension(R.styleable.BookCoverImageView_cornerRadiusTopLeft, 0.0f);
            this.cornerRadiusTopRight = obtainStyledAttributes.getDimension(R.styleable.BookCoverImageView_cornerRadiusTopRight, 0.0f);
            this.cornerRadiusBottomLeft = obtainStyledAttributes.getDimension(R.styleable.BookCoverImageView_cornerRadiusBottomLeft, 0.0f);
            this.cornerRadiusBottomRight = obtainStyledAttributes.getDimension(R.styleable.BookCoverImageView_cornerRadiusBottomRight, 0.0f);
            this.selectableCoverType = obtainStyledAttributes.getInteger(R.styleable.BookCoverImageView_selectableCoverType, 0);
            this.pressedColor = ContextCompat.getColor(context, R.color.selector_black_pressed);
            this.transparentColor = ContextCompat.getColor(context, R.color.transparent);
            obtainStyledAttributes.recycle();
            setScaleType(ImageView.ScaleType.FIT_XY);
            Drawable drawable = this.bookCoverDrawable;
            if (drawable != null) {
                setImageDrawable(drawable);
            }
            if (this.selectableCoverType > 0) {
                setOnTouchListener(this);
                setClickable(true);
            }
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
