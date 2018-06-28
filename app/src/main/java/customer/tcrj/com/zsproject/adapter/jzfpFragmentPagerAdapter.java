package customer.tcrj.com.zsproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import customer.tcrj.com.zsproject.first.gridbtn.gzggFregment;
import customer.tcrj.com.zsproject.first.gridbtn.ldjhFregment;
import customer.tcrj.com.zsproject.first.gridbtn.xwdeTPFregment;
import customer.tcrj.com.zsproject.first.gridbtn.xwdtFregment;
import customer.tcrj.com.zsproject.first.gridbtn.zxwjFregment;
import customer.tcrj.com.zsproject.first.gridbtn.zyhdFregment;
import customer.tcrj.com.zsproject.first.jzfp.nzxxFregment;
import customer.tcrj.com.zsproject.first.jzfp.tsncpFregment;
import customer.tcrj.com.zsproject.first.jzfp.wyfpFregment;

/**
 * Created by leict on 2018/4/19.
 */

public class jzfpFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"我要扶贫", "台账报表", "陕西龙头企业认定公示", "农资信息", "商标信息",
            "特色农产品推荐"};

    public jzfpFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new wyfpFregment();
        } else if (position == 1) {
            return new xwdeTPFregment();
        }else if (position == 2){
            return new zxwjFregment();
        }else if (position == 3){
            return new nzxxFregment();
        }else if (position == 4){
            return new ldjhFregment();
        }else if (position == 5){
            return new tsncpFregment();
        }
        return new xwdtFregment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }


}

