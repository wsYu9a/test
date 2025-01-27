package com.opos.mobad.n.c;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class l extends TextView {

    /* renamed from: a */
    private float f22058a;

    /* renamed from: b */
    private CharSequence f22059b;

    public l(Context context) {
        super(context);
        this.f22058a = 0.2f;
        this.f22059b = "";
    }

    private void a() {
        if (this.f22059b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < this.f22059b.length()) {
            sb.append(("" + this.f22059b.charAt(i2)).toLowerCase());
            i2++;
            if (i2 < this.f22059b.length()) {
                sb.append(" ");
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i3 = 1; i3 < sb.toString().length(); i3 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.f22058a + 1.0f) / 10.0f), i3, i3 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @Override // android.widget.TextView
    public float getLetterSpacing() {
        return this.f22058a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.f22059b;
    }

    @Override // android.widget.TextView
    public void setLetterSpacing(float f2) {
        this.f22058a = f2;
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f22059b = charSequence;
        a();
    }
}
