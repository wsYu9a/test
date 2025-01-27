package le;

import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.rpauth.MartianIUserManager;
import u8.b;
import x8.k;

/* loaded from: classes3.dex */
public abstract class a<Params extends u8.b, Data> extends ne.a<Params, Data> {

    /* renamed from: h */
    public MartianIUserManager f28101h;

    public a(Class<Params> cls, Class<Data> cls2) {
        super(cls, cls2);
        this.f28101h = MartianIUserManager.b();
    }

    private void p() {
        me.b e10;
        MartianIUserManager martianIUserManager = this.f28101h;
        if (martianIUserManager == null || !martianIUserManager.f() || (e10 = this.f28101h.e()) == null) {
            return;
        }
        Params k10 = k();
        if (k10 instanceof MTHttpGetParams) {
            MTHttpGetParams mTHttpGetParams = (MTHttpGetParams) k10;
            mTHttpGetParams.setUid(e10.getUid());
            mTHttpGetParams.setToken(e10.getToken());
        } else if (k10 instanceof MTHttpPostParams) {
            MTHttpPostParams mTHttpPostParams = (MTHttpPostParams) k10;
            mTHttpPostParams.setUid(e10.getUid());
            mTHttpPostParams.setToken(e10.getToken());
        }
    }

    @Override // y8.d
    public k i() {
        p();
        return super.i();
    }

    @Override // y8.d
    public void j() {
        p();
        super.j();
    }
}
