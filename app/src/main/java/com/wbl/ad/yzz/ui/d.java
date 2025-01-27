package com.wbl.ad.yzz.ui;

import android.app.Activity;
import android.view.KeyEvent;

/* loaded from: classes5.dex */
public interface d extends com.wbl.ad.yzz.d.d.a {
    void a();

    void a(Activity activity);

    void a(com.wbl.ad.yzz.d.b.d.b<com.wbl.ad.yzz.d.d.a, com.wbl.ad.yzz.d.a.a> bVar);

    void a(com.wbl.ad.yzz.innerconfig.d.e eVar);

    void a(ADActivity aDActivity);

    void b();

    void b(ADActivity aDActivity);

    int d();

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    void finish();

    void onDestroy();

    void onPause();

    void onStop();
}
