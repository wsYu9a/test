package com.opos.mobad.q.a;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.service.event.EventDescription;

/* loaded from: classes4.dex */
public interface h {
    void a(Context context, AdItemData adItemData, MaterialFileData materialFileData, int i2, boolean z, int i3, EventDescription eventDescription);

    boolean a(Activity activity);

    boolean a(Activity activity, AdItemData adItemData, int i2, com.opos.mobad.q.a.b.d dVar, EventDescription eventDescription);
}
