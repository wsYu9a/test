package vi;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes4.dex */
public class a implements e {

    /* renamed from: a */
    public static String f31538a = "http://www.amazon.com/gp/mas/dl/android?p=";

    @Override // vi.e
    public Uri a(Context context) {
        return Uri.parse(f31538a + context.getPackageName().toString());
    }
}
