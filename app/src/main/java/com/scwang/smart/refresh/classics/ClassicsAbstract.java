package com.scwang.smart.refresh.classics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.scwang.smart.refresh.classics.ClassicsAbstract;
import com.scwang.smart.refresh.footer.classics.R;
import pf.a;
import pf.e;
import pf.f;
import tf.b;
import uf.c;

/* loaded from: classes3.dex */
public abstract class ClassicsAbstract<T extends ClassicsAbstract<?>> extends b implements a {

    /* renamed from: r */
    public static final int f16635r = R.id.srl_classics_title;

    /* renamed from: s */
    public static final int f16636s = R.id.srl_classics_arrow;

    /* renamed from: t */
    public static final int f16637t = R.id.srl_classics_progress;

    /* renamed from: e */
    public TextView f16638e;

    /* renamed from: f */
    public ImageView f16639f;

    /* renamed from: g */
    public ImageView f16640g;

    /* renamed from: h */
    public e f16641h;

    /* renamed from: i */
    public p004if.a f16642i;

    /* renamed from: j */
    public p004if.a f16643j;

    /* renamed from: k */
    public boolean f16644k;

    /* renamed from: l */
    public boolean f16645l;

    /* renamed from: m */
    public int f16646m;

    /* renamed from: n */
    public int f16647n;

    /* renamed from: o */
    public int f16648o;

    /* renamed from: p */
    public int f16649p;

    /* renamed from: q */
    public int f16650q;

    public ClassicsAbstract(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16647n = 500;
        this.f16648o = 20;
        this.f16649p = 20;
        this.f16650q = 0;
        this.f30866c = qf.b.f30066d;
    }

    public T A(int i10) {
        ViewGroup.LayoutParams layoutParams = this.f16639f.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.f16639f.setLayoutParams(layoutParams);
        return b();
    }

    public T B(float f10) {
        ImageView imageView = this.f16639f;
        ImageView imageView2 = this.f16640g;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
        int c10 = c.c(f10);
        marginLayoutParams2.rightMargin = c10;
        marginLayoutParams.rightMargin = c10;
        imageView.setLayoutParams(marginLayoutParams);
        imageView2.setLayoutParams(marginLayoutParams2);
        return b();
    }

    public T C(int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f16639f.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f16640g.getLayoutParams();
        marginLayoutParams2.rightMargin = i10;
        marginLayoutParams.rightMargin = i10;
        this.f16639f.setLayoutParams(marginLayoutParams);
        this.f16640g.setLayoutParams(marginLayoutParams2);
        return b();
    }

    public T D(float f10) {
        ImageView imageView = this.f16640g;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int c10 = c.c(f10);
        layoutParams.width = c10;
        layoutParams.height = c10;
        imageView.setLayoutParams(layoutParams);
        return b();
    }

    public T E(int i10) {
        ViewGroup.LayoutParams layoutParams = this.f16640g.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i10;
        this.f16640g.setLayoutParams(layoutParams);
        return b();
    }

    public T F(float f10) {
        ImageView imageView = this.f16639f;
        ImageView imageView2 = this.f16640g;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int c10 = c.c(f10);
        layoutParams2.width = c10;
        layoutParams.width = c10;
        int c11 = c.c(f10);
        layoutParams2.height = c11;
        layoutParams.height = c11;
        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        return b();
    }

    public T G(int i10) {
        ViewGroup.LayoutParams layoutParams = this.f16639f.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f16640g.getLayoutParams();
        layoutParams2.width = i10;
        layoutParams.width = i10;
        layoutParams2.height = i10;
        layoutParams.height = i10;
        this.f16639f.setLayoutParams(layoutParams);
        this.f16640g.setLayoutParams(layoutParams2);
        return b();
    }

    public T H(int i10) {
        this.f16647n = i10;
        return b();
    }

    public T I(@ColorInt int i10) {
        this.f16645l = true;
        this.f16646m = i10;
        e eVar = this.f16641h;
        if (eVar != null) {
            eVar.c(this, i10);
        }
        return b();
    }

    public T J(@ColorRes int i10) {
        I(ContextCompat.getColor(getContext(), i10));
        return b();
    }

    public T K(Bitmap bitmap) {
        this.f16643j = null;
        this.f16640g.setImageBitmap(bitmap);
        return b();
    }

    public T L(Drawable drawable) {
        this.f16643j = null;
        this.f16640g.setImageDrawable(drawable);
        return b();
    }

    public T M(@DrawableRes int i10) {
        this.f16643j = null;
        this.f16640g.setImageResource(i10);
        return b();
    }

    public T N(qf.b bVar) {
        this.f30866c = bVar;
        return b();
    }

    public T O(float f10) {
        this.f16638e.setTextSize(f10);
        e eVar = this.f16641h;
        if (eVar != null) {
            eVar.n(this);
        }
        return b();
    }

    public T P(int i10, float f10) {
        this.f16638e.setTextSize(i10, f10);
        e eVar = this.f16641h;
        if (eVar != null) {
            eVar.n(this);
        }
        return b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T b() {
        return this;
    }

    @Override // tf.b, pf.a
    public void d(@NonNull e eVar, int i10, int i11) {
        this.f16641h = eVar;
        eVar.c(this, this.f16646m);
    }

    @Override // tf.b, pf.a
    public void l(@NonNull f fVar, int i10, int i11) {
        t(fVar, i10, i11);
    }

    @Override // tf.b, pf.a
    public int o(@NonNull f fVar, boolean z10) {
        ImageView imageView = this.f16640g;
        Object drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.f16647n;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.f16639f;
        ImageView imageView2 = this.f16640g;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Object drawable = this.f16640g.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f16650q == 0) {
            this.f16648o = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.f16649p = paddingBottom;
            if (this.f16648o == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i12 = this.f16648o;
                if (i12 == 0) {
                    i12 = c.c(20.0f);
                }
                this.f16648o = i12;
                int i13 = this.f16649p;
                if (i13 == 0) {
                    i13 = c.c(20.0f);
                }
                this.f16649p = i13;
                setPadding(paddingLeft, this.f16648o, paddingRight, i13);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            int size = View.MeasureSpec.getSize(i11);
            int i14 = this.f16650q;
            if (size < i14) {
                int i15 = (size - i14) / 2;
                setPadding(getPaddingLeft(), i15, getPaddingRight(), i15);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.f16648o, getPaddingRight(), this.f16649p);
        }
        super.onMeasure(i10, i11);
        if (this.f16650q == 0) {
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                int measuredHeight = getChildAt(i16).getMeasuredHeight();
                if (this.f16650q < measuredHeight) {
                    this.f16650q = measuredHeight;
                }
            }
        }
    }

    @Override // tf.b, pf.a
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.f16645l) {
                I(iArr[0]);
                this.f16645l = false;
            }
            if (this.f16644k) {
                return;
            }
            if (iArr.length > 1) {
                u(iArr[1]);
            }
            this.f16644k = false;
        }
    }

    @Override // tf.b, pf.a
    public void t(@NonNull f fVar, int i10, int i11) {
        ImageView imageView = this.f16640g;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Object drawable = this.f16640g.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    public T u(@ColorInt int i10) {
        this.f16644k = true;
        this.f16638e.setTextColor(i10);
        p004if.a aVar = this.f16642i;
        if (aVar != null) {
            aVar.a(i10);
            this.f16639f.invalidateDrawable(this.f16642i);
        }
        p004if.a aVar2 = this.f16643j;
        if (aVar2 != null) {
            aVar2.a(i10);
            this.f16640g.invalidateDrawable(this.f16643j);
        }
        return b();
    }

    public T v(@ColorRes int i10) {
        u(ContextCompat.getColor(getContext(), i10));
        return b();
    }

    public T w(Bitmap bitmap) {
        this.f16642i = null;
        this.f16639f.setImageBitmap(bitmap);
        return b();
    }

    public T x(Drawable drawable) {
        this.f16642i = null;
        this.f16639f.setImageDrawable(drawable);
        return b();
    }

    public T y(@DrawableRes int i10) {
        this.f16642i = null;
        this.f16639f.setImageResource(i10);
        return b();
    }

    public T z(float f10) {
        ImageView imageView = this.f16639f;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int c10 = c.c(f10);
        layoutParams.width = c10;
        layoutParams.height = c10;
        imageView.setLayoutParams(layoutParams);
        return b();
    }
}
