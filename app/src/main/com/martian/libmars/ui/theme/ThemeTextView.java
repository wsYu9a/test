package com.martian.libmars.ui.theme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ThemeTextView extends TextView implements a, View.OnTouchListener {

    /* renamed from: b */
    public int f12389b;

    /* renamed from: c */
    public boolean f12390c;

    /* renamed from: d */
    public int f12391d;

    public ThemeTextView(Context context) {
        super(context);
        a();
    }

    private void a() {
        if (this.f12390c) {
            setOnTouchListener(this);
            setClickable(true);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            setFallbackLineSpacing(false);
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeTextView);
        this.f12389b = obtainStyledAttributes.getInteger(R.styleable.ThemeTextView_textColorType, 0);
        this.f12390c = obtainStyledAttributes.getBoolean(R.styleable.ThemeTextView_selectableItem, false);
        this.f12391d = obtainStyledAttributes.getInteger(R.styleable.ThemeTextView_textBackgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    public boolean b() {
        return this.f12390c;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f12390c) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1 && action != 3) {
                return false;
            }
            setAlpha(1.0f);
            return false;
        }
        if (this.f12391d > 0) {
            setAlpha(0.8f);
            return false;
        }
        setAlpha(0.6f);
        return false;
    }

    @Override // k9.a
    public void p() {
        int i10;
        if (isInEditMode()) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            switch (this.f12389b) {
                case 1:
                    i10 = R.color.night_text_color_secondary;
                    break;
                case 2:
                    i10 = R.color.night_text_color_thirdly;
                    break;
                case 3:
                    i10 = R.color.night_text_color_unclickable;
                    break;
                case 4:
                    i10 = R.color.theme_default;
                    break;
                case 5:
                    i10 = R.color.night_theme_item_color_primary;
                    break;
                case 6:
                    i10 = R.color.night_highlight_color;
                    break;
                default:
                    i10 = R.color.night_text_color_primary;
                    break;
            }
            int i11 = this.f12391d;
            if (i11 == 1) {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.night_background));
            } else if (i11 == 2) {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.night_background_secondary));
            } else if (i11 == 3) {
                setBackgroundResource(R.drawable.border_search_background_night);
            } else if (i11 == 4) {
                setBackgroundResource(R.drawable.border_button_line_round_night);
            } else if (i11 == 5) {
                setBackgroundResource(R.drawable.border_button_round_night_background);
            } else if (i11 == 6) {
                setBackgroundResource(R.drawable.border_search_background_night_4dp);
            } else if (i11 == 7) {
                setBackgroundResource(R.drawable.border_search_background_night_8dp);
            } else if (i11 == 8) {
                setBackgroundResource(R.drawable.border_round_background_night_card);
            }
        } else {
            switch (this.f12389b) {
                case 1:
                    i10 = R.color.day_text_color_secondary;
                    break;
                case 2:
                    i10 = R.color.day_text_color_thirdly;
                    break;
                case 3:
                    i10 = R.color.day_text_color_unclickable;
                    break;
                case 4:
                case 5:
                    i10 = R.color.theme_default;
                    break;
                case 6:
                    i10 = R.color.day_highlight_color;
                    break;
                default:
                    i10 = R.color.day_text_color_primary;
                    break;
            }
            int i12 = this.f12391d;
            if (i12 == 1) {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
            } else if (i12 == 2) {
                setBackgroundColor(ContextCompat.getColor(getContext(), R.color.theme_default));
            } else if (i12 == 3) {
                setBackgroundResource(R.drawable.border_search_background_day);
            } else if (i12 == 4) {
                setBackgroundResource(R.drawable.border_button_line_round_day);
            } else if (i12 == 5 || i12 == 8) {
                setBackgroundResource(R.drawable.border_button_round_white);
            } else if (i12 == 6) {
                setBackgroundResource(R.drawable.border_search_background_day_4dp);
            } else if (i12 == 7) {
                setBackgroundResource(R.drawable.border_search_background_day_8dp);
            }
        }
        if (this.f12389b != -1) {
            setTextColor(ContextCompat.getColor(getContext(), i10));
        }
    }

    public void setBackgroundType(int i10) {
        this.f12391d = i10;
    }

    public void setSelectable(boolean z10) {
        this.f12390c = z10;
        invalidate();
    }

    public void setTextColorType(int i10) {
        this.f12389b = i10;
    }

    public ThemeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        c(context, attributeSet);
        a();
    }

    public ThemeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c(context, attributeSet);
        a();
    }
}
