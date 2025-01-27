package com.wbl.ad.yzz.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.mobad.f.a.j;
import com.umeng.analytics.pro.am;
import com.vivo.ic.dm.Downloads;
import com.wbl.ad.yzz.adapter.base.viewholder.BaseViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\u00020\u0006:\u0002µ\u0001B'\b\u0007\u0012\b\b\u0001\u0010<\u001a\u00020\u001a\u0012\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%¢\u0006\u0006\b³\u0001\u0010´\u0001J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002¢\u0006\u0004\b\b\u0010\fJ%\u0010\b\u001a\u0004\u0018\u00018\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\b\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u0000H$¢\u0006\u0004\b\b\u0010\u0014J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0013\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015H\u0014¢\u0006\u0004\b\b\u0010\u0017J\u001f\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010 \u001a\u00020\u001aH\u0016¢\u0006\u0004\b#\u0010$J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010 \u001a\u00020\u001a2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0016¢\u0006\u0004\b\b\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001aH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\b\u0010*J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b/\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020\u001aH\u0014¢\u0006\u0004\b2\u00103J\u0017\u0010\u001c\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u00104J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a05¢\u0006\u0004\b#\u00106J\u0013\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a05¢\u0006\u0004\b\u001c\u00106J\u001f\u0010\b\u001a\u00020\u00072\u0006\u00107\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\b\u0010$J\u001f\u0010\u001c\u001a\u00020\u00072\u0006\u00108\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001c\u00109J\u001f\u00102\u001a\u0002012\u0006\u00108\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001aH\u0014¢\u0006\u0004\b2\u0010:J\u001f\u0010\b\u001a\u00020\u00072\u0006\u00108\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001aH\u0014¢\u0006\u0004\b\b\u00109J\u001f\u0010#\u001a\u0002012\u0006\u00108\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001aH\u0014¢\u0006\u0004\b#\u0010:J\u001f\u0010\u001c\u001a\u00020\u00072\u0006\u00107\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001c\u0010$J\u000f\u0010;\u001a\u00020\u001aH\u0014¢\u0006\u0004\b;\u0010\u001fJ\u0017\u0010#\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001aH\u0014¢\u0006\u0004\b#\u0010\"J\u001f\u0010#\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b#\u0010\u001dJ!\u0010\b\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010<\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\b\u0010\u001dJ\u0017\u0010\b\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\b\u0010=J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b#\u0010\u0012J+\u0010\b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010>\u001a\u00020\u001a2\b\b\u0002\u0010?\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\b\u0010@J+\u0010#\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010>\u001a\u00020\u001a2\b\b\u0002\u0010?\u001a\u00020\u001aH\u0007¢\u0006\u0004\b#\u0010@J\r\u0010A\u001a\u000201¢\u0006\u0004\bA\u0010BJ\r\u0010C\u001a\u000201¢\u0006\u0004\bC\u0010BJ\r\u0010D\u001a\u000201¢\u0006\u0004\bD\u0010BJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010F\u001a\u00020E2\u0006\u0010>\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\b\u0010GJ\u001f\u0010\b\u001a\u00020\u00072\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010HH\u0016¢\u0006\u0004\b\b\u0010JJ\u0017\u0010;\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001aH\u0016¢\u0006\u0004\b;\u0010KJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u001aH\u0004¢\u0006\u0004\b\b\u0010KR\"\u0010Q\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010M\u001a\u0004\bN\u0010B\"\u0004\bO\u0010PR\u0018\u0010T\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010SR\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001a058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0013\u0010Y\u001a\u00020\u001a8F@\u0006¢\u0006\u0006\u001a\u0004\bX\u0010\u001fR$\u0010_\u001a\u00020Z2\u0006\u0010[\u001a\u00020Z8\u0004@BX\u0084.¢\u0006\f\n\u0004\b8\u0010\\\u001a\u0004\b]\u0010^R\u0016\u0010<\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010`R\u0016\u0010a\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010`R6\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000%2\f\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000%8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010b\u001a\u0004\b2\u0010c\"\u0004\bd\u0010eR\u0013\u0010j\u001a\u00020g8F@\u0006¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020\u001a058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010VR$\u0010}\u001a\u0004\u0018\u00010g8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010i\"\u0004\b{\u0010|R5\u0010\u0086\u0001\u001a\u0004\u0018\u00010~2\b\u0010\u007f\u001a\u0004\u0018\u00010~8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0019\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bh\u0010\u0088\u0001R%\u0010\u008b\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b;\u0010M\u001a\u0005\b\u0080\u0001\u0010B\"\u0005\b\u008a\u0001\u0010PR&\u0010\u008f\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008c\u0001\u0010M\u001a\u0005\b\u008d\u0001\u0010B\"\u0005\b\u008e\u0001\u0010PR%\u0010\u0092\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b#\u0010M\u001a\u0005\b\u0090\u0001\u0010B\"\u0005\b\u0091\u0001\u0010PR\u001a\u0010\u0096\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0015\u0010\u0098\u0001\u001a\u00020\u001a8F@\u0006¢\u0006\u0007\u001a\u0005\b\u0097\u0001\u0010\u001fR\u0019\u0010\u0099\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bX\u0010\u0088\u0001R%\u0010\u009a\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b2\u0010M\u001a\u0005\b\u009a\u0001\u0010B\"\u0005\b\u009b\u0001\u0010PR\u0015\u0010\u009c\u0001\u001a\u00020\u001a8F@\u0006¢\u0006\u0007\u001a\u0005\b\u008c\u0001\u0010\u001fR\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R&\u0010£\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010M\u001a\u0005\b¡\u0001\u0010B\"\u0005\b¢\u0001\u0010PR&\u0010¤\u0001\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010M\u001a\u0005\b¤\u0001\u0010B\"\u0005\b¥\u0001\u0010PR\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R*\u0010®\u0001\u001a\u0004\u0018\u00010+8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b\u0094\u0001\u0010¬\u0001\"\u0005\b\u00ad\u0001\u0010.R\u001c\u0010²\u0001\u001a\u0005\u0018\u00010¯\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001¨\u0006¶\u0001"}, d2 = {"Lcom/wbl/ad/yzz/adapter/base/BaseQuickAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/wbl/ad/yzz/adapter/b/a;", "", "", "a", "()V", "Ljava/lang/Class;", am.aD, "(Ljava/lang/Class;)Ljava/lang/Class;", "Landroid/view/View;", "view", "(Ljava/lang/Class;Landroid/view/View;)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "item", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "", "payloads", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "c", "(Landroid/view/ViewGroup;I)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "getItemCount", "()I", "position", "getItemViewType", "(I)I", "b", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;I)V", "", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "", "getItemId", "(I)J", "(Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onDetachedFromRecyclerView", "type", "", "d", "(I)Z", "(I)Ljava/lang/Object;", "Ljava/util/LinkedHashSet;", "()Ljava/util/LinkedHashSet;", "viewHolder", "v", "(Landroid/view/View;I)V", "(Landroid/view/View;I)Z", com.kwad.sdk.ranger.e.TAG, "layoutResId", "(Landroid/view/View;)Lcom/wbl/ad/yzz/adapter/base/viewholder/BaseViewHolder;", "index", "orientation", "(Landroid/view/View;II)I", "o", "()Z", "n", "m", "Landroid/animation/Animator;", "anim", "(Landroid/animation/Animator;I)V", "", "list", "(Ljava/util/Collection;)V", "(I)V", OapsKey.KEY_SIZE, "Z", "getFooterWithEmptyEnable", "setFooterWithEmptyEnable", "(Z)V", "footerWithEmptyEnable", "Lcom/wbl/ad/yzz/adapter/b/d/d;", "Lcom/wbl/ad/yzz/adapter/b/d/d;", "mOnItemClickListener", "x", "Ljava/util/LinkedHashSet;", "childClickViewIds", j.f20763a, "headerViewPosition", "Landroid/content/Context;", "<set-?>", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "I", "mLastPosition", "Ljava/util/List;", "()Ljava/util/List;", "setData$wblsdk_release", "(Ljava/util/List;)V", MiConfigSingleton.t0, "Lcom/wbl/ad/yzz/adapter/b/f/b;", "k", "()Lcom/wbl/ad/yzz/adapter/b/f/b;", "loadMoreModule", "Lcom/wbl/ad/yzz/adapter/b/d/a;", "Lcom/wbl/ad/yzz/adapter/b/d/a;", "mSpanSizeLookup", "Lcom/wbl/ad/yzz/adapter/b/d/b;", "q", "Lcom/wbl/ad/yzz/adapter/b/d/b;", "mOnItemChildClickListener", "Lcom/wbl/ad/yzz/adapter/b/f/a;", "t", "Lcom/wbl/ad/yzz/adapter/b/f/a;", "mDraggableModule", "y", "childLongClickViewIds", "u", "Lcom/wbl/ad/yzz/adapter/b/f/b;", "getMLoadMoreModule$wblsdk_release", "setMLoadMoreModule$wblsdk_release", "(Lcom/wbl/ad/yzz/adapter/b/f/b;)V", "mLoadMoreModule", "Lcom/wbl/ad/yzz/adapter/b/b/b;", Downloads.RequestHeaders.COLUMN_VALUE, "i", "Lcom/wbl/ad/yzz/adapter/b/b/b;", "getAdapterAnimation", "()Lcom/wbl/ad/yzz/adapter/b/b/b;", "setAdapterAnimation", "(Lcom/wbl/ad/yzz/adapter/b/b/b;)V", "adapterAnimation", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mFooterLayout", "setHeaderViewAsFlow", "headerViewAsFlow", "f", OapsKey.KEY_GRADE, "setFooterViewAsFlow", "footerViewAsFlow", "getHeaderWithEmptyEnable", "setHeaderWithEmptyEnable", "headerWithEmptyEnable", "Landroid/widget/FrameLayout;", t.f9404d, "Landroid/widget/FrameLayout;", "mEmptyLayout", "h", "headerLayoutCount", "mHeaderLayout", "isUseEmpty", "setUseEmpty", "footerLayoutCount", "Lcom/wbl/ad/yzz/adapter/b/d/c;", t.k, "Lcom/wbl/ad/yzz/adapter/b/d/c;", "mOnItemChildLongClickListener", "getAnimationEnable", "setAnimationEnable", "animationEnable", "isAnimationFirstOnly", "setAnimationFirstOnly", "Lcom/wbl/ad/yzz/adapter/b/d/e;", "p", "Lcom/wbl/ad/yzz/adapter/b/d/e;", "mOnItemLongClickListener", IAdInterListener.AdReqParam.WIDTH, "Landroidx/recyclerview/widget/RecyclerView;", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView$wblsdk_release", "mRecyclerView", "Lcom/wbl/ad/yzz/adapter/b/f/c;", "s", "Lcom/wbl/ad/yzz/adapter/b/f/c;", "mUpFetchModule", "<init>", "(ILjava/util/List;)V", "AnimationType", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> implements com.wbl.ad.yzz.adapter.b.a {

    /* renamed from: a, reason: from kotlin metadata */
    @f.b.a.d
    public List<T> com.martian.mibook.application.MiConfigSingleton.t0 java.lang.String;

    /* renamed from: b, reason: from kotlin metadata */
    public boolean headerWithEmptyEnable;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean footerWithEmptyEnable;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isUseEmpty;

    /* renamed from: e */
    public boolean headerViewAsFlow;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean footerViewAsFlow;

    /* renamed from: g */
    public boolean animationEnable;

    /* renamed from: h, reason: from kotlin metadata */
    public boolean isAnimationFirstOnly;

    /* renamed from: i, reason: from kotlin metadata */
    @f.b.a.e
    public com.wbl.ad.yzz.adapter.b.b.b adapterAnimation;

    /* renamed from: j */
    public LinearLayout mHeaderLayout;

    /* renamed from: k, reason: from kotlin metadata */
    public LinearLayout mFooterLayout;

    /* renamed from: l */
    public FrameLayout mEmptyLayout;

    /* renamed from: m, reason: from kotlin metadata */
    public int mLastPosition;

    /* renamed from: n, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.b.d.a mSpanSizeLookup;

    /* renamed from: o, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.b.d.d mOnItemClickListener;

    /* renamed from: p, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.b.d.e mOnItemLongClickListener;

    /* renamed from: q, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.b.d.b mOnItemChildClickListener;

    /* renamed from: r */
    public com.wbl.ad.yzz.adapter.b.d.c mOnItemChildLongClickListener;

    /* renamed from: s, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.b.f.c mUpFetchModule;

    /* renamed from: t, reason: from kotlin metadata */
    public com.wbl.ad.yzz.adapter.b.f.a mDraggableModule;

    /* renamed from: u, reason: from kotlin metadata */
    @f.b.a.e
    public com.wbl.ad.yzz.adapter.b.f.b mLoadMoreModule;

    /* renamed from: v, reason: from kotlin metadata */
    public Context context;

    /* renamed from: w */
    @f.b.a.e
    public RecyclerView mRecyclerView;

    /* renamed from: x, reason: from kotlin metadata */
    public final LinkedHashSet<Integer> childClickViewIds;

    /* renamed from: y, reason: from kotlin metadata */
    public final LinkedHashSet<Integer> childLongClickViewIds;

    /* renamed from: z */
    public final int layoutResId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/wbl/ad/yzz/adapter/base/BaseQuickAdapter$AnimationType;", "", "<init>", "(Ljava/lang/String;I)V", "AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
    public enum AnimationType {
        AlphaIn,
        ScaleIn,
        SlideInBottom,
        SlideInLeft,
        SlideInRight;

        public static AnimationType valueOf(String str) {
            return (AnimationType) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15958, null, str);
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static AnimationType[] valuesCustom() {
            return (AnimationType[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15957, null, null);
        }
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ BaseViewHolder f31185b;

        public a(BaseViewHolder baseViewHolder) {
            this.f31185b = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15960, this, view);
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* renamed from: b */
        public final /* synthetic */ BaseViewHolder f31187b;

        public b(BaseViewHolder baseViewHolder) {
            this.f31187b = baseViewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15955, this, view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ BaseViewHolder f31189b;

        public c(BaseViewHolder baseViewHolder) {
            this.f31189b = baseViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-16046, this, view);
        }
    }

    public static final class d implements View.OnLongClickListener {

        /* renamed from: b */
        public final /* synthetic */ BaseViewHolder f31191b;

        public d(BaseViewHolder baseViewHolder) {
            this.f31191b = baseViewHolder;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-16045, this, view);
        }
    }

    public static final class e extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b */
        public final /* synthetic */ RecyclerView.LayoutManager f31193b;

        /* renamed from: c */
        public final /* synthetic */ GridLayoutManager.SpanSizeLookup f31194c;

        public e(RecyclerView.LayoutManager layoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f31193b = layoutManager;
            this.f31194c = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i2) {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-16048, this, Integer.valueOf(i2));
        }
    }

    @JvmOverloads
    public BaseQuickAdapter(@LayoutRes int i2, @f.b.a.e List<T> list) {
        this.layoutResId = i2;
        this.com.martian.mibook.application.MiConfigSingleton.t0 java.lang.String = list == null ? new ArrayList<>() : list;
        this.isUseEmpty = true;
        this.isAnimationFirstOnly = true;
        this.mLastPosition = -1;
        a();
        this.childClickViewIds = new LinkedHashSet<>();
        this.childLongClickViewIds = new LinkedHashSet<>();
    }

    public static final /* synthetic */ FrameLayout a(BaseQuickAdapter baseQuickAdapter) {
        return (FrameLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15897, null, baseQuickAdapter);
    }

    public static final /* synthetic */ LinearLayout b(BaseQuickAdapter baseQuickAdapter) {
        return (LinearLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15894, null, baseQuickAdapter);
    }

    public static final /* synthetic */ LinearLayout c(BaseQuickAdapter baseQuickAdapter) {
        return (LinearLayout) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15896, null, baseQuickAdapter);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.adapter.b.d.a d(BaseQuickAdapter baseQuickAdapter) {
        return (com.wbl.ad.yzz.adapter.b.d.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15895, null, baseQuickAdapter);
    }

    public final int a(View view, int index, int orientation) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15890, this, view, Integer.valueOf(index), Integer.valueOf(orientation));
    }

    public VH a(View view) {
        return (VH) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15889, this, view);
    }

    public VH a(ViewGroup parent, int layoutResId) {
        return (VH) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15892, this, parent, Integer.valueOf(layoutResId));
    }

    public final VH a(Class<?> r3, View view) {
        return (VH) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15891, this, r3, view);
    }

    public final Class<?> a(Class<?> r3) {
        return (Class) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15982, this, r3);
    }

    public final void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15981, this, null);
    }

    public final void a(int r3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15984, this, Integer.valueOf(r3));
    }

    public void a(Animator anim, int index) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15983, this, anim, Integer.valueOf(index));
    }

    public void a(View v, int position) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15978, this, v, Integer.valueOf(position));
    }

    public final void a(RecyclerView.ViewHolder holder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15977, this, holder);
    }

    public void a(VH holder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15980, this, holder);
    }

    public void a(VH viewHolder, int viewType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15979, this, viewHolder, Integer.valueOf(viewType));
    }

    public void a(VH holder, int position, List<Object> payloads) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15974, this, holder, Integer.valueOf(position), payloads);
    }

    public abstract void a(@f.b.a.d VH holder, T item);

    public void a(VH holder, T item, List<? extends Object> payloads) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15973, this, holder, item, payloads);
    }

    public void a(Collection<? extends T> list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15976, this, list);
    }

    public int b(int position) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15975, this, Integer.valueOf(position));
    }

    public final int b(View view) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15970, this, view);
    }

    public final int b(View view, int index, int orientation) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15969, this, view, Integer.valueOf(index), Integer.valueOf(orientation));
    }

    public VH b(ViewGroup parent, int viewType) {
        return (VH) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15972, this, parent, Integer.valueOf(viewType));
    }

    public final LinkedHashSet<Integer> b() {
        return (LinkedHashSet) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15971, this, null);
    }

    public void b(RecyclerView.ViewHolder holder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15998, this, holder);
    }

    public void b(VH holder, int position) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15997, this, holder, Integer.valueOf(position));
    }

    public boolean b(View v, int position) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-16000, this, v, Integer.valueOf(position));
    }

    public VH c(ViewGroup parent, int viewType) {
        return (VH) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15999, this, parent, Integer.valueOf(viewType));
    }

    public T c(int position) {
        return (T) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15994, this, Integer.valueOf(position));
    }

    public final LinkedHashSet<Integer> c() {
        return (LinkedHashSet) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15993, this, null);
    }

    public void c(View v, int position) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15996, this, v, Integer.valueOf(position));
    }

    public void c(VH viewHolder, int viewType) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15995, this, viewHolder, Integer.valueOf(viewType));
    }

    public final List<T> d() {
        return (List) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15990, this, null);
    }

    public boolean d(int type) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15989, this, Integer.valueOf(type));
    }

    public boolean d(View v, int position) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15992, this, v, Integer.valueOf(position));
    }

    public int e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15991, this, null);
    }

    public com.wbl.ad.yzz.adapter.b.f.b e(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        return (com.wbl.ad.yzz.adapter.b.f.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15986, this, baseQuickAdapter);
    }

    public void e(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15985, this, Integer.valueOf(i2));
    }

    public final int f() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15988, this, null);
    }

    public final boolean g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15987, this, null);
    }

    public final Context getContext() {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15950, this, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15949, this, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.j(-15952, this, Integer.valueOf(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15951, this, Integer.valueOf(position));
    }

    public final int h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15946, this, null);
    }

    public final boolean i() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15945, this, null);
    }

    public final int j() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-15948, this, null);
    }

    public final com.wbl.ad.yzz.adapter.b.f.b k() {
        return (com.wbl.ad.yzz.adapter.b.f.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15947, this, null);
    }

    public final RecyclerView l() {
        return (RecyclerView) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15942, this, null);
    }

    public final boolean m() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15941, this, null);
    }

    public final boolean n() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15944, this, null);
    }

    public final boolean o() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-15943, this, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15938, this, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15937, this, viewHolder, Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2, List list) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15940, this, viewHolder, Integer.valueOf(i2), list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return (RecyclerView.ViewHolder) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-15939, this, viewGroup, Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15966, this, recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-15965, this, viewHolder);
    }
}
