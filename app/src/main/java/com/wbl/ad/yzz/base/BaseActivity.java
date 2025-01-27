package com.wbl.ad.yzz.base;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public abstract void a();

    public void a(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15777, this, bundle);
    }

    public void b(Activity activity) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15780, this, activity);
    }

    public abstract int d();

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15779, this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15806, this, null);
    }
}
