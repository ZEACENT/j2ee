package bean;

public class order {
    public int id;
    public String loginname;
    public String goods;
    public int sum;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getGoods() {
        return goods;
    }
    public void setGoods(String goods) {
        this.goods = goods;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
