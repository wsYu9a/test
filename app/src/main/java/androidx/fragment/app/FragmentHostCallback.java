package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.util.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class FragmentHostCallback<E> extends FragmentContainer {

    /* renamed from: a */
    @Nullable
    private final Activity f2347a;

    /* renamed from: b */
    @NonNull
    private final Context f2348b;

    /* renamed from: c */
    @NonNull
    private final Handler f2349c;

    /* renamed from: d */
    private final int f2350d;

    /* renamed from: e */
    final FragmentManagerImpl f2351e;

    public FragmentHostCallback(@NonNull Context context, @NonNull Handler handler, int i2) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i2);
    }

    @NonNull
    Handler a() {
        return this.f2349c;
    }

    @Nullable
    Activity getActivity() {
        return this.f2347a;
    }

    @NonNull
    Context getContext() {
        return this.f2348b;
    }

    void onAttachFragment(@NonNull Fragment fragment) {
    }

    public void onDump(@NonNull String str, @Nullable FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @Nullable String[] strArr) {
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int i2) {
        return null;
    }

    @Nullable
    public abstract E onGetHost();

    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        return LayoutInflater.from(this.f2348b);
    }

    public int onGetWindowAnimations() {
        return this.f2350d;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(@NonNull Fragment fragment, @NonNull String[] strArr, int i2) {
    }

    public boolean onShouldSaveFragmentState(@NonNull Fragment fragment) {
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NonNull String str) {
        return false;
    }

    public void onStartActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        onStartActivityFromFragment(fragment, intent, i2, null);
    }

    public void onStartIntentSenderFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, @Nullable Intent intent, int i3, int i4, int i5, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.startIntentSenderForResult(this.f2347a, intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void onSupportInvalidateOptionsMenu() {
    }

    FragmentHostCallback(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    public void onStartActivityFromFragment(@NonNull Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, @Nullable Bundle bundle) {
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f2348b.startActivity(intent);
    }

    FragmentHostCallback(@Nullable Activity activity, @NonNull Context context, @NonNull Handler handler, int i2) {
        this.f2351e = new FragmentManagerImpl();
        this.f2347a = activity;
        this.f2348b = (Context) Preconditions.checkNotNull(context, "context == null");
        this.f2349c = (Handler) Preconditions.checkNotNull(handler, "handler == null");
        this.f2350d = i2;
    }
}
