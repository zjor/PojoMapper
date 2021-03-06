PojoMapper
==========
Sample class which allows to populate POJO fields from Map and Map from POJO with annotation.

```java
public class MapInflaterExample {

        public static void main(String[] args) throws InstantiationException, IllegalAccessException {
                Map<String, Object> data = new HashMap<String, Object>();
                data.put("first_name", "James");
                data.put("last_name", "Stone");
                data.put("age", 25);

                Person p = Mapper.fromMap(data, Person.class);
                System.out.println("Created from map: " + p);
                System.out.println("Mapped back: " + Mapper.toMap(p));
        }

}

class Person {

        @Key("first_name")
        private String firstName;

        @Key("last_name")
        private String lastName;

        @Key("age")
        private int age;

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("Person{");
                sb.append("firstName='").append(firstName).append('\'');
                sb.append(", lastName='").append(lastName).append('\'');
                sb.append(", age=").append(age);
                sb.append('}');
                return sb.toString();
        }
}
```
