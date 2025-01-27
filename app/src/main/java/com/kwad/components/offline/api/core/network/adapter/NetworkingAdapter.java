package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNetworking;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NetworkingAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> extends m<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final OfflineCompoNetworking<R, T> mOfflineCompoNetworking;

    /* renamed from: com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter$1 */
    class AnonymousClass1 extends RequestAdapter<R> {
        final /* synthetic */ IOfflineCompoRequest val$offlineRequest;

        AnonymousClass1(IOfflineCompoRequest iOfflineCompoRequest) {
            createRequest = iOfflineCompoRequest;
        }

        @Override // com.kwad.sdk.core.network.b
        public boolean encryptDisable() {
            return createRequest.encryptDisable();
        }

        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
        public JSONObject getBody() {
            return createRequest.getBody();
        }

        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
        public Map<String, String> getBodyMap() {
            return createRequest.getBodyMap();
        }

        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
        public Map<String, String> getHeader() {
            return createRequest.getHeader();
        }

        @Override // com.kwad.components.offline.api.core.network.adapter.RequestAdapter
        public R getOfflineCompoRequest() {
            return (R) createRequest;
        }

        @Override // com.kwad.sdk.core.network.b
        public String getRequestHost() {
            return createRequest.getRequestHost();
        }

        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
        @Nullable
        public SceneImpl getScene() {
            return null;
        }

        @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
        public String getUrl() {
            return createRequest.getUrl();
        }
    }

    public NetworkingAdapter(@NonNull OfflineCompoNetworking<R, T> offlineCompoNetworking) {
        this.mOfflineCompoNetworking = offlineCompoNetworking;
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    public RequestAdapter<R> createRequest() {
        return new RequestAdapter<R>() { // from class: com.kwad.components.offline.api.core.network.adapter.NetworkingAdapter.1
            final /* synthetic */ IOfflineCompoRequest val$offlineRequest;

            AnonymousClass1(IOfflineCompoRequest iOfflineCompoRequest) {
                createRequest = iOfflineCompoRequest;
            }

            @Override // com.kwad.sdk.core.network.b
            public boolean encryptDisable() {
                return createRequest.encryptDisable();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public JSONObject getBody() {
                return createRequest.getBody();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public Map<String, String> getBodyMap() {
                return createRequest.getBodyMap();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public Map<String, String> getHeader() {
                return createRequest.getHeader();
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.RequestAdapter
            public R getOfflineCompoRequest() {
                return (R) createRequest;
            }

            @Override // com.kwad.sdk.core.network.b
            public String getRequestHost() {
                return createRequest.getRequestHost();
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            @Nullable
            public SceneImpl getScene() {
                return null;
            }

            @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
            public String getUrl() {
                return createRequest.getUrl();
            }
        };
    }

    @Override // com.kwad.sdk.core.network.m
    public boolean enableMonitorReport() {
        return this.mOfflineCompoNetworking.enableMonitorReport();
    }

    @Override // com.kwad.sdk.core.network.m
    public boolean isPostByJson() {
        return this.mOfflineCompoNetworking.isPostByJson();
    }

    @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.a
    public void onResponse(RequestAdapter<R> requestAdapter, c cVar) {
        super.onResponse((NetworkingAdapter<R, T>) requestAdapter, cVar);
        this.mOfflineCompoNetworking.onResponse(requestAdapter.getOfflineCompoRequest(), cVar);
    }

    @Override // com.kwad.sdk.core.network.m
    @NonNull
    public ResultDataAdapter<T> parseData(String str) {
        return new ResultDataAdapter<>(this.mOfflineCompoNetworking.parseData(str));
    }
}
