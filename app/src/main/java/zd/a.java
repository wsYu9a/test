package zd;

import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.martian.mibook.lib.account.request.MiOptionsParams;
import l9.p0;
import z5.k;
import z8.e;

/* loaded from: classes3.dex */
public class a extends Thread {
    public final String a() {
        me.b e10;
        MiOptionsParams miOptionsParams = new MiOptionsParams();
        if (MiUserManager.q() != null && (e10 = MiUserManager.q().e()) != null) {
            miOptionsParams.setUid(e10.getUid());
        }
        miOptionsParams.setDevice_id(ConfigSingleton.D().y());
        return miOptionsParams.toHttpUrl(k.f33694e);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            MiConfigSingleton.b2().f2().s(e.b(a(), null));
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }
}
