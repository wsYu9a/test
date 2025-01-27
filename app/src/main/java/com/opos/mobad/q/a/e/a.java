package com.opos.mobad.q.a.e;

import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.q.a.m;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public abstract class a extends com.opos.mobad.service.event.a implements b.InterfaceC0437b, m.a {

    /* renamed from: a */
    private b.InterfaceC0437b f23246a;

    public a() {
        this(null);
    }

    public a(EventDescription eventDescription) {
        super(eventDescription);
    }

    public void a(b.InterfaceC0437b interfaceC0437b) {
        this.f23246a = interfaceC0437b;
    }

    public void a(AdItemData adItemData, String str) {
        b.InterfaceC0437b interfaceC0437b = this.f23246a;
        if (interfaceC0437b != null) {
            interfaceC0437b.a(adItemData, str);
        }
    }

    public void b(AdItemData adItemData, String str) {
        b.InterfaceC0437b interfaceC0437b = this.f23246a;
        if (interfaceC0437b != null) {
            interfaceC0437b.b(adItemData, str);
        }
    }

    public void c(AdItemData adItemData, String str) {
        b.InterfaceC0437b interfaceC0437b = this.f23246a;
        if (interfaceC0437b != null) {
            interfaceC0437b.c(adItemData, str);
        }
    }

    public void e() {
    }

    public void f() {
    }
}
