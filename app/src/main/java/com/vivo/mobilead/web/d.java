package com.vivo.mobilead.web;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.vivo.mobilead.util.m;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private PopupWindow f30865a;

    /* renamed from: b */
    private Activity f30866b;

    /* renamed from: c */
    private LinearLayout f30867c;

    /* renamed from: d */
    private View.OnClickListener f30868d;

    /* renamed from: e */
    private View.OnClickListener f30869e;

    /* renamed from: f */
    private PopupWindow.OnDismissListener f30870f;

    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            d.this.d();
            if (d.this.f30870f != null) {
                d.this.f30870f.onDismiss();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f30868d != null) {
                d.this.f30868d.onClick(view);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.f30869e != null) {
                d.this.f30869e.onClick(view);
            }
        }
    }

    public d(Activity activity) {
        this.f30866b = activity;
        a(activity);
        c();
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f30867c = linearLayout;
        linearLayout.setOrientation(1);
        this.f30867c.setGravity(1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(m.a(context, 16.0f));
        this.f30867c.setBackground(gradientDrawable);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m.a(context, 54.0f));
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        textView.setTextColor(Color.parseColor("#FF000000"));
        textView.setTextSize(1, 16.0f);
        textView.setText("安全警告");
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setGravity(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = m.a(context, 20.0f);
        layoutParams2.bottomMargin = m.a(context, 14.0f);
        textView.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        textView2.setTextColor(Color.parseColor("#FF000000"));
        textView2.setTextSize(1, 14.0f);
        textView2.setText("网站安全证书来自未知授权中心");
        textView2.setGravity(1);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = m.a(context, 16.0f);
        layoutParams3.rightMargin = m.a(context, 16.0f);
        textView2.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams4.weight = 1.0f;
        TextView textView3 = new TextView(context);
        textView3.setGravity(17);
        textView3.setTextColor(Color.parseColor("#FF456FFF"));
        textView3.setTextSize(1, 16.0f);
        textView3.setText("关闭网页");
        textView3.setOnClickListener(new b());
        textView3.setLayoutParams(layoutParams4);
        TextView textView4 = new TextView(context);
        textView4.setGravity(17);
        textView4.setTextColor(Color.parseColor("#FF456FFF"));
        textView4.setTextSize(1, 16.0f);
        textView4.setText("继续浏览");
        textView4.setOnClickListener(new c());
        textView4.setLayoutParams(layoutParams4);
        linearLayout2.addView(textView3);
        linearLayout2.addView(textView4);
        this.f30867c.addView(textView);
        this.f30867c.addView(textView2);
        this.f30867c.addView(linearLayout2);
    }

    private void c() {
        PopupWindow popupWindow = new PopupWindow(this.f30867c, this.f30866b.getResources().getDisplayMetrics().widthPixels - (m.a(this.f30866b, 16.0f) * 2), -2);
        this.f30865a = popupWindow;
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager.LayoutParams attributes = this.f30866b.getWindow().getAttributes();
        attributes.alpha = 0.6f;
        this.f30866b.getWindow().setAttributes(attributes);
        this.f30865a.setOutsideTouchable(true);
        this.f30865a.setOnDismissListener(new a());
    }

    public void d() {
        WindowManager.LayoutParams attributes = this.f30866b.getWindow().getAttributes();
        attributes.alpha = 1.0f;
        this.f30866b.getWindow().setAttributes(attributes);
    }

    public void b() {
        try {
            this.f30865a.showAtLocation(this.f30867c, 81, 0, m.a(this.f30866b, 58.0f));
        } catch (Exception unused) {
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.f30869e = onClickListener;
    }

    public void a() {
        try {
            this.f30865a.dismiss();
        } catch (Exception unused) {
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f30868d = onClickListener;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.f30870f = onDismissListener;
    }
}
