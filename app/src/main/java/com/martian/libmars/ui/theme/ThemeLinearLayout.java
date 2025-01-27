package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import com.martian.theme.yellow.R;
import g.a;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ThemeLinearLayout extends LinearLayout implements a, View.OnTouchListener {

    /* renamed from: a */
    private int f10100a;

    /* renamed from: b */
    private boolean f10101b;

    public ThemeLinearLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        if (this.f10101b) {
            setOnTouchListener(this);
            setClickable(true);
        }
    }

    private void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeLinearLayout);
        this.f10100a = obtainStyledAttributes.getColor(R.styleable.ThemeLinearLayout_backgroundType, 0);
        this.f10101b = obtainStyledAttributes.getBoolean(R.styleable.ThemeLinearLayout_selectableLayout, false);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (this.f10100a == -1) {
            return;
        }
        if (h.F().I0()) {
            switch (this.f10100a) {
                case 1:
                case 2:
                    i2 = com.martian.libmars.R.color.night_background_secondary;
                    break;
                case 3:
                case 18:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_search_background_night);
                    return;
                case 4:
                    i2 = com.martian.libmars.R.color.night_highlight_color;
                    break;
                case 5:
                    setBackgroundResource(com.martian.libmars.R.drawable.theme_selectable_background_night);
                    return;
                case 6:
                case 15:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_account_grey_line_night);
                    return;
                case 7:
                case 14:
                default:
                    i2 = com.martian.libmars.R.color.night_background;
                    break;
                case 8:
                    i2 = com.martian.libmars.R.color.transparent;
                    break;
                case 9:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_round_night);
                    return;
                case 10:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_account_grey_round_night);
                    return;
                case 11:
                case 12:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_account_grey_round_night_secondary);
                    return;
                case 13:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_top_round_night);
                    return;
                case 16:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_account_grey_line_night_4dp);
                    return;
                case 17:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_light_theme_night);
                    return;
            }
        } else {
            switch (this.f10100a) {
                case 1:
                    i2 = com.martian.libmars.R.color.light_grey;
                    break;
                case 2:
                    i2 = com.martian.libmars.R.color.theme_default;
                    break;
                case 3:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_search_background_day);
                    return;
                case 4:
                    i2 = com.martian.libmars.R.color.day_highlight_color;
                    break;
                case 5:
                    setBackgroundResource(com.martian.libmars.R.drawable.theme_selectable_background_day);
                    return;
                case 6:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_account_grey_line_day);
                    return;
                case 7:
                default:
                    i2 = com.martian.libmars.R.color.white;
                    break;
                case 8:
                    i2 = com.martian.libmars.R.color.transparent;
                    break;
                case 9:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_round_day);
                    return;
                case 10:
                case 11:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_account_grey_round_day);
                    return;
                case 12:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_round_grey_day);
                    return;
                case 13:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_top_round_day);
                    return;
                case 14:
                    i2 = com.martian.libmars.R.color.light_grey_bg;
                    break;
                case 15:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_light_grey);
                    return;
                case 16:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_light_grey_4dp);
                    return;
                case 17:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_background_light_theme_day);
                    return;
                case 18:
                    setBackgroundResource(com.martian.libmars.R.drawable.border_button_round_white);
                    return;
            }
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (!this.f10101b) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            int i2 = this.f10100a;
            if (i2 == 6) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.99f, 1.0f, 0.99f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(150L);
                scaleAnimation.setFillAfter(true);
                startAnimation(scaleAnimation);
                return false;
            }
            if (i2 != 7 && i2 != 8) {
                setAlpha(0.6f);
                return false;
            }
            Iterator<View> it = i.a.a(this).iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.6f);
            }
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        int i3 = this.f10100a;
        if (i3 == 6) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.99f, 1.0f, 0.99f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(150L);
            scaleAnimation2.setFillAfter(true);
            startAnimation(scaleAnimation2);
            return false;
        }
        if (i3 != 7 && i3 != 8) {
            setAlpha(1.0f);
            return false;
        }
        Iterator<View> it2 = i.a.a(this).iterator();
        while (it2.hasNext()) {
            it2.next().setAlpha(1.0f);
        }
        return false;
    }

    public void setBackgroundType(int type) {
        this.f10100a = type;
        invalidate();
    }

    public void setSelectableLayout(boolean selectableLayout) {
        this.f10101b = selectableLayout;
        if (selectableLayout) {
            setOnTouchListener(this);
        }
        setEnabled(selectableLayout);
        setClickable(selectableLayout);
    }

    public ThemeLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public ThemeLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        b(context, attrs);
        a();
    }
}
