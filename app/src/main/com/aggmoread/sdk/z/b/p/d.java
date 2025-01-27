package com.aggmoread.sdk.z.b.p;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private final Context f4783a;

    /* renamed from: b */
    private c f4784b;

    /* renamed from: c */
    boolean f4785c;

    /* renamed from: d */
    private boolean f4786d;

    /* renamed from: e */
    private final BroadcastReceiver f4787e = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            d dVar = d.this;
            boolean z10 = dVar.f4785c;
            dVar.f4785c = dVar.a(context);
            if (z10 != d.this.f4785c) {
                com.aggmoread.sdk.z.b.d.a("ConnectivityListener", "connectivity changed, isConnected: " + d.this.f4785c);
                d.this.f4784b.a(d.this.f4785c);
            }
        }
    }

    public d(@NonNull Context context, @NonNull c cVar) {
        this.f4783a = context.getApplicationContext();
        this.f4784b = cVar == null ? c.f4782a : cVar;
    }

    private void d() {
        if (this.f4786d) {
            this.f4783a.unregisterReceiver(this.f4787e);
            this.f4786d = false;
        }
    }

    public void b() {
        a();
    }

    public void c() {
        d();
    }

    public static d a(Context context, c cVar) {
        d dVar = new d(context, cVar);
        dVar.b();
        return dVar;
    }

    private void a() {
        if (this.f4786d) {
            return;
        }
        this.f4785c = a(this.f4783a);
        try {
            this.f4783a.registerReceiver(this.f4787e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4786d = true;
        } catch (SecurityException e10) {
            com.aggmoread.sdk.z.b.d.a("ConnectivityListener", "Failed to register", e10);
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e10) {
            com.aggmoread.sdk.z.b.d.a("ConnectivityListener", "Failed to determine connectivity status when connectivity changed ", e10);
            return true;
        }
    }
}
