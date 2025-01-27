package androidx.navigation.ui;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.core.app.NotificationCompat;
import androidx.customview.widget.Openable;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
abstract class AbstractAppBarOnDestinationChangedListener implements NavController.OnDestinationChangedListener {

    /* renamed from: a */
    private final Context f3054a;

    /* renamed from: b */
    private final Set<Integer> f3055b;

    /* renamed from: c */
    @Nullable
    private final WeakReference<Openable> f3056c;

    /* renamed from: d */
    private DrawerArrowDrawable f3057d;

    /* renamed from: e */
    private ValueAnimator f3058e;

    AbstractAppBarOnDestinationChangedListener(@NonNull Context context, @NonNull AppBarConfiguration appBarConfiguration) {
        this.f3054a = context;
        this.f3055b = appBarConfiguration.getTopLevelDestinations();
        Openable openableLayout = appBarConfiguration.getOpenableLayout();
        if (openableLayout != null) {
            this.f3056c = new WeakReference<>(openableLayout);
        } else {
            this.f3056c = null;
        }
    }

    private void a(boolean z) {
        boolean z2;
        if (this.f3057d == null) {
            this.f3057d = new DrawerArrowDrawable(this.f3054a);
            z2 = false;
        } else {
            z2 = true;
        }
        b(this.f3057d, z ? R.string.nav_app_bar_open_drawer_description : R.string.nav_app_bar_navigate_up_description);
        float f2 = z ? 0.0f : 1.0f;
        if (!z2) {
            this.f3057d.setProgress(f2);
            return;
        }
        float progress = this.f3057d.getProgress();
        ValueAnimator valueAnimator = this.f3058e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f3057d, NotificationCompat.CATEGORY_PROGRESS, progress, f2);
        this.f3058e = ofFloat;
        ofFloat.start();
    }

    protected abstract void b(Drawable drawable, @StringRes int i2);

    protected abstract void c(CharSequence charSequence);

    @Override // androidx.navigation.NavController.OnDestinationChangedListener
    public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
        if (navDestination instanceof FloatingWindow) {
            return;
        }
        WeakReference<Openable> weakReference = this.f3056c;
        Openable openable = weakReference != null ? weakReference.get() : null;
        if (this.f3056c != null && openable == null) {
            navController.removeOnDestinationChangedListener(this);
            return;
        }
        CharSequence label = navDestination.getLabel();
        if (label != null) {
            StringBuffer stringBuffer = new StringBuffer();
            Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(label);
            while (matcher.find()) {
                String group = matcher.group(1);
                if (bundle == null || !bundle.containsKey(group)) {
                    throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + ((Object) label));
                }
                matcher.appendReplacement(stringBuffer, "");
                stringBuffer.append(bundle.get(group).toString());
            }
            matcher.appendTail(stringBuffer);
            c(stringBuffer);
        }
        boolean d2 = NavigationUI.d(navDestination, this.f3055b);
        if (openable == null && d2) {
            b(null, 0);
        } else {
            a(openable != null && d2);
        }
    }
}
