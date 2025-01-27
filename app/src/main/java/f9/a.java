package f9;

import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.libmars.common.ConfigSingleton;
import u8.b;
import x8.k;

/* loaded from: classes3.dex */
public abstract class a<Params extends u8.b, Data> extends y8.e<Params, Data, b<Data>> {

    /* renamed from: g */
    public static final int f26008g = 201;

    public a(Class<Params> cls, b<Data> bVar) {
        super(cls, ConfigSingleton.D(), bVar);
    }

    @Override // y8.d, y8.b
    /* renamed from: h */
    public k doInBackground(u8.b bVar) {
        k doInBackground = super.doInBackground(bVar);
        MTHttpGetParams.diffServerTime = doInBackground.a() - System.currentTimeMillis();
        if (!(doInBackground instanceof x8.c) || ((x8.c) doInBackground).c() != 201 || !(bVar instanceof MTHttpGetParams)) {
            return doInBackground;
        }
        ((MTHttpGetParams) bVar).initTime();
        return super.doInBackground(bVar);
    }

    public void o() {
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
