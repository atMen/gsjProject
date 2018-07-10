package customer.tcrj.com.zsproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/7/5.
 */

public class zcgssInfo {

    /**
     * Listinfo : [{"id":"RFVFba","parentId":"Njyma2","name":"西安","path":"#nEFVji#fumIZr#Njyma2#RFVFba#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"1","nocheck":"true"},{"id":"BF7Z3e","parentId":"Njyma2","name":"西咸新区","path":"#nEFVji#fumIZr#Njyma2#BF7Z3e#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"2","nocheck":"true"},{"id":"r26Bvi","parentId":"Njyma2","name":"咸阳","path":"#nEFVji#fumIZr#Njyma2#r26Bvi#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"3","nocheck":"true"},{"id":"MVrYvu","parentId":"Njyma2","name":"宝鸡","path":"#nEFVji#fumIZr#Njyma2#MVrYvu#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"4","nocheck":"true"},{"id":"BBBbmq","parentId":"Njyma2","name":"商洛","path":"#nEFVji#fumIZr#Njyma2#BBBbmq#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"5","nocheck":"true"},{"id":"2IN3iy","parentId":"Njyma2","name":"榆林","path":"#nEFVji#fumIZr#Njyma2#2IN3iy#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"6","nocheck":"true"},{"id":"MV3ymm","parentId":"Njyma2","name":"安康","path":"#nEFVji#fumIZr#Njyma2#MV3ymm#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"7","nocheck":"true"},{"id":"eQ3INb","parentId":"Njyma2","name":"汉中","path":"#nEFVji#fumIZr#Njyma2#eQ3INb#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"8","nocheck":"true"},{"id":"A7BbMz","parentId":"Njyma2","name":"延安","path":"#nEFVji#fumIZr#Njyma2#A7BbMz#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"9","nocheck":"true"},{"id":"BZVF3q","parentId":"Njyma2","name":"渭南","path":"#nEFVji#fumIZr#Njyma2#BZVF3q#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"10","nocheck":"true"},{"id":"6fi2Mv","parentId":"Njyma2","name":"铜川","path":"#nEFVji#fumIZr#Njyma2#6fi2Mv#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"11","nocheck":"true"},{"id":"B3Anma","parentId":"Njyma2","name":"神木","path":"#nEFVji#fumIZr#Njyma2#B3Anma#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"12","nocheck":"true"},{"id":"BFr2ey","parentId":"Njyma2","name":"杨凌","path":"#nEFVji#fumIZr#Njyma2#BFr2ey#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"13","nocheck":"true"},{"id":"VnAbMf","parentId":"Njyma2","name":"韩城","path":"#nEFVji#fumIZr#Njyma2#VnAbMf#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"14","nocheck":"true"},{"id":"f2yAVf","parentId":"Njyma2","name":"府谷","path":"#nEFVji#fumIZr#Njyma2#f2yAVf#","gkzt":"","gksx":"","sxyj":"","gkfs":"","gkgs":"","note":"","gksxid":"","treeSort":"15","nocheck":"true"}]
     * state : 1
     * msg : 操作成功
     */

    private int state;
    private String msg;
    private List<ListinfoBean> Listinfo;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListinfoBean> getListinfo() {
        return Listinfo;
    }

    public void setListinfo(List<ListinfoBean> Listinfo) {
        this.Listinfo = Listinfo;
    }

    public static class ListinfoBean {
        /**
         * id : RFVFba
         * parentId : Njyma2
         * name : 西安
         * path : #nEFVji#fumIZr#Njyma2#RFVFba#
         * gkzt :
         * gksx :
         * sxyj :
         * gkfs :
         * gkgs :
         * note :
         * gksxid :
         * treeSort : 1
         * nocheck : true
         */

        private String id;
        private String parentId;
        private String name;
        private String path;
        private String gkzt;
        private String gksx;
        private String sxyj;
        private String gkfs;
        private String gkgs;
        private String note;
        private String gksxid;
        private String treeSort;
        private String nocheck;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getGkzt() {
            return gkzt;
        }

        public void setGkzt(String gkzt) {
            this.gkzt = gkzt;
        }

        public String getGksx() {
            return gksx;
        }

        public void setGksx(String gksx) {
            this.gksx = gksx;
        }

        public String getSxyj() {
            return sxyj;
        }

        public void setSxyj(String sxyj) {
            this.sxyj = sxyj;
        }

        public String getGkfs() {
            return gkfs;
        }

        public void setGkfs(String gkfs) {
            this.gkfs = gkfs;
        }

        public String getGkgs() {
            return gkgs;
        }

        public void setGkgs(String gkgs) {
            this.gkgs = gkgs;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getGksxid() {
            return gksxid;
        }

        public void setGksxid(String gksxid) {
            this.gksxid = gksxid;
        }

        public String getTreeSort() {
            return treeSort;
        }

        public void setTreeSort(String treeSort) {
            this.treeSort = treeSort;
        }

        public String getNocheck() {
            return nocheck;
        }

        public void setNocheck(String nocheck) {
            this.nocheck = nocheck;
        }
    }
}
