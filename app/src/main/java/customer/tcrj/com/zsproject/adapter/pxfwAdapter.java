package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.Utils.ShowImageUtils;
import customer.tcrj.com.zsproject.bean.pxInfo;
import customer.tcrj.com.zsproject.bean.qyListInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class pxfwAdapter extends BaseQuickAdapter<pxInfo.ContentBean, BaseViewHolder> {
    private Context mContext;

    public pxfwAdapter(@Nullable List<pxInfo.ContentBean> data, Context context) {
        super(R.layout.item_px, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, pxInfo.ContentBean item) {
        TextView name = helper.getView(R.id.name);
        TextView time = helper.getView(R.id.duty);
        ImageView icon = helper.getView(R.id.im_icon);

        name.setText(item.getTitle());
        time.setText(item.getUploadTime());


        ShowImageUtils.showImageView(mContext, ApiConstants.BASEIMAGE+item.getCover(),icon);
//        TextView sex = helper.getView(R.id.sex);
//        TextView duty = helper.getView(R.id.duty);
//        ImageView im_icon = helper.getView(R.id.im_icon);

    }


}
