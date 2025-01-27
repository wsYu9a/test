package com.opos.mobad.l;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class n implements com.opos.mobad.ad.e.d {

    /* renamed from: a */
    private Context f21219a;

    /* renamed from: b */
    private ViewGroup f21220b;

    /* renamed from: c */
    private String f21221c;

    /* renamed from: d */
    private String f21222d;

    public n(Context context, String str, String str2) {
        this.f21219a = context.getApplicationContext();
        this.f21221c = str;
        this.f21222d = str2;
        b();
    }

    public static String a(Context context, String str) {
        String str2;
        String str3 = "";
        if (context != null) {
            try {
            } catch (Exception e2) {
                e = e2;
                str2 = "";
            }
            if (!com.opos.cmn.an.c.a.a(str)) {
                str2 = com.opos.cmn.an.h.d.a.g(context, str);
                try {
                    if (!com.opos.cmn.an.c.a.a(str2) && str2.length() > 0) {
                        int indexOf = str2.indexOf("(");
                        int indexOf2 = str2.indexOf(")");
                        com.opos.cmn.an.f.a.b("SplashBottomArea", "english first=" + indexOf + ",english last=" + indexOf2);
                        if (-1 == indexOf || -1 == indexOf2) {
                            indexOf = str2.indexOf("（");
                            indexOf2 = str2.indexOf("）");
                            com.opos.cmn.an.f.a.b("SplashBottomArea", "chinese first=" + indexOf + ",chinese last=" + indexOf2);
                        }
                        if (-1 != indexOf && -1 != indexOf2 && indexOf2 > indexOf) {
                            str2 = str2.substring(0, indexOf) + str2.substring(indexOf2 + 1, str2.length());
                        }
                        int indexOf3 = str2.indexOf("-");
                        com.opos.cmn.an.f.a.b("SplashBottomArea", "english - =" + indexOf3);
                        if (-1 == indexOf3) {
                            indexOf3 = str2.indexOf("—");
                            com.opos.cmn.an.f.a.b("SplashBottomArea", "chinese — =" + indexOf3);
                        }
                        if (-1 != indexOf3) {
                            str3 = str2.substring(0, indexOf3);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.a("SplashBottomArea", "", (Throwable) e);
                    str3 = str2;
                    com.opos.cmn.an.f.a.b("SplashBottomArea", "getAppDefaultTitle=" + str3);
                    return str3;
                }
                str3 = str2;
            }
        }
        com.opos.cmn.an.f.a.b("SplashBottomArea", "getAppDefaultTitle=" + str3);
        return str3;
    }

    private void a(RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.f21219a);
        imageView.setId(2);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Context context = this.f21219a;
        Drawable f2 = com.opos.cmn.an.h.d.a.f(context, context.getPackageName());
        if (f2 != null) {
            imageView.setImageDrawable(f2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21219a, 40.0f), com.opos.cmn.an.h.f.a.a(this.f21219a, 40.0f));
        layoutParams.addRule(15);
        relativeLayout.addView(imageView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f21219a);
        textView.setText(str);
        textView.setId(3);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#010036"));
        textView.setTextSize(1, 22.0f);
        textView.setMaxEms(7);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, String str, String str2) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f21219a);
        a(relativeLayout2, str);
        b(relativeLayout2, str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21219a, 10.0f);
        relativeLayout.addView(relativeLayout2, layoutParams);
    }

    private void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21219a);
        this.f21220b = relativeLayout;
        relativeLayout.setBackgroundColor(Color.parseColor("#ffffff"));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f21219a);
        a(relativeLayout2);
        a(relativeLayout2, this.f21221c, this.f21222d);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f21219a, 55.0f));
        layoutParams.addRule(13);
        this.f21220b.addView(relativeLayout2, layoutParams);
    }

    private void b(RelativeLayout relativeLayout, String str) {
        TextView textView = new TextView(this.f21219a);
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#aaaaaa"));
        textView.setTextSize(1, 13.0f);
        textView.setMaxEms(11);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, 3);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        relativeLayout.addView(textView, layoutParams);
    }

    @Override // com.opos.mobad.ad.e.d
    public View a() {
        return this.f21220b;
    }
}
