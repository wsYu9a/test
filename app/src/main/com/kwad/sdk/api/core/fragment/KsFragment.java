package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.kwad.sdk.api.a;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.lifecycle.KsLifecycle;
import com.kwad.sdk.api.loader.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

@KsAdSdkDynamicApi
@Keep
/* loaded from: classes3.dex */
public class KsFragment extends AbstractIFragmentLifecycle implements IFragment, IFragmentLifecycle {
    private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap<>();
    private Fragment mBase;
    private KsFragmentManager mChildFragmentManager;
    private KsFragmentManager mFragmentManager;
    private KsLifecycle mLifeCycle;

    @KsAdSdkDynamicApi
    @Keep
    public KsFragment() {
        this.mBase = new ResFragment(this);
    }

    public static KsFragment instantiate(Context context, String str, @Nullable Bundle bundle) {
        try {
            SimpleArrayMap<String, Class<?>> simpleArrayMap = sClassMap;
            Class<?> cls = simpleArrayMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                simpleArrayMap.put(str, cls);
            }
            KsFragment ksFragment = (KsFragment) cls.getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(ksFragment.getClass().getClassLoader());
                ksFragment.setArguments(bundle);
            }
            return ksFragment;
        } catch (Exception e10) {
            throw new Fragment.InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e10);
        }
    }

    private boolean isKsAdParentFragment() {
        Fragment parentFragment = this.mBase.getParentFragment();
        return parentFragment != null && (parentFragment instanceof IDelegateFragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.mBase.dump(str, fileDescriptor, printWriter, strArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public final Activity getActivity() {
        ActivityResultCaller activityResultCaller = this.mBase;
        if (activityResultCaller instanceof IDelegateFragment) {
            return ((IDelegateFragment) activityResultCaller).getActivity2();
        }
        throw new RuntimeException(this.mBase + " must be DelegateFragment or DelegateDialogFragment");
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getAllowEnterTransitionOverlap() {
        return this.mBase.getAllowEnterTransitionOverlap();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getAllowReturnTransitionOverlap() {
        return this.mBase.getAllowReturnTransitionOverlap();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final Bundle getArguments() {
        Bundle arguments = this.mBase.getArguments();
        if (arguments != null) {
            arguments.setClassLoader(Loader.get().getRealClassLoader());
        }
        return arguments;
    }

    @Keep
    public final Fragment getBase() {
        return this.mBase;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentManager getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            this.mChildFragmentManager = new KsFragmentManager(this.mBase.getChildFragmentManager());
        }
        return this.mChildFragmentManager;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    @Nullable
    public final Context getContext() {
        return this.mBase.getContext();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public Object getEnterTransition() {
        return this.mBase.getEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getExitTransition() {
        return this.mBase.getExitTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public KsFragmentManager getFragmentManager() {
        if (this.mFragmentManager == null) {
            this.mFragmentManager = new KsFragmentManager(this.mBase.getFragmentManager());
        }
        return this.mFragmentManager;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final Object getHost() {
        return this.mBase.getHost();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final int getId() {
        return this.mBase.getId();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public final LayoutInflater getLayoutInflater(@Nullable Bundle bundle) {
        return this.mBase.getLayoutInflater(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public KsLifecycle getLifecycle() {
        if (this.mLifeCycle == null) {
            this.mLifeCycle = new KsLifecycle(this.mBase.getLifecycle());
        }
        return this.mLifeCycle;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final KsFragment getParentFragment() {
        Object parentFragment = this.mBase.getParentFragment();
        if (parentFragment instanceof IDelegateFragment) {
            return ((IDelegateFragment) parentFragment).getBase();
        }
        if (parentFragment == null) {
            return null;
        }
        throw new RuntimeException(parentFragment + " is not a DelegateFragment or DelegateDialogFragment");
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final Object getReenterTransition() {
        return this.mBase.getReenterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public final Resources getResources() {
        if (a.ns.booleanValue()) {
            throw new RuntimeException("please use getContext().getResources()");
        }
        return this.mBase.getContext().getResources();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getRetainInstance() {
        return this.mBase.getRetainInstance();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getReturnTransition() {
        return this.mBase.getReturnTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getSharedElementEnterTransition() {
        return this.mBase.getSharedElementEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final Object getSharedElementReturnTransition() {
        return this.mBase.getSharedElementReturnTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public final String getString(@StringRes int i10) {
        return getResources().getString(i10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final String getTag() {
        return this.mBase.getTag();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final int getTargetRequestCode() {
        return this.mBase.getTargetRequestCode();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public final CharSequence getText(@StringRes int i10) {
        return getResources().getText(i10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean getUserVisibleHint() {
        return this.mBase.getUserVisibleHint();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @Nullable
    @KsAdSdkDynamicApi
    @Keep
    public final View getView() {
        return this.mBase.getView();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public final boolean hasOptionsMenu() {
        return this.mBase.hasOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isAdded() {
        return this.mBase.isAdded();
    }

    public boolean isAllFragmentIsHidden() {
        if (isKsAdParentFragment()) {
            KsFragment parentFragment = getParentFragment();
            return parentFragment == null ? isHidden() : isHidden() || parentFragment.isAllFragmentIsHidden();
        }
        Fragment fragment = this.mBase;
        Fragment parentFragment2 = fragment.getParentFragment();
        return parentFragment2 == null ? fragment.isHidden() : fragment.isHidden() || isAllFragmentIsHidden(parentFragment2);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isDetached() {
        return this.mBase.isDetached();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isHidden() {
        return this.mBase.isHidden();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isInLayout() {
        return this.mBase.isInLayout();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    @SuppressLint({"RestrictedApi"})
    public final boolean isMenuVisible() {
        return this.mBase.isMenuVisible();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isRemoving() {
        return this.mBase.isRemoving();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    public final boolean isResumed() {
        return this.mBase.isResumed();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isStateSaved() {
        return this.mBase.isStateSaved();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean isVisible() {
        return this.mBase.isVisible();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Deprecated
    public /* bridge */ /* synthetic */ void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttachFragment(KsFragment ksFragment) {
        super.onAttachFragment(ksFragment);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ Animation onCreateAnimation(int i10, boolean z10, int i11) {
        return super.onCreateAnimation(i10, z10, i11);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ Animator onCreateAnimator(int i10, boolean z10, int i11) {
        return super.onCreateAnimator(i10, z10, i11);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public /* bridge */ /* synthetic */ View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onDetach() {
        super.onDetach();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return this.mBase.onGetLayoutInflater(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onLowMemory() {
        super.onLowMemory();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onMultiWindowModeChanged(boolean z10) {
        super.onMultiWindowModeChanged(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPictureInPictureModeChanged(boolean z10) {
        super.onPictureInPictureModeChanged(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onResume() {
        super.onResume();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onStart() {
        super.onStart();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onStop() {
        super.onStop();
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void postponeEnterTransition() {
        this.mBase.postponeEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void registerForContextMenu(View view) {
        this.mBase.registerForContextMenu(view);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void requestPermissions(@NonNull String[] strArr, int i10) {
        this.mBase.requestPermissions(strArr, i10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setAllowEnterTransitionOverlap(boolean z10) {
        this.mBase.setAllowEnterTransitionOverlap(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setAllowReturnTransitionOverlap(boolean z10) {
        this.mBase.setAllowReturnTransitionOverlap(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setArguments(@Nullable Bundle bundle) {
        this.mBase.setArguments(bundle);
    }

    @Keep
    public void setBase(Fragment fragment) {
        this.mBase = fragment;
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setEnterTransition(@Nullable Object obj) {
        this.mBase.setEnterTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setExitTransition(@Nullable Object obj) {
        this.mBase.setExitTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setHasOptionsMenu(boolean z10) {
        this.mBase.setHasOptionsMenu(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    public void setInitialSavedState(@Nullable KsSavedState ksSavedState) {
        this.mBase.setInitialSavedState(ksSavedState.getBase());
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setMenuVisibility(boolean z10) {
        this.mBase.setMenuVisibility(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setReenterTransition(@Nullable Object obj) {
        this.mBase.setReenterTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setRetainInstance(boolean z10) {
        this.mBase.setRetainInstance(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setReturnTransition(@Nullable Object obj) {
        this.mBase.setReturnTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setSharedElementEnterTransition(@Nullable Object obj) {
        this.mBase.setSharedElementEnterTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void setSharedElementReturnTransition(@Nullable Object obj) {
        this.mBase.setSharedElementReturnTransition(obj);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public void setUserVisibleHint(boolean z10) {
        this.mBase.setUserVisibleHint(z10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final boolean shouldShowRequestPermissionRationale(@NonNull String str) {
        return this.mBase.shouldShowRequestPermissionRationale(str);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivity(Intent intent) {
        this.mBase.startActivity(intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivityForResult(Intent intent, int i10) {
        this.mBase.startActivityForResult(intent, i10);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startIntentSenderForResult(IntentSender intentSender, int i10, @Nullable Intent intent, int i11, int i12, int i13, Bundle bundle) {
        this.mBase.startIntentSenderForResult(intentSender, i10, intent, i11, i12, i13, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startPostponedEnterTransition() {
        this.mBase.startPostponedEnterTransition();
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void unregisterForContextMenu(View view) {
        this.mBase.unregisterForContextMenu(view);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public final String getString(@StringRes int i10, Object... objArr) {
        return getResources().getString(i10, objArr);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public /* bridge */ /* synthetic */ void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivity(Intent intent, @Nullable Bundle bundle) {
        this.mBase.startActivity(intent, bundle);
    }

    @Override // com.kwad.sdk.api.core.fragment.IFragment
    @KsAdSdkDynamicApi
    @Keep
    public final void startActivityForResult(Intent intent, int i10, @Nullable Bundle bundle) {
        this.mBase.startActivityForResult(intent, i10, bundle);
    }

    @Keep
    public KsFragment(Fragment fragment) {
        this.mBase = fragment;
    }

    private boolean isAllFragmentIsHidden(Fragment fragment) {
        Fragment parentFragment = fragment.getParentFragment();
        if (parentFragment == null) {
            return fragment.isHidden();
        }
        return fragment.isHidden() || isAllFragmentIsHidden(parentFragment);
    }
}
