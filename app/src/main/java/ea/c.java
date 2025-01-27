package ea;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.PermissionChecker;
import ba.m;
import com.kuaishou.weapon.p0.g;
import com.martian.libmars.activity.PermissionActivity;
import com.martian.libsupport.permission.TipInfo;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public static final String f25794a = "/libraries/libmars/PermissionActivity";

    /* renamed from: b */
    public static final String f25795b = "PermissionGrantor";

    /* renamed from: c */
    public static final HashMap<String, b> f25796c = new HashMap<>();

    public class a implements b {

        /* renamed from: a */
        public final /* synthetic */ b f25797a;

        /* renamed from: b */
        public final /* synthetic */ Context f25798b;

        public a(b bVar, Context context) {
            this.f25797a = bVar;
            this.f25798b = context;
        }

        @Override // ea.b
        public void permissionDenied() {
            this.f25797a.permissionDenied();
            Toast.makeText(this.f25798b, "缺少存储权限", 0).show();
        }

        @Override // ea.b
        public void permissionGranted() {
            this.f25797a.permissionGranted();
        }
    }

    public static b a(String str) {
        return f25796c.remove(str);
    }

    public static ea.a b(String str) {
        str.hashCode();
        switch (str) {
            case "android.permission.ACCESS_FINE_LOCATION":
            case "android.permission.ACCESS_COARSE_LOCATION":
                return new ea.a(g.f11106g, "· 位置信息权限", "精准内容推送");
            case "android.permission.READ_EXTERNAL_STORAGE":
            case "android.permission.WRITE_EXTERNAL_STORAGE":
                return new ea.a("android.permission.WRITE_EXTERNAL_STORAGE", "· 存储权限", "缓存内容信息，降低流量消耗");
            case "android.permission.READ_PHONE_STATE":
                return new ea.a(g.f11102c, "· 手机IMEI权限", "检验IMEI码，保证账号安全，防止账号被盗");
            default:
                return null;
        }
    }

    public static void c(@NonNull Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        context.startActivity(intent);
    }

    public static boolean d(@NonNull Context context, @NonNull String... strArr) {
        if (strArr.length == 0) {
            return false;
        }
        for (String str : strArr) {
            if (PermissionChecker.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean e(Context context) {
        return d(context, g.f11108i);
    }

    public static boolean f(Context context) {
        return d(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean g(@NonNull int... iArr) {
        if (iArr.length == 0) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(@NonNull Activity activity, boolean z10) {
        return m.y() && m.N(activity) && z10;
    }

    public static void i(@NonNull Activity activity, boolean z10, @NonNull b bVar) {
        boolean isExternalStorageManager;
        if (h(activity, z10) && m.y()) {
            isExternalStorageManager = Environment.isExternalStorageManager();
            if (!isExternalStorageManager) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                f25796c.put(valueOf, bVar);
                n1.a.j().d("/libraries/libmars/PermissionActivity").withInt(PermissionActivity.f12050t, 210).withSerializable(PermissionActivity.f12049s, new TipInfo("权限申请", "需要所有文件访问权限才能使用此功能。", "取消", "前往开启")).withString(PermissionActivity.f12046p, valueOf).addFlags(268435456).navigation();
                return;
            }
        }
        bVar.permissionGranted();
    }

    public static void j(@NonNull Activity activity, @NonNull b bVar) {
        boolean canRequestPackageInstalls;
        if (m.u()) {
            canRequestPackageInstalls = activity.getPackageManager().canRequestPackageInstalls();
            if (!canRequestPackageInstalls) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                f25796c.put(valueOf, bVar);
                n1.a.j().d("/libraries/libmars/PermissionActivity").withInt(PermissionActivity.f12050t, 205).withSerializable(PermissionActivity.f12049s, new TipInfo("权限申请", "需要安装权限才能完成安装。", "取消", "前往开启")).withString(PermissionActivity.f12046p, valueOf).addFlags(268435456).navigation();
                return;
            }
        }
        bVar.permissionGranted();
    }

    public static void k(@NonNull Context context, @NonNull b bVar, @NonNull String[] strArr, boolean z10, @Nullable TipInfo tipInfo, boolean z11) {
        if (d(context, strArr)) {
            bVar.permissionGranted();
        } else {
            if (!m.n()) {
                bVar.permissionDenied();
                return;
            }
            String valueOf = String.valueOf(System.currentTimeMillis());
            f25796c.put(valueOf, bVar);
            n1.a.j().d("/libraries/libmars/PermissionActivity").withCharSequenceArray("permission", strArr).withBoolean(PermissionActivity.f12047q, z10).withSerializable(PermissionActivity.f12049s, tipInfo).withString(PermissionActivity.f12046p, valueOf).withBoolean(PermissionActivity.f12048r, z11).addFlags(268435456).navigation();
        }
    }

    public static void l(Activity activity, String str, boolean z10, b bVar) {
        if (h(activity, z10)) {
            i(activity, z10, bVar);
        } else {
            m(activity, str, bVar);
        }
    }

    public static void m(Context context, String str, @NonNull b bVar) {
        k(context, new a(bVar, context), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, true, new TipInfo("权限申请", "需要存储权限才能正常使用" + str + "功能", "取消", "前往开启"), true);
    }
}
