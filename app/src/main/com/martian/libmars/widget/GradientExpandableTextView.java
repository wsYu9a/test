package com.martian.libmars.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.martian.libmars.R;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes3.dex */
public class GradientExpandableTextView extends AppCompatTextView {

    /* renamed from: r */
    public static final int f12610r = 250;

    /* renamed from: s */
    public static final int f12611s = 200;

    /* renamed from: b */
    public int f12612b;

    /* renamed from: c */
    public int f12613c;

    /* renamed from: d */
    public boolean f12614d;

    /* renamed from: e */
    public boolean f12615e;

    /* renamed from: f */
    public Paint f12616f;

    /* renamed from: g */
    public float f12617g;

    /* renamed from: h */
    public float f12618h;

    /* renamed from: i */
    public float f12619i;

    /* renamed from: j */
    public float f12620j;

    /* renamed from: k */
    public boolean f12621k;

    /* renamed from: l */
    public int f12622l;

    /* renamed from: m */
    public int f12623m;

    /* renamed from: n */
    public int f12624n;

    /* renamed from: o */
    public int f12625o;

    /* renamed from: p */
    public int f12626p;

    /* renamed from: q */
    public a f12627q;

    public interface a {
        void a(boolean z10);
    }

    public GradientExpandableTextView(Context context) {
        super(context);
        this.f12614d = false;
        this.f12615e = false;
        this.f12622l = 0;
        this.f12623m = 0;
        this.f12624n = 0;
        this.f12625o = -1;
        this.f12626p = -1;
    }

    private int getGradientCenterColor() {
        return this.f12625o;
    }

    private int getGradientEndColor() {
        return this.f12626p;
    }

    private int getGradientStartColor() {
        return this.f12624n;
    }

    public final void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.GradientExpandableTextView, 0, 0);
        try {
            this.f12612b = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GradientExpandableTextView_gradientWidth, 250);
            this.f12613c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.GradientExpandableTextView_handleWidth, 200);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public boolean f() {
        return this.f12615e;
    }

    public void g(boolean z10, int i10) {
        this.f12615e = z10;
        this.f12614d = true;
        this.f12621k = true;
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), i10);
        if (z10) {
            this.f12616f = null;
        }
        invalidate();
    }

    public final void h() {
        int lineCount = getLineCount();
        int maxLines = getMaxLines();
        if (lineCount == this.f12622l && maxLines == this.f12623m && !this.f12621k) {
            return;
        }
        this.f12622l = lineCount;
        this.f12623m = maxLines;
        this.f12621k = false;
        if (lineCount <= maxLines) {
            this.f12616f = null;
            return;
        }
        Layout layout = getLayout();
        if (layout != null) {
            float lineLeft = layout.getLineLeft(maxLines - 1);
            float width = getWidth();
            float f10 = (width - this.f12612b) - this.f12613c;
            this.f12617g = f10;
            this.f12618h = width;
            if (f10 < lineLeft) {
                this.f12617g = lineLeft;
            }
            float floatValue = new BigDecimal(Float.toString((this.f12612b * 1.0f) / (r7 + this.f12613c))).setScale(2, RoundingMode.DOWN).floatValue();
            if (floatValue < 0.0f || floatValue > 1.0f) {
                floatValue = 0.5f;
            }
            Paint paint = new Paint();
            this.f12616f = paint;
            paint.set(getPaint());
            this.f12616f.setShader(new LinearGradient(this.f12617g, 0.0f, this.f12618h, 0.0f, new int[]{getGradientStartColor(), getGradientCenterColor(), getGradientEndColor()}, new float[]{0.0f, floatValue, 1.0f}, Shader.TileMode.CLAMP));
            this.f12619i = layout.getLineTop(r5);
            this.f12620j = layout.getLineBottom(r5);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f12615e && this.f12614d) {
            h();
            this.f12614d = false;
        }
        Paint paint = this.f12616f;
        if (paint != null) {
            canvas.drawRect(this.f12617g, this.f12619i, this.f12618h, this.f12620j, paint);
        }
        a aVar = this.f12627q;
        if (aVar != null) {
            aVar.a(this.f12616f != null);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f12614d = true;
    }

    public void setGradientChangedListener(a aVar) {
        this.f12627q = aVar;
    }

    public void setGradientColors(int[] iArr) {
        if (iArr.length > 0) {
            this.f12624n = iArr[0];
        }
        if (iArr.length > 1) {
            this.f12625o = iArr[1];
        }
        if (iArr.length > 2) {
            this.f12626p = iArr[2];
        }
        this.f12614d = true;
        this.f12621k = true;
        invalidate();
    }

    public void setGradientWidth(int i10) {
        this.f12612b = i10;
    }

    public GradientExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12614d = false;
        this.f12615e = false;
        this.f12622l = 0;
        this.f12623m = 0;
        this.f12624n = 0;
        this.f12625o = -1;
        this.f12626p = -1;
        a(attributeSet);
    }

    public GradientExpandableTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12614d = false;
        this.f12615e = false;
        this.f12622l = 0;
        this.f12623m = 0;
        this.f12624n = 0;
        this.f12625o = -1;
        this.f12626p = -1;
        a(attributeSet);
    }
}
