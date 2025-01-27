package com.opos.mobad.d.a;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static int f20408a = 800;

    /* renamed from: b */
    private long f20409b = 0;

    /* renamed from: c */
    private ArrayList<h> f20410c;

    public enum a {
        INIT_STATUS(0),
        PROGRESS_STATUS(1),
        PAUSED_STATUS(2),
        FAILED_STATUS(3),
        END_STATUS(4);


        /* renamed from: f */
        private int f20417f;

        a(int i2) {
            this.f20417f = i2;
        }

        public int a() {
            return this.f20417f;
        }
    }

    public d() {
        ArrayList<h> arrayList = new ArrayList<>(5);
        this.f20410c = arrayList;
        arrayList.add(new h(a.INIT_STATUS));
        this.f20410c.add(new h(a.PROGRESS_STATUS));
        this.f20410c.add(new h(a.PAUSED_STATUS));
        this.f20410c.add(new h(a.FAILED_STATUS));
        this.f20410c.add(new h(a.END_STATUS));
    }

    public void a(Runnable runnable, a aVar) {
        String str;
        h hVar = this.f20410c.get(aVar.a());
        if (System.currentTimeMillis() <= this.f20409b + f20408a) {
            if (aVar.a() != a.PROGRESS_STATUS.a()) {
                Iterator<h> it = this.f20410c.iterator();
                while (it.hasNext()) {
                    h next = it.next();
                    if (next.b() >= aVar.a() && next.a()) {
                        str = "is high level running";
                    } else if (next.b() < aVar.a() && next.a()) {
                        com.opos.cmn.an.f.a.b("LevelController", "level cancel = " + aVar.a());
                        next.c();
                        next.d();
                    }
                }
                com.opos.cmn.an.f.a.b("LevelController", "needToPost level = " + aVar.a());
                hVar.a(runnable, (long) f20408a);
                this.f20409b = System.currentTimeMillis() + ((long) f20408a);
                return;
            }
            return;
        }
        hVar.a(runnable);
        this.f20409b = System.currentTimeMillis();
        str = "meet interval and start";
        com.opos.cmn.an.f.a.b("LevelController", str);
    }
}
