package l8;

import com.martian.appwall.request.MartianAppwallAuthoptParams;
import com.martian.rpauth.MartianIUserManager;
import x8.k;

/* loaded from: classes3.dex */
public abstract class a<Params extends MartianAppwallAuthoptParams, Data> extends ne.a<Params, Data> {

    /* renamed from: h */
    public final MartianIUserManager f27953h;

    public a(MartianIUserManager martianIUserManager, Class<Params> cls, Class<Data> cls2) {
        super(cls, cls2);
        this.f27953h = martianIUserManager;
    }

    @Override // y8.d
    public k i() {
        p(this.f27953h);
        return super.i();
    }

    @Override // y8.d
    public void j() {
        p(this.f27953h);
        super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(MartianIUserManager martianIUserManager) {
        me.b e10;
        if (martianIUserManager.f() && (e10 = martianIUserManager.e()) != null) {
            ((MartianAppwallAuthoptParams) k()).setUid(e10.getUid());
            ((MartianAppwallAuthoptParams) k()).setToken(e10.getToken());
        }
    }
}
