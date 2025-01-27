package com.sigmob.sdk.base.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.videoAd.BaseAdActivity;
import java.lang.reflect.Field;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class AdActivity extends BaseAdActivity implements k {

    /* renamed from: k */
    public j f17626k;

    /* renamed from: l */
    public String f17627l;

    public final j a(BaseAdUnit baseAdUnit, Bundle bundle) throws IllegalStateException {
        String stringExtra = getIntent().getStringExtra(BaseAdActivity.f20400g);
        stringExtra.hashCode();
        switch (stringExtra) {
            case "LandNative":
                return new com.sigmob.sdk.nativead.w(this, baseAdUnit, getIntent().getExtras(), bundle, this.f17627l, this);
            case "LandPage":
                return new w(this, baseAdUnit, getIntent().getExtras(), bundle, this.f17627l, this);
            case "DisLike":
                return new com.sigmob.sdk.nativead.t(this, baseAdUnit, getIntent().getExtras(), bundle, this.f17627l, this);
            case "reward":
                return new com.sigmob.sdk.videoAd.n(this, baseAdUnit, getIntent().getExtras(), bundle, this.f17627l, this);
            case "new_interstitial":
                return new com.sigmob.sdk.newInterstitial.h(this, baseAdUnit, getIntent().getExtras(), bundle, this.f17627l, this);
            case "mraid":
                return new com.sigmob.sdk.mraid.n(this, baseAdUnit, getIntent().getExtras(), bundle, this.f17627l, this);
            case "mraid_two":
                return new com.sigmob.sdk.mraid2.p(this, baseAdUnit, getIntent().getExtras(), bundle, this.f17627l, this);
            default:
                return null;
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        j jVar = this.f17626k;
        if (jVar != null) {
            jVar.a(i10, i11, intent);
        }
    }

    @Override // android.app.Activity, com.sigmob.sdk.base.common.k
    public void onBackPressed() {
        j jVar = this.f17626k;
        if (jVar == null || !jVar.b()) {
            return;
        }
        super.onBackPressed();
        this.f17626k.j();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.f17626k;
        if (jVar != null) {
            jVar.a(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        com.sigmob.sdk.videoplayer.d.c((Activity) this);
        super.onCreate(bundle);
        SigmobLog.i("TaskId :" + getTaskId());
        this.f17627l = a(getIntent());
        String stringExtra = getIntent().getStringExtra(BaseAdActivity.f20401h);
        try {
            if (ClientMetadata.getInstance() != null && !TextUtils.isEmpty(stringExtra)) {
                BaseAdUnit f10 = h.f(stringExtra);
                if (!this.f17627l.equals("dislike_broadcastIdentifier") && f10 == null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("error", "playAdUnit is null");
                    BaseBroadcastReceiver.a(this, this.f17627l, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
                    finish();
                    return;
                }
                j a10 = a(f10, bundle);
                this.f17626k = a10;
                if (a10 != null) {
                    a10.k();
                    return;
                }
                return;
            }
            SigmobLog.e("uuid is empty");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("error", "uuid is empty");
            BaseBroadcastReceiver.a(this, this.f17627l, hashMap2, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        } catch (Throwable th2) {
            SigmobLog.e("AdActivity onCreate Throwable:" + th2.getMessage());
            HashMap hashMap3 = new HashMap();
            hashMap3.put("error", th2.getMessage());
            BaseBroadcastReceiver.a(this, this.f17627l, hashMap3, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        SigmobLog.d("RewardVideoAdPlayerActivity onDestroy() called");
        j jVar = this.f17626k;
        if (jVar != null) {
            jVar.l();
        }
        this.f17626k = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
            j jVar = this.f17626k;
            if (jVar != null) {
                jVar.m();
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("error", th2.getMessage());
            BaseBroadcastReceiver.a(this, this.f17627l, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            j jVar = this.f17626k;
            if (jVar != null) {
                jVar.n();
            }
        } catch (Throwable th2) {
            HashMap hashMap = new HashMap();
            hashMap.put("error", th2.getMessage());
            BaseBroadcastReceiver.a(this, this.f17627l, hashMap, IntentActions.ACTION_REWARDED_VIDEO_PLAYFAIL);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j jVar = this.f17626k;
        if (jVar != null) {
            jVar.a(bundle);
        }
    }

    @Override // com.sigmob.sdk.base.common.k
    public void onSetContentView(View view) {
        setContentView(view);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            j jVar = this.f17626k;
            if (jVar != null) {
                jVar.o();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i10) {
        try {
            if (Build.VERSION.SDK_INT == 26 && com.sigmob.sdk.videoplayer.d.e((Activity) this)) {
                return;
            }
            super.setRequestedOrientation(i10);
        } catch (Exception e10) {
            SigmobLog.e("setRequestedOrientation: " + e10.getMessage());
        }
    }

    public static void a(Context context) {
        InputMethodManager inputMethodManager;
        if (context == null) {
            return;
        }
        try {
            inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            inputMethodManager = null;
        }
        if (inputMethodManager == null) {
            return;
        }
        for (Field field : inputMethodManager.getClass().getDeclaredFields()) {
            try {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object obj = field.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    field.set(inputMethodManager, null);
                }
            } catch (Throwable th3) {
                SigmobLog.e(th3.getMessage());
            }
        }
    }

    public static String a(Intent intent) {
        return intent.getStringExtra(Constants.BROADCAST_IDENTIFIER_KEY);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a(int i10) {
        setRequestedOrientation(i10);
    }

    @Override // com.sigmob.sdk.base.common.k
    public void a(Class<? extends Activity> cls, int i10, Bundle bundle) {
        if (cls == null) {
            return;
        }
        try {
            startActivityForResult(u.a(this, cls, bundle), i10);
        } catch (Throwable unused) {
            SigmobLog.d("Activity " + cls.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
        }
    }
}
