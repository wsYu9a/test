package u8;

import okhttp3.RequestBody;

/* loaded from: classes3.dex */
public abstract class b {
    private static final String DEFAULT_CHARSET = "UTF-8";
    protected c mProvider;

    public b(c cVar) {
        this.mProvider = cVar;
    }

    public boolean enableCookie() {
        return false;
    }

    public c getProvider() {
        return this.mProvider;
    }

    public abstract String getRequestMethod();

    public void setProvider(c cVar) {
        this.mProvider = cVar;
    }

    public String toHttpUrl(String str) {
        return getProvider().getRequestUrl(this, str);
    }

    public RequestBody toPostContent(String str) {
        return a.h(this, str);
    }

    public String toHttpUrl() {
        return getProvider().getRequestUrl(this, "UTF-8");
    }
}
