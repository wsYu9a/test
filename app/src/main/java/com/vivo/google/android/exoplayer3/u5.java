package com.vivo.google.android.exoplayer3;

import android.text.TextUtils;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface u5 extends DataSource {

    public static class a implements p6<String> {
        public boolean a(Object obj) {
            String lowerInvariant = Util.toLowerInvariant((String) obj);
            return (TextUtils.isEmpty(lowerInvariant) || (lowerInvariant.contains(com.baidu.mobads.sdk.internal.a.f5473b) && !lowerInvariant.contains("text/vtt")) || lowerInvariant.contains(com.baidu.mobads.sdk.internal.a.f5477f) || lowerInvariant.contains("xml")) ? false : true;
        }
    }

    public static abstract class b implements c {
        public final g defaultRequestProperties = new g();

        @Deprecated
        public final void clearAllDefaultRequestProperties() {
            this.defaultRequestProperties.a();
        }

        @Deprecated
        public final void clearDefaultRequestProperty(String str) {
            this.defaultRequestProperties.a(str);
        }

        @Override // com.vivo.google.android.exoplayer3.upstream.DataSource.Factory
        public final u5 createDataSource() {
            return createDataSourceInternal(this.defaultRequestProperties);
        }

        public abstract u5 createDataSourceInternal(g gVar);

        public final g getDefaultRequestProperties() {
            return this.defaultRequestProperties;
        }

        @Deprecated
        public final void setDefaultRequestProperty(String str, String str2) {
            this.defaultRequestProperties.a(str, str2);
        }
    }

    public interface c extends DataSource.Factory {
    }

    public static class d extends IOException {
        public d(IOException iOException, q5 q5Var, int i2) {
            super(iOException);
        }

        public d(String str, q5 q5Var, int i2) {
            super(str);
        }

        public d(String str, IOException iOException, q5 q5Var, int i2) {
            super(str, iOException);
        }
    }

    public static final class e extends d {
        public e(String str, q5 q5Var) {
            super("Invalid content type: " + str, q5Var, 1);
        }
    }

    public static final class f extends d {
        public f(int i2, Map<String, List<String>> map, q5 q5Var) {
            super("Response code: " + i2, q5Var, 1);
        }
    }

    public static final class g {

        /* renamed from: a */
        public final Map<String, String> f28137a = new HashMap();

        /* renamed from: b */
        public Map<String, String> f28138b;

        public synchronized void a() {
            this.f28138b = null;
            this.f28137a.clear();
        }

        public synchronized void a(String str) {
            this.f28138b = null;
            this.f28137a.remove(str);
        }

        public synchronized void a(String str, String str2) {
            this.f28138b = null;
            this.f28137a.put(str, str2);
        }

        public synchronized Map<String, String> b() {
            if (this.f28138b == null) {
                this.f28138b = Collections.unmodifiableMap(new HashMap(this.f28137a));
            }
            return this.f28138b;
        }
    }
}
