package com.opos.mobad.h.e.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.o.b.j;

/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a */
    private j f20978a;

    /* renamed from: b */
    private com.opos.mobad.h.c.a.a f20979b;

    public b(Context context, com.opos.mobad.h.c.a.a aVar, FrameLayout frameLayout) {
        this.f20978a = new j(context, this, frameLayout);
        this.f20979b = aVar;
    }

    @Override // com.opos.mobad.o.b.d
    public void a() {
    }

    @Override // com.opos.mobad.o.b.d
    public void a(int i2, String str) {
        com.opos.mobad.h.c.a.a aVar = this.f20979b;
        if (aVar != null) {
            aVar.a(i2, str);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void a(long j2) {
    }

    @Override // com.opos.mobad.o.b.d
    public void a(View view, AdItemData adItemData) {
        com.opos.mobad.h.c.a.a aVar = this.f20979b;
        if (aVar != null) {
            aVar.a(view, adItemData);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void a(View view, AdItemData adItemData, long j2) {
        com.opos.mobad.h.c.a.a aVar = this.f20979b;
        if (aVar != null) {
            aVar.a(view, adItemData, j2);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void a(View view, int[] iArr, long j2, com.opos.mobad.cmn.a.b.a aVar) {
        com.opos.mobad.h.c.a.a aVar2 = this.f20979b;
        if (aVar2 != null) {
            aVar2.a(view, iArr, j2, aVar);
        }
    }

    @Override // com.opos.mobad.h.e.a.a
    public void a(AdItemData adItemData) {
        this.f20978a.b(adItemData);
    }

    @Override // com.opos.mobad.h.e.a.a
    public void a(AdItemData adItemData, String str) {
        this.f20978a.a(adItemData, str);
    }

    @Override // com.opos.mobad.h.e.a.a
    public void b() {
        this.f20978a.b();
    }

    @Override // com.opos.mobad.o.b.d
    public void b(View view, AdItemData adItemData) {
        com.opos.mobad.h.c.a.a aVar = this.f20979b;
        if (aVar != null) {
            aVar.b(view, adItemData);
        }
    }

    @Override // com.opos.mobad.o.b.d
    public void b(View view, AdItemData adItemData, long j2) {
        com.opos.mobad.h.c.a.a aVar = this.f20979b;
        if (aVar != null) {
            aVar.b(view, adItemData, j2);
        }
    }

    @Override // com.opos.mobad.h.e.a.a
    public void b(AdItemData adItemData, String str) {
        this.f20978a.b(adItemData, str);
    }

    @Override // com.opos.mobad.h.e.a.a
    public void c() {
        this.f20978a.Q();
    }

    @Override // com.opos.mobad.o.b.d
    public void c(View view, AdItemData adItemData, long j2) {
        com.opos.mobad.h.c.a.a aVar = this.f20979b;
        if (aVar != null) {
            aVar.c(view, adItemData, j2);
        }
    }
}
