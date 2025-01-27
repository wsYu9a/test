package com.opos.cmn.e.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class a extends TextView {

    /* renamed from: a */
    private Context f16921a;

    /* renamed from: b */
    private Drawable f16922b;

    /* renamed from: c */
    private Drawable f16923c;

    public a(Context context, int i2) {
        super(context);
        this.f16922b = com.opos.cmn.e.a.d.a.a(context, i2);
        this.f16923c = com.opos.cmn.e.a.d.a.a(context, i2);
        com.opos.cmn.e.a.d.a.a(this, a());
    }

    public a(Context context, Drawable drawable, Drawable drawable2, int i2, int i3) {
        super(context);
        this.f16922b = drawable;
        this.f16923c = drawable2;
        com.opos.cmn.e.a.d.a.a(this, a());
        setTextColor(a(i2, i3));
    }

    public a(Context context, String str, String str2) {
        super(context);
        this.f16921a = context;
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.c.a.a(str2)) {
            return;
        }
        this.f16922b = com.opos.cmn.an.d.a.a.c(this.f16921a, str);
        this.f16923c = com.opos.cmn.an.d.a.a.c(this.f16921a, str2);
        com.opos.cmn.e.a.d.a.a(this, a());
    }

    public static ColorStateList a(int i2, int i3) {
        return new ColorStateList(new int[][]{View.PRESSED_ENABLED_STATE_SET, View.ENABLED_FOCUSED_STATE_SET, View.ENABLED_STATE_SET, View.FOCUSED_STATE_SET, View.EMPTY_STATE_SET}, new int[]{i3, i3, i2, i3, i2});
    }

    private StateListDrawable a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, this.f16923c);
        stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, this.f16923c);
        stateListDrawable.addState(View.ENABLED_STATE_SET, this.f16922b);
        stateListDrawable.addState(View.FOCUSED_STATE_SET, this.f16923c);
        stateListDrawable.addState(View.EMPTY_STATE_SET, this.f16922b);
        return stateListDrawable;
    }
}
