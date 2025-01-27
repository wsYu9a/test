package y6;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class b extends c {
    @Override // y6.d
    public final b7.d a(Context context, int i10, Intent intent) {
        if (4105 == i10) {
            return b(intent);
        }
        return null;
    }

    @Override // y6.c
    public final b7.d b(Intent intent) {
        try {
            b7.b bVar = new b7.b();
            bVar.u(Integer.parseInt(c7.a.a(intent.getStringExtra(b7.b.X))));
            bVar.y(Integer.parseInt(c7.a.a(intent.getStringExtra("code"))));
            bVar.v(c7.a.a(intent.getStringExtra("content")));
            bVar.s(c7.a.a(intent.getStringExtra(b7.b.Y)));
            bVar.t(c7.a.a(intent.getStringExtra(b7.b.Z)));
            bVar.d(c7.a.a(intent.getStringExtra("appPackage")));
            c7.e.a("OnHandleIntent-message:" + bVar.toString());
            return bVar;
        } catch (Exception e10) {
            c7.e.a("OnHandleIntent--" + e10.getMessage());
            return null;
        }
    }
}
