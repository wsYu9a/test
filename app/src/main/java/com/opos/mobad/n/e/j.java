package com.opos.mobad.n.e;

import android.content.Context;
import android.view.View;
import com.wrapper_oaction.ZkViewSDK;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class j implements d {

    /* renamed from: a */
    private View f22134a;

    /* renamed from: b */
    private Context f22135b;

    public j(Context context, View view) {
        this.f22134a = view;
        this.f22135b = context;
    }

    private boolean e() {
        if (this.f22134a != null) {
            return true;
        }
        com.opos.cmn.an.f.a.d("MatView", "mView is null!");
        return false;
    }

    @Override // com.opos.mobad.n.e.d
    public View a() {
        return this.f22134a;
    }

    @Override // com.opos.mobad.n.e.d
    public void a(String str) {
        com.opos.cmn.an.f.a.b("MatView", "updateMatTitle!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_TITLE, str);
                ZkViewSDK.b().e(this.f22134a, hashMap);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.d("MatView", "updateMatTitle error!title=" + str);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void a(boolean z) {
        com.opos.cmn.an.f.a.b("MatView", "setVideoMute!");
        if (e()) {
            try {
                ZkViewSDK.b().f(this.f22134a, z);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.d("MatView", "setVideoMute error!mute=" + z);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void b() {
        com.opos.cmn.an.f.a.b("MatView", "pause!");
        if (e()) {
            try {
                ZkViewSDK.b().i(this.f22134a);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.d("MatView", "pause error!" + this.f22134a);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void b(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatDesc!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_DESC, str);
                ZkViewSDK.b().e(this.f22134a, hashMap);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.d("MatView", "setMatDesc error!desc=" + str);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void c() {
        com.opos.cmn.an.f.a.b("MatView", "resume!");
        if (e()) {
            try {
                ZkViewSDK.b().d(this.f22134a);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.d("MatView", "resume error!" + this.f22134a);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void c(String str) {
        com.opos.cmn.an.f.a.b("MatView", "setMatAction!");
        if (e()) {
            try {
                HashMap<ZkViewSDK.KEY, Object> hashMap = new HashMap<>();
                hashMap.put(ZkViewSDK.KEY.KEY_AD_ACTION, str);
                ZkViewSDK.b().e(this.f22134a, hashMap);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.d("MatView", "setMatAction error!action=" + str);
            }
        }
    }

    @Override // com.opos.mobad.n.e.d
    public void d() {
        com.opos.cmn.an.f.a.b("MatView", "release!");
        if (e()) {
            try {
                ZkViewSDK.b().j(this.f22134a);
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.d("MatView", "release error!" + this.f22134a);
            }
        }
    }
}
