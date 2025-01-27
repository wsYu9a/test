package com.ss.android.downloadlib.a.a;

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
import com.ss.android.downloadlib.a.a.c;
import com.ss.android.downloadlib.addownload.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: d */
    private static String f21099d = "";

    /* renamed from: e */
    private static String f21100e = "";

    /* renamed from: f */
    private static String f21101f = "";

    /* renamed from: g */
    private static volatile a f21102g;

    /* renamed from: a */
    public c f21103a;

    /* renamed from: k */
    private Context f21109k;

    /* renamed from: h */
    private boolean f21106h = true;

    /* renamed from: i */
    private boolean f21107i = false;

    /* renamed from: j */
    private volatile boolean f21108j = false;

    /* renamed from: l */
    private final List<Pair<b, d>> f21110l = new ArrayList();

    /* renamed from: b */
    public final List<InterfaceC0633a> f21104b = new ArrayList();

    /* renamed from: m */
    private final ServiceConnection f21111m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.a.a.1
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f21105c) {
                try {
                    a.this.a(false);
                    a.this.f21103a = c.a.a(iBinder);
                    a.this.c();
                    Iterator<InterfaceC0633a> it = a.this.f21104b.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f21105c) {
                try {
                    a.this.a(false);
                    a aVar = a.this;
                    aVar.f21103a = null;
                    Iterator<InterfaceC0633a> it = aVar.f21104b.iterator();
                    while (it.hasNext()) {
                        it.next().b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    };

    /* renamed from: n */
    private String f21112n = "";

    /* renamed from: c */
    public final Object f21105c = new Object();

    /* renamed from: com.ss.android.downloadlib.a.a.a$1 */
    public class AnonymousClass1 implements ServiceConnection {
        public AnonymousClass1() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f21105c) {
                try {
                    a.this.a(false);
                    a.this.f21103a = c.a.a(iBinder);
                    a.this.c();
                    Iterator<InterfaceC0633a> it = a.this.f21104b.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f21105c) {
                try {
                    a.this.a(false);
                    a aVar = a.this;
                    aVar.f21103a = null;
                    Iterator<InterfaceC0633a> it = aVar.f21104b.iterator();
                    while (it.hasNext()) {
                        it.next().b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.a.a.a$a */
    public interface InterfaceC0633a {
        void a();

        void b();
    }

    private a() {
    }

    public static a a() {
        if (f21102g == null) {
            synchronized (a.class) {
                try {
                    if (f21102g == null) {
                        f21102g = new a();
                    }
                } finally {
                }
            }
        }
        return f21102g;
    }

    public void b() {
        if (this.f21103a != null) {
            this.f21109k.unbindService(this.f21111m);
            this.f21103a = null;
        }
        this.f21104b.clear();
        this.f21110l.clear();
    }

    public void c() {
        for (Pair<b, d> pair : this.f21110l) {
            try {
                this.f21103a.a((b) pair.first, (d) pair.second);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        this.f21110l.clear();
    }

    public boolean d() {
        return this.f21108j;
    }

    public boolean a(Context context, boolean z10) {
        if (TextUtils.isEmpty(f21099d)) {
            JSONObject j10 = k.j();
            String optString = j10.optString("s");
            f21099d = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("q"), optString);
            f21100e = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString("u"), optString);
            f21101f = com.ss.android.socialbase.appdownloader.f.c.a(j10.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.f21107i = z10;
        if (context == null) {
            return true;
        }
        this.f21109k = context.getApplicationContext();
        if (TextUtils.isEmpty(f21101f)) {
            f21101f = this.f21109k.getPackageName();
        }
        if (this.f21103a != null || d()) {
            return true;
        }
        return this.f21109k.bindService(a(context), this.f21111m, 33);
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(f21099d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        Iterator<ResolveInfo> it = queryIntentServices.iterator();
        while (it.hasNext()) {
            ServiceInfo serviceInfo = it.next().serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f21100e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f21105c) {
            try {
                bVar.f21118e = f21101f;
                if (TextUtils.isEmpty(bVar.f21119f)) {
                    bVar.f21119f = this.f21112n;
                }
                c cVar = this.f21103a;
                if (cVar != null) {
                    try {
                        cVar.a(bVar, dVar);
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                } else if (d() || a(this.f21109k, this.f21107i)) {
                    this.f21110l.add(Pair.create(bVar, dVar));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(boolean z10) {
        this.f21108j = z10;
    }
}
