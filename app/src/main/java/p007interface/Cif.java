package p007interface;

import com.sntech.ads.AdCode;
import h3.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import sh.a;
import xi.k;

/* renamed from: interface.if */
/* loaded from: classes4.dex */
public final class Cif {

    /* renamed from: e */
    public static boolean f27054e;

    /* renamed from: b */
    public boolean f27056b;

    /* renamed from: a */
    @k
    public String f27055a = e.f26403h;

    /* renamed from: c */
    @k
    public final Map<String, a> f27057c = new LinkedHashMap();

    /* renamed from: d */
    @k
    public final Map<String, List<AdCode>> f27058d = new LinkedHashMap();

    /* renamed from: interface.if$do */
    public static final class Cdo {

        /* renamed from: a */
        @k
        public static final Cdo f27059a = new Cdo();

        /* renamed from: b */
        @k
        public static final Lazy f27060b = LazyKt.lazy(C0716do.f33do);

        /* renamed from: interface.if$do$do */
        public static final class C0716do extends Lambda implements Function0<Cif> {

            /* renamed from: do */
            public static final C0716do f33do = new C0716do();

            public C0716do() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Cif invoke() {
                return new Cif();
            }
        }
    }
}
