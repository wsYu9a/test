package com.martian.mibook.data.theme;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import b7.e;
import ba.b;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0002+,B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010#\u001a\u00020$J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020&H\u0004J\u0006\u0010*\u001a\u00020$R\u001c\u0010\t\u001a\u00020\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\rR\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006-"}, d2 = {"Lcom/martian/mibook/data/theme/ThemeItem;", "", "themeId", "", "themeName", "", "type", "Lcom/martian/mibook/data/theme/ReaderThemeType;", "(ILjava/lang/String;Lcom/martian/mibook/data/theme/ReaderThemeType;)V", "backgroundImagePath", "getBackgroundImagePath", "()Ljava/lang/String;", "setBackgroundImagePath", "(Ljava/lang/String;)V", "downLoadStatus", "getDownLoadStatus", "()I", "setDownLoadStatus", "(I)V", TTDownloadField.TT_DOWNLOAD_PATH, "getDownloadPath", "setDownloadPath", TTDownloadField.TT_DOWNLOAD_URL, "getDownloadUrl", "setDownloadUrl", "fileSize", "getFileSize", "setFileSize", "previewImageRes", "getPreviewImageRes", "setPreviewImageRes", "getThemeId", "getThemeName", "getType", "()Lcom/martian/mibook/data/theme/ReaderThemeType;", "downloadFileCopyToFilePath", "", "dp2px", "", f.X, "Landroid/content/Context;", "dipValue", "isExitCustomBackgroundPicture", "ColorDelegate", "Companion", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nThemeItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ThemeItem.kt\ncom/martian/mibook/data/theme/ThemeItem\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
/* loaded from: classes3.dex */
public class ThemeItem {

    @k
    public static final String PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR = "PREF_CUSTOM_NIGHT_THEME_BACKGROUND_COLOR";

    @k
    public static final String PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE = "PREF_CUSTOM_NIGHT_THEME_BACKGROUND_IMAGE";

    @k
    public static final String PREF_CUSTOM_NIGHT_THEME_NAVIGATIONBAR_BACKGROUND_COLOR = "PREF_CUSTOM_NIGHT_THEME_NAVIGATIONBAR_BACKGROUND_COLOR";

    @k
    public static final String PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR = "PREF_CUSTOM_NIGHT_THEME_TEXT_COLOR";

    @k
    public static final String PREF_CUSTOM_THEME_BACKGROUND_COLOR = "PREF_CUSTOM_THEME_BACKGROUND_COLOR";

    @k
    public static final String PREF_CUSTOM_THEME_BACKGROUND_IMAGE = "PREF_CUSTOM_THEME_BACKGROUND_IMAGE";

    @k
    public static final String PREF_CUSTOM_THEME_NAVIGATIONBAR_BACKGROUND_COLOR = "PREF_CUSTOM_THEME_NAVIGATIONBAR_BACKGROUND_COLOR";

    @k
    public static final String PREF_CUSTOM_THEME_TEXT_COLOR = "PREF_CUSTOM_THEME_TEXT_COLOR";

    @k
    public static final String PREF_IS_CUSTOM_IMAGE_BACKGROUND = "PREF_IS_CUSTOM_IMAGE_BACKGROUND";

    @k
    public static final String PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND = "PREF_IS_CUSTOM_NIGHT_IMAGE_BACKGROUND";

    @k
    private String backgroundImagePath;
    private int downLoadStatus;

    @l
    private String downloadPath;

    @l
    private String downloadUrl;

    @l
    private String fileSize;
    private int previewImageRes;
    private final int themeId;

    @l
    private final String themeName;

    @l
    private final ReaderThemeType type;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00022\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0097\u0002¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0096\u0002R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/data/theme/ThemeItem$ColorDelegate;", "Lkotlin/properties/ReadWriteProperty;", "", "", "getColor", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "color", "Ljava/lang/Integer;", "getValue", "thisRef", e.f1381l, "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Integer;", "setValue", "", "value", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ColorDelegate implements ReadWriteProperty<Object, Integer> {

        @l
        private Integer color;

        @k
        private final Function0<Integer> getColor;

        public ColorDelegate(@k @ColorInt Function0<Integer> getColor) {
            Intrinsics.checkNotNullParameter(getColor, "getColor");
            this.getColor = getColor;
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
            return getValue(obj, (KProperty<?>) kProperty);
        }

        @Override // kotlin.properties.ReadWriteProperty
        public /* bridge */ /* synthetic */ void setValue(Object obj, KProperty kProperty, Integer num) {
            setValue(obj, (KProperty<?>) kProperty, num.intValue());
        }

        @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
        @k
        @ColorInt
        public Integer getValue(@l Object thisRef, @k KProperty<?> r22) {
            Intrinsics.checkNotNullParameter(r22, "property");
            Integer num = this.color;
            if (num == null || (num != null && num.intValue() == 0)) {
                this.color = this.getColor.invoke();
            }
            Integer num2 = this.color;
            Intrinsics.checkNotNull(num2);
            return num2;
        }

        public void setValue(@l Object thisRef, @k KProperty<?> r22, int value) {
            Intrinsics.checkNotNullParameter(r22, "property");
            this.color = Integer.valueOf(value);
        }
    }

    public ThemeItem(int i10, @l String str, @l ReaderThemeType readerThemeType) {
        this.themeId = i10;
        this.themeName = str;
        this.type = readerThemeType;
        this.backgroundImagePath = "";
    }

    public final boolean downloadFileCopyToFilePath() {
        if (TextUtils.isEmpty(getDownloadPath()) || TextUtils.isEmpty(getBackgroundImagePath())) {
            return false;
        }
        String downloadPath = getDownloadPath();
        Intrinsics.checkNotNull(downloadPath);
        File file = new File(downloadPath);
        File file2 = new File(getBackgroundImagePath());
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, null);
                        CloseableKt.closeFinally(fileInputStream, null);
                        return true;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } finally {
            }
        } finally {
        }
    }

    public final float dp2px(@k Context r22, float dipValue) {
        Intrinsics.checkNotNullParameter(r22, "context");
        return (dipValue * r22.getResources().getDisplayMetrics().density) + 0.5f;
    }

    @k
    public final String getBackgroundImagePath() {
        if (TextUtils.isEmpty(this.backgroundImagePath) && !TextUtils.isEmpty(this.downloadUrl)) {
            Uri parse = Uri.parse(this.downloadUrl);
            this.backgroundImagePath = b.l() + parse.getLastPathSegment();
        }
        return this.backgroundImagePath;
    }

    public final int getDownLoadStatus() {
        return this.downLoadStatus;
    }

    @l
    public final String getDownloadPath() {
        if (TextUtils.isEmpty(this.downloadPath) && !TextUtils.isEmpty(this.downloadUrl)) {
            Uri parse = Uri.parse(this.downloadUrl);
            this.downloadPath = b.h("themes") + parse.getLastPathSegment();
        }
        return this.downloadPath;
    }

    @l
    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    @l
    public final String getFileSize() {
        return this.fileSize;
    }

    public final int getPreviewImageRes() {
        return this.previewImageRes;
    }

    public final int getThemeId() {
        return this.themeId;
    }

    @l
    public final String getThemeName() {
        return this.themeName;
    }

    @l
    public final ReaderThemeType getType() {
        return this.type;
    }

    public final boolean isExitCustomBackgroundPicture() {
        return this.type == ReaderThemeType.THEME_CUSTOM && !TextUtils.isEmpty(getBackgroundImagePath()) && new File(getBackgroundImagePath()).exists();
    }

    public final void setBackgroundImagePath(@k String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backgroundImagePath = str;
    }

    public final void setDownLoadStatus(int i10) {
        this.downLoadStatus = i10;
    }

    public final void setDownloadPath(@l String str) {
        this.downloadPath = str;
    }

    public final void setDownloadUrl(@l String str) {
        this.downloadUrl = str;
    }

    public final void setFileSize(@l String str) {
        this.fileSize = str;
    }

    public final void setPreviewImageRes(int i10) {
        this.previewImageRes = i10;
    }

    public /* synthetic */ ThemeItem(int i10, String str, ReaderThemeType readerThemeType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, (i11 & 4) != 0 ? ReaderThemeType.THEME_DEFAULT : readerThemeType);
    }
}
