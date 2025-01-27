package com.opos.mobad.q.a.f.c;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: classes4.dex */
public abstract class a extends com.opos.mobad.cmn.a.c {

    /* renamed from: h */
    protected com.opos.mobad.q.a.c.a f23323h;

    /* renamed from: i */
    protected RelativeLayout f23324i;

    /* renamed from: j */
    private final String f23325j;

    /* renamed from: com.opos.mobad.q.a.f.c.a$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ AdItemData f23327a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.cmn.a.b.a f23328b;

        AnonymousClass1(AdItemData adItemData, com.opos.mobad.cmn.a.b.a aVar) {
            adItemData = adItemData;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.a(adItemData, aVar)) {
                a aVar = a.this;
                aVar.f23323h.a(view, ((com.opos.mobad.cmn.a.c) aVar).f20281d, aVar);
            }
        }
    }

    public a(Context context, com.opos.mobad.q.a.c.a aVar) {
        super(context);
        this.f23325j = "BaseTipBarView";
        this.f23323h = aVar;
        b();
        g();
    }

    private void b() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f20278a);
        this.f23324i = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f20278a, 85.0f)));
        this.f23324i.setVisibility(8);
    }

    public RelativeLayout a() {
        return this.f23324i;
    }

    protected void a(View view, AdItemData adItemData, com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f20281d));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.c.a.1

                /* renamed from: a */
                final /* synthetic */ AdItemData f23327a;

                /* renamed from: b */
                final /* synthetic */ com.opos.mobad.cmn.a.b.a f23328b;

                AnonymousClass1(AdItemData adItemData2, com.opos.mobad.cmn.a.b.a aVar2) {
                    adItemData = adItemData2;
                    aVar = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.a(adItemData, aVar)) {
                        a aVar2 = a.this;
                        aVar2.f23323h.a(view2, ((com.opos.mobad.cmn.a.c) aVar2).f20281d, aVar);
                    }
                }
            });
        }
    }

    protected void a(TextView textView, String str) {
        if (textView != null) {
            if (com.opos.cmn.an.c.a.a(str)) {
                str = "";
            }
            textView.setText(str);
        }
    }

    @Override // com.opos.mobad.cmn.a.c
    public void j() {
        this.f23324i.removeAllViews();
    }
}
