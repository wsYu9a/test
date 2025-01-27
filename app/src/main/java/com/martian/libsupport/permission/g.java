package com.martian.libsupport.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;
import com.martian.libsupport.l;
import java.util.HashMap;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    public static final String f10646a = "PermissionGrantor";

    /* renamed from: b */
    private static final HashMap<String, f> f10647b = new HashMap<>();

    static f a(String key) {
        return f10647b.remove(key);
    }

    public static e b(String tag) {
        tag.hashCode();
        switch (tag) {
            case "android.permission.ACCESS_FINE_LOCATION":
            case "android.permission.ACCESS_COARSE_LOCATION":
                return new e(com.kuaishou.weapon.p0.g.f9322g, "· 位置信息权限", "精准内容推送");
            case "android.permission.READ_EXTERNAL_STORAGE":
            case "android.permission.WRITE_EXTERNAL_STORAGE":
                return new e(com.kuaishou.weapon.p0.g.f9325j, "· 存储权限", "缓存内容信息，降低流量消耗");
            case "android.permission.READ_PHONE_STATE":
                return new e(com.kuaishou.weapon.p0.g.f9318c, "· 手机IMEI权限", "检验IMEI码，保证账号安全，防止账号被盗");
            default:
                return null;
        }
    }

    public static void c(@NonNull Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    public static boolean d(@NonNull Context context, @NonNull String... permissions) {
        if (permissions.length == 0) {
            return false;
        }
        for (String str : permissions) {
            if (PermissionChecker.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(@NonNull int... grantResult) {
        if (grantResult.length == 0) {
            return false;
        }
        for (int i2 : grantResult) {
            if (i2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(@NonNull final Activity activity, @NonNull f listener) {
        if (!l.A() || activity.getPackageManager().canRequestPackageInstalls()) {
            return true;
        }
        f10647b.put(String.valueOf(System.currentTimeMillis()), listener);
        PermissionActivity.u0(activity, 205, new TipInfo("权限申请", "需要安装权限才能完成安装 \n \n 请点击 \"前往开启\"-打开所需权限。", "取消", "前往开启"));
        return false;
    }

    public static void g(Context context, f listener, String[] permission) {
        h(context, listener, permission, true, null, false);
    }

    public static void h(@NonNull Context context, @NonNull f listener, @NonNull String[] permission, boolean showTip, @Nullable TipInfo tip, boolean cancelable) {
        if (d(context, permission)) {
            listener.permissionGranted();
        } else {
            if (!l.t()) {
                listener.permissionDenied();
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            f10647b.put(valueOf, listener);
            PermissionActivity.v0(context, permission, showTip, tip, valueOf, cancelable);
        }
    }
}
