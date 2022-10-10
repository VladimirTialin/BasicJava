package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Laptop {
    private String model;
    private String CPU;
    private int RAM;
    private int disk;
    private String GPU;
    private double screen;
    private String OS;
    private String color;
    private int price;

    public String getModel() {
        return model;
    }

    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getDisk() {
        return disk;
    }

    public String getGPU() {
        return GPU;
    }

    public double getScreen() {
        return screen;
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return color;
    }

    public int getPrice() {
        return price;
    }

    /**
     * Параметры поиска
     *
     * @param model  - производитель
     * @param CPU    - тип процессора
     * @param RAM    - объем оперативной памяти
     * @param disk   - размер жесткого диска
     * @param screen - диагональ экрана
     * @param OS     - операционная система*
     * @param color  - цвет ноубука
     * @param price  - цена
     */
    public Laptop(String model, String CPU,
                  int RAM, int disk, String GPU,
                  double screen, String OS, String color, int price) {
        this.model = model;
        this.CPU = CPU;
        this.RAM = RAM;
        this.disk = disk;
        this.GPU = GPU;
        this.screen = screen;
        this.OS = OS;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return  model + ", " +
                CPU + ", " +
                RAM +", "+
                disk +", "+
                GPU +", "+
                screen +", "+
                OS +", "+
                color +", "+
                price;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}

