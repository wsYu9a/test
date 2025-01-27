package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.shu.priory.config.AdKeys;
import com.umeng.analytics.pro.b;
import com.umeng.analytics.pro.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
class bi implements be {

    /* renamed from: a */
    private static String f23560a = "";

    public static final class a implements ServiceConnection {

        /* renamed from: a */
        boolean f23561a;

        /* renamed from: b */
        private final LinkedBlockingQueue<IBinder> f23562b;

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public IBinder a() throws InterruptedException {
            if (this.f23561a) {
                throw new IllegalStateException();
            }
            this.f23561a = true;
            return this.f23562b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f23562b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
            this.f23561a = false;
            this.f23562b = new LinkedBlockingQueue<>();
        }
    }

    public static final class b extends b.AbstractBinderC0666b {
        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i10, long j10, boolean z10, float f10, double d10, String str) throws RemoteException {
        }

        private b() {
        }

        @Override // com.umeng.analytics.pro.b
        public void a(int i10, Bundle bundle) throws RemoteException {
            if (i10 != 0 || bundle == null) {
                return;
            }
            String string = bundle.getString("oa_id_flag");
            if (bi.c(string)) {
                String unused = bi.f23560a = string;
            }
        }
    }

    public interface c {

        /* renamed from: a */
        public static final int f23563a = 0;

        /* renamed from: b */
        public static final String f23564b = "oa_id_flag";
    }

    public static boolean c(String str) {
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("00000000-0000-0000-0000-000000000000")) ? false : true;
    }

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!Boolean.parseBoolean(Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state"))) {
                String string = Settings.Global.getString(context.getContentResolver(), AdKeys.OAID);
                if (c(string)) {
                    f23560a = string;
                    return string;
                }
            }
        } catch (Throwable unused) {
        }
        a aVar = new a();
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        if (context.bindService(intent, aVar, 1)) {
            try {
                c.b.a(aVar.a()).a(new b());
                return f23560a;
            } catch (Exception unused2) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
