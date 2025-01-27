package f9;

import android.content.Context;
import com.martian.libmars.comm.request.MTHttpGetParams;
import com.martian.libmars.comm.request.MTHttpPostParams;
import com.martian.libmars.common.ConfigSingleton;
import u8.b;
import y8.h;

/* loaded from: classes3.dex */
public abstract class e<Params extends u8.b, Data> extends h<Params, Data> {
    public e(Class cls, Class cls2, Context context) {
        super(cls, cls2, context);
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
