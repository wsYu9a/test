package com.opos.cmn.biz.web.b.b.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class a extends TextView {

    /* renamed from: a */
    private Context f16873a;

    /* renamed from: b */
    private Drawable f16874b;

    /* renamed from: c */
    private Drawable f16875c;

    public a(Context context, String str, String str2) {
        super(context);
        this.f16873a = context;
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2)) {
            return;
        }
        this.f16874b = com.opos.cmn.an.d.a.a.c(this.f16873a.getApplicationContext(), str);
        this.f16875c = com.opos.cmn.an.d.a.a.c(this.f16873a.getApplicationContext(), str2);
        com.opos.cmn.biz.web.b.b.a.a.a(this, a());
    }

    private Drawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, this.f16875c);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, this.f16875c);
        stateListDrawable.addState(View.ENABLED_STATE_SET, this.f16874b);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, this.f16875c);
        stateListDrawable.addState(View.EMPTY_STATE_SET, this.f16874b);
        return stateListDrawable;
    }
}
