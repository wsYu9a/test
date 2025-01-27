package com.czhj.volley.toolbox;

import com.czhj.volley.AuthFailureError;
import com.czhj.volley.Request;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BaseHttpStack {
    public abstract HttpResponse executeRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
