package com.wbl.ad.yzz.ms.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.f.k.k;

/* loaded from: classes5.dex */
public class MeNewWebActivity extends AppCompatActivity {

    /* renamed from: c */
    public static k f33014c;

    /* renamed from: a */
    public WebView f33015a;

    /* renamed from: b */
    public String f33016b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12717, this, view);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12720, this, view);
        }
    }

    public static /* synthetic */ k a() {
        return (k) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12719, null, null);
    }

    public static /* synthetic */ String a(MeNewWebActivity meNewWebActivity) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12714, null, meNewWebActivity);
    }

    public static /* synthetic */ WebView b(MeNewWebActivity meNewWebActivity) {
        return (WebView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-12713, null, meNewWebActivity);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12716, this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12715, this, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-12710, this, Integer.valueOf(i2), keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12709, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12712, this, null);
    }

    public void setZoomControlGone(View view) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12711, this, view);
    }
}
