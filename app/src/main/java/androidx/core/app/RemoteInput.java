package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final String f1629a = "RemoteInput";

    /* renamed from: b, reason: collision with root package name */
    private static final String f1630b = "android.remoteinput.dataTypeResultsData";

    /* renamed from: c, reason: collision with root package name */
    private static final String f1631c = "android.remoteinput.resultsSource";

    /* renamed from: d, reason: collision with root package name */
    private final String f1632d;

    /* renamed from: e, reason: collision with root package name */
    private final CharSequence f1633e;

    /* renamed from: f, reason: collision with root package name */
    private final CharSequence[] f1634f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f1635g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1636h;

    /* renamed from: i, reason: collision with root package name */
    private final Bundle f1637i;

    /* renamed from: j, reason: collision with root package name */
    private final Set<String> f1638j;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final String f1639a;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f1642d;

        /* renamed from: e, reason: collision with root package name */
        private CharSequence[] f1643e;

        /* renamed from: b, reason: collision with root package name */
        private final Set<String> f1640b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        private final Bundle f1641c = new Bundle();

        /* renamed from: f, reason: collision with root package name */
        private boolean f1644f = true;

        /* renamed from: g, reason: collision with root package name */
        private int f1645g = 0;

        public Builder(@NonNull String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f1639a = str;
        }

        @NonNull
        public Builder addExtras(@NonNull Bundle bundle) {
            if (bundle != null) {
                this.f1641c.putAll(bundle);
            }
            return this;
        }

        @NonNull
        public RemoteInput build() {
            return new RemoteInput(this.f1639a, this.f1642d, this.f1643e, this.f1644f, this.f1645g, this.f1641c, this.f1640b);
        }

        @NonNull
        public Bundle getExtras() {
            return this.f1641c;
        }

        @NonNull
        public Builder setAllowDataType(@NonNull String str, boolean z) {
            if (z) {
                this.f1640b.add(str);
            } else {
                this.f1640b.remove(str);
            }
            return this;
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean z) {
            this.f1644f = z;
            return this;
        }

        @NonNull
        public Builder setChoices(@Nullable CharSequence[] charSequenceArr) {
            this.f1643e = charSequenceArr;
            return this;
        }

        @NonNull
        public Builder setEditChoicesBeforeSending(int i2) {
            this.f1645g = i2;
            return this;
        }

        @NonNull
        public Builder setLabel(@Nullable CharSequence charSequence) {
            this.f1642d = charSequence;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    RemoteInput(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, int i2, Bundle bundle, Set<String> set) {
        this.f1632d = str;
        this.f1633e = charSequence;
        this.f1634f = charSequenceArr;
        this.f1635g = z;
        this.f1636h = i2;
        this.f1637i = bundle;
        this.f1638j = set;
        if (getEditChoicesBeforeSending() == 2 && !getAllowFreeFormInput()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    @RequiresApi(20)
    static android.app.RemoteInput a(RemoteInput remoteInput) {
        RemoteInput.Builder addExtras = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras());
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(remoteInput.getEditChoicesBeforeSending());
        }
        return addExtras.build();
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map<String, Uri> map) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            android.app.RemoteInput.addDataResultToIntent(a(remoteInput), intent, map);
            return;
        }
        if (i2 >= 16) {
            Intent c2 = c(intent);
            if (c2 == null) {
                c2 = new Intent();
            }
            for (Map.Entry<String, Uri> entry : map.entrySet()) {
                String key = entry.getKey();
                Uri value = entry.getValue();
                if (key != null) {
                    Bundle bundleExtra = c2.getBundleExtra(d(key));
                    if (bundleExtra == null) {
                        bundleExtra = new Bundle();
                    }
                    bundleExtra.putString(remoteInput.getResultKey(), value.toString());
                    c2.putExtra(d(key), bundleExtra);
                }
            }
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, c2));
        }
    }

    public static void addResultsToIntent(RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            android.app.RemoteInput.addResultsToIntent(b(remoteInputArr), intent, bundle);
            return;
        }
        if (i2 >= 20) {
            Bundle resultsFromIntent = getResultsFromIntent(intent);
            int resultsSource = getResultsSource(intent);
            if (resultsFromIntent != null) {
                resultsFromIntent.putAll(bundle);
                bundle = resultsFromIntent;
            }
            for (RemoteInput remoteInput : remoteInputArr) {
                Map<String, Uri> dataResultsFromIntent = getDataResultsFromIntent(intent, remoteInput.getResultKey());
                android.app.RemoteInput.addResultsToIntent(b(new RemoteInput[]{remoteInput}), intent, bundle);
                if (dataResultsFromIntent != null) {
                    addDataResultToIntent(remoteInput, intent, dataResultsFromIntent);
                }
            }
            setResultsSource(intent, resultsSource);
            return;
        }
        if (i2 >= 16) {
            Intent c2 = c(intent);
            if (c2 == null) {
                c2 = new Intent();
            }
            Bundle bundleExtra = c2.getBundleExtra(EXTRA_RESULTS_DATA);
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            for (RemoteInput remoteInput2 : remoteInputArr) {
                Object obj = bundle.get(remoteInput2.getResultKey());
                if (obj instanceof CharSequence) {
                    bundleExtra.putCharSequence(remoteInput2.getResultKey(), (CharSequence) obj);
                }
            }
            c2.putExtra(EXTRA_RESULTS_DATA, bundleExtra);
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, c2));
        }
    }

    @RequiresApi(20)
    static android.app.RemoteInput[] b(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i2 = 0; i2 < remoteInputArr.length; i2++) {
            remoteInputArr2[i2] = a(remoteInputArr[i2]);
        }
        return remoteInputArr2;
    }

    @RequiresApi(16)
    private static Intent c(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().toString().contentEquals(RESULTS_CLIP_LABEL)) {
            return clipData.getItemAt(0).getIntent();
        }
        return null;
    }

    private static String d(String str) {
        return f1630b + str;
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String str) {
        Intent c2;
        String string;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return android.app.RemoteInput.getDataResultsFromIntent(intent, str);
        }
        if (i2 < 16 || (c2 = c(intent)) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : c2.getExtras().keySet()) {
            if (str2.startsWith(f1630b)) {
                String substring = str2.substring(39);
                if (!substring.isEmpty() && (string = c2.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                    hashMap.put(substring, Uri.parse(string));
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        Intent c2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            return android.app.RemoteInput.getResultsFromIntent(intent);
        }
        if (i2 < 16 || (c2 = c(intent)) == null) {
            return null;
        }
        return (Bundle) c2.getExtras().getParcelable(EXTRA_RESULTS_DATA);
    }

    public static int getResultsSource(@NonNull Intent intent) {
        Intent c2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return android.app.RemoteInput.getResultsSource(intent);
        }
        if (i2 < 16 || (c2 = c(intent)) == null) {
            return 0;
        }
        return c2.getExtras().getInt(f1631c, 0);
    }

    public static void setResultsSource(@NonNull Intent intent, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            android.app.RemoteInput.setResultsSource(intent, i2);
            return;
        }
        if (i3 >= 16) {
            Intent c2 = c(intent);
            if (c2 == null) {
                c2 = new Intent();
            }
            c2.putExtra(f1631c, i2);
            intent.setClipData(ClipData.newIntent(RESULTS_CLIP_LABEL, c2));
        }
    }

    public boolean getAllowFreeFormInput() {
        return this.f1635g;
    }

    public Set<String> getAllowedDataTypes() {
        return this.f1638j;
    }

    public CharSequence[] getChoices() {
        return this.f1634f;
    }

    public int getEditChoicesBeforeSending() {
        return this.f1636h;
    }

    public Bundle getExtras() {
        return this.f1637i;
    }

    public CharSequence getLabel() {
        return this.f1633e;
    }

    public String getResultKey() {
        return this.f1632d;
    }

    public boolean isDataOnly() {
        return (getAllowFreeFormInput() || (getChoices() != null && getChoices().length != 0) || getAllowedDataTypes() == null || getAllowedDataTypes().isEmpty()) ? false : true;
    }
}
