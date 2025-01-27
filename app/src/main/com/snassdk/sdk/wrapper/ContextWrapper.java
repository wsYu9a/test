package com.snassdk.sdk.wrapper;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.app.backup.BackupAgent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import cg.a;
import cg.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
class ContextWrapper extends android.content.ContextWrapper {

    /* renamed from: a */
    public static Set<String> f20911a = null;

    /* renamed from: b */
    public static final int f20912b = 3;

    static {
        HashSet hashSet = new HashSet();
        f20911a = hashSet;
        hashSet.add(WebView.class.getName());
        f20911a.add("com.android.webview.chromium.WebViewChromium");
        f20911a.add("com.sensorsdata.analytics.android.sdk");
        try {
            f20911a.add("com.kwad.sdk.api.loader.Wrapper");
        } catch (Throwable unused) {
        }
    }

    public ContextWrapper(Context context) {
        super(context);
    }

    public static Context a(Context context) {
        if (!(context instanceof android.content.ContextWrapper)) {
            return context;
        }
        try {
            Field declaredField = android.content.ContextWrapper.class.getDeclaredField("mBase");
            declaredField.setAccessible(true);
            return (Context) declaredField.get(context);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    public static boolean d(Context context) {
        if (context instanceof ContextWrapper) {
            return true;
        }
        if (context instanceof android.content.ContextWrapper) {
            return d(a(context));
        }
        return false;
    }

    public static boolean e(Context context) {
        if ((context instanceof ContextWrapper) || (context instanceof Application) || (context instanceof Activity) || (context instanceof Service) || (context instanceof BackupAgent)) {
            return true;
        }
        return d(context);
    }

    public static boolean f(Exception exc) {
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace != null && stackTrace.length >= 3) {
            ArrayList arrayList = new ArrayList();
            for (StackTraceElement stackTraceElement : stackTrace) {
                arrayList.add(stackTraceElement.getClassName() + stackTraceElement.getMethodName() + stackTraceElement.getLineNumber());
            }
            for (int i10 = 2; i10 < arrayList.size(); i10++) {
                String str = (String) arrayList.get(i10);
                String str2 = (String) arrayList.get(i10 - 1);
                String str3 = (String) arrayList.get(i10 - 2);
                if (str != null && str.equals(str2) && str.equals(str3)) {
                    return true;
                }
                if (str == null && str2 == null && str3 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean g() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (f20911a.contains(stackTraceElement.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Context b() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, int i10, Executor executor, ServiceConnection serviceConnection) {
        return super.bindService(intent, i10, executor, serviceConnection);
    }

    public final Context c() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context applicationContext = super.getApplicationContext();
        return e(applicationContext) ? applicationContext : new ContextWrapper(applicationContext);
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return a(this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        PackageManager packageManager = super.getPackageManager();
        c.e(packageManager);
        return packageManager;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        b().registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Intent registerReceiver = super.registerReceiver(broadcastReceiver, intentFilter);
        a.a().h(c(), broadcastReceiver, intentFilter, null, null, 0, registerReceiver);
        return registerReceiver;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        if (a.a().l(intentArr)) {
            return;
        }
        super.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        if (a.a().startActivity(intent)) {
            return;
        }
        super.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return super.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        return super.stopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        super.unbindService(serviceConnection);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        b().unregisterComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        a.a().i(c(), broadcastReceiver);
        super.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i10) {
        return super.bindService(intent, serviceConnection, i10);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i10) {
        Intent registerReceiver = super.registerReceiver(broadcastReceiver, intentFilter, i10);
        a.a().h(c(), broadcastReceiver, intentFilter, null, null, i10, registerReceiver);
        return registerReceiver;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        if (a.a().m(intentArr, bundle)) {
            return;
        }
        super.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        if (a.a().startActivity(intent, bundle)) {
            return;
        }
        super.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        Intent registerReceiver = super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        a.a().h(c(), broadcastReceiver, intentFilter, str, handler, 0, registerReceiver);
        return registerReceiver;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
        Intent registerReceiver = super.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10);
        a.a().h(c(), broadcastReceiver, intentFilter, str, handler, i10, registerReceiver);
        return registerReceiver;
    }
}
