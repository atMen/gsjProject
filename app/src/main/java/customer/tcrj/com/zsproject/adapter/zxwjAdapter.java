package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.qyListInfo;
import customer.tcrj.com.zsproject.bean.tpxwInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class zxwjAdapter extends BaseQuickAdapter<tpxwInfo.ListinfoBean, BaseViewHolder> {
    private Context mContext;

    public zxwjAdapter(@Nullable List<tpxwInfo.ListinfoBean> data, Context context) {
        super(R.layout.item_zxwj, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, tpxwInfo.ListinfoBean item) {
        TextView name = helper.getView(R.id.tv_title);
        name.setText(item.getTitle());

//        TextView time = helper.getView(R.id.time);
//        TextView sex = helper.getView(R.id.sex);
//        TextView duty = helper.getView(R.id.duty);
//        ImageView im_icon = helper.getView(R.id.im_icon);

    }


}
