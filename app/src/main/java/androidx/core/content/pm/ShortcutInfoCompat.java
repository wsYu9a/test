package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.LocusId;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s.f;
import s.k;
import s.l;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {
    private static final String EXTRA_LOCUS_ID = "extraLocusId";
    private static final String EXTRA_LONG_LIVED = "extraLongLived";
    private static final String EXTRA_PERSON_ = "extraPerson_";
    private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
    private static final String EXTRA_SLICE_URI = "extraSliceUri";
    public static final int SURFACE_LAUNCHER = 1;
    ComponentName mActivity;
    Set<String> mCategories;
    Context mContext;
    CharSequence mDisabledMessage;
    int mDisabledReason;
    int mExcludedSurfaces;
    PersistableBundle mExtras;
    boolean mHasKeyFieldsOnly;
    IconCompat mIcon;
    String mId;
    Intent[] mIntents;
    boolean mIsAlwaysBadged;
    boolean mIsCached;
    boolean mIsDeclaredInManifest;
    boolean mIsDynamic;
    boolean mIsEnabled = true;
    boolean mIsImmutable;
    boolean mIsLongLived;
    boolean mIsPinned;
    CharSequence mLabel;
    long mLastChangedTimestamp;

    @Nullable
    LocusIdCompat mLocusId;
    CharSequence mLongLabel;
    String mPackageName;
    Person[] mPersons;
    int mRank;
    Bundle mTransientExtras;
    UserHandle mUser;

    public static class Builder {
        private Map<String, Map<String, List<String>>> mCapabilityBindingParams;
        private Set<String> mCapabilityBindings;
        private final ShortcutInfoCompat mInfo;
        private boolean mIsConversation;
        private Uri mSliceUri;

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            shortcutInfoCompat.mId = str;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String str) {
            if (this.mCapabilityBindings == null) {
                this.mCapabilityBindings = new HashSet();
            }
            this.mCapabilityBindings.add(str);
            return this;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.mInfo.mLabel)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            ShortcutInfoCompat shortcutInfoCompat = this.mInfo;
            Intent[] intentArr = shortcutInfoCompat.mIntents;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.mIsConversation) {
                if (shortcutInfoCompat.mLocusId == null) {
                    shortcutInfoCompat.mLocusId = new LocusIdCompat(shortcutInfoCompat.mId);
                }
                this.mInfo.mIsLongLived = true;
            }
            if (this.mCapabilityBindings != null) {
                ShortcutInfoCompat shortcutInfoCompat2 = this.mInfo;
                if (shortcutInfoCompat2.mCategories == null) {
                    shortcutInfoCompat2.mCategories = new HashSet();
                }
                this.mInfo.mCategories.addAll(this.mCapabilityBindings);
            }
            if (this.mCapabilityBindingParams != null) {
                ShortcutInfoCompat shortcutInfoCompat3 = this.mInfo;
                if (shortcutInfoCompat3.mExtras == null) {
                    shortcutInfoCompat3.mExtras = new PersistableBundle();
                }
                for (String str : this.mCapabilityBindingParams.keySet()) {
                    Map<String, List<String>> map = this.mCapabilityBindingParams.get(str);
                    this.mInfo.mExtras.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List<String> list = map.get(str2);
                        this.mInfo.mExtras.putStringArray(str + "/" + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.mSliceUri != null) {
                ShortcutInfoCompat shortcutInfoCompat4 = this.mInfo;
                if (shortcutInfoCompat4.mExtras == null) {
                    shortcutInfoCompat4.mExtras = new PersistableBundle();
                }
                this.mInfo.mExtras.putString(ShortcutInfoCompat.EXTRA_SLICE_URI, UriCompat.toSafeString(this.mSliceUri));
            }
            return this.mInfo;
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            this.mInfo.mActivity = componentName;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.mInfo.mIsAlwaysBadged = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            this.mInfo.mCategories = set;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            this.mInfo.mDisabledMessage = charSequence;
            return this;
        }

        @NonNull
        public Builder setExcludedFromSurfaces(int i10) {
            this.mInfo.mExcludedSurfaces = i10;
            return this;
        }

        @NonNull
        public Builder setExtras(@NonNull PersistableBundle persistableBundle) {
            this.mInfo.mExtras = persistableBundle;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            this.mInfo.mIcon = iconCompat;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            this.mInfo.mIntents = intentArr;
            return this;
        }

        @NonNull
        public Builder setIsConversation() {
            this.mIsConversation = true;
            return this;
        }

        @NonNull
        public Builder setLocusId(@Nullable LocusIdCompat locusIdCompat) {
            this.mInfo.mLocusId = locusIdCompat;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            this.mInfo.mLongLabel = charSequence;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.mInfo.mIsLongLived = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            return setPersons(new Person[]{person});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            this.mInfo.mPersons = personArr;
            return this;
        }

        @NonNull
        public Builder setRank(int i10) {
            this.mInfo.mRank = i10;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            this.mInfo.mLabel = charSequence;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder setSliceUri(@NonNull Uri uri) {
            this.mSliceUri = uri;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder setTransientExtras(@NonNull Bundle bundle) {
            this.mInfo.mTransientExtras = (Bundle) Preconditions.checkNotNull(bundle);
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean z10) {
            this.mInfo.mIsLongLived = z10;
            return this;
        }

        @NonNull
        @SuppressLint({"MissingGetterMatchingBuilder"})
        public Builder addCapabilityBinding(@NonNull String str, @NonNull String str2, @NonNull List<String> list) {
            addCapabilityBinding(str);
            if (!list.isEmpty()) {
                if (this.mCapabilityBindingParams == null) {
                    this.mCapabilityBindingParams = new HashMap();
                }
                if (this.mCapabilityBindingParams.get(str) == null) {
                    this.mCapabilityBindingParams.put(str, new HashMap());
                }
                this.mCapabilityBindingParams.get(str).put(str2, list);
            }
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat2;
            shortcutInfoCompat2.mContext = shortcutInfoCompat.mContext;
            shortcutInfoCompat2.mId = shortcutInfoCompat.mId;
            shortcutInfoCompat2.mPackageName = shortcutInfoCompat.mPackageName;
            Intent[] intentArr = shortcutInfoCompat.mIntents;
            shortcutInfoCompat2.mIntents = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.mActivity = shortcutInfoCompat.mActivity;
            shortcutInfoCompat2.mLabel = shortcutInfoCompat.mLabel;
            shortcutInfoCompat2.mLongLabel = shortcutInfoCompat.mLongLabel;
            shortcutInfoCompat2.mDisabledMessage = shortcutInfoCompat.mDisabledMessage;
            shortcutInfoCompat2.mDisabledReason = shortcutInfoCompat.mDisabledReason;
            shortcutInfoCompat2.mIcon = shortcutInfoCompat.mIcon;
            shortcutInfoCompat2.mIsAlwaysBadged = shortcutInfoCompat.mIsAlwaysBadged;
            shortcutInfoCompat2.mUser = shortcutInfoCompat.mUser;
            shortcutInfoCompat2.mLastChangedTimestamp = shortcutInfoCompat.mLastChangedTimestamp;
            shortcutInfoCompat2.mIsCached = shortcutInfoCompat.mIsCached;
            shortcutInfoCompat2.mIsDynamic = shortcutInfoCompat.mIsDynamic;
            shortcutInfoCompat2.mIsPinned = shortcutInfoCompat.mIsPinned;
            shortcutInfoCompat2.mIsDeclaredInManifest = shortcutInfoCompat.mIsDeclaredInManifest;
            shortcutInfoCompat2.mIsImmutable = shortcutInfoCompat.mIsImmutable;
            shortcutInfoCompat2.mIsEnabled = shortcutInfoCompat.mIsEnabled;
            shortcutInfoCompat2.mLocusId = shortcutInfoCompat.mLocusId;
            shortcutInfoCompat2.mIsLongLived = shortcutInfoCompat.mIsLongLived;
            shortcutInfoCompat2.mHasKeyFieldsOnly = shortcutInfoCompat.mHasKeyFieldsOnly;
            shortcutInfoCompat2.mRank = shortcutInfoCompat.mRank;
            Person[] personArr = shortcutInfoCompat.mPersons;
            if (personArr != null) {
                shortcutInfoCompat2.mPersons = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.mCategories != null) {
                shortcutInfoCompat2.mCategories = new HashSet(shortcutInfoCompat.mCategories);
            }
            PersistableBundle persistableBundle = shortcutInfoCompat.mExtras;
            if (persistableBundle != null) {
                shortcutInfoCompat2.mExtras = persistableBundle;
            }
            shortcutInfoCompat2.mExcludedSurfaces = shortcutInfoCompat.mExcludedSurfaces;
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            String id2;
            String str;
            Intent[] intents;
            ComponentName activity;
            CharSequence shortLabel;
            CharSequence longLabel;
            CharSequence disabledMessage;
            boolean isEnabled;
            Set<String> categories;
            PersistableBundle extras;
            UserHandle userHandle;
            long lastChangedTimestamp;
            boolean isDynamic;
            boolean isPinned;
            boolean isDeclaredInManifest;
            boolean isImmutable;
            boolean isEnabled2;
            boolean hasKeyFieldsOnly;
            int rank;
            PersistableBundle extras2;
            boolean isCached;
            int disabledReason;
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.mInfo = shortcutInfoCompat;
            shortcutInfoCompat.mContext = context;
            id2 = shortcutInfo.getId();
            shortcutInfoCompat.mId = id2;
            str = shortcutInfo.getPackage();
            shortcutInfoCompat.mPackageName = str;
            intents = shortcutInfo.getIntents();
            shortcutInfoCompat.mIntents = (Intent[]) Arrays.copyOf(intents, intents.length);
            activity = shortcutInfo.getActivity();
            shortcutInfoCompat.mActivity = activity;
            shortLabel = shortcutInfo.getShortLabel();
            shortcutInfoCompat.mLabel = shortLabel;
            longLabel = shortcutInfo.getLongLabel();
            shortcutInfoCompat.mLongLabel = longLabel;
            disabledMessage = shortcutInfo.getDisabledMessage();
            shortcutInfoCompat.mDisabledMessage = disabledMessage;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                disabledReason = shortcutInfo.getDisabledReason();
                shortcutInfoCompat.mDisabledReason = disabledReason;
            } else {
                isEnabled = shortcutInfo.isEnabled();
                shortcutInfoCompat.mDisabledReason = isEnabled ? 0 : 3;
            }
            categories = shortcutInfo.getCategories();
            shortcutInfoCompat.mCategories = categories;
            extras = shortcutInfo.getExtras();
            shortcutInfoCompat.mPersons = ShortcutInfoCompat.getPersonsFromExtra(extras);
            userHandle = shortcutInfo.getUserHandle();
            shortcutInfoCompat.mUser = userHandle;
            lastChangedTimestamp = shortcutInfo.getLastChangedTimestamp();
            shortcutInfoCompat.mLastChangedTimestamp = lastChangedTimestamp;
            if (i10 >= 30) {
                isCached = shortcutInfo.isCached();
                shortcutInfoCompat.mIsCached = isCached;
            }
            isDynamic = shortcutInfo.isDynamic();
            shortcutInfoCompat.mIsDynamic = isDynamic;
            isPinned = shortcutInfo.isPinned();
            shortcutInfoCompat.mIsPinned = isPinned;
            isDeclaredInManifest = shortcutInfo.isDeclaredInManifest();
            shortcutInfoCompat.mIsDeclaredInManifest = isDeclaredInManifest;
            isImmutable = shortcutInfo.isImmutable();
            shortcutInfoCompat.mIsImmutable = isImmutable;
            isEnabled2 = shortcutInfo.isEnabled();
            shortcutInfoCompat.mIsEnabled = isEnabled2;
            hasKeyFieldsOnly = shortcutInfo.hasKeyFieldsOnly();
            shortcutInfoCompat.mHasKeyFieldsOnly = hasKeyFieldsOnly;
            shortcutInfoCompat.mLocusId = ShortcutInfoCompat.getLocusId(shortcutInfo);
            rank = shortcutInfo.getRank();
            shortcutInfoCompat.mRank = rank;
            extras2 = shortcutInfo.getExtras();
            shortcutInfoCompat.mExtras = extras2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Surface {
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle buildLegacyExtrasBundle() {
        if (this.mExtras == null) {
            this.mExtras = new PersistableBundle();
        }
        Person[] personArr = this.mPersons;
        if (personArr != null && personArr.length > 0) {
            this.mExtras.putInt(EXTRA_PERSON_COUNT, personArr.length);
            int i10 = 0;
            while (i10 < this.mPersons.length) {
                PersistableBundle persistableBundle = this.mExtras;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(EXTRA_PERSON_);
                int i11 = i10 + 1;
                sb2.append(i11);
                persistableBundle.putPersistableBundle(sb2.toString(), this.mPersons[i10].toPersistableBundle());
                i10 = i11;
            }
        }
        LocusIdCompat locusIdCompat = this.mLocusId;
        if (locusIdCompat != null) {
            this.mExtras.putString(EXTRA_LOCUS_ID, locusIdCompat.getId());
        }
        this.mExtras.putBoolean(EXTRA_LONG_LIVED, this.mIsLongLived);
        return this.mExtras;
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static List<ShortcutInfoCompat> fromShortcuts(@NonNull Context context, @NonNull List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Builder(context, f.a(it.next())).build());
        }
        return arrayList;
    }

    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private static LocusIdCompat getLocusIdFromExtra(@Nullable PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(EXTRA_LOCUS_ID)) == null) {
            return null;
        }
        return new LocusIdCompat(string);
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    public static boolean getLongLivedFromExtra(@Nullable PersistableBundle persistableBundle) {
        boolean z10;
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_LONG_LIVED)) {
            return false;
        }
        z10 = persistableBundle.getBoolean(EXTRA_LONG_LIVED);
        return z10;
    }

    @VisibleForTesting
    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person[] getPersonsFromExtra(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(EXTRA_PERSON_COUNT)) {
            return null;
        }
        int i10 = persistableBundle.getInt(EXTRA_PERSON_COUNT);
        Person[] personArr = new Person[i10];
        int i11 = 0;
        while (i11 < i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(EXTRA_PERSON_);
            int i12 = i11 + 1;
            sb2.append(i12);
            personArr[i11] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb2.toString()));
            i11 = i12;
        }
        return personArr;
    }

    public Intent addToIntent(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
        if (this.mIcon != null) {
            Drawable drawable = null;
            if (this.mIsAlwaysBadged) {
                PackageManager packageManager = this.mContext.getPackageManager();
                ComponentName componentName = this.mActivity;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.mContext.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.mIcon.addToShortcutIntent(intent, drawable, this.mContext);
        }
        return intent;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.mActivity;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.mCategories;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.mDisabledMessage;
    }

    public int getDisabledReason() {
        return this.mDisabledReason;
    }

    public int getExcludedFromSurfaces() {
        return this.mExcludedSurfaces;
    }

    @Nullable
    public PersistableBundle getExtras() {
        return this.mExtras;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    @NonNull
    public Intent getIntent() {
        return this.mIntents[r0.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] intentArr = this.mIntents;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long getLastChangedTimestamp() {
        return this.mLastChangedTimestamp;
    }

    @Nullable
    public LocusIdCompat getLocusId() {
        return this.mLocusId;
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.mLongLabel;
    }

    @NonNull
    public String getPackage() {
        return this.mPackageName;
    }

    public int getRank() {
        return this.mRank;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.mLabel;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle getTransientExtras() {
        return this.mTransientExtras;
    }

    @Nullable
    public UserHandle getUserHandle() {
        return this.mUser;
    }

    public boolean hasKeyFieldsOnly() {
        return this.mHasKeyFieldsOnly;
    }

    public boolean isCached() {
        return this.mIsCached;
    }

    public boolean isDeclaredInManifest() {
        return this.mIsDeclaredInManifest;
    }

    public boolean isDynamic() {
        return this.mIsDynamic;
    }

    public boolean isEnabled() {
        return this.mIsEnabled;
    }

    public boolean isExcludedFromSurfaces(int i10) {
        return (i10 & this.mExcludedSurfaces) != 0;
    }

    public boolean isImmutable() {
        return this.mIsImmutable;
    }

    public boolean isPinned() {
        return this.mIsPinned;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder shortLabel;
        ShortcutInfo.Builder intents;
        ShortcutInfo build;
        l.a();
        shortLabel = k.a(this.mContext, this.mId).setShortLabel(this.mLabel);
        intents = shortLabel.setIntents(this.mIntents);
        IconCompat iconCompat = this.mIcon;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.mContext));
        }
        if (!TextUtils.isEmpty(this.mLongLabel)) {
            intents.setLongLabel(this.mLongLabel);
        }
        if (!TextUtils.isEmpty(this.mDisabledMessage)) {
            intents.setDisabledMessage(this.mDisabledMessage);
        }
        ComponentName componentName = this.mActivity;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.mCategories;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.mRank);
        PersistableBundle persistableBundle = this.mExtras;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.mPersons;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i10 = 0; i10 < length; i10++) {
                    personArr2[i10] = this.mPersons[i10].toAndroidPerson();
                }
                intents.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.mLocusId;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.toLocusId());
            }
            intents.setLongLived(this.mIsLongLived);
        } else {
            intents.setExtras(buildLegacyExtrasBundle());
        }
        build = intents.build();
        return build;
    }

    @Nullable
    @RequiresApi(25)
    public static LocusIdCompat getLocusId(@NonNull ShortcutInfo shortcutInfo) {
        PersistableBundle extras;
        LocusId locusId;
        LocusId locusId2;
        if (Build.VERSION.SDK_INT < 29) {
            extras = shortcutInfo.getExtras();
            return getLocusIdFromExtra(extras);
        }
        locusId = shortcutInfo.getLocusId();
        if (locusId == null) {
            return null;
        }
        locusId2 = shortcutInfo.getLocusId();
        return LocusIdCompat.toLocusIdCompat(locusId2);
    }
}
