package com.opos.cmn.an.e;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import com.kuaishou.weapon.p0.g;
import com.opos.cmn.an.e.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    private static c f16387a;

    /* renamed from: c */
    private Context f16389c;

    /* renamed from: f */
    private volatile CountDownLatch f16392f;

    /* renamed from: g */
    private volatile LocationManager f16393g;

    /* renamed from: h */
    private volatile b f16394h;

    /* renamed from: i */
    private volatile long f16395i;

    /* renamed from: j */
    private volatile b f16396j;

    /* renamed from: b */
    private LocationListener f16388b = new LocationListener() { // from class: com.opos.cmn.an.e.c.1
        AnonymousClass1() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.b("LocationManager", "location onLocationChanged location");
            if (location != null) {
                c.this.a(location);
                CountDownLatch countDownLatch = c.this.f16392f;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderDisabled provider=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderEnabled provider=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onStatusChanged provider=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(",status=");
            sb.append(i2);
            sb.append(",extras=");
            sb.append(bundle != null ? bundle.toString() : "null");
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }
    };
    private LocationListener k = new LocationListener() { // from class: com.opos.cmn.an.e.c.2
        AnonymousClass2() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.b("LocationManager", "passive onLocationChanged location");
            if (location != null) {
                c.this.a(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    };

    /* renamed from: e */
    private a f16391e = new a(new a.b() { // from class: com.opos.cmn.an.e.c.3

        /* renamed from: com.opos.cmn.an.e.c$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0368a f16400a;

            AnonymousClass1(a.InterfaceC0368a interfaceC0368a) {
                interfaceC0368a = interfaceC0368a;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("LocationManager", "init");
                try {
                    c.this.a(interfaceC0368a);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("LocationManager", "init fail", e2);
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.cmn.an.e.a.b
        public void a(a.InterfaceC0368a interfaceC0368a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.cmn.an.e.c.3.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0368a f16400a;

                AnonymousClass1(a.InterfaceC0368a interfaceC0368a2) {
                    interfaceC0368a = interfaceC0368a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.b("LocationManager", "init");
                    try {
                        c.this.a(interfaceC0368a);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("LocationManager", "init fail", e2);
                    }
                }
            });
        }
    });

    /* renamed from: d */
    private a f16390d = new a(new a.b() { // from class: com.opos.cmn.an.e.c.4

        /* renamed from: com.opos.cmn.an.e.c$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0368a f16403a;

            AnonymousClass1(a.InterfaceC0368a interfaceC0368a) {
                interfaceC0368a = interfaceC0368a;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("LocationManager", "locate");
                try {
                    c.this.b(interfaceC0368a);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("LocationManager", "locate fail", e2);
                }
            }
        }

        AnonymousClass4() {
        }

        @Override // com.opos.cmn.an.e.a.b
        public void a(a.InterfaceC0368a interfaceC0368a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.cmn.an.e.c.4.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0368a f16403a;

                AnonymousClass1(a.InterfaceC0368a interfaceC0368a2) {
                    interfaceC0368a = interfaceC0368a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.b("LocationManager", "locate");
                    try {
                        c.this.b(interfaceC0368a);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("LocationManager", "locate fail", e2);
                    }
                }
            });
        }
    });

    /* renamed from: com.opos.cmn.an.e.c$1 */
    class AnonymousClass1 implements LocationListener {
        AnonymousClass1() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.b("LocationManager", "location onLocationChanged location");
            if (location != null) {
                c.this.a(location);
                CountDownLatch countDownLatch = c.this.f16392f;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderDisabled provider=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderEnabled provider=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onStatusChanged provider=");
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            sb.append(",status=");
            sb.append(i2);
            sb.append(",extras=");
            sb.append(bundle != null ? bundle.toString() : "null");
            com.opos.cmn.an.f.a.b("LocationManager", sb.toString());
        }
    }

    /* renamed from: com.opos.cmn.an.e.c$2 */
    class AnonymousClass2 implements LocationListener {
        AnonymousClass2() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.b("LocationManager", "passive onLocationChanged location");
            if (location != null) {
                c.this.a(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    /* renamed from: com.opos.cmn.an.e.c$3 */
    class AnonymousClass3 implements a.b {

        /* renamed from: com.opos.cmn.an.e.c$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0368a f16400a;

            AnonymousClass1(a.InterfaceC0368a interfaceC0368a2) {
                interfaceC0368a = interfaceC0368a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("LocationManager", "init");
                try {
                    c.this.a(interfaceC0368a);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("LocationManager", "init fail", e2);
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.cmn.an.e.a.b
        public void a(a.InterfaceC0368a interfaceC0368a2) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.cmn.an.e.c.3.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0368a f16400a;

                AnonymousClass1(a.InterfaceC0368a interfaceC0368a22) {
                    interfaceC0368a = interfaceC0368a22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.b("LocationManager", "init");
                    try {
                        c.this.a(interfaceC0368a);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("LocationManager", "init fail", e2);
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.cmn.an.e.c$4 */
    class AnonymousClass4 implements a.b {

        /* renamed from: com.opos.cmn.an.e.c$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0368a f16403a;

            AnonymousClass1(a.InterfaceC0368a interfaceC0368a2) {
                interfaceC0368a = interfaceC0368a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("LocationManager", "locate");
                try {
                    c.this.b(interfaceC0368a);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("LocationManager", "locate fail", e2);
                }
            }
        }

        AnonymousClass4() {
        }

        @Override // com.opos.cmn.an.e.a.b
        public void a(a.InterfaceC0368a interfaceC0368a2) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.cmn.an.e.c.4.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0368a f16403a;

                AnonymousClass1(a.InterfaceC0368a interfaceC0368a22) {
                    interfaceC0368a = interfaceC0368a22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.b("LocationManager", "locate");
                    try {
                        c.this.b(interfaceC0368a);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("LocationManager", "locate fail", e2);
                    }
                }
            });
        }
    }

    private c() {
    }

    public static c a() {
        c cVar = f16387a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (c.class) {
            if (f16387a == null) {
                f16387a = new c();
            }
        }
        return f16387a;
    }

    public void a(Location location) {
        com.opos.cmn.an.f.a.b("LocationManager", "reset location provider:" + location.getProvider());
        if ("gps".equals(location.getProvider())) {
            b bVar = this.f16394h;
            if (bVar == null || bVar.a() < location.getElapsedRealtimeNanos()) {
                this.f16394h = b(location);
                return;
            }
            return;
        }
        if (!"network".equals(location.getProvider())) {
            com.opos.cmn.an.f.a.b("LocationManager", "location with unexpected provider");
            return;
        }
        b bVar2 = this.f16396j;
        if (bVar2 == null || bVar2.a() < location.getElapsedRealtimeNanos()) {
            this.f16396j = b(location);
        }
    }

    public void a(a.InterfaceC0368a interfaceC0368a) {
        LocationManager g2;
        if (f() && (g2 = g()) != null) {
            Location lastKnownLocation = g2.getLastKnownLocation("gps");
            if (lastKnownLocation != null) {
                a(lastKnownLocation);
            }
            Location lastKnownLocation2 = g2.getLastKnownLocation("network");
            if (lastKnownLocation2 != null) {
                a(lastKnownLocation2);
            }
            if (j()) {
                g2.requestLocationUpdates("passive", 60000L, 50.0f, this.k, Looper.getMainLooper());
                interfaceC0368a.a();
                return;
            }
        }
        interfaceC0368a.b();
    }

    private static final boolean a(b bVar) {
        if (bVar != null) {
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() - bVar.a();
            com.opos.cmn.an.f.a.b("LocationManager", "internal :" + elapsedRealtimeNanos);
            if (elapsedRealtimeNanos <= 300000000000L) {
                return false;
            }
        }
        return true;
    }

    private double[] a(b bVar, double[] dArr) {
        double b2 = (int) (bVar.b() * 10000.0d);
        Double.isNaN(b2);
        dArr[0] = b2 / 10000.0d;
        double c2 = (int) (bVar.c() * 10000.0d);
        Double.isNaN(c2);
        dArr[1] = c2 / 10000.0d;
        return dArr;
    }

    private b b(Location location) {
        return new b(location.getLatitude(), location.getLongitude(), location.getElapsedRealtimeNanos());
    }

    public void b(a.InterfaceC0368a interfaceC0368a) {
        if (f() && this.f16389c != null) {
            b bVar = this.f16394h;
            com.opos.cmn.an.f.a.b("LocationManager", "gps:" + this.f16395i);
            if (a(bVar) && this.f16395i + 180000 < SystemClock.elapsedRealtime()) {
                d();
            }
            if (this.f16389c != null) {
                if (a(this.f16396j)) {
                    e();
                }
                interfaceC0368a.a();
                return;
            }
        }
        interfaceC0368a.b();
    }

    private void d() {
        com.opos.cmn.an.f.a.b("LocationManager", "locate gps");
        LocationManager g2 = g();
        if (g2 != null && h()) {
            this.f16395i = SystemClock.elapsedRealtime();
            g2.requestLocationUpdates("gps", 60000L, 1.0f, this.f16388b, Looper.getMainLooper());
            this.f16392f = new CountDownLatch(1);
            try {
                try {
                    this.f16392f.await(60000L, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("LocationManager", "await fail", e2);
                }
            } finally {
                com.opos.cmn.an.f.a.b("LocationManager", "remove locate gps");
                g2.removeUpdates(this.f16388b);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.location.LocationListener] */
    private void e() {
        String str = "remove locate net";
        com.opos.cmn.an.f.a.b("LocationManager", "locate net");
        LocationManager g2 = g();
        if (g2 != 0 && i()) {
            g2.requestLocationUpdates("network", 10000L, 1.0f, this.f16388b, Looper.getMainLooper());
            this.f16392f = new CountDownLatch(1);
            try {
                try {
                    this.f16392f.await(10000L, TimeUnit.MILLISECONDS);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("LocationManager", "await fail", e2);
                }
            } finally {
                com.opos.cmn.an.f.a.b("LocationManager", str);
                g2.removeUpdates(this.f16388b);
            }
        }
    }

    private boolean f() {
        return this.f16389c.checkCallingOrSelfPermission(g.f9322g) == 0 && this.f16389c.checkCallingOrSelfPermission(g.f9323h) == 0;
    }

    private LocationManager g() {
        Context context;
        if (this.f16393g == null && (context = this.f16389c) != null) {
            this.f16393g = (LocationManager) context.getSystemService("location");
        }
        return this.f16393g;
    }

    private boolean h() {
        boolean z;
        try {
            z = g().isProviderEnabled("gps");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e2);
            z = false;
        }
        com.opos.cmn.an.f.a.b("LocationManager", "isGpsProviderEnabled =" + z);
        return z;
    }

    private boolean i() {
        boolean z;
        try {
            z = g().isProviderEnabled("network");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e2);
            z = false;
        }
        com.opos.cmn.an.f.a.b("LocationManager", "isNetProviderEnabled =" + z);
        return z;
    }

    private boolean j() {
        boolean z;
        try {
            z = g().isProviderEnabled("passive");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e2);
            z = false;
        }
        com.opos.cmn.an.f.a.b("LocationManager", "isPassiveProviderEnabled =" + z);
        return z;
    }

    public void a(Context context) {
        if (context != null && this.f16389c == null) {
            synchronized (this) {
                if (this.f16389c == null) {
                    this.f16389c = context.getApplicationContext();
                }
            }
            this.f16391e.a();
        }
    }

    public void b() {
        com.opos.cmn.an.f.a.b("LocationManager", "destroy");
        if (this.f16389c == null) {
            return;
        }
        try {
            LocationManager g2 = f() ? g() : null;
            this.f16389c = null;
            CountDownLatch countDownLatch = this.f16392f;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (g2 != null) {
                g2.removeUpdates(this.k);
                g2.removeUpdates(this.f16388b);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e2);
        }
    }

    public double[] c() {
        com.opos.cmn.an.f.a.b("LocationManager", "obtainLocation");
        double[] dArr = {0.0d, 0.0d};
        if (this.f16389c == null) {
            return dArr;
        }
        b bVar = this.f16394h;
        b bVar2 = this.f16396j;
        if (a(bVar) || a(bVar2)) {
            this.f16390d.a();
        }
        if (a(bVar)) {
            if (a(bVar2) && (bVar == null || bVar2 == null || bVar2.a() <= bVar.a() + 300000000000L)) {
                if (bVar == null) {
                    if (bVar2 == null) {
                        return dArr;
                    }
                }
            }
            return a(bVar2, dArr);
        }
        return a(bVar, dArr);
    }
}
