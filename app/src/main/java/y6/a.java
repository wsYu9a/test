package y6;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class a extends c {
    @Override // y6.d
    public final b7.d a(Context context, int i10, Intent intent) {
        if (4098 != i10) {
            return null;
        }
        b7.d b10 = b(intent);
        x6.b.u0(context, (b7.a) b10, x6.b.f31839j);
        return b10;
    }

    @Override // y6.c
    public final b7.d b(Intent intent) {
        try {
            b7.a aVar = new b7.a();
            aVar.e(Integer.parseInt(c7.a.a(intent.getStringExtra("messageID"))));
            aVar.g(c7.a.a(intent.getStringExtra("taskID")));
            aVar.d(c7.a.a(intent.getStringExtra("appPackage")));
            aVar.r(c7.a.a(intent.getStringExtra("content")));
            aVar.q(Integer.parseInt(c7.a.a(intent.getStringExtra(b7.d.f1370w))));
            aVar.w(Long.parseLong(c7.a.a(intent.getStringExtra(b7.d.B))));
            aVar.t(Long.parseLong(c7.a.a(intent.getStringExtra(b7.d.C))));
            aVar.x(c7.a.a(intent.getStringExtra(b7.d.f1371x)));
            aVar.y(c7.a.a(intent.getStringExtra("title")));
            aVar.v(c7.a.a(intent.getStringExtra(b7.d.f1372y)));
            aVar.u(Integer.parseInt(c7.a.a(intent.getStringExtra(b7.d.f1373z))));
            aVar.s(Integer.parseInt(c7.a.a(intent.getStringExtra(b7.d.A))));
            c7.e.a("OnHandleIntent-message:" + aVar.toString());
            return aVar;
        } catch (Exception e10) {
            c7.e.a("OnHandleIntent--" + e10.getMessage());
            return null;
        }
    }
}
