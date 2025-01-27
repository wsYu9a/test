package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.android.creator.IdsSupplier;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
public class FreemeImpl implements d {

    /* renamed from: a */
    public final Context f21994a;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (asInterface != null) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IdsSupplier is null");
        }
    }

    public FreemeImpl(Context context) {
        this.f21994a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f21994a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        b.a(this.f21994a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f21994a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
