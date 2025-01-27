package com.sigmob.sdk.base.views;

import androidx.media3.common.MimeTypes;
import com.czhj.sdk.common.utils.Preconditions;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class n implements Serializable {

    /* renamed from: f */
    public static final List<String> f18801f = Arrays.asList(MimeTypes.IMAGE_JPEG, MimeTypes.IMAGE_PNG, "image/bmp", "image/gif");

    /* renamed from: g */
    public static final List<String> f18802g = Arrays.asList("application/x-javascript");
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final String f18803a;

    /* renamed from: b */
    public final c f18804b;

    /* renamed from: c */
    public final b f18805c;

    /* renamed from: d */
    public final int f18806d;

    /* renamed from: e */
    public final int f18807e;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f18808a;

        static {
            int[] iArr = new int[c.values().length];
            f18808a = iArr;
            try {
                iArr[c.IFRAME_RESOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18808a[c.HTML_RESOURCE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18808a[c.STATIC_RESOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18808a[c.NATIVE_RESOURCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18808a[c.URL_RESOURCE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        NONE,
        IMAGE,
        JAVASCRIPT
    }

    public enum c {
        STATIC_RESOURCE,
        HTML_RESOURCE,
        IFRAME_RESOURCE,
        NATIVE_RESOURCE,
        URL_RESOURCE
    }

    public n(String str, c cVar, b bVar, int i10, int i11) {
        Preconditions.NoThrow.checkNotNull(str);
        Preconditions.NoThrow.checkNotNull(cVar);
        Preconditions.NoThrow.checkNotNull(bVar);
        this.f18803a = str;
        this.f18804b = cVar;
        this.f18805c = bVar;
        this.f18806d = i10;
        this.f18807e = i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r0 != 5) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            int[] r0 = com.sigmob.sdk.base.views.n.a.f18808a
            com.sigmob.sdk.base.views.n$c r1 = r5.f18804b
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 1
            java.lang.String r2 = "CreativeType.JAVASCRIPT"
            java.lang.String r3 = "CreativeType.IMAGE"
            r4 = 0
            if (r0 == r1) goto L39
            r1 = 2
            if (r0 == r1) goto L39
            r1 = 3
            if (r0 == r1) goto L1f
            r1 = 4
            if (r0 == r1) goto L39
            r1 = 5
            if (r0 == r1) goto L39
            goto L52
        L1f:
            com.sigmob.sdk.base.views.n$b r0 = com.sigmob.sdk.base.views.n.b.IMAGE
            com.sigmob.sdk.base.views.n$b r1 = r5.f18805c
            if (r0 != r1) goto L30
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L2f
            return r7
        L2f:
            return r6
        L30:
            com.sigmob.sdk.base.views.n$b r6 = com.sigmob.sdk.base.views.n.b.JAVASCRIPT
            if (r6 != r1) goto L38
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L38:
            return r4
        L39:
            com.sigmob.sdk.base.views.n$b r0 = com.sigmob.sdk.base.views.n.b.IMAGE
            com.sigmob.sdk.base.views.n$b r1 = r5.f18805c
            if (r0 != r1) goto L4a
            com.czhj.sdk.logger.SigmobLog.d(r3)
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L49
            return r6
        L49:
            return r4
        L4a:
            com.sigmob.sdk.base.views.n$b r6 = com.sigmob.sdk.base.views.n.b.JAVASCRIPT
            if (r6 != r1) goto L52
            com.czhj.sdk.logger.SigmobLog.d(r2)
            return r7
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.views.n.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public String b() {
        return this.f18803a;
    }

    public c c() {
        return this.f18804b;
    }

    public b a() {
        return this.f18805c;
    }

    public void a(o oVar) {
        StringBuilder sb2;
        String str;
        String str2;
        String str3;
        Preconditions.NoThrow.checkNotNull(oVar);
        int i10 = a.f18808a[this.f18804b.ordinal()];
        if (i10 == 1) {
            sb2 = new StringBuilder();
            sb2.append("<iframe frameborder=\"0\" scrolling=\"no\" marginheight=\"0\" marginwidth=\"0\" style=\"border: 0px; margin: 0px;\" width=\"");
            sb2.append(this.f18806d);
            sb2.append("\" height=\"");
            sb2.append(this.f18807e);
            sb2.append("\" src=\"");
            sb2.append(this.f18803a);
            str = "\"></iframe>";
        } else {
            if (i10 == 2) {
                str2 = this.f18803a;
                oVar.a(str2);
            }
            if (i10 != 3) {
                if (i10 != 4) {
                    if (i10 != 5) {
                        return;
                    }
                } else if (!this.f18803a.toLowerCase().startsWith("file://")) {
                    str3 = "file://" + this.f18803a;
                    oVar.loadUrl(str3);
                    return;
                }
                str3 = this.f18803a;
                oVar.loadUrl(str3);
                return;
            }
            b bVar = this.f18805c;
            if (bVar == b.IMAGE) {
                sb2 = new StringBuilder();
                sb2.append("<html><head></head><body style=\"margin:0;padding:0\"><img src=\"");
                sb2.append(this.f18803a);
                str = "\" width=\"100%\" style=\"max-width:100%;max-height:100%;\" /></body></html>";
            } else {
                if (bVar != b.JAVASCRIPT) {
                    return;
                }
                sb2 = new StringBuilder();
                sb2.append("<script src=\"");
                sb2.append(this.f18803a);
                str = "\"></script>";
            }
        }
        sb2.append(str);
        str2 = sb2.toString();
        oVar.a(str2);
    }
}
