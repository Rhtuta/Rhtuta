package OPPs;

public class Course {
    String name;
    int duration;

    Course(){
        this("DSA", 6);
        System.out.println("called default construtor");

    }
    Course(String name){
        System.out.println("called parameterized construtor single argument");
        System.out.println(name);
        this.name = name;
    }
    Course(String name, int duration){
        System.out.println("called parameterized construtor double argument");
        System.out.println(name);
        System.out.println(duration);
        this.name = name;
        this.duration = duration;
    }

    public static void main(String[] args) {
        System.out.println("called first object");
        Course c1 = new Course();
        System.out.println("called second object");
        Course c2 = new Course("java");
        //c2.name = "java";
        System.out.println(c2.name);
        System.out.println("called third object");
        Course c3 = new Course("devops", 5);
        //c3.name = "devops";
        c1.learn(c1);
        c2.learn(c2);
        c3.learn(c3);
    }
    void learn(Course c1){
        System.out.println("name: "+c1.name);
        System.out.println("duration: "+c1.duration);
        this.skill();
        skill2(this);
    }
    void skill(){
        System.out.println("My skill is "+name);
    }
    void skill2(Course c1){    //for skill(this);
        System.out.println("My skill is "+c1.name);
    }
}
