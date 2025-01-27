package com.aggmoread.sdk.a.adcomm.amsdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.b.u.e;

/* loaded from: classes.dex */
public class AMAppActivity extends Activity {
    private static e tmpActivityPresenter;
    private e apiActivityPresenter;

    public static void setActivityPresenter(e eVar) {
        tmpActivityPresenter = eVar;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e eVar = this.apiActivityPresenter;
        if (eVar != null ? eVar.a() : false) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        e eVar = tmpActivityPresenter;
        if (eVar != null && this.apiActivityPresenter == null) {
            this.apiActivityPresenter = eVar;
            tmpActivityPresenter = null;
        }
        e eVar2 = this.apiActivityPresenter;
        if (eVar2 != null) {
            eVar2.a(this);
            this.apiActivityPresenter.a(bundle);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        e eVar = this.apiActivityPresenter;
        if (eVar != null) {
            eVar.b();
        }
        this.apiActivityPresenter = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        e eVar = tmpActivityPresenter;
        if (eVar != null && this.apiActivityPresenter == null) {
            this.apiActivityPresenter = eVar;
            tmpActivityPresenter = null;
        }
        e eVar2 = this.apiActivityPresenter;
        if (eVar2 != null) {
            eVar2.a(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        e eVar = this.apiActivityPresenter;
        if (eVar != null) {
            eVar.onPause();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        e eVar = this.apiActivityPresenter;
        if (eVar != null) {
            eVar.onResume();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar = this.apiActivityPresenter;
        if (eVar != null ? eVar.a(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
