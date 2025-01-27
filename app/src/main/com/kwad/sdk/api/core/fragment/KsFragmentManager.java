package com.kwad.sdk.api.core.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@KsAdSdkDynamicApi
@Keep
/* loaded from: classes3.dex */
public class KsFragmentManager {

    @Keep
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    private final FragmentManager mBase;

    @KsAdSdkDynamicApi
    @Keep
    public static abstract class FragmentLifecycleCallbacks {
        private FragmentManager.FragmentLifecycleCallbacks mBase;

        @Keep
        public FragmentLifecycleCallbacks() {
        }

        @Keep
        public FragmentManager.FragmentLifecycleCallbacks getBase() {
            return this.mBase;
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentActivityCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentDetached(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentPaused(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentPreAttached(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Context context) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentPreCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentResumed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentSaveInstanceState(KsFragmentManager ksFragmentManager, KsFragment ksFragment, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentStarted(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentStopped(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentViewCreated(KsFragmentManager ksFragmentManager, KsFragment ksFragment, View view, Bundle bundle) {
        }

        @KsAdSdkDynamicApi
        @Keep
        public void onFragmentViewDestroyed(KsFragmentManager ksFragmentManager, KsFragment ksFragment) {
        }

        @Keep
        public void setBase(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
            this.mBase = fragmentLifecycleCallbacks;
        }
    }

    @Keep
    public KsFragmentManager(FragmentManager fragmentManager) {
        this.mBase = fragmentManager;
    }

    @KsAdSdkDynamicApi
    @Keep
    public static void enableDebugLogging(boolean z10) {
        while (true) {
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentTransaction beginTransaction() {
        return new KsFragmentTransaction(this.mBase.beginTransaction());
    }

    @KsAdSdkDynamicApi
    @Keep
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mBase.dump(str, fileDescriptor, printWriter, strArr);
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean executePendingTransactions() {
        return this.mBase.executePendingTransactions();
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment findFragmentById(int i10) {
        Object findFragmentById = this.mBase.findFragmentById(i10);
        if (findFragmentById instanceof IDelegateFragment) {
            return ((IDelegateFragment) findFragmentById).getBase();
        }
        if (findFragmentById == null) {
            return null;
        }
        throw new RuntimeException(findFragmentById + " is not a DelegateFragment");
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment findFragmentByTag(String str) {
        Object findFragmentByTag = this.mBase.findFragmentByTag(str);
        if (findFragmentByTag instanceof IDelegateFragment) {
            return ((IDelegateFragment) findFragmentByTag).getBase();
        }
        if (findFragmentByTag == null) {
            return null;
        }
        throw new RuntimeException(findFragmentByTag + " is not a DelegateFragment");
    }

    @KsAdSdkDynamicApi
    @Keep
    public int getBackStackEntryCount() {
        return this.mBase.getBackStackEntryCount();
    }

    @Keep
    public FragmentManager getBase() {
        return this.mBase;
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment getFragment(Bundle bundle, String str) {
        Object fragment = this.mBase.getFragment(bundle, str);
        if (fragment instanceof IDelegateFragment) {
            return ((IDelegateFragment) fragment).getBase();
        }
        if (fragment == null) {
            return null;
        }
        throw new RuntimeException(fragment + " is not a DelegateFragment or DelegateDialogFragment");
    }

    @KsAdSdkDynamicApi
    @Keep
    public List<KsFragment> getFragments() {
        List<Fragment> fragments = this.mBase.getFragments();
        ArrayList arrayList = new ArrayList(fragments.size());
        for (Fragment fragment : fragments) {
            if (!(fragment instanceof IDelegateFragment)) {
                throw new RuntimeException(fragment + " is not a DelegateFragment");
            }
            arrayList.add(((IDelegateFragment) fragment).getBase());
        }
        return arrayList;
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isDestroyed() {
        return this.mBase.isDestroyed();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean isStateSaved() {
        return this.mBase.isStateSaved();
    }

    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public KsFragmentTransaction openTransaction() {
        return new KsFragmentTransaction(this.mBase.beginTransaction());
    }

    @KsAdSdkDynamicApi
    @Keep
    public void popBackStack() {
        this.mBase.popBackStack();
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean popBackStackImmediate() {
        return this.mBase.popBackStackImmediate();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void putFragment(Bundle bundle, String str, KsFragment ksFragment) {
        this.mBase.putFragment(bundle, str, ksFragment.getBase());
    }

    @KsAdSdkDynamicApi
    @Keep
    public void registerFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z10) {
        fragmentLifecycleCallbacks.setBase(new DelegateFragmentLifecycleCallbacks(this, fragmentLifecycleCallbacks));
        this.mBase.registerFragmentLifecycleCallbacks(fragmentLifecycleCallbacks.getBase(), z10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public KsSavedState saveFragmentInstanceState(KsFragment ksFragment) {
        return new KsSavedState(this.mBase.saveFragmentInstanceState(ksFragment.getBase()));
    }

    @KsAdSdkDynamicApi
    @Keep
    public void unregisterFragmentLifecycleCallbacks(FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        this.mBase.unregisterFragmentLifecycleCallbacks(fragmentLifecycleCallbacks.getBase());
    }

    @KsAdSdkDynamicApi
    @Keep
    public void popBackStack(String str, int i10) {
        this.mBase.popBackStack(str, i10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean popBackStackImmediate(String str, int i10) {
        return this.mBase.popBackStackImmediate(str, i10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void popBackStack(int i10, int i11) {
        this.mBase.popBackStack(i10, i11);
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean popBackStackImmediate(int i10, int i11) {
        return this.mBase.popBackStackImmediate(i10, i11);
    }
}
