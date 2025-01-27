package l8;

import android.content.Context;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.rpauth.MartianIUserManager;
import u8.b;
import y8.h;

/* loaded from: classes3.dex */
public abstract class b<Params extends u8.b, Data> extends h<Params, Data> {

    /* renamed from: g */
    public MartianIUserManager f27954g;

    public b(Class cls, Class cls2, Context context) {
        super(cls, cls2, context);
        this.f27954g = MartianIUserManager.b();
    }

    private void q() {
        me.b e10;
        MartianIUserManager martianIUserManager = this.f27954g;
        if (martianIUserManager == null || !martianIUserManager.f() || (e10 = this.f27954g.e()) == null) {
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
        q();
        super.j();
    }

    public void p() {
        Params k10 = k();
        if (k10 instanceof MTHttpGetParams) {
            MTHttpGetParams mTHttpGetParams = (MTHttpGetParams) k10;
            mTHttpGetParams.setOaid(ConfigSingleton.D().M());
            mTHttpGetParams.setAndroid_id(ConfigSingleton.D().j());
            mTHttpGetParams.setImei(ConfigSingleton.D().A());
            return;
        }
        if (k10 instanceof MTHttpPostParams) {
            MTHttpPostParams mTHttpPostParams = (MTHttpPostParams) k10;
            mTHttpPostParams.setOaid(ConfigSingleton.D().M());
            mTHttpPostParams.setAndroid_id(ConfigSingleton.D().j());
            mTHttpPostParams.setImei(ConfigSingleton.D().A());
        }
    }
}
