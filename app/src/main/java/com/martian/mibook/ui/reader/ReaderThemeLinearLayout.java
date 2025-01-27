package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import java.util.Iterator;
import k9.a;
import l9.u0;

/* loaded from: classes3.dex */
public class ReaderThemeLinearLayout extends LinearLayout implements a, View.OnTouchListener {

    /* renamed from: b */
    public boolean f16035b;

    /* renamed from: c */
    public int f16036c;

    /* renamed from: d */
    public boolean f16037d;

    /* renamed from: e */
    public Drawable f16038e;

    /* renamed from: f */
    public int f16039f;

    public ReaderThemeLinearLayout(Context context) {
        super(context);
        this.f16035b = false;
        this.f16037d = false;
        a();
    }

    private void a() {
        if (this.f16037d) {
            setOnTouchListener(this);
            setClickable(true);
        }
        p();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderThemeLinearLayout);
        this.f16035b = obtainStyledAttributes.getBoolean(R.styleable.ReaderThemeLinearLayout_backgroundRes, false);
        this.f16037d = obtainStyledAttributes.getBoolean(R.styleable.ReaderThemeLinearLayout_selectableItemLayout, false);
        this.f16036c = obtainStyledAttributes.getInt(R.styleable.ReaderThemeLinearLayout_readerBackgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f16037d) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int i10 = this.f16036c;
            if (i10 != 19 && i10 != 23) {
                Iterator<View> it = u0.a(this).iterator();
                while (it.hasNext()) {
                    it.next().setAlpha(0.6f);
                }
                return false;
            }
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.99f, 1.0f, 0.99f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(150L);
            scaleAnimation.setFillAfter(true);
            startAnimation(scaleAnimation);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        int i11 = this.f16036c;
        if (i11 != 19 && i11 != 23) {
            Iterator<View> it2 = u0.a(this).iterator();
            while (it2.hasNext()) {
                it2.next().setAlpha(1.0f);
            }
            return false;
        }
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.99f, 1.0f, 0.99f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(150L);
        scaleAnimation2.setFillAfter(true);
        startAnimation(scaleAnimation2);
        return false;
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode() || this.f16036c < 0) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        int i10 = this.f16036c;
        if (i10 <= 0) {
            if (this.f16035b) {
                setBackground(k10.getBorderLineBackgroundLayoutDrawable(getContext()));
                return;
            } else {
                setBackgroundColor(MiConfigSingleton.b2().h2().h());
            }
        }
        switch (i10) {
            case 9:
                break;
            case 10:
                setBackgroundColor(k10.getItemColorPrimary());
                break;
            case 11:
                setBackgroundColor(k10.getBackgroundColor());
                break;
            case 12:
                setBackgroundColor(k10.getItemColorPrimary());
                setAlpha(0.05f);
                break;
            case 13:
                setBackgroundColor(MiConfigSingleton.b2().h2().s() ? MiConfigSingleton.b2().h2().h() : ContextCompat.getColor(getContext(), R.color.ad_white_alpha_bg));
                break;
            case 14:
                setBackgroundColor(k10.getTextColorPrimary());
                break;
            case 15:
                setBackground(k10.getTopRoundBgDrawable(getContext()));
                break;
            case 16:
                setBackground(k10.getBorderBackgroundLightButtonDrawable(getContext()));
                break;
            case 17:
                setBackground(k10.getRound4DpBgDrawable(getContext()));
                break;
            case 18:
                setBackgroundColor(MiConfigSingleton.b2().h2().s() ? MiConfigSingleton.b2().h2().h() : ContextCompat.getColor(getContext(), com.martian.libmars.R.color.white));
                break;
            case 19:
                setBackgroundColor(MiConfigSingleton.b2().h2().h());
                break;
            case 20:
                setBackground(k10.getRoundBgResTextThirdlyDrawable(getContext()));
                break;
            case 21:
                setBackgroundColor(k10.getTextColorThirdly());
                break;
            case 22:
                setBackground(k10.getRound8DpBgResTextThirdlyDrawable(getContext()));
                break;
            case 23:
                setBackground(k10.getRound12dpBgDrawable(getContext()));
                break;
            case 24:
                setBackgroundColor(k10.getTextColorThirdly());
                getBackground().setAlpha(5);
                break;
            case 25:
                int backgroundColor = k10.getBackgroundColor();
                if (this.f16038e == null || this.f16039f != backgroundColor) {
                    this.f16039f = backgroundColor;
                    this.f16038e = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, this.f16039f});
                }
                setBackground(this.f16038e);
                break;
            case 26:
                setBackgroundColor(k10.getTextColorThirdly());
                getBackground().setAlpha(26);
                break;
            default:
                setBackgroundColor(k10.getItemColorPrimaryLight());
                break;
        }
    }

    public void setBackgroundType(int i10) {
        this.f16036c = i10;
    }

    public ReaderThemeLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ReaderThemeLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16035b = false;
        this.f16037d = false;
        b(context, attributeSet);
        a();
    }
}
