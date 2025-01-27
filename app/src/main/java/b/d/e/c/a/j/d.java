package b.d.e.c.a.j;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a */
    private final Context f4660a;

    /* renamed from: b */
    private c f4661b;

    /* renamed from: c */
    boolean f4662c;

    /* renamed from: d */
    private boolean f4663d;

    /* renamed from: e */
    private final BroadcastReceiver f4664e = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            d dVar = d.this;
            boolean z = dVar.f4662c;
            dVar.f4662c = dVar.d(context);
            if (z != d.this.f4662c) {
                b.d.e.c.a.d.d("ConnectivityListener", "connectivity changed, isConnected: " + d.this.f4662c);
                d.this.f4661b.a(d.this.f4662c);
            }
        }
    }

    public d(@NonNull Context context, @NonNull c cVar) {
        this.f4660a = context.getApplicationContext();
        this.f4661b = cVar == null ? c.E0 : cVar;
    }

    public static d b(Context context, c cVar) {
        d dVar = new d(context, cVar);
        dVar.e();
        return dVar;
    }

    private void c() {
        if (this.f4663d) {
            return;
        }
        this.f4662c = d(this.f4660a);
        try {
            this.f4660a.registerReceiver(this.f4664e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4663d = true;
        } catch (SecurityException e2) {
            b.d.e.c.a.d.e("ConnectivityListener", "Failed to register", e2);
        }
    }

    private void g() {
        if (this.f4663d) {
            this.f4660a.unregisterReceiver(this.f4664e);
            this.f4663d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean d(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            b.d.e.c.a.d.e("ConnectivityListener", "Failed to determine connectivity status when connectivity changed ", e2);
            return true;
        }
    }

    public void e() {
        c();
    }

    public void f() {
        g();
    }
}
