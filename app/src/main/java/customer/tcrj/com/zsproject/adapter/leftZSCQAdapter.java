package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.TextView;

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
public class leftZSCQAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public leftZSCQAdapter(@Nullable List<String> data) {
        super(R.layout.item_zxwj, data);
    }


    @Override
    protected void convert(final BaseViewHolder helper, String item) {
        TextView name = helper.getView(R.id.tv_title);
        name.setText(item);
//        TextView time = helper.getView(R.id.time);
//        TextView sex = helper.getView(R.id.sex);
//        TextView duty = helper.getView(R.id.duty);
//        ImageView im_icon = helper.getView(R.id.im_icon);

    }


}
