package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.utils.tablayout.CommonNavigator;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u001f\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\fJ/\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0015¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0015¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u0007¢\u0006\u0004\b.\u0010\u001fJ\u0015\u00100\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u0007¢\u0006\u0004\b0\u0010\u001fJ\r\u00101\u001a\u00020\u0007¢\u0006\u0004\b1\u0010,J\u0015\u00103\u001a\u00020\n2\u0006\u00102\u001a\u00020\u0007¢\u0006\u0004\b3\u0010\u001fJ\u000f\u00104\u001a\u00020\u0007H\u0016¢\u0006\u0004\b4\u0010,J\u000f\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b5\u0010,J\u000f\u00106\u001a\u00020\u0007H\u0016¢\u0006\u0004\b6\u0010,J\u000f\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010,J\u0017\u00109\u001a\u00020\n2\u0006\u00108\u001a\u00020\u0017H\u0016¢\u0006\u0004\b9\u0010:J\u0015\u0010=\u001a\u00020\n2\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\bA\u0010@J\u000f\u0010B\u001a\u00020\nH\u0002¢\u0006\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010DR\u0016\u0010G\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010FR\u0016\u0010H\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010FR\u0016\u0010I\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010FR\u0016\u0010K\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010JR\u0016\u0010M\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010FR\u0016\u0010Y\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010FR\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006\\"}, d2 = {"Lcom/martian/libmars/utils/tablayout/ClipPagerTitleView;", "Landroid/view/View;", "Lcom/martian/libmars/utils/tablayout/CommonNavigator$b;", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "index", "totalCount", "d", "b", "", "leavePercent", "", "leftToRight", e.TAG, "(IIFZ)V", "enterPercent", "c", "textStyleMode", "setTextStyleMode", "(I)V", "", "getText", "()Ljava/lang/String;", "text", "setText", "(Ljava/lang/String;)V", "getTextSize", "()F", "textSize", "setTextSize", "(F)V", "getTextColor", "()I", "textColor", "setTextColor", "selectTextColor", "setSelectTextColor", "getClipColor", "clipColor", "setClipColor", "getContentLeft", "getContentTop", "getContentRight", "getContentBottom", "enabled", "setEnabled", "(Z)V", "Landroid/graphics/Typeface;", "typeface", "setTypeFace", "(Landroid/graphics/Typeface;)V", "g", "(I)I", "a", "f", "()V", "Ljava/lang/String;", "mText", "I", "mTextColor", "mSelectTextColor", "mClipColor", "Z", "mLeftToRight", "F", "mClipPercent", "Landroid/graphics/Paint;", "h", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Rect;", "i", "Landroid/graphics/Rect;", "mTextBounds", "j", "mTextStyleMode", "k", "paintColor", t.f11204d, "Landroid/graphics/Typeface;", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ClipPagerTitleView extends View implements CommonNavigator.b {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public String mText;

    /* renamed from: c, reason: from kotlin metadata */
    public int mTextColor;

    /* renamed from: d, reason: from kotlin metadata */
    public int mSelectTextColor;

    /* renamed from: e */
    public int mClipColor;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean mLeftToRight;

    /* renamed from: g, reason: from kotlin metadata */
    public float mClipPercent;

    /* renamed from: h, reason: from kotlin metadata */
    @k
    public final Paint mPaint;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final Rect mTextBounds;

    /* renamed from: j, reason: from kotlin metadata */
    public int mTextStyleMode;

    /* renamed from: k, reason: from kotlin metadata */
    public int paintColor;

    /* renamed from: l */
    @k
    public Typeface typeface;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClipPagerTitleView(@k Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTextBounds = new Rect();
        this.mTextStyleMode = 2;
        Typeface DEFAULT = Typeface.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.typeface = DEFAULT;
        int o12 = ConfigSingleton.o1(14);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setTextSize(o12);
        int i10 = ConfigSingleton.i(10.0f);
        setPadding(i10, 0, i10, 0);
    }

    public final int a(int heightMeasureSpec) {
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.mTextBounds.height() + getPaddingTop() + getPaddingBottom() : Math.min(this.mTextBounds.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    @Override // m9.g
    public void b(int index, int totalCount) {
        int i10 = this.mTextStyleMode;
        if (i10 == 0) {
            this.mPaint.setTypeface(Typeface.create(this.typeface, 1));
        } else if (i10 == 1) {
            this.mPaint.setTypeface(Typeface.create(this.typeface, 0));
        } else {
            this.mPaint.setTypeface(Typeface.create(this.typeface, 0));
        }
        this.paintColor = this.mTextColor;
    }

    @Override // m9.g
    public void c(int index, int totalCount, float enterPercent, boolean leftToRight) {
        this.mLeftToRight = leftToRight;
        this.mClipPercent = enterPercent;
        invalidate();
    }

    @Override // m9.g
    public void d(int index, int totalCount) {
        int i10 = this.mTextStyleMode;
        if (i10 == 0) {
            this.mPaint.setTypeface(Typeface.create(this.typeface, 1));
        } else if (i10 == 1) {
            this.mPaint.setTypeface(Typeface.create(this.typeface, 1));
        } else {
            this.mPaint.setTypeface(Typeface.create(this.typeface, 0));
        }
        int i11 = this.mSelectTextColor;
        if (i11 != 0) {
            this.paintColor = i11;
        }
    }

    @Override // m9.g
    public void e(int i10, int i11, float f10, boolean z10) {
        this.mLeftToRight = !z10;
        this.mClipPercent = 1.0f - f10;
        invalidate();
    }

    public final void f() {
        Paint paint = this.mPaint;
        String str = this.mText;
        paint.getTextBounds(str, 0, str != null ? str.length() : 0, this.mTextBounds);
    }

    public final int g(int widthMeasureSpec) {
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.mTextBounds.width() + getPaddingLeft() + getPaddingRight() : Math.min(this.mTextBounds.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    /* renamed from: getClipColor, reason: from getter */
    public final int getMClipColor() {
        return this.mClipColor;
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.mTextBounds.width() / 2);
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.mTextBounds.width() / 2);
    }

    @Override // com.martian.libmars.utils.tablayout.CommonNavigator.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @l
    /* renamed from: getText, reason: from getter */
    public final String getMText() {
        return this.mText;
    }

    /* renamed from: getTextColor, reason: from getter */
    public final int getMTextColor() {
        return this.mTextColor;
    }

    public final float getTextSize() {
        return this.mPaint.getTextSize();
    }

    @Override // android.view.View
    public void onDraw(@k Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int width = (getWidth() - this.mTextBounds.width()) / 2;
        Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2);
        this.mPaint.setColor(this.paintColor);
        String str = this.mText;
        Intrinsics.checkNotNull(str);
        float f10 = width;
        float f11 = height;
        canvas.drawText(str, f10, f11, this.mPaint);
        canvas.save();
        if (this.mLeftToRight) {
            canvas.clipRect(0, 0, (int) (getWidth() * this.mClipPercent), getHeight());
        } else {
            canvas.clipRect((int) (getWidth() * (1 - this.mClipPercent)), 0, getWidth(), getHeight());
        }
        this.mPaint.setColor(this.mClipColor);
        String str2 = this.mText;
        Intrinsics.checkNotNull(str2);
        canvas.drawText(str2, f10, f11, this.mPaint);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        f();
        setMeasuredDimension(g(widthMeasureSpec), a(heightMeasureSpec));
    }

    public final void setClipColor(int clipColor) {
        this.mClipColor = clipColor;
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        setAlpha(enabled ? 1.0f : 0.6f);
    }

    public final void setSelectTextColor(int selectTextColor) {
        this.mSelectTextColor = selectTextColor;
        invalidate();
    }

    public final void setText(@k String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mText = text;
        requestLayout();
    }

    public final void setTextColor(int textColor) {
        this.mTextColor = textColor;
        invalidate();
    }

    public final void setTextSize(float textSize) {
        this.mPaint.setTextSize(textSize);
        requestLayout();
    }

    public final void setTextStyleMode(int textStyleMode) {
        this.mTextStyleMode = textStyleMode;
        requestLayout();
    }

    public final void setTypeFace(@k Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.typeface = typeface;
    }
}
