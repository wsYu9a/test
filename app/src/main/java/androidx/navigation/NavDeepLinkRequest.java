package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class NavDeepLinkRequest {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f2997a;

    /* renamed from: b, reason: collision with root package name */
    private final String f2998b;

    /* renamed from: c, reason: collision with root package name */
    private final String f2999c;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Uri f3000a;

        /* renamed from: b, reason: collision with root package name */
        private String f3001b;

        /* renamed from: c, reason: collision with root package name */
        private String f3002c;

        private Builder() {
        }

        @NonNull
        public static Builder fromAction(@NonNull String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
            }
            Builder builder = new Builder();
            builder.setAction(str);
            return builder;
        }

        @NonNull
        public static Builder fromMimeType(@NonNull String str) {
            Builder builder = new Builder();
            builder.setMimeType(str);
            return builder;
        }

        @NonNull
        public static Builder fromUri(@NonNull Uri uri) {
            Builder builder = new Builder();
            builder.setUri(uri);
            return builder;
        }

        @NonNull
        public NavDeepLinkRequest build() {
            return new NavDeepLinkRequest(this.f3000a, this.f3001b, this.f3002c);
        }

        @NonNull
        public Builder setAction(@NonNull String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLinkRequest cannot have an empty action.");
            }
            this.f3001b = str;
            return this;
        }

        @NonNull
        public Builder setMimeType(@NonNull String str) {
            if (Pattern.compile("^[-\\w*.]+/[-\\w+*.]+$").matcher(str).matches()) {
                this.f3002c = str;
                return this;
            }
            throw new IllegalArgumentException("The given mimeType " + str + " does not match to required \"type/subtype\" format");
        }

        @NonNull
        public Builder setUri(@NonNull Uri uri) {
            this.f3000a = uri;
            return this;
        }
    }

    NavDeepLinkRequest(@NonNull Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    @Nullable
    public String getAction() {
        return this.f2998b;
    }

    @Nullable
    public String getMimeType() {
        return this.f2999c;
    }

    @Nullable
    public Uri getUri() {
        return this.f2997a;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.f2997a != null) {
            sb.append(" uri=");
            sb.append(this.f2997a.toString());
        }
        if (this.f2998b != null) {
            sb.append(" action=");
            sb.append(this.f2998b);
        }
        if (this.f2999c != null) {
            sb.append(" mimetype=");
            sb.append(this.f2999c);
        }
        sb.append(" }");
        return sb.toString();
    }

    NavDeepLinkRequest(@Nullable Uri uri, @Nullable String str, @Nullable String str2) {
        this.f2997a = uri;
        this.f2998b = str;
        this.f2999c = str2;
    }
}
