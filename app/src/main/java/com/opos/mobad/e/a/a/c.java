package com.opos.mobad.e.a.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.e.a.a.b.a;
import com.opos.mobad.e.a.g;
import com.wrapper_oaction.ZkViewSDK;
import java.util.HashMap;

/* loaded from: classes4.dex */
final class c implements g {

    /* renamed from: a */
    private View f20505a;

    /* renamed from: b */
    private Context f20506b;

    /* renamed from: c */
    private a.C0441a f20507c;

    public c(Context context, View view, a.C0441a c0441a) {
        this.f20505a = view;
        this.f20506b = context;
        this.f20507c = c0441a;
    }

    private boolean e() {
        if (this.f20505a != null) {
            return true;
        }
        com.opos.cmn.an.f.a.d("MatView", "mView is null!");
        return false;
    }

    @Override // com.opos.mobad.e.a.g
    public final View a() {
        return this.f20505a;
    }

    @Override // com.opos.mobad.e.a.g
    public final void a(Object obj) {
        com.opos.cmn.an.f.a.b("MatView", "setMatImage!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_IMAGE, obj);
                ZkViewSDK.b().e(this.f20505a, hashMap);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("7").e("zk setMatImage error!Object=" + obj + ",msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "setMatImage error!Object=".concat(String.valueOf(obj)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void a(String str) {
        com.opos.cmn.an.f.a.b("MatView", "updateMatTitle!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_TITLE, str);
                ZkViewSDK.b().e(this.f20505a, hashMap);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("7").e("zk updateMatTitle error!title=" + str + ",msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "updateMatTitle error!title=".concat(String.valueOf(str)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void b() {
        com.opos.cmn.an.f.a.b("MatView", "pause!");
        if (e()) {
            try {
                ZkViewSDK.b().i(this.f20505a);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("2").e("zk pause error! + msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "pause error!" + this.f20505a);
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void b(Object obj) {
        com.opos.cmn.an.f.a.b("MatView", "setMatLogo!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_LOGO, obj);
                ZkViewSDK.b().e(this.f20505a, hashMap);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("7").e("zk setMatLogo error!Object=" + obj + ",msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "setMatLogo error!Object=".concat(String.valueOf(obj)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void b(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatDesc!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_DESC, str);
                ZkViewSDK.b().e(this.f20505a, hashMap);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("7").e("zk setMatDesc error!desc=" + str + ",msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "setMatDesc error!desc=".concat(String.valueOf(str)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void c() {
        com.opos.cmn.an.f.a.b("MatView", "resume!");
        if (e()) {
            try {
                ZkViewSDK.b().d(this.f20505a);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("1").e("zk resume error! + msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "resume error!" + this.f20505a);
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void c(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatAction!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_ACTION, str);
                ZkViewSDK.b().e(this.f20505a, hashMap);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("7").e("zk setMatAction error!action=" + str + ",msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "setMatAction error!action=".concat(String.valueOf(str)));
            }
        }
    }

    @Override // com.opos.mobad.e.a.g
    public final void d() {
        com.opos.cmn.an.f.a.b("MatView", "release!");
        if (e()) {
            try {
                ZkViewSDK.b().j(this.f20505a);
            } catch (Exception e2) {
                com.opos.mobad.e.a.a.b.a.a();
                com.opos.mobad.e.a.a.b.a.d().a(this.f20507c).d("3").e("zk release error! + msg:" + e2.getMessage()).a(this.f20506b);
                com.opos.cmn.an.f.a.d("MatView", "release error!" + this.f20505a);
            }
        }
    }
}
