package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class a {
    public static final View a(com.opos.mobad.n.d.d dVar, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        Drawable drawable = null;
        if (viewGroup == null) {
            return null;
        }
        Context context = viewGroup.getContext();
        TextView textView = new TextView(context);
        textView.setPadding(com.opos.cmn.an.h.f.a.a(context, 4.0f), com.opos.cmn.an.h.f.a.a(context, 2.0f), com.opos.cmn.an.h.f.a.a(context, 4.0f), com.opos.cmn.an.h.f.a.a(context, 2.0f));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(1, 8.0f);
        textView.setGravity(17);
        textView.setMaxEms(6);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        textView.setVisibility(8);
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        if (dVar != null && dVar.f22077i) {
            String str = dVar.q;
            if (!com.opos.cmn.an.c.a.a(str)) {
                str.hashCode();
                if (str.equals("bd_api") || str.equals("bd")) {
                    drawable = com.opos.cmn.an.d.a.a.c(context, "opos_module_biz_ui_cmn_bd_logo_img.png");
                } else {
                    com.opos.mobad.n.d.g gVar = dVar.f22078j;
                    if (gVar != null && !com.opos.cmn.an.c.a.a(gVar.f22084a)) {
                        drawable = com.opos.mobad.cmn.a.b.g.b(context, dVar.f22078j.f22084a);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getLogoDrawable=");
            sb.append(drawable != null ? drawable : "null");
            com.opos.cmn.an.f.a.b("AdViewUtils", sb.toString());
            if (drawable != null) {
                com.opos.mobad.cmn.a.b.g.a(textView, drawable);
                layoutParams.width = com.opos.cmn.an.h.f.a.a(context, 26.0f);
                layoutParams.height = com.opos.cmn.an.h.f.a.a(context, 12.0f);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#3D151515"));
                gradientDrawable.setCornerRadius(5.0f);
                com.opos.mobad.cmn.a.b.g.a(textView, gradientDrawable);
                if (!com.opos.cmn.an.c.a.a(dVar.k)) {
                    textView.setText(dVar.k);
                }
                layoutParams.width = -2;
                layoutParams.height = -2;
            }
            textView.setVisibility(0);
        }
        viewGroup.addView(textView, layoutParams);
        return textView;
    }
}
