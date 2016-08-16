package com.example.listviewdemo;

//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？  

/**
 * Created by jackiechan on 16/8/9.
 */
public class NewsBean {
    /**
     * id	:	494810
     * <p>
     * Content	:	0
     * <p>
     * title	:
     * <p>
     * postdate	:	2016/8/9 9:49:24
     * <p>
     * editor	:	朝晖
     * <p>
     * icon	:	http://img1.mydrivers.com/img/20160809/8eceb3eb8359415b80ae5145cee54703.jpg
     * <p>
     * desc	:	据国外媒体报道，如今在我们的生活中，互联网可谓无处不在。为了直观地了解到全球互联网接入设备的具体分布情况，一位...
     * <p>
     * reviewcount	:	0
     * <p>
     * stress	:
     * <p>
     * isdel	:	False
     * <p>
     * ispass	:	True
     */
    private int id;
    private int Content;
    private String title;
    private String postdate;
    private String editor;
    private String icon;
    private String desc;
    private int reviewcount;
    private boolean isdel;
    private boolean ispass;

    public int getContent() {
        return Content;
    }

    public void setContent(int content) {
        Content = content;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isdel() {
        return isdel;
    }

    public void setIsdel(boolean isdel) {
        this.isdel = isdel;
    }

    public boolean ispass() {
        return ispass;
    }

    public void setIspass(boolean ispass) {
        this.ispass = ispass;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public int getReviewcount() {
        return reviewcount;
    }

    public void setReviewcount(int reviewcount) {
        this.reviewcount = reviewcount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
