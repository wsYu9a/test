package com.czhj.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.czhj.volley.Request;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.Response;
import com.czhj.volley.VolleyError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class ImageLoader {

    /* renamed from: a */
    public final RequestQueue f8788a;

    /* renamed from: b */
    public final ImageCache f8789b;

    /* renamed from: c */
    public final HashMap<String, BatchedImageRequest> f8790c = new HashMap<>();

    /* renamed from: d */
    public final HashMap<String, BatchedImageRequest> f8791d = new HashMap<>();

    /* renamed from: e */
    public final Handler f8792e = new Handler(Looper.getMainLooper());

    /* renamed from: f */
    public int f8793f = 100;

    /* renamed from: g */
    public Runnable f8794g;

    /* renamed from: com.czhj.volley.toolbox.ImageLoader$1 */
    public class AnonymousClass1 implements ImageListener {

        /* renamed from: a */
        public final /* synthetic */ int f8795a;

        /* renamed from: b */
        public final /* synthetic */ ImageView f8796b;

        /* renamed from: c */
        public final /* synthetic */ int f8797c;

        public AnonymousClass1(int i10, ImageView imageView, int i11) {
            i11 = i10;
            imageView = imageView;
            i10 = i11;
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            int i10 = i11;
            if (i10 != 0) {
                imageView.setImageResource(i10);
            }
        }

        @Override // com.czhj.volley.toolbox.ImageLoader.ImageListener
        public void onResponse(ImageContainer imageContainer, boolean z10) {
            if (imageContainer.getBitmap() != null) {
                imageView.setImageBitmap(imageContainer.getBitmap());
                return;
            }
            int i10 = i10;
            if (i10 != 0) {
                imageView.setImageResource(i10);
            }
        }
    }

    /* renamed from: com.czhj.volley.toolbox.ImageLoader$2 */
    public class AnonymousClass2 implements Response.Listener<Bitmap> {

        /* renamed from: a */
        public final /* synthetic */ String f8798a;

        public AnonymousClass2(String str) {
            str2 = str;
        }

        @Override // com.czhj.volley.Response.Listener
        public void onResponse(Bitmap bitmap) {
            ImageLoader.this.onGetImageSuccess(str2, bitmap);
        }
    }

    /* renamed from: com.czhj.volley.toolbox.ImageLoader$3 */
    public class AnonymousClass3 implements Response.ErrorListener {

        /* renamed from: a */
        public final /* synthetic */ String f8800a;

        public AnonymousClass3(String str) {
            str2 = str;
        }

        @Override // com.czhj.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ImageLoader.this.onGetImageError(str2, volleyError);
        }
    }

    /* renamed from: com.czhj.volley.toolbox.ImageLoader$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (BatchedImageRequest batchedImageRequest : ImageLoader.this.f8791d.values()) {
                for (ImageContainer imageContainer : batchedImageRequest.f8804b) {
                    if (imageContainer.f8807a != null) {
                        if (batchedImageRequest.getError() == null) {
                            imageContainer.f8810d = batchedImageRequest.f8805c;
                            imageContainer.f8807a.onResponse(imageContainer, false);
                        } else {
                            imageContainer.f8807a.onErrorResponse(batchedImageRequest.getError());
                        }
                    }
                }
            }
            ImageLoader.this.f8791d.clear();
            ImageLoader.this.f8794g = null;
        }
    }

    public static class BatchedImageRequest {

        /* renamed from: a */
        public final Request<?> f8803a;

        /* renamed from: b */
        public final List<ImageContainer> f8804b;

        /* renamed from: c */
        public Bitmap f8805c;

        /* renamed from: d */
        public VolleyError f8806d;

        public BatchedImageRequest(Request<?> request, ImageContainer imageContainer) {
            ArrayList arrayList = new ArrayList();
            this.f8804b = arrayList;
            this.f8803a = request;
            arrayList.add(imageContainer);
        }

        public void addContainer(ImageContainer imageContainer) {
            this.f8804b.add(imageContainer);
        }

        public VolleyError getError() {
            return this.f8806d;
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.f8804b.remove(imageContainer);
            if (this.f8804b.size() != 0) {
                return false;
            }
            this.f8803a.cancel();
            return true;
        }

        public void setError(VolleyError volleyError) {
            this.f8806d = volleyError;
        }
    }

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public class ImageContainer {

        /* renamed from: a */
        public final ImageListener f8807a;

        /* renamed from: b */
        public final String f8808b;

        /* renamed from: c */
        public final String f8809c;

        /* renamed from: d */
        public Bitmap f8810d;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.f8810d = bitmap;
            this.f8809c = str;
            this.f8808b = str2;
            this.f8807a = imageListener;
        }

        public void cancelRequest() {
            HashMap hashMap;
            Threads.a();
            if (this.f8807a == null) {
                return;
            }
            BatchedImageRequest batchedImageRequest = (BatchedImageRequest) ImageLoader.this.f8790c.get(this.f8808b);
            if (batchedImageRequest == null) {
                BatchedImageRequest batchedImageRequest2 = (BatchedImageRequest) ImageLoader.this.f8791d.get(this.f8808b);
                if (batchedImageRequest2 == null) {
                    return;
                }
                batchedImageRequest2.removeContainerAndCancelIfNecessary(this);
                if (batchedImageRequest2.f8804b.size() != 0) {
                    return;
                } else {
                    hashMap = ImageLoader.this.f8791d;
                }
            } else if (!batchedImageRequest.removeContainerAndCancelIfNecessary(this)) {
                return;
            } else {
                hashMap = ImageLoader.this.f8790c;
            }
            hashMap.remove(this.f8808b);
        }

        public Bitmap getBitmap() {
            return this.f8810d;
        }

        public String getRequestUrl() {
            return this.f8809c;
        }
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z10);
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.f8788a = requestQueue;
        this.f8789b = imageCache;
    }

    public static ImageListener getImageListener(ImageView imageView, int i10, int i11) {
        return new ImageListener() { // from class: com.czhj.volley.toolbox.ImageLoader.1

            /* renamed from: a */
            public final /* synthetic */ int f8795a;

            /* renamed from: b */
            public final /* synthetic */ ImageView f8796b;

            /* renamed from: c */
            public final /* synthetic */ int f8797c;

            public AnonymousClass1(int i112, ImageView imageView2, int i102) {
                i11 = i112;
                imageView = imageView2;
                i10 = i102;
            }

            @Override // com.czhj.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                int i102 = i11;
                if (i102 != 0) {
                    imageView.setImageResource(i102);
                }
            }

            @Override // com.czhj.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageContainer imageContainer, boolean z10) {
                if (imageContainer.getBitmap() != null) {
                    imageView.setImageBitmap(imageContainer.getBitmap());
                    return;
                }
                int i102 = i10;
                if (i102 != 0) {
                    imageView.setImageResource(i102);
                }
            }
        };
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public boolean isCached(String str, int i10, int i11) {
        return isCached(str, i10, i11, ImageView.ScaleType.CENTER_INSIDE);
    }

    public Request<Bitmap> makeImageRequest(String str, int i10, int i11, ImageView.ScaleType scaleType, String str2) {
        return new ImageRequest(str, new Response.Listener<Bitmap>() { // from class: com.czhj.volley.toolbox.ImageLoader.2

            /* renamed from: a */
            public final /* synthetic */ String f8798a;

            public AnonymousClass2(String str22) {
                str2 = str22;
            }

            @Override // com.czhj.volley.Response.Listener
            public void onResponse(Bitmap bitmap) {
                ImageLoader.this.onGetImageSuccess(str2, bitmap);
            }
        }, i10, i11, scaleType, Bitmap.Config.RGB_565, new Response.ErrorListener() { // from class: com.czhj.volley.toolbox.ImageLoader.3

            /* renamed from: a */
            public final /* synthetic */ String f8800a;

            public AnonymousClass3(String str22) {
                str2 = str22;
            }

            @Override // com.czhj.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                ImageLoader.this.onGetImageError(str2, volleyError);
            }
        });
    }

    public void onGetImageError(String str, VolleyError volleyError) {
        BatchedImageRequest remove = this.f8790c.remove(str);
        if (remove != null) {
            remove.setError(volleyError);
            a(str, remove);
        }
    }

    public void onGetImageSuccess(String str, Bitmap bitmap) {
        this.f8789b.putBitmap(str, bitmap);
        BatchedImageRequest remove = this.f8790c.remove(str);
        if (remove != null) {
            remove.f8805c = bitmap;
            a(str, remove);
        }
    }

    public void setBatchedResponseDelay(int i10) {
        this.f8793f = i10;
    }

    public ImageContainer get(String str, ImageListener imageListener, int i10, int i11) {
        return get(str, imageListener, i10, i11, ImageView.ScaleType.CENTER_INSIDE);
    }

    public boolean isCached(String str, int i10, int i11, ImageView.ScaleType scaleType) {
        Threads.a();
        return this.f8789b.getBitmap(a(str, i10, i11, scaleType)) != null;
    }

    public final void a(String str, BatchedImageRequest batchedImageRequest) {
        this.f8791d.put(str, batchedImageRequest);
        if (this.f8794g == null) {
            AnonymousClass4 anonymousClass4 = new Runnable() { // from class: com.czhj.volley.toolbox.ImageLoader.4
                public AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    for (BatchedImageRequest batchedImageRequest2 : ImageLoader.this.f8791d.values()) {
                        for (ImageContainer imageContainer : batchedImageRequest2.f8804b) {
                            if (imageContainer.f8807a != null) {
                                if (batchedImageRequest2.getError() == null) {
                                    imageContainer.f8810d = batchedImageRequest2.f8805c;
                                    imageContainer.f8807a.onResponse(imageContainer, false);
                                } else {
                                    imageContainer.f8807a.onErrorResponse(batchedImageRequest2.getError());
                                }
                            }
                        }
                    }
                    ImageLoader.this.f8791d.clear();
                    ImageLoader.this.f8794g = null;
                }
            };
            this.f8794g = anonymousClass4;
            this.f8792e.postDelayed(anonymousClass4, this.f8793f);
        }
    }

    public ImageContainer get(String str, ImageListener imageListener, int i10, int i11, ImageView.ScaleType scaleType) {
        Threads.a();
        String a10 = a(str, i10, i11, scaleType);
        Bitmap bitmap = this.f8789b.getBitmap(a10);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, null, null);
            imageListener.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, a10, imageListener);
        imageListener.onResponse(imageContainer2, true);
        BatchedImageRequest batchedImageRequest = this.f8790c.get(a10);
        if (batchedImageRequest != null) {
            batchedImageRequest.addContainer(imageContainer2);
            return imageContainer2;
        }
        Request<Bitmap> makeImageRequest = makeImageRequest(str, i10, i11, scaleType, a10);
        RequestQueue requestQueue = this.f8788a;
        if (requestQueue != null) {
            requestQueue.add(makeImageRequest);
            this.f8790c.put(a10, new BatchedImageRequest(makeImageRequest, imageContainer2));
        }
        return imageContainer2;
    }

    public static String a(String str, int i10, int i11, ImageView.ScaleType scaleType) {
        StringBuilder sb2 = new StringBuilder(str.length() + 12);
        sb2.append("#W");
        sb2.append(i10);
        sb2.append("#H");
        sb2.append(i11);
        sb2.append("#S");
        sb2.append(scaleType.ordinal());
        sb2.append(str);
        return sb2.toString();
    }
}
