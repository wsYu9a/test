package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderThemeEditText extends AppCompatEditText implements a {
    public ReaderThemeEditText(Context context) {
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
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        setTextColor(k10.getTextColorPrimary());
        setHintTextColor(k10.getTextColorThirdly());
    }

    public ReaderThemeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a();
    }

    public ReaderThemeEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
