package com.martian.libmars.ui.theme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import com.martian.theme.yellow.R;
import g.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class ThemeTextView extends TextView implements a, View.OnTouchListener {

    /* renamed from: a */
    private int f10104a;

    /* renamed from: b */
    private boolean f10105b;

    /* renamed from: c */
    private int f10106c;

    /* renamed from: d */
    private int f10107d;

    public ThemeTextView(Context context) {
        super(context);
        this.f10107d = 0;
        a();
    }

    private void a() {
        if (this.f10105b) {
            setOnTouchListener(this);
            setClickable(true);
        }
    }

    private void c(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeTextView);
        this.f10104a = obtainStyledAttributes.getInteger(R.styleable.ThemeTextView_textColorType, 0);
        this.f10105b = obtainStyledAttributes.getBoolean(R.styleable.ThemeTextView_selectableItem, false);
        this.f10106c = obtainStyledAttributes.getInteger(R.styleable.ThemeTextView_textBackgroundType, 0);
        this.f10107d = obtainStyledAttributes.getInteger(R.styleable.ThemeTextView_textTypeFace, 0);
        obtainStyledAttributes.recycle();
    }

    public boolean b() {
        return this.f10105b;
    }

    @Override // g.a
    public void g() {
        int i2;
        if (h.F().I0()) {
            switch (this.f10104a) {
                case 1:
                    i2 = com.martian.libmars.R.color.night_text_color_secondary;
                    break;
                case 2:
                    i2 = com.martian.libmars.R.color.night_text_color_thirdly;
                    break;
                case 3:
                    i2 = com.martian.libmars.R.color.night_text_color_unclickable;
                    break;
                case 4:
                    i2 = com.martian.libmars.R.color.theme_default;
                    break;
                case 5:
                    i2 = com.martian.libmars.R.color.night_theme_item_color_primary;
                    break;
                case 6:
                    i2 = com.martian.libmars.R.color.night_highlight_color;
                    break;
                default:
                    i2 = com.martian.libmars.R.color.night_text_color_primary;
                    break;
            }
            int i3 = this.f10106c;
            if (i3 == 1) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.night_background));
            } else if (i3 == 2) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.night_background_secondary));
            } else if (i3 == 3) {
                setBackgroundResource(com.martian.libmars.R.drawable.border_search_background_night);
            } else if (i3 == 4) {
                setBackgroundResource(com.martian.libmars.R.drawable.border_button_line_round_night);
            }
        } else {
            switch (this.f10104a) {
                case 1:
                    i2 = com.martian.libmars.R.color.day_text_color_secondary;
                    break;
                case 2:
                    i2 = com.martian.libmars.R.color.day_text_color_thirdly;
                    break;
                case 3:
                    i2 = com.martian.libmars.R.color.day_text_color_unclickable;
                    break;
                case 4:
                    i2 = com.martian.libmars.R.color.theme_default;
                    break;
                case 5:
                    i2 = com.martian.libmars.R.color.theme_default;
                    break;
                case 6:
                    i2 = com.martian.libmars.R.color.day_highlight_color;
                    break;
                default:
                    i2 = com.martian.libmars.R.color.day_text_color_primary;
                    break;
            }
            int i4 = this.f10106c;
            if (i4 == 1) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.white));
            } else if (i4 == 2) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.theme_default));
            } else if (i4 == 3) {
                setBackgroundResource(com.martian.libmars.R.drawable.border_search_background_day);
            } else if (i4 == 4) {
                setBackgroundResource(com.martian.libmars.R.drawable.border_button_line_round_day);
            }
        }
        if (this.f10104a != -1) {
            setTextColor(ContextCompat.getColor(getContext(), i2));
        }
        if (this.f10107d == 0 || h.F().v0() == null) {
            return;
        }
        setTypeface(h.F().v0());
        setIncludeFontPadding(false);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (!this.f10105b) {
            return false;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                return false;
            }
            setAlpha(1.0f);
            return false;
        }
        if (this.f10106c > 0) {
            setAlpha(0.8f);
            return false;
        }
        setAlpha(0.6f);
        return false;
    }

    public void setBackgroundType(int backgroundType) {
        this.f10106c = backgroundType;
    }

    public void setSelectable(boolean selectable) {
        this.f10105b = selectable;
        invalidate();
    }

    public void setTextColorType(int type) {
        this.f10104a = type;
    }

    public void setWithTypeFace(int type) {
        this.f10107d = type;
    }

    public ThemeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        c(context, attrs);
        a();
    }

    public ThemeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10107d = 0;
        c(context, attrs);
        a();
    }
}
