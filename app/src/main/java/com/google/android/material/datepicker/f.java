package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.util.Pair;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface f<S> extends Parcelable {
    @StringRes
    int a0();

    @StyleRes
    int b0(Context context);

    @NonNull
    String c0(Context context);

    @NonNull
    Collection<Pair<Long, Long>> d0();

    void e0(@NonNull S s);

    @NonNull
    View f0(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, @NonNull a aVar, @NonNull q<S> qVar);

    boolean g0();

    @NonNull
    Collection<Long> h0();

    @Nullable
    S i0();

    void j0(long j2);
}
