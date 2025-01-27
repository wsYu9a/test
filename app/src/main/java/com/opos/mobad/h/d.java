package com.opos.mobad.h;

import android.content.Context;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d extends com.opos.mobad.l.e {

    /* renamed from: b */
    private int f20954b;

    /* renamed from: c */
    private Context f20955c;

    /* renamed from: d */
    private String f20956d;

    /* renamed from: e */
    private com.opos.mobad.cmn.a.a f20957e;

    /* renamed from: f */
    private com.opos.mobad.ad.privacy.a f20958f;

    /* renamed from: com.opos.mobad.h.d$1 */
    class AnonymousClass1 implements b.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            if (c0457a == null || c0457a.f21743a.a() != 1) {
                d.this.f20954b = i2;
                d.this.a(d.this.a(c0457a.f21743a));
            } else {
                com.opos.mobad.service.a.a().a(d.this.f20956d, 4, c0457a.f21744b.f(), c0457a.f21744b.b(), c0457a.f21745c.aa(), c0457a.f21744b.a(), c0457a.f21744b.J());
                d.this.f20954b = c0457a.f21743a.c();
                d.this.a(-1, com.opos.mobad.ad.a.a(-1));
            }
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            if (adData != null) {
                d.this.f20954b = adData.c();
            }
            d.this.a(i2, str);
        }
    }

    public d(Context context, String str, com.opos.mobad.cmn.a.d dVar, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        super(jVar);
        this.f20955c = context;
        this.f20957e = new com.opos.mobad.cmn.a.a(this.f20955c, str, dVar);
        this.f20956d = str;
        this.f20958f = aVar;
    }

    public List<h> a(AdData adData) {
        ArrayList arrayList = new ArrayList();
        for (AdItemData adItemData : adData.f()) {
            if (adItemData != null) {
                arrayList.add(new com.opos.mobad.h.b.c(this.f20957e, adItemData, this.f20955c, this.f20956d, this.f20958f.a()));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str, int i2) {
        this.f20954b = 0;
        com.opos.mobad.model.b.a(this.f20955c.getApplicationContext()).a(this.f20955c, this.f20956d, 4, str, i2, new b.a() { // from class: com.opos.mobad.h.d.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, a.C0457a c0457a) {
                if (c0457a == null || c0457a.f21743a.a() != 1) {
                    d.this.f20954b = i22;
                    d.this.a(d.this.a(c0457a.f21743a));
                } else {
                    com.opos.mobad.service.a.a().a(d.this.f20956d, 4, c0457a.f21744b.f(), c0457a.f21744b.b(), c0457a.f21745c.aa(), c0457a.f21744b.a(), c0457a.f21744b.J());
                    d.this.f20954b = c0457a.f21743a.c();
                    d.this.a(-1, com.opos.mobad.ad.a.a(-1));
                }
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, String str2, AdData adData) {
                if (adData != null) {
                    d.this.f20954b = adData.c();
                }
                d.this.a(i22, str2);
            }
        }, com.opos.mobad.model.b.f21484b);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f20954b;
    }
}
