package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public class DeviceIdManager {

    /* renamed from: a */
    public static Map<String, String> f5220a;

    /* renamed from: b */
    private final Context f5221b;

    class a implements Runnable {

        /* renamed from: b */
        private final /* synthetic */ Context f5223b;

        /* renamed from: c */
        private final /* synthetic */ Map f5224c;

        a(Context context, Map map) {
            this.f5223b = context;
            this.f5224c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c cVar = new c();
                cVar.f(this.f5223b, this.f5224c);
                cVar.i(this.f5223b, DeviceIdManager.f5220a);
            } catch (Throwable th) {
                ArrayList arrayList = new ArrayList();
                if (this.f5224c.get(b.b.a.b.b.f4200c) != null && ((String) this.f5224c.get(b.b.a.b.b.f4200c)).length() > 20) {
                    arrayList.add(((String) this.f5224c.get(b.b.a.b.b.f4200c)).substring(0, 20));
                }
                if (this.f5224c.get(b.b.a.b.b.f4204g) != null && ((String) this.f5224c.get(b.b.a.b.b.f4204g)).length() > 20) {
                    arrayList.add(((String) this.f5224c.get(b.b.a.b.b.f4204g)).substring(0, 20));
                }
                arrayList.add(f.e(th));
                f.g(arrayList);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.i();
            } catch (Throwable th) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("");
                arrayList.add("");
                arrayList.add("");
                arrayList.add(f.e(th));
                f.g(arrayList);
            }
        }
    }

    public DeviceIdManager(Context context) {
        this.f5221b = context;
        f.f(context);
    }

    private synchronized void b(Context context, Map<String, String> map) {
        new Thread(new a(context, map)).start();
    }

    private void c() {
        new Thread(new b()).start();
    }

    public String a(Map<String, String> map) {
        c cVar;
        Map<String, String> c2;
        c();
        String str = null;
        try {
            cVar = new c();
            c2 = cVar.c(this.f5221b);
            f5220a = c2;
        } catch (Exception e2) {
            e = e2;
        }
        if (c2 == null) {
            ArrayList arrayList = new ArrayList();
            if (map.get(b.b.a.b.b.f4200c) != null && map.get(b.b.a.b.b.f4200c).length() > 20) {
                arrayList.add(map.get(b.b.a.b.b.f4200c).substring(0, 20));
            }
            if (map.get(b.b.a.b.b.f4204g) != null && map.get(b.b.a.b.b.f4204g).length() > 20) {
                arrayList.add(map.get(b.b.a.b.b.f4204g).substring(0, 20));
            }
            arrayList.add("model.GetPrivateData(mcontext)  strMap is null");
            f.g(arrayList);
            b(this.f5221b, map);
            return null;
        }
        if (cVar.a(c2)) {
            String str2 = f5220a.get(c.w);
            try {
                ArrayList arrayList2 = new ArrayList();
                if (map.get(b.b.a.b.b.f4200c) != null && map.get(b.b.a.b.b.f4200c).length() > 20) {
                    arrayList2.add(map.get(b.b.a.b.b.f4200c).substring(0, 20));
                }
                if (map.get(b.b.a.b.b.f4204g) != null && map.get(b.b.a.b.b.f4204g).length() > 20) {
                    arrayList2.add(map.get(b.b.a.b.b.f4204g).substring(0, 20));
                }
                arrayList2.add("GetApDid  deviceID is " + str2);
                f.g(arrayList2);
                str = str2;
            } catch (Exception e3) {
                e = e3;
                str = str2;
                ArrayList arrayList3 = new ArrayList();
                if (map.get(b.b.a.b.b.f4200c) != null && map.get(b.b.a.b.b.f4200c).length() > 20) {
                    arrayList3.add(map.get(b.b.a.b.b.f4200c).substring(0, 20));
                }
                if (map.get(b.b.a.b.b.f4204g) != null && map.get(b.b.a.b.b.f4204g).length() > 20) {
                    arrayList3.add(map.get(b.b.a.b.b.f4204g).substring(0, 20));
                }
                arrayList3.add(f.e(e));
                f.g(arrayList3);
                return str;
            }
        }
        b(this.f5221b, map);
        return str;
    }
}
