package com.vivo.mobilead.unified.base.view.t.j;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.mobilead.i.u;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.util.m;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private View f30242a;

    /* renamed from: b */
    private d f30243b;

    /* renamed from: c */
    private String f30244c = "关闭";

    /* renamed from: d */
    private TextView f30245d;

    /* renamed from: e */
    private com.vivo.ad.view.c f30246e;

    /* renamed from: f */
    private Context f30247f;

    public c(Context context) {
        this.f30247f = context;
        a(context);
    }

    private void a(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View view = new View(context);
        this.f30242a = view;
        view.setBackgroundColor(-1);
        this.f30242a.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        d dVar = new d(context);
        this.f30243b = dVar;
        dVar.setLayoutParams(layoutParams2);
        this.f30245d = new TextView(context);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#80333333"));
        gradientDrawable.setStroke(1, Color.parseColor("#80FFFFFF"));
        gradientDrawable.setCornerRadius(m.b(context, 12.67f));
        this.f30245d.setText(this.f30244c);
        this.f30245d.setTextSize(1, 12.0f);
        this.f30245d.setGravity(17);
        this.f30245d.setTextColor(Color.parseColor("#FFFFFF"));
        this.f30245d.setBackground(gradientDrawable);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(m.b(context, 54.67f), m.b(context, 25.33f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(10);
        if (m.c(context) == 1) {
            layoutParams3.rightMargin = m.b(context, 20.0f);
        } else {
            layoutParams3.rightMargin = m.b(context, 24.66f);
        }
        layoutParams3.topMargin = m.a(context, 19.33f);
        this.f30245d.setLayoutParams(layoutParams3);
        this.f30246e = new com.vivo.ad.view.c(context);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(Color.parseColor("#80333333"));
        gradientDrawable2.setStroke(1, Color.parseColor("#80FFFFFF"));
        gradientDrawable2.setCornerRadius(m.b(context, 3.0f));
        this.f30246e.setTagBackground(gradientDrawable2);
        this.f30246e.a(10, -1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(10);
        layoutParams4.addRule(9);
        layoutParams4.leftMargin = m.a(context, 20.0f);
        layoutParams4.topMargin = m.a(context, 25.0f);
        this.f30246e.setLayoutParams(layoutParams4);
    }

    public boolean b(RelativeLayout relativeLayout) {
        d dVar;
        return (relativeLayout == null || (dVar = this.f30243b) == null || relativeLayout.indexOfChild(dVar) < 0) ? false : true;
    }

    public void c() {
        d dVar = this.f30243b;
        if (dVar != null) {
            dVar.c();
        }
    }

    public void b() {
        d dVar = this.f30243b;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void a(com.vivo.ad.model.b bVar, String str, BackUrlInfo backUrlInfo, int i2, int i3) {
        this.f30243b.a(bVar, str, i2, i3);
        String v = bVar.v();
        if (!TextUtils.isEmpty(v)) {
            HashMap hashMap = new HashMap();
            if (m.c(this.f30247f) == 1) {
                hashMap.put("wkOrientation", "1");
            } else {
                hashMap.put("wkOrientation", "0");
            }
            v = u.a(v, hashMap);
        }
        if (TextUtils.isEmpty(v)) {
            return;
        }
        this.f30243b.setPreloadFlag(1);
        this.f30243b.loadUrl(v);
    }

    public void a(RelativeLayout relativeLayout, boolean z) {
        if (relativeLayout == null) {
            return;
        }
        if (relativeLayout.indexOfChild(this.f30242a) < 0) {
            relativeLayout.addView(this.f30242a);
        }
        if (relativeLayout.indexOfChild(this.f30243b) < 0) {
            relativeLayout.addView(this.f30243b);
            this.f30243b.setPreloadFlag(0);
            this.f30243b.a();
        }
        if (relativeLayout.indexOfChild(this.f30246e) < 0) {
            relativeLayout.addView(this.f30246e);
        }
        if (z) {
            if (relativeLayout.indexOfChild(this.f30245d) < 0) {
                relativeLayout.addView(this.f30245d);
            }
        } else if (relativeLayout.indexOfChild(this.f30245d) >= 0) {
            relativeLayout.removeView(this.f30245d);
        }
    }

    public void a(RelativeLayout relativeLayout) {
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.removeView(this.f30242a);
        relativeLayout.removeView(this.f30243b);
        relativeLayout.removeView(this.f30246e);
        relativeLayout.removeView(this.f30245d);
    }

    public void a(e eVar) {
        this.f30243b.setWebCallback(eVar);
    }

    public void a(String str, String str2, String str3) {
        com.vivo.ad.view.c cVar = this.f30246e;
        if (cVar != null) {
            cVar.a(com.vivo.mobilead.h.b.a().a(str), str2, str3, false);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        TextView textView = this.f30245d;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void a() {
        d dVar = this.f30243b;
        if (dVar != null) {
            dVar.destroy();
        }
    }
}
