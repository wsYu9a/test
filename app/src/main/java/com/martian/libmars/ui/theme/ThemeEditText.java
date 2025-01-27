package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeEditText extends EditText implements a {
    public ThemeEditText(Context context) {
        super(context);
        a();
    }

    private void a() {
        setFocusableInTouchMode(true);
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
        if (isInEditMode()) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            setTextColor(ContextCompat.getColor(getContext(), R.color.night_text_color_primary));
            setHintTextColor(ContextCompat.getColor(getContext(), R.color.night_text_color_thirdly));
        } else {
            setTextColor(ContextCompat.getColor(getContext(), R.color.day_text_color_primary));
            setHintTextColor(ContextCompat.getColor(getContext(), R.color.day_text_color_thirdly));
        }
    }

    public ThemeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a();
    }

    public ThemeEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
