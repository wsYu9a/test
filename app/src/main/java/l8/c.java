package l8;

import com.martian.appwall.request.MartianGetAppwallParams;
import com.martian.appwall.response.MartianAppwallTask;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes3.dex */
public abstract class c extends a<MartianGetAppwallParams, MartianAppwallTask> {
    public c() {
        super(MartianIUserManager.b(), MartianGetAppwallParams.class, MartianAppwallTask.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: q */
    public boolean onPreDataReceived(MartianAppwallTask martianAppwallTask) {
        if (martianAppwallTask == null) {
            return false;
        }
        return super.onPreDataReceived(martianAppwallTask);
    }
}
