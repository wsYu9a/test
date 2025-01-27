package com.jd.ad.sdk.jad_zk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashSet;
import java.util.Set;
import p3.f;

/* loaded from: classes2.dex */
public class jad_uh extends Fragment {
    public final com.jd.ad.sdk.jad_zk.jad_an jad_an;
    public final jad_qd jad_bo;
    public final Set<jad_uh> jad_cp;

    @Nullable
    public jad_uh jad_dq;

    @Nullable
    public com.jd.ad.sdk.jad_gr.jad_jw jad_er;

    @Nullable
    public Fragment jad_fs;

    public class jad_an implements jad_qd {
        public jad_an() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + jad_uh.this + f.f29748d;
        }
    }

    public jad_uh() {
        this(new com.jd.ad.sdk.jad_zk.jad_an());
    }

    @Nullable
    public final Fragment jad_an() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.jad_fs;
    }

    public final void jad_bo() {
        jad_uh jad_uhVar = this.jad_dq;
        if (jad_uhVar != null) {
            jad_uhVar.jad_cp.remove(this);
            this.jad_dq = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Logger.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                jad_an(getContext(), fragmentManager);
            } catch (IllegalStateException e10) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Logger.w("SupportRMFragment", "Unable to register fragment with root", e10);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.jad_fs = null;
        jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + jad_an() + f.f29748d;
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public jad_uh(@NonNull com.jd.ad.sdk.jad_zk.jad_an jad_anVar) {
        this.jad_bo = new jad_an();
        this.jad_cp = new HashSet();
        this.jad_an = jad_anVar;
    }

    public final void jad_an(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        jad_bo();
        jad_uh jad_an2 = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(context).jad_fs.jad_an(fragmentManager, (Fragment) null);
        this.jad_dq = jad_an2;
        if (equals(jad_an2)) {
            return;
        }
        this.jad_dq.jad_cp.add(this);
    }
}
