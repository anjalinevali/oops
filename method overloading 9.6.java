// Parent Class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child Class 1
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

// Child Class 2
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

// Main Class
public class TestAnimal {
    public static void main(String[] args) {

        // Parent reference, Child objects (Polymorphism)
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.makeSound();  // Dog's method called
        a2.makeSound();  // Cat's method called
    }
}


