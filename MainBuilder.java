package com.Robert;

public class Main {

    public static void main(String[] args) {
        GardenBuilder fancy = new FancyGarden();
        Director director = new Director(fancy);

        director.constructGarden();

        Garden garden = director.getGarden();
        System.out.println("Builder constructed: " + garden);
    }

    interface GardenPlan {

        public void setFence (String fence);
        public void setSwing (String swing);
        public void setFlowers (String flowers);
    }

    interface GardenBuilder {

        public void buildFence();
        public void buildSwing();
        public void buildFlowers();

        public Garden getGarden();

    }

    static class Garden implements GardenPlan {

        private String fence;
        private String swing;
        private String flowers;

        public void setFence(String fence) {
            this.fence = fence;
        }

        public void setSwing(String swing) {
            this.swing = swing;
        }

        public void setFlowers(String flowers) {
            this.flowers = flowers;
        }
    }

    static class FancyGarden implements GardenBuilder {

        private Garden garden;

        public FancyGarden() {
            this.garden = new Garden();
        }

        public void buildFence() {
            garden.setFence("green");
        }

        public void buildSwing() {
            garden.setSwing("high");
        }

        public void buildFlowers() {
            garden.setFlowers("gerbera");
        }

        public Garden getGarden() {
            return this.garden;
        }
    }

    static class MiddleSizeGarden implements GardenBuilder {

        private Garden garden;

        public MiddleSizeGarden() {
            this.garden = new Garden();
        }

        public void buildFence() {
            garden.setFence("brown");
        }

        public void buildSwing() {
            garden.setSwing("middle");
        }

        public void buildFlowers() {
            garden.setFlowers("roses");
        }

        public Garden getGarden() {
            return this.garden;
        }
    }

    static class Director {

        private GardenBuilder gardenBuilder;

        public Director(GardenBuilder gardenBuilder) {
            this.gardenBuilder = gardenBuilder;
        }

        public Garden getGarden() {
            return this.gardenBuilder.getGarden();
        }

        public void constructGarden() {

            this.gardenBuilder.buildFence();
            this.gardenBuilder.buildSwing();
            this.gardenBuilder.buildFlowers();
        }
    }
}


