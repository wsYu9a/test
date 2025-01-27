package com.opos.mobad.q.a.a;

import android.os.Parcel;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.event.b;
import com.opos.mobad.service.event.c;

/* loaded from: classes4.dex */
public class a implements c {

    /* renamed from: a */
    private EventDescription f23188a;

    /* renamed from: b */
    private com.opos.mobad.q.a.e.a f23189b;

    /* renamed from: com.opos.mobad.q.a.a.a$a */
    public static class C0475a extends com.opos.mobad.q.a.e.a {
        public C0475a(EventDescription eventDescription) {
            super(eventDescription);
        }

        @Override // com.opos.mobad.service.event.a, com.opos.mobad.service.event.c
        public void a(int i2, Parcel parcel) {
            c a2;
            if (this.f23599b == null || (a2 = b.a().a(this.f23599b)) == null) {
                super.a(i2, parcel);
            } else {
                a2.a(i2, parcel);
            }
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInt(i2);
            obtain.writeString(str);
            a(6, obtain);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j2);
            a(4, obtain);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeString(str);
            a(3, obtain);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            a(1, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
            a(7, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j2) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j2);
            a(10, obtain);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeString(str);
            a(9, obtain);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
            a(8, (Parcel) null);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            a(5, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.e.a
        public void f() {
            a(11, (Parcel) null);
        }

        public void g() {
            a(12, (Parcel) null);
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
            a(2, (Parcel) null);
        }
    }

    public a(EventDescription eventDescription, com.opos.mobad.q.a.e.a aVar) {
        this.f23188a = eventDescription;
        this.f23189b = aVar;
    }

    public static a a(EventDescription eventDescription, com.opos.mobad.q.a.e.a aVar) {
        if (eventDescription == null || aVar == null) {
            return null;
        }
        a aVar2 = new a(eventDescription, aVar);
        b.a().a(aVar2);
        return aVar2;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.f23188a;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i2, Parcel parcel) {
        String str;
        if (this.f23189b == null) {
            com.opos.cmn.an.f.a.b("VideoEventHandler", "null listener");
            return;
        }
        int i3 = 0;
        if (parcel != null) {
            parcel.setDataPosition(0);
        }
        str = "";
        switch (i2) {
            case 1:
                this.f23189b.a((Object[]) null);
                break;
            case 2:
                this.f23189b.j_();
                break;
            case 3:
                this.f23189b.a(parcel != null ? parcel.readString() : "");
                break;
            case 4:
                this.f23189b.a(parcel != null ? parcel.readLong() : 0L);
                break;
            case 5:
                this.f23189b.d();
                break;
            case 6:
                if (parcel != null) {
                    i3 = parcel.readInt();
                    str = parcel.readString();
                }
                this.f23189b.a(i3, str);
                break;
            case 7:
                this.f23189b.b();
                break;
            case 8:
                this.f23189b.c();
                break;
            case 9:
                this.f23189b.b(parcel != null ? parcel.readString() : "");
                break;
            case 10:
                this.f23189b.b(parcel != null ? parcel.readLong() : 0L);
                break;
            case 11:
                this.f23189b.f();
                break;
            case 12:
                this.f23189b.e();
                break;
        }
    }
}
