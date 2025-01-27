package com.opos.mobad.cmn.b;

import android.os.Parcel;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public class a implements b, com.opos.mobad.service.event.c {

    /* renamed from: a */
    private EventDescription f20295a;

    /* renamed from: b */
    private b f20296b;

    /* renamed from: com.opos.mobad.cmn.b.a$a */
    public static class C0434a extends com.opos.mobad.service.event.a implements b {
        public C0434a(EventDescription eventDescription) {
            super(eventDescription);
        }

        public static EventDescription a(EventDescription eventDescription) {
            if (eventDescription == null) {
                return null;
            }
            return new EventDescription(eventDescription.a() + "-finisher");
        }

        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            b(1, null);
        }

        @Override // com.opos.mobad.service.event.a
        public void b(int i2, Parcel parcel) {
            if (this.f23599b != null) {
                com.opos.mobad.service.event.c a2 = com.opos.mobad.service.event.b.a().a(this.f23599b);
                if (a2 != null) {
                    a2.a(i2, parcel);
                } else {
                    super.b(i2, parcel);
                }
            }
        }
    }

    public a(EventDescription eventDescription, b bVar) {
        this.f20295a = eventDescription;
        this.f20296b = bVar;
    }

    public static com.opos.mobad.service.event.c a(EventDescription eventDescription, b bVar) {
        if (eventDescription == null || bVar == null) {
            return null;
        }
        a aVar = new a(eventDescription, bVar);
        com.opos.mobad.service.event.b.a().a(aVar);
        return aVar;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.f20295a;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i2, Parcel parcel) {
        b bVar = this.f20296b;
        if (bVar == null) {
            com.opos.cmn.an.f.a.b("VideoEventHandler", "null listener");
        } else {
            if (i2 != 1) {
                return;
            }
            bVar.b();
        }
    }

    @Override // com.opos.mobad.cmn.b.b
    public void b() {
        b bVar = this.f20296b;
        if (bVar == null) {
            return;
        }
        bVar.b();
    }
}
