import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() {
        return "High-Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private T mealType;
    
    public Meal(T mealType) {
        this.mealType = mealType;
    }
    
    public T getMealType() {
        return mealType;
    }
    
    @Override
    public String toString() {
        return mealType.getMealType();
    }
}

class MealPlanner {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        return new Meal<>(mealType);
    }
    
    public static void displayMeals(List<? extends MealPlan> meals) {
        for (MealPlan meal : meals) {
            System.out.println(meal.getMealType());
        }
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        List<MealPlan> mealPlans = new ArrayList<>();
        
        mealPlans.add(new VegetarianMeal());
        mealPlans.add(new VeganMeal());
        mealPlans.add(new KetoMeal());
        mealPlans.add(new HighProteinMeal());
        
        System.out.println("Available Meal Plans:");
        MealPlanner.displayMeals(mealPlans);
        
        Meal<VegetarianMeal> vegetarianMeal = MealPlanner.generateMealPlan(new VegetarianMeal());
        System.out.println("\nGenerated Meal Plan: " + vegetarianMeal);
    }
}