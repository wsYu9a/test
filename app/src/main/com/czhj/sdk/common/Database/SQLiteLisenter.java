package com.czhj.sdk.common.Database;

import java.util.List;

/* loaded from: classes2.dex */
public interface SQLiteLisenter {
    void onFailed(Error error);

    void onSuccess(List<?> list);
}
