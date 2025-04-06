import java.util.Objects;

public class ProductClass {
    private String name;
    private double price;
    private String category;

    public ProductClass(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        /*
🔍 এই লাইনটি কী করে: `getClass() != otherObject.getClass()`

এই চেকটি করে যে বর্তমান অবজেক্ট (`this`) এবং যেটার সাথে তুলনা করা হচ্ছে (`otherObject`)
তারা কি একেবারে একই ক্লাসের কিনা। যদি না হয়, তাহলে `false` রিটার্ন করে — অর্থাৎ সমান নয়।

📌 `getClass()` কী?
এটি `Object` ক্লাসের একটি মেথড, যা কোন অবজেক্টটি কোন ক্লাস থেকে এসেছে, সেটি বলে দেয়।
যেমন:
    Student s = new Student(...);
    s.getClass() দিলে আউটপুট হবে: class Student

🧠 কেন এটা দরকার?
এই চেক ছাড়া যদি শুধু ফিল্ডগুলোর তুলনা করা হয়, তাহলে ভুলভাবে দুটি আলাদা ক্লাসের অবজেক্টকেও
সমান ধরে নেওয়া হতে পারে। এটি প্রতিরোধ করতেই এই চেক ব্যবহার করা হয়।

উদাহরণ:
    class Student { ... }
    class Teacher extends Student { ... }

এখন যদি `Teacher` অবজেক্টকে `Student` অবজেক্টের সাথে তুলনা করা হয়, সেটা লজিক্যালি ভুল।
তাই এই চেক নিশ্চিত করে যে দুইটা অবজেক্ট একি ক্লাসের কিনা।

✅ এই লাইনটি:
    if (getClass() != otherObject.getClass()) return false;

এই শর্ত নিশ্চিত করে যে তুলনা শুধুমাত্র তখনই হবে, যখন দুইটা অবজেক্ট একদম একই ক্লাসের হবে।

⚠️ অতিরিক্ত টিপ:
`instanceof` চেক করলে সাবক্লাসকেও গ্রহণ করে, কিন্তু `getClass()` ব্যবহার করলে
শুধু সম্পূর্ণ মিল থাকা ক্লাসকেই গ্রহণ করে — অর্থাৎ এটি বেশি সুনির্দিষ্ট (strict)।
*/

       ProductClass other = (ProductClass) otherObject;
       return  name.equals(other.name) && price == other.price && category.equals(category);
    }

    @Override
    public String toString() {
        return "ProductClass{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }


    public static void main(String[] args) {
        ProductClass p1 = new ProductClass("Soap", 55 , "Food");

        System.out.println(p1);
    }
}
