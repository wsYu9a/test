package com.aggmoread.sdk.z.d.a.a.e.r;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.d.b.j;

/* loaded from: classes.dex */
public class i extends ContextThemeWrapper {

    /* renamed from: a */
    protected Context f6140a;

    /* renamed from: b */
    protected String[] f6141b;

    /* renamed from: c */
    protected String f6142c;

    /* renamed from: d */
    private boolean f6143d;

    /* renamed from: e */
    protected h f6144e;

    public i(Context context, String str, String str2) {
        this(context, str, new String[]{str2});
    }

    private Intent a(Intent intent) {
        try {
            if (this.f6142c.equals(intent.getPackage())) {
                intent.setPackage(b().getPackageName());
                com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "injectSendBroadcastIntent reset packageName name");
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return intent;
    }

    public Context b() {
        return this.f6140a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "ProxyContext#getApplicationContext enter, isEnable = " + this.f6143d + ",startActivityClassPrefix = " + this.f6141b);
        if (this.f6143d) {
            boolean a10 = g.a(this.f6141b);
            com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "fromClassPrefix = " + a10);
            if (a10) {
                if (this.f6144e == null) {
                    this.f6144e = new h(this);
                }
                return this.f6144e;
            }
        }
        return b().getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        if (!this.f6143d) {
            return b().getApplicationInfo();
        }
        ApplicationInfo applicationInfo = b().getApplicationInfo();
        String str = this.f6142c;
        applicationInfo.packageName = str;
        applicationInfo.processName = str;
        return applicationInfo;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getOpPackageName() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "ProxyContext#getOpPackageName enter, isEnable = " + this.f6143d + " , proxyPackageName = " + this.f6142c);
        return (this.f6143d && g.a(this.f6141b)) ? this.f6142c : b().getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "ProxyContext#getPackageName enter, isEnable = " + this.f6143d + " , proxyPackageName = " + this.f6142c);
        return (this.f6143d && g.a(this.f6141b)) ? this.f6142c : b().getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        b().registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        b().sendBroadcast(a(intent));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, @Nullable String str) {
        b().sendBroadcast(a(intent), str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "startActivity context = " + b());
        j.f6027q.startActivity(b(intent));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        b(intent);
        return b().startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        b().unregisterComponentCallbacks(componentCallbacks);
    }

    public i(Context context, String str, String[] strArr) {
        super(context, 0);
        this.f6143d = true;
        this.f6140a = context;
        this.f6142c = str;
        this.f6141b = strArr;
    }

    private Intent b(Intent intent) {
        try {
            ComponentName component = intent.getComponent();
            com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "injectStartActivityIntent enter , " + component + " , packageName = " + intent.getPackage() + " , action = " + intent.getAction());
            if (component != null) {
                String className = component.getClassName();
                String packageName = component.getPackageName();
                String packageName2 = j.f6027q.getPackageName();
                boolean startsWith = className != null ? className.startsWith(packageName2) : false;
                com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "injectStartActivityIntent isStartCurrentPackageActivity = " + startsWith);
                String[] strArr = this.f6141b;
                if (strArr != null) {
                    for (String str : strArr) {
                        if ((this.f6142c.equals(packageName) && className != null && className.startsWith(str)) || startsWith) {
                            intent.setClassName(packageName2, className);
                            intent.setPackage(packageName2);
                            com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "injectStartActivityIntent reset packageName name");
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return intent;
    }

    public void a() {
        this.f6143d = true;
        com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "enable enter , packageName = " + this.f6142c);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, @Nullable String str) {
        b().sendBroadcast(a(intent), str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(@NonNull Intent intent, @Nullable String str, @Nullable BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i10, @Nullable String str2, @Nullable Bundle bundle) {
        b().sendOrderedBroadcast(a(intent), str, broadcastReceiver, handler, i10, str2, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, @Nullable Bundle bundle) {
        j.f6027q.startActivity(b(intent), bundle);
    }
}
