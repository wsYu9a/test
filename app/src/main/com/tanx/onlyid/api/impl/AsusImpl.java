package com.tanx.onlyid.api.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.asus.msa.SupplementaryDID.IDidAidlInterface;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class AsusImpl implements d {

    /* renamed from: a */
    public final Context f21988a;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDidAidlInterface asInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (asInterface == null) {
                throw new OAIDException("IDidAidlInterface is null");
            }
            if (asInterface.isSupport()) {
                return asInterface.getOAID();
            }
            throw new OAIDException("IDidAidlInterface#isSupport return false");
        }
    }

    public AsusImpl(Context context) {
        this.f21988a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f21988a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        b.a(this.f21988a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f21988a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
