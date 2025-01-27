package com.snassdk.sdk.wrapper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: classes4.dex */
public interface SystemConfig {
    @Keep
    ApplicationInfo getApplicationInfo(String str, int i10, ApplicationInfo applicationInfo);

    @Keep
    List<ApplicationInfo> getInstalledApplications(List<ApplicationInfo> list);

    @Keep
    List<PackageInfo> getInstalledPackages(List<PackageInfo> list);

    @Keep
    Intent getLaunchIntentForPackage(String str, Intent intent);

    @Keep
    PackageInfo getPackageInfo(String str, int i10, PackageInfo packageInfo);

    @Keep
    void onRegisterReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10, Intent intent);

    @Keep
    void onUnregisterReceiver(Context context, BroadcastReceiver broadcastReceiver);

    @Keep
    List<ResolveInfo> queryIntentActivities(List<ResolveInfo> list, Intent intent);

    @Keep
    boolean startActivities(Intent[] intentArr);

    @Keep
    boolean startActivities(Intent[] intentArr, Bundle bundle);

    @Keep
    boolean startActivity(Intent intent);

    @Keep
    boolean startActivity(Intent intent, Bundle bundle);
}
