package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Preconditions;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentController {

    /* renamed from: a */
    private final FragmentHostCallback<?> f2345a;

    private FragmentController(FragmentHostCallback<?> fragmentHostCallback) {
        this.f2345a = fragmentHostCallback;
    }

    @NonNull
    public static FragmentController createController(@NonNull FragmentHostCallback<?> fragmentHostCallback) {
        return new FragmentController((FragmentHostCallback) Preconditions.checkNotNull(fragmentHostCallback, "callbacks == null"));
    }

    public void attachHost(@Nullable Fragment fragment) {
        FragmentHostCallback<?> fragmentHostCallback = this.f2345a;
        fragmentHostCallback.f2351e.attachController(fragmentHostCallback, fragmentHostCallback, fragment);
    }

    public void dispatchActivityCreated() {
        this.f2345a.f2351e.dispatchActivityCreated();
    }

    public void dispatchConfigurationChanged(@NonNull Configuration configuration) {
        this.f2345a.f2351e.dispatchConfigurationChanged(configuration);
    }

    public boolean dispatchContextItemSelected(@NonNull MenuItem menuItem) {
        return this.f2345a.f2351e.dispatchContextItemSelected(menuItem);
    }

    public void dispatchCreate() {
        this.f2345a.f2351e.dispatchCreate();
    }

    public boolean dispatchCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        return this.f2345a.f2351e.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    public void dispatchDestroy() {
        this.f2345a.f2351e.dispatchDestroy();
    }

    public void dispatchDestroyView() {
        this.f2345a.f2351e.dispatchDestroyView();
    }

    public void dispatchLowMemory() {
        this.f2345a.f2351e.dispatchLowMemory();
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        this.f2345a.f2351e.dispatchMultiWindowModeChanged(z);
    }

    public boolean dispatchOptionsItemSelected(@NonNull MenuItem menuItem) {
        return this.f2345a.f2351e.dispatchOptionsItemSelected(menuItem);
    }

    public void dispatchOptionsMenuClosed(@NonNull Menu menu) {
        this.f2345a.f2351e.dispatchOptionsMenuClosed(menu);
    }

    public void dispatchPause() {
        this.f2345a.f2351e.dispatchPause();
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        this.f2345a.f2351e.dispatchPictureInPictureModeChanged(z);
    }

    public boolean dispatchPrepareOptionsMenu(@NonNull Menu menu) {
        return this.f2345a.f2351e.dispatchPrepareOptionsMenu(menu);
    }

    @Deprecated
    public void dispatchReallyStop() {
    }

    public void dispatchResume() {
        this.f2345a.f2351e.dispatchResume();
    }

    public void dispatchStart() {
        this.f2345a.f2351e.dispatchStart();
    }

    public void dispatchStop() {
        this.f2345a.f2351e.dispatchStop();
    }

    @Deprecated
    public void doLoaderDestroy() {
    }

    @Deprecated
    public void doLoaderRetain() {
    }

    @Deprecated
    public void doLoaderStart() {
    }

    @Deprecated
    public void doLoaderStop(boolean z) {
    }

    @Deprecated
    public void dumpLoaders(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    public boolean execPendingActions() {
        return this.f2345a.f2351e.execPendingActions();
    }

    @Nullable
    public Fragment findFragmentByWho(@NonNull String str) {
        return this.f2345a.f2351e.findFragmentByWho(str);
    }

    @NonNull
    public List<Fragment> getActiveFragments(@SuppressLint({"UnknownNullness"}) List<Fragment> list) {
        return this.f2345a.f2351e.M();
    }

    public int getActiveFragmentsCount() {
        return this.f2345a.f2351e.L();
    }

    @NonNull
    public FragmentManager getSupportFragmentManager() {
        return this.f2345a.f2351e;
    }

    @SuppressLint({"UnknownNullness"})
    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        throw new UnsupportedOperationException("Loaders are managed separately from FragmentController, use LoaderManager.getInstance() to obtain a LoaderManager.");
    }

    public void noteStateNotSaved() {
        this.f2345a.f2351e.noteStateNotSaved();
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return this.f2345a.f2351e.onCreateView(view, str, context, attributeSet);
    }

    @Deprecated
    public void reportLoaderStart() {
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable List<Fragment> list) {
        this.f2345a.f2351e.k0(parcelable, new FragmentManagerNonConfig(list, null, null));
    }

    @Deprecated
    public void restoreLoaderNonConfig(@SuppressLint({"UnknownNullness"}) SimpleArrayMap<String, LoaderManager> simpleArrayMap) {
    }

    public void restoreSaveState(@Nullable Parcelable parcelable) {
        FragmentHostCallback<?> fragmentHostCallback = this.f2345a;
        if (!(fragmentHostCallback instanceof ViewModelStoreOwner)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        fragmentHostCallback.f2351e.l0(parcelable);
    }

    @Nullable
    @Deprecated
    public SimpleArrayMap<String, LoaderManager> retainLoaderNonConfig() {
        return null;
    }

    @Nullable
    @Deprecated
    public FragmentManagerNonConfig retainNestedNonConfig() {
        return this.f2345a.f2351e.m0();
    }

    @Nullable
    @Deprecated
    public List<Fragment> retainNonConfig() {
        FragmentManagerNonConfig m0 = this.f2345a.f2351e.m0();
        if (m0 == null || m0.b() == null) {
            return null;
        }
        return new ArrayList(m0.b());
    }

    @Nullable
    public Parcelable saveAllState() {
        return this.f2345a.f2351e.n0();
    }

    @Deprecated
    public void restoreAllState(@Nullable Parcelable parcelable, @Nullable FragmentManagerNonConfig fragmentManagerNonConfig) {
        this.f2345a.f2351e.k0(parcelable, fragmentManagerNonConfig);
    }
}
