package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
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
public class xwdtTPAdapter extends BaseQuickAdapter<tpxwInfo.ListinfoBean, BaseViewHolder> {
    private Context mContext;

    public xwdtTPAdapter(@Nullable List<tpxwInfo.ListinfoBean> data, Context context) {
        super(R.layout.item_xwdt_yw, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, tpxwInfo.ListinfoBean item) {
        TextView name = helper.getView(R.id.titlename);
        TextView time = helper.getView(R.id.time);

        ImageView im_icon = helper.getView(R.id.sp_icon);

        name.setText(item.getTitle());
        time.setText(item.getShowTime());
        ShowImageUtils.showImageView(mContext,item.getThumbUrl(),im_icon);
    }


}
