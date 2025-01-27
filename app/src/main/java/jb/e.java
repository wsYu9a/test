package jb;

import android.content.Context;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.mibook.lib.account.MiUserManager;
import u8.b;

/* loaded from: classes3.dex */
public abstract class e<Params extends u8.b, Data> extends y8.h<Params, Data> {

    /* renamed from: g */
    public MiUserManager f27314g;

    public e(Class<Params> cls, Class<Data> cls2, Context context) {
        super(cls, cls2, context);
        this.f27314g = MiUserManager.q();
    }

    private void p() {
        me.b e10;
        MiUserManager miUserManager = this.f27314g;
        if (miUserManager == null || !miUserManager.f() || (e10 = this.f27314g.e()) == null) {
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
    public void j() {
        p();
        super.j();
    }
}
