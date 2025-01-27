package com.martian.libmars.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0002mIB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010 \u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u0019J\u001f\u0010#\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020!H\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010)J%\u0010-\u001a\u00020\f2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020!0*j\b\u0012\u0004\u0012\u00020!`+¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020\f2\u0006\u0010/\u001a\u00020\t¢\u0006\u0004\b0\u00101J/\u00105\u001a\u00020\f2\u0006\u00102\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00103\u001a\u00020\t2\u0006\u00104\u001a\u00020\tH\u0014¢\u0006\u0004\b5\u00106J\u001f\u00109\u001a\u00020\f2\u0006\u00107\u001a\u00020\t2\u0006\u00108\u001a\u00020\tH\u0014¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b;\u0010\u0013J\r\u0010<\u001a\u00020\f¢\u0006\u0004\b<\u0010\u000fJ\u0015\u0010>\u001a\u00020\f2\u0006\u0010=\u001a\u00020\t¢\u0006\u0004\b>\u00101J\r\u0010?\u001a\u00020\t¢\u0006\u0004\b?\u0010)J\u0015\u0010B\u001a\u00020\f2\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u0015\u0010F\u001a\u00020\f2\u0006\u0010E\u001a\u00020D¢\u0006\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010S\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010RR\u0016\u0010T\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010RR\u0016\u0010U\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010RR\u0016\u0010W\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010VR\u0016\u0010X\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010VR\u0016\u0010Y\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010VR\u0016\u0010Z\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010RR\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010RR\u0016\u0010[\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010RR\u0016\u0010^\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010]R\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010]R\u0016\u0010`\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010]R\u0016\u0010a\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010RR\u0016\u0010b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010RR\u0016\u0010d\u001a\u00020\\8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010]R&\u0010,\u001a\u0012\u0012\u0004\u0012\u00020!0*j\b\u0012\u0004\u0012\u00020!`+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010l¨\u0006n"}, d2 = {"Lcom/martian/libmars/widget/DownLoadButton;", "Landroid/widget/ProgressBar;", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "p", "q", "()V", "Landroid/graphics/Canvas;", "canvas", "f", "(Landroid/graphics/Canvas;)V", "g", "j", "h", "mProgressColor", "k", "(Landroid/graphics/Canvas;I)V", "o", "", "progress", t.f11204d, "(F)V", "color", "n", "", "text", "m", "(Landroid/graphics/Canvas;Ljava/lang/String;)V", "i", "getPercent", "()Ljava/lang/String;", e.TAG, "()I", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "stateTextList", "setStateText", "(Ljava/util/ArrayList;)V", "themeColor", "setThemColor", "(I)V", IAdInterListener.AdReqParam.WIDTH, "oldw", "oldh", "onSizeChanged", "(IIII)V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "onDraw", t.f11211k, "state", "setState", "getState", "Lcom/martian/libmars/widget/DownLoadButton$b;", "mStateChangeListener", "setStateChangeListener", "(Lcom/martian/libmars/widget/DownLoadButton$b;)V", "Landroid/graphics/Typeface;", "typeface", "setTypeFace", "(Landroid/graphics/Typeface;)V", "Landroid/graphics/Paint;", "b", "Landroid/graphics/Paint;", "mPaint", "c", "textPaint", "Landroid/graphics/Path;", "d", "Landroid/graphics/Path;", "mProgressPath", "I", "mValidWidth", "mValidHeight", "mBorderColor", "F", "mBorderRadius", "mBorderWidth", "mTextSize", "mTextColor", "mFinishColor", "", "Z", "showPercent", "showBorder", "showGradientText", "mDrawableResId", "mCurrentState", "s", "canPause", bt.aO, "Ljava/util/ArrayList;", "Landroid/graphics/PorterDuffXfermode;", "u", "Landroid/graphics/PorterDuffXfermode;", "mPorterDuffMode", "v", "Lcom/martian/libmars/widget/DownLoadButton$b;", "a", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class DownLoadButton extends ProgressBar {

    /* renamed from: x */
    public static final int f12533x = 0;

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public Paint mPaint;

    /* renamed from: c, reason: from kotlin metadata */
    @k
    public Paint textPaint;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public Path mProgressPath;

    /* renamed from: e */
    public int mValidWidth;

    /* renamed from: f, reason: from kotlin metadata */
    public int mValidHeight;

    /* renamed from: g, reason: from kotlin metadata */
    public int mBorderColor;

    /* renamed from: h, reason: from kotlin metadata */
    public float mBorderRadius;

    /* renamed from: i, reason: from kotlin metadata */
    public float mBorderWidth;

    /* renamed from: j, reason: from kotlin metadata */
    public float mTextSize;

    /* renamed from: k, reason: from kotlin metadata */
    public int mTextColor;

    /* renamed from: l */
    public int mProgressColor;

    /* renamed from: m, reason: from kotlin metadata */
    public int mFinishColor;

    /* renamed from: n, reason: from kotlin metadata */
    public boolean showPercent;

    /* renamed from: o, reason: from kotlin metadata */
    public boolean showBorder;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean showGradientText;

    /* renamed from: q, reason: from kotlin metadata */
    public int mDrawableResId;

    /* renamed from: r */
    public int mCurrentState;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean canPause;

    /* renamed from: t */
    @k
    public ArrayList<String> stateTextList;

    /* renamed from: u, reason: from kotlin metadata */
    @k
    public PorterDuffXfermode mPorterDuffMode;

    /* renamed from: v, reason: from kotlin metadata */
    @l
    public b mStateChangeListener;

    /* renamed from: w */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: y */
    public static final int f12534y = 1;

    /* renamed from: z */
    public static final int f12535z = 2;
    public static final int A = 3;

    /* renamed from: com.martian.libmars.widget.DownLoadButton$a */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return DownLoadButton.f12533x;
        }

        public final int b() {
            return DownLoadButton.f12534y;
        }

        public final int c() {
            return DownLoadButton.A;
        }

        public final int d() {
            return DownLoadButton.f12535z;
        }

        public Companion() {
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownLoadButton(@k Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final String getPercent() {
        return TextUtils.concat(String.valueOf(e()), "%").toString();
    }

    public final int e() {
        return (int) (100 * ((getProgress() * 1.0f) / getMax()));
    }

    public final void f(Canvas canvas) {
        n(canvas, this.mBorderColor);
        String str = this.stateTextList.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        m(canvas, str);
    }

    public final void g(Canvas canvas) {
        String str;
        n(canvas, this.mBorderColor);
        k(canvas, this.mProgressColor);
        String str2 = "";
        if (this.showPercent) {
            str = "";
        } else {
            String str3 = this.stateTextList.get(1);
            Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
            str = str3;
        }
        m(canvas, str);
        if (!this.showPercent) {
            String str4 = this.stateTextList.get(1);
            Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
            str2 = str4;
        }
        i(canvas, str2);
        if (getProgress() == getMax()) {
            this.mCurrentState = A;
            postInvalidateDelayed(20L);
        }
    }

    /* renamed from: getState, reason: from getter */
    public final int getMCurrentState() {
        return this.mCurrentState;
    }

    public final void h(Canvas canvas) {
        n(canvas, this.mFinishColor);
        k(canvas, this.mFinishColor);
        this.showBorder = false;
        String str = this.stateTextList.get(3);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        m(canvas, str);
    }

    public final void i(Canvas canvas, String text) {
        if (this.showGradientText) {
            this.textPaint.setColor(-1);
            if (this.showPercent && TextUtils.isEmpty(text)) {
                text = getPercent();
            }
            float measureText = this.textPaint.measureText(text);
            float f10 = 2;
            float measuredWidth = (getMeasuredWidth() - measureText) / f10;
            float descent = (this.mValidHeight / 2) - ((this.textPaint.descent() + this.textPaint.ascent()) / f10);
            float progress = ((getProgress() - (100 / getMax())) * getMeasuredWidth()) / 100;
            if (progress > measuredWidth) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            canvas.clipRect(measuredWidth, 0.0f, progress, getMeasuredHeight());
            canvas.drawText(text, measuredWidth, descent, this.textPaint);
        }
    }

    public final void j(Canvas canvas) {
        n(canvas, this.mBorderColor);
        k(canvas, this.mProgressColor);
        String str = this.stateTextList.get(2);
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        m(canvas, str);
        String str2 = this.stateTextList.get(2);
        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
        i(canvas, str2);
    }

    public final void k(Canvas canvas, int mProgressColor) {
        this.mPaint.setStyle(Paint.Style.FILL);
        float progress = this.mValidWidth * ((getProgress() * 1.0f) / getMax());
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, progress, getHeight(), this.mPaint);
        o(canvas);
        this.mPaint.setColor(mProgressColor);
        l(progress);
        this.mPaint.setXfermode(this.mPorterDuffMode);
        canvas.drawPath(this.mProgressPath, this.mPaint);
        canvas.restoreToCount(saveLayer);
        this.mPaint.setXfermode(null);
    }

    public final void l(float f10) {
        this.mProgressPath.reset();
        this.mProgressPath.addRect(new RectF(0.0f, 0.0f, f10, this.mValidHeight), Path.Direction.CCW);
    }

    public final void m(Canvas canvas, String text) {
        this.textPaint.setColor(this.showBorder ? this.mTextColor : -1);
        if (this.showPercent && TextUtils.isEmpty(text)) {
            text = getPercent();
        }
        float measureText = this.textPaint.measureText(text);
        float descent = this.textPaint.descent() + this.textPaint.ascent();
        if (this.mDrawableResId == -1 || this.mCurrentState != f12533x) {
            float f10 = 2;
            canvas.drawText(text, (this.mValidWidth / 2) - (measureText / f10), (this.mValidHeight / 2) - (descent / f10), this.textPaint);
            return;
        }
        Drawable drawable = ContextCompat.getDrawable(getContext(), this.mDrawableResId);
        float intrinsicWidth = drawable != null ? drawable.getIntrinsicWidth() : 0;
        float intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
        float f11 = 2;
        float f12 = (this.mValidWidth / 2) - ((measureText + intrinsicWidth) / f11);
        float max = (this.mValidHeight / 2) - (Math.max(descent, intrinsicHeight) / f11);
        if (drawable != null) {
            drawable.setBounds((int) f12, (int) max, (int) (f12 + intrinsicWidth), (int) (max + intrinsicHeight));
            drawable.draw(canvas);
        }
        canvas.drawText(text, f12 + intrinsicWidth, (max + (intrinsicHeight / f11)) - (descent / f11), this.textPaint);
    }

    public final void n(Canvas canvas, int color) {
        if (this.showBorder) {
            this.mPaint.setStyle(Paint.Style.STROKE);
        } else {
            this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        this.mPaint.setStrokeWidth(this.mBorderWidth);
        this.mPaint.setColor(color);
        float f10 = this.mBorderWidth;
        RectF rectF = new RectF(f10, f10, this.mValidWidth - f10, this.mValidHeight - f10);
        float f11 = this.mBorderRadius;
        canvas.drawRoundRect(rectF, f11, f11, this.mPaint);
    }

    public final void o(Canvas canvas) {
        float f10 = this.mBorderWidth;
        float f11 = 2;
        RectF rectF = new RectF(f10 + f11, f10 + f11, (this.mValidWidth - f10) - f11, (this.mValidHeight - f10) - f11);
        float f12 = this.mBorderRadius;
        canvas.drawRoundRect(rectF, f12, f12, this.mPaint);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDraw(@k Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i10 = this.mCurrentState;
        if (i10 == f12533x) {
            f(canvas);
            return;
        }
        if (i10 == f12534y) {
            g(canvas);
        } else if (i10 == f12535z) {
            j(canvas);
        } else if (i10 == A) {
            h(canvas);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        float f10 = 2;
        int measureText = (int) (this.textPaint.measureText(this.stateTextList.get(0)) + (this.mBorderWidth * f10));
        int descent = (int) (this.textPaint.descent() + Math.abs(this.textPaint.ascent()) + (this.mBorderWidth * f10));
        if (getLayoutParams().width == -2 && getLayoutParams().height == -2) {
            setMeasuredDimension(measureText, descent);
        } else if (getLayoutParams().width == -2) {
            setMeasuredDimension(measureText, size2);
        } else if (getLayoutParams().height == -2) {
            setMeasuredDimension(size, descent);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int r12, int h10, int oldw, int oldh) {
        super.onSizeChanged(r12, h10, oldw, oldh);
        this.mValidWidth = (getWidth() - getPaddingLeft()) - getPaddingRight();
        this.mValidHeight = (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final void p(Context r22, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = r22.obtainStyledAttributes(attrs, R.styleable.DownloadProgressButton);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mBorderRadius = obtainStyledAttributes.getDimension(R.styleable.DownloadProgressButton_border_radius, 0.0f);
        this.mBorderWidth = obtainStyledAttributes.getDimension(R.styleable.DownloadProgressButton_border_width, 6.0f);
        this.mBorderColor = obtainStyledAttributes.getColor(R.styleable.DownloadProgressButton_border_color, -16776961);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.DownloadProgressButton_progress_textSize, 46.0f);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.DownloadProgressButton_text_color, SupportMenu.CATEGORY_MASK);
        this.mProgressColor = obtainStyledAttributes.getColor(R.styleable.DownloadProgressButton_loading_progress_color, SupportMenu.CATEGORY_MASK);
        this.mFinishColor = obtainStyledAttributes.getColor(R.styleable.DownloadProgressButton_finish_color, -16711936);
        this.showPercent = obtainStyledAttributes.getBoolean(R.styleable.DownloadProgressButton_percent_show, true);
        this.showBorder = obtainStyledAttributes.getBoolean(R.styleable.DownloadProgressButton_border_show, true);
        this.showGradientText = obtainStyledAttributes.getBoolean(R.styleable.DownloadProgressButton_gradient_text_show, false);
        this.mDrawableResId = obtainStyledAttributes.getResourceId(R.styleable.DownloadProgressButton_drawable, -1);
        obtainStyledAttributes.recycle();
    }

    public final void q() {
        this.mPaint.setAntiAlias(true);
        this.textPaint.setTextSize(this.mTextSize);
        this.textPaint.setAntiAlias(true);
    }

    public final void r() {
        if (getProgress() == 0 && this.mCurrentState == f12533x) {
            this.mCurrentState = f12534y;
            b bVar = this.mStateChangeListener;
            if (bVar != null) {
                bVar.a();
                return;
            }
            return;
        }
        int max = getMax();
        int progress = getProgress();
        if (progress >= 0 && progress <= max && this.mCurrentState == f12534y) {
            if (this.canPause) {
                this.mCurrentState = f12535z;
                b bVar2 = this.mStateChangeListener;
                if (bVar2 != null) {
                    bVar2.b();
                    return;
                }
                return;
            }
            return;
        }
        int max2 = getMax();
        int progress2 = getProgress();
        if (progress2 >= 0 && progress2 <= max2 && this.mCurrentState == f12535z) {
            this.mCurrentState = f12534y;
            b bVar3 = this.mStateChangeListener;
            if (bVar3 != null) {
                bVar3.a();
                return;
            }
            return;
        }
        if (getProgress() == getMax()) {
            int i10 = this.mCurrentState;
            int i11 = A;
            if (i10 == i11) {
                this.mCurrentState = i11;
                b bVar4 = this.mStateChangeListener;
                if (bVar4 != null) {
                    bVar4.c();
                }
            }
        }
    }

    public final void setState(int state) {
        this.mCurrentState = state;
        if (state == f12533x) {
            setProgress(0);
        }
        postInvalidateDelayed(10L);
    }

    public final void setStateChangeListener(@k b mStateChangeListener) {
        Intrinsics.checkNotNullParameter(mStateChangeListener, "mStateChangeListener");
        this.mStateChangeListener = mStateChangeListener;
    }

    public final void setStateText(@k ArrayList<String> stateTextList) {
        Intrinsics.checkNotNullParameter(stateTextList, "stateTextList");
        this.stateTextList = stateTextList;
    }

    public final void setThemColor(int themeColor) {
        this.mBorderColor = themeColor;
        this.mFinishColor = themeColor;
        this.mProgressColor = themeColor;
        invalidate();
    }

    public final void setTypeFace(@k Typeface typeface) {
        Intrinsics.checkNotNullParameter(typeface, "typeface");
        this.textPaint.setTypeface(typeface);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownLoadButton(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownLoadButton(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.textPaint = new Paint();
        this.mProgressPath = new Path();
        this.mBorderColor = -16776961;
        this.mTextColor = -16776961;
        this.mProgressColor = SupportMenu.CATEGORY_MASK;
        this.mFinishColor = -16711936;
        this.showPercent = true;
        this.showBorder = true;
        this.mDrawableResId = -1;
        this.mCurrentState = f12533x;
        this.stateTextList = CollectionsKt.arrayListOf("下载", "暂停", "继续", "已缓存");
        this.mPorterDuffMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        p(context, attributeSet);
        q();
    }
}
