package com.kwad.sdk.api.core.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* loaded from: classes3.dex */
abstract class DelegateDialogFragment extends DialogFragment implements IDelegateFragment {
    private IDialogFragmentLifecycle mBase;

    public DelegateDialogFragment(KsDialogFragment ksDialogFragment) {
        this.mBase = ksDialogFragment;
    }

    @Override // com.kwad.sdk.api.core.fragment.IDelegateFragment
    public Activity getActivity2() {
        return getActivity();
    }

    @Override // com.kwad.sdk.api.core.fragment.IDelegateFragment
    public KsFragment getBase() {
        return (KsFragment) this.mBase;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mBase.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.mBase.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mBase.onAttach(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof IDelegateFragment) {
            this.mBase.onAttachFragment(((IDelegateFragment) fragment).getBase());
        } else {
            if (fragment == 0) {
                this.mBase.onAttachFragment(null);
                return;
            }
            throw new RuntimeException(fragment + " is not a DelegateFragment or DelegateDialogFragment");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.mBase.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mBase.onConfigurationChanged(configuration);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        return this.mBase.onContextItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mBase.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i10, boolean z10, int i11) {
        return this.mBase.onCreateAnimation(i10, z10, i11);
    }

    @Override // androidx.fragment.app.Fragment
    public Animator onCreateAnimator(int i10, boolean z10, int i11) {
        return this.mBase.onCreateAnimator(i10, z10, i11);
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        this.mBase.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return this.mBase.onCreateDialog(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        this.mBase.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.mBase.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mBase.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        this.mBase.onDestroyOptionsMenu();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mBase.onDestroyView();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.mBase.onDetach();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.mBase.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @NonNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        return super.onGetLayoutInflater(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        this.mBase.onHiddenChanged(z10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        this.mBase.onInflate(context, attributeSet, bundle);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mBase.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z10) {
        super.onMultiWindowModeChanged(z10);
        this.mBase.onMultiWindowModeChanged(z10);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mBase.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.Fragment
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        this.mBase.onOptionsMenuClosed(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mBase.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z10) {
        super.onPictureInPictureModeChanged(z10);
        this.mBase.onPictureInPictureModeChanged(z10);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.mBase.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        this.mBase.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mBase.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mBase.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mBase.onStart();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mBase.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mBase.onViewCreated(view, bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.mBase.onViewStateRestored(bundle);
    }

    public void setBase(KsDialogFragment ksDialogFragment) {
        this.mBase = ksDialogFragment;
    }

    public void superOnCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
    }

    public Dialog superOnCreateDialog(Bundle bundle) {
        return super.onCreateDialog(bundle);
    }

    public void superOnDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mBase.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.mBase.onInflate(activity, attributeSet, bundle);
    }
}
