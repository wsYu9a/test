package com.martian.mibook.lib.account.d.q;

import android.app.Activity;
import com.martian.mibook.lib.account.request.auth.GetMiAccountParams;
import com.martian.rpauth.response.MartianRPAccount;

/* loaded from: classes3.dex */
public abstract class p extends com.martian.mibook.lib.account.d.n<GetMiAccountParams, MartianRPAccount> {
    public p(Activity activity) {
        super(activity, GetMiAccountParams.class, MartianRPAccount.class);
    }
}
