package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import org.apache.http.HttpStatus;

/* loaded from: classes4.dex */
public class q {

    /* renamed from: a */
    private static PowerManager f21877a;

    public static final View a(com.opos.mobad.n.d.d dVar, ViewGroup viewGroup) {
        if (viewGroup == null || dVar == null) {
            return null;
        }
        View a2 = dVar.u.a();
        if (a2 == null) {
            a2 = new d(viewGroup.getContext());
        }
        viewGroup.addView(a2, a(viewGroup.getContext(), dVar, a2));
        a2.setVisibility(4);
        return a2;
    }

    public static RelativeLayout.LayoutParams a(Context context, com.opos.mobad.n.d.d dVar, View view) {
        RelativeLayout.LayoutParams layoutParams;
        if (view instanceof d) {
            layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(context, 28.0f));
            view.setMinimumWidth(com.opos.cmn.an.h.f.a.a(context, 60.0f));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        int i2 = dVar.o;
        layoutParams.topMargin = i2 != 1 ? i2 != 2 ? com.opos.cmn.an.h.f.a.a(context, 33.0f) : (com.opos.cmn.an.h.f.a.c(context) - c(context)) + com.opos.cmn.an.h.f.a.a(context, 12.0f) : (com.opos.cmn.an.h.f.a.c(context) - c(context)) - com.opos.cmn.an.h.f.a.a(context, 75.0f);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, 21.0f);
        return layoutParams;
    }

    public static RelativeLayout.LayoutParams a(com.opos.mobad.n.d.d dVar, Context context) {
        int a2 = com.opos.cmn.an.h.f.a.a(context, 26.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        int i2 = dVar.o == 0 ? 96 : 22;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, 33.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, i2);
        return layoutParams;
    }

    public static final TextView a(Context context) {
        TextView textView = new TextView(context);
        textView.setTextSize(0, com.opos.cmn.an.h.f.a.a(context, 18.0f));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        textView.setPadding(com.opos.cmn.an.h.f.a.a(context, 34.0f), com.opos.cmn.an.h.f.a.a(context, 19.0f), com.opos.cmn.an.h.f.a.a(context, 34.0f), com.opos.cmn.an.h.f.a.a(context, 19.0f));
        textView.setBackground(context.getResources().getDrawable(R.drawable.opos_mobad_drawable_splash_click));
        Drawable drawable = context.getResources().getDrawable(R.drawable.opos_mobad_splash_right_side_arrow);
        drawable.setBounds(com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 1.0f), com.opos.cmn.an.h.f.a.a(context, 10.0f), com.opos.cmn.an.h.f.a.a(context, 17.0f));
        textView.setCompoundDrawables(null, null, drawable, null);
        return textView;
    }

    public static final ViewGroup.LayoutParams b(Context context) {
        if (context == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, c(context));
        layoutParams.addRule(12);
        return layoutParams;
    }

    public static int c(Context context) {
        return context != null ? (int) ((com.opos.cmn.an.h.f.a.b(context) * 0.3778f) + 0.5f) : HttpStatus.SC_GATEWAY_TIMEOUT;
    }

    public static final PowerManager d(Context context) {
        if (f21877a == null) {
            f21877a = (PowerManager) context.getSystemService("power");
        }
        return f21877a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x001b -> B:3:0x0020). Please report as a decompilation issue!!! */
    public static final boolean e(Context context) {
        PowerManager d2;
        boolean isInteractive;
        if (context != null) {
            try {
                d2 = d(context);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("SplashUtils", "", (Throwable) e2);
            }
            if (d2 != null) {
                isInteractive = Build.VERSION.SDK_INT >= 20 ? d2.isInteractive() : d2.isScreenOn();
                com.opos.cmn.an.f.a.b("SplashUtils", "is screenOn = " + isInteractive);
                return isInteractive;
            }
        }
        isInteractive = true;
        com.opos.cmn.an.f.a.b("SplashUtils", "is screenOn = " + isInteractive);
        return isInteractive;
    }
}
