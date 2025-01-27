package com.vivo.ad.h.b;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class d extends ImageView implements View.OnTouchListener {
    public d(Context context) {
        this(context, null);
    }

    private void a() {
        setBackgroundColor(0);
        setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_afk_ctrl_vol_resume.png"));
        setOnTouchListener(this);
        setFocusableInTouchMode(true);
        setFocusable(true);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        requestFocus();
        return false;
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
