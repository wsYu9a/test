package com.wbl.ad.yzz.ms.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class MeAlertDialogActivity extends AppCompatActivity implements View.OnClickListener {

    /* renamed from: a */
    public static b f33012a;

    /* renamed from: b */
    public static a f33013b;

    public interface a {
        void a();
    }

    public interface b {
        void a();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12628, this, view);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12627, this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-12718, this, null);
    }
}
