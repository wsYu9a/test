package vi;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes4.dex */
public class d implements e {

    /* renamed from: a */
    public static String f31549a = "market://details?id=";

    @Override // vi.e
    public Uri a(Context context) {
        return Uri.parse(f31549a + context.getPackageName().toString());
    }
}
