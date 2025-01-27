package cg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import com.snassdk.sdk.wrapper.SystemConfig;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public SystemConfig f2010a = null;

    /* renamed from: cg.a$a */
    public static class C0019a {

        /* renamed from: a */
        public static final a f2011a = new a();
    }

    public static a a() {
        return C0019a.f2011a;
    }

    public ApplicationInfo b(String str, int i10, ApplicationInfo applicationInfo) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.getApplicationInfo(str, i10, applicationInfo);
        }
        return null;
    }

    public final SystemConfig c() {
        return this.f2010a;
    }

    public List<ApplicationInfo> d(List<ApplicationInfo> list) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.getInstalledApplications(list);
        }
        return null;
    }

    public List<PackageInfo> e(List<PackageInfo> list) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.getInstalledPackages(list);
        }
        return null;
    }

    public Intent f(String str, Intent intent) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.getLaunchIntentForPackage(str, intent);
        }
        return null;
    }

    public PackageInfo g(String str, int i10, PackageInfo packageInfo) {
        try {
            SystemConfig c10 = c();
            if (c10 != null) {
                return c10.getPackageInfo(str, i10, packageInfo);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void h(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10, Intent intent) {
        SystemConfig c10 = c();
        if (c10 != null) {
            c10.onRegisterReceiver(context, broadcastReceiver, intentFilter, str, handler, i10, intent);
        }
    }

    public void i(Context context, BroadcastReceiver broadcastReceiver) {
        SystemConfig c10 = c();
        if (c10 != null) {
            c10.onUnregisterReceiver(context, broadcastReceiver);
        }
    }

    public List<ResolveInfo> j(List<ResolveInfo> list, Intent intent) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.queryIntentActivities(list, intent);
        }
        return null;
    }

    public void k(SystemConfig systemConfig) {
        this.f2010a = systemConfig;
    }

    public boolean l(Intent[] intentArr) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.startActivities(intentArr);
        }
        return false;
    }

    public boolean m(Intent[] intentArr, Bundle bundle) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.startActivities(intentArr, bundle);
        }
        return false;
    }

    public boolean startActivity(Intent intent) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.startActivity(intent);
        }
        return false;
    }

    public boolean startActivity(Intent intent, Bundle bundle) {
        SystemConfig c10 = c();
        if (c10 != null) {
            return c10.startActivity(intent, bundle);
        }
        return false;
    }
}
