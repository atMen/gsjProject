package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.Utils.ShowImageUtils;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.bean.tpxwInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class FreshNewsAdapter extends BaseQuickAdapter<tpxwInfo.ListinfoBean, BaseViewHolder> {
    private Context mContext;

    public FreshNewsAdapter(@Nullable List<tpxwInfo.ListinfoBean> data, Context context) {
        super(R.layout.item_xwdt, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, tpxwInfo.ListinfoBean item) {
        TextView name = helper.getView(R.id.tv_tpms);

        ImageView im_icon = helper.getView(R.id.iv_tpxw);

        name.setText(item.getTitle());
        ShowImageUtils.showImageView(mContext,item.getThumbUrl(),im_icon);

    }


}
