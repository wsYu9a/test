package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {

    /* renamed from: a */
    private final String f1836a;

    /* renamed from: b */
    private final String f1837b;

    /* renamed from: c */
    private final String f1838c;

    /* renamed from: d */
    private final List<List<byte[]>> f1839d;

    /* renamed from: e */
    private final int f1840e;

    /* renamed from: f */
    private final String f1841f;

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.f1836a = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.f1837b = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.f1838c = str6;
        this.f1839d = (List) Preconditions.checkNotNull(list);
        this.f1840e = 0;
        this.f1841f = str4 + "-" + str5 + "-" + str6;
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.f1839d;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.f1840e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String getIdentifier() {
        return this.f1841f;
    }

    @NonNull
    public String getProviderAuthority() {
        return this.f1836a;
    }

    @NonNull
    public String getProviderPackage() {
        return this.f1837b;
    }

    @NonNull
    public String getQuery() {
        return this.f1838c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f1836a + ", mProviderPackage: " + this.f1837b + ", mQuery: " + this.f1838c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f1839d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f1839d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f1840e);
        return sb.toString();
    }

    public FontRequest(@NonNull String str, @NonNull String str2, @NonNull String str3, @ArrayRes int i2) {
        String str4 = (String) Preconditions.checkNotNull(str);
        this.f1836a = str4;
        String str5 = (String) Preconditions.checkNotNull(str2);
        this.f1837b = str5;
        String str6 = (String) Preconditions.checkNotNull(str3);
        this.f1838c = str6;
        this.f1839d = null;
        Preconditions.checkArgument(i2 != 0);
        this.f1840e = i2;
        this.f1841f = str4 + "-" + str5 + "-" + str6;
    }
}
