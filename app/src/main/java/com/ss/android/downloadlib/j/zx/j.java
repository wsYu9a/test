package com.ss.android.downloadlib.j.zx;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.j.zx.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: g */
    private static String f24307g = "";
    private static String gv = "";
    private static volatile j lg = null;
    private static String q = "";

    /* renamed from: j */
    public i f24309j;
    private Context t;
    private boolean y = true;
    private boolean k = false;
    private volatile boolean pa = false;
    private final List<Pair<zx, g>> nt = new ArrayList();
    public final List<InterfaceC0500j> zx = new ArrayList();
    private final ServiceConnection p = new ServiceConnection() { // from class: com.ss.android.downloadlib.j.zx.j.1
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (j.this.f24308i) {
                j.this.j(false);
                j.this.f24309j = i.j.j(iBinder);
                j.this.i();
                Iterator<InterfaceC0500j> it = j.this.zx.iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (j.this.f24308i) {
                j.this.j(false);
                j jVar = j.this;
                jVar.f24309j = null;
                Iterator<InterfaceC0500j> it = jVar.zx.iterator();
                while (it.hasNext()) {
                    it.next().zx();
                }
            }
        }
    };
    private String r = "";

    /* renamed from: i */
    public final Object f24308i = new Object();

    /* renamed from: com.ss.android.downloadlib.j.zx.j$1 */
    class AnonymousClass1 implements ServiceConnection {
        AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (j.this.f24308i) {
                j.this.j(false);
                j.this.f24309j = i.j.j(iBinder);
                j.this.i();
                Iterator<InterfaceC0500j> it = j.this.zx.iterator();
                while (it.hasNext()) {
                    it.next().j();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (j.this.f24308i) {
                j.this.j(false);
                j jVar = j.this;
                jVar.f24309j = null;
                Iterator<InterfaceC0500j> it = jVar.zx.iterator();
                while (it.hasNext()) {
                    it.next().zx();
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.j.zx.j$j */
    public interface InterfaceC0500j {
        void j();

        void zx();
    }

    private j() {
    }

    public static j j() {
        if (lg == null) {
            synchronized (j.class) {
                if (lg == null) {
                    lg = new j();
                }
            }
        }
        return lg;
    }

    public boolean g() {
        return this.pa;
    }

    public void i() {
        for (Pair<zx, g> pair : this.nt) {
            try {
                this.f24309j.j((zx) pair.first, (g) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.nt.clear();
    }

    public void zx() {
        if (this.f24309j != null) {
            this.t.unbindService(this.p);
            this.f24309j = null;
        }
        this.zx.clear();
        this.nt.clear();
    }

    public boolean j(Context context, boolean z) {
        if (TextUtils.isEmpty(f24307g)) {
            JSONObject k = pa.k();
            String optString = k.optString("s");
            f24307g = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("q"), optString);
            q = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString("u"), optString);
            gv = com.ss.android.socialbase.appdownloader.gv.i.j(k.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.k = z;
        if (context == null) {
            return true;
        }
        this.t = context.getApplicationContext();
        if (TextUtils.isEmpty(gv)) {
            gv = this.t.getPackageName();
        }
        if (this.f24309j != null || g()) {
            return true;
        }
        return this.t.bindService(j(context), this.p, 33);
    }

    public Intent j(Context context) {
        Intent intent = new Intent();
        intent.setAction(f24307g);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (q.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void j(zx zxVar, g gVar) {
        synchronized (this.f24308i) {
            zxVar.q = gv;
            if (TextUtils.isEmpty(zxVar.gv)) {
                zxVar.gv = this.r;
            }
            i iVar = this.f24309j;
            if (iVar != null) {
                try {
                    iVar.j(zxVar, gVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (g() || j(this.t, this.k)) {
                this.nt.add(Pair.create(zxVar, gVar));
            }
        }
    }

    public void j(boolean z) {
        this.pa = z;
    }
}
