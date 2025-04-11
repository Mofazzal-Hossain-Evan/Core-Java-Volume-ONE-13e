# 🔍 `Objects.hash(id)` কী করে?

```java
return Objects.hash(id);
```

এই লাইনটি Java-এর `java.util.Objects` ক্লাসের একটি স্ট্যাটিক মেথড ব্যবহার করে `id` ফিল্ড-এর জন্য একটি hashCode তৈরি করে।

---

## ✅ কাজের ব্যাখ্যা

- `Objects.hash(id)` আসলে `Arrays.hashCode(new Object[] { id })` এর সমান।
- এটি একটি `Object[]` অ্যারে তৈরি করে, যেখানে `id` রাখা হয়।
- তারপর ঐ array এর জন্য একটি hashCode তৈরি হয়।
- এটি null-safe এবং অনেক ফিল্ডের জন্য একসাথে hashCode বানানো যায়।

---

## ⚠️ Performance Note

- `Objects.hash(...)` একটু কম efficient কারণ এটি একটি অস্থায়ী array তৈরি করে।
- যদি performance sensitive হয়, তাহলে এই স্টাইলটি ভালো:
```java
@Override
public int hashCode() {
    return Integer.hashCode(id);
}
```

---

## 🎯 কখন ব্যবহার করব?

- যখন কোড clean এবং readable রাখতে চাই
- যখন multiple ফিল্ড নিয়ে hashCode তৈরি করতে চাই

উদাহরণ:
```java
Objects.hash(name, salary, hireDate);
```

---

## 🧠 মনে রাখার ট্রিক

> `Objects.hash(...)` = এক বা একাধিক ফিল্ড নিয়ে smart hashCode তৈরি করে।