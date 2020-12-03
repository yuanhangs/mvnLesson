package org.hlx.entity;

/**
 * 实体类
 */
public class Cards {
    //属性字段
    private int id;
    private String card;
    private String name;
    private String pwd;

    public Cards(int id, String card, String pwd) {
        this.id = id;
        this.card = card;
        this.pwd = pwd;
    }

    public Cards(int id, String card, String name, String pwd) {
        this.id = id;
        this.card = card;
        this.name = name;
        this.pwd = pwd;
    }

    public Cards(String card, String name) {
        this.card = card;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", card='" + card + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
