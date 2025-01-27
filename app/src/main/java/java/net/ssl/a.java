package java.net.ssl;

import java.security.Provider;
import java.util.List;
import java.util.Map;
import javax.net.ssl.DefaultSSLContextSpi;
import javax.net.ssl.SSLContextSpi;

/* loaded from: classes4.dex */
public final class a extends Provider.Service {

    /* renamed from: a */
    public static final /* synthetic */ int f27303a = 0;

    public a(Provider provider, String str, String str2, String str3, List<String> list, Map<String, String> map) {
        super(provider, str, str2, str3, list, map);
    }

    @Override // java.security.Provider.Service
    public final Object newInstance(Object obj) {
        Object newInstance = super.newInstance(obj);
        return newInstance instanceof SSLContextSpi ? new DefaultSSLContextSpi((SSLContextSpi) newInstance) : newInstance;
    }
}
