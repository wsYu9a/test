package androidx.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class Navigation {

    /* renamed from: androidx.navigation.Navigation$1 */
    class AnonymousClass1 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f3049a;

        /* renamed from: b */
        final /* synthetic */ Bundle f3050b;

        AnonymousClass1(int i2, Bundle bundle) {
            i2 = i2;
            bundle = bundle;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(i2, bundle);
        }
    }

    /* renamed from: androidx.navigation.Navigation$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(NavDirections.this);
        }
    }

    private Navigation() {
    }

    @Nullable
    private static NavController a(@NonNull View view) {
        while (view != null) {
            NavController b2 = b(view);
            if (b2 != null) {
                return b2;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @Nullable
    private static NavController b(@NonNull View view) {
        Object tag = view.getTag(R.id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes int i2) {
        return createNavigateOnClickListener(i2, null);
    }

    @NonNull
    public static NavController findNavController(@NonNull Activity activity, @IdRes int i2) {
        NavController a2 = a(ActivityCompat.requireViewById(activity, i2));
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i2);
    }

    public static void setViewNavController(@NonNull View view, @Nullable NavController navController) {
        view.setTag(R.id.nav_controller_view_tag, navController);
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@IdRes int i2, @Nullable Bundle bundle) {
        return new View.OnClickListener() { // from class: androidx.navigation.Navigation.1

            /* renamed from: a */
            final /* synthetic */ int f3049a;

            /* renamed from: b */
            final /* synthetic */ Bundle f3050b;

            AnonymousClass1(int i22, Bundle bundle2) {
                i2 = i22;
                bundle = bundle2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(i2, bundle);
            }
        };
    }

    @NonNull
    public static View.OnClickListener createNavigateOnClickListener(@NonNull NavDirections navDirections) {
        return new View.OnClickListener() { // from class: androidx.navigation.Navigation.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(NavDirections.this);
            }
        };
    }

    @NonNull
    public static NavController findNavController(@NonNull View view) {
        NavController a2 = a(view);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }
}
