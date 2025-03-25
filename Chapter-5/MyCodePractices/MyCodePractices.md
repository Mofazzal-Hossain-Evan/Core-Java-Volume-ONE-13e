# Java Inheritance - Subclass Constructors (বাংলায় ব্যাখ্যা)

## 🔥 Inheritance (উত্তরাধিকার) কী?

Inheritance এমন একটি ধারণা যেখানে **একটি ক্লাস (Subclass) আরেকটি ক্লাসের (Superclass) বৈশিষ্ট্য ও মেথড ব্যবহার করতে পারে।**

এখানে `` ক্লাস `` ক্লাস থেকে ইনহেরিট করেছে:

```java
public class Manager extends Employee
```

✅ **এতে করে **``** ক্লাস **``** ক্লাসের ফিল্ড ও মেথড পেয়ে যায়।** ✅ কিন্তু `Employee` ক্লাসের `private` ফিল্ড সরাসরি ব্যবহার করা যাবে না।

---

## 🔥 `super` কীভাবে কাজ করে?

`super` হল এমন একটি কীওয়ার্ড যা **প্যারেন্ট ক্লাসের কনস্ট্রাক্টর অথবা মেথড কল করতে ব্যবহৃত হয়।**

### ➤ **কনস্ট্রাক্টর কল করার জন্য **``

`Manager` ক্লাসের কনস্ট্রাক্টর:

```java
public Manager(String name, double salary, int year, int month, int day) {
   super(name, salary, year, month, day); // Employee কনস্ট্রাক্টর কল
   bonus = 0;
}
```

➡ ``** কল করে **``** ক্লাসের কনস্ট্রাক্টর চালানো হয়েছে।** ➡ কারণ ``** ক্লাস সরাসরি **``**-এর **``** ফিল্ড এক্সেস করতে পারে না।**

---

## 🔥 Method Overriding (মেথড পুনঃলিখন) কেন দরকার?

আমরা `Employee` ক্লাসের `` মেথড দেখি:

```java
public double getSalary() {
   return salary;
}
```

➡ এটি **শুধু বেস স্যালারি রিটার্ন করে।**

কিন্তু `Manager`-এর **বোনাস** আছে, তাই আমাদের নতুনভাবে `getSalary()` লিখতে হবে:

```java
public double getSalary() {
   double baseSalary = super.getSalary(); // Employee-এর getSalary() কল করা হচ্ছে
   return baseSalary + bonus; // বোনাস যোগ করা হচ্ছে
}
```

✅ **এখন যদি **``** ক্লাসের **``** কল হয়, তাহলে বোনাস যোগ হবে।** ✅ ``** দিয়ে আমরা **``**-এর **``** কল করেছি, যাতে বেস স্যালারি পাওয়া যায়।**

---

## 🔥 Dynamic Binding (পলিমরফিজম)

আমরা যখন `getSalary()` কল করি, তখন **Java স্বয়ংক্রিয়ভাবে বুঝে নেয় কোন মেথড কল হবে।**

```java
for (Employee e : staff) {
   System.out.println(e.getName() + " " + e.getSalary());
}
```

✅ **যদি **``** একটি **``** হয়**, তাহলে `Employee`-এর `getSalary()` কল হবে।\
✅ **যদি **``** একটি **``** হয়**, তাহলে `Manager`-এর `getSalary()` কল হবে।

**এটাই Polymorphism (বহুরূপীতা)।** 📌 **C++-এ dynamic binding করতে **``** কীওয়ার্ড ব্যবহার করতে হয়, কিন্তু Java-তে এটি ডিফল্টভাবে হয়।**

---

## 🔥 **এই কোডের আউটপুট কী হবে?**

```java
staff[0] = boss; // Manager (bonus = 5000)
staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
staff[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);
```

🔹 যখন `e.getSalary()` কল হবে:

```
Carl Cracker 85000.0   (80000 + 5000)
Harry Hacker 50000.0
Tommy Tester 40000.0
```

✅ ``** হল **``** অবজেক্ট, তাই তার বোনাস যোগ হয়েছে।** ✅ ``** ও **``** হল **``** অবজেক্ট, তাই বোনাস ছাড়াই বেতন দেখিয়েছে।**

---

## 🔥 Final Takeaways (সংক্ষেপে)

✅ ``** ব্যবহার করে প্যারেন্ট ক্লাসের কনস্ট্রাক্টর কল করা যায়।**\
✅ **Method Overriding-এর মাধ্যমে আমরা **``**-এর **``** মেথড পরিবর্তন করেছি।**\
✅ **Polymorphism-এর কারণে অবজেক্টের টাইপ অনুযায়ী সঠিক মেথড রান হয়।**\
✅ **Java-তে মেথড Overriding স্বাভাবিকভাবে হয়, কিন্তু C++-এ **``** লাগে।**

---

**এই ব্যাখ্যা পড়ার পর তোমার কোনো প্রশ্ন থাকলে বলো! 😊**

