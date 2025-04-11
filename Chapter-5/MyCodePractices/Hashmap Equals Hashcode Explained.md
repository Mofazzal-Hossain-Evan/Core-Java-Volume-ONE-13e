🔍 Java HashMap, equals() এবং hashCode() ব্যাখ্যা সহ
----------------------------------------------------

এই Markdown ফাইলে আমরা ব্যাখ্যা করেছি কীভাবে Java-র `==`, `equals()`, `hashCode()` এবং `HashMap` এর বিভিন্ন মেথড (`containsKey()`, `get()`) কাজ করে।

* * *

### 🔍 ১. `e1 == e2` ➤ **false**

    System.out.println("e1 == e2: " + (e1 == e2));

#### 👉 ব্যাখ্যা:

* `==` চেক করে **object reference**, মানে `e1` আর `e2` মেমোরিতে একই জায়গায় আছে কিনা।

* এখানে `e1` ও `e2` আলাদা object, তাই ফলাফল `false`।

* * *

### 🔍 ২. `e1.equals(e2)` ➤ **true (ঠিক override করলে)** | **false (default version)**

    System.out.println("e1.equals(e2): " + e1.equals(e2));

#### 👉 ব্যাখ্যা:

* `equals()` object সমতা যাচাই করে।

* যদি override না করা হয়, তাহলে এটা `==` এর মতই behave করে।

* override করলে name ও id মিলিয়ে সমতা যাচাই হয়।

#### ✅ ফলাফল:

* ভুল ভার্সন: `false`

* override করা ভার্সন: `true`

* * *

### 🔍 ৩. `map.containsKey(e2)` ➤ **true (ঠিক ভার্সন)** | **false (ভুল ভার্সন)**

    System.out.println("map.containsKey(e2): " + map.containsKey(e2));

#### 👉 ব্যাখ্যা:

* প্রথমে `e2.hashCode()` নিয়ে hash bucket খোঁজে

* তারপর সেই bucket-এ `equals()` দিয়ে মিলিয়ে দেখে

* যদি `hashCode()` ও `equals()` override না করা হয়, match হয় না

#### ✅ ফলাফল:

* ভুল ভার্সন: `false`

* override ভার্সন: `true`

* * *

### 🔍 ৪. `map.get(e2)` ➤ **"Software Engineer" (ঠিক ভার্সন)** | **null (ভুল ভার্সন)**

    System.out.println("map.get(e2): " + map.get(e2));

#### 👉 ব্যাখ্যা:

* `get()` method ওই key দিয়ে value ফেরত দেয়

* key match করতে `hashCode()` ও `equals()` ব্যবহার হয়

#### ✅ ফলাফল:

* ভুল ভার্সন: `null`

* override ভার্সন: `"Software Engineer"`

* * *

✨ সারাংশ টেবিল:
---------------

| Expression            | ভুল ভার্সন রেজাল্ট | ঠিক ভার্সন রেজাল্ট  | কারণ                                         |
| --------------------- | ------------------ | ------------------- | -------------------------------------------- |
| `e1 == e2`            | false              | false               | আলাদা object                                 |
| `e1.equals(e2)`       | false              | true                | override না করলে reference check হয়          |
| `map.containsKey(e2)` | false              | true                | `hashCode()` ও `equals()` match করতে হয়      |
| `map.get(e2)`         | null               | "Software Engineer" | সঠিকভাবে খুঁজে পায় না যদি override না করা হয় |

* * *

চাইলে এই behavior গুলো নিয়ে একটি GUI বা CLI-based tool তৈরি করা যেতে পারে যেখানে লাইভভাবে এসব experiment করা যাবে।
