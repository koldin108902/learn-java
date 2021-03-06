import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
//        const != final
//        final은 const와 같이 상수 선언도 해주나
//        오버라이딩을 통한 타입 변경 제선언도 불가함.+
        final int AGES = 100;
//        타입 변환
        System.out.println((double) AGES);
//        해당 코드의 int부분에 class나 interface가 들어갔을떄 변수가
//        class || interface와 같은 타입인지 알려줌.(bool)
        //        System.out.println(AGES instanceof int);

        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int e : arr) {
            System.out.println(e+" ");
        }
//            1 2 3 4 5 for of?
        Car myCar = new Car("아반떼", 2016);

        Parent testP = new Parent();
        Parent test = new Child();
        test.display(); // 자식 클래스의 display()
//        메소드 오버라이딩
//        부모 메소드를 같은 이름의 메소드를 자식 메소드에 선언함으로써 덮어씌움.

        Parent test2 = new Brother();
        Parent test3 = new Child();
//        Child test4 = new Brother();
//        Child test5 = new Parent();
//        다향성 / 자식 클래스 끼리는 동일 타입으로 취급하지 않고
//        부모 클래스는 자식클래스로 그대로 대입 가능하며
//        부모 클래스는 자식 클래스에 타입 변환 없이 대입 불가.
        System.out.println(test3 instanceof Parent); // true
        System.out.println(test3 instanceof Child); // true
        System.out.println(testP instanceof Child); // false
    }
}

class Parent {
    void display() { System.out.println("부모 클래스의 display() 메소드입니다."); }
}

class Child extends Parent {
    void display() { System.out.println("자식 클래스의 display() 메소드입니다."); }
}

class Brother extends Parent {
    void display() { System.out.println("형제 클래스의 display() 메소드입니다."); }
}

// 추상 클래스는 추상 메소드를 포함하기 위해 있음
// 추상 메소드는 오버라이딩한 "자식" 클래스에게 만들어야하는 메소드를 알려주는 가이드 같은 존재
// abstract class는 상속 관계를 따지며 해당 관계 내에서의 공통 기능이 필요할 때 사용한다.
abstract class abstractTest {
    abstract void cry();
    void crying(){};
}

class Car {
//    this == 자기 자신을 가르킴 
//    this()는 생성자를 가르킴
//    super와 super()도 위와 같음

//    private == 선언된 클래스 내에서만 접근 가능
//    public  == 선언된 클래스를 넘어 다른 패키지에서도 접근 가능
//    default == 선언된 클래스가 있는 패키지 내에서 접근 가능
//    protect == default + 선언된 클래스의 자식 클래스는 다른 패키지에서 접근 가능
    static String className;
    public String modelName;
    public int modelYear;

//    ===========클래스 내의 변수를 초기화 해줄 수 있음.=========
//    인스턴스 초기화 블록
    {
        modelYear = 10;
    }

//    클래스 변수 초기화 블록
    static {
        className = "Car";
    }
//    ===========클래스 내의 변수를 초기화 해줄 수 있음.=========

//    Car setter
    Car(String modelName, int modelYear) {
//        this == 해당 클래스 내의 변수 사용
        this.modelName = modelName;
        this.modelYear = modelYear;
    }

    public String getModel() {
        return this.modelYear+"년식 "+this.modelName;
    }
}

// Car클래스의 defualt생성자가 있어야 함(예제에는 없어도 괜찮다 뜨는데 뭐 그렇다고 하니께)
class hisCar extends Car {
    public int c = 0;

    // 이 부분 이 없으면 디폴트 메소드 없다고 에러뜸
    hisCar(String modelName, int modelYear) {
        super(modelName, modelYear);
    }

    void display() {
        new Car("ionic", 2018);
        System.out.println(getModel());
        System.out.println(c);
    }
}

// 메소드 오버로딩 == 같은 이름의 메소드라도 다른 타입을 가지면 사용 가능.
class Test {
//    static 변수명 == 클래스 변수
//    프로그램 시작시 선언되며 인스턴스와 관련 없이 프로그램 종료까지 남아있음.
//
//    변수 == 인스턴스 변수
//    해당 클래스를 활용해 만드는 인스턴스가 생성될 때부터 끝날때 까지.
//    위 내용은 함수(메소드)에도 동일하게 적용됨
    static void display(int num1) { System.out.println(num1); }
    static void display(int num1, int num2) { System.out.println(num1 * num2); }
    static void display(int num1, double num2) { System.out.println(num1 + num2); }
}

class Method06 {
    void function() {
//        지역 변수는 사용전 초기화 필수
        Test func = new Test();

        func.display(10);
        func.display(10, 20);
        func.display(10, 3.14);
        func.display(10, 'a');
    }
}

// =============== interface ==================
// 모든 필드는 public static final(해당 클래스 자체 선언 및 변경 불가) 이며
// 모든 메소드는 public abstract이다. 제어자는 생략 가능.
interface Animal { void cry(); }
interface Animal2 { void cry(); }

// abstract class(추상 클래스)는 단수만이 상속될 수 있지만
// interface는 implements를 통한 다수의 interface를 상속시킬 수 있다.
// interface와 abstract class는 기능적으론 비슷하나 사용 목적에서 확연한 차이가 난다.

// 추상 클래스는 클래스에서 함수를 정의해 같은 이름의 메소드를 호출하면 둘중 어느 클래스의
// 메소드인지 알 수 없는 모호성을 지니기에 다중성을 금한다.
// interface는 애초에 함수의 가이드이기 때문에 두가지 기능이 완성형으로 들어오지 않기 때문에
// 오버라이딩을 할 때 두개의 메소드를 나누지 않고 한번에 설정이 가능하다.
// *즉 interface는 상속 관계에 상관 없이 공통의 기능이 필요할 때 사용하고
// abstract class는 상속 관계를 따지며 해당 관계 내에서의 공통 기능이 필요할 때 사용한다.*
class Cat implements Animal, Animal2 {
    public void cry() { System.out.println("냐옹냐옹!"); }
}

class Dog implements Animal {
    public void cry() { System.out.println("멍멍!"); }
}

class Polymorphism03 {
    public static void main(String[] args) {
        Cat c = new Cat();
        Dog d = new Dog();

        c.cry();
        d.cry();
    }
}
// =============== interface ==================

// =============== inner class ================
class outer {
//    static한 class 주로 outer 클래스의 메소드 역할
     static class inner1 {}
//    local class 외부 접근은 불가하며 지역 내에서만 사용 가능한 클래스
//    local class ex1)
    { class inner2 {} }
//    local class ex2)
    void innerClass() { class inner3{} }
//    익명 클래스인데 계속 에러 뜸.
//    Insect inner4 = new Insect() {void innerFunc() {}};

//    인스턴트 클래스
//    outer클래스 영역에 정의 됐으며 static제어자가 없는 클래스로 인스턴트 생성시 사용 가능.
    class Inner5 {}
}
// =============== inner class ================

// =============== string buffer ===============
class stringBuffer {
//    string buffer클래스는 string과 달리 가변 클래스이다.
//    insert, append와 같은 함수로 값을 추가할 수 있는데 string은 그런 작업이 concat으로만 가능하게 되어있다.
//    불변 클래스는 멀티 쓰레드에서 하나의 객체에 접근하되 다른 객체에 영향을 주기 싫을떄 사용하는데
//    가변 클래스에 비해 불변성이 보장되기 때문에 신뢰할 수 있는 코드를 짤 수 있기 때문이다.
//
//    stringBuffer는 기본 string의 버퍼 사이즈보다 16정도의 크기를 더 가져 추후 변화에 대응할 수 있게 한다.
//    concat은 문자 한글자를 추가할 때마다 메모리 주소를 할당하는데
//    stringBuffer는 버퍼 자체를 수정하기에 속도가 빠르고 메모리 낭비가 없다.
    private void del() {
        StringBuffer str = new StringBuffer("Hello world!");
        System.out.println(str.delete(4, 8)); // Hellrld!
        System.out.println(str.deleteCharAt(1)); // Hllo world!
        System.out.println(str.insert(5, " the")); // Hello the world!
        System.out.println(str.reverse()); // !dlrow olleH
    }
}
// =============== string buffer ===============

// =============== wrapper =====================
class Wrapper02 {
//    타입과 달리 클래스로서 value만 갖는게 아닌 value는 데이터 형식으로 갖고 있으며 ~Value()를 통해 언박싱이 가능하다.
//    선언부터 래퍼 클래스를 쓰거나 Integer클래스를 int변수에 담으면 오토언박싱이 된다.
    public static void main(String[] args) {
        Integer num1 = new Integer(7); // 박싱
        Integer num2 = new Integer(3); // 박싱

        int int1 = num1.intValue();    // 언박싱
        int int2 = num2.intValue();    // 언박싱

        Integer result1 = num1 + num2; // 10
        Integer result2 = int1 - int2; // 4
        int result3 = num1 * int2;     // 21
    }
    public class Wrapper03 {
        public static void main(String[] args) {
//            아래의 Integer.valueOf == interface 예제
            Integer num1 = Integer.valueOf(20);
            Integer num2 = Integer.valueOf(20);
            Integer num3 = Integer.valueOf(10);

            System.out.println(num1 < num2);       // true
            System.out.println(num1 == num3);      // false
            System.out.println(num1.equals(num3)); // true
        }
    }
}
// =============== wrapper =====================

// =============== enum ====================

// 관련된 상수의 집합.
class enumExample {
    enum Day {
        MONDAY,TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    public enum RoadSide {
        Left("왼쪽"),
        Right("오른쪽");

        //        상수들의 타입
        private String krName;

        //        setter는 추후 업뎃을 하지 않는 상수이기에 private로 한다.
        private RoadSide(String krName) {
            this.krName = krName;
        }

        public String getKrName() {
            return krName;
        }
    }
}
// =============== enum ====================

// =============== generic =================

// go의 제너릭과는 느낌이 다름.
// 하나의 클래스에 정해진 값이 아닌 타입이 들어와서 인스턴스 클래스를 완성해주는 느낌임.

// interface를 쓰더라도 implements가 아닌 extends를 써야 함.
interface WarmBlood {}
class AnimalLists<T extends WarmBlood> {}

class generic {
    class AnimalList<T> {
        ArrayList<T> al = new ArrayList<T>();

        void add(T animal) { al.add(animal); }
        T get(int index) { return al.get(index); }
        boolean remove(T animal) { return al.remove(animal); }
        int size() { return al.size(); }

        public static <T> void sort(ArrayList<T> list, ArrayList<? super T> comp) {}
//        Wild Card
//        <?>           // 타입 변수에 모든 타입을 사용할 수 있음.
//        <? extends T> // T 타입과 T 타입을 상속받는 자손 클래스 타입만을 사용할 수 있음.
//        <? super T>   // T 타입과 T 타입이 상속받은 조상 클래스 타입만을 사용할 수 있음.
    }

    void run() {
//        int, double, char같은 타입은 wrapper을 해야 사용 가능.
        AnimalList<Integer> a = new AnimalList<Integer>();
        AnimalList<String> b = new AnimalList<String>();

        a.add(1);
        b.add("hello world");
    }
}

// =============== generic =================

// =============== Collection Interface ================

// === Array list ===
// ArrayList는 자료구조의 List방식이 아니다.
// ArrayList의 기본 사이즈는 10인데 10개 이상의 값을 넣으면
// 기존 값 + 기존값 / 2를 하여 배열을 복사한다. 이렇다 보니 배열의 장점인 서칭은 가져왔지만 데이터 수정, 추가, 삭제의 속도는 느리다.
// === Array list ===

// === LinkedList ===
// List방식을 따른다.
// SingleLinkedList는 단방향으로 위치를 기억하기에 전 값을 찾기는 힘들다.
// 하지만 DoubleLinkedList가 이 문제점을 해결한다.
// === LinkedList ===

// == LinkedList vs ArrayList ==
//            | ArrayList | LinkedList
// Read speed | fast      | slow
// add, remove| slow      | fast

// etc ArrayList
// 비효율적인 메모리 사용, 데이터의 순차적 추가, 삭제시 빠름.

// etc LinkedList
// 데이터가 많을 수록 접근성은 떨어짐.
// == LinkedList vs ArrayList ==

// === HashSet ===
// hash 알고리즘를 이용한 저장방식이다.
// Key가 배열에 저장될 때 배열의 어느 위치에 저장되는지 숨겨지며 배열 내에 연결리스트도 있다.
// 서칭시 속도가 빠르다
// 값의 중복이 불가능 하다
// === HashSet ===

// === TreeSet ===
// binarySearch tree의 형태로 저장함.
// 값의 중복이 불가능 하다
// 저장되는 값이 모두 정렬된다.
// === TreeSet ===
// =============== Collection Interface ================

// =============== try catch =========================
// catch문 중첩시 주의점.
// 중첩 catch문일떄 처리할 catch문을 찾아내는 방법은 처리할 에러의 타입으로 구분한다.
// 따라서 에러의 상속관계에 대해 잘 살펴야 한다.
// error란 클래스의 에러를 잡을때 Object를 써버리면 Obj는 모든 클래스를 포함할 수 있어 Obj catch에 모든 에러가 막힌다.

// === throwable class ===
// error나 exaption클래스의 부모 클래스로 모든 에러의 부모 클래스이다.
// 에러에 관한 다양한 정보를 읽을 수 있는 메소드를 제공한다.
// === throwable class ===

// === try with resource ===
// try(resource) {} == defer resorce.Close() in Golang
// === try with resource ===
// =============== try catch =========================

// =============== thread ============================
// JAVA는 멀티 쓰레드가 가능한 언어이다.
// Thread클래스를 상속받아 해당 클래스 자체를 타 쓰레드에서 돌게 할 수도 있지만
// Thread test = new Thread(method); test.start()를 통해서 멀티 쓰레드를 실행할 수도 있다.

// === daemon thread ===
// 데몬 쓰레드는 다른 일반 쓰레드를 보조하는 역할을 한다.
// 타 쓰레드가 모두 종료되면 자동 종료된다.
// ex) gabage collector
// === daemon thread ===
// =============== thread ============================

// =============== 람다 표현식 ===============
// () -> {} JS의 Arrow function과 비슷한 형태로 목적도 비슷하다.
// 자바에서는 메소드가 생성됨과 동시에 객체가 생성된다.
// 그렇기에 람다 표현식을 쓰면 이름 없는 객체가 생성돠므로 이를 익명 클래스라 한다.

// === 메소드 참조식 ===
//::는 메소드 참조식이다.
// 클래스를 불러와 그 하위에 있는 메소드를 찾는 것이 아닌 클래스의 메소드를 참조하는 것이다.
// ex) obj.equals() => obj::equals()
// 해당 참조식을 사용하면 불필요한 값들은 참조하지 않고 내가 필요로하는 "메소드만" 참조할 수 있다는 장점이 있다.
// 쉽게말해 난 한가지의 데이터만 필요한데 QueryRow가 아닌 Query를 날려버리는 느낌이다.
// === 메소드 참조식 ===

// === 생성자 참조식 ===
// 단순 객체를 생성하고 리턴하는 람다 표현식이 생성자 참조시엔 매우 효과적이다.
// 성능면에서 좋다기보단 코드 작성시 좀더 편하게 작성이 가능한데 간단한 예를 들어보면
// ex) (a, b) -> { new Student(a, b) } ==> (a, b) -> { Student::new }
// 위 코드와 같이 인자값을 두번 적지 않아도 된다.
// 위 예시에선 한 글자라 차이가 크게 느껴지지 않을 지도 모르지만 변수가 길어질 수록 효율적이다.

// 이는 단순 생성자에서만 한정되는게 아니다.
// 메소드 참조시에도 obj.compare(a, b)가 인자값이라면 (a, b) -> { obj::compare } 또한 가능하다.
// === 생성자 참조식 ===
// =============== 람다 표현식 ===============
