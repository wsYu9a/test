package com.martian.mibook.mvvm.base;

import androidx.fragment.app.Fragment;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/mvvm/base/LazyFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "", t.f11204d, "", "j", "()Z", "onResume", "onPause", "k", "c", "Z", "isDataLoaded", "d", "isVisibleToUser", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public abstract class LazyFragment extends Fragment {

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isDataLoaded;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isVisibleToUser;

    private final void l() {
        if (this.isDataLoaded) {
            return;
        }
        this.isDataLoaded = true;
        k();
    }

    /* renamed from: j, reason: from getter */
    public boolean getIsVisibleToUser() {
        return this.isVisibleToUser;
    }

    public void k() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isVisibleToUser = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isVisibleToUser = true;
        l();
    }
}
