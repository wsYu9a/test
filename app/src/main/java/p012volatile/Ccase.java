package p012volatile;

import android.util.Log;
import com.sn.catpie.service.CodeService;
import com.sntech.ads.AdCode;
import com.sntech.ads.AdError;
import com.sntech.ads.SNAdSdk;
import com.sntech.ads.SNCodeManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import l5.c;
import org.json.JSONArray;
import org.json.JSONObject;
import p007interface.Cif;
import sh.a;
import xi.k;
import xi.l;
import yk.b;

/* renamed from: volatile.case */
/* loaded from: classes5.dex */
public final class Ccase implements SNCodeManager {

    /* renamed from: volatile.case$do */
    public static final class Cdo {

        /* renamed from: a */
        @k
        public static final Cdo f31554a = new Cdo();

        /* renamed from: b */
        @k
        public static final Lazy f31555b = LazyKt.lazy(C0798do.f39do);

        /* renamed from: volatile.case$do$do */
        public static final class C0798do extends Lambda implements Function0<Ccase> {

            /* renamed from: do */
            public static final C0798do f39do = new C0798do();

            public C0798do() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Ccase invoke() {
                return new Ccase();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, sh.a>] */
    public final void a(CodeService codeService) {
        if (codeService.isAdCodesSet()) {
            return;
        }
        Cif.Cdo cdo = Cif.Cdo.f27059a;
        Cif cif = (Cif) Cif.Cdo.f27060b.getValue();
        cif.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!cif.f27057c.isEmpty()) {
            for (Map.Entry entry : cif.f27057c.entrySet()) {
                ArrayList arrayList = new ArrayList();
                List<a.C0787a> list = ((a) entry.getValue()).f30666b;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((a.C0787a) it.next()).f30669b);
                    }
                }
                linkedHashMap.put(entry.getKey(), arrayList);
            }
        }
        if (!linkedHashMap.isEmpty()) {
            boolean b10 = b.b();
            Cif.Cdo cdo2 = Cif.Cdo.f27059a;
            codeService.setAdCodes(b10, ((Cif) Cif.Cdo.f27060b.getValue()).f27055a, linkedHashMap);
        }
    }

    @Override // com.sntech.ads.SNCodeManager
    @k
    public final JSONArray getFilteredAdCodeArray(@k String adPositionName) {
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        JSONArray jSONArray = new JSONArray();
        for (AdCode adCode : getFilteredAdCodeList(adPositionName)) {
            JSONObject jSONObject = new JSONObject();
            try {
                Result.Companion companion = Result.INSTANCE;
                jSONObject.put("code_id", adCode.getId());
                jSONObject.put("platform", adCode.getPlatform());
                jSONObject.put("price", adCode.getPrice());
                jSONObject.put("level", adCode.getLevel());
                Result.m58constructorimpl(jSONArray.put(jSONObject));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m58constructorimpl(ResultKt.createFailure(th2));
            }
        }
        return jSONArray;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, sh.a>] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.util.List<com.sntech.ads.AdCode>>] */
    @Override // com.sntech.ads.SNCodeManager
    @k
    public final List<AdCode> getFilteredAdCodeList(@k String adPositionName) {
        List<AdCode> list;
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        CodeService codeService = (CodeService) SNAdSdk.getExtService(CodeService.class);
        if (codeService != null) {
            a(codeService);
            List<AdCode> filteredAdCodeList = codeService.getFilteredAdCodeList(adPositionName);
            Intrinsics.checkNotNullExpressionValue(filteredAdCodeList, "{\n            setAdCodes…adPositionName)\n        }");
            return filteredAdCodeList;
        }
        ArrayList arrayList = new ArrayList();
        Cif.Cdo cdo = Cif.Cdo.f27059a;
        Cif cif = (Cif) Cif.Cdo.f27060b.getValue();
        cif.getClass();
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        if (Cif.f27054e) {
            Log.d("CodeM.local.ctrl", Intrinsics.stringPlus("get aac list for ", adPositionName));
        }
        a aVar = (a) cif.f27057c.get(adPositionName);
        if (aVar == null) {
            list = null;
        } else {
            List<AdCode> list2 = (List) cif.f27058d.get(adPositionName);
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            if (aVar.f30668d) {
                aVar.f30668d = false;
                list2.clear();
                List<a.C0787a> list3 = aVar.f30666b;
                if (list3 != null) {
                    for (a.C0787a innerAdCode : list3) {
                        Intrinsics.checkNotNullParameter(innerAdCode, "innerAdCode");
                        list2.add(innerAdCode.f30669b);
                    }
                }
                cif.f27058d.put(adPositionName, list2);
                if (Cif.f27054e) {
                    Log.d("CodeM.local.ctrl", Intrinsics.stringPlus("return filtered aac list for ", adPositionName));
                }
            } else if (Cif.f27054e) {
                Log.d("CodeM.local.ctrl", Intrinsics.stringPlus("return cached aac list for ", adPositionName));
            }
            list = list2;
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // com.sntech.ads.SNCodeManager
    public final void onAdClicked(@k String adPositionName, @k String platform, @k String codeId) {
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(codeId, "codeId");
        onAdClicked(adPositionName, new AdCode(codeId, platform, c.f27899e), false);
    }

    @Override // com.sntech.ads.SNCodeManager
    public final void onAdFilled(@k String adPositionName, @k String platform, @k String codeId, boolean z10, @l AdError adError) {
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(codeId, "codeId");
        onAdFilled(adPositionName, new AdCode(codeId, platform, c.f27899e), false, z10, adError);
    }

    @Override // com.sntech.ads.SNCodeManager
    public final void setAdCodes(@k String appId, @k Map<String, ? extends List<? extends AdCode>> adCodesInMap) {
        a aVar;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(adCodesInMap, "adCodesInMap");
        CodeService codeService = (CodeService) SNAdSdk.getExtService(CodeService.class);
        if (codeService != null) {
            codeService.setAdCodes(b.b(), appId, adCodesInMap);
            return;
        }
        Cif.Cdo cdo = Cif.Cdo.f27059a;
        Lazy lazy = Cif.Cdo.f27060b;
        Cif cif = (Cif) lazy.getValue();
        boolean b10 = b.b();
        boolean a10 = b.a();
        cif.getClass();
        Log.i("CodeM.local.ctrl", "init " + b10 + b5.a.O + a10);
        int i10 = 1;
        if (!cif.f27056b) {
            cif.f27056b = true;
            Cif.f27054e = a10;
        }
        Cif cif2 = (Cif) lazy.getValue();
        cif2.getClass();
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(adCodesInMap, "adCodesInMap");
        Log.i("CodeM.local.ctrl", Intrinsics.stringPlus("updateAdCodes: ", appId));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : adCodesInMap.keySet()) {
            List<? extends AdCode> list = adCodesInMap.get(str);
            if (list == null) {
                aVar = null;
            } else {
                a adPosition = new a();
                adPosition.f30665a = str;
                adPosition.f30666b = new ArrayList();
                Iterator<? extends AdCode> it = list.iterator();
                while (it.hasNext()) {
                    a.C0787a c0787a = new a.C0787a(it.next());
                    List<a.C0787a> list2 = adPosition.f30666b;
                    if (list2 != null) {
                        list2.add(c0787a);
                    }
                }
                Collections.sort(adPosition.f30666b, Collections.reverseOrder());
                List<a.C0787a> list3 = adPosition.f30666b;
                int i11 = -1;
                if (list3 != null) {
                    double d10 = c.f27899e;
                    for (a.C0787a c0787a2 : list3) {
                        double d11 = c0787a2.f30672e;
                        if (d11 == d10) {
                            c0787a2.f30673f = i11;
                        } else {
                            i11++;
                            c0787a2.f30673f = i11;
                            d10 = d11;
                        }
                        c0787a2.f30669b.setLevel(c0787a2.f30673f);
                    }
                }
                adPosition.f30667c = i11 + i10;
                if (Cif.f27054e) {
                    Intrinsics.checkNotNullParameter(adPosition, "adPosition");
                    StringBuilder a11 = nh.b.a("AdPosition: name = ");
                    a11.append((Object) adPosition.f30665a);
                    a11.append(" levels = ");
                    a11.append(adPosition.f30667c);
                    a11.append(" \nchanged = ");
                    a11.append(adPosition.f30668d);
                    a11.append('\n');
                    StringBuffer stringBuffer = new StringBuffer(a11.toString());
                    List<a.C0787a> list4 = adPosition.f30666b;
                    if (list4 != null) {
                        int i12 = 0;
                        for (Iterator it2 = list4.iterator(); it2.hasNext(); it2 = it2) {
                            a.C0787a innerAdCode = (a.C0787a) it2.next();
                            int i13 = innerAdCode.f30673f;
                            if (i13 > i12) {
                                stringBuffer.append("\n");
                                i12 = i13;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append('{');
                            sb2.append((Object) innerAdCode.f30670c);
                            sb2.append(b5.a.O);
                            sb2.append((Object) innerAdCode.f30671d);
                            sb2.append(b5.a.O);
                            sb2.append(innerAdCode.f30672e);
                            sb2.append(b5.a.O);
                            sb2.append(false);
                            sb2.append(b5.a.O);
                            Intrinsics.checkNotNullParameter(innerAdCode, "innerAdCode");
                            sb2.append(false);
                            sb2.append("} ");
                            stringBuffer.append(sb2.toString());
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    Intrinsics.checkNotNullExpressionValue(stringBuffer2, "log.toString()");
                    Log.d("CodeM.local.ctrl", Intrinsics.stringPlus("sorted ad pos\n", stringBuffer2));
                }
                aVar = adPosition;
            }
            if (aVar != null) {
                linkedHashMap.put(str, aVar);
            }
            if (Cif.f27054e) {
                Log.d("CodeM.local.ctrl", "build ad pos for " + str + ": " + aVar);
            }
            i10 = 1;
        }
        synchronized (cif2) {
            try {
                if (!cif2.f27057c.isEmpty()) {
                    Log.w("CodeM.local.ctrl", "Calling setAdPositions repeatedly is useless!");
                } else {
                    cif2.f27055a = appId;
                    cif2.f27057c.putAll(linkedHashMap);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.sntech.ads.SNCodeManager
    public final void onAdClicked(@k String adPositionName, @k AdCode adCode, boolean z10) {
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        CodeService codeService = (CodeService) SNAdSdk.getExtService(CodeService.class);
        if (codeService != null) {
            a(codeService);
            codeService.onAdClicked(adPositionName, adCode, z10);
            return;
        }
        Cif.Cdo cdo = Cif.Cdo.f27059a;
        ((Cif) Cif.Cdo.f27060b.getValue()).getClass();
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        if (Cif.f27054e) {
            Log.d("CodeM.local.ctrl", "onAdClick " + adPositionName + b5.a.O + ((Object) adCode.getId()) + b5.a.O + z10);
        }
    }

    @Override // com.sntech.ads.SNCodeManager
    public final void onAdFilled(@k String adPositionName, @k AdCode adCode, boolean z10, boolean z11, @l AdError adError) {
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        CodeService codeService = (CodeService) SNAdSdk.getExtService(CodeService.class);
        if (codeService != null) {
            a(codeService);
            codeService.onAdFilled(adPositionName, adCode, z10, z11, adError);
            return;
        }
        Cif.Cdo cdo = Cif.Cdo.f27059a;
        ((Cif) Cif.Cdo.f27060b.getValue()).getClass();
        Intrinsics.checkNotNullParameter(adPositionName, "adPositionName");
        Intrinsics.checkNotNullParameter(adCode, "adCode");
        if (Cif.f27054e) {
            Log.d("CodeM.local.ctrl", "onAdFill " + adPositionName + b5.a.O + ((Object) adCode.getId()) + b5.a.O + z10 + b5.a.O + z11);
        }
    }

    @Override // com.sntech.ads.SNCodeManager
    public final void setAdCodes(@k String appId, @k JSONObject adCodesInJson) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(adCodesInJson, "adCodesInJson");
        Iterator<String> keys = adCodesInJson.keys();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONArray optJSONArray = adCodesInJson.optJSONArray(key);
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                if (length > 0) {
                    int i10 = 0;
                    while (true) {
                        int i11 = i10 + 1;
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                        if (optJSONObject != null) {
                            arrayList.add(new AdCode(optJSONObject.optString("code_id"), optJSONObject.optString("platform"), optJSONObject.optDouble("price")));
                        }
                        if (i11 >= length) {
                            break;
                        } else {
                            i10 = i11;
                        }
                    }
                }
                Intrinsics.checkNotNullExpressionValue(key, "key");
                linkedHashMap.put(key, arrayList);
            }
        }
        setAdCodes(appId, linkedHashMap);
    }
}
