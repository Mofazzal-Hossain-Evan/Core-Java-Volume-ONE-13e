
# 🧠 Analogy: `Arrays.deepToString(new Object[]{obj})` কীভাবে কাজ করে

## 📘 প্রসঙ্গ
কোডটি:
```java
if (obj.getClass().isArray()) {
    return Arrays.deepToString(new Object[]{obj});
}
```
এই অংশটি বুঝতে একটু চিন্তা করতে হয়। তাই চলো, একটা মজার analogy দিয়ে ব্যাপারটা পরিষ্কার করি।

---

## 🍱 analogy: খাবার বক্সের মধ্যে খাবার

ধরো, তোমার কাছে একটা খাবার রয়েছে — যেমন একটি স্যান্ডউইচ (মানে, একটা array)। তুমি সেটা **ডেলিভারি অ্যাপে** পাঠাতে চাও। কিন্তু অ্যাপটি চায়, সব খাবার যেন একটা **বক্সে মোড়া** হয়।

এখন, তুমি স্যান্ডউইচটা সরাসরি পাঠালে অ্যাপটি চিনতে পারবে না বা ভুলভাবে দেখাবে। তাই তুমি করো কী:
> 🥪 → 📦 (box) → অ্যাপে পাঠাও

### কোডের ভাষায়:
- `obj` → স্যান্ডউইচ (array)
- `new Object[]{obj}` → খাবারের বক্সের মধ্যে মোড়ানো
- `Arrays.deepToString(...)` → খাবার বক্স খুলে সুন্দরভাবে দেখানো

---

## 🛠️ কেন এটা দরকার?
`Arrays.deepToString()` শুধুমাত্র nested বা object টাইপ array ভালোভাবে প্রিন্ট করতে পারে।  
কিন্তু যদি `obj` একাই কোনো অ্যারে হয় (যেমন `String[][]`), তখন সরাসরি দিলে ঠিকমতো দেখাবে না।

তাই, `new Object[]{obj}` দিয়ে একটা মোড়ানো লাগে।

---

## 🔁 উদাহরণ
```java
String[][] nested = {{"Alice", "Bob"}, {"Charlie"}};
System.out.println(Arrays.toString(nested));
// ➡️ [[Ljava.lang.String;@hexcode, ...] (কুৎসিত)

System.out.println(Arrays.deepToString(new Object[]{nested}));
// ➡️ [[[Alice, Bob], [Charlie]]] (সুন্দর)
```

---

## ✅ সারসংক্ষেপ:
`Arrays.deepToString(new Object[]{obj})` মানে হচ্ছে:
> "যদি obj অ্যারে হয়, তাহলে তাকে একটা নতুন Object array-এর মধ্যে ঢুকাও, তারপর সুন্দরভাবে প্রিন্ট করো।"

---

👉 এটা হলো Java-এর way to say: “Array হলে, আগে একটা বক্সে ভরে নিই, তারপর সুন্দর করে খুলি!” 😄
