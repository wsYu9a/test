package com.opos.mobad.n.e;

import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.util.Map;

/* loaded from: classes4.dex */
class k implements ZkViewSDK.a {

    /* renamed from: a */
    private final String f22136a;

    /* renamed from: c */
    private final i f22138c;

    /* renamed from: b */
    private final long f22137b = System.currentTimeMillis();

    /* renamed from: d */
    private final com.opos.mobad.n.e.b f22139d = new a();

    /* renamed from: e */
    private final e f22140e = new b();

    /* renamed from: f */
    private final f f22141f = new c();

    class a implements com.opos.mobad.n.e.b {
        a() {
        }

        @Override // com.opos.mobad.n.e.b
        public void a(View view, int[] iArr) {
            if (k.this.f22138c.o != null) {
                k.this.f22138c.o.a(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void b(View view, int[] iArr) {
            if (k.this.f22138c.o != null) {
                k.this.f22138c.o.b(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void c(View view, int[] iArr) {
            if (k.this.f22138c.o != null) {
                k.this.f22138c.o.c(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void d(View view, int[] iArr) {
            if (k.this.f22138c.o != null) {
                k.this.f22138c.o.d(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void e(View view, int[] iArr) {
            if (k.this.f22138c.o != null) {
                k.this.f22138c.o.e(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.e.b
        public void f(View view, int[] iArr) {
            if (k.this.f22138c.o != null) {
                k.this.f22138c.o.f(view, iArr);
            }
        }
    }

    class b implements e {
        b() {
        }

        @Override // com.opos.mobad.n.e.e
        public void a() {
            if (k.this.f22138c.p != null) {
                k.this.f22138c.p.a();
            }
        }
    }

    class c implements f {
        c() {
        }

        @Override // com.opos.mobad.n.e.f
        public void a() {
            if (k.this.f22138c.q != null) {
                k.this.f22138c.q.a();
            }
        }

        @Override // com.opos.mobad.n.e.f
        public void a(String str) {
            if (k.this.f22138c.q != null) {
                k.this.f22138c.q.a(str);
            }
        }
    }

    public k(i iVar, String str) {
        this.f22138c = iVar;
        this.f22136a = str;
    }

    private int[] a(ZkViewSDK.Event event) {
        return event == null ? new int[4] : new int[]{event.downX, event.downY, event.upX, event.upY};
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i2, int i3, int i4, Map map2) {
        g gVar = this.f22138c.r;
        if (gVar != null) {
            gVar.a(i3, i4);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoProgress scene:" + str + ",sceneType:" + i2 + ", curTime:" + i3 + ", totalTime:" + i4 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i2, int i3, Map map2) {
        g gVar = this.f22138c.r;
        if (gVar != null) {
            gVar.a(i3);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoStart scene:" + str + ",sceneType:" + i2 + ", totalTime:" + i3 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i2, String str2, Map map2) {
        g gVar = this.f22138c.r;
        if (gVar != null) {
            gVar.a(str2);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i2 + ", errorMsg:" + str2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, int i2, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f22137b;
        this.f22141f.a();
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadSuccess path:" + this.f22136a + ",scene:" + str + ", sceneType:" + i2 + ",loadTime:" + (currentTimeMillis - j2));
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, ZkViewSDK.Event event, int i2, String str2, int i3, Map map2) {
        int[] iArr = {event.downX, event.downY, event.upX, event.upY};
        if (i2 == 0) {
            this.f22139d.e(this.f22138c.s, iArr);
        } else if (1 == i2) {
            this.f22139d.f(this.f22138c.s, iArr);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAdClick path:" + this.f22136a + ",action:" + str + ",type:" + i2 + ",scene:" + str2 + ", sceneType:" + i3 + ",coordinate:" + iArr + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, ZkViewSDK.Event event, int i2, Map map2) {
        com.opos.cmn.an.f.a.b("LoadCallBack", "doOtherAction path:" + this.f22136a + ",action:" + str + ", sceneType:" + i2 + ",event:" + a(event) + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, ZkViewSDK.Event event, String str2, int i2, Map map2) {
        int[] a2;
        a2 = a(event);
        str.hashCode();
        switch (str) {
            case "useraction_showprivacy":
                this.f22139d.c(this.f22138c.s, a2);
                break;
            case "useraction_showpermissions":
                this.f22139d.b(this.f22138c.s, a2);
                break;
            case "useraction_close":
            case "useraction_countdown":
            case "useraction_skip":
                this.f22139d.a(this.f22138c.s, a2);
                break;
            case "useraction_shake":
                this.f22139d.d(this.f22138c.s, a2);
                break;
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "doAction path:" + this.f22136a + ",action:" + str + ",scene:" + str2 + ", sceneType:" + i2 + ",coordinate:" + a2 + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, String str2, int i2, Map map2) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f22137b;
        this.f22140e.a();
        com.opos.cmn.an.f.a.b("LoadCallBack", "onSceneExpose path:" + this.f22136a + ",lastScene:" + str + ",curScene:" + str2 + ", sceneType:" + i2 + ",loadTime:" + (currentTimeMillis - j2) + ",engineInfo:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, String str, Map map2) {
        this.f22141f.a(str);
        com.opos.cmn.an.f.a.b("LoadCallBack", "onLoadFailed path:" + this.f22136a + ",msg:" + str);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void a(Map map, Map map2) {
        com.opos.cmn.an.f.a.b("LoadCallBack", "preLoadInfo path:" + this.f22136a + ",map1:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void b(Map map, String str, int i2, int i3, int i4, Map map2) {
        g gVar = this.f22138c.r;
        if (gVar != null) {
            gVar.b(i3, i4);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPause scene:" + str + ",sceneType:" + i2 + ", curTime:" + i3 + ", totalTime:" + i4 + ",map:" + map2);
    }

    @Override // com.wrapper_oaction.ZkViewSDK.a
    public void c(Map map, String str, int i2, int i3, int i4, Map map2) {
        g gVar = this.f22138c.r;
        if (gVar != null) {
            gVar.c(i3, i4);
        }
        com.opos.cmn.an.f.a.b("LoadCallBack", "onVideoPlayEnd scene:" + str + ",sceneType:" + i2 + ", curTime:" + i3 + ", totalTime:" + i4 + ",map:" + map2);
    }
}
