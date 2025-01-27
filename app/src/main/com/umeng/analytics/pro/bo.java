package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.d;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class bo implements be {

    public static final class a implements ServiceConnection {

        /* renamed from: a */
        boolean f23577a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f23578b;

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public IBinder a() throws InterruptedException {
            if (this.f23577a) {
                throw new IllegalStateException();
            }
            this.f23577a = true;
            return this.f23578b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f23578b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f23577a = false;
            this.f23578b = new LinkedBlockingQueue<>();
        }
    }

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return d.b.a(aVar.a()).a();
            } catch (Exception unused) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
