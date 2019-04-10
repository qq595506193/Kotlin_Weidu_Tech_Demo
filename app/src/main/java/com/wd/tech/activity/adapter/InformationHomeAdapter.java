package com.wd.tech.activity.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;
import com.wd.tech.R;
import com.wd.tech.entity.InformationHomeBean;

public class InformationHomeAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    private Context context;
    private final int BANNER = 0;
    private final int ITEM_01 = 1;
    private final int ITEM_02 = 2;
    private final int ITEM_03 = 3;
    private BannerViewHolder bannerViewHolder;
    private Item_01ViewHolder item_01ViewHolder;
    private Item_02ViewHolder item_02ViewHolder;
    private Item_03ViewHolder item_03ViewHolder;
    private InformationHomeBean informationHomeBean;

    public InformationHomeAdapter(Context context) {
        informationHomeBean = new InformationHomeBean();
        this.context = context;
    }

    public void setInformationHomeBeans(InformationHomeBean informationHomeBean) {
        if (informationHomeBean != null) {
            this.informationHomeBean = informationHomeBean;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        if (getItemViewType(i) == BANNER) {
            view = LayoutInflater.from(context).inflate(R.layout.item_xrv_information_home_01, viewGroup, false);
            bannerViewHolder = new BannerViewHolder(view);
            return bannerViewHolder;
        } else if (getItemViewType(i) == ITEM_01) {
            view = LayoutInflater.from(context).inflate(R.layout.item_xrv_information_home_02, viewGroup, false);
            item_01ViewHolder = new Item_01ViewHolder(view);
            return item_01ViewHolder;
        } else if (getItemViewType(i) == ITEM_02) {
            view = LayoutInflater.from(context).inflate(R.layout.item_xrv_information_home_03, viewGroup, false);
            item_02ViewHolder = new Item_02ViewHolder(view);
            return item_02ViewHolder;
        } else if (getItemViewType(i) == ITEM_03) {
            view = LayoutInflater.from(context).inflate(R.layout.item_xrv_information_home_04, viewGroup, false);
            item_03ViewHolder = new Item_03ViewHolder(view);
            return item_03ViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder viewHolder, int i) {
        InformationHomeBean.Result result = informationHomeBean.getResult().get(i);
        if (getItemViewType(i) == BANNER) {

        } else if (getItemViewType(i) == ITEM_01) {
            Glide.with(context).load(result.getThumbnail()).into(item_01ViewHolder.iv_icon);
            item_01ViewHolder.tv_name.setText(result.getTitle());
            item_01ViewHolder.tv_content.setText(result.getSummary());
            item_01ViewHolder.tv_source.setText(result.getSource());
            item_01ViewHolder.tv_time.setText(result.getReleaseTime());
            item_01ViewHolder.tv_share_count.setText(result.getShare());
            item_01ViewHolder.tv_like_count.setText(result.getCollection());
        } else if (getItemViewType(i) == ITEM_02) {
            item_02ViewHolder.tv_content.setText(result.getInfoAdvertisingVo().getContent());
            Glide.with(context).load(result.getInfoAdvertisingVo().getPic());
        } else if (getItemViewType(i) == ITEM_03) {
            Glide.with(context).load(result.getThumbnail()).into(item_03ViewHolder.iv_icon);
            item_03ViewHolder.tv_name.setText(result.getTitle());
            item_03ViewHolder.tv_content.setText(result.getSummary());
            item_03ViewHolder.tv_source.setText(result.getSource());
            item_03ViewHolder.tv_time.setText(result.getReleaseTime());
            item_03ViewHolder.tv_share_count.setText(result.getShare());
            item_03ViewHolder.tv_like_count.setText(result.getCollection());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == BANNER) {
            return BANNER;
        } else if (position == ITEM_01) {
            return ITEM_01;
        } else if (position == ITEM_02) {
            return ITEM_02;
        } else if (position == ITEM_03) {
            return ITEM_03;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class BannerViewHolder extends XRecyclerView.ViewHolder {

        private final XBanner xbanner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            xbanner = itemView.findViewById(R.id.xbanner);
        }
    }

    static class Item_01ViewHolder extends XRecyclerView.ViewHolder {

        private final ImageView iv_icon;
        private final TextView tv_name;
        private final TextView tv_content;
        private final TextView tv_source;
        private final TextView tv_time;
        private final ImageView iv_like;
        private final TextView tv_like_count;
        private final ImageView iv_share;
        private final TextView tv_share_count;

        public Item_01ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_source = itemView.findViewById(R.id.tv_source);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_like = itemView.findViewById(R.id.iv_like);
            tv_like_count = itemView.findViewById(R.id.tv_like_count);
            iv_share = itemView.findViewById(R.id.iv_share);
            tv_share_count = itemView.findViewById(R.id.tv_share_count);
        }
    }

    static class Item_02ViewHolder extends XRecyclerView.ViewHolder {

        private final TextView tv_content;
        private final ImageView iv_icon;

        public Item_02ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);
            iv_icon = itemView.findViewById(R.id.iv_icon);
        }
    }

    static class Item_03ViewHolder extends XRecyclerView.ViewHolder {
        private final ImageView iv_icon;
        private final TextView tv_name;
        private final TextView tv_content;
        private final TextView tv_source;
        private final TextView tv_time;
        private final ImageView iv_like;
        private final TextView tv_like_count;
        private final ImageView iv_share;
        private final TextView tv_share_count;

        public Item_03ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_source = itemView.findViewById(R.id.tv_source);
            tv_time = itemView.findViewById(R.id.tv_time);
            iv_like = itemView.findViewById(R.id.iv_like);
            tv_like_count = itemView.findViewById(R.id.tv_like_count);
            iv_share = itemView.findViewById(R.id.iv_share);
            tv_share_count = itemView.findViewById(R.id.tv_share_count);
        }
    }
}
