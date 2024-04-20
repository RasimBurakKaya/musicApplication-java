
public class Profile {
    private String fullName;
    private int age;
    private String country;

    public Profile(String fullName,int age, String country) {
        this.fullName = fullName;
        this.age = age;
        this.country = country;
    }

   
    public String getFullName() {
        return fullName;
    }

    public void setFirstName(String fullName) {
        this.fullName = fullName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void printProfile() {
        System.out.println("Name and Surname: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
    }
}