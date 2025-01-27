package com.opos.mobad.k;

import android.content.Context;
import android.view.View;
import com.opos.mobad.k.f;
import java.util.List;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: com.opos.mobad.k.e$1 */
    static final class AnonymousClass1 extends com.opos.mobad.n.a.e {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.ad.e.e f21175a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List list, com.opos.mobad.ad.e.e eVar) {
            super(list);
            eVar = eVar;
        }

        @Override // com.opos.mobad.n.d
        public View a() {
            return eVar.a();
        }

        @Override // com.opos.mobad.n.d
        public void a(int i2) {
            eVar.a(i2);
        }
    }

    public static final com.opos.mobad.n.d a(f.a aVar, Context context, com.opos.mobad.ad.e.e eVar) {
        return (!f.a(aVar) || eVar == null || eVar.a() == null || eVar.b().size() <= 0) ? new com.opos.mobad.n.a.d(context) : new com.opos.mobad.n.a.e(eVar.b()) { // from class: com.opos.mobad.k.e.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.ad.e.e f21175a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(List list, com.opos.mobad.ad.e.e eVar2) {
                super(list);
                eVar = eVar2;
            }

            @Override // com.opos.mobad.n.d
            public View a() {
                return eVar.a();
            }

            @Override // com.opos.mobad.n.d
            public void a(int i2) {
                eVar.a(i2);
            }
        };
    }
}
