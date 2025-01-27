package b.h.a;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes4.dex */
public final class i extends b.h.a.h.b {

    /* renamed from: c */
    private final b.h.a.a.b f4999c;

    public i(b.h.a.a.b bVar) {
        this.f4999c = bVar;
    }

    @Override // b.h.a.h.b
    public final void h(String str, String str2, boolean z, byte b2) {
        b.h.a.a.b bVar;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (f() != -1 && b2 >= f() && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (bVar = this.f4999c) != null) {
            bVar.a(str, str2, b2, k());
        }
        if (!z || i() == -1 || b2 < i()) {
            return;
        }
        if (b2 == 1) {
            Log.v(str, str2);
            return;
        }
        if (b2 == 2) {
            Log.d(str, str2);
            return;
        }
        if (b2 == 3) {
            Log.i(str, str2);
        } else if (b2 == 4) {
            Log.w(str, str2);
        } else {
            if (b2 != 5) {
                return;
            }
            Log.e(str, str2);
        }
    }
}
