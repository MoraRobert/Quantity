package com.Robert;
import java.util.ArrayList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        List<Visitable> visitableElements = new ArrayList<Visitable>();
        visitableElements.add(new Book("k755",4,800.0));
        visitableElements.add(new Fruit(10,55.0));
        visitableElements.add(new Vegetable(5,3.5));
        BillingVisitor billingVisitor = new BillingVisitor();
        for(Visitable visitableElement : visitableElements){
            visitableElement.accept(billingVisitor);
        }
        OfferVisitor offerVisitor = new OfferVisitor();
        for(Visitable visitableElement : visitableElements){
            visitableElement.accept(offerVisitor);
        }
        System.out.println("Total bill " + billingVisitor.totalPrice);
        System.out.println("Offer  " + offerVisitor.offer);
    }

    interface Visitor {
        void visit(Book book);
        void visit(Vegetable vegetable);
        void visit(Fruit fruit);
    }

    interface Visitable{
        public void accept(Visitor visitor);
    }

    static class OfferVisitor implements Visitor{
        StringBuilder offer = new StringBuilder();

        @Override
        public void visit(Book book) {
            offer.append("Book " +  book.isbn +  " discount 10 %" + " \n");
        }

        @Override
        public void visit(Vegetable vegetable) {
            offer.append("Vegetable  No discount \n");
        }

        @Override
        public void visit(Fruit fruit) {
            offer.append("Fruits  No discount \n");
        }

    }

    static class BillingVisitor implements Visitor{
        double totalPrice = 0.0;

        @Override
        public void visit(Book book) {
            totalPrice += (book.quantity * book.price);
        }

        @Override
        public void visit(Vegetable vegetable) {
            totalPrice += (vegetable.weight * vegetable.price);
        }

        @Override
        public void visit(Fruit fruit) {
            totalPrice += (fruit.quantity * fruit.price);
        }

    }

    static class Book implements Visitable{
        private String isbn;
        private double quantity;
        private double price;

        public Book(String isbn, double quantity, double price) {
            this.isbn = isbn;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class Fruit implements Visitable{
        private double quantity;
        private double price;

        public Fruit(double quantity, double price) {
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    static class Vegetable implements Visitable{
        private double weight;
        private double price;

        public Vegetable(double weight, double price) {
            this.weight = weight;
            this.price = price;
        }


        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
}