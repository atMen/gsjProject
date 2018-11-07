package customer.tcrj.com.zsproject.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.Utils.ShowImageUtils;
import customer.tcrj.com.zsproject.bean.jdInfo;


/**
 * desc: .
 * author: Will .
 * date: 2017/9/27 .
 */
public class zscqflyzAdapter extends BaseQuickAdapter<jdInfo.ContentBean, BaseViewHolder> {
    private Context mContext;

    public zscqflyzAdapter(@Nullable List<jdInfo.ContentBean> data, Context context) {
        super(R.layout.item_zscqflyz, data);
        this.mContext = context;
    }


    @Override
    protected void convert(final BaseViewHolder helper, jdInfo.ContentBean item) {
//        TextView name = helper.getView(R.id.name);
//        TextView time = helper.getView(R.id.time);
//        TextView zsbh = helper.getView(R.id.sex);
//        TextView zmal = helper.getView(R.id.duty);
//
//        TextView tv_scly = helper.getView(R.id.tv_scly);
//        TextView phone = helper.getView(R.id.cpname);
//        TextView yx = helper.getView(R.id.cptime);
//        ImageView im_icon = helper.getView(R.id.im_icon);
//
//        name.setText(item.getName());
//        time.setText("从业时间："+item.getJoinJobTime());
//        zsbh.setText("资格证书编号："+item.getZgzsbh());
//        zmal.setText("著名案例："+item.getZmal());
//        tv_scly.setText(item.getScly());
//        phone.setText(item.getLxdh());
//        yx.setText(item.getEmail());
//        ShowImageUtils.showImageView(mContext, ApiConstants.URLBASE8080+item.getPhoto(),im_icon);





    }


}
