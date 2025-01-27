package com.opos.exoplayer.core.h;

import android.text.TextUtils;
import com.opos.exoplayer.core.h.g;
import com.opos.exoplayer.core.i.u;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface q extends g {

    /* renamed from: a */
    public static final com.opos.exoplayer.core.i.o<String> f18979a = new com.opos.exoplayer.core.i.o<String>() { // from class: com.opos.exoplayer.core.h.q.1
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.i.o
        public boolean a(String str) {
            String d2 = u.d(str);
            return (TextUtils.isEmpty(d2) || (d2.contains(com.baidu.mobads.sdk.internal.a.f5473b) && !d2.contains("text/vtt")) || d2.contains(com.baidu.mobads.sdk.internal.a.f5477f) || d2.contains("xml")) ? false : true;
        }
    };

    /* renamed from: com.opos.exoplayer.core.h.q$1 */
    static final class AnonymousClass1 implements com.opos.exoplayer.core.i.o<String> {
        AnonymousClass1() {
        }

        @Override // com.opos.exoplayer.core.i.o
        public boolean a(String str) {
            String d2 = u.d(str);
            return (TextUtils.isEmpty(d2) || (d2.contains(com.baidu.mobads.sdk.internal.a.f5473b) && !d2.contains("text/vtt")) || d2.contains(com.baidu.mobads.sdk.internal.a.f5477f) || d2.contains("xml")) ? false : true;
        }
    }

    public static abstract class a implements b {

        /* renamed from: a */
        private final f f18980a = new f();

        @Override // com.opos.exoplayer.core.h.g.a
        /* renamed from: b */
        public final q a() {
            return b(this.f18980a);
        }

        protected abstract q b(f fVar);
    }

    public interface b extends g.a {
    }

    public static class c extends IOException {

        /* renamed from: a */
        public final int f18981a;

        /* renamed from: b */
        public final i f18982b;

        public c(IOException iOException, i iVar, int i2) {
            super(iOException);
            this.f18982b = iVar;
            this.f18981a = i2;
        }

        public c(String str, i iVar, int i2) {
            super(str);
            this.f18982b = iVar;
            this.f18981a = i2;
        }

        public c(String str, IOException iOException, i iVar, int i2) {
            super(str, iOException);
            this.f18982b = iVar;
            this.f18981a = i2;
        }
    }

    public static final class d extends c {

        /* renamed from: c */
        public final String f18983c;

        public d(String str, i iVar) {
            super("Invalid content type: " + str, iVar, 1);
            this.f18983c = str;
        }
    }

    public static final class e extends c {

        /* renamed from: c */
        public final int f18984c;

        /* renamed from: d */
        public final Map<String, List<String>> f18985d;

        public e(int i2, Map<String, List<String>> map, i iVar) {
            super("Response code: " + i2, iVar, 1);
            this.f18984c = i2;
            this.f18985d = map;
        }
    }

    public static final class f {

        /* renamed from: a */
        private final Map<String, String> f18986a = new HashMap();

        /* renamed from: b */
        private Map<String, String> f18987b;

        public Map<String, String> a() {
            Map<String, String> map;
            synchronized (this) {
                if (this.f18987b == null) {
                    this.f18987b = Collections.unmodifiableMap(new HashMap(this.f18986a));
                }
                map = this.f18987b;
            }
            return map;
        }
    }
}
