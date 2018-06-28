package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class wdfpAdapter extends BaseQuickAdapter<qyListInfo.DataBean.ContentBean, BaseViewHolder> {
    private Context mContext;

    public wdfpAdapter(@Nullable List<qyListInfo.DataBean.ContentBean> data, Context context) {
        super(R.layout.item_wdfp, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, qyListInfo.DataBean.ContentBean item) {
//        TextView name = helper.getView(R.id.name);
//        TextView time = helper.getView(R.id.time);
//        TextView sex = helper.getView(R.id.sex);
//        TextView duty = helper.getView(R.id.duty);
//        ImageView im_icon = helper.getView(R.id.im_icon);

    }


}
