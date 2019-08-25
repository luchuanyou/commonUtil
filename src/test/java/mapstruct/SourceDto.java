package mapstruct;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/21
 */
public class SourceDto {
    private String sName;
    private Integer sAge;
    private String address;

    private String type;
    private String id;

    public SourceDto(String sName, Integer sAge, String address) {
        this.sName = sName;
        this.sAge = sAge;
        this.address = address;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
