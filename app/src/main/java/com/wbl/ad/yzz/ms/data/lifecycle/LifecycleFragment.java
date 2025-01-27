package com.wbl.ad.yzz.ms.data.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.ms.d.d.c;

/* loaded from: classes5.dex */
public class LifecycleFragment extends Fragment {

    /* renamed from: a */
    public c f33096a;

    public static LifecycleFragment a(Activity activity) {
        return (LifecycleFragment) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11983, null, activity);
    }

    public static LifecycleFragment a(FragmentManager fragmentManager) {
        return (LifecycleFragment) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-11978, null, fragmentManager);
    }

    public void a(c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11977, this, cVar);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11980, this, null);
    }

    @Override // android.app.Fragment
    public void onPause() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11979, this, null);
    }

    @Override // android.app.Fragment
    public void onResume() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11974, this, null);
    }

    @Override // android.app.Fragment
    public void onStart() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11973, this, null);
    }

    @Override // android.app.Fragment
    public void onStop() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-11976, this, null);
    }
}
