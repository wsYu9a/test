package com.opos.mobad.n.g;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class ac extends RelativeLayout {

    /* renamed from: a */
    private TextView f22388a;

    /* renamed from: b */
    private ad f22389b;

    public ac(Context context) {
        super(context);
        b(context);
    }

    public static ac a(Context context) {
        return new ac(context);
    }

    private void b(Context context) {
        TextView textView = new TextView(getContext());
        this.f22388a = textView;
        textView.setTextColor(getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.f22388a.setTextSize(1, 17.0f);
        this.f22388a.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22388a.setMaxLines(2);
        addView(this.f22388a, new RelativeLayout.LayoutParams(-1, -2));
        this.f22389b = ad.a(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.f22389b, layoutParams);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockSmallLeftAreaView", "setListener " + interfaceC0458a);
        this.f22389b.a(interfaceC0458a);
    }

    public void a(com.opos.mobad.n.d.d dVar) {
        if (dVar == null) {
            return;
        }
        String str = dVar.f22073e;
        if (!TextUtils.isEmpty(str)) {
            this.f22388a.setText(str);
        }
        this.f22389b.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k, dVar.B, dVar.f22074f);
    }
}
