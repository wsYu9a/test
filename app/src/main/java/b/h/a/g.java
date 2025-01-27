package b.h.a;

import android.text.TextUtils;
import android.util.Log;
import com.oplus.log.core.e;
import com.oplus.log.core.h;
import com.oplus.log.core.m;

/* loaded from: classes4.dex */
public final class g implements f {

    /* renamed from: a */
    private com.oplus.log.core.b f4994a = null;

    final class a implements com.oplus.log.core.i {
        a() {
        }

        @Override // com.oplus.log.core.i
        public final void a(String str, int i2) {
            Log.i("NLogWriter", "loganProtocolStatus: " + str + "," + i2);
        }
    }

    @Override // b.h.a.f
    public final void a() {
        h hVar;
        try {
            com.oplus.log.core.d dVar = this.f4994a.f16112b;
            if (dVar == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            if (TextUtils.isEmpty(dVar.f16131b) || (hVar = dVar.f16133d) == null) {
                return;
            }
            hVar.f();
        } catch (Exception e2) {
            if (c.j()) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.h.a.f
    public final void a(String str, String str2, byte b2, int i2) {
        try {
            com.oplus.log.core.d dVar = this.f4994a.f16112b;
            if (dVar == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            e eVar = new e();
            eVar.f16140a = e.a.f16144a;
            m mVar = new m();
            String name = Thread.currentThread().getName();
            long id = Thread.currentThread().getId();
            mVar.f16171a = str;
            mVar.f16173c = str2;
            mVar.f16172b = b2;
            mVar.f16176f = System.currentTimeMillis();
            mVar.f16177g = i2;
            mVar.f16174d = id;
            mVar.f16175e = name;
            eVar.f16142c = mVar;
            if (dVar.f16130a.size() < dVar.f16132c) {
                dVar.f16130a.add(eVar);
                h hVar = dVar.f16133d;
                if (hVar != null) {
                    hVar.c();
                }
            }
        } catch (Exception e2) {
            if (c.j()) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.h.a.f
    public final void b(e.b bVar) {
        try {
            this.f4994a.b(bVar);
        } catch (Exception e2) {
            if (c.j()) {
                e2.printStackTrace();
            }
        }
    }

    @Override // b.h.a.f
    public final void c(com.oplus.log.core.c cVar) {
        try {
            com.oplus.log.core.b bVar = new com.oplus.log.core.b();
            this.f4994a = bVar;
            bVar.a(cVar);
            if (c.j()) {
                this.f4994a.c(new a());
            }
        } catch (Throwable th) {
            if (c.j()) {
                th.printStackTrace();
            }
        }
    }
}
