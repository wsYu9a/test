package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes3.dex */
public class ReaderThemeCountUpTextView extends CountUpTextView {
    public ReaderThemeCountUpTextView(Context context) {
        super(context);
    }

    @Override // com.martian.libmars.widget.CountUpTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // com.martian.libmars.widget.CountUpTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // com.martian.libmars.widget.CountUpTextView, k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        setTextColor(MiConfigSingleton.b2().h2().k().getTextColorThirdly());
    }

    public ReaderThemeCountUpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReaderThemeCountUpTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
