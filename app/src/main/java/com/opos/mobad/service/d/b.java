package com.opos.mobad.service.d;

import android.util.LruCache;
import com.opos.mobad.service.i.d;
import com.opos.mobad.service.j.e;
import com.opos.mobad.service.j.f;
import com.opos.mobad.service.j.g;
import com.opos.mobad.service.j.h;
import com.opos.mobad.service.j.i;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static b f23574a;

    /* renamed from: c */
    private h f23576c = new h(15);

    /* renamed from: b */
    private LruCache<String, com.opos.mobad.service.j.b<Integer>> f23575b = new LruCache<>(50);

    /* renamed from: com.opos.mobad.service.d.b$1 */
    class AnonymousClass1 implements com.opos.mobad.service.j.b<e> {

        /* renamed from: a */
        final /* synthetic */ i f23577a;

        /* renamed from: b */
        final /* synthetic */ String f23578b;

        AnonymousClass1(i iVar, String str) {
            iVar = iVar;
            str = str;
        }

        @Override // com.opos.mobad.service.j.b
        public void a(e eVar) {
            iVar.a(eVar);
            b.this.a(str, eVar.b());
        }
    }

    private b() {
    }

    public static final b a() {
        b bVar = f23574a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = f23574a;
                if (bVar == null) {
                    bVar = new b();
                    f23574a = bVar;
                }
            }
        }
        return bVar;
    }

    public void a(String str, int i2) {
        d.a().a(str, i2);
    }

    private com.opos.mobad.service.j.b<Integer> b(String str) {
        com.opos.mobad.service.j.b<Integer> bVar = this.f23575b.get(str);
        if (bVar != null) {
            return bVar;
        }
        e eVar = new e();
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(new i(90000));
        linkedList2.add(this.f23576c);
        linkedList.add(new g(new f(linkedList2)));
        i iVar = new i(90000);
        linkedList.add(iVar);
        com.opos.mobad.service.j.a aVar = new com.opos.mobad.service.j.a(eVar, new f(linkedList), new com.opos.mobad.service.j.b<e>() { // from class: com.opos.mobad.service.d.b.1

            /* renamed from: a */
            final /* synthetic */ i f23577a;

            /* renamed from: b */
            final /* synthetic */ String f23578b;

            AnonymousClass1(i iVar2, String str2) {
                iVar = iVar2;
                str = str2;
            }

            @Override // com.opos.mobad.service.j.b
            public void a(e eVar2) {
                iVar.a(eVar2);
                b.this.a(str, eVar2.b());
            }
        });
        this.f23575b.put(str2, aVar);
        return aVar;
    }

    public void a(String str) {
        b(str).a(1);
    }
}
