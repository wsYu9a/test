package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

@RequiresApi(24)
/* loaded from: classes.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {

    /* renamed from: a */
    private final LocaleList f1826a;

    LocaleListPlatformWrapper(LocaleList localeList) {
        this.f1826a = localeList;
    }

    public boolean equals(Object obj) {
        return this.f1826a.equals(((LocaleListInterface) obj).getLocaleList());
    }

    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i2) {
        return this.f1826a.get(i2);
    }

    @Override // androidx.core.os.LocaleListInterface
    @Nullable
    public Locale getFirstMatch(@NonNull String[] strArr) {
        return this.f1826a.getFirstMatch(strArr);
    }

    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.f1826a;
    }

    public int hashCode() {
        return this.f1826a.hashCode();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        return this.f1826a.indexOf(locale);
    }

    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.f1826a.isEmpty();
    }

    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.f1826a.size();
    }

    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.f1826a.toLanguageTags();
    }

    public String toString() {
        return this.f1826a.toString();
    }
}
