package com.vivo.mobilead.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class i0 {

    /* renamed from: a */
    private PopupWindow f30650a;

    /* renamed from: b */
    private LinearLayout f30651b;

    /* renamed from: c */
    private TextView f30652c;

    /* renamed from: d */
    private TextView f30653d;

    /* renamed from: e */
    private Activity f30654e;

    /* renamed from: f */
    private String f30655f;

    /* renamed from: g */
    private Handler f30656g = new Handler(new a());

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            i0.this.f30650a.dismiss();
            return false;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i0 i0Var = i0.this;
            i0Var.a(i0Var.f30655f);
        }
    }

    public i0(Activity activity) {
        this.f30654e = activity;
        LinearLayout linearLayout = new LinearLayout(activity);
        this.f30651b = linearLayout;
        linearLayout.setBackgroundColor(Color.parseColor("#cc000000"));
        this.f30651b.setOrientation(1);
        this.f30651b.setGravity(17);
        int a2 = m.a(this.f30654e, 10.0f);
        this.f30651b.setPadding(a2, a2, a2, a2);
        this.f30652c = new TextView(activity);
        this.f30652c.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f30652c.setGravity(17);
        this.f30652c.setTextColor(Color.parseColor("#ccffffff"));
        this.f30652c.setTextSize(1, 14.0f);
        this.f30653d = new TextView(activity);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f30653d.setTop(m.a(activity, 4.0f));
        this.f30653d.setTextColor(Color.parseColor("#4568ff"));
        this.f30653d.setTextSize(1, 14.0f);
        this.f30653d.setGravity(17);
        this.f30653d.setLayoutParams(layoutParams);
        this.f30651b.setOnClickListener(new b());
        this.f30651b.addView(this.f30652c);
        this.f30651b.addView(this.f30653d);
        PopupWindow popupWindow = new PopupWindow((View) this.f30651b, this.f30654e.getResources().getDisplayMetrics().widthPixels - (m.a(this.f30654e, 16.0f) * 2), -2, false);
        this.f30650a = popupWindow;
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        this.f30650a.setFocusable(false);
        this.f30650a.setOutsideTouchable(false);
    }

    public void a(String str) {
        Intent launchIntentForPackage = this.f30654e.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage != null) {
            this.f30654e.startActivity(launchIntentForPackage);
        }
        a();
    }

    public void a(String str, String str2) {
        this.f30655f = str;
        this.f30656g.removeCallbacksAndMessages(null);
        this.f30652c.setText("您下载的\"" + str2 + "\"已安装完成");
        this.f30653d.setText("立即打开");
        this.f30650a.showAtLocation(this.f30651b, 81, 0, m.a(this.f30654e, 45.0f));
        this.f30656g.sendEmptyMessageDelayed(0, 3000L);
    }

    public void a() {
        this.f30650a.dismiss();
        Handler handler = this.f30656g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f30656g = null;
        }
    }
}
