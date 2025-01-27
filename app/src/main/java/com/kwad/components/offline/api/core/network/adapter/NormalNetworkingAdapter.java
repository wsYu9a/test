package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.OfflineCompoNormalNetworking;
import com.kwad.components.offline.api.core.network.model.NormalOfflineCompoResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NormalNetworkingAdapter<R extends IOfflineCompoRequest, T extends NormalOfflineCompoResultData> extends n<NormalRequestAdapter<R>, NormalResultDataAdapter<T>> {
    private final OfflineCompoNormalNetworking<R, T> mOfflineCompoNetworking;

    /* renamed from: com.kwad.components.offline.api.core.network.adapter.NormalNetworkingAdapter$1 */
    class AnonymousClass1 extends NormalRequestAdapter<R> {
        final /* synthetic */ IOfflineCompoRequest val$offlineRequest;

        AnonymousClass1(IOfflineCompoRequest iOfflineCompoRequest) {
            createRequest = iOfflineCompoRequest;
        }

        @Override // com.kwad.sdk.core.network.g
        public JSONObject getBody() {
            return createRequest.getBody();
        }

        @Override // com.kwad.sdk.core.network.g
        public Map<String, String> getBodyMap() {
            return createRequest.getBodyMap();
        }

        @Override // com.kwad.sdk.core.network.g
        public Map<String, String> getHeader() {
            return createRequest.getHeader();
        }

        @Override // com.kwad.sdk.core.network.o
        public String getMethod() {
            return createRequest.getMethod();
        }

        @Override // com.kwad.components.offline.api.core.network.adapter.NormalRequestAdapter
        public R getOfflineCompoRequest() {
            return (R) createRequest;
        }

        @Override // com.kwad.sdk.core.network.g
        @Nullable
        public SceneImpl getScene() {
            return null;
        }

        @Override // com.kwad.sdk.core.network.g
        public String getUrl() {
            return createRequest.getUrl();
        }
    }

    public NormalNetworkingAdapter(@NonNull OfflineCompoNormalNetworking<R, T> offlineCompoNormalNetworking) {
        this.mOfflineCompoNetworking = offlineCompoNormalNetworking;
    }

    @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
    }

    @Override // com.kwad.sdk.core.network.a
    @NonNull
    public NormalRequestAdapter<R> createRequest() {
        return new NormalRequestAdapter<R>() { // from class: com.kwad.components.offline.api.core.network.adapter.NormalNetworkingAdapter.1
            final /* synthetic */ IOfflineCompoRequest val$offlineRequest;

            AnonymousClass1(IOfflineCompoRequest iOfflineCompoRequest) {
                createRequest = iOfflineCompoRequest;
            }

            @Override // com.kwad.sdk.core.network.g
            public JSONObject getBody() {
                return createRequest.getBody();
            }

            @Override // com.kwad.sdk.core.network.g
            public Map<String, String> getBodyMap() {
                return createRequest.getBodyMap();
            }

            @Override // com.kwad.sdk.core.network.g
            public Map<String, String> getHeader() {
                return createRequest.getHeader();
            }

            @Override // com.kwad.sdk.core.network.o
            public String getMethod() {
                return createRequest.getMethod();
            }

            @Override // com.kwad.components.offline.api.core.network.adapter.NormalRequestAdapter
            public R getOfflineCompoRequest() {
                return (R) createRequest;
            }

            @Override // com.kwad.sdk.core.network.g
            @Nullable
            public SceneImpl getScene() {
                return null;
            }

            @Override // com.kwad.sdk.core.network.g
            public String getUrl() {
                return createRequest.getUrl();
            }
        };
    }

    @Override // com.kwad.sdk.core.network.n
    public NormalResultDataAdapter<T> createResponseData() {
        return new NormalResultDataAdapter<>(this.mOfflineCompoNetworking.createResponseData());
    }
}
