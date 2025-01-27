package com.opos.mobad.cmn.service.pkginstall;

import android.content.Context;
import android.content.IntentFilter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static final byte[] f20354a = new byte[0];

    /* renamed from: b */
    private static volatile c f20355b;

    /* renamed from: g */
    private SystemBR f20360g;

    /* renamed from: c */
    private Map<Integer, a> f20356c = null;

    /* renamed from: d */
    private Map<Integer, a> f20357d = null;

    /* renamed from: e */
    private Map<Integer, a> f20358e = null;

    /* renamed from: f */
    private volatile ExecutorService f20359f = null;

    /* renamed from: h */
    private boolean f20361h = false;

    /* renamed from: com.opos.mobad.cmn.service.pkginstall.c$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f20362a;

        /* renamed from: b */
        final /* synthetic */ Object[] f20363b;

        AnonymousClass1(int i2, Object[] objArr) {
            i2 = i2;
            objArr = objArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = i2;
            if (i2 == 0) {
                c cVar = c.this;
                cVar.a((Map<Integer, a>) cVar.f20356c, objArr);
            } else if (i2 == 1) {
                c cVar2 = c.this;
                cVar2.a((Map<Integer, a>) cVar2.f20357d, objArr);
            } else {
                if (i2 != 2) {
                    return;
                }
                c cVar3 = c.this;
                cVar3.a((Map<Integer, a>) cVar3.f20358e, objArr);
            }
        }
    }

    private c() {
        b();
    }

    public static c a() {
        c cVar = f20355b;
        if (cVar == null) {
            synchronized (f20354a) {
                cVar = f20355b;
                if (cVar == null) {
                    cVar = new c();
                    f20355b = cVar;
                }
            }
        }
        return cVar;
    }

    public void a(Map<Integer, a> map, Object... objArr) {
        if (map != null) {
            try {
                if (map.size() > 0) {
                    Iterator<a> it = map.values().iterator();
                    while (it.hasNext()) {
                        it.next().a(objArr);
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e2);
            }
        }
    }

    private void b() {
        this.f20356c = new ConcurrentHashMap();
        this.f20357d = new ConcurrentHashMap();
        this.f20358e = new ConcurrentHashMap();
    }

    private void c() {
        this.f20356c.clear();
        this.f20357d.clear();
        this.f20358e.clear();
    }

    private void c(Context context) {
        if (context != null) {
            this.f20360g = new SystemBR();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            context.registerReceiver(this.f20360g, intentFilter);
        }
    }

    private ExecutorService d() {
        ExecutorService executorService = this.f20359f;
        if (executorService == null) {
            synchronized (f20354a) {
                executorService = this.f20359f;
                if (executorService == null) {
                    executorService = com.opos.cmn.an.i.a.g();
                    this.f20359f = executorService;
                }
            }
        }
        return executorService;
    }

    private void d(Context context) {
        SystemBR systemBR;
        if (context == null || (systemBR = this.f20360g) == null) {
            return;
        }
        context.unregisterReceiver(systemBR);
        this.f20360g = null;
    }

    public int a(int i2, a aVar) {
        String str;
        int i3 = -1;
        if (aVar != null) {
            try {
                i3 = aVar.hashCode();
                if (i2 == 0) {
                    this.f20356c.put(Integer.valueOf(i3), aVar);
                    str = "addISystemBRListener sPkgAddedBRListenerMap.size=" + this.f20356c.size();
                } else if (i2 == 1) {
                    this.f20357d.put(Integer.valueOf(i3), aVar);
                    str = "addISystemBRListener sPkgReplacedBRListenerMap.size=" + this.f20357d.size();
                } else if (i2 == 2) {
                    this.f20358e.put(Integer.valueOf(i3), aVar);
                    str = "addISystemBRListener sPkgRemovedBRListenerMap.size=" + this.f20358e.size();
                }
                com.opos.cmn.an.f.a.b("SystemBRMgr", str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("SystemBRMgr", "addISystemBRListener systemEventId=" + i2 + ",listenerId=" + i3);
        return i3;
    }

    public void a(int i2, int i3) {
        String str;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e2);
        }
        if (i2 == 0) {
            if (this.f20356c.containsKey(Integer.valueOf(i3))) {
                this.f20356c.remove(Integer.valueOf(i3));
                str = "removeISystemBRListener sPkgAddedBRListenerMap.size=" + this.f20356c.size();
            }
            com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i2 + ",listenerId=" + i3);
        }
        if (i2 == 1) {
            if (this.f20357d.containsKey(Integer.valueOf(i3))) {
                this.f20357d.remove(Integer.valueOf(i3));
                str = "removeISystemBRListener sPkgReplacedBRListenerMap.size=" + this.f20357d.size();
            }
            com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i2 + ",listenerId=" + i3);
        }
        if (i2 == 2 && this.f20358e.containsKey(Integer.valueOf(i3))) {
            this.f20358e.remove(Integer.valueOf(i3));
            str = "removeISystemBRListener sPkgRemovedBRListenerMap.size=" + this.f20358e.size();
        }
        com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i2 + ",listenerId=" + i3);
        com.opos.cmn.an.f.a.b("SystemBRMgr", str);
        com.opos.cmn.an.f.a.b("SystemBRMgr", "removeISystemBRListener systemEventId=" + i2 + ",listenerId=" + i3);
    }

    public void a(int i2, Object... objArr) {
        try {
            a(new Runnable() { // from class: com.opos.mobad.cmn.service.pkginstall.c.1

                /* renamed from: a */
                final /* synthetic */ int f20362a;

                /* renamed from: b */
                final /* synthetic */ Object[] f20363b;

                AnonymousClass1(int i22, Object[] objArr2) {
                    i2 = i22;
                    objArr = objArr2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i22 = i2;
                    if (i22 == 0) {
                        c cVar = c.this;
                        cVar.a((Map<Integer, a>) cVar.f20356c, objArr);
                    } else if (i22 == 1) {
                        c cVar2 = c.this;
                        cVar2.a((Map<Integer, a>) cVar2.f20357d, objArr);
                    } else {
                        if (i22 != 2) {
                            return;
                        }
                        c cVar3 = c.this;
                        cVar3.a((Map<Integer, a>) cVar3.f20358e, objArr);
                    }
                }
            });
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("notifyBRListener systemEventId=");
        sb.append(i22);
        sb.append(",objects=");
        Object obj = objArr2;
        if (objArr2 == null) {
            obj = "null";
        }
        sb.append(obj);
        com.opos.cmn.an.f.a.b("SystemBRMgr", sb.toString());
    }

    public void a(Context context) {
        synchronized (this) {
            try {
                com.opos.cmn.an.f.a.b("SystemBRMgr", "register mHasRegistered=" + this.f20361h);
                if (context != null && !this.f20361h) {
                    Context applicationContext = context.getApplicationContext();
                    c();
                    c(applicationContext);
                    this.f20361h = true;
                    com.opos.cmn.an.f.a.b("SystemBRMgr", "really register.");
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e2);
            }
        }
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            try {
                d().execute(runnable);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "");
            }
        }
    }

    public void b(Context context) {
        synchronized (this) {
            try {
                com.opos.cmn.an.f.a.b("SystemBRMgr", "unregister mHasRegistered=" + this.f20361h);
                if (context != null && this.f20361h) {
                    d(context.getApplicationContext());
                    c();
                    this.f20361h = false;
                    com.opos.cmn.an.f.a.b("SystemBRMgr", "really unregister.");
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("SystemBRMgr", "", (Throwable) e2);
            }
        }
    }
}
