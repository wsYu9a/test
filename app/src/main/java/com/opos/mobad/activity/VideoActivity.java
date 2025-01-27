package com.opos.mobad.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.q.a.g;

/* loaded from: classes4.dex */
public class VideoActivity extends Activity {
    public static final int ACTION_TYPE_INTERSTITIAL = 2;
    public static final int ACTION_TYPE_PLAY_REWARD_VIDEO = 1;
    public static final String EXTRA_KEY_ACTION_TYPE = "actionType";
    public static final String EXTRA_KEY_AD_ITEM_DATA = "adItemData";
    public static final String EXTRA_KEY_BID_PRICE = "bidPrice";
    public static final String EXTRA_KEY_EVENT_DESCRIPTION = "eventDescription";
    public static final String EXTRA_KEY_SCREEN_MODE = "screenMode";
    public static final String EXTRA_KEY_TEMPLATE_CREATOR = "templateCreator";
    private static final String TAG = "VideoActivity";
    private com.opos.mobad.q.a.d.a mIntentDispatcher;

    /* renamed from: com.opos.mobad.activity.VideoActivity$1 */
    class AnonymousClass1 implements g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.q.a.g
        public void a() {
            if (VideoActivity.this.isDestroyed() || VideoActivity.this.isFinishing()) {
                return;
            }
            VideoActivity.this.finish();
        }
    }

    private void destroy() {
        try {
            com.opos.cmn.an.f.a.b(TAG, "destroy");
            finish();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e2);
        }
    }

    private void handleAction(Intent intent) {
        if (intent != null) {
            try {
                com.opos.mobad.q.a.d.a aVar = new com.opos.mobad.q.a.d.a(this);
                this.mIntentDispatcher = aVar;
                aVar.a(intent, createInteractor(), new g() { // from class: com.opos.mobad.activity.VideoActivity.1
                    AnonymousClass1() {
                    }

                    @Override // com.opos.mobad.q.a.g
                    public void a() {
                        if (VideoActivity.this.isDestroyed() || VideoActivity.this.isFinishing()) {
                            return;
                        }
                        VideoActivity.this.finish();
                    }
                });
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e2);
                destroy();
            }
        }
    }

    protected d createInteractor() {
        return new com.opos.mobad.a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.opos.cmn.an.f.a.b(TAG, "onConfigurationChanged newConfig=" + configuration.toString());
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        com.opos.cmn.i.g.a((Activity) this);
        super.onCreate(bundle);
        com.opos.cmn.an.f.a.b(TAG, "onCreate");
        handleAction(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        com.opos.cmn.an.f.a.b(TAG, "onDestroy");
        try {
            com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
            if (aVar != null) {
                aVar.c();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a(TAG, "", (Throwable) e2);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar == null || !aVar.a(i2, keyEvent)) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        com.opos.cmn.an.f.a.b(TAG, "onPause");
        super.onPause();
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.opos.cmn.an.f.a.b(TAG, "onResume");
        com.opos.mobad.q.a.d.a aVar = this.mIntentDispatcher;
        if (aVar != null) {
            aVar.a();
        }
    }
}
