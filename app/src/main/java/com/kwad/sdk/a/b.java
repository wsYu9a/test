package com.kwad.sdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class b {
    private static final Map<String, String> aaV = new HashMap();
    private final AtomicBoolean aaW;
    private final AtomicBoolean aaX;
    private final BroadcastReceiver aaY;
    private final List<com.kwad.sdk.a.a> mListeners;

    /* renamed from: com.kwad.sdk.a.b$1 */
    final class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Uri data;
            if (intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                    return;
                }
                String schemeSpecificPart = data.getSchemeSpecificPart();
                if (TextUtils.isEmpty(schemeSpecificPart)) {
                    return;
                }
                if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                    b.this.t(context, schemeSpecificPart);
                } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                    b.this.bj(schemeSpecificPart);
                }
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    static class a {
        private static final b aba = new b((byte) 0);
    }

    private b() {
        this.aaW = new AtomicBoolean();
        this.aaX = new AtomicBoolean();
        this.mListeners = new CopyOnWriteArrayList();
        this.aaY = new BroadcastReceiver() { // from class: com.kwad.sdk.a.b.1
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Uri data;
                if (intent == null) {
                    return;
                }
                try {
                    String action = intent.getAction();
                    if (TextUtils.isEmpty(action) || (data = intent.getData()) == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    if (TextUtils.isEmpty(schemeSpecificPart)) {
                        return;
                    }
                    if (TextUtils.equals("android.intent.action.PACKAGE_ADDED", action)) {
                        b.this.t(context, schemeSpecificPart);
                    } else if (TextUtils.equals("android.intent.action.PACKAGE_REMOVED", action)) {
                        b.this.bj(schemeSpecificPart);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
        };
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    private synchronized void av(Context context) {
        if (this.aaW.get()) {
            return;
        }
        v(context, "com.smile.gifmaker");
        v(context, "com.kuaishou.nebula");
        v(context, "com.tencent.mm");
        this.aaW.set(true);
    }

    public void bj(@NonNull String str) {
        com.kwad.sdk.core.d.b.d("AppInstallManager", "unInstallApp packageName: " + str);
        bn(str);
        bk(str);
        bm(str);
    }

    private static void bk(@NonNull String str) {
        try {
            InstalledAppInfoManager.AppPackageInfo appPackageInfo = new InstalledAppInfoManager.AppPackageInfo();
            appPackageInfo.packageName = str;
            ((com.kwad.sdk.service.kwai.b) ServiceProvider.get(com.kwad.sdk.service.kwai.b.class)).e(InstalledAppInfoManager.a(appPackageInfo), 2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    private void bl(String str) {
        Iterator<com.kwad.sdk.a.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().X(str);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    private void bm(String str) {
        Iterator<com.kwad.sdk.a.a> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private static void bn(String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                aaV.put("com.tencent.mm", "");
                break;
            case "com.kuaishou.nebula":
                aaV.put("com.kuaishou.nebula", "");
                break;
            case "com.smile.gifmaker":
                aaV.put("com.smile.gifmaker", "");
                break;
        }
    }

    public void t(Context context, @NonNull String str) {
        com.kwad.sdk.core.d.b.d("AppInstallManager", "installApp packageName: " + str);
        v(context, str);
        u(context, str);
        bl(str);
    }

    public static b tA() {
        return a.aba;
    }

    private static void u(Context context, @NonNull String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                ((com.kwad.sdk.service.kwai.b) ServiceProvider.get(com.kwad.sdk.service.kwai.b.class)).e(InstalledAppInfoManager.a(InstalledAppInfoManager.a(packageInfo, packageManager)), 1);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    private static void v(Context context, String str) {
        str.hashCode();
        switch (str) {
            case "com.tencent.mm":
                aaV.put("com.tencent.mm", k.F(context, "com.tencent.mm"));
                break;
            case "com.kuaishou.nebula":
                aaV.put("com.kuaishou.nebula", k.F(context, "com.kuaishou.nebula"));
                break;
            case "com.smile.gifmaker":
                aaV.put("com.smile.gifmaker", k.F(context, "com.smile.gifmaker"));
                break;
        }
    }

    public final void a(com.kwad.sdk.a.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.add(aVar);
    }

    public final void b(com.kwad.sdk.a.a aVar) {
        if (aVar == null) {
            return;
        }
        checkInit();
        this.mListeners.remove(aVar);
    }

    public final synchronized void checkInit() {
        try {
            if (this.aaX.get()) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            ServiceProvider.CA().registerReceiver(this.aaY, intentFilter);
            this.aaX.set(true);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public final String getVersion(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        av(context);
        return aaV.get(str);
    }
}
