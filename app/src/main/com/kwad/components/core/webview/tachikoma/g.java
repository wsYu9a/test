package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.offline.api.tk.model.BundleServiceConfig;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.s;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class g {
    private final Map<String, a> abx = new ConcurrentHashMap();

    /* renamed from: com.kwad.components.core.webview.tachikoma.g$1 */
    public class AnonymousClass1 implements com.kwad.components.core.n.a.d.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i10, int i11, long j10, long j11) {
            g.this.ax(KsAdSDK.getContext());
        }
    }

    /* renamed from: com.kwad.components.core.webview.tachikoma.g$2 */
    public class AnonymousClass2 implements j {
        final /* synthetic */ a abA;
        final /* synthetic */ String abB;
        final /* synthetic */ StyleTemplate abz;

        public AnonymousClass2(StyleTemplate styleTemplate, a aVar, String str) {
            styleTemplate = styleTemplate;
            aVar2 = aVar;
            str = str;
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(a.C0448a c0448a) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void ay() {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle success: done");
            a aVar = aVar2;
            aVar.abD = true;
            aVar.tF();
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void az() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final FrameLayout getTKContainer() {
            return null;
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final String getTKReaderScene() {
            return "tk_bundle_service";
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final String getTkTemplateId() {
            return styleTemplate.templateId;
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final com.kwad.sdk.widget.e getTouchCoordsView() {
            return null;
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(ad.a aVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(ay ayVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(o oVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(p pVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(m mVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(t tVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(WebCloseStatus webCloseStatus) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(s sVar, com.kwad.sdk.core.webview.b bVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        }

        @Override // com.kwad.components.core.webview.tachikoma.j
        public final void a(TKRenderFailReason tKRenderFailReason) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: execute fail");
            aVar2.aS("execute fail");
            g.this.unloadBundle(str);
        }
    }

    public static class a {
        public i abC;
        public boolean abD;
        public List<b> abE = new ArrayList();

        /* renamed from: com.kwad.components.core.webview.tachikoma.g$a$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ String abF;

            public AnonymousClass1(String str) {
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator<b> it = a.this.abE.iterator();
                while (it.hasNext()) {
                    it.next().onFailed(str);
                }
                a.this.abE.clear();
            }
        }

        /* renamed from: com.kwad.components.core.webview.tachikoma.g$a$2 */
        public class AnonymousClass2 implements Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator<b> it = a.this.abE.iterator();
                while (it.hasNext()) {
                    it.next().onSuccess();
                }
                a.this.abE.clear();
            }
        }

        public a(i iVar) {
            this.abC = iVar;
        }

        public final void a(b bVar) {
            if (bVar != null) {
                this.abE.add(bVar);
            }
        }

        public final void aS(String str) {
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.1
                final /* synthetic */ String abF;

                public AnonymousClass1(String str2) {
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Iterator<b> it = a.this.abE.iterator();
                    while (it.hasNext()) {
                        it.next().onFailed(str);
                    }
                    a.this.abE.clear();
                }
            });
        }

        public final void tF() {
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.g.a.2
                public AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Iterator<b> it = a.this.abE.iterator();
                    while (it.hasNext()) {
                        it.next().onSuccess();
                    }
                    a.this.abE.clear();
                }
            });
        }
    }

    public interface b {
        void onFailed(String str);

        void onSuccess();
    }

    public static class c {
        private static final g abH = new g();
    }

    public void ax(Context context) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "begin load all services");
        SdkConfigData DA = com.kwad.sdk.core.config.d.DA();
        if (context == null || (optJSONObject = DA.toJson().optJSONObject("appConfig")) == null || (optJSONArray = optJSONObject.optJSONArray("tkServiceConfigs")) == null) {
            return;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            BundleServiceConfig bundleServiceConfig = new BundleServiceConfig();
            bundleServiceConfig.parseJson(optJSONArray.optJSONObject(i10));
            if (bundleServiceConfig.loadType == 1) {
                b(context, bundleServiceConfig.bundleName, null);
            }
        }
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    public static g tE() {
        return c.abH;
    }

    public final void b(Context context, String str, b bVar) {
        if (isLocalDebugEnable()) {
            unloadBundle(str);
        }
        com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle:" + str);
        if (TextUtils.isEmpty(str)) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: invalid bundle name");
            if (bVar != null) {
                bVar.onFailed("invalid bundle name");
                return;
            }
            return;
        }
        SdkConfigData DA = com.kwad.sdk.core.config.d.DA();
        if (DA == null) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: config data empty");
            if (bVar != null) {
                bVar.onFailed("config data empty");
                return;
            }
            return;
        }
        if (context == null) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: no context");
            if (bVar != null) {
                bVar.onFailed("no context");
                return;
            }
            return;
        }
        JSONObject optJSONObject = DA.toJson().optJSONObject("styleTemplatesConfig");
        StyleTemplate styleTemplate = null;
        JSONArray optJSONArray = optJSONObject == null ? null : optJSONObject.optJSONArray("styleTemplates");
        if (optJSONArray != null) {
            int i10 = 0;
            while (true) {
                if (i10 >= optJSONArray.length()) {
                    break;
                }
                StyleTemplate styleTemplate2 = new StyleTemplate();
                styleTemplate2.parseJson(optJSONArray.optJSONObject(i10));
                String str2 = styleTemplate2.templateId;
                if (str2 != null && str2.equals(str)) {
                    styleTemplate = styleTemplate2;
                    break;
                }
                i10++;
            }
        }
        if (isLocalDebugEnable() && styleTemplate == null) {
            styleTemplate = new StyleTemplate();
            styleTemplate.templateId = str;
        }
        if (styleTemplate != null) {
            a(context, styleTemplate, bVar);
            return;
        }
        com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: no bundle");
        if (bVar != null) {
            bVar.onFailed("no bundle");
        }
    }

    public final void init() {
        try {
            com.kwad.components.core.n.a.d.b bVar = (com.kwad.components.core.n.a.d.b) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.d.b.class);
            if (bVar != null) {
                bVar.a(new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.core.webview.tachikoma.g.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.components.core.n.a.d.a
                    public final void a(int i10, int i11, long j10, long j11) {
                        g.this.ax(KsAdSDK.getContext());
                    }
                });
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public final void unloadBundle(String str) {
        if (this.abx.get(str) != null) {
            com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "unload bundle" + str);
            a aVar = this.abx.get(str);
            if (aVar != null) {
                aVar.abC.jK();
            }
            this.abx.remove(str);
        }
    }

    public final void a(Context context, String str, b bVar) {
        if (TextUtils.isEmpty(str)) {
            bVar.onFailed("invalid bundle string");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            StyleTemplate styleTemplate = new StyleTemplate();
            styleTemplate.parseJson(jSONObject);
            if (TextUtils.isEmpty(styleTemplate.templateId) || TextUtils.isEmpty(styleTemplate.templateUrl)) {
                bVar.onFailed("invalid bundle:" + str);
            }
            a(context, styleTemplate, bVar);
        } catch (Throwable th2) {
            bVar.onFailed(th2.getMessage());
        }
    }

    private void a(Context context, StyleTemplate styleTemplate, b bVar) {
        String str = styleTemplate.templateId;
        if (str == null) {
            if (bVar != null) {
                bVar.onFailed("no bundle");
                return;
            }
            return;
        }
        a aVar = this.abx.get(str);
        if (aVar != null) {
            if (aVar.abD) {
                com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle finish: already load");
                if (bVar != null) {
                    bVar.onSuccess();
                    return;
                }
                return;
            }
            aVar.a(bVar);
            return;
        }
        i iVar = new i(context, false);
        iVar.a("isService", Boolean.TRUE);
        a aVar2 = new a(iVar);
        aVar2.a(bVar);
        iVar.a(styleTemplate);
        iVar.a((Activity) null, (AdResultData) null, new j() { // from class: com.kwad.components.core.webview.tachikoma.g.2
            final /* synthetic */ a abA;
            final /* synthetic */ String abB;
            final /* synthetic */ StyleTemplate abz;

            public AnonymousClass2(StyleTemplate styleTemplate2, a aVar22, String str2) {
                styleTemplate = styleTemplate2;
                aVar2 = aVar22;
                str = str2;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0448a c0448a) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void ay() {
                com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle success: done");
                a aVar3 = aVar2;
                aVar3.abD = true;
                aVar3.tF();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void az() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_bundle_service";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return styleTemplate.templateId;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ad.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ay ayVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(m mVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(s sVar, com.kwad.sdk.core.webview.b bVar2) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar3) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                com.kwad.sdk.core.d.c.d("KSAdTKBundleService", "load bundle fail: execute fail");
                aVar2.aS("execute fail");
                g.this.unloadBundle(str);
            }
        });
        this.abx.put(str2, aVar22);
    }
}
