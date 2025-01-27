package com.opos.cmn.e.a.b.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class c extends a {

    /* renamed from: g */
    protected ImageView f16942g;

    /* renamed from: h */
    private TextView f16943h;

    /* renamed from: i */
    private TextView f16944i;

    /* renamed from: j */
    private int[] f16945j;

    /* renamed from: com.opos.cmn.e.a.b.b.c$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.f16933b.b(view, cVar.f16945j);
        }
    }

    /* renamed from: com.opos.cmn.e.a.b.b.c$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.f16933b.a(view, cVar.f16945j);
        }
    }

    public c(Context context) {
        super(context);
        this.f16945j = new int[4];
    }

    public c(Context context, float f2) {
        super(context, f2);
        this.f16945j = new int[4];
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16932a, 129.0f), com.opos.cmn.an.h.f.a.a(this.f16932a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        this.f16935d.addView(this.f16943h, layoutParams);
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16932a, 129.0f), com.opos.cmn.an.h.f.a.a(this.f16932a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.f16935d.addView(this.f16944i, layoutParams);
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16932a, 1.0f), com.opos.cmn.an.h.f.a.a(this.f16932a, 38.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        this.f16935d.addView(this.f16942g, layoutParams);
    }

    @Override // com.opos.cmn.e.a.b.b.a
    protected void a() {
        TextView textView = new TextView(this.f16932a);
        this.f16943h = textView;
        textView.setGravity(17);
        this.f16943h.setSingleLine();
        this.f16943h.setEllipsize(TextUtils.TruncateAt.END);
        this.f16943h.setTextColor(Color.parseColor("#767575"));
        this.f16943h.setTextSize(1, 13.0f);
        TextView textView2 = new TextView(this.f16932a);
        this.f16944i = textView2;
        textView2.setGravity(17);
        this.f16944i.setSingleLine();
        this.f16944i.setEllipsize(TextUtils.TruncateAt.END);
        this.f16944i.setTextColor(Color.parseColor("#d95955"));
        this.f16944i.setTextSize(1, 13.0f);
        ImageView imageView = new ImageView(this.f16932a);
        this.f16942g = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f16942g.setImageDrawable(new ColorDrawable(Color.parseColor("#cdd2d4")));
        e();
        c();
        d();
    }

    public void a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.f16944i.setText(str);
        this.f16944i.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f16945j));
        this.f16944i.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.b.b.c.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.f16933b.b(view, cVar.f16945j);
            }
        });
    }

    public void b(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.f16943h.setText(str);
        this.f16943h.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f16945j));
        this.f16943h.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.b.b.c.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = c.this;
                cVar.f16933b.a(view, cVar.f16945j);
            }
        });
    }
}
