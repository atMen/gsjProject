package customer.tcrj.com.zsproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/7/5.
 */

public class pxInfo {

    /**
     * content : [{"cover":"/uploadfile//2018-06-29/20180629091428718.jpg","departmentId":"","describe":"asd","format":"docx","id":"470856a2d475422681befd080f03d6af","optime":{"date":27,"day":3,"hours":10,"minutes":38,"month":5,"nanos":215000000,"seconds":21,"time":1530067101215,"timezoneOffset":-480,"year":118},"organizationName":"","path":"/uploadfile//2018-06-29/20180629091407296.docx","playTime":18,"state":"0","timeLength":12,"title":"asd","trainType":"10301","trainTypeName":"","uploadTime":"2018-06-27 10:38:21","userId":"1","userName":""},{"cover":"/uploadfile//2018-06-29/20180629091046832.jpg","departmentId":"","describe":"12","format":"mp4","id":"5656835af70d4e4a838f58abecb69bce","optime":{"date":27,"day":3,"hours":10,"minutes":23,"month":5,"nanos":297000000,"seconds":53,"time":1530066233297,"timezoneOffset":-480,"year":118},"organizationName":"","path":"/uploadfile//2018-06-27/video.mp4","playTime":17,"state":"0","timeLength":12,"title":"测试标题","trainType":"10301","trainTypeName":"","uploadTime":"2018-06-27 10:23:53","userId":"1","userName":""},{"cover":"/uploadfile//2018-06-29/20180629090451753.jpg","departmentId":"","describe":"12","format":"mp4","id":"2c58873b7db34609b43cda192a7f085c","optime":{"date":27,"day":3,"hours":10,"minutes":22,"month":5,"nanos":648000000,"seconds":11,"time":1530066131648,"timezoneOffset":-480,"year":118},"organizationName":"","path":"/uploadfile//2018-06-29/20180629090439736.mp4","playTime":10,"state":"0","timeLength":11,"title":"测试1","trainType":"10301","trainTypeName":"","uploadTime":"2018-06-27 10:22:11","userId":"1","userName":""},{"cover":"/uploadfile//2018-06-29/20180629090524517.jpg","departmentId":"","describe":"","format":"mp4","id":"39e57c3a4237406e87e76f7fba0243d0","optime":{"date":26,"day":2,"hours":17,"minutes":38,"month":5,"nanos":929000000,"seconds":48,"time":1530005928929,"timezoneOffset":-480,"year":118},"organizationName":"","path":"/uploadfile//2018-06-29/20180629090520008.mp4","playTime":18,"state":"0","timeLength":12,"title":"测试2","trainType":"10301","trainTypeName":"","uploadTime":"2018-06-26 17:38:48","userId":"1","userName":""},{"cover":"/uploadfile//2018-06-29/20180629090948926.png","departmentId":"","describe":"asd","format":"pdf","id":"ece9a2f4b0d94a4dac2325b7909b54ee","optime":{"date":26,"day":2,"hours":15,"minutes":49,"month":5,"nanos":947000000,"seconds":40,"time":1529999380947,"timezoneOffset":-480,"year":118},"organizationName":"","path":"/uploadfile//2018-06-29/20180629090938013.pdf","playTime":12,"state":"0","timeLength":0,"title":"测试课件","trainType":"10301","trainTypeName":"","uploadTime":"2018-06-26 15:49:42","userId":"1","userName":""}]
     * first : true
     * last : true
     * number : 0
     * numberOfElements : 5
     * size : 10
     * sort : {}
     * totalElements : 5
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
         * cover : /uploadfile//2018-06-29/20180629091428718.jpg
         * departmentId :
         * describe : asd
         * format : docx
         * id : 470856a2d475422681befd080f03d6af
         * optime : {"date":27,"day":3,"hours":10,"minutes":38,"month":5,"nanos":215000000,"seconds":21,"time":1530067101215,"timezoneOffset":-480,"year":118}
         * organizationName :
         * path : /uploadfile//2018-06-29/20180629091407296.docx
         * playTime : 18
         * state : 0
         * timeLength : 12
         * title : asd
         * trainType : 10301
         * trainTypeName :
         * uploadTime : 2018-06-27 10:38:21
         * userId : 1
         * userName :
         */

        private String cover;
        private String departmentId;
        private String describe;
        private String format;
        private String id;
        private OptimeBean optime;
        private String organizationName;
        private String path;
        private int playTime;
        private String state;
        private int timeLength;
        private String title;
        private String trainType;
        private String trainTypeName;
        private String uploadTime;
        private String userId;
        private String userName;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public OptimeBean getOptime() {
            return optime;
        }

        public void setOptime(OptimeBean optime) {
            this.optime = optime;
        }

        public String getOrganizationName() {
            return organizationName;
        }

        public void setOrganizationName(String organizationName) {
            this.organizationName = organizationName;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getPlayTime() {
            return playTime;
        }

        public void setPlayTime(int playTime) {
            this.playTime = playTime;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getTimeLength() {
            return timeLength;
        }

        public void setTimeLength(int timeLength) {
            this.timeLength = timeLength;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTrainType() {
            return trainType;
        }

        public void setTrainType(String trainType) {
            this.trainType = trainType;
        }

        public String getTrainTypeName() {
            return trainTypeName;
        }

        public void setTrainTypeName(String trainTypeName) {
            this.trainTypeName = trainTypeName;
        }

        public String getUploadTime() {
            return uploadTime;
        }

        public void setUploadTime(String uploadTime) {
            this.uploadTime = uploadTime;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public static class OptimeBean {
            /**
             * date : 27
             * day : 3
             * hours : 10
             * minutes : 38
             * month : 5
             * nanos : 215000000
             * seconds : 21
             * time : 1530067101215
             * timezoneOffset : -480
             * year : 118
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int nanos;
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

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
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
