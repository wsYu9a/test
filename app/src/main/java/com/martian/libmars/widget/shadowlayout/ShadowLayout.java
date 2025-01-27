package com.martian.libmars.widget.shadowlayout;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.martian.libmars.R;
import qe.c;
import x9.b;

/* loaded from: classes3.dex */
public class ShadowLayout extends FrameLayout {

    /* renamed from: d0 */
    public static final int f12871d0 = 1;

    /* renamed from: e0 */
    public static final int f12872e0 = 2;

    /* renamed from: f0 */
    public static final int f12873f0 = 3;

    /* renamed from: g0 */
    public static final int f12874g0 = 4;
    public Drawable A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public float I;
    public int J;
    public int K;
    public float L;
    public float M;
    public boolean N;
    public Drawable O;
    public int P;
    public int Q;
    public TextView R;
    public int S;
    public int T;
    public String U;
    public String V;
    public Paint W;

    /* renamed from: a0 */
    public Path f12875a0;

    /* renamed from: b */
    public Paint f12876b;

    /* renamed from: b0 */
    public int f12877b0;

    /* renamed from: c */
    public int f12878c;

    /* renamed from: c0 */
    public View.OnClickListener f12879c0;

    /* renamed from: d */
    public float f12880d;

    /* renamed from: e */
    public float f12881e;

    /* renamed from: f */
    public float f12882f;

    /* renamed from: g */
    public float f12883g;

    /* renamed from: h */
    public float f12884h;

    /* renamed from: i */
    public float f12885i;

    /* renamed from: j */
    public float f12886j;

    /* renamed from: k */
    public float f12887k;

    /* renamed from: l */
    public boolean f12888l;

    /* renamed from: m */
    public boolean f12889m;

    /* renamed from: n */
    public boolean f12890n;

    /* renamed from: o */
    public boolean f12891o;

    /* renamed from: p */
    public int f12892p;

    /* renamed from: q */
    public int f12893q;

    /* renamed from: r */
    public int f12894r;

    /* renamed from: s */
    public int f12895s;

    /* renamed from: t */
    public RectF f12896t;

    /* renamed from: u */
    public View f12897u;

    /* renamed from: v */
    public boolean f12898v;

    /* renamed from: w */
    public boolean f12899w;

    /* renamed from: x */
    public int f12900x;

    /* renamed from: y */
    public GradientDrawable f12901y;

    /* renamed from: z */
    public Drawable f12902z;

    public class a implements View.OnLayoutChangeListener {
        public a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
            ShadowLayout.this.removeOnLayoutChangeListener(this);
            ShadowLayout shadowLayout = ShadowLayout.this;
            shadowLayout.setSelected(shadowLayout.isSelected());
        }
    }

    @RequiresApi(api = 16)
    public ShadowLayout(Context context) {
        this(context, null);
    }

    public static int b(String str) throws IllegalArgumentException {
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        return Color.parseColor(str);
    }

    public ShadowLayout A(boolean z10) {
        n();
        this.f12891o = !z10;
        x();
        return this;
    }

    public ShadowLayout B(boolean z10) {
        n();
        this.f12888l = !z10;
        x();
        return this;
    }

    public ShadowLayout C(boolean z10) {
        n();
        this.f12889m = !z10;
        x();
        return this;
    }

    public ShadowLayout D(boolean z10) {
        n();
        this.f12890n = !z10;
        x();
        return this;
    }

    public ShadowLayout E(int i10) {
        n();
        this.f12880d = i10;
        if (this.f12899w) {
            x();
        }
        return this;
    }

    public ShadowLayout F(float f10) {
        n();
        if (this.f12899w) {
            float abs = Math.abs(f10);
            float f11 = this.f12880d;
            if (abs <= f11) {
                this.f12881e = f10;
            } else if (f10 > 0.0f) {
                this.f12881e = f11;
            } else {
                this.f12881e = -f11;
            }
            x();
        }
        return this;
    }

    public ShadowLayout G(float f10) {
        n();
        if (this.f12899w) {
            float abs = Math.abs(f10);
            float f11 = this.f12880d;
            if (abs <= f11) {
                this.f12882f = f10;
            } else if (f10 > 0.0f) {
                this.f12882f = f11;
            } else {
                this.f12882f = -f11;
            }
            x();
        }
        return this;
    }

    @RequiresApi(api = 16)
    public ShadowLayout H(int i10, int i11, int i12, int i13) {
        n();
        this.f12884h = i10;
        this.f12885i = i11;
        this.f12886j = i12;
        this.f12887k = i13;
        if (getWidth() != 0 && getHeight() != 0) {
            q(getWidth(), getHeight());
        }
        return this;
    }

    public ShadowLayout I(int i10) {
        n();
        this.J = i10;
        if (this.f12900x != 2) {
            this.H = i10;
        } else if (!isSelected()) {
            this.H = this.J;
        }
        postInvalidate();
        return this;
    }

    public ShadowLayout J(int i10) {
        n();
        this.K = i10;
        if (this.f12900x == 2 && isSelected()) {
            this.H = this.K;
        }
        postInvalidate();
        return this;
    }

    public ShadowLayout K(float f10) {
        n();
        this.I = f10;
        postInvalidate();
        return this;
    }

    public final void L(Drawable drawable, String str) {
        this.f12897u.setTag(R.id.action_container, str);
        View view = this.f12897u;
        if (view == null || drawable == null) {
            return;
        }
        float f10 = this.f12884h;
        if (f10 == -1.0f && this.f12886j == -1.0f && this.f12885i == -1.0f && this.f12887k == -1.0f) {
            b.b(view, drawable, this.f12883g, str);
            return;
        }
        if (f10 == -1.0f) {
            f10 = this.f12883g;
        }
        int i10 = (int) f10;
        float f11 = this.f12886j;
        if (f11 == -1.0f) {
            f11 = this.f12883g;
        }
        int i11 = (int) f11;
        float f12 = this.f12885i;
        if (f12 == -1.0f) {
            f12 = this.f12883g;
        }
        b.a(view, drawable, i10, i11, (int) f12, this.f12887k == -1.0f ? (int) this.f12883g : (int) r5, str);
    }

    @RequiresApi(api = 16)
    public final void a() {
        View view;
        if (this.f12900x != 1 || (view = this.f12897u) == null) {
            return;
        }
        if (this.N) {
            Drawable drawable = this.f12902z;
            if (drawable != null) {
                L(drawable, "changeSwitchClickable");
            } else if (view.getBackground() != null) {
                this.f12897u.getBackground().setAlpha(0);
            }
            GradientDrawable gradientDrawable = this.f12901y;
            int i10 = this.B;
            gradientDrawable.setColors(new int[]{i10, i10});
            postInvalidate();
            return;
        }
        if (this.P != -101) {
            if (this.f12902z != null) {
                view.getBackground().setAlpha(0);
            }
            GradientDrawable gradientDrawable2 = this.f12901y;
            int i11 = this.P;
            gradientDrawable2.setColors(new int[]{i11, i11});
            postInvalidate();
            return;
        }
        Drawable drawable2 = this.O;
        if (drawable2 != null) {
            L(drawable2, "changeSwitchClickable");
            this.f12901y.setColors(new int[]{Color.parseColor("#00000000"), Color.parseColor("#00000000")});
            postInvalidate();
        }
    }

    public final Bitmap c(int i10, int i11, float f10, float f11, float f12, float f13, int i12, int i13) {
        float f14 = f12 / 4.0f;
        float f15 = f13 / 4.0f;
        int i14 = i10 / 4;
        if (i14 == 0) {
            i14 = 1;
        }
        int i15 = i11 / 4;
        if (i15 == 0) {
            i15 = 1;
        }
        float f16 = f10 / 4.0f;
        float f17 = f11 / 4.0f;
        Bitmap createBitmap = Bitmap.createBitmap(i14, i15, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(this.f12888l ? f17 : Math.max(Math.max(Math.max(f16, this.f12884h), Math.max(f16, this.f12886j)), f17) / 2.0f, this.f12890n ? f17 : Math.max(Math.max(Math.max(f16, this.f12884h), Math.max(f16, this.f12885i)), f17) / 2.0f, this.f12889m ? i14 - f17 : i14 - (Math.max(Math.max(Math.max(f16, this.f12885i), Math.max(f16, this.f12887k)), f17) / 2.0f), this.f12891o ? i15 - f17 : i15 - (Math.max(Math.max(Math.max(f16, this.f12886j), Math.max(f16, this.f12887k)), f17) / 2.0f));
        if (this.f12898v) {
            if (f15 > 0.0f) {
                rectF.top += f15;
                rectF.bottom -= f15;
            } else if (f15 < 0.0f) {
                rectF.top += Math.abs(f15);
                rectF.bottom -= Math.abs(f15);
            }
            if (f14 > 0.0f) {
                rectF.left += f14;
                rectF.right -= f14;
            } else if (f14 < 0.0f) {
                rectF.left += Math.abs(f14);
                rectF.right -= Math.abs(f14);
            }
        } else {
            rectF.top -= f15;
            rectF.bottom -= f15;
            rectF.right -= f14;
            rectF.left -= f14;
        }
        this.f12876b.setColor(i13);
        if (!isInEditMode()) {
            this.f12876b.setShadowLayer(f17 / 2.0f, f14, f15, i12);
        }
        if (this.f12886j == -1.0f && this.f12884h == -1.0f && this.f12885i == -1.0f && this.f12887k == -1.0f) {
            canvas.drawRoundRect(rectF, f16, f16, this.f12876b);
        } else {
            RectF rectF2 = this.f12896t;
            rectF2.left = this.f12892p;
            rectF2.top = this.f12893q;
            rectF2.right = getWidth() - this.f12894r;
            this.f12896t.bottom = getHeight() - this.f12895s;
            this.f12876b.setAntiAlias(true);
            float f18 = this.f12884h;
            int i16 = f18 == -1.0f ? ((int) this.f12883g) / 4 : ((int) f18) / 4;
            float f19 = this.f12886j;
            int i17 = f19 == -1.0f ? ((int) this.f12883g) / 4 : ((int) f19) / 4;
            float f20 = this.f12885i;
            int i18 = f20 == -1.0f ? ((int) this.f12883g) / 4 : ((int) f20) / 4;
            float f21 = this.f12887k;
            float f22 = i16;
            float f23 = i18;
            float f24 = f21 == -1.0f ? ((int) this.f12883g) / 4 : ((int) f21) / 4;
            float f25 = i17;
            float[] fArr = {f22, f22, f23, f23, f24, f24, f25, f25};
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, this.f12876b);
        }
        return createBitmap;
    }

    public final int d(float f10) {
        return (int) ((f10 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(api = 21)
    public void dispatchDraw(Canvas canvas) {
        RectF rectF = this.f12896t;
        int i10 = (int) (rectF.bottom - rectF.top);
        if (getChildAt(0) != null) {
            if (this.f12884h == -1.0f && this.f12886j == -1.0f && this.f12885i == -1.0f && this.f12887k == -1.0f) {
                float f10 = i10 / 2;
                if (this.f12883g > f10) {
                    Path path = new Path();
                    path.addRoundRect(this.f12896t, f10, f10, Path.Direction.CW);
                    canvas.clipPath(path);
                } else {
                    Path path2 = new Path();
                    RectF rectF2 = this.f12896t;
                    float f11 = this.f12883g;
                    path2.addRoundRect(rectF2, f11, f11, Path.Direction.CW);
                    canvas.clipPath(path2);
                }
            } else {
                float[] g10 = g(i10);
                Path path3 = new Path();
                path3.addRoundRect(this.f12892p, this.f12893q, getWidth() - this.f12894r, getHeight() - this.f12895s, g10, Path.Direction.CW);
                canvas.clipPath(path3);
            }
        }
        super.dispatchDraw(canvas);
    }

    @RequiresApi(api = 16)
    public void e(Canvas canvas, RectF rectF, float[] fArr) {
        this.f12901y.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        if (this.J != -101) {
            if (this.L != -1.0f) {
                this.f12901y.setStroke(Math.round(this.I), this.H, this.L, this.M);
            } else {
                this.f12901y.setStroke(Math.round(this.I), this.H);
            }
        }
        this.f12901y.setCornerRadii(fArr);
        this.f12901y.draw(canvas);
    }

    public void f(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width > height) {
            this.W.setStrokeWidth(height);
            this.f12875a0.reset();
            float f10 = height / 2;
            this.f12875a0.moveTo(0.0f, f10);
            this.f12875a0.lineTo(width, f10);
        } else {
            this.W.setStrokeWidth(width);
            this.f12875a0.reset();
            float f11 = width / 2;
            this.f12875a0.moveTo(f11, 0.0f);
            this.f12875a0.lineTo(f11, height);
        }
        canvas.drawPath(this.f12875a0, this.W);
    }

    public final float[] g(int i10) {
        float f10 = this.f12884h;
        if (f10 == -1.0f) {
            f10 = this.f12883g;
        }
        int i11 = (int) f10;
        int i12 = i10 / 2;
        if (i11 > i12) {
            i11 = i12;
        }
        float f11 = this.f12885i;
        if (f11 == -1.0f) {
            f11 = this.f12883g;
        }
        int i13 = (int) f11;
        if (i13 > i12) {
            i13 = i12;
        }
        float f12 = this.f12887k;
        if (f12 == -1.0f) {
            f12 = this.f12883g;
        }
        int i14 = (int) f12;
        if (i14 > i12) {
            i14 = i12;
        }
        float f13 = this.f12886j;
        int i15 = f13 == -1.0f ? (int) this.f12883g : (int) f13;
        if (i15 <= i12) {
            i12 = i15;
        }
        float f14 = i11;
        float f15 = i13;
        float f16 = i14;
        float f17 = i12;
        return new float[]{f14, f14, f15, f15, f16, f16, f17, f17};
    }

    public float getCornerRadius() {
        return this.f12883g;
    }

    public float getShadowLimit() {
        return this.f12880d;
    }

    @RequiresApi(api = 16)
    public final void h(GradientDrawable gradientDrawable) {
        if (this.N) {
            int i10 = this.E;
            gradientDrawable.setColors(i10 == -101 ? new int[]{this.D, this.F} : new int[]{this.D, i10, this.F});
            int i11 = this.G;
            if (i11 < 0) {
                this.G = (i11 % c.f30025o) + c.f30025o;
            }
            switch ((this.G % c.f30025o) / 45) {
                case 0:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                    break;
                case 1:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.BL_TR);
                    break;
                case 2:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                    break;
                case 3:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.BR_TL);
                    break;
                case 4:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                    break;
                case 5:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.TR_BL);
                    break;
                case 6:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                    break;
                case 7:
                    gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
                    break;
            }
        }
    }

    @RequiresApi(api = 16)
    public final void i(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ShadowLayout);
        this.f12900x = obtainStyledAttributes.getInt(R.styleable.ShadowLayout_hl_shapeMode, 1);
        if (m()) {
            this.J = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_strokeColor, -101);
            this.L = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashWidth, -1.0f);
            float dimension = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashGap, -1.0f);
            this.M = dimension;
            if (this.J == -101) {
                throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE,需设置stroke_color值");
            }
            float f10 = this.L;
            if (f10 == -1.0f) {
                throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE,需设置stroke_dashWidth值");
            }
            if ((f10 == -1.0f && dimension != -1.0f) || (f10 != -1.0f && dimension == -1.0f)) {
                throw new UnsupportedOperationException("使用了虚线边框,必须设置以下2个属性：ShadowLayout_hl_stroke_dashWidth，ShadowLayout_hl_stroke_dashGap");
            }
            j();
            obtainStyledAttributes.recycle();
            return;
        }
        this.f12899w = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHidden, false);
        this.f12888l = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenLeft, false);
        this.f12889m = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenRight, false);
        this.f12891o = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenBottom, false);
        this.f12890n = !obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowHiddenTop, false);
        this.f12883g = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius, 0.0f);
        this.f12884h = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_leftTop, -1.0f);
        this.f12886j = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_leftBottom, -1.0f);
        this.f12885i = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_rightTop, -1.0f);
        this.f12887k = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_cornerRadius_rightBottom, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_shadowLimit, 0.0f);
        this.f12880d = dimension2;
        if (dimension2 == 0.0f) {
            this.f12899w = false;
        }
        this.f12881e = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_shadowOffsetX, 0.0f);
        this.f12882f = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_shadowOffsetY, 0.0f);
        this.f12878c = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_shadowColor, this.f12877b0);
        this.f12898v = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_hl_shadowSymmetry, true);
        this.B = this.f12877b0;
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ShadowLayout_hl_layoutBackground);
        if (drawable != null) {
            if (drawable instanceof ColorDrawable) {
                this.B = ((ColorDrawable) drawable).getColor();
            } else {
                this.f12902z = drawable;
            }
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.ShadowLayout_hl_layoutBackground_true);
        if (drawable2 != null) {
            if (drawable2 instanceof ColorDrawable) {
                this.C = ((ColorDrawable) drawable2).getColor();
            } else {
                this.A = drawable2;
            }
        }
        if (this.C != -101 && this.f12902z != null) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，必须先设置ShadowLayout_hl_layoutBackground属性。且设置颜色时，必须保持都为颜色");
        }
        if (this.f12902z == null && this.A != null) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，必须先设置ShadowLayout_hl_layoutBackground属性。且设置图片时，必须保持都为图片");
        }
        this.J = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_strokeColor, -101);
        int color = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_strokeColor_true, -101);
        this.K = color;
        if (this.J == -101 && color != -101) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_strokeColor_true属性，必须先设置ShadowLayout_hl_strokeColor属性");
        }
        this.I = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_strokeWith, d(1.0f));
        this.L = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashWidth, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.ShadowLayout_hl_stroke_dashGap, -1.0f);
        this.M = dimension3;
        float f11 = this.L;
        if ((f11 == -1.0f && dimension3 != -1.0f) || (f11 != -1.0f && dimension3 == -1.0f)) {
            throw new UnsupportedOperationException("使用了虚线边框,必须设置以下2个属性：ShadowLayout_hl_stroke_dashWidth，ShadowLayout_hl_stroke_dashGap");
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.ShadowLayout_hl_layoutBackground_clickFalse);
        if (drawable3 != null) {
            if (drawable3 instanceof ColorDrawable) {
                this.P = ((ColorDrawable) drawable3).getColor();
            } else {
                this.O = drawable3;
            }
        }
        this.D = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_startColor, -101);
        this.E = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_centerColor, -101);
        int color2 = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_endColor, -101);
        this.F = color2;
        if (this.D != -101 && color2 == -101) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_startColor渐变起始色，必须搭配终止色ShadowLayout_hl_endColor");
        }
        int i10 = obtainStyledAttributes.getInt(R.styleable.ShadowLayout_hl_angle, 0);
        this.G = i10;
        if (i10 % 45 != 0) {
            throw new IllegalArgumentException("Linear gradient requires 'angle' attribute to be a multiple of 45");
        }
        if (this.f12900x == 3) {
            if (this.B == -101 || this.C == -101) {
                throw new NullPointerException("使用了ShadowLayout的水波纹，必须设置使用了ShadowLayout_hl_layoutBackground和使用了ShadowLayout_hl_layoutBackground_true属性，且为颜色值");
            }
            if (this.f12902z != null) {
                this.f12900x = 1;
            }
        }
        this.Q = obtainStyledAttributes.getResourceId(R.styleable.ShadowLayout_hl_bindTextView, -1);
        this.S = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_textColor, -101);
        this.T = obtainStyledAttributes.getColor(R.styleable.ShadowLayout_hl_textColor_true, -101);
        this.U = obtainStyledAttributes.getString(R.styleable.ShadowLayout_hl_text);
        this.V = obtainStyledAttributes.getString(R.styleable.ShadowLayout_hl_text_true);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.ShadowLayout_clickable, true);
        this.N = z10;
        setClickable(z10);
        obtainStyledAttributes.recycle();
    }

    public final void j() {
        Paint paint = new Paint();
        this.W = paint;
        paint.setAntiAlias(true);
        this.W.setColor(this.J);
        this.W.setStyle(Paint.Style.STROKE);
        this.W.setPathEffect(new DashPathEffect(new float[]{this.L, this.M}, 0.0f));
        this.f12875a0 = new Path();
    }

    @RequiresApi(api = 16)
    public final void k(Context context, AttributeSet attributeSet) {
        i(attributeSet);
        if (m()) {
            return;
        }
        Paint paint = new Paint();
        this.f12876b = paint;
        paint.setAntiAlias(true);
        this.f12876b.setStyle(Paint.Style.FILL);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f12901y = gradientDrawable;
        int i10 = this.B;
        gradientDrawable.setColors(new int[]{i10, i10});
        int i11 = this.J;
        if (i11 != -101) {
            this.H = i11;
        }
        x();
    }

    public final void l(int i10) {
        if (Color.alpha(i10) == 255) {
            String hexString = Integer.toHexString(Color.red(i10));
            String hexString2 = Integer.toHexString(Color.green(i10));
            String hexString3 = Integer.toHexString(Color.blue(i10));
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            if (hexString2.length() == 1) {
                hexString2 = "0" + hexString2;
            }
            if (hexString3.length() == 1) {
                hexString3 = "0" + hexString3;
            }
            this.f12878c = b("#2a" + hexString + hexString2 + hexString3);
        }
    }

    public final boolean m() {
        return this.f12900x == 4;
    }

    public final void n() {
        if (m()) {
            throw new RuntimeException("shapeMode为MODE_DASHLINE,不允许设置此属性");
        }
    }

    @RequiresApi(api = 21)
    public final void o(float[] fArr) {
        int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[]{android.R.attr.state_activated}, new int[0]};
        int i10 = this.B;
        int i11 = this.C;
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{i11, i11, i11, i10});
        RoundRectShape roundRectShape = new RoundRectShape(fArr, null, null);
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(roundRectShape);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        if (this.J != -101) {
            if (this.L != -1.0f) {
                this.f12901y.setStroke(Math.round(this.I), this.H, this.L, this.M);
            } else {
                this.f12901y.setStroke(Math.round(this.I), this.H);
            }
        }
        this.f12901y.setCornerRadii(fArr);
        if (this.D != -101) {
            h(this.f12901y);
        }
        this.f12897u.setBackground(new RippleDrawable(colorStateList, this.f12901y, shapeDrawable));
    }

    @Override // android.view.View
    @RequiresApi(api = 21)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (m()) {
            f(canvas);
            return;
        }
        RectF rectF = this.f12896t;
        rectF.left = this.f12892p;
        rectF.top = this.f12893q;
        rectF.right = getWidth() - this.f12894r;
        this.f12896t.bottom = getHeight() - this.f12895s;
        RectF rectF2 = this.f12896t;
        int i10 = (int) (rectF2.bottom - rectF2.top);
        if (this.J != -101) {
            float f10 = i10 / 2;
            if (this.I > f10) {
                this.I = f10;
            }
        }
        if (this.f12902z == null && this.A == null) {
            float[] g10 = g(i10);
            if (this.f12900x != 3) {
                e(canvas, this.f12896t, g10);
            } else {
                o(g10);
            }
        }
    }

    @Override // android.view.View
    @RequiresApi(api = 16)
    public void onFinishInflate() {
        super.onFinishInflate();
        if (m()) {
            if (getChildAt(0) != null) {
                throw new UnsupportedOperationException("shapeMode为MODE_DASHLINE，不支持子view");
            }
            return;
        }
        int i10 = this.Q;
        if (i10 != -1) {
            TextView textView = (TextView) findViewById(i10);
            this.R = textView;
            if (textView == null) {
                throw new NullPointerException("ShadowLayout找不到hl_bindTextView，请确保绑定的资源id在ShadowLayout内");
            }
            if (this.S == -101) {
                this.S = textView.getCurrentTextColor();
            }
            if (this.T == -101) {
                this.T = this.R.getCurrentTextColor();
            }
            this.R.setTextColor(this.S);
            if (!TextUtils.isEmpty(this.U)) {
                this.R.setText(this.U);
            }
        }
        this.f12897u = getChildAt(0);
        if (this.f12902z != null && this.f12899w && this.f12880d > 0.0f && getChildAt(0) == null) {
            throw new UnsupportedOperationException("使用了图片又加上阴影的情况下，必须加上子view才会生效!~");
        }
        if (this.f12897u == null) {
            this.f12897u = this;
            this.f12899w = false;
        }
        if (this.f12897u != null) {
            if (this.f12900x == 2) {
                L(this.f12902z, "onFinishInflate");
                return;
            }
            if (this.N) {
                L(this.f12902z, "onFinishInflate");
                return;
            }
            L(this.O, "onFinishInflate");
            int i11 = this.P;
            if (i11 != -101) {
                this.f12901y.setColors(new int[]{i11, i11});
            }
        }
    }

    @Override // android.view.View
    @RequiresApi(api = 16)
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (m()) {
            setBackgroundColor(Color.parseColor("#00000000"));
            return;
        }
        if (i10 <= 0 || i11 <= 0) {
            return;
        }
        q(i10, i11);
        if (this.D != -101) {
            h(this.f12901y);
        }
    }

    @Override // android.view.View
    @RequiresApi(api = 16)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TextView textView;
        int i10 = this.f12900x;
        if (i10 == 3) {
            if (this.N) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    TextView textView2 = this.R;
                    if (textView2 != null) {
                        textView2.setTextColor(this.T);
                        if (!TextUtils.isEmpty(this.V)) {
                            this.R.setText(this.V);
                        }
                    }
                } else if ((action == 1 || action == 3) && (textView = this.R) != null) {
                    textView.setTextColor(this.S);
                    if (!TextUtils.isEmpty(this.U)) {
                        this.R.setText(this.U);
                    }
                }
            }
            return super.onTouchEvent(motionEvent);
        }
        if ((this.C != -101 || this.K != -101 || this.A != null) && this.N && i10 == 1) {
            int action2 = motionEvent.getAction();
            if (action2 == 0) {
                int i11 = this.C;
                if (i11 != -101) {
                    this.f12901y.setColors(new int[]{i11, i11});
                }
                int i12 = this.K;
                if (i12 != -101) {
                    this.H = i12;
                }
                Drawable drawable = this.A;
                if (drawable != null) {
                    L(drawable, "onTouchEvent");
                }
                postInvalidate();
                TextView textView3 = this.R;
                if (textView3 != null) {
                    textView3.setTextColor(this.T);
                    if (!TextUtils.isEmpty(this.V)) {
                        this.R.setText(this.V);
                    }
                }
            } else if (action2 == 1 || action2 == 3) {
                GradientDrawable gradientDrawable = this.f12901y;
                int i13 = this.B;
                gradientDrawable.setColors(new int[]{i13, i13});
                if (this.D != -101) {
                    h(this.f12901y);
                }
                int i14 = this.J;
                if (i14 != -101) {
                    this.H = i14;
                }
                Drawable drawable2 = this.f12902z;
                if (drawable2 != null) {
                    L(drawable2, "onTouchEvent");
                }
                postInvalidate();
                TextView textView4 = this.R;
                if (textView4 != null) {
                    textView4.setTextColor(this.S);
                    if (!TextUtils.isEmpty(this.U)) {
                        this.R.setText(this.U);
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @RequiresApi(api = 16)
    public final void q(int i10, int i11) {
        if (this.f12899w) {
            l(this.f12878c);
            setBackground(new BitmapDrawable(c(i10, i11, this.f12883g, this.f12880d, this.f12881e, this.f12882f, this.f12878c, 0)));
            return;
        }
        if (getChildAt(0) != null) {
            setBackgroundColor(Color.parseColor("#00000000"));
            return;
        }
        Drawable drawable = this.f12902z;
        if (drawable == null) {
            setBackgroundColor(Color.parseColor("#00000000"));
            return;
        }
        this.f12897u = this;
        if (this.N) {
            L(drawable, "setBackgroundCompat");
        } else {
            a();
        }
    }

    @RequiresApi(api = 16)
    public ShadowLayout r(int i10) {
        n();
        this.f12883g = i10;
        if (getWidth() != 0 && getHeight() != 0) {
            q(getWidth(), getHeight());
        }
        return this;
    }

    @RequiresApi(api = 16)
    public ShadowLayout s(int i10, int i11) {
        t(this.G, i10, i11);
        return this;
    }

    @Override // android.view.View
    @RequiresApi(api = 16)
    public void setClickable(boolean z10) {
        n();
        super.setClickable(z10);
        this.N = z10;
        a();
        if (this.N) {
            super.setOnClickListener(this.f12879c0);
        }
        GradientDrawable gradientDrawable = this.f12901y;
        if (gradientDrawable == null || this.D == -101 || this.F == -101) {
            return;
        }
        h(gradientDrawable);
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f12879c0 = onClickListener;
        if (this.N) {
            super.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    @RequiresApi(api = 16)
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        if (getWidth() == 0) {
            addOnLayoutChangeListener(new a());
            return;
        }
        if (this.f12900x == 2) {
            if (z10) {
                int i10 = this.C;
                if (i10 != -101) {
                    this.f12901y.setColors(new int[]{i10, i10});
                }
                int i11 = this.K;
                if (i11 != -101) {
                    this.H = i11;
                }
                Drawable drawable = this.A;
                if (drawable != null) {
                    L(drawable, "setSelected");
                }
                TextView textView = this.R;
                if (textView != null) {
                    textView.setTextColor(this.T);
                    if (!TextUtils.isEmpty(this.V)) {
                        this.R.setText(this.V);
                    }
                }
            } else {
                GradientDrawable gradientDrawable = this.f12901y;
                int i12 = this.B;
                gradientDrawable.setColors(new int[]{i12, i12});
                if (this.D != -101) {
                    h(this.f12901y);
                }
                int i13 = this.J;
                if (i13 != -101) {
                    this.H = i13;
                }
                Drawable drawable2 = this.f12902z;
                if (drawable2 != null) {
                    L(drawable2, "setSelected");
                }
                TextView textView2 = this.R;
                if (textView2 != null) {
                    textView2.setTextColor(this.S);
                    if (!TextUtils.isEmpty(this.U)) {
                        this.R.setText(this.U);
                    }
                }
            }
            postInvalidate();
        }
    }

    @RequiresApi(api = 16)
    public ShadowLayout t(int i10, int i11, int i12) {
        u(i10, i11, -101, i12);
        return this;
    }

    @RequiresApi(api = 16)
    public ShadowLayout u(int i10, int i11, int i12, int i13) {
        n();
        if (i10 % 45 != 0) {
            throw new IllegalArgumentException("Linear gradient requires 'angle' attribute to be a multiple of 45");
        }
        this.G = i10;
        this.D = i11;
        this.E = i12;
        this.F = i13;
        h(this.f12901y);
        postInvalidate();
        return this;
    }

    @RequiresApi(api = 16)
    public ShadowLayout v(int i10) {
        n();
        if (!this.N) {
            return this;
        }
        if (this.A != null) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground_true属性，要与ShadowLayout_hl_layoutBackground属性统一为颜色");
        }
        this.B = i10;
        this.D = -101;
        this.E = -101;
        this.F = -101;
        if (this.f12900x != 2) {
            this.f12901y.setColors(new int[]{i10, i10});
        } else if (!isSelected()) {
            GradientDrawable gradientDrawable = this.f12901y;
            int i11 = this.B;
            gradientDrawable.setColors(new int[]{i11, i11});
        }
        postInvalidate();
        return this;
    }

    @RequiresApi(api = 16)
    public ShadowLayout w(int i10) {
        n();
        if (this.f12902z != null) {
            throw new UnsupportedOperationException("使用了ShadowLayout_hl_layoutBackground属性，要与ShadowLayout_hl_layoutBackground_true属性统一为颜色");
        }
        this.C = i10;
        if (this.f12900x == 2 && isSelected()) {
            GradientDrawable gradientDrawable = this.f12901y;
            int i11 = this.C;
            gradientDrawable.setColors(new int[]{i11, i11});
        }
        postInvalidate();
        return this;
    }

    public final void x() {
        if (this.f12899w) {
            float f10 = this.f12880d;
            if (f10 > 0.0f) {
                if (this.f12898v) {
                    int abs = (int) (f10 + Math.abs(this.f12881e));
                    int abs2 = (int) (this.f12880d + Math.abs(this.f12882f));
                    if (this.f12888l) {
                        this.f12892p = abs;
                    } else {
                        this.f12892p = 0;
                    }
                    if (this.f12890n) {
                        this.f12893q = abs2;
                    } else {
                        this.f12893q = 0;
                    }
                    if (this.f12889m) {
                        this.f12894r = abs;
                    } else {
                        this.f12894r = 0;
                    }
                    if (this.f12891o) {
                        this.f12895s = abs2;
                    } else {
                        this.f12895s = 0;
                    }
                } else {
                    float abs3 = Math.abs(this.f12882f);
                    float f11 = this.f12880d;
                    if (abs3 > f11) {
                        if (this.f12882f > 0.0f) {
                            this.f12882f = f11;
                        } else {
                            this.f12882f = 0.0f - f11;
                        }
                    }
                    float abs4 = Math.abs(this.f12881e);
                    float f12 = this.f12880d;
                    if (abs4 > f12) {
                        if (this.f12881e > 0.0f) {
                            this.f12881e = f12;
                        } else {
                            this.f12881e = 0.0f - f12;
                        }
                    }
                    if (this.f12890n) {
                        this.f12893q = (int) (f12 - this.f12882f);
                    } else {
                        this.f12893q = 0;
                    }
                    if (this.f12891o) {
                        this.f12895s = (int) (this.f12882f + f12);
                    } else {
                        this.f12895s = 0;
                    }
                    if (this.f12889m) {
                        this.f12894r = (int) (f12 - this.f12881e);
                    } else {
                        this.f12894r = 0;
                    }
                    if (this.f12888l) {
                        this.f12892p = (int) (f12 + this.f12881e);
                    } else {
                        this.f12892p = 0;
                    }
                }
                setPadding(this.f12892p, this.f12893q, this.f12894r, this.f12895s);
            }
        }
    }

    @RequiresApi(api = 16)
    public ShadowLayout y(int i10) {
        n();
        this.f12878c = i10;
        if (getWidth() != 0 && getHeight() != 0) {
            q(getWidth(), getHeight());
        }
        return this;
    }

    @RequiresApi(api = 16)
    public ShadowLayout z(boolean z10) {
        n();
        this.f12899w = !z10;
        x();
        if (getWidth() != 0 && getHeight() != 0) {
            q(getWidth(), getHeight());
        }
        return this;
    }

    @RequiresApi(api = 16)
    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @RequiresApi(api = 16)
    public ShadowLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12896t = new RectF();
        this.f12899w = true;
        this.C = -101;
        this.L = -1.0f;
        this.M = -1.0f;
        this.P = -101;
        this.Q = -1;
        this.f12877b0 = Color.parseColor("#2a000000");
        k(context, attributeSet);
    }
}
