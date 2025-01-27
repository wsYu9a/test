package com.opos.mobad.o.a.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.o.a.a.a;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private Context f22966a;

    /* renamed from: b */
    private c f22967b;

    /* renamed from: c */
    private FrameLayout f22968c;

    /* renamed from: d */
    private RelativeLayout f22969d;

    /* renamed from: e */
    private final int f22970e = g.a();

    /* renamed from: f */
    private final int f22971f = g.a();

    /* renamed from: g */
    private final int f22972g = g.a();

    /* renamed from: h */
    private d f22973h;

    /* renamed from: i */
    private d f22974i;

    /* renamed from: j */
    private e f22975j;
    private e k;

    /* renamed from: com.opos.mobad.o.a.b.b$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f22967b.a();
        }
    }

    public b(Context context, c cVar) {
        this.f22966a = context;
        this.f22967b = cVar;
        c();
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.a.b.b.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.f22967b.a();
                }
            });
        }
    }

    private void c() {
        FrameLayout frameLayout = new FrameLayout(this.f22966a);
        this.f22968c = frameLayout;
        frameLayout.setBackgroundColor(Color.parseColor("#55000000"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22966a, 320.0f), -2);
        layoutParams.gravity = 17;
        RelativeLayout relativeLayout = new RelativeLayout(this.f22966a);
        this.f22969d = relativeLayout;
        relativeLayout.setClickable(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f22966a, 18.0f));
        this.f22969d.setBackground(gradientDrawable);
        this.f22969d.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22966a, 320.0f), com.opos.cmn.an.h.f.a.a(this.f22966a, 320.0f)));
        this.f22968c.addView(this.f22969d, layoutParams);
        a(this.f22968c);
        e();
        d();
    }

    private void d() {
        TextView textView = new TextView(this.f22966a);
        textView.setBackground(com.opos.cmn.an.d.a.a.c(this.f22966a, "opos_module_biz_ui_cmn_close_bn_bg_img.png"));
        textView.setGravity(17);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22966a, 16.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f22966a, 10.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.topMargin = a3;
        layoutParams.rightMargin = a3;
        this.f22969d.addView(textView, layoutParams);
        a(textView);
    }

    private void e() {
        d dVar = new d(this.f22966a, this.f22967b);
        this.f22973h = dVar;
        dVar.a(new a.C0470a().a("不感兴趣").a(com.opos.mobad.o.a.a.b.TAG_REPEAT_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_LOW_QUALITY_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_LOW_RELATIVE_CONTENT).a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22966a, 288.0f), -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22966a, 20.0f);
        layoutParams.addRule(14);
        View a2 = this.f22973h.a();
        a2.setId(this.f22970e);
        this.f22969d.addView(a2, layoutParams);
        d dVar2 = new d(this.f22966a, this.f22967b);
        this.f22974i = dVar2;
        dVar2.a(new a.C0470a().a("投诉").a(com.opos.mobad.o.a.a.b.TAG_VULGAR_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_FAKE_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_AFFECT_OPERATION_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_INDUCE_CLICK_CONTENT).a(com.opos.mobad.o.a.a.b.TAG_OTHER_CONTENT).a());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22966a, 288.0f), -2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f22966a, 20.0f);
        layoutParams2.addRule(3, this.f22970e);
        layoutParams2.addRule(14);
        View a3 = this.f22974i.a();
        a3.setId(this.f22971f);
        this.f22969d.addView(a3, layoutParams2);
        e eVar = new e(this.f22966a, this.f22967b);
        this.f22975j = eVar;
        eVar.a(new a.C0470a().a(com.opos.mobad.o.a.a.b.TAG_CANNOT_CLOSE).a());
        View a4 = this.f22975j.a();
        a4.setId(this.f22972g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22966a, 288.0f), -2);
        layoutParams3.addRule(3, this.f22971f);
        layoutParams3.addRule(14);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.f22966a, 20.0f);
        this.f22969d.addView(a4, layoutParams3);
        e eVar2 = new e(this.f22966a, this.f22967b);
        this.k = eVar2;
        eVar2.a(new a.C0470a().a(com.opos.mobad.o.a.a.b.TAG_DISPLAY_EXCEPTION).a());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22966a, 288.0f), -2);
        layoutParams4.topMargin = com.opos.cmn.an.h.f.a.a(this.f22966a, 20.0f);
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22966a, 20.0f);
        layoutParams4.addRule(3, this.f22972g);
        layoutParams4.addRule(14);
        this.f22969d.addView(this.k.a(), layoutParams4);
    }

    public View a() {
        return this.f22968c;
    }

    public void b() {
        FrameLayout frameLayout = this.f22968c;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        d dVar = this.f22973h;
        if (dVar != null) {
            dVar.b();
        }
        d dVar2 = this.f22974i;
        if (dVar2 != null) {
            dVar2.b();
        }
        e eVar = this.f22975j;
        if (eVar != null) {
            eVar.b();
        }
        e eVar2 = this.k;
        if (eVar2 != null) {
            eVar2.b();
        }
    }
}
