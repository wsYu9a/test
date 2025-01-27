package com.kwad.sdk.service.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface f {
    void a(String str, Map<String, String> map, String str2);

    boolean aM(AdTemplate adTemplate);

    String an(String str);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    String getSDKVersion();

    boolean pz();

    com.kwad.sdk.core.response.b.g uL();

    boolean zB();

    boolean zC();

    boolean zD();

    boolean zE();

    String zF();

    com.kwad.sdk.core.b zG();

    List<AdTemplate> zH();

    String zI();

    JSONObject zJ();

    JSONObject zK();

    Map<String, String> zL();
}
