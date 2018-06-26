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
import customer.tcrj.com.zsproject.mine.MineFragment;

/**
 * Created by leict on 2018/4/19.
 */

public class xwdtFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"图片新闻", "要闻动态", "最新文件", "通知公告", "领导讲话",
            "重要活动", "媒体关注"};

    public xwdtFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new xwdtFregment();
        } else if (position == 1) {
            return new xwdeTPFregment();
        }else if (position == 2){
            return new zxwjFregment();
        }else if (position == 3){
            return new gzggFregment();
        }else if (position == 4){
            return new ldjhFregment();
        }else if (position == 5){
            return new zyhdFregment();
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

