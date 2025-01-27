package com.tanx.onlyid.api.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.tanx.onlyid.api.OAIDException;
import com.tanx.onlyid.api.impl.b;
import com.tanx.onlyid.core.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import ug.c;
import ug.d;
import ug.e;

/* loaded from: classes4.dex */
class HuaweiImpl implements d {

    /* renamed from: a */
    public final Context f22015a;

    /* renamed from: b */
    public String f22016b;

    public class a implements b.a {
        public a() {
        }

        @Override // com.tanx.onlyid.api.impl.b.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (asInterface.isOaidTrackLimited()) {
                throw new OAIDException("User has disabled advertising identifier");
            }
            return asInterface.getOaid();
        }
    }

    public HuaweiImpl(Context context) {
        this.f22015a = context;
    }

    @Override // ug.d
    public void a(c cVar) {
        Context context = this.f22015a;
        if (context == null || cVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    e.b("Get oaid from global settings: " + string);
                    cVar.oaidSucc(string);
                    return;
                }
            } catch (Exception e10) {
                e.b(e10);
            }
        }
        if (TextUtils.isEmpty(this.f22016b) && !b()) {
            cVar.oaidError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f22016b);
        b.a(this.f22015a, intent, cVar, new a());
    }

    @Override // ug.d
    public boolean b() {
        Context context = this.f22015a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f22016b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f22016b = "com.huawei.hwid.tv";
            } else {
                this.f22016b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            e.b(e10);
            return false;
        }
    }
}
