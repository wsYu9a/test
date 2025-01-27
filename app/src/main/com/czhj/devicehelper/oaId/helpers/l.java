package com.czhj.devicehelper.oaId.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper;
import com.czhj.devicehelper.oaId.interfaces.g;
import com.czhj.sdk.logger.SigmobLog;
import com.shu.priory.config.AdKeys;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a */
    public Context f8354a;

    /* renamed from: b */
    public final LinkedBlockingQueue<IBinder> f8355b = new LinkedBlockingQueue<>(1);

    /* renamed from: c */
    public ServiceConnection f8356c = new a();

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l.this.f8355b.put(iBinder);
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public l(Context context) {
        this.f8354a = context;
    }

    public final boolean a() {
        try {
            return this.f8354a.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
            return false;
        }
    }

    public void a(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (!a()) {
            Log.d(AdKeys.OAID, "oaid  checkService false ");
            return;
        }
        String packageName = this.f8354a.getPackageName();
        a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        if (this.f8354a.bindService(intent, this.f8356c, 1)) {
            try {
                try {
                    Log.d(AdKeys.OAID, "oaid getID()  bindService success called with: pkgName = [" + packageName + "]");
                    String h10 = new g.a.C0250a(this.f8355b.take()).h();
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsAvalid(h10);
                    }
                } catch (Exception e10) {
                    SigmobLog.e(e10.getMessage());
                }
            } finally {
                this.f8354a.unbindService(this.f8356c);
            }
        }
    }

    public final void a(String str) {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", str);
            intent.putExtra("com.bun.msa.param.runinset", true);
            if (this.f8354a.startService(intent) != null) {
                Log.d(AdKeys.OAID, "oaid startMsaklServer()  success called with: pkgName = [" + str + "]");
            }
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
        }
    }
}
