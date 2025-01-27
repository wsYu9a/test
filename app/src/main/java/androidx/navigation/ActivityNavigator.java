package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Navigator.Name(TTDownloadField.TT_ACTIVITY)
/* loaded from: classes.dex */
public class ActivityNavigator extends Navigator<Destination> {

    /* renamed from: a */
    private static final String f2920a = "android-support-navigation:ActivityNavigator:source";

    /* renamed from: b */
    private static final String f2921b = "android-support-navigation:ActivityNavigator:current";

    /* renamed from: c */
    private static final String f2922c = "android-support-navigation:ActivityNavigator:popEnterAnim";

    /* renamed from: d */
    private static final String f2923d = "android-support-navigation:ActivityNavigator:popExitAnim";

    /* renamed from: e */
    private static final String f2924e = "ActivityNavigator";

    /* renamed from: f */
    private Context f2925f;

    /* renamed from: g */
    private Activity f2926g;

    @NavDestination.ClassType(Activity.class)
    public static class Destination extends NavDestination {

        /* renamed from: j */
        private Intent f2927j;
        private String k;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this((Navigator<? extends Destination>) navigatorProvider.getNavigator(ActivityNavigator.class));
        }

        @Override // androidx.navigation.NavDestination
        boolean g() {
            return false;
        }

        @Nullable
        public final String getAction() {
            Intent intent = this.f2927j;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        @Nullable
        public final ComponentName getComponent() {
            Intent intent = this.f2927j;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        @Nullable
        public final Uri getData() {
            Intent intent = this.f2927j;
            if (intent == null) {
                return null;
            }
            return intent.getData();
        }

        @Nullable
        public final String getDataPattern() {
            return this.k;
        }

        @Nullable
        public final Intent getIntent() {
            return this.f2927j;
        }

        @Nullable
        public final String getTargetPackage() {
            Intent intent = this.f2927j;
            if (intent == null) {
                return null;
            }
            return intent.getPackage();
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.ActivityNavigator);
            String string = obtainAttributes.getString(R.styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace(NavInflater.APPLICATION_ID_PLACEHOLDER, context.getPackageName());
            }
            setTargetPackage(string);
            String string2 = obtainAttributes.getString(R.styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                setComponentName(new ComponentName(context, string2));
            }
            setAction(obtainAttributes.getString(R.styleable.ActivityNavigator_action));
            String string3 = obtainAttributes.getString(R.styleable.ActivityNavigator_data);
            if (string3 != null) {
                setData(Uri.parse(string3));
            }
            setDataPattern(obtainAttributes.getString(R.styleable.ActivityNavigator_dataPattern));
            obtainAttributes.recycle();
        }

        @NonNull
        public final Destination setAction(@Nullable String str) {
            if (this.f2927j == null) {
                this.f2927j = new Intent();
            }
            this.f2927j.setAction(str);
            return this;
        }

        @NonNull
        public final Destination setComponentName(@Nullable ComponentName componentName) {
            if (this.f2927j == null) {
                this.f2927j = new Intent();
            }
            this.f2927j.setComponent(componentName);
            return this;
        }

        @NonNull
        public final Destination setData(@Nullable Uri uri) {
            if (this.f2927j == null) {
                this.f2927j = new Intent();
            }
            this.f2927j.setData(uri);
            return this;
        }

        @NonNull
        public final Destination setDataPattern(@Nullable String str) {
            this.k = str;
            return this;
        }

        @NonNull
        public final Destination setIntent(@Nullable Intent intent) {
            this.f2927j = intent;
            return this;
        }

        @NonNull
        public final Destination setTargetPackage(@Nullable String str) {
            if (this.f2927j == null) {
                this.f2927j = new Intent();
            }
            this.f2927j.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        @NonNull
        public String toString() {
            ComponentName component = getComponent();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (component != null) {
                sb.append(" class=");
                sb.append(component.getClassName());
            } else {
                String action = getAction();
                if (action != null) {
                    sb.append(" action=");
                    sb.append(action);
                }
            }
            return sb.toString();
        }

        public Destination(@NonNull Navigator<? extends Destination> navigator) {
            super(navigator);
        }
    }

    public static final class Extras implements Navigator.Extras {

        /* renamed from: a */
        private final int f2928a;

        /* renamed from: b */
        private final ActivityOptionsCompat f2929b;

        public static final class Builder {

            /* renamed from: a */
            private int f2930a;

            /* renamed from: b */
            private ActivityOptionsCompat f2931b;

            @NonNull
            public Builder addFlags(int i2) {
                this.f2930a = i2 | this.f2930a;
                return this;
            }

            @NonNull
            public Extras build() {
                return new Extras(this.f2930a, this.f2931b);
            }

            @NonNull
            public Builder setActivityOptions(@NonNull ActivityOptionsCompat activityOptionsCompat) {
                this.f2931b = activityOptionsCompat;
                return this;
            }
        }

        Extras(int i2, @Nullable ActivityOptionsCompat activityOptionsCompat) {
            this.f2928a = i2;
            this.f2929b = activityOptionsCompat;
        }

        @Nullable
        public ActivityOptionsCompat getActivityOptions() {
            return this.f2929b;
        }

        public int getFlags() {
            return this.f2928a;
        }
    }

    public ActivityNavigator(@NonNull Context context) {
        this.f2925f = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f2926g = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    public static void applyPopAnimationsToPendingTransition(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(f2922c, -1);
        int intExtra2 = intent.getIntExtra(f2923d, -1);
        if (intExtra == -1 && intExtra2 == -1) {
            return;
        }
        if (intExtra == -1) {
            intExtra = 0;
        }
        if (intExtra2 == -1) {
            intExtra2 = 0;
        }
        activity.overridePendingTransition(intExtra, intExtra2);
    }

    @NonNull
    final Context getContext() {
        return this.f2925f;
    }

    @Override // androidx.navigation.Navigator
    public boolean popBackStack() {
        Activity activity = this.f2926g;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.Navigator
    @NonNull
    public Destination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    @Nullable
    public NavDestination navigate(@NonNull Destination destination, @Nullable Bundle bundle, @Nullable NavOptions navOptions, @Nullable Navigator.Extras extras) {
        Intent intent;
        int intExtra;
        if (destination.getIntent() == null) {
            throw new IllegalStateException("Destination " + destination.getId() + " does not have an Intent set.");
        }
        Intent intent2 = new Intent(destination.getIntent());
        if (bundle != null) {
            intent2.putExtras(bundle);
            String dataPattern = destination.getDataPattern();
            if (!TextUtils.isEmpty(dataPattern)) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(dataPattern);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (!bundle.containsKey(group)) {
                        throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + dataPattern);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z = extras instanceof Extras;
        if (z) {
            intent2.addFlags(((Extras) extras).getFlags());
        }
        if (!(this.f2925f instanceof Activity)) {
            intent2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        }
        if (navOptions != null && navOptions.shouldLaunchSingleTop()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.f2926g;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra(f2921b, 0)) != 0) {
            intent2.putExtra(f2920a, intExtra);
        }
        intent2.putExtra(f2921b, destination.getId());
        Resources resources = getContext().getResources();
        if (navOptions != null) {
            int popEnterAnim = navOptions.getPopEnterAnim();
            int popExitAnim = navOptions.getPopExitAnim();
            if ((popEnterAnim == -1 || !resources.getResourceTypeName(popEnterAnim).equals("animator")) && (popExitAnim == -1 || !resources.getResourceTypeName(popExitAnim).equals("animator"))) {
                intent2.putExtra(f2922c, popEnterAnim);
                intent2.putExtra(f2923d, popExitAnim);
            } else {
                Log.w(f2924e, "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(popEnterAnim) + " and popExit resource " + resources.getResourceName(popExitAnim) + "when launching " + destination);
            }
        }
        if (z) {
            ActivityOptionsCompat activityOptions = ((Extras) extras).getActivityOptions();
            if (activityOptions != null) {
                ContextCompat.startActivity(this.f2925f, intent2, activityOptions.toBundle());
            } else {
                this.f2925f.startActivity(intent2);
            }
        } else {
            this.f2925f.startActivity(intent2);
        }
        if (navOptions == null || this.f2926g == null) {
            return null;
        }
        int enterAnim = navOptions.getEnterAnim();
        int exitAnim = navOptions.getExitAnim();
        if (enterAnim == -1 && exitAnim == -1) {
            return null;
        }
        if (!resources.getResourceTypeName(enterAnim).equals("animator") && !resources.getResourceTypeName(exitAnim).equals("animator")) {
            if (enterAnim == -1) {
                enterAnim = 0;
            }
            this.f2926g.overridePendingTransition(enterAnim, exitAnim != -1 ? exitAnim : 0);
            return null;
        }
        Log.w(f2924e, "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(enterAnim) + " and exit resource " + resources.getResourceName(exitAnim) + "when launching " + destination);
        return null;
    }
}
