package com.tanx.onlyid.api.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.heytap.openid.IOpenID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class OppoImpl implements d {

    /* renamed from: a */
    public final Context f22024a;

    /* renamed from: b */
    public String f22025b;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return OppoImpl.this.e(iBinder);
            } catch (RemoteException e10) {
                throw e10;
            } catch (OAIDException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new OAIDException(e12);
            }
        }
    }

    public OppoImpl(Context context) {
        if (context instanceof Application) {
            this.f22024a = context;
        } else {
            this.f22024a = context.getApplicationContext();
        }
    }

    @Override // ug.d
    public void a(c cVar) {
        if (this.f22024a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        b.a(this.f22024a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f22024a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }

    public final String d(IBinder iBinder, String str, String str2) throws RemoteException, OAIDException {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final String e(IBinder iBinder) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException, OAIDException {
        String packageName = this.f22024a.getPackageName();
        String str = this.f22025b;
        if (str != null) {
            return d(iBinder, packageName, str);
        }
        byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f22024a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb2 = new StringBuilder();
        for (byte b10 : digest) {
            sb2.append(Integer.toHexString((b10 & 255) | 256).substring(1, 3));
        }
        String sb3 = sb2.toString();
        this.f22025b = sb3;
        return d(iBinder, packageName, sb3);
    }
}
