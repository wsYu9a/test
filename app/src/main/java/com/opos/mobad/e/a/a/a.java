package com.opos.mobad.e.a.a;

import android.content.Context;
import com.opos.mobad.e.a.a.b.a;
import com.opos.mobad.e.a.k;
import com.opos.mobad.e.a.l;
import com.wrapper_oaction.ZkViewSDK;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a implements ZkViewSDK.a {

    /* renamed from: a */
    private final String f20480a;

    /* renamed from: c */
    private final com.opos.mobad.e.a.a.b f20482c;

    /* renamed from: d */
    private final Context f20483d;

    /* renamed from: e */
    private final a.C0441a f20484e;

    /* renamed from: b */
    private final long f20481b = System.currentTimeMillis();

    /* renamed from: f */
    private final C0440a f20485f = new C0440a();

    /* renamed from: g */
    private final b f20486g = new b();

    /* renamed from: h */
    private final c f20487h = new c();

    /* renamed from: com.opos.mobad.e.a.a.a$a */
    final class C0440a implements com.opos.mobad.e.a.b {
        C0440a() {
        }

        @Override // com.opos.mobad.e.a.b
        public final void a(Map map, String str, l lVar, int i2, String str2, int i3, Map map2) {
            if (a.this.f20482c.k != null) {
                a.this.f20482c.k.a(map, str, lVar, i2, str2, i3);
            }
            if (a.this.f20482c.n != null) {
                a.this.f20482c.n.a(map, str, lVar, i2, str2, i3, map2);
            }
        }

        @Override // com.opos.mobad.e.a.b
        public final void a(Map map, String str, l lVar, String str2, int i2, Map map2) {
            if (a.this.f20482c.k != null) {
                a.this.f20482c.k.a(map, str, lVar, str2, i2);
            }
            if (a.this.f20482c.n != null) {
                a.this.f20482c.n.a(map, str, lVar, str2, i2, map2);
            }
        }
    }

    final class b implements com.opos.mobad.e.a.c {
        b() {
        }

        @Override // com.opos.mobad.e.a.c
        public final void a(Map map, String str, String str2, int i2, Map map2) {
            if (a.this.f20482c.l != null) {
                a.this.f20482c.l.a(map, str, str2, i2);
            }
            if (a.this.f20482c.o != null) {
                a.this.f20482c.o.a(map, str, str2, i2, map2);
            }
        }
    }

    final class c implements com.opos.mobad.e.a.d {
        c() {
        }

        @Override // com.opos.mobad.e.a.d
        public final void a(Map map, String str, Map map2) {
            if (a.this.f20482c.m != null) {
                a.this.f20482c.m.a(map, str);
            }
            if (a.this.f20482c.p != null) {
                a.this.f20482c.p.a(map, str, map2);
            }
        }

        @Override // com.opos.mobad.e.a.d
        public final void a(Map map, Map map2) {
            if (a.this.f20482c.p != null) {
                a.this.f20482c.p.a(map, map2);
            }
        }

        @Override // com.opos.mobad.e.a.d
        public final void b(Map map, Map map2) {
            if (a.this.f20482c.m != null) {
                a.this.f20482c.m.a(map);
            }
            if (a.this.f20482c.p != null) {
                a.this.f20482c.p.b(map, map2);
            }
        }
    }

    public a(Context context, com.opos.mobad.e.a.a.b bVar, a.C0441a c0441a, String str) {
        this.f20482c = bVar;
        this.f20483d = context;
        this.f20484e = c0441a;
        this.f20480a = str;
    }

    private static l a(ZkViewSDK.Event event) {
        l lVar = new l();
        if (event != null) {
            lVar.f20509b = event.upEvent;
            lVar.f20508a = event.downEvent;
            lVar.f20510c = event.downX;
            lVar.f20511d = event.downY;
            lVar.f20513f = event.upX;
            lVar.f20514g = event.upY;
            lVar.f20515h = event.upTime;
        }
        return lVar;
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i2, int i3, int i4, Map map2) {
        k kVar = this.f20482c.q;
        if (kVar != null) {
            kVar.a(map, str, i2, i3, i4, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoProgress scene:" + str + ",sceneType:" + i2 + ", curTime:" + i3 + ", totalTime:" + i4 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i2, int i3, Map map2) {
        k kVar = this.f20482c.q;
        if (kVar != null) {
            kVar.a(map, str, i2, i3, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoStart scene:" + str + ",sceneType:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i2, String str2, Map map2) {
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i2 + ", errorMsg:" + str2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, int i2, Map map2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f20481b;
        this.f20487h.b(map, map2);
        this.f20486g.a(map, "", str, i2, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.b().a(this.f20484e).d("").e(str).a(currentTimeMillis).a(i2).a(this.f20483d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadSuccess path:" + this.f20480a + ",scene:" + str + ", sceneType:" + i2 + ",loadTime:" + currentTimeMillis);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, ZkViewSDK.Event event, int i2, String str2, int i3, Map map2) {
        l a2 = a(event);
        this.f20485f.a(map, str, a2, i2, str2, i3, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.c().a(this.f20484e).e(String.valueOf(i2)).f(str2).a(i3).d("1").a(a2).a(this.f20483d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAdClick path:" + this.f20480a + ",action:" + str + ",type:" + i2 + ",scene:" + str2 + ", sceneType:" + i3 + ",event:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, ZkViewSDK.Event event, int i2, Map map2) {
        l a2 = a(event);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.d().a(this.f20484e).d("5").e(str + " scene action name error!").a(this.f20483d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "doOtherAction path:" + this.f20480a + ",action:" + str + ", sceneType:" + i2 + ",event:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, ZkViewSDK.Event event, String str2, int i2, Map map2) {
        l a2 = a(event);
        this.f20485f.a(map, str, a2, str2, i2, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.c().a(this.f20484e).f(str2).a(i2).d("0").a(a2).a(this.f20483d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAction path:" + this.f20480a + ",action:" + str + ",scene:" + str2 + ", sceneType:" + i2 + ",event:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, String str2, int i2, Map map2) {
        long currentTimeMillis = System.currentTimeMillis() - this.f20481b;
        this.f20486g.a(map, str, str2, i2, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.b().a(this.f20484e).d(str).e(str2).a(i2).a(currentTimeMillis).a(this.f20483d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onSceneExpose path:" + this.f20480a + ",lastScene:" + str + ",curScene:" + str2 + ", sceneType:" + i2 + ",loadTime:" + currentTimeMillis + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, String str, Map map2) {
        this.f20487h.a(map, str, map2);
        com.opos.mobad.e.a.a.b.a.a();
        com.opos.mobad.e.a.a.b.a.d().a(this.f20484e).d("0").e(str).a(this.f20483d);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadFailed path:" + this.f20480a + ",msg:" + str);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void a(Map map, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f20481b;
        this.f20487h.a(map, map2);
        com.opos.cmn.an.f.a.b("LoadCallBack", "preLoadInfo path:" + this.f20480a + ",map1:" + map2 + ", cost time:" + (currentTimeMillis - j2));
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void b(Map map, String str, int i2, int i3, int i4, Map map2) {
        k kVar = this.f20482c.q;
        if (kVar != null) {
            kVar.b(map, str, i2, i3, i4, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPause scene:" + str + ",sceneType:" + i2 + ", curTime:" + i3 + ", totalTime:" + i4 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public final void c(Map map, String str, int i2, int i3, int i4, Map map2) {
        k kVar = this.f20482c.q;
        if (kVar != null) {
            kVar.c(map, str, i2, i3, i4, map2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i2 + ", curTime:" + i3 + ", totalTime:" + i4 + ",map:" + map2);
    }
}
