package l9;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.martian.libmars.common.ConfigSingleton;
import java.io.File;
import l9.i0;
import l9.k0;

/* loaded from: classes3.dex */
public class k0 {

    public interface a {
        void a(String str, String str2);
    }

    public static void c(Activity activity, String str, String str2, a aVar) {
        i0.z0(activity, "文件下载", "是否下载 \"" + str2 + "\"？" + (!ConfigSingleton.D().N0() ? "\n(wifi未连接, 将使用流量下载)" : ""), new i0.l() { // from class: l9.j0

            /* renamed from: a */
            public final /* synthetic */ Activity f28008a;

            /* renamed from: b */
            public final /* synthetic */ String f28009b;

            /* renamed from: c */
            public final /* synthetic */ String f28010c;

            /* renamed from: d */
            public final /* synthetic */ k0.a f28011d;

            public /* synthetic */ j0(Activity activity2, String str3, String str22, k0.a aVar2) {
                activity = activity2;
                str = str3;
                str2 = str22;
                aVar = aVar2;
            }

            @Override // l9.i0.l
            public final void a() {
                k0.e(activity, str, str2, aVar);
            }
        });
    }

    public static void d(Activity activity, String str, String str2, String str3, a aVar, boolean z10) {
        f(activity, str, URLUtil.guessFileName(str, str2, str3), aVar, z10);
    }

    public static void e(Activity activity, String str, String str2, a aVar) {
        File i10;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (i10 = ba.b.i()) == null) {
            return;
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(new File(i10, str2)));
            ((DownloadManager) activity.getSystemService("download")).enqueue(request);
        } catch (Exception unused) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(268435456);
            activity.startActivity(intent);
        }
        if (aVar != null) {
            aVar.a(str2, str);
        }
    }

    public static void f(Activity activity, String str, String str2, a aVar, boolean z10) {
        if (z10 || !ConfigSingleton.D().N0()) {
            c(activity, str, str2, aVar);
        } else {
            e(activity, str, str2, aVar);
        }
    }
}
