package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* renamed from: a */
    @Nullable
    Drawable f7298a;

    /* renamed from: b */
    Rect f7299b;

    /* renamed from: c */
    private Rect f7300c;

    /* renamed from: d */
    private boolean f7301d;

    /* renamed from: e */
    private boolean f7302e;

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ScrimInsetsFrameLayout scrimInsetsFrameLayout = ScrimInsetsFrameLayout.this;
            if (scrimInsetsFrameLayout.f7299b == null) {
                scrimInsetsFrameLayout.f7299b = new Rect();
            }
            ScrimInsetsFrameLayout.this.f7299b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            ScrimInsetsFrameLayout.this.a(windowInsetsCompat);
            ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.f7298a == null);
            ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    public ScrimInsetsFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    protected void a(WindowInsetsCompat windowInsetsCompat) {
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f7299b == null || this.f7298a == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f7301d) {
            this.f7300c.set(0, 0, width, this.f7299b.top);
            this.f7298a.setBounds(this.f7300c);
            this.f7298a.draw(canvas);
        }
        if (this.f7302e) {
            this.f7300c.set(0, height - this.f7299b.bottom, width, height);
            this.f7298a.setBounds(this.f7300c);
            this.f7298a.draw(canvas);
        }
        Rect rect = this.f7300c;
        Rect rect2 = this.f7299b;
        rect.set(0, rect2.top, rect2.left, height - rect2.bottom);
        this.f7298a.setBounds(this.f7300c);
        this.f7298a.draw(canvas);
        Rect rect3 = this.f7300c;
        Rect rect4 = this.f7299b;
        rect3.set(width - rect4.right, rect4.top, width, height - rect4.bottom);
        this.f7298a.setBounds(this.f7300c);
        this.f7298a.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = this.f7298a;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Drawable drawable = this.f7298a;
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public void setDrawBottomInsetForeground(boolean z) {
        this.f7302e = z;
    }

    public void setDrawTopInsetForeground(boolean z) {
        this.f7301d = z;
    }

    public void setScrimInsetForeground(@Nullable Drawable drawable) {
        this.f7298a = drawable;
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7300c = new Rect();
        this.f7301d = true;
        this.f7302e = true;
        TypedArray j2 = n.j(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i2, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f7298a = j2.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        j2.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new a());
    }
}
