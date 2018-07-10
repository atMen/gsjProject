package customer.tcrj.com.zsproject.base;

import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import butterknife.BindView;
import customer.tcrj.com.zsproject.R;


public class NewsinfoActivity extends BaseActivity {


    @BindView(R.id.webView)
    WebView mWebView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.sub_title)
    TextView sub_title;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.source)
    TextView source;
    @BindView(R.id.number)
    TextView number;

    private String contentUrl;

    @Override
    protected int setLayout() {
        return R.layout.activity_newsinfo;
    }

    @Override
    protected void setView() {
        contentUrl = getIntent().getStringExtra("contentUrl");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //支持javascript
        mWebView.getSettings().setJavaScriptEnabled(true);

// 设置可以支持缩放
        mWebView.getSettings().setSupportZoom(true);

// 设置出现缩放工具
        mWebView.getSettings().setBuiltInZoomControls(true);

//设定支持viewport
        mWebView.getSettings().setUseWideViewPort(true);
    }

    @Override
    protected void setData() {
//        mWebView.loadData(contentUrl, "text/html; charset=UTF-8",null);
        mWebView.loadUrl("http://ow365.cn/?i=16237&furl=http://113.200.26.66:8000/upfile/201609220553341.xlsx");
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
