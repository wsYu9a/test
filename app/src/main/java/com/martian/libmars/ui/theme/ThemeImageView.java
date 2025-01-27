package com.martian.libmars.ui.theme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.d.h;
import g.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class ThemeImageView extends ImageView implements a, View.OnTouchListener {

    /* renamed from: a */
    private int f10095a;

    /* renamed from: b */
    private boolean f10096b;

    /* renamed from: c */
    private int f10097c;

    /* renamed from: d */
    private int f10098d;

    /* renamed from: e */
    private int f10099e;

    public ThemeImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        if (this.f10097c > 0) {
            setOnTouchListener(this);
            setClickable(true);
        }
    }

    private void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeImageView);
        this.f10095a = obtainStyledAttributes.getInteger(R.styleable.ThemeImageView_colorFilterType, 0);
        this.f10096b = obtainStyledAttributes.getBoolean(R.styleable.ThemeImageView_enableFilter, true);
        this.f10097c = obtainStyledAttributes.getInteger(R.styleable.ThemeImageView_selectableImageType, 0);
        this.f10098d = ContextCompat.getColor(context, R.color.selector_black_pressed);
        this.f10099e = ContextCompat.getColor(context, R.color.transparent);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (this.f10096b) {
            if (!h.F().I0()) {
                switch (this.f10095a) {
                    case 1:
                        i2 = R.color.theme_default;
                        break;
                    case 2:
                        i2 = R.color.day_text_color_primary;
                        break;
                    case 3:
                        i2 = R.color.day_text_color_secondary;
                        break;
                    case 4:
                        i2 = R.color.day_text_color_thirdly;
                        break;
                    case 5:
                        i2 = R.color.white;
                        break;
                    case 6:
                        i2 = R.color.theme_default;
                        break;
                    case 7:
                        setBackgroundResource(R.drawable.bg_divider_line_top);
                        return;
                    case 8:
                        setBackgroundResource(R.drawable.bg_divider_line_bottom);
                        return;
                    case 9:
                        i2 = R.color.day_highlight_color;
                        break;
                    case 10:
                        setBackgroundResource(R.drawable.border_mask_day);
                        return;
                    case 11:
                        setAlpha(0.05f);
                        return;
                    case 12:
                        setAlpha(1.0f);
                        return;
                    case 13:
                        i2 = R.color.white;
                        break;
                    case 14:
                        i2 = R.color.light_grey;
                        break;
                    case 15:
                        i2 = R.color.day_text_color_unclickable;
                        break;
                    default:
                        i2 = R.color.day_item_color_primary;
                        break;
                }
            } else {
                switch (this.f10095a) {
                    case 1:
                        i2 = R.color.night_theme_item_color_primary;
                        break;
                    case 2:
                        i2 = R.color.night_text_color_primary;
                        break;
                    case 3:
                        i2 = R.color.night_text_color_secondary;
                        break;
                    case 4:
                        i2 = R.color.night_text_color_thirdly;
                        break;
                    case 5:
                        i2 = R.color.white;
                        break;
                    case 6:
                        i2 = R.color.theme_default;
                        break;
                    case 7:
                        setBackgroundResource(R.drawable.bg_divider_line_top_night);
                        return;
                    case 8:
                        setBackgroundResource(R.drawable.bg_divider_line_bottom_night);
                        return;
                    case 9:
                        i2 = R.color.night_highlight_color;
                        break;
                    case 10:
                        setBackgroundResource(R.drawable.border_mask_night);
                        return;
                    case 11:
                        setAlpha(0.18f);
                        return;
                    case 12:
                        setAlpha(0.13f);
                        return;
                    case 13:
                        i2 = R.color.night_background;
                        break;
                    case 14:
                        i2 = R.color.night_background_secondary;
                        break;
                    case 15:
                        i2 = R.color.night_text_color_unclickable;
                        break;
                    default:
                        i2 = R.color.night_item_color_primary;
                        break;
                }
            }
            setColorFilter(ContextCompat.getColor(getContext(), i2));
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (this.f10097c <= 0) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            if (this.f10097c == 2) {
                setColorFilter(this.f10098d);
                return false;
            }
            setAlpha(0.6f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        if (this.f10097c == 2) {
            setColorFilter(this.f10099e);
            return false;
        }
        setAlpha(1.0f);
        return false;
    }

    public void setColorFilterType(int colorFilterType) {
        this.f10095a = colorFilterType;
    }

    public void setEnableFilter(boolean enableFilter) {
        this.f10096b = enableFilter;
    }

    public ThemeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public ThemeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        b(context, attrs);
        a();
    }
}
