package com.opos.exoplayer.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
final class e {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private StaticLayout G;
    private int H;
    private int I;
    private int J;
    private Rect K;

    /* renamed from: a */
    private final RectF f17481a = new RectF();

    /* renamed from: b */
    private final float f17482b;

    /* renamed from: c */
    private final float f17483c;

    /* renamed from: d */
    private final float f17484d;

    /* renamed from: e */
    private final float f17485e;

    /* renamed from: f */
    private final float f17486f;

    /* renamed from: g */
    private final float f17487g;

    /* renamed from: h */
    private final TextPaint f17488h;

    /* renamed from: i */
    private final Paint f17489i;

    /* renamed from: j */
    private CharSequence f17490j;
    private Layout.Alignment k;
    private Bitmap l;
    private float m;
    private int n;
    private int o;
    private float p;
    private int q;
    private float r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public e(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f17487g = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f17486f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f17482b = round;
        this.f17483c = round;
        this.f17484d = round;
        this.f17485e = round;
        TextPaint textPaint = new TextPaint();
        this.f17488h = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f17489i = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x014c  */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.text.SpannableStringBuilder] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.e.a():void");
    }

    private void a(Canvas canvas) {
        StaticLayout staticLayout = this.G;
        if (staticLayout == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.H, this.I);
        if (Color.alpha(this.x) > 0) {
            this.f17489i.setColor(this.x);
            canvas.drawRect(-this.J, 0.0f, staticLayout.getWidth() + this.J, staticLayout.getHeight(), this.f17489i);
        }
        if (Color.alpha(this.w) > 0) {
            this.f17489i.setColor(this.w);
            float lineTop = staticLayout.getLineTop(0);
            int lineCount = staticLayout.getLineCount();
            int i2 = 0;
            while (i2 < lineCount) {
                this.f17481a.left = staticLayout.getLineLeft(i2) - this.J;
                this.f17481a.right = staticLayout.getLineRight(i2) + this.J;
                RectF rectF = this.f17481a;
                rectF.top = lineTop;
                rectF.bottom = staticLayout.getLineBottom(i2);
                RectF rectF2 = this.f17481a;
                float f2 = rectF2.bottom;
                float f3 = this.f17482b;
                canvas.drawRoundRect(rectF2, f3, f3, this.f17489i);
                i2++;
                lineTop = f2;
            }
        }
        int i3 = this.z;
        if (i3 == 1) {
            this.f17488h.setStrokeJoin(Paint.Join.ROUND);
            this.f17488h.setStrokeWidth(this.f17483c);
            this.f17488h.setColor(this.y);
            this.f17488h.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout.draw(canvas);
        } else if (i3 == 2) {
            TextPaint textPaint = this.f17488h;
            float f4 = this.f17484d;
            float f5 = this.f17485e;
            textPaint.setShadowLayer(f4, f5, f5, this.y);
        } else if (i3 == 3 || i3 == 4) {
            boolean z = i3 == 3;
            int i4 = z ? -1 : this.y;
            int i5 = z ? this.y : -1;
            float f6 = this.f17484d / 2.0f;
            this.f17488h.setColor(this.v);
            this.f17488h.setStyle(Paint.Style.FILL);
            float f7 = -f6;
            this.f17488h.setShadowLayer(this.f17484d, f7, f7, i4);
            staticLayout.draw(canvas);
            this.f17488h.setShadowLayer(this.f17484d, f6, f6, i5);
        }
        this.f17488h.setColor(this.v);
        this.f17488h.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f17488h.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    private void a(Canvas canvas, boolean z) {
        if (z) {
            a(canvas);
        } else {
            b(canvas);
        }
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            r7 = this;
            int r0 = r7.E
            int r1 = r7.C
            int r0 = r0 - r1
            int r2 = r7.F
            int r3 = r7.D
            int r2 = r2 - r3
            float r1 = (float) r1
            float r0 = (float) r0
            float r4 = r7.p
            float r4 = r4 * r0
            float r1 = r1 + r4
            float r3 = (float) r3
            float r2 = (float) r2
            float r4 = r7.m
            float r4 = r4 * r2
            float r3 = r3 + r4
            float r4 = r7.r
            float r0 = r0 * r4
            int r0 = java.lang.Math.round(r0)
            float r4 = r7.s
            r5 = 1
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 == 0) goto L28
            goto L38
        L28:
            float r2 = (float) r0
            android.graphics.Bitmap r4 = r7.l
            int r4 = r4.getHeight()
            float r4 = (float) r4
            android.graphics.Bitmap r5 = r7.l
            int r5 = r5.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
        L38:
            float r2 = r2 * r4
            int r2 = java.lang.Math.round(r2)
            int r4 = r7.o
            r5 = 1
            r6 = 2
            if (r4 != r6) goto L47
            float r4 = (float) r0
        L45:
            float r1 = r1 - r4
            goto L4d
        L47:
            if (r4 != r5) goto L4d
            int r4 = r0 / 2
            float r4 = (float) r4
            goto L45
        L4d:
            int r1 = java.lang.Math.round(r1)
            int r4 = r7.q
            if (r4 != r6) goto L58
            float r4 = (float) r2
        L56:
            float r3 = r3 - r4
            goto L5e
        L58:
            if (r4 != r5) goto L5e
            int r4 = r2 / 2
            float r4 = (float) r4
            goto L56
        L5e:
            int r3 = java.lang.Math.round(r3)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r0 = r0 + r1
            int r2 = r2 + r3
            r4.<init>(r1, r3, r0, r2)
            r7.K = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.e.b():void");
    }

    private void b(Canvas canvas) {
        canvas.drawBitmap(this.l, (Rect) null, this.K, (Paint) null);
    }

    public void a(com.opos.exoplayer.core.f.b bVar, boolean z, boolean z2, com.opos.exoplayer.core.f.a aVar, float f2, float f3, Canvas canvas, int i2, int i3, int i4, int i5) {
        boolean z3 = bVar.f18618c == null;
        int i6 = -16777216;
        if (z3) {
            if (TextUtils.isEmpty(bVar.f18616a)) {
                return;
            } else {
                i6 = (bVar.k && z) ? bVar.l : aVar.f18555d;
            }
        }
        if (!a(this.f17490j, bVar.f18616a) || !u.a(this.k, bVar.f18617b) || this.l != bVar.f18618c || this.m != bVar.f18619d || this.n != bVar.f18620e || !u.a(Integer.valueOf(this.o), Integer.valueOf(bVar.f18621f)) || this.p != bVar.f18622g || !u.a(Integer.valueOf(this.q), Integer.valueOf(bVar.f18623h)) || this.r != bVar.f18624i || this.s != bVar.f18625j || this.t != z || this.u != z2 || this.v != aVar.f18553b || this.w != aVar.f18554c || this.x != i6 || this.z != aVar.f18556e || this.y != aVar.f18557f || !u.a(this.f17488h.getTypeface(), aVar.f18558g) || this.A != f2 || this.B != f3 || this.C != i2 || this.D != i3 || this.E != i4 || this.F != i5) {
            this.f17490j = bVar.f18616a;
            this.k = bVar.f18617b;
            this.l = bVar.f18618c;
            this.m = bVar.f18619d;
            this.n = bVar.f18620e;
            this.o = bVar.f18621f;
            this.p = bVar.f18622g;
            this.q = bVar.f18623h;
            this.r = bVar.f18624i;
            this.s = bVar.f18625j;
            this.t = z;
            this.u = z2;
            this.v = aVar.f18553b;
            this.w = aVar.f18554c;
            this.x = i6;
            this.z = aVar.f18556e;
            this.y = aVar.f18557f;
            this.f17488h.setTypeface(aVar.f18558g);
            this.A = f2;
            this.B = f3;
            this.C = i2;
            this.D = i3;
            this.E = i4;
            this.F = i5;
            if (z3) {
                a();
            } else {
                b();
            }
        }
        a(canvas, z3);
    }
}
