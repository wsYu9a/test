package androidx.activity.result.contract;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import com.umeng.analytics.pro.f;
import h3.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0012\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0015"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts;", "", "()V", "Api33Impl", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "PickMultipleVisualMedia", "PickVisualMedia", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ActivityResultContracts {

    @RequiresApi(33)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$Api33Impl;", "", "()V", "getPickImagesMaxLimit", "", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api33Impl {

        @k
        public static final Api33Impl INSTANCE = new Api33Impl();

        private Api33Impl() {
        }

        @DoNotInline
        public final int getPickImagesMaxLimit() {
            return MediaStore.getPickImagesMaxLimit();
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class CaptureVideo extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@k Context r22, @k Uri input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k Uri input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public final Boolean parseResult(int resultCode, @l Intent intent) {
            return Boolean.valueOf(resultCode == -1);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0017¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "mimeType", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RequiresApi(19)
    public static class CreateDocument extends ActivityResultContract<String, Uri> {

        @k
        private final String mimeType;

        public CreateDocument(@k String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            this.mimeType = mimeType;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent putExtra = new Intent("android.intent.action.CREATE_DOCUMENT").setType(this.mimeType).putExtra("android.intent.extra.TITLE", input);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return putExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Uri parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }

        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(expression = "CreateDocument(\"todo/todo\")", imports = {}))
        public CreateDocument() {
            this("*/*");
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class GetContent extends ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input);
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Uri parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000 \u00122\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J$\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\b¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RequiresApi(18)
    public static class GetMultipleContents extends ActivityResultContract<String, List<Uri>> {

        /* renamed from: Companion, reason: from kotlin metadata */
        @k
        public static final Companion INSTANCE = new Companion(null);

        @RequiresApi(18)
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents$Companion;", "", "()V", "getClipDataUris", "", "Landroid/net/Uri;", "Landroid/content/Intent;", "getClipDataUris$activity_release", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @k
            public final List<Uri> getClipDataUris$activity_release(@k Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "<this>");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                Uri data = intent.getData();
                if (data != null) {
                    linkedHashSet.add(data);
                }
                ClipData clipData = intent.getClipData();
                if (clipData == null && linkedHashSet.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                if (clipData != null) {
                    int itemCount = clipData.getItemCount();
                    for (int i10 = 0; i10 < itemCount; i10++) {
                        Uri uri = clipData.getItemAt(i10).getUri();
                        if (uri != null) {
                            linkedHashSet.add(uri);
                        }
                    }
                }
                return new ArrayList(linkedHashSet);
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent putExtra = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return putExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public final List<Uri> parseResult(int resultCode, @l Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (resultCode != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = INSTANCE.getClipDataUris$activity_release(intent)) == null) ? CollectionsKt.emptyList() : clipDataUris$activity_release;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\u000bJ+\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RequiresApi(19)
    public static class OpenDocument extends ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@k Context r22, @k String[] input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k String[] input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Uri parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¨\u0006\u000f"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RequiresApi(21)
    public static class OpenDocumentTree extends ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@k Context r12, @l Uri input) {
            Intrinsics.checkNotNullParameter(r12, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r32, @l Uri input) {
            Intrinsics.checkNotNullParameter(r32, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (Build.VERSION.SDK_INT >= 26 && input != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", input);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Uri parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\t¨\u0006\u0015"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RequiresApi(19)
    public static class OpenMultipleDocuments extends ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@k Context r22, @k String[] input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k String[] input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent type = new Intent("android.intent.action.OPEN_DOCUMENT").putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public final List<Uri> parseResult(int resultCode, @l Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (resultCode != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.INSTANCE.getClipDataUris$activity_release(intent)) == null) ? CollectionsKt.emptyList() : clipDataUris$activity_release;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PickContact extends ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public Intent createIntent(@k Context r12, @l Void input) {
            Intrinsics.checkNotNullParameter(r12, "context");
            Intent type = new Intent("android.intent.action.PICK").setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public Uri parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u00132\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00030\u0001:\u0001\u0013B\u000f\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0017J)\u0010\u000e\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "maxItems", "", "(I)V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RequiresApi(19)
    public static class PickMultipleVisualMedia extends ActivityResultContract<PickVisualMediaRequest, List<Uri>> {

        /* renamed from: Companion, reason: from kotlin metadata */
        @k
        public static final Companion INSTANCE = new Companion(null);
        private final int maxItems;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia$Companion;", "", "()V", "getMaxItems", "", "getMaxItems$activity_release", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int getMaxItems$activity_release() {
                if (!PickVisualMedia.INSTANCE.isPhotoPickerAvailable() || Build.VERSION.SDK_INT < 33) {
                    return Integer.MAX_VALUE;
                }
                return Api33Impl.INSTANCE.getPickImagesMaxLimit();
            }

            private Companion() {
            }
        }

        public PickMultipleVisualMedia() {
            this(0, 1, null);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(@k Context r22, @k PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        public /* synthetic */ PickMultipleVisualMedia(int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? INSTANCE.getMaxItems$activity_release() : i10);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r32, @k PickVisualMediaRequest input) {
            Intent intent;
            Intrinsics.checkNotNullParameter(r32, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            PickVisualMedia.Companion companion = PickVisualMedia.INSTANCE;
            if (companion.isPhotoPickerAvailable()) {
                intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                if (Build.VERSION.SDK_INT >= 33 && this.maxItems > Api33Impl.INSTANCE.getPickImagesMaxLimit()) {
                    throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
                }
                intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.maxItems);
            } else {
                intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                if (intent.getType() == null) {
                    intent.setType("*/*");
                    intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
                }
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public final List<Uri> parseResult(int resultCode, @l Intent intent) {
            List<Uri> clipDataUris$activity_release;
            if (resultCode != -1) {
                intent = null;
            }
            return (intent == null || (clipDataUris$activity_release = GetMultipleContents.INSTANCE.getClipDataUris$activity_release(intent)) == null) ? CollectionsKt.emptyList() : clipDataUris$activity_release;
        }

        public PickMultipleVisualMedia(int i10) {
            this.maxItems = i10;
            if (i10 <= 1) {
                throw new IllegalArgumentException("Max items must be higher than 1".toString());
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u0000 \u00102\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "ImageAndVideo", "ImageOnly", "SingleMimeType", "VideoOnly", "VisualMediaType", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class PickVisualMedia extends ActivityResultContract<PickVisualMediaRequest, Uri> {

        /* renamed from: Companion, reason: from kotlin metadata */
        @k
        public static final Companion INSTANCE = new Companion(null);

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$Companion;", "", "()V", "getVisualMimeType", "", "input", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "getVisualMimeType$activity_release", "isPhotoPickerAvailable", "", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @l
            public final String getVisualMimeType$activity_release(@k VisualMediaType input) {
                Intrinsics.checkNotNullParameter(input, "input");
                if (input instanceof ImageOnly) {
                    return "image/*";
                }
                if (input instanceof VideoOnly) {
                    return "video/*";
                }
                if (input instanceof SingleMimeType) {
                    return ((SingleMimeType) input).getMimeType();
                }
                if (input instanceof ImageAndVideo) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }

            @JvmStatic
            @SuppressLint({"ClassVerificationFailure", "NewApi"})
            public final boolean isPhotoPickerAvailable() {
                int extensionVersion;
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 33) {
                    return true;
                }
                if (i10 >= 30) {
                    extensionVersion = SdkExtensions.getExtensionVersion(30);
                    if (extensionVersion >= 2) {
                        return true;
                    }
                }
                return false;
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class ImageAndVideo implements VisualMediaType {

            @k
            public static final ImageAndVideo INSTANCE = new ImageAndVideo();

            private ImageAndVideo() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class ImageOnly implements VisualMediaType {

            @k
            public static final ImageOnly INSTANCE = new ImageOnly();

            private ImageOnly() {
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "mimeType", "", "(Ljava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class SingleMimeType implements VisualMediaType {

            @k
            private final String mimeType;

            public SingleMimeType(@k String mimeType) {
                Intrinsics.checkNotNullParameter(mimeType, "mimeType");
                this.mimeType = mimeType;
            }

            @k
            public final String getMimeType() {
                return this.mimeType;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "()V", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class VideoOnly implements VisualMediaType {

            @k
            public static final VideoOnly INSTANCE = new VideoOnly();

            private VideoOnly() {
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageAndVideo;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$ImageOnly;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$SingleMimeType;", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VideoOnly;", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public interface VisualMediaType {
        }

        @JvmStatic
        @SuppressLint({"ClassVerificationFailure", "NewApi"})
        public static final boolean isPhotoPickerAvailable() {
            return INSTANCE.isPhotoPickerAvailable();
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(@k Context r22, @k PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r32, @k PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(r32, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Companion companion = INSTANCE;
            if (companion.isPhotoPickerAvailable()) {
                Intent intent = new Intent("android.provider.action.PICK_IMAGES");
                intent.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
                return intent;
            }
            Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(companion.getVisualMimeType$activity_release(input.getMediaType()));
            if (intent2.getType() != null) {
                return intent2;
            }
            intent2.setType("*/*");
            intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{"image/*", "video/*"});
            return intent2;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Uri parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return intent.getData();
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00152%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u00060\u00040\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\rJ7\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RequestMultiplePermissions extends ActivityResultContract<String[], Map<String, Boolean>> {

        @k
        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";

        /* renamed from: Companion, reason: from kotlin metadata */
        @k
        public static final Companion INSTANCE = new Companion(null);

        @k
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";

        @k
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0000¢\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions$Companion;", "", "()V", "ACTION_REQUEST_PERMISSIONS", "", "EXTRA_PERMISSIONS", "EXTRA_PERMISSION_GRANT_RESULTS", "createIntent", "Landroid/content/Intent;", "input", "", "createIntent$activity_release", "([Ljava/lang/String;)Landroid/content/Intent;", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @k
            public final Intent createIntent$activity_release(@k String[] input) {
                Intrinsics.checkNotNullParameter(input, "input");
                Intent putExtra = new Intent(RequestMultiplePermissions.ACTION_REQUEST_PERMISSIONS).putExtra(RequestMultiplePermissions.EXTRA_PERMISSIONS, input);
                Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return putExtra;
            }

            private Companion() {
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public Intent createIntent(@k Context r22, @k String[] input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return INSTANCE.createIntent$activity_release(input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(@k Context r52, @k String[] input) {
            Intrinsics.checkNotNullParameter(r52, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (input.length == 0) {
                return new ActivityResultContract.SynchronousResult<>(MapsKt.emptyMap());
            }
            for (String str : input) {
                if (ContextCompat.checkSelfPermission(r52, str) != 0) {
                    return null;
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(input.length), 16));
            for (String str2 : input) {
                Pair pair = TuplesKt.to(str2, Boolean.TRUE);
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return new ActivityResultContract.SynchronousResult<>(linkedHashMap);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public Map<String, Boolean> parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                return MapsKt.emptyMap();
            }
            if (intent == null) {
                return MapsKt.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra(EXTRA_PERMISSIONS);
            int[] intArrayExtra = intent.getIntArrayExtra(EXTRA_PERMISSION_GRANT_RESULTS);
            if (intArrayExtra == null || stringArrayExtra == null) {
                return MapsKt.emptyMap();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i10 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i10 == 0));
            }
            return MapsKt.toMap(CollectionsKt.zip(ArraysKt.filterNotNull(stringArrayExtra), arrayList));
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RequestPermission extends ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public Intent createIntent(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return RequestMultiplePermissions.INSTANCE.createIntent$activity_release(new String[]{input});
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@k Context r22, @k String input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (ContextCompat.checkSelfPermission(r22, input) == 0) {
                return new ActivityResultContract.SynchronousResult<>(Boolean.TRUE);
            }
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public Boolean parseResult(int resultCode, @l Intent intent) {
            if (intent == null || resultCode != -1) {
                return Boolean.FALSE;
            }
            int[] intArrayExtra = intent.getIntArrayExtra(RequestMultiplePermissions.EXTRA_PERMISSION_GRANT_RESULTS);
            boolean z10 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    if (intArrayExtra[i10] == 0) {
                        z10 = true;
                        break;
                    }
                    i10++;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", f.X, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {

        @k
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public Intent createIntent(@k Context r22, @k Intent input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return input;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public ActivityResult parseResult(int resultCode, @l Intent intent) {
            return new ActivityResult(resultCode, intent);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class StartIntentSenderForResult extends ActivityResultContract<IntentSenderRequest, ActivityResult> {

        @k
        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";

        @k
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";

        @k
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public Intent createIntent(@k Context r22, @k IntentSenderRequest input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent putExtra = new Intent(ACTION_INTENT_SENDER_REQUEST).putExtra(EXTRA_INTENT_SENDER_REQUEST, input);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return putExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public ActivityResult parseResult(int resultCode, @l Intent intent) {
            return new ActivityResult(resultCode, intent);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class TakePicture extends ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(@k Context r22, @k Uri input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k Uri input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent putExtra = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        public final Boolean parseResult(int resultCode, @l Intent intent) {
            return Boolean.valueOf(resultCode == -1);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class TakePicturePreview extends ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@k Context r12, @l Void input) {
            Intrinsics.checkNotNullParameter(r12, "context");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r12, @l Void input) {
            Intrinsics.checkNotNullParameter(r12, "context");
            return new Intent("android.media.action.IMAGE_CAPTURE");
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Bitmap parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra(e.f26408m);
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", f.X, "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    public static class TakeVideo extends ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(@k Context r22, @k Uri input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return null;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @k
        @CallSuper
        public Intent createIntent(@k Context r22, @k Uri input) {
            Intrinsics.checkNotNullParameter(r22, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent putExtra = new Intent("android.media.action.VIDEO_CAPTURE").putExtra("output", input);
            Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return putExtra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        @l
        public final Bitmap parseResult(int resultCode, @l Intent intent) {
            if (resultCode != -1) {
                intent = null;
            }
            if (intent != null) {
                return (Bitmap) intent.getParcelableExtra(e.f26408m);
            }
            return null;
        }
    }

    private ActivityResultContracts() {
    }
}
