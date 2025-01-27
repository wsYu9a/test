package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class MiSwitchButton extends CompoundButton implements a {

    /* renamed from: b */
    public int f12362b;

    /* renamed from: c */
    public int f12363c;

    /* renamed from: d */
    public int f12364d;

    /* renamed from: e */
    public int f12365e;

    /* renamed from: f */
    public int f12366f;

    /* renamed from: g */
    public StateListDrawable f12367g;

    /* renamed from: h */
    public StateListDrawable f12368h;

    /* renamed from: i */
    public int[] f12369i;

    /* renamed from: j */
    public int[] f12370j;

    public MiSwitchButton(Context context) {
        super(context);
        a();
    }

    public final void a() {
        b();
        setBackgroundColor(getResources().getColor(R.color.transparent));
        f();
        setSelected(isChecked());
        setClickable(true);
    }

    public final void b() {
        if (this.f12363c <= 0 || this.f12364d <= 0) {
            return;
        }
        c();
        if (this.f12369i != null) {
            this.f12367g = new StateListDrawable();
            int i10 = 0;
            while (true) {
                if (i10 >= this.f12369i.length) {
                    break;
                }
                Drawable drawable = ContextCompat.getDrawable(getContext(), this.f12369i[i10]);
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                this.f12367g.addState(new int[0], e(drawable));
                                break;
                            }
                        } else {
                            this.f12367g.addState(new int[]{android.R.attr.state_selected}, e(drawable));
                        }
                    } else {
                        this.f12367g.addState(new int[]{android.R.attr.state_pressed}, e(drawable));
                    }
                } else {
                    this.f12367g.addState(new int[]{android.R.attr.state_focused}, e(drawable));
                }
                i10++;
            }
        }
        if (this.f12370j != null) {
            this.f12368h = new StateListDrawable();
            for (int i11 = 0; i11 < this.f12370j.length; i11++) {
                Drawable drawable2 = ContextCompat.getDrawable(getContext(), this.f12370j[i11]);
                if (i11 == 0) {
                    this.f12368h.addState(new int[]{android.R.attr.state_focused}, e(drawable2));
                } else if (i11 == 1) {
                    this.f12368h.addState(new int[]{android.R.attr.state_pressed}, e(drawable2));
                } else if (i11 == 2) {
                    this.f12368h.addState(new int[]{android.R.attr.state_selected}, e(drawable2));
                } else if (i11 == 3) {
                    this.f12368h.addState(new int[0], e(drawable2));
                    return;
                }
            }
        }
    }

    public final void c() {
        int i10 = this.f12366f;
        if (i10 == 1) {
            int i11 = R.drawable.selector_switch_1_selected_day;
            int i12 = R.drawable.selector_switch_1_unselected_day;
            this.f12369i = new int[]{i11, i11, i11, i12};
            this.f12370j = new int[]{i11, i11, i11, i12};
            return;
        }
        if (i10 == 2) {
            int i13 = R.drawable.selector_switch_2_selected_day;
            int i14 = R.drawable.selector_switch_1_unselected_day;
            this.f12369i = new int[]{i13, i13, i13, i14};
            this.f12370j = new int[]{i13, i13, i13, i14};
            return;
        }
        if (i10 == 3) {
            int i15 = R.drawable.selector_switch_3_selected_day;
            int i16 = R.drawable.selector_switch_1_unselected_day;
            this.f12369i = new int[]{i15, i15, i15, i16};
            this.f12370j = new int[]{i15, i15, i15, i16};
            return;
        }
        int i17 = R.drawable.selector_icon_selected_night;
        int i18 = R.drawable.selector_icon_unselected_day;
        this.f12369i = new int[]{i17, i17, i17, i18};
        int i19 = R.drawable.selector_icon_selected_day;
        this.f12370j = new int[]{i19, i19, i19, i18};
    }

    public final void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MiSwitchButton);
        this.f12362b = obtainStyledAttributes.getInteger(R.styleable.MiSwitchButton_switchButtonBackgroundType, 0);
        this.f12363c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiSwitchButton_switchButtonIconWidth, 0);
        this.f12364d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MiSwitchButton_switchButtonIconHeight, 0);
        this.f12365e = obtainStyledAttributes.getInt(R.styleable.MiSwitchButton_switchButtonLocationForText, 0);
        this.f12366f = obtainStyledAttributes.getInt(R.styleable.MiSwitchButton_switchButtonDrawableType, 0);
        obtainStyledAttributes.recycle();
    }

    public final Drawable e(Drawable drawable) {
        if (this.f12363c <= 0 || this.f12364d <= 0 || !(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        return new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(((BitmapDrawable) drawable).getBitmap(), this.f12363c, this.f12364d, false));
    }

    public final void f() {
        int e02 = ConfigSingleton.D().e0();
        if (this.f12363c <= 0 || this.f12364d <= 0) {
            int i10 = this.f12365e;
            int i11 = i10 == 1 ? e02 : 0;
            if (i10 != 0) {
                e02 = 0;
            }
            setCompoundDrawablesWithIntrinsicBounds(i11, 0, e02, 0);
            return;
        }
        if (ConfigSingleton.D().A0()) {
            int i12 = this.f12365e;
            setCompoundDrawablesWithIntrinsicBounds(i12 == 1 ? this.f12367g : null, (Drawable) null, i12 == 0 ? this.f12367g : null, (Drawable) null);
        } else {
            int i13 = this.f12365e;
            setCompoundDrawablesWithIntrinsicBounds(i13 == 1 ? this.f12368h : null, (Drawable) null, i13 == 0 ? this.f12368h : null, (Drawable) null);
        }
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

    @Override // k9.a
    public void p() {
        int i10;
        if (isInEditMode() || this.f12362b == -1) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            int i11 = this.f12362b;
            i10 = i11 != 1 ? i11 != 2 ? R.color.night_text_color_primary : R.color.night_text_color_thirdly : R.color.night_text_color_secondary;
        } else {
            int i12 = this.f12362b;
            i10 = i12 != 1 ? i12 != 2 ? R.color.day_text_color_primary : R.color.day_text_color_thirdly : R.color.day_text_color_secondary;
        }
        setTextColor(ContextCompat.getColor(getContext(), i10));
        f();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        setSelected(z10);
    }

    public MiSwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        d(context, attributeSet);
        a();
    }

    public MiSwitchButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d(context, attributeSet);
        a();
    }
}
