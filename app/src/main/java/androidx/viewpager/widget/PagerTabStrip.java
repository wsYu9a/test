package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

/* loaded from: classes.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private static final String s = "PagerTabStrip";
    private static final int t = 3;
    private static final int u = 6;
    private static final int v = 16;
    private static final int w = 32;
    private static final int x = 64;
    private static final int y = 1;
    private static final int z = 32;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private final Paint G;
    private final Rect H;
    private int I;
    private boolean J;
    private boolean K;
    private int L;
    private boolean M;
    private float N;
    private float O;
    private int P;

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PagerTabStrip.this.f4041e.setCurrentItem(r2.getCurrentItem() - 1);
        }
    }

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f4041e;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public PagerTabStrip(@NonNull Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void c(int i2, float f2, boolean z2) {
        Rect rect = this.H;
        int height = getHeight();
        int left = this.f4043g.getLeft() - this.F;
        int right = this.f4043g.getRight() + this.F;
        int i3 = height - this.B;
        rect.set(left, i3, right, height);
        super.c(i2, f2, z2);
        this.I = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f4043g.getLeft() - this.F, i3, this.f4043g.getRight() + this.F, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.J;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.E);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.A;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f4043g.getLeft() - this.F;
        int right = this.f4043g.getRight() + this.F;
        int i2 = height - this.B;
        this.G.setColor((this.I << 24) | (this.A & 16777215));
        float f2 = height;
        canvas.drawRect(left, i2, right, f2, this.G);
        if (this.J) {
            this.G.setColor((-16777216) | (this.A & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.L, getWidth() - getPaddingRight(), f2, this.G);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.M) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (action == 0) {
            this.N = x2;
            this.O = y2;
            this.M = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x2 - this.N) > this.P || Math.abs(y2 - this.O) > this.P)) {
                this.M = true;
            }
        } else if (x2 < this.f4043g.getLeft() - this.F) {
            ViewPager viewPager = this.f4041e;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x2 > this.f4043g.getRight() + this.F) {
            ViewPager viewPager2 = this.f4041e;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        super.setBackgroundColor(i2);
        if (this.K) {
            return;
        }
        this.J = (i2 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.K) {
            return;
        }
        this.J = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        if (this.K) {
            return;
        }
        this.J = i2 == 0;
    }

    public void setDrawFullUnderline(boolean z2) {
        this.J = z2;
        this.K = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.C;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(@ColorInt int i2) {
        this.A = i2;
        this.G.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i2) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i2));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i2) {
        int i3 = this.D;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.G = paint;
        this.H = new Rect();
        this.I = 255;
        this.J = false;
        this.K = false;
        int i2 = this.r;
        this.A = i2;
        paint.setColor(i2);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.B = (int) ((3.0f * f2) + 0.5f);
        this.C = (int) ((6.0f * f2) + 0.5f);
        this.D = (int) (64.0f * f2);
        this.F = (int) ((16.0f * f2) + 0.5f);
        this.L = (int) ((1.0f * f2) + 0.5f);
        this.E = (int) ((f2 * 32.0f) + 0.5f);
        this.P = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f4042f.setFocusable(true);
        this.f4042f.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PagerTabStrip.this.f4041e.setCurrentItem(r2.getCurrentItem() - 1);
            }
        });
        this.f4044h.setFocusable(true);
        this.f4044h.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.f4041e;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.J = true;
        }
    }
}
