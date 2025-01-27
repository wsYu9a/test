package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class ShortcutInfoCompat {

    /* renamed from: a */
    private static final String f1677a = "extraPersonCount";

    /* renamed from: b */
    private static final String f1678b = "extraPerson_";

    /* renamed from: c */
    private static final String f1679c = "extraLongLived";

    /* renamed from: d */
    Context f1680d;

    /* renamed from: e */
    String f1681e;

    /* renamed from: f */
    Intent[] f1682f;

    /* renamed from: g */
    ComponentName f1683g;

    /* renamed from: h */
    CharSequence f1684h;

    /* renamed from: i */
    CharSequence f1685i;

    /* renamed from: j */
    CharSequence f1686j;
    IconCompat k;
    boolean l;
    Person[] m;
    Set<String> n;
    boolean o;
    int p;

    public static class Builder {

        /* renamed from: a */
        private final ShortcutInfoCompat f1687a;

        public Builder(@NonNull Context context, @NonNull String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f1687a = shortcutInfoCompat;
            shortcutInfoCompat.f1680d = context;
            shortcutInfoCompat.f1681e = str;
        }

        @NonNull
        public ShortcutInfoCompat build() {
            if (TextUtils.isEmpty(this.f1687a.f1684h)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            ShortcutInfoCompat shortcutInfoCompat = this.f1687a;
            Intent[] intentArr = shortcutInfoCompat.f1682f;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            return shortcutInfoCompat;
        }

        @NonNull
        public Builder setActivity(@NonNull ComponentName componentName) {
            this.f1687a.f1683g = componentName;
            return this;
        }

        @NonNull
        public Builder setAlwaysBadged() {
            this.f1687a.l = true;
            return this;
        }

        @NonNull
        public Builder setCategories(@NonNull Set<String> set) {
            this.f1687a.n = set;
            return this;
        }

        @NonNull
        public Builder setDisabledMessage(@NonNull CharSequence charSequence) {
            this.f1687a.f1686j = charSequence;
            return this;
        }

        @NonNull
        public Builder setIcon(IconCompat iconCompat) {
            this.f1687a.k = iconCompat;
            return this;
        }

        @NonNull
        public Builder setIntent(@NonNull Intent intent) {
            return setIntents(new Intent[]{intent});
        }

        @NonNull
        public Builder setIntents(@NonNull Intent[] intentArr) {
            this.f1687a.f1682f = intentArr;
            return this;
        }

        @NonNull
        public Builder setLongLabel(@NonNull CharSequence charSequence) {
            this.f1687a.f1685i = charSequence;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setLongLived() {
            this.f1687a.o = true;
            return this;
        }

        @NonNull
        public Builder setPerson(@NonNull Person person) {
            return setPersons(new Person[]{person});
        }

        @NonNull
        public Builder setPersons(@NonNull Person[] personArr) {
            this.f1687a.m = personArr;
            return this;
        }

        @NonNull
        public Builder setRank(int i2) {
            this.f1687a.p = i2;
            return this;
        }

        @NonNull
        public Builder setShortLabel(@NonNull CharSequence charSequence) {
            this.f1687a.f1684h = charSequence;
            return this;
        }

        @NonNull
        public Builder setLongLived(boolean z) {
            this.f1687a.o = z;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull ShortcutInfoCompat shortcutInfoCompat) {
            ShortcutInfoCompat shortcutInfoCompat2 = new ShortcutInfoCompat();
            this.f1687a = shortcutInfoCompat2;
            shortcutInfoCompat2.f1680d = shortcutInfoCompat.f1680d;
            shortcutInfoCompat2.f1681e = shortcutInfoCompat.f1681e;
            Intent[] intentArr = shortcutInfoCompat.f1682f;
            shortcutInfoCompat2.f1682f = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            shortcutInfoCompat2.f1683g = shortcutInfoCompat.f1683g;
            shortcutInfoCompat2.f1684h = shortcutInfoCompat.f1684h;
            shortcutInfoCompat2.f1685i = shortcutInfoCompat.f1685i;
            shortcutInfoCompat2.f1686j = shortcutInfoCompat.f1686j;
            shortcutInfoCompat2.k = shortcutInfoCompat.k;
            shortcutInfoCompat2.l = shortcutInfoCompat.l;
            shortcutInfoCompat2.o = shortcutInfoCompat.o;
            shortcutInfoCompat2.p = shortcutInfoCompat.p;
            Person[] personArr = shortcutInfoCompat.m;
            if (personArr != null) {
                shortcutInfoCompat2.m = (Person[]) Arrays.copyOf(personArr, personArr.length);
            }
            if (shortcutInfoCompat.n != null) {
                shortcutInfoCompat2.n = new HashSet(shortcutInfoCompat.n);
            }
        }

        @RequiresApi(25)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder(@NonNull Context context, @NonNull ShortcutInfo shortcutInfo) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.f1687a = shortcutInfoCompat;
            shortcutInfoCompat.f1680d = context;
            shortcutInfoCompat.f1681e = shortcutInfo.getId();
            Intent[] intents = shortcutInfo.getIntents();
            shortcutInfoCompat.f1682f = (Intent[]) Arrays.copyOf(intents, intents.length);
            shortcutInfoCompat.f1683g = shortcutInfo.getActivity();
            shortcutInfoCompat.f1684h = shortcutInfo.getShortLabel();
            shortcutInfoCompat.f1685i = shortcutInfo.getLongLabel();
            shortcutInfoCompat.f1686j = shortcutInfo.getDisabledMessage();
            shortcutInfoCompat.n = shortcutInfo.getCategories();
            shortcutInfoCompat.m = ShortcutInfoCompat.d(shortcutInfo.getExtras());
            shortcutInfoCompat.p = shortcutInfo.getRank();
        }
    }

    ShortcutInfoCompat() {
    }

    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    private PersistableBundle b() {
        PersistableBundle persistableBundle = new PersistableBundle();
        Person[] personArr = this.m;
        if (personArr != null && personArr.length > 0) {
            persistableBundle.putInt(f1677a, personArr.length);
            int i2 = 0;
            while (i2 < this.m.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(f1678b);
                int i3 = i2 + 1;
                sb.append(i3);
                persistableBundle.putPersistableBundle(sb.toString(), this.m[i2].toPersistableBundle());
                i2 = i3;
            }
        }
        persistableBundle.putBoolean(f1679c, this.o);
        return persistableBundle;
    }

    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @VisibleForTesting
    static boolean c(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(f1679c)) {
            return false;
        }
        return persistableBundle.getBoolean(f1679c);
    }

    @VisibleForTesting
    @Nullable
    @RequiresApi(25)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    static Person[] d(@NonNull PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(f1677a)) {
            return null;
        }
        int i2 = persistableBundle.getInt(f1677a);
        Person[] personArr = new Person[i2];
        int i3 = 0;
        while (i3 < i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(f1678b);
            int i4 = i3 + 1;
            sb.append(i4);
            personArr[i3] = Person.fromPersistableBundle(persistableBundle.getPersistableBundle(sb.toString()));
            i3 = i4;
        }
        return personArr;
    }

    Intent a(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.f1682f[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f1684h.toString());
        if (this.k != null) {
            Drawable drawable = null;
            if (this.l) {
                PackageManager packageManager = this.f1680d.getPackageManager();
                ComponentName componentName = this.f1683g;
                if (componentName != null) {
                    try {
                        drawable = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (drawable == null) {
                    drawable = this.f1680d.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.k.addToShortcutIntent(intent, drawable, this.f1680d);
        }
        return intent;
    }

    @Nullable
    public ComponentName getActivity() {
        return this.f1683g;
    }

    @Nullable
    public Set<String> getCategories() {
        return this.n;
    }

    @Nullable
    public CharSequence getDisabledMessage() {
        return this.f1686j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat getIcon() {
        return this.k;
    }

    @NonNull
    public String getId() {
        return this.f1681e;
    }

    @NonNull
    public Intent getIntent() {
        return this.f1682f[r0.length - 1];
    }

    @NonNull
    public Intent[] getIntents() {
        Intent[] intentArr = this.f1682f;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    @Nullable
    public CharSequence getLongLabel() {
        return this.f1685i;
    }

    public int getRank() {
        return this.p;
    }

    @NonNull
    public CharSequence getShortLabel() {
        return this.f1684h;
    }

    @RequiresApi(25)
    public ShortcutInfo toShortcutInfo() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f1680d, this.f1681e).setShortLabel(this.f1684h).setIntents(this.f1682f);
        IconCompat iconCompat = this.k;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.toIcon(this.f1680d));
        }
        if (!TextUtils.isEmpty(this.f1685i)) {
            intents.setLongLabel(this.f1685i);
        }
        if (!TextUtils.isEmpty(this.f1686j)) {
            intents.setDisabledMessage(this.f1686j);
        }
        ComponentName componentName = this.f1683g;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.n;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.p);
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.m;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i2 = 0; i2 < length; i2++) {
                    personArr2[i2] = this.m[i2].toAndroidPerson();
                }
                intents.setPersons(personArr2);
            }
            intents.setLongLived(this.o);
        } else {
            intents.setExtras(b());
        }
        return intents.build();
    }
}
