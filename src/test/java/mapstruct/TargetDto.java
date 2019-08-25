package mapstruct;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/21
 */
public class TargetDto {
    private String tName;
    private Integer tAge;
    private String address;

    private int type;
    private long id;

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TargetDto{" +
                "tName='" + tName + '\'' +
                ", tAge=" + tAge +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", id=" + id +
                '}';
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
