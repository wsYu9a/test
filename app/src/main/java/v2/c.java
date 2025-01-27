package v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import b3.a;
import com.baidu.mobads.sdk.internal.bz;
import java.util.Collections;
import org.json.JSONObject;
import p3.k;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    public static final int f31219a = 1010;

    /* renamed from: b */
    public static a f31220b;

    public interface a {
        void a(boolean z10, JSONObject jSONObject, String str);
    }

    public static boolean a(n3.a aVar, int i10, int i11, Intent intent) {
        if (i10 != 1010 || intent == null) {
            return false;
        }
        a aVar2 = f31220b;
        if (aVar2 == null) {
            return true;
        }
        f31220b = null;
        if (i11 == -1) {
            x2.a.d(aVar, x2.b.f31789l, x2.b.f31814x0, intent.toUri(1));
            aVar2.a(true, k.q(intent), bz.f6993k);
        } else if (i11 != 0) {
            x2.a.i(aVar, x2.b.f31789l, x2.b.f31812w0, "" + i11);
        } else {
            x2.a.d(aVar, x2.b.f31789l, x2.b.f31810v0, intent.toUri(1));
            aVar2.a(false, null, "CANCELED");
        }
        return true;
    }

    public static boolean b(n3.a aVar, Activity activity, int i10, String str, String str2, a aVar2) {
        try {
            x2.a.c(aVar, x2.b.f31789l, x2.b.f31808u0);
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i10);
            f31220b = aVar2;
            return true;
        } catch (Throwable th2) {
            aVar2.a(false, null, "UNKNOWN_ERROR");
            x2.a.e(aVar, x2.b.f31789l, x2.b.f31816y0, th2);
            return false;
        }
    }

    public static boolean c(n3.a aVar, Context context) {
        return k.y(aVar, context, Collections.singletonList(new a.b("com.taobao.taobao", 0, "")), false);
    }
}
