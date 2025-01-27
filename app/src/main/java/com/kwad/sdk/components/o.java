package com.kwad.sdk.components;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.app.AppPackageInfo;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface o extends b {
    Map<String, AppPackageInfo> M(Context context);

    void a(Context context, com.kwad.sdk.f.a<JSONArray> aVar);

    JSONArray[] b(Context context, List<String> list);

    @NonNull
    JSONArray c(@NonNull Map<String, AppPackageInfo> map);

    JSONObject e(Context context, String str);

    JSONObject y(String str);
}
