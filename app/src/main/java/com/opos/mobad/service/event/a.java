package com.opos.mobad.service.event;

import android.os.Parcel;

/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: b */
    protected final EventDescription f23599b;

    public a(EventDescription eventDescription) {
        this.f23599b = eventDescription;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.f23599b;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i2, Parcel parcel) {
        b.a().a(this.f23599b.a(), i2, parcel);
    }

    public void b(int i2, Parcel parcel) {
        b.a().a(this.f23599b.a(), i2, parcel, true);
    }
}
