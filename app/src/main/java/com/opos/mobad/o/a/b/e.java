package com.opos.mobad.o.a.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private Context f22987a;

    /* renamed from: b */
    private c f22988b;

    /* renamed from: c */
    private TextView f22989c;

    /* renamed from: com.opos.mobad.o.a.b.e$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f22990a;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.f22988b != null) {
                e.this.f22988b.a(i2);
            }
        }
    }

    public e(Context context, c cVar) {
        this.f22987a = context;
        this.f22988b = cVar;
        c();
    }

    private void a(View view, int i2) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.a.b.e.1

                /* renamed from: a */
                final /* synthetic */ int f22990a;

                AnonymousClass1(int i22) {
                    i2 = i22;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (e.this.f22988b != null) {
                        e.this.f22988b.a(i2);
                    }
                }
            });
        }
    }

    private void c() {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1A000000"));
        colorDrawable.setBounds(0, 0, com.opos.cmn.an.h.f.a.c(this.f22987a, 288.0f), com.opos.cmn.an.h.f.a.c(this.f22987a, 1.0f));
        TextView textView = new TextView(this.f22987a);
        this.f22989c = textView;
        textView.setTextColor(com.opos.cmn.e.a.a.a.a(Color.parseColor("#8C000000"), Color.parseColor("#FF5A60")));
        this.f22989c.setText("内容展示异常（黑屏/卡顿）");
        this.f22989c.setTextSize(1, 13.0f);
        this.f22989c.setCompoundDrawables(null, colorDrawable, null, null);
        this.f22989c.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f22987a, 14.0f));
        new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22987a, 288.0f), -2).topMargin = com.opos.cmn.an.h.f.a.a(this.f22987a, 20.0f);
    }

    public View a() {
        return this.f22989c;
    }

    public void a(com.opos.mobad.o.a.a.a aVar) {
        com.opos.mobad.o.a.a.b bVar;
        if (aVar == null || (bVar = aVar.f22953b.get(0)) == null) {
            return;
        }
        this.f22989c.setText(bVar.b());
        a(this.f22989c, bVar.a());
    }

    public void b() {
        if (this.f22988b != null) {
            this.f22988b = null;
        }
    }
}
