package com.jd.ad.sdk.jad_n_an;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class jad_n_an {
    public int jad_n_an;
    public jad_n_cp jad_n_bo;
    public WeakReference<JADNativeSplashInteractionListener> jad_n_cp;
    public final int jad_n_er;

    @Nullable
    public View jad_n_hu;
    public final Handler jad_n_fs = new Handler(Looper.getMainLooper());

    @NonNull
    public int jad_n_jt = 1;
    public final Runnable jad_n_iv = new RunnableC0338jad_n_an();
    public final Application.ActivityLifecycleCallbacks jad_n_jw = new jad_n_bo();
    public final Application jad_n_dq = JADMediator.getInstance().getFoundationService().getApplication();

    /* renamed from: com.jd.ad.sdk.jad_n_an.jad_n_an$jad_n_an */
    public class RunnableC0338jad_n_an implements Runnable {
        public RunnableC0338jad_n_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<JADNativeSplashInteractionListener> weakReference = jad_n_an.this.jad_n_cp;
            if (weakReference != null && weakReference.get() != null) {
                jad_n_an.this.jad_n_cp.get().onCountdown(jad_n_an.this.jad_n_an);
            }
            jad_n_an jad_n_anVar = jad_n_an.this;
            jad_n_anVar.jad_n_an--;
            StringBuilder a10 = a.a("Native ad skip=====totalCount=");
            a10.append(jad_n_an.this.jad_n_an);
            Logger.d(a10.toString());
            jad_n_an jad_n_anVar2 = jad_n_an.this;
            if (jad_n_anVar2.jad_n_an >= 0) {
                jad_n_anVar2.jad_n_fs.postDelayed(jad_n_anVar2.jad_n_iv, 1000L);
                return;
            }
            jad_n_cp jad_n_cpVar = jad_n_anVar2.jad_n_bo;
            if (jad_n_cpVar != null) {
                jad_n_hu.jad_n_an(((jad_n_jw) jad_n_cpVar).jad_n_an, jad_n_anVar2.jad_n_hu, false);
            }
            Logger.d("Native ad skip===stopCount");
            jad_n_an.this.jad_n_bo();
        }
    }

    public class jad_n_bo implements Application.ActivityLifecycleCallbacks {
        public jad_n_bo() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            Logger.d("Native ad time onActivityDestroyed = " + activity);
            int hashCode = activity.hashCode();
            jad_n_an jad_n_anVar = jad_n_an.this;
            if (hashCode == jad_n_anVar.jad_n_er) {
                jad_n_anVar.jad_n_bo();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            Logger.d("Native ad time onActivityPaused = " + activity);
            int hashCode = activity.hashCode();
            jad_n_an jad_n_anVar = jad_n_an.this;
            if (hashCode == jad_n_anVar.jad_n_er && jad_n_anVar.jad_n_jt == 2) {
                jad_n_anVar.jad_n_an(3);
                jad_n_anVar.jad_n_fs.removeCallbacksAndMessages(null);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            Logger.d("Native ad time onActivityResumed = " + activity);
            int hashCode = activity.hashCode();
            jad_n_an jad_n_anVar = jad_n_an.this;
            if (hashCode == jad_n_anVar.jad_n_er && jad_n_anVar.jad_n_jt == 3) {
                jad_n_anVar.jad_n_an(2);
                jad_n_anVar.jad_n_fs.post(jad_n_anVar.jad_n_iv);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    public interface jad_n_cp {
    }

    public jad_n_an(JADNative jADNative) {
        this.jad_n_er = jADNative.getActivity() != null ? jADNative.getActivity().hashCode() : -1;
    }

    public final void jad_n_an() {
        if (this.jad_n_jt != 1) {
            return;
        }
        jad_n_an(2);
        int i10 = this.jad_n_an;
        if (i10 < 1 || i10 > 30) {
            this.jad_n_an = 5;
        }
        this.jad_n_fs.post(this.jad_n_iv);
        if (this.jad_n_dq == null || -1 == this.jad_n_er) {
            return;
        }
        Logger.d("Native ad time registerLifeCycle");
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.jad_n_jw;
        if (activityLifecycleCallbacks != null) {
            this.jad_n_dq.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.jad_n_dq.registerActivityLifecycleCallbacks(this.jad_n_jw);
        }
    }

    public void jad_n_bo() {
        StringBuilder a10 = a.a("Native ad time stopCount=counterState=");
        a10.append(com.jd.ad.sdk.jad_n_an.jad_n_cp.jad_n_an(this.jad_n_jt));
        Logger.d(a10.toString());
        if (this.jad_n_jt == 4) {
            return;
        }
        jad_n_an(4);
        this.jad_n_an = 0;
        this.jad_n_fs.removeCallbacksAndMessages(null);
        if (this.jad_n_dq == null) {
            return;
        }
        Logger.d("Native ad time unRegisterLifeCycle");
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.jad_n_jw;
        if (activityLifecycleCallbacks != null) {
            this.jad_n_dq.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    public final void jad_n_an(@NonNull int i10) {
        StringBuilder a10 = a.a("Native ad counter state changed counterState= ");
        a10.append(com.jd.ad.sdk.jad_n_an.jad_n_cp.jad_n_an(this.jad_n_jt));
        a10.append(",now=");
        a10.append(com.jd.ad.sdk.jad_n_an.jad_n_cp.jad_n_an(i10));
        Logger.d(a10.toString());
        this.jad_n_jt = i10;
    }
}
