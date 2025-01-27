package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.IntentCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ShareCompat {
    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";

    /* renamed from: a */
    private static final String f1646a = ".sharecompat_";

    public static class IntentBuilder {

        /* renamed from: a */
        @NonNull
        private final Context f1647a;

        /* renamed from: b */
        @NonNull
        private final Intent f1648b;

        /* renamed from: c */
        @Nullable
        private CharSequence f1649c;

        /* renamed from: d */
        @Nullable
        private ArrayList<String> f1650d;

        /* renamed from: e */
        @Nullable
        private ArrayList<String> f1651e;

        /* renamed from: f */
        @Nullable
        private ArrayList<String> f1652f;

        /* renamed from: g */
        @Nullable
        private ArrayList<Uri> f1653g;

        private IntentBuilder(@NonNull Context context, @Nullable ComponentName componentName) {
            this.f1647a = (Context) Preconditions.checkNotNull(context);
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f1648b = action;
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE, context.getPackageName());
            action.putExtra(ShareCompat.EXTRA_CALLING_PACKAGE_INTEROP, context.getPackageName());
            action.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY, componentName);
            action.putExtra(ShareCompat.EXTRA_CALLING_ACTIVITY_INTEROP, componentName);
            action.addFlags(524288);
        }

        private void a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f1648b.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[arrayList.size() + length];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f1648b.putExtra(str, strArr);
        }

        private void b(@Nullable String str, @NonNull String[] strArr) {
            Intent intent = getIntent();
            String[] stringArrayExtra = intent.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr2 = new String[strArr.length + length];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr2, 0, length);
            }
            System.arraycopy(strArr, 0, strArr2, length, strArr.length);
            intent.putExtra(str, strArr2);
        }

        @NonNull
        private static IntentBuilder c(@NonNull Context context, @Nullable ComponentName componentName) {
            return new IntentBuilder(context, componentName);
        }

        @NonNull
        public static IntentBuilder from(@NonNull Activity activity) {
            return c((Context) Preconditions.checkNotNull(activity), activity.getComponentName());
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String str) {
            if (this.f1652f == null) {
                this.f1652f = new ArrayList<>();
            }
            this.f1652f.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String str) {
            if (this.f1651e == null) {
                this.f1651e = new ArrayList<>();
            }
            this.f1651e.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String str) {
            if (this.f1650d == null) {
                this.f1650d = new ArrayList<>();
            }
            this.f1650d.add(str);
            return this;
        }

        @NonNull
        public IntentBuilder addStream(@NonNull Uri uri) {
            Uri uri2 = (Uri) this.f1648b.getParcelableExtra("android.intent.extra.STREAM");
            ArrayList<Uri> arrayList = this.f1653g;
            if (arrayList == null && uri2 == null) {
                return setStream(uri);
            }
            if (arrayList == null) {
                this.f1653g = new ArrayList<>();
            }
            if (uri2 != null) {
                this.f1648b.removeExtra("android.intent.extra.STREAM");
                this.f1653g.add(uri2);
            }
            this.f1653g.add(uri);
            return this;
        }

        @NonNull
        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.f1649c);
        }

        @NonNull
        Context getContext() {
            return this.f1647a;
        }

        @NonNull
        public Intent getIntent() {
            ArrayList<String> arrayList = this.f1650d;
            if (arrayList != null) {
                a("android.intent.extra.EMAIL", arrayList);
                this.f1650d = null;
            }
            ArrayList<String> arrayList2 = this.f1651e;
            if (arrayList2 != null) {
                a("android.intent.extra.CC", arrayList2);
                this.f1651e = null;
            }
            ArrayList<String> arrayList3 = this.f1652f;
            if (arrayList3 != null) {
                a("android.intent.extra.BCC", arrayList3);
                this.f1652f = null;
            }
            ArrayList<Uri> arrayList4 = this.f1653g;
            boolean z = arrayList4 != null && arrayList4.size() > 1;
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.f1648b.getAction());
            if (!z && equals) {
                this.f1648b.setAction("android.intent.action.SEND");
                ArrayList<Uri> arrayList5 = this.f1653g;
                if (arrayList5 == null || arrayList5.isEmpty()) {
                    this.f1648b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f1648b.putExtra("android.intent.extra.STREAM", this.f1653g.get(0));
                }
                this.f1653g = null;
            }
            if (z && !equals) {
                this.f1648b.setAction("android.intent.action.SEND_MULTIPLE");
                ArrayList<Uri> arrayList6 = this.f1653g;
                if (arrayList6 == null || arrayList6.isEmpty()) {
                    this.f1648b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.f1648b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f1653g);
                }
            }
            return this.f1648b;
        }

        @NonNull
        public IntentBuilder setChooserTitle(@Nullable CharSequence charSequence) {
            this.f1649c = charSequence;
            return this;
        }

        @NonNull
        public IntentBuilder setEmailBcc(@Nullable String[] strArr) {
            this.f1648b.putExtra("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailCc(@Nullable String[] strArr) {
            this.f1648b.putExtra("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setEmailTo(@Nullable String[] strArr) {
            if (this.f1650d != null) {
                this.f1650d = null;
            }
            this.f1648b.putExtra("android.intent.extra.EMAIL", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder setHtmlText(@Nullable String str) {
            this.f1648b.putExtra(IntentCompat.EXTRA_HTML_TEXT, str);
            if (!this.f1648b.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(str));
            }
            return this;
        }

        @NonNull
        public IntentBuilder setStream(@Nullable Uri uri) {
            if (!"android.intent.action.SEND".equals(this.f1648b.getAction())) {
                this.f1648b.setAction("android.intent.action.SEND");
            }
            this.f1653g = null;
            this.f1648b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        @NonNull
        public IntentBuilder setSubject(@Nullable String str) {
            this.f1648b.putExtra("android.intent.extra.SUBJECT", str);
            return this;
        }

        @NonNull
        public IntentBuilder setText(@Nullable CharSequence charSequence) {
            this.f1648b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        @NonNull
        public IntentBuilder setType(@Nullable String str) {
            this.f1648b.setType(str);
            return this;
        }

        public void startChooser() {
            this.f1647a.startActivity(createChooserIntent());
        }

        @NonNull
        public IntentBuilder setChooserTitle(@StringRes int i2) {
            return setChooserTitle(this.f1647a.getText(i2));
        }

        @NonNull
        public IntentBuilder addEmailBcc(@NonNull String[] strArr) {
            b("android.intent.extra.BCC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailCc(@NonNull String[] strArr) {
            b("android.intent.extra.CC", strArr);
            return this;
        }

        @NonNull
        public IntentBuilder addEmailTo(@NonNull String[] strArr) {
            b("android.intent.extra.EMAIL", strArr);
            return this;
        }
    }

    public static class IntentReader {

        /* renamed from: a */
        private static final String f1654a = "IntentReader";

        /* renamed from: b */
        @NonNull
        private final Context f1655b;

        /* renamed from: c */
        @NonNull
        private final Intent f1656c;

        /* renamed from: d */
        @Nullable
        private final String f1657d;

        /* renamed from: e */
        @Nullable
        private final ComponentName f1658e;

        /* renamed from: f */
        @Nullable
        private ArrayList<Uri> f1659f;

        private IntentReader(@NonNull Context context, @NonNull Intent intent) {
            this.f1655b = (Context) Preconditions.checkNotNull(context);
            this.f1656c = (Intent) Preconditions.checkNotNull(intent);
            this.f1657d = ShareCompat.b(intent);
            this.f1658e = ShareCompat.a(intent);
        }

        @NonNull
        private static IntentReader a(@NonNull Context context, @NonNull Intent intent) {
            return new IntentReader(context, intent);
        }

        private static void b(StringBuilder sb, CharSequence charSequence, int i2, int i3) {
            while (i2 < i3) {
                char charAt = charSequence.charAt(i2);
                if (charAt == '<') {
                    sb.append("&lt;");
                } else if (charAt == '>') {
                    sb.append("&gt;");
                } else if (charAt == '&') {
                    sb.append("&amp;");
                } else if (charAt > '~' || charAt < ' ') {
                    sb.append("&#");
                    sb.append((int) charAt);
                    sb.append(";");
                } else if (charAt == ' ') {
                    while (true) {
                        int i4 = i2 + 1;
                        if (i4 >= i3 || charSequence.charAt(i4) != ' ') {
                            break;
                        }
                        sb.append("&nbsp;");
                        i2 = i4;
                    }
                    sb.append(' ');
                } else {
                    sb.append(charAt);
                }
                i2++;
            }
        }

        @NonNull
        public static IntentReader from(@NonNull Activity activity) {
            return a((Context) Preconditions.checkNotNull(activity), activity.getIntent());
        }

        @Nullable
        public ComponentName getCallingActivity() {
            return this.f1658e;
        }

        @Nullable
        public Drawable getCallingActivityIcon() {
            if (this.f1658e == null) {
                return null;
            }
            try {
                return this.f1655b.getPackageManager().getActivityIcon(this.f1658e);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(f1654a, "Could not retrieve icon for calling activity", e2);
                return null;
            }
        }

        @Nullable
        public Drawable getCallingApplicationIcon() {
            if (this.f1657d == null) {
                return null;
            }
            try {
                return this.f1655b.getPackageManager().getApplicationIcon(this.f1657d);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(f1654a, "Could not retrieve icon for calling application", e2);
                return null;
            }
        }

        @Nullable
        public CharSequence getCallingApplicationLabel() {
            if (this.f1657d == null) {
                return null;
            }
            PackageManager packageManager = this.f1655b.getPackageManager();
            try {
                return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.f1657d, 0));
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e(f1654a, "Could not retrieve label for calling application", e2);
                return null;
            }
        }

        @Nullable
        public String getCallingPackage() {
            return this.f1657d;
        }

        @Nullable
        public String[] getEmailBcc() {
            return this.f1656c.getStringArrayExtra("android.intent.extra.BCC");
        }

        @Nullable
        public String[] getEmailCc() {
            return this.f1656c.getStringArrayExtra("android.intent.extra.CC");
        }

        @Nullable
        public String[] getEmailTo() {
            return this.f1656c.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        @Nullable
        public String getHtmlText() {
            String stringExtra = this.f1656c.getStringExtra(IntentCompat.EXTRA_HTML_TEXT);
            if (stringExtra != null) {
                return stringExtra;
            }
            CharSequence text = getText();
            if (text instanceof Spanned) {
                return Html.toHtml((Spanned) text);
            }
            if (text == null) {
                return stringExtra;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                return Html.escapeHtml(text);
            }
            StringBuilder sb = new StringBuilder();
            b(sb, text, 0, text.length());
            return sb.toString();
        }

        @Nullable
        public Uri getStream() {
            return (Uri) this.f1656c.getParcelableExtra("android.intent.extra.STREAM");
        }

        public int getStreamCount() {
            if (this.f1659f == null && isMultipleShare()) {
                this.f1659f = this.f1656c.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f1659f;
            return arrayList != null ? arrayList.size() : this.f1656c.hasExtra("android.intent.extra.STREAM") ? 1 : 0;
        }

        @Nullable
        public String getSubject() {
            return this.f1656c.getStringExtra("android.intent.extra.SUBJECT");
        }

        @Nullable
        public CharSequence getText() {
            return this.f1656c.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        @Nullable
        public String getType() {
            return this.f1656c.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.f1656c.getAction());
        }

        public boolean isShareIntent() {
            String action = this.f1656c.getAction();
            return "android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action);
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.f1656c.getAction());
        }

        @Nullable
        public Uri getStream(int i2) {
            if (this.f1659f == null && isMultipleShare()) {
                this.f1659f = this.f1656c.getParcelableArrayListExtra("android.intent.extra.STREAM");
            }
            ArrayList<Uri> arrayList = this.f1659f;
            if (arrayList != null) {
                return arrayList.get(i2);
            }
            if (i2 == 0) {
                return (Uri) this.f1656c.getParcelableExtra("android.intent.extra.STREAM");
            }
            throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + i2);
        }
    }

    private ShareCompat() {
    }

    @Nullable
    static ComponentName a(@NonNull Intent intent) {
        ComponentName componentName = (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY);
        return componentName == null ? (ComponentName) intent.getParcelableExtra(EXTRA_CALLING_ACTIVITY_INTEROP) : componentName;
    }

    @Nullable
    static String b(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_CALLING_PACKAGE);
        return stringExtra == null ? intent.getStringExtra(EXTRA_CALLING_PACKAGE_INTEROP) : stringExtra;
    }

    public static void configureMenuItem(@NonNull MenuItem menuItem, @NonNull IntentBuilder intentBuilder) {
        ActionProvider actionProvider = menuItem.getActionProvider();
        ShareActionProvider shareActionProvider = !(actionProvider instanceof ShareActionProvider) ? new ShareActionProvider(intentBuilder.getContext()) : (ShareActionProvider) actionProvider;
        shareActionProvider.setShareHistoryFileName(f1646a + intentBuilder.getContext().getClass().getName());
        shareActionProvider.setShareIntent(intentBuilder.getIntent());
        menuItem.setActionProvider(shareActionProvider);
        if (Build.VERSION.SDK_INT >= 16 || menuItem.hasSubMenu()) {
            return;
        }
        menuItem.setIntent(intentBuilder.createChooserIntent());
    }

    @Nullable
    public static ComponentName getCallingActivity(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        ComponentName callingActivity = activity.getCallingActivity();
        return callingActivity == null ? a(intent) : callingActivity;
    }

    @Nullable
    public static String getCallingPackage(@NonNull Activity activity) {
        Intent intent = activity.getIntent();
        String callingPackage = activity.getCallingPackage();
        return (callingPackage != null || intent == null) ? callingPackage : b(intent);
    }

    public static void configureMenuItem(@NonNull Menu menu, @IdRes int i2, @NonNull IntentBuilder intentBuilder) {
        MenuItem findItem = menu.findItem(i2);
        if (findItem != null) {
            configureMenuItem(findItem, intentBuilder);
            return;
        }
        throw new IllegalArgumentException("Could not find menu item with id " + i2 + " in the supplied menu");
    }
}
