package customer.tcrj.com.zsproject.first.zcgs;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.zsproject.ApiConstants;
import customer.tcrj.com.zsproject.MyApp;
import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.adapter.flfwFragmentPagerAdapter;
import customer.tcrj.com.zsproject.adapter.xwdtFragmentPagerAdapter;
import customer.tcrj.com.zsproject.base.BaseActivity;
import customer.tcrj.com.zsproject.bean.flInfo;

import static android.R.attr.data;

public class flActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tab_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_main)
    ViewPager mViewPager;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;
    private MyOkHttp mMyOkhttp;

    private flfwFragmentPagerAdapter myFragmentPagerAdapter;
    List<flInfo.DataBean> data;


    @Override
    protected int setLayout() {
        return R.layout.activity_xwdt_info;
    }

    @Override
    protected void setView() {

//        mViewPager.setOffscreenPageLimit(4);

        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        getNum();

        txtTitle.setText("法律服务");
        btnback.setOnClickListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnback:
                finish();
                break;
        }
    }
    private void getNum() {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("page", "");
            jsonObject.put("size", "");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.fwzx_fl_listApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<flInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Log.e("TAG","msg"+statusCode);
                    }

                    @Override
                    public void onSuccess(int statusCode, flInfo response) {
                        data = response.getData();

                        setview();

                    }
                });
    }

    private void setview() {
        myFragmentPagerAdapter = new flfwFragmentPagerAdapter(getSupportFragmentManager(),data);

        mViewPager.setAdapter(myFragmentPagerAdapter);

        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMyOkhttp.cancel(this);
    }
}
