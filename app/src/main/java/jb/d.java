package jb;

import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.mibook.lib.account.MiUserManager;
import u8.b;

/* loaded from: classes3.dex */
public abstract class d<Params extends u8.b, Data> extends ne.a<Params, Data> {

    /* renamed from: h */
    public MiUserManager f27313h;

    public d(Class<Params> cls, Class<Data> cls2) {
        super(cls, cls2);
        this.f27313h = MiUserManager.q();
    }

    private void p() {
        me.b e10;
        MiUserManager miUserManager = this.f27313h;
        if (miUserManager == null || !miUserManager.f() || (e10 = this.f27313h.e()) == null) {
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
    public x8.k i() {
        p();
        return super.i();
    }

    @Override // y8.d
    public void j() {
        p();
        super.j();
    }
}
