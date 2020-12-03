import org.aly.hlx.biz.UserinfoBiz;
import org.aly.hlx.biz.impl.UserinfoBizImpl;
import org.aly.hlx.entity.UserInfo;
import org.junit.Test;

import java.util.List;

public class TestUserinfo {

    @Test
    public void login() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        //封装对象
//        UserInfo user = new UserInfo("孙主管", "aaa");
        UserInfo user = new UserInfo("刘丽", "pass123");
        try {
            //调用方法
            UserInfo userInfo = biz.isLogin(user);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void all() {
        //实例化对象
        UserinfoBiz biz = new UserinfoBizImpl();
        //参数
        Object[] obj={"经"};
        try {
            //调用方法
//            List<UserInfo> userInfos = biz.all();
             List<UserInfo> userInfos = biz.all(obj);
            //循环遍历
            for(UserInfo userInfo:userInfos) {
                System.out.println(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
