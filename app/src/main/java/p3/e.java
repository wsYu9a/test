package p3;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import java.util.HashMap;
import java.util.Map;
import n3.a;
import org.json.JSONObject;
import p3.k;

/* loaded from: classes.dex */
public class e {

    /* renamed from: i */
    public static final String f29726i = "failed";

    /* renamed from: j */
    public static final String f29727j = "scheme_failed";

    /* renamed from: a */
    public Activity f29728a;

    /* renamed from: b */
    public volatile IAlixPay f29729b;

    /* renamed from: d */
    public boolean f29731d;

    /* renamed from: e */
    public f f29732e;

    /* renamed from: f */
    public final n3.a f29733f;

    /* renamed from: c */
    public final Object f29730c = IAlixPay.class;

    /* renamed from: g */
    public boolean f29734g = false;

    /* renamed from: h */
    public String f29735h = null;

    public class a implements APayEntranceActivity.a {

        /* renamed from: a */
        public final /* synthetic */ Object f29736a;

        public a(Object obj) {
            this.f29736a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            e.this.f29735h = str;
            synchronized (this.f29736a) {
                try {
                    this.f29736a.notify();
                } finally {
                }
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ APayEntranceActivity.a f29738b;

        public b(APayEntranceActivity.a aVar) {
            this.f29738b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f29733f == null || e.this.f29733f.q()) {
                return;
            }
            x2.a.i(e.this.f29733f, x2.b.f31789l, x2.b.f31781e0, "");
            if (b3.a.J().D()) {
                e.this.f29733f.l(true);
                this.f29738b.a(v2.b.a());
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Intent f29740b;

        /* renamed from: c */
        public final /* synthetic */ Object f29741c;

        public c(Intent intent, Object obj) {
            this.f29740b = intent;
            this.f29741c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (e.this.f29728a != null) {
                    e.this.f29728a.startActivity(this.f29740b);
                } else {
                    x2.a.i(e.this.f29733f, x2.b.f31789l, x2.b.f31779c0, "");
                    Context a10 = e.this.f29733f.a();
                    if (a10 != null) {
                        a10.startActivity(this.f29740b);
                    }
                }
            } finally {
            }
        }
    }

    public class d extends IRemoteServiceCallback.Stub {
        public d() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            x2.a.d(e.this.f29733f, x2.b.f31797p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (e.this.f29732e != null) {
                    e.this.f29732e.a();
                }
                if (e.this.f29733f != null) {
                    e.this.f29733f.o(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i10, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i10);
                intent.putExtras(bundle);
            } catch (Exception e10) {
                x2.a.e(e.this.f29733f, x2.b.f31789l, x2.b.Z, e10);
            }
            intent.setClassName(str, str2);
            try {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                x2.a.d(e.this.f29733f, x2.b.f31789l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
            } catch (Throwable unused) {
            }
            try {
                if (e.this.f29728a == null) {
                    x2.a.i(e.this.f29733f, x2.b.f31789l, x2.b.f31777a0, "");
                    Context a10 = e.this.f29733f.a();
                    if (a10 != null) {
                        a10.startActivity(intent);
                        return;
                    }
                    return;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                e.this.f29728a.startActivity(intent);
                x2.a.d(e.this.f29733f, x2.b.f31789l, "stAct2", "" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            } catch (Throwable th2) {
                x2.a.e(e.this.f29733f, x2.b.f31789l, x2.b.f31778b0, th2);
                throw th2;
            }
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this();
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z10, String str) throws RemoteException {
        }
    }

    /* renamed from: p3.e$e */
    public class ServiceConnectionC0764e implements ServiceConnection {
        public ServiceConnectionC0764e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x2.a.c(e.this.f29733f, x2.b.f31789l, "srvCon");
            synchronized (e.this.f29730c) {
                e.this.f29729b = IAlixPay.Stub.asInterface(iBinder);
                e.this.f29730c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            x2.a.c(e.this.f29733f, x2.b.f31789l, "srvDis");
            e.this.f29729b = null;
        }

        public /* synthetic */ ServiceConnectionC0764e(e eVar, a aVar) {
            this();
        }
    }

    public interface f {
        void a();

        void b();
    }

    public e(Activity activity, n3.a aVar, f fVar) {
        this.f29728a = activity;
        this.f29733f = aVar;
        this.f29732e = fVar;
        p3.d.i(z2.a.A, "alipaySdk");
    }

    public static boolean k(String str, Context context, n3.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            x2.a.c(aVar, x2.b.f31789l, "BSADetectFail");
            return false;
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, "BSADetectFail", th2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.String, java.lang.Boolean> a(java.lang.String r18, java.lang.String r19, n3.a r20) {
        /*
            Method dump skipped, instructions count: 922
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.e.a(java.lang.String, java.lang.String, n3.a):android.util.Pair");
    }

    public final String c(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String g10 = k.g(32);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        x2.a.d(this.f29733f, x2.b.f31789l, "BSAStart", g10 + "|" + elapsedRealtime);
        a.C0746a.d(this.f29733f, g10);
        a aVar = new a(obj);
        APayEntranceActivity.f6482i.put(g10, aVar);
        try {
            try {
                HashMap<String, String> f10 = n3.a.f(this.f29733f);
                f10.put("ts_intent", String.valueOf(elapsedRealtime));
                jSONObject = new JSONObject(f10);
            } catch (Throwable th2) {
                x2.a.e(this.f29733f, x2.b.f31789l, "BSALocEx", th2);
                jSONObject = null;
            }
            Intent intent = new Intent(this.f29728a, (Class<?>) APayEntranceActivity.class);
            intent.putExtra(APayEntranceActivity.f6478e, str);
            intent.putExtra(APayEntranceActivity.f6479f, str2);
            intent.putExtra(APayEntranceActivity.f6480g, g10);
            if (jSONObject != null) {
                intent.putExtra(APayEntranceActivity.f6481h, jSONObject.toString());
            }
            new Handler(Looper.getMainLooper()).postDelayed(new b(aVar), b3.a.J().s());
            Activity activity = this.f29728a;
            n3.a aVar2 = this.f29733f;
            x2.a.b(activity, aVar2, str, aVar2.f28764d);
            if (b3.a.J().G()) {
                new Handler(Looper.getMainLooper()).post(new c(intent, obj));
            } else {
                try {
                    Activity activity2 = this.f29728a;
                    if (activity2 != null) {
                        activity2.startActivity(intent);
                    } else {
                        x2.a.i(this.f29733f, x2.b.f31789l, x2.b.f31777a0, "");
                        Context a10 = this.f29733f.a();
                        if (a10 != null) {
                            a10.startActivity(intent);
                        }
                    }
                } catch (Throwable th3) {
                    x2.a.e(this.f29733f, x2.b.f31789l, x2.b.f31778b0, th3);
                    throw th3;
                }
            }
            synchronized (obj) {
                obj.wait();
            }
            String str3 = this.f29735h;
            String str4 = "unknown";
            try {
                String str5 = i.d(this.f29733f, str3).get(i.f29756a);
                str4 = str5 == null ? "null" : str5;
            } catch (Throwable th4) {
                x2.a.e(this.f29733f, x2.b.f31789l, "BSAStatEx", th4);
            }
            x2.a.c(this.f29733f, x2.b.f31789l, "BSADone-" + str4);
            if (!TextUtils.isEmpty(str3)) {
                return str3;
            }
            x2.a.c(this.f29733f, x2.b.f31789l, "BSAEmpty");
            return f29727j;
        } catch (InterruptedException e10) {
            x2.a.e(this.f29733f, x2.b.f31789l, "BSAWaiting", e10);
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
            return v2.b.b(cVar.b(), cVar.a(), "");
        } catch (Throwable th5) {
            x2.a.e(this.f29733f, x2.b.f31789l, "BSAEx", th5);
            k.u("alipaySdk", z2.b.f33632q, this.f29728a, this.f29733f);
            return f29727j;
        }
    }

    public final String d(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        p3.d.i(z2.a.A, "pay payInvokeAct");
        x2.a.d(this.f29733f, x2.b.f31789l, x2.b.X, str2 + "|" + str3);
        Activity activity = this.f29728a;
        n3.a aVar = this.f29733f;
        x2.a.b(activity, aVar, str, aVar.f28764d);
        return c(str, str2);
    }

    public final String e(String str, String str2, PackageInfo packageInfo, k.c cVar) {
        String str3;
        Activity activity;
        boolean z10 = false;
        int i10 = packageInfo != null ? packageInfo.versionCode : 0;
        p3.d.i(z2.a.A, "pay bind or scheme");
        n3.a aVar = this.f29733f;
        if (aVar != null && !TextUtils.isEmpty(aVar.f28767g)) {
            z10 = this.f29733f.f28767g.toLowerCase().contains(x2.b.f31793n);
        }
        if (z10 || !k.R(this.f29733f, str2)) {
            if (cVar != null) {
                try {
                    if (!b3.a.J().x()) {
                        j(cVar);
                    }
                } catch (Throwable unused) {
                }
            }
            Pair<String, Boolean> a10 = a(str, str2, this.f29733f);
            str3 = (String) a10.first;
            try {
                if (f29726i.equals(str3) && ((Boolean) a10.second).booleanValue() && b3.a.J().v()) {
                    x2.a.c(this.f29733f, x2.b.f31789l, "BindRetry");
                    str3 = (String) a(str, str2, this.f29733f).first;
                }
            } catch (Throwable th2) {
                x2.a.e(this.f29733f, x2.b.f31789l, "BindRetryEx", th2);
            }
        } else {
            if (cVar != null) {
                try {
                    if (b3.a.J().H()) {
                        j(cVar);
                    }
                } catch (Throwable unused2) {
                }
            }
            x2.a.c(this.f29733f, x2.b.f31789l, "BindSkipByL");
            str3 = f29726i;
        }
        p3.d.i(z2.a.A, "pay bind result: " + str3);
        Activity activity2 = this.f29728a;
        n3.a aVar2 = this.f29733f;
        x2.a.b(activity2, aVar2, str, aVar2.f28764d);
        if (f29726i.equals(str3)) {
            if (!k.f29761b.equals(str2)) {
                x2.a.d(this.f29733f, x2.b.f31789l, "BSPNotStartByAlipay", str2 + "|" + i10);
                return str3;
            }
            if (i10 >= 460 && !z10 && (activity = this.f29728a) != null && k(str2, activity, this.f29733f)) {
                return d(str, str2, packageInfo);
            }
        }
        return str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #1 {all -> 0x0050, blocks: (B:12:0x0023, B:14:0x002b, B:17:0x0033, B:20:0x003c, B:23:0x0042, B:26:0x004b, B:27:0x0056, B:30:0x005b, B:32:0x0065, B:73:0x0052), top: B:11:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String f(java.lang.String r9, boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            r1 = 0
            b3.a r2 = b3.a.J()     // Catch: java.lang.Throwable -> Lb0
            java.util.List r2 = r2.t()     // Catch: java.lang.Throwable -> Lb0
            b3.a r3 = b3.a.J()     // Catch: java.lang.Throwable -> Lb0
            boolean r3 = r3.f1139g     // Catch: java.lang.Throwable -> Lb0
            if (r3 == 0) goto L15
            if (r2 != 0) goto L17
        L15:
            java.util.List<b3.a$b> r2 = v2.a.f31216d     // Catch: java.lang.Throwable -> Lb0
        L17:
            n3.a r3 = r8.f29733f     // Catch: java.lang.Throwable -> Lb0
            android.app.Activity r4 = r8.f29728a     // Catch: java.lang.Throwable -> Lb0
            p3.k$c r2 = p3.k.t(r3, r4, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r3 = "failed"
            if (r2 == 0) goto Laf
            n3.a r4 = r8.f29733f     // Catch: java.lang.Throwable -> L50
            boolean r4 = r2.b(r4)     // Catch: java.lang.Throwable -> L50
            if (r4 != 0) goto Laf
            boolean r4 = r2.a()     // Catch: java.lang.Throwable -> L50
            if (r4 == 0) goto L33
            goto Laf
        L33:
            android.content.pm.PackageInfo r4 = r2.f29773a     // Catch: java.lang.Throwable -> L50
            boolean r4 = p3.k.w(r4)     // Catch: java.lang.Throwable -> L50
            if (r4 == 0) goto L3c
            return r3
        L3c:
            android.content.pm.PackageInfo r3 = r2.f29773a     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L52
            java.lang.String r4 = "com.eg.android.AlipayGphone"
            java.lang.String r3 = r3.packageName     // Catch: java.lang.Throwable -> L50
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L4b
            goto L52
        L4b:
            android.content.pm.PackageInfo r3 = r2.f29773a     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = r3.packageName     // Catch: java.lang.Throwable -> L50
            goto L56
        L50:
            r3 = move-exception
            goto Lb2
        L52:
            java.lang.String r0 = p3.k.D()     // Catch: java.lang.Throwable -> L50
        L56:
            android.content.pm.PackageInfo r3 = r2.f29773a     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto L5b
            r1 = r3
        L5b:
            b3.a r3 = b3.a.J()     // Catch: java.lang.Throwable -> L50
            java.lang.String r3 = r3.m()     // Catch: java.lang.Throwable -> L50
            if (r3 == 0) goto Lbb
            int r4 = r3.length()     // Catch: java.lang.Throwable -> L50
            if (r4 <= 0) goto Lbb
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Lad
            r4.<init>(r3)     // Catch: java.lang.Throwable -> Lad
            org.json.JSONObject r3 = r4.optJSONObject(r0)     // Catch: java.lang.Throwable -> Lad
            if (r3 == 0) goto Lbb
            int r4 = r3.length()     // Catch: java.lang.Throwable -> Lad
            if (r4 <= 0) goto Lbb
            java.util.Iterator r4 = r3.keys()     // Catch: java.lang.Throwable -> Lad
        L80:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> Lad
            if (r5 == 0) goto Lbb
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> Lad
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> Lad
            int r6 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Throwable -> Lad
            if (r1 == 0) goto L80
            int r7 = r1.versionCode     // Catch: java.lang.Throwable -> Lad
            if (r7 < r6) goto L80
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> Lad
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> Lad
            b3.a r6 = b3.a.J()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> Lad
            android.app.Activity r7 = r8.f29728a     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> Lad
            boolean r5 = r6.k(r7, r5)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> Lad
            r8.f29734g = r5     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> Lad
            if (r5 == 0) goto L80
            goto Lbb
        Lad:
            goto Lbb
        Laf:
            return r3
        Lb0:
            r3 = move-exception
            r2 = r1
        Lb2:
            n3.a r4 = r8.f29733f
            java.lang.String r5 = "biz"
            java.lang.String r6 = "CheckClientSignEx"
            x2.a.e(r4, r5, r6, r3)
        Lbb:
            n3.a r3 = r8.f29733f
            boolean r3 = p3.k.J(r3)
            if (r10 != 0) goto Lc7
            boolean r10 = r8.f29734g
            if (r10 == 0) goto Ld8
        Lc7:
            if (r3 != 0) goto Ld8
            android.app.Activity r10 = r8.f29728a
            n3.a r3 = r8.f29733f
            boolean r10 = k(r0, r10, r3)
            if (r10 == 0) goto Ld8
            java.lang.String r9 = r8.d(r9, r0, r1)
            return r9
        Ld8:
            java.lang.String r9 = r8.e(r9, r0, r1, r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p3.e.f(java.lang.String, boolean):java.lang.String");
    }

    public void i() {
        this.f29728a = null;
        this.f29732e = null;
    }

    public final void j(k.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.f29773a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f29728a.startActivity(intent);
        } catch (Throwable th2) {
            x2.a.e(this.f29733f, x2.b.f31789l, x2.b.f31783g0, th2);
        }
        Thread.sleep(200L);
    }
}
