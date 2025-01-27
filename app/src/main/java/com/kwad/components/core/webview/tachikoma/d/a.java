package com.kwad.components.core.webview.tachikoma.d;

import android.text.TextUtils;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.martian.mibook.fragment.BookMarkFragment;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private List<Integer> adV;
    private final List<Integer> adW;

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ int adX;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.aW(i10);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.a$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ String adZ;

        public AnonymousClass2(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a.this.ba(str);
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.d.a$a */
    public static class C0456a {
        private static final a aea = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public void aW(int i10) {
        if (this.adW.contains(Integer.valueOf(i10))) {
            this.adV.add(Integer.valueOf(i10));
        }
    }

    public void ba(String str) {
        int i10;
        try {
            i10 = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            i10 = Integer.MAX_VALUE;
        }
        if (this.adW.contains(Integer.valueOf(i10))) {
            this.adV.add(Integer.valueOf(i10));
        }
    }

    public static a uf() {
        return C0456a.aea;
    }

    public final void aX(int i10) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.d.a.1
            final /* synthetic */ int adX;

            public AnonymousClass1(int i102) {
                i10 = i102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.aW(i10);
            }
        });
    }

    public final void bb(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.d.a.2
            final /* synthetic */ String adZ;

            public AnonymousClass2(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a.this.ba(str);
            }
        });
    }

    public final List<Integer> ug() {
        return this.adV;
    }

    public final void uh() {
        this.adV.clear();
    }

    private a() {
        this.adV = new ArrayList();
        this.adW = Arrays.asList(123, Integer.valueOf(TinkerReport.KEY_APPLIED_RESOURCE_EXTRACT), 185, 190, Integer.valueOf(BookMarkFragment.f13618i), 200);
    }
}
