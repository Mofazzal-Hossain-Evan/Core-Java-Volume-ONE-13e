# 🧠 Java Ternary Expression মনে রাখার কৌশল

## 🤔 কোনটা মনে রাখতে ভুলে যাই?
```java
name == null ? 0 : name.hashCode()
```

---

## 🔁 মনে রাখার বাংলা ছন্দ:
> **"নেম যদি নাল হয়, দে 0; না হলে দে হ্যাশ!"** 😄

---

## 📖 কী করে এই লাইনটা?

এই লাইনটি হলো একটি **ternary expression**, অর্থাৎ সংক্ষিপ্ত `if-else`:

- যদি `name` == `null` হয় ➡️ `0` রিটার্ন করবে
- যদি `name` null না হয় ➡️ `name.hashCode()` রিটার্ন করবে

---

## ✅ কেন দরকার?

এই expression সাধারণত `hashCode()` method override করার সময় ব্যবহার করা হয়:

```java
@Override
public int hashCode() {
    return Objects.hash(name == null ? 0 : name.hashCode(), age);
}
```

🔐 কারণ: যদি `name` null হয় এবং তুমি সরাসরি `name.hashCode()` করো, তাহলে `NullPointerException` হবে।

---

## 🧪 উদাহরণ:

```java
String name = null;
int hash = name == null ? 0 : name.hashCode(); // hash = 0

name = "Hello";
hash = name == null ? 0 : name.hashCode(); // hash = "Hello".hashCode()
```

---

## 📌 মনে রাখার টিপস:

- `?` মানে "যদি"
- `:` মানে "নয় তো"
- `null` হলে `0` দাও — এটা safe
- `null` না হলে — `hashCode()` দাও

---

## 🧡 উপসংহার

এই ছন্দটা মনে রাখো:

> **"নেম যদি নাল হয়, দে 0; না হলে দে হ্যাশ!"**

তাহলেই আর ভুল হবে না ইনশাআল্লাহ্‌! 😄

