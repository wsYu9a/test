package com.vivo.mobilead.e.c;

import android.database.ContentObserver;

/* loaded from: classes4.dex */
public class d extends ContentObserver {

    /* renamed from: a */
    private String f28820a;

    /* renamed from: b */
    private int f28821b;

    /* renamed from: c */
    private b f28822c;

    d(b bVar, int i2, String str) {
        super(null);
        this.f28822c = bVar;
        this.f28821b = i2;
        this.f28820a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.f28822c;
        if (bVar != null) {
            bVar.a(this.f28821b, this.f28820a);
        } else {
            c.b("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
