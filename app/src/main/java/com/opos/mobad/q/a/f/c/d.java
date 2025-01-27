package com.opos.mobad.q.a.f.c;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: b */
    protected c f23333b;

    /* renamed from: c */
    protected b f23334c;

    /* renamed from: d */
    protected com.opos.cmn.e.a.a.a f23335d;

    /* renamed from: g */
    private Context f23338g;

    /* renamed from: h */
    private com.opos.mobad.q.a.c.a f23339h;

    /* renamed from: i */
    private AdItemData f23340i;

    /* renamed from: f */
    private final String f23337f = "TipBarTemplate";

    /* renamed from: a */
    protected int f23332a = 0;

    /* renamed from: e */
    protected int[] f23336e = new int[4];

    /* renamed from: com.opos.mobad.q.a.f.c.d$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ AdItemData f23341a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.cmn.a.b.a f23342b;

        AnonymousClass1(AdItemData adItemData, com.opos.mobad.cmn.a.b.a aVar) {
            adItemData = adItemData;
            aVar = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.a(adItemData, aVar)) {
                d.this.f23339h.a(view, d.this.f23336e, aVar);
            }
        }
    }

    public d(Context context, com.opos.mobad.q.a.c.a aVar) {
        this.f23338g = context.getApplicationContext();
        this.f23339h = aVar;
        b();
    }

    private void a(View view, AdItemData adItemData, com.opos.mobad.cmn.a.b.a aVar) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f23336e));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.q.a.f.c.d.1

                /* renamed from: a */
                final /* synthetic */ AdItemData f23341a;

                /* renamed from: b */
                final /* synthetic */ com.opos.mobad.cmn.a.b.a f23342b;

                AnonymousClass1(AdItemData adItemData2, com.opos.mobad.cmn.a.b.a aVar2) {
                    adItemData = adItemData2;
                    aVar = aVar2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (g.a(adItemData, aVar)) {
                        d.this.f23339h.a(view2, d.this.f23336e, aVar);
                    }
                }
            });
        }
    }

    private View b(AdItemData adItemData) {
        a aVar;
        try {
            if (!c(adItemData)) {
                this.f23332a = 0;
                this.f23335d.setText(g.a(this.f23338g, this.f23340i, false));
                a(this.f23335d, adItemData, com.opos.mobad.cmn.a.b.a.ClickBt);
                return this.f23335d;
            }
            if (adItemData == null) {
                return null;
            }
            int G = adItemData.i().get(0).G();
            if (G == 0) {
                this.f23332a = 2;
                this.f23333b.d(adItemData);
                aVar = this.f23333b;
            } else {
                if (G != 1) {
                    return null;
                }
                this.f23332a = 1;
                this.f23334c.d(adItemData);
                aVar = this.f23334c;
            }
            return aVar.a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("TipBarTemplate", "", (Throwable) e2);
            return null;
        }
    }

    private void b() {
        this.f23333b = new c(this.f23338g, this.f23339h);
        this.f23334c = new b(this.f23338g, this.f23339h);
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f23338g, "opos_module_biz_ui_reward_video_click_bn_normal_img.png", "opos_module_biz_ui_reward_video_click_bn_pressed_img.png");
        this.f23335d = aVar;
        aVar.setGravity(17);
        this.f23335d.setTextColor(Color.parseColor("#ffffff"));
        this.f23335d.setTextSize(1, 15.0f);
        this.f23335d.setSingleLine();
        this.f23335d.setVisibility(8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        if (com.opos.cmn.an.c.a.a(r5.get(0).a()) == false) goto L62;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0074 -> B:3:0x0079). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(com.opos.mobad.model.data.AdItemData r5) {
        /*
            r4 = this;
            java.lang.String r0 = "TipBarTemplate"
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L79
            java.util.List r3 = r5.i()     // Catch: java.lang.Exception -> L73
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialData r3 = (com.opos.mobad.model.data.MaterialData) r3     // Catch: java.lang.Exception -> L73
            int r3 = r3.G()     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto L46
            if (r3 == r1) goto L19
            goto L79
        L19:
            java.util.List r5 = r5.i()     // Catch: java.lang.Exception -> L73
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialData r5 = (com.opos.mobad.model.data.MaterialData) r5     // Catch: java.lang.Exception -> L73
            java.util.List r5 = r5.j()     // Catch: java.lang.Exception -> L73
            if (r5 == 0) goto L79
            int r3 = r5.size()     // Catch: java.lang.Exception -> L73
            if (r3 <= 0) goto L79
            java.lang.Object r3 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto L79
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialFileData r5 = (com.opos.mobad.model.data.MaterialFileData) r5     // Catch: java.lang.Exception -> L73
            java.lang.String r5 = r5.a()     // Catch: java.lang.Exception -> L73
            boolean r5 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L73
            if (r5 != 0) goto L79
            goto L7a
        L46:
            java.util.List r5 = r5.i()     // Catch: java.lang.Exception -> L73
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialData r5 = (com.opos.mobad.model.data.MaterialData) r5     // Catch: java.lang.Exception -> L73
            java.util.List r5 = r5.f()     // Catch: java.lang.Exception -> L73
            if (r5 == 0) goto L79
            int r3 = r5.size()     // Catch: java.lang.Exception -> L73
            if (r3 <= 0) goto L79
            java.lang.Object r3 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto L79
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialFileData r5 = (com.opos.mobad.model.data.MaterialFileData) r5     // Catch: java.lang.Exception -> L73
            java.lang.String r5 = r5.a()     // Catch: java.lang.Exception -> L73
            boolean r5 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L73
            if (r5 != 0) goto L79
            goto L7a
        L73:
            r5 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r5)
        L79:
            r1 = 0
        L7a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "hasTipBarMaterial="
            r5.append(r2)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.opos.cmn.an.f.a.b(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.f.c.d.c(com.opos.mobad.model.data.AdItemData):boolean");
    }

    public View a() {
        return b(this.f23340i);
    }

    public void a(AdItemData adItemData) {
        this.f23340i = adItemData;
    }

    public void a(String str) {
        com.opos.cmn.e.a.a.a aVar;
        b bVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = this.f23332a;
        if (i2 == 0) {
            aVar = this.f23335d;
        } else if (i2 != 1 || (bVar = this.f23334c) == null || bVar.b() == null) {
            return;
        } else {
            aVar = this.f23334c.b();
        }
        aVar.setText(str);
    }
}
