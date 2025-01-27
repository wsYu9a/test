package com.sigmob.sdk.mraid;

import com.sigmob.sdk.base.models.PlacementType;

/* loaded from: classes4.dex */
public class g extends Enum<g> {

    /* renamed from: b */
    public static final g f19557b = new g("CLOSE", 0, "close");

    /* renamed from: c */
    public static final g f19558c = new a("EXPAND", 1, "expand");

    /* renamed from: d */
    public static final g f19559d = new g("USE_CUSTOM_CLOSE", 2, "usecustomclose");

    /* renamed from: e */
    public static final g f19560e = new g("OPEN", 3, "open") { // from class: com.sigmob.sdk.mraid.g.b
        public b(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    };

    /* renamed from: f */
    public static final g f19561f = new g("feedBack", 4, "feedback") { // from class: com.sigmob.sdk.mraid.g.c
        public c(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    };

    /* renamed from: g */
    public static final g f19562g = new g("UNLOAD", 5, "unload");

    /* renamed from: h */
    public static final g f19563h = new g("OPENFOURELEMENTS", 6, "openFourElements");

    /* renamed from: i */
    public static final g f19564i = new g("RESIZE", 7, "resize") { // from class: com.sigmob.sdk.mraid.g.d
        public d(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    };

    /* renamed from: j */
    public static final g f19565j = new g("SET_ORIENTATION_PROPERTIES", 8, "setOrientationProperties");

    /* renamed from: k */
    public static final g f19566k = new g("PLAY_VIDEO", 9, "playVideo") { // from class: com.sigmob.sdk.mraid.g.e
        public e(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    };

    /* renamed from: l */
    public static final g f19567l = new g("STORE_PICTURE", 10, "storePicture") { // from class: com.sigmob.sdk.mraid.g.f
        public f(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    };

    /* renamed from: m */
    public static final g f19568m = new g("CREATE_CALENDAR_EVENT", 11, "createCalendarEvent") { // from class: com.sigmob.sdk.mraid.g.g
        public C0600g(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    };

    /* renamed from: n */
    public static final g f19569n = new g("VPAID", 12, "vpaid") { // from class: com.sigmob.sdk.mraid.g.h
        public h(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    };

    /* renamed from: o */
    public static final g f19570o = new g("EXTENSION", 13, "extension") { // from class: com.sigmob.sdk.mraid.g.i
        public i(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    };

    /* renamed from: p */
    public static final g f19571p = new g("UNSPECIFIED", 14, "");

    /* renamed from: q */
    public static final /* synthetic */ g[] f19572q = a();

    /* renamed from: a */
    public final String f19573a;

    public enum a extends g {
        public a(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    }

    public enum b extends g {
        public b(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    }

    public enum c extends g {
        public c(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    }

    public enum d extends g {
        public d(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    }

    public enum e extends g {
        public e(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    }

    public enum f extends g {
        public f(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    }

    /* renamed from: com.sigmob.sdk.mraid.g$g */
    public enum C0600g extends g {
        public C0600g(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    }

    public enum h extends g {
        public h(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    }

    public enum i extends g {
        public i(String str, int i10, String str2) {
            super(str, i10, str2, null);
        }

        @Override // com.sigmob.sdk.mraid.g
        public boolean a(PlacementType placementType) {
            return true;
        }
    }

    public g(String str, int i10, String str2) {
        super(str, i10);
        this.f19573a = str2;
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) f19572q.clone();
    }

    public boolean a(PlacementType placementType) {
        return false;
    }

    public String b() {
        return this.f19573a;
    }

    public /* synthetic */ g(String str, int i10, String str2, a aVar) {
        this(str, i10, str2);
    }

    public static /* synthetic */ g[] a() {
        return new g[]{f19557b, f19558c, f19559d, f19560e, f19561f, f19562g, f19563h, f19564i, f19565j, f19566k, f19567l, f19568m, f19569n, f19570o, f19571p};
    }

    public static g a(String str) {
        for (g gVar : values()) {
            if (gVar.f19573a.equals(str)) {
                return gVar;
            }
        }
        return f19571p;
    }
}
