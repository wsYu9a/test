package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes4.dex */
public class ReaderThemeCountUpTextView extends CountUpTextView {
    public ReaderThemeCountUpTextView(Context context) {
        super(context);
    }

    @Override // com.martian.libmars.widget.CountUpTextView, g.a
    public void g() {
        setTextColor(MiConfigSingleton.V3().J4.r().getTextColorThirdly());
    }

    @Override // com.martian.libmars.widget.CountUpTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    public ReaderThemeCountUpTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ReaderThemeCountUpTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
