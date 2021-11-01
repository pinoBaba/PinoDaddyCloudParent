package io.pd.product.entity;

import java.util.Date;

/**
 * @Description 产品实体类
 * @author: PinoDaddy
 * @date: 2021/11/1
 */
public class productVO {
    private String id;
    private String name;
    private Date date;

    public productVO(String id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("productVO{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
