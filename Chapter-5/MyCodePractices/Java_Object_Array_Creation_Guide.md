# ☕ Java: Array & Object Creation Techniques

এই ডকুমেন্টে আমরা Java-তে বিভিন্নভাবে `String[]` (অথবা অন্য অ্যারে/অবজেক্ট) কিভাবে তৈরি করা যায় তা দেখব।

---

## 📦 1. ইনলাইন অ্যারে ডিক্লেয়ারেশন (Shorthand)

```java
String[] skills = {"Java", "Spring", "Hibernate"};
```

> শুধুমাত্র ডিক্লেয়ার করার সময় এইভাবে লেখা যায়।

---

## 🛠 2. `new` কীওয়ার্ড দিয়ে অ্যারে তৈরি

```java
String[] skills = new String[]{"Java", "Spring"};
```

> এটি constructor বা method parameter হিসেবে পাঠানোর সময় দরকার হয়।

### ✅ উদাহরণ:
```java
Employee emp = new Employee("Alice", 101, LocalDate.of(2022, 5, 1), new String[]{"Java", "Spring"});
```

---

## 🧑‍💻 3. অ্যারে তৈরি করে পরে ভ্যালু বসানো

```java
String[] skills = new String[2];
skills[0] = "Java";
skills[1] = "Spring";
```

> যদি তুমি প্রথমে অ্যারে তৈরি করতে চাও আর পরে ডাটা বসাতে চাও, তখন এটা কাজে আসে।

---

## 🧪 4. মাল্টি-ডাইমেনশনাল অ্যারে

```java
String[][] devTeams = {
    {"Alice", "Bob"},
    {"Charlie", "Daisy"}
};
```

অথবা,

```java
String[][] devTeams = new String[2][2];
devTeams[0][0] = "Alice";
devTeams[0][1] = "Bob";
```

---

## 🚀 5. অবজেক্ট ইনিশিয়ালাইজেশনের বিভিন্ন উপায়

### 🔸 Simple Constructor

```java
Employee e1 = new Employee("John", 100, LocalDate.of(2023, 1, 1), new String[]{"Java", "Spring"});
```

### 🔸 No-args constructor (if defined)

```java
Employee e2 = new Employee();
e2.setName("Bob");
e2.setId(101);
e2.setHireDate(LocalDate.of(2023, 1, 1));
e2.setSkills(new String[]{"Python"});
```

### 🔸 Using Builder Pattern (Advanced)

```java
Employee e3 = Employee.builder()
    .name("Charlie")
    .id(102)
    .hireDate(LocalDate.now())
    .skills(new String[]{"Kotlin", "Flutter"})
    .build();
```

> এর জন্য Lombok বা নিজে ম্যানুয়ালি builder ক্লাস বানাতে হয়।

---

## 🧠 Tips

- Method বা Constructor-এ সরাসরি অ্যারে পাঠাতে চাইলে `new Type[]{...}` ব্যবহার করো
- `Arrays.toString()` বা `Arrays.deepToString()` ব্যবহার করে সহজে অ্যারে দেখতে পারো
- `Objects.hash(...)` ব্যবহার করলে অ্যারে hash এর সময় `Arrays.hashCode` কাজ করে

---

👉 এখন তুমি confident ভাবে Java-তে যেকোনো ধরনের object বা array তৈরি করতে পারবে!

Happy coding! 🚀