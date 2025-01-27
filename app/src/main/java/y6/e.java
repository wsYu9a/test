package y6;

import android.content.Context;
import android.content.Intent;
import b7.h;

/* loaded from: classes2.dex */
public final class e extends c {
    @Override // y6.d
    public final b7.d a(Context context, int i10, Intent intent) {
        if (4103 != i10) {
            return null;
        }
        b7.d b10 = b(intent);
        x6.b.w0(context, (h) b10, x6.b.f31839j);
        return b10;
    }

    @Override // y6.c
    public final b7.d b(Intent intent) {
        try {
            h hVar = new h();
            hVar.e(Integer.parseInt(c7.a.a(intent.getStringExtra("messageID"))));
            hVar.g(c7.a.a(intent.getStringExtra("taskID")));
            hVar.d(c7.a.a(intent.getStringExtra("appPackage")));
            hVar.m(c7.a.a(intent.getStringExtra("content")));
            hVar.n(c7.a.a(intent.getStringExtra("description")));
            hVar.l(c7.a.a(intent.getStringExtra(b7.d.F)));
            hVar.o(c7.a.a(intent.getStringExtra("globalID")));
            return hVar;
        } catch (Exception e10) {
            c7.e.a("OnHandleIntent--" + e10.getMessage());
            return null;
        }
    }
}
