package com.opos.cmn.e.a.c.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.cmn.e.a.c.d.c;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    protected Context f16976a;

    /* renamed from: b */
    protected c f16977b;

    /* renamed from: c */
    protected RelativeLayout f16978c;

    /* renamed from: d */
    protected ImageView f16979d;

    /* renamed from: e */
    protected int[] f16980e = new int[4];

    /* renamed from: com.opos.cmn.e.a.c.a.a$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f16981a;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.f16977b.b(aVar.f16979d, aVar.f16980e, str, new Object[0]);
        }
    }

    /* renamed from: com.opos.cmn.e.a.c.a.a$2 */
    class AnonymousClass2 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ View f16983a;

        /* renamed from: b */
        final /* synthetic */ String f16984b;

        AnonymousClass2(View view, String str) {
            view = view;
            str = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            aVar.f16977b.a(view, aVar.f16980e, str, new Object[0]);
        }
    }

    public a(Context context, c cVar) {
        this.f16976a = context.getApplicationContext();
        this.f16977b = cVar;
        c();
        b();
    }

    private void c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f16976a);
        this.f16978c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.b(this.f16976a), com.opos.cmn.an.h.f.a.a(this.f16976a, 90.0f)));
        com.opos.cmn.e.a.d.a.a(this.f16978c, com.opos.cmn.an.d.a.a.c(this.f16976a, "opos_module_biz_ui_cmn_reminder_toast_bg_img.png"));
        d();
    }

    private void d() {
        ImageView imageView = new ImageView(this.f16976a);
        this.f16979d = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f16976a, 16.0f), com.opos.cmn.an.h.f.a.a(this.f16976a, 16.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        this.f16978c.addView(this.f16979d, layoutParams);
    }

    public View a() {
        return this.f16978c;
    }

    protected void a(View view) {
        view.setOnClickListener(null);
    }

    protected void a(View view, String str) {
        view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f16980e));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.c.a.a.2

            /* renamed from: a */
            final /* synthetic */ View f16983a;

            /* renamed from: b */
            final /* synthetic */ String f16984b;

            AnonymousClass2(View view2, String str2) {
                view = view2;
                str = str2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a aVar = a.this;
                aVar.f16977b.a(view, aVar.f16980e, str, new Object[0]);
            }
        });
    }

    protected void a(String str) {
        this.f16979d.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f16980e));
        this.f16979d.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.e.a.c.a.a.1

            /* renamed from: a */
            final /* synthetic */ String f16981a;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                aVar.f16977b.b(aVar.f16979d, aVar.f16980e, str, new Object[0]);
            }
        });
    }

    public abstract void a(String str, boolean z, Object... objArr);

    public abstract void b();
}
