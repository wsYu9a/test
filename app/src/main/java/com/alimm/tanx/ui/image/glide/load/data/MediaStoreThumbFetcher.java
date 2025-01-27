package com.alimm.tanx.ui.image.glide.load.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.Priority;
import com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class MediaStoreThumbFetcher implements DataFetcher<InputStream> {
    private static final ThumbnailStreamOpenerFactory DEFAULT_FACTORY = new ThumbnailStreamOpenerFactory();
    private static final int MINI_HEIGHT = 384;
    private static final int MINI_WIDTH = 512;
    private static final String TAG = "MediaStoreThumbFetcher";
    private final Context context;
    private final DataFetcher<InputStream> defaultFetcher;
    private final ThumbnailStreamOpenerFactory factory;
    private final int height;
    private InputStream inputStream;
    private final Uri mediaStoreUri;
    private final int width;

    public static class FileService {
        public boolean exists(File file) {
            return file.exists();
        }

        public File get(String str) {
            return new File(str);
        }

        public long length(File file) {
            return file.length();
        }
    }

    public static class ImageThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {"_data"};
        private static final String PATH_SELECTION = "kind = 1 AND image_id = ?";

        @Override // com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery
        public Cursor queryPath(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public interface ThumbnailQuery {
        Cursor queryPath(Context context, Uri uri);
    }

    public static class ThumbnailStreamOpener {
        private static final FileService DEFAULT_SERVICE = new FileService();
        private ThumbnailQuery query;
        private final FileService service;

        public ThumbnailStreamOpener(ThumbnailQuery thumbnailQuery) {
            this(DEFAULT_SERVICE, thumbnailQuery);
        }

        private Uri parseThumbUri(Cursor cursor) {
            String string = cursor.getString(0);
            if (!TextUtils.isEmpty(string)) {
                File file = this.service.get(string);
                if (this.service.exists(file) && this.service.length(file) > 0) {
                    return Uri.fromFile(file);
                }
            }
            return null;
        }

        public int getOrientation(Context context, Uri uri) {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                    int orientation = new ImageHeaderParser(inputStream).getOrientation();
                    if (inputStream == null) {
                        return orientation;
                    }
                    try {
                        inputStream.close();
                        return orientation;
                    } catch (IOException unused) {
                        return orientation;
                    }
                } catch (IOException e10) {
                    if (Log.isLoggable(MediaStoreThumbFetcher.TAG, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to open uri: ");
                        sb2.append(uri);
                        Log.d(MediaStoreThumbFetcher.TAG, sb2.toString(), e10);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return -1;
                }
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x001c A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.io.InputStream open(android.content.Context r3, android.net.Uri r4) throws java.io.FileNotFoundException {
            /*
                r2 = this;
                com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher$ThumbnailQuery r0 = r2.query
                android.database.Cursor r4 = r0.queryPath(r3, r4)
                r0 = 0
                if (r4 == 0) goto L19
                boolean r1 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L14
                if (r1 == 0) goto L19
                android.net.Uri r1 = r2.parseThumbUri(r4)     // Catch: java.lang.Throwable -> L14
                goto L1a
            L14:
                r3 = move-exception
                r4.close()
                throw r3
            L19:
                r1 = r0
            L1a:
                if (r4 == 0) goto L1f
                r4.close()
            L1f:
                if (r1 == 0) goto L29
                android.content.ContentResolver r3 = r3.getContentResolver()
                java.io.InputStream r0 = r3.openInputStream(r1)
            L29:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailStreamOpener.open(android.content.Context, android.net.Uri):java.io.InputStream");
        }

        public ThumbnailStreamOpener(FileService fileService, ThumbnailQuery thumbnailQuery) {
            this.service = fileService;
            this.query = thumbnailQuery;
        }
    }

    public static class ThumbnailStreamOpenerFactory {
        public ThumbnailStreamOpener build(Uri uri, int i10, int i11) {
            if (!MediaStoreThumbFetcher.isMediaStoreUri(uri) || i10 > 512 || i11 > MediaStoreThumbFetcher.MINI_HEIGHT) {
                return null;
            }
            return MediaStoreThumbFetcher.isMediaStoreVideo(uri) ? new ThumbnailStreamOpener(new VideoThumbnailQuery()) : new ThumbnailStreamOpener(new ImageThumbnailQuery());
        }
    }

    public static class VideoThumbnailQuery implements ThumbnailQuery {
        private static final String[] PATH_PROJECTION = {"_data"};
        private static final String PATH_SELECTION = "kind = 1 AND video_id = ?";

        @Override // com.alimm.tanx.ui.image.glide.load.data.MediaStoreThumbFetcher.ThumbnailQuery
        public Cursor queryPath(Context context, Uri uri) {
            return context.getContentResolver().query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, PATH_PROJECTION, PATH_SELECTION, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public MediaStoreThumbFetcher(Context context, Uri uri, DataFetcher<InputStream> dataFetcher, int i10, int i11) {
        this(context, uri, dataFetcher, i10, i11, DEFAULT_FACTORY);
    }

    public static boolean isMediaStoreUri(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean isMediaStoreVideo(Uri uri) {
        return isMediaStoreUri(uri) && uri.getPathSegments().contains("video");
    }

    private InputStream openThumbInputStream(ThumbnailStreamOpener thumbnailStreamOpener) {
        InputStream inputStream;
        try {
            inputStream = thumbnailStreamOpener.open(this.context, this.mediaStoreUri);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to find thumbnail file", e10);
            }
            inputStream = null;
        }
        int orientation = inputStream != null ? thumbnailStreamOpener.getOrientation(this.context, this.mediaStoreUri) : -1;
        return orientation != -1 ? new ExifOrientationStream(inputStream, orientation) : inputStream;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        this.defaultFetcher.cleanup();
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public String getId() {
        return this.mediaStoreUri.toString();
    }

    public MediaStoreThumbFetcher(Context context, Uri uri, DataFetcher<InputStream> dataFetcher, int i10, int i11, ThumbnailStreamOpenerFactory thumbnailStreamOpenerFactory) {
        this.context = context;
        this.mediaStoreUri = uri;
        this.defaultFetcher = dataFetcher;
        this.width = i10;
        this.height = i11;
        this.factory = thumbnailStreamOpenerFactory;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) throws Exception {
        ThumbnailStreamOpener build = this.factory.build(this.mediaStoreUri, this.width, this.height);
        if (build != null) {
            this.inputStream = openThumbInputStream(build);
        }
        if (this.inputStream == null) {
            this.inputStream = this.defaultFetcher.loadData(priority);
        }
        return this.inputStream;
    }
}
