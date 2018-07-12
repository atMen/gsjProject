package customer.tcrj.com.zsproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/7/12.
 */

public class jdInfo
{

    /**
     * content : [{"bankId":"ff8080816488b31c01648c1162a10018","bankName":"","departmentId":"","id":"ff8080816488b31c01648c12ff04001e","limit":"44","name":"中国银行聚宝盆","nll":"44","note":"","optime":{"date":12,"day":4,"hours":11,"minutes":24,"month":6,"seconds":1,"time":1531365841943,"timezoneOffset":-480,"year":118},"person":"王先生","phone":"18149297793","quota":"44","state":"1","userId":"","workType":"小微微贷业务","ywgjys":"柜台、网银、手机银行、微信银行"},{"bankId":"ff8080816488b31c01648c112c300016","bankName":"","departmentId":"","id":"ff8080816488b31c01648c12248d001a","limit":"1","name":"西安银行聚宝盆","nll":"1","note":"","optime":{"date":12,"day":4,"hours":11,"minutes":24,"month":6,"seconds":1,"time":1531365841943,"timezoneOffset":-480,"year":118},"person":"张先生","phone":"18149297793","quota":"10","state":"1","userId":"","workType":"小微抵押业务","ywgjys":"柜台、网银、手机银行、微信银行"},{"bankId":"ff8080816488b31c01648c1102d60014","bankName":"","departmentId":"","id":"ff8080816488b31c01648c12916c001c","limit":"33","name":"长安银行聚宝盆","nll":"33","note":"","optime":{"date":12,"day":4,"hours":11,"minutes":24,"month":6,"seconds":1,"time":1531365841943,"timezoneOffset":-480,"year":118},"person":"李先生","phone":"18149297793","quota":"33","state":"1","userId":"","workType":"小微微贷业务","ywgjys":"非保本浮动收益型"}]
     * first : true
     * last : true
     * number : 0
     * numberOfElements : 3
     * size : 9999
     * sort : {}
     * totalElements : 3
     * totalPages : 1
     */

    private boolean first;
    private boolean last;
    private int number;
    private int numberOfElements;
    private int size;
    private SortBean sort;
    private int totalElements;
    private int totalPages;
    private List<ContentBean> content;

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SortBean getSort() {
        return sort;
    }

    public void setSort(SortBean sort) {
        this.sort = sort;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class SortBean {
    }

    public static class ContentBean {
        /**
         * bankId : ff8080816488b31c01648c1162a10018
         * bankName :
         * departmentId :
         * id : ff8080816488b31c01648c12ff04001e
         * limit : 44
         * name : 中国银行聚宝盆
         * nll : 44
         * note :
         * optime : {"date":12,"day":4,"hours":11,"minutes":24,"month":6,"seconds":1,"time":1531365841943,"timezoneOffset":-480,"year":118}
         * person : 王先生
         * phone : 18149297793
         * quota : 44
         * state : 1
         * userId :
         * workType : 小微微贷业务
         * ywgjys : 柜台、网银、手机银行、微信银行
         */

        private String bankId;
        private String bankName;
        private String departmentId;
        private String id;
        private String limit;
        private String name;
        private String nll;
        private String note;
        private OptimeBean optime;
        private String person;
        private String phone;
        private String quota;
        private String state;
        private String userId;
        private String workType;
        private String ywgjys;

        public String getBankId() {
            return bankId;
        }

        public void setBankId(String bankId) {
            this.bankId = bankId;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNll() {
            return nll;
        }

        public void setNll(String nll) {
            this.nll = nll;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public OptimeBean getOptime() {
            return optime;
        }

        public void setOptime(OptimeBean optime) {
            this.optime = optime;
        }

        public String getPerson() {
            return person;
        }

        public void setPerson(String person) {
            this.person = person;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getQuota() {
            return quota;
        }

        public void setQuota(String quota) {
            this.quota = quota;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWorkType() {
            return workType;
        }

        public void setWorkType(String workType) {
            this.workType = workType;
        }

        public String getYwgjys() {
            return ywgjys;
        }

        public void setYwgjys(String ywgjys) {
            this.ywgjys = ywgjys;
        }

        public static class OptimeBean {
            /**
             * date : 12
             * day : 4
             * hours : 11
             * minutes : 24
             * month : 6
             * seconds : 1
             * time : 1531365841943
             * timezoneOffset : -480
             * year : 118
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }
        }
    }
}
