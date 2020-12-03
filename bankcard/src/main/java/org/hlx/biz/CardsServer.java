package org.hlx.biz;

import org.hlx.entity.Cards;
import org.hlx.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardsServer extends BaseDao {
    /**
     * 登录
     *
     * @param cards
     * @return
     */
    public int isLogin(Cards cards) {

        //sql语句
        String sql = "select count(1) from cards where card=? and pwd=?";
        //设置值
        Object[] obj = new Object[]{cards.getCard(), cards.getPwd()};

        ResultSet rs = null;
        //调用方法
        try {
            rs = this.queryQuery(sql, obj);

            //获得值
            rs.next();

            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            this.closeAll(rs, this.ps, this.con);
        }
        return 0;
    }


    public int add(Cards cards) {
        //sql语句
        String sql = "insert into cards(card,name) values(?,?)";
        //设置值
        Object[] obj = new Object[]{cards.getCard(), cards.getName()};
        //调用方法
        try {
            return this.queryUpdate(sql, obj);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
