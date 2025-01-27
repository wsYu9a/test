package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import ba.m;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t8.a;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\rH\u0014¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010!R\u0016\u0010+\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010&R\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010&R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010&R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010&R\u0016\u00105\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010&R\u0016\u00107\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010&R\u0016\u00109\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010&R\u0016\u0010;\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010&R\u0016\u0010<\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010&R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006E"}, d2 = {"Lcom/martian/mibook/ui/reader/ReaderBrokenLineView;", "Landroid/view/View;", "Lk9/a;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "", "percent", "a", "(F)V", "onAttachedToWindow", "()V", "onDetachedFromWindow", "p", "", "b", "Z", "isInitialized", "c", "I", "brokenLineColorType", "d", "brokenLineDirection", e.TAG, "F", "brokenLineWidth", "f", "brokenLineColor", "g", "brokenLineMaxDragDistance", "h", "dragDistance", "i", "mWidth", "j", "mHeight", "k", "startX", t.f11204d, "startY", "m", "endX", "n", "endY", "o", "controlX", "controlY", "Landroid/graphics/Path;", "q", "Landroid/graphics/Path;", a.f30751f, "Landroid/graphics/Paint;", t.f11211k, "Landroid/graphics/Paint;", "paint", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderBrokenLineView extends View implements k9.a {

    /* renamed from: b, reason: from kotlin metadata */
    public boolean isInitialized;

    /* renamed from: c, reason: from kotlin metadata */
    public int brokenLineColorType;

    /* renamed from: d, reason: from kotlin metadata */
    public int brokenLineDirection;

    /* renamed from: e */
    public float brokenLineWidth;

    /* renamed from: f, reason: from kotlin metadata */
    public int brokenLineColor;

    /* renamed from: g, reason: from kotlin metadata */
    public float brokenLineMaxDragDistance;

    /* renamed from: h, reason: from kotlin metadata */
    public float dragDistance;

    /* renamed from: i, reason: from kotlin metadata */
    public float mWidth;

    /* renamed from: j, reason: from kotlin metadata */
    public float mHeight;

    /* renamed from: k, reason: from kotlin metadata */
    public float startX;

    /* renamed from: l */
    public float startY;

    /* renamed from: m, reason: from kotlin metadata */
    public float endX;

    /* renamed from: n, reason: from kotlin metadata */
    public float endY;

    /* renamed from: o, reason: from kotlin metadata */
    public float controlX;

    /* renamed from: p, reason: from kotlin metadata */
    public float controlY;

    /* renamed from: q, reason: from kotlin metadata */
    @k
    public final Path t8.a.f java.lang.String;

    /* renamed from: r */
    @k
    public final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderBrokenLineView(@k Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(float percent) {
        float f10 = percent < 1.0f ? 0.0f : percent >= 1.3f ? this.brokenLineMaxDragDistance : (this.brokenLineMaxDragDistance * (percent - 1)) / 0.3f;
        this.dragDistance = f10;
        this.controlX = this.brokenLineDirection == 0 ? (this.mWidth - this.brokenLineWidth) - f10 : this.brokenLineWidth + f10;
        invalidate();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isInitialized = false;
        ConfigSingleton.D().X0(this);
    }

    @Override // android.view.View
    public void onDraw(@k Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.t8.a.f java.lang.String.reset();
        this.t8.a.f java.lang.String.moveTo(this.startX, this.startY);
        this.t8.a.f java.lang.String.lineTo(this.controlX, this.controlY);
        this.t8.a.f java.lang.String.lineTo(this.endX, this.endY);
        canvas.drawPath(this.t8.a.f java.lang.String, this.paint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.mWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        float size = View.MeasureSpec.getSize(heightMeasureSpec);
        this.mHeight = size;
        if (this.brokenLineDirection != 0) {
            float f10 = this.brokenLineWidth;
            this.startX = f10;
            this.startY = f10;
            this.endX = f10;
            this.endY = size - f10;
            this.controlX = f10 + this.dragDistance;
            this.controlY = size / 2;
            return;
        }
        float f11 = this.mWidth;
        float f12 = this.brokenLineWidth;
        this.startX = f11 - f12;
        this.startY = f12;
        this.endX = f11 - f12;
        this.endY = size - f12;
        this.controlX = (f11 - f12) - this.dragDistance;
        this.controlY = size / 2;
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        if (this.brokenLineColorType == 0) {
            this.brokenLineColor = k10.getTextColorThirdlyAlpha20();
        }
        this.paint.setColor(this.brokenLineColor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderBrokenLineView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ReaderBrokenLineView(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReaderBrokenLineView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.brokenLineWidth = m.a(context, 3.0f);
        this.brokenLineColor = -16777216;
        this.t8.a.f java.lang.String = new Path();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.brokenLineColor);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(this.brokenLineWidth);
        paint.setStyle(Paint.Style.STROKE);
        this.paint = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderBrokenLineView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.brokenLineColorType = obtainStyledAttributes.getColor(R.styleable.ReaderBrokenLineView_readerBrokenLineColorType, 0);
        this.brokenLineWidth = obtainStyledAttributes.getDimension(R.styleable.ReaderBrokenLineView_readerBrokenLineWidth, 8.0f);
        this.brokenLineMaxDragDistance = obtainStyledAttributes.getDimension(R.styleable.ReaderBrokenLineView_readerBrokenLineMaxDragDistance, 8.0f);
        this.brokenLineDirection = obtainStyledAttributes.getInt(R.styleable.ReaderBrokenLineView_readerBrokenLineDirection, 0);
        obtainStyledAttributes.recycle();
    }
}
