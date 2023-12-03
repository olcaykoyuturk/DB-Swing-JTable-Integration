package entity;

public class MyTable {
    private String nameSurname;
    private String phone;
    private String age;

    public MyTable(String nameSurname, String phone, String age){
        this.nameSurname = nameSurname;
        this.phone = phone;
        this.age = age;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
