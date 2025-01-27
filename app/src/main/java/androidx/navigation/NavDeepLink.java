package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class NavDeepLink {

    /* renamed from: a */
    private static final Pattern f2973a = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: b */
    private final ArrayList<String> f2974b;

    /* renamed from: c */
    private final Map<String, ParamQuery> f2975c;

    /* renamed from: d */
    private Pattern f2976d;

    /* renamed from: e */
    private boolean f2977e;

    /* renamed from: f */
    private boolean f2978f;

    /* renamed from: g */
    private final String f2979g;

    /* renamed from: h */
    private final String f2980h;

    /* renamed from: i */
    private Pattern f2981i;

    /* renamed from: j */
    private final String f2982j;

    public static final class Builder {

        /* renamed from: a */
        private String f2983a;

        /* renamed from: b */
        private String f2984b;

        /* renamed from: c */
        private String f2985c;

        Builder() {
        }

        @NonNull
        public static Builder fromAction(@NonNull String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
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
        public static Builder fromUriPattern(@NonNull String str) {
            Builder builder = new Builder();
            builder.setUriPattern(str);
            return builder;
        }

        @NonNull
        public NavDeepLink build() {
            return new NavDeepLink(this.f2983a, this.f2984b, this.f2985c);
        }

        @NonNull
        public Builder setAction(@NonNull String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.f2984b = str;
            return this;
        }

        @NonNull
        public Builder setMimeType(@NonNull String str) {
            this.f2985c = str;
            return this;
        }

        @NonNull
        public Builder setUriPattern(@NonNull String str) {
            this.f2983a = str;
            return this;
        }
    }

    private static class MimeType implements Comparable<MimeType> {

        /* renamed from: a */
        String f2986a;

        /* renamed from: b */
        String f2987b;

        MimeType(@NonNull String str) {
            String[] split = str.split("/", -1);
            this.f2986a = split[0];
            this.f2987b = split[1];
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull MimeType mimeType) {
            int i2 = this.f2986a.equals(mimeType.f2986a) ? 2 : 0;
            return this.f2987b.equals(mimeType.f2987b) ? i2 + 1 : i2;
        }
    }

    private static class ParamQuery {

        /* renamed from: a */
        private String f2988a;

        /* renamed from: b */
        private ArrayList<String> f2989b = new ArrayList<>();

        ParamQuery() {
        }

        void a(String str) {
            this.f2989b.add(str);
        }

        String b(int i2) {
            return this.f2989b.get(i2);
        }

        String c() {
            return this.f2988a;
        }

        void d(String str) {
            this.f2988a = str;
        }

        public int size() {
            return this.f2989b.size();
        }
    }

    NavDeepLink(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f2974b = new ArrayList<>();
        this.f2975c = new HashMap();
        this.f2976d = null;
        this.f2977e = false;
        this.f2978f = false;
        this.f2981i = null;
        this.f2979g = str;
        this.f2980h = str2;
        this.f2982j = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.f2978f = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!f2973a.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.f2978f) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, compile);
                }
                this.f2977e = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i2 = 0;
                    while (matcher2.find()) {
                        paramQuery.a(matcher2.group(1));
                        sb2.append(Pattern.quote(queryParameter.substring(i2, matcher2.start())));
                        sb2.append("(.+?)?");
                        i2 = matcher2.end();
                    }
                    if (i2 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i2)));
                    }
                    paramQuery.d(sb2.toString().replace(".*", "\\E.*\\Q"));
                    this.f2975c.put(str4, paramQuery);
                }
            } else {
                this.f2977e = a(str, sb, compile);
            }
            this.f2976d = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
            }
            MimeType mimeType = new MimeType(str3);
            this.f2981i = Pattern.compile(("^(" + mimeType.f2986a + "|[*]+)/(" + mimeType.f2987b + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
        }
    }

    private boolean a(@NonNull String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i2 = 0;
        while (matcher.find()) {
            this.f2974b.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i2, matcher.start())));
            sb.append("(.+?)");
            i2 = matcher.end();
            z = false;
        }
        if (i2 < str.length()) {
            sb.append(Pattern.quote(str.substring(i2)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    private boolean e(String str) {
        boolean z = str == null;
        String str2 = this.f2980h;
        if (z == (str2 != null)) {
            return false;
        }
        return str == null || str2.equals(str);
    }

    private boolean f(String str) {
        if ((str == null) == (this.f2982j != null)) {
            return false;
        }
        return str == null || this.f2981i.matcher(str).matches();
    }

    private boolean g(Uri uri) {
        boolean z = uri == null;
        Pattern pattern = this.f2976d;
        if (z == (pattern != null)) {
            return false;
        }
        return uri == null || pattern.matcher(uri.toString()).matches();
    }

    private boolean j(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument == null) {
            bundle.putString(str, str2);
            return false;
        }
        try {
            navArgument.getType().c(bundle, str, str2);
            return false;
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    @Nullable
    Bundle b(@NonNull Uri uri, @NonNull Map<String, NavArgument> map) {
        Matcher matcher;
        Matcher matcher2 = this.f2976d.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.f2974b.size();
        int i2 = 0;
        while (i2 < size) {
            String str = this.f2974b.get(i2);
            i2++;
            if (j(bundle, str, Uri.decode(matcher2.group(i2)), map.get(str))) {
                return null;
            }
        }
        if (this.f2978f) {
            for (String str2 : this.f2975c.keySet()) {
                ParamQuery paramQuery = this.f2975c.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    matcher = Pattern.compile(paramQuery.c()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                for (int i3 = 0; i3 < paramQuery.size(); i3++) {
                    String decode = matcher != null ? Uri.decode(matcher.group(i3 + 1)) : null;
                    String b2 = paramQuery.b(i3);
                    NavArgument navArgument = map.get(b2);
                    if (decode != null && !decode.replaceAll("[{}]", "").equals(b2) && j(bundle, b2, decode, navArgument)) {
                        return null;
                    }
                }
            }
        }
        return bundle;
    }

    int c(@NonNull String str) {
        if (this.f2982j == null || !this.f2981i.matcher(str).matches()) {
            return -1;
        }
        return new MimeType(this.f2982j).compareTo(new MimeType(str));
    }

    boolean d() {
        return this.f2977e;
    }

    @Nullable
    public String getAction() {
        return this.f2980h;
    }

    @Nullable
    public String getMimeType() {
        return this.f2982j;
    }

    @Nullable
    public String getUriPattern() {
        return this.f2979g;
    }

    boolean h(@NonNull Uri uri) {
        return i(new NavDeepLinkRequest(uri, null, null));
    }

    boolean i(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        if (g(navDeepLinkRequest.getUri()) && e(navDeepLinkRequest.getAction())) {
            return f(navDeepLinkRequest.getMimeType());
        }
        return false;
    }

    NavDeepLink(@NonNull String str) {
        this(str, null, null);
    }
}
