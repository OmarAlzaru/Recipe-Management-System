package com.example.recipemanagmentsystem;

public class recipeDatabase {
    private String title;
    private String ingredients;
    private String instructions;
    private int cooking_time;

    public recipeDatabase(String title, String ingredients, String instructions, int cooking_time, String serving_size, String notes) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cooking_time = cooking_time;
        this.serving_size = serving_size;
        this.notes = notes;
    }

    private String serving_size;
    private String notes;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public recipeDatabase(String title, String ingredients, String instructions, int cooking_time, String serving_size, String notes, String category) {
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.cooking_time = cooking_time;
        this.serving_size = serving_size;
        this.notes = notes;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getCooking_time() {
        return cooking_time;
    }

    public void setCooking_time(int cooking_time) {
        this.cooking_time = cooking_time;
    }

    public String getServing_size() {
        return serving_size;
    }

    public void setServing_size(String serving_size) {
        this.serving_size = serving_size;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}
