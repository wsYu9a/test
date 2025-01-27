package androidx.core.app;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
public class Person {

    /* renamed from: a */
    private static final String f1613a = "name";

    /* renamed from: b */
    private static final String f1614b = "icon";

    /* renamed from: c */
    private static final String f1615c = "uri";

    /* renamed from: d */
    private static final String f1616d = "key";

    /* renamed from: e */
    private static final String f1617e = "isBot";

    /* renamed from: f */
    private static final String f1618f = "isImportant";

    /* renamed from: g */
    @Nullable
    CharSequence f1619g;

    /* renamed from: h */
    @Nullable
    IconCompat f1620h;

    /* renamed from: i */
    @Nullable
    String f1621i;

    /* renamed from: j */
    @Nullable
    String f1622j;
    boolean k;
    boolean l;

    public static class Builder {

        /* renamed from: a */
        @Nullable
        CharSequence f1623a;

        /* renamed from: b */
        @Nullable
        IconCompat f1624b;

        /* renamed from: c */
        @Nullable
        String f1625c;

        /* renamed from: d */
        @Nullable
        String f1626d;

        /* renamed from: e */
        boolean f1627e;

        /* renamed from: f */
        boolean f1628f;

        public Builder() {
        }

        @NonNull
        public Person build() {
            return new Person(this);
        }

        @NonNull
        public Builder setBot(boolean z) {
            this.f1627e = z;
            return this;
        }

        @NonNull
        public Builder setIcon(@Nullable IconCompat iconCompat) {
            this.f1624b = iconCompat;
            return this;
        }

        @NonNull
        public Builder setImportant(boolean z) {
            this.f1628f = z;
            return this;
        }

        @NonNull
        public Builder setKey(@Nullable String str) {
            this.f1626d = str;
            return this;
        }

        @NonNull
        public Builder setName(@Nullable CharSequence charSequence) {
            this.f1623a = charSequence;
            return this;
        }

        @NonNull
        public Builder setUri(@Nullable String str) {
            this.f1625c = str;
            return this;
        }

        Builder(Person person) {
            this.f1623a = person.f1619g;
            this.f1624b = person.f1620h;
            this.f1625c = person.f1621i;
            this.f1626d = person.f1622j;
            this.f1627e = person.k;
            this.f1628f = person.l;
        }
    }

    Person(Builder builder) {
        this.f1619g = builder.f1623a;
        this.f1620h = builder.f1624b;
        this.f1621i = builder.f1625c;
        this.f1622j = builder.f1626d;
        this.k = builder.f1627e;
        this.l = builder.f1628f;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromAndroidPerson(@NonNull android.app.Person person) {
        return new Builder().setName(person.getName()).setIcon(person.getIcon() != null ? IconCompat.createFromIcon(person.getIcon()) : null).setUri(person.getUri()).setKey(person.getKey()).setBot(person.isBot()).setImportant(person.isImportant()).build();
    }

    @NonNull
    public static Person fromBundle(@NonNull Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(f1614b);
        return new Builder().setName(bundle.getCharSequence("name")).setIcon(bundle2 != null ? IconCompat.createFromBundle(bundle2) : null).setUri(bundle.getString("uri")).setKey(bundle.getString(f1616d)).setBot(bundle.getBoolean(f1617e)).setImportant(bundle.getBoolean(f1618f)).build();
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Person fromPersistableBundle(@NonNull PersistableBundle persistableBundle) {
        return new Builder().setName(persistableBundle.getString("name")).setUri(persistableBundle.getString("uri")).setKey(persistableBundle.getString(f1616d)).setBot(persistableBundle.getBoolean(f1617e)).setImportant(persistableBundle.getBoolean(f1618f)).build();
    }

    @Nullable
    public IconCompat getIcon() {
        return this.f1620h;
    }

    @Nullable
    public String getKey() {
        return this.f1622j;
    }

    @Nullable
    public CharSequence getName() {
        return this.f1619g;
    }

    @Nullable
    public String getUri() {
        return this.f1621i;
    }

    public boolean isBot() {
        return this.k;
    }

    public boolean isImportant() {
        return this.l;
    }

    @NonNull
    @RequiresApi(28)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public android.app.Person toAndroidPerson() {
        return new Person.Builder().setName(getName()).setIcon(getIcon() != null ? getIcon().toIcon() : null).setUri(getUri()).setKey(getKey()).setBot(isBot()).setImportant(isImportant()).build();
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f1619g);
        IconCompat iconCompat = this.f1620h;
        bundle.putBundle(f1614b, iconCompat != null ? iconCompat.toBundle() : null);
        bundle.putString("uri", this.f1621i);
        bundle.putString(f1616d, this.f1622j);
        bundle.putBoolean(f1617e, this.k);
        bundle.putBoolean(f1618f, this.l);
        return bundle;
    }

    @NonNull
    @RequiresApi(22)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PersistableBundle toPersistableBundle() {
        PersistableBundle persistableBundle = new PersistableBundle();
        CharSequence charSequence = this.f1619g;
        persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
        persistableBundle.putString("uri", this.f1621i);
        persistableBundle.putString(f1616d, this.f1622j);
        persistableBundle.putBoolean(f1617e, this.k);
        persistableBundle.putBoolean(f1618f, this.l);
        return persistableBundle;
    }
}
