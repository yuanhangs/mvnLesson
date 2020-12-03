package org.aly.hlx.entity;

/**
 * @ClassName: UserType
 * @Description: TODO
 * @Author: 沈佳程
 * @date: 2020/12/2 14:37
 * @Version: V1.0
 */

public class UserType {
    private int typeID;
    private String typeName;

    public UserType() {
    }

    public UserType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "typeID=" + typeID +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
