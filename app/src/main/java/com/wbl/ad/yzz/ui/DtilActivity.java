package com.wbl.ad.yzz.ui;

import android.content.Context;
import android.content.res.Configuration;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.base.BaseActivity;
import com.wbl.ad.yzz.ui.delegate.DtilActivityDelegate;

/* loaded from: classes5.dex */
public class DtilActivity extends BaseActivity {

    /* renamed from: a */
    public final DtilActivityDelegate f33930a = new DtilActivityDelegate(this);

    public static void startActivity(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10145, null, context);
    }

    public static void startActivity(Context context, com.wbl.ad.yzz.bean.b bVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10148, null, context, bVar);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10147, this, null);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public int d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10174, this, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10173, this, configuration);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10176, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10175, this, null);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10170, this, Boolean.valueOf(z));
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10169, this, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10172, this, null);
    }
}
