package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.lg.y;
import com.ss.android.downloadlib.q.i;

/* loaded from: classes4.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    protected void j() {
        if (getIntent() == null) {
            i.j().j("handleIntent is null");
            com.ss.android.socialbase.appdownloader.i.j((Activity) this);
        }
        String stringExtra = getIntent().getStringExtra("p");
        long longExtra = getIntent().getLongExtra("id", 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            i.j().j("getPackage or id is null");
            com.ss.android.socialbase.appdownloader.i.j((Activity) this);
        }
        int optInt = pa.k().optInt("ab", 0);
        y.j(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            com.ss.android.socialbase.appdownloader.i.j((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.ss.android.socialbase.appdownloader.i.j((Activity) this);
    }
}
