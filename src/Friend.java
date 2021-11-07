public class Friend {
    String name;
    String phone;
    String email;

    public Friend(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public String toString() {
        return name + " " + phone + " " + email;
    }
}


