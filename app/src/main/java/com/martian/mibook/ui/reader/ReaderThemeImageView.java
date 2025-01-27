package com.martian.mibook.ui.reader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ReaderThemeImageView extends ImageView implements a, View.OnTouchListener {

    /* renamed from: b */
    public int f16027b;

    /* renamed from: c */
    public int f16028c;

    /* renamed from: d */
    public boolean f16029d;

    /* renamed from: e */
    public GradientDrawable f16030e;

    /* renamed from: f */
    public int f16031f;

    public ReaderThemeImageView(Context context) {
        super(context);
        this.f16029d = true;
        a();
    }

    private void a() {
        if (b()) {
            setOnTouchListener(this);
            setClickable(true);
        }
        p();
    }

    private boolean b() {
        return this.f16028c > 0;
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderThemeImageView);
        this.f16027b = obtainStyledAttributes.getColor(R.styleable.ReaderThemeImageView_readerImageColorFilterType, 0);
        this.f16028c = obtainStyledAttributes.getInt(R.styleable.ReaderThemeImageView_readerImageSelectableImageType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!b()) {
                return false;
            }
            setAlpha(0.6f);
            return false;
        }
        if ((action != 1 && action != 3) || !b()) {
            return false;
        }
        setAlpha(1.0f);
        return false;
    }

    @Override // k9.a
    public void p() {
        if (!isInEditMode() && this.f16029d) {
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            int i10 = this.f16027b;
            if (i10 == 9) {
                Drawable background = getBackground();
                if (background != null) {
                    background.setColorFilter(k10.getItemColorPrimary(), PorterDuff.Mode.SRC_IN);
                    return;
                }
                return;
            }
            if (i10 == 8) {
                int textColorThirdly = k10.getTextColorThirdly();
                if (this.f16030e == null || this.f16031f != textColorThirdly) {
                    this.f16031f = textColorThirdly;
                    this.f16030e = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{0, Color.argb(77, Color.red(textColorThirdly), Color.green(this.f16031f), Color.blue(this.f16031f))});
                }
                setImageDrawable(this.f16030e);
                return;
            }
            if (i10 == 7) {
                int textColorThirdly2 = k10.getTextColorThirdly();
                if (this.f16030e == null || this.f16031f != textColorThirdly2) {
                    this.f16031f = textColorThirdly2;
                    this.f16030e = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0, Color.argb(77, Color.red(textColorThirdly2), Color.green(this.f16031f), Color.blue(this.f16031f))});
                }
                setImageDrawable(this.f16030e);
                return;
            }
            if (i10 == 6) {
                setColorFilter(k10.getBackgroundColor(), PorterDuff.Mode.SRC_IN);
                return;
            }
            if (i10 == 5) {
                setBackgroundResource(R.drawable.bg_book_more_setting);
                ((GradientDrawable) getBackground()).setColor(k10.getTextColorThirdly());
                setColorFilter(k10.getPopupBackgroundColor(), PorterDuff.Mode.SRC_IN);
            } else if (i10 == 4) {
                setBackgroundResource(R.drawable.bg_book_more_setting);
                ((GradientDrawable) getBackground()).setColor(k10.getBackgroundColor());
            } else if (i10 == 3) {
                setColorFilter(k10.getItemColorPrimary(), PorterDuff.Mode.SRC_IN);
            } else if (i10 == 2) {
                setColorFilter(k10.getTextColorThirdly(), PorterDuff.Mode.SRC_IN);
            } else if (i10 >= 0) {
                setColorFilter(k10.getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
            }
        }
    }

    public void setEnableColorFilter(boolean z10) {
        this.f16029d = z10;
        if (z10) {
            p();
        }
    }

    public ReaderThemeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        c(context, attributeSet);
        a();
    }

    public ReaderThemeImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16029d = true;
        c(context, attributeSet);
        a();
    }
}
