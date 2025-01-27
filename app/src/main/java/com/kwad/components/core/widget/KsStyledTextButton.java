package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.r.g;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class KsStyledTextButton extends TextView implements d {
    public KsStyledTextButton(Context context) {
        super(context);
    }

    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsStyledTextButton(Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        g.b(eVar, getBackground());
    }
}
