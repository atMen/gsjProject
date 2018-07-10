package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.jzfptzInfo;
import customer.tcrj.com.zsproject.bean.tpxwInfo;


/**
 * desc: .List<jzfptzInfo.ProvinceBean> province
 * author: Will .
 * date: 2017/9/27 .
 */
public class jzfptzAdapter extends BaseQuickAdapter<jzfptzInfo.ProvinceBean, BaseViewHolder> {
    private Context mContext;

    public jzfptzAdapter(@Nullable List<jzfptzInfo.ProvinceBean> data, Context context) {
        super(R.layout.jzfp_tz_item, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, jzfptzInfo.ProvinceBean item) {
        TextView name = helper.getView(R.id.city);
        name.setText(item.getCityName());

//        TextView time = helper.getView(R.id.time);
//        TextView sex = helper.getView(R.id.sex);
//        TextView duty = helper.getView(R.id.duty);
//        ImageView im_icon = helper.getView(R.id.im_icon);

    }


}
