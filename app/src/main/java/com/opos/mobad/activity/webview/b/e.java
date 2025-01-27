package com.opos.mobad.activity.webview.b;

import android.os.Parcel;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public class e implements com.opos.mobad.service.event.c {

    /* renamed from: a */
    private EventDescription f19417a;

    /* renamed from: b */
    private d f19418b;

    /* renamed from: c */
    private c f19419c;

    public static final class a extends com.opos.mobad.service.event.a implements c {
        public a(EventDescription eventDescription) {
            super(eventDescription);
        }

        @Override // com.opos.mobad.service.event.a, com.opos.mobad.service.event.c
        public void a(int i2, Parcel parcel) {
            com.opos.mobad.service.event.c a2;
            if (this.f23599b == null || (a2 = com.opos.mobad.service.event.b.a().a(this.f23599b)) == null) {
                super.a(i2, parcel);
            } else {
                a2.a(i2, parcel);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(int i2, String str) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInt(i2);
            obtain.writeString(str);
            a(8, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(long j2) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j2);
            a(5, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b() {
            a(4, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b(long j2) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j2);
            a(6, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c() {
            a(7, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c(long j2) {
            Parcel obtain = Parcel.obtain();
            obtain.writeLong(j2);
            a(9, obtain);
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
            a(1, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            a(2, (Parcel) null);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void f_() {
            a(3, (Parcel) null);
        }
    }

    e(EventDescription eventDescription, d dVar) {
        this.f19417a = eventDescription;
        this.f19418b = dVar;
        if (dVar instanceof c) {
            this.f19419c = (c) dVar;
        }
    }

    public static e a(EventDescription eventDescription, d dVar) {
        if (eventDescription == null || dVar == null) {
            return null;
        }
        e eVar = new e(eventDescription, dVar);
        com.opos.mobad.service.event.b.a().a(eVar);
        return eVar;
    }

    @Override // com.opos.mobad.service.event.c
    public EventDescription a() {
        return this.f19417a;
    }

    @Override // com.opos.mobad.service.event.c
    public void a(int i2, Parcel parcel) {
        String str;
        if (this.f19418b == null) {
            com.opos.cmn.an.f.a.b("WebActionEventHandler", "null listener");
            return;
        }
        int i3 = 0;
        if (parcel != null) {
            parcel.setDataPosition(0);
        }
        switch (i2) {
            case 1:
                this.f19418b.d();
                break;
            case 2:
                this.f19418b.e();
                break;
            case 3:
                c cVar = this.f19419c;
                if (cVar != null) {
                    cVar.f_();
                    break;
                }
                break;
            case 4:
                c cVar2 = this.f19419c;
                if (cVar2 != null) {
                    cVar2.b();
                    break;
                }
                break;
            case 5:
                if (this.f19419c != null) {
                    this.f19419c.a(parcel != null ? parcel.readLong() : 0L);
                    break;
                }
                break;
            case 6:
                if (this.f19419c != null) {
                    this.f19419c.b(parcel != null ? parcel.readLong() : 0L);
                    break;
                }
                break;
            case 7:
                c cVar3 = this.f19419c;
                if (cVar3 != null) {
                    cVar3.c();
                    break;
                }
                break;
            case 8:
                if (this.f19419c != null) {
                    if (parcel != null) {
                        i3 = parcel.readInt();
                        str = parcel.readString();
                    } else {
                        str = "";
                    }
                    this.f19419c.a(i3, str);
                    break;
                }
                break;
            case 9:
                if (this.f19419c != null) {
                    this.f19419c.c(parcel != null ? parcel.readLong() : 0L);
                    break;
                }
                break;
        }
    }
}
