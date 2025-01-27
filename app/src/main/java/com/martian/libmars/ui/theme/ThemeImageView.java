package com.martian.libmars.ui.theme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ThemeImageView extends ImageView implements a, View.OnTouchListener {

    /* renamed from: b */
    public int f12380b;

    /* renamed from: c */
    public boolean f12381c;

    /* renamed from: d */
    public int f12382d;

    /* renamed from: e */
    public int f12383e;

    /* renamed from: f */
    public int f12384f;

    public ThemeImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        if (this.f12382d > 0) {
            setOnTouchListener(this);
            setClickable(true);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeImageView);
        this.f12380b = obtainStyledAttributes.getInteger(R.styleable.ThemeImageView_colorFilterType, 0);
        this.f12381c = obtainStyledAttributes.getBoolean(R.styleable.ThemeImageView_enableFilter, true);
        this.f12382d = obtainStyledAttributes.getInteger(R.styleable.ThemeImageView_selectableImageType, 0);
        this.f12383e = ContextCompat.getColor(context, R.color.selector_black_pressed);
        this.f12384f = ContextCompat.getColor(context, R.color.transparent);
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
        if (this.f12382d <= 0) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.f12382d == 2) {
                setColorFilter(this.f12383e, PorterDuff.Mode.SRC_IN);
                return false;
            }
            setAlpha(0.6f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        if (this.f12382d == 2) {
            setColorFilter(this.f12384f, PorterDuff.Mode.SRC_IN);
            return false;
        }
        setAlpha(1.0f);
        return false;
    }

    @Override // k9.a
    public void p() {
        int i10;
        if (!isInEditMode() && this.f12381c) {
            if (ConfigSingleton.D().A0()) {
                switch (this.f12380b) {
                    case 1:
                        i10 = R.color.night_theme_item_color_primary;
                        break;
                    case 2:
                        i10 = R.color.night_text_color_primary;
                        break;
                    case 3:
                        i10 = R.color.night_text_color_secondary;
                        break;
                    case 4:
                        i10 = R.color.night_text_color_thirdly;
                        break;
                    case 5:
                        i10 = R.color.white;
                        break;
                    case 6:
                        i10 = R.color.theme_default;
                        break;
                    case 7:
                        setBackgroundResource(R.drawable.bg_divider_line_top_night);
                        return;
                    case 8:
                        setBackgroundResource(R.drawable.bg_divider_line_bottom_night);
                        return;
                    case 9:
                        i10 = R.color.night_highlight_color;
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
                        i10 = R.color.night_background;
                        break;
                    case 14:
                        i10 = R.color.night_background_secondary;
                        break;
                    case 15:
                        i10 = R.color.night_text_color_unclickable;
                        break;
                    case 16:
                    default:
                        i10 = R.color.night_item_color_primary;
                        break;
                    case 17:
                        i10 = R.color.night_background_card;
                        break;
                    case 18:
                        i10 = R.color.sign_in_bg_night_color;
                        break;
                }
            } else {
                switch (this.f12380b) {
                    case 1:
                    case 6:
                        i10 = R.color.theme_default;
                        break;
                    case 2:
                        i10 = R.color.day_text_color_primary;
                        break;
                    case 3:
                        i10 = R.color.day_text_color_secondary;
                        break;
                    case 4:
                        i10 = R.color.day_text_color_thirdly;
                        break;
                    case 5:
                    case 17:
                        i10 = R.color.white;
                        break;
                    case 7:
                        setBackgroundResource(R.drawable.bg_divider_line_top);
                        return;
                    case 8:
                        setBackgroundResource(R.drawable.bg_divider_line_bottom);
                        return;
                    case 9:
                        i10 = R.color.day_highlight_color;
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
                        i10 = R.color.white;
                        break;
                    case 14:
                        i10 = R.color.light_grey;
                        break;
                    case 15:
                        i10 = R.color.day_text_color_unclickable;
                        break;
                    case 16:
                    default:
                        i10 = R.color.day_item_color_primary;
                        break;
                    case 18:
                        clearColorFilter();
                        return;
                }
            }
            setColorFilter(ContextCompat.getColor(getContext(), i10), PorterDuff.Mode.SRC_IN);
        }
    }

    public void setColorFilterType(int i10) {
        this.f12380b = i10;
    }

    public void setEnableFilter(boolean z10) {
        this.f12381c = z10;
    }

    public ThemeImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ThemeImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet);
        a();
    }
}
