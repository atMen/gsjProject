package customer.tcrj.com.zsproject.jpush;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;

import customer.tcrj.com.zsproject.R;
import customer.tcrj.com.zsproject.bean.tzInfo;


/**
 * Created by qndroid on 16/11/19.
 *
 * @function 显示推送的消息界面
 */
public class PushMessageActivity extends Activity {

    private TextView title;
    private ImageView backBtn;
    private WebView mWebView = null;
    private TextView sub_title;
    private TextView source;
    private TextView number;
    private TextView date;
    private TextView txtTitle;

    tzInfo.DataBean response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpush_layout);
        StatusBarUtil.setTranslucentForImageView(this,10, null);
        response = (tzInfo.DataBean) getIntent().getSerializableExtra("ztinfo");
        initView();
        getData();
    }


    public void initView() {
        backBtn = (ImageView) findViewById(R.id.btnback);
        backBtn.setVisibility(View.VISIBLE);
        mWebView = (WebView) findViewById(R.id.webView);
        backBtn.setOnClickListener(new OnClick());

        title = (TextView) findViewById(R.id.title);
        sub_title = (TextView) findViewById(R.id.sub_title);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        source = (TextView) findViewById(R.id.source);
        number = (TextView) findViewById(R.id.number);
        date = (TextView) findViewById(R.id.date);
        txtTitle.setText("消息详情");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
    }


    public void getData() {

//      mWebView.loadDataWithBaseURL(null,html, "text/html", "UTF-8",null);
//        Log.e("TAG","content:"+response.getContent());
        if(response != null && response.getContent() != null){
            mWebView.loadDataWithBaseURL(null,response.getContent(), "text/html", "UTF-8",null);
            title.setText(response.getTitle());
            date.setText(response.getUpdateTime());
        }

    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnback:
                    finish();
                    break;

            }
        }
    }

    /**
     * 拦截返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 是否触发按键为back键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back();
            return true;
            // 如果不是back键正常响应
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void back() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            finish();
        }
    }

}
