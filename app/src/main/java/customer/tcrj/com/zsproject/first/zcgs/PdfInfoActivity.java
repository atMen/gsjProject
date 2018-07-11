package customer.tcrj.com.zsproject.first.zcgs;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.bean.pxInfo;
import customer.tcrj.com.zsproject.pdf.PdfActivity;


public class PdfInfoActivity extends BaseActivity {

    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.spmc)
     TextView spmc;
    @BindView(R.id.scgs)
     TextView scgs;
    @BindView(R.id.sctime)
     TextView sctime;
    @BindView(R.id.tvjj)
     TextView tvjj;
    @BindView(R.id.down)
    TextView down;

    pxInfo.ContentBean item;
    String TYPE = "pdf";

    @Override
    protected int setLayout() {
        return R.layout.activity_pdf_info;
    }

    @Override
    protected void setView() {

        txtTitle.setText("文件详情");
    }

    @Override
    protected void setData() {
        item = (pxInfo.ContentBean) getIntent().getSerializableExtra("pxInfo");
        if(item != null){

            spmc.setText("文件名称："+item.getTitle());
            scgs.setText("上传公司："+item.getOrganizationName());
            sctime.setText("上传时间："+item.getUploadTime());
            tvjj.setText(item.getDescribe());
        }
    }

    @OnClick({R.id.btnback,R.id.down})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnback:
                finish();
                break;
            case R.id.down:

                if(TYPE.equals(item.getFormat())){
                    Bundle bundle = new Bundle();
                    bundle.putString("cover", ApiConstants.BASEIMAGE+item.getCover());
                    toClass(this,PdfActivity.class,bundle);
                }else {
                    T("暂无法在手机端查看");
                }

                break;
            default:

        }
    }

}
