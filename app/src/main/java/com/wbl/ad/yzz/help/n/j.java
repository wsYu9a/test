package com.wbl.ad.yzz.help.n;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.api.IActivityImpl;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class j implements IActivityImpl {

    /* renamed from: c */
    public static String f32736c = "BaiduWblActivityProxy";

    /* renamed from: a */
    public IActivityImpl f32737a;

    /* renamed from: b */
    public WeakReference<Activity> f32738b = null;

    public void a(IActivityImpl iActivityImpl) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12928, this, iActivityImpl);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12927, this, keyEvent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12922, this, motionEvent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onActivityResult(int i2, int i3, Intent intent) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12921, this, Integer.valueOf(i2), Integer.valueOf(i3), intent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onAttachedToWindow() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12924, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onBackPressed() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12923, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onConfigurationChanged(Configuration configuration) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12918, this, configuration);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12917, this, bundle);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12920, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onDetachedFromWindow() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12919, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12914, this, Integer.valueOf(i2), keyEvent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12913, this, Integer.valueOf(i2), keyEvent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onNewIntent(Intent intent) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12916, this, intent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12915, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onRestoreInstanceState(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12878, this, bundle);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12877, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onSaveInstanceState(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12880, this, bundle);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStart() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12879, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12874, this, null);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12873, this, motionEvent);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void onWindowFocusChanged(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12876, this, Boolean.valueOf(z));
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void overridePendingTransition(int i2, int i3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12875, this, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setActivity(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12870, this, activity);
    }

    @Override // com.baidu.mobads.sdk.api.IActivityImpl
    public void setLpBussParam(JSONObject jSONObject) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12869, this, jSONObject);
    }
}
