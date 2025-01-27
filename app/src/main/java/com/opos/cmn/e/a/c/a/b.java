package com.opos.cmn.e.a.c.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.cmn.e.a.c.d.c;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: f */
    private ImageView f16986f;

    /* renamed from: g */
    private TextView f16987g;

    /* renamed from: h */
    private com.opos.cmn.e.a.a.a f16988h;

    public b(Context context, c cVar) {
        super(context, cVar);
    }

    private void b(String str) {
        Drawable f2 = com.opos.cmn.an.h.d.a.f(this.f16976a, str);
        if (f2 != null) {
            this.f16986f.setImageDrawable(f2);
        }
    }

    private void c() {
        ImageView imageView = new ImageView(this.f16976a);
        this.f16986f = imageView;
        imageView.setId(1);
        this.f16986f.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16976a, 43.0f), com.opos.cmn.an.h.f.a.a(this.f16976a, 43.0f));
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f16976a, 12.0f);
        this.f16978c.addView(this.f16986f, layoutParams);
    }

    private void c(String str) {
        this.f16987g.setText("您下载的【" + d(str) + "】已经安装完成，是否立即打开？");
    }

    private String d(String str) {
        String g2 = com.opos.cmn.an.h.d.a.g(this.f16976a, str);
        try {
            if (!com.opos.cmn.an.c.a.a(g2) && g2.length() > 0) {
                int indexOf = g2.indexOf("(");
                int indexOf2 = g2.indexOf(")");
                com.opos.cmn.an.f.a.b("ReminderToast", "english first=" + indexOf + ",english last=" + indexOf2);
                if (-1 == indexOf || -1 == indexOf2) {
                    indexOf = g2.indexOf("（");
                    indexOf2 = g2.indexOf("）");
                    com.opos.cmn.an.f.a.b("ReminderToast", "chinese first=" + indexOf + ",chinese last=" + indexOf2);
                }
                if (-1 != indexOf && -1 != indexOf2 && indexOf2 > indexOf) {
                    g2 = g2.substring(0, indexOf) + g2.substring(indexOf2 + 1, g2.length());
                }
                int indexOf3 = g2.indexOf("-");
                com.opos.cmn.an.f.a.b("ReminderToast", "english - =" + indexOf3);
                if (-1 == indexOf3) {
                    indexOf3 = g2.indexOf("—");
                    com.opos.cmn.an.f.a.b("ReminderToast", "chinese — =" + indexOf3);
                }
                if (-1 != indexOf3) {
                    g2 = g2.substring(0, indexOf3);
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToast", "", (Throwable) e2);
        }
        com.opos.cmn.an.f.a.b("ReminderToast", "getAppDefaultTitle=" + g2);
        return g2;
    }

    private void d() {
        TextView textView = new TextView(this.f16976a);
        this.f16987g = textView;
        textView.setTextColor(Color.parseColor("#2f2f2f"));
        this.f16987g.setTextSize(1, 12.0f);
        this.f16987g.setMaxLines(2);
        this.f16987g.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, 1);
        layoutParams.addRule(0, 2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f16976a, 19.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f16976a, 19.0f);
        this.f16978c.addView(this.f16987g, layoutParams);
    }

    private void e() {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f16976a, "opos_module_biz_ui_cmn_reminder_toast_click_bn_normal_img.png", "opos_module_biz_ui_cmn_reminder_toast_click_bn_pressed_img.png");
        this.f16988h = aVar;
        aVar.setText("立即打开");
        this.f16988h.setId(2);
        this.f16988h.setTextColor(-1);
        this.f16988h.setTextSize(1, 10.0f);
        this.f16988h.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16976a, 66.0f), com.opos.cmn.an.h.f.a.a(this.f16976a, 22.0f));
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f16976a, 12.0f);
        this.f16978c.addView(this.f16988h, layoutParams);
    }

    @Override // com.opos.cmn.e.a.c.a.a
    public void a(String str, boolean z, Object... objArr) {
        com.opos.cmn.e.a.a.a aVar;
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("setCustomViewData pkgName=");
            sb.append(str);
            sb.append(",gbClick=");
            sb.append(z);
            sb.append(",objects=");
            Object obj = objArr;
            if (objArr == null) {
                obj = "null";
            }
            sb.append(obj);
            com.opos.cmn.an.f.a.b("ReminderToast", sb.toString());
            b(str);
            c(str);
            a(str);
            if (z) {
                a(this.f16978c, str);
                aVar = this.f16988h;
            } else {
                a(this.f16978c);
                aVar = this.f16988h;
            }
            a(aVar, str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ReminderToast", "", (Throwable) e2);
        }
    }

    @Override // com.opos.cmn.e.a.c.a.a
    public void b() {
        c();
        e();
        d();
    }
}
