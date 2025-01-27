package i9;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import java.io.File;

/* loaded from: classes3.dex */
public final class a {
    @NonNull
    public static Glide a(@NonNull Context context) {
        return Glide.get(context);
    }

    @Nullable
    public static File b(@NonNull Context context) {
        return Glide.getPhotoCacheDir(context);
    }

    @Nullable
    public static File c(@NonNull Context context, @NonNull String str) {
        return Glide.getPhotoCacheDir(context, str);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void d(@NonNull Context context, @NonNull GlideBuilder glideBuilder) {
        Glide.init(context, glideBuilder);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    @Deprecated
    public static void e(Glide glide) {
        Glide.init(glide);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void f() {
        Glide.tearDown();
    }

    @NonNull
    public static d g(@NonNull Activity activity) {
        return (d) Glide.with(activity);
    }

    @NonNull
    @Deprecated
    public static d h(@NonNull Fragment fragment) {
        return (d) Glide.with(fragment);
    }

    @NonNull
    public static d i(@NonNull Context context) {
        return (d) Glide.with(context);
    }

    @NonNull
    public static d j(@NonNull View view) {
        return (d) Glide.with(view);
    }

    @NonNull
    public static d k(@NonNull androidx.fragment.app.Fragment fragment) {
        return (d) Glide.with(fragment);
    }

    @NonNull
    public static d l(@NonNull FragmentActivity fragmentActivity) {
        return (d) Glide.with(fragmentActivity);
    }
}
