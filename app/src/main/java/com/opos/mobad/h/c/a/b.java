package com.opos.mobad.h.c.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: a */
    private com.opos.mobad.h.e.a.a f20952a;

    /* renamed from: b */
    private com.opos.mobad.h.a.a f20953b;

    public b(Context context, com.opos.mobad.h.a.a aVar, FrameLayout frameLayout) {
        this.f20952a = new com.opos.mobad.h.e.a.b(context, this, frameLayout);
        this.f20953b = aVar;
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a() {
        this.f20952a.b();
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(int i2, String str) {
        this.f20953b.a(i2, str);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(View view, AdItemData adItemData) {
        this.f20953b.a(view, adItemData);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(View view, AdItemData adItemData, long j2) {
        this.f20953b.a(view, adItemData, j2);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(View view, int[] iArr, long j2, com.opos.mobad.cmn.a.b.a aVar) {
        this.f20953b.a(view, iArr, j2, aVar);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(AdItemData adItemData) {
        this.f20952a.a(adItemData);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void a(AdItemData adItemData, String str) {
        this.f20952a.a(adItemData, str);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b() {
        this.f20952a.c();
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b(View view, AdItemData adItemData) {
        this.f20953b.b(view, adItemData);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b(View view, AdItemData adItemData, long j2) {
        com.opos.mobad.h.a.a aVar = this.f20953b;
        if (aVar != null) {
            aVar.b(view, adItemData, j2);
        }
    }

    @Override // com.opos.mobad.h.c.a.a
    public void b(AdItemData adItemData, String str) {
        this.f20952a.b(adItemData, str);
    }

    @Override // com.opos.mobad.h.c.a.a
    public void c(View view, AdItemData adItemData, long j2) {
        this.f20953b.c(view, adItemData, j2);
    }
}
