package kb;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.GetMiTaskAccountParams;
import com.martian.mibook.lib.account.response.MiTaskAccount;

/* loaded from: classes3.dex */
public abstract class l extends jb.k<GetMiTaskAccountParams, MiTaskAccount> {
    public l(Activity activity) {
        super(activity, GetMiTaskAccountParams.class, MiTaskAccount.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: u */
    public boolean onPreDataReceived(MiTaskAccount miTaskAccount) {
        if (miTaskAccount == null) {
            return false;
        }
        return super.onPreDataReceived(miTaskAccount);
    }
}
