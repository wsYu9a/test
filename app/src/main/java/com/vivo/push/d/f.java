package com.vivo.push.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes4.dex */
final class f extends com.vivo.push.l {
    f(com.vivo.push.o oVar) {
        super(oVar);
    }

    public static boolean a(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            com.vivo.push.util.p.a("OnChangePushStatusTask", "enableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 1) {
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has enabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 1, 1);
        com.vivo.push.util.p.d("OnChangePushStatusTask", "enableService push service.");
        return true;
    }

    public static boolean b(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            com.vivo.push.util.p.a("OnChangePushStatusTask", "disableService error: can not find push service.");
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
        if (packageManager.getComponentEnabledSetting(componentName) == 2) {
            com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has disabled");
            return false;
        }
        packageManager.setComponentEnabledSetting(componentName, 2, 1);
        com.vivo.push.util.p.d("OnChangePushStatusTask", "disableService push service.");
        return true;
    }

    private static List<ResolveInfo> c(Context context) {
        List<ResolveInfo> list;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        if (list != null && list.size() > 0) {
            return list;
        }
        Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
        intent2.setPackage(context.getPackageName());
        try {
            return context.getPackageManager().queryBroadcastReceivers(intent2, 576);
        } catch (Exception unused2) {
            return list;
        }
    }

    @Override // com.vivo.push.l
    protected final void a(com.vivo.push.o oVar) {
        if (this.f31028a.getPackageName().equals(com.vivo.push.util.t.b(this.f31028a))) {
            return;
        }
        com.vivo.push.b.j jVar = (com.vivo.push.b.j) oVar;
        int d2 = jVar.d();
        int e2 = jVar.e();
        com.vivo.push.util.p.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + d2 + " ; receiverStatus is " + e2);
        if (d2 == 2) {
            b(this.f31028a);
        } else if (d2 == 1) {
            a(this.f31028a);
        } else if (d2 == 0) {
            Context context = this.f31028a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 0, 1);
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has defaulted");
                }
            } else {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            }
        }
        if (e2 == 2) {
            Context context2 = this.f31028a;
            List<ResolveInfo> c2 = c(context2);
            if (c2 != null && c2.size() > 0) {
                String str = c2.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                } else {
                    PackageManager packageManager2 = context2.getPackageManager();
                    ComponentName componentName2 = new ComponentName(context2, str);
                    if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                        packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                        com.vivo.push.util.p.d("OnChangePushStatusTask", "push service disableReceiver ");
                    } else {
                        com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has disableReceiver ");
                    }
                }
            } else {
                com.vivo.push.util.p.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            }
            com.vivo.push.sdk.a.a().b();
            return;
        }
        if (e2 == 1) {
            Context context3 = this.f31028a;
            List<ResolveInfo> c3 = c(context3);
            if (c3 != null && c3.size() > 0) {
                String str2 = c3.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, str2);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 1) {
                    packageManager3.setComponentEnabledSetting(componentName3, 1, 1);
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "push service enableReceiver ");
                    return;
                } else {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has enableReceiver ");
                    return;
                }
            }
            com.vivo.push.util.p.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
            return;
        }
        if (e2 == 0) {
            Context context4 = this.f31028a;
            List<ResolveInfo> c4 = c(context4);
            if (c4 != null && c4.size() > 0) {
                String str3 = c4.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager4 = context4.getPackageManager();
                ComponentName componentName4 = new ComponentName(context4, str3);
                if (packageManager4.getComponentEnabledSetting(componentName4) != 0) {
                    packageManager4.setComponentEnabledSetting(componentName4, 0, 1);
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "push service defaultReceiver ");
                    return;
                } else {
                    com.vivo.push.util.p.d("OnChangePushStatusTask", "push service has defaulted");
                    return;
                }
            }
            com.vivo.push.util.p.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        }
    }
}
