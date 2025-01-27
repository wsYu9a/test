package com.jd.ad.sdk.jad_zk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashSet;
import java.util.Set;
import p3.f;

@Deprecated
/* loaded from: classes2.dex */
public class jad_ob extends Fragment {
    public final com.jd.ad.sdk.jad_zk.jad_an jad_an;
    public final jad_qd jad_bo;
    public final Set<jad_ob> jad_cp;

    @Nullable
    public com.jd.ad.sdk.jad_gr.jad_jw jad_dq;

    @Nullable
    public jad_ob jad_er;

    @Nullable
    public Fragment jad_fs;

    public class jad_an implements jad_qd {
        public jad_an() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + jad_ob.this + f.f29748d;
        }
    }

    public jad_ob() {
        this(new com.jd.ad.sdk.jad_zk.jad_an());
    }

    public final void jad_an(@NonNull Activity activity) {
        jad_an();
        jad_pc jad_pcVar = com.jd.ad.sdk.jad_gr.jad_cp.jad_an(activity).jad_fs;
        jad_pcVar.getClass();
        jad_ob jad_an2 = jad_pcVar.jad_an(activity.getFragmentManager(), (Fragment) null);
        this.jad_er = jad_an2;
        if (equals(jad_an2)) {
            return;
        }
        this.jad_er.jad_cp.add(this);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            jad_an(activity);
        } catch (IllegalStateException e10) {
            if (Log.isLoggable("RMFragment", 5)) {
                Logger.w("RMFragment", "Unable to register fragment with root", e10);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.jad_an.jad_an();
        jad_an();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        jad_an();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.jad_an.jad_bo();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.jad_an.jad_cp();
    }

    @Override // android.app.Fragment
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = this.jad_fs;
        }
        sb2.append(parentFragment);
        sb2.append(f.f29748d);
        return sb2.toString();
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public jad_ob(@NonNull com.jd.ad.sdk.jad_zk.jad_an jad_anVar) {
        this.jad_bo = new jad_an();
        this.jad_cp = new HashSet();
        this.jad_an = jad_anVar;
    }

    public final void jad_an() {
        jad_ob jad_obVar = this.jad_er;
        if (jad_obVar != null) {
            jad_obVar.jad_cp.remove(this);
            this.jad_er = null;
        }
    }
}
