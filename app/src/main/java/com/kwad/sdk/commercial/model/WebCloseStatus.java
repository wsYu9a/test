package com.kwad.sdk.commercial.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.kwai.a;
import java.io.Serializable;

@KsJson
/* loaded from: classes2.dex */
public class WebCloseStatus extends a implements Serializable {
    private static final long serialVersionUID = -998295657148922925L;
    public int closeType;
    public boolean interactSuccess;
}
