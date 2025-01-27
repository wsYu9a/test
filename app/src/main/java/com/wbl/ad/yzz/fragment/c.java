package com.wbl.ad.yzz.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public final class c extends Fragment {

    /* renamed from: a */
    public final SparseArray<a> f32194a = new SparseArray<>();

    public final boolean a(Intent intent, a aVar) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-14085, this, intent, aVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14088, this, Integer.valueOf(i2), Integer.valueOf(i3), intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-14087, this, bundle);
    }
}
