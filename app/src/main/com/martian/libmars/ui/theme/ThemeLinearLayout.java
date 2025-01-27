package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import java.util.Iterator;
import k9.a;
import l9.u0;

/* loaded from: classes3.dex */
public class ThemeLinearLayout extends LinearLayout implements a, View.OnTouchListener {

    /* renamed from: b */
    public int f12385b;

    /* renamed from: c */
    public boolean f12386c;

    public ThemeLinearLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        if (this.f12386c) {
            setOnTouchListener(this);
            setClickable(true);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeLinearLayout);
        this.f12385b = obtainStyledAttributes.getColor(R.styleable.ThemeLinearLayout_backgroundType, 0);
        this.f12386c = obtainStyledAttributes.getBoolean(R.styleable.ThemeLinearLayout_selectableLayout, false);
        obtainStyledAttributes.recycle();
    }

    public int getType() {
        return this.f12385b;
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
        if (!this.f12386c) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            int i10 = this.f12385b;
            if (i10 == 6 || i10 == 20 || i10 == 27 || i10 == 28 || i10 == 29) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.99f, 1.0f, 0.99f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(150L);
                scaleAnimation.setFillAfter(true);
                startAnimation(scaleAnimation);
                return false;
            }
            if (i10 != 7 && i10 != 8) {
                setAlpha(0.6f);
                return false;
            }
            Iterator<View> it = u0.a(this).iterator();
            while (it.hasNext()) {
                it.next().setAlpha(0.6f);
            }
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        int i11 = this.f12385b;
        if (i11 == 6 || i11 == 20 || i11 == 27 || i11 == 28 || i11 == 29) {
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.99f, 1.0f, 0.99f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(150L);
            scaleAnimation2.setFillAfter(true);
            startAnimation(scaleAnimation2);
            return false;
        }
        if (i11 != 7 && i11 != 8) {
            setAlpha(1.0f);
            return false;
        }
        Iterator<View> it2 = u0.a(this).iterator();
        while (it2.hasNext()) {
            it2.next().setAlpha(1.0f);
        }
        return false;
    }

    @Override // k9.a
    public void p() {
        int i10;
        if (!isInEditMode() && this.f12385b >= 0) {
            if (ConfigSingleton.D().A0()) {
                switch (this.f12385b) {
                    case 1:
                    case 2:
                        i10 = R.color.night_background_secondary;
                        break;
                    case 3:
                    case 18:
                        setBackgroundResource(R.drawable.border_search_background_night);
                        return;
                    case 4:
                        i10 = R.color.night_highlight_color;
                        break;
                    case 5:
                        setBackgroundResource(R.drawable.theme_selectable_background_night);
                        return;
                    case 6:
                    case 15:
                        setBackgroundResource(R.drawable.border_account_grey_line_night);
                        return;
                    case 7:
                    case 14:
                    default:
                        i10 = R.color.night_background;
                        break;
                    case 8:
                        i10 = R.color.transparent;
                        break;
                    case 9:
                        setBackgroundResource(R.drawable.border_background_round_night);
                        return;
                    case 10:
                        setBackgroundResource(R.drawable.border_account_grey_round_night);
                        return;
                    case 11:
                    case 12:
                    case 31:
                        setBackgroundResource(R.drawable.border_account_grey_round_night_secondary);
                        return;
                    case 13:
                        setBackgroundResource(R.drawable.border_background_top_round_night);
                        return;
                    case 16:
                        setBackgroundResource(R.drawable.border_account_grey_line_night_4dp);
                        return;
                    case 17:
                        setBackgroundResource(R.drawable.border_background_light_theme_night);
                        return;
                    case 19:
                        setBackgroundResource(R.drawable.border_tag_background_night_card);
                        return;
                    case 20:
                        setBackgroundResource(R.drawable.border_background_round_card_night_12dp);
                        return;
                    case 21:
                        setBackgroundResource(R.drawable.border_background_top_round_card_night_12dp);
                        return;
                    case 22:
                        setBackgroundResource(R.drawable.border_background_bottom_round_card_night_12dp);
                        return;
                    case 23:
                        i10 = R.color.night_background_card;
                        break;
                    case 24:
                        setBackgroundResource(R.drawable.border_background_vip_top_round_night_8dp);
                        return;
                    case 25:
                        setBackgroundResource(R.drawable.border_background_vip_round_night_8dp);
                        return;
                    case 26:
                        setBackgroundResource(R.drawable.border_background_night_card_10dp);
                        return;
                    case 27:
                        setBackgroundResource(R.drawable.border_background_book_mall_rank2_night);
                        return;
                    case 28:
                        setBackgroundResource(R.drawable.border_background_round_card_night_18dp);
                        return;
                    case 29:
                        setBackgroundResource(R.drawable.border_background_bottom_round_card_night_18dp);
                        return;
                    case 30:
                        setBackgroundResource(R.drawable.border_background_top_round_card_night_16dp);
                        return;
                    case 32:
                        setBackgroundResource(R.drawable.border_background_bottom_round_night_16dp);
                        return;
                    case 33:
                        setBackgroundResource(R.drawable.border_background_night_card_button_8dp);
                        return;
                    case 34:
                        setBackgroundResource(R.drawable.border_button_round_night_background);
                        return;
                }
            } else {
                switch (this.f12385b) {
                    case 1:
                        i10 = R.color.light_grey;
                        break;
                    case 2:
                        i10 = R.color.theme_default;
                        break;
                    case 3:
                    case 34:
                        setBackgroundResource(R.drawable.border_search_background_day);
                        return;
                    case 4:
                        i10 = R.color.day_highlight_color;
                        break;
                    case 5:
                        setBackgroundResource(R.drawable.theme_selectable_background_day);
                        return;
                    case 6:
                        setBackgroundResource(R.drawable.border_account_grey_line_day);
                        return;
                    case 7:
                    case 23:
                    default:
                        i10 = R.color.white;
                        break;
                    case 8:
                        i10 = R.color.transparent;
                        break;
                    case 9:
                        setBackgroundResource(R.drawable.border_background_round_day);
                        return;
                    case 10:
                    case 11:
                        setBackgroundResource(R.drawable.border_account_grey_round_day);
                        return;
                    case 12:
                        setBackgroundResource(R.drawable.border_background_round_grey_day);
                        return;
                    case 13:
                        setBackgroundResource(R.drawable.border_background_top_round_day);
                        return;
                    case 14:
                        i10 = R.color.light_grey_bg;
                        break;
                    case 15:
                    case 31:
                    case 33:
                        setBackgroundResource(R.drawable.border_background_light_grey);
                        return;
                    case 16:
                    case 19:
                        setBackgroundResource(R.drawable.border_background_light_grey_4dp);
                        return;
                    case 17:
                        setBackgroundResource(R.drawable.border_background_light_theme_day);
                        return;
                    case 18:
                        setBackgroundResource(R.drawable.border_button_round_white);
                        return;
                    case 20:
                        setBackgroundResource(R.drawable.border_background_round_card_day_12dp);
                        return;
                    case 21:
                        setBackgroundResource(R.drawable.border_background_top_round_card_day_12dp);
                        return;
                    case 22:
                        setBackgroundResource(R.drawable.border_background_bottom_round_card_day_12dp);
                        return;
                    case 24:
                        setBackgroundResource(R.drawable.border_background_vip_top_round_day_8dp);
                        return;
                    case 25:
                        setBackgroundResource(R.drawable.border_background_vip_round_day_8dp);
                        return;
                    case 26:
                        setBackgroundResource(R.drawable.border_background_light_grey_10dp);
                        return;
                    case 27:
                        setBackgroundResource(R.drawable.border_background_book_mall_rank2_day);
                        return;
                    case 28:
                        setBackgroundResource(R.drawable.border_background_round_card_day_18dp);
                        return;
                    case 29:
                        setBackgroundResource(R.drawable.border_background_bottom_round_card_day_18dp);
                        return;
                    case 30:
                        setBackgroundResource(R.drawable.border_background_top_round_card_day_16dp);
                        return;
                    case 32:
                        setBackgroundResource(R.drawable.border_background_bottom_round_day_16dp);
                        return;
                }
            }
            setBackgroundColor(ContextCompat.getColor(getContext(), i10));
        }
    }

    public void setBackgroundType(int i10) {
        this.f12385b = i10;
        p();
    }

    public void setSelectableLayout(boolean z10) {
        this.f12386c = z10;
        if (z10) {
            setOnTouchListener(this);
        }
        setEnabled(z10);
        setClickable(z10);
    }

    public ThemeLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ThemeLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet);
        a();
    }
}
