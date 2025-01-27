package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.mobad.b.a.y;
import com.opos.mobad.provider.ad.AdEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static volatile c f21560a;

    /* renamed from: b */
    private Context f21561b;

    /* renamed from: c */
    private com.opos.mobad.provider.ad.a f21562c;

    /* renamed from: com.opos.mobad.model.d.c$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f21563a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.model.b.d f21564b;

        /* renamed from: c */
        final /* synthetic */ String f21565c;

        AnonymousClass1(List list, com.opos.mobad.model.b.d dVar, String str) {
            list = list;
            dVar = dVar;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] a2 = c.this.a((List<com.opos.mobad.b.a.b>) list);
                c.this.f21562c.a(str, new AdEntity(com.opos.mobad.b.a.d.f19667c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.d>) dVar.c()), a2, dVar.i()));
                c.this.a((com.opos.mobad.b.a.b) list.get(0));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("acManager", "cache fail", (Throwable) e2);
            }
        }
    }

    private c(Context context) {
        this.f21561b = context;
        this.f21562c = new com.opos.mobad.provider.ad.a(context);
    }

    public static final c a(Context context) {
        c cVar = f21560a;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = f21560a;
                if (cVar == null) {
                    cVar = new c(context.getApplicationContext());
                    f21560a = cVar;
                }
            }
        }
        return cVar;
    }

    private List<com.opos.mobad.b.a.b> a(byte[] bArr) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        while (dataInputStream.available() > 0) {
            int readInt = dataInputStream.readInt();
            byte[] bArr2 = new byte[readInt];
            dataInputStream.read(bArr2, 0, readInt);
            arrayList.add(com.opos.mobad.b.a.b.f19603c.a(bArr2));
        }
        return arrayList;
    }

    public void a(com.opos.mobad.b.a.b bVar) {
        if (com.opos.cmn.an.h.c.a.e(this.f21561b)) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            d.a(this.f21561b, bVar, (Set<com.opos.mobad.model.b.e>) hashSet, false, (q) null);
            List<y> list = bVar.A;
            if (list != null && list.size() >= 0 && bVar.A.get(0) != null) {
                d.a(this.f21561b, bVar.A.get(0), hashSet, hashSet2, false, null);
            }
            com.opos.cmn.an.f.a.b("acManager", "fm:" + hashSet.size() + ",om:" + hashSet2.size());
            if (hashSet.size() > 0) {
                com.opos.cmn.an.f.a.b("acManager", "resource result:" + new j(this.f21561b).a(hashSet, null));
            }
        }
    }

    public byte[] a(List<com.opos.mobad.b.a.b> list) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Iterator<com.opos.mobad.b.a.b> it = list.iterator();
        while (it.hasNext()) {
            byte[] b2 = com.opos.mobad.b.a.b.f19603c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.b>) it.next());
            dataOutputStream.writeInt(b2.length);
            dataOutputStream.write(b2);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public com.opos.mobad.model.b.d a(String str) throws Exception {
        AdEntity a2 = this.f21562c.a(str);
        if (a2 == null) {
            return null;
        }
        return new com.opos.mobad.model.b.d(com.opos.mobad.b.a.d.f19667c.a(a2.f23119a), a(a2.f23120b), a2.f23121c);
    }

    public void a(String str, com.opos.mobad.model.b.d dVar, List<com.opos.mobad.b.a.b> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("cache list num:");
        sb.append(list != null ? list.size() : 0);
        com.opos.cmn.an.f.a.b("acManager", sb.toString());
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.c.1

            /* renamed from: a */
            final /* synthetic */ List f21563a;

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.model.b.d f21564b;

            /* renamed from: c */
            final /* synthetic */ String f21565c;

            AnonymousClass1(List list2, com.opos.mobad.model.b.d dVar2, String str2) {
                list = list2;
                dVar = dVar2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    byte[] a2 = c.this.a((List<com.opos.mobad.b.a.b>) list);
                    c.this.f21562c.a(str, new AdEntity(com.opos.mobad.b.a.d.f19667c.b((com.heytap.nearx.a.a.e<com.opos.mobad.b.a.d>) dVar.c()), a2, dVar.i()));
                    c.this.a((com.opos.mobad.b.a.b) list.get(0));
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("acManager", "cache fail", (Throwable) e2);
                }
            }
        });
    }
}
